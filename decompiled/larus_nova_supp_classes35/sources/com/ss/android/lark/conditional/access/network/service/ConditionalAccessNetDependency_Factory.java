package com.ss.android.lark.conditional.access.network.service;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.conditional.access.nopermission.manager.NoPermissionModuleManager;
import com.ss.android.lark.security.compliance.infra.network.userscpoe.a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ConditionalAccessNetDependency_Factory implements Factory<ConditionalAccessNetDependency> {
    private final Provider<NoPermissionModuleManager> noPermissionModuleManagerProvider;
    private final Provider<a> requestServiceProvider;
    private final Provider<l> userClientProvider;

    public ConditionalAccessNetDependency get() {
        return newInstance((NoPermissionModuleManager) this.noPermissionModuleManagerProvider.get(), (a) this.requestServiceProvider.get(), (l) this.userClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m970get() {
        return get();
    }

    public ConditionalAccessNetDependency_Factory(Provider<NoPermissionModuleManager> r1, Provider<a> r2, Provider<l> r3) {
        this.noPermissionModuleManagerProvider = r1;
        this.requestServiceProvider = r2;
        this.userClientProvider = r3;
    }

    public static ConditionalAccessNetDependency_Factory create(Provider<NoPermissionModuleManager> r1, Provider<a> r2, Provider<l> r3) {
        return new ConditionalAccessNetDependency_Factory(r1, r2, r3);
    }

    public static ConditionalAccessNetDependency newInstance(NoPermissionModuleManager r1, a r2, l r3) {
        return new ConditionalAccessNetDependency(r1, r2, r3);
    }
}
