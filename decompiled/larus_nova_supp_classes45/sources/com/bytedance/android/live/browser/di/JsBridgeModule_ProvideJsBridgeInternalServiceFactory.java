package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.JsBridgeService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import s20.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class JsBridgeModule_ProvideJsBridgeInternalServiceFactory implements Factory<JsBridgeService> {
    private final f module;

    public JsBridgeService get() {
        return provideJsBridgeInternalService(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m477get() {
        return get();
    }

    public JsBridgeModule_ProvideJsBridgeInternalServiceFactory(f r1) {
        this.module = r1;
    }

    public static JsBridgeModule_ProvideJsBridgeInternalServiceFactory create(f r1) {
        return new JsBridgeModule_ProvideJsBridgeInternalServiceFactory(r1);
    }

    public static JsBridgeService provideJsBridgeInternalService(f r0) {
        r0.getClass();
        return (JsBridgeService) Preconditions.checkNotNullFromProvides(new JsBridgeService());
    }
}
