package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BaseUserMocksModule_ProvideIExportTabDataManagerFactory implements Factory<yqb.a> {

    public static final class a {
        public static final BaseUserMocksModule_ProvideIExportTabDataManagerFactory a = null;

        static {
            a = new BaseUserMocksModule_ProvideIExportTabDataManagerFactory();
        }
    }

    public BaseUserMocksModule_ProvideIExportTabDataManagerFactory() {
    }

    public static yqb.a provideIExportTabDataManager() {
        int r0 = b.a;
        return (yqb.a) Preconditions.checkNotNullFromProvides((yqb.a) b.a(yqb.a.class));
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m52get();
    }

    public static BaseUserMocksModule_ProvideIExportTabDataManagerFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public yqb.a m52get() {
        return provideIExportTabDataManager();
    }
}
