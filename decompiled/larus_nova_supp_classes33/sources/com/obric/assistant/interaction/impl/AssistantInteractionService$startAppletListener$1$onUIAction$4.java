package com.obric.assistant.interaction.impl;

import com.larus.audio.AudioServiceDelegate;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
@DebugMetadata(c = "com.obric.assistant.interaction.impl.AssistantInteractionService$startAppletListener$1$onUIAction$4", f = "AssistantInteractionService.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
public final class AssistantInteractionService$startAppletListener$1$onUIAction$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AssistantInteractionService this$0;

    public AssistantInteractionService$startAppletListener$1$onUIAction$4(AssistantInteractionService r1, Continuation<? super AssistantInteractionService$startAppletListener$1$onUIAction$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AssistantInteractionService$startAppletListener$1$onUIAction$4(this.this$0, r3);
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
    L11:
        AudioServiceDelegate r7 = AudioServiceDelegate.a;
        if (r7.i0().a() == true) goto L39;
        IDoraWakeupService r3 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r3 != null) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == true) goto L39;
        if (r7.F().b() == false) goto L39;
        IDoraWakeupService r8 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r8 != null) goto L25;
    L27:
        boolean r9 = false;
    L28:
        if (r9 == true) goto L39;
        IDoraWakeupService r10 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r10 != null) goto L32;
    L34:
        r2 = false;
    L35:
        if (r2 == false) goto L39;
        IDoraWakeupService r11 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r11 == null) goto L39;
        r11.p();
        goto L39
    L32:
        if (r10.e() == true) goto L34;
    L25:
        if (r8.f() != true) goto L27;
        r9 = true;
        goto L28
    L16:
        if (r3.o() != true) goto L18;
        r4 = true;
    L39:
        AssistantInteractionService.access$setStopVUIJob$p(this.this$0, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(2000, this) != r0) goto L11;
        return r0;
    }
}
