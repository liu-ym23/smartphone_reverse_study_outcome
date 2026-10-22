package com.bytedance.android.live.broadcastgame.di;

import com.bytedance.android.live.broadcastgame.f0;
import dagger.internal.Factory;
import i10.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenPlatformModuleFallback_ProvideOpenPlatformServiceFactory implements Factory<f0> {
    private final g module;

    public f0 get() {
        return provideOpenPlatformService(null);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m155get() {
        return get();
    }

    public OpenPlatformModuleFallback_ProvideOpenPlatformServiceFactory(g r1) {
    }

    public static OpenPlatformModuleFallback_ProvideOpenPlatformServiceFactory create(g r1) {
        return new OpenPlatformModuleFallback_ProvideOpenPlatformServiceFactory(r1);
    }

    public static f0 provideOpenPlatformService(g r0) {
        throw null;
    }
}
