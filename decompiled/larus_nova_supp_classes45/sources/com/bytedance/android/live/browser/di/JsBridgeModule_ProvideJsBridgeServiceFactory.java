package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.JsBridgeService;
import com.bytedance.android.live.browser.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import s20.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class JsBridgeModule_ProvideJsBridgeServiceFactory implements Factory<v> {
    private final f module;
    private final Provider<JsBridgeService> serviceProvider;

    public v get() {
        return provideJsBridgeService(this.module, (JsBridgeService) this.serviceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m478get() {
        return get();
    }

    public JsBridgeModule_ProvideJsBridgeServiceFactory(f r1, Provider<JsBridgeService> r2) {
        this.module = r1;
        this.serviceProvider = r2;
    }

    public static JsBridgeModule_ProvideJsBridgeServiceFactory create(f r1, Provider<JsBridgeService> r2) {
        return new JsBridgeModule_ProvideJsBridgeServiceFactory(r1, r2);
    }

    public static v provideJsBridgeService(f r0, JsBridgeService r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "service");
        return (v) Preconditions.checkNotNullFromProvides(r1);
    }
}
