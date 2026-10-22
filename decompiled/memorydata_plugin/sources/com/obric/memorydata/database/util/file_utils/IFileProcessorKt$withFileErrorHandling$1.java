package com.obric.memorydata.database.util.file_utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
@DebugMetadata(c = "com.obric.memorydata.database.util.file_utils.IFileProcessorKt", f = "IFileProcessor.kt", i = {0}, l = {51}, m = "withFileErrorHandling", n = {"fileTypeTag"}, s = {"L$0"})
final class IFileProcessorKt$withFileErrorHandling$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    IFileProcessorKt$withFileErrorHandling$1(Continuation<? super IFileProcessorKt$withFileErrorHandling$1> r3) {
        super((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return p.a(null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
