package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", f = "Merge.kt", i = {}, l = {193, 193}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1\n*L\n1#1,218:1\n*E\n"})
public final class FlowKt__MergeKt$flatMapLatest$1 extends SuspendLambda implements Function3<d<Object>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super c<Object>>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$flatMapLatest$1(Function2<Object, ? super Continuation<? super c<Object>>, ? extends Object> r10, Continuation<? super FlowKt__MergeKt$flatMapLatest$1> r11) {
        this.$transform = r10;
        super(3, r11);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(d<Object> r10, Object r11, Continuation<? super Unit> r12) {
        return invoke2(r10, r11, r12);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(d<Object> r10, Object r11, Continuation<? super Unit> r12) {
        FlowKt__MergeKt$flatMapLatest$1 r13 = new FlowKt__MergeKt$flatMapLatest$1(this.$transform, r12);
        r13.L$0 = r10;
        r13.L$1 = r11;
        return r13.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        d r13 = (d) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        this.L$0 = null;
        this.label = 2;
        if (e.n(r13, (c) r10, this) != r11) goto L17;
        return r11;
    L10:
        ResultKt.throwOnFailure(r10);
        r13 = (d) this.L$0;
        Object r14 = this.L$1;
        Function2<Object, Continuation<? super c<Object>>, Object> r15 = this.$transform;
        this.L$0 = r13;
        this.label = 1;
        r10 = r15.invoke(r14, this);
        if (r10 != r11) goto L13;
        return r11;
    }

    public final Object invokeSuspend$$forInline(Object r10) {
        d r11 = (d) this.L$0;
        Object r12 = this.L$1;
        c r13 = (c) this.$transform.invoke(r12, this);
        InlineMarker.mark(0);
        e.n(r11, r13, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
