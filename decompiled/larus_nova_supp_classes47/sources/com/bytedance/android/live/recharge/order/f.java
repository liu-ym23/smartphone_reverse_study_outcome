package com.bytedance.android.live.recharge.order;

import com.bytedance.android.live.revenue.common.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements com.bytedance.android.scope.o, com.bytedance.android.live.recharge.order.a {
    public final Set<c> a;
    public final Set<b> b;

    public static final class a {
    }

    public static final class b implements Order {
        public final ArrayDeque<e> a;
        public a b;
        public final com.bytedance.android.live.revenue.common.reactive.c c;
        public Object d;
        public final com.bytedance.android.live.revenue.common.reactive.c e;
        public final com.bytedance.android.live.recharge.deal.f f;
        public final k g;

        public static final class a implements Order.a {
            public final b a;
            public final e b;

            /* JADX WARN: Multi-variable type inference failed */
            public final boolean g() {
                if (((Order.State) this.a.c.b) == Order.State.Accepted) goto L7;
                if (((Order.State) this.a.c.b) == Order.State.Transmitting) goto L7;
            L9:
                return false;
            L7:
                if (this.a.b != this) goto L9;
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void f() {
                if (g() == false) goto L9;
                b r0 = this.a;
                if (((Order.State) r0.c.b) != Order.State.Accepted) goto L10;
                r0.b = null;
                r0.c.setValue(Order.State.Open);
                jy0.b.a("Recharge/OrderService", "drop: order = " + r0);
                r0.d();
                return;
            L10:
                return;
            }

            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final b getOrder() {
                return this.a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final void a(Object r4) {
                Intrinsics.checkNotNullParameter(r4, "result");
                if (g() == false) goto L9;
                b r1 = this.a;
                r1.getClass();
                Intrinsics.checkNotNullParameter(r4, "result");
                if (((Order.State) r1.c.b).isClosed() == true) goto L10;
                jy0.b.d("Recharge/OrderService", "succeed: order = " + r1 + ", result = " + r4);
                r1.setResult(r4);
                r1.c.setValue(Order.State.Successful);
                return;
            L10:
                return;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final void b(Object r4) {
                Intrinsics.checkNotNullParameter(r4, "result");
                if (g() == false) goto L9;
                b r0 = this.a;
                r0.getClass();
                Intrinsics.checkNotNullParameter(r4, "progress");
                if (((Order.State) r0.c.b).isClosed() == true) goto L10;
                jy0.b.a("Recharge/OrderService", "progress: order = " + r0 + ", progress = " + r4);
                r0.e.setValue(r4);
                return;
            L10:
                return;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final void c(Object r4) {
                b r0 = this.a;
                if (((Order.State) r0.c.b).isClosed() == true) goto L7;
                jy0.b.a("Recharge/OrderService", "transmit: order = " + r0 + ", result = " + r4);
                r0.setResult(r4);
                r0.c.setValue(Order.State.Transmitting);
                return;
            }

            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final void cancel(Object r2) {
                if (g() == false) goto L6;
                this.a.c(r2);
                return;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final void d(Object r6) {
                Intrinsics.checkNotNullParameter(r6, "result");
                if (g() == false) goto L9;
                b r1 = this.a;
                r1.getClass();
                Intrinsics.checkNotNullParameter(r6, "result");
                if (((Order.State) r1.c.b).isClosed() == true) goto L10;
                jy0.b.f("Recharge/OrderService", "fail: order = " + r1 + ", result = " + r6, null, 4);
                r1.setResult(r6);
                r1.c.setValue(Order.State.Failed);
                return;
            L10:
                return;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final void e(e r5) {
                Intrinsics.checkNotNullParameter(r5, "processor");
                if (g() == false) goto L9;
                b r1 = this.a;
                r1.getClass();
                Intrinsics.checkNotNullParameter(r5, "processor");
                if (((Order.State) r1.c.b) != Order.State.Accepted) goto L10;
                a r0 = new a(r1, r5);
                r1.b = r0;
                jy0.b.a("Recharge/OrderService", "transfer: order = " + r1 + ", processor = " + r5);
                r5.a(r1, r0);
                return;
            L10:
                return;
            }

            public a(b r2, e r3) {
                Intrinsics.checkNotNullParameter(r2, "order");
                Intrinsics.checkNotNullParameter(r3, "processor");
                this.a = r2;
                this.b = r3;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void d() {
            if (((Order.State) this.c.b) == Order.State.Open) goto L5;
            return;
        L5:
            e r0 = (e) this.a.removeFirstOrNull();
            if (r0 == null) goto L9;
            a r1 = new a(this, r0);
            this.b = r1;
            this.c.setValue(Order.State.Accepted);
            jy0.b.a("Recharge/OrderService", "tryInvokeNextProcessor: order = " + this + ", processor = " + r0);
            r0.a(this, r1);
            return;
        }

        public final String toString() {
            return "Order@" + t.a(this);
        }

        @Override // com.bytedance.android.live.recharge.order.Order
        public final k a() {
            return this.g;
        }

        @Override // com.bytedance.android.live.recharge.order.Order
        public final com.bytedance.android.live.revenue.common.reactive.c getProgress() {
            return this.e;
        }

        @Override // com.bytedance.android.live.recharge.order.Order
        public final Object getResult() {
            return this.d;
        }

        @Override // com.bytedance.android.live.recharge.order.Order
        public final com.bytedance.android.live.revenue.common.reactive.c getState() {
            return this.c;
        }

        @Override // com.bytedance.android.live.recharge.order.Order
        public final com.bytedance.android.live.recharge.deal.f o() {
            return this.f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(e r2) {
            Intrinsics.checkNotNullParameter(r2, "processor");
            if (((Order.State) this.c.b).isClosed() == false) goto L5;
            return;
        L5:
            this.a.add(r2);
            d();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c(Object r3) {
            if (((Order.State) this.c.b).isClosed() == false) goto L5;
            return;
        L5:
            jy0.b.d("Recharge/OrderService", "cancel: order = " + this + ", result = " + r3);
            setResult(r3);
            this.c.setValue(Order.State.Canceled);
        }

        public void setResult(Object r1) {
            this.d = r1;
        }

        public b(com.bytedance.android.live.recharge.deal.f r2, k r3, BusinessType r4) {
            Intrinsics.checkNotNullParameter(r2, "deal");
            Intrinsics.checkNotNullParameter(r3, "entranceParams");
            Intrinsics.checkNotNullParameter(r4, "businessType");
            this.f = r2;
            this.g = r3;
            this.a = new ArrayDeque();
            this.c = new com.bytedance.android.live.revenue.common.reactive.c(Order.State.Open);
            this.e = new com.bytedance.android.live.revenue.common.reactive.c(Order.b.a);
        }
    }

    public static final class c {
        public final e a;
        public final BusinessType b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L10;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            e r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            BusinessType r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ProcessorDescriptor(processor=" + this.a + ", businessType=" + this.b + ")";
        }

        public c(e r2, BusinessType r3) {
            Intrinsics.checkNotNullParameter(r2, "processor");
            Intrinsics.checkNotNullParameter(r3, "businessType");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        Iterator r0 = CollectionsKt.toMutableList(this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).c(null);
        goto L4
    L6:
        ((HashSet) this.b).clear();
        this.a.clear();
    }

    public f() {
        this.a = new LinkedHashSet();
        this.b = new HashSet();
    }

    @Override // com.bytedance.android.live.recharge.order.a
    public final void N(e r3, BusinessType r4) {
        Intrinsics.checkNotNullParameter(r3, "processor");
        Intrinsics.checkNotNullParameter(r4, "businessType");
        jy0.b.a("Recharge/OrderService", "registerOrderProcessor: processor = " + r3 + ", businessType = " + r4);
        this.a.add(new c(r3, r4));
    }

    @Override // com.bytedance.android.live.recharge.order.a
    public final b u1(com.bytedance.android.live.recharge.deal.f r5, k r6, BusinessType r7) {
        Intrinsics.checkNotNullParameter(r5, "deal");
        Intrinsics.checkNotNullParameter(r6, "options");
        Intrinsics.checkNotNullParameter(r7, "businessType");
        b r0 = new b(r5, r6, r7);
        StringBuilder r8 = new StringBuilder("buy: order = ");
        StringBuilder r9 = new StringBuilder();
        StringBuilder r1 = new StringBuilder();
        r1.append(r0);
        r1.append('(');
        r9.append(r1.toString());
        r9.append("state=" + ((Order.State) r0.c.b));
        if (r0.e.b == Order.b.a) goto L6;
        r9.append(", progress=" + r0.e.b);
    L6:
        if (r0.d == null) goto L9;
        r9.append(", result = " + r0.d);
    L9:
        if (r0.b == null) goto L15;
        StringBuilder r2 = new StringBuilder(", owner = ");
        b.a r3 = r0.b;
        if (r3 == null) goto L13;
        e r4 = r3.b;
    L14:
        r2.append(r4);
        r9.append(r2.toString());
        goto L15
    L13:
        r4 = null;
    L15:
        r9.append(", deal=" + r0.f);
        r9.append(")");
        r8.append(r9.toString());
        jy0.b.d("Recharge/OrderService", r8.toString());
        ((HashSet) this.b).add(r0);
        com.bytedance.android.live.revenue.common.reactive.j.a(r0.c, false).filter(g.a).take(1).subscribe(new h(this, r0));
        Set<c> r10 = this.a;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r10.iterator();
    L17:
        if (r13.hasNext() == false) goto L24;
        Object r14 = r13.next();
        if (((c) r14).b != r7) goto L21;
        boolean r15 = true;
    L22:
        if (r15 == false) goto L17;
        r12.add(r14);
        goto L17
    L21:
        r15 = false;
        goto L22
    L24:
        Iterator r16 = r12.iterator();
    L26:
        if (r16.hasNext() == false) goto L28;
        ((c) r16.next()).a.c(r0);
        goto L26
    L28:
        r0.d();
        return r0;
    }
}
