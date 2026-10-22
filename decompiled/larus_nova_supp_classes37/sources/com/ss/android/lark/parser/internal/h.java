package com.ss.android.lark.parser.internal;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.BannerSetting;
import com.bytedance.lark.pb.basic.v1.BotAutoMuteConfig;
import com.bytedance.lark.pb.basic.v1.BotTipsContent;
import com.bytedance.lark.pb.basic.v1.ChatMailSetting;
import com.bytedance.lark.pb.basic.v1.ChatOptionInfo;
import com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting;
import com.bytedance.lark.pb.basic.v1.MediaContent;
import com.bytedance.lark.pb.basic.v1.SideBarButton;
import com.bytedance.lark.pb.basic.v1.TnsBlockedFeature;
import com.bytedance.lark.pb.basic.v1.TnsOpKind;
import com.bytedance.lark.pb.basic.v1.TnsSystemBannedInfo;
import com.bytedance.lark.pb.media.v1.GetChatResourcesResponse;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ExtraConfig;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.entity.chat.AutoMuteConfig;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatAnnouncement;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.chat.ChatTnsBlockedFeature;
import com.ss.android.lark.chat.entity.chat.ChatTnsInfo;
import com.ss.android.lark.chat.entity.chat.ChatTnsSystemBannedInfo;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public static MediaExtra b(GetChatResourcesResponse.Resource.MediaMeta r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        MediaContent r1 = r4.media_content;
        if (r1 == null) goto L9;
        MediaExtra r0 = new MediaExtra();
        r0.setKey(r1.key);
        r0.setUrl(r1.url);
        r0.setSize(r1.size.longValue());
        r0.setFilePath(r4.file_path);
        r0.setMime(r1.mime);
        r0.setDuration(r1.duration.intValue());
        return r0;
    L9:
        return null;
    }

    public static OpenApp c(com.bytedance.lark.pb.basic.v1.OpenApp r5) {
        OpenApp r0 = new OpenApp();
        r0.setAppId(r5.app_id);
        r0.setAvatarKey(r5.avatar_key);
        r0.setBotId(r5.bot_id);
        BotTipsContent r1 = r5.bot_tips;
        if (r1 == null) goto L5;
        r0.setBotTips(new com.ss.android.lark.biz.im.api.BotTipsContent(r1.i18n_msg, r1.admin_id, r1.i18n_admin_name));
    L5:
        r0.setDesc(r5.i18n_desc);
        r0.setId(r5.id);
        r0.setLastHappen(r5.last_happen);
        r0.setName(r5.i18n_name);
        r0.setState(OpenApp.State.fromValue(r5.state.getValue()));
        r0.setTips(r5.tips);
        r0.setVersion(r5.version);
        r0.setChatable(OpenApp.Chatable.fromValue(r5.chatable.getValue()));
        com.bytedance.lark.pb.basic.v1.OpenApp.BotMenuDisplayStrategy r2 = r5.bot_menu_display_strategy;
        if (r2 == null) goto L8;
        r0.setBotMenuDisplayStrategy(OpenApp.BotMenuDisplayStrategy.fromValue(r2.getValue()));
    L17:
        ExtraConfig r3 = (ExtraConfig) GsonProtectorUtils.fromJson(new Gson(), r5.extra_config, ExtraConfig.class);     // Catch: JsonSyntaxException -> L11
    L12:
        r0.setExtraConfig(r3);
        Boolean r6 = r5.can_edit;
        if (r6 == null) goto L15;
        r0.setCanEdit(r6);
    L16:
        return r0;
    L15:
        r0.setCanEdit(Boolean.FALSE);
    L11:
        r3 = new ExtraConfig();
        goto L12
    L8:
        r0.setBotMenuDisplayStrategy(OpenApp.BotMenuDisplayStrategy.MENU_UNKNOWN);
        goto L17
    }

    public static Chat a(com.bytedance.lark.pb.basic.v1.Chat r13, Map<String, ChatMailSetting> r14) {
        ChatTnsInfo r0 = null;
        if (r13 != null) goto L5;
        return null;
    L5:
        Chat r1 = new Chat();
        r1.setId(r13.id);
        String r4 = "";
        if (r13.type != com.bytedance.lark.pb.basic.v1.Chat.Type.P2P) goto L8;
        String r2 = r13.chatter_id;
    L9:
        r1.setKey(r2);
        r1.setName(r13.name);
        r1.setDescription(r13.description);
        ChatAnnouncement r3 = new ChatAnnouncement();
        r3.setChatId(r13.id);
        com.bytedance.lark.pb.basic.v1.Chat.Announcement r5 = r13.announcement;
        boolean r6 = false;
        if (r5 != null) goto L13;
    L14:
        String r7 = "";
    L16:
        r3.setContent(r7);
        com.bytedance.lark.pb.basic.v1.Chat.Announcement r8 = r13.announcement;
        if (r8 != null) goto L19;
        long r9 = 0;
    L20:
        r3.setUpdateTime(r9);
        com.bytedance.lark.pb.basic.v1.Chat.Announcement r10 = r13.announcement;
        if (r10 != null) goto L23;
        String r11 = "";
    L24:
        r3.setLastEditorId(r11);
        com.bytedance.lark.pb.basic.v1.Chat.Announcement r12 = r13.announcement;
        if (r12 != null) goto L27;
        String r15 = "";
    L28:
        r3.setDocUrl(r15);
        if (TextUtils.isEmpty(r3.getDocUrl()) == true) goto L31;
        r4 = r3.getDocUrl() + "?open_type=announce&chat_id=" + r13.id + "&from=group_announcement";
    L31:
        r3.setAnnounceUrl(r4);
        com.bytedance.lark.pb.basic.v1.Chat.Announcement r16 = r13.announcement;
        if (r16 != null) goto L34;
        boolean r17 = false;
    L35:
        r3.setUseOpenDoc(r17);
        r1.setChatAnnouncement(r3);
        r1.setLastMessageId(r13.last_message_id);
        r1.setAutoTranslate(r13.is_auto_translate.booleanValue());
        com.bytedance.lark.pb.basic.v1.Chat.TopNoticePermissionSetting.Enum r18 = r13.top_notice_permission_setting;
        if (r18 == null) goto L38;
        r1.setTopNoticePermissionSetting(Chat.TopNoticePermissionSetting.fromValue(r18.getValue()));
    L38:
        r1.setMemberCount(Math.max(r13.chatter_count.intValue(), r13.user_count.intValue()));
        r1.setOwnerId(r13.owner_id);
        r1.setType(Chat.Type.valueOf(r13.type.getValue()));
        r1.setAvatarKey(r13.avatar_key);
        r1.setUpdateTime(r13.update_time.longValue());
        r1.setIs_department(r13.is_department.booleanValue());
        r1.setIs_public(r13.is_public.booleanValue());
        r1.setLastMessagePosition(r13.last_message_position.intValue());
        int r19 = r13.first_message_position.intValue();
        Chat.ChatMode r20 = Chat.ChatMode.forNumber(r13.chat_mode.getValue());
        BannerSetting r21 = r13.banner_setting;
        int r22 = f.a;
        if (r21 != null) goto L41;
        com.ss.android.lark.chat.entity.chat.BannerSetting r23 = null;
    L42:
        if (r23 != null) goto L44;
    L55:
        r1.setFirstMessagePosition(r19);
        r1.setUserCount(r13.user_count.intValue());
        r1.setUserCountVisible(r13.is_user_count_visible.booleanValue());
        r1.setNamePinyin(r13.name_pinyin);
        r1.setMeeting(r13.is_meeting.booleanValue());
        r1.setIsOcicService(r13.is_ocic_customer_service.booleanValue());
        r1.setSecret(r13.is_crypto.booleanValue());
        r1.setBurnLife(r13.burn_life.intValue());
        r1.setCrossTenant(r13.is_cross_tenant.booleanValue());
        r1.setCrossWithKa(r13.is_cross_with_ka.booleanValue());
        r1.setTenantId(r13.tenant_id);
        r1.setHasWatermark(r13.has_water_mark.booleanValue());
        r1.setTextDraftId(r13.text_draft_id);
        r1.setPostDraftId(r13.post_draft_id);
        r1.setReEditDraftId(r13.edit_message_draft_id);
        r1.setScheduleDraftId(r13.schedule_message_draft_id);
        Chat.Status r24 = Chat.Status.NORMAL;
        if (r13.is_archived.booleanValue() == false) goto L59;
        r24 = Chat.Status.ARCHIVE;
    L61:
        r1.setStatus(r24);
        r1.setP2pChatterId(r13.chatter_id);
        r1.setRemind(r13.is_remind.booleanValue());
        r1.setRole(Chat.Role.forNumber(r13.role.getValue()));
        r1.setIsCustomAvatar(r13.is_custom_icon.booleanValue());
        r1.setSuper(r13.is_super.booleanValue());
        r1.setTenant(r13.is_tenant.booleanValue());
        r1.setCustomerService(r13.is_customer_service.booleanValue());
        r1.setOnlyOwnerEditGroupInfo(r13.off_edit_group_chat_info.booleanValue());
        r1.setDissolved(r13.is_dissolved.booleanValue());
        r1.setMessagePosition(Chat.MessagePosition.forNumber(r13.message_position.getValue()));
        r1.setAddMemberPermission(Chat.AddMemberPermission.forNumber(r13.add_member_permission.getValue()));
        r1.setAtAllPermission(Chat.AtAllPermission.forNumber(r13.at_all_permission.getValue()));
        r1.setJoinMessageVisible(Chat.SystemMessageVisible.forNumber(r13.join_message_visible.getValue()));
        r1.setQuitMessageVisible(Chat.SystemMessageVisible.forNumber(r13.quit_message_visible.getValue()));
        r1.setShareCardPermission(Chat.ShareCardPermission.forNumber(r13.share_card_permission.getValue()));
        r1.setChatable(r13.chatable.booleanValue());
        r1.setMuteable(r13.muteable.booleanValue());
        r1.setTenant(r13.is_tenant.booleanValue());
        r1.setRecentReadPosition(r13.last_read_position.intValue());
        r1.setRecentReadOffset(r13.last_read_offset.floatValue());
        r1.setInBox(r13.is_in_box.booleanValue());
        r1.setOnCallId(r13.oncall_id);
        r1.setLastVisibleMessagePosition(r13.last_visible_message_position.intValue());
        r1.setLastVisibleMessageId(r13.last_visible_message_id);
        r1.setReadPosition(r13.read_position.intValue());
        r1.setReadPositionBadgeCount(r13.read_position_badge_count.intValue());
        r1.setLastMessagePositionBadgeCount(r13.last_message_position_badge_count.intValue());
        r1.setPublic(r13.is_public_v2.booleanValue());
        r1.setOfficialOncall(r13.is_official_oncall.booleanValue());
        r1.setOfflineOncall(r13.is_offline_oncall);
        r1.setShotCut(r13.is_shortcut.booleanValue());
        r1.setChatMode(r20);
        r1.setLastThreadId(r13.last_thread_id);
        r1.setLastThreadPosition(r13.last_thread_position.intValue());
        r1.setLastThreadPositionBadgeCount(r13.last_thread_position_badge_count.intValue());
        r1.setReadThreadPosition(r13.read_thread_position.intValue());
        r1.setReadThreadPositionBadgeCount(r13.read_thread_position_badge_count.intValue());
        r1.setLastVisibleThreadPosition(r13.last_visible_thread_position.intValue());
        r1.setLastVisibleThreadId(r13.last_visible_thread_id);
        r1.setAllowPost(r13.allow_post.booleanValue());
        r1.setPutChatterApplyCount(r13.put_chatter_apply_count.intValue());
        r1.setShowApplyBanner(r13.show_banner.booleanValue());
        r1.setAddMemberApply(Chat.AddMemberApply.forNumber(r13.add_member_apply.getValue()));
        r1.setPostType(Chat.PostType.forNumber(r13.post_type.getValue()));
        r1.setLastDraftId(r13.last_draft_id);
        r1.setMiniAvatarKey(r13.mini_avatar_key);
        r1.setSideBarId(r13.sidebar_id);
        List r25 = r13.sidebar_buttons;
        ArrayList r26 = new ArrayList();
        Iterator r27 = r25.iterator();
    L63:
        if (r27.hasNext() == false) goto L65;
        SideBarButton r28 = (SideBarButton) r27.next();
        r26.add(new com.ss.android.lark.chat.entity.chat.SideBarButton(r28.i18n_name, r28.icon_key, r28.url));
        goto L63
    L65:
        r1.setSideBarButtons(r26);
        r1.setCreateTime(String.valueOf(r13.create_time));
        r1.setThreadLastTimeStamp(r13.my_threads_last_timestamp.longValue());
        r1.setThreadReadTimeStamp(r13.my_threads_read_timestamp.longValue());
        r1.setMyThreadsUnreadCount(r13.my_threads_unread_count.intValue());
        com.bytedance.lark.pb.basic.v1.Chat.AnonymousSetting.Enum r29 = r13.anonymous_setting;
        if (r29 == null) goto L68;
        r1.setAnonymousSetting(Chat.AnonymousSetting.forNumber(r29.getValue()));
    L68:
        if (r14 != null) goto L70;
    L74:
        r1.setMessageVisibilitySetting(Chat.MessageVisibilitySetting.forNumber(r13.message_visibility_setting.getValue()));
        r1.setAnonymousTotalQuota(r13.anonymous_total_quota.longValue());
        r1.setAnonymousId(r13.anonymous_id);
        r1.setAdmin(r13.is_admin.booleanValue());
        r1.setFake(r13.is_fake.booleanValue());
        r1.setTags(r13.tags);
        r1.setBuzzPermissionSetting(Chat.BuzzPermissionSetting.forNumber(r13.create_urgent_setting.getValue()));
        r1.setCreateVideoConferenceSetting(Chat.CreateVideoConferenceSetting.forNumber(r13.create_video_conference_setting.getValue()));
        r1.setPinPermissionSetting(Chat.PinPermissionSetting.forNumber(r13.pin_permission_setting.getValue()));
        r1.setTypingTranslateSetting(Chat.TypingTranslateSetting.from(r13.typing_translate_setting));
        r1.setChatTabPermissionSetting(Chat.ChatTabPermissionSetting.forNumber(r13.chat_tab_permission_setting.getValue()));
        r1.setChatPinPermissionSetting(Chat.ChatPinPermissionSetting.forNumber(r13.chat_pin_permission_setting.getValue()));
        r1.setUserCountVisibleSetting(Chat.UserCountVisibleSetting.forNumber(r13.user_count_visible_setting.getValue()));
        r1.setUserCountVisible(r13.is_user_count_visible.booleanValue());
        r1.setDoubaoSetting(Chat.DoubaoSetting.from(r13.doubao_setting));
        Chat.RestrictedModeSetting r110 = new Chat.RestrictedModeSetting();
        com.bytedance.lark.pb.basic.v1.Chat.RestrictedModeSetting r30 = r13.restricted_mode_setting;
        if (r30 == null) goto L86;
        r110.setSwitch(r30.switch_.booleanValue());
        r110.setCopy(Chat.RestrictedModeSetting.Participant.forNumber(r13.restricted_mode_setting.copy.getValue()));
        r110.setForward(Chat.RestrictedModeSetting.Participant.forNumber(r13.restricted_mode_setting.forward.getValue()));
        r110.setDownload(Chat.RestrictedModeSetting.Participant.forNumber(r13.restricted_mode_setting.download.getValue()));
        r110.setScreenshot(Chat.RestrictedModeSetting.Participant.forNumber(r13.restricted_mode_setting.screenshot.getValue()));
        if (r13.restricted_mode_setting.on_time_del_msg_setting == null) goto L79;
        Chat.RestrictedModeSetting.OnTimeDelMsgSetting r31 = new Chat.RestrictedModeSetting.OnTimeDelMsgSetting();
        r31.setStatus(r13.restricted_mode_setting.on_time_del_msg_setting.status.booleanValue());
        r31.setAliveTime(r13.restricted_mode_setting.on_time_del_msg_setting.alive_time.longValue());
        r110.setOnTimeDelMsgSetting(r31);
    L79:
        com.bytedance.lark.pb.basic.v1.Chat.WhiteListSetting r32 = r13.restricted_mode_setting.white_list_setting;
        if (r32 == null) goto L85;
        Chat.RestrictedWhiteListSetting r33 = new Chat.RestrictedWhiteListSetting();
        com.bytedance.lark.pb.basic.v1.Chat.WhiteListSetting.LevelEnum r34 = r32.level;
        if (r34 == null) goto L84;
        r33.setLevel(Chat.RestrictedWhiteListSetting.LevelEnum.valueOf(r34.getValue()));
    L84:
        r33.setHitWhiteList(r32.hit_whitelist.booleanValue());
        r33.setMemberListUserIds(new LinkedList(r32.member_list_user_ids));
        r110.setWhiteListSetting(r33);
    L85:
        r1.setRestrictedModeSetting(r110);
    L86:
        com.bytedance.lark.pb.basic.v1.Chat.AdminPostSetting.Enum r111 = r13.admin_post_setting;
        if (r111 == null) goto L89;
        r1.setAdminPostSetting(Chat.AdminPostSetting.forNumber(r111.getValue()));
    L89:
        com.bytedance.lark.pb.basic.v1.Chat.ChatDisplayModeSetting.Enum r112 = r13.chat_display_mode_setting;
        if (r112 == null) goto L92;
        ChatDisplayModeSetting.a r35 = ChatDisplayModeSetting.Companion;
        int r113 = r112.getValue();
        r35.getClass();
        r1.setChatDisplayModeSetting(ChatDisplayModeSetting.a.a(r113));
    L92:
        r1.setBoundTeamInfos(ModelParserChatTeamInfo.a(r13.bound_team_infos));
        r1.setChatterExtraStates(r13.chatter_extra_states);
        r1.setIsMuteAtAll(r13.is_mute_at_all.booleanValue());
        r1.setIsDelayed(r13.is_delayed.booleanValue());
        Boolean r114 = r13.is_flag;
        if (r114 != null) goto L95;
    L97:
        boolean r115 = false;
    L98:
        r1.setFlag(r115);
        r1.setDefaultDisplaySetting(Chat.DefaultDisplaySetting.forNumber(r13.def_display_setting.getValue()));
        r1.setTagData(a0.a(r13.tag_info));
        r1.setHasVCChatPermission(r13.has_vc_chat_permission.booleanValue());
        r1.setThemeId(r13.theme_id.longValue());
        r1.setFrozen(r13.is_frozen.booleanValue());
        r1.setCanBeSortedAlphabetically(r13.can_be_sorted_alphabetically.booleanValue());
        Boolean r116 = r13.is_p2p_ai;
        Boolean r36 = Boolean.FALSE;
        if (r116 != null) goto L102;
        Objects.requireNonNull(r36, "defaultObj");
        r116 = r36;
    L102:
        r1.setAIMainChat(r116.booleanValue());
        Boolean r117 = r13.is_p2p_official_bot_ai;
        if (r117 == null) goto L105;
        r36 = r117;
    L106:
        r1.setAIBotChat(r36.booleanValue());
        r1.setBannerSetting(r23);
        r1.setTypingTranslateHasAutoOpened(r13.typing_translate_has_auto_opened.booleanValue());
        r1.setCanTranslateName(r13.can_translate_name.booleanValue());
        r1.setShouldDisplayTranslatedName(r13.should_display_translated_name.booleanValue());
        r1.setTranslatedName(r13.translated_name);
        r1.setNameMajorLanguage(r13.name_major_language);
        r1.setNameTranslateLanguage(r13.name_translate_language);
        r1.setAtKnowledgeQueryId(r13.ai_knowledge_query_id);
        r1.setAtKnowledgeQueryCreateTime(r13.query_create_time);
        ChatUserAutoMuteSetting r118 = r13.user_auto_mute;
        int r37 = i.a;
        if (r118 != null) goto L109;
        com.ss.android.lark.chat.entity.chat.ChatUserAutoMuteSetting r38 = null;
    L122:
        r1.setUserAutoMuteSetting(r38);
        com.bytedance.lark.pb.basic.v1.Chat.TnsInfo r119 = r13.tns_info;
        if (r119 == null) goto L150;
        TnsOpKind r120 = r119.op_kind;
        TnsSystemBannedInfo r121 = r119.system_banned_info;
        if (r121 != null) goto L128;
        ChatTnsInfo.Companion.getClass();
        r0 = new ChatTnsInfo(ChatTnsInfo.a.a(r120), null);
        goto L150
    L128:
        boolean r39 = r121.is_banned.booleanValue();
        Long r40 = r121.expire_at;
        String r41 = r121.appeal_url;
        ChatTnsBlockedFeature.a r42 = ChatTnsBlockedFeature.Companion;
        List r43 = r121.blocked_features;
        r42.getClass();
        if (r43 != null) goto L131;
    L149:
        ChatTnsSystemBannedInfo r44 = new ChatTnsSystemBannedInfo(r39, r40, r41, r0, r121.is_permanent.booleanValue());
        ChatTnsInfo.Companion.getClass();
        r0 = new ChatTnsInfo(ChatTnsInfo.a.a(r120), r44);
        goto L150
    L131:
        if (r43.isEmpty() == true) goto L149;
        r0 = new ArrayList();
        Iterator r45 = r43.iterator();
    L135:
        if (r45.hasNext() == false) goto L149;
        switch(ChatTnsBlockedFeature.a.a.a[((TnsBlockedFeature) r45.next()).ordinal()]) {
            case 1: goto L147;
            case 2: goto L146;
            case 3: goto L145;
            case 4: goto L144;
            case 5: goto L143;
            case 6: goto L142;
            case 7: goto L141;
            case 8: goto L140;
            case 9: goto L139;
            default: goto L138;
        };
    L138:
        ChatTnsBlockedFeature r46 = ChatTnsBlockedFeature.UNKNOWN_BLOCKED_FEATURE;
    L148:
        r0.add(r46);
        goto L135
    L139:
        r46 = ChatTnsBlockedFeature.BLOCKED_GROUP_TASK;
        goto L148
    L140:
        r46 = ChatTnsBlockedFeature.BLOCKED_MANAGE_BOT;
        goto L148
    L141:
        r46 = ChatTnsBlockedFeature.BLOCKED_BOT_POST;
        goto L148
    L142:
        r46 = ChatTnsBlockedFeature.BLOCKED_MESSAGE_MENU;
        goto L148
    L143:
        r46 = ChatTnsBlockedFeature.BLOCKED_CHAT_MENU_TNS;
        goto L148
    L144:
        r46 = ChatTnsBlockedFeature.BLOCKED_CHAT_TAB;
        goto L148
    L145:
        r46 = ChatTnsBlockedFeature.BLOCKED_REMOVE_MEMBER;
        goto L148
    L146:
        r46 = ChatTnsBlockedFeature.BLOCKED_ADD_MEMBER;
        goto L148
    L147:
        r46 = ChatTnsBlockedFeature.UNKNOWN_BLOCKED_FEATURE;
    L150:
        r1.setChatTnsInfo(r0);
        return r1;
    L109:
        AutoMuteConfig r47 = i.a(r118.user_auto_mute);
        List r48 = r118.bot_auto_mute;
        List r49 = r48;
        if (r49 != null) goto L112;
    L113:
        r6 = true;
    L114:
        if (r6 == false) goto L116;
        LinkedHashMap r50 = null;
    L121:
        r38 = new com.ss.android.lark.chat.entity.chat.ChatUserAutoMuteSetting(r47, r50, r118.notice_type, r118.update_time.longValue(), r118.show_top_banner.booleanValue());
        goto L122
    L116:
        LinkedHashMap r51 = new LinkedHashMap();
        Iterator r52 = r48.iterator();
    L118:
        if (r52.hasNext() == false) goto L120;
        BotAutoMuteConfig r53 = (BotAutoMuteConfig) r52.next();
        r51.put(r53.bot_id, i.a(r53.mute_config));
        goto L118
    L120:
        r50 = r51;
        goto L121
    L112:
        if (r49.isEmpty() == false) goto L114;
    L105:
        Objects.requireNonNull(r36, "defaultObj");
        goto L106
    L95:
        if (r114.booleanValue() == false) goto L97;
        r115 = true;
        goto L98
    L70:
        if (r14.get(r1.getId()) == null) goto L74;
        ChatMailSetting r122 = r14.get(r1.getId());
        if (r122 == null) goto L74;
        r1.setGroupMailEnable(r122.allow_mail_send.booleanValue());
        r1.setGroupMailSendType(Chat.GroupMailSendPermissionType.forNumber(r122.send_permission.getValue()));
        goto L74
    L59:
        if (r13.is_deleted.booleanValue() == false) goto L61;
        r24 = Chat.Status.DELETED;
        goto L61
    L44:
        if (r20 != Chat.ChatMode.DEFAULT) goto L49;
        if (r23.getChatMessagePosition() == null) goto L49;
        int r54 = r23.getChatMessagePosition().intValue();
    L54:
        r19 = Math.max(r19, r54);
    L49:
        if (r20 == Chat.ChatMode.THREAD_V2) goto L51;
    L53:
        r54 = r19;
        goto L54
    L51:
        if (r23.getChatThreadPosition() == null) goto L53;
        r54 = r23.getChatThreadPosition().intValue();
        goto L54
    L41:
        r23 = new com.ss.android.lark.chat.entity.chat.BannerSetting(r21.chat_message_position, r21.chat_thread_position, new HashMap(r21.i18n_names));
        goto L42
    L34:
        r17 = r16.use_opendoc.booleanValue();
        goto L35
    L27:
        r15 = r12.doc_url;
        goto L28
    L23:
        r11 = r10.last_editor_id;
        goto L24
    L19:
        r9 = r8.update_time.longValue();
        goto L20
    L13:
        if (TextUtils.isEmpty(r5.content) == true) goto L14;
        String r55 = r5.content;
        r7 = r55.substring(0, Math.min(1000, r55.length()));
        goto L16
    L8:
        r2 = "";
        goto L9
    }

    public static Map<String, Chat> d(Map<String, com.bytedance.lark.pb.basic.v1.Chat> r7, Map<String, ChatOptionInfo> r8, Map<String, ChatMailSetting> r9) {
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r7.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        String r2 = r1.next();
        com.bytedance.lark.pb.basic.v1.Chat r3 = r7.get(r2);
        com.ss.android.lark.chat.entity.chat.ChatOptionInfo r4 = new com.ss.android.lark.chat.entity.chat.ChatOptionInfo();
        if (CollectionUtils.isNotEmpty(r8) == true) goto L8;
    L12:
        Chat r5 = a(r3, r9);
        if (r5 == null) goto L4;
        r5.setChatOptionInfo(r4);
        r0.put(r2, r5);
        goto L4
    L8:
        if (r8.get(r2) == null) goto L12;
        ChatOptionInfo r6 = r8.get(r2);
        if (r6 == null) goto L12;
        r4.setAnnounceIsUnread(r6.announce.booleanValue());
        r4.setId(r6.id);
        goto L12
    L15:
        return r0;
    }
}
