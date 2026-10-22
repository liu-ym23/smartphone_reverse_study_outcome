package com.bytedance.android.livesdk.gift.multiplayer.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.e;
import hz1.a;
import hz1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MultiPlayerModule_ProviderMultiPlayerClassFactory implements Factory<e> {
    private final b module;

    public e get() {
        return providerMultiPlayerClass(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m44get() {
        return get();
    }

    public MultiPlayerModule_ProviderMultiPlayerClassFactory(b r1) {
        this.module = r1;
    }

    public static MultiPlayerModule_ProviderMultiPlayerClassFactory create(b r1) {
        return new MultiPlayerModule_ProviderMultiPlayerClassFactory(r1);
    }

    public static e providerMultiPlayerClass(b r0) {
        r0.getClass();
        return (e) Preconditions.checkNotNullFromProvides(new a());
    }
}
