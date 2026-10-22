package com.ss.android.lark.dynamicconfig.v2.impl.service;

import android.app.Application;
import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;
import lcb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GlobalDomainConfigService_Factory implements Factory<d> {
    private final Provider<Application> appProvider;
    private final Provider<j> mPassportGlobalServiceProvider;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public d m1143get() {
        d r0 = newInstance((j) this.passportProvider.get());
        r0.c = (j) this.mPassportGlobalServiceProvider.get();
        Application r1 = (Application) this.appProvider.get();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1143get();
    }

    public static d newInstance(j r1) {
        return new d(r1);
    }

    public GlobalDomainConfigService_Factory(Provider<j> r1, Provider<j> r2, Provider<Application> r3) {
        this.passportProvider = r1;
        this.mPassportGlobalServiceProvider = r2;
        this.appProvider = r3;
    }

    public static GlobalDomainConfigService_Factory create(Provider<j> r1, Provider<j> r2, Provider<Application> r3) {
        return new GlobalDomainConfigService_Factory(r1, r2, r3);
    }
}
