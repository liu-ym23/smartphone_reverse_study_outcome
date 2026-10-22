package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class TTMultiNetwork {
    private static final String HEADER_ACTIVE_RESULT = "ActiveResult";
    private static final String HOST_MULTINET = "multinet";
    private static final String PATH_ACTIVATE_CELL = "/activatecell";
    private static final String TAG = "TTMultiNetwork";
    private static volatile ActiveResult sActiveResult;
    private static volatile State sCurrentState;
    private static Map<Observer, Handler> sObservers;

    public static final enum ActiveResult extends Enum<ActiveResult> {
        private static final /* synthetic */ ActiveResult[] $VALUES = null;
        public static final ActiveResult ACTIVATION_IN_PROGRESS = null;
        public static final ActiveResult DEFAULT = null;
        public static final ActiveResult DEFERRED_UNSUITABLE_NETWORK = null;
        public static final ActiveResult FAILED = null;
        public static final ActiveResult SUCCESS = null;
        private final int code;

        static {
            ActiveResult r0 = new ActiveResult("DEFAULT", 0, 0);
            DEFAULT = r0;
            ActiveResult r1 = new ActiveResult("SUCCESS", 1, 1);
            SUCCESS = r1;
            ActiveResult r3 = new ActiveResult(RawObservationEntity.STATE_FAILED, 2, 2);
            FAILED = r3;
            ActiveResult r5 = new ActiveResult("DEFERRED_UNSUITABLE_NETWORK", 3, 3);
            DEFERRED_UNSUITABLE_NETWORK = r5;
            ActiveResult r7 = new ActiveResult("ACTIVATION_IN_PROGRESS", 4, 4);
            ACTIVATION_IN_PROGRESS = r7;
            $VALUES = new ActiveResult[]{r0, r1, r3, r5, r7};
        }

        private ActiveResult(String r1, int r2, int r3) {
            super(r1, r2);
            this.code = r3;
        }

        static ActiveResult convertToResult(String r2) {
            int r3 = Integer.parseInt(r2);     // Catch: NumberFormatException -> L4
            return values()[r3 - DEFAULT.code()];
        L5:
            return DEFAULT;
        }

        public static ActiveResult valueOf(String r2) {
            return (ActiveResult) ZeusTransformUtils.preCheckCast(Enum.valueOf(ActiveResult.class, r2), ActiveResult.class, "com.obric.memorydata.plugin");
        }

        public static ActiveResult[] values() {
            return (ActiveResult[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ActiveResult[].class, "com.obric.memorydata.plugin");
        }

        int code() {
            return this.code;
        }

        public int getCode() {
            return this.code;
        }
    }

    public interface Observer {
        void onMultiNetStateChanged(State r1, State r2, long r3);

        void onUserSpecifiedNetworkEnabled(boolean r1, long r2);
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State DEFAULT_CELLULAR_WITH_WIFI_DOWN = null;
        public static final State DEFAULT_VPN = null;
        public static final State DEFAULT_WIFI_WITH_CELLULAR_DOWN = null;
        public static final State DEFAULT_WIFI_WITH_CELLULAR_UP = null;
        public static final State NO_NETWORK = null;
        public static final State STOPPED = null;
        public static final State WAIT_CELLULAR_ALWAYS_UP = null;
        final int state;

        static {
            State r0 = new State("STOPPED", 0, -1);
            STOPPED = r0;
            State r1 = new State("NO_NETWORK", 1, 0);
            NO_NETWORK = r1;
            State r3 = new State("DEFAULT_CELLULAR_WITH_WIFI_DOWN", 2, 1);
            DEFAULT_CELLULAR_WITH_WIFI_DOWN = r3;
            State r5 = new State("DEFAULT_WIFI_WITH_CELLULAR_DOWN", 3, 2);
            DEFAULT_WIFI_WITH_CELLULAR_DOWN = r5;
            State r7 = new State("DEFAULT_WIFI_WITH_CELLULAR_UP", 4, 3);
            DEFAULT_WIFI_WITH_CELLULAR_UP = r7;
            State r9 = new State("WAIT_CELLULAR_ALWAYS_UP", 5, 4);
            WAIT_CELLULAR_ALWAYS_UP = r9;
            State r11 = new State("DEFAULT_VPN", 6, 5);
            DEFAULT_VPN = r11;
            $VALUES = new State[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private State(String r1, int r2, int r3) {
            super(r1, r2);
            this.state = r3;
        }

        static State convertToState(int r2) {
            return values()[r2 - STOPPED.code()];
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
        }

        public int code() {
            return this.state;
        }
    }

    static {
        sCurrentState = State.STOPPED;
        sActiveResult = ActiveResult.DEFAULT;
        sObservers = new HashMap();
    }

    public TTMultiNetwork() {
    }

    static /* synthetic */ ActiveResult access$002(ActiveResult r0) {
        sActiveResult = r0;
        return r0;
    }

    static /* synthetic */ void access$100(boolean r0) {
        notifyUserSpecifiedNetworkEnabled(r0);
    }

    public static ActiveResult getActiveResult() {
        return sActiveResult;
    }

    public static State getCurrentState() {
        return sCurrentState;
    }

    private static void notifyMultiNetworkState(final int r12, final int r13) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "notifyMultiNetworkState, prev: " + r12 + ", curr: " + r13);
    L5:
        sCurrentState = State.convertToState(r13);
        final long r7 = System.currentTimeMillis();
        monitor-enter(TTMultiNetwork.class);
        Iterator<Map.Entry<Observer, Handler>> r9 = sObservers.entrySet().iterator();     // Catch: Throwable -> L15
    L9:
        if (r9.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        final Observer r2 = (Observer) ZeusTransformUtils.preCheckCast(r1.getKey(), Observer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Handler r10 = (Handler) ZeusTransformUtils.preCheckCast(r1.getValue(), Handler.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r10 == null) goto L9;
        r10.post(new AnonymousClass2(r2, r12, r13, r7));     // Catch: Throwable -> L15
        goto L9
    L13:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private static void notifyUserSpecifiedNetworkEnabled(final boolean r8) {
        final long r0 = System.currentTimeMillis();
        monitor-enter(TTMultiNetwork.class);
        Iterator<Map.Entry<Observer, Handler>> r3 = sObservers.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        final Observer r5 = (Observer) ZeusTransformUtils.preCheckCast(r4.getKey(), Observer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Handler r6 = (Handler) ZeusTransformUtils.preCheckCast(r4.getValue(), Handler.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r6 == null) goto L6;
        r6.post(new AnonymousClass3(r5, r8, r0));     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void registerMultiNetObserver(Observer r3, Handler r4) {
        Observer r5 = (Observer) ZeusTransformUtils.wrapperContextForParams(r3, Observer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5, "observer == null");
        monitor-enter(TTMultiNetwork.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sObservers.containsKey(r5) == true) goto L9;
        if (r4 != null) goto L8;
        sObservers.put(r5, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L11
        goto L9
    L8:
        sObservers.put(r5, r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L11
    }

    @Deprecated
    public static void triggerSwitchingToCellular() {
        TTWiFiCellSwitcher.inst().triggerSwitchingToNetwork(TTWiFiCellSwitcher.NetworkType.CELL);
    }

    public static void tryActivateAlternativeNet() {
        TTNetProtocolUtil.a(HOST_MULTINET, PATH_ACTIVATE_CELL, null, null, new AnonymousClass1());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void unregisterMultiNetObserver(Observer r2) {
        Observer r3 = (Observer) ZeusTransformUtils.wrapperContextForParams(r2, Observer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "observer == null");
        monitor-enter(TTMultiNetwork.class);
        sObservers.remove(r3);     // Catch: Throwable -> L7
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
