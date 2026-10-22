package com.bytedance.apm.launch.evil;

import androidx.annotation.NonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class LaunchSleepDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1003a = false;

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State DISK_SLEEP = null;
        public static final State NONE = null;
        public static final State NOT_SLEEP = null;
        public static final State SLEEP = null;

        static {
            State r10 = new State("NONE", 0);
            NONE = r10;
            State r11 = new State("SLEEP", 1);
            SLEEP = r11;
            State r12 = new State("NOT_SLEEP", 2);
            NOT_SLEEP = r12;
            State r13 = new State("DISK_SLEEP", 3);
            DISK_SLEEP = r13;
            $VALUES = new State[]{r10, r11, r12, r13};
        }

        private State(String r10, int r11) {
            super(r10, r11);
        }

        public static State valueOf(String r10) {
            return (State) Enum.valueOf(State.class, r10);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    static class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable r10) {
            Thread r11 = new Thread(r10);
            r11.setName("launch_sleep_detector");
            return r11;
        }
    }

    static {
        State r10 = State.NONE;
        Executors.newSingleThreadExecutor(new a());
    }

    public static void a() {
        if (f1003a == true) goto L5;
        return;
    L5:
        f1003a = false;
        State r10 = State.NONE;
    }
}
