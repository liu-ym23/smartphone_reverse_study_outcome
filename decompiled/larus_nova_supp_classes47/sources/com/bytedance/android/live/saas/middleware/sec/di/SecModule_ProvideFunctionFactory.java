package com.bytedance.android.live.saas.middleware.sec.di;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.sec.ISecSdk;
import com.bytedance.android.live.saas.middleware.sec.SecConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SecModule_ProvideFunctionFactory implements Factory<BaseFunction<ISecSdk, SecConfig>> {
    private final SecModule module;

    public BaseFunction<ISecSdk, SecConfig> get() {
        return provideFunction(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1127get() {
        return get();
    }

    public SecModule_ProvideFunctionFactory(SecModule r1) {
        this.module = r1;
    }

    public static SecModule_ProvideFunctionFactory create(SecModule r1) {
        return new SecModule_ProvideFunctionFactory(r1);
    }

    public static BaseFunction<ISecSdk, SecConfig> provideFunction(SecModule r0) {
        return (BaseFunction) Preconditions.checkNotNullFromProvides(r0.provideFunction());
    }
}
