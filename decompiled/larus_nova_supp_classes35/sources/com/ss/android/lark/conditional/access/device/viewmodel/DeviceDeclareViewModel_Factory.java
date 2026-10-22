package com.ss.android.lark.conditional.access.device.viewmodel;

import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DeviceDeclareViewModel_Factory implements Factory<DeviceDeclareViewModel> {
    private final Provider<g> fgServiceProvider;
    private final Provider<ConditionalAccessNetDependency> networkDependencyProvider;

    public DeviceDeclareViewModel get() {
        DeviceDeclareViewModel r0 = newInstance((g) this.fgServiceProvider.get());
        r0.networkDependency = (ConditionalAccessNetDependency) this.networkDependencyProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m964get() {
        return get();
    }

    public static DeviceDeclareViewModel newInstance(g r1) {
        return new DeviceDeclareViewModel(r1);
    }

    public DeviceDeclareViewModel_Factory(Provider<g> r1, Provider<ConditionalAccessNetDependency> r2) {
        this.fgServiceProvider = r1;
        this.networkDependencyProvider = r2;
    }

    public static DeviceDeclareViewModel_Factory create(Provider<g> r1, Provider<ConditionalAccessNetDependency> r2) {
        return new DeviceDeclareViewModel_Factory(r1, r2);
    }
}
