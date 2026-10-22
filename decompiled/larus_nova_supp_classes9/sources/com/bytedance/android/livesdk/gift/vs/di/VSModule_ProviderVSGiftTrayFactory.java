package com.bytedance.android.livesdk.gift.vs.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.g;
import z12.b;
import z12.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class VSModule_ProviderVSGiftTrayFactory implements Factory<g> {
    private final c module;

    public g get() {
        return providerVSGiftTray(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m376get() {
        return get();
    }

    public VSModule_ProviderVSGiftTrayFactory(c r1) {
        this.module = r1;
    }

    public static VSModule_ProviderVSGiftTrayFactory create(c r1) {
        return new VSModule_ProviderVSGiftTrayFactory(r1);
    }

    public static g providerVSGiftTray(c r0) {
        r0.getClass();
        return (g) Preconditions.checkNotNullFromProvides(new b());
    }
}
