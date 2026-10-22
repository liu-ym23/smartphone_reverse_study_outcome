package com.ss.android.lark.integrator.im.impl.feed.user;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import vmb.a;
import vmb.c;
import vmb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UserFeedBundleModule_ProvideUserFeedBundleFactory implements Factory<a> {
    private final d module;
    private final Provider<c> proxyProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m911get() {
        return provideUserFeedBundle(this.module, (c) this.proxyProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m911get();
    }

    public UserFeedBundleModule_ProvideUserFeedBundleFactory(d r1, Provider<c> r2) {
        this.module = r1;
        this.proxyProvider = r2;
    }

    public static UserFeedBundleModule_ProvideUserFeedBundleFactory create(d r1, Provider<c> r2) {
        return new UserFeedBundleModule_ProvideUserFeedBundleFactory(r1, r2);
    }

    public static a provideUserFeedBundle(d r0, c r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "proxy");
        return (a) Preconditions.checkNotNullFromProvides(r1);
    }
}
