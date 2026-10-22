package com.bytedance.android.live.recharge.trace;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.o;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements o {
    public final j a;

    public static final class a<T> implements com.bytedance.android.live.revenue.common.reactive.f {
        public final /* synthetic */ Set a;
        public final /* synthetic */ com.bytedance.android.live.recharge.panel.context.c b;

        public a(Set r1, com.bytedance.android.live.recharge.panel.context.c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.live.revenue.common.reactive.f
        public final void a(Object r5) {
            Order r6 = (Order) r5;
            if (r6 != null) goto L5;
            return;
        L5:
            if (this.a.contains(r6) == true) goto L10;
            this.a.add(r6);
            com.bytedance.android.live.recharge.trace.session.a r0 = this.b.getSession();
            r0.c(com.bytedance.android.live.recharge.trace.session.d.d);
            com.bytedance.android.live.recharge.panel.context.b.a(com.bytedance.android.live.revenue.common.reactive.j.a(r6.getState(), true).filter(com.bytedance.android.live.recharge.order.d.a).take(1).subscribe(new d(r6, r0)), this.b.getCd());
            return;
        }
    }

    public final void onStop() {
    }

    public final void onStart() {
        j r0 = this.a;
        if ((r0 instanceof ex0.a) == false) goto L6;
        com.bytedance.android.live.recharge.panel.context.c r1 = ((ex0.a) r0).c();
    L8:
        LinkedHashSet r2 = new LinkedHashSet();
        r1.f().a(new a(r2, r1));
        return;
    L6:
        if ((r0 instanceof com.bytedance.android.live.recharge.panel.dynamic.b) == false) goto L11;
        r1 = ((com.bytedance.android.live.recharge.panel.dynamic.b) r0).c();
        goto L8
    L11:
        throw new IllegalArgumentException();
    }

    public e(j r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = r2;
    }
}
