package com.bytedance.crash.tracker;

import android.text.TextUtils;
import com.bytedance.crash.Global;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.DateUtils;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.obric.cae.userAware.WifiScanStateMachine;
import java.io.File;
import java.util.Arrays;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessTracker {
    private static final String DIR = "processTrack";
    private static final int MAX_DAY = 5;
    private static File currentDayDir = null;
    private static File currentFile = null;
    private static File currentProcessDir = null;
    private static ProcessTracker instance = null;
    private static volatile boolean isInited = false;
    private static File rootDir;
    private boolean isEnable;

    static {
        instance = new ProcessTracker();
    }

    private ProcessTracker() {
    }

    static /* synthetic */ void access$000(ProcessTracker r0) {
        r0.clear();
    }

    private void clear() {
        if (App.isMainProcess() == true) goto L5;
        return;
    L5:
        init();
        File r0 = rootDir;
        if (r0 != null) goto L8;
        return;
    L8:
        File[] r1 = r0.listFiles();
        if (r1 != null) goto L23;
        return;
    L23:
        Arrays.sort(r1, new AnonymousClass2(this));     // Catch: Exception -> L21
    L12:
        int r2 = (int) (Global.getAppStartTime() / WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS);
        int r3 = r1.length;
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L19;
        File r5 = r1[r4];
        if (Math.abs(r2 - Integer.valueOf(r5.getName()).intValue()) < 5) goto L18;
        FileUtils.deleteFile(r5);     // Catch: Exception -> L22
    L18:
        r4 = r4 + 1;
        goto L13
    L19:
        DefaultWorkThread.postDelayed(new AnonymousClass3(this), 120000);
    }

    public static ProcessTracker getInstance() {
        return instance;
    }

    private void init() {
        if (isInited == false) goto L5;
        return;
    L5:
        File r5 = new File(Global.getRootDirectory(), DIR);
        rootDir = r5;
        FileSystemUtils.createDirectory(r5);
        File r6 = new File(rootDir, String.valueOf(Global.getAppStartTime() / WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS));
        currentDayDir = r6;
        FileSystemUtils.createDirectory(r6);
        File r7 = new File(currentDayDir, App.getProcessName());
        currentProcessDir = r7;
        FileSystemUtils.createDirectory(r7);
        isInited = true;
    }

    public void addEvent(String r2, String r3, long r4) {
        File r1 = getCurrentFile();     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        FileUtils.writeFile(r1, r2 + ' ' + r3 + ' ' + DateUtils.getFileDateInstance().format(new Date(r4)) + '\n', true);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public File getCurrentFile() {
        File r0 = currentFile;
        if (r0 == null) goto L5;
        return r0;
    L5:
        init();
        if (currentProcessDir == null) goto L10;
        File r3 = new File(currentProcessDir, String.valueOf(Global.getAppStartTime()));
        currentFile = r3;
        return r3;
    L10:
        return currentFile;
    }

    public File getProcessTrackFile(String r4, long r5) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return null;
    L7:
        return new File(Global.getRootDirectory(), DIR + File.separator + String.valueOf(r5 / WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) + File.separator + r4 + File.separator + String.valueOf(r5));
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public void setEnable(boolean r1) {
        if (r1 == true) goto L4;
        return;
    L4:
        this.isEnable = true;
    }

    public void start() {
        if (App.isMainProcess() == true) goto L5;
        return;
    L5:
        DefaultWorkThread.postDelayed(new AnonymousClass1(this), 10000);
    }
}
