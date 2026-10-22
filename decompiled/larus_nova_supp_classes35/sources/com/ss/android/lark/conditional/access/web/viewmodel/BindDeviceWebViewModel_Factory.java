package com.ss.android.lark.conditional.access.web.viewmodel;

import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class BindDeviceWebViewModel_Factory implements Factory<BindDeviceWebViewModel> {
    private final Provider<ConditionalAccessNetDependency> networkDependencyProvider;

    public static BindDeviceWebViewModel newInstance() {
        return new BindDeviceWebViewModel();
    }

    public BindDeviceWebViewModel get() {
        BindDeviceWebViewModel r0 = newInstance();
        r0.networkDependency = (ConditionalAccessNetDependency) this.networkDependencyProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1005get() {
        return get();
    }

    public BindDeviceWebViewModel_Factory(Provider<ConditionalAccessNetDependency> r1) {
        this.networkDependencyProvider = r1;
    }

    public static BindDeviceWebViewModel_Factory create(Provider<ConditionalAccessNetDependency> r1) {
        return new BindDeviceWebViewModel_Factory(r1);
    }
}
