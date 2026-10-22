package com.bytedance.android.livesdk.gift.banner.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import cy1.e;
import cy1.f;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PopularCardGiftModule_ProvidePopularCardGiftFactoryFactory implements Factory<h.a> {
    private final f module;

    public h.a get() {
        return providePopularCardGiftFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m2get() {
        return get();
    }

    public PopularCardGiftModule_ProvidePopularCardGiftFactoryFactory(f r1) {
        this.module = r1;
    }

    public static PopularCardGiftModule_ProvidePopularCardGiftFactoryFactory create(f r1) {
        return new PopularCardGiftModule_ProvidePopularCardGiftFactoryFactory(r1);
    }

    public static h.a providePopularCardGiftFactory(f r0) {
        r0.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new e());
    }
}
