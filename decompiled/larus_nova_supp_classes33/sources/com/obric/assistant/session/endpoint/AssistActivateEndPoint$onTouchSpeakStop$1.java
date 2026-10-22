package com.obric.assistant.session.endpoint;

import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.endpoint.AssistActivateEndPoint$onTouchSpeakStop$1", f = "AssistActivateEndPoint.kt", i = {}, l = {425}, m = "invokeSuspend", n = {}, s = {})
public final class AssistActivateEndPoint$onTouchSpeakStop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AssistActivateEndPoint this$0;

    public AssistActivateEndPoint$onTouchSpeakStop$1(AssistActivateEndPoint r1, Continuation<? super AssistActivateEndPoint$onTouchSpeakStop$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AssistActivateEndPoint$onTouchSpeakStop$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        IDoraOperation r6 = bga.f.a();
        if (r6 != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        this.this$0.getClass();
        if (ISessionEndPoint.a.a().getRingerMode() != 2) goto L18;
        if (r7 == true) goto L18;
        SoundEffectHelper.INSTANCE.playRelease();
    L18:
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_TICK);
        z0 r8 = IAssistantInteractionServiceKt.getInteractionStateService().getPreSoundEffectState();
        Pair r2 = TuplesKt.to(Boxing.boxBoolean(true), "onTouchSpeakStop");
        this.label = 1;
        if (r8.emit(r2, this) != r0) goto L22;
        return r0;
    L11:
        if (r6.c() != true) goto L13;
        r7 = true;
        goto L14
    }
}
