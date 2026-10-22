package com.bytedance.android.livesdk.gift.vs.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.f;
import z12.a;
import z12.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class VSModule_ProviderVSGiftDialogFactory implements Factory<f> {
    private final c module;

    public f get() {
        return providerVSGiftDialog(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m375get() {
        return get();
    }

    public VSModule_ProviderVSGiftDialogFactory(c r1) {
        this.module = r1;
    }

    public static VSModule_ProviderVSGiftDialogFactory create(c r1) {
        return new VSModule_ProviderVSGiftDialogFactory(r1);
    }

    public static f providerVSGiftDialog(c r0) {
        r0.getClass();
        return (f) Preconditions.checkNotNullFromProvides(new a());
    }
}
