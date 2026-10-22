package com.bytedance.android.live.revenue.service.gift.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import q01.a;
import s01.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class GiftServiceModule_ProvideRegistrarFactory implements Factory<a> {
    private final t01.a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m449get() {
        return provideRegistrar(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m449get();
    }

    public GiftServiceModule_ProvideRegistrarFactory(t01.a r1) {
        this.module = r1;
    }

    public static GiftServiceModule_ProvideRegistrarFactory create(t01.a r1) {
        return new GiftServiceModule_ProvideRegistrarFactory(r1);
    }

    public static a provideRegistrar(t01.a r0) {
        r0.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new b());
    }
}
