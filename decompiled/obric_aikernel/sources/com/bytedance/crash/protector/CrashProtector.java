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

/* JADX INFO: loaded from: classes.dex */
public class CrashProtector {
    private static final String CONFIG_FILE = "crash_protector.config";
    private static final String LOG_TAG = "NPTH_PROT";

    public CrashProtector() {
    }

    public static synchronized boolean addConfig(JSONObject r10) {
        monitor-enter(CrashProtector.class);
        CrashProtectorConfig r11 = new CrashProtectorConfig();     // Catch: Throwable -> L16
        if (CrashProtectorConfig.addConfig(r10) == true) goto L9;
        monitor-exit(CrashProtector.class);
        return false;
    L9:
        r11.parse();     // Catch: Throwable -> L16
        if (r11.isConfigEnabled(r10) == true) goto L13;
        monitor-exit(CrashProtector.class);
        return false;
    L13:
        boolean r12 = updateConfigFile(r11.getConfigData(), r11.getConfigSize());     // Catch: Throwable -> L16
        monitor-exit(CrashProtector.class);
        return r12;
    L16:
        th = move-exception;
        throw th;
    }

    public static void addDefaultConfig() {
        JSONObject r10 = new ProtectorConfigBuilder("com.bytedance.inner_fix.npth_profiler").addSignal("SIGSEGV").setMinApiLevel(35).setAbiType(ProtectorConfigBuilder.AbiType.ARM64_V8A).addFrame("libnpth.so").addFrame("libnpth.so", null, true).addFrame("libnpth.so").addFrame("libc.so", "_ZL15__pthread_startPv").addRegister("w0", -1).build();     // Catch: Exception -> L5
        NpthLog.i(LOG_TAG, "addConfig: " + addConfig(r10) + ", config: " + r10.toString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        NpthLog.w(LOG_TAG, e.getMessage());
    }

    private static boolean compareFileContent(File r10, byte[] r11, int r12) {
        if (r11 == null) goto L47;
        if (r12 > 0) goto L6;
        return false;
    L6:
        if (r10.exists() == true) goto L8;
        return false;
    L8:
        if (r10.length() != r12) goto L51;
        FileInputStream r13 = null;
        FileInputStream r14 = new FileInputStream(r10);     // Catch: Exception -> L31
        byte[] r15 = new byte[4096];     // Catch: Exception -> L29
        int r16 = 0;
    L37:
        int r17 = r14.read(r15);     // Catch: Exception -> L28
        if (r17 <= 0) goto L33;
        int r18 = r16 + r17;     // Catch: Exception -> L28
        if (r18 > r12) goto L33;
        int r19 = 0;
    L21:
        if (r19 >= r17) goto L27;
        if (r15[r19] != r11[r16 + r19]) goto L24;
        r19 = r19 + 1;
        goto L21
    L24:
        r14.close();     // Catch: Exception -> L28
        return false;
    L27:
        r16 = r18;
    L33:
        FileSystemUtils.close(r14);
        if (r16 != r12) goto L50;
        return true;
    L50:
        return false;
    L28:
        int r20 = r16;
    L30:
        r13 = r14;
    L32:
        r14 = r13;
        r16 = r20;
    L29:
        r20 = 0;
    L31:
        r20 = 0;
        goto L32
    L51:
        return false;
    L47:
        return false;
    }

    private static String readAllFromFile(File r10) {
        if (r10 != null) goto L12;
        return null;
    L12:
        FileInputStream r11 = new FileInputStream(r10);     // Catch: IOException -> L11
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();     // Catch: IOException -> L11
        byte[] r13 = new byte[4096];     // Catch: IOException -> L11
    L6:
        int r14 = r11.read(r13);     // Catch: IOException -> L11
        if (r14 <= 0) goto L9;
        r12.write(r13, 0, r14);     // Catch: IOException -> L11
        goto L6
    L9:
        r11.close();     // Catch: IOException -> L11
        return r12.toString();
    L11:
        return null;
    }

    public static synchronized void updateConfig(JSONObject r10) {
        monitor-enter(CrashProtector.class);
        CrashProtectorConfig r11 = new CrashProtectorConfig();     // Catch: Throwable -> L7
        CrashProtectorConfig.updateConfig(r10);     // Catch: Throwable -> L7
        r11.parse();     // Catch: Throwable -> L7
        updateConfigFile(r11.getConfigData(), r11.getConfigSize());     // Catch: Throwable -> L7
        monitor-exit(CrashProtector.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static boolean updateConfigFile(byte[] r10, int r11) {
        File r12 = new File(Global.getConfigDir(), CONFIG_FILE);     // Catch: Throwable -> L33
        if (compareFileContent(r12, r10, r11) == false) goto L8;
        NpthLog.i(LOG_TAG, "config not changed");     // Catch: Throwable -> L33
        return true;
    L8:
        if (r12.exists() == false) goto L10;
        r12.delete();     // Catch: Throwable -> L33
    L10:
        if (r10 == null) goto L30;
        if (r11 <= 0) goto L30;
        File r13 = new File(Global.getConfigDir(), "crash_protector.config.tmp");     // Catch: Throwable -> L33
        if (r13.exists() == false) goto L16;
    L18:
        FileOutputStream r14 = null;
        FileOutputStream r15 = new FileOutputStream(r13, false);     // Catch: Throwable -> L27
        r15.write(r10, 0, r11);     // Catch: Throwable -> L25
        r15.flush();     // Catch: Throwable -> L25
        FileSystemUtils.close(r15);     // Catch: Throwable -> L33
        if (r13.renameTo(r12) == false) goto L31;
        NpthLog.i(LOG_TAG, "update config file done");     // Catch: Throwable -> L33
        return true;
    L25:
        th = th;
        r14 = r15;
    L28:
        FileSystemUtils.close(r14);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L27:
        th = th;
        goto L28
    L16:
        if (r13.createNewFile() == true) goto L18;
        return false;
    L30:
        return false;
    L31:
        NpthLog.e(LOG_TAG, "failed to update config file");
        return false;
    }

    public static synchronized void updateConfigFromLocalFile(String r10) {
        monitor-enter(CrashProtector.class);
        if (r10 != null) goto L29;
    L21:
        monitor-exit(CrashProtector.class);
        return;
    L29:
        if (r10.isEmpty() == true) goto L21;
        String r11 = null;
        r11 = readAllFromFile(new File(r10));     // Catch: Throwable -> L23
    L10:
        if (r11 != null) goto L27;
        monitor-exit(CrashProtector.class);
        return;
    L27:
        JSONObject r12 = new JSONObject(r11).optJSONObject("protector");     // Catch: Throwable -> L24
        if (r12 == null) goto L16;
        CrashProtectorConfig r13 = new CrashProtectorConfig();     // Catch: Throwable -> L24
        CrashProtectorConfig.updateConfig(r12);     // Catch: Throwable -> L24
        r13.parse();     // Catch: Throwable -> L24
        updateConfigFile(r13.getConfigData(), r13.getConfigSize());     // Catch: Throwable -> L24
    L16:
        monitor-exit(CrashProtector.class);
        return;
    L18:
        th = move-exception;
        throw th;
    }
}
