package com.obric.assistant.chat;

import com.larus.audio.AudioServiceDelegate;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.ObricChatService$stopVUIforNoTts$1", f = "ObricChatService.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, s = {})
final class ObricChatService$stopVUIforNoTts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricChatService this$0;

    public ObricChatService$stopVUIforNoTts$1(ObricChatService r1, Continuation<? super ObricChatService$stopVUIforNoTts$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricChatService$stopVUIforNoTts$1(this.this$0, r3);
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
    L14:
        AudioServiceDelegate r7 = AudioServiceDelegate.a;
        if (r7.i0().a() == true) goto L39;
        IDoraWakeupService r3 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r3 != null) goto L19;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == true) goto L39;
        if (r7.F().b() == false) goto L39;
        IDoraWakeupService r8 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r8 != null) goto L28;
    L30:
        r2 = false;
    L31:
        if (r2 == true) goto L39;
        IDoraWakeupService r9 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r9 == null) goto L37;
        r9.p();
    L37:
        return Unit.INSTANCE;
    L28:
        if (r8.e() != true) goto L30;
    L19:
        if (r3.o() != true) goto L21;
        r4 = true;
    L39:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        boolean r10 = IKeyguardStateKt.getKeyguardState().isKeyguardLocked();
        ObricChatService r5 = this.this$0;
        List r11 = ObricChatService.m;
        if (r5.x() == true) goto L11;
        if (r10 == false) goto L14;
    L11:
        this.label = 1;
        if (DelayKt.delay(2000, this) != r0) goto L14;
        return r0;
    }
}
