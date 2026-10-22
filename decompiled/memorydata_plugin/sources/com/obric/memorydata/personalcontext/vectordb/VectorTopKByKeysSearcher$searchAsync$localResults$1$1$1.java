package com.obric.memorydata.personalcontext.vectordb;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/memorydata/personalcontext/vectordb/VectorTopKByKeysSearcher$ScoredKey;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.vectordb.VectorTopKByKeysSearcher$searchAsync$localResults$1$1$1", f = "VectorTopKByKeysSearcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VectorTopKByKeysSearcher$searchAsync$localResults$1$1$1 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends h.b>>, Object> {
    final /* synthetic */ Float $minScore;
    final /* synthetic */ List<Long> $partition;
    final /* synthetic */ double $queryNorm;
    final /* synthetic */ float[] $queryVector;
    final /* synthetic */ int $resultLimit;
    final /* synthetic */ Function1<Long, float[]> $vectorReader;
    int label;
    final /* synthetic */ h this$0;

    VectorTopKByKeysSearcher$searchAsync$localResults$1$1$1(h r3, float[] r4, double r5, List<Long> r7, int r8, Float r9, Function1<? super Long, float[]> r10, Continuation<? super VectorTopKByKeysSearcher$searchAsync$localResults$1$1$1> r11) {
        List<Long> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Function1<Long, float[]> r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$queryVector = r4;
        this.$queryNorm = r5;
        this.$partition = r12;
        this.$resultLimit = r8;
        this.$minScore = r9;
        this.$vectorReader = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new VectorTopKByKeysSearcher$searchAsync$localResults$1$1$1(this.this$0, this.$queryVector, this.$queryNorm, this.$partition, this.$resultLimit, this.$minScore, this.$vectorReader, r10), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends h.b>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super List<h.b>> r4) {
        return ((VectorTopKByKeysSearcher$searchAsync$localResults$1$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), VectorTopKByKeysSearcher$searchAsync$localResults$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        return h.a(this.this$0, this.$queryVector, this.$queryNorm, this.$partition, this.$resultLimit, this.$minScore, this.$vectorReader);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
