package com.bytedance.android.live.saas.middleware.baselib;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BaseLibProxy_MembersInjector implements MembersInjector<BaseLibProxy> {
    private final Provider<Map<FuncType, BaseFunction<Object, BaseLibConfig>>> mFunctionMapProvider;

    public BaseLibProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<Object, BaseLibConfig>>> r1) {
        this.mFunctionMapProvider = r1;
    }

    public static MembersInjector<BaseLibProxy> create(Provider<Map<FuncType, BaseFunction<Object, BaseLibConfig>>> r1) {
        return new BaseLibProxy_MembersInjector(r1);
    }

    public void injectMembers(BaseLibProxy r2) {
        injectMFunctionMap(r2, (Map) this.mFunctionMapProvider.get());
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object r1) {
        injectMembers((BaseLibProxy) r1);
    }

    @Named("baselib")
    public static void injectMFunctionMap(BaseLibProxy r0, Map<FuncType, BaseFunction<Object, BaseLibConfig>> r1) {
        r0.mFunctionMap = r1;
    }
}
