package com.bytedance.android.live.saas.middleware.network.di;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.network.NetworkConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class CornetModule_ProvideFunctionFactory implements Factory<BaseFunction<Object, NetworkConfig>> {
    private final CornetModule module;

    public BaseFunction<Object, NetworkConfig> get() {
        return provideFunction(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1125get() {
        return get();
    }

    public CornetModule_ProvideFunctionFactory(CornetModule r1) {
        this.module = r1;
    }

    public static CornetModule_ProvideFunctionFactory create(CornetModule r1) {
        return new CornetModule_ProvideFunctionFactory(r1);
    }

    public static BaseFunction<Object, NetworkConfig> provideFunction(CornetModule r0) {
        return (BaseFunction) Preconditions.checkNotNullFromProvides(r0.provideFunction());
    }
}
