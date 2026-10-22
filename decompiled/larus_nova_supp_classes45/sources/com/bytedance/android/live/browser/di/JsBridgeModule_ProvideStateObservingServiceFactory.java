package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.state.StateObservingService;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import s20.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class JsBridgeModule_ProvideStateObservingServiceFactory implements Factory<StateObservingService> {
    private final Provider<Gson> gsonProvider;
    private final f module;

    public StateObservingService get() {
        return provideStateObservingService(this.module, (Gson) this.gsonProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m482get() {
        return get();
    }

    public JsBridgeModule_ProvideStateObservingServiceFactory(f r1, Provider<Gson> r2) {
        this.module = r1;
        this.gsonProvider = r2;
    }

    public static JsBridgeModule_ProvideStateObservingServiceFactory create(f r1, Provider<Gson> r2) {
        return new JsBridgeModule_ProvideStateObservingServiceFactory(r1, r2);
    }

    public static StateObservingService provideStateObservingService(f r0, Gson r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "gson");
        return (StateObservingService) Preconditions.checkNotNullFromProvides(new StateObservingService(r1));
    }
}
