package com.ss.android.lark.integrator.security.compliance.export;

import com.ss.android.lark.watermark.userscope.WatermarkImplFactoryV3;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class WatermarkService_Factory implements Factory<WatermarkService> {
    private final Provider<WatermarkImplFactoryV3> watermarkImplFactoryV3Provider;
    private final Provider<com.ss.android.lark.watermark.userscope.c> watermarkModuleProvider;

    public WatermarkService get() {
        return newInstance((WatermarkImplFactoryV3) this.watermarkImplFactoryV3Provider.get(), (com.ss.android.lark.watermark.userscope.c) this.watermarkModuleProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m950get() {
        return get();
    }

    public WatermarkService_Factory(Provider<WatermarkImplFactoryV3> r1, Provider<com.ss.android.lark.watermark.userscope.c> r2) {
        this.watermarkImplFactoryV3Provider = r1;
        this.watermarkModuleProvider = r2;
    }

    public static WatermarkService_Factory create(Provider<WatermarkImplFactoryV3> r1, Provider<com.ss.android.lark.watermark.userscope.c> r2) {
        return new WatermarkService_Factory(r1, r2);
    }

    public static WatermarkService newInstance(WatermarkImplFactoryV3 r1, com.ss.android.lark.watermark.userscope.c r2) {
        return new WatermarkService(r1, r2);
    }
}
