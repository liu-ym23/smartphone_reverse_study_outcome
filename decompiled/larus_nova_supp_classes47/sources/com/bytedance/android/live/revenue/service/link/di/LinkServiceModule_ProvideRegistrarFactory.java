package com.bytedance.android.live.revenue.service.link.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import q01.a;
import v01.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LinkServiceModule_ProvideRegistrarFactory implements Factory<a> {
    private final v01.a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m450get() {
        return provideRegistrar(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m450get();
    }

    public LinkServiceModule_ProvideRegistrarFactory(v01.a r1) {
        this.module = r1;
    }

    public static LinkServiceModule_ProvideRegistrarFactory create(v01.a r1) {
        return new LinkServiceModule_ProvideRegistrarFactory(r1);
    }

    public static a provideRegistrar(v01.a r0) {
        r0.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new b());
    }
}
