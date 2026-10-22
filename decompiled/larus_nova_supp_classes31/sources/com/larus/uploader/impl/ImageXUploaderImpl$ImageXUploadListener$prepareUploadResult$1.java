package com.larus.uploader.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uploader.impl.ImageXUploaderImpl$ImageXUploadListener", f = "ImageXUploaderImpl.kt", i = {0, 0}, l = {244}, m = "prepareUploadResult", n = {"info", "imageResult"}, s = {"L$0", "L$1"})
final class ImageXUploaderImpl$ImageXUploadListener$prepareUploadResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageXUploaderImpl.ImageXUploadListener this$0;

    public ImageXUploaderImpl$ImageXUploadListener$prepareUploadResult$1(ImageXUploaderImpl.ImageXUploadListener r1, Continuation<? super ImageXUploaderImpl$ImageXUploadListener$prepareUploadResult$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ImageXUploaderImpl.ImageXUploadListener.a(this.this$0, null, this);
    }
}
