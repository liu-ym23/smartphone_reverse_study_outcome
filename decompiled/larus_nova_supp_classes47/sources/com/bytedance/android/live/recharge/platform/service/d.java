package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.recharge.deal.FetchFrom;
import com.bytedance.android.live.recharge.r0;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ h a;
    public final /* synthetic */ com.bytedance.android.live.recharge.deal.m b;

    public d(h r1, com.bytedance.android.live.recharge.deal.m r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r12) {
        ExtraResponse r13 = (ExtraResponse) r12;
        Intrinsics.checkNotNullParameter(r13, "extraResponse");
        int r0 = com.bytedance.android.live.recharge.deal.k.a;
        List r1 = (List) r13.data;
        com.bytedance.android.live.recharge.model.diamond.a r2 = (com.bytedance.android.live.recharge.model.diamond.a) r13.extra;
        Intrinsics.checkNotNullParameter(r1, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r2, "extra");
        com.bytedance.android.live.recharge.deal.t r3 = new com.bytedance.android.live.recharge.deal.t(r1, r2);
        com.bytedance.android.live.recharge.deal.a r4 = com.bytedance.android.live.recharge.deal.l.a;
        com.bytedance.android.live.recharge.deal.a r5 = new com.bytedance.android.live.recharge.deal.a(this.b, r3);
        Intrinsics.checkNotNullParameter(r5, "dealSet");
        if (com.bytedance.android.live.recharge.deal.c.a(r5) == false) goto L5;
        jy0.b.a("Recharge/DealSetMemoryCache", "cache write");
        com.bytedance.android.live.recharge.deal.l.a = r5;
    L6:
        boolean r6 = false;
        if (this.b.e != FetchFrom.PreFetch) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == false) goto L12;
    L13:
        this.a.getClass();
        com.bytedance.android.live.recharge.platform.business.model.diamond.h r8 = new com.bytedance.android.live.recharge.platform.business.model.diamond.h(CollectionsKt.toMutableList((Collection) r13.data), (com.bytedance.android.live.recharge.model.diamond.a) r13.extra, 4);     // Catch: Throwable -> L22
        String r14 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();     // Catch: Throwable -> L22
        if (r3.p != 1) goto L18;
        HashMap<String, String> r9 = r0.a();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r8, "$this$serialize");     // Catch: Throwable -> L22
        r9.put(r14, GsonProtectorUtils.toJson(GsonHelper.get(), r8));     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r9, "<set-?>");     // Catch: Throwable -> L22
        r0.c.setValue(null, r0.a[1], r9);     // Catch: Throwable -> L22
    L18:
        if (r3.p != 0) goto L20;
        r6 = true;
    L20:
        r0.d.setValue(null, r0.a[2], Boolean.valueOf(r6));     // Catch: Throwable -> L22
    L21:
        return r3;
    L12:
        if (com.bytedance.android.live.recharge.utils.j.d().enableDiamondApiCache() == false) goto L21;
    L9:
        r7 = false;
        goto L10
    L5:
        jy0.b.a("Recharge/DealSetMemoryCache", "clear cache");
        com.bytedance.android.live.recharge.deal.l.a = null;
        goto L6
    }
}
