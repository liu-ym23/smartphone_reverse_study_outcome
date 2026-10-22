package com.ss.android.lark.conditional.access.nopermission.viewmodel;

import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import dagger.internal.Factory;
import javax.inject.Provider;
import k8b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class NoPermissionViewModel_Factory implements Factory<NoPermissionViewModel> {
    private final Provider<c> dependencyProvider;
    private final Provider<yyb.b> mfaServiceProvider;
    private final Provider<ConditionalAccessNetDependency> networkDependencyProvider;

    public static NoPermissionViewModel newInstance() {
        return new NoPermissionViewModel();
    }

    public NoPermissionViewModel get() {
        NoPermissionViewModel r0 = newInstance();
        r0.networkDependency = (ConditionalAccessNetDependency) this.networkDependencyProvider.get();
        r0.dependency = (c) this.dependencyProvider.get();
        r0.mfaService = (yyb.b) this.mfaServiceProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m990get() {
        return get();
    }

    public NoPermissionViewModel_Factory(Provider<ConditionalAccessNetDependency> r1, Provider<c> r2, Provider<yyb.b> r3) {
        this.networkDependencyProvider = r1;
        this.dependencyProvider = r2;
        this.mfaServiceProvider = r3;
    }

    public static NoPermissionViewModel_Factory create(Provider<ConditionalAccessNetDependency> r1, Provider<c> r2, Provider<yyb.b> r3) {
        return new NoPermissionViewModel_Factory(r1, r2, r3);
    }
}
