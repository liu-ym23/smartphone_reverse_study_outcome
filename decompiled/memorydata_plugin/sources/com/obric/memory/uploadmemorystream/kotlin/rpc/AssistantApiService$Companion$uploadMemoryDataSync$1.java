package com.obric.memory.uploadmemorystream.kotlin.rpc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@"}, d2 = {"uploadMemoryDataSync", "", "req", "Lcom/obric/memory/uploadmemorystream/kotlin/UploadMemoryDataRequest;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/memory/uploadmemorystream/kotlin/UploadMemoryDataResponse;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.obric.memory.uploadmemorystream.kotlin.rpc.AssistantApiService$Companion", f = "AssistantApiService.kt", i = {0, 0, 1, 1}, l = {19, 19}, m = "uploadMemoryDataSync", n = {"this", "req", "this", "req"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class AssistantApiService$Companion$uploadMemoryDataSync$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a.C0412a this$0;

    AssistantApiService$Companion$uploadMemoryDataSync$1(a.C0412a r3, Continuation r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
