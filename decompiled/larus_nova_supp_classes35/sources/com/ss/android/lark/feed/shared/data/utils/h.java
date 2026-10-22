package com.ss.android.lark.feed.shared.data.utils;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.AvatarMedal;
import com.bytedance.lark.pb.basic.v1.FeedButtonData;
import com.bytedance.lark.pb.basic.v1.Icon;
import com.bytedance.lark.pb.basic.v1.Image;
import com.bytedance.lark.pb.feed.v1.AppFeedCard;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.bytedance.lark.pb.feed.v1.BoxData;
import com.bytedance.lark.pb.feed.v1.ChatData;
import com.bytedance.lark.pb.feed.v1.Digest;
import com.bytedance.lark.pb.feed.v1.DocData;
import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import com.bytedance.lark.pb.feed.v1.FocusInfo;
import com.bytedance.lark.pb.feed.v1.OpenAppData;
import com.bytedance.lark.pb.feed.v1.SubscriptionsData;
import com.bytedance.lark.pb.feed.v1.ThreadData;
import com.ss.android.lark.biz.im.api.ChatNotMemberType;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.doc.entity.DocMessage;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.feed.app.entity.AutoMuteSettingNoticeType;
import com.ss.android.lark.parser.internal.ModelParserChatTeamInfo;
import com.ss.android.lark.team.parser.TeamModelParser;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h {
    public static final List<com.ss.android.lark.feed.export.feedcard.f> a = null;

    static {
        int r0 = c.a;
        Map r1 = com.ss.android.lark.im.base.d.a;
        List r2 = com.ss.android.lark.im.base.d.c(ImExtensionType.FEED_CARD_FACTORY, com.ss.android.lark.feed.export.feedcard.e.class);
        ArrayList r3 = new ArrayList();
        Iterator r4 = ((ArrayList) r2).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r3.add(((com.ss.android.lark.feed.export.feedcard.e) r4.next()).a());
        goto L4
    L6:
        a = r3;
    }

    public static FeedPreviewInfo a(FeedEntityPreview r10) {
        List r0 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        Iterator r1 = ((ArrayList) a).iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        com.ss.android.lark.feed.export.feedcard.f r2 = (com.ss.android.lark.feed.export.feedcard.f) r1.next();
        if (r2.c(r10) == false) goto L7;
        return r2.a(r10);
    L12:
        FeedPreviewInfo r3 = new FeedPreviewInfo();
        r3.a = r10.feed_id;
        r3.e = FeedCard.FeedType.forNumber(r10.feed_type.getValue());
        r3.z = r10.is_delayed.booleanValue();
        Boolean r4 = r10.is_flag;
        boolean r5 = true;
        boolean r6 = false;
        if (r4 != null) goto L15;
    L17:
        boolean r7 = false;
    L18:
        r3.A = r7;
        r3.m = r10.update_time.longValue();
        r3.P1 = r10.parent_card_id;
        Long r8 = r10.user_id;
        if (r8 == null) goto L21;
        String r9 = String.valueOf(r8);
    L22:
        r3.b = r9;
        Boolean r11 = r10.check_user;
        if (r11 != null) goto L25;
    L27:
        boolean r12 = false;
    L28:
        r3.c = r12;
        r3.K2 = r10.on_top_rank_time.longValue();
        r3.L2 = r10.is_priority_processing.booleanValue();
        ChatData r13 = r10.chat_data;
        if (r13 == null) goto L79;
        r3.d = FeedCard.Type.CHAT;
        r3.g = r13.name;
        String r14 = r13.avatar_key;
        Icon r15 = r13.icon;
        if (r15 != null) goto L33;
    L37:
        r3.f = r14;
        FocusInfo r16 = r13.focus_info;
        if (r16 == null) goto L40;
        r3.Y = new com.ss.android.lark.biz.im.api.FocusInfo(r16.message_id.longValue());
    L40:
        r3.Z = r13.chatter_apply_count.intValue();
        Boolean r17 = r13.is_special_focus;
        if (r17 != null) goto L43;
    L45:
        r5 = false;
    L46:
        r3.k0 = r5;
        r3.p0 = r13.digest;
        r3.i = r13.unread_count.intValue();
        r3.j = r13.is_remind.booleanValue();
        r3.o = r13.is_shortcut.booleanValue();
        r3.s = b.a(r13.draft_preview);
        r3.p = b.c(r13.at_info);
        r3.M1 = b.b(r13.at_infos);
        r3.q = r13.at_infos_count.intValue();
        r3.r = b.d(r13.urgent_info);
        r3.t = FeedPreviewInfo.EntityStatus.getSource(r13.entity_status.getValue());
        r3.k = r13.display_time.longValue();
        r3.l = r13.rank_time.longValue();
        r3.L0 = r13.cross_tenant.booleanValue();
        r3.P0 = j.a(r13.reactions);
        r3.n = r13.do_not_disturb_end_time.longValue();
        r3.V0 = r13.mini_avatar_key;
        r3.G = Chat.Type.forNumber(r13.chat_type.getValue());
        r3.I = Chatter.ChatterType.forNumber(r13.chatter_type.getValue());
        r3.J = r13.chatter_id;
        r3.K = r13.is_crypto.booleanValue();
        r3.H = Chat.ChatMode.forNumber(r13.chat_mode.getValue());
        r3.L = r13.is_meeting.booleanValue();
        r3.O = g.a(r13.urgents);
        r3.y2 = r13.chat_readable.intValue();
        r3.E2 = r13.is_stranger.booleanValue();
        r3.G2 = r13.can_set_stranger.intValue();
        r3.F2 = r13.is_blocked.booleanValue();
        r3.M = r13.with_bot_tag;
        r13.bot_ext_type.intValue();
        r3.N = r13.is_agent.booleanValue();
        r3.u = r13.last_message_position.intValue();
        r3.P = r13.is_department.booleanValue();
        r3.Q = r13.is_super.booleanValue();
        r3.R = r13.tenant_chat.booleanValue();
        r3.Q1 = r13.oncall_id;
        r3.v = Message.Type.forNumber(r13.last_message_type.getValue());
        r3.w = SystemMessageType.forNumber(r13.system_message_type.getValue());
        r3.x = FeedPreviewInfo.CardContentType.forNumber(r13.card_type.getValue());
        r3.S = r13.is_public_v2.booleanValue();
        r3.T1 = r13.last_visible_message_id;
        r3.T = r13.is_official_oncall.booleanValue();
        r3.U = r13.is_offline_oncall.booleanValue();
        r3.y = FeedPreviewInfo.VideoChatContentType.forNumber(r13.video_chat_type.getValue());
        r3.S1 = r13.is_voice_call.booleanValue();
        r3.g2 = r13.is_my_threads_updated.booleanValue();
        r3.V = r13.is_cross_with_ka.booleanValue();
        r3.b1 = r13.user_count.intValue();
        r3.g1 = r13.is_user_count_visible.booleanValue();
        r3.W = r13.tags;
        r3.X = r13.tag_info;
        r3.h2 = heb.a.a.getResourceDependency().a(r13.chatter_status);
        List r18 = r13.chatter_status;
        r3.p2 = r18;
        if (r18 == null) goto L49;
        ChatterCustomStatus.Companion.getClass();
        r3.v2 = ChatterCustomStatus.a.b(r18);
    L49:
        com.bytedance.lark.pb.basic.v1.Chat.Role r19 = r13.chat_role;
        if (r19 == null) goto L52;
        r3.x2 = Chat.Role.forNumber(r19.getValue());
    L52:
        AvatarMedal r110 = r13.avatar_medal;
        if (r110 == null) goto L59;
        r3.H2 = r110.key;
        Boolean r111 = r110.show_switch;
        if (r111 == null) goto L57;
        boolean r112 = r111.booleanValue();
    L58:
        r3.I2 = r112;
        goto L59
    L57:
        r112 = false;
    L59:
        r3.J2 = r13.is_frozen.booleanValue();
        r3.h1 = TeamModelParser.a(r13.items);
        r3.k1 = i.a(r13);
        r3.p1 = ModelParserChatTeamInfo.a(r13.bound_team_infos);
        Boolean r113 = r13.muted_bot_p2p;
        if (r113 == null) goto L62;
        r6 = r113.booleanValue();
    L62:
        r3.H0 = r6;
        Boolean r114 = r13.is_p2p_ai;
        Boolean r20 = Boolean.FALSE;
        if (r114 != null) goto L66;
        Objects.requireNonNull(r20, "defaultObj");
        r114 = r20;
    L66:
        r3.v1 = r114.booleanValue();
        Boolean r115 = r13.is_p2p_official_bot_ai;
        if (r115 != null) goto L70;
        Objects.requireNonNull(r20, "defaultObj");
        r115 = r20;
    L70:
        r3.x1 = r115.booleanValue();
        r3.L1 = r13.last_has_ai_reply.booleanValue();
        r3.Q2 = r13.query_status;
        r3.R2 = r13.digest_is_query.booleanValue();
        r3.S2 = AutoMuteSettingNoticeType.forNumber(Integer.valueOf(r13.notice_type.getValue()));
        r3.T2 = r13.is_red_badge.booleanValue();
        Boolean r116 = r13.is_chat_admin;
        if (r116 != null) goto L74;
        Objects.requireNonNull(r20, "defaultObj");
        r116 = r20;
    L74:
        r3.y1 = r116.booleanValue();
        Boolean r117 = r13.is_chat_owner;
        if (r117 == null) goto L77;
        r20 = r117;
    L78:
        r3.G1 = r20.booleanValue();
        ChatNotMemberType.a r118 = ChatNotMemberType.Companion;
        ChatData.NotMemberType r21 = r13.not_member_type;
        r118.getClass();
        r3.H1 = ChatNotMemberType.a.a(r21);
    L183:
        return r3;
    L77:
        Objects.requireNonNull(r20, "defaultObj");
        goto L78
    L43:
        if (r17.booleanValue() == false) goto L45;
    L33:
        if (TextUtils.isEmpty(r15.value) == true) goto L37;
        if (r15.type != Icon.Type.IMAGE) goto L37;
        r14 = r15.value;
        goto L37
    L79:
        DocData r22 = r10.doc_data;
        if (r22 == null) goto L82;
        r3.d = FeedCard.Type.DOC;
        r3.g = r22.name;
        r3.i = r22.unread_count.intValue();
        r3.j = r22.is_remind.booleanValue();
        r3.o = r22.is_shortcut.booleanValue();
        r3.s = b.a(r22.draft_preview);
        r3.k = r22.display_time.longValue();
        r3.l = r22.rank_time.longValue();
        r3.L0 = r22.cross_tenant.booleanValue();
        r3.P0 = j.a(r22.reactions);
        r3.B = DocType.forNumber(r22.doc_type.getValue());
        r3.C = r22.doc_url;
        r3.F = r22.icon_info;
        r3.D = DocMessage.Type.forNumber(r22.doc_message_type.getValue());
        r3.E = r22.last_doc_message_id;
        r3.p0 = r22.digest;
        r3.p = b.c(r22.at_info);
        r3.X = r22.tag_info;
        goto L183
    L82:
        ThreadData r23 = r10.thread_data;
        if (r23 == null) goto L97;
        ThreadData.EntityType r119 = r23.entity_type;
        if (r119 != ThreadData.EntityType.THREAD) goto L88;
        r3.d = FeedCard.Type.THREAD;
    L93:
        r3.g = r23.name;
        r3.f = r23.avatar_key;
        r3.i = r23.unread_count.intValue();
        r3.j = r23.is_remind.booleanValue();
        r3.s = b.a(r23.draft_preview);
        r3.p = b.c(r23.at_info);
        r3.M1 = b.b(r23.at_infos);
        r3.q = r23.at_infos_count.intValue();
        r3.t = FeedPreviewInfo.EntityStatus.getSource(r23.entity_status.getValue());
        r3.k = r23.display_time.longValue();
        r3.l = r23.rank_time.longValue();
        r3.b2 = r23.chat_id;
        r3.p0 = r23.digest;
        com.bytedance.lark.pb.basic.v1.Chat.Type r120 = r23.chat_type;
        if (r120 == null) goto L96;
        r3.G = Chat.Type.forNumber(r120.getValue());
    L96:
        r3.J = r23.chatter_id;
        r3.P0 = j.a(r23.reactions);
        goto L183
    L88:
        if (r119 != ThreadData.EntityType.TOPIC) goto L91;
        r3.d = FeedCard.Type.TOPIC;
        goto L93
    L91:
        if (r119 != ThreadData.EntityType.MSG_THREAD) goto L93;
        r3.d = FeedCard.Type.MSG_THREAD;
        goto L93
    L97:
        OpenAppData r24 = r10.open_app_data;
        if (r24 == null) goto L100;
        r3.d = FeedCard.Type.APP;
        r3.g = r24.name;
        r3.f = r24.avatar_key;
        r3.i = r24.unread_count.intValue();
        r3.j = r24.is_remind.booleanValue();
        r3.o = r24.is_shortcut.booleanValue();
        r3.k = r24.display_time.longValue();
        r3.l = r24.rank_time.longValue();
        r3.p0 = r24.digest;
        goto L183
    L100:
        BoxData r25 = r10.box_data;
        if (r25 == null) goto L103;
        r3.d = FeedCard.Type.BOX;
        r3.j = r25.is_remind.booleanValue();
        r3.l = r25.rank_time.longValue();
        r3.o = r25.is_shortcut.booleanValue();
        r3.i = r25.unread_count.intValue();
        r3.k = r25.display_time.longValue();
        r3.p = b.c(r25.at_info);
        r3.M1 = b.b(r25.at_infos);
        r25.has_focus.booleanValue();
        r3.Z = r25.chatter_apply_count.intValue();
        r3.p0 = r25.digest;
        goto L183
    L103:
        SubscriptionsData r26 = r10.subscriptions_data;
        if (r26 == null) goto L107;
        r3.d = FeedCard.Type.SUBSCRIPTION;
        r3.g = r26.name;
        r3.f = r26.avatar_key;
        r3.i = r26.unread_count.intValue();
        r3.j = r26.is_remind.booleanValue();
        r3.o = r26.is_shortcut.booleanValue();
        r3.k = r26.display_time.longValue();
        r3.l = r26.rank_time.longValue();
        r3.p0 = r26.digest;
        goto L183
    L107:
        if (r10.knowledge_ai_data == null) goto L183;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r10, "pb");
        AppFeedCard r121 = r10.knowledge_ai_data;
        if (r121 == null) goto L183;
        AppFeedCard.TitleData r27 = r121.title_data;
        String r28 = BuildConfig.FLAVOR;
        if (r27 == null) goto L115;
        String r29 = r27.title;
        if (r29 == null) goto L115;
    L116:
        r3.g = r29;
        r3.d = FeedCard.Type.KNOWLEDGE_AI;
        AppFeedCard.FeedDefaultData r30 = r121.feed_default_data;
        long r31 = 0;
        if (r30 == null) goto L121;
        Long r32 = r30.rank_time;
        if (r32 == null) goto L121;
        long r33 = r32.longValue();
    L122:
        r3.l = r33;
        AppFeedCard.FeedDefaultData r34 = r121.feed_default_data;
        if (r34 == null) goto L127;
        Boolean r35 = r34.is_shortcut;
        if (r35 == null) goto L127;
        boolean r36 = r35.booleanValue();
    L128:
        r3.o = r36;
        AppFeedCard.DisplayTimeData r37 = r121.display_time_data;
        if (r37 == null) goto L133;
        Long r38 = r37.display_time_ms;
        if (r38 == null) goto L133;
        long r39 = r38.longValue();
    L134:
        r3.k = r39;
        AppFeedCard.PreviewData r40 = r121.preview_data;
        if (r40 == null) goto L137;
        Digest r41 = beb.b.a(r40);
    L138:
        r3.p0 = r41;
        AppFeedCard.AvatarData r42 = r121.avatar_data;
        if (r42 == null) goto L143;
        Image r43 = r42.avatar;
        if (r43 == null) goto L143;
        String r44 = r43.key;
    L144:
        r3.f = r44;
        AppFeedCard.BadgeData r45 = r121.badge_data;
        if (r45 == null) goto L149;
        Long r46 = r45.badge;
        if (r46 == null) goto L149;
        r31 = r46.longValue();
    L149:
        r3.i = r31;
        AppFeedCard.SettingData r47 = r121.setting_data;
        if (r47 == null) goto L156;
        Boolean r48 = r47.mute;
        if (r48 == null) goto L156;
        if (r48.booleanValue() == true) goto L156;
    L157:
        r3.j = r5;
        r3.V1 = r121.app_id.toString();
        AppFeedCard.PreviewData r49 = r121.preview_data;
        if (r49 == null) goto L161;
        AppFeedCard.PreviewStatus r50 = r49.status;
        if (r50 == null) goto L161;
    L162:
        r3.O2 = r50;
        String r51 = r121.biz_id;
        if (r51 == null) goto L166;
        r28 = r51;
    L166:
        AppFeedCardType r52 = r121.type;
        if (r52 != null) goto L169;
        r52 = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
    L169:
        AppFeedCard.ExtraData r53 = r121.biz_extra_data;
        if (r53 == null) goto L173;
        ByteString r54 = r53.extra_data;
        if (r54 == null) goto L173;
    L174:
        if (r53 == null) goto L176;
        AppFeedCard.ExtraData.BizFields r55 = r53.biz_fields;
    L177:
        r3.N2 = new com.ss.android.lark.biz.im.api.c(r52, r28, r54, r55);
        int r56 = beb.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.im.feed.feed_button") == false) goto L183;
        FeedButtonData r122 = r121.button_data;
        if (r122 == null) goto L182;
        r0 = r122.buttons;
    L182:
        r3.P2 = r0;
        goto L183
    L176:
        r55 = null;
    L173:
        r54 = ByteString.EMPTY;
    L161:
        r50 = AppFeedCard.PreviewStatus.PREVIEW_NORMAL;
    L156:
        r5 = false;
    L143:
        r44 = null;
        goto L144
    L137:
        r41 = null;
    L133:
        r39 = 0;
    L127:
        r36 = false;
    L121:
        r33 = 0;
    L115:
        r29 = BuildConfig.FLAVOR;
        goto L116
    L25:
        if (r11.booleanValue() == false) goto L27;
        r12 = true;
        goto L28
    L21:
        r9 = null;
        goto L22
    L15:
        if (r4.booleanValue() == false) goto L17;
        r7 = true;
        goto L18
    }
}
