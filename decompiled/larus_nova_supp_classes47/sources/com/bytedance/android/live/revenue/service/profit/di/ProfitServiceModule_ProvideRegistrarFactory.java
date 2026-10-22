package com.bytedance.android.live.revenue.service.profit.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import q01.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfitServiceModule_ProvideRegistrarFactory implements Factory<a> {
    private final x01.a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m451get() {
        return provideRegistrar(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m451get();
    }

    public ProfitServiceModule_ProvideRegistrarFactory(x01.a r1) {
        this.module = r1;
    }

    public static ProfitServiceModule_ProvideRegistrarFactory create(x01.a r1) {
        return new ProfitServiceModule_ProvideRegistrarFactory(r1);
    }

    public static a provideRegistrar(x01.a r0) {
        r0.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new w01.a());
    }
}
