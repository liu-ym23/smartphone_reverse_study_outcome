package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n107#2,5:142\n*E\n"})
public final class FlowKt__ReduceKt$first$$inlined$collectWhile$2<T> implements d<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2 f10424c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f10425g;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2$1, reason: invalid class name */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2", f = "Reduce.kt", i = {0, 0}, l = {142}, m = "emit", n = {"this", "it"}, s = {"L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1$emit$1\n*L\n1#1,141:1\n*E\n"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__ReduceKt$first$$inlined$collectWhile$2 this$0;

        public AnonymousClass1(FlowKt__ReduceKt$first$$inlined$collectWhile$2 r10, Continuation r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.emit(null, this);
        }
    }

    public FlowKt__ReduceKt$first$$inlined$collectWhile$2(Function2 r10, Ref.ObjectRef r11) {
        this.f10424c = r10;
        this.f10425g = r11;
    }

    @Override // kotlinx.coroutines.flow.d
    public Object emit(T r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r12 = (AnonymousClass1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        boolean r17 = true;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (T) r12.L$1;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2<T> this = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        if (((Boolean) r14).booleanValue() == false) goto L20;
        T r18 = r10;
        this.f10425g.element = r18;
        r17 = false;
    L20:
        if (r17 == false) goto L24;
        return Unit.INSTANCE;
    L24:
        throw new AbortFlowException(this);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        Function2 r19 = this.f10424c;
        r12.L$0 = this;
        r12.L$1 = r10;
        r12.label = 1;
        InlineMarker.mark(6);
        r14 = r19.invoke(r10, r12);
        InlineMarker.mark(7);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r12 = new AnonymousClass1(this, r11);
        goto L8
    }
}
