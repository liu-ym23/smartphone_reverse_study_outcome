package com.obric.memorydata.middleware.impl.image;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.middleware.impl.image.ImageXUploader$Companion", f = "ImageXUploader.kt", i = {0, 0, 0, 0, 0}, l = {203}, m = "writePrivilegedUriFileToCache", n = {"this", "context", "uri", "sourcePackage", "resize"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
final class ImageXUploader$Companion$writePrivilegedUriFileToCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ m.a this$0;

    ImageXUploader$Companion$writePrivilegedUriFileToCache$1(m.a r3, Continuation<? super ImageXUploader$Companion$writePrivilegedUriFileToCache$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return m.a.a(this.this$0, null, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
