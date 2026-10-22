package com.ss.android.lark.lark_env;

import dagger.internal.Factory;
import fpb.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class GlobalEnvironmentServiceImpl_Factory implements Factory<a> {
    private final Provider<izb.a> environmentDependencyProvider;

    public a get() {
        return newInstance((izb.a) this.environmentDependencyProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1386get() {
        return get();
    }

    public GlobalEnvironmentServiceImpl_Factory(Provider<izb.a> r1) {
        this.environmentDependencyProvider = r1;
    }

    public static GlobalEnvironmentServiceImpl_Factory create(Provider<izb.a> r1) {
        return new GlobalEnvironmentServiceImpl_Factory(r1);
    }

    public static a newInstance(izb.a r1) {
        return new a(r1);
    }
}
