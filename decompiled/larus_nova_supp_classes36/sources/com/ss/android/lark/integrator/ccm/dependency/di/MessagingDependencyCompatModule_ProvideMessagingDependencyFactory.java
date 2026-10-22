package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MessagingDependencyCompatModule_ProvideMessagingDependencyFactory implements Factory<com.bytedance.ee.bear.lark.dependency.t> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final h0 module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportServiceProvider;

    public com.bytedance.ee.bear.lark.dependency.t get() {
        return provideMessagingDependency(this.module, (com.ss.android.lark.passportc.api.j) this.passportServiceProvider.get(), (com.ss.android.lark.passportc.internal.v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m867get() {
        return get();
    }

    public MessagingDependencyCompatModule_ProvideMessagingDependencyFactory(h0 r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        this.module = r1;
        this.passportServiceProvider = r2;
        this.accessorProvider = r3;
    }

    public static MessagingDependencyCompatModule_ProvideMessagingDependencyFactory create(h0 r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        return new MessagingDependencyCompatModule_ProvideMessagingDependencyFactory(r1, r2, r3);
    }

    public static com.bytedance.ee.bear.lark.dependency.t provideMessagingDependency(h0 r0, com.ss.android.lark.passportc.api.j r1, com.ss.android.lark.passportc.internal.v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passportService");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        j0 r3 = new j0(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (com.bytedance.ee.bear.lark.dependency.t) Preconditions.checkNotNullFromProvides(r3);
    }
}
