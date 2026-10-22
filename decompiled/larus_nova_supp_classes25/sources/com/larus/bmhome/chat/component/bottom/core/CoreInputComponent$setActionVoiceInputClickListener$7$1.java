package com.larus.bmhome.chat.component.bottom.core;

import android.animation.AnimatorSet;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.widget.input.audiowave.AudioWaveView;
import com.larus.common_ui.widget.input.audiowave.gradient.AudioWaveGradientView;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputComponent$setActionVoiceInputClickListener$7$1", f = "CoreInputComponent.kt", i = {}, l = {3029}, m = "invokeSuspend", n = {}, s = {})
final class CoreInputComponent$setActionVoiceInputClickListener$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $it;
    final /* synthetic */ LarusWidgetInputBinding $this_setActionVoiceInputClickListener;
    int label;

    public CoreInputComponent$setActionVoiceInputClickListener$7$1(LarusWidgetInputBinding r1, byte[] r2, Continuation<? super CoreInputComponent$setActionVoiceInputClickListener$7$1> r3) {
        this.$this_setActionVoiceInputClickListener = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CoreInputComponent$setActionVoiceInputClickListener$7$1(this.$this_setActionVoiceInputClickListener, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        AudioWaveGradientView r5 = this.$this_setActionVoiceInputClickListener.z;
        byte[] r2 = this.$it;
        this.label = 1;
        AnimatorSet r3 = ((AudioWaveView) r5).j.b;
        if (r3 == null) goto L11;
        boolean r6 = r3.isRunning();
    L12:
        if (r6 == false) goto L14;
        Object r7 = ((AudioWaveView) r5).k.update(r2, this);
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        r7 = Unit.INSTANCE;
    L21:
        if (r7 != r0) goto L24;
        return r0;
    L14:
        if (r5.isInEditMode() == true) goto L16;
        FLogger.a.w("AudioWaveView", "[updateAudioData][NOT_ANIM]");
    L16:
        r7 = Unit.INSTANCE;
        goto L21
    L11:
        r6 = false;
        goto L12
    }
}
