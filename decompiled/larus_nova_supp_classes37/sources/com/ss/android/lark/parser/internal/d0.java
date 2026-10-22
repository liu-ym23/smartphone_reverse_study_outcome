package com.ss.android.lark.parser.internal;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.MessageSource;
import com.bytedance.lark.pb.basic.v1.MessageSourceType;
import com.bytedance.lark.pb.basic.v1.SubTranslateInfo;
import com.bytedance.lark.pb.im.v1.PushTranslateState;
import com.bytedance.lark.pb.im.v1.TranslateError;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.dto.translate.TranslateState;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d0 {

    public static class a {
        public Message a;
        public HashMap<String, TranslateInfo> b;

        public a() {
        }
    }

    public static class b {
        public boolean a;
        public boolean b;
        public String c;
        public boolean d;

        public b() {
            this.a = false;
            this.b = false;
            this.c = "";
            this.d = false;
        }
    }

    public static b a(Message r9) {
        b r0 = new b();
        MergeForwardContent r1 = r9.getContent();
        List r2 = r1.getMessages();
        if (r2 != null) goto L5;
        return r0;
    L5:
        r0.c = r9.getTranslateLanguage();
        Iterator r3 = r2.iterator();
        int r4 = 0;
    L6:
        int r5 = 1;
        if (r3.hasNext() == false) goto L23;
        Message r6 = (Message) r3.next();
        if (c(r6) == false) goto L6;
        if (r6.getType() != Message.Type.MERGE_FORWARD) goto L16;
        b r7 = a(r6);
        if (r7.a == false) goto L16;
        r0.b |= r7.b;
        r0.c = r7.c;
        r0.d = r7.d;
    L16:
        r4 = r6.getTranslateDisplayRule();
        if (r0.b == true) goto L6;
        if (r4 == 2) goto L21;
        if (r4 != 3) goto L6;
    L21:
        r0.a = true;
        r0.b = true;
        r0.c = r6.getTranslateLanguage();
        r0.d = r6.isTranslatedManually();
        goto L6
    L23:
        if (r1.isFromPrivateTopic() == false) goto L25;
        r9.setTranslateDisplayRule(r4);
    L29:
        r9.setTranslateLanguage(r0.c);
        if (r0.b == true) goto L32;
    L34:
        r9.setTranslatedManually(r0.d);
        return r0;
    L32:
        if (TextUtils.isEmpty(r0.c) == false) goto L34;
        r9.setTranslateLanguage("zh");
        goto L34
    L25:
        if (r0.b == false) goto L27;
        r5 = 2;
    L27:
        r9.setTranslateDisplayRule(r5);
        goto L29
    }

    public static void b(Message r13) {
        MergeForwardContent r0 = r13.getContent();
        List r1 = r0.getMessages();
        if (r1 != null) goto L5;
        return;
    L5:
        String r2 = r13.getTranslateLanguage();
        Iterator r3 = r1.iterator();
        int r4 = 0;
        boolean r5 = false;
        boolean r6 = false;
    L6:
        int r8 = 1;
        if (r3.hasNext() == false) goto L22;
        Message r7 = (Message) r3.next();
        if (c(r7) == false) goto L6;
        Message.Type r11 = r7.getType();
        Message.Type r12 = Message.Type.MERGE_FORWARD;
        if (r11 != r12) goto L13;
        if (r7.getType() != r12) goto L6;
        b(r7);
        goto L6
    L13:
        r4 = r7.getTranslateDisplayRule();
        if (r5 == true) goto L6;
        if (r4 == 2) goto L17;
        if (r4 != 3) goto L6;
    L17:
        r2 = r7.getTranslateLanguage();
        r6 = r7.isTranslatedManually();
        r5 = true;
        goto L6
    L22:
        if (CollectionUtils.isEmpty(r1) == true) goto L32;
        Iterator r9 = r1.iterator();
    L25:
        if (r9.hasNext() == false) goto L32;
        Message r10 = (Message) r9.next();
        if (r10.getTranslateDisplayRule() == 2) goto L30;
        if (r10.getTranslateDisplayRule() != 3) goto L25;
    L30:
        r4 = r10.getTranslateDisplayRule();
        r2 = r10.getTranslateLanguage();
        r6 = r10.isTranslatedManually();
        r5 = true;
    L32:
        if (r0.isFromPrivateTopic() == true) goto L36;
        if (r5 == false) goto L35;
        r8 = 2;
    L35:
        r13.setTranslateDisplayRule(r8);
    L37:
        r13.setTranslateLanguage(r2);
        if (r5 == true) goto L40;
    L42:
        r13.setTranslatedManually(r6);
        return;
    L40:
        if (r2.isEmpty() == false) goto L42;
        r13.setTranslateLanguage("zh");
        goto L42
    L36:
        r13.setTranslateDisplayRule(r4);
        goto L37
    }

    public static boolean c(Message r3) {
        if (r3.getType() != Message.Type.MERGE_FORWARD) goto L5;
    L11:
        boolean r4 = false;
    L13:
        return !r4;
    L5:
        if (r3.getType() == Message.Type.TEXT) goto L9;
        if (r3.getType() == Message.Type.POST) goto L9;
    L10:
        r4 = true;
    L9:
        if (TextUtils.equals(r3.getMessageLanguage(), "not_lang") == false) goto L11;
        goto L10
    }

    public static fcb.a f(nyb.b r9, PushTranslateState r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        fcb.a r0 = new fcb.a();
        HashMap r1 = new HashMap();
        HashMap r2 = new HashMap();
        Entity r3 = r10.entities;
        Iterator r4 = r10.message_id.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        String r5 = (String) r4.next();
        TranslateState r6 = new TranslateState(r5);
        r9.getClass();
        Message r7 = ModelParserMessage.c(r3, r5);
        if (r7 == null) goto L11;
        r6.setMessage(r7);
        r6.setTranslateInfo(e(r7, r3, false));
    L11:
        r1.put(r5, r6);
        goto L7
    L12:
        r0.d = r1;
        Iterator r11 = r10.translate_errors.iterator();
    L14:
        if (r11.hasNext() == false) goto L24;
        TranslateError r8 = (TranslateError) r11.next();
        MessageSource r12 = r8.message_source;
        if (r12.source_type != MessageSourceType.MERGE_FORWARD_MESSAGE) goto L23;
        if (TextUtils.isEmpty(r12.source_id) == true) goto L23;
        TranslateState r13 = new TranslateState(r8.message_source.source_id);
        r13.setErrorCode(r8.error_code.intValue());
        r13.setError(r8.error_msg);
        MessageSource.Builder r14 = new MessageSource.Builder().source_type(MessageSourceType.COMMON_MESSAGE).source_id("");
        MessageSource r15 = r8.message_source;
        if (r15 == null) goto L22;
        r14.message_id_path(r15.message_id_path);
    L22:
        r13.setMessageSource(r14.build());
        r2.put(r13.getMessageId(), r13);
    L23:
        TranslateState r16 = new TranslateState(r8.message_id);
        r16.setErrorCode(r8.error_code.intValue());
        r16.setError(r8.error_msg);
        r16.setMessageSource(r8.message_source);
        r2.put(r16.getMessageId(), r16);
        goto L14
    L24:
        r0.e = r2;
        r10.is_user_manual_translate.booleanValue();
        Boolean r17 = r10.is_from_message_update;
        if (r17 == null) goto L27;
        r17.booleanValue();
    L27:
        return r0;
    }

    public static TranslateInfo e(Message r16, Entity r17, boolean r18) {
        String r1 = r16.getId();
        boolean r2 = ImSdkProxy.c().isFeatureGatingEnable("ai.translate.message.audio");
        if (r16.getType() != Message.Type.TEXT) goto L5;
    L74:
        com.bytedance.lark.pb.basic.v1.TranslateInfo r3 = (com.bytedance.lark.pb.basic.v1.TranslateInfo) r17.translate_messages.get(r1);
        if (r3 != null) goto L77;
    L78:
        return null;
    L77:
        return new TranslateInfo(r3.message_id, r3.language, ModelParserMessage.e(r17, r16, r3.content, r3), r3.message_content_version.intValue());
    L5:
        if (r16.getType() == Message.Type.POST) goto L74;
        if (r16.getType() == Message.Type.IMAGE) goto L74;
        if (r16.getType() != Message.Type.AUDIO) goto L12;
        if (r2 == true) goto L74;
    L12:
        if (vab.a.a == true) goto L15;
    L32:
        boolean r4 = false;
    L33:
        if (r4 == true) goto L74;
        if (r16.getType() != Message.Type.MERGE_FORWARD) goto L78;
        SubTranslateInfo r5 = (SubTranslateInfo) r17.merge_forward_translate_messages.get(r1);
        MergeForwardContent r6 = r16.getContent();
        if (r5 != null) goto L40;
    L73:
        return null;
    L40:
        if (r6.getMessages() == null) goto L73;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.message.threadforward_supports_translation") == false) goto L45;
        b(r16);
    L46:
        MergeForwardContent r7 = r6.clone();
        ArrayList r8 = new ArrayList();
        TranslateInfo r9 = new TranslateInfo(r1, r16.getTranslateLanguage(), r7);
        HashMap r10 = new HashMap();
        Iterator r11 = r7.getMessages().iterator();
    L48:
        if (r11.hasNext() == false) goto L71;
        Message r12 = (Message) r11.next();
        String r13 = r12.getId();
        Message r14 = r12.clone();
        if (r14 == null) goto L48;
        com.bytedance.lark.pb.basic.v1.TranslateInfo r15 = (com.bytedance.lark.pb.basic.v1.TranslateInfo) r5.sub_translate_messages.get(r13);
        HashMap r19 = new HashMap();
        Iterator r110 = r5.sub_mf_translate_messages.iterator();
    L54:
        if (r110.hasNext() == false) goto L56;
        SubTranslateInfo.SubMfTranslateInfo r111 = (SubTranslateInfo.SubMfTranslateInfo) r110.next();
        r19.put(r111.sub_message_id, r111.sub_translate_messages);
        goto L54
    L56:
        SubTranslateInfo r20 = (SubTranslateInfo) r19.get(r13);
        if (r15 != null) goto L58;
        if (r20 != null) goto L61;
    L68:
        if (r18 == false) goto L48;
        r14.setTranslateDisplayRule(1);
        r8.add(r14);
        goto L48
    L61:
        if (r12.getType() != Message.Type.MERGE_FORWARD) goto L68;
        a r112 = new a();
        d(r112, r12, r20, 2);
        if (r112.a == null) goto L65;
        TranslateInfo r21 = new TranslateInfo(r13, r14.getTranslateLanguage(), r112.a.getContent());
        r10.put(r13, r21);
        r21.setSubTranslateInfoMap(r112.b);
    L65:
        Message r22 = r112.a;
        if (r22 == null) goto L48;
        r8.add(r22);
        goto L48
    L58:
        r14.setMessageContent(ModelParserMessage.e(r17, r14, r15.content, r15));
        r8.add(r14);
        goto L48
    L71:
        r7.setMessages(r8);
        r7.setTranslated(true);
        r9.setSubTranslateInfoMap(r10);
        return r9;
    L45:
        a(r16);
        goto L46
    L15:
        if (r16.getType() != Message.Type.CARD) goto L32;
        boolean r23 = vab.a.b;
        if ((r16.getContent() instanceof CardContent) == false) goto L32;
        CardContent r24 = r16.getContent();
        if (r24.getExtraInfo() != null) goto L22;
    L23:
        if (r23 == false) goto L32;
    L26:
        if (r24.getType() != CardContent.Type.TEXT) goto L32;
        if (r24.getCardVersion() < 2) goto L32;
        r4 = true;
        goto L33
    L22:
        if (r24.getExtraInfo().getEnableTranslate() == true) goto L26;
        goto L23
    }

    public static void d(a r16, Message r17, SubTranslateInfo r18, int r19) {
        if (r19 <= 3) goto L5;
        return;
    L5:
        MergeForwardContent r4 = r17.getContent().clone();
        if (r4.getMessages() != null) goto L8;
        return;
    L8:
        ArrayList r5 = new ArrayList();
        HashMap<String, TranslateInfo> r6 = new HashMap();
        a r7 = new a();
        Iterator r8 = r4.getMessages().iterator();
    L10:
        if (r8.hasNext() == false) goto L31;
        Message r9 = (Message) r8.next();
        String r11 = r9.getId();
        Message r12 = r9.clone();
        com.bytedance.lark.pb.basic.v1.TranslateInfo r13 = (com.bytedance.lark.pb.basic.v1.TranslateInfo) r18.sub_translate_messages.get(r11);
        TranslateInfo r14 = null;
        if (r13 == null) goto L14;
        Content r15 = ModelParserMessage.e(null, r12, r13.content, r13);
        r12.setMessageContent(r15);
        r5.add(r12);
        TranslateInfo r110 = new TranslateInfo(r13.message_id, r13.language, r15, r13.message_content_version.intValue());
        r6.put(r11, r110);
        r14 = r110;
    L14:
        HashMap r10 = new HashMap();
        Iterator r111 = r18.sub_mf_translate_messages.iterator();
    L16:
        if (r111.hasNext() == false) goto L18;
        SubTranslateInfo.SubMfTranslateInfo r112 = (SubTranslateInfo.SubMfTranslateInfo) r111.next();
        r10.put(r112.sub_message_id, r112.sub_translate_messages);
        goto L16
    L18:
        SubTranslateInfo r113 = (SubTranslateInfo) r10.get(r11);
        if (r113 == null) goto L10;
        if (r9.getType() != Message.Type.MERGE_FORWARD) goto L10;
        d(r7, r9, r113, 1 + r19);
        if (r7.a == null) goto L27;
        if (r14 != null) goto L26;
        TranslateInfo r114 = new TranslateInfo(r11, r9.getTranslateLanguage(), r7.a.getContent());
        r6.put(r11, r114);
        r14 = r114;
    L26:
        r5.add(r7.a);
    L27:
        HashMap<String, TranslateInfo> r20 = r7.b;
        if (r20 == null) goto L10;
        if (r14 == null) goto L10;
        r14.setSubTranslateInfoMap(r20);
        goto L10
    L31:
        r4.setMessages(r5);
        r4.setTranslated(true);
        r17.setMessageContent(r4);
        r16.a = r17;
        r16.b = r6;
    }
}
