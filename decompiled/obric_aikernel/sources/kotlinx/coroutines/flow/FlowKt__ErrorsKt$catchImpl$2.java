package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
final class FlowKt__ErrorsKt$catchImpl$2<T> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d<T> f10408c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef<Throwable> f10409g;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ErrorsKt$catchImpl$2(d<? super T> r10, Ref.ObjectRef<Throwable> r11) {
        this.f10408c = r10;
        this.f10409g = r11;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Throwable] */
    @Override // kotlinx.coroutines.flow.d
    public final Object emit(T r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof FlowKt__ErrorsKt$catchImpl$2$emit$1) == false) goto L7;
        FlowKt__ErrorsKt$catchImpl$2$emit$1 r12 = (FlowKt__ErrorsKt$catchImpl$2$emit$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 != 1) goto L15;
        FlowKt__ErrorsKt$catchImpl$2 r17 = (FlowKt__ErrorsKt$catchImpl$2) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
    L20:
        FlowKt__ErrorsKt$catchImpl$2<T> this = (FlowKt__ErrorsKt$catchImpl$2<T>) Unit.INSTANCE;
        return this;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r14);
        d<T> r18 = this.f10408c;     // Catch: Throwable -> L22
        r12.L$0 = this;     // Catch: Throwable -> L22
        r12.label = 1;     // Catch: Throwable -> L22
        if (r18.emit(r10, r12) != r15) goto L20;
        return r15;
    L22:
        th = move-exception;
        r5 = (T) th;
        this.f10409g.element = r5;
        throw r5;
    L7:
        r12 = new FlowKt__ErrorsKt$catchImpl$2$emit$1(this, r11);
        goto L8
    }
}
