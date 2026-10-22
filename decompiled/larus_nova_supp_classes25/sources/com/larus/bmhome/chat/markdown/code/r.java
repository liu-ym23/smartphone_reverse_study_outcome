package com.larus.bmhome.chat.markdown.code;

import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tx9.g1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r implements Function1 {
    public final /* synthetic */ ClickableMarkdownCodeView a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Long c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ String f;
    public final /* synthetic */ by7.e g;

    public /* synthetic */ r(ClickableMarkdownCodeView r1, Function0 r2, Long r3, Function0 r4, boolean r5, String r6, by7.e r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke(Object r13) {
        ClickableMarkdownCodeView r0 = this.a;
        Function0 r1 = this.b;
        Long r2 = this.c;
        Function0 r3 = this.d;
        boolean r4 = this.e;
        String r5 = this.f;
        by7.e r9 = this.g;
        boolean r14 = ((Boolean) r13).booleanValue();
        List<String> r6 = ClickableMarkdownCodeView.H0;
        com.bytedance.router.i r7 = SmartRouter.buildRoute(r0.getContext(), "//flow/code_block_detail");
        Pair[] r8 = new Pair[21];
        r8[0] = TuplesKt.to("key_mark_down_detail_raw_content", r0.i);
        r8[1] = TuplesKt.to("key_code_block_code_info", r0.j);
        r8[2] = TuplesKt.to("key_code_block_title", r0.l);
        r8[3] = TuplesKt.to("key_enable_dynamic_code_fence", Boolean.valueOf(r0.m));
        r8[4] = TuplesKt.to("key_code_block_default_no_wrap", Boolean.valueOf(r0.n));
        r8[5] = TuplesKt.to("key_mark_down_detail_message_id", r0.x);
        Message r10 = r0.y;
        String r11 = null;
        if (r10 == null) goto L5;
        String r12 = r10.getConversationId();
    L6:
        r8[6] = TuplesKt.to("key_mark_down_detail_conversation_id", r12);
        Message r15 = r0.y;
        if (r15 == null) goto L9;
        String r16 = r15.getThreadId();
    L10:
        r8[7] = TuplesKt.to("key_thread_id", r16);
        if (r1 == null) goto L13;
        BotModel r17 = (BotModel) r1.invoke();
    L14:
        r8[8] = TuplesKt.to("key_mark_down_detail_bot_model", r17);
        r8[9] = TuplesKt.to("key_mark_down_detail_chat_unique_key", r2);
        if (r3 == null) goto L17;
        ChatParam r18 = (ChatParam) r3.invoke();
    L18:
        r8[10] = TuplesKt.to("key_mark_down_detail_chat_param", r18);
        r8[11] = TuplesKt.to("key_mark_down_detail_is_immersive", Boolean.valueOf(r4));
        r8[12] = TuplesKt.to("key_mark_down_detail_copy_content", r0.i);
        r8[13] = TuplesKt.to("key_can_code_be_previewed", Boolean.valueOf(ClickableMarkdownCodeView.a.a(r0.j)));
        r8[14] = TuplesKt.to("key_is_to_preview", Boolean.valueOf(r14));
        r8[15] = TuplesKt.to("key_code_delay_render", Boolean.TRUE);
        r8[16] = TuplesKt.to("key_is_code_finished", Boolean.valueOf(r0.q));
        Function0<? extends Map<String, ? extends Object>> r19 = r0.v;
        if (r19 == null) goto L21;
        Map r110 = (Map) r19.invoke();
    L22:
        r8[17] = TuplesKt.to("key_event_extra", r110);
        Message r111 = r0.y;
        if (r111 == null) goto L26;
        String r112 = com.larus.im.bean.message.a.r(r111);
        if (r112 == null) goto L26;
    L27:
        r8[18] = TuplesKt.to("is_general_agent", r112);
        Message r113 = r0.y;
        if (r113 == null) goto L30;
        String r114 = com.larus.im.bean.message.a.s(r113);
    L31:
        if (r114 != null) goto L33;
        r114 = "";
    L33:
        r8[19] = TuplesKt.to("chat_id", r114);
        String r115 = r0.s;
        com.larus.bmhome.chat.detail.code.preview.m.a.getClass();
        com.larus.bmhome.chat.detail.code.preview.m.a r20 = com.larus.bmhome.chat.detail.code.preview.m.b;
        if (r20 == null) goto L36;
        String r21 = r20.b;
    L38:
        if (Intrinsics.areEqual(r21, r115) == false) goto L40;
        r11 = r115;
    L40:
        r8[20] = TuplesKt.to("key_preload_code_id", r11);
        r7.c.putExtras(com.larus.utils.f.c(r8));
        r7.d();
        g1.a(r5, r0.x, "code", r0.v, r9, 64);
        return Unit.INSTANCE;
    L36:
        r21 = null;
        goto L38
    L30:
        r114 = null;
    L26:
        r112 = "0";
        goto L27
    L21:
        r110 = null;
        goto L22
    L17:
        r18 = null;
        goto L18
    L13:
        r17 = null;
        goto L14
    L9:
        r16 = null;
        goto L10
    L5:
        r12 = null;
        goto L6
    }
}
