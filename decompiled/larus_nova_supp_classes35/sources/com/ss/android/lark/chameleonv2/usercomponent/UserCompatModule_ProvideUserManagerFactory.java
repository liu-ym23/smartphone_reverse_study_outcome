package com.ss.android.lark.chameleonv2.usercomponent;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import v1b.a;
import v1b.c;
import v1b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UserCompatModule_ProvideUserManagerFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m80get() {
        return provideUserManager((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m80get();
    }

    public UserCompatModule_ProvideUserManagerFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static UserCompatModule_ProvideUserManagerFactory create(Provider<j> r1, Provider<v> r2) {
        return new UserCompatModule_ProvideUserManagerFactory(r1, r2);
    }

    public static a provideUserManager(j r1, v r2) {
        int r0 = d.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        c r3 = new c(r1, r2);
        h.a(r3);
        return (a) Preconditions.checkNotNullFromProvides(r3);
    }
}
