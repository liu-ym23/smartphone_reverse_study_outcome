package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BaseSingletonMocksModule_ProvideINotificationSettingApiFactory implements Factory<ysb.b> {

    public static final class a {
        public static final BaseSingletonMocksModule_ProvideINotificationSettingApiFactory a = null;

        static {
            a = new BaseSingletonMocksModule_ProvideINotificationSettingApiFactory();
        }
    }

    public BaseSingletonMocksModule_ProvideINotificationSettingApiFactory() {
    }

    public static ysb.b provideINotificationSettingApi() {
        int r0 = com.ss.android.lark.officesdk.demo.dependency.a.a;
        return (ysb.b) Preconditions.checkNotNullFromProvides((ysb.b) com.ss.android.lark.officesdk.demo.dependency.a.a(ysb.b.class));
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m50get();
    }

    public static BaseSingletonMocksModule_ProvideINotificationSettingApiFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public ysb.b m50get() {
        return provideINotificationSettingApi();
    }
}
