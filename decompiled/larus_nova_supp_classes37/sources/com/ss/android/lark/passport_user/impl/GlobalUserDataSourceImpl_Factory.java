package com.ss.android.lark.passport_user.impl;

import a0c.a;
import dagger.internal.Factory;
import javax.inject.Provider;
import yzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GlobalUserDataSourceImpl_Factory implements Factory<a> {
    private final Provider<b> userListApiProvider;

    public a get() {
        return newInstance((b) this.userListApiProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m687get() {
        return get();
    }

    public GlobalUserDataSourceImpl_Factory(Provider<b> r1) {
        this.userListApiProvider = r1;
    }

    public static GlobalUserDataSourceImpl_Factory create(Provider<b> r1) {
        return new GlobalUserDataSourceImpl_Factory(r1);
    }

    public static a newInstance(b r1) {
        return new a(r1);
    }
}
