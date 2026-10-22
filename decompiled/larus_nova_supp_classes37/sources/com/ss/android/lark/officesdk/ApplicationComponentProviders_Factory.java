package com.ss.android.lark.officesdk;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ApplicationComponentProviders_Factory implements Factory<a> {
    private final Provider<Application> applicationProvider;

    public a get() {
        return newInstance((Application) this.applicationProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m0get() {
        return get();
    }

    public ApplicationComponentProviders_Factory(Provider<Application> r1) {
        this.applicationProvider = r1;
    }

    public static ApplicationComponentProviders_Factory create(Provider<Application> r1) {
        return new ApplicationComponentProviders_Factory(r1);
    }

    public static a newInstance(Application r1) {
        return new a(r1);
    }
}
