package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GlobalPassportServiceImpl_Factory implements Factory<GlobalPassportServiceImpl> {
    private final Provider<t> executorsProvider;
    private final Provider<com.ss.android.lark.log.c> loggerProvider;
    private final Provider<com.ss.android.lark.passportc.api.e> passportProvider;
    private final Provider<Set<com.ss.android.lark.passportc.api.p>> staticConventionsProvider;
    private final Provider<l0c.c> userFlowMonitorProvider;

    public GlobalPassportServiceImpl get() {
        return newInstance(this.passportProvider, (com.ss.android.lark.log.c) this.loggerProvider.get(), (t) this.executorsProvider.get(), (l0c.c) this.userFlowMonitorProvider.get(), this.staticConventionsProvider);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m731get() {
        return get();
    }

    public GlobalPassportServiceImpl_Factory(Provider<com.ss.android.lark.passportc.api.e> r1, Provider<com.ss.android.lark.log.c> r2, Provider<t> r3, Provider<l0c.c> r4, Provider<Set<com.ss.android.lark.passportc.api.p>> r5) {
        this.passportProvider = r1;
        this.loggerProvider = r2;
        this.executorsProvider = r3;
        this.userFlowMonitorProvider = r4;
        this.staticConventionsProvider = r5;
    }

    public static GlobalPassportServiceImpl_Factory create(Provider<com.ss.android.lark.passportc.api.e> r7, Provider<com.ss.android.lark.log.c> r8, Provider<t> r9, Provider<l0c.c> r10, Provider<Set<com.ss.android.lark.passportc.api.p>> r11) {
        return new GlobalPassportServiceImpl_Factory(r7, r8, r9, r10, r11);
    }

    public static GlobalPassportServiceImpl newInstance(Provider<com.ss.android.lark.passportc.api.e> r7, com.ss.android.lark.log.c r8, t r9, l0c.c r10, Provider<Set<com.ss.android.lark.passportc.api.p>> r11) {
        return new GlobalPassportServiceImpl(r7, r8, r9, r10, r11);
    }
}
