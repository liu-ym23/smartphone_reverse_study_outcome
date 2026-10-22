package com.ss.android.lark.officesdk.container;

import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKConfigProviderModule_ProvideDeviceInfoProviderFactory implements Factory<IDeviceInfoProvider> {

    public static final class InstanceHolder {
        private static final OfficeSDKConfigProviderModule_ProvideDeviceInfoProviderFactory INSTANCE = null;

        private InstanceHolder() {
        }

        static {
            INSTANCE = new OfficeSDKConfigProviderModule_ProvideDeviceInfoProviderFactory();
        }

        public static /* synthetic */ OfficeSDKConfigProviderModule_ProvideDeviceInfoProviderFactory access$000() {
            return INSTANCE;
        }
    }

    public OfficeSDKConfigProviderModule_ProvideDeviceInfoProviderFactory() {
    }

    public static IDeviceInfoProvider provideDeviceInfoProvider() {
        return (IDeviceInfoProvider) Preconditions.checkNotNullFromProvides(OfficeSDKConfigProviderModule.INSTANCE.provideDeviceInfoProvider());
    }

    public static OfficeSDKConfigProviderModule_ProvideDeviceInfoProviderFactory create() {
        return InstanceHolder.access$000();
    }

    public IDeviceInfoProvider get() {
        return provideDeviceInfoProvider();
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m31get() {
        return get();
    }
}
