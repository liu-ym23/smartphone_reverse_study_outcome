package com.ss.android.lark.passportc.task.monitor;

import dagger.internal.Factory;
import javax.inject.Provider;
import l0c.e;
import zyb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PassportUserFlowMonitorImpl_Factory implements Factory<e> {
    private final Provider<c> monitorServiceProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public e m755get() {
        return newInstance((c) this.monitorServiceProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m755get();
    }

    public PassportUserFlowMonitorImpl_Factory(Provider<c> r1) {
        this.monitorServiceProvider = r1;
    }

    public static PassportUserFlowMonitorImpl_Factory create(Provider<c> r1) {
        return new PassportUserFlowMonitorImpl_Factory(r1);
    }

    public static e newInstance(c r1) {
        return new e(r1);
    }
}
