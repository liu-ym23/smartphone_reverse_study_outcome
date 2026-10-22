package com.bytedance.android.live.broadcastgame.opengame.di;

import com.bytedance.android.live.broadcastgame.e0;
import com.bytedance.android.live.broadcastgame.opengame.performance.OpenPlatformPerfDog;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import p10.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenPlatformModule_ProvideOpenPlatformPerfDogFactory implements Factory<e0> {
    private final a module;

    public e0 get() {
        return provideOpenPlatformPerfDog(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m206get() {
        return get();
    }

    public OpenPlatformModule_ProvideOpenPlatformPerfDogFactory(a r1) {
        this.module = r1;
    }

    public static OpenPlatformModule_ProvideOpenPlatformPerfDogFactory create(a r1) {
        return new OpenPlatformModule_ProvideOpenPlatformPerfDogFactory(r1);
    }

    public static e0 provideOpenPlatformPerfDog(a r0) {
        r0.getClass();
        return (e0) Preconditions.checkNotNullFromProvides(OpenPlatformPerfDog.p);
    }
}
