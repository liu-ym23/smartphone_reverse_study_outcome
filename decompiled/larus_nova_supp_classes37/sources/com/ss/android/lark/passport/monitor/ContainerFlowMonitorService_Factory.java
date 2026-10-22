package com.ss.android.lark.passport.monitor;

import dagger.internal.Factory;
import javax.inject.Provider;
import zyb.a;
import zyb.d;
import zyb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ContainerFlowMonitorService_Factory implements Factory<a> {
    private final Provider<d> enterAppFlowMonitorServiceProvider;
    private final Provider<e> switchMonitorServiceProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m681get() {
        return newInstance((d) this.enterAppFlowMonitorServiceProvider.get(), (e) this.switchMonitorServiceProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m681get();
    }

    public ContainerFlowMonitorService_Factory(Provider<d> r1, Provider<e> r2) {
        this.enterAppFlowMonitorServiceProvider = r1;
        this.switchMonitorServiceProvider = r2;
    }

    public static ContainerFlowMonitorService_Factory create(Provider<d> r1, Provider<e> r2) {
        return new ContainerFlowMonitorService_Factory(r1, r2);
    }

    public static a newInstance(d r1, e r2) {
        return new a(r1, r2);
    }
}
