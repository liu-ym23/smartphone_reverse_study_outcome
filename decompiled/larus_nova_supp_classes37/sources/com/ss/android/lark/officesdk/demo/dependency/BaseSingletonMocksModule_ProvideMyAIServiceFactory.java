package com.ss.android.lark.officesdk.demo.dependency;

import com.ss.android.lark.myai.export.MyAIService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BaseSingletonMocksModule_ProvideMyAIServiceFactory implements Factory<MyAIService> {

    public static final class a {
        public static final BaseSingletonMocksModule_ProvideMyAIServiceFactory a = null;

        static {
            a = new BaseSingletonMocksModule_ProvideMyAIServiceFactory();
        }
    }

    public BaseSingletonMocksModule_ProvideMyAIServiceFactory() {
    }

    public static MyAIService provideMyAIService() {
        int r0 = com.ss.android.lark.officesdk.demo.dependency.a.a;
        return (MyAIService) Preconditions.checkNotNullFromProvides((MyAIService) com.ss.android.lark.officesdk.demo.dependency.a.a(MyAIService.class));
    }

    public MyAIService get() {
        return provideMyAIService();
    }

    public static BaseSingletonMocksModule_ProvideMyAIServiceFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m51get() {
        return get();
    }
}
