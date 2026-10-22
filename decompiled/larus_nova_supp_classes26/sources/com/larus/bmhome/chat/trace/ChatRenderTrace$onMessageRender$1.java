package com.larus.bmhome.chat.trace;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.trace.appreciable.CommonParamManager;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.message.Message;
import java.util.Map;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatRenderTrace$onMessageRender$1", f = "ChatRenderTrace.kt", i = {0}, l = {386}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class ChatRenderTrace$onMessageRender$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $data;
    final /* synthetic */ int $renderTimes;
    private /* synthetic */ Object L$0;
    int label;

    public ChatRenderTrace$onMessageRender$1(Message r1, int r2, Continuation<? super ChatRenderTrace$onMessageRender$1> r3) {
        this.$data = r1;
        this.$renderTimes = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ChatRenderTrace$onMessageRender$1 r0 = new ChatRenderTrace$onMessageRender$1(this.$data, this.$renderTimes, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        if (CoroutineScopeKt.isActive(r2) == false) goto L60;
        String r11 = com.larus.im.bean.message.a.O(this.$data);
        String r3 = "";
        if (r11 != null) goto L17;
        r11 = "";
    L17:
        com.larus.platform.service.o r4 = com.larus.platform.service.o.a;
        ChatRenderTrace r5 = ChatRenderTrace.b;
        Message r6 = this.$data;
        Pair[] r7 = new Pair[17];
        r7[0] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r6.getMessageId());
        r7[1] = TuplesKt.to(MusicAppletPage.KEY_CONVERSATION_ID, this.$data.getMessageId());
        r7[2] = TuplesKt.to("is_onboarding", Boxing.boxInt(com.larus.bmhome.chat.bean.d.z0(this.$data) ? 1 : 0));
        LruCache<String, CommonParamManager.CommonParam> r8 = CommonParamManager.a;
        CommonParamManager.CommonParam r9 = CommonParamManager.c(this.$data.getMessageId());
        String r12 = null;
        if (r9 == null) goto L20;
        String r13 = r9.getScene();
    L21:
        r7[3] = TuplesKt.to("scene", r13);
        r7[4] = TuplesKt.to("content_type", Boxing.boxInt(this.$data.getContentType()));
        ChatControlTrace.b.getClass();
        LruCache<String, wc9.e> r14 = ChatControlTrace.o;
        String r15 = this.$data.getConversationId();
        if (r15 != null) goto L24;
        r15 = "";
    L24:
        wc9.e r16 = (wc9.e) r14.get(r15);
        if (r16 == null) goto L27;
        String r17 = ic8.n.f(r16);
    L28:
        r7[5] = TuplesKt.to("chat_type", r17);
        BotInfoCache r18 = BotInfoCache.INSTANCE;
        String r19 = this.$data.getConversationId();
        if (r19 != null) goto L31;
        r19 = "";
    L31:
        r7[6] = TuplesKt.to("bot_id", r18.getBotId(r19));
        String r20 = this.$data.getConversationId();
        if (r20 == null) goto L35;
        r3 = r20;
    L35:
        r7[7] = TuplesKt.to("model_type", Boxing.boxLong(r18.getModelType(r3)));
        r7[8] = TuplesKt.to("character_count", Boxing.boxInt(r11.length()));
        r5.getClass();
        r7[9] = TuplesKt.to("character_type", Boxing.boxInt(ChatRenderTrace.b(r11)));
        r7[10] = TuplesKt.to("render_times", Boxing.boxInt(this.$renderTimes));
        r7[11] = TuplesKt.to("hang_duration", Boxing.boxLong(((Number) ChatRenderTrace.u.getValue()).longValue()));
        Map r110 = this.$data.getExt();
        if (r110 == null) goto L38;
        String r111 = (String) r110.get("intention");
    L39:
        r7[12] = TuplesKt.to("intention", r111);
        Map r112 = this.$data.getExt();
        if (r112 == null) goto L42;
        String r113 = (String) r112.get("llm_model_type");
    L43:
        r7[13] = TuplesKt.to("llmModelType", r113);
        r7[14] = TuplesKt.to("replied_message_id", this.$data.getReplyId());
        Map r114 = this.$data.getExt();
        if (r114 == null) goto L46;
        String r115 = (String) r114.get("general_agent");
    L47:
        String r21 = "1";
        if (Intrinsics.areEqual(r115, "1") == false) goto L50;
        Object r116 = "1";
    L51:
        r7[15] = TuplesKt.to("general_agent", r116);
        Map r117 = this.$data.getExt();
        if (r117 == null) goto L55;
        r12 = (String) r117.get("is_async_task");
    L55:
        if (Intrinsics.areEqual(r12, "1") == true) goto L58;
        r21 = TriggerSendLoading.NO_LOADING;
    L58:
        r7[16] = TuplesKt.to("is_async_task", r21);
        r4.b("stream_message_render_hang", ChatRenderTrace.r(r6, r7));
        goto L60
    L50:
        r116 = TriggerSendLoading.NO_LOADING;
        goto L51
    L46:
        r115 = null;
        goto L47
    L42:
        r113 = null;
        goto L43
    L38:
        r111 = null;
        goto L39
    L27:
        r17 = null;
        goto L28
    L20:
        r13 = null;
    L60:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r118 = (CoroutineScope) this.L$0;
        ChatRenderTrace.b.getClass();
        long r22 = ((Number) ChatRenderTrace.u.getValue()).longValue();
        this.L$0 = r118;
        this.label = 1;
        if (DelayKt.delay(r22, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r118;
        goto L13
    }
}
