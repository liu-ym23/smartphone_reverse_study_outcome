package com.larus.bmhome.chat.trace.appreciable;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.IMMsgExt;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y {
    public static final Lazy a = null;
    public static final Queue<String> b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;

    static {
        a = LazyKt.lazy(new r());
        b = new LinkedList();
        c = LazyKt.lazy(new s());
        d = LazyKt.lazy(new t());
        e = LazyKt.lazy(new u());
        f = LazyKt.lazy(new v());
        g = LazyKt.lazy(new w());
    }

    public static Keva a() {
        return (Keva) a.getValue();
    }

    public static void b(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        a().erase(r1.getLocalMessageId());
    }

    public static void c(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        Lazy r0 = f;
        if (((Queue) r0.getValue()).size() < 20) goto L5;
        ((Queue) r0.getValue()).poll();
    L5:
        ((Queue) r0.getValue()).add(r3);
    }

    public static void d(String r32, Message r33, String r34, wc9.e r35) {
        Regex r2 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r33, "<this>");
        if (r33.getContentType() == 1) goto L7;
        if (r33.getContentType() == 0) goto L7;
    L9:
        int r3 = 0;
    L10:
        Map r6 = r33.getBusinessExt();
        if (r6 == null) goto L13;
        String r7 = (String) r6.get("key_is_business_error");
    L14:
        Map r8 = r33.getBusinessExt();
        if (r8 == null) goto L17;
        String r9 = (String) r8.get("key_error_code");
    L18:
        Map r10 = r33.getBusinessExt();
        if (r10 == null) goto L21;
        String r11 = (String) r10.get("err_msg");
    L22:
        Map r12 = r33.getExt();
        if (r12 == null) goto L29;
        String r13 = (String) r12.get("has_err");
        if (r13 == null) goto L29;
        Integer r14 = StringsKt.toIntOrNull(r13);
        if (r14 == null) goto L29;
        int r15 = r14.intValue();
    L30:
        boolean r16 = com.larus.bmhome.chat.bean.d.G0(r33);
        if (r16 != true) goto L35;
        String r17 = r33.getLocalMessageId();
        if (r17 != null) goto L57;
    L34:
        r17 = "";
    L57:
        Map r18 = r33.getExt();
        if (r18 == null) goto L60;
        String r19 = (String) r18.get("tea_tags_time_cost");
    L61:
        if (r19 != null) goto L63;
    L66:
        boolean r110 = true;
    L67:
        if (r110 == false) goto L69;
        Map<String, String> r20 = new LinkedHashMap();
    L70:
        IMMsgExt r111 = com.larus.bmhome.chat.bean.d.x(r33);
        String r112 = com.larus.bmhome.chat.bean.d.i(r33);
        Integer r5 = ic8.j.b(r33);
        Map r4 = r33.getExt();
        if (r4 == null) goto L73;
        String r21 = (String) r4.get("spring_guide_card_id");
    L74:
        Map r113 = r33.getExt();
        if (r113 == null) goto L77;
        String r114 = (String) r113.get("is_spring_guide");
    L78:
        Map r22 = r33.getExt();
        if (r22 == null) goto L81;
        String r23 = (String) r22.get("delay_request_interval_ms");
    L82:
        Map r115 = r33.getExt();
        String r24 = r11;
        if (r115 == null) goto L85;
        String r116 = (String) r115.get("common_venue_guide_card_id");
    L86:
        Map r25 = r33.getExt();
        String r26 = r7;
        if (r25 == null) goto L89;
        String r27 = (String) r25.get("is_common_venue_guide");
    L91:
        if (r112.length() <= 0) goto L93;
        int r28 = 1;
    L94:
        String r117 = String.valueOf(r28);
        String r118 = ChatControlTrace.b.Ia(r17);
        if (r118.length() <= 0) goto L97;
        boolean r29 = true;
    L98:
        if (r29 == true) goto L101;
        r118 = null;
    L101:
        Map<String, String> r210 = com.larus.im.bean.message.a.U(r33);
        String r211 = r118;
        if (r210.isEmpty() == false) goto L120;
        Iterator r119 = CollectionsKt.listOf(new String[]{r33.getReplyId(), r17, r33.getMessageId()}).iterator();
    L105:
        if (r119.hasNext() == false) goto L116;
        CommonParamManager.CommonParam r120 = CommonParamManager.c((String) r119.next());
        if (r120 == null) goto L113;
        Map<String, String> r121 = r120.getMessageTrackCommonTags();
        if (r121 == null) goto L113;
        if ((!r121.isEmpty()) == false) goto L113;
    L114:
        if (r121 == null) goto L105;
    L117:
        if (r121 != null) goto L119;
        r210 = MapsKt.emptyMap();
        goto L120
    L119:
        r210 = r121;
    L113:
        r121 = null;
        goto L114
    L116:
        r121 = null;
    L120:
        JSONObject r122 = new JSONObject();
        Iterator<Map.Entry<String, String>> r123 = r210.entrySet().iterator();
    L122:
        if (r123.hasNext() == false) goto L124;
        Map.Entry<String, String> r212 = r123.next();
        r122.put(r212.getKey(), r212.getValue());
        r16 = r16;
        r123 = r123;
        goto L122
    L124:
        boolean r30 = r16;
        if (r21 != null) goto L127;
        r21 = "";
    L127:
        r122.put("spring_guide_card_id", r21);
        if (r114 != null) goto L130;
        r114 = r12;
    L130:
        r122.put("is_spring_guide", r114);
        if (r116 != null) goto L133;
        r116 = r12;
    L133:
        r122.put("common_venue_guide_card_id", r116);
        if (r27 != null) goto L136;
        r27 = r12;
    L136:
        r122.put("is_common_venue_guide", r27);
        if (r23 != null) goto L139;
        r23 = r12;
    L139:
        r122.put("delay_request_interval_ms", r23);
        String r0 = r111.getLocalCallId();
        if (r0 != null) goto L142;
        r0 = r12;
    L142:
        r122.put("local_call_id", r0);
        String r1 = r111.getCallAsrId();
        if (r1 != null) goto L145;
        r1 = r12;
    L145:
        r122.put("call_asr_id", r1);
        r122.put("local_message_id", r33.getLocalMessageId());
        r122.put("is_social", false);
        String r31 = r33.getLocalMessageId();
        if (r31 != null) goto L149;
        r31 = r12;
    L149:
        if (((Queue) c.getValue()).contains(r31) == false) goto L152;
        String r36 = "asr_recog_err";
    L155:
        r122.put("reason", r36);
        MessageStatus r37 = r33.getMessageStatus();
        if (r37 == null) goto L158;
        Integer r38 = Integer.valueOf(r37.value);
    L159:
        r122.put("server_msg_status", r38);
        r122.put("local_msg_status", r33.getMessageStatusLocal());
        r122.put("content_type", r33.getContentType());
        r122.put(MusicAppletPage.KEY_MESSAGE_ID, r33.getMessageId());
        if (r35 == null) goto L162;
        Integer r39 = r35.v;
    L163:
        r122.put("bot_conversation_type", r39);
        if (r35 == null) goto L166;
        String r40 = ic8.n.i(r35);
    L167:
        r122.put("chat_type", r40);
        r122.put("is_voice_message", r3);
        r122.put("is_from_current_user", r30 ? 1 : 0);
        r122.put("message_index", r33.getLocalIndex());
        r122.put(MusicAppletPage.KEY_CONVERSATION_ID, r33.getConversationId());
        r122.put("bot_id", r34);
        r122.put("on_boarding", com.larus.bmhome.chat.bean.d.D(r33).value);
        r122.put("ext_is_business_err", r26);
        r122.put("ext_err_code", r9);
        r122.put("ext_err_msg", r24);
        r122.put("error_code", r15);
        r122.put("reply_id", r33.getReplyId());
        if (r211 == null) goto L170;
        r122.put("scene", r211);
    L170:
        String r41 = (String) r111.get("intention");
        if (r41 != null) goto L173;
        String r124 = r12;
    L174:
        r122.put("intention", r124);
        Map r42 = r33.getExt();
        if (r42 == null) goto L177;
        String r43 = (String) r42.get("general_agent");
    L178:
        String r44 = "1";
        if (Intrinsics.areEqual(r43, "1") == false) goto L181;
        Object r45 = "1";
    L182:
        r122.put("general_agent", r45);
        Map r46 = r33.getExt();
        if (r46 == null) goto L185;
        String r47 = (String) r46.get("is_async_task");
    L187:
        if (Intrinsics.areEqual(r47, "1") == true) goto L190;
        r44 = TriggerSendLoading.NO_LOADING;
    L190:
        r122.put("is_async_task", r44);
        r122.put("version", 2);
        r122.put("action_bar_key", r112);
        r122.put("is_action_bar", r117);
        r122.put("action_bar_template_id", r5);
        Iterator<Map.Entry<String, String>> r48 = r20.entrySet().iterator();
    L192:
        if (r48.hasNext() == false) goto L194;
        Map.Entry<String, String> r49 = r48.next();
        r122.put(r49.getKey(), r49.getValue());
        goto L192
    L194:
        com.larus.platform.service.o.a.reportEvent(r32, r122);
        com.larus.bmhome.utils.c.a(r32, r122, true);
        return;
    L185:
        r47 = null;
        goto L187
    L181:
        r45 = TriggerSendLoading.NO_LOADING;
        goto L182
    L177:
        r43 = null;
        goto L178
    L173:
        r124 = r41;
        goto L174
    L166:
        r40 = null;
        goto L167
    L162:
        r39 = null;
        goto L163
    L158:
        r38 = null;
        goto L159
    L152:
        if (((Queue) d.getValue()).contains(r31) == false) goto L154;
        r36 = "net_err_" + ((Map) e.getValue()).get(r31);
        goto L155
    L154:
        r36 = "default";
        goto L155
    L97:
        r29 = false;
        goto L98
    L93:
        r28 = 0;
        goto L94
    L89:
        r27 = null;
        goto L91
    L85:
        r116 = null;
        goto L86
    L81:
        r23 = null;
        goto L82
    L77:
        r114 = null;
        goto L78
    L73:
        r21 = null;
        goto L74
    L69:
        r20 = z.a(r19, "ChatMobUtil");
        goto L70
    L63:
        if (r19.length() == 0) goto L66;
        r110 = false;
        goto L67
    L60:
        r19 = null;
        goto L61
    L35:
        Iterator r125 = ((Queue) f.getValue()).iterator();
    L37:
        if (r125.hasNext() == false) goto L41;
        Object r126 = r125.next();
        if (Intrinsics.areEqual(((Message) r126).getMessageId(), r33.getReplyId()) == false) goto L37;
    L42:
        Message r127 = (Message) r126;
        if (r127 == null) goto L45;
        String r50 = r127.getLocalMessageId();
    L46:
        if (r50 != null) goto L49;
        r50 = "";
    L49:
        if (r50.length() != 0) goto L51;
        boolean r128 = true;
    L52:
        if (r128 == false) goto L56;
        r50 = r33.getReplyId();
        if (r50 == null) goto L34;
    L56:
        r17 = r50;
        goto L57
    L51:
        r128 = false;
        goto L52
    L45:
        r50 = null;
        goto L46
    L41:
        r126 = null;
    L29:
        r15 = 0;
        goto L30
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r7 = null;
    L7:
        if (r33.getSourceFromAsr() == false) goto L9;
        r3 = 1;
        goto L10
    }
}
