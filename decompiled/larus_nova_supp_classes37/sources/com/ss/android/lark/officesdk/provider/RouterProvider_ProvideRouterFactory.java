package com.ss.android.lark.officesdk.provider;

import com.suite.lark.component.navroute.generated.aggregator.NavGraphAggregatorRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import nwb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RouterProvider_ProvideRouterFactory implements Factory<com.suite.lark.component.navroute.graph.a> {

    public static final class a {
        public static final RouterProvider_ProvideRouterFactory a = null;

        static {
            a = new RouterProvider_ProvideRouterFactory();
        }
    }

    public RouterProvider_ProvideRouterFactory() {
    }

    public static com.suite.lark.component.navroute.graph.a provideRouter() {
        int r0 = g.a;
        return (com.suite.lark.component.navroute.graph.a) Preconditions.checkNotNullFromProvides(NavGraphAggregatorRepository.f);
    }

    public com.suite.lark.component.navroute.graph.a get() {
        return provideRouter();
    }

    public static RouterProvider_ProvideRouterFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m550get() {
        return get();
    }
}
