package com.bytedance.crash.protector;

import com.bytedance.crash.Global;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CrashProtector {
    private static final String CONFIG_FILE = "crash_protector.config";
    private static final String LOG_TAG = "NPTH_PROT";

    public CrashProtector() {
    }

    public static synchronized boolean addConfig(JSONObject r4) {
        monitor-enter(CrashProtector.class);
        CrashProtectorConfig r1 = new CrashProtectorConfig();     // Catch: Throwable -> L16
        if (CrashProtectorConfig.addConfig(r4) == true) goto L9;
        monitor-exit(CrashProtector.class);
        return false;
    L9:
        r1.parse();     // Catch: Throwable -> L16
        if (r1.isConfigEnabled(r4) == true) goto L13;
        monitor-exit(CrashProtector.class);
        return false;
    L13:
        boolean r5 = updateConfigFile(r1.getConfigData(), r1.getConfigSize());     // Catch: Throwable -> L16
        monitor-exit(CrashProtector.class);
        return r5;
    L16:
        th = move-exception;
        throw th;
    }

    public static void addDefaultConfig() {
        JSONObject r1 = new ProtectorConfigBuilder("com.bytedance.inner_fix.npth_profiler").addSignal("SIGSEGV").setMinApiLevel(35).setAbiType(ProtectorConfigBuilder.AbiType.ARM64_V8A).addFrame("libnpth.so").addFrame("libnpth.so", null, true).addFrame("libnpth.so").addFrame("libc.so", "_ZL15__pthread_startPv").addRegister("w0", -1).build();     // Catch: Exception -> L5
        NpthLog.i(LOG_TAG, "addConfig: " + addConfig(r1) + ", config: " + r1.toString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        NpthLog.w(LOG_TAG, e.getMessage());
    }

    private static boolean compareFileContent(File r8, byte[] r9, int r10) {
        if (r9 == null) goto L47;
        if (r10 > 0) goto L6;
        return false;
    L6:
        if (r8.exists() == true) goto L8;
        return false;
    L8:
        if (r8.length() != r10) goto L51;
        FileInputStream r1 = null;
        FileInputStream r2 = new FileInputStream(r8);     // Catch: Exception -> L31
        byte[] r11 = new byte[4096];     // Catch: Exception -> L29
        int r3 = 0;
    L37:
        int r4 = r2.read(r11);     // Catch: Exception -> L28
        if (r4 <= 0) goto L33;
        int r5 = r3 + r4;     // Catch: Exception -> L28
        if (r5 > r10) goto L33;
        int r6 = 0;
    L21:
        if (r6 >= r4) goto L27;
        if (r11[r6] != r9[r3 + r6]) goto L24;
        r6 = r6 + 1;
        goto L21
    L24:
        r2.close();     // Catch: Exception -> L28
        return false;
    L27:
        r3 = r5;
    L33:
        FileSystemUtils.close(r2);
        if (r3 != r10) goto L50;
        return true;
    L50:
        return false;
    L28:
        int r12 = r3;
    L30:
        r1 = r2;
    L32:
        r2 = r1;
        r3 = r12;
    L29:
        r12 = 0;
    L31:
        r12 = 0;
        goto L32
    L51:
        return false;
    L47:
        return false;
    }

    private static String readAllFromFile(File r5) {
        if (r5 != null) goto L12;
        return null;
    L12:
        FileInputStream r1 = new FileInputStream(r5);     // Catch: IOException -> L11
        ByteArrayOutputStream r6 = new ByteArrayOutputStream();     // Catch: IOException -> L11
        byte[] r2 = new byte[4096];     // Catch: IOException -> L11
    L6:
        int r3 = r1.read(r2);     // Catch: IOException -> L11
        if (r3 <= 0) goto L9;
        r6.write(r2, 0, r3);     // Catch: IOException -> L11
        goto L6
    L9:
        r1.close();     // Catch: IOException -> L11
        return r6.toString();
    L11:
        return null;
    }

    public static synchronized void updateConfig(JSONObject r2) {
        monitor-enter(CrashProtector.class);
        CrashProtectorConfig r1 = new CrashProtectorConfig();     // Catch: Throwable -> L7
        CrashProtectorConfig.updateConfig(r2);     // Catch: Throwable -> L7
        r1.parse();     // Catch: Throwable -> L7
        updateConfigFile(r1.getConfigData(), r1.getConfigSize());     // Catch: Throwable -> L7
        monitor-exit(CrashProtector.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static boolean updateConfigFile(byte[] r7, int r8) {
        File r2 = new File(Global.getConfigDir(), CONFIG_FILE);     // Catch: Throwable -> L33
        if (compareFileContent(r2, r7, r8) == false) goto L8;
        NpthLog.i(LOG_TAG, "config not changed");     // Catch: Throwable -> L33
        return true;
    L8:
        if (r2.exists() == false) goto L10;
        r2.delete();     // Catch: Throwable -> L33
    L10:
        if (r7 == null) goto L30;
        if (r8 <= 0) goto L30;
        File r3 = new File(Global.getConfigDir(), "crash_protector.config.tmp");     // Catch: Throwable -> L33
        if (r3.exists() == false) goto L16;
    L18:
        FileOutputStream r5 = null;
        FileOutputStream r6 = new FileOutputStream(r3, false);     // Catch: Throwable -> L27
        r6.write(r7, 0, r8);     // Catch: Throwable -> L25
        r6.flush();     // Catch: Throwable -> L25
        FileSystemUtils.close(r6);     // Catch: Throwable -> L33
        if (r3.renameTo(r2) == false) goto L31;
        NpthLog.i(LOG_TAG, "update config file done");     // Catch: Throwable -> L33
        return true;
    L25:
        th = th;
        r5 = r6;
    L28:
        FileSystemUtils.close(r5);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L27:
        th = th;
        goto L28
    L16:
        if (r3.createNewFile() == true) goto L18;
        return false;
    L30:
        return false;
    L31:
        NpthLog.e(LOG_TAG, "failed to update config file");
        return false;
    }

    public static synchronized void updateConfigFromLocalFile(String r3) {
        monitor-enter(CrashProtector.class);
        if (r3 != null) goto L29;
    L21:
        monitor-exit(CrashProtector.class);
        return;
    L29:
        if (r3.isEmpty() == true) goto L21;
        String r1 = null;
        r1 = readAllFromFile(new File(r3));     // Catch: Throwable -> L23
    L10:
        if (r1 != null) goto L27;
        monitor-exit(CrashProtector.class);
        return;
    L27:
        JSONObject r4 = new JSONObject(r1).optJSONObject("protector");     // Catch: Throwable -> L24
        if (r4 == null) goto L16;
        CrashProtectorConfig r2 = new CrashProtectorConfig();     // Catch: Throwable -> L24
        CrashProtectorConfig.updateConfig(r4);     // Catch: Throwable -> L24
        r2.parse();     // Catch: Throwable -> L24
        updateConfigFile(r2.getConfigData(), r2.getConfigSize());     // Catch: Throwable -> L24
    L16:
        monitor-exit(CrashProtector.class);
        return;
    L18:
        th = move-exception;
        throw th;
    }
}
