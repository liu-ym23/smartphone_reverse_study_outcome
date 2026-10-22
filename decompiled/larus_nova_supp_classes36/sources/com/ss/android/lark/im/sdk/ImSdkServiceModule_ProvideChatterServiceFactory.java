package com.ss.android.lark.im.sdk;

import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkServiceModule_ProvideChatterServiceFactory implements Factory<h> {
    private final Provider<v> accessorProvider;
    private final b module;
    private final Provider<j> passportProvider;

    public h get() {
        return provideChatterService(this.module, (j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m724get() {
        return get();
    }

    public ImSdkServiceModule_ProvideChatterServiceFactory(b r1, Provider<j> r2, Provider<v> r3) {
        this.module = r1;
        this.passportProvider = r2;
        this.accessorProvider = r3;
    }

    public static ImSdkServiceModule_ProvideChatterServiceFactory create(b r1, Provider<j> r2, Provider<v> r3) {
        return new ImSdkServiceModule_ProvideChatterServiceFactory(r1, r2, r3);
    }

    public static h provideChatterService(b r0, j r1, v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        com.ss.android.lark.im.sdk.usercontainer.b r3 = new com.ss.android.lark.im.sdk.usercontainer.b(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (h) Preconditions.checkNotNullFromProvides(r3);
    }
}
