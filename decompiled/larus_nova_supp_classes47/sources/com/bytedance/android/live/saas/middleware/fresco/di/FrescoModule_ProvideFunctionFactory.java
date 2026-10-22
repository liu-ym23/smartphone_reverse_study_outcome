package com.bytedance.android.live.saas.middleware.fresco.di;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.fresco.FrescoConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FrescoModule_ProvideFunctionFactory implements Factory<BaseFunction<Object, FrescoConfig>> {
    private final FrescoModule module;

    public BaseFunction<Object, FrescoConfig> get() {
        return provideFunction(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1122get() {
        return get();
    }

    public FrescoModule_ProvideFunctionFactory(FrescoModule r1) {
        this.module = r1;
    }

    public static FrescoModule_ProvideFunctionFactory create(FrescoModule r1) {
        return new FrescoModule_ProvideFunctionFactory(r1);
    }

    public static BaseFunction<Object, FrescoConfig> provideFunction(FrescoModule r0) {
        return (BaseFunction) Preconditions.checkNotNullFromProvides(r0.provideFunction());
    }
}
