package com.bytedance.android.livesdk.feed.di;

import dagger.internal.Factory;
import rv1.a;
import uv1.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class DrawerCategoryModuleFallback_ProvideDrawerCategoryServiceFactory implements Factory<d> {
    private final a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public d m1221get() {
        return provideDrawerCategoryService(null);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1221get();
    }

    public DrawerCategoryModuleFallback_ProvideDrawerCategoryServiceFactory(a r1) {
    }

    public static DrawerCategoryModuleFallback_ProvideDrawerCategoryServiceFactory create(a r1) {
        return new DrawerCategoryModuleFallback_ProvideDrawerCategoryServiceFactory(r1);
    }

    public static d provideDrawerCategoryService(a r0) {
        throw null;
    }
}
