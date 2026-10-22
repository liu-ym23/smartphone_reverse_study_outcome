package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BaseSingletonMocksModule_ProvideINotificationControllerApiFactory implements Factory<ysb.a> {

    public static final class a {
        public static final BaseSingletonMocksModule_ProvideINotificationControllerApiFactory a = null;

        static {
            a = new BaseSingletonMocksModule_ProvideINotificationControllerApiFactory();
        }
    }

    public BaseSingletonMocksModule_ProvideINotificationControllerApiFactory() {
    }

    public static ysb.a provideINotificationControllerApi() {
        int r0 = com.ss.android.lark.officesdk.demo.dependency.a.a;
        return (ysb.a) Preconditions.checkNotNullFromProvides((ysb.a) com.ss.android.lark.officesdk.demo.dependency.a.a(ysb.a.class));
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m49get();
    }

    public static BaseSingletonMocksModule_ProvideINotificationControllerApiFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public ysb.a m49get() {
        return provideINotificationControllerApi();
    }
}
