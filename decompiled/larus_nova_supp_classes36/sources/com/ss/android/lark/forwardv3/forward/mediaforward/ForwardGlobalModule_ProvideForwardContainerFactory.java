package com.ss.android.lark.forwardv3.forward.mediaforward;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForwardGlobalModule_ProvideForwardContainerFactory implements Factory<f> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public f get() {
        return provideForwardContainer((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m628get() {
        return get();
    }

    public ForwardGlobalModule_ProvideForwardContainerFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static ForwardGlobalModule_ProvideForwardContainerFactory create(Provider<j> r1, Provider<v> r2) {
        return new ForwardGlobalModule_ProvideForwardContainerFactory(r1, r2);
    }

    public static f provideForwardContainer(j r1, v r2) {
        int r0 = e.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        d r3 = new d(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (f) Preconditions.checkNotNullFromProvides(r3);
    }
}
