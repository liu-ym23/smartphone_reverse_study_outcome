package com.obric.assistant.component.clicktalk;

import android.os.Build;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
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
@DebugMetadata(c = "com.obric.assistant.component.clicktalk.ChatClickTalkComponent$closeClickTalk$3", f = "ChatClickTalkComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatClickTalkComponent$closeClickTalk$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $suppressCloseHaptic;
    int label;
    final /* synthetic */ ChatClickTalkComponent this$0;

    public ChatClickTalkComponent$closeClickTalk$3(ChatClickTalkComponent r1, boolean r2, Continuation<? super ChatClickTalkComponent$closeClickTalk$3> r3) {
        this.this$0 = r1;
        this.$suppressCloseHaptic = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatClickTalkComponent$closeClickTalk$3(this.this$0, this.$suppressCloseHaptic, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r6);
        ChatClickTalkComponent r7 = this.this$0;
        int r0 = ChatClickTalkComponent.L0;
        String r8 = r7.Q3();
        zga.b r1 = ObricInteractionProjectionDelegate.b.a(r8);
        ObricInteractionType r2 = r1.c;
        FLogger.a.i("ChatClickTalkComponent", "closeClickTalk phase：" + r1.e + " mode: " + r2 + " botId:" + r8);
        if (r2 != ObricInteractionType.AutoHalfDuplex) goto L16;
        ForegroundInteractionPhase r9 = r1.e;
        if (r9 == ForegroundInteractionPhase.Activate) goto L11;
        if (r9 != ForegroundInteractionPhase.Listen) goto L16;
    L11:
        if (this.$suppressCloseHaptic == true) goto L16;
        if (Build.VERSION.SDK_INT < 27) goto L16;
        this.this$0.getClass();
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_TICK);
    L16:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
