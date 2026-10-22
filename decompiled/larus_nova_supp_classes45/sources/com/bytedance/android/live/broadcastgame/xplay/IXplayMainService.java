package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface IXplayMainService {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/IXplayMainService$State;", "", "state", "", "isAtLeast", "", "precedence", "I", "Uninitialized", "Preloading", "Preloaded", "StartingFailed", "Starting", "Started", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State Preloaded = null;
        public static final State Preloading = null;
        public static final State Started = null;
        public static final State Starting = null;
        public static final State StartingFailed = null;
        public static final State Uninitialized = null;
        public static final /* synthetic */ State[] a = null;
        private final int precedence;

        static {
            State r1 = new State("Uninitialized", 0, 0);
            Uninitialized = r1;
            State r2 = new State("Preloading", 1, 1);
            Preloading = r2;
            State r3 = new State("Preloaded", 2, 2);
            Preloaded = r3;
            State r4 = new State("StartingFailed", 3, 2);
            StartingFailed = r4;
            State r5 = new State("Starting", 4, 3);
            Starting = r5;
            State r6 = new State("Started", 5, 4);
            Started = r6;
            a = new State[]{r1, r2, r3, r4, r5, r6};
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public final boolean isAtLeast(State r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            if (this.precedence < r2.precedence) goto L5;
            return true;
        L5:
            return false;
        }

        public State(String r1, int r2, int r3) {
            super(r1, r2);
            this.precedence = r3;
        }
    }

    void a();
}
