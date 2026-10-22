package com.ss.android.lark.officesdk.container;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKConfigProviderModule_ProvideLifeCycleFactory implements Factory<IOfficeSDKLifeCycle> {

    public static final class InstanceHolder {
        private static final OfficeSDKConfigProviderModule_ProvideLifeCycleFactory INSTANCE = null;

        private InstanceHolder() {
        }

        static {
            INSTANCE = new OfficeSDKConfigProviderModule_ProvideLifeCycleFactory();
        }

        public static /* synthetic */ OfficeSDKConfigProviderModule_ProvideLifeCycleFactory access$000() {
            return INSTANCE;
        }
    }

    public OfficeSDKConfigProviderModule_ProvideLifeCycleFactory() {
    }

    public static IOfficeSDKLifeCycle provideLifeCycle() {
        return (IOfficeSDKLifeCycle) Preconditions.checkNotNullFromProvides(OfficeSDKConfigProviderModule.INSTANCE.provideLifeCycle());
    }

    public static OfficeSDKConfigProviderModule_ProvideLifeCycleFactory create() {
        return InstanceHolder.access$000();
    }

    public IOfficeSDKLifeCycle get() {
        return provideLifeCycle();
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m34get() {
        return get();
    }
}
