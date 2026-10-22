package com.bytedance.android.live.recharge.widget;

import com.bytedance.android.livesdkapi.depend.model.IQueryPrePayCashierData;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ RechargeCjComponentWidget a;
    public final /* synthetic */ com.bytedance.android.live.recharge.deal.f b;

    public h(RechargeCjComponentWidget r1, com.bytedance.android.live.recharge.deal.f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Map r6 = ((IQueryPrePayCashierData) r5).getRenderData();
        if (r6 == null) goto L12;
        Iterator<T> r7 = r6.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) r7.next();
        ((Map) this.a.h.getRepository().s.a).put(r0.getKey(), r0.getValue());
        goto L6
    L8:
        RechargeCjComponentWidget r8 = this.a;
        if (r8.j != null) goto L11;
        r8.Bq(r8.Aq(this.b.g()));
    L13:
        this.a.h.getRepository().R.onNext(12);
        this.a.h.isPreQueryInfo().a(Boolean.FALSE);
        return;
    L11:
        RechargeCjComponentWidget.Cq(r8.Aq(this.b.g()), new RechargeCjComponentWidget$onDealSelected$1$2(this));
        goto L13
    L12:
        RechargeCjComponentWidget r9 = this.a;
        int r1 = RechargeCjComponentWidget.k;
        r9.zq();
        int r10 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.e("error", 1, "render data is null", -1);
        goto L13
    }
}
