package com.obric.audio.continuous_talk;

import com.obric.assistant.spi.chat.IObricChatSPIService;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousTalkUIComponent$invokeOnSpeak$1$7", f = "ObricContinuousTalkUIComponent.kt", i = {}, l = {380}, m = "invokeSuspend", n = {}, s = {})
final class ObricContinuousTalkUIComponent$invokeOnSpeak$1$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $convId;
    int label;

    public ObricContinuousTalkUIComponent$invokeOnSpeak$1$7(String r1, Continuation<? super ObricContinuousTalkUIComponent$invokeOnSpeak$1$7> r2) {
        this.$convId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricContinuousTalkUIComponent$invokeOnSpeak$1$7(this.$convId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L13:
        Boolean r11 = (Boolean) r10;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        IObricChatSPIService r3 = (IObricChatSPIService) ServiceManager.get().getService(IObricChatSPIService.class);
        if (r3 == null) goto L15;
        String r4 = this.$convId;
        this.label = 1;
        r10 = IObricChatSPIService.a.a(r3, r4, false, null, this, 6);
        if (r10 != r0) goto L13;
        return r0;
    }
}
