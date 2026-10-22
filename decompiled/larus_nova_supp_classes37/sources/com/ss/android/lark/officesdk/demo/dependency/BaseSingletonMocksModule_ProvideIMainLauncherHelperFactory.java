package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BaseSingletonMocksModule_ProvideIMainLauncherHelperFactory implements Factory<s9b.a> {

    public static final class a {
        public static final BaseSingletonMocksModule_ProvideIMainLauncherHelperFactory a = null;

        static {
            a = new BaseSingletonMocksModule_ProvideIMainLauncherHelperFactory();
        }
    }

    public BaseSingletonMocksModule_ProvideIMainLauncherHelperFactory() {
    }

    public static s9b.a provideIMainLauncherHelper() {
        int r0 = com.ss.android.lark.officesdk.demo.dependency.a.a;
        return (s9b.a) Preconditions.checkNotNullFromProvides((s9b.a) com.ss.android.lark.officesdk.demo.dependency.a.a(s9b.a.class));
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m48get();
    }

    public static BaseSingletonMocksModule_ProvideIMainLauncherHelperFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public s9b.a m48get() {
        return provideIMainLauncherHelper();
    }
}
