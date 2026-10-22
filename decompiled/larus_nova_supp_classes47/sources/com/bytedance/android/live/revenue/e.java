package com.bytedance.android.live.revenue;

import com.bytedance.android.live.revenue.service.gift.di.GiftServiceModule_ProvideRegistrarFactory;
import com.bytedance.android.live.revenue.service.link.di.LinkServiceModule_ProvideRegistrarFactory;
import com.bytedance.android.live.revenue.service.profit.di.ProfitServiceModule_ProvideRegistrarFactory;
import com.bytedance.android.live.revenue.service.recharge.di.RechargeServiceModule_ProvideRegistrarFactory;
import dagger.internal.SetBuilder;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements q01.a {
    public final Set<q01.a> a;

    @Override // q01.a
    public final void a() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((q01.a) r0.next()).a();
        goto L4
    }

    @Override // q01.a
    public final void b() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((q01.a) r0.next()).b();
        goto L4
    }

    @Override // q01.a
    public final void c() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((q01.a) r0.next()).c();
        goto L4
    }

    @Override // q01.a
    public final void d() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((q01.a) r0.next()).d();
        goto L4
    }

    public e() {
        r01.a r0 = r01.b.a.e;
        this.a = SetBuilder.newSetBuilder(4).add(GiftServiceModule_ProvideRegistrarFactory.provideRegistrar(r0.a)).add(LinkServiceModule_ProvideRegistrarFactory.provideRegistrar(r0.b)).add(ProfitServiceModule_ProvideRegistrarFactory.provideRegistrar(r0.c)).add(RechargeServiceModule_ProvideRegistrarFactory.provideRegistrar(r0.d)).build();
    }
}
