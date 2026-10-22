package com.ss.android.lark.parser.internal;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.api.service.impl.PreviewService;
import com.ss.android.lark.chat.api.service.request.PullUrlPreviewRequest;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MyAIThreadInfo;
import com.ss.android.lark.chat.entity.message.Pin;
import com.ss.android.lark.chat.entity.message.SmartReplyEntryInfo;
import com.ss.android.lark.chat.entity.message.content.ProfileContent;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.ding.entity.DingStatus;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static ChatChatter g(Message r2, com.ss.android.lark.chat.entity.chatter.a r3) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.getOriginalSenderId() != null) goto L6;
        return null;
    L6:
        if (r2.getOriginalSenderId().isEmpty() == false) goto L8;
        return null;
    L8:
        if (r2.getOriginalSenderId().equals(r2.getFromId()) == false) goto L10;
        return null;
    L10:
        return r3.b(r2.getChatId(), r2.getOriginalSenderId());
    }

    public static void i(Message r2, com.ss.android.lark.chat.entity.chatter.a r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getType() != Message.Type.SHARE_USER_CARD) goto L21;
        String r0 = r2.getChatId();
        ProfileContent r4 = r2.getContent();
        if (r4 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r4.getId()) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r4.getDisplayName()) == false) goto L22;
        ChatChatter r5 = r3.b(r0, r4.getId());
        if (r5 == null) goto L20;
        r4.setAvatarKey(r5.getAvatarKey());
        r4.setDisplayName(r5.getLocalizedName());
        r4.setChatterType(r5.getType());
        r4.setTenantId(r5.getTenantId());
        return;
    L20:
        return;
    L22:
        return;
    }

    public static void j(Message r4, com.ss.android.lark.chat.entity.chatter.a r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.getType() != Message.Type.SYSTEM) goto L33;
        SystemContent r0 = r4.getContent();
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.getType() != SystemMessageType.USER_CHECK_OTHERS_TELEPHONE) goto L11;
    L17:
        String r1 = r0.getFromChatterId();
        String r2 = r0.getToChatterId();
        if (TextUtils.isEmpty(r2) == false) goto L20;
        return;
    L20:
        if (TextUtils.isEmpty(r1) == true) goto L35;
        String r6 = r4.getChatId();
        ChatChatter r3 = r5.b(r6, r1);
        if (r3 == null) goto L25;
        r0.setFromChatter(r3);
    L25:
        ChatChatter r7 = r5.b(r6, r2);
        if (r7 == null) goto L32;
        r0.setToChatter(r7);
        return;
    L32:
        return;
    L35:
        return;
    L11:
        if (r0.getType() == SystemMessageType.SystemContent_CHECK_USER_PHONE_NUMBER) goto L17;
        if (r0.isVoIPSystemMessage() == true) goto L17;
        if (r0.isVCSystemMessage() == true) goto L17;
        return;
    }

    public static void a(Message r16, Entity r17, MessageInfo r18) {
        if (r16 == null) goto L50;
        if (r17 == null) goto L51;
        String r1 = r16.getThreadId();
        if (r1 != null) goto L9;
        return;
    L9:
        if (Message.ThreadMessageType.THREAD_ROOT_MESSAGE == r16.getThreadMessageType()) goto L11;
        return;
    L11:
        long r2 = r16.getAiChatModeId();
        if (r2 != 0) goto L14;
        return;
    L14:
        String r4 = r16.getId();
        int r5 = u.a;
        Intrinsics.checkNotNullParameter(r17, "entity");
        Intrinsics.checkNotNullParameter(r4, "messageId");
        Intrinsics.checkNotNullParameter(r1, "threadId");
        Thread r3 = (Thread) r17.threads.get(r1);
        int r6 = 0;
        if (r3 != null) goto L17;
        Log.w("ModelParserMyAIThreadInfo", "messageId:" + r4 + ",pbThread == null");
        UrlInlinePreviewEntity r0 = new UrlInlinePreviewEntity.Builder().build();
    L44:
        if (r3 == null) goto L48;
        Integer r7 = r3.last_message_position;
        if (r7 == null) goto L48;
        r6 = r7.intValue();
    L48:
        r18.setMyAIThreadInfo(new MyAIThreadInfo(r0, r6));
        return;
    L17:
        PreviewHangPoint r8 = r3.ai_chat_mode_url_preview_hang_point;
        if (r8 != null) goto L20;
        Log.w("ModelParserMyAIThreadInfo", "messageId:" + r4 + ",pbHandPoint == null");
        r0 = new UrlInlinePreviewEntity.Builder().build();
        goto L44
    L20:
        String r13 = r8.url;
        StringBuilder r9 = new StringBuilder("messageId:");
        r9.append(r4);
        r9.append(",aiChatModeId:");
        r9.append(r2);
        r9.append(",isUrlEmpty:");
        if (r13 != null) goto L23;
    L26:
        boolean r10 = true;
    L27:
        r9.append(r10);
        Log.i("ModelParserMyAIThreadInfo", r9.toString());
        Map r11 = r17.preview_entities;
        int r12 = w.a;
        Intrinsics.checkNotNullParameter(r4, "messageId");
        Intrinsics.checkNotNullParameter(r8, "pbHandPoint");
        PullUrlPreviewRequest.a r14 = new PullUrlPreviewRequest.a();
        Boolean r15 = r8.is_lazy_load;
        if (r15 == null) goto L30;
        boolean r19 = r15.booleanValue();
    L31:
        UrlPreviewHangPoint r20 = new UrlPreviewHangPoint.Builder().preview_id(r8.preview_id).url(r8.url).need_local_preview(r8.need_local_preview).is_lazy_load(r8.is_lazy_load).build();
        Intrinsics.checkNotNull(r20);
        UrlCardPreviewEntity r21 = w.b(r4, r11, r20, r19, r14);
        if (r14.a.isEmpty() == true) goto L35;
        ((PreviewService) PreviewService.c.getValue()).Fa(new PullUrlPreviewRequest(r14.a));
    L35:
        String r22 = r8.url;
        String r110 = r8.preview_id;
        Boolean r23 = r8.need_local_preview;
        if (r23 == null) goto L38;
        boolean r111 = r23.booleanValue();
    L39:
        UrlCardPreviewEntity r24 = new com.ss.android.lark.export.entity.PreviewHangPoint(r22, null, r4, r110, r111, r19, r21).getUrlCardPreviewEntity();
        if (r24 != null) goto L42;
        Log.w("ModelParserMyAIThreadInfo", "messageId:" + r4 + ",previewEntity == null");
        r0 = new UrlInlinePreviewEntity.Builder().url(new Url(r13, null, null, null, null)).build();
        goto L44
    L42:
        r0 = r24.getInlineEntity();
        goto L44
    L38:
        r111 = false;
        goto L39
    L30:
        r19 = false;
        goto L31
    L23:
        if (r13.length() == 0) goto L26;
        r10 = false;
        goto L27
    L51:
        return;
    }

    public static List<ReactionInfo> e(com.ss.android.lark.chat.entity.chatter.a r6, String r7, List<Reaction> r8) {
        if (CollectionUtils.isEmpty(r8) == true) goto L14;
        ArrayList r0 = new ArrayList();
        Iterator r9 = ((ArrayList) r8).iterator();
    L6:
        if (r9.hasNext() == false) goto L22;
        Reaction r1 = (Reaction) r9.next();
        List r2 = r1.getChatterIds();
        HashMap r3 = new HashMap();
        Iterator r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        String r5 = (String) r4.next();
        ChatChatter r10 = r6.b(r7, r5);
        if (r10 == null) goto L9;
        r3.put(r5, r10);
        goto L9
    L13:
        r0.add(new ReactionInfo(r1, r3));
        goto L6
    L22:
        return r0;
    L14:
        return null;
    }

    public static Pin h(com.bytedance.lark.pb.basic.v1.Message.Pin r9, String r10, com.ss.android.lark.chat.entity.chatter.a r11) {
        if (r9 == null) goto L10;
        ChatChatter r12 = r11.b(r10, r9.operator_id);
        if (r12 == null) goto L7;
        String r13 = r12.getNickName();
        r12.setNickName("");
        String r6 = com.ss.android.lark.chat.utils.m.b(r12, ChatterNameDisplayRule.NAME, false);
        r12.setNickName(r13);
        return new Pin(r9.id, r12.getId(), com.ss.android.lark.chat.utils.m.b(r12, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true), r6, r9.timestamp.longValue());
    L7:
        Log.e("parsePinFromPb chatChatter == null ,chatId=" + r10 + " ; chatterId=" + r9.operator_id);
        return null;
    L10:
        return null;
    }

    public static void m(com.bytedance.lark.pb.basic.v1.Message r6, f5b.b r7, com.ss.android.lark.chat.entity.chatter.a r8) {
        if (r6.is_urgent.booleanValue() == false) goto L14;
        DingStatus r0 = new DingStatus();
        r0.setMessageId(r7.getMessage().getId());
        if (r7.getMessage().isFromMe() == false) goto L11;
        LinkedHashSet r1 = new LinkedHashSet();
        r0.setConfirmedChatterIds(r6.ack_urgent_chatter_ids);
        r0.setUnconfirmedChatterIds(r6.unack_urgent_chatter_ids);
        r1.addAll(r6.unack_urgent_chatter_ids);
        r1.addAll(r6.ack_urgent_chatter_ids);
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        String r3 = (String) r2.next();
        r9.put(r3, com.ss.android.lark.chat.utils.m.b(r8.b(r7.getMessage().getChatId(), r3), ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, false));
        goto L8
    L10:
        r0.setChatterNameMap(r9);
    L11:
        r7.setDingStatus(r0);
        return;
    }

    public static MessageFoldDetail d(com.bytedance.lark.pb.basic.v1.MessageFoldDetail r5, Message r6, com.ss.android.lark.chat.entity.chatter.a r7, Chat r8) {
        if (r5 == null) goto L20;
        if (r8 == null) goto L20;
        ArrayList r0 = new ArrayList(r5.user_counts.size());
        Iterator r1 = r5.user_counts.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        com.bytedance.lark.pb.basic.v1.MessageFoldDetail.FoldUserCount r2 = (com.bytedance.lark.pb.basic.v1.MessageFoldDetail.FoldUserCount) r1.next();
        ChatChatter r3 = r7.b(r6.getChatId(), String.valueOf(r2.user_id));
        if (r3 == null) goto L10;
        r0.add(new MessageFoldDetail.b(r3, r2.count.intValue()));
        goto L7
    L10:
        Log.w("getFoldDetail: find foldUser is null , drop this FoldUserCount");
        goto L7
    L12:
        ChatChatter r9 = r7.b(r6.getChatId(), String.valueOf(r5.recall_user_id));
        Log.i("getFoldDetail: foldMessage.recallType: " + r5.recall_type + " ; recall chatter id is " + r5.recall_user_id);
        MessageFoldDetail.Builder r10 = MessageFoldDetail.newBuilder().message(r6).foldId(String.valueOf(r5.fold_id)).rootMessageId(String.valueOf(r5.root_message_id)).rootMessagePosition((long) r5.root_message_position.intValue()).lastMessageId(String.valueOf(r5.last_message_id)).lastMessagePos((long) r5.last_message_position.intValue()).lastMessageBadgeCount((long) r5.last_message_badge_count.intValue()).userLength(r5.user_len.intValue()).totalCount(r5.total_count.intValue()).updateTimeMs(r5.update_time_ms.longValue()).userCounts(r0).recallChatter(r9).recallType(MessageFoldDetail.RecallType.fromValue(r5.recall_type.getValue()));
        if (r5.last_message_position.intValue() >= r8.last_message_position.intValue()) goto L15;
    L17:
        boolean r11 = false;
    L19:
        return r10.enableFollow(r11).build();
    L15:
        if (r8.allow_post.booleanValue() == false) goto L17;
        r11 = true;
    L20:
        Log.w("getFoldDetail:foldDetail or chat is null, method return");
        return null;
    }

    public static MessageInfo f(String r3, Message r4, Entity r5, com.ss.android.lark.chat.entity.chatter.a r6) {
        if (r4 != null) goto L6;
        Log.d("parseMessageInfo message not found == " + r3);
        return null;
    L6:
        String r7 = r4.getChatId();
        ChatChatter r1 = r6.b(r7, r4.getFromId());
        if (r1 != null) goto L10;
        Log.d("parseMessageInfo chatter not found == " + r4.getFromId());
        return null;
    L10:
        MessageInfo r0 = new MessageInfo(r4, r1);
        String r2 = r4.getRecallerId();
        if (TextUtils.isEmpty(r2) == true) goto L13;
        r0.setRecallUser(r6.b(r7, r2));
    L13:
        r0.setTranslateInfo(d0.e(r4, r5, true));
        return r0;
    }

    public static void b(Message r3, Entity r4, com.ss.android.lark.chat.entity.chatter.a r5, MessageInfo r6, Map<String, MessageInfo> r7) {
        String r0 = r3.getParentId();
        r3.getChatId();
        if (TextUtils.isEmpty(r0) == true) goto L9;
        if (r7 == null) goto L8;
        HashMap r1 = (HashMap) r7;
        if (r1.containsKey(r0) == false) goto L8;
        r6.setParentMessageInfo((MessageInfo) r1.get(r0));
    L8:
        r6.setParentMessageInfo(f(r0, ModelParserMessage.c(r4, r0), r4, r5));
    L9:
        String r2 = r3.getRootId();
        if (TextUtils.isEmpty(r2) == true) goto L16;
        if (r7 == null) goto L15;
        HashMap r8 = (HashMap) r7;
        if (r8.containsKey(r2) == false) goto L15;
        r6.setRootMessageInfo((MessageInfo) r8.get(r2));
    L15:
        r6.setRootMessageInfo(f(r2, ModelParserMessage.c(r4, r2), r4, r5));
    L16:
        String r9 = Long.toString(r3.getSyncToChatThreadRootId());
        r6.setThreadParentMessageInfo(f(r9, ModelParserMessage.c(r4, r9), r4, r5));
    }

    public static void c(Message r5, Entity r6, MessageInfo r7, com.ss.android.lark.chat.entity.chatter.a r8, Map<String, Message> r9) {
        if (TextUtils.isEmpty(r5.getThreadId()) == false) goto L5;
        return;
    L5:
        Map r0 = r6.threads;
        if (r0 != null) goto L8;
    L45:
        Log.w("ModelParserMessage", "entity.threads is null or empty, message id is " + r5.getId());
        return;
    L8:
        if (r0.isEmpty() == true) goto L45;
        Map r1 = r6.messages;
        if (r1 != null) goto L13;
    L43:
        Log.w("ModelParserMessage", "entity.messages is null or empty, message id is " + r5.getId());
        return;
    L13:
        if (r1.isEmpty() == true) goto L43;
        Thread r2 = (Thread) r6.threads.get(r5.getThreadId());
        if (r2 != null) goto L19;
        Log.w("ModelParserMessage", "Thread from entity.threads is null, message id is " + r5.getId());
        return;
    L19:
        List r10 = r2.last_reply_ids;
        if (r10 != null) goto L22;
    L41:
        Log.w("ModelParserMessage", "Last reply ids is null or empty, thread id is " + r2.id);
        return;
    L22:
        if (r10.isEmpty() == true) goto L41;
        ArrayList r3 = new ArrayList();
        Iterator r11 = r10.iterator();
    L26:
        if (r11.hasNext() == false) goto L39;
        String r4 = (String) r11.next();
        if (((com.bytedance.lark.pb.basic.v1.Message) r6.messages.get(r4)) == null) goto L29;
        if (r9 != null) goto L32;
        Message r12 = null;
    L33:
        if (r12 != null) goto L38;
        r12 = ModelParserMessage.c(r6, r4);
        if (r9 == null) goto L38;
        if (r12 == null) goto L38;
        r9.put(r4, r12);
    L38:
        r3.add(f(r4, r12, r6, r8));
        goto L26
    L32:
        r12 = r9.get(r4);
        goto L33
    L29:
        Log.w("ModelParserMessage", "Reply message not found, id is " + r4);
        goto L26
    L39:
        r7.setLatestRepliesInThread(r3);
    }

    public static MessageInfo k(Message r7, com.bytedance.lark.pb.basic.v1.Message r8, Entity r9, com.ss.android.lark.chat.entity.chatter.a r10, Map<String, MessageInfo> r11) {
        return l(r7, r8, r9, r10, r11, null, true);
    }

    public static MessageInfo l(Message r4, com.bytedance.lark.pb.basic.v1.Message r5, Entity r6, com.ss.android.lark.chat.entity.chatter.a r7, Map<String, MessageInfo> r8, Map<String, Message> r9, boolean r10) {
        ChatChatter r0 = r7.b(r4.getChatId(), r4.getFromId());
        r4.getId();
        String r1 = r4.getChatId();
        MessageInfo r2 = new MessageInfo(r4, r0);
        List<ReactionInfo> r3 = e(r7, r1, x.b(r5.reactions));
        r2.setPin(h(r5.pin, r1, r7));
        r2.setReactionInfoList(r3);
        m(r5, r2, r7);
        String r11 = r4.getRecallerId();
        if (TextUtils.isEmpty(r11) == true) goto L5;
        r2.setRecallUser(r7.b(r4.getChatId(), r11));
    L5:
        r2.setTranslateInfo(d0.e(r4, r6, true));
        j(r4, r7);
        i(r4, r7);
        r2.setOriginalSender(g(r4, r7));
        b(r4, r6, r7, r2, r8);
        Message r12 = r2.getMessage();
        if (Objects.equals(r12.getFoldId(), r12.getId()) == true) goto L8;
    L17:
        b0.b(r4, r6, r2);
        if (r10 == false) goto L20;
        c(r4, r6, r2, r7, r9);
    L20:
        a(r4, r6, r2);
        com.bytedance.lark.pb.basic.v1.Message.AIReplyEntryInfo r13 = r5.ai_reply_entry_info;
        if (r13 == null) goto L24;
        r2.setSmartReplyEntryInfo(new SmartReplyEntryInfo(r13.has_pre_generation.booleanValue(), r13.ai_reply_id, null));
    L24:
        return r2;
    L8:
        if (TextUtils.isEmpty(r12.getFoldId()) == true) goto L17;
        String r14 = r12.getChatId();
        Chat r15 = (Chat) r6.chats.get(r14);
        Long r16 = StringsKt.toLongOrNull(r12.getFoldId());
        if (r16 != null) goto L13;
        Log.w("CommonModelParserMessage", "completeFoldDetailIfNeed: get fold is null");
        goto L17
    L13:
        MessageFoldDetail r17 = d((com.bytedance.lark.pb.basic.v1.MessageFoldDetail) r6.message_fold_details.get(r16), r2.getMessage(), r7, r15);
        if (r17 != null) goto L16;
        r17 = new MessageFoldDetail.Builder().foldId(r12.getFoldId()).build();
    L16:
        r2.setMessageFoldDetail(r17);
        goto L17
    }
}
