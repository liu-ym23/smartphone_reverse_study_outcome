package com.ss.android.lark.integrator.im.impl.feed.user;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import vmb.c;
import vmb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UserFeedBundleModule_ProvideUserFeedBundleProxyFactory implements Factory<c> {
    private final d module;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m912get() {
        return provideUserFeedBundleProxy(this.module, (j) this.passportProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m912get();
    }

    public UserFeedBundleModule_ProvideUserFeedBundleProxyFactory(d r1, Provider<j> r2) {
        this.module = r1;
        this.passportProvider = r2;
    }

    public static UserFeedBundleModule_ProvideUserFeedBundleProxyFactory create(d r1, Provider<j> r2) {
        return new UserFeedBundleModule_ProvideUserFeedBundleProxyFactory(r1, r2);
    }

    public static c provideUserFeedBundleProxy(d r0, j r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passport");
        c r2 = new c(r1);
        h.a(r2);
        return (c) Preconditions.checkNotNullFromProvides(r2);
    }
}
