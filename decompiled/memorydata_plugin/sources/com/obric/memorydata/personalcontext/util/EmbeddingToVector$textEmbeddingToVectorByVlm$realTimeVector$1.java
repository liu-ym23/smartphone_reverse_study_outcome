package com.obric.memorydata.personalcontext.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.util.EmbeddingToVector$textEmbeddingToVectorByVlm$realTimeVector$1", f = "EmbeddingToVector.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
final class EmbeddingToVector$textEmbeddingToVectorByVlm$realTimeVector$1 extends SuspendLambda implements Function2<al, Continuation<? super float[]>, Object> {
    final /* synthetic */ String $foregroundCallerPkg;
    final /* synthetic */ String $query;
    int label;

    EmbeddingToVector$textEmbeddingToVectorByVlm$realTimeVector$1(String r3, String r4, Continuation<? super EmbeddingToVector$textEmbeddingToVectorByVlm$realTimeVector$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$query = r3;
        this.$foregroundCallerPkg = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EmbeddingToVector$textEmbeddingToVectorByVlm$realTimeVector$1(this.$query, this.$foregroundCallerPkg, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super float[]> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super float[]> r4) {
        return ((EmbeddingToVector$textEmbeddingToVectorByVlm$realTimeVector$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EmbeddingToVector$textEmbeddingToVectorByVlm$realTimeVector$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        com.obric.memorydata.aikernelcore.a r2 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        String r11 = this.$query;
        String r3 = this.$foregroundCallerPkg;
        Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r10 = com.obric.memorydata.aikernelcore.a.a(r2, r11, r3, false, true, r6, 4, null);
        if (r10 != r0) goto L11;
        return r0;
    }
}
