package com.larus.disk.impl.handler;

import com.larus.dora.impl.ota.g2.j0;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class l implements Function0 {
    public final /* synthetic */ FrescoCustomCacheHandler a;

    public /* synthetic */ l(FrescoCustomCacheHandler r1) {
        this.a = r1;
    }

    public final Object invoke() {
        String r0 = this.a.a;
        Lazy r1 = ImageLoaderKt.a;
        Intrinsics.checkNotNullParameter(r0, "cacheName");
        ImageLoaderKt.c(r0, j0.G2_OTA_RECOVERY_BLOCK_FOREVER);
        return Unit.INSTANCE;
    }
}
