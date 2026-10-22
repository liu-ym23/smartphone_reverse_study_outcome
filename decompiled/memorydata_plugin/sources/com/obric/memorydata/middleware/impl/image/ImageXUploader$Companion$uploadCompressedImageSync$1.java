package com.obric.memorydata.middleware.impl.image;

import com.obric.aikernel.core.data.IdlErrors;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.middleware.impl.image.ImageXUploader$Companion", f = "ImageXUploader.kt", i = {0, 0}, l = {116, IdlErrors.E_RejectInferDeviceOverheat}, m = "uploadCompressedImageSync", n = {"this", "bizType"}, s = {"L$0", "L$1"})
final class ImageXUploader$Companion$uploadCompressedImageSync$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ m.a this$0;

    ImageXUploader$Companion$uploadCompressedImageSync$1(m.a r3, Continuation<? super ImageXUploader$Companion$uploadCompressedImageSync$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
