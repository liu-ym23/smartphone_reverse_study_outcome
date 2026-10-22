package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BaseUserMocksModule_ProvideINotificationSettingApiFactory implements Factory<ysb.b> {

    public static final class a {
        public static final BaseUserMocksModule_ProvideINotificationSettingApiFactory a = null;

        static {
            a = new BaseUserMocksModule_ProvideINotificationSettingApiFactory();
        }
    }

    public BaseUserMocksModule_ProvideINotificationSettingApiFactory() {
    }

    public static ysb.b provideINotificationSettingApi() {
        int r0 = b.a;
        return (ysb.b) Preconditions.checkNotNullFromProvides((ysb.b) b.a(ysb.b.class));
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m55get();
    }

    public static BaseUserMocksModule_ProvideINotificationSettingApiFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public ysb.b m55get() {
        return provideINotificationSettingApi();
    }
}
