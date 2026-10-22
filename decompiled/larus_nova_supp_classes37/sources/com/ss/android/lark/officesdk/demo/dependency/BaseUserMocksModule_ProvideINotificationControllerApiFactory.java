package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BaseUserMocksModule_ProvideINotificationControllerApiFactory implements Factory<ysb.a> {

    public static final class a {
        public static final BaseUserMocksModule_ProvideINotificationControllerApiFactory a = null;

        static {
            a = new BaseUserMocksModule_ProvideINotificationControllerApiFactory();
        }
    }

    public BaseUserMocksModule_ProvideINotificationControllerApiFactory() {
    }

    public static ysb.a provideINotificationControllerApi() {
        int r0 = b.a;
        return (ysb.a) Preconditions.checkNotNullFromProvides((ysb.a) b.a(ysb.a.class));
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m54get();
    }

    public static BaseUserMocksModule_ProvideINotificationControllerApiFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public ysb.a m54get() {
        return provideINotificationControllerApi();
    }
}
