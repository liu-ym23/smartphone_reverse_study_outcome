package com.bytedance.crash.tracker;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.crash.Global;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.DateUtils;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
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

    static /* synthetic */ void access$000(ProcessTracker r10) {
        r10.clear();
    }

    private void clear() {
        if (App.isMainProcess() == true) goto L5;
        return;
    L5:
        init();
        File r10 = rootDir;
        if (r10 != null) goto L8;
        return;
    L8:
        File[] r11 = r10.listFiles();
        if (r11 != null) goto L23;
        return;
    L23:
        Arrays.sort(r11, new AnonymousClass2(this));     // Catch: Exception -> L21
    L12:
        int r12 = (int) (Global.getAppStartTime() / 86400000);
        int r13 = r11.length;
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L19;
        File r15 = r11[r14];
        if (Math.abs(r12 - Integer.valueOf(r15.getName()).intValue()) < 5) goto L18;
        FileUtils.deleteFile(r15);     // Catch: Exception -> L22
    L18:
        r14 = r14 + 1;
        goto L13
    L19:
        DefaultWorkThread.postDelayed(new AnonymousClass3(this), AnrManager.ANR_MIN_INTERVAL);
    }

    public static ProcessTracker getInstance() {
        return instance;
    }

    private void init() {
        if (isInited == false) goto L5;
        return;
    L5:
        File r10 = new File(Global.getRootDirectory(), DIR);
        rootDir = r10;
        FileSystemUtils.createDirectory(r10);
        File r11 = new File(rootDir, String.valueOf(Global.getAppStartTime() / 86400000));
        currentDayDir = r11;
        FileSystemUtils.createDirectory(r11);
        File r12 = new File(currentDayDir, App.getProcessName());
        currentProcessDir = r12;
        FileSystemUtils.createDirectory(r12);
        isInited = true;
    }

    public void addEvent(String r10, String r11, long r12) {
        File r13 = getCurrentFile();     // Catch: Throwable -> L6
        if (r13 == null) goto L9;
        FileUtils.writeFile(r13, r10 + ' ' + r11 + ' ' + DateUtils.getFileDateInstance().format(new Date(r12)) + '\n', true);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public File getCurrentFile() {
        File r10 = currentFile;
        if (r10 == null) goto L5;
        return r10;
    L5:
        init();
        if (currentProcessDir == null) goto L10;
        File r11 = new File(currentProcessDir, String.valueOf(Global.getAppStartTime()));
        currentFile = r11;
        return r11;
    L10:
        return currentFile;
    }

    public File getProcessTrackFile(String r10, long r11) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        String r12 = String.valueOf(r11 / 86400000);
        String r13 = String.valueOf(r11);
        File r14 = Global.getRootDirectory();
        StringBuilder r15 = new StringBuilder();
        r15.append(DIR);
        String r16 = File.separator;
        r15.append(r16);
        r15.append(r12);
        r15.append(r16);
        r15.append(r10);
        r15.append(r16);
        r15.append(r13);
        return new File(r14, r15.toString());
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public void setEnable(boolean r10) {
        if (r10 == true) goto L4;
        return;
    L4:
        this.isEnable = true;
    }

    public void start() {
        if (App.isMainProcess() == true) goto L5;
        return;
    L5:
        DefaultWorkThread.postDelayed(new AnonymousClass1(this), WorkRequest.MIN_BACKOFF_MILLIS);
    }
}
