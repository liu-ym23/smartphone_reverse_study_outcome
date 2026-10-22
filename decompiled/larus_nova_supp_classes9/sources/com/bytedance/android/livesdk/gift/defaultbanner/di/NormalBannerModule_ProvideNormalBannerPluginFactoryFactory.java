package com.bytedance.android.livesdk.gift.defaultbanner.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import hy1.a;
import hy1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class NormalBannerModule_ProvideNormalBannerPluginFactoryFactory implements Factory<h.a> {
    private final b module;

    public h.a get() {
        return provideNormalBannerPluginFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m10get() {
        return get();
    }

    public NormalBannerModule_ProvideNormalBannerPluginFactoryFactory(b r1) {
        this.module = r1;
    }

    public static NormalBannerModule_ProvideNormalBannerPluginFactoryFactory create(b r1) {
        return new NormalBannerModule_ProvideNormalBannerPluginFactoryFactory(r1);
    }

    public static h.a provideNormalBannerPluginFactory(b r0) {
        r0.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}
