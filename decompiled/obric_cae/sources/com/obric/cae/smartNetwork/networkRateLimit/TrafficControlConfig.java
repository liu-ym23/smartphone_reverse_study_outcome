package com.obric.cae.smartNetwork.networkRateLimit;

import android.content.Context;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import com.obric.cae.utils.CaeUtil;
import defpackage.b;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class TrafficControlConfig {
    private static final int BACKGROUND_OTHERS_CLASS_ID = 3;
    public static final int BACKGROUND_OTHER_APP_UID = 0;
    private static final int CLASS_ID_START_NUM = 4;
    private static final int DEFAULT_CLASS_ID = 1;
    private static final int DEFAULT_CLASS_PRIORITY = 2;
    private static final int DEFAULT_PRIORITY = 5;
    public static final int DEFAULT_UNLIMITED_RATE = 2097152;
    private static final int FOREGROUND_APP_PRIORITY = 2;
    private static final int FOREGROUND_LOW_LATENCY_APP_PRIORITY = 0;
    private static final int MAX_CLASS_ID_SRC_NUM = 30;
    private static final String TAG = "TrafficControlConfig";
    private static final int VIP_APP_CLASS_ID = 2;
    private static final int VIP_APP_PRIORITY = 1;
    private static TrafficControlConfig mNetTrafficControl;
    private final ConcurrentHashMap<Integer, Integer> mClassIdMap;
    private final ConcurrentLinkedQueue<Integer> mClassIdSource;
    private int mClassIdSourceNum;
    private final Context mContext;
    private boolean mIsBackgroundOthersClassSet;
    private boolean mIsInit;
    private boolean mIsVipClassSet;
    private final NefidInterface mNefidInterface;
    private String mTargetIfName;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.networkRateLimit.TrafficControlConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$TrafficControlConfig$AppClassType = null;

        static {
            int[] r8 = new int[AppClassType.values().length];
            $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$TrafficControlConfig$AppClassType = r8;
            r8[AppClassType.VIP_CLASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$TrafficControlConfig$AppClassType[AppClassType.FOREGROUND_LOW_LATENCY_CLASS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$TrafficControlConfig$AppClassType[AppClassType.FOREGROUND_NORMAL_CLASS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$TrafficControlConfig$AppClassType[AppClassType.DEFAULT_CLASS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum AppClassType extends Enum<AppClassType> {
        private static final /* synthetic */ AppClassType[] $VALUES = null;
        public static final AppClassType DEFAULT_CLASS = null;
        public static final AppClassType FOREGROUND_LOW_LATENCY_CLASS = null;
        public static final AppClassType FOREGROUND_NORMAL_CLASS = null;
        public static final AppClassType VIP_CLASS = null;

        private static /* synthetic */ AppClassType[] $values() {
            return new AppClassType[]{VIP_CLASS, FOREGROUND_LOW_LATENCY_CLASS, FOREGROUND_NORMAL_CLASS, DEFAULT_CLASS};
        }

        static {
            VIP_CLASS = new AppClassType("VIP_CLASS", 0);
            FOREGROUND_LOW_LATENCY_CLASS = new AppClassType("FOREGROUND_LOW_LATENCY_CLASS", 1);
            FOREGROUND_NORMAL_CLASS = new AppClassType("FOREGROUND_NORMAL_CLASS", 2);
            DEFAULT_CLASS = new AppClassType("DEFAULT_CLASS", 3);
            $VALUES = $values();
        }

        private AppClassType(String r8, int r10) {
            super(r8, r10);
        }

        public static AppClassType valueOf(String r8) {
            return (AppClassType) Enum.valueOf(AppClassType.class, r8);
        }

        public static AppClassType[] values() {
            return (AppClassType[]) $VALUES.clone();
        }
    }

    public static class UidSocketInfo {
        String inputHandleId;
        String outputHandleId;
        String srcIP;
        int srcPort;
        long throughput;
        int timeOutCnt;

        public UidSocketInfo(String r8, int r10, long r11) {
            this.srcIP = r8;
            this.srcPort = r10;
            this.throughput = r11;
        }

        public int getKey() {
            return (this.srcIP + this.srcPort).hashCode();
        }
    }

    private TrafficControlConfig(Context r8) {
        this.mIsInit = false;
        this.mIsVipClassSet = false;
        this.mIsBackgroundOthersClassSet = false;
        this.mClassIdMap = new ConcurrentHashMap();
        this.mClassIdSource = new ConcurrentLinkedQueue();
        this.mClassIdSourceNum = 4;
        this.mNefidInterface = NefidInterface.getInstance(r8);
        this.mContext = r8;
    }

    private synchronized void buildBaseClass() {
        monitor-enter(this);
        CaeLog.i(TAG, "buildBaseClass");     // Catch: Throwable -> L8
        if (this.mNefidInterface.netTCCreateClass(1, DEFAULT_UNLIMITED_RATE, 2) >= 0) goto L6;
        CaeLog.e(TAG, "netTCCreateClass foreground_unlimited failed");     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private int getClassId() {
        Integer r8 = this.mClassIdSource.poll();
        if (r8 != null) goto L10;
        int r10 = this.mClassIdSourceNum;
        if (r10 <= 30) goto L8;
        CaeLog.e(TAG, "classId source use out, mClassIdSourceNum: " + this.mClassIdSourceNum);
        return -1;
    L8:
        r8 = Integer.valueOf(r10);
        this.mClassIdSourceNum++;
    L10:
        return r8.intValue();
    }

    public static synchronized TrafficControlConfig getInstance(Context r8) {
        monitor-enter(TrafficControlConfig.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mNetTrafficControl != null) goto L7;
        mNetTrafficControl = new TrafficControlConfig(r8);     // Catch: Throwable -> L10
    L7:
        TrafficControlConfig r10 = mNetTrafficControl;     // Catch: Throwable -> L10
        monitor-exit(TrafficControlConfig.class);
        return r10;
    }

    private void releaseClassId(int r8) {
        if (r8 >= 0) goto L4;
    L8:
        android.aimedia.a.p("releaseClassId, invalid classId: ", r8, TAG);
        return;
    L4:
        if (r8 >= 30) goto L8;
        this.mClassIdSource.offer(Integer.valueOf(r8));
    }

    public synchronized void cleanFilter() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsInit == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        CaeLog.i(TAG, "call cleanFilter");     // Catch: Throwable -> L10
        this.mNefidInterface.netTCCleanFilter();     // Catch: Throwable -> L10
        this.mIsVipClassSet = false;     // Catch: Throwable -> L10
        this.mIsBackgroundOthersClassSet = false;     // Catch: Throwable -> L10
        setDefaultClassRateLimit(DEFAULT_UNLIMITED_RATE, 2);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public synchronized void deInit() {
        monitor-enter(this);
        CaeLog.i(TAG, "call deInit: " + this.mTargetIfName);     // Catch: Throwable -> L12
        this.mNefidInterface.netTCDeInit();     // Catch: Throwable -> L12
        if (this.mIsInit == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.mIsInit = false;     // Catch: Throwable -> L12
        this.mTargetIfName = null;     // Catch: Throwable -> L12
        this.mIsVipClassSet = false;     // Catch: Throwable -> L12
        this.mIsBackgroundOthersClassSet = false;     // Catch: Throwable -> L12
        this.mClassIdMap.clear();     // Catch: Throwable -> L12
        this.mClassIdSource.clear();     // Catch: Throwable -> L12
        this.mClassIdSourceNum = 4;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean getInitState() {
        return this.mIsInit;
    }

    public int getPriorityByClassType(AppClassType r8) {
        int r10 = AnonymousClass1.$SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$TrafficControlConfig$AppClassType[r8.ordinal()];
        if (r10 != 1) goto L5;
        return 1;
    L5:
        if (r10 != 2) goto L7;
        return 0;
    L7:
        if (r10 == 3) goto L10;
        return 5;
    L10:
        return 2;
    }

    public synchronized String getTargetIfName() {
        monitor-enter(this);
        String r8 = this.mTargetIfName;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean init() {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L6:
        if (this.mIsInit == false) goto L9;
        monitor-exit(this);
        return true;
    L9:
        String r8 = this.mTargetIfName;     // Catch: Throwable -> L30
        if (r8 != null) goto L12;
    L27:
        CaeLog.e(TAG, "mTargetIfName is null or empty");     // Catch: Throwable -> L30
        monitor-exit(this);
        return false;
    L12:
        if (r8.isEmpty() == true) goto L27;
        if (CaeUtil.isNetifUp(this.mContext, this.mTargetIfName, 0) == true) goto L19;
        CaeLog.e(TAG, "netif " + this.mTargetIfName + " is not up");     // Catch: Throwable -> L30
        monitor-exit(this);
        return false;
    L19:
        CaeLog.i(TAG, "call init: " + this.mTargetIfName);     // Catch: Throwable -> L30
        if (this.mNefidInterface.netTCInit(this.mTargetIfName) >= 0) goto L24;
        CaeLog.e(TAG, "netTCInit failed");     // Catch: Throwable -> L30
        this.mNefidInterface.netTCDeInit();     // Catch: Throwable -> L30
        monitor-exit(this);
        return false;
    L24:
        buildBaseClass();     // Catch: Throwable -> L30
        this.mIsInit = true;     // Catch: Throwable -> L30
        monitor-exit(this);
        return true;
    }

    public synchronized void removeClassId(int r8) {
        monitor-enter(this);
        Integer r10 = this.mClassIdMap.remove(Integer.valueOf(r8));     // Catch: Throwable -> L22
        if (r10 != null) goto L9;
        CaeLog.e(TAG, "removeClassId, uid: " + r8 + " not found");     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L9:
        CaeLog.i(TAG, "removeClassId, uid: " + r8 + " classId: " + r10);     // Catch: Throwable -> L22
        if (r10.intValue() != 2) goto L12;
    L19:
        CaeLog.i(TAG, "removeClassId, skip delete shared classId: " + r10);     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L12:
        if (r10.intValue() == 3) goto L19;
        this.mNefidInterface.netTCDeleteClass(r10.intValue());     // Catch: Throwable -> L22
        if (r10.intValue() < 4) goto L17;
        releaseClassId(r10.intValue());     // Catch: Throwable -> L22
    L17:
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public void removeRateLimit(ConcurrentHashMap<Integer, UidSocketInfo> r10) {
        CaeLog.i(TAG, "removeRateLimit, sockList size: " + r10.size());
        if (getInitState() == true) goto L5;
        return;
    L5:
        Iterator<UidSocketInfo> r11 = r10.values().iterator();
    L7:
        if (r11.hasNext() == false) goto L16;
        UidSocketInfo r8 = r11.next();
        StringBuilder r12 = new StringBuilder("removeRateLimit, ip: ");
        r12.append(r8.srcIP);
        r12.append(", port: ");
        r12.append(r8.srcPort);
        r12.append(", outputHandleId: ");
        r12.append(r8.outputHandleId);
        r12.append(", inputHandleId: ");
        android.aimedia.a.r(r12, r8.inputHandleId, TAG);
        String r13 = r8.outputHandleId;
        if (r13 == null) goto L7;
        if (r8.inputHandleId == null) goto L7;
        String[] r14 = r13.split("::");     // Catch: Exception -> L14
        int r15 = Integer.parseInt(r14[0], 16);     // Catch: Exception -> L14
        int r16 = Integer.parseInt(r14[1], 16);     // Catch: Exception -> L14
        String[] r17 = r8.inputHandleId.split("::");     // Catch: Exception -> L14
        this.mNefidInterface.netTCDeleteOutputFilter(r15, r16, Integer.parseInt(r17[0], 16), Integer.parseInt(r17[1], 16));     // Catch: Exception -> L14
    L14:
        e = move-exception;
        CaeLog.e(TAG, "Failed to parse handleId", e);
        goto L7
    }

    public synchronized boolean setDefaultClassRateLimit(int r8, int r10) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (init() == true) goto L9;
        monitor-exit(this);
        return false;
    L9:
        CaeLog.i(TAG, "setDefaultClassRateLimit rateLimit: " + r8 + "kbps, priority: " + r10);     // Catch: Throwable -> L16
        if (this.mNefidInterface.netTCUpdateClassRate(1, r8, r10) >= 0) goto L14;
        CaeLog.i(TAG, "netTCUpdateClassRate failed");     // Catch: Throwable -> L16
        monitor-exit(this);
        return false;
    L14:
        monitor-exit(this);
        return true;
    }

    public synchronized void setTargetIfName(String r8) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsInit == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (r8.equals(this.mTargetIfName) == true) goto L11;
        this.mTargetIfName = r8;     // Catch: Throwable -> L13
        CaeLog.i(TAG, "setTargetIfName: " + this.mTargetIfName);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
    }

    public boolean setUidRateLimit(int r10, ConcurrentHashMap<Integer, UidSocketInfo> r11, int r12, AppClassType r13) {
        if (init() == true) goto L5;
        return false;
    L5:
        int r8 = getPriorityByClassType(r13);
        Integer r14 = this.mClassIdMap.get(Integer.valueOf(r10));
        if (r14 != null) goto L16;
        if (r10 != 0) goto L10;
        r14 = 3;
        boolean r15 = this.mIsBackgroundOthersClassSet;
    L14:
        if (r14.intValue() >= 0) goto L17;
        return false;
    L17:
        StringBuilder r16 = b.f("setUidRateLimit, uid: ", r10, ", sockList size: ");
        r16.append(r11.size());
        r16.append(", rateLimit: ");
        r16.append(r12);
        r16.append(" classId: ");
        r16.append(r14);
        CaeLog.i(TAG, r16.toString());
        if (r15 == true) goto L29;
        CaeLog.i(TAG, "create new class: " + r14);
        if (this.mNefidInterface.netTCCreateClass(r14.intValue(), r12, r8) >= 0) goto L24;
        CaeLog.e(TAG, "netTCCreateClass classId: " + r14 + " failed");
        return false;
    L24:
        if (r13 != AppClassType.VIP_CLASS) goto L26;
        this.mIsVipClassSet = true;
    L32:
        this.mClassIdMap.put(Integer.valueOf(r10), r14);
        Iterator<UidSocketInfo> r17 = r11.values().iterator();
    L34:
        if (r17.hasNext() == false) goto L39;
        UidSocketInfo r18 = r17.next();
        StringBuilder r19 = b.f("setUidRateLimit, uid: ", r10, ", ip: ");
        r19.append(r18.srcIP);
        r19.append(", port: ");
        r19.append(r18.srcPort);
        r19.append(", classId: ");
        r19.append(r14);
        CaeLog.i(TAG, r19.toString());
        if (this.mNefidInterface.netTCCreateOutputFilter(r18.srcIP, r18.srcPort, r14.intValue()) >= 0) goto L34;
        CaeLog.e(TAG, "netTCCreateOutputFilter failed");
        return false;
    L39:
        return true;
    L26:
        if (r10 != 0) goto L32;
        this.mIsBackgroundOthersClassSet = true;
        goto L32
    L29:
        if (this.mNefidInterface.netTCUpdateClassRate(r14.intValue(), r12, r8) >= 0) goto L32;
        CaeLog.i(TAG, "netTCUpdateClassRate failed");
        return false;
    L10:
        if (r13 != AppClassType.VIP_CLASS) goto L12;
        r14 = 2;
        r15 = this.mIsVipClassSet;
        goto L14
    L12:
        r14 = Integer.valueOf(getClassId());
        r15 = false;
        goto L14
    L16:
        r15 = true;
        goto L17
    }
}
