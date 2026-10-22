package com.ss.android.lark.officesdk.demo.dependency;

import com.ss.android.lark.myai.export.MyAIService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BaseUserMocksModule_ProvideMyAIServiceFactory implements Factory<MyAIService> {

    public static final class a {
        public static final BaseUserMocksModule_ProvideMyAIServiceFactory a = null;

        static {
            a = new BaseUserMocksModule_ProvideMyAIServiceFactory();
        }
    }

    public BaseUserMocksModule_ProvideMyAIServiceFactory() {
    }

    public static MyAIService provideMyAIService() {
        int r0 = b.a;
        return (MyAIService) Preconditions.checkNotNullFromProvides((MyAIService) b.a(MyAIService.class));
    }

    public MyAIService get() {
        return provideMyAIService();
    }

    public static BaseUserMocksModule_ProvideMyAIServiceFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m56get() {
        return get();
    }
}
