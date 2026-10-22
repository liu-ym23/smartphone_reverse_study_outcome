package com.obric.cae.cldReport;

import android.content.Context;
import com.obric.cae.cldReport.bluetooth.BluetoothLogLevelConfig;
import com.obric.cae.cldReport.gnss.GnssLogLevelConfig;
import com.obric.cae.cldReport.logLevelDataBase.LogLevDAO;
import com.obric.cae.cldReport.logLevelDataBase.LogLevEntry;
import com.obric.cae.cldReport.logcat.LogcatLogLevelConfig;
import com.obric.cae.cldReport.network.NetworkLogLevelConfig;
import com.obric.cae.cldReport.wifi.WifiLogLevelConfig;
import com.obric.cae.log.CaeLog;
import java.io.File;
import java.util.Iterator;
import o5.q;

/* JADX INFO: loaded from: classes.dex */
public class CldCommon {
    public static final String CLD_LOG_DIRECTORY = "/data/syslog/monitor/cld";
    private static final String CLD_MODULE_TYPE_BLUETOOTH_STR = "cld_bluetooth";
    private static final String CLD_MODULE_TYPE_GNSS_STR = "cld_gnss";
    private static final String CLD_MODULE_TYPE_LOGCAT_STR = "cld_logcat";
    private static final String CLD_MODULE_TYPE_NETWORK_STR = "cld_network";
    private static final String CLD_MODULE_TYPE_WIFI_STR = "cld_wifi";
    private static final String TAG = "CldCommon";
    private final BluetoothLogLevelConfig mBluetoothLogLevelConfig;
    private final Context mContext;
    private final LogLevDAO mDb;
    private final GnssLogLevelConfig mGnssLogLevelConfig;
    private final LogcatLogLevelConfig mLogcatLogLevelConfig;
    private final NetworkLogLevelConfig mNetworkLogLevelConfig;
    private final WifiLogLevelConfig mWifiLogLevelConfig;

    public static class CldSummary {
        private int mErrorCode;
        private String mInfo;
        private int mModuleType;
        private int mReason;
        private int mSubReason;

        public CldSummary(int r8, int r10, int r11, int r12, String r13) {
            this.mModuleType = r8;
            this.mErrorCode = r10;
            this.mReason = r11;
            this.mSubReason = r12;
            this.mInfo = r13;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public int getModuleType() {
            return this.mModuleType;
        }

        public String toString() {
            return "module: " + CldCommon.CldModuleToString(this.mModuleType) + ", errorCode: " + Integer.toString(this.mErrorCode) + ", reason: " + Integer.toString(this.mReason) + ", subReason: " + Integer.toString(this.mSubReason) + ", info: " + this.mInfo;
        }
    }

    public CldCommon(Context r8) {
        this.mContext = r8;
        this.mWifiLogLevelConfig = new WifiLogLevelConfig(r8);
        this.mLogcatLogLevelConfig = new LogcatLogLevelConfig(r8);
        this.mGnssLogLevelConfig = new GnssLogLevelConfig(r8);
        this.mNetworkLogLevelConfig = new NetworkLogLevelConfig(r8);
        this.mBluetoothLogLevelConfig = new BluetoothLogLevelConfig(r8);
        this.mDb = LogLevDAO.getInstance(r8);
        clearHistoryLogs();
    }

    public static int CldModuleStrToInt(String r8) {
        r8.getClass();
        switch(r8.hashCode()) {
            case -2003224822: goto L22;
            case -1047603062: goto L18;
            case -113050186: goto L14;
            case 759508523: goto L10;
            case 759979961: goto L6;
            default: goto L4;
        };
    L4:
        byte r10 = -1;
    L25:
        switch(r10) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            default: goto L26;
        };
    L26:
        return -1;
    L27:
        return 0;
    L28:
        return 3;
    L29:
        return 5;
    L31:
        return 1;
    L32:
        return 2;
    L6:
        if (r8.equals(CLD_MODULE_TYPE_WIFI_STR) == false) goto L33;
        r10 = 4;
        goto L25
    L33:
        r10 = -1;
        goto L25
    L10:
        if (r8.equals(CLD_MODULE_TYPE_GNSS_STR) == false) goto L34;
        r10 = 3;
        goto L25
    L34:
        r10 = -1;
        goto L25
    L14:
        if (r8.equals(CLD_MODULE_TYPE_LOGCAT_STR) == false) goto L35;
        r10 = 2;
        goto L25
    L35:
        r10 = -1;
        goto L25
    L18:
        if (r8.equals(CLD_MODULE_TYPE_BLUETOOTH_STR) == false) goto L36;
        r10 = 1;
        goto L25
    L36:
        r10 = -1;
        goto L25
    L22:
        if (r8.equals(CLD_MODULE_TYPE_NETWORK_STR) == false) goto L37;
        r10 = 0;
        goto L25
    L37:
        r10 = -1;
        goto L25
    }

    public static String CldModuleToString(int r8) {
        if (r8 != 0) goto L4;
        return CLD_MODULE_TYPE_WIFI_STR;
    L4:
        if (r8 != 1) goto L6;
        return CLD_MODULE_TYPE_BLUETOOTH_STR;
    L6:
        if (r8 != 2) goto L8;
        return CLD_MODULE_TYPE_NETWORK_STR;
    L8:
        if (r8 != 3) goto L10;
        return CLD_MODULE_TYPE_GNSS_STR;
    L10:
        if (r8 == 5) goto L13;
        return "unknown";
    L13:
        return CLD_MODULE_TYPE_LOGCAT_STR;
    }

