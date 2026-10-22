package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f18834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f18835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f18836c;

    public d(e r5, Ref.ObjectRef r10, h r11) {
        this.f18834a = r5;
        this.f18835b = r10;
        this.f18836c = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r10, Continuation r11) {
        if ((r11 instanceof DistinctFlowImpl$collect$2$emit$1) == false) goto L7;
        DistinctFlowImpl$collect$2$emit$1 r5 = (DistinctFlowImpl$collect$2$emit$1) r11;
        int r12 = r5.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L25:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        this.f18834a.getClass();
        Ref.ObjectRef r16 = this.f18835b;
        T r17 = r16.element;
        if (r17 != kotlinx.coroutines.flow.internal.b.f18863b) goto L17;
    L21:
        r16.element = r10;
        r5.label = 1;
        if (this.f18836c.emit(r10, r5) != r14) goto L25;
        return r14;
    L17:
        if (Intrinsics.areEqual(r17, r10) == false) goto L21;
        return Unit.INSTANCE;
    L7:
        r5 = new DistinctFlowImpl$collect$2$emit$1(this, r11);
        goto L8
    }
}
