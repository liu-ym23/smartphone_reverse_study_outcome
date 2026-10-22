package com.ss.android.lark.officesdk.container;

import com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKConfigProviderModule_ProvideAppBaseInfoFactory implements Factory<IOfficeAppBaseInfo> {

    public static final class InstanceHolder {
        private static final OfficeSDKConfigProviderModule_ProvideAppBaseInfoFactory INSTANCE = null;

        private InstanceHolder() {
        }

        static {
            INSTANCE = new OfficeSDKConfigProviderModule_ProvideAppBaseInfoFactory();
        }

        public static /* synthetic */ OfficeSDKConfigProviderModule_ProvideAppBaseInfoFactory access$000() {
            return INSTANCE;
        }
    }

    public OfficeSDKConfigProviderModule_ProvideAppBaseInfoFactory() {
    }

    public static IOfficeAppBaseInfo provideAppBaseInfo() {
        return (IOfficeAppBaseInfo) Preconditions.checkNotNullFromProvides(OfficeSDKConfigProviderModule.INSTANCE.provideAppBaseInfo());
    }

    public static OfficeSDKConfigProviderModule_ProvideAppBaseInfoFactory create() {
        return InstanceHolder.access$000();
    }

    public IOfficeAppBaseInfo get() {
        return provideAppBaseInfo();
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m30get() {
        return get();
    }
}
