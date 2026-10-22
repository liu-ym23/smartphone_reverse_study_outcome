package com.bytedance.android.live.saas.middleware.applog;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AppLogProxy_MembersInjector implements MembersInjector<AppLogProxy> {
    private final Provider<Map<FuncType, BaseFunction<IAppLog, AppLogConfig>>> mFunctionMapProvider;

    public AppLogProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<IAppLog, AppLogConfig>>> r1) {
        this.mFunctionMapProvider = r1;
    }

    public static MembersInjector<AppLogProxy> create(Provider<Map<FuncType, BaseFunction<IAppLog, AppLogConfig>>> r1) {
        return new AppLogProxy_MembersInjector(r1);
    }

    public void injectMembers(AppLogProxy r2) {
        injectMFunctionMap(r2, (Map) this.mFunctionMapProvider.get());
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object r1) {
        injectMembers((AppLogProxy) r1);
    }

    @Named("applog")
    public static void injectMFunctionMap(AppLogProxy r0, Map<FuncType, BaseFunction<IAppLog, AppLogConfig>> r1) {
        r0.mFunctionMap = r1;
    }
}
