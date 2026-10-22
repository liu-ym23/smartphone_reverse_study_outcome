package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
final class FlowKt__LimitKt$drop$2$1<T> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.IntRef f10413c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ int f10414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ d<T> f10415h;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__LimitKt$drop$2$1(Ref.IntRef r10, int r11, d<? super T> r12) {
        this.f10413c = r10;
        this.f10414g = r11;
        this.f10415h = r12;
    }

    @Override // kotlinx.coroutines.flow.d
    public final Object emit(T r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof FlowKt__LimitKt$drop$2$1$emit$1) == false) goto L7;
        FlowKt__LimitKt$drop$2$1$emit$1 r12 = (FlowKt__LimitKt$drop$2$1$emit$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L20:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        Ref.IntRef r17 = this.f10413c;
        int r18 = r17.element;
        if (r18 < this.f10414g) goto L21;
        d<T> r19 = this.f10415h;
        r12.label = 1;
        if (r19.emit(r10, r12) != r15) goto L20;
        return r15;
    L21:
        r17.element = r18 + 1;
        return Unit.INSTANCE;
    L7:
        r12 = new FlowKt__LimitKt$drop$2$1$emit$1(this, r11);
        goto L8
    }
}
