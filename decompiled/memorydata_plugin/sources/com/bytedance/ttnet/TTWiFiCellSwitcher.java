package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class TTWiFiCellSwitcher {
    private static final String ACTION_NAME = "wifi-to-cell";
    private static final String ACTION_PATH_NOTIFY_SWITCH = "/notify-switch";
    private static final String ACTION_PATH_START = "/start";
    private static final String ACTION_PATH_STOP = "/stop";
    private static final String ACTION_PATH_TRIGGER = "/trigger-switch";
    private static final String ACTION_PATH_TRIGGER_THIRD_PARTY = "/trigger-third-party";
    private static final String TAG = "TTWiFiCellSwitchManager";
    private volatile State mCurrentState;
    private final Map<a, Handler> mObservers;

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType CELL = null;
        public static final NetworkType WIFI = null;
        final int networkType;

        static {
            NetworkType r0 = new NetworkType("WIFI", 0, 0);
            WIFI = r0;
            NetworkType r1 = new NetworkType("CELL", 1, 1);
            CELL = r1;
            $VALUES = new NetworkType[]{r0, r1};
        }

        private NetworkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.networkType = r3;
        }

        public static NetworkType valueOf(String r2) {
            return (NetworkType) ZeusTransformUtils.preCheckCast(Enum.valueOf(NetworkType.class, r2), NetworkType.class, "com.obric.memorydata.plugin");
        }

        public static NetworkType[] values() {
            return (NetworkType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NetworkType[].class, "com.obric.memorydata.plugin");
        }

        public int code() {
            return this.networkType;
        }
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        private static final Map<Integer, State> BY_CODE = null;
        public static final State DEFAULT_CELLULAR = null;
        public static final State DEFAULT_WIFI_WITH_CELLULAR_DOWN = null;
        public static final State DEFAULT_WIFI_WITH_CELLULAR_UP = null;
        public static final State EVALUATE_CELLULAR = null;
        public static final State NO_NETWORK = null;
        public static final State STOPPED = null;
        public static final State UNKNOWN = null;
        public static final State WAIT_CELLULAR_ALWAYS_UP = null;
        public static final State WAIT_USER_ALLOW_TO_CELLULAR = null;
        public static final State WAIT_USER_ALLOW_TO_WIFI = null;
        public static final State WIFI_WITH_CELLULAR_TRANS_DATA = null;
        final int state;

        static {
            int r2 = 0;
            State r0 = new State("UNKNOWN", 0, Integer.MIN_VALUE);
            UNKNOWN = r0;
            State r1 = new State("STOPPED", 1, -1);
            STOPPED = r1;
            State r3 = new State("NO_NETWORK", 2, 0);
            NO_NETWORK = r3;
            State r5 = new State("DEFAULT_CELLULAR", 3, 1);
            DEFAULT_CELLULAR = r5;
            State r7 = new State("DEFAULT_WIFI_WITH_CELLULAR_DOWN", 4, 2);
            DEFAULT_WIFI_WITH_CELLULAR_DOWN = r7;
            State r9 = new State("DEFAULT_WIFI_WITH_CELLULAR_UP", 5, 3);
            DEFAULT_WIFI_WITH_CELLULAR_UP = r9;
            State r11 = new State("WAIT_CELLULAR_ALWAYS_UP", 6, 4);
            WAIT_CELLULAR_ALWAYS_UP = r11;
            State r13 = new State("WAIT_USER_ALLOW_TO_CELLULAR", 7, 5);
            WAIT_USER_ALLOW_TO_CELLULAR = r13;
            State r15 = new State("WIFI_WITH_CELLULAR_TRANS_DATA", 8, 6);
            WIFI_WITH_CELLULAR_TRANS_DATA = r15;
            State r12 = new State("EVALUATE_CELLULAR", 9, 7);
            EVALUATE_CELLULAR = r12;
            State r14 = new State("WAIT_USER_ALLOW_TO_WIFI", 10, 8);
            WAIT_USER_ALLOW_TO_WIFI = r14;
            $VALUES = new State[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r12, r14};
            BY_CODE = new HashMap();
            State[] r4 = values();
            int r6 = r4.length;
        L3:
            if (r2 >= r6) goto L5;
            State r8 = r4[r2];
            BY_CODE.put(Integer.valueOf(r8.state), r8);
            r2 = r2 + 1;
            goto L3
        }

        private State(String r1, int r2, int r3) {
            super(r1, r2);
            this.state = r3;
        }

        public static State convertToState(int r2) {
            State r3 = (State) ZeusTransformUtils.preCheckCast(BY_CODE.get(Integer.valueOf(r2)), State.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L6;
            return r3;
        L6:
            return UNKNOWN;
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

    public interface a {
        void a(State r1, State r2);
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final TTWiFiCellSwitcher f3200a = null;

        static {
            f3200a = new TTWiFiCellSwitcher();
        }
    }

    public TTWiFiCellSwitcher() {
        this.mCurrentState = State.STOPPED;
        this.mObservers = new HashMap();
    }

    private void handleWiFiToCellState(final int r6, final int r7) {
        this.mCurrentState = State.convertToState(r7);
        monitor-enter(this);
        Iterator<Map.Entry<a, Handler>> r0 = this.mObservers.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        final a r2 = (a) ZeusTransformUtils.preCheckCast(r1.getKey(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Handler r3 = (Handler) ZeusTransformUtils.preCheckCast(r1.getValue(), Handler.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r3 == null) goto L6;
        r3.post(new AnonymousClass1(this, r2, r6, r7));     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static TTWiFiCellSwitcher inst() {
        return b.f3200a;
    }

    private static void notifyWiFiToCellState(int r1, int r2) {
        inst().handleWiFiToCellState(r1, r2);
    }

    public State getCurrentState() {
        return this.mCurrentState;
    }

    @Deprecated
    public boolean notifySwitchToMultiNetwork(boolean r3) {
        HashMap r2 = new HashMap();     // Catch: Exception -> L9
        if (r3 == false) goto L5;
        String r4 = "1";
    L6:
        r2.put("enable", r4);     // Catch: Exception -> L9
        TTNetProtocolUtil.a(ACTION_NAME, ACTION_PATH_NOTIFY_SWITCH, r2, null);     // Catch: Exception -> L9
        return true;
    L5:
        r4 = "0";
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void registerObserver(a r3, Handler r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5, "observer == null");
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservers.containsKey(r5) == true) goto L9;
        if (r4 != null) goto L8;
        this.mObservers.put(r5, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L11
        goto L9
    L8:
        this.mObservers.put(r5, r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    public void start() {
        TTNetProtocolUtil.a(ACTION_NAME, ACTION_PATH_START, null, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void stop() {
        TTNetProtocolUtil.a(ACTION_NAME, ACTION_PATH_STOP, null, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Deprecated
    public void triggerSwitchingToCellular() {
        TTNetProtocolUtil.a(ACTION_NAME, ACTION_PATH_TRIGGER_THIRD_PARTY, null, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void triggerSwitchingToNetwork(NetworkType r3) {
        HashMap r2 = new HashMap();     // Catch: Exception -> L4
        r2.put("network-type", Integer.toString(r3.code()));     // Catch: Exception -> L4
        TTNetProtocolUtil.a(ACTION_NAME, ACTION_PATH_TRIGGER, r2, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void unregisterObserver(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "observer == null");
        monitor-enter(this);
        this.mObservers.remove(r4);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
