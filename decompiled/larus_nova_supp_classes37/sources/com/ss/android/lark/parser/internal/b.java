package com.ss.android.lark.parser.internal;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Content;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.lark.pb.basic.v1.QuasiMessage;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.AccessInfo;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {

    public static class a {
        public final String a;
        public final StringBuilder b;

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "chatterId is:" + this.a + ", fromTag is:" + this.b.toString();
        }

        public final boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof a) == true) goto L10;
            return false;
        L10:
            return Objects.equals(this.a, ((a) r2).a);
        }

        public a(String r1, String r2) {
            this.a = r1;
            this.b = new StringBuilder(r2);
        }
    }

    public static void e(Map r4) {
        if (CollectionUtils.isNotEmpty(r4) == false) goto L22;
        StringBuilder r0 = new StringBuilder("missedChatterIdsMap not empty: ");
        Iterator r5 = ((HashMap) r4).entrySet().iterator();
        boolean r1 = false;
    L6:
        if (r5.hasNext() == false) goto L15;
        Map.Entry r2 = (Map.Entry) r5.next();
        r0.append(" chatId: ");
        r0.append((String) r2.getKey());
        r0.append("[");
        Map r3 = (Map) r2.getValue();
        if (CollectionUtils.isNotEmpty(r3) == false) goto L14;
        Iterator r6 = r3.values().iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        a r7 = (a) r6.next();
        r0.append(" chatterId: ");
        r0.append(r7.a);
        r0.append(" fromTag: ");
        r0.append(r7.b);
        goto L11
    L13:
        r1 = true;
    L14:
        r0.append("]");
        goto L6
    L15:
        if (r1 == false) goto L23;
        Log.w("EntityAPI", r0.toString());
        return;
    L23:
        return;
    }

    public static com.ss.android.lark.chat.entity.chatter.a d(Entity r10, boolean r11) {
        com.ss.android.lark.chat.entity.chatter.a r0 = j.b(r10, null);
        HashMap r1 = new HashMap(r10.messages);
        if (r10.ephemeral_messages.size() <= 0) goto L5;
        r1.putAll(r10.ephemeral_messages);
    L5:
        HashMap r2 = new HashMap();
        Iterator r3 = r1.values().iterator();
    L7:
        if (r3.hasNext() == false) goto L84;
        Message r4 = (Message) r3.next();
        HashMap r5 = new HashMap();
        Iterator r6 = r4.reactions.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        Message.Reaction r7 = (Message.Reaction) r6.next();
        b(r0, r4.chat_id, r5, r7.chatter_ids, "reaction");
        goto L10
    L12:
        ArrayList r8 = new ArrayList();
        r8.addAll(r4.ack_urgent_chatter_ids);
        r8.addAll(r4.unack_urgent_chatter_ids);
        if (CollectionUtils.isEmpty(r8) == true) goto L15;
        b(r0, r4.chat_id, r5, r8, "ding");
    L15:
        a(r0, r4.chat_id, r5, r4.from_id, "fromId");
        if (TextUtils.isEmpty(r4.original_sender_id) == true) goto L19;
        a(r0, r4.chat_id, r5, r4.original_sender_id, "forward");
    L19:
        if (TextUtils.isEmpty(r4.recaller_id) == true) goto L21;
        a(r0, r4.chat_id, r5, r4.recaller_id, "recallerId");
    L21:
        Message.Type r9 = r4.type;
        if (r9 != Message.Type.SYSTEM) goto L74;
        Content r12 = r4.content;
        if (r12 != null) goto L26;
    L31:
        if (r12 == null) goto L53;
        Content.SystemType r13 = r12.system_type;
        if (r13 != Content.SystemType.USER_CALL_E2EE_VOICE_DURATION) goto L35;
    L44:
        boolean r14 = true;
    L45:
        if (r14 == false) goto L53;
        String r15 = r12.e2ee_from_id;
        String r16 = r12.e2ee_to_id;
        if (r15 == null) goto L50;
        if (r16 == null) goto L50;
        a(r0, r4.chat_id, r5, r15, "VoipContent.fromChatterId");
        a(r0, r4.chat_id, r5, r16, "VoipContent.toChatterId");
    L50:
        String r17 = r12.trigger_id;
        if (r17 == null) goto L83;
        a(r0, r4.chat_id, r5, r17, "VoipContent.triggerId");
    L83:
        c(r2, r0, r4.chat_id, r5);
        goto L7
    L35:
        if (r13 == Content.SystemType.USER_CALL_E2EE_VOICE_ON_CANCELL) goto L44;
        if (r13 == Content.SystemType.USER_CALL_E2EE_VOICE_ON_MISSING) goto L44;
        if (r13 == Content.SystemType.USER_CALL_E2EE_VOICE_WHEN_OCCUPY) goto L44;
        if (r13 == Content.SystemType.USER_CALL_E2EE_VOICE_WHEN_REFUSED) goto L44;
        r14 = false;
    L53:
        if (r12 == null) goto L83;
        Content.SystemType r18 = r12.system_type;
        if (r18 != Content.SystemType.VC_CALL_DURATION) goto L57;
    L68:
        String r19 = r12.vc_from_id;
        String r20 = r12.vc_to_id;
        if (TextUtils.isEmpty(r19) == true) goto L83;
        if (TextUtils.isEmpty(r20) == true) goto L83;
        a(r0, r4.chat_id, r5, r19, "VcCallDuration.fromChatterId");
        a(r0, r4.chat_id, r5, r20, "VcCallDuration.toChatterId");
        goto L83
    L57:
        if (r18 == Content.SystemType.VC_CALL_FINISH_NOTICE) goto L68;
        if (r18 == Content.SystemType.VC_CALL_HOST_BUSY) goto L68;
        if (r18 == Content.SystemType.VC_CALL_HOST_CANCEL) goto L68;
        if (r18 == Content.SystemType.VC_CALL_PARTI_BUSY) goto L68;
        if (r18 == Content.SystemType.VC_CALL_PARTI_CANCEL) goto L68;
        if (r18 != Content.SystemType.VC_CALL_PARTI_NO_ANSWER) goto L83;
    L26:
        if (r12.system_type != Content.SystemType.USER_CHECK_OTHERS_TELEPHONE) goto L31;
        Map r21 = r12.values;
        String r22 = (String) r21.get("caller_id");
        String r23 = (String) r21.get("callee_id");
        if (r22 == null) goto L83;
        if (r23 == null) goto L83;
        a(r0, r4.chat_id, r5, r22, "SystemContent.fromChatterId");
        a(r0, r4.chat_id, r5, r23, "SystemContent.toChatterId");
        goto L83
    L74:
        if (r9 != Message.Type.AUDIO) goto L79;
        Content r24 = r4.content;
        if (TextUtils.isEmpty(r24.origin_sender_id_str) == true) goto L83;
        a(r0, r4.chat_id, r5, r24.origin_sender_id_str, "AUDIO.origin_sender_id_str");
        goto L83
    L79:
        if (r9 != Message.Type.SHARE_USER_CARD) goto L83;
        Content r25 = r4.content;
        if (TextUtils.isEmpty(r25.share_chatter_id) == true) goto L83;
        a(r0, r4.chat_id, r5, r25.share_chatter_id, "SHARE_USER_CARD.share_chatter_id");
        goto L83
    L84:
        Map r110 = r10.quasi_messages;
        if (CollectionUtils.isEmpty(r110) == true) goto L90;
        Iterator r111 = r110.values().iterator();
        if (r111.hasNext() == false) goto L90;
        QuasiMessage r112 = (QuasiMessage) r111.next();
        HashMap r26 = new HashMap();
        String r27 = r112.from_id;
        r26.put(r27, new a(r27, "quasiMessage"));
        c(r2, r0, r112.chat_id, r26);
    L90:
        if (CollectionUtils.isNotEmpty(r2) == false) goto L97;
        Iterator r113 = r2.entrySet().iterator();
    L93:
        if (r113.hasNext() == false) goto L97;
        if (TextUtils.isEmpty((CharSequence) ((Map.Entry) r113.next()).getKey()) == false) goto L93;
        r113.remove();
    L97:
        e(r2);
        if (r2.isEmpty() == true) goto L112;
        Iterator r114 = r2.entrySet().iterator();
    L102:
        if (r114.hasNext() == false) goto L112;
        Map.Entry r28 = (Map.Entry) r114.next();
        String r29 = (String) r28.getKey();
        Map r30 = (Map) r28.getValue();
        Map r31 = ImSdkService.d().A2(r29, new ArrayList(r30.keySet()));
        Iterator r32 = r30.keySet().iterator();
    L105:
        if (r32.hasNext() == false) goto L110;
        Chatter r33 = (Chatter) r31.get((String) r32.next());
        if (r33 == null) goto L105;
        r0.d(r33);
        r32.remove();
        goto L105
    L110:
        if (r30.isEmpty() == false) goto L102;
        r114.remove();
    L112:
        if (r11 == true) goto L114;
    L133:
        e(r2);
        if (CollectionUtils.isNotEmpty(r2) == true) goto L136;
    L148:
        return r0;
    L136:
        if (CollectionUtils.isEmpty(r2) == true) goto L148;
        Iterator r115 = r2.entrySet().iterator();
    L140:
        if (r115.hasNext() == false) goto L148;
        Map r116 = (Map) ((Map.Entry) r115.next()).getValue();
        Iterator r34 = r116.keySet().iterator();
    L143:
        if (r34.hasNext() == false) goto L146;
        String r35 = (String) r34.next();
        Chatter r36 = new Chatter();
        r36.setId(r35);
        r36.setName(UIHelper.getString(2131892308));
        r0.d(r36);
        r34.remove();
        goto L143
    L146:
        if (r116.isEmpty() == false) goto L140;
        r115.remove();
        goto L140
    L114:
        if (CollectionUtils.isEmpty(r2) == true) goto L133;
        if (r2.isEmpty() == true) goto L133;
        Iterator r117 = r2.entrySet().iterator();
    L120:
        if (r117.hasNext() == false) goto L133;
        Map.Entry r118 = (Map.Entry) r117.next();
        String r37 = (String) r118.getKey();
        Map r119 = (Map) r118.getValue();
        Map r38 = ImSdkService.d().ld(r37, new ArrayList(r119.keySet()));
        if (r38 == null) goto L120;
        Iterator r39 = r119.keySet().iterator();
    L126:
        if (r39.hasNext() == false) goto L131;
        Chatter r40 = (Chatter) r38.get((String) r39.next());
        if (r40 == null) goto L126;
        r0.d(r40);
        r39.remove();
        goto L126
    L131:
        if (r119.isEmpty() == false) goto L120;
        r117.remove();
        goto L120
    }

    public static void c(Map<String, Map<String, a>> r2, com.ss.android.lark.chat.entity.chatter.a r3, String r4, Map<String, a> r5) {
        HashMap r6 = (HashMap) r5;
        if (r6.isEmpty() == true) goto L12;
        HashMap r7 = (HashMap) r2;
        if (r7.containsKey(r4) == false) goto L7;
        Map r8 = (Map) r7.get(r4);
    L8:
        Iterator r9 = r6.values().iterator();
    L10:
        if (r9.hasNext() == false) goto L14;
        a r0 = (a) r9.next();
        a(r3, r4, r8, r0.a, r0.b.toString());
        goto L10
    L14:
        return;
    L7:
        HashMap r1 = new HashMap();
        r7.put(r4, r1);
        r8 = r1;
        goto L8
    }

    public static void a(com.ss.android.lark.chat.entity.chatter.a r0, String r1, Map<String, a> r2, String r3, String r4) {
        b(r0, r1, r2, Collections.singletonList(r3), r4);
    }

    public static void b(com.ss.android.lark.chat.entity.chatter.a r4, String r5, Map<String, a> r6, List<String> r7, String r8) {
        Iterator<String> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L20;
        String r0 = r9.next();
        Map r1 = (Map) ((HashMap) r4.b).get(r5);
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L4;
        if (Objects.equals(r0, "1") == true) goto L15;
        a r3 = r6.get(r0);
        if (r3 == null) goto L18;
        StringBuilder r10 = r3.b;
        r10.append("|");
        r10.append(r8);
        goto L4
    L18:
        r6.put(r0, new a(r0, r8));
        goto L4
    L15:
        Chatter r11 = new Chatter();
        r11.setAccessInfo(new AccessInfo());
        r11.setAvatarKey("1a6b000560475123acd0");
        r11.setCreatorId("6398000646401818882");
        r11.setEnName("System Message");
        r11.setId("1");
        r11.setLocalizedName("System msg");
        r11.setNamePinyin("xi tong xiao xi");
        r11.setNamePy("xi tong xiao xi");
        r11.setTenantId("1");
        r11.setType(Chatter.ChatterType.BOT);
        r11.setWithBotTag("bot");
        r11.setBotExtraType(0);
        ChatChatter r12 = new ChatChatter(r11);
        r12.setChatId(r5);
        r4.d(r12);
        goto L4
    L8:
        if (r1.containsKey(r0) == false) goto L10;
        r2 = true;
        goto L11
    }
}
