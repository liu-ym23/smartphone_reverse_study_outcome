package com.bytedance.android.live.saas.middleware.baselib.di;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.baselib.BaseLibConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BaseLibModule_ProvideFunctionFactory implements Factory<BaseFunction<Object, BaseLibConfig>> {
    private final BaseLibModule module;

    public BaseFunction<Object, BaseLibConfig> get() {
        return provideFunction(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1119get() {
        return get();
    }

    public BaseLibModule_ProvideFunctionFactory(BaseLibModule r1) {
        this.module = r1;
    }

    public static BaseLibModule_ProvideFunctionFactory create(BaseLibModule r1) {
        return new BaseLibModule_ProvideFunctionFactory(r1);
    }

    public static BaseFunction<Object, BaseLibConfig> provideFunction(BaseLibModule r0) {
        return (BaseFunction) Preconditions.checkNotNullFromProvides(r0.provideFunction());
    }
}