    public static /* synthetic */ void a() {
        lambda$clearHistoryLogs$0();
    }

    public static /* synthetic */ void b(Thread r8, Throwable r10) {
        lambda$clearHistoryLogs$1(r8, r10);
    }

    private void clearHistoryLogs() {
        Thread r8 = new Thread(new q(1), "ClearHistoryLogs-Thread");
        r8.setUncaughtExceptionHandler(new a());
        r8.start();
    }

    private static /* synthetic */ void lambda$clearHistoryLogs$0() {
        CldUtil.deleteDirectory(new File(CLD_LOG_DIRECTORY));
    }

    private static /* synthetic */ void lambda$clearHistoryLogs$1(Thread r8, Throwable r10) {
        CaeLog.e(TAG, "Failed to clear history logs in thread: " + r8.getName(), r10);
    }

    public void disableModuleAndLogMasks(AbstractLogLevelConfig.ModuleAndLogMasks[] r8, int r10, boolean r11) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "disableModuleAndLogMasks: modMasksArray is null");
        return;
    L5:
        int r12 = r8.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L24;
        AbstractLogLevelConfig.ModuleAndLogMasks r14 = r8[r13];
        int r15 = r14.modType;
        if (r15 != 0) goto L10;
        this.mWifiLogLevelConfig.logLevelDecrement(r14.logMasks, r11);
    L23:
        r13 = r13 + 1;
        goto L6
    L10:
        if (r15 != 1) goto L12;
        this.mBluetoothLogLevelConfig.logLevelDecrement(r14.logMasks, r11);
        goto L23
    L12:
        if (r15 != 2) goto L14;
        this.mNetworkLogLevelConfig.logLevelDecrement(r14.logMasks, r11);
        goto L23
    L14:
        if (r15 != 3) goto L16;
        this.mGnssLogLevelConfig.logLevelDecrement(r14.logMasks, r11);
        goto L23
    L16:
        if (r15 != 5) goto L23;
        this.mLogcatLogLevelConfig.logLevelDecrement(r14.logMasks, r11);
        goto L23
    }

    public void enableModuleAndLogMasks(AbstractLogLevelConfig.ModuleAndLogMasks[] r8, int r10, boolean r11) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "enableModuleAndLogMasks: modMasksArray is null");
        return;
    L5:
        int r12 = r8.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L24;
        AbstractLogLevelConfig.ModuleAndLogMasks r14 = r8[r13];
        int r15 = r14.modType;
        if (r15 != 0) goto L10;
        this.mWifiLogLevelConfig.logLevelIncrement(r14.logMasks, r10, r11);
    L23:
        r13 = r13 + 1;
        goto L6
    L10:
        if (r15 != 1) goto L12;
        this.mBluetoothLogLevelConfig.logLevelIncrement(r14.logMasks, r10, r11);
        goto L23
    L12:
        if (r15 != 2) goto L14;
        this.mNetworkLogLevelConfig.logLevelIncrement(r14.logMasks, r10, r11);
        goto L23
    L14:
        if (r15 != 3) goto L16;
        this.mGnssLogLevelConfig.logLevelIncrement(r14.logMasks, r10, r11);
        goto L23
    L16:
        if (r15 != 5) goto L23;
        this.mLogcatLogLevelConfig.logLevelIncrement(r14.logMasks, r10, r11);
        goto L23
    }

    public int initAllModuleLogMasks(boolean r18) {
        Iterator<LogLevEntry> r8 = this.mDb.getAllEntries().iterator();
        int r10 = -1;
        LogLevEntry r11 = null;
        int r12 = 0;
    L4:
        if (r8.hasNext() == false) goto L20;
        LogLevEntry r13 = r8.next();
        long r14 = CldUtil.stringToTimeMillis(r13.getInvalidDate());
        if (r14 < 0) goto L19;
        int r15 = CldModuleStrToInt(r13.getModule());
        int r16 = r13.getLogmask();
        if (r15 < 0) goto L19;
        if (r16 < 0) goto L19;
        AbstractLogLevelConfig.ModuleAndLogMasks[] r17 = {new AbstractLogLevelConfig.ModuleAndLogMasks(r15, r16)};
        long r19 = CldUtil.getCurrentTimeMillis();
        if (r14 <= (r19 + 1000)) goto L14;
        r10 = (int) ((r14 - r19) / 1000);
        r12 = Math.max(r12, r10);
        if (r18 == true) goto L18;
        enableModuleAndLogMasks(r17, r10, false);
    L18:
        r11 = r13;
        goto L4
    L14:
        disableModuleAndLogMasks(r17, r10, false);
    L19:
        this.mDb.deleteLogEntry(r13.getModule(), r13.getLogmask());
        goto L4
    L20:
        if (r11 == null) goto L22;
        StringBuilder r20 = defpackage.b.f("initAllModuleLogMasks: maxDuration=", r12, ", maxDurationEntry=");
        r20.append(r11.toString());
        r20.append(", isRestored=");
        r20.append(r18);
        CaeLog.i(TAG, r20.toString());
    L22:
        return r12;
    }
}
