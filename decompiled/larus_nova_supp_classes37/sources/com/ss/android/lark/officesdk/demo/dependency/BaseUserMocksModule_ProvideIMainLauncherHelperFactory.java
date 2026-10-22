package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BaseUserMocksModule_ProvideIMainLauncherHelperFactory implements Factory<s9b.a> {

    public static final class a {
        public static final BaseUserMocksModule_ProvideIMainLauncherHelperFactory a = null;

        static {
            a = new BaseUserMocksModule_ProvideIMainLauncherHelperFactory();
        }
    }

    public BaseUserMocksModule_ProvideIMainLauncherHelperFactory() {
    }

    public static s9b.a provideIMainLauncherHelper() {
        int r0 = b.a;
        return (s9b.a) Preconditions.checkNotNullFromProvides((s9b.a) b.a(s9b.a.class));
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m53get();
    }

    public static BaseUserMocksModule_ProvideIMainLauncherHelperFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public s9b.a m53get() {
        return provideIMainLauncherHelper();
    }
}
