package com.obric.assistant.session.singleton;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatContextService;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
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
@DebugMetadata(c = "com.obric.assistant.session.singleton.DoraWakeupDetector$cancel$1", f = "DoraWakeupDetector.kt", i = {}, l = {358}, m = "invokeSuspend", n = {}, s = {})
public final class DoraWakeupDetector$cancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraWakeupDetector$cancel$1(Continuation<? super DoraWakeupDetector$cancel$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraWakeupDetector$cancel$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        if (DoraWakeupDetector.c == true) goto L42;
        if (DoraWakeupDetector.d == true) goto L42;
        FLogger r9 = FLogger.a;
        r9.i("DoraWakeupDetector", "cancel, invoke closeClickTalk");
        DoraWakeupDetector r3 = DoraWakeupDetector.a;
        t1a.b r4 = IObricChatContextService.a.a(ObricChatContextServiceDelegate.b);
        if (r4 == null) goto L18;
        maa.e r5 = (maa.e) r4.getAbility(maa.e.class);
    L19:
        r9.w("DoraWakeupDetector", "tryCloseClickTalk: chatClickTalkAbility = " + r5 + ", VContext = " + r4);
        if (r4 == null) goto L26;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r6 = r4.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r6 == null) goto L26;
        if (r6.m0() != true) goto L26;
        boolean r7 = true;
    L27:
        if (r7 == false) goto L40;
        if (r4 == null) goto L34;
        laa.d r10 = r4.getAbility(laa.d.class);
        if (r10 == null) goto L34;
        if (r10.Da() != true) goto L34;
    L35:
        if (r2 == true) goto L37;
        if (r5 == null) goto L40;
    L37:
        if (r5 == null) goto L39;
        maa.e.a.a(r5, null, null, false, 7);
    L39:
        aga.j.m();
    L34:
        r2 = false;
    L40:
        DoraWakeupDetector.h();
    L26:
        r7 = false;
        goto L27
    L18:
        r5 = null;
    L42:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L12;
        return r0;
    }
}
