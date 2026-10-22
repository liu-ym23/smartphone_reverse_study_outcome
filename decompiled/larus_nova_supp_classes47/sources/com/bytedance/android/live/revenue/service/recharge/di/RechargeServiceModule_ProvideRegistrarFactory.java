package com.bytedance.android.live.revenue.service.recharge.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import q01.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RechargeServiceModule_ProvideRegistrarFactory implements Factory<a> {
    private final z01.a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m452get() {
        return provideRegistrar(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m452get();
    }

    public RechargeServiceModule_ProvideRegistrarFactory(z01.a r1) {
        this.module = r1;
    }

    public static RechargeServiceModule_ProvideRegistrarFactory create(z01.a r1) {
        return new RechargeServiceModule_ProvideRegistrarFactory(r1);
    }

    public static a provideRegistrar(z01.a r0) {
        r0.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new y01.a());
    }
}
