package com.ss.android.lark.officesdk.container;

import com.ss.android.lark.officesdk.api.service.capacity.IHostLifecycle;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKConfigProviderModule_ProvideHostLifecycleFactory implements Factory<IHostLifecycle> {

    public static final class InstanceHolder {
        private static final OfficeSDKConfigProviderModule_ProvideHostLifecycleFactory INSTANCE = null;

        private InstanceHolder() {
        }

        static {
            INSTANCE = new OfficeSDKConfigProviderModule_ProvideHostLifecycleFactory();
        }

        public static /* synthetic */ OfficeSDKConfigProviderModule_ProvideHostLifecycleFactory access$000() {
            return INSTANCE;
        }
    }

    public OfficeSDKConfigProviderModule_ProvideHostLifecycleFactory() {
    }

    public static IHostLifecycle provideHostLifecycle() {
        return (IHostLifecycle) Preconditions.checkNotNullFromProvides(OfficeSDKConfigProviderModule.INSTANCE.provideHostLifecycle());
    }

    public static OfficeSDKConfigProviderModule_ProvideHostLifecycleFactory create() {
        return InstanceHolder.access$000();
    }

    public IHostLifecycle get() {
        return provideHostLifecycle();
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m33get() {
        return get();
    }
}
