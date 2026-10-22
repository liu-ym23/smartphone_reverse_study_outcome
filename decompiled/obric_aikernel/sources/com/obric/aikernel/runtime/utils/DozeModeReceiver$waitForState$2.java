package com.obric.aikernel.runtime.utils;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.utils.DozeModeReceiver$waitForState$2", f = "DozeModeReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DozeModeReceiver$waitForState$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $expected;
    /* synthetic */ boolean Z$0;
    int label;

    DozeModeReceiver$waitForState$2(boolean r10, Continuation<? super DozeModeReceiver$waitForState$2> r11) {
        this.$expected = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        DozeModeReceiver$waitForState$2 r12 = new DozeModeReceiver$waitForState$2(this.$expected, r11);
        r12.Z$0 = ((Boolean) r10).booleanValue();
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean r10, Continuation<? super Boolean> r11) {
        return invoke(r10.booleanValue(), r11);
    }

    public final Object invoke(boolean r10, Continuation<? super Boolean> r11) {
        return ((DozeModeReceiver$waitForState$2) create(Boolean.valueOf(r10), r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r10);
        if (this.Z$0 != this.$expected) goto L7;
        boolean r11 = true;
    L9:
        return Boxing.boxBoolean(r11);
    L7:
        r11 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
