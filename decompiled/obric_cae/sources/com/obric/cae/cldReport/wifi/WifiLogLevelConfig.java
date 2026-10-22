package com.obric.cae.cldReport.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import com.google.protobuf.d;
import com.obric.cae.cldReport.AbstractLogLevelConfig;
import com.obric.cae.cldReport.CldCommon;
import com.obric.cae.cldReport.CldUtil;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class WifiLogLevelConfig extends AbstractLogLevelConfig {
    public static final Set<Integer> ALL_LOG_MASKS = null;
    public static final String TAG = "WifiLogLevelConfig";
    public static final int WIFI_FIRMWARE_LOG_MASK = 2;
    public static final int WIFI_NETWORK_CAPTURE_LOG_MASK = 4;
    public static final int WIFI_VERBOSE_LOG_MASK = 1;
    static AbstractLogLevelConfig.ErrorCodeAndLogConfMap[] mErrAndLogMaskMaps;
    private static final ConcurrentHashMap<Integer, AtomicInteger> mLogMaskCounterMap = null;
    private final Context mContext;
    private boolean mIsReceiverRegistered;
    private final BroadcastReceiver mWifiStateReceiver;

    static {
        HashSet r8 = new HashSet();
        r8.add(1);
        r8.add(2);
        r8.add(4);
        ALL_LOG_MASKS = Collections.unmodifiableSet(r8);
        mErrAndLogMaskMaps = new AbstractLogLevelConfig.ErrorCodeAndLogConfMap[]{new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(0, "Feedback", 200, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(0, 7), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 1)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(1, "OpenFail", 20, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(0, 3), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 1)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(2, "OpenSlow", 20, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(0, 3), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 1)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(3, "ConnectFail", 50, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(0, 3), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 1)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(5, "Disconnect", 20, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(0, 3), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 1)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(4, "ConnectSlow", 10, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(0, 3), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 1)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(6, "WlanCrash", 10, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(0, 3)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(7, "RoamFail", 50, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(0, 3), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 1)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(8, "NotAutoConnect", 50, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(0, 3), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 1)})};
        mLogMaskCounterMap = new ConcurrentHashMap();
    }

    public WifiLogLevelConfig(Context r8) {
        super(r8);
        this.mIsReceiverRegistered = false;
        this.mWifiStateReceiver = new AnonymousClass1(this);
        this.mContext = r8;
        mLogMaskCounterMap.clear();
    }

    public static /* synthetic */ AtomicInteger a(Integer r8) {
        return lambda$logLevelIncrement$0(r8);
    }

    public static /* synthetic */ boolean access$000(WifiLogLevelConfig r8) {
        return r8.mIsReceiverRegistered;
    }

    public static /* synthetic */ boolean access$002(WifiLogLevelConfig r8, boolean r10) {
        r8.mIsReceiverRegistered = r10;
        return r10;
    }

    public static /* synthetic */ Context access$100(WifiLogLevelConfig r8) {
        return r8.mContext;
    }

    public static int getDuration(int r8) {
        AbstractLogLevelConfig.ErrorCodeAndLogConfMap[] r10 = mErrAndLogMaskMaps;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        AbstractLogLevelConfig.ErrorCodeAndLogConfMap r13 = r10[r12];
        if (r13.getErrorCode() == r8) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        return r13.getDuration();
    L9:
        return 0;
    }

    public static AbstractLogLevelConfig.ModuleAndLogMasks[] getWiFiLogLevelMasks(int r8) {
        AbstractLogLevelConfig.ErrorCodeAndLogConfMap[] r10 = mErrAndLogMaskMaps;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        AbstractLogLevelConfig.ErrorCodeAndLogConfMap r13 = r10[r12];
        if (r13.getErrorCode() == r8) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        return r13.getLogLevelMasks();
    L9:
        return null;
    }

    public static boolean hasWifiLogMask(int r8, int r10) {
        AbstractLogLevelConfig.ModuleAndLogMasks[] r11 = getWiFiLogLevelMasks(r8);
        if (r11 != null) goto L5;
        return false;
    L5:
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L14;
        AbstractLogLevelConfig.ModuleAndLogMasks r14 = r11[r13];
        if (r14.modType != 0) goto L13;
        if ((r14.logMasks & r10) == 0) goto L13;
        return true;
    L13:
        r13 = r13 + 1;
        goto L6
    L14:
        return false;
    }

    private static /* synthetic */ AtomicInteger lambda$logLevelIncrement$0(Integer r8) {
        return new AtomicInteger(0);
    }

    private void setCldWiFiLogLevel(int r8, boolean r10) {
        String r11 = TAG;
        CaeLog.i(r11, "setCldLogLevel: levelMask=" + r8 + ", enable=" + r10);
        if (r8 != 1) goto L5;
        setWifiVerboseLog(r10, this.mContext);
        return;
    L5:
        if (r8 != 2) goto L7;
        setWifiFirmwareLog(r10);
        return;
    L7:
        if (r8 == 4) goto L9;
        CaeLog.e(r11, "unknown log level");
        return;
    L9:
        setWifiNetworkCapture(r10, this.mContext);
    }

    private void setWifiFirmwareLog(boolean r8) {
        WifiManager r10 = (WifiManager) this.mContext.getSystemService("wifi");
        if (r8 == false) goto L11;
        if (r10 != null) goto L6;
    L8:
        CaeLog.w(TAG, "Wifi is busy/starting, waiting for ENABLED state to start log...");
        if (this.mIsReceiverRegistered == true) goto L20;
        IntentFilter r11 = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        this.mContext.registerReceiver(this.mWifiStateReceiver, r11);
        this.mIsReceiverRegistered = true;
        return;
    L20:
        return;
    L6:
        if (r10.getWifiState() != 3) goto L8;
        CldUtil.setProperty("ctl.start", "vendor.cnss_diag");
        return;
    L11:
        CldUtil.setProperty("ctl.stop", "vendor.cnss_diag");
        if (this.mIsReceiverRegistered == false) goto L22;
        this.mContext.unregisterReceiver(this.mWifiStateReceiver);     // Catch: IllegalArgumentException -> L16
        this.mIsReceiverRegistered = false;     // Catch: IllegalArgumentException -> L16
        return;
    L22:
        return;
    }

    private void setWifiNetworkCapture(boolean r8, Context r10) {
        String r11 = TAG;
        CaeLog.i(r11, "setWifiNetworkCapture: enable=" + r8);
        if (r8 == false) goto L5;
        String r12 = "startCaptureTask ret: " + NefidInterface.getInstance(r10).startCaptureTask();
    L6:
        CaeLog.i(r11, r12);
        return;
    L5:
        NefidInterface.getInstance(r10).stopCaptureTask();
        r12 = "stopCaptureTask";
        goto L6
    }

    private void setWifiVerboseLog(boolean r8, Context r10) {
        WifiManager r11 = (WifiManager) r10.getSystemService("wifi");
        if (r11 != null) goto L6;
        return;
    L6:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "key_show_wifi_verbose_log_settings", 0) != 1) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        return;
    L11:
        if (r8 == false) goto L13;
        r11.enableVerboseLogging(1);
        return;
    L13:
        r11.enableVerboseLogging(0);
        return;
    L8:
        r12 = false;
        goto L9
    }

    @Override // com.obric.cae.cldReport.AbstractLogLevelConfig
    public void logLevelDecrement(int r8, boolean r10) {
        Iterator<Integer> r11 = ALL_LOG_MASKS.iterator();
    L4:
        if (r11.hasNext() == false) goto L19;
        int r12 = r11.next().intValue();
        if ((r8 & r12) == 0) goto L4;
        AtomicInteger r13 = mLogMaskCounterMap.get(Integer.valueOf(r12));
        if (r13 == null) goto L9;
        if (r10 == false) goto L13;
        int r14 = r13.decrementAndGet();
    L14:
        String r15 = TAG;
        CaeLog.d(r15, r12 + " decrement: counterValue=" + r14);
        if (r14 == 0) goto L16;
        if (r14 >= 0) goto L4;
        CaeLog.e(r15, "logLevelDecrement: counterValue < 0");
        goto L4
    L16:
        setCldWiFiLogLevel(r12, false);
        deleteLogLevDb(CldCommon.CldModuleToString(0), r12);
        goto L4
    L13:
        r14 = r13.get();
        goto L14
    L9:
        CaeLog.i(TAG, r12 + " decrement: counter == null");
        setCldWiFiLogLevel(r12, false);
        deleteLogLevDb(CldCommon.CldModuleToString(0), r12);
        return;
    }

    @Override // com.obric.cae.cldReport.AbstractLogLevelConfig
    public void logLevelIncrement(int r8, int r10, boolean r11) {
        Iterator<Integer> r12 = ALL_LOG_MASKS.iterator();
    L4:
        if (r12.hasNext() == false) goto L20;
        int r13 = r12.next().intValue();
        if ((r8 & r13) == 0) goto L4;
        AtomicInteger r14 = mLogMaskCounterMap.computeIfAbsent(Integer.valueOf(r13), new d(4));
        if (r11 == false) goto L10;
        int r15 = r14.incrementAndGet();
    L11:
        CaeLog.d(TAG, r13 + " increment: counterValue=" + r15);
        if (r15 == 0) goto L13;
        if (r15 == 1) goto L17;
        if (r15 <= 1) goto L4;
        updateLogLevDb(CldCommon.CldModuleToString(0), r13, r10);
        goto L4
    L17:
        setCldWiFiLogLevel(r13, true);
        insertLogLevDb(CldCommon.CldModuleToString(0), r13, r10);
        goto L4
    L13:
        setCldWiFiLogLevel(r13, true);
        return;
    L10:
        r15 = r14.get();
        goto L11
    }
}
