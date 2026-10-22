package com.larus.dora.impl.dynamic;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraDynamicFragment$onIndividualToneResult$1$1$2", f = "DoraDynamicFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDynamicFragment$onIndividualToneResult$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $botInfo;
    final /* synthetic */ String $fromVoiceId;
    final /* synthetic */ w2a.f $it;
    final /* synthetic */ p2a.m<SpeakerVoice> $saveResult;
    final /* synthetic */ SpeakerVoice $voice;
    int label;
    final /* synthetic */ DoraDynamicFragment this$0;

    public DoraDynamicFragment$onIndividualToneResult$1$1$2(SpeakerVoice r1, DoraDynamicFragment r2, BotModel r3, w2a.f r4, String r5, p2a.m<SpeakerVoice> r6, Continuation<? super DoraDynamicFragment$onIndividualToneResult$1$1$2> r7) {
        this.$voice = r1;
        this.this$0 = r2;
        this.$botInfo = r3;
        this.$it = r4;
        this.$fromVoiceId = r5;
        this.$saveResult = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new DoraDynamicFragment$onIndividualToneResult$1$1$2(this.$voice, this.this$0, this.$botInfo, this.$it, this.$fromVoiceId, this.$saveResult, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r72) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r72);
        SpeakerVoice r1 = this.$voice;
        if (r1 == null) goto L8;
        DoraDynamicFragment.Y90(this.this$0, BotModel.copy$default(this.$botInfo, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r1, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -655361, Integer.MAX_VALUE, null));
        v2a.b r2 = p2a.r.b.f7();
        this.this$0.getClass();
        w2a.f r3 = this.$it;
        r2.a(r3, "DoraDynamicActivity", this.$fromVoiceId, "edit", this.$voice, r3.h);
    L8:
        if ((this.$saveResult instanceof p2a.j) == false) goto L11;
        FLogger.a.e("DoraFunctionIntroductionFragment", "setupSelectSpeakerResult save voice error " + ((p2a.m) this.$saveResult).a);
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
