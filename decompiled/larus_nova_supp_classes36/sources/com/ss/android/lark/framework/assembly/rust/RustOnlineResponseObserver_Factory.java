package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RustOnlineResponseObserver_Factory implements Factory<x> {
    private final Provider<l0c.c> userFlowMonitorProvider;

    public x get() {
        return newInstance((l0c.c) this.userFlowMonitorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m688get() {
        return get();
    }

    public RustOnlineResponseObserver_Factory(Provider<l0c.c> r1) {
        this.userFlowMonitorProvider = r1;
    }

    public static RustOnlineResponseObserver_Factory create(Provider<l0c.c> r1) {
        return new RustOnlineResponseObserver_Factory(r1);
    }

    public static x newInstance(l0c.c r1) {
        return new x(r1);
    }
}
