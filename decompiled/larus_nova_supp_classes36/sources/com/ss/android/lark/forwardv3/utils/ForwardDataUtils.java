package com.ss.android.lark.forwardv3.utils;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.DeniedReason;
import com.bytedance.lark.pb.feed.v1.ForwardCommonData;
import com.bytedance.lark.pb.feed.v1.ThreadData;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.ForwardImServices;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.data.ForwardTargetChatterInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetGroupChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetShieldP2PChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetThreadInfo;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.info.SearchAiKnowledgeInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.ss.android.lark.utils.UIHelper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForwardDataUtils {
    public static WeakReference<Message> a;
    public static Message b;
    public static long c;
    public static String d;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Chat.Type.values().length];
            r0[Chat.Type.P2P.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L32:
            r0[Chat.Type.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L6:
            int[] r1 = new int[ThreadData.EntityType.values().length];
            r1[ThreadData.EntityType.THREAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L38:
            r1[ThreadData.EntityType.MSG_THREAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L9:
            int[] r2 = new int[ForwardCommonData.ItemType.values().length];
            r2[ForwardCommonData.ItemType.ITEM_TYPE_CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L34:
            r2[ForwardCommonData.ItemType.ITEM_TYPE_CHATTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L36:
            r2[ForwardCommonData.ItemType.ITEM_TYPE_THREAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L30:
            r2[ForwardCommonData.ItemType.ITEM_TYPE_REPLY_IN_THREAD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L42:
            r2[ForwardCommonData.ItemType.ITEM_TYPE_SHIELD_P2P_CHAT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L15:
            a = r2;
        }
    }

    static {
        d = UIHelper.getString(2131891299);
        e = LazyKt.lazy(ForwardDataUtils$chatParser$2.INSTANCE);
        f = LazyKt.lazy(ForwardDataUtils$chatterParser$2.INSTANCE);
        g = LazyKt.lazy(ForwardDataUtils$threadParser$2.INSTANCE);
        h = LazyKt.lazy(ForwardDataUtils$replyInThreadParser$2.INSTANCE);
        i = LazyKt.lazy(ForwardDataUtils$shieldP2PChatParser$2.INSTANCE);
    }

    public static SearchChatInfo c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "chatId");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        ImSdkChatService r0 = (ImSdkChatService) ForwardImServices.a.getValue();
        if (r0 == null) goto L24;
        com.ss.android.lark.chat.entity.chat.Chat r4 = r0.we(r3);
        if (r4 == null) goto L24;
        com.ss.android.lark.chat.entity.chat.Chat.Type r1 = r4.getType();
        com.ss.android.lark.chat.entity.chat.Chat.Type r2 = com.ss.android.lark.chat.entity.chat.Chat.Type.GROUP;
        if (r1 != r2) goto L24;
        SearchChatInfo r5 = new SearchChatInfo();
        r5.setScene(Scene.Type.TRANSMIT_MESSAGES);
        r5.setTitle(r4.getName());
        r5.setAvatarKey(r4.getAvatarKey());
        r5.setId(r4.getId());
        com.ss.android.lark.chat.entity.chat.Chat.Type r6 = r4.getType();
        if (r6 == null) goto L16;
        r2 = r6;
    L16:
        r5.setChatType(r2);
        r5.setPublic(r4.isPublic());
        r5.setDepartment(r4.is_department());
        r5.setCrossTenant(r4.isCrossTenant());
        r5.setCrossWithKa(r4.isCrossWithKa());
        com.ss.android.lark.chat.entity.chat.Chat.ChatMode r7 = r4.getChatMode();
        if (r7 != null) goto L19;
        r7 = com.ss.android.lark.chat.entity.chat.Chat.ChatMode.DEFAULT;
    L19:
        r5.setChatMode(r7);
        r5.setUserCount(r4.getUserCount());
        r5.setTenant(r4.isTenant());
        r5.setTagData(r4.getTagData());
        r5.setMeeting(r4.isMeeting());
        r5.setSecretChat(r4.isSecret());
        r5.setOfficialOnCall(r4.isOfficialOncall());
        r5.setCountLightStyle(true);
        r5.setLastMessagePosition(r4.getLastMessagePosition());
        r5.setRemind(r4.isRemind());
        r5.setDelayed(r4.isDelayed());
        r5.setType(2);
        r5.setMember(r4.isMember());
        r5.setTags(r4.getTags());
        ChatDisplayModeSetting r8 = r4.getChatDisplayModeSetting();
        if (r8 != null) goto L22;
        r8 = ChatDisplayModeSetting.DEFAULT;
    L22:
        r5.setChatDisplayModeSetting(r8);
        r5.setUserCountVisible(r4.isUserCountVisible());
        return r5;
    L24:
        return null;
    }

    public static String d(List r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        if (b.b() == true) goto L5;
    L31:
        return "";
    L5:
        if (r2.size() != 1) goto L31;
        SearchChatInfo r3 = (SearchBaseInfo) CollectionsKt.first(r2);
        if ((r3 instanceof SearchChatInfo) == false) goto L13;
        String r4 = r3.getId();
        if (r4 == null) goto L31;
        return r4;
    L13:
        if ((r3 instanceof SearchChatterInfo) == false) goto L18;
        String r5 = ((SearchChatterInfo) r3).getP2pChatId();
        if (r5 == null) goto L31;
        return r5;
    L18:
        if ((r3 instanceof SearchThreadInfo) == false) goto L23;
        String r6 = ((SearchThreadInfo) r3).getChatId();
        if (r6 == null) goto L31;
        return r6;
    L23:
        if ((r3 instanceof SearchReplyInThreadInfo) == false) goto L28;
        String r7 = ((SearchReplyInThreadInfo) r3).getChatId();
        if (r7 == null) goto L31;
        return r7;
    L28:
        if ((r3 instanceof SearchAiKnowledgeInfo) == false) goto L31;
        String r8 = ((SearchAiKnowledgeInfo) r3).getId();
        if (r8 == null) goto L31;
        return r8;
    }

    public static SearchBaseInfo e(ForwardCommonData r8) {
        Intrinsics.checkNotNullParameter(r8, "pb");
        ForwardCommonData.ItemType r1 = r8.item_type;
        if (r1 != null) goto L5;
        int r2 = -1;
    L7:
        if (r2 == 1) goto L88;
        String r0 = "";
        if (r2 != 2) goto L11;
        ajb.b r3 = (ajb.b) f.getValue();
        ForwardCommonData.ChatterInfo r4 = r8.chatter;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r8, "commonData");
        if (r4 != null) goto L75;
        Log.e("ChatterParser", "ForwardCommonData id is: " + r8.id + ", ForwardCommonData type is: " + r8.item_type);
        Unit r5 = Unit.INSTANCE;
    L75:
        if (r4 == null) goto L93;
        SearchChatterInfo r6 = new SearchChatterInfo();
        ajb.c.a(r6, r8);
        Long r7 = r4.chatter_id;
        if (r7 == null) goto L80;
        String r9 = r7.toString();
        if (r9 == null) goto L80;
    L81:
        r6.setId(r9);
        Long r10 = r8.chat_id;
        if (r10 == null) goto L87;
        String r11 = r10.toString();
        if (r11 == null) goto L87;
        r0 = r11;
    L87:
        r6.setP2pChatId(r0);
        r6.setType(1);
        r6.setStatusList(r4.customStatus);
        r6.setZenModeEndTime(r4.doNotDisturbEndTime.longValue());
        r6.setChatterType(Chatter.ChatterType.forNumber(r4.chatter_type.getValue()));
        r6.setBotExtType(r4.bot_ext_type.intValue());
        r6.setAgent(r4.is_agent.booleanValue());
        return r6;
    L80:
        r9 = "";
    L93:
        return null;
    L11:
        if (r2 != 3) goto L13;
        ajb.f r12 = (ajb.f) g.getValue();
        ForwardCommonData.ThreadInfo r13 = r8.thread;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r8, "commonData");
        if (r13 != null) goto L59;
        Log.e("ThreadParser", "ForwardCommonData id is: " + r8.id + ", ForwardCommonData type is: " + r8.item_type);
        Unit r14 = Unit.INSTANCE;
    L59:
        if (r13 == null) goto L93;
        SearchThreadInfo r15 = new SearchThreadInfo();
        ajb.c.a(r15, r8);
        r15.setType(8);
        Channel.Type r16 = Channel.Type.CHAT;
        Long r17 = r8.chat_id;
        if (r17 == null) goto L64;
        String r18 = r17.toString();
        if (r18 == null) goto L64;
    L65:
        r15.setChannel(new Channel(r16, r18));
        Long r19 = r8.chat_id;
        if (r19 == null) goto L71;
        String r20 = r19.toString();
        if (r20 == null) goto L71;
        r0 = r20;
    L71:
        r15.setChatId(r0);
        return r15;
    L64:
        r18 = "";
        goto L65
    L13:
        if (r2 != 4) goto L15;
        ajb.d r21 = (ajb.d) h.getValue();
        ForwardCommonData.ReplyInThreadInfo r22 = r8.replyInThread;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r8, "commonData");
        if (r22 != null) goto L36;
        Log.e("ReplyInThreadParser", "ForwardCommonData id is: " + r8.id + ", ForwardCommonData type is: " + r8.item_type);
        Unit r23 = Unit.INSTANCE;
    L36:
        if (r22 == null) goto L93;
        SearchReplyInThreadInfo r24 = new SearchReplyInThreadInfo();
        ajb.c.a(r24, r8);
        Long r25 = r22.p2p_chatter_id;
        if (r25 != null) goto L41;
    L42:
        com.ss.android.lark.chat.entity.chat.Chat.Type r26 = com.ss.android.lark.chat.entity.chat.Chat.Type.P2P;
    L44:
        r24.setChatType(r26);
        Long r27 = r8.chat_id;
        if (r27 == null) goto L48;
        String r28 = r27.toString();
        if (r28 == null) goto L48;
    L49:
        r24.setChatId(r28);
        Long r29 = r22.p2p_chatter_id;
        if (r29 == null) goto L55;
        String r30 = r29.toString();
        if (r30 == null) goto L55;
        r0 = r30;
    L55:
        r24.setP2pChatterId(r0);
        return r24;
    L48:
        r28 = "";
        goto L49
    L41:
        if (r25.longValue() != 0) goto L42;
        r26 = com.ss.android.lark.chat.entity.chat.Chat.Type.UNKNOWN;
        goto L44
    L15:
        if (r2 != 5) goto L93;
        ajb.e r31 = (ajb.e) i.getValue();
        ForwardCommonData.ShieldP2PChatInfo r32 = r8.shieldP2PChatInfo;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r8, "commonData");
        if (r32 != null) goto L20;
        Log.e("ShieldP2PChatParser", "ForwardCommonData id is: " + r8.id + ", ForwardCommonData type is: " + r8.item_type);
        Unit r33 = Unit.INSTANCE;
    L20:
        if (r32 == null) goto L93;
        SearchShieldP2PChatInfo r34 = new SearchShieldP2PChatInfo();
        ajb.c.a(r34, r8);
        Long r35 = r8.chat_id;
        if (r35 == null) goto L25;
        String r36 = r35.toString();
        if (r36 == null) goto L25;
    L26:
        r34.setId(r36);
        r34.setType(100000027);
        Long r37 = r32.chatter_id;
        if (r37 == null) goto L32;
        String r38 = r37.toString();
        if (r38 == null) goto L32;
        r0 = r38;
    L32:
        r34.setChatterId(r0);
        return r34;
    L25:
        r36 = "";
        goto L26
    L88:
        ajb.a r39 = (ajb.a) e.getValue();
        ForwardCommonData.ChatInfo r40 = r8.chat;
        r39.getClass();
        Intrinsics.checkNotNullParameter(r8, "commonData");
        if (r40 != null) goto L91;
        Log.e("ChatParser", "ForwardCommonData id is: " + r8.id + ", ForwardCommonData type is: " + r8.item_type);
        Unit r41 = Unit.INSTANCE;
    L91:
        if (r40 == null) goto L93;
        SearchChatInfo r42 = new SearchChatInfo();
        ajb.c.a(r42, r8);
        r42.setType(2);
        r42.setOfficialOnCall(r40.is_official_oncall.booleanValue());
        r42.setShield(r40.is_shield_mode.booleanValue());
        r42.setChatMode(com.ss.android.lark.chat.entity.chat.Chat.ChatMode.forNumber(r40.chat_type.getValue()));
        ChatDisplayModeSetting.a r43 = ChatDisplayModeSetting.Companion;
        Chat.ChatDisplayModeSetting.Enum r44 = r40.chat_display_mode_setting;
        r43.getClass();
        Intrinsics.checkNotNullParameter(r44, "pb");
        r42.setChatDisplayModeSetting(ChatDisplayModeSetting.a.a(r44.getValue()));
        r42.setUserCount(r40.chat_user_count.intValue());
        r42.setCountLightStyle(true);
        r42.setDepartment(r40.is_department.booleanValue());
        r42.setPublic(r40.is_public.booleanValue());
        r42.setUserCountVisible(r40.is_user_count_visible.booleanValue());
        return r42;
    L5:
        r2 = a.a[r1.ordinal()];
        goto L7
    }

    public static ForwardTargetBaseInfoNew f(SearchBaseInfo r9) {
        Intrinsics.checkNotNullParameter(r9, "info");
        String r5 = "";
        if ((r9 instanceof SearchChatterInfo) == false) goto L16;
        ForwardTargetChatterInfo.a r0 = new ForwardTargetChatterInfo.a();
        SearchChatterInfo r6 = (SearchChatterInfo) r9;
        String r7 = r6.getId();
        if (r7 != null) goto L7;
        r7 = "";
    L7:
        Intrinsics.checkNotNullParameter(r7, "chatterId");
        r0.a = r7;
        String r4 = r6.getP2pChatId();
        if (r4 == null) goto L11;
        r5 = r4;
    L11:
        Intrinsics.checkNotNullParameter(r5, "p2pChatId");
        r0.b = r5;
        Chatter.ChatterType r3 = r6.getChatterType();
        if (r3 != null) goto L14;
        r3 = Chatter.ChatterType.UNKNOWN;
    L14:
        Intrinsics.checkNotNullParameter(r3, "chatterType");
        r0.c = r3;
        ForwardTargetChatterInfo r2 = new ForwardTargetChatterInfo();
        String r8 = r0.a;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r2.g = r8;
        String r10 = r0.b;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r2.h = r10;
        Chatter.ChatterType r1 = r0.c;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r2.i = r1;
        a(r2, r9);
        return r2;
    L16:
        if ((r9 instanceof SearchChatInfo) == false) goto L29;
        ForwardTargetGroupChatInfo.a r11 = new ForwardTargetGroupChatInfo.a();
        SearchChatInfo r12 = (SearchChatInfo) r9;
        String r13 = r12.getId();
        if (r13 == null) goto L21;
        r5 = r13;
    L21:
        Intrinsics.checkNotNullParameter(r5, "chatId");
        r11.d = r5;
        com.ss.android.lark.chat.entity.chat.Chat.ChatMode r14 = r12.getChatMode();
        if (r14 != null) goto L24;
        r14 = com.ss.android.lark.chat.entity.chat.Chat.ChatMode.UNKNOWN;
    L24:
        Intrinsics.checkNotNullParameter(r14, "chatMode");
        r11.a = r14;
        r11.c = r12.isShield();
        ChatDisplayModeSetting r15 = r12.getChatDisplayModeSetting();
        if (r15 != null) goto L27;
        r15 = ChatDisplayModeSetting.DEFAULT;
    L27:
        Intrinsics.checkNotNullParameter(r15, "chatDisplayModeSetting");
        r11.b = r15;
        ForwardTargetGroupChatInfo r16 = new ForwardTargetGroupChatInfo();
        com.ss.android.lark.chat.entity.chat.Chat.ChatMode r17 = r11.a;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r16.g = r17;
        ChatDisplayModeSetting r18 = r11.b;
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r16.h = r18;
        r16.i = r11.c;
        String r19 = r11.d;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r16.j = r19;
        a(r16, r9);
        return r16;
    L29:
        if ((r9 instanceof SearchThreadInfo) == false) goto L38;
        ForwardTargetThreadInfo.a r20 = new ForwardTargetThreadInfo.a();
        SearchThreadInfo r21 = (SearchThreadInfo) r9;
        String r22 = r21.getId();
        if (r22 != null) goto L33;
        r22 = "";
    L33:
        Intrinsics.checkNotNullParameter(r22, "threadId");
        r20.b = r22;
        Channel r23 = r21.getChannel();
        if (r23 != null) goto L36;
        r23 = new Channel(Channel.Type.UNKNOWN, "");
    L36:
        Intrinsics.checkNotNullParameter(r23, "channel");
        r20.a = r23;
        Intrinsics.checkNotNullParameter("", "p2pChatterId");
        r20.c = "";
        r20.d = 0;
        ForwardTargetThreadInfo r24 = r20.a();
        a(r24, r9);
        return r24;
    L38:
        if ((r9 instanceof SearchReplyInThreadInfo) == false) goto L45;
        ForwardTargetThreadInfo.a r25 = new ForwardTargetThreadInfo.a();
        SearchReplyInThreadInfo r26 = (SearchReplyInThreadInfo) r9;
        String r27 = r26.getId();
        if (r27 == null) goto L43;
        r5 = r27;
    L43:
        Intrinsics.checkNotNullParameter(r5, "threadId");
        r25.b = r5;
        Channel r28 = new Channel(Channel.Type.CHAT, r26.getChatId());
        Intrinsics.checkNotNullParameter(r28, "channel");
        r25.a = r28;
        String r29 = r26.getP2pChatterId();
        Intrinsics.checkNotNullParameter(r29, "p2pChatterId");
        r25.c = r29;
        r25.d = 1;
        ForwardTargetThreadInfo r30 = r25.a();
        a(r30, r9);
        return r30;
    L45:
        if ((r9 instanceof SearchShieldP2PChatInfo) == false) goto L54;
        ForwardTargetShieldP2PChatInfo.a r31 = new ForwardTargetShieldP2PChatInfo.a();
        SearchShieldP2PChatInfo r32 = (SearchShieldP2PChatInfo) r9;
        Chatter.ChatterType r33 = r32.getChatterType();
        if (r33 != null) goto L49;
        r33 = Chatter.ChatterType.UNKNOWN;
    L49:
        Intrinsics.checkNotNullParameter(r33, "chatterType");
        r31.c = r33;
        String r34 = r32.getId();
        if (r34 == null) goto L53;
        r5 = r34;
    L53:
        Intrinsics.checkNotNullParameter(r5, "p2pChatId");
        r31.b = r5;
        String r35 = r32.getChatterId();
        Intrinsics.checkNotNullParameter(r35, "chatterId");
        r31.a = r35;
        ForwardTargetChatterInfo r36 = new ForwardTargetChatterInfo();
        String r37 = r31.a;
        Intrinsics.checkNotNullParameter(r37, "<set-?>");
        r36.g = r37;
        String r38 = r31.b;
        Intrinsics.checkNotNullParameter(r38, "<set-?>");
        r36.h = r38;
        Chatter.ChatterType r39 = r31.c;
        Intrinsics.checkNotNullParameter(r39, "<set-?>");
        r36.i = r39;
        a(r36, r9);
        return r36;
    L54:
        return null;
    }

    public static void g(Message r1) {
        if (b.c() == false) goto L5;
        b = r1;
        return;
    L5:
        if (r1 == null) goto L7;
        WeakReference<Message> r0 = new WeakReference(r1);
    L8:
        a = r0;
        return;
    L7:
        r0 = null;
        goto L8
    }

    public static void a(ForwardTargetBaseInfoNew r3, SearchBaseInfo r4) {
        String r0 = r4.getId();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r3.a = r0;
        String r2 = r4.getTitle();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r3.b = r2;
        String r5 = r4.getAvatarKey();
        if (r5 == null) goto L12;
        r1 = r5;
    L12:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r3.c = r1;
        r3.d = r4.isCrossTenant();
    }

    public static void b(List r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "result");
        Intrinsics.checkNotNullParameter(r4, "denyReasons");
        Sequence r5 = SequencesKt.filter(CollectionsKt.asSequence(r3), ForwardDataUtils$appendDeniedReason$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        SearchChatterInfo r0 = (SearchChatterInfo) r6.next();
        DeniedReason r1 = (DeniedReason) r4.get(r0.getId());     // Catch: NumberFormatException -> L10
        if (r1 == null) goto L4;
        r0.setDeniedReason(r1.getValue());     // Catch: NumberFormatException -> L10
        r0.setDeniedReasons(CollectionsKt.listOf(r1));     // Catch: NumberFormatException -> L10
    L10:
        Log.e("ForwardDataUtils", "parse deny reason error, cause chatter id:" + r0.getId() + " is error");
        goto L4
    }
}
