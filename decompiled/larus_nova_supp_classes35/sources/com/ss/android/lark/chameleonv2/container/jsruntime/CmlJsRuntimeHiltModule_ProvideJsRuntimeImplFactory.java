package com.ss.android.lark.chameleonv2.container.jsruntime;

import com.ss.android.lark.chameleon.AbsChameleonJsRuntime;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import e0c.k;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import m0b.b;
import m0b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CmlJsRuntimeHiltModule_ProvideJsRuntimeImplFactory implements Factory<AbsChameleonJsRuntime> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public AbsChameleonJsRuntime get() {
        return provideJsRuntimeImpl((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m49get() {
        return get();
    }

    public CmlJsRuntimeHiltModule_ProvideJsRuntimeImplFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static CmlJsRuntimeHiltModule_ProvideJsRuntimeImplFactory create(Provider<j> r1, Provider<v> r2) {
        return new CmlJsRuntimeHiltModule_ProvideJsRuntimeImplFactory(r1, r2);
    }

    public static AbsChameleonJsRuntime provideJsRuntimeImpl(j r4, v r5) {
        int r0 = b.a;
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        UserSession r2 = r4.b();
        if (r2 != null) goto L5;
        r2 = ContainerConstsKt.a();
    L5:
        c r1 = new c(r4, r5, new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r2), AbsChameleonJsRuntime.class), AbsChameleonJsRuntime.class));
        h.a(r1);
        return (AbsChameleonJsRuntime) Preconditions.checkNotNullFromProvides(r1);
    }
}
