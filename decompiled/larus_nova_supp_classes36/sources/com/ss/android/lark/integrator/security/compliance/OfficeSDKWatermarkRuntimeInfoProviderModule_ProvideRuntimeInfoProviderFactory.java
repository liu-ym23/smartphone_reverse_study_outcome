package com.ss.android.lark.integrator.security.compliance;

import com.ss.android.lark.watermark.userscope.u0;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeSDKWatermarkRuntimeInfoProviderModule_ProvideRuntimeInfoProviderFactory implements Factory<u0> {

    public static final class a {
        public static final OfficeSDKWatermarkRuntimeInfoProviderModule_ProvideRuntimeInfoProviderFactory a = null;

        static {
            a = new OfficeSDKWatermarkRuntimeInfoProviderModule_ProvideRuntimeInfoProviderFactory();
        }
    }

    public OfficeSDKWatermarkRuntimeInfoProviderModule_ProvideRuntimeInfoProviderFactory() {
    }

    public static u0 provideRuntimeInfoProvider() {
        int r0 = h.a;
        return (u0) Preconditions.checkNotNullFromProvides(g.a);
    }

    public u0 get() {
        return provideRuntimeInfoProvider();
    }

    public static OfficeSDKWatermarkRuntimeInfoProviderModule_ProvideRuntimeInfoProviderFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m933get() {
        return get();
    }
}
