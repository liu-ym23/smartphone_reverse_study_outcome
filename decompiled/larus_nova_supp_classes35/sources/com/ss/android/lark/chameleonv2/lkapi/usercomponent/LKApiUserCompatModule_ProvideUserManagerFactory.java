package com.ss.android.lark.chameleonv2.lkapi.usercomponent;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import q1b.a;
import q1b.b;
import q1b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class LKApiUserCompatModule_ProvideUserManagerFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m74get() {
        return provideUserManager((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m74get();
    }

    public LKApiUserCompatModule_ProvideUserManagerFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static LKApiUserCompatModule_ProvideUserManagerFactory create(Provider<j> r1, Provider<v> r2) {
        return new LKApiUserCompatModule_ProvideUserManagerFactory(r1, r2);
    }

    public static a provideUserManager(j r1, v r2) {
        int r0 = b.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        d r3 = new d(r1, r2);
        h.a(r3);
        return (a) Preconditions.checkNotNullFromProvides(r3);
    }
}
