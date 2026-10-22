package oi8;

import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return r9 + r1;
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "MobCardInfo(cardId=" + this.a + ", url=" + this.b + ", docId=" + this.c + ", searchId=" + this.d + ')';
        }

        public a(String r1, String r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public n() {
    }

    public static void b(Message r18, ChatParam r19, Integer r20, Integer r21, String r22, String r23, String r24, String r25, Boolean r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, int r35) {
        if ((r35 & 4) == 0) goto L5;
        Integer r2 = null;
    L7:
        if ((r35 & 8) == 0) goto L9;
        Integer r4 = null;
    L10:
        Object r6 = "";
        if ((r35 & 16) == 0) goto L13;
        Object r5 = "";
    L15:
        if ((r35 & 32) == 0) goto L17;
        Object r7 = "";
    L19:
        if ((r35 & 64) == 0) goto L21;
        Object r8 = "";
    L23:
        if ((r35 & 256) == 0) goto L25;
        Object r9 = null;
    L27:
        if ((r35 & 512) == 0) goto L29;
        Boolean r10 = null;
    L31:
        if ((r35 & 1024) == 0) goto L33;
        Object r11 = "";
    L35:
        if ((r35 & 2048) != 0) goto L39;
        r6 = r28;
    L39:
        if ((r35 & 4096) == 0) goto L41;
        Object r12 = null;
    L43:
        if ((r35 & 8192) == 0) goto L45;
        Object r13 = null;
    L47:
        if ((r35 & 16384) == 0) goto L49;
        Object r14 = null;
    L51:
        if ((32768 & r35) == 0) goto L53;
        Object r15 = null;
    L55:
        if ((r35 & 65536) == 0) goto L57;
        Object r3 = null;
    L59:
        if ((r35 & 131072) == 0) goto L61;
        Object r210 = null;
    L62:
        Object r211 = r3;
        Intrinsics.checkNotNullParameter(r18, "msg");
        Intrinsics.checkNotNullParameter(r5, "cardId");
        Intrinsics.checkNotNullParameter(r7, "cardType");
        Intrinsics.checkNotNullParameter(r8, "botId");
        o r1 = o.a;
        JSONObject r16 = new JSONObject();
        if (r19 == null) goto L65;
        Object r17 = r19.d;
    L66:
        r16.put("current_page", r17);
        if (r19 == null) goto L69;
        Object r36 = r19.c;
    L70:
        r16.put("previous_page", r36);
        r16.put("message_id", r18.getMessageId());
        r16.put("conversation_id", r18.getConversationId());
        r16.put("bot_id", r8);
        if (r19 == null) goto L73;
        Object r0 = r19.e;
    L74:
        r16.put("chat_type", r0);
        r16.put("reply_id", r18.getReplyId());
        r16.put("module_position", "within_text");
        r16.put("module_type", "simple_search");
        r16.put("card_id", r5);
        r16.put("card_type", r7);
        if (r2 == null) goto L77;
        r16.put("card_position", r2.intValue() + 1);
    L77:
        if (r4 == null) goto L79;
        r16.put("position", r4.intValue());
        r16.put("search_position", r4.intValue());
    L79:
        if (r9 == null) goto L81;
        r16.put("status", r9);
    L81:
        r16.put("req_id", com.larus.bmhome.chat.bean.d.x(r18).getReqId());
        r16.put("is_deep_thinking", Intrinsics.areEqual(r10, Boolean.TRUE) ? 1 : 0);
        r16.put("deep_research_id", r11);
        r16.put("doc_id", r6);
        if (r13 == null) goto L84;
        r16.put("tool_name", r13);
    L84:
        if (r12 == null) goto L86;
        r16.put("url", r12);
    L86:
        if (r14 == null) goto L88;
        r16.put("module_source", r14);
    L88:
        if (r15 == 0) goto L90;
        r16.put("code_type", r15);
    L90:
        if (r211 == null) goto L92;
        r16.put("chat_type", r211);
    L92:
        if (r210 == null) goto L94;
        r16.put("search_id", r210);
    L94:
        Unit r37 = Unit.INSTANCE;
        r1.reportEvent("show_card", r16);
        return;
    L73:
        r0 = null;
        goto L74
    L69:
        r36 = null;
        goto L70
    L65:
        r17 = null;
        goto L66
    L61:
        r210 = r34;
        goto L62
    L57:
        r3 = r33;
        goto L59
    L53:
        r15 = r32;
        goto L55
    L49:
        r14 = r31;
        goto L51
    L45:
        r13 = r30;
        goto L47
    L41:
        r12 = r29;
        goto L43
    L33:
        r11 = r27;
        goto L35
    L29:
        r10 = r26;
        goto L31
    L25:
        r9 = r25;
        goto L27
    L21:
        r8 = r24;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r5 = r22;
        goto L15
    L9:
        r4 = r21;
        goto L10
    L5:
        r2 = r20;
        goto L7
    }

    public static void a(Message r22, ChatParam r23, Integer r24, Integer r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, Boolean r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, int r43) {
        if ((r43 & 4) == 0) goto L5;
        Integer r2 = null;
    L7:
        if ((r43 & 8) == 0) goto L9;
        Integer r4 = null;
    L10:
        Object r6 = "";
        if ((r43 & 16) == 0) goto L13;
        Object r5 = "";
    L15:
        if ((r43 & 32) == 0) goto L17;
        Object r7 = "";
    L19:
        if ((r43 & 64) == 0) goto L21;
        Object r8 = "";
    L23:
        if ((r43 & 128) == 0) goto L25;
        Object r9 = "";
    L27:
        if ((r43 & 512) == 0) goto L29;
        Object r10 = null;
    L31:
        if ((r43 & 1024) == 0) goto L33;
        Object r11 = null;
    L35:
        if ((r43 & 2048) == 0) goto L37;
        Object r12 = null;
    L39:
        if ((r43 & 4096) == 0) goto L41;
        Object r13 = null;
    L43:
        if ((r43 & 8192) == 0) goto L45;
        Boolean r14 = null;
    L47:
        if ((r43 & 16384) == 0) goto L49;
        Object r15 = null;
    L51:
        if ((r43 & 32768) == 0) goto L53;
        Object r3 = "";
    L55:
        if ((r43 & 65536) != 0) goto L59;
        r6 = r37;
    L59:
        if ((r43 & 131072) == 0) goto L61;
        Object r18 = null;
    L63:
        if ((r43 & 262144) == 0) goto L65;
        Object r19 = null;
    L67:
        if ((r43 & 524288) == 0) goto L69;
        Object r20 = null;
    L71:
        if ((r43 & 1048576) == 0) goto L73;
        Object r21 = null;
    L75:
        if ((r43 & 2097152) == 0) goto L77;
        Object r210 = null;
    L78:
        Object r17 = r6;
        Intrinsics.checkNotNullParameter(r22, "msg");
        Intrinsics.checkNotNullParameter(r5, "cardId");
        Intrinsics.checkNotNullParameter(r7, "cardType");
        Intrinsics.checkNotNullParameter(r8, "botId");
        Intrinsics.checkNotNullParameter(r9, "clickEffect");
        o r1 = o.a;
        JSONObject r16 = new JSONObject();
        if (r23 == null) goto L81;
        Object r44 = r23.d;
    L82:
        r16.put("current_page", r44);
        if (r23 == null) goto L85;
        Object r0 = r23.c;
    L86:
        r16.put("previous_page", r0);
        r16.put("message_id", r22.getMessageId());
        r16.put("conversation_id", r22.getConversationId());
        r16.put("bot_id", r8);
        r16.put("reply_id", r22.getReplyId());
        r16.put("module_position", "within_text");
        r16.put("module_type", "simple_search");
        r16.put("card_id", r5);
        r16.put("card_type", r7);
        if (r10 == null) goto L89;
        r16.put("is_immersive_background", r10);
    L89:
        if (r11 == null) goto L92;
        r16.put("recommend_from", r11);
    L92:
        if (r12 == null) goto L94;
        r16.put("req_id", r12);
    L94:
        if (r2 == null) goto L96;
        r16.put("card_position", r2.intValue() + 1);
    L96:
        if (r4 == null) goto L99;
        r16.put("position", r4.intValue());
        r16.put("search_position", r4.intValue());
    L99:
        if (r13 == null) goto L101;
        r16.put("chat_type", r13);
    L102:
        r16.put("click_effect", r9);
        r16.put("req_id", com.larus.bmhome.chat.bean.d.x(r22).getReqId());
        r16.put("is_deep_thinking", Intrinsics.areEqual(r14, Boolean.TRUE) ? 1 : 0);
        r16.put("deep_research_id", r3);
        if (r15 == 0) goto L105;
        r16.put("click_position", r15);
    L105:
        r16.put("doc_id", r17);
        Object r45 = r18;
        if (r45 == null) goto L108;
        r16.put("url", r45);
    L108:
        Object r46 = r19;
        if (r46 == null) goto L111;
        r16.put("tool_name", r46);
    L111:
        Object r47 = r21;
        if (r47 == null) goto L114;
        r16.put("module_source", r47);
    L114:
        Object r48 = r20;
        if (r48 == null) goto L117;
        r16.put("code_type", r48);
    L117:
        if (r210 == null) goto L119;
        r16.put("search_id", r210);
    L119:
        Unit r49 = Unit.INSTANCE;
        r1.reportEvent("click_card", r16);
        return;
    L101:
        r16.put("chat_type", "default");
        goto L102
    L85:
        r0 = null;
        goto L86
    L81:
        r44 = null;
        goto L82
    L77:
        r210 = r42;
        goto L78
    L73:
        r21 = r41;
        goto L75
    L69:
        r20 = r40;
        goto L71
    L65:
        r19 = r39;
        goto L67
    L61:
        r18 = r38;
        goto L63
    L53:
        r3 = r36;
        goto L55
    L49:
        r15 = r35;
        goto L51
    L45:
        r14 = r34;
        goto L47
    L41:
        r13 = r33;
        goto L43
    L37:
        r12 = r32;
        goto L39
    L33:
        r11 = r31;
        goto L35
    L29:
        r10 = r30;
        goto L31
    L25:
        r9 = r29;
        goto L27
    L21:
        r8 = r28;
        goto L23
    L17:
        r7 = r27;
        goto L19
    L13:
        r5 = r26;
        goto L15
    L9:
        r4 = r25;
        goto L10
    L5:
        r2 = r24;
        goto L7
    }
}
