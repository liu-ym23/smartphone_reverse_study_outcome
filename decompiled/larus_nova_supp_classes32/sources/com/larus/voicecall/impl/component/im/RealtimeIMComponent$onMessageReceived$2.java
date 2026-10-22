package com.larus.voicecall.impl.component.im;

import android.content.Context;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.layout.holder.helper.s0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import f2a.f;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.im.RealtimeIMComponent$onMessageReceived$2", f = "RealtimeIMComponent.kt", i = {}, l = {SpeechEvent.SERVER_DOWNLINK_EVENT_TTS_SENTENCE_START, 218}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeIMComponent$onMessageReceived$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ RealtimeIMComponent this$0;

    public RealtimeIMComponent$onMessageReceived$2(RealtimeIMComponent r1, Message r2, Continuation<? super RealtimeIMComponent$onMessageReceived$2> r3) {
        this.this$0 = r1;
        this.$msg = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeIMComponent$onMessageReceived$2(this.this$0, this.$msg, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r79) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r6 = NameKeys.UnloadStrategy_No_Strategy;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r79);
        Object r3 = r79;
    L29:
        String r4 = (String) r3;
    L31:
        f2a.c r5 = com.larus.voicecall.impl.utils.d.a.b("did show new message - reply");
        LinkedHashMap r7 = new LinkedHashMap();
        Message r8 = this.$msg;
        RealtimeIMComponent r9 = this.this$0;
        f r10 = f.i;
        String r11 = r8.getMessageId();
        if (r11 != null) goto L34;
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L34:
        r7.put(r10, r11);
        f r12 = f.c;
        int r13 = RealtimeIMComponent.C;
        r7.put(r12, ((h88.b) r9.p3()).b);
        f r14 = new f("reply_message_id");
        String r15 = r8.getReplyId();
        if (r15 != null) goto L37;
        r15 = NameKeys.UnloadStrategy_No_Strategy;
    L37:
        r7.put(r14, r15);
        r7.put(new f("room_id"), ((h88.b) r9.p3()).c);
        f r16 = new f("text");
        if (r4 == null) goto L41;
        r6 = r4;
    L41:
        r7.put(r16, r6);
        r5.d(r7);
        r5.c.f = "auto_test";
        f2a.c.c(r5, null, 15);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r79);
        Object r17 = r79;
    L21:
        List r18 = (List) r17;
        if (r18 == null) goto L44;
        s0 r19 = ILegacyChatUiServiceDelegate.b.X8();
        if (r19 == null) goto L30;
        this.label = 2;
        r3 = r19.b(r18, this);
        if (r3 != r1) goto L29;
        return r1;
    L30:
        r4 = null;
    L44:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r79);
        s0 r20 = ILegacyChatUiServiceDelegate.b.X8();
        if (r20 == null) goto L44;
        Context r21 = this.this$0.getContext();
        Message r22 = this.$msg;
        RealtimeIMComponent r23 = this.this$0;
        int r110 = RealtimeIMComponent.C;
        BotModel r24 = r23.m3().H0;
        if (r24 != null) goto L18;
        BotInfoCache r111 = BotInfoCache.INSTANCE;
        String r112 = this.$msg.getConversationId();
        if (r112 != null) goto L17;
        r112 = NameKeys.UnloadStrategy_No_Strategy;
    L17:
        r24 = new BotModel(r111.getBotId(r112), null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    L18:
        this.label = 1;
        r17 = s0.a.b(r20, r21, r22, r24, this);
        if (r17 != r1) goto L21;
        return r1;
    }
}
