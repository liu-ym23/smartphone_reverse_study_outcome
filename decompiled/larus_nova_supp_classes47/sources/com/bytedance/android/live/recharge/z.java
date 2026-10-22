package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ RechargeDialogFragmentV2 a;

    public z(RechargeDialogFragmentV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Map r8 = ((cq2.d) r7).getParams();
        Object r0 = null;
        if (r8 == null) goto L5;
        Object r9 = r8.get("keys");
    L7:
        if ((r9 instanceof List) == false) goto L10;
        r0 = r9;
    L10:
        List r1 = (List) r0;
        if (r1 != null) goto L14;
        r1 = CollectionsKt.emptyList();
    L14:
        if (r1.contains("diamond") == false) goto L24;
        RechargeDialogFragmentV2 r10 = this.a;
        int r2 = RechargeDialogFragmentV2.n;
        RechargeDialogContext r3 = r10.j;
        Intrinsics.checkNotNull(r3);
        com.bytedance.android.live.recharge.model.d r12 = r10.g;
        if (r12 == null) goto L18;
        long r4 = r12.d;
    L19:
        long r5 = r4 * 10;
        if (r12 != null) goto L22;
        r12 = com.bytedance.android.live.recharge.model.d.p;
    L22:
        r3.getDiamondList(r5, r12);
        goto L24
    L18:
        r4 = 0;
    L24:
        if (r1.contains("wallet") == false) goto L31;
        IRechargeService r13 = (IRechargeService) jc1.k.f(IRechargeService.class);
        if (r13 == null) goto L31;
        zv0.f r14 = r13.rechargeCenter();
        if (r14 == null) goto L31;
        r14.sync("recharge_panel");
    L31:
        if (r1.contains("exchange") == false) goto L38;
        IRechargeService r15 = (IRechargeService) jc1.k.f(IRechargeService.class);
        if (r15 == null) goto L38;
        zv0.f r16 = r15.rechargeCenter();
        if (r16 == null) goto L38;
        r16.syncExchangeInfo();
    L38:
        if (r1.contains("extra") == false) goto L45;
        RechargeDialogContext r17 = this.a.j;
        if (r17 == null) goto L46;
        a0 r18 = r17.getRepository();
        if (r18 == null) goto L47;
        r18.b();
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L5:
        r9 = null;
        goto L7
    }
}
