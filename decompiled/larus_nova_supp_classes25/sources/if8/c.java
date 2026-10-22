package if8;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.collection.LruCache;
import by7.h;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.widget.handler.e;
import com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1.v;
import com.larus.bmhome.chat.list.trace.HighlightWordShowScene;
import com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView;
import com.larus.bmhome.chat.markdown.code.share.CodeShareHelper;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.utils.c3;
import com.larus.bmhome.utils.s3;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.bmhome.view.textview.impl.GestureTextView;
import com.larus.business.markdown.api.FullScreenDetailType;
import com.larus.home.impl.sdk.i1;
import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.IMMsgExt;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import fh8.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import lw8.g;
import lw8.k;
import lw8.l;
import org.json.JSONObject;
import tx9.c0;
import tx9.g1;
import tx9.j0;
import tx9.q;
import tx9.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final /* synthetic */ int b = 0;
    public final d a;

    public static final class a {
    }

    static {
    }

    public c(d r2) {
        Intrinsics.checkNotNullParameter(r2, "markdownEventProcessorParams");
        this.a = r2;
    }

    public final JSONObject a(Message r4) {
        JSONObject r0 = new JSONObject();
        q0.a r1 = this.a.j;
        if (r1 == null) goto L9;
        y r2 = r1.u0();
        if (r2 == null) goto L9;
        String r3 = r2.getBotId();
        if (r3 == null) goto L9;
    L10:
        r0.put("bot_id", r3);
        r0.put("message_id", r4.getMessageId());
        r0.put("conversation_id", r4.getConversationId());
        r0.put("footnote_style", ChatDraftItem.TYPE_TEXT);
        return r0;
    L9:
        r3 = "";
        goto L10
    }

    public final void d(g r21) {
        Intrinsics.checkNotNullParameter(r21, "span");
        com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1.a r1 = v.a(r21);
        d r3 = this.a;
        Message r4 = r3.a;
        BotModel r5 = r3.d;
        String r6 = r3.c.d;
        if (r6 != null) goto L5;
    L12:
        r6 = "chat";
    L13:
        String r7 = r6;
        String r8 = this.a.c.c;
        String r9 = r4.getMessageId();
        String r10 = r4.getConversationId();
        String r11 = r5.getBotId();
        String r12 = this.a.c.e;
        String r13 = r4.getReplyId();
        String r14 = r21.a();
        String r15 = r1.a;
        String r16 = r1.e;
        String r2 = r1.b;
        String r17 = r1.d;
        String r18 = r1.c;
        x1.b(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r2, r17, com.larus.bmhome.chat.bean.d.u(r4), r18);
        return;
    L5:
        if (r6.length() <= 0) goto L7;
        boolean r19 = true;
    L8:
        if (r19 == true) goto L11;
        r6 = null;
    L11:
        if (r6 != null) goto L13;
    L7:
        r19 = false;
        goto L8
    }

    public final void j(g r21) {
        Intrinsics.checkNotNullParameter(r21, "span");
        com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1.a r1 = v.a(r21);
        d r3 = this.a;
        Message r4 = r3.a;
        BotModel r5 = r3.d;
        String r6 = r3.c.d;
        if (r6 != null) goto L5;
    L12:
        r6 = "chat";
    L13:
        String r7 = r6;
        String r8 = this.a.c.c;
        String r9 = r4.getMessageId();
        String r10 = r4.getConversationId();
        String r11 = r5.getBotId();
        String r12 = this.a.c.e;
        String r13 = r4.getReplyId();
        String r14 = r21.a();
        String r15 = r1.a;
        String r16 = r1.e;
        String r2 = r1.b;
        String r17 = r1.d;
        String r18 = r1.c;
        x1.c(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r2, r17, com.larus.bmhome.chat.bean.d.u(r4), r18);
        return;
    L5:
        if (r6.length() <= 0) goto L7;
        boolean r19 = true;
    L8:
        if (r19 == true) goto L11;
        r6 = null;
    L11:
        if (r6 != null) goto L13;
    L7:
        r19 = false;
        goto L8
    }

    public final void b(Context r6, gw8.b r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "span");
        d r0 = this.a;
        Message r1 = r0.a;
        BotModel r2 = r0.d;
        i r8 = SmartRouter.buildRoute(r6, "//flow/code_block_detail");
        Pair[] r3 = new Pair[14];
        r3[0] = TuplesKt.to("key_mark_down_detail_raw_content", r7.getContent());
        r3[1] = TuplesKt.to("key_code_block_code_info", r7.getInfo());
        r3[2] = TuplesKt.to("key_mark_down_detail_message_id", r1.getMessageId());
        r3[3] = TuplesKt.to("key_mark_down_detail_conversation_id", r1.getConversationId());
        r3[4] = TuplesKt.to("key_mark_down_detail_bot_model", r2);
        q0 r4 = this.a.g;
        if (r4 == null) goto L9;
        ChatMessageList r5 = r4.B7();
        if (r5 == null) goto L9;
        Long r9 = r5.getChatUniqueKey();
        if (r9 == null) goto L9;
        long r10 = r9.longValue();
    L10:
        r3[5] = TuplesKt.to("key_mark_down_detail_chat_unique_key", Long.valueOf(r10));
        r3[6] = TuplesKt.to("key_mark_down_detail_chat_param", this.a.c);
        r3[7] = TuplesKt.to("key_mark_down_detail_is_immersive", Boolean.valueOf(Intrinsics.areEqual(this.a.h, Boolean.TRUE)));
        r3[8] = TuplesKt.to("key_mark_down_detail_copy_content", r7.a());
        List<String> r11 = ClickableMarkdownCodeView.H0;
        r3[9] = TuplesKt.to("key_can_code_be_previewed", Boolean.valueOf(ClickableMarkdownCodeView.a.a(r7.getInfo())));
        r3[10] = TuplesKt.to("key_is_to_preview", Boolean.valueOf(r7.isPreview()));
        Function0<Map<String, Object>> r12 = this.a.k;
        if (r12 == null) goto L13;
        Map r13 = (Map) r12.invoke();
    L14:
        r3[11] = TuplesKt.to("key_event_extra", r13);
        String r14 = com.larus.im.bean.message.a.r(r1);
        if (r14 != null) goto L17;
        r14 = "0";
    L17:
        r3[12] = TuplesKt.to("is_general_agent", r14);
        String r15 = com.larus.im.bean.message.a.s(r1);
        if (r15 != null) goto L20;
        r15 = "";
    L20:
        r3[13] = TuplesKt.to("chat_id", r15);
        Bundle r16 = f.c(r3);
        r8.c.putExtras(r16);
        r8.d();
        return;
    L13:
        r13 = null;
    L9:
        LruCache r17 = ko8.a.a;
        r10 = ko8.a.g();
        goto L10
    }

    public final void c(Context r6, gw8.b r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "span");
        d r0 = this.a;
        Message r1 = r0.a;
        BotModel r2 = r0.d;
        i r8 = SmartRouter.buildRoute(r6, "//flow/table_block_detail");
        Pair[] r3 = new Pair[12];
        r3[0] = TuplesKt.to("key_mark_down_detail_raw_content", r7.getContent());
        r3[1] = TuplesKt.to("key_mark_down_detail_message_id", r1.getMessageId());
        r3[2] = TuplesKt.to("key_mark_down_detail_conversation_id", r1.getConversationId());
        r3[3] = TuplesKt.to("key_mark_down_detail_bot_model", r2);
        r3[4] = TuplesKt.to("key_mark_down_detail_message", r1);
        q0 r4 = this.a.g;
        if (r4 == null) goto L9;
        ChatMessageList r5 = r4.B7();
        if (r5 == null) goto L9;
        Long r9 = r5.getChatUniqueKey();
        if (r9 == null) goto L9;
        long r10 = r9.longValue();
    L10:
        r3[5] = TuplesKt.to("key_mark_down_detail_chat_unique_key", Long.valueOf(r10));
        r3[6] = TuplesKt.to("key_mark_down_detail_chat_param", this.a.c);
        r3[7] = TuplesKt.to("key_mark_down_detail_is_immersive", Boolean.valueOf(Intrinsics.areEqual(this.a.h, Boolean.TRUE)));
        r3[8] = TuplesKt.to("key_mark_down_detail_copy_content", v.b(r7.a()));
        Function0<Map<String, Object>> r11 = this.a.k;
        if (r11 == null) goto L13;
        Map r12 = (Map) r11.invoke();
    L14:
        r3[9] = TuplesKt.to("key_event_extra", r12);
        String r13 = com.larus.im.bean.message.a.r(r1);
        if (r13 != null) goto L17;
        r13 = "0";
    L17:
        r3[10] = TuplesKt.to("is_general_agent", r13);
        String r14 = com.larus.im.bean.message.a.s(r1);
        if (r14 != null) goto L20;
        r14 = "";
    L20:
        r3[11] = TuplesKt.to("chat_id", r14);
        Bundle r15 = f.c(r3);
        r8.c.putExtras(r15);
        r8.d();
        return;
    L13:
        r12 = null;
    L9:
        LruCache r16 = ko8.a.a;
        r10 = ko8.a.g();
        goto L10
    }

    public final void f(View r44, lw8.f r45) {
        Intrinsics.checkNotNullParameter(r44, "view");
        Intrinsics.checkNotNullParameter(r45, "span");
        CodeShareHelper r1 = CodeShareHelper.a;
        Context r2 = r44.getContext();
        String r4 = r45.getCode();
        String r5 = r45.a();
        r1.getClass();
        CodeShareHelper.b(r2, r4, r5);
        if (Intrinsics.areEqual(r45.a(), "table") == false) goto L21;
        ri8.c r3 = ri8.c.a;
        String r6 = this.a.a.getMessageId();
        d r7 = this.a;
        int r8 = r7.b;
        String r9 = r7.a.getConversationId();
        d r10 = this.a;
        String r13 = r10.c.e;
        String r31 = r10.d.getBotId();
        if (this.a.e == false) goto L7;
        String r11 = "thinking_progress";
    L8:
        String r12 = r11;
        String r14 = r45.a();
        String r15 = this.a.c.d;
        if (r15 != null) goto L11;
    L18:
        r15 = "chat";
    L19:
        String r42 = r15;
        Function0<Map<String, Object>> r16 = this.a.k;
        ri8.c.m(null, r6, r9, null, r42, null, Integer.valueOf(r8), null, r12, null, r14, r31, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r13, null, null, null, "download_table", null, r16, null, null, -536874327, 53);
        return;
    L11:
        if (r15.length() <= 0) goto L13;
        boolean r17 = true;
    L14:
        if (r17 == true) goto L17;
        r15 = null;
    L17:
        if (r15 != null) goto L19;
    L13:
        r17 = false;
        goto L14
    L7:
        r11 = "within_text";
        goto L8
    }

    public final void g(View r47, CustomMarkdownTextView r48) {
        c r1 = this;
        String r3 = "ext";
        String r4 = "3";
        String r5 = "1";
        Intrinsics.checkNotNullParameter(r47, "it");
        d r6 = r1.a;
        Message r7 = r6.a;
        Block r8 = r6.i;
        if (r8 == null) goto L6;
        List<IMMetaInfo.f> r9 = com.larus.bmhome.chat.bean.d.d1(r8);
        if (r9 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r47, "<this>");
        fh8.a r10 = (fh8.a) e.a(r47, "clicked_markdown_link_info");
        boolean r11 = r47 instanceof TextView;
        if (r11 == false) goto L10;
        TextView r12 = (TextView) r47;
    L11:
        if (r12 == null) goto L13;
        Integer r13 = Integer.valueOf(r12.getSelectionStart());
    L14:
        if (r11 == false) goto L16;
        TextView r14 = (TextView) r47;
    L17:
        if (r14 == null) goto L19;
        Integer r15 = Integer.valueOf(r14.getSelectionEnd());
    L20:
        BotModel r16 = r1.a.d;
        if (Intrinsics.areEqual(r13, r15) == false) goto L32;
        if (r13 == null) goto L32;
        if (r13.intValue() != (-1)) goto L32;
        if ((r47 instanceof GestureTextView) == false) goto L29;
        GestureTextView r17 = (GestureTextView) r47;
    L30:
        if (r17 == null) goto L32;
        int r18 = r17.getOffsetForPosition(r17.getClickX(), r17.getClickY());
    L34:
        if ((r47 instanceof CustomMarkdownTextView) == false) goto L36;
        CustomMarkdownTextView r0 = (CustomMarkdownTextView) r47;
    L37:
        if (r0 == null) goto L248;
        l r2 = r0.getMarkdownContent();
        if (r2 == null) goto L277;
        Iterator r19 = ((ArrayList) x.b(r2)).iterator();
        int r110 = 0;
    L42:
        if (r19.hasNext() == false) goto L278;
        Object r20 = r19.next();
        int r111 = r110 + 1;
        if (r110 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        String r112 = r4;
        k r21 = (k) r20;
        String r113 = r5;
        if (r10 == null) goto L54;
        if (r10.a == r110) goto L51;
    L73:
        boolean r22 = false;
    L74:
        if (r22 == true) goto L258;
        String r44 = r3;
        List<IMMetaInfo.f> r45 = r9;
        fh8.a r23 = r10;
        Integer r24 = r15;
        int r25 = r18;
    L247:
        r1 = this;
        r110 = r111;
        r4 = r112;
        r5 = r113;
        r10 = r23;
        r15 = r24;
        r18 = r25;
        r3 = r44;
        r9 = r45;
        goto L42
    L258:
        String r26 = r21.a;     // Catch: Throwable -> L82
        if (r26 != null) goto L78;
        r23 = r10;
        r24 = r15;
        r25 = r18;
    L85:
        boolean r27 = false;
    L86:
        if (r27 == false) goto L106;
        String r28 = UriProtector.getQueryParameter(UriProtector.parse(r21.a), r3);     // Catch: Throwable -> L104
        if (r28 != null) goto L90;
    L93:
        boolean r29 = true;
    L94:
        if (r29 == false) goto L97;
    L103:
        String r30 = r113;
    L107:
        String r33 = r30;
    L109:
        Iterator r31 = r9.iterator();
    L111:
        if (r31.hasNext() == false) goto L129;
        Object r114 = r31.next();
        IMMetaInfo.f r32 = (IMMetaInfo.f) r114;
        if (r32 == null) goto L115;
        String r34 = r32.d();
    L116:
        Iterator r210 = r31;
        if (Intrinsics.areEqual(r34, "[" + r21.b + "](" + r21.a + ')') == true) goto L125;
        if (r32 == null) goto L120;
        String r35 = r32.d();
    L122:
        if (Intrinsics.areEqual(r35, "[**" + r21.b + "**](" + r21.a + ')') == true) goto L125;
        boolean r36 = false;
    L126:
        if (r36 == true) goto L130;
        r31 = r210;
    L130:
        IMMetaInfo.f r115 = (IMMetaInfo.f) r114;
        LruCache r37 = ko8.a.a;
        if (r115 == null) goto L133;
        String r38 = r115.c();
    L134:
        IAIChatControlTraceService.Companion r39 = IAIChatControlTraceService.a;
        JSONObject r40 = r39.Ta(r38);
        JSONObject r41 = ko8.a.i(r7, r39.Gb(r21.a, null));
        if (r41 != null) goto L137;
        r41 = new JSONObject();
    L137:
        JSONObject r42 = r41;
        String r211 = r16.getBotId();
        String r212 = r7.getConversationId();
        String r43 = r1.a.c.d;
        if (r43 != null) goto L140;
    L147:
        r43 = "chat";
    L148:
        String r213 = r43;
        String r214 = r7.getMessageId();
        long r116 = ((long) r110) + 1;
        String r117 = r21.b;
        String r46 = r21.a;
        if (r46 != null) goto L262;
        String r310 = "";
        r44 = r3;
        r45 = r9;
    L214:
        if (r115 == null) goto L216;
        String r49 = r115.a();
    L217:
        if (r48 == null) goto L219;
        String r50 = r48.getOnBoardingType();
    L220:
        if (r50 != null) goto L222;
        String r215 = "0";
    L223:
        if (r115 == null) goto L225;
        String r311 = r115.g();
    L226:
        if (r115 == null) goto L234;
        String r51 = r115.h();
        if (r51 == null) goto L234;
        if ((!StringsKt.isBlank(r51)) == true) goto L233;
        r51 = null;
    L233:
        if (r51 == null) goto L234;
    L237:
        String r312 = r51;
        if (r48 == null) goto L240;
        by7.e r410 = h.g(r48);
    L241:
        Regex r52 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r313 = com.larus.bmhome.chat.bean.d.x(r7).getNotifyTaskId();
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r314 = com.larus.bmhome.chat.bean.d.x(r7).getMsgSourceType();
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r315 = com.larus.bmhome.chat.bean.d.x(r7).getMsgCandidateSourceType();
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r316 = com.larus.bmhome.chat.bean.d.x(r7).getMsgGid();
        LruCache r53 = ko8.a.a;
        IAIChatControlTraceService.Companion r54 = IAIChatControlTraceService.a;
        String r317 = r54.pb(r40);
        String r318 = r54.Ya(r40);
        String r411 = ko8.a.c(r7);
        r42.put("agent_tool", r42.optString("fpa_agent_tool"));
        c0.C(r211, r212, r213, r215, r214, Long.valueOf(r116), r117, r310, r311, r312, r33, r314, r315, r316, r313, r317, r318, r411, r49, r42, r410);
        String r55 = r21.a;
        if (r55 == null) goto L247;
        if (c3.a(r55) == false) goto L247;
        x1.e(UriProtector.getQueryParameter(UriProtector.parse(r55), "pc_guide_scene"), null, null, null, null, null, 126);
        goto L247
    L240:
        r410 = null;
    L234:
        LruCache r56 = ko8.a.a;
        r51 = IAIChatControlTraceService.a.Za(r7);
        if (r51 != null) goto L237;
        Set<String> r57 = com.larus.bmhome.chat.list.trace.a.a;
        r51 = com.larus.bmhome.chat.list.trace.a.a(r21.a);
        goto L237
    L225:
        r311 = null;
        goto L226
    L222:
        r215 = r113;
        goto L223
    L219:
        r50 = null;
        goto L220
    L216:
        r49 = null;
        goto L217
    L262:
        String r58 = UriProtector.getQueryParameter(UriProtector.parse(r46), r3);     // Catch: Exception -> L201
        if (r58 == null) goto L157;
        if (r58.length() == 0) goto L157;
        boolean r216 = false;
    L158:
        if (r216 == true) goto L200;
        String r217 = r46;
        IMMsgExt r59 = new IMMsgExt();     // Catch: Throwable -> L190
        if (r58 != null) goto L266;
    L167:
        boolean r218 = true;
    L168:
        if (r218 == false) goto L256;
        r44 = r3;
        r45 = r9;
    L185:
        Object r60 = null;
    L260:
        Map r61 = (Map) r60;     // Catch: Throwable -> L249
        if (r61 == null) goto L193;
        r59.putAll(r61);     // Catch: Throwable -> L249
    L193:
        if (r59 != null) goto L252;
    L199:
        String r62 = "";
    L205:
        if (r62 != null) goto L207;
    L210:
        boolean r63 = true;
    L211:
        if (r63 == true) goto L213;
        r310 = r62;
        goto L214
    L213:
        r310 = r217;
        goto L214
    L207:
        if (r62.length() == 0) goto L210;
        r63 = false;
        goto L211
    L252:
        r62 = r59.getSWikiLink();     // Catch: Exception -> L197
        if (r62 != null) goto L205;
    L197:
        e = e;
    L203:
        FLogger.a.e("", "parese URL err msg=" + e.getMessage());
    L204:
        r62 = null;
    L192:
        r59 = null;
        goto L193
    L256:
        Result.Companion r219 = Result.Companion;     // Catch: Throwable -> L180
        r44 = r3;
        r45 = r9;
        r60 = Result.constructor-impl(HttpExtKt.f.fromJson(r58, Map.class));     // Catch: Throwable -> L176
    L184:
        if (Result.isFailure-impl(r60) == false) goto L260;
    L176:
        th = th;
    L182:
        Result.Companion r64 = Result.Companion;     // Catch: Throwable -> L249
        r60 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L249
    L178:
        th = th;
    L179:
        r45 = r9;
    L180:
        th = th;
        r44 = r3;
        goto L179
    L266:
        if (StringsKt.isBlank(r58) == true) goto L167;
        r218 = false;
    L166:
        r44 = r3;
        r45 = r9;
    L190:
        r44 = r3;
        r45 = r9;
        goto L192
    L200:
        r217 = r46;
        r44 = r3;
        r45 = r9;
    L157:
        r216 = true;
    L201:
        e = e;
        r217 = r46;
        r44 = r3;
        r45 = r9;
        goto L203
    L140:
        if (r43.length() <= 0) goto L142;
        boolean r118 = true;
    L143:
        if (r118 == true) goto L146;
        r43 = null;
    L146:
        if (r43 != null) goto L148;
    L142:
        r118 = false;
        goto L143
    L133:
        r38 = null;
        goto L134
    L120:
        r35 = null;
    L125:
        r36 = true;
        goto L126
    L115:
        r34 = null;
        goto L116
    L129:
        r114 = null;
        goto L130
    L97:
        if (r28 != null) goto L100;
        r28 = "";
    L100:
        if (new JSONObject(r28).has("s$wiki_link") == false) goto L103;
        r30 = "2";
        goto L107
    L90:
        if (StringsKt.isBlank(r28) == true) goto L93;
        r29 = false;
        goto L94
    L106:
        r30 = r112;
        goto L107
    L78:
        r23 = r10;
        r24 = r15;
        r25 = r18;
        if (StringsKt.startsWith$default(r26, "coco://sendMessage?", false, 2, null) != true) goto L85;
        r27 = true;
    L104:
        th = th;
    L108:
        FLogger.a.e("MarkdownTextViewClickHandler", "parse link err ! msg=" + th);
        r33 = r112;
    L82:
        th = th;
        r23 = r10;
        r24 = r15;
        r25 = r18;
        goto L108
    L51:
        if (Intrinsics.areEqual(r10.b, r21) == false) goto L73;
    L72:
        r22 = true;
        goto L74
    L54:
        if (Intrinsics.areEqual(r13, r21.c) == false) goto L58;
        if (Intrinsics.areEqual(r15, r21.d) == true) goto L72;
    L58:
        if (r18 == (-1)) goto L73;
        Integer r65 = r21.c;
        if (r65 == null) goto L62;
        int r66 = r65.intValue();
    L63:
        Integer r67 = r21.d;
        if (r67 == null) goto L66;
        int r68 = r67.intValue();
    L67:
        if (r18 > r68) goto L70;
        if (r66 > r18) goto L70;
        boolean r69 = true;
    L71:
        if (r69 == false) goto L73;
    L70:
        r69 = false;
        goto L71
    L66:
        r68 = 0;
        goto L67
    L62:
        r66 = 0;
        goto L63
    L278:
        return;
    L277:
        return;
    L248:
        return;
    L36:
        r0 = null;
        goto L37
    L29:
        r17 = null;
    L32:
        r18 = -1;
        goto L34
    L19:
        r15 = null;
        goto L20
    L16:
        r14 = null;
        goto L17
    L13:
        r13 = null;
        goto L14
    L10:
        r12 = null;
    L6:
        r9 = com.larus.bmhome.chat.bean.d.c1(r7);
        goto L7
    }

    public final void h(lw8.f r50, by7.e r51) {
        Intrinsics.checkNotNullParameter(r50, "it");
        d r1 = this.a;
        Message r3 = r1.a;
        BotModel r2 = r1.d;
        ri8.c r4 = ri8.c.a;
        String r6 = String.valueOf(r50.getCode().hashCode());
        String r16 = r50.a();
        String r5 = r2.getBotId();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        String r17 = r5;
        ChatParam r7 = this.a.c;
        String r10 = r7.e;
        String r8 = r7.d;
        boolean r45 = false;
        String r48 = null;
        if (r8 != null) goto L8;
    L15:
        r8 = "chat";
    L16:
        String r9 = r3.getMessageId();
        String r11 = r3.getConversationId();
        q0 r12 = this.a.g;
        if (r12 == null) goto L19;
        LruSet<String> r13 = r12.E7();
    L20:
        ri8.c.n(r13, r6, r9, r11, null, r8, null, null, null, null, null, r16, r17, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r10, null, null, null, null, null, null, this.a.k, null, -536877104, 47);
        String r14 = this.a.c.d;
        if (r14 != null) goto L23;
    L30:
        String r15 = "chat";
    L31:
        ChatParam r18 = this.a.c;
        q.a("copy", r15, r18.c, r18.e, r2.getBotId(), r3.getConversationId(), r3.getMessageId(), "answer", r3.getSectionId(), 1L, r50.a(), yc9.c0.c(r3, new JSONObject()), r51);
        return;
    L23:
        if (r14.length() <= 0) goto L25;
        r45 = true;
    L25:
        if (r45 == false) goto L27;
        r48 = r14;
    L27:
        if (r48 == null) goto L30;
        r15 = r48;
        goto L31
    L19:
        r13 = null;
        goto L20
    L8:
        if (r8.length() <= 0) goto L10;
        boolean r19 = true;
    L11:
        if (r19 == true) goto L14;
        r8 = null;
    L14:
        if (r8 != null) goto L16;
    L10:
        r19 = false;
        goto L11
    }

    public final void i(gw8.b r9, View r10) {
        Intrinsics.checkNotNullParameter(r9, "span");
        Intrinsics.checkNotNullParameter(r10, "it");
        d r0 = this.a;
        Message r1 = r0.a;
        String r2 = r0.d.getBotId();
        String r3 = r1.getMessageId();
        if (r9.getType() != FullScreenDetailType.CODE_BLOCK) goto L5;
        String r11 = "code";
    L6:
        by7.e r6 = h.g(r10);
        g1.a(r2, r3, r11, this.a.k, r6, 64);
        return;
    L5:
        r11 = "table";
        goto L6
    }

    public final void k(final int r15, final k r16, CustomMarkdownTextView r17) {
        Intrinsics.checkNotNullParameter(r16, "markDownLinkInfo");
        final String r4 = r16.a;
        final Message r1 = this.a.a;
        if (r4 == null) goto L15;
        if (r17 == null) goto L7;
        Boolean r5 = (Boolean) e.a(r17, "pc_guide: " + r1.getMessageId() + r4);
    L8:
        if (r5 != null) goto L15;
        if (c3.a(r4) == false) goto L15;
        if (r17 == null) goto L13;
        e.b(r17, "pc_guide: " + r1.getMessageId() + r4, Boolean.TRUE);
    L13:
        x1.f(UriProtector.getQueryParameter(UriProtector.parse(r4), "pc_guide_scene"), null, null, null, null, null, 126);
        goto L15
    L7:
        r5 = null;
    L15:
        if (this.a.f == false) goto L17;
        return;
    L17:
        Uri r0 = UriProtector.parse(r4);
        if (Intrinsics.areEqual(r0.getScheme(), "sslocal") == true) goto L20;
    L24:
        boolean r2 = false;
    L25:
        Set<String> r3 = com.larus.bmhome.chat.list.trace.a.a;
        boolean r6 = com.larus.bmhome.chat.list.trace.a.d(r4);
        if (r2 == true) goto L28;
        if (r6 == true) goto L28;
        return;
    L28:
        com.larus.bmhome.chat.list.trace.a.e(HighlightWordShowScene.LINK_LONG_URL, this.a.g, r1.getMessageId(), r4 + '_' + r15, new if8.a(r1, this, r16, r4, r15));
        return;
    L20:
        if (Intrinsics.areEqual(r0.getHost(), "flow") == false) goto L24;
        if (Intrinsics.areEqual(r0.getPath(), "/file_open") == false) goto L24;
        r2 = true;
        goto L25
    }

    public final void e(Context r54, final View r55, lw8.f r56, CustomMarkdownTextView r57, by7.e r58) {
        Intrinsics.checkNotNullParameter(r54, "context");
        Intrinsics.checkNotNullParameter(r55, "view");
        Intrinsics.checkNotNullParameter(r56, "span");
        Intrinsics.checkNotNullParameter(r57, "customMarkdownTextView");
        d r3 = this.a;
        BotModel r6 = r3.d;
        Message r4 = r3.a;
        r55.post(new b(r55));
        String r7 = "table";
        if (Intrinsics.areEqual(r56.a(), "table") == false) goto L8;
        String r2 = v.b(r56.getCode());
        if (z2.a.clipTableHtmlEnabled() == false) goto L7;
        ClipData r5 = ClipData.newHtmlText("info", r2, s3.a(r2));
    L9:
        IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r8 == null) goto L13;
        r8.d0();
        i1 r9 = i1.a;
        Intrinsics.checkNotNull(r5);
        r9.i(r54, r5, "bpea-markdown-text-copy");
    L13:
        if (AudioServiceDelegate.a.getAudioConfig().n(r6) == false) goto L15;
        String r1 = "1";
    L16:
        String r22 = r1;
        String r10 = r6.getBotId();
        ChatParam r11 = this.a.c;
        String r12 = r11.e;
        String r14 = r11.c;
        String r13 = r11.d;
        if (r13 != null) goto L19;
    L26:
        r13 = "chat";
    L27:
        String r15 = r13;
        String r16 = r4.getMessageId();
        String r18 = r56.a();
        String r19 = r4.getConversationId();
        String r20 = r4.getSectionId();
        boolean r17 = this.a.f;
        if (r58 != null) goto L30;
        by7.e r49 = h.g(r57);
    L31:
        StateFlowImpl r21 = ce8.c.a;
        JSONObject r48 = new JSONObject();
        ce8.c.c(r48);
        String r28 = com.larus.bmhome.chat.bean.d.u(r4);
        String r110 = ko8.a.d;
        String r29 = ko8.a.b;
        String r30 = ko8.a.c;
        if (Intrinsics.areEqual(r56.a(), "table") == true) goto L35;
        r7 = "code";
    L35:
        String r46 = com.larus.im.bean.message.a.r(r4);
        Function0<Map<String, Object>> r23 = this.a.k;
        Boolean r24 = Boolean.valueOf(r17);
        j0.a(r10, r12, "copy_button", r15, null, r16, r14, r110, null, 1L, r18, r19, r20, r24, r22, null, "bot", ChatDraftItem.TYPE_TEXT, null, null, r28, r29, r30, null, null, null, null, null, null, null, null, null, null, null, r7, null, null, null, r46, null, r48, r49, r23, 1678765680, 778236);
        return;
    L30:
        r49 = r58;
        goto L31
    L19:
        if (r13.length() <= 0) goto L21;
        boolean r25 = true;
    L22:
        if (r25 == true) goto L25;
        r13 = null;
    L25:
        if (r13 != null) goto L27;
    L21:
        r25 = false;
        goto L22
    L15:
        r1 = "0";
        goto L16
    L7:
        r5 = ClipData.newPlainText("info", r2);
        goto L9
    L8:
        r5 = ClipData.newPlainText("info", r56.getCode());
        goto L9
    }
}
