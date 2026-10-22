package com.ss.android.lark.dynamicconfig.v2.impl.service;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;
import lcb.f;
import mcb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UserDomainConfigService_Factory implements Factory<f> {
    private final Provider<b> globalDomainDispatcherProvider;
    private final Provider<b> mGlobalDomainDispatcherProvider;
    private final Provider<j> mPassportGlobalServiceProvider;
    private final Provider<String> mUidProvider;
    private final Provider<j> passportGlobalServiceProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public f m1144get() {
        f r0 = newInstance((j) this.passportGlobalServiceProvider.get(), (b) this.globalDomainDispatcherProvider.get());
        r0.a = (String) this.mUidProvider.get();
        r0.b = (b) this.mGlobalDomainDispatcherProvider.get();
        r0.c = (j) this.mPassportGlobalServiceProvider.get();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1144get();
    }

    public static f newInstance(j r1, b r2) {
        return new f(r1, r2);
    }

    public UserDomainConfigService_Factory(Provider<j> r1, Provider<b> r2, Provider<String> r3, Provider<b> r4, Provider<j> r5) {
        this.passportGlobalServiceProvider = r1;
        this.globalDomainDispatcherProvider = r2;
        this.mUidProvider = r3;
        this.mGlobalDomainDispatcherProvider = r4;
        this.mPassportGlobalServiceProvider = r5;
    }

    public static UserDomainConfigService_Factory create(Provider<j> r7, Provider<b> r8, Provider<String> r9, Provider<b> r10, Provider<j> r11) {
        return new UserDomainConfigService_Factory(r7, r8, r9, r10, r11);
    }
}
