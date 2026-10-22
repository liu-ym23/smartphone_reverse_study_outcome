package com.obric.memorydata.memory.ui.migration;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.migration.DataTransferViewModel$buildPostRestoreHook$1", f = "DataTransferViewModel.kt", i = {0}, l = {780, 840}, m = "onPostRestore", n = {"this"}, s = {"L$0"})
final class DataTransferViewModel$buildPostRestoreHook$1$onPostRestore$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataTransferViewModel.f this$0;

    DataTransferViewModel$buildPostRestoreHook$1$onPostRestore$1(DataTransferViewModel.f r3, Continuation<? super DataTransferViewModel$buildPostRestoreHook$1$onPostRestore$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
