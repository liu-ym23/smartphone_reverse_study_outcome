package ew0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements dw0.a {
    public static final c a = null;

    public c() {
    }

    static {
        a = new c();
    }

    @Override // dw0.a
    public final void a(String r4, Map<String, String> r5, Collection<? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "eventProperties");
        Intrinsics.checkNotNullParameter(r6, "eventContext");
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Object r0 = r8.next();
        if ((r0 instanceof com.bytedance.android.live.recharge.deal.f) == false) goto L4;
        r7.add(r0);
        goto L4
    L8:
        Iterator r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L23;
        com.bytedance.android.live.recharge.deal.f r10 = (com.bytedance.android.live.recharge.deal.f) r9.next();
        r5.put("money", String.valueOf(r10.i()));
        r5.put("money_paid", String.valueOf(r10.g()));
        r5.put("given_scores", String.valueOf(r10.h()));
        Intrinsics.checkNotNullParameter(r10, "$this$getDescription");
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r1 = r10.c().getPanelExtraInfo().get(Long.valueOf(r10.g()));
        if (r1 == null) goto L15;
        String r2 = r1.getDiamondDesc();
        if (r2 == null) goto L15;
    L16:
        String r12 = r10.d();
        if (r2.length() != 0) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L22;
        r2 = r12;
    L22:
        r5.put("deal_badge", r2);
        goto L10
    L19:
        r3 = false;
    L15:
        r2 = "";
        goto L16
    }
}
