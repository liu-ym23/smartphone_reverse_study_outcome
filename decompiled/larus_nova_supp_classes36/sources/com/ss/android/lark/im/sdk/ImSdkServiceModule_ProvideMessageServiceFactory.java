package com.ss.android.lark.im.sdk;

import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.im.sdk.usercontainer.c;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkServiceModule_ProvideMessageServiceFactory implements Factory<p> {
    private final Provider<v> accessorProvider;
    private final b module;
    private final Provider<j> passportProvider;

    public p get() {
        return provideMessageService(this.module, (j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m726get() {
        return get();
    }

    public ImSdkServiceModule_ProvideMessageServiceFactory(b r1, Provider<j> r2, Provider<v> r3) {
        this.module = r1;
        this.passportProvider = r2;
        this.accessorProvider = r3;
    }

    public static ImSdkServiceModule_ProvideMessageServiceFactory create(b r1, Provider<j> r2, Provider<v> r3) {
        return new ImSdkServiceModule_ProvideMessageServiceFactory(r1, r2, r3);
    }

    public static p provideMessageService(b r0, j r1, v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        c r3 = new c(r1, r2);
        h.a(r3);
        return (p) Preconditions.checkNotNullFromProvides(r3);
    }
}
