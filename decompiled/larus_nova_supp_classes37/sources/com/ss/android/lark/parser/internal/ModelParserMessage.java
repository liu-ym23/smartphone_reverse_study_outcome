package com.ss.android.lark.parser.internal;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.COTContent;
import com.bytedance.lark.pb.basic.v1.COTEvent;
import com.bytedance.lark.pb.basic.v1.COTEventType;
import com.bytedance.lark.pb.basic.v1.COTStatus;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.EditMessageContent;
import com.bytedance.lark.pb.basic.v1.EditingMessageInfo;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.MessageDLPState;
import com.bytedance.lark.pb.basic.v1.MessageFoldDetail;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.lark.pb.basic.v1.MessageLocalData;
import com.bytedance.lark.pb.basic.v1.MessageLocalDataInfoMap;
import com.bytedance.lark.pb.basic.v1.QuasiMessage;
import com.bytedance.lark.pb.basic.v1.SecurityESCReviewExtra;
import com.bytedance.lark.pb.basic.v1.TranslateInfo;
import com.bytedance.lark.pb.basic.v1.TranslateMessageDisplayRule;
import com.bytedance.lark.pb.im.v1.MGetMessagesResponse;
import com.bytedance.lark.pb.office_sdk.basic.DoubaoContent;
import com.bytedance.lark.pb.openplatform.v1.AppInfoItem;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.AIButtonConfig;
import com.ss.android.lark.chat.entity.message.AIButtonStrategy;
import com.ss.android.lark.chat.entity.message.AIButtonType;
import com.ss.android.lark.chat.entity.message.AIInfo;
import com.ss.android.lark.chat.entity.message.AISmartReply;
import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import com.ss.android.lark.chat.entity.message.CotStatus;
import com.ss.android.lark.chat.entity.message.CustomizeAIButtonGroup;
import com.ss.android.lark.chat.entity.message.EnterpriseQAGeneralInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageAnalysisConfig;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageSecurityESCReviewExtra;
import com.ss.android.lark.chat.entity.message.MessageSenderAppInfo;
import com.ss.android.lark.chat.entity.message.MessageSourceDisplayPolicy;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.PreMessageSendingStatus;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ModelParserMessage {
    public static final okb.h a = null;
    public static final okb.e b = null;

    public static class UnknownContent extends Content {
        public UnknownContent() {
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            a = r0;
            r0[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L50:
            a[Message.Type.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L36:
            a[Message.Type.POST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L46:
            a[Message.Type.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L52:
            a[Message.Type.AUDIO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L38:
            a[Message.Type.SHARE_GROUP_CHAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L40:
            a[Message.Type.STICKER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L58:
            a[Message.Type.SYSTEM.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L32:
            a[Message.Type.MEDIA.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L54:
            a[Message.Type.RED_PACKET.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L56:
            a[Message.Type.COMMERCIALIZED_HONGBAO.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L42:
            a[Message.Type.SHARE_USER_CARD.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L48:
            a[Message.Type.FOLDER.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L34:
            a[Message.Type.UNKNOWN.ordinal()] = 14;     // Catch: NoSuchFieldError -> L31
            return;
        }
    }

    static {
        a = ImSdkProxy.e();
        b = (okb.e) ImSdkProxy.f.getValue();
    }

    public static Map<String, Message> h(Entity r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 == null) goto L25;
        Iterator r1 = r4.messages.values().iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        Message r2 = c(r4, ((com.bytedance.lark.pb.basic.v1.Message) r1.next()).id);
        if (r2 == null) goto L6;
        r0.put(r2.getId(), r2);
        if (kkb.a.a(r2) == true) goto L6;
        ImSdkMessageUtils.d(r2);
        goto L6
    L12:
        Map r3 = r4.ephemeral_messages;
        if (r3 == null) goto L25;
        if (r3.size() <= 0) goto L25;
        Iterator r5 = r4.ephemeral_messages.values().iterator();
    L18:
        if (r5.hasNext() == false) goto L25;
        String r6 = ((com.bytedance.lark.pb.basic.v1.Message) r5.next()).id;
        com.bytedance.lark.pb.basic.v1.Message r7 = (com.bytedance.lark.pb.basic.v1.Message) r4.ephemeral_messages.get(r6);
        if (r7 != null) goto L22;
        Message r8 = null;
    L23:
        if (r8 == null) goto L18;
        r0.put(r8.getId(), r8);
        ImSdkMessageUtils.d(r8);
        goto L18
    L22:
        r8 = f(r4, r7);
    L25:
        return r0;
    }

    public static PartialReplyInfo i(com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r2) {
        if (r2 != null) goto L7;
        Log.i("ModelParserMessage", "partialReplyInfoPb is null.");
        return null;
    L7:
        return new PartialReplyInfo(g0.e(r2.content, null), PartialReplyInfo.PartialContentRelativePosition.fromValue(r2.position.getValue()));
    }

    public static Map<String, MessageInfo> j(MGetMessagesResponse r7) throws IOException {
        HashMap r0 = new HashMap();
        HashMap r1 = new HashMap();
        if (r7 == null) goto L13;
        Entity r8 = r7.entity;
        if (r8 == null) goto L13;
        Map r2 = r8.messages;
        if (r2 == null) goto L13;
        r0.putAll(h(r8));
        com.ss.android.lark.chat.entity.chatter.a r3 = b.d(r8, true);
        Iterator r4 = r0.entrySet().iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        Map.Entry r5 = (Map.Entry) r4.next();
        MessageInfo r6 = com.ss.android.lark.parser.internal.a.k((Message) r5.getValue(), (com.bytedance.lark.pb.basic.v1.Message) r2.get(r5.getKey()), r8, r3, null);
        r1.put(r6.getMessage().getId(), r6);
    L13:
        return r1;
    }

    public static List<String> a(Entity r4, Message r5) {
        ArrayList r0 = new ArrayList();
        Message.Type r1 = r5.getType();
        Message.Type r2 = Message.Type.TEXT;
        if (r1 != r2) goto L5;
    L9:
        if (r4 != null) goto L11;
    L36:
        return r0;
    L11:
        if (CollectionUtils.isEmpty(r4.chat_chatters) == true) goto L36;
        String r3 = r5.getChatId();
        Entity.ChatChatter r6 = (Entity.ChatChatter) r4.chat_chatters.get(r3);
        if (r6 != null) goto L17;
        return r0;
    L17:
        if (r5.getType() != r2) goto L20;
        RichText r7 = r5.getContent().getRichText();
    L26:
        if (r7 != null) goto L28;
        return r0;
    L28:
        ArrayList r8 = com.ss.android.lark.widget.richtext.d.f(r7, false);
        Map r9 = r6.chatters;
        Iterator r10 = r8.iterator();
    L30:
        if (r10.hasNext() == false) goto L36;
        String r11 = (String) r10.next();
        if (r9.containsKey(r11) == false) goto L30;
        if (((Chatter) r9.get(r11)).type != Chatter.Type.BOT) goto L30;
        r0.add(r11);
        goto L30
    L20:
        if (r5.getType() != Message.Type.POST) goto L23;
        r7 = r5.getContent().getRichText();
        goto L26
    L23:
        if (r5.getType() != Message.Type.AUDIO) goto L25;
        r7 = r5.getContent().getRecognizedRichText();
        goto L26
    L25:
        r7 = null;
        goto L26
    L5:
        if (r5.getType() == Message.Type.POST) goto L9;
        if (r5.getType() == Message.Type.AUDIO) goto L9;
        return r0;
    }

    public static Message c(Entity r1, String r2) {
        com.bytedance.lark.pb.basic.v1.Message r3 = (com.bytedance.lark.pb.basic.v1.Message) r1.messages.get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return f(r1, r3);
    }

    public static Message d(Entity r6, QuasiMessage r7) {
        Message r0 = new Message();
        r0.setId(r7.id);
        r0.setcId(r7.cid);
        r0.setType(Message.Type.valueOf(r7.type.getValue()));
        r0.setIsFromMe(true);
        r0.setFromId(r7.from_id);
        r0.setFromChatterTenantId(b(r6, r7.chat_id, r7.from_id));
        r0.setCreateTime(r7.create_time.longValue());
        r0.setMessageContent(e(r6, r0, r7.content, null));
        r0.setRootId(r7.root_id);
        r0.setParentId(r7.parent_id);
        r0.setChatId(r7.chat_id);
        r0.setPosition(r7.position.intValue());
        r0.setThreadId(r7.thread_id);
        r0.setThreadPosition(r7.thread_position.intValue());
        r0.setUpdateTime(r7.create_time.longValue());
        r0.setNotified(r7.should_notify.booleanValue());
        r0.setNewTopic(r7.is_new_topic.booleanValue());
        PreMessageSendingStatus r1 = PreMessageSendingStatus.forNumber(r7.status.getValue());
        PreMessageSendingStatus r3 = PreMessageSendingStatus.FAILED;
        if (r1 != r3) goto L6;
        r0.setSendStatus(SendStatus.FAIL);
    L9:
        if (r0.getType() != Message.Type.MEDIA) goto L15;
        if (r1 != r3) goto L13;
        r0.getContent().setFileState(FileState.PAUSE);
        goto L15
    L13:
        if (r1 != PreMessageSendingStatus.PENDING) goto L15;
        r0.getContent().setFileState(FileState.COMPRESSING);
    L15:
        r0.setCryptoToken(r7.crypto_token);
        r0.setChannel(g.a(r7.channel));
        r0.setAtBotIds(a(r6, r0));
        MessageDLPState r8 = r7.dlp_state;
        if (r8 == null) goto L18;
        r0.setDlpState(com.ss.android.lark.chat.entity.message.MessageDLPState.fromValue(r8.getValue()));
    L19:
        SecurityESCReviewExtra r9 = r7.security_extra;
        if (r9 == null) goto L22;
        r0.setSecurityESCReviewExtra(new MessageSecurityESCReviewExtra(r9.tip_text, r9.submit_text, r9.feed_back_url));
    L22:
        com.bytedance.lark.pb.basic.v1.Message.ChatDisplayModeSetting r10 = r7.in_chat_display_mode;
        if (r10 == null) goto L25;
        ChatDisplayModeSetting.a r2 = ChatDisplayModeSetting.Companion;
        int r11 = r10.getValue();
        r2.getClass();
        r0.setChatDisplayModeSetting(ChatDisplayModeSetting.a.a(r11));
    L25:
        Long r12 = r7.sync_to_chat_thread_root_id;
        if (r12 == null) goto L28;
        r0.setSyncToChatThreadRootId(r12.longValue());
    L28:
        com.bytedance.lark.pb.basic.v1.Message.SyncToChatMessageType r13 = r7.sync_to_chat_message_type;
        if (r13 == null) goto L31;
        r0.setSyncToChatMessageType(Message.SyncToChatMessageType.fromValue(r13.getValue()));
    L31:
        r0.setPartialReplyInfo(i(r7.partial_reply_info));
        return r0;
    L18:
        r0.setDlpState(null);
        goto L19
    L6:
        if (r1 != PreMessageSendingStatus.PENDING) goto L9;
        r0.setSendStatus(SendStatus.SENDING);
        goto L9
    }

    public static Message f(Entity r32, com.bytedance.lark.pb.basic.v1.Message r33) {
        Message r10 = new Message();
        r10.setId(r33.id);
        r10.setType(Message.Type.valueOf(r33.type.getValue()));
        r10.setFromId(r33.from_id);
        r10.setFromChatterTenantId(b(r32, r33.chat_id, r33.from_id));
        r10.setAiMessageType(r33.ai_message_type);
        if (r33.from_id.equals(a.getCurrentUserId()) == true) goto L12;
        com.bytedance.lark.pb.basic.v1.Message.AnonymousInfo r0 = r33.anonymous_info;
        if (r0 != null) goto L7;
    L11:
        boolean r1 = false;
    L13:
        r10.setIsFromMe(r1);
        r10.setCreateTime(r33.create_time.longValue());
        r10.setCreateTimeInMills(r33.create_time_ms.longValue());
        r10.setChatId(r33.chat_id);
        r10.setImageTranslationAbility(r33.image_translation_ability);
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction r2 = r33.disabled_action;
        if (r2 == null) goto L16;
        r10.setDisabledAction(r2.actions);
    L16:
        r10.setMessageContent(e(r32, r10, r33.content, null));
        if (r32 == null) goto L58;
        int r3 = s.a;
        Intrinsics.checkNotNullParameter(r32, "entity");
        Intrinsics.checkNotNullParameter(r33, "pbMessage");
        Intrinsics.checkNotNullParameter(r10, "message");
        if (r10.getMessageType() != MessageType.DOUBAO) goto L58;
        com.bytedance.lark.pb.basic.v1.Content r4 = r33.content;
        if (r4 == null) goto L55;
        DoubaoContent r5 = r4.doubao_content;
        if (r5 == null) goto L55;
        Long r6 = r5.doubao_msg_id;
        if (r6 == null) goto L55;
        long r24 = r6.longValue();
        Long r7 = r5.query_msg_id;
        if (r7 == null) goto L55;
        long r26 = r7.longValue();
        Long r8 = r5.query_msg_owner_id;
        if (r8 == null) goto L55;
        long r28 = r8.longValue();
        if (r26 == 0) goto L55;
        String r9 = r33.thread_id;
        if (r9 != null) goto L38;
    L41:
        boolean r11 = true;
    L42:
        if (r11 == false) goto L44;
    L54:
        g5b.a r12 = new g5b.a(r24, r26, r28, null);
    L56:
        if (r12 == null) goto L58;
        r10.putExtra(g5b.a.class, r12);
        goto L58
    L44:
        if (Intrinsics.areEqual(r33.thread_id, UserInfo.NONE_NAME_CARD_ID) == true) goto L54;
        Message r13 = c(r32, String.valueOf(r26));     // Catch: Exception -> L51
        if (r13 != null) goto L50;
        r12 = new g5b.a(r24, r26, r28, null);     // Catch: Exception -> L51
        goto L56
    L50:
        MessageInfo r23 = com.ss.android.lark.parser.internal.a.l(r13, (com.bytedance.lark.pb.basic.v1.Message) r32.messages.get(String.valueOf(r26)), r32, b.d(r32, true), null, null, false);     // Catch: Exception -> L51
    L53:
        r12 = new g5b.a(r24, r26, r28, r23);
    L51:
        e = move-exception;
        Log.e("parse thread query message error", e);
        r23 = null;
        goto L53
    L38:
        if (r9.length() == 0) goto L41;
        r11 = false;
    L55:
        r12 = null;
    L58:
        r10.setIncludeDocUrl(r33.is_include_doc_url.booleanValue());
        MessageEditInfo r14 = new MessageEditInfo();
        long r15 = StringsKt.toLongOrNull(r33.id);
        if (r15 != null) goto L61;
        r15 = 0L;
    L61:
        r14.setCurrentEditVersion(r33.edit_version.intValue());
        r14.setLastEditTime(r33.edit_time_ms.longValue());
        r14.setEditDraftId(r33.edit_draft_id);
        if (r32 == null) goto L70;
        EditingMessageInfo r16 = (EditingMessageInfo) r32.editing_message_infos.get(r15);
        if (r16 == null) goto L70;
        Log.i("ModelParserMessage", "parseMessageEditInfo: message has editinfo , id: " + r15);
        r14.setMsgType(Message.Type.forNumber(r14.getMsgType().getNumber()));
        r14.setEditStatus(MessageEditInfo.EditStatus.fromValue(r16.request_status.getValue()));
        r14.setBaseEditVersion(r16.base_edit_version.intValue());
        EditMessageContent r17 = r16.content;
        if (r17 == null) goto L70;
        r14.setTitle(r17.title);
        r14.setRichText(g0.e(r17.rich_text, null));
    L70:
        r10.setEditInfo(r14);
        LinkedHashMap r18 = new LinkedHashMap();
        if (r32 == null) goto L74;
        r18.putAll(r32.message_links);
        r10.setMessageLinkMap(r18);
    L74:
        if (r33.fold_id.longValue() <= 0) goto L76;
        r10.setFoldId(String.valueOf(r33.fold_id));
    L76:
        r10.setCleaned(r33.is_cleaned.booleanValue());
        TextContent r19 = r10.getContent();
        if (r19 != null) goto L416;
        StringBuilder r20 = new StringBuilder("error when decoding message pb, msgId: ");
        r20.append(r10.getId());
        r20.append(", type: ");
        r20.append(r10.getType());
        r20.append(",isSecret: ");
        if (r10.getBurnLife() <= 0) goto L81;
        boolean r21 = true;
    L82:
        r20.append(r21);
        Log.e("ModelParserMessage", r20.toString());
        goto L416
    L81:
        r21 = false;
    L416:
    L91:
        e = move-exception;
        e.printStackTrace();
    L93:
        boolean r22 = r33.is_deleted.booleanValue();
        boolean r25 = r33.is_edited.booleanValue();
        boolean r27 = r33.is_recalled.booleanValue();
        Message.Status r29 = Message.Status.NORMAL;
        if (r27 == false) goto L96;
        r29 = Message.Status.DELETED;
        r10.setReEditable(r33.is_reeditable.booleanValue());
    L98:
        r10.setRemoved(r22);
        r10.setDeCryptFailed(r33.is_decrypto_fail.booleanValue());
        r10.setStatus(r29);
        r10.setRootId(r33.root_id);
        r10.setParentId(r33.parent_id);
        r10.setChatId(r33.chat_id);
        r10.setcId(r33.cid);
        r10.setPosition(r33.position.intValue());
        r10.setBadgeCount(r33.badge_count.intValue());
        r10.setBadged(r33.is_badged.booleanValue());
        r10.setUpdateTime(r33.update_time.longValue());
        r10.setNotified(r33.should_notify.booleanValue());
        r10.setReplyCount(r33.reply_count.intValue());
        r10.setDing(r33.is_urgent.booleanValue());
        if (r33.file_deleted_status != com.bytedance.lark.pb.basic.v1.Message.FileDeletedStatus.RECALLED) goto L101;
        boolean r30 = true;
    L102:
        r10.setSourceFileDelete(r30);
        r10.setFileDeletedStatus(Message.FileDeletedStatus.fromValue(r33.file_deleted_status.getValue()));
        if (r33.is_at_me.booleanValue() == true) goto L105;
    L107:
        boolean r31 = false;
    L108:
        r10.setOtherAtMe(r31);
        int r34 = 2;
        if (r33.me_read.booleanValue() == false) goto L111;
        int r35 = 2;
    L112:
        r10.setMeReadType(r35);
        r10.setIsUnTranslatable(r33.is_untranslateable.booleanValue());
        r10.setReadAtChatterIds(r33.read_at_chatter_ids);
        r10.setTextDraftId(r33.text_draft_id);
        r10.setPostDraftId(r33.post_draft_id);
        if (Message.Type.SHARE_GROUP_CHAT != r10.getType()) goto L120;
        ShareGroupChatContent r36 = r10.getContent();
        if (r32 == null) goto L120;
        Chat r37 = (Chat) r32.chats.get(r33.content.share_chat_id);
        if (r37 == null) goto L120;
        r36.setChat(h.a(r37, null));
    L120:
        r10.setChannel(g.a(r33.channel));
        r10.setReadCount(r33.read_count.intValue());
        r10.setUnReadCount(r33.unread_count.intValue());
        r10.setSourceId(r33.source_id);
        r10.setParentSourceId(r33.parent_source_id);
        r10.setSourceType(Message.SourceType.valueOf(r33.source_type.getValue()));
        r10.setRecallerId(r33.recaller_id);
        r10.setRecallerIdentity(Message.RecallerIdentity.valueOf(r33.recaller_identity.getValue()));
        r10.setAtAll(r33.is_at_all.booleanValue());
        r10.setAtMe(r33.is_at_me.booleanValue());
        r10.setVisible(r33.is_visible.booleanValue());
        r10.setThreadId(r33.thread_id);
        r10.setThreadBadgeCount(r33.thread_badge_count.intValue());
        r10.setThreadPosition(r33.thread_position.intValue());
        r10.setNoTraceDelete(r33.is_no_trace_deleted.booleanValue());
        r10.setOriginBadgeCount(r33.origin_badge_count.intValue());
        r10.setBurnLife(r33.burn_life.intValue());
        r10.setBurnTime(r33.burn_time.longValue());
        r10.setBurned(r33.is_burned.booleanValue());
        r10.setOnTimeDel(r33.is_on_time_del.booleanValue());
        r10.setTranslateLanguage(r33.translate_language);
        r10.setMessageLanguage(r33.message_language);
        r10.setCharacterLength(r33.character_length.intValue());
        com.bytedance.lark.pb.basic.v1.Message.Version r38 = r33.version;
        if (r38 == null) goto L123;
        int r39 = r38.content_version.intValue();
    L124:
        r10.setContentVersion(r39);
        TranslateMessageDisplayRule r40 = r33.translate_message_display_rule;
        if (r40 == null) goto L127;
        int r41 = r40.rule.getValue();
    L128:
        r10.setTranslateDisplayRule(r41);
        r10.setAutoTranslatedForReceiver(r33.is_auto_translated_by_receiver.booleanValue());
        r10.setAtBotIds(a(r32, r10));
        r10.setTranslatedManually(r33.is_manual_translated.booleanValue());
        if (r33.content.origin_sender_id_str.isEmpty() == true) goto L131;
        r10.setOriginalSenderId(r33.content.origin_sender_id_str);
    L133:
        if (r33.forward_from_friend.booleanValue() == false) goto L135;
    L138:
        boolean r42 = true;
    L139:
        r10.setForwardFromFriend(r42);
        r10.setIsCryptoIntermediate(r33.is_crypto_intermediate.booleanValue());
        r10.setIsSyncMsgDep(r33.sync_dependency.booleanValue());
        r10.setCryptoToken(r33.crypto_token);
        r10.setHasFollowUP(r33.has_follow_up.booleanValue());
        com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType r43 = r33.thread_message_type;
        if (r43 == null) goto L142;
        r10.setThreadMessageType(Message.ThreadMessageType.fromValue(r43.getValue()));
    L142:
        Boolean r44 = r33.is_flag;
        if (r44 != null) goto L145;
    L147:
        boolean r45 = false;
    L148:
        r10.setFlag(r45);
        r10.setReplyInThreadDraftId(r33.msg_thread_draft_id);
        MessageDLPState r46 = r33.dlp_state;
        if (r46 == null) goto L151;
        r10.setDlpState(com.ss.android.lark.chat.entity.message.MessageDLPState.fromValue(r46.getValue()));
    L152:
        SecurityESCReviewExtra r47 = r33.security_extra;
        if (r47 == null) goto L155;
        r10.setSecurityESCReviewExtra(new MessageSecurityESCReviewExtra(r47.tip_text, r47.submit_text, r47.feed_back_url));
    L155:
        r10.setScheduleDraftId(r33.schedule_message_draft_id);
        com.bytedance.lark.pb.basic.v1.Message.ChatDisplayModeSetting r48 = r33.in_chat_display_mode;
        if (r48 == null) goto L158;
        ChatDisplayModeSetting.a r49 = ChatDisplayModeSetting.Companion;
        int r50 = r48.getValue();
        r49.getClass();
        r10.setChatDisplayModeSetting(ChatDisplayModeSetting.a.a(r50));
    L158:
        r10.setIsRestricted(r33.is_restricted.booleanValue());
        r10.setGrey(r33.set_grey.booleanValue());
        r10.setSecretChatDecryptedFailed(r33.is_secret_chat_decrypted_failed.booleanValue());
        HashMap r51 = new HashMap();
        long r52 = CastLongProtector.parseLong(r33.id);     // Catch: NumberFormatException -> L161
    L163:
        if (r52 == 0) goto L178;
        if (r32 == null) goto L178;
        Map r53 = r32.message_local_data;
        if (r53 == null) goto L178;
        if (r53.get(Long.valueOf(r52)) == null) goto L178;
        Map r54 = ((MessageLocalDataInfoMap) r32.message_local_data.get(Long.valueOf(r52))).data;
        if (r54 == null) goto L178;
        Iterator r55 = r54.entrySet().iterator();
    L174:
        if (r55.hasNext() == false) goto L178;
        Map.Entry r56 = (Map.Entry) r55.next();
        if (TextUtils.isEmpty(((MessageLocalData) r56.getValue()).json_data_string) == true) goto L174;
        r51.put((Integer) r56.getKey(), ((MessageLocalData) r56.getValue()).json_data_string);
    L178:
        r10.setMessageLocalDataInfoMap(r51);
        r10.setStreamSequenceId(r33.stream_sequence_id.intValue());
        com.bytedance.lark.pb.basic.v1.Message.StreamStatus r57 = r33.stream_status;
        if (r57 == null) goto L181;
        r10.setStreamStatus(MessageStreamStatus.fromValue(r57.getValue()));
    L181:
        Long r58 = r33.ai_chat_mode_id;
        if (r58 == null) goto L184;
        r10.setAiChatModeId(r58.longValue());
    L184:
        r10.setAiAnswerRawData(r33.ai_answer_raw_data);
        r10.setAIMessageLikeFeedbackStatus(r33.ai_message_like_feedback_status);
        Long r59 = r33.sync_to_chat_thread_root_id;
        if (r59 == null) goto L187;
        r10.setSyncToChatThreadRootId(r59.longValue());
    L187:
        com.bytedance.lark.pb.basic.v1.Message.SyncToChatMessageType r60 = r33.sync_to_chat_message_type;
        if (r60 == null) goto L192;
        r10.setSyncToChatMessageType(Message.SyncToChatMessageType.fromValue(r60.getValue()));
        if (r10.getSyncToChatMessageType() != Message.SyncToChatMessageType.SYNC_TO_CHAT_SOURCE_MESSAGE) goto L192;
        new HashMap();
    L192:
        Long r61 = r33.sync_to_chat_related_message_id;
        if (r61 == null) goto L195;
        r10.setSyncToChatRelatedMessageId(r61.longValue());
    L195:
        Boolean r62 = r33.can_show_ai_progress;
        if (r62 == null) goto L199;
        r10.setCanShowAiProcess(r62.booleanValue());
    L199:
        if (r33.is_ai_session_first_msg.booleanValue() == false) goto L201;
        r10.setNewTopic(r33.is_ai_session_first_msg.booleanValue());
    L201:
        com.bytedance.lark.pb.basic.v1.Message.AuthorizedSource r63 = r33.authorized_source;
        if (r63 != null) goto L204;
    L236:
        r10.setPartialReplyInfo(i(r33.partial_reply_info));
        com.bytedance.lark.pb.basic.v1.Message.AIInfo r64 = r33.ai_info;
        Gson r65 = e.a;
        if (r64 == null) goto L319;
        Long r66 = r64.round_id;
        com.bytedance.lark.pb.basic.v1.Message.AIInfo.ButtonConfig r67 = r64.button_config;
        if (r67 == null) goto L297;
        com.bytedance.lark.pb.basic.v1.Message.AIInfo.ButtonConfig.Strategy r110 = r67.strategy;
        if (r110 != null) goto L243;
        int r111 = -1;
    L244:
        if (r111 == 1) goto L248;
        if (r111 == 2) goto L247;
        AIButtonStrategy r112 = null;
    L249:
        List r113 = r67.customize_buttons;
        if (r113 == null) goto L275;
        ArrayList r68 = new ArrayList();
        Iterator r114 = r113.iterator();
    L253:
        if (r114.hasNext() == false) goto L276;
        com.bytedance.lark.pb.basic.v1.Message.AIInfo.ButtonConfig.Button r210 = (com.bytedance.lark.pb.basic.v1.Message.AIInfo.ButtonConfig.Button) r114.next();
        if (r210 != null) goto L257;
        int r69 = -1;
    L258:
        if (r69 == 1) goto L271;
        if (r69 != r34) goto L261;
        AIButtonType r70 = AIButtonType.DISLIKE;
    L272:
        if (r70 == null) goto L274;
        r68.add(r70);
    L274:
        r34 = 2;
        goto L253
    L261:
        if (r69 != 3) goto L263;
        r70 = AIButtonType.REGENERATE;
        goto L272
    L263:
        if (r69 != 4) goto L265;
        r70 = AIButtonType.SHARE;
        goto L272
    L265:
        if (r69 == 5) goto L267;
        r70 = null;
        goto L272
    L267:
        r70 = AIButtonType.COPY;
        goto L272
    L271:
        r70 = AIButtonType.LIKE;
        goto L272
    L257:
        r69 = e.a.b[r210.ordinal()];
    L276:
        String r71 = r67.ai_answer_markdown_data;
        String r72 = r67.button_list_json;
        if (r72 != null) goto L279;
    L282:
        boolean r73 = true;
    L283:
        if (r73 == true) goto L295;
        Gson r74 = e.a;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L288
        Object r75 = Result.constructor-impl(r74.fromJson(r72, CustomizeAIButtonGroup.class));     // Catch: Throwable -> L288
    L291:
        if (Result.isFailure-impl(r75) == false) goto L294;
        Log.e("ModelParserAIInfo", "parseJsonData failed", Result.exceptionOrNull-impl(r75));
    L294:
        if (Result.isFailure-impl(r75) == true) goto L295;
    L296:
        AIButtonConfig r76 = new AIButtonConfig(r112, r68, r71, (CustomizeAIButtonGroup) r75);
    L298:
        Long r77 = r64.root_round_id;
        String r78 = r64.enterprise_qa_general_info;
        if (r78 != null) goto L301;
    L304:
        boolean r79 = true;
    L305:
        if (r79 == true) goto L317;
        Gson r80 = e.a;
        Result.Companion r81 = Result.Companion;     // Catch: Throwable -> L310
        Object r82 = Result.constructor-impl(r80.fromJson(r78, EnterpriseQAGeneralInfo.class));     // Catch: Throwable -> L310
    L313:
        if (Result.isFailure-impl(r82) == false) goto L316;
        Log.e("ModelParserAIInfo", "parseJsonData failed", Result.exceptionOrNull-impl(r82));
    L316:
        if (Result.isFailure-impl(r82) == true) goto L317;
    L318:
        AIInfo r83 = new AIInfo(r66, r76, r77, (EnterpriseQAGeneralInfo) r82);
    L320:
        r10.setAiInfo(r83);
        if (ImSdkProxy.c().isFeatureGatingEnable("lark.im.agent.cot_message") == false) goto L331;
        COTContent r84 = r33.cot_content;
        if (r84 == null) goto L331;
        if (r10.getType() != Message.Type.TEXT) goto L329;
    L332:
        ArrayList r85 = new ArrayList();
        List r86 = r84.cot_events;
        if (r86 == null) goto L360;
        Iterator r87 = r86.iterator();
    L336:
        if (r87.hasNext() == false) goto L360;
        COTEvent r88 = (COTEvent) r87.next();
        if (r88 == null) goto L336;
        String r116 = r88.event_id;
        if (r116 != null) goto L343;
        String r211 = "";
    L344:
        CotEventType r117 = CotEventType.UNKNOWN;
        COTEventType r118 = r88.event_type;
        if (r118 == null) goto L347;
        r117 = CotEventType.fromValue(r118.getValue());
    L347:
        CotEventType r212 = r117;
        String r119 = r88.content;
        if (r119 != null) goto L350;
        String r213 = "";
    L351:
        Long r120 = r88.timestamp;
        if (r120 != null) goto L354;
        long r214 = 0;
    L355:
        Long r89 = r88.created_at;
        if (r89 != null) goto L358;
        long r310 = 0;
    L359:
        r85.add(new CotEvent(r211, r212, r213, r214, r310));
        goto L336
    L358:
        r310 = r89.longValue();
        goto L359
    L354:
        r214 = r120.longValue();
        goto L355
    L350:
        r213 = r119;
        goto L351
    L343:
        r211 = r116;
    L360:
        COTStatus r90 = r84.cot_status;
        if (r90 != null) goto L363;
        int r91 = 0;
    L364:
        Boolean r92 = r84.violated;
        if (r92 != null) goto L367;
    L369:
        boolean r121 = false;
    L370:
        Boolean r93 = r84.cot_events_incomplete;
        if (r93 != null) goto L373;
    L375:
        boolean r94 = false;
    L376:
        String r122 = r84.cot_id;
        int r95 = l.a;
        if (r122 != null) goto L379;
    L382:
        boolean r123 = true;
    L383:
        if (r123 == false) goto L425;
    L407:
        CotContent r124 = null;
    L408:
        if (r124 == null) goto L410;
        Log.i("ModelParserMessage", "parseCotContentIfNeed: parsed, messageId=" + r10.getId() + ", cid=" + r10.getcId() + ", chatId=" + r10.getChatId() + ", cotId=" + r84.cot_id + ", status=" + r91 + ", events=" + r85.size() + ", incomplete=" + r94);
    L410:
        r10.setCotContent(r124);
        r10.setAiSmartReply(AISmartReply.parsePbToAIReply(r33.smart_ai_reply));
        if (r32 == null) goto L413;
        r10.setAnalysisConfigs(MessageAnalysisConfig.parseFromPbMessage((com.bytedance.lark.pb.basic.v1.MessageAnalysisConfig) r32.analysis_configs.get(r33.id)));
    L413:
        return r10;
    L425:
        CotStatus.Companion.getClass();     // Catch: Exception -> L404
        if (r91 != 1) goto L388;
        CotStatus r125 = CotStatus.RUNNING;     // Catch: Exception -> L404
    L414:
        r124 = new CotContent(r122, r85, r125, r121, r94);     // Catch: Exception -> L402
    L402:
        e = e;
    L406:
        Log.e("ModelParserCotContent", "parse cotContent failed, cotId=" + r122, e);
        goto L407
    L388:
        if (r91 != 2) goto L390;
        r125 = CotStatus.DONE;     // Catch: Exception -> L404
        goto L414
    L390:
        if (r91 != 3) goto L392;
        r125 = CotStatus.ERROR;     // Catch: Exception -> L404
        goto L414
    L392:
        if (r91 == 4) goto L394;
        r125 = CotStatus.NONE;     // Catch: Exception -> L404
        goto L414
    L394:
        r125 = CotStatus.TIMEOUT;     // Catch: Exception -> L404
    L404:
        e = e;
        goto L406
    L379:
        if (r122.length() == 0) goto L382;
        r123 = false;
        goto L383
    L373:
        if (r93.booleanValue() == false) goto L375;
        r94 = true;
        goto L376
    L367:
        if (r92.booleanValue() == false) goto L369;
        r121 = true;
        goto L370
    L363:
        r91 = r90.getValue();
        goto L364
    L329:
        if (r10.getType() == Message.Type.POST) goto L332;
        Log.i("ModelParserMessage", "parseCotContentIfNeed: skip non text/post message, messageId=" + r10.getId() + ", chatId=" + r10.getChatId() + ", type=" + r10.getType() + ", cotId=" + r84.cot_id);
    L331:
        r124 = null;
    L310:
        th = move-exception;
        Result.Companion r96 = Result.Companion;
        r82 = Result.constructor-impl(ResultKt.createFailure(th));
    L317:
        r82 = null;
        goto L318
    L301:
        if (r78.length() == 0) goto L304;
        r79 = false;
    L288:
        th = move-exception;
        Result.Companion r97 = Result.Companion;
        r75 = Result.constructor-impl(ResultKt.createFailure(th));
    L295:
        r75 = null;
        goto L296
    L279:
        if (r72.length() == 0) goto L282;
        r73 = false;
        goto L283
    L275:
        r68 = null;
        goto L276
    L247:
        r112 = AIButtonStrategy.CUSTOMIZE;
        goto L249
    L248:
        r112 = AIButtonStrategy.DEFAULT;
        goto L249
    L243:
        r111 = e.a.a[r110.ordinal()];
        goto L244
    L297:
        r76 = null;
        goto L298
    L319:
        r83 = null;
        goto L320
    L204:
        if (r63.authorized_source_type != com.bytedance.lark.pb.basic.v1.Message.AuthorizedSourceType.APP) goto L236;
        if (r32 != null) goto L207;
        AppInfoItem r98 = null;
    L208:
        if (r98 != null) goto L215;
        Iterator r99 = r18.values().iterator();
    L211:
        if (r99.hasNext() == false) goto L215;
        AppInfoItem r100 = (AppInfoItem) ((MessageLink) r99.next()).app_info_items.get(r33.authorized_source.source_id);
        if (r100 == null) goto L211;
        r98 = r100;
    L215:
        com.bytedance.lark.pb.basic.v1.Message.AgentSendMessageSourceDisplayPolicy r101 = r33.authorized_source.display_policy;
        if (r101 != null) goto L218;
    L228:
        if (r98 == null) goto L235;
        r10.setAppInfoItemName(r98.name);
        Boolean r102 = r98.is_agent;
        if (r102 == null) goto L236;
        boolean r103 = r102.booleanValue();
        String r104 = r98.avatar_url;
        if (r104 != null) goto L234;
        r104 = "";
    L234:
        r10.setSenderAppInfo(new MessageSenderAppInfo(r103, r104));
        goto L236
    L235:
        r10.setAppInfoItemName("");
        goto L236
    L218:
        if (r101 != com.bytedance.lark.pb.basic.v1.Message.AgentSendMessageSourceDisplayPolicy.UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY) goto L221;
        MessageSourceDisplayPolicy r105 = MessageSourceDisplayPolicy.UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY;
    L227:
        r10.setDisplayPolicy(r105);
        goto L228
    L221:
        if (r101 != com.bytedance.lark.pb.basic.v1.Message.AgentSendMessageSourceDisplayPolicy.MENU) goto L224;
        r105 = MessageSourceDisplayPolicy.MENU;
        goto L227
    L224:
        if (r101 != com.bytedance.lark.pb.basic.v1.Message.AgentSendMessageSourceDisplayPolicy.INLINE) goto L226;
        r105 = MessageSourceDisplayPolicy.INLINE;
        goto L227
    L226:
        r105 = MessageSourceDisplayPolicy.UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY;
        goto L227
    L207:
        r98 = (AppInfoItem) r32.app_info_items.get(r63.source_id);
    L161:
        Log.e("ModelParserMessage", "parseMessageLocalDataInfoMap exception parse messageId");
        r52 = 0;
        goto L163
    L151:
        r10.setDlpState(null);
        goto L152
    L145:
        if (r44.booleanValue() == false) goto L147;
        r45 = true;
        goto L148
    L135:
        if (r33.content.is_friend.booleanValue() == true) goto L138;
        r42 = false;
        goto L139
    L131:
        r10.setOriginalSenderId(r33.original_sender_id);
        goto L133
    L127:
        r41 = 0;
        goto L128
    L123:
        r39 = 0;
        goto L124
    L111:
        r35 = 0;
        goto L112
    L105:
        if (r10.isFromMe() == true) goto L107;
        r31 = true;
        goto L108
    L101:
        r30 = false;
        goto L102
    L96:
        if (r25 == false) goto L98;
        r29 = Message.Status.MODIFIED;
        goto L98
    L84:
        if ((r19 instanceof TextContent) == false) goto L93;
        if (r10.getType() == Message.Type.TEXT) goto L93;
        if (r19.equals(r.p(null)) == false) goto L93;
        r10.setType(Message.Type.UNKNOWN);     // Catch: Exception -> L91
        goto L93
    L7:
        if (r0.is_anonymous.booleanValue() == false) goto L11;
        if (r33.anonymous_info.is_sender.booleanValue() == false) goto L11;
    L12:
        r1 = true;
        goto L13
    }

    public static Pair<Message, com.bytedance.lark.pb.basic.v1.Message> g(Entity r3, String r4) {
        Long r5 = StringsKt.toLongOrNull(r4);
        if (r5 != null) goto L5;
        return null;
    L5:
        MessageFoldDetail r6 = (MessageFoldDetail) r3.message_fold_details.get(r5);
        if (r6 != null) goto L9;
        Log.w("ModelParserMessage", "parseMessageFromFold: fold detail is null , continue");
        return null;
    L9:
        com.bytedance.lark.pb.basic.v1.Message r2 = r6.message;
        if (r2 != null) goto L13;
        Log.w("ModelParserMessage", "parseMessageFromFold: fold detail has no message, continue");
        return null;
    L13:
        Message r7 = f(r3, r2);
        r7.setUpdateTime(r6.update_time_ms.longValue());
        return new Pair(r7, r2);
    }

    public static String b(Entity r1, String r2, String r3) {
        if (r3 == null) goto L19;
        if (r2 == null) goto L19;
        if (r1 == null) goto L19;
        Map r4 = r1.chat_chatters;
        if (r4 == null) goto L19;
        Entity.ChatChatter r5 = (Entity.ChatChatter) r4.get(r2);
        if (r5 == null) goto L19;
        Map r6 = r5.chatters;
        if (r6 == null) goto L19;
        Chatter r7 = (Chatter) r6.get(r3);
        if (r7 != null) goto L18;
        return null;
    L18:
        return r7.tenant_id;
    L19:
        return null;
    }

    public static Content e(Entity r8, Message r9, com.bytedance.lark.pb.basic.v1.Content r10, TranslateInfo r11) {
        String r3 = r9.getId();     // Catch: Exception -> L42
        String r2 = r9.getChatId();     // Catch: Exception -> L42
        switch(a.a[r9.getType().ordinal()]) {
            case 1: goto L26;
            case 2: goto L22;
            case 3: goto L57;
            case 4: goto L56;
            case 5: goto L55;
            case 6: goto L13;
            case 7: goto L53;
            case 8: goto L52;
            case 9: goto L51;
            case 10: goto L50;
            case 11: goto L50;
            case 12: goto L49;
            case 13: goto L48;
            case 14: goto L47;
            default: goto L27;
        };     // Catch: Exception -> L42
    L13:
        ShareGroupChatContent r12 = new ShareGroupChatContent();     // Catch: Exception -> L42
        String r13 = r10.share_chat_id;     // Catch: Exception -> L42
        if (r8 == null) goto L18;
        Map r14 = r8.chats;     // Catch: Exception -> L42
        if (r14 == null) goto L18;
        r12.setChat(h.a((Chat) r14.get(r13), null));     // Catch: Exception -> L42
    L18:
        r12.setJoinToken(r10.join_token);     // Catch: Exception -> L42
        r12.setExpireTime(r10.expire_time.longValue());     // Catch: Exception -> L42
        return r12;
    L22:
        TextContent r15 = r.f(r10, r9, r11);     // Catch: Exception -> L42
        if (r9.isPreMessage() == false) goto L58;
        r15.setProgress(0);     // Catch: Exception -> L42
    L58:
        return r15;
    L26:
        r9.isFromMe();     // Catch: Exception -> L42
        String r4 = r9.getChatId();     // Catch: Exception -> L42
        r9.getcId();     // Catch: Exception -> L42
        return r.o(r4, r3, r10, r8, r9.getCreateTimeInMills());
    L27:
        gya.a r5 = b.a(MessageType.forNumber(r9.getType().getNumber()));     // Catch: Exception -> L42
        if (r5 != null) goto L45;
        r15 = new UnknownContent();     // Catch: Exception -> L42
        goto L58
    L45:
    L35:
        th = move-exception;
        Log.e("ModelParserMessage", th.getMessage());     // Catch: Exception -> L42
        if (ImSdkProxy.b().isDebug() == true) goto L39;
        Log.e("ModelParserMessage", "return unknown content in release mode");     // Catch: Exception -> L42
        return r.p(null);
    L39:
        throw th;     // Catch: Exception -> L42
    L30:
        if (r5.b() == false) goto L32;
        r15 = r5.e(r8, r9, r10, r11);     // Catch: Throwable -> L35
    L33:
        if (r15 != null) goto L58;
        r15 = r.p(null);     // Catch: Exception -> L42
        goto L58
    L32:
        r15 = r5.g(r8, r9, r10);     // Catch: Throwable -> L35
        goto L33
    L47:
        return r.p(r10);
    L48:
        return r.d(r10, r9);
    L49:
        return r.k(r8, r2, r10);
    L50:
        return r.l(r8, r10, r2);
    L51:
        return r.g(r10, r9);
    L52:
        return r.n(r10);
    L53:
        return r.m(r10);
    L55:
        return r.b(r10, r11);
    L56:
        return r.c(r10, r2, r9, r8);
    L57:
        return r.j(r8, r10, r9, r11);
    L42:
        e = move-exception;
        Log.e("ModelParserMessage", "error when decoding pb" + e.getMessage(), e, true);
        return null;
    }

    public static MessageInfo k(Message r2, Entity r3, com.ss.android.lark.chat.entity.chatter.a r4, Map<String, MessageInfo> r5) {
        ChatChatter r0 = r4.b(r2.getChatId(), r2.getFromId());
        if (r0 == null) goto L6;
        MessageInfo r1 = new MessageInfo(r2, r0);
        com.ss.android.lark.parser.internal.a.b(r2, r3, r4, r1, r5);
        return r1;
    L6:
        return null;
    }
}
