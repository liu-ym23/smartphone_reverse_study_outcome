package com.ss.android.lark.officesdk.provider;

import com.suite.lark.component.navroute.args.b;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import nwb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RouterProvider_ProvideNavGraphRepositoryFactory implements Factory<b> {

    public static final class a {
        public static final RouterProvider_ProvideNavGraphRepositoryFactory a = null;

        static {
            a = new RouterProvider_ProvideNavGraphRepositoryFactory();
        }
    }

    public RouterProvider_ProvideNavGraphRepositoryFactory() {
    }

    public static b provideNavGraphRepository() {
        int r0 = g.a;
        return (b) Preconditions.checkNotNullFromProvides(com.suite.lark.component.navroute.generated.aggregator.a.b);
    }

    public b get() {
        return provideNavGraphRepository();
    }

    public static RouterProvider_ProvideNavGraphRepositoryFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m549get() {
        return get();
    }
}
