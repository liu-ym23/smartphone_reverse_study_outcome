package com.bytedance.crash.soloader;

import android.content.Context;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.LogPathConfig;
import com.bytedance.crash.constants.SoName;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class NpthSoData {
    private static boolean sShouldCheckSo;
    private static HashMap<String, String> sSoVersions;

    public NpthSoData() {
    }

    static /* synthetic */ void access$000() {
        checkSoList();
    }

    static /* synthetic */ boolean access$100(String r10, String r11) {
        return checkSoAvailable(r10, r11);
    }

    static /* synthetic */ String access$200(String r10) {
        return getSoPath(r10);
    }

    static /* synthetic */ HashMap access$300() {
        return sSoVersions;
    }

    static /* synthetic */ String access$400(String r10) {
        return getSoVersionPath(r10);
    }

    private static void checkAndUpdateSo(final String r10, final String r11) {
        DefaultWorkThread.post(new AnonymousClass1(r10, r11));
    }

    public static boolean checkDumperFile() {
        Context r10 = Global.getContext();
        if (r10 != null) goto L6;
        return false;
    L6:
        if (new File(r10.getApplicationInfo().nativeLibraryDir, SoName.NPTH_DUMPER_FILE_NAME).exists() == false) goto L8;
        return true;
    L8:
        String r11 = String.valueOf(4020254);
        File r12 = new File(LogPathConfig.getNpthLibDir(), r11);
        if (r12.exists() == true) goto L12;
        r12.mkdirs();
    L12:
        if (new File(r12, SoName.NPTH_DUMPER_FILE_NAME).exists() == false) goto L15;
        return true;
    L15:
        if (updateSo("c++_shared", r12, r10) == true) goto L17;
        return false;
    L17:
        if (updateSo("npth_unwind", r12, r10) == true) goto L19;
        return false;
    L19:
        if (updateSo(SoName.NPTH_DUMPER_NAME, r12, r10) == true) goto L21;
        return false;
    L21:
        return true;
    }

    private static boolean checkSoAvailable(String r10, String r11) {
        if (r11.equals(sSoVersions.get(r10)) == true) goto L7;
        return false;
    L7:
        return new File(getSoPath(r10)).exists();
    }

    public static void checkSoFile(String r10, String r11) {
        AppMonitor r12 = MonitorManager.getAppMonitor();
        if (r12 != null) goto L5;
        return;
    L5:
        r12.getUserDataCenter().registerInnerSdkInfo(r10 + ".so", r11);
        if (sShouldCheckSo == false) goto L9;
        checkAndUpdateSo(r10, r11);
        return;
    }

    private static void checkSoList() {
        if (sSoVersions == null) goto L5;
        return;
    L5:
        sSoVersions = new HashMap();
        File r10 = LogPathConfig.getNpthLibDir();
        String[] r11 = r10.list();
        if (r11 != null) goto L8;
        return;
    L8:
        int r12 = r11.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L21;
        String r14 = r11[r13];
        if (r14.endsWith(".ver") == false) goto L18;
        String r15 = r14.substring(0, r14.length() - 4);
        sSoVersions.put(r15, FileUtils.readFile(r10.getAbsolutePath() + "/" + r14));     // Catch: Throwable -> L15
    L20:
        r13 = r13 + 1;
    L15:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        goto L20
    L18:
        if (r14.endsWith(".so") == true) goto L20;
        FileUtils.deleteFile(new File(r10, r14));
        goto L20
    }

    private static String getSoDir() {
        return LogPathConfig.getNpthLibDir().getAbsolutePath();
    }

    private static String getSoPath(String r10) {
        return LogPathConfig.getNpthLibDir().getAbsolutePath() + "/lib" + r10 + ".so";
    }

    private static String getSoVersionPath(String r10) {
        return LogPathConfig.getNpthLibDir().getAbsolutePath() + "/" + r10 + ".ver";
    }

    private static boolean updateSo(String r10, File r11, Context r12) {
        File r13 = new File(r11, "lib" + r10 + ".so.tmp");
        String r14 = SafelyLibraryLoader.unpackLibrary(r12, r10, r13);
        if (r14 == null) goto L7;
        NpthLog.w(r10 + " unpack error: " + r14);
        return false;
    L7:
        return r13.renameTo(new File(r11, "lib" + r10 + ".so"));
    }
}
