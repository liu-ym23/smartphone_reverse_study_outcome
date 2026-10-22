package com.larus.bmhome.chat.trace;

import android.os.Bundle;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.trace.appreciable.CommonParamManager;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.message.Message;
import java.util.LinkedHashMap;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatRenderTrace$checkMessageRenderStuck$1", f = "ChatRenderTrace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatRenderTrace$checkMessageRenderStuck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $current;
    final /* synthetic */ Message $data;
    final /* synthetic */ Long $last;
    int label;

    public ChatRenderTrace$checkMessageRenderStuck$1(Message r1, long r2, Long r4, Continuation<? super ChatRenderTrace$checkMessageRenderStuck$1> r5) {
        this.$data = r1;
        this.$current = r2;
        this.$last = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatRenderTrace$checkMessageRenderStuck$1(this.$data, this.$current, this.$last, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L73;
        ResultKt.throwOnFailure(r15);
        String r16 = com.larus.bmhome.chat.bean.d.r(this.$data);
        String r0 = "";
        if (r16 != null) goto L7;
        r16 = "";
    L7:
        Map r1 = this.$data.getExt();
        if (r1 == null) goto L11;
        String r2 = (String) r1.get("intention");
        if (r2 == null) goto L11;
    L12:
        Map r3 = this.$data.getExt();
        String r4 = null;
        if (r3 == null) goto L15;
        String r5 = (String) r3.get("tea_tags_time_cost");
    L17:
        if (r5 != null) goto L19;
    L22:
        boolean r7 = true;
    L23:
        if (r7 == false) goto L25;
        Map r6 = new LinkedHashMap();
    L26:
        ChatRenderTrace r8 = ChatRenderTrace.b;
        Message r9 = this.$data;
        Pair[] r10 = new Pair[17];
        r10[0] = TuplesKt.to("lag_dration", Boxing.boxLong(this.$current - this.$last.longValue()));
        r10[1] = TuplesKt.to("lag_duration_threshold", Boxing.boxLong(1000));
        r10[2] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, this.$data.getMessageId());
        BotInfoCache r11 = BotInfoCache.INSTANCE;
        String r12 = this.$data.getConversationId();
        if (r12 != null) goto L29;
        r12 = "";
    L29:
        r10[3] = TuplesKt.to("bot_id", r11.getBotId(r12));
        LruCache<String, CommonParamManager.CommonParam> r13 = CommonParamManager.a;
        CommonParamManager.CommonParam r14 = CommonParamManager.c(this.$data.getMessageId());
        if (r14 == null) goto L32;
        String r17 = r14.getScene();
    L33:
        r10[4] = TuplesKt.to("scene", r17);
        r10[5] = TuplesKt.to("content_type", Boxing.boxInt(this.$data.getContentType()));
        ChatControlTrace.b.getClass();
        LruCache<String, wc9.e> r18 = ChatControlTrace.o;
        String r19 = this.$data.getConversationId();
        if (r19 != null) goto L36;
        r19 = "";
    L36:
        wc9.e r110 = (wc9.e) r18.get(r19);
        if (r110 == null) goto L39;
        String r111 = ic8.n.f(r110);
    L40:
        r10[6] = TuplesKt.to("chat_type", r111);
        r10[7] = TuplesKt.to(MusicAppletPage.KEY_CONVERSATION_ID, this.$data.getConversationId());
        String r112 = this.$data.getConversationId();
        if (r112 == null) goto L44;
        r0 = r112;
    L44:
        r10[8] = TuplesKt.to("is_typewriter", Boxing.boxInt(r11.getTypeWriter(r0)));
        r10[9] = TuplesKt.to("character_count", Boxing.boxInt(r16.length()));
        r8.getClass();
        r10[10] = TuplesKt.to("character_type", Boxing.boxInt(ChatRenderTrace.b(r16)));
        Map r113 = this.$data.getExt();
        if (r113 == null) goto L47;
        String r114 = (String) r113.get("intention");
    L48:
        r10[11] = TuplesKt.to("intention", r114);
        Map r115 = this.$data.getExt();
        if (r115 == null) goto L51;
        String r116 = (String) r115.get("llm_model_type");
    L52:
        r10[12] = TuplesKt.to("llmModelType", r116);
        r10[13] = TuplesKt.to("intention", r2);
        r10[14] = TuplesKt.to("replied_message_id", this.$data.getReplyId());
        Map r117 = this.$data.getExt();
        if (r117 == null) goto L55;
        String r118 = (String) r117.get("general_agent");
    L56:
        String r20 = "1";
        if (Intrinsics.areEqual(r118, "1") == false) goto L59;
        Object r119 = "1";
    L60:
        r10[15] = TuplesKt.to("general_agent", r119);
        Map r120 = this.$data.getExt();
        if (r120 == null) goto L64;
        r4 = (String) r120.get("is_async_task");
    L64:
        if (Intrinsics.areEqual(r4, "1") == true) goto L67;
        r20 = TriggerSendLoading.NO_LOADING;
    L67:
        r10[16] = TuplesKt.to("is_async_task", r20);
        Bundle r121 = ChatRenderTrace.r(r9, r10);
        if ((!r6.isEmpty()) == false) goto L70;
        com.larus.utils.f.a(r121, r6);
    L70:
        com.larus.platform.service.o.a.b("stream_message_render_lag", r121);
        return Unit.INSTANCE;
    L59:
        r119 = TriggerSendLoading.NO_LOADING;
        goto L60
    L55:
        r118 = null;
        goto L56
    L51:
        r116 = null;
        goto L52
    L47:
        r114 = null;
        goto L48
    L39:
        r111 = null;
        goto L40
    L32:
        r17 = null;
        goto L33
    L25:
        r6 = com.larus.bmhome.chat.trace.appreciable.z.a(r5, "ChatRenderTrace#onMessageRenderFinish");
        goto L26
    L19:
        if (r5.length() == 0) goto L22;
        r7 = false;
        goto L23
    L15:
        r5 = null;
    L11:
        r2 = "default";
        goto L12
    L73:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
