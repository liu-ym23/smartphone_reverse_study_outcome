package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends d {
    public final kotlinx.coroutines.flow.g d;

    public f(kotlinx.coroutines.flow.g r5, CoroutineContext r10, int r11, BufferOverflow r12) {
        super(r10, r11, r12);
        this.d = r5;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final Object c(kotlinx.coroutines.channels.u r5, Continuation r10) {
        Object r11 = g(new w(r5), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d, kotlinx.coroutines.flow.g
    public final Object collect(kotlinx.coroutines.flow.h r5, Continuation r10) {
        if (this.f18866b != (-3)) goto L26;
        CoroutineContext r11 = r10.getContext();
        Boolean r12 = Boolean.FALSE;
        com.bytedance.ai.applet.components.view.a r13 = new com.bytedance.ai.applet.components.view.a(1);
        CoroutineContext r14 = this.f18865a;
        if (((Boolean) r14.fold(r12, r13)).booleanValue() == true) goto L7;
        CoroutineContext r15 = r11.plus(r14);
    L9:
        if (Intrinsics.areEqual(r15, r11) == false) goto L14;
        Object r16 = g(r5, r10);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        return r16;
    L31:
        return Unit.INSTANCE;
    L14:
        ContinuationInterceptor.Key r17 = ContinuationInterceptor.Key;
        if (Intrinsics.areEqual(r15.get(r17), r11.get(r17)) == false) goto L26;
        CoroutineContext r18 = r10.getContext();
        if ((r5 instanceof w) == false) goto L19;
    L22:
        ChannelFlowOperator$collectWithContextUndispatched$2 r19 = new ChannelFlowOperator$collectWithContextUndispatched$2(this, null);
        Object r20 = b.b(r15, r5, kotlinx.coroutines.internal.v.b(r15), r19, r10);
        if (r20 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L32;
        return r20;
    L32:
        return Unit.INSTANCE;
    L19:
        if ((r5 instanceof t) == true) goto L22;
        r5 = new z(r5, r18);
        goto L22
    L7:
        r15 = kotlinx.coroutines.x.a(r11, r14, false);
    L26:
        Object r21 = super.collect(r5, r10);
        if (r21 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
        return r21;
    L30:
        return Unit.INSTANCE;
    }

    public abstract Object g(kotlinx.coroutines.flow.h r5, Continuation r10);

    @Override // kotlinx.coroutines.flow.internal.d
    public final String toString() {
        return this.d + " -> " + super.toString();
    }
}
