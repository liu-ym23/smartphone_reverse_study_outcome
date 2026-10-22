package com.obric.audio.continuous_talk;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
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
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousTalkCtrlComponent$closeContinuousTalk$1", f = "ObricContinuousTalkCtrlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricContinuousTalkCtrlComponent$closeContinuousTalk$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ ObricContinuousTalkEndType $endType;
    final /* synthetic */ boolean $suppressCloseHaptic;
    int label;
    final /* synthetic */ ObricContinuousTalkCtrlComponent this$0;

    public ObricContinuousTalkCtrlComponent$closeContinuousTalk$1(ObricContinuousTalkCtrlComponent r1, boolean r2, ObricContinuousTalkEndType r3, FragmentActivity r4, Continuation<? super ObricContinuousTalkCtrlComponent$closeContinuousTalk$1> r5) {
        this.this$0 = r1;
        this.$suppressCloseHaptic = r2;
        this.$endType = r3;
        this.$activity = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ObricContinuousTalkCtrlComponent$closeContinuousTalk$1(this.this$0, this.$suppressCloseHaptic, this.$endType, this.$activity, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r3);
        ObricContinuousTalkCtrlComponent r4 = this.this$0;
        int r0 = ObricContinuousTalkCtrlComponent.L;
        b r5 = r4.C3();
        if (r5 == null) goto L9;
        boolean r1 = true;
        if (r5.m0() != true) goto L9;
    L10:
        if (r1 == false) goto L17;
        if (this.$suppressCloseHaptic == true) goto L17;
        if (Build.VERSION.SDK_INT < 27) goto L17;
        this.this$0.getClass();
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_TICK);
    L17:
        if (this.$endType != ObricContinuousTalkEndType.TIMEOUT) goto L19;
        ObricAssistantForAudioDelegate.b.V4(false, this.$activity);
    L21:
        return Unit.INSTANCE;
    L19:
        ObricAssistantForAudioDelegate.b.Z4(this.$activity);
    L9:
        r1 = false;
        goto L10
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
