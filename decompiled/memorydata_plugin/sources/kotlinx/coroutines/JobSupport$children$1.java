package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/Job;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {963, 965}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super bx>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ce this$0;

    JobSupport$children$1(ce r3, Continuation<? super JobSupport$children$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        JobSupport$children$1 r0 = new JobSupport$children$1(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(SequenceScope<? super bx> r3, Continuation<? super Unit> r4) {
        return invoke2((SequenceScope) ZeusTransformUtils.preCheckCast(r3, SequenceScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super bx> r3, Continuation<? super Unit> r4) {
        return ((JobSupport$children$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), JobSupport$children$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00b5 -> B:27:0x00d0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00cd -> B:27:0x00d0). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        kotlinx.coroutines.internal.v r2 = (kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(this.L$2, kotlinx.coroutines.internal.v.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.internal.t r3 = (kotlinx.coroutines.internal.t) ZeusTransformUtils.preCheckCast(this.L$1, kotlinx.coroutines.internal.t.class, "com.obric.memorydata.plugin");
        SequenceScope r5 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L27:
        r2 = r2.g();
    L21:
        if (Intrinsics.areEqual(r2, r3) == true) goto L29;
        if (ZeusTransformUtils.instanceOf(r2, u.class) == false) goto L27;
        v r10 = ((u) ZeusTransformUtils.preCheckCast(r2, u.class, "com.obric.memorydata.plugin")).f17661a;
        this.L$0 = r5;
        this.L$1 = r3;
        this.L$2 = r2;
        this.label = 2;
        if (r5.yield(r10, this) != r0) goto L27;
        return r0;
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
        goto L29
    L10:
        ResultKt.throwOnFailure(r9);
        SequenceScope r11 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
        Object r4 = this.this$0.o();
        if (ZeusTransformUtils.instanceOf(r4, u.class) == false) goto L16;
        v r6 = ((u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.memorydata.plugin")).f17661a;
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r11.yield(r6, r7) != r0) goto L29;
        return r0;
    L16:
        if (ZeusTransformUtils.instanceOf(r4, br.class) == false) goto L29;
        cj r8 = ((br) ZeusTransformUtils.preCheckCast(r4, br.class, "com.obric.memorydata.plugin")).n_();
        if (r8 == null) goto L29;
        kotlinx.coroutines.internal.t r12 = (kotlinx.coroutines.internal.t) ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.internal.t.class, "com.obric.memorydata.plugin");
        Object r13 = r12.f();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        kotlinx.coroutines.internal.v r14 = (kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(r13, kotlinx.coroutines.internal.v.class, "com.obric.memorydata.plugin");
        r5 = r11;
        r3 = r12;
        r2 = r14;
        goto L21
    }
}
