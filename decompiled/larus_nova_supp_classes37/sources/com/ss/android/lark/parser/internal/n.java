package com.ss.android.lark.parser.internal;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.lark.pb.basic.v1.CloudDraftContent;
import com.bytedance.lark.pb.basic.v1.Draft;
import com.bytedance.lark.pb.basic.v1.DraftAttachmentSnapshot;
import com.bytedance.lark.pb.basic.v1.ScheduleMessageItem;
import com.ss.android.lark.dto.draft.ScheduleDraftInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Draft.Type.values().length];
            a = r0;
            r0[Draft.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[Draft.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[Draft.Type.INDIVIDUAL_TOPIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[Draft.Type.EDIT_MESSAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[Draft.Type.MSG_THREAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[Draft.Type.SCHEDULE_MESSAGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static boolean a(String r6) {
        if (r6 == null) goto L19;
        int r1 = r6.length();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        int r4 = r6.codePointAt(r2);
        if (Character.isWhitespace(r4) == false) goto L9;
        r2 = r2 + Character.charCount(r4);
        goto L6
    L9:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
        return false;
    L14:
        if (TextUtils.equals(r6, UserInfo.NONE_NAME_CARD_ID) == true) goto L21;
        return true;
    L21:
        return false;
    L11:
        r3 = true;
        goto L12
    L19:
        return false;
    }

    public static Map<String, com.ss.android.lark.dto.draft.Draft> c(Map<String, Draft> r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r5 == null) goto L10;
        Iterator<String> r1 = r5.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r2 = r1.next();
        com.ss.android.lark.dto.draft.Draft r3 = b(r5.get(r2), Boolean.FALSE);
        if (r3 == null) goto L6;
        r0.put(r2, r3);
    L10:
        return r0;
    }

    public static com.ss.android.lark.dto.draft.Draft b(Draft r12, Boolean r13) {
        if (r12 != null) goto L6;
        Log.e("ModelParserDraft", "parseDraftFromPb failed: pbDraft is null");
        return null;
    L6:
        com.ss.android.lark.dto.draft.Draft r2 = new com.ss.android.lark.dto.draft.Draft();
        r2.id = r12.id;
        r2.chatId = r12.chat_id;
        r2.messageId = r12.message_id;
        r2.threadId = r12.thread_id;
        r2.partialReplyInfo = ModelParserMessage.i(r12.partial_reply_info);
        DraftAttachmentSnapshot r3 = r12.attachment_snapshot;
        r2.attachmentSnapshot = r3;
        int r4 = 1;
        if (r3 == null) goto L13;
        List r5 = r3.attachments;
        if (r5 == null) goto L13;
        if (r5.isEmpty() == true) goto L13;
        boolean r6 = true;
    L14:
        String r7 = "";
        if (r12.schedule_info == null) goto L27;
        ScheduleDraftInfo r8 = new ScheduleDraftInfo();
        r8.setScheduleSendTime(r12.schedule_info.schedule_time.longValue());
        ScheduleMessageItem r9 = r12.schedule_info.item;
        if (r9 == null) goto L19;
        String r10 = r9.item_id;
    L20:
        r8.setScheduleMessageId(r10);
        ScheduleMessageItem r11 = r12.schedule_info.item;
        if (r11 != null) goto L23;
    L25:
        boolean r14 = false;
    L26:
        r8.setPreScheduleMessage(r14);
        r2.scheduleDraftInfo = r8;
        goto L27
    L23:
        if (r11.item_type != ScheduleMessageItem.ItemType.QUASI_SCHEDULE_MESSAGE) goto L25;
        r14 = true;
        goto L26
    L19:
        r10 = "";
    L27:
        String r15 = r12.content;
        if (r15 == null) goto L42;
        int r16 = r15.length();
        int r17 = 0;
    L30:
        if (r17 >= r16) goto L35;
        int r18 = r15.codePointAt(r17);
        if (Character.isWhitespace(r18) == false) goto L33;
        r17 = r17 + Character.charCount(r18);
        goto L30
    L33:
        boolean r19 = false;
    L36:
        if (r19 == true) goto L42;
        com.ss.android.lark.dto.draft.Draft r110 = (com.ss.android.lark.dto.draft.Draft) JSON.parseObject(r12.content, com.ss.android.lark.dto.draft.Draft.class);     // Catch: Exception -> L39
        r2.title = r110.title;     // Catch: Exception -> L39
        r2.reEditMessageId = r110.reEditMessageId;     // Catch: Exception -> L39
        r2.contentRichText = r110.contentRichText;     // Catch: Exception -> L39
        r2.postRichText = r110.postRichText;     // Catch: Exception -> L39
        r2.createTime = r110.createTime;     // Catch: Exception -> L39
        r2.type = r110.type;     // Catch: Exception -> L39
        r2.topicGroupId = r110.topicGroupId;     // Catch: Exception -> L39
        r2.queryStatusInfo = r110.queryStatusInfo;     // Catch: Exception -> L39
        return r2;
    L39:
        e = move-exception;
        Log.e("ModelParserDraft", "parseDraftFromPb failed, exception = " + e.getMessage());
        e.printStackTrace();
        return null;
    L35:
        r19 = true;
    L42:
        CloudDraftContent r0 = r12.cloud_draft_content;
        if (r0 != null) goto L45;
        com.ss.android.lark.dto.draft.CloudDraftContent r20 = null;
    L46:
        if (r20 != null) goto L55;
        if (r6 == false) goto L49;
    L51:
        r2.title = "";
        r2.contentRichText = com.ss.android.lark.widget.richtext.c.a();
        r2.postRichText = com.ss.android.lark.widget.richtext.c.a();
        if (r6 == true) goto L63;
        r2.isNeedDelete = Boolean.TRUE;
    L63:
        String r111 = r12.chat_id;
        if (r111 != null) goto L67;
        r111 = "";
    L67:
        String r1 = r12.message_id;
        if (r1 == null) goto L71;
        r7 = r1;
    L71:
        switch(a.a[r12.type.ordinal()]) {
            case 1: goto L84;
            case 2: goto L78;
            case 3: goto L76;
            case 4: goto L75;
            case 5: goto L74;
            case 6: goto L73;
            default: goto L72;
        };
    L72:
        r4 = 0;
    L89:
        r2.type = r4;
        r2.createTime = 0;
        r2.topicGroupId = r2.chatId;
        r2.isReloadUrl = Boolean.TRUE;
        return r2;
    L73:
        r4 = 7;
        goto L89
    L74:
        r4 = 5;
        goto L89
    L75:
        r4 = 6;
        goto L89
    L76:
        r4 = 4;
        goto L89
    L78:
        if (a(r111) == true) goto L80;
    L82:
        r4 = 3;
        goto L89
    L80:
        if (a(r7) == true) goto L82;
    L84:
        if (a(r111) == true) goto L86;
    L88:
        r4 = 2;
        goto L89
    L86:
        if (a(r7) == true) goto L88;
    L49:
        if (r13.booleanValue() == true) goto L51;
        return null;
    L55:
        if (r20.getTitle() != null) goto L57;
        String r112 = "";
    L58:
        r2.title = r112;
        r2.contentRichText = com.ss.android.lark.widget.richtext.c.a();
        if (r20.getContent() != null) goto L61;
        RichText r113 = com.ss.android.lark.widget.richtext.c.a();
    L62:
        r2.postRichText = r113;
        goto L63
    L61:
        r113 = r20.getContent();
        goto L62
    L57:
        r112 = r20.getTitle();
        goto L58
    L45:
        r20 = new com.ss.android.lark.dto.draft.CloudDraftContent(r0.title, g0.e(r0.rich_text, null));
    L13:
        r6 = false;
        goto L14
    }
}
