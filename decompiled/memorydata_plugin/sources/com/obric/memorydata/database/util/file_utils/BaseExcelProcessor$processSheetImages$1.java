package com.obric.memorydata.database.util.file_utils;

import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.util.file_utils.BaseExcelProcessor", f = "BaseExcelProcessor.kt", i = {0, 0, 0, 0, 0}, l = {BDAbstractUpload.KeyIsSDKMaxRetryTimeout}, m = "processSheetImages$suspendImpl", n = {"$this", "tree", "fileEntity", "parentId", "index$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"})
final class BaseExcelProcessor$processSheetImages$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    BaseExcelProcessor$processSheetImages$1(c r3, Continuation<? super BaseExcelProcessor$processSheetImages$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return c.a(this.this$0, null, null, 0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
