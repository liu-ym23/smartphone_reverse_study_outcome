package com.bytedance.android.livesdk.gift.goods.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import py1.a;
import py1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GoodModule_ProvideGoodsPluginFactoryFactory implements Factory<h.a> {
    private final b module;

    public h.a get() {
        return provideGoodsPluginFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m33get() {
        return get();
    }

    public GoodModule_ProvideGoodsPluginFactoryFactory(b r1) {
        this.module = r1;
    }

    public static GoodModule_ProvideGoodsPluginFactoryFactory create(b r1) {
        return new GoodModule_ProvideGoodsPluginFactoryFactory(r1);
    }

    public static h.a provideGoodsPluginFactory(b r0) {
        r0.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}
