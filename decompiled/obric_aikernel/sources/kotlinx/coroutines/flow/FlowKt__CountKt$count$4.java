package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
final class FlowKt__CountKt$count$4<T> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> f10400c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Ref.IntRef f10401g;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__CountKt$count$4(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r10, Ref.IntRef r11) {
        this.f10400c = r10;
        this.f10401g = r11;
    }

    @Override // kotlinx.coroutines.flow.d
    public final Object emit(T r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof FlowKt__CountKt$count$4$emit$1) == false) goto L7;
        FlowKt__CountKt$count$4$emit$1 r12 = (FlowKt__CountKt$count$4$emit$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        FlowKt__CountKt$count$4<T> this = (FlowKt__CountKt$count$4) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        if (((Boolean) r14).booleanValue() == false) goto L21;
        this.f10401g.element++;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        Function2<T, Continuation<? super Boolean>, Object> r17 = this.f10400c;
        r12.L$0 = this;
        r12.label = 1;
        r14 = r17.invoke(r10, r12);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r12 = new FlowKt__CountKt$count$4$emit$1(this, r11);
        goto L8
    }
}
