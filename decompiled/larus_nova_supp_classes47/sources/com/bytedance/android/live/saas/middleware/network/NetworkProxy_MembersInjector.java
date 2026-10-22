package com.bytedance.android.live.saas.middleware.network;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class NetworkProxy_MembersInjector implements MembersInjector<NetworkProxy> {
    private final Provider<Map<FuncType, BaseFunction<Object, NetworkConfig>>> cornetFunctionProvider;

    public NetworkProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<Object, NetworkConfig>>> r1) {
        this.cornetFunctionProvider = r1;
    }

    public static MembersInjector<NetworkProxy> create(Provider<Map<FuncType, BaseFunction<Object, NetworkConfig>>> r1) {
        return new NetworkProxy_MembersInjector(r1);
    }

    public void injectMembers(NetworkProxy r2) {
        injectCornetFunction(r2, (Map) this.cornetFunctionProvider.get());
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object r1) {
        injectMembers((NetworkProxy) r1);
    }

    @Named("cornet")
    public static void injectCornetFunction(NetworkProxy r0, Map<FuncType, BaseFunction<Object, NetworkConfig>> r1) {
        r0.cornetFunction = r1;
    }
}
