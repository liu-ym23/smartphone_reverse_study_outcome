package com.bytedance.android.livesdk.gift.banner.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import cy1.a;
import cy1.b;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class BannerGiftModule_ProvideBannerGiftFactoryFactory implements Factory<h.a> {
    private final b module;

    public h.a get() {
        return provideBannerGiftFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m0get() {
        return get();
    }

    public BannerGiftModule_ProvideBannerGiftFactoryFactory(b r1) {
        this.module = r1;
    }

    public static BannerGiftModule_ProvideBannerGiftFactoryFactory create(b r1) {
        return new BannerGiftModule_ProvideBannerGiftFactoryFactory(r1);
    }

    public static h.a provideBannerGiftFactory(b r0) {
        r0.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}
