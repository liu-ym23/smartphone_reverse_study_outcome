package com.obric.memorydata.personalcontext.vectordb;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.vectordb.VectorTopKByKeysSearcher$search$1", f = "VectorTopKByKeysSearcher.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
final class VectorTopKByKeysSearcher$search$1 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends Pair<? extends Long, ? extends Float>>>, Object> {
    final /* synthetic */ List<Long> $keys;
    final /* synthetic */ int $limit;
    final /* synthetic */ Float $minScore;
    final /* synthetic */ float[] $queryVector;
    final /* synthetic */ Function1<Long, float[]> $vectorReader;
    int label;
    final /* synthetic */ h this$0;

    VectorTopKByKeysSearcher$search$1(h r3, float[] r4, List<Long> r5, int r6, Float r7, Function1<? super Long, float[]> r8, Continuation<? super VectorTopKByKeysSearcher$search$1> r9) {
        List<Long> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Function1<Long, float[]> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$queryVector = r4;
        this.$keys = r10;
        this.$limit = r6;
        this.$minScore = r7;
        this.$vectorReader = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new VectorTopKByKeysSearcher$search$1(this.this$0, this.$queryVector, this.$keys, this.$limit, this.$minScore, this.$vectorReader, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends Pair<? extends Long, ? extends Float>>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super List<Pair<Long, Float>>> r4) {
        return ((VectorTopKByKeysSearcher$search$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), VectorTopKByKeysSearcher$search$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
        h r2 = this.this$0;
        float[] r11 = this.$queryVector;
        List<Long> r3 = this.$keys;
        int r4 = this.$limit;
        Float r5 = this.$minScore;
        Function1<Long, float[]> r6 = this.$vectorReader;
        Continuation<? super List<Pair<Long, Float>>> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r10 = r2.a(r11, r3, r4, r5, r6, r7);
        if (r10 != r0) goto L11;
        return r0;
    }
}
