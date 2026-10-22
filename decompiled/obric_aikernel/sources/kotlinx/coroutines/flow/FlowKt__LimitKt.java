package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,141:1\n1#2:142\n107#3:143\n107#3:144\n107#3:145\n107#3:146\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n22#1:143\n33#1:144\n52#1:145\n83#1:146\n*E\n"})
final /* synthetic */ class FlowKt__LimitKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,113:1\n23#2,5:114\n*E\n"})
    public static final class a<T> implements c<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f10410c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f10411g;

        public a(c r10, int r11) {
            this.f10410c = r10;
            this.f10411g = r11;
        }

        @Override // kotlinx.coroutines.flow.c
        public Object a(d<? super T> r10, Continuation<? super Unit> r11) {
            Ref.IntRef r12 = new Ref.IntRef();
            Object r13 = this.f10410c.a(new FlowKt__LimitKt$drop$2$1(r12, this.f10411g, r10), r11);
            if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r13;
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ Object a(d r10, Object r11, Continuation r12) {
        return d(r10, r11, r12);
    }

    public static final <T> Object b(c<? extends T> r10, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof FlowKt__LimitKt$collectWhile$1) == false) goto L7;
        FlowKt__LimitKt$collectWhile$1 r13 = (FlowKt__LimitKt$collectWhile$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        d<? super Object> r18 = (FlowKt__LimitKt$collectWhile$collector$1) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: AbortFlowException -> L14
    L26:
        return Unit.INSTANCE;
    L14:
        e = e;
    L24:
        kotlinx.coroutines.flow.internal.j.a(e, r18);
        goto L26
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        d<? super Object> r19 = new FlowKt__LimitKt$collectWhile$collector$1(r11);
        r13.L$0 = r19;     // Catch: AbortFlowException -> L22
        r13.label = 1;     // Catch: AbortFlowException -> L22
        if (r10.a(r19, r13) != r16) goto L26;
        return r16;
    L22:
        e = e;
        r18 = r19;
    L7:
        r13 = new FlowKt__LimitKt$collectWhile$1(r12);
        goto L8
    }

    public static final <T> c<T> c(c<? extends T> r10, int r11) {
        if (r11 < 0) goto L4;
        boolean r12 = true;
    L5:
        if (r12 == false) goto L9;
        return new a(r10, r11);
    L9:
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + r11).toString());
    L4:
        r12 = false;
        goto L5
    }

    private static final <T> Object d(d<? super T> r10, T r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof FlowKt__LimitKt$emitAbort$1) == false) goto L7;
        FlowKt__LimitKt$emitAbort$1 r13 = (FlowKt__LimitKt$emitAbort$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L12;
        r10 = (d) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L18:
        throw new AbortFlowException(r10);
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        r13.L$0 = r10;
        r13.label = 1;
        if (r10.emit(r11, r13) != r16) goto L18;
        return r16;
    L7:
        r13 = new FlowKt__LimitKt$emitAbort$1(r12);
        goto L8
    }
}
