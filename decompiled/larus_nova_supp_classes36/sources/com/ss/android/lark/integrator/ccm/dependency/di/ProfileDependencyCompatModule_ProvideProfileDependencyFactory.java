package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ProfileDependencyCompatModule_ProvideProfileDependencyFactory implements Factory<com.bytedance.ee.bear.lark.dependency.c0> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final k1 module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportServiceProvider;

    public com.bytedance.ee.bear.lark.dependency.c0 get() {
        return provideProfileDependency(this.module, (com.ss.android.lark.passportc.api.j) this.passportServiceProvider.get(), (com.ss.android.lark.passportc.internal.v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m883get() {
        return get();
    }

    public ProfileDependencyCompatModule_ProvideProfileDependencyFactory(k1 r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        this.module = r1;
        this.passportServiceProvider = r2;
        this.accessorProvider = r3;
    }

    public static ProfileDependencyCompatModule_ProvideProfileDependencyFactory create(k1 r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        return new ProfileDependencyCompatModule_ProvideProfileDependencyFactory(r1, r2, r3);
    }

    public static com.bytedance.ee.bear.lark.dependency.c0 provideProfileDependency(k1 r0, com.ss.android.lark.passportc.api.j r1, com.ss.android.lark.passportc.internal.v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passportService");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        o1 r3 = new o1(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (com.bytedance.ee.bear.lark.dependency.c0) Preconditions.checkNotNullFromProvides(r3);
    }
}
