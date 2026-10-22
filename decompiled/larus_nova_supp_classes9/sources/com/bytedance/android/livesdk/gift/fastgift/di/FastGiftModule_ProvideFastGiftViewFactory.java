package com.bytedance.android.livesdk.gift.fastgift.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class FastGiftModule_ProvideFastGiftViewFactory implements Factory<h> {
    private final e module;

    public h get() {
        return provideFastGiftView(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m23get() {
        return get();
    }

    public FastGiftModule_ProvideFastGiftViewFactory(e r1) {
        this.module = r1;
    }

    public static FastGiftModule_ProvideFastGiftViewFactory create(e r1) {
        return new FastGiftModule_ProvideFastGiftViewFactory(r1);
    }

    public static h provideFastGiftView(e r0) {
        r0.getClass();
        return (h) Preconditions.checkNotNullFromProvides(new d());
    }
}
