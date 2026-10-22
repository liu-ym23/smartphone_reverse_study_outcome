package com.ss.android.lark.integrator.im.impl.feed.user;

import chb.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import vmb.c;
import vmb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UserFeedBundleModule_ProvideFeedUserDataSourceFactory implements Factory<a> {
    private final d module;
    private final Provider<c> proxyProvider;

    public a get() {
        return provideFeedUserDataSource(this.module, (c) this.proxyProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m910get() {
        return get();
    }

    public UserFeedBundleModule_ProvideFeedUserDataSourceFactory(d r1, Provider<c> r2) {
        this.module = r1;
        this.proxyProvider = r2;
    }

    public static UserFeedBundleModule_ProvideFeedUserDataSourceFactory create(d r1, Provider<c> r2) {
        return new UserFeedBundleModule_ProvideFeedUserDataSourceFactory(r1, r2);
    }

    public static a provideFeedUserDataSource(d r0, c r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "proxy");
        return (a) Preconditions.checkNotNullFromProvides(r1);
    }
}
