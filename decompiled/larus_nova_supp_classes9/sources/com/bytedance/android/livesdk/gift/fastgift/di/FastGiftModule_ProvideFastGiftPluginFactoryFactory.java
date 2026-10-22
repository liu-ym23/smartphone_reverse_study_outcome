package com.bytedance.android.livesdk.gift.fastgift.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class FastGiftModule_ProvideFastGiftPluginFactoryFactory implements Factory<h.a> {
    private final e module;

    public h.a get() {
        return provideFastGiftPluginFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m22get() {
        return get();
    }

    public FastGiftModule_ProvideFastGiftPluginFactoryFactory(e r1) {
        this.module = r1;
    }

    public static FastGiftModule_ProvideFastGiftPluginFactoryFactory create(e r1) {
        return new FastGiftModule_ProvideFastGiftPluginFactoryFactory(r1);
    }

    public static h.a provideFastGiftPluginFactory(e r0) {
        r0.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new c());
    }
}
