package com.ss.android.lark.officesdk.provider;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import nwb.g;
import xnc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RouterProvider_ProvideUriRouteMappingFactory implements Factory<xnc.a> {

    public static final class a {
        public static final RouterProvider_ProvideUriRouteMappingFactory a = null;

        static {
            a = new RouterProvider_ProvideUriRouteMappingFactory();
        }
    }

    public RouterProvider_ProvideUriRouteMappingFactory() {
    }

    public static xnc.a provideUriRouteMapping() {
        int r0 = g.a;
        return (xnc.a) Preconditions.checkNotNullFromProvides(new b());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m551get();
    }

    public static RouterProvider_ProvideUriRouteMappingFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public xnc.a m551get() {
        return provideUriRouteMapping();
    }
}
