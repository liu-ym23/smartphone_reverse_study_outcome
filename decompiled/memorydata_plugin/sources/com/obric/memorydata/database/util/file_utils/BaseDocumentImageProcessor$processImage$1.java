package com.obric.memorydata.database.util.file_utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.util.file_utils.BaseDocumentImageProcessor", f = "BaseDocumentImageProcessor.kt", i = {0, 0, 0, 0, 0}, l = {114}, m = "processImage$suspendImpl", n = {"$this", "imageInfo", "tree", "docFileEntity", "parentId"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
final class BaseDocumentImageProcessor$processImage$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    BaseDocumentImageProcessor$processImage$1(b r3, Continuation<? super BaseDocumentImageProcessor$processImage$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return b.a(this.this$0, null, null, null, 0, null, false, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
