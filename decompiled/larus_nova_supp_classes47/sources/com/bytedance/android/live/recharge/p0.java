package com.bytedance.android.live.recharge;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p0<T> implements Consumer {
    public final /* synthetic */ a0 a;
    public final /* synthetic */ com.bytedance.android.live.recharge.model.d b;

    public p0(a0 r1, com.bytedance.android.live.recharge.model.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        Long r12 = (Long) r10;
        a0 r13 = this.a;
        Map r0 = (Map) r13.s.a;
        Iterable r14 = (Iterable) r13.k.a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r1.add(Long.valueOf(((com.bytedance.android.live.recharge.deal.f) r15.next()).g()));
        goto L4
    L6:
        ArrayList r6 = new ArrayList();
        Iterator r16 = r1.iterator();
    L8:
        if (r16.hasNext() == false) goto L12;
        Object r2 = r16.next();
        if ((!r0.containsKey(Long.valueOf(((Number) r2).longValue()))) == false) goto L8;
        r6.add(r2);
        goto L8
    L12:
        a0 r3 = this.a;
        RxUtilKt.c(r3.c(((Number) r3.c.a).longValue(), r6, this.b, 3).compose(RxUtil.rxSchedulerHelper()).subscribe(new n0(this), o0.a), this.a.a);
    }
}
