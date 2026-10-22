package com.bytedance.android.live.saas.middleware.monitor;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MonitorProxy_MembersInjector implements MembersInjector<MonitorProxy> {
    private final Provider<Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>>> mFunctionMapProvider;

    public MonitorProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>>> r1) {
        this.mFunctionMapProvider = r1;
    }

    public static MembersInjector<MonitorProxy> create(Provider<Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>>> r1) {
        return new MonitorProxy_MembersInjector(r1);
    }

    public void injectMembers(MonitorProxy r2) {
        injectMFunctionMap(r2, (Map) this.mFunctionMapProvider.get());
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object r1) {
        injectMembers((MonitorProxy) r1);
    }

    @Named("monitor")
    public static void injectMFunctionMap(MonitorProxy r0, Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>> r1) {
        r0.mFunctionMap = r1;
    }
}
