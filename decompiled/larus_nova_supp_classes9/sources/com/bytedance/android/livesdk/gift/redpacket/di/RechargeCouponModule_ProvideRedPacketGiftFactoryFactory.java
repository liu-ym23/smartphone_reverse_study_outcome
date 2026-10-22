package com.bytedance.android.livesdk.gift.redpacket.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import u12.c;
import u12.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class RechargeCouponModule_ProvideRedPacketGiftFactoryFactory implements Factory<h.a> {
    private final d module;

    public h.a get() {
        return provideRedPacketGiftFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m368get() {
        return get();
    }

    public RechargeCouponModule_ProvideRedPacketGiftFactoryFactory(d r1) {
        this.module = r1;
    }

    public static RechargeCouponModule_ProvideRedPacketGiftFactoryFactory create(d r1) {
        return new RechargeCouponModule_ProvideRedPacketGiftFactoryFactory(r1);
    }

    public static h.a provideRedPacketGiftFactory(d r0) {
        r0.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new c());
    }
}
