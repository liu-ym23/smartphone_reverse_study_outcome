package com.bytedance.android.live.saas.middleware.applog.di;

import com.bytedance.android.live.saas.middleware.applog.AppLogConfig;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AppLogModule_ProvideFunctionFactory implements Factory<BaseFunction<IAppLog, AppLogConfig>> {
    private final AppLogModule module;

    public BaseFunction<IAppLog, AppLogConfig> get() {
        return provideFunction(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1118get() {
        return get();
    }

    public AppLogModule_ProvideFunctionFactory(AppLogModule r1) {
        this.module = r1;
    }

    public static AppLogModule_ProvideFunctionFactory create(AppLogModule r1) {
        return new AppLogModule_ProvideFunctionFactory(r1);
    }

    public static BaseFunction<IAppLog, AppLogConfig> provideFunction(AppLogModule r0) {
        return (BaseFunction) Preconditions.checkNotNullFromProvides(r0.provideFunction());
    }
}
