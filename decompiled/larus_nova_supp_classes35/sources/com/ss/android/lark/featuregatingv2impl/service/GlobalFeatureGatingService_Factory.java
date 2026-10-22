package com.ss.android.lark.featuregatingv2impl.service;

import android.app.Application;
import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.f;
import ldb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GlobalFeatureGatingService_Factory implements Factory<c> {
    private final Provider<Application> appProvider;
    private final Provider<j> globalServiceProvider;
    private final Provider<j> mPassportGlobalServiceProvider;
    private final Provider<f> mockFgProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m1163get() {
        c r0 = newInstance((j) this.globalServiceProvider.get(), (f) this.mockFgProvider.get());
        r0.p = (j) this.mPassportGlobalServiceProvider.get();
        r0.q = (Application) this.appProvider.get();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1163get();
    }

    public static c newInstance(j r1, f r2) {
        return new c(r1, r2);
    }

    public GlobalFeatureGatingService_Factory(Provider<j> r1, Provider<f> r2, Provider<j> r3, Provider<Application> r4) {
        this.globalServiceProvider = r1;
        this.mockFgProvider = r2;
        this.mPassportGlobalServiceProvider = r3;
        this.appProvider = r4;
    }

    public static GlobalFeatureGatingService_Factory create(Provider<j> r1, Provider<f> r2, Provider<j> r3, Provider<Application> r4) {
        return new GlobalFeatureGatingService_Factory(r1, r2, r3, r4);
    }
}
