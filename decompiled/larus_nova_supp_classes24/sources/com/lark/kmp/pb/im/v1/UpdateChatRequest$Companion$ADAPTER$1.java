package com.lark.kmp.pb.im.v1;

import com.lark.kmp.pb.basic.v1.AvatarMeta;
import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.pb.basic.v1.ChatMailSetting;
import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.s;
import com.lark.wire.t;
import com.lark.wire.w;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UpdateChatRequest$Companion$ADAPTER$1 extends ProtoAdapter<UpdateChatRequest> implements c<UpdateChatRequest> {
    public final Lazy v;

    @Override // com.lark.wire.ProtoAdapter
    public final UpdateChatRequest c(g0 r11) {
        Intrinsics.checkNotNullParameter(r11, "reader");
        UpdateChatRequest.a r1 = new UpdateChatRequest.a();
        LinkedHashMap r2 = new LinkedHashMap();
        long r3 = r11.c();
    L3:
        int r5 = r11.e();
        if (r5 == (-1)) goto L113;
        switch(r5) {
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L32;
            case 6: goto L31;
            case 7: goto L30;
            case 8: goto L29;
            case 9: goto L28;
            case 10: goto L27;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            case 14: goto L23;
            case 15: goto L22;
            case 16: goto L21;
            case 17: goto L20;
            case 18: goto L115;
            case 19: goto L15;
            case 20: goto L14;
            case 21: goto L13;
            case 22: goto L12;
            case 23: goto L11;
            case 24: goto L10;
            case 25: goto L9;
            case 26: goto L8;
            default: goto L6;
        };
    L115:
        r1.u = Chat.MessagePosition.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
    L18:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r6 = Unit.INSTANCE;
        goto L3
    L8:
        r1.C = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L9:
        r1.B = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L10:
        r1.A = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L11:
        r2.putAll((Map) ((ProtoAdapter) this.v.getValue()).c(r11));
        Unit r7 = Unit.INSTANCE;
        goto L3
    L12:
        r1.y = AvatarMeta.ADAPTER.c(r11);
        goto L3
    L13:
        r1.x = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L14:
        r1.w = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L15:
        r1.v = (Integer) ProtoAdapter.h.c(r11);
        goto L3
    L20:
        r1.t = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L21:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r1.s = r11.i();
        goto L3
    L22:
        r1.r = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L23:
        r1.q = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L24:
        r1.p = (Long) ProtoAdapter.k.c(r11);
        goto L3
    L25:
        r1.o = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L26:
        r1.n = (Long) ProtoAdapter.k.c(r11);
        goto L3
    L27:
        r1.m = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L28:
        r1.l = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L29:
        r1.k = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L30:
        r1.j = (Integer) ProtoAdapter.h.c(r11);
        goto L3
    L31:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r1.i = r11.i();
        goto L3
    L32:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r1.h = r11.i();
        goto L3
    L33:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r1.g = r11.i();
        goto L3
    L34:
        ProtoAdapter.p.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r1.f = r11.f();
        goto L3
    L35:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r1.e = r11.i();
        goto L3
    L36:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        String r8 = r11.i();
        Intrinsics.checkNotNullParameter(r8, "chat_id");
        r1.d = r8;
        goto L3
    L6:
        switch(r5) {
            case 100: goto L117;
            case 101: goto L119;
            case 102: goto L121;
            case 103: goto L127;
            case 104: goto L133;
            case 105: goto L139;
            case 106: goto L88;
            case 107: goto L123;
            case 108: goto L129;
            case 109: goto L135;
            case 110: goto L141;
            case 111: goto L147;
            case 112: goto L149;
            case 113: goto L151;
            case 114: goto L59;
            case 115: goto L143;
            case 116: goto L54;
            case 117: goto L125;
            case 118: goto L131;
            case 119: goto L137;
            case 120: goto L145;
            case 121: goto L37;
            default: goto L7;
        };
    L117:
        r1.D = Chat.AddMemberPermission.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L111
    L111:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r9 = Unit.INSTANCE;
        goto L3
    L119:
        r1.E = Chat.AtAllPermission.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L107
    L107:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r10 = Unit.INSTANCE;
        goto L3
    L121:
        r1.F = Chat.SystemMessageVisible.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L103
    L103:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r12 = Unit.INSTANCE;
        goto L3
    L123:
        r1.K = ChatMailSetting.SendPermission.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L86
    L86:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r13 = Unit.INSTANCE;
        goto L3
    L125:
        r1.U = Chat.DefDisplaySetting.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L52
    L52:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r14 = Unit.INSTANCE;
        goto L3
    L127:
        r1.G = Chat.SystemMessageVisible.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L99
    L99:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r15 = Unit.INSTANCE;
        goto L3
    L129:
        r1.L = Chat.AnonymousSetting.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L82
    L82:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r16 = Unit.INSTANCE;
        goto L3
    L131:
        r1.V = Chat.ChatDisplayModeSetting.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L48
    L48:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r17 = Unit.INSTANCE;
        goto L3
    L133:
        r1.H = Chat.ShareCardPermission.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L95
    L95:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r19 = Unit.INSTANCE;
        goto L3
    L135:
        r1.M = Chat.MessageVisibilitySetting.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L78
    L78:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r20 = Unit.INSTANCE;
        goto L3
    L137:
        r1.W = Chat.ChatPinPermissionSetting.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L44
    L44:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r21 = Unit.INSTANCE;
        goto L3
    L139:
        r1.I = Chat.AddMemberApply.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L91
    L91:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r22 = Unit.INSTANCE;
        goto L3
    L141:
        r1.N = Chat.CreateUrgentSetting.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L74
    L74:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r23 = Unit.INSTANCE;
        goto L3
    L143:
        r1.S = Chat.ChatTabPermissionSetting.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L57
    L57:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r24 = Unit.INSTANCE;
        goto L3
    L145:
        r1.X = Chat.UserCountVisibleSetting.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L40
    L40:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r25 = Unit.INSTANCE;
        goto L3
    L147:
        r1.O = Chat.CreateVideoConferenceSetting.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L70
    L70:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r26 = Unit.INSTANCE;
        goto L3
    L149:
        r1.P = Chat.PinPermissionSetting.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L66
    L66:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r27 = Unit.INSTANCE;
        goto L3
    L151:
        r1.Q = Chat.TopNoticePermissionSetting.Enum.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L62
    L62:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r29 = Unit.INSTANCE;
        goto L3
    L37:
        r1.Y = Chat.DoubaoSetting.ADAPTER.c(r11);
        goto L3
    L54:
        r1.T = Chat.RestrictedModeSetting.ADAPTER.c(r11);
        goto L3
    L59:
        r1.R = Chat.TypingTranslateSetting.ADAPTER.c(r11);
        goto L3
    L88:
        r1.J = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L7:
        r11.j(r5);
        Unit r30 = Unit.INSTANCE;
        goto L3
    L113:
        ByteString r110 = r11.d(r3);
        Intrinsics.checkNotNullParameter(r2, "patch_chatter_extra_states");
        r1.z = r2;
        return new UpdateChatRequest(r1, r110, null);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(UpdateChatRequest r8) {
        UpdateChatRequest r9 = r8;
        Intrinsics.checkNotNullParameter(r9, "value");
        int r0 = r9.unknownFields().size();
        w r1 = ProtoAdapter.q;
        int r2 = (((((r0 + r1.l(1, r9.getChat_id())) + r1.l(2, r9.getName())) + ProtoAdapter.p.l(3, r9.getIcon_data())) + r1.l(4, r9.getDescription())) + r1.l(5, r9.getAnnouncement())) + r1.l(6, r9.getOwner_id());
        s r3 = ProtoAdapter.h;
        int r4 = r2 + r3.l(7, r9.getChatter_count());
        l r5 = ProtoAdapter.g;
        int r6 = ((r4 + r5.l(8, r9.is_archive())) + r5.l(9, r9.is_public())) + r5.l(10, r9.is_inner());
        t r7 = ProtoAdapter.k;
        int r10 = (((((((((((((((((r6 + r7.l(11, r9.getOrganization_id())) + r5.l(12, r9.is_group_companies())) + r7.l(13, r9.getGroup_companies_id())) + r5.l(14, r9.is_remind())) + r5.l(15, r9.getOff_edit_info())) + r1.l(16, r9.getIcon_key())) + r5.l(17, r9.is_dissolved())) + Chat.MessagePosition.Enum.ADAPTER.l(18, r9.getMessage_position())) + r3.l(19, r9.getBurn_life())) + r5.l(20, r9.is_auto_translate())) + r5.l(21, r9.is_public_v2())) + AvatarMeta.ADAPTER.l(22, r9.getAvatar_meta())) + ((ProtoAdapter) this.v.getValue()).l(23, r9.getPatch_chatter_extra_states())) + r5.l(24, r9.is_mute_at_all())) + r5.l(25, r9.is_delayed())) + r5.l(26, r9.is_frozen())) + Chat.AddMemberPermission.Enum.ADAPTER.l(100, r9.getAdd_member_permission())) + Chat.AtAllPermission.Enum.ADAPTER.l(101, r9.getAt_all_permission());
        ProtoAdapter<Chat.SystemMessageVisible.Enum> r11 = Chat.SystemMessageVisible.Enum.ADAPTER;
        return (((((((((((((((((((r10 + r11.l(102, r9.getJoin_message_visible())) + r11.l(103, r9.getQuit_message_visible())) + Chat.ShareCardPermission.Enum.ADAPTER.l(104, r9.getShare_card_permission())) + Chat.AddMemberApply.Enum.ADAPTER.l(105, r9.getAdd_member_apply())) + r5.l(106, r9.getAllow_mail_send())) + ChatMailSetting.SendPermission.ADAPTER.l(107, r9.getMail_send_permission())) + Chat.AnonymousSetting.Enum.ADAPTER.l(108, r9.getAnonymous_setting())) + Chat.MessageVisibilitySetting.Enum.ADAPTER.l(109, r9.getMessage_visibility_setting())) + Chat.CreateUrgentSetting.Enum.ADAPTER.l(110, r9.getCreate_urgent_setting())) + Chat.CreateVideoConferenceSetting.Enum.ADAPTER.l(111, r9.getCreate_video_conference_setting())) + Chat.PinPermissionSetting.Enum.ADAPTER.l(112, r9.getPin_permission_setting())) + Chat.TopNoticePermissionSetting.Enum.ADAPTER.l(113, r9.getTop_notice_permission_setting())) + Chat.TypingTranslateSetting.ADAPTER.l(114, r9.getTyping_translate_setting())) + Chat.ChatTabPermissionSetting.Enum.ADAPTER.l(115, r9.getChat_tab_permission_setting())) + Chat.RestrictedModeSetting.ADAPTER.l(116, r9.getRestricted_mode_setting())) + Chat.DefDisplaySetting.Enum.ADAPTER.l(117, r9.getDef_display_setting())) + Chat.ChatDisplayModeSetting.Enum.ADAPTER.l(118, r9.getChat_display_mode_setting())) + Chat.ChatPinPermissionSetting.Enum.ADAPTER.l(119, r9.getChat_pin_permission_setting())) + Chat.UserCountVisibleSetting.Enum.ADAPTER.l(120, r9.getUser_count_visible_setting())) + Chat.DoubaoSetting.ADAPTER.l(121, r9.getDoubao_setting());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r7, UpdateChatRequest r8) {
        UpdateChatRequest r9 = r8;
        Intrinsics.checkNotNullParameter(r7, "writer");
        Intrinsics.checkNotNullParameter(r9, "value");
        w r0 = ProtoAdapter.q;
        r0.i(r7, 1, r9.getChat_id());
        r0.i(r7, 2, r9.getName());
        ProtoAdapter.p.i(r7, 3, r9.getIcon_data());
        r0.i(r7, 4, r9.getDescription());
        r0.i(r7, 5, r9.getAnnouncement());
        r0.i(r7, 6, r9.getOwner_id());
        s r1 = ProtoAdapter.h;
        r1.i(r7, 7, r9.getChatter_count());
        l r2 = ProtoAdapter.g;
        r2.i(r7, 8, r9.is_archive());
        r2.i(r7, 9, r9.is_public());
        r2.i(r7, 10, r9.is_inner());
        t r3 = ProtoAdapter.k;
        r3.i(r7, 11, r9.getOrganization_id());
        r2.i(r7, 12, r9.is_group_companies());
        r3.i(r7, 13, r9.getGroup_companies_id());
        r2.i(r7, 14, r9.is_remind());
        r2.i(r7, 15, r9.getOff_edit_info());
        r0.i(r7, 16, r9.getIcon_key());
        r2.i(r7, 17, r9.is_dissolved());
        Chat.MessagePosition.Enum.ADAPTER.i(r7, 18, r9.getMessage_position());
        r1.i(r7, 19, r9.getBurn_life());
        r2.i(r7, 20, r9.is_auto_translate());
        r2.i(r7, 21, r9.is_public_v2());
        AvatarMeta.ADAPTER.i(r7, 22, r9.getAvatar_meta());
        ((ProtoAdapter) this.v.getValue()).i(r7, 23, r9.getPatch_chatter_extra_states());
        r2.i(r7, 24, r9.is_mute_at_all());
        r2.i(r7, 25, r9.is_delayed());
        r2.i(r7, 26, r9.is_frozen());
        Chat.AddMemberPermission.Enum.ADAPTER.i(r7, 100, r9.getAdd_member_permission());
        Chat.AtAllPermission.Enum.ADAPTER.i(r7, 101, r9.getAt_all_permission());
        ProtoAdapter<Chat.SystemMessageVisible.Enum> r4 = Chat.SystemMessageVisible.Enum.ADAPTER;
        r4.i(r7, 102, r9.getJoin_message_visible());
        r4.i(r7, 103, r9.getQuit_message_visible());
        Chat.ShareCardPermission.Enum.ADAPTER.i(r7, 104, r9.getShare_card_permission());
        Chat.AddMemberApply.Enum.ADAPTER.i(r7, 105, r9.getAdd_member_apply());
        r2.i(r7, 106, r9.getAllow_mail_send());
        ChatMailSetting.SendPermission.ADAPTER.i(r7, 107, r9.getMail_send_permission());
        Chat.AnonymousSetting.Enum.ADAPTER.i(r7, 108, r9.getAnonymous_setting());
        Chat.MessageVisibilitySetting.Enum.ADAPTER.i(r7, 109, r9.getMessage_visibility_setting());
        Chat.CreateUrgentSetting.Enum.ADAPTER.i(r7, 110, r9.getCreate_urgent_setting());
        Chat.CreateVideoConferenceSetting.Enum.ADAPTER.i(r7, 111, r9.getCreate_video_conference_setting());
        Chat.PinPermissionSetting.Enum.ADAPTER.i(r7, 112, r9.getPin_permission_setting());
        Chat.TopNoticePermissionSetting.Enum.ADAPTER.i(r7, 113, r9.getTop_notice_permission_setting());
        Chat.TypingTranslateSetting.ADAPTER.i(r7, 114, r9.getTyping_translate_setting());
        Chat.ChatTabPermissionSetting.Enum.ADAPTER.i(r7, 115, r9.getChat_tab_permission_setting());
        Chat.RestrictedModeSetting.ADAPTER.i(r7, 116, r9.getRestricted_mode_setting());
        Chat.DefDisplaySetting.Enum.ADAPTER.i(r7, 117, r9.getDef_display_setting());
        Chat.ChatDisplayModeSetting.Enum.ADAPTER.i(r7, 118, r9.getChat_display_mode_setting());
        Chat.ChatPinPermissionSetting.Enum.ADAPTER.i(r7, 119, r9.getChat_pin_permission_setting());
        Chat.UserCountVisibleSetting.Enum.ADAPTER.i(r7, 120, r9.getUser_count_visible_setting());
        Chat.DoubaoSetting.ADAPTER.i(r7, 121, r9.getDoubao_setting());
        r7.a(r9.unknownFields());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r7, UpdateChatRequest r8) {
        UpdateChatRequest r9 = r8;
        Intrinsics.checkNotNullParameter(r7, "writer");
        Intrinsics.checkNotNullParameter(r9, "value");
        r7.d(r9.unknownFields());
        Chat.DoubaoSetting.ADAPTER.j(r7, 121, r9.getDoubao_setting());
        Chat.UserCountVisibleSetting.Enum.ADAPTER.j(r7, 120, r9.getUser_count_visible_setting());
        Chat.ChatPinPermissionSetting.Enum.ADAPTER.j(r7, 119, r9.getChat_pin_permission_setting());
        Chat.ChatDisplayModeSetting.Enum.ADAPTER.j(r7, 118, r9.getChat_display_mode_setting());
        Chat.DefDisplaySetting.Enum.ADAPTER.j(r7, 117, r9.getDef_display_setting());
        Chat.RestrictedModeSetting.ADAPTER.j(r7, 116, r9.getRestricted_mode_setting());
        Chat.ChatTabPermissionSetting.Enum.ADAPTER.j(r7, 115, r9.getChat_tab_permission_setting());
        Chat.TypingTranslateSetting.ADAPTER.j(r7, 114, r9.getTyping_translate_setting());
        Chat.TopNoticePermissionSetting.Enum.ADAPTER.j(r7, 113, r9.getTop_notice_permission_setting());
        Chat.PinPermissionSetting.Enum.ADAPTER.j(r7, 112, r9.getPin_permission_setting());
        Chat.CreateVideoConferenceSetting.Enum.ADAPTER.j(r7, 111, r9.getCreate_video_conference_setting());
        Chat.CreateUrgentSetting.Enum.ADAPTER.j(r7, 110, r9.getCreate_urgent_setting());
        Chat.MessageVisibilitySetting.Enum.ADAPTER.j(r7, 109, r9.getMessage_visibility_setting());
        Chat.AnonymousSetting.Enum.ADAPTER.j(r7, 108, r9.getAnonymous_setting());
        ChatMailSetting.SendPermission.ADAPTER.j(r7, 107, r9.getMail_send_permission());
        l r0 = ProtoAdapter.g;
        r0.j(r7, 106, r9.getAllow_mail_send());
        Chat.AddMemberApply.Enum.ADAPTER.j(r7, 105, r9.getAdd_member_apply());
        Chat.ShareCardPermission.Enum.ADAPTER.j(r7, 104, r9.getShare_card_permission());
        ProtoAdapter<Chat.SystemMessageVisible.Enum> r1 = Chat.SystemMessageVisible.Enum.ADAPTER;
        r1.j(r7, 103, r9.getQuit_message_visible());
        r1.j(r7, 102, r9.getJoin_message_visible());
        Chat.AtAllPermission.Enum.ADAPTER.j(r7, 101, r9.getAt_all_permission());
        Chat.AddMemberPermission.Enum.ADAPTER.j(r7, 100, r9.getAdd_member_permission());
        r0.j(r7, 26, r9.is_frozen());
        r0.j(r7, 25, r9.is_delayed());
        r0.j(r7, 24, r9.is_mute_at_all());
        ((ProtoAdapter) this.v.getValue()).j(r7, 23, r9.getPatch_chatter_extra_states());
        AvatarMeta.ADAPTER.j(r7, 22, r9.getAvatar_meta());
        r0.j(r7, 21, r9.is_public_v2());
        r0.j(r7, 20, r9.is_auto_translate());
        s r2 = ProtoAdapter.h;
        r2.j(r7, 19, r9.getBurn_life());
        Chat.MessagePosition.Enum.ADAPTER.j(r7, 18, r9.getMessage_position());
        r0.j(r7, 17, r9.is_dissolved());
        w r3 = ProtoAdapter.q;
        r3.j(r7, 16, r9.getIcon_key());
        r0.j(r7, 15, r9.getOff_edit_info());
        r0.j(r7, 14, r9.is_remind());
        t r4 = ProtoAdapter.k;
        r4.j(r7, 13, r9.getGroup_companies_id());
        r0.j(r7, 12, r9.is_group_companies());
        r4.j(r7, 11, r9.getOrganization_id());
        r0.j(r7, 10, r9.is_inner());
        r0.j(r7, 9, r9.is_public());
        r0.j(r7, 8, r9.is_archive());
        r2.j(r7, 7, r9.getChatter_count());
        r3.j(r7, 6, r9.getOwner_id());
        r3.j(r7, 5, r9.getAnnouncement());
        r3.j(r7, 4, r9.getDescription());
        ProtoAdapter.p.j(r7, 3, r9.getIcon_data());
        r3.j(r7, 2, r9.getName());
        r3.j(r7, 1, r9.getChat_id());
    }

    public UpdateChatRequest$Companion$ADAPTER$1(FieldEncoding r7, KClass<UpdateChatRequest> r8, Syntax r9) {
        super(r7, r8, "type.googleapis.com/im.v1.UpdateChatRequest", r9, null);
        this.v = LazyKt.lazy(UpdateChatRequest$Companion$ADAPTER$1$patch_chatter_extra_statesAdapter$2.INSTANCE);
    }
}
