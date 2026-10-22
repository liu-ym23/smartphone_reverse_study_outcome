package com.obric.assistant.state.impl.multitask.producer;

import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.TtsStateProducer$globalAudioCallback$1$onPlaybackStateChanged$1", f = "TtsStateProducer.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
public final class TtsStateProducer$globalAudioCallback$1$onPlaybackStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $bizExtra;
    final /* synthetic */ GlobalAudioStateEnum $playbackState;
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ TtsStateProducer.globalAudioCallback.1 this$0;

    public TtsStateProducer$globalAudioCallback$1$onPlaybackStateChanged$1(TtsStateProducer.globalAudioCallback.1 r1, String r2, GlobalAudioStateEnum r3, Map<String, String> r4, Continuation<? super TtsStateProducer$globalAudioCallback$1$onPlaybackStateChanged$1> r5) {
        this.this$0 = r1;
        this.$scene = r2;
        this.$playbackState = r3;
        this.$bizExtra = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new TtsStateProducer$globalAudioCallback$1$onPlaybackStateChanged$1(this.this$0, this.$scene, this.$playbackState, this.$bizExtra, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L52:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        TtsStateProducer.globalAudioCallback.1 r12 = this.this$0;
        String r4 = this.$scene;
        GlobalAudioStateEnum r5 = this.$playbackState;
        Map<String, String> r3 = this.$bizExtra;
        if (r3 != null) goto L11;
        r3 = MapsKt.emptyMap();
    L11:
        Map<String, String> r8 = r3;
        this.label = 1;
        r12.getClass();
        String r6 = r8.get("message_id");
        String r7 = null;
        if (r6 != null) goto L14;
    L21:
        r6 = r8.get("uni_id");
        if (r6 != null) goto L24;
    L29:
        String r9 = null;
    L30:
        String r10 = r8.get("conversation_id");
        if (r10 == null) goto L39;
        if (r10.length() > 0) goto L36;
        r2 = false;
    L36:
        if (r2 == false) goto L39;
        r7 = r10;
    L39:
        if (r5 != GlobalAudioStateEnum.PLAYING) goto L41;
    L45:
        FLogger.a.i("TtsStateProducer", "emitTts state,scene=" + r4 + ", state=" + r5 + ", messageId=" + r9 + ", conversationId=" + r7);
        Object r13 = TtsStateProducer.a(r12.a, r4, r5, r7, r9, r8, this);
        if (r13 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L49;
        r13 = Unit.INSTANCE;
    L49:
        if (r13 != r0) goto L52;
        return r0;
    L41:
        if (r5 == GlobalAudioStateEnum.PAUSED) goto L45;
        if (r5 == GlobalAudioStateEnum.STOPPED) goto L45;
        FLogger.a.i("TtsStateProducer", "ignore tts state: " + r5.name());
        r13 = Unit.INSTANCE;
        goto L49
    L24:
        if (r6.length() <= 0) goto L26;
        boolean r14 = true;
    L27:
        if (r14 == false) goto L29;
    L28:
        r9 = r6;
        goto L30
    L26:
        r14 = false;
        goto L27
    L14:
        if (r6.length() <= 0) goto L16;
        boolean r15 = true;
    L17:
        if (r15 == true) goto L20;
        r6 = null;
    L20:
        if (r6 != null) goto L28;
    L16:
        r15 = false;
        goto L17
    }
}
