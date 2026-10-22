package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserComponentManagerImpl_Factory implements Factory<UserComponentManagerImpl> {
    private final Provider<b0> componentProvidersProvider;
    private final Provider<com.ss.android.lark.log.c> loggerProvider;

    public UserComponentManagerImpl get() {
        return newInstance((b0) this.componentProvidersProvider.get(), (com.ss.android.lark.log.c) this.loggerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m742get() {
        return get();
    }

    public UserComponentManagerImpl_Factory(Provider<b0> r1, Provider<com.ss.android.lark.log.c> r2) {
        this.componentProvidersProvider = r1;
        this.loggerProvider = r2;
    }

    public static UserComponentManagerImpl_Factory create(Provider<b0> r1, Provider<com.ss.android.lark.log.c> r2) {
        return new UserComponentManagerImpl_Factory(r1, r2);
    }

    public static UserComponentManagerImpl newInstance(b0 r1, com.ss.android.lark.log.c r2) {
        return new UserComponentManagerImpl(r1, r2);
    }
}
