package com.ss.android.lark.passportc.impl.v2;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserUpdateVisitorImpl_Factory implements Factory<e> {
    private final Provider<l0c.c> userFlowMonitorProvider;

    public e get() {
        return newInstance((l0c.c) this.userFlowMonitorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m710get() {
        return get();
    }

    public UserUpdateVisitorImpl_Factory(Provider<l0c.c> r1) {
        this.userFlowMonitorProvider = r1;
    }

    public static UserUpdateVisitorImpl_Factory create(Provider<l0c.c> r1) {
        return new UserUpdateVisitorImpl_Factory(r1);
    }

    public static e newInstance(l0c.c r1) {
        return new e(r1);
    }
}
