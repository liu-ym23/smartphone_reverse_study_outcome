package com.obric.cae.cldReport.gnss;

import android.content.Context;
import android.location.LocationManager;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.protobuf.c;
import com.obric.cae.cldReport.AbstractLogLevelConfig;
import com.obric.cae.cldReport.CldCommon;
import com.obric.cae.log.CaeLog;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class GnssLogLevelConfig extends AbstractLogLevelConfig {
    public static final Set<Integer> ALL_LOG_MASKS = null;
    private static final String ERROR_NAME_EVENT_GEOFENCE_POWER = "EventGeofencePower";
    private static final String ERROR_NAME_FEEDBACK = "Feedback";
    private static final String ERROR_NAME_LOCATION_AOI_BOARD_BREACH = "LocationAoiBoardBreach";
    private static final String ERROR_NAME_MAGIC_NUMBER_BUGREPORT = "MagicNumberBugReport";
    private static final String ERROR_NAME_MAGIC_NUMBER_MODEM = "MagicNumberModem";
    private static final String ERROR_NAME_SENSOR_FLIGHT_MODE = "SensorFlightMode";
    private static final int GNSS_MODEM_LOG_MASK = 2;
    private static final int GNSS_VERBOSE_LOG_MASK = 1;
    private static final String TAG = "StarLocation-LogLevelConfig";
    static AbstractLogLevelConfig.ErrorCodeAndLogConfMap[] gnssErrAndLogMaskMaps;
    private static final ConcurrentHashMap<Integer, AtomicInteger> mLogMaskCounterMap = null;
    private final Context mContext;

    static {
        mLogMaskCounterMap = new ConcurrentHashMap();
        HashSet r8 = new HashSet();
        r8.add(1);
        r8.add(2);
        ALL_LOG_MASKS = Collections.unmodifiableSet(r8);
        gnssErrAndLogMaskMaps = new AbstractLogLevelConfig.ErrorCodeAndLogConfMap[]{new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(1, ERROR_NAME_FEEDBACK, 180, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(3, 3), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 2)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(2, ERROR_NAME_MAGIC_NUMBER_BUGREPORT, 3, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(3, 1), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 2)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(3, ERROR_NAME_MAGIC_NUMBER_MODEM, TimeUtils.SECONDS_PER_DAY, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(3, 3), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 2)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(4, ERROR_NAME_EVENT_GEOFENCE_POWER, 180, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(3, 3), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 2)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(5, ERROR_NAME_SENSOR_FLIGHT_MODE, 3, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(5, 2)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(6, ERROR_NAME_LOCATION_AOI_BOARD_BREACH, 3, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(5, 2)})};
    }

    public GnssLogLevelConfig(Context r8) {
        super(r8);
        this.mContext = r8;
        mLogMaskCounterMap.clear();
    }

    public static /* synthetic */ AtomicInteger a(Integer r8) {
        return lambda$logLevelIncrement$0(r8);
    }

    public static int getDuration(int r8) {
        AbstractLogLevelConfig.ErrorCodeAndLogConfMap[] r10 = gnssErrAndLogMaskMaps;
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

    public static AbstractLogLevelConfig.ModuleAndLogMasks[] getGnssLogLevelMasks(int r8) {
        AbstractLogLevelConfig.ErrorCodeAndLogConfMap[] r10 = gnssErrAndLogMaskMaps;
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

    private static /* synthetic */ AtomicInteger lambda$logLevelIncrement$0(Integer r8) {
        return new AtomicInteger(0);
    }

    private void setCldGnssLogLevel(int r8, boolean r10) {
        CaeLog.i(TAG, "setCldGnssLogLevel: levelMask=" + r8 + ", enable=" + r10);
        if (r8 != 1) goto L5;
        setGnssVerboseLog(r10, this.mContext);
        return;
    L5:
        if (r8 == 2) goto L7;
        CaeLog.e(TAG, "unknown log level");
        return;
    L7:
        setGnssModemLog(r10);
    }

    private void setGnssModemLog(boolean r8) {
        CaeLog.i(TAG, "setGnssModemLog: enable=" + r8);
        ModemLogCapturer r10 = ModemLogCapturer.getInstance();
        if (r8 == false) goto L5;
        r10.startModemLog(128, 256, 0);
        return;
    L5:
        r10.stopModemLog();
    }

    private void setGnssVerboseLog(boolean r8, Context r10) {
        CaeLog.i(TAG, "setGnssVerboseLog: enable=" + r8);
        LocationManager r11 = (LocationManager) r10.getSystemService(LocationMonitorConst.LOCATION);
        if (r11 == null) goto L6;
        r11.enableGpsVerbosLogs(r8);
        return;
    }

    @Override // com.obric.cae.cldReport.AbstractLogLevelConfig
    public void logLevelDecrement(int r10, boolean r11) {
        Iterator<Integer> r8 = ALL_LOG_MASKS.iterator();
    L4:
        if (r8.hasNext() == false) goto L19;
        int r12 = r8.next().intValue();
        if ((r10 & r12) == 0) goto L4;
        AtomicInteger r13 = mLogMaskCounterMap.get(Integer.valueOf(r12));
        if (r13 == null) goto L9;
        if (r11 == false) goto L13;
        int r14 = r13.decrementAndGet();
    L14:
        CaeLog.d(TAG, r12 + " decrement: counterValue=" + r14);
        if (r14 == 0) goto L16;
        if (r14 >= 0) goto L4;
        CaeLog.e(TAG, "logLevelDecrement: counterValue < 0");
        goto L4
    L16:
        setCldGnssLogLevel(r12, false);
        deleteLogLevDb(CldCommon.CldModuleToString(3), r12);
        goto L4
    L13:
        r14 = r13.get();
        goto L14
    L9:
        CaeLog.i(TAG, r12 + " decrement: counter == null");
        setCldGnssLogLevel(r12, false);
        deleteLogLevDb(CldCommon.CldModuleToString(3), r12);
        return;
    }

    @Override // com.obric.cae.cldReport.AbstractLogLevelConfig
    public void logLevelIncrement(int r8, int r10, boolean r11) {
        Iterator<Integer> r12 = ALL_LOG_MASKS.iterator();
    L4:
        if (r12.hasNext() == false) goto L20;
        int r13 = r12.next().intValue();
        if ((r8 & r13) == 0) goto L4;
        AtomicInteger r14 = mLogMaskCounterMap.computeIfAbsent(Integer.valueOf(r13), new c(1));
        if (r11 == false) goto L10;
        int r15 = r14.incrementAndGet();
    L11:
        CaeLog.d(TAG, r13 + " increment: counterValue=" + r15);
        if (r15 == 0) goto L13;
        if (r15 == 1) goto L17;
        if (r15 <= 1) goto L4;
        updateLogLevDb(CldCommon.CldModuleToString(3), r13, r10);
        goto L4
    L17:
        setCldGnssLogLevel(r13, true);
        insertLogLevDb(CldCommon.CldModuleToString(3), r13, r10);
        goto L4
    L13:
        setCldGnssLogLevel(r13, true);
        return;
    L10:
        r15 = r14.get();
        goto L11
    }
}
