package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorUploadPreviewHelper", f = "ImageSelectorUploadPreviewHelper.kt", i = {0}, l = {21}, m = "fetchPreviewBitmap", n = {"imageUri"}, s = {"L$0"})
public final class ImageSelectorUploadPreviewHelper$fetchPreviewBitmap$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageSelectorUploadPreviewHelper this$0;

    public ImageSelectorUploadPreviewHelper$fetchPreviewBitmap$1(ImageSelectorUploadPreviewHelper r1, Continuation<? super ImageSelectorUploadPreviewHelper$fetchPreviewBitmap$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
