package com.obric.memorydata.personalcontext.vectordb;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/memorydata/personalcontext/vectordb/VectorTopKByKeysSearcher$ScoredKey;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.vectordb.VectorTopKByKeysSearcher$searchAsync$localResults$1", f = "VectorTopKByKeysSearcher.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
final class VectorTopKByKeysSearcher$searchAsync$localResults$1 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends List<? extends h.b>>>, Object> {
    final /* synthetic */ Float $minScore;
    final /* synthetic */ double $queryNorm;
    final /* synthetic */ float[] $queryVector;
    final /* synthetic */ int $resultLimit;
    final /* synthetic */ Function1<Long, float[]> $vectorReader;
    final /* synthetic */ List<List<Long>> $workerKeys;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ h this$0;

    VectorTopKByKeysSearcher$searchAsync$localResults$1(List<? extends List<Long>> r3, h r4, float[] r5, double r6, int r8, Float r9, Function1<? super Long, float[]> r10, Continuation<? super VectorTopKByKeysSearcher$searchAsync$localResults$1> r11) {
        List<List<Long>> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Function1<Long, float[]> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        this.$workerKeys = r7;
        this.this$0 = r4;
        this.$queryVector = r5;
        this.$queryNorm = r6;
        this.$resultLimit = r8;
        this.$minScore = r9;
        this.$vectorReader = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        VectorTopKByKeysSearcher$searchAsync$localResults$1 r15 = new VectorTopKByKeysSearcher$searchAsync$localResults$1(this.$workerKeys, this.this$0, this.$queryVector, this.$queryNorm, this.$resultLimit, this.$minScore, this.$vectorReader, r11);
        r15.L$0 = r13;
        return (Continuation) ZeusTransformUtils.preCheckCast(r15, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends List<? extends h.b>>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super List<? extends List<h.b>>> r4) {
        return ((VectorTopKByKeysSearcher$searchAsync$localResults$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), VectorTopKByKeysSearcher$searchAsync$localResults$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r28) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r28);
        return r28;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r28);
        al r3 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.$workerKeys, Iterable.class, "com.obric.memorydata.plugin");
        h r15 = this.this$0;
        float[] r14 = this.$queryVector;
        double r12 = this.$queryNorm;
        int r11 = this.$resultLimit;
        Float r9 = this.$minScore;
        Function1<Long, float[]> r10 = this.$vectorReader;
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        List r16 = (List) ZeusTransformUtils.preCheckCast(r5.next(), List.class, "com.obric.memorydata.plugin");
        Collection r20 = r8;
        Float r21 = r9;
        Function1<Long, float[]> r22 = r10;
        int r23 = r11;
        r20.add(i.b(r3, (CoroutineContext) ZeusTransformUtils.preCheckCast(h.a(r15), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new VectorTopKByKeysSearcher$searchAsync$localResults$1$1$1(r15, r14, r12, r16, r23, r21, r22, null), Function2.class, "com.obric.memorydata.plugin"), 2, null));
        r8 = r20;
        r14 = r14;
        r9 = r21;
        r10 = r22;
        r11 = r23;
        r12 = r12;
        r15 = r15;
        goto L10
    L12:
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        Object r0 = kotlinx.coroutines.f.a(r6, r7);
        if (r0 != r1) goto L17;
        return r1;
    L17:
        return r0;
    }
}
