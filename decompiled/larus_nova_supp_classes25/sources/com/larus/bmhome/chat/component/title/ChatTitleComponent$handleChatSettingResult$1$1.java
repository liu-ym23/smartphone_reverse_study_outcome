package com.larus.bmhome.chat.component.title;

import android.content.Context;
import android.os.Bundle;
import by7.a;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.d;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import p2a.i;
import p2a.j;
import p2a.m;
import w2a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponent$handleChatSettingResult$1$1", f = "ChatTitleComponent.kt", i = {}, l = {1523}, m = "invokeSuspend", n = {}, s = {})
public final class ChatTitleComponent$handleChatSettingResult$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ BotModel $currentBot;
    final /* synthetic */ String $currentStyleId;
    final /* synthetic */ f $it;
    final /* synthetic */ Ref.ObjectRef<SpeakerVoice> $voice;
    int label;
    final /* synthetic */ ChatTitleComponent this$0;

    public ChatTitleComponent$handleChatSettingResult$1$1(f r1, BotModel r2, Ref.ObjectRef<SpeakerVoice> r3, ChatTitleComponent r4, Bundle r5, String r6, Continuation<? super ChatTitleComponent$handleChatSettingResult$1$1> r7) {
        this.$it = r1;
        this.$currentBot = r2;
        this.$voice = r3;
        this.this$0 = r4;
        this.$bundle = r5;
        this.$currentStyleId = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatTitleComponent$handleChatSettingResult$1$1(this.$it, this.$currentBot, this.$voice, this.this$0, this.$bundle, this.$currentStyleId, r10);
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
        String r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L27:
        j r12 = (m) r11;
        this.$voice.element = ((m) r12).a;
        BotServiceImpl r2 = d.a();
        BotModel r4 = this.$currentBot;
        if (r4 == null) goto L31;
        String r5 = r4.getBotId();
        if (r5 == null) goto L31;
    L32:
        final Ref.ObjectRef<SpeakerVoice> r6 = this.$voice;
        r2.updateLocalBot(r5, new p1(r6), null);
        SpeakerVoice r7 = (SpeakerVoice) this.$voice.element;
        if (r7 == null) goto L35;
        this.this$0.d5(this.$currentBot, r7, null, "");
    L35:
        boolean r8 = r12 instanceof j;
        if (r8 == false) goto L39;
        t19.s.a.g(this.this$0.getContext(), 2131907872, false);
        FLogger.a.e("ChatFragment", "handleChatSettingResult save voice error " + ((m) r12).a);
    L39:
        if (z2.a.ttsSwitchLongPressConfig().a() == false) goto L56;
        if (Intrinsics.areEqual(this.$bundle.getString("key_enter_method", ""), "long_press_tts_switch") == false) goto L56;
        SpeakerVoice r13 = (SpeakerVoice) this.$voice.element;
        if (r13 == null) goto L46;
        r3 = r13.getStyleId();
    L46:
        if (Intrinsics.areEqual(r3, this.$currentStyleId) == true) goto L56;
        Integer r14 = Boxing.boxInt(!r8 ? 1 : 0);
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "params");
        r9.put("current_page", "chat");
        r9.put("previous_page", "bot_voice_change");
        r9.put("scene", "long_press_tts_switch");
        if (r14 == null) goto L50;
        r9.put("success", r14.intValue());
    L50:
        TrackParams r15 = new TrackParams().merge(r9);
        a r10 = new a("bot_voice_change_result_show");
        r10.a.merge(r15);
        r10.b();
        t19.s r16 = t19.s.a;
        Context r17 = this.this$0.getContext();
        if (r8 == false) goto L53;
        int r18 = 2131911120;
    L54:
        r16.g(r17, r18, false);
        goto L56
    L53:
        r18 = 2131911121;
    L56:
        return Unit.INSTANCE;
    L31:
        r5 = "";
        goto L32
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        i r19 = i.b;
        f r20 = this.$it;
        BotModel r110 = this.$currentBot;
        if (r110 == null) goto L13;
        SpeakerVoice r111 = r110.getVoiceType();
        if (r111 == null) goto L13;
        String r21 = r111.getId();
    L14:
        BotModel r112 = this.$currentBot;
        if (r112 == null) goto L17;
        String r22 = r112.getBotId();
    L18:
        BotModel r113 = this.$currentBot;
        if (r113 == null) goto L23;
        SpeakerVoice r114 = r113.getVoiceType();
        if (r114 == null) goto L23;
        String r23 = r114.getLanguageCode();
    L24:
        this.label = 1;
        r11 = r19.y2(r20, r21, r22, r23, this);
        if (r11 != r0) goto L27;
        return r0;
    L23:
        r23 = null;
        goto L24
    L17:
        r22 = null;
    L13:
        r21 = null;
        goto L14
    }
}
