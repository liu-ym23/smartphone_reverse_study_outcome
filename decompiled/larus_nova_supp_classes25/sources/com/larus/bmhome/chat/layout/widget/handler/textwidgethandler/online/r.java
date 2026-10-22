package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.collection.LruCache;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.api.FullScreenDetailType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import tx9.g1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r implements gw8.a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ BotModel c;
    public final /* synthetic */ k d;
    public final /* synthetic */ CustomMarkdownTextView e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FullScreenDetailType.values().length];
            r0[FullScreenDetailType.CODE_BLOCK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FullScreenDetailType.TABLE_BLOCK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final void a(View r20, com.larus.business.markdown.impl.markwon.custom.title.c r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        Intrinsics.checkNotNullParameter(r21, "span");
        if (r21.e == true) goto L6;
        FLogger.a.i("MarkdownTextViewWidgetHandler", "FullScreenDetailSpanClickListener is uncompleted");
        return;
    L6:
        FullScreenDetailType r2 = r21.getType();
        int r3 = a.a[r2.ordinal()];
        if (r3 == 1) goto L27;
        if (r3 != 2) goto L26;
        com.bytedance.router.i r4 = SmartRouter.buildRoute(this.a, "//flow/table_block_detail");
        Pair[] r9 = new Pair[11];
        r9[0] = TuplesKt.to("key_mark_down_detail_raw_content", r21.b);
        r9[1] = TuplesKt.to("key_mark_down_detail_message_id", this.b.getMessageId());
        r9[2] = TuplesKt.to("key_mark_down_detail_conversation_id", this.b.getConversationId());
        r9[3] = TuplesKt.to("key_mark_down_detail_bot_model", this.c);
        r9[4] = TuplesKt.to("key_mark_down_detail_message", this.b);
        q0 r5 = this.d.a.f;
        if (r5 == null) goto L16;
        ChatMessageList r6 = r5.B7();
        if (r6 == null) goto L16;
        Long r7 = r6.getChatUniqueKey();
        if (r7 == null) goto L16;
        long r8 = r7.longValue();
    L17:
        r9[5] = TuplesKt.to("key_mark_down_detail_chat_unique_key", Long.valueOf(r8));
        r9[6] = TuplesKt.to("key_mark_down_detail_chat_param", this.d.a.d);
        r9[7] = TuplesKt.to("key_mark_down_detail_is_immersive", Boolean.valueOf(Intrinsics.areEqual(this.d.a.g, Boolean.TRUE)));
        r9[8] = TuplesKt.to("key_mark_down_detail_copy_content", k.f(this.d, r21.c));
        String r10 = com.larus.im.bean.message.a.r(this.b);
        String r11 = "";
        if (r10 != null) goto L20;
        r10 = "";
    L20:
        r9[9] = TuplesKt.to("is_general_agent", r10);
        String r12 = com.larus.im.bean.message.a.s(this.b);
        if (r12 == null) goto L24;
        r11 = r12;
    L24:
        r9[10] = TuplesKt.to("chat_id", r11);
        Bundle r13 = com.larus.utils.f.c(r9);
        r4.c.putExtras(r13);
        r4.d();
    L39:
        String r14 = this.c.getBotId();
        String r15 = this.b.getMessageId();
        if (r21.getType() != FullScreenDetailType.CODE_BLOCK) goto L42;
        String r1 = "code";
    L43:
        g1.a(r14, r15, r1, null, by7.h.g(this.e), 192);
        return;
    L42:
        r1 = "table";
    L16:
        LruCache r16 = ko8.a.a;
        r8 = ko8.a.g();
        goto L17
    L26:
        throw new NoWhenBranchMatchedException();
    L27:
        com.bytedance.router.i r17 = SmartRouter.buildRoute(this.a, "//flow/code_block_detail");
        Pair[] r18 = new Pair[13];
        r18[0] = TuplesKt.to("key_mark_down_detail_raw_content", r21.b);
        r18[1] = TuplesKt.to("key_code_block_code_info", r21.a);
        r18[2] = TuplesKt.to("key_mark_down_detail_message_id", this.b.getMessageId());
        r18[3] = TuplesKt.to("key_mark_down_detail_conversation_id", this.b.getConversationId());
        r18[4] = TuplesKt.to("key_mark_down_detail_bot_model", this.c);
        q0 r19 = this.d.a.f;
        if (r19 == null) goto L34;
        ChatMessageList r22 = r19.B7();
        if (r22 == null) goto L34;
        Long r23 = r22.getChatUniqueKey();
        if (r23 == null) goto L34;
        long r24 = r23.longValue();
    L35:
        r18[5] = TuplesKt.to("key_mark_down_detail_chat_unique_key", Long.valueOf(r24));
        r18[6] = TuplesKt.to("key_mark_down_detail_chat_param", this.d.a.d);
        r18[7] = TuplesKt.to("key_mark_down_detail_is_immersive", Boolean.valueOf(Intrinsics.areEqual(this.d.a.g, Boolean.TRUE)));
        r18[8] = TuplesKt.to("key_mark_down_detail_copy_content", r21.c);
        List<String> r25 = ClickableMarkdownCodeView.H0;
        r18[9] = TuplesKt.to("key_can_code_be_previewed", Boolean.valueOf(ClickableMarkdownCodeView.a.a(r21.a)));
        r18[10] = TuplesKt.to("key_is_to_preview", Boolean.valueOf(r21.f));
        String r26 = com.larus.im.bean.message.a.r(this.b);
        if (r26 != null) goto L38;
        r26 = "0";
    L38:
        r18[11] = TuplesKt.to("is_general_agent", r26);
        r18[12] = TuplesKt.to("chat_id", com.larus.im.bean.message.a.s(this.b));
        Bundle r27 = com.larus.utils.f.c(r18);
        r17.c.putExtras(r27);
        r17.d();
    L34:
        LruCache r28 = ko8.a.a;
        r24 = ko8.a.g();
        goto L35
    }

    public r(Context r1, Message r2, BotModel r3, k r4, CustomMarkdownTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
