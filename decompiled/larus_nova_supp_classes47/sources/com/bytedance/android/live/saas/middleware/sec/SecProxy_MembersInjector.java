package com.bytedance.android.live.saas.middleware.sec;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SecProxy_MembersInjector implements MembersInjector<SecProxy> {
    private final Provider<Map<FuncType, BaseFunction<ISecSdk, SecConfig>>> taskMapProvider;

    public SecProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<ISecSdk, SecConfig>>> r1) {
        this.taskMapProvider = r1;
    }

    public static MembersInjector<SecProxy> create(Provider<Map<FuncType, BaseFunction<ISecSdk, SecConfig>>> r1) {
        return new SecProxy_MembersInjector(r1);
    }

    public void injectMembers(SecProxy r2) {
        injectTaskMap(r2, (Map) this.taskMapProvider.get());
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object r1) {
        injectMembers((SecProxy) r1);
    }

    @Named("sec")
    public static void injectTaskMap(SecProxy r0, Map<FuncType, BaseFunction<ISecSdk, SecConfig>> r1) {
        r0.taskMap = r1;
    }
}
