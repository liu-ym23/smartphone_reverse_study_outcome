package com.obric.memorydata.database.util.file_utils;

import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.util.file_utils.BaseExcelProcessor", f = "BaseExcelProcessor.kt", i = {0, 0, 0, 1}, l = {BDVideoUploaderBase.KeyIsDynamicSliceLowSize, BDVideoUploaderBase.KeyIsTosEncStorageMode}, m = "process$suspendImpl", n = {"$this", "fileEntity", "fileTypeTag$iv", "fileTypeTag$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
final class BaseExcelProcessor$process$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    BaseExcelProcessor$process$1(c r3, Continuation<? super BaseExcelProcessor$process$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return c.a(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
