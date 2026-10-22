package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ProfileDependencyImpl_Factory implements Factory<n1> {
    private final Provider<by4.b> kvStorageProvider;

    public n1 get() {
        return newInstance((by4.b) this.kvStorageProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m884get() {
        return get();
    }

    public ProfileDependencyImpl_Factory(Provider<by4.b> r1) {
        this.kvStorageProvider = r1;
    }

    public static ProfileDependencyImpl_Factory create(Provider<by4.b> r1) {
        return new ProfileDependencyImpl_Factory(r1);
    }

    public static n1 newInstance(by4.b r0) {
        return new n1();
    }
}
