package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class FlowKt__CountKt {

    static final class a<T> implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f10399c;

        a(Ref.IntRef r10) {
            this.f10399c = r10;
        }

        @Override // kotlinx.coroutines.flow.d
        public final Object emit(T r10, Continuation<? super Unit> r11) {
            this.f10399c.element++;
            return Unit.INSTANCE;
        }
    }

    public static final <T> Object a(c<? extends T> r10, Continuation<? super Integer> r11) {
        if ((r11 instanceof FlowKt__CountKt$count$1) == false) goto L7;
        FlowKt__CountKt$count$1 r12 = (FlowKt__CountKt$count$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Ref.IntRef r17 = (Ref.IntRef) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L19:
        return Boxing.boxInt(r17.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        Ref.IntRef r18 = new Ref.IntRef();
        d<? super Object> r19 = new a(r18);
        r12.L$0 = r18;
        r12.label = 1;
        if (r10.a(r19, r12) != r15) goto L17;
        return r15;
    L17:
        r17 = r18;
    L7:
        r12 = new FlowKt__CountKt$count$1(r11);
        goto L8
    }

    public static final <T> Object b(c<? extends T> r10, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super Integer> r12) {
        if ((r12 instanceof FlowKt__CountKt$count$3) == false) goto L7;
        FlowKt__CountKt$count$3 r13 = (FlowKt__CountKt$count$3) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        Ref.IntRef r18 = (Ref.IntRef) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L19:
        return Boxing.boxInt(r18.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        Ref.IntRef r19 = new Ref.IntRef();
        d<? super Object> r20 = new FlowKt__CountKt$count$4(r11, r19);
        r13.L$0 = r19;
        r13.label = 1;
        if (r10.a(r20, r13) != r16) goto L17;
        return r16;
    L17:
        r18 = r19;
    L7:
        r13 = new FlowKt__CountKt$count$3(r12);
        goto L8
    }
}
