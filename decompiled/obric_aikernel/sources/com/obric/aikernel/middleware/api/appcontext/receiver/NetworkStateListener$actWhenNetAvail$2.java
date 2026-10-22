package com.obric.aikernel.middleware.api.appcontext.receiver;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes2.dex */
final class NetworkStateListener$actWhenNetAvail$2<T> implements kotlinx.coroutines.flow.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2<Boolean, Continuation<? super Unit>, Object> f4517c;

    /* JADX WARN: Multi-variable type inference failed */
    NetworkStateListener$actWhenNetAvail$2(Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object> r10) {
        this.f4517c = r10;
    }

    public final Object a(boolean r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof NetworkStateListener$actWhenNetAvail$2$emit$1) == false) goto L7;
        NetworkStateListener$actWhenNetAvail$2$emit$1 r12 = (NetworkStateListener$actWhenNetAvail$2$emit$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        ResultKt.throwOnFailure(r14);
    L23:
        y1.d(r12.getContext(), null, 1, null);
    L25:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = r12.Z$0;
        NetworkStateListener$actWhenNetAvail$2<T> this = (NetworkStateListener$actWhenNetAvail$2) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L19:
        if (r10 == false) goto L25;
        Function2<Boolean, Continuation<? super Unit>, Object> r17 = this.f4517c;
        Boolean r18 = Boxing.boxBoolean(false);
        r12.L$0 = null;
        r12.label = 2;
        if (r17.invoke(r18, r12) != r15) goto L23;
        return r15;
    L16:
        ResultKt.throwOnFailure(r14);
        r12.L$0 = this;
        r12.Z$0 = r10;
        r12.label = 1;
        if (DelayKt.b(1000, r12) != r15) goto L19;
        return r15;
    L7:
        r12 = new NetworkStateListener$actWhenNetAvail$2$emit$1(this, r11);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.d
    public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
        return a(((Boolean) r10).booleanValue(), r11);
    }
}
