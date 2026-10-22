package com.bytedance.android.livesdk.chatroom.vs_base.base.paid;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class PrivilegeClarityEventHub {
    public final NextLiveData<State> a;
    public final NextLiveData<String> b;
    public final NextLiveData<String> c;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/paid/PrivilegeClarityEventHub$State;", "", "", "isActive", "showPlayerCard", "NONE", "CLARITY_GUIDE", "CLARITY_TEMP_WATCH", "CLARITY_TEMP_WATCH_END", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State CLARITY_GUIDE = null;
        public static final State CLARITY_TEMP_WATCH = null;
        public static final State CLARITY_TEMP_WATCH_END = null;
        public static final State NONE = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r1 = new State("NONE", 0);
            NONE = r1;
            State r2 = new State("CLARITY_GUIDE", 1);
            CLARITY_GUIDE = r2;
            State r3 = new State("CLARITY_TEMP_WATCH", 2);
            CLARITY_TEMP_WATCH = r3;
            State r4 = new State("CLARITY_TEMP_WATCH_END", 3);
            CLARITY_TEMP_WATCH_END = r4;
            a = new State[]{r1, r2, r3, r4};
        }

        public static State valueOf(String r1) {
            return (State) a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public final boolean isActive() {
            if (this == NONE) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean showPlayerCard() {
            if (this != CLARITY_TEMP_WATCH) goto L5;
            return true;
        L5:
            return false;
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public PrivilegeClarityEventHub() {
        NextLiveData<State> r0 = new NextLiveData();
        r0.setValue(State.NONE);
        Unit r1 = Unit.INSTANCE;
        this.a = r0;
        this.b = new NextLiveData();
        this.c = new NextLiveData();
    }
}
