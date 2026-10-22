package com.ss.android.lark.im.base;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImBaseBizModule_Factory implements Factory<ImBaseBizModule> {
    private final Provider<b> ccmDependencyProvider;
    private final Provider<c> extensionDependencyProvider;

    public static ImBaseBizModule newInstance() {
        return new ImBaseBizModule();
    }

    public ImBaseBizModule get() {
        ImBaseBizModule r0 = newInstance();
        r0.a = (c) this.extensionDependencyProvider.get();
        r0.b = (b) this.ccmDependencyProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m705get() {
        return get();
    }

    public ImBaseBizModule_Factory(Provider<c> r1, Provider<b> r2) {
        this.extensionDependencyProvider = r1;
        this.ccmDependencyProvider = r2;
    }

    public static ImBaseBizModule_Factory create(Provider<c> r1, Provider<b> r2) {
        return new ImBaseBizModule_Factory(r1, r2);
    }
}
