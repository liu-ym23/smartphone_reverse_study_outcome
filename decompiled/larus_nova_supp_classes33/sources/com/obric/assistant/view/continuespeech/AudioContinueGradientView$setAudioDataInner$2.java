package com.obric.assistant.view.continuespeech;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.view.continuespeech.AudioContinueGradientView$setAudioDataInner$2", f = "AudioContinueGradientView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AudioContinueGradientView$setAudioDataInner$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $amplitude;
    int label;
    final /* synthetic */ AudioContinueGradientView this$0;

    public AudioContinueGradientView$setAudioDataInner$2(AudioContinueGradientView r1, float r2, Continuation<? super AudioContinueGradientView$setAudioDataInner$2> r3) {
        this.this$0 = r1;
        this.$amplitude = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AudioContinueGradientView$setAudioDataInner$2(this.this$0, this.$amplitude, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r3);
        AudioContinueGradientView r4 = this.this$0;
        r4.i = Boxing.boxFloat(this.$amplitude);
        AudioContinueGradientView r5 = this.this$0;
        if (r5.h == false) goto L7;
    L8:
        AudioContinueGradientView r6 = this.this$0;
        u r0 = r6.d;
        float r1 = this.$amplitude;
        if (r6.getMode() != 0) goto L11;
        boolean r7 = true;
    L12:
        r0.g(r1, r7);
    L14:
        return Unit.INSTANCE;
    L11:
        r7 = false;
        goto L12
    L7:
        if (r5.getMode() != 0) goto L14;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
