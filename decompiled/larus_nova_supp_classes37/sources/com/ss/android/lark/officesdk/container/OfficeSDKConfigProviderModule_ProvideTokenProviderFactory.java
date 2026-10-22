package com.ss.android.lark.officesdk.container;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKConfigProviderModule_ProvideTokenProviderFactory implements Factory<IOfficeSDKTokenProvider> {

    public static final class InstanceHolder {
        private static final OfficeSDKConfigProviderModule_ProvideTokenProviderFactory INSTANCE = null;

        private InstanceHolder() {
        }

        static {
            INSTANCE = new OfficeSDKConfigProviderModule_ProvideTokenProviderFactory();
        }

        public static /* synthetic */ OfficeSDKConfigProviderModule_ProvideTokenProviderFactory access$000() {
            return INSTANCE;
        }
    }

    public OfficeSDKConfigProviderModule_ProvideTokenProviderFactory() {
    }

    public static IOfficeSDKTokenProvider provideTokenProvider() {
        return (IOfficeSDKTokenProvider) Preconditions.checkNotNullFromProvides(OfficeSDKConfigProviderModule.INSTANCE.provideTokenProvider());
    }

    public static OfficeSDKConfigProviderModule_ProvideTokenProviderFactory create() {
        return InstanceHolder.access$000();
    }

    public IOfficeSDKTokenProvider get() {
        return provideTokenProvider();
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m35get() {
        return get();
    }
}
