package com.bytedance.android.livesdk.gift.redpacket.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import u12.e;
import u12.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class RedPacketGiftModule_ProvideRedPacketGiftFactoryFactory implements Factory<h.a> {
    private final f module;

    public h.a get() {
        return provideRedPacketGiftFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m369get() {
        return get();
    }

    public RedPacketGiftModule_ProvideRedPacketGiftFactoryFactory(f r1) {
        this.module = r1;
    }

    public static RedPacketGiftModule_ProvideRedPacketGiftFactoryFactory create(f r1) {
        return new RedPacketGiftModule_ProvideRedPacketGiftFactoryFactory(r1);
    }

    public static h.a provideRedPacketGiftFactory(f r0) {
        r0.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new e());
    }
}
