package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BaseSingletonMocksModule_ProvideIExportTabDataManagerFactory implements Factory<yqb.a> {

    public static final class a {
        public static final BaseSingletonMocksModule_ProvideIExportTabDataManagerFactory a = null;

        static {
            a = new BaseSingletonMocksModule_ProvideIExportTabDataManagerFactory();
        }
    }

    public BaseSingletonMocksModule_ProvideIExportTabDataManagerFactory() {
    }

    public static yqb.a provideIExportTabDataManager() {
        int r0 = com.ss.android.lark.officesdk.demo.dependency.a.a;
        return (yqb.a) Preconditions.checkNotNullFromProvides((yqb.a) com.ss.android.lark.officesdk.demo.dependency.a.a(yqb.a.class));
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m47get();
    }

    public static BaseSingletonMocksModule_ProvideIExportTabDataManagerFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public yqb.a m47get() {
        return provideIExportTabDataManager();
    }
}
