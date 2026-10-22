package com.bytedance.android.livesdk.gift.banner.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import cy1.c;
import cy1.d;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PKBattlePropCardModule_ProvidePopularCardGiftFactoryFactory implements Factory<h.a> {
    private final d module;

    public h.a get() {
        return providePopularCardGiftFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1get() {
        return get();
    }

    public PKBattlePropCardModule_ProvidePopularCardGiftFactoryFactory(d r1) {
        this.module = r1;
    }

    public static PKBattlePropCardModule_ProvidePopularCardGiftFactoryFactory create(d r1) {
        return new PKBattlePropCardModule_ProvidePopularCardGiftFactoryFactory(r1);
    }

    public static h.a providePopularCardGiftFactory(d r0) {
        r0.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new c());
    }
}
