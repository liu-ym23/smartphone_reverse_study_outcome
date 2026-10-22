package com.larus.disk.impl.handler;

import com.larus.dora.impl.ota.g2.j0;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class FrescoCacheHandler$cleanCache$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public static final FrescoCacheHandler$cleanCache$2 INSTANCE = null;

    static {
        INSTANCE = new FrescoCacheHandler$cleanCache$2();
    }

    public FrescoCacheHandler$cleanCache$2() {
        super(0, ImageLoaderKt.class, "clearDefaultImageCache", "clearDefaultImageCache()V", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m32invoke() {
        ImageLoaderKt.p().clearMainDiskCacheByTimestamp(j0.G2_OTA_RECOVERY_BLOCK_FOREVER);
        ImageLoaderKt.p().clearSmallDiskCacheByTimestamp(j0.G2_OTA_RECOVERY_BLOCK_FOREVER);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m32invoke();
        return Unit.INSTANCE;
    }
}
