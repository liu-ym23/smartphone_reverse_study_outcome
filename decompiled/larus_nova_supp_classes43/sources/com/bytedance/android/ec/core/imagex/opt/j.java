package com.bytedance.android.ec.core.imagex.opt;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j extends SettableProducerContext {
    public final CloseableStaticBitmap a;

    public j(CloseableStaticBitmap r11, ImageRequest r12, String r13, RequestListener r14, Object r15) {
        Intrinsics.checkNotNullParameter(r11, "image");
        super(r12, r13, r14, r15, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE, false, false, Priority.IMMEDIATE);
        this.a = r11;
    }
}
