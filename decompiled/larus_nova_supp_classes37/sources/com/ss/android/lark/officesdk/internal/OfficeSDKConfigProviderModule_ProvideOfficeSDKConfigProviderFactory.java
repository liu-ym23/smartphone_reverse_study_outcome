package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKConfigProviderModule_ProvideOfficeSDKConfigProviderFactory implements Factory<IOfficeSDKConfigProvider> {
    private final d module;

    public IOfficeSDKConfigProvider get() {
        return provideOfficeSDKConfigProvider(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m111get() {
        return get();
    }

    public OfficeSDKConfigProviderModule_ProvideOfficeSDKConfigProviderFactory(d r1) {
        this.module = r1;
    }

    public static OfficeSDKConfigProviderModule_ProvideOfficeSDKConfigProviderFactory create(d r1) {
        return new OfficeSDKConfigProviderModule_ProvideOfficeSDKConfigProviderFactory(r1);
    }

    public static IOfficeSDKConfigProvider provideOfficeSDKConfigProvider(d r0) {
        r0.getClass();
        return (IOfficeSDKConfigProvider) Preconditions.checkNotNullFromProvides(new c());
    }
}
