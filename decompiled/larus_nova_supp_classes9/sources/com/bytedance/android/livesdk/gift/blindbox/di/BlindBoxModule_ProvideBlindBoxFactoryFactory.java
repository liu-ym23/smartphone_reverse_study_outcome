package com.bytedance.android.livesdk.gift.blindbox.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ey1.a;
import ey1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class BlindBoxModule_ProvideBlindBoxFactoryFactory implements Factory<h.a> {
    private final b module;

    public h.a get() {
        return provideBlindBoxFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8get() {
        return get();
    }

    public BlindBoxModule_ProvideBlindBoxFactoryFactory(b r1) {
        this.module = r1;
    }

    public static BlindBoxModule_ProvideBlindBoxFactoryFactory create(b r1) {
        return new BlindBoxModule_ProvideBlindBoxFactoryFactory(r1);
    }

    public static h.a provideBlindBoxFactory(b r0) {
        r0.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}
