package com.ss.android.lark.conditional.access.nopermission.manager;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class NoPermissionModuleManager_Factory implements Factory<NoPermissionModuleManager> {
    private final Provider<k8b.c> conditionalAccessDependencyProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;
    private final Provider<com.ss.android.lark.security.compliance.infra.network.userscpoe.a> scRequestProvider;

    public NoPermissionModuleManager get() {
        return newInstance((com.ss.android.lark.security.compliance.infra.network.userscpoe.a) this.scRequestProvider.get(), (com.ss.android.lark.passportc.api.j) this.passportProvider.get(), (k8b.c) this.conditionalAccessDependencyProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m972get() {
        return get();
    }

    public NoPermissionModuleManager_Factory(Provider<com.ss.android.lark.security.compliance.infra.network.userscpoe.a> r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<k8b.c> r3) {
        this.scRequestProvider = r1;
        this.passportProvider = r2;
        this.conditionalAccessDependencyProvider = r3;
    }

    public static NoPermissionModuleManager_Factory create(Provider<com.ss.android.lark.security.compliance.infra.network.userscpoe.a> r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<k8b.c> r3) {
        return new NoPermissionModuleManager_Factory(r1, r2, r3);
    }

    public static NoPermissionModuleManager newInstance(com.ss.android.lark.security.compliance.infra.network.userscpoe.a r1, com.ss.android.lark.passportc.api.j r2, k8b.c r3) {
        return new NoPermissionModuleManager(r1, r2, r3);
    }
}
