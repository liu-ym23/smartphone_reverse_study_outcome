package com.bytedance.android.livesdk.gift.periodcard.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import jz1.a;
import jz1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PeriodCardGiftModule_ProvidePeriodCardGiftFactoryFactory implements Factory<h.a> {
    private final b module;

    public h.a get() {
        return providePeriodCardGiftFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m45get() {
        return get();
    }

    public PeriodCardGiftModule_ProvidePeriodCardGiftFactoryFactory(b r1) {
        this.module = r1;
    }

    public static PeriodCardGiftModule_ProvidePeriodCardGiftFactoryFactory create(b r1) {
        return new PeriodCardGiftModule_ProvidePeriodCardGiftFactoryFactory(r1);
    }

    public static h.a providePeriodCardGiftFactory(b r0) {
        r0.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}
