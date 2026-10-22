package com.bytedance.android.live.broadcastgame.opengame.di;

import com.bytedance.android.live.broadcastgame.f0;
import com.bytedance.android.live.broadcastgame.opengame.s;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import p10.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenPlatformModule_ProvideOpenPlatformServiceFactory implements Factory<f0> {
    private final a module;

    public f0 get() {
        return provideOpenPlatformService(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m207get() {
        return get();
    }

    public OpenPlatformModule_ProvideOpenPlatformServiceFactory(a r1) {
        this.module = r1;
    }

    public static OpenPlatformModule_ProvideOpenPlatformServiceFactory create(a r1) {
        return new OpenPlatformModule_ProvideOpenPlatformServiceFactory(r1);
    }

    public static f0 provideOpenPlatformService(a r0) {
        r0.getClass();
        return (f0) Preconditions.checkNotNullFromProvides(new s());
    }
}
