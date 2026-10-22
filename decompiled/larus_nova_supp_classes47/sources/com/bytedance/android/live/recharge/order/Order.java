package com.bytedance.android.live.recharge.order;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface Order {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0011\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/order/Order$State;", "", "", "isClosed", "()Z", "Open", "Accepted", "Successful", "Failed", "Canceled", "Transmitting", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum State extends Enum<State> {
        public static final State Accepted = null;
        public static final State Canceled = null;
        public static final State Failed = null;
        public static final State Open = null;
        public static final State Successful = null;
        public static final State Transmitting = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r1 = new State("Open", 0);
            Open = r1;
            State r2 = new State("Accepted", 1);
            Accepted = r2;
            State r3 = new State("Successful", 2);
            Successful = r3;
            State r4 = new State("Failed", 3);
            Failed = r4;
            State r5 = new State("Canceled", 4);
            Canceled = r5;
            State r6 = new State("Transmitting", 5);
            Transmitting = r6;
            a = new State[]{r1, r2, r3, r4, r5, r6};
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public final boolean isClosed() {
            int r0 = com.bytedance.android.live.recharge.order.b.a[ordinal()];
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 != 2) goto L7;
            return true;
        L7:
            if (r0 == 3) goto L12;
            return false;
        L12:
            return true;
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void a(Object r1);

        void b(Object r1);

        void c(Object r1);

        void cancel(Object r1);

        void d(Object r1);

        void e(e r1);

        f.b getOrder();
    }

    public static final class b {
        public static final b a = null;

        public b() {
        }

        static {
            a = new b();
        }
    }

    k a();

    com.bytedance.android.live.revenue.common.reactive.c getProgress();

    Object getResult();

    com.bytedance.android.live.revenue.common.reactive.c getState();

    com.bytedance.android.live.recharge.deal.f o();
}
