package com.ss.android.lark.flow.feed.cell.chat;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.AvatarMedal;
import com.bytedance.lark.pb.basic.v1.Icon;
import com.bytedance.lark.pb.feed.v1.ChatData;
import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import com.bytedance.lark.pb.feed.v1.FocusInfo;
import com.ss.android.lark.biz.im.api.ChatNotMemberType;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.feed.app.entity.AutoMuteSettingNoticeType;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.f;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.feed.shared.data.utils.g;
import com.ss.android.lark.feed.shared.data.utils.i;
import com.ss.android.lark.feed.shared.data.utils.j;
import com.ss.android.lark.parser.internal.ModelParserChatTeamInfo;
import com.ss.android.lark.team.parser.TeamModelParser;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements f {
    public final leb.c a;

    public d() {
        this.a = new leb.c();
    }

    public final FeedPreviewInfo a(FeedEntityPreview r6) {
        Intrinsics.checkNotNullParameter(r6, "pbFeed");
        FeedPreviewInfo r0 = beb.b.c(r6);
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r6, "pb");
        ChatData r7 = r6.chat_data;
        r0.d = FeedCard.Type.CHAT;
        r0.g = r7.name;
        String r1 = r7.avatar_key;
        Icon r2 = r7.icon;
        if (r2 != null) goto L5;
    L9:
        r0.f = r1;
        FocusInfo r3 = r7.focus_info;
        if (r3 == null) goto L14;
        Long r4 = r3.message_id;
        if (r4 == null) goto L14;
        r0.Y = new com.ss.android.lark.biz.im.api.FocusInfo(r4.longValue());
    L14:
        r0.Z = r7.chatter_apply_count.intValue();
        Boolean r5 = r7.is_special_focus;
        boolean r8 = false;
        if (r5 != null) goto L17;
    L19:
        boolean r9 = false;
    L20:
        r0.k0 = r9;
        r0.p0 = r7.digest;
        r0.i = r7.unread_count.intValue();
        r0.j = r7.is_remind.booleanValue();
        r0.o = r7.is_shortcut.booleanValue();
        r0.s = com.ss.android.lark.feed.shared.data.utils.b.a(r7.draft_preview);
        r0.p = com.ss.android.lark.feed.shared.data.utils.b.c(r7.at_info);
        r0.M1 = com.ss.android.lark.feed.shared.data.utils.b.b(r7.at_infos);
        r0.q = r7.at_infos_count.intValue();
        r0.r = com.ss.android.lark.feed.shared.data.utils.b.d(r7.urgent_info);
        r0.t = FeedPreviewInfo.EntityStatus.getSource(r7.entity_status.getValue());
        r0.k = r7.display_time.longValue();
        r0.l = r7.rank_time.longValue();
        r0.L0 = r7.cross_tenant.booleanValue();
        r0.P0 = j.a(r7.reactions);
        r0.n = r7.do_not_disturb_end_time.longValue();
        r0.V0 = r7.mini_avatar_key;
        r0.G = Chat.Type.forNumber(r7.chat_type.getValue());
        r0.I = Chatter.ChatterType.forNumber(r7.chatter_type.getValue());
        r0.J = r7.chatter_id;
        r0.K = r7.is_crypto.booleanValue();
        r0.H = Chat.ChatMode.forNumber(r7.chat_mode.getValue());
        r0.L = r7.is_meeting.booleanValue();
        r0.O = g.a(r7.urgents);
        r0.y2 = r7.chat_readable.intValue();
        r0.E2 = r7.is_stranger.booleanValue();
        r0.G2 = r7.can_set_stranger.intValue();
        r0.F2 = r7.is_blocked.booleanValue();
        r0.M = r7.with_bot_tag;
        r7.bot_ext_type.intValue();
        r0.N = r7.is_agent.booleanValue();
        r0.u = r7.last_message_position.intValue();
        r0.P = r7.is_department.booleanValue();
        r0.Q = r7.is_super.booleanValue();
        r0.R = r7.tenant_chat.booleanValue();
        r0.Q1 = r7.oncall_id;
        r0.v = Message.Type.forNumber(r7.last_message_type.getValue());
        r0.w = SystemMessageType.forNumber(r7.system_message_type.getValue());
        r0.x = FeedPreviewInfo.CardContentType.forNumber(r7.card_type.getValue());
        r0.S = r7.is_public_v2.booleanValue();
        r0.T1 = r7.last_visible_message_id;
        r0.T = r7.is_official_oncall.booleanValue();
        r0.U = r7.is_offline_oncall.booleanValue();
        r0.y = FeedPreviewInfo.VideoChatContentType.forNumber(r7.video_chat_type.getValue());
        r0.S1 = r7.is_voice_call.booleanValue();
        r0.g2 = r7.is_my_threads_updated.booleanValue();
        r0.V = r7.is_cross_with_ka.booleanValue();
        r0.b1 = r7.user_count.intValue();
        r0.g1 = r7.is_user_count_visible.booleanValue();
        r0.W = r7.tags;
        r0.X = r7.tag_info;
        r0.h2 = heb.a.a.getResourceDependency().a(r7.chatter_status);
        List r10 = r7.chatter_status;
        r0.p2 = r10;
        if (r10 == null) goto L23;
        ChatterCustomStatus.Companion.getClass();
        r0.v2 = ChatterCustomStatus.a.b(r10);
    L23:
        com.bytedance.lark.pb.basic.v1.Chat.Role r11 = r7.chat_role;
        if (r11 == null) goto L26;
        r0.x2 = Chat.Role.forNumber(r11.getValue());
    L26:
        AvatarMedal r12 = r7.avatar_medal;
        if (r12 == null) goto L29;
        r0.H2 = r12.key;
        r0.I2 = Intrinsics.areEqual(r12.show_switch, Boolean.TRUE);
    L29:
        r0.J2 = r7.is_frozen.booleanValue();
        r0.h1 = TeamModelParser.a(r7.items);
        r0.k1 = i.a(r7);
        r0.p1 = ModelParserChatTeamInfo.a(r7.bound_team_infos);
        Boolean r13 = r7.muted_bot_p2p;
        if (r13 == null) goto L32;
        boolean r14 = r13.booleanValue();
    L33:
        r0.H0 = r14;
        Boolean r15 = r7.is_p2p_ai;
        if (r15 == null) goto L36;
        boolean r16 = r15.booleanValue();
    L37:
        r0.v1 = r16;
        Boolean r17 = r7.is_p2p_official_bot_ai;
        if (r17 == null) goto L40;
        r8 = r17.booleanValue();
    L40:
        r0.x1 = r8;
        r0.L1 = r7.last_has_ai_reply.booleanValue();
        r0.Q2 = r7.query_status;
        r0.R2 = r7.digest_is_query.booleanValue();
        r0.S2 = AutoMuteSettingNoticeType.Companion.forNumber(Integer.valueOf(r7.notice_type.getValue()));
        r0.T2 = r7.is_red_badge.booleanValue();
        r0.y1 = Intrinsics.areEqual(r7.is_chat_admin, Boolean.TRUE);
        r0.G1 = r7.is_chat_owner.booleanValue();
        ChatNotMemberType.a r18 = ChatNotMemberType.Companion;
        ChatData.NotMemberType r19 = r7.not_member_type;
        r18.getClass();
        r0.H1 = ChatNotMemberType.a.a(r19);
        return r0;
    L36:
        r16 = false;
        goto L37
    L32:
        r14 = false;
        goto L33
    L17:
        if (r5.booleanValue() == false) goto L19;
        r9 = true;
        goto L20
    L5:
        if (TextUtils.isEmpty(r2.value) == true) goto L9;
        if (r2.type != Icon.Type.IMAGE) goto L9;
        r1 = r2.value;
        goto L9
    }

    public final UIFeedCard b(FeedPreviewInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "feedPreviewInfo");
        Object r4 = this.a.e(r3);
        ((ChatFeedPreview) r4).setReactionDisplayCount(6);
        return (UIFeedCard) r4;
    }

    public final boolean c(FeedEntityPreview r2) {
        Intrinsics.checkNotNullParameter(r2, "pbFeed");
        if (r2.chat_data == null) goto L5;
        return true;
    L5:
        return false;
    }
}
