package com.bytedance.android.btm.api;

import com.bytedance.android.btm.api.model.m;
import com.bytedance.android.btm.api.model.o;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface BtmPageLifecycle {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/btm/api/BtmPageLifecycle$State;", "", "state", "", "isAtLeast", "INITIALIZED", "CREATED", "RESUMED", "PAUSED", "DESTROYED", "btm-api_cnRelease"}, k = 1, mv = {1, 4, 0})
    public static final enum State extends Enum<State> {
        public static final State CREATED = null;
        public static final State DESTROYED = null;
        public static final State INITIALIZED = null;
        public static final State PAUSED = null;
        public static final State RESUMED = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r1 = new State("INITIALIZED", 0);
            INITIALIZED = r1;
            State r10 = new State("CREATED", 1);
            CREATED = r10;
            State r11 = new State("RESUMED", 2);
            RESUMED = r11;
            State r12 = new State("PAUSED", 3);
            PAUSED = r12;
            State r13 = new State("DESTROYED", 4);
            DESTROYED = r13;
            a = new State[]{r1, r10, r11, r12, r13};
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public boolean isAtLeast(State r1) {
            if (compareTo(r1) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public State(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
        public static /* synthetic */ void a(BtmPageLifecycle r1, Object r10, Boolean r11, int r12) {
            if ((r12 & 2) == 0) goto L5;
            r11 = null;
        L5:
            r1.e(r10, r11, null);
        }
    }

    void a(Object r1);

    @Deprecated(message = "use onPageShow/onPageHide instead")
    void b(Object r1, boolean r10);

    void c(Object r1, State r10);

    boolean d(Object r1, boolean r10);

    void e(Object r1, Boolean r10, m r11);

    State f(Object r1);

    void g(Object r1, Boolean r10, o r11);
}
