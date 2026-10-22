package com.bytedance.android.live.saas.middleware.npth;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class NpthProxy_MembersInjector implements MembersInjector<NpthProxy> {
    private final Provider<Map<FuncType, BaseFunction<Object, NpthConfig>>> mFunctionMapProvider;

    public NpthProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<Object, NpthConfig>>> r1) {
        this.mFunctionMapProvider = r1;
    }

    public static MembersInjector<NpthProxy> create(Provider<Map<FuncType, BaseFunction<Object, NpthConfig>>> r1) {
        return new NpthProxy_MembersInjector(r1);
    }

    public void injectMembers(NpthProxy r2) {
        injectMFunctionMap(r2, (Map) this.mFunctionMapProvider.get());
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object r1) {
        injectMembers((NpthProxy) r1);
    }

    @Named("npth")
    public static void injectMFunctionMap(NpthProxy r0, Map<FuncType, BaseFunction<Object, NpthConfig>> r1) {
        r0.mFunctionMap = r1;
    }
}
