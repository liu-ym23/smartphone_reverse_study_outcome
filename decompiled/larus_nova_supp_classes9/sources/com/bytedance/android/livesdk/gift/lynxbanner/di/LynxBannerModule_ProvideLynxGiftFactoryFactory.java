package com.bytedance.android.livesdk.gift.lynxbanner.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dz1.a;
import dz1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LynxBannerModule_ProvideLynxGiftFactoryFactory implements Factory<h.a> {
    private final b module;

    public h.a get() {
        return provideLynxGiftFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m41get() {
        return get();
    }

    public LynxBannerModule_ProvideLynxGiftFactoryFactory(b r1) {
        this.module = r1;
    }

    public static LynxBannerModule_ProvideLynxGiftFactoryFactory create(b r1) {
        return new LynxBannerModule_ProvideLynxGiftFactoryFactory(r1);
    }

    public static h.a provideLynxGiftFactory(b r0) {
        r0.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}
