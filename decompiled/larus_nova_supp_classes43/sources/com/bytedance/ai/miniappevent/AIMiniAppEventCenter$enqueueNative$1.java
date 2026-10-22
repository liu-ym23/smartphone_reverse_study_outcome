package com.bytedance.ai.miniappevent;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.miniappevent.AIMiniAppEventCenter$enqueueNative$1", f = "AIMiniAppEventCenter.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
public final class AIMiniAppEventCenter$enqueueNative$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $event;
    final /* synthetic */ AIMiniAppEventCenter.c $eventNotify;
    int label;

    public AIMiniAppEventCenter$enqueueNative$1(AIMiniAppEventCenter.c r1, a r10, Continuation<? super AIMiniAppEventCenter$enqueueNative$1> r11) {
        this.$eventNotify = r1;
        this.$event = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIMiniAppEventCenter$enqueueNative$1(this.$eventNotify, this.$event, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AIMiniAppEventCenter r11 = AIMiniAppEventCenter.a;
        AIMiniAppEventCenter.c r12 = this.$eventNotify;
        AIMiniAppEventCenter.b r13 = new AIMiniAppEventCenter.b(com.bytedance.android.ec.core.event.a.VALUE_NATIVE, this.$event.e.getWireValue(), true);
        this.label = 1;
        if (AIMiniAppEventCenter.a(r11, r12, r13, this) != r0) goto L12;
        return r0;
    }
}
