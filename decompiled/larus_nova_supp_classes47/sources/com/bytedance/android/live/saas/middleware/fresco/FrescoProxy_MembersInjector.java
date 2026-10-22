package com.bytedance.android.live.saas.middleware.fresco;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FrescoProxy_MembersInjector implements MembersInjector<FrescoProxy> {
    private final Provider<Map<FuncType, BaseFunction<Object, FrescoConfig>>> mFunctionMapProvider;

    public FrescoProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<Object, FrescoConfig>>> r1) {
        this.mFunctionMapProvider = r1;
    }

    public static MembersInjector<FrescoProxy> create(Provider<Map<FuncType, BaseFunction<Object, FrescoConfig>>> r1) {
        return new FrescoProxy_MembersInjector(r1);
    }

    public void injectMembers(FrescoProxy r2) {
        injectMFunctionMap(r2, (Map) this.mFunctionMapProvider.get());
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object r1) {
        injectMembers((FrescoProxy) r1);
    }

    @Named("fresco")
    public static void injectMFunctionMap(FrescoProxy r0, Map<FuncType, BaseFunction<Object, FrescoConfig>> r1) {
        r0.mFunctionMap = r1;
    }
}
