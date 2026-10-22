package com.obric.assistant.session.singleton;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.session.model.IAiKeyOperation;
import com.obric.assistant.session.model.IDoraOperation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.singleton.DoraWakeupDetector$cancel$2", f = "DoraWakeupDetector.kt", i = {}, l = {371}, m = "invokeSuspend", n = {}, s = {})
public final class DoraWakeupDetector$cancel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraWakeupDetector$cancel$2(Continuation<? super DoraWakeupDetector$cancel$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraWakeupDetector$cancel$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        if (DoraWakeupDetector.c == true) goto L33;
        if (DoraWakeupDetector.d == true) goto L33;
        FLogger r7 = FLogger.a;
        r7.i("DoraWakeupDetector", "cancel, listener = " + DoraWakeupDetector.b);
        IAiKeyOperation r3 = bga.b.a();
        if (r3 != null) goto L18;
    L20:
        boolean r4 = false;
    L21:
        if (r4 == true) goto L29;
        IDoraOperation r5 = bga.f.a();
        if (r5 != null) goto L25;
    L27:
        r2 = false;
    L28:
        if (r2 == false) goto L33;
    L25:
        if (r5.b() != true) goto L27;
    L29:
        r7.i("DoraWakeupDetector", "cancel, invoke onDoraRadioStop");
        DoraWakeupDetector r8 = DoraWakeupDetector.a;
        DoraWakeupDetector.a r9 = DoraWakeupDetector.c("cancel radio stop");
        if (r9 == null) goto L33;
        r9.a();
        goto L33
    L18:
        if (r3.isAiKeyPressing() != true) goto L20;
        r4 = true;
    L33:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L12;
        return r0;
    }
}
