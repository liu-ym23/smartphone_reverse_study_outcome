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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class NpthSoData {
    private static boolean sShouldCheckSo;
    private static HashMap<String, String> sSoVersions;

    public NpthSoData() {
    }

    static /* synthetic */ void access$000() {
        checkSoList();
    }

    static /* synthetic */ boolean access$100(String r0, String r1) {
        return checkSoAvailable(r0, r1);
    }

    static /* synthetic */ String access$200(String r0) {
        return getSoPath(r0);
    }

    static /* synthetic */ HashMap access$300() {
        return sSoVersions;
    }

    static /* synthetic */ String access$400(String r0) {
        return getSoVersionPath(r0);
    }

    private static void checkAndUpdateSo(final String r1, final String r2) {
        DefaultWorkThread.post(new AnonymousClass1(r1, r2));
    }

    public static boolean checkDumperFile() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return false;
    L6:
        if (new File(r0.getApplicationInfo().nativeLibraryDir, SoName.NPTH_DUMPER_FILE_NAME).exists() == false) goto L8;
        return true;
    L8:
        String r2 = String.valueOf(4020254);
        File r5 = new File(LogPathConfig.getNpthLibDir(), r2);
        if (r5.exists() == true) goto L12;
        r5.mkdirs();
    L12:
        if (new File(r5, SoName.NPTH_DUMPER_FILE_NAME).exists() == false) goto L15;
        return true;
    L15:
        if (updateSo("c++_shared", r5, r0) == true) goto L17;
        return false;
    L17:
        if (updateSo("npth_unwind", r5, r0) == true) goto L19;
        return false;
    L19:
        if (updateSo(SoName.NPTH_DUMPER_NAME, r5, r0) == true) goto L21;
        return false;
    L21:
        return true;
    }

    private static boolean checkSoAvailable(String r3, String r4) {
        if (r4.equals((String) ZeusTransformUtils.preCheckCast(sSoVersions.get(r3), String.class, "com.obric.memorydata.plugin")) == true) goto L7;
        return false;
    L7:
        return new File(getSoPath(r3)).exists();
    }

    public static void checkSoFile(String r3, String r4) {
        AppMonitor r0 = MonitorManager.getAppMonitor();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.getUserDataCenter().registerInnerSdkInfo(r3 + ".so", r4);
        if (sShouldCheckSo == false) goto L9;
        checkAndUpdateSo(r3, r4);
        return;
    }

    private static void checkSoList() {
        if (sSoVersions == null) goto L5;
        return;
    L5:
        sSoVersions = new HashMap();
        File r0 = LogPathConfig.getNpthLibDir();
        String[] r1 = r0.list();
        if (r1 != null) goto L8;
        return;
    L8:
        int r2 = r1.length;
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L21;
        String r5 = r1[r4];
        if (r5.endsWith(".ver") == false) goto L18;
        sSoVersions.put(r5.substring(0, r5.length() - 4), FileUtils.readFile(r0.getAbsolutePath() + "/" + r5));     // Catch: Throwable -> L15
    L20:
        r4 = r4 + 1;
    L15:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        goto L20
    L18:
        if (r5.endsWith(".so") == true) goto L20;
        FileUtils.deleteFile(new File(r0, r5));
        goto L20
    }

    private static String getSoDir() {
        return LogPathConfig.getNpthLibDir().getAbsolutePath();
    }

    private static String getSoPath(String r2) {
        return LogPathConfig.getNpthLibDir().getAbsolutePath() + "/lib" + r2 + ".so";
    }

    private static String getSoVersionPath(String r2) {
        return LogPathConfig.getNpthLibDir().getAbsolutePath() + "/" + r2 + ".ver";
    }

    private static boolean updateSo(String r4, File r5, Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        File r0 = new File(r5, "lib" + r4 + ".so.tmp");
        String r8 = SafelyLibraryLoader.unpackLibrary(r7, r4, r0);
        if (r8 == null) goto L7;
        NpthLog.w(r4 + " unpack error: " + r8);
        return false;
    L7:
        return r0.renameTo(new File(r5, "lib" + r4 + ".so"));
    }
}
