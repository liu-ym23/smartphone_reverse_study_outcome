package com.bytedance.android.live.saas.middleware.npth.di;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.npth.NpthConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class NpthModule_ProvideFunctionFactory implements Factory<BaseFunction<Object, NpthConfig>> {
    private final NpthModule module;

    public BaseFunction<Object, NpthConfig> get() {
        return provideFunction(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1126get() {
        return get();
    }

    public NpthModule_ProvideFunctionFactory(NpthModule r1) {
        this.module = r1;
    }

    public static NpthModule_ProvideFunctionFactory create(NpthModule r1) {
        return new NpthModule_ProvideFunctionFactory(r1);
    }

    public static BaseFunction<Object, NpthConfig> provideFunction(NpthModule r0) {
        return (BaseFunction) Preconditions.checkNotNullFromProvides(r0.provideFunction());
    }
}
