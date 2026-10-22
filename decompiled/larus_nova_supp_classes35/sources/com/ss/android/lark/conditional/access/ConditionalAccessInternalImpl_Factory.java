package com.ss.android.lark.conditional.access;

import com.ss.android.lark.conditional.access.nopermission.manager.NoPermissionModuleManager;
import dagger.internal.Factory;
import g8b.a;
import javax.inject.Provider;
import k8b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ConditionalAccessInternalImpl_Factory implements Factory<a> {
    private final Provider<c> dependencyProvider;
    private final Provider<com.ss.android.lark.conditional.access.traffic.a> networkTrafficPushProvider;
    private final Provider<NoPermissionModuleManager> noPermissionModuleManagerProvider;

    public a get() {
        a r0 = newInstance((NoPermissionModuleManager) this.noPermissionModuleManagerProvider.get(), (com.ss.android.lark.conditional.access.traffic.a) this.networkTrafficPushProvider.get());
        r0.c = (c) this.dependencyProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m946get() {
        return get();
    }

    public static a newInstance(NoPermissionModuleManager r1, com.ss.android.lark.conditional.access.traffic.a r2) {
        return new a(r1, r2);
    }

    public ConditionalAccessInternalImpl_Factory(Provider<NoPermissionModuleManager> r1, Provider<com.ss.android.lark.conditional.access.traffic.a> r2, Provider<c> r3) {
        this.noPermissionModuleManagerProvider = r1;
        this.networkTrafficPushProvider = r2;
        this.dependencyProvider = r3;
    }

    public static ConditionalAccessInternalImpl_Factory create(Provider<NoPermissionModuleManager> r1, Provider<com.ss.android.lark.conditional.access.traffic.a> r2, Provider<c> r3) {
        return new ConditionalAccessInternalImpl_Factory(r1, r2, r3);
    }
}
