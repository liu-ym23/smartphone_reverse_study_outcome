package com.obric.cae.cldReport.network;

import android.content.Context;
import com.obric.cae.BWDL.BwdlDrop.a;
import com.obric.cae.cldReport.AbstractLogLevelConfig;
import com.obric.cae.cldReport.CldCommon;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class NetworkLogLevelConfig extends AbstractLogLevelConfig {
    public static final Set<Integer> ALL_LOG_MASKS = null;
    public static final int NETWORK_CAPTURE_LOG_MASK = 1;
    public static final String TAG = "NetworkLogLevelConfig";
    static AbstractLogLevelConfig.ErrorCodeAndLogConfMap[] mErrAndLogMaskMaps;
    private static final ConcurrentHashMap<Integer, AtomicInteger> mLogMaskCounterMap = null;
    private String mCaptureTaskId;
    private final Context mContext;

    static {
        mLogMaskCounterMap = new ConcurrentHashMap();
        HashSet r8 = new HashSet();
        r8.add(1);
        ALL_LOG_MASKS = Collections.unmodifiableSet(r8);
        mErrAndLogMaskMaps = new AbstractLogLevelConfig.ErrorCodeAndLogConfMap[]{new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(0, "Data Stall", 10, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(2, 1), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 1)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(1, "Handover", 30, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(2, 1), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 1)}), new AbstractLogLevelConfig.ErrorCodeAndLogConfMap(2, "Assistant Failure", 30, new AbstractLogLevelConfig.ModuleAndLogMasks[]{new AbstractLogLevelConfig.ModuleAndLogMasks(2, 1), new AbstractLogLevelConfig.ModuleAndLogMasks(5, 1)})};
    }

    public NetworkLogLevelConfig(Context r8) {
        super(r8);
        this.mCaptureTaskId = "";
        this.mContext = r8;
        mLogMaskCounterMap.clear();
    }

    public static /* synthetic */ AtomicInteger a(Integer r8) {
        return lambda$logLevelIncrement$0(r8);
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

    public static AbstractLogLevelConfig.ModuleAndLogMasks[] getNetworkLogLevelMasks(int r8) {
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

    private static /* synthetic */ AtomicInteger lambda$logLevelIncrement$0(Integer r8) {
        return new AtomicInteger(0);
    }

    private void setCldNetworkLogLevel(int r8, boolean r10, int r11) {
        String r12 = TAG;
        CaeLog.i(r12, "setCldLogLevel: levelMask=" + r8 + ", enable=" + r10);
        if (r8 == 1) goto L5;
        CaeLog.e(r12, "unknown log level");
        return;
    L5:
        setNetworkCapture(r10, this.mContext);
    }

    private void setNetworkCapture(boolean r8, Context r10) {
        String r11 = TAG;
        CaeLog.i(r11, "setNetworkCapture: enable=" + r8);
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
        String r15 = TAG;
        CaeLog.d(r15, r12 + " decrement: counterValue=" + r14);
        if (r14 == 0) goto L16;
        if (r14 >= 0) goto L4;
        CaeLog.e(r15, "logLevelDecrement: counterValue < 0");
        goto L4
    L16:
        setCldNetworkLogLevel(r12, false, 0);
        deleteLogLevDb(CldCommon.CldModuleToString(2), r12);
        goto L4
    L13:
        r14 = r13.get();
        goto L14
    L9:
        CaeLog.i(TAG, r12 + " decrement: counter == null");
        setCldNetworkLogLevel(r12, false, 0);
        deleteLogLevDb(CldCommon.CldModuleToString(2), r12);
        return;
    }

    @Override // com.obric.cae.cldReport.AbstractLogLevelConfig
    public void logLevelIncrement(int r8, int r10, boolean r11) {
        Iterator<Integer> r12 = ALL_LOG_MASKS.iterator();
    L4:
        if (r12.hasNext() == false) goto L20;
        int r13 = r12.next().intValue();
        if ((r8 & r13) == 0) goto L4;
        AtomicInteger r14 = mLogMaskCounterMap.computeIfAbsent(Integer.valueOf(r13), new a(1));
        if (r11 == false) goto L10;
        int r15 = r14.incrementAndGet();
    L11:
        CaeLog.d(TAG, r13 + " increment: counterValue=" + r15);
        if (r15 == 0) goto L13;
        if (r15 == 1) goto L17;
        if (r15 <= 1) goto L4;
        updateLogLevDb(CldCommon.CldModuleToString(2), r13, r10);
        goto L4
    L17:
        setCldNetworkLogLevel(r13, true, r10);
        insertLogLevDb(CldCommon.CldModuleToString(2), r13, r10);
        goto L4
    L13:
        setCldNetworkLogLevel(r13, true, r10);
        return;
    L10:
        r15 = r14.get();
        goto L11
    }
}
