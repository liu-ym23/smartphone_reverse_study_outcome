package com.bytedance.android.live.recharge;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.utils.ApiResult;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h0<T> implements Consumer {
    public final /* synthetic */ a0 a;
    public final /* synthetic */ long b;
    public final /* synthetic */ com.bytedance.android.live.recharge.model.d c;

    public h0(a0 r1, long r2, com.bytedance.android.live.recharge.model.d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r7) {
        com.bytedance.android.live.recharge.deal.i r8 = (com.bytedance.android.live.recharge.deal.i) r7;
        if (r8 == null) goto L25;
        int r0 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.c(this.b, ApiResult.RESPONSE_SUCCESS.getValue());
        this.a.R.onNext(2);
        a0 r1 = this.a;
        if (r1.T == true) goto L30;
        r1.e(r8, false);
        PropertyOwner<Map<Long, com.bytedance.android.live.recharge.model.diamond.e>> r2 = this.a.M;
        Map<Long, com.bytedance.android.live.recharge.model.diamond.e> r3 = r8.j();
        if (r3 != null) goto L9;
        r3 = MapsKt.emptyMap();
    L9:
        r2.a(r3);
        PropertyOwner<Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g>> r4 = this.a.N;
        Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r5 = r8.getPanelExtraInfo();
        if (r5 != null) goto L12;
        r5 = MapsKt.emptyMap();
    L12:
        r4.a(r5);
        this.a.O.a(new LinkedHashMap());
        Iterator r6 = ((Map) this.a.M.a).entrySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L19;
        Map.Entry r9 = (Map.Entry) r6.next();
        Map r10 = (Map) this.a.O.a;
        Object r12 = r9.getKey();
        String r13 = ((com.bytedance.android.live.recharge.model.diamond.e) r9.getValue()).getCouponInfo();
        if (r13 != null) goto L18;
        r13 = "";
    L18:
        r10.put(r12, r13);
        goto L14
    L19:
        this.a.E.onNext(r8);
        this.a.R.onNext(8);
        a0 r14 = this.a;
        com.bytedance.android.live.recharge.model.d r15 = this.c;
        r14.getClass();
        long r16 = ((Number) com.bytedance.android.live.recharge.utils.j.B.getValue(null, com.bytedance.android.live.recharge.utils.j.a[25])).longValue();
        if (r16 >= 0) goto L22;
        return;
    L22:
        if (((Boolean) r14.t.a).booleanValue() == false) goto L33;
        RxUtilKt.c(RxUtilKt.h(Observable.timer(r16, TimeUnit.MILLISECONDS)).subscribe(new p0(r14, r15)), r14.a);
        return;
    L33:
        return;
    L30:
        return;
    L25:
        this.a.R.onNext(3);
    }
}
