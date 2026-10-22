package com.ss.android.lark.passport_user.impl;

import a0c.b;
import dagger.internal.Factory;
import izb.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class LarkUserService_Factory implements Factory<b> {
    private final Provider<a> environmentDependencyProvider;
    private final Provider<kzb.b> globalEnvironmentServiceProvider;
    private final Provider<yzb.b> larkUserListServiceProvider;
    private final Provider<String> uidProvider;

    public b get() {
        return newInstance((String) this.uidProvider.get(), (yzb.b) this.larkUserListServiceProvider.get(), (kzb.b) this.globalEnvironmentServiceProvider.get(), (a) this.environmentDependencyProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m688get() {
        return get();
    }

    public LarkUserService_Factory(Provider<String> r1, Provider<yzb.b> r2, Provider<kzb.b> r3, Provider<a> r4) {
        this.uidProvider = r1;
        this.larkUserListServiceProvider = r2;
        this.globalEnvironmentServiceProvider = r3;
        this.environmentDependencyProvider = r4;
    }

    public static LarkUserService_Factory create(Provider<String> r1, Provider<yzb.b> r2, Provider<kzb.b> r3, Provider<a> r4) {
        return new LarkUserService_Factory(r1, r2, r3, r4);
    }

    public static b newInstance(String r1, yzb.b r2, kzb.b r3, a r4) {
        return new b(r1, r2, r3, r4);
    }
}
