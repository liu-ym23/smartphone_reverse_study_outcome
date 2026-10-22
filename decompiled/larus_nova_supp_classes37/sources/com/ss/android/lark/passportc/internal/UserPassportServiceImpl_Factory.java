package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserPassportServiceImpl_Factory implements Factory<UserPassportServiceImpl> {
    private final Provider<com.ss.android.lark.log.c> loggerProvider;
    private final Provider<t> passportExecutorsProvider;
    private final Provider<f0> userDelegateProvider;
    private final Provider<l0c.c> userFlowMonitorProvider;

    public UserPassportServiceImpl get() {
        return newInstance((f0) this.userDelegateProvider.get(), (com.ss.android.lark.log.c) this.loggerProvider.get(), (t) this.passportExecutorsProvider.get(), (l0c.c) this.userFlowMonitorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m748get() {
        return get();
    }

    public UserPassportServiceImpl_Factory(Provider<f0> r1, Provider<com.ss.android.lark.log.c> r2, Provider<t> r3, Provider<l0c.c> r4) {
        this.userDelegateProvider = r1;
        this.loggerProvider = r2;
        this.passportExecutorsProvider = r3;
        this.userFlowMonitorProvider = r4;
    }

    public static UserPassportServiceImpl_Factory create(Provider<f0> r1, Provider<com.ss.android.lark.log.c> r2, Provider<t> r3, Provider<l0c.c> r4) {
        return new UserPassportServiceImpl_Factory(r1, r2, r3, r4);
    }

    public static UserPassportServiceImpl newInstance(f0 r1, com.ss.android.lark.log.c r2, t r3, l0c.c r4) {
        return new UserPassportServiceImpl(r1, r2, r3, r4);
    }
}
