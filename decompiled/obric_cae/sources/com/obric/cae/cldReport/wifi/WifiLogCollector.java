package com.obric.cae.cldReport.wifi;

import android.content.Context;
import com.obric.cae.cldReport.AbstractLogCollector;
import com.obric.cae.cldReport.AbstractLogLevelConfig;
import com.obric.cae.cldReport.CldCommon;
import com.obric.cae.cldReport.CldUtil;
import com.obric.cae.cldReport.LogCollectAsyncTask;
import com.obric.cae.libs.cldReport.ICldReportCallback;
import com.obric.cae.log.CaeLog;
import defpackage.a;
import defpackage.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class WifiLogCollector extends AbstractLogCollector {
    private static final String CAE_ALOG_DIR = "/sdcard/Android/data/com.obric.cae/files/logs";
    private static final String CAE_ALOG_HOT_SUFFIX = ".alog.hot";
    private static final String CAE_ALOG_SUFFIX = ".alog";
    private static final long CAPTURE_FILE_MTIME_SLOP_MS = 5000;
    private static final String CAPTURE_LOG_DIR = "/data/capture";
    private static final String CNSS_FW_LOG_PREFIX = "cnss_fw_logs";
    private static final String HOST_DRIVER_LOG_PREFIX = "host_driver_logs";
    private static final int MAX_CAE_ALOG_FILES = 3;
    private static final int MAX_CNSS_FW_LOG_FILES = 2;
    private static final int MAX_FEEDBACK_CAE_ALOG_FILES = 6;
    private static final int MAX_HOST_DRIVER_LOG_FILES = 2;
    private static final String TAG = "WifiLogCollector";
    private static final String WIFI_KERNEL_LOGCAT_FILE = "kernel_logcat.txt";
    private static final String WIFI_WLAN_LOG_DIR = "/data/vendor/wifi/wlan_logs";
    private final CldCommon mCldCommon;
    private long mCollectStartTimeMs;
    private final Context mContext;

    public interface FileMatcher {
        boolean matches(File r8);
    }

    public static final class FileWithModifiedTime {
        final File file;
        final long modifiedTimeMs;

        public FileWithModifiedTime(File r8) {
            this.file = r8;
            this.modifiedTimeMs = r8.lastModified();
        }
    }

    public WifiLogCollector(Context r10, ICldReportCallback r11, boolean r12, boolean r13, CldCommon r14, CldCommon.CldSummary r15) {
        super(r10, r11, r12, r13, r15, WifiLogLevelConfig.getDuration(r15.getErrorCode()));
        this.mContext = r10;
        this.mCldCommon = r14;
    }

    private void copyCaptureLogsIfNeeded(File r10) {
        int r8 = this.mSummary.getErrorCode();
        if (WifiLogLevelConfig.hasWifiLogMask(r8, 4) == true) goto L6;
        a.i("skip capture logs for errorCode=", r8, TAG);
        return;
    L6:
        File r11 = new File(CAPTURE_LOG_DIR);
        long r12 = this.mCollectStartTimeMs;
        if (r12 > 0) goto L10;
        r12 = System.currentTimeMillis();
    L10:
        copyFilesModifiedInWindow(r11, r10, r12, 5000 + System.currentTimeMillis());
    }

    private int copyCommandOutput(File r8, String... r10) {
        Process r11 = null;
        Process r12 = new ProcessBuilder(r10).redirectErrorStream(true).start();     // Catch: Throwable -> L28 InterruptedException -> L30 IOException -> L34
        InputStream r13 = r12.getInputStream();     // Catch: Throwable -> L28 InterruptedException -> L30 IOException -> L34
        FileOutputStream r14 = new FileOutputStream(r8);     // Catch: Throwable -> L21
        byte[] r15 = new byte[4096];     // Catch: Throwable -> L15
    L7:
        int r16 = r13.read(r15);     // Catch: Throwable -> L15
        if (r16 == (-1)) goto L11;
        r14.write(r15, 0, r16);     // Catch: Throwable -> L15
    L11:
        r14.close();     // Catch: Throwable -> L21
        r13.close();     // Catch: Throwable -> L28 InterruptedException -> L30 IOException -> L34
        int r17 = r12.waitFor();     // Catch: Throwable -> L28 InterruptedException -> L30 IOException -> L34
        r12.destroy();
        return r17;
    L15:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L21
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        if (r13 != null) goto L45;
    L27:
        throw th;     // Catch: Throwable -> L28 InterruptedException -> L30 IOException -> L34
    L45:
        r13.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L28 InterruptedException -> L30 IOException -> L34
    L28:
        th = move-exception;
        if (0 == 0) goto L41;
        r11.destroy();
    L41:
        throw th;
    L34:
        e = move-exception;
        CaeLog.e(TAG, "copyCommandOutput: " + e.getMessage());     // Catch: Throwable -> L28
        if (0 == 0) goto L38;
    L37:
        r11.destroy();
    L38:
        return -1;
    L30:
        e = move-exception;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L28
        CaeLog.e(TAG, "copyCommandOutput interrupted: " + e.getMessage());     // Catch: Throwable -> L28
        if (0 == 0) goto L38;
        goto L38
    }

    private void copyFileToDest(File r8, File r10, String r11) {
        File r12 = r10.getParentFile();
        if (r12 == null) goto L11;
        if (r12.exists() == true) goto L11;
        if (r12.mkdirs() == true) goto L11;
        StringBuilder r13 = b.h("failed to create ", r11, " dest directory: ");
        r13.append(r12.getAbsolutePath());
        CaeLog.e(TAG, r13.toString());
        return;
    L11:
        if (CldUtil.copyFile(r8, r10) == false) goto L14;
        StringBuilder r14 = b.h("copy ", r11, ": ");
        r14.append(r8.getAbsolutePath());
        r14.append(" -> ");
        r14.append(r10.getAbsolutePath());
        CaeLog.i(TAG, r14.toString());
        return;
    }

    private void copyFilesModifiedInWindow(File r10, File r11, long r12, long r13) {
        if (isValidDirectory(r10) == true) goto L5;
        return;
    L5:
        copyFilesModifiedInWindow(r10, r10, r11, r12, r13);
    }

    private void copyHostDriverLogs(File r8) {
        copyLatestFiles(new File(WIFI_WLAN_LOG_DIR), r8, new AnonymousClass1(this), 2, "host driver log");
    }

    private void copyKernelLog(String r8) {
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "copyKernelLog: logPath is null");
        return;
    L6:
        int r10 = copyCommandOutput(new File(r8, WIFI_KERNEL_LOGCAT_FILE), new String[]{"logcat", "-b", "kernel", "-d"});
        if (r10 == 0) goto L10;
        CaeLog.w(TAG, "copyKernelLog: logcat kernel exited with code " + r10);
        return;
    }

    private void copyLatestCaeAlogs(File r8) {
        copyLatestFiles(new File(CAE_ALOG_DIR), r8, new AnonymousClass3(this), getMaxCaeAlogFiles(), "CAE alog");
    }

    private void copyLatestFiles(File r8, File r10, FileMatcher r11, int r12, String r13) {
        File[] r14 = listMatchedFiles(r8, r11);
        if (r14 != null) goto L5;
    L15:
        StringBuilder r15 = b.h("no ", r13, " files in ");
        r15.append(r8.getAbsolutePath());
        CaeLog.i(TAG, r15.toString());
        return;
    L5:
        if (r14.length == 0) goto L15;
        int r16 = r14.length;
        FileWithModifiedTime[] r17 = new FileWithModifiedTime[r16];
        int r18 = 0;
        int r19 = 0;
    L9:
        if (r19 >= r14.length) goto L11;
        r17[r19] = new FileWithModifiedTime(r14[r19]);
        r19 = r19 + 1;
        goto L9
    L11:
        Arrays.sort(r17, new AnonymousClass4(this));
        int r20 = Math.min(r12, r16);
    L12:
        if (r18 >= r20) goto L14;
        File r21 = r17[r18].file;
        copyFileToDest(r21, new File(r10, r21.getName()), r13);
        r18 = r18 + 1;
        goto L12
    }

    private void copyWifiFirmwareLogs(File r8) {
        int r10 = this.mSummary.getErrorCode();
        if (r10 != 0) goto L5;
    L10:
        copyLatestFiles(new File(WIFI_WLAN_LOG_DIR), r8, new AnonymousClass2(this), 2, "cnss firmware log");
        return;
    L5:
        if (r10 == 6) goto L10;
        if (r10 == 7) goto L10;
        a.i("skip cnss firmware logs for errorCode=", r10, TAG);
    }

    private int getMaxCaeAlogFiles() {
        if (this.mSummary.getErrorCode() != 0) goto L6;
        return 6;
    L6:
        return 3;
    }

    private boolean isValidDirectory(File r8) {
        if (r8.exists() == true) goto L8;
        StringBuilder r10 = new StringBuilder("source directory is not exist: ");
    L5:
        r10.append(r8.getAbsolutePath());
        CaeLog.e(TAG, r10.toString());
        return false;
    L8:
        if (r8.isDirectory() == true) goto L10;
        r10 = new StringBuilder("source path is not a directory: ");
        goto L5
    L10:
        return true;
    }

    private File[] listMatchedFiles(File r8, final FileMatcher r10) {
        if (isValidDirectory(r8) == true) goto L7;
        return null;
    L7:
        return r8.listFiles(new AnonymousClass5(this, r10));
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public LogCollectAsyncTask createAsyncTask(AbstractLogCollector r8) {
        return new LogCollectAsyncTask(this, CldCommon.CldModuleToString(r8.mSummary.getModuleType()));
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void doCopyLog(String r8) {
        File r10 = new File(r8);
        copyHostDriverLogs(r10);
        copyWifiFirmwareLogs(r10);
        CldUtil.dumpsys(a.e(r8, "/dumpsys_wifi.txt"), new String[]{"wifi"});
        CldUtil.dumpsys(a.e(r8, "/dumpsys_wifiscanner.txt"), new String[]{"wifiscanner"});
        copyLatestCaeAlogs(r10);
        copyCaptureLogsIfNeeded(r10);
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void doInbg(int r8) {
        copyKernelLog(this.mLogPath);
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void startCollect(int r8) {
        this.mCollectStartTimeMs = System.currentTimeMillis();
        AbstractLogLevelConfig.ModuleAndLogMasks[] r10 = WifiLogLevelConfig.getWiFiLogLevelMasks(r8);
        int r11 = WifiLogLevelConfig.getDuration(r8);
        CldCommon r12 = this.mCldCommon;
        if (r12 == null) goto L5;
        r12.enableModuleAndLogMasks(r10, r11, true);
        return;
    L5:
        CaeLog.e(TAG, "mCldCommon is null, cannot enable module and log masks");
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void stopCollect(int r8) {
        AbstractLogLevelConfig.ModuleAndLogMasks[] r10 = WifiLogLevelConfig.getWiFiLogLevelMasks(r8);
        int r11 = WifiLogLevelConfig.getDuration(r8);
        if (r10 == null) goto L9;
        CldCommon r12 = this.mCldCommon;
        if (r12 == null) goto L7;
        r12.disableModuleAndLogMasks(r10, r11, true);
        return;
    L7:
        CaeLog.e(TAG, "mCldCommon is null, cannot disable module and log masks");
        return;
    }

    private void copyFilesModifiedInWindow(File r13, File r14, File r15, long r16, long r18) {
        File[] r8 = r14.listFiles();
        if (r8 != null) goto L5;
        return;
    L5:
        String r10 = r13.getAbsolutePath();
        int r11 = r8.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L23;
        File r17 = r8[r12];
        if (r17.isDirectory() == false) goto L11;
        copyFilesModifiedInWindow(r13, r17, r15, r16, r18);
    L22:
        r12 = r12 + 1;
        goto L6
    L11:
        if (r17.isFile() == false) goto L22;
        if (r17.length() <= 0) goto L22;
        long r19 = r17.lastModified();
        if (r19 < r16) goto L22;
        if (r19 > r18) goto L22;
        copyFileToDest(r17, new File(r15, r17.getAbsolutePath().substring(r10.length() + 1)), "capture log");
        goto L22
    }
}
