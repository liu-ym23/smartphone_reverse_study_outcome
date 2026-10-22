package ew0;

import com.bytedance.android.live.profile.monitor.DataType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements dw0.a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    @Override // dw0.a
    public final void a(String r5, Map<String, String> r6, Collection<? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "eventProperties");
        Intrinsics.checkNotNullParameter(r7, "eventContext");
        com.bytedance.android.live.recharge.panel.context.c r8 = com.bytedance.android.live.recharge.panel.g.a();
        if (r8 != null) goto L6;
        return;
    L6:
        if (r8.g().getValue().b() == true) goto L8;
        return;
    L8:
        boolean r9 = com.bytedance.android.live.recharge.combinedpay.a.a();
        if (r9 == false) goto L11;
        String r0 = DataType.TRUE;
    L12:
        r6.put("if_deduction", r0);
        ArrayList r1 = new ArrayList();
        Iterator<T> r10 = r7.iterator();
    L14:
        if (r10.hasNext() == false) goto L18;
        Object r2 = r10.next();
        if ((r2 instanceof com.bytedance.android.live.recharge.deal.f) == false) goto L14;
        r1.add(r2);
        goto L14
    L18:
        com.bytedance.android.live.recharge.deal.f r12 = (com.bytedance.android.live.recharge.deal.f) CollectionsKt.firstOrNull(r1);
        if (r9 == false) goto L36;
        if (r12 == null) goto L37;
        long r3 = r12.g();
        com.bytedance.android.live.incentive.exchange.d r13 = qa0.c.b.getService(com.bytedance.android.live.incentive.exchange.d.class);
        Intrinsics.checkNotNull(r13);
        com.bytedance.android.live.incentive.exchange.d r14 = r13;
        if (va0.a.a == false) goto L24;
        com.bytedance.android.live.incentive.balance.b.a r15 = com.bytedance.android.live.incentive.balance.b.a.a;
    L25:
        long r4 = r14.c(r15);
        if (r4 < r3) goto L28;
        String r16 = String.valueOf(r3 / ((long) 10));
    L29:
        r6.put("deduction_amt", r16);
        return;
    L28:
        r16 = String.valueOf(r4 / ((long) 10));
        goto L29
    L24:
        r15 = com.bytedance.android.live.incentive.balance.b.e.a;
        goto L25
    L37:
        return;
    L36:
        return;
    L11:
        r0 = DataType.FALSE;
        goto L12
    }
}
