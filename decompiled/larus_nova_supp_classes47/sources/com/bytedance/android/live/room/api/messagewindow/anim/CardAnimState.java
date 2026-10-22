package com.bytedance.android.live.room.api.messagewindow.anim;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class CardAnimState {
    public final State a;
    public final CardAnimType b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/anim/CardAnimState$State;", "", "START", "END", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State END = null;
        public static final State START = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r1 = new State("START", 0);
            START = r1;
            State r2 = new State("END", 1);
            END = r2;
            a = new State[]{r1, r2};
        }

        public static State valueOf(String r1) {
            return (State) a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public CardAnimState(State r2, CardAnimType r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "animType");
        this.a = r2;
        this.b = r3;
    }
}
