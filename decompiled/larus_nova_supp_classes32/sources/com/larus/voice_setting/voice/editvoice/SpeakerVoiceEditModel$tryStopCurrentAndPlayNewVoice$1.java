package com.larus.voice_setting.voice.editvoice;

import com.larus.im.bean.bot.MixVoice;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel$tryStopCurrentAndPlayNewVoice$1", f = "SpeakerVoiceEditModel.kt", i = {}, l = {899, 917}, m = "invokeSuspend", n = {}, s = {})
public final class SpeakerVoiceEditModel$tryStopCurrentAndPlayNewVoice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $caller;
    int label;
    final /* synthetic */ SpeakerVoiceEditModel this$0;

    public SpeakerVoiceEditModel$tryStopCurrentAndPlayNewVoice$1(SpeakerVoiceEditModel r1, String r2, Continuation<? super SpeakerVoiceEditModel$tryStopCurrentAndPlayNewVoice$1> r3) {
        this.this$0 = r1;
        this.$caller = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SpeakerVoiceEditModel$tryStopCurrentAndPlayNewVoice$1(this.this$0, this.$caller, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L26:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L13:
        FLogger.a.i("SpeakerVoiceEditModel", "[tryStopCurrentAndPlayNewVoice]: voicePlayStatus = " + this.this$0.y.getValue() + ", isMultiVoiceMixMode = " + this.this$0.e + ", mixVoiceList = " + this.this$0.n + ", selectVoice = " + this.this$0.j.getValue());
        final MixVoice r13 = (MixVoice) CollectionsKt.firstOrNull(this.this$0.f());
        if (r13 == null) goto L16;
        final String r3 = this.$caller;
        f2a.c r4 = com.larus.voice_setting.voice.utils.k.a.b("auto play when change pitch or rate");
        r4.e(new z0(r13, r3));
        r4.c.b = CollectionsKt.listOf("VoicePlay");
        f2a.c.c(r4, null, 15);
    L16:
        SpeakerVoiceEditModel r14 = this.this$0;
        r14.getClass();
        p2a.q.a().stopAudio();
        Integer r5 = (Integer) r14.y.getValue();
        if (r5 != null) goto L20;
    L21:
        r14.x.setValue(3);
    L22:
        BuildersKt.launch$default(r14.a, Dispatchers.getIO(), null, new SpeakerVoiceEditModel$requestPreviewAndPlayVoice$1(r14, null), 2, null);
        MutableSharedFlow<a1> r15 = this.this$0.z;
        a1.a r2 = a1.a.a;
        this.label = 2;
        if (r15.emit(r2, this) != r0) goto L26;
        return r0;
    L20:
        if (r5.intValue() == 3) goto L22;
    L10:
        ResultKt.throwOnFailure(r12);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L13;
        return r0;
    }
}
