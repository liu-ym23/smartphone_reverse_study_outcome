package com.bytedance.android.live.recharge;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m0<T, R> implements Function {
    public final /* synthetic */ a0 a;

    public m0(a0 r1) {
        this.a = r1;
    }

    public final Object apply(Object r6) {
        Pair r7 = (Pair) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        com.bytedance.android.live.recharge.deal.i r0 = (com.bytedance.android.live.recharge.deal.i) r7.getFirst();
        this.a.e(r0, false);
        PropertyOwner<Map<Long, com.bytedance.android.live.recharge.model.diamond.e>> r1 = this.a.M;
        Map<Long, com.bytedance.android.live.recharge.model.diamond.e> r2 = r0.j();
        if (r2 != null) goto L5;
        r2 = MapsKt.emptyMap();
    L5:
        r1.a(r2);
        PropertyOwner<Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g>> r3 = this.a.N;
        Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r4 = r0.getPanelExtraInfo();
        if (r4 != null) goto L8;
        r4 = MapsKt.emptyMap();
    L8:
        r3.a(r4);
        this.a.O.a(new LinkedHashMap());
        Iterator r5 = ((Map) this.a.M.a).entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L15;
        Map.Entry r8 = (Map.Entry) r5.next();
        Map r9 = (Map) this.a.O.a;
        Object r10 = r8.getKey();
        String r12 = ((com.bytedance.android.live.recharge.model.diamond.e) r8.getValue()).getCouponInfo();
        if (r12 != null) goto L14;
        r12 = "";
    L14:
        r9.put(r10, r12);
        goto L10
    L15:
        this.a.E.onNext(r0);
        return Single.just(r7.getSecond());
    }
}
