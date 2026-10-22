package com.bytedance.apm.launch.evil;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class LaunchSleepDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1426a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1427b = false;
    private static State c;
    private static long d;
    private static long e;
    private static String f;
    private static long g;
    private static long h;
    private static ExecutorService i;

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State DISK_SLEEP = null;
        public static final State NONE = null;
        public static final State NOT_SLEEP = null;
        public static final State SLEEP = null;

        static {
            State r0 = new State("NONE", 0);
            NONE = r0;
            State r1 = new State("SLEEP", 1);
            SLEEP = r1;
            State r3 = new State("NOT_SLEEP", 2);
            NOT_SLEEP = r3;
            State r5 = new State("DISK_SLEEP", 3);
            DISK_SLEEP = r5;
            $VALUES = new State[]{r0, r1, r3, r5};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        c = State.NONE;
        d = -1;
        e = 0;
        f = "";
        g = 8000;
        h = 0;
        i = Executors.newSingleThreadExecutor(new AnonymousClass1());
    }

    public static void a() {
        if (f1426a == true) goto L5;
        return;
    L5:
        f1426a = false;
        c = State.NONE;
        d = -1;
        e = 0;
        f = "";
    }
}
