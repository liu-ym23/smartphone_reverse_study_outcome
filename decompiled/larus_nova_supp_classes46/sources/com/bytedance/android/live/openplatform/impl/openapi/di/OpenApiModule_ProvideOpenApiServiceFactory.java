package com.bytedance.android.live.openplatform.impl.openapi.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import or0.a;
import yo0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class OpenApiModule_ProvideOpenApiServiceFactory implements Factory<b> {
    private final a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m804get() {
        return provideOpenApiService(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m804get();
    }

    public OpenApiModule_ProvideOpenApiServiceFactory(a r1) {
        this.module = r1;
    }

    public static OpenApiModule_ProvideOpenApiServiceFactory create(a r1) {
        return new OpenApiModule_ProvideOpenApiServiceFactory(r1);
    }

    public static b provideOpenApiService(a r0) {
        r0.getClass();
        return (b) Preconditions.checkNotNullFromProvides(new com.bytedance.android.live.openplatform.impl.openapi.a());
    }
}
