package com.larus.voicecall.impl.ui;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotUpdateType;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import uc9.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallHelperKt$updateChatBot$1", f = "RealtimeCallHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallHelperKt$updateChatBot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ SpeakerVoice $newSpeakerVoice;
    int label;

    public RealtimeCallHelperKt$updateChatBot$1(SpeakerVoice r1, BotModel r2, Continuation<? super RealtimeCallHelperKt$updateChatBot$1> r3) {
        this.$newSpeakerVoice = r1;
        this.$bot = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeCallHelperKt$updateChatBot$1(this.$newSpeakerVoice, this.$bot, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r33) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L35;
        ResultKt.throwOnFailure(r33);
        SpeakerVoice r1 = this.$newSpeakerVoice;
        if (r1 == null) goto L7;
        String r2 = r1.getId();
    L8:
        boolean r3 = Intrinsics.areEqual(r2, VoiceDisplayScene.NONE);
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        if (r3 == false) goto L15;
        BotServiceImpl r5 = com.larus.im.d.a();
        BotUpdateType r6 = BotUpdateType.MODIFY_VOICE;
        String r7 = this.$bot.getBotId();
        if (r7 == null) goto L14;
        r4 = r7;
    L14:
        r5.updateBot(new s(r6, r4, null, null, null, null, null, null, null, Boxing.boxBoolean(true), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108348), null);
    L33:
        return Unit.INSTANCE;
    L15:
        BotServiceImpl r0 = com.larus.im.d.a();
        BotUpdateType r8 = BotUpdateType.MODIFY_VOICE;
        String r9 = this.$bot.getBotId();
        if (r9 != null) goto L18;
        String r10 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        SpeakerVoice r11 = this.$newSpeakerVoice;
        if (r11 == null) goto L22;
        String r15 = r11.getStyleId();
    L23:
        SpeakerVoice r12 = this.$newSpeakerVoice;
        if (r12 == null) goto L26;
        Boolean r18 = Boxing.boxBoolean(r12.isUgcVoice());
    L27:
        SpeakerVoice r13 = this.$newSpeakerVoice;
        if (r13 == null) goto L30;
        Integer r14 = Boxing.boxInt(r13.getPrivateStatus());
    L31:
        r0.updateBot(new s(r8, r10, null, null, null, null, null, null, r14, Boxing.boxBoolean(false), r15, null, null, r18, null, null, null, null, null, null, null, null, null, null, null, null, 67098876), null);
        goto L33
    L30:
        r14 = null;
        goto L31
    L26:
        r18 = null;
        goto L27
    L22:
        r15 = null;
        goto L23
    L18:
        r10 = r9;
        goto L19
    L7:
        r2 = null;
        goto L8
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
