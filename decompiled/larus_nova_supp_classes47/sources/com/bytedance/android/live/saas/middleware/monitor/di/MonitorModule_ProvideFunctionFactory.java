package com.bytedance.android.live.saas.middleware.monitor.di;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.monitor.IMonitorReport;
import com.bytedance.android.live.saas.middleware.monitor.MonitorConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MonitorModule_ProvideFunctionFactory implements Factory<BaseFunction<IMonitorReport, MonitorConfig>> {
    private final MonitorModule module;

    public BaseFunction<IMonitorReport, MonitorConfig> get() {
        return provideFunction(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1124get() {
        return get();
    }

    public MonitorModule_ProvideFunctionFactory(MonitorModule r1) {
        this.module = r1;
    }

    public static MonitorModule_ProvideFunctionFactory create(MonitorModule r1) {
        return new MonitorModule_ProvideFunctionFactory(r1);
    }

    public static BaseFunction<IMonitorReport, MonitorConfig> provideFunction(MonitorModule r0) {
        return (BaseFunction) Preconditions.checkNotNullFromProvides(r0.provideFunction());
    }
}
