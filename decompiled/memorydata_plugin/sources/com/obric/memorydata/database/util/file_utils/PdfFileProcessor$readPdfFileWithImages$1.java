package com.obric.memorydata.database.util.file_utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.util.file_utils.PdfFileProcessor", f = "PdfFileProcessor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {100}, m = "readPdfFileWithImages", n = {"this", "fileEntity", "document", "tree", "root", "pageCount", "totalChars", "totalCharLimit", "i"}, s = {"L$0", "L$1", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3"})
final class PdfFileProcessor$readPdfFileWithImages$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PdfFileProcessor this$0;

    PdfFileProcessor$readPdfFileWithImages$1(PdfFileProcessor r3, Continuation<? super PdfFileProcessor$readPdfFileWithImages$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return PdfFileProcessor.a(this.this$0, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
