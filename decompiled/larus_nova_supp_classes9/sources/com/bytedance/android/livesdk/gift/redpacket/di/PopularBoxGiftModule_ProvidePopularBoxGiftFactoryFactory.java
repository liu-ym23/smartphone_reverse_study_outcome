package com.bytedance.android.livesdk.gift.redpacket.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import u12.a;
import u12.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PopularBoxGiftModule_ProvidePopularBoxGiftFactoryFactory implements Factory<h.a> {
    private final b module;

    public h.a get() {
        return providePopularBoxGiftFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m367get() {
        return get();
    }

    public PopularBoxGiftModule_ProvidePopularBoxGiftFactoryFactory(b r1) {
        this.module = r1;
    }

    public static PopularBoxGiftModule_ProvidePopularBoxGiftFactoryFactory create(b r1) {
        return new PopularBoxGiftModule_ProvidePopularBoxGiftFactoryFactory(r1);
    }

    public static h.a providePopularBoxGiftFactory(b r0) {
        r0.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}
