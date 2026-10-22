package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.jsbridge.state.StateObservingService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import s20.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class JsBridgeModule_ProvideStateObservingServiceInterfaceFactory implements Factory<i> {
    private final f module;
    private final Provider<StateObservingService> stateObservingServiceProvider;

    public i get() {
        return provideStateObservingServiceInterface(this.module, (StateObservingService) this.stateObservingServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m483get() {
        return get();
    }

    public JsBridgeModule_ProvideStateObservingServiceInterfaceFactory(f r1, Provider<StateObservingService> r2) {
        this.module = r1;
        this.stateObservingServiceProvider = r2;
    }

    public static JsBridgeModule_ProvideStateObservingServiceInterfaceFactory create(f r1, Provider<StateObservingService> r2) {
        return new JsBridgeModule_ProvideStateObservingServiceInterfaceFactory(r1, r2);
    }

    public static i provideStateObservingServiceInterface(f r0, StateObservingService r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "stateObservingService");
        return (i) Preconditions.checkNotNullFromProvides(r1);
    }
}
