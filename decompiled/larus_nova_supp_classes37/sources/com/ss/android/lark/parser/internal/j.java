package com.ss.android.lark.parser.internal;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.AvatarMedal;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.Image;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.WorkStatus;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.AccessInfo;
import com.ss.android.lark.chat.entity.chatter.BotMutedInfo;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.ChatterSensitiveInfo;
import com.ss.android.lark.chat.entity.chatter.TagInfo;
import com.ss.android.lark.chat.entity.chatter.TimeZone;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j {
    public static volatile okb.h a;

    public j() {
    }

    public static Chatter a(com.bytedance.lark.pb.basic.v1.Chatter r12) {
        BotMutedInfo r0 = null;
        if (r12 != null) goto L5;
        return null;
    L5:
        Chatter r1 = new Chatter();
        if (r12.is_resigned.booleanValue() == false) goto L8;
        r1.setDimission();
    L8:
        r1.setId(r12.id);
        r1.setName(r12.name);
        r1.setNameWithAnotherName(r12.name_with_another_name);
        r1.setAnotherName(r12.another_name);
        r1.setEnName(r12.en_us_name);
        r1.setLocalizedName(r12.localized_name);
        r1.setAlias(r12.alias);
        r1.setAvatarKey(r12.avatar_key);
        r1.setAnother_name(r12.another_name);
        List r2 = r12.avatar_urls;
        if (r2 != null) goto L11;
    L14:
        ImageSet r3 = r12.avatar;
        if (r3 == null) goto L17;
        Image r4 = r3.origin;
    L18:
        if (r4 == null) goto L20;
        List r5 = r4.urls;
    L21:
        r1.setAvatarUrls(r5);
    L22:
        ImageSet r6 = r12.avatar;
        if (r6 == null) goto L25;
        Image r7 = r6.thumbnail;
    L26:
        if (r7 == null) goto L28;
        List r8 = r7.urls;
    L29:
        r1.setThumbnails(r8);
        r1.setUpdateTime(r12.update_time.longValue());
        if (TextUtils.isEmpty(r12.name_pinyin) == false) goto L32;
        r1.setNamePinyin("#");
    L33:
        r1.setNamePy(r12.name_pinyin);
        r1.setCreatorId(r12.creator_id);
        r1.setType(Chatter.ChatterType.valueOf(r12.type.getValue()));
        if (r12.type != com.bytedance.lark.pb.basic.v1.Chatter.Type.UNKNOWN) goto L36;
        Log.e("chatter type unknown value: " + r1.getId());
    L36:
        r1.setRegistered(r12.is_registered.booleanValue());
        com.bytedance.lark.pb.basic.v1.Chatter.Description r9 = r12.description;
        if (r9 != null) goto L39;
        String r10 = "";
    L40:
        if (r9 != null) goto L42;
        com.bytedance.lark.pb.basic.v1.Chatter.Description.Type r11 = com.bytedance.lark.pb.basic.v1.Chatter.Description.DEFAULT_TYPE;
    L43:
        r1.setDescription(new ChatterDescription(r10, ChatterDescription.Type.valueOf(r11.getValue())));
        Long r13 = r12.private_description_id;
        if (r13 != null) goto L46;
    L52:
        r1.setPrivateDescription(null);
    L53:
        r1.setWithBotTag(r12.with_bot_tag);
        r1.setBotExtraType(r12.bot_ext_type.intValue());
        r1.setAgent(r12.is_agent.booleanValue());
        r1.setInContacts(r12.in_contacts.booleanValue());
        r1.setCanJoinGroup(r12.can_join_group.booleanValue());
        r1.setTenantId(r12.tenant_id);
        r1.setProfileEnable(r12.profile_enabled.booleanValue());
        WorkStatus r14 = r12.work_status;
        if (r14 == null) goto L68;
        String r15 = r1.getTenantId();
        if (a == null) goto L58;
    L67:
        r1.setWorkStatus(new com.ss.android.lark.chat.entity.chatter.WorkStatus(com.ss.android.lark.chat.entity.chatter.WorkStatus.Status.valueOf(r14.status.getValue()), r14.description, r14.start_time.longValue(), r14.end_time.longValue(), !TextUtils.equals(r15, a.getCurrentTenantId())));
        goto L68
    L58:
        monitor-enter(j.class);
    L64:
        th = move-exception;
        throw th;
    L60:
        if (a != null) goto L62;
        a = ImSdkProxy.e();     // Catch: Throwable -> L64
    L62:
        monitor-exit(j.class);     // Catch: Throwable -> L64
    L68:
        r1.setFrozen(r12.is_frozen.booleanValue());
        r1.setZenModeEndTime(r12.do_not_disturb_end_time.longValue());
        com.bytedance.lark.pb.basic.v1.Chatter.AccessInfo r16 = r12.access_info;
        if (r16 == null) goto L85;
        com.bytedance.lark.pb.basic.v1.Chatter.AccessInfo.AccessProfile r17 = r16.access_profile;
        if (r17 == null) goto L85;
        AccessInfo r18 = new AccessInfo();
        com.bytedance.lark.pb.basic.v1.Chatter.AccessInfo.AccessProfile.AccessMessage r19 = r17.access_message_phone_call;
        if (r19 == null) goto L75;
        r18.setPhoneCallAccessProfile(new AccessInfo.AccessProfile(r19.is_accessible.booleanValue(), AccessInfo.InaccessibleCode.fromValue(r17.access_message_phone_call.inaccessible_code.getValue())));
    L75:
        com.bytedance.lark.pb.basic.v1.Chatter.AccessInfo.AccessProfile.AccessMessage r20 = r17.access_message_voice_call;
        if (r20 == null) goto L78;
        r18.setVoiceCallAccessProfile(new AccessInfo.AccessProfile(r20.is_accessible.booleanValue(), AccessInfo.InaccessibleCode.fromValue(r17.access_message_voice_call.inaccessible_code.getValue())));
    L78:
        com.bytedance.lark.pb.basic.v1.Chatter.AccessInfo.AccessProfile.AccessMessage r21 = r17.access_message_video_call;
        if (r21 == null) goto L81;
        r18.setVideoCallAccessProfile(new AccessInfo.AccessProfile(r21.is_accessible.booleanValue(), AccessInfo.InaccessibleCode.fromValue(r17.access_message_video_call.inaccessible_code.getValue())));
    L81:
        com.bytedance.lark.pb.basic.v1.Chatter.AccessInfo.AccessProfile.AccessMessage r22 = r17.access_message_urgent;
        if (r22 == null) goto L84;
        r18.setUrgentAccessProfile(new AccessInfo.AccessProfile(r22.is_accessible.booleanValue(), AccessInfo.InaccessibleCode.fromValue(r17.access_message_urgent.inaccessible_code.getValue())));
    L84:
        r1.setAccessInfo(r18);
    L85:
        r1.setOpenAppId(r12.open_app_id);
        r1.setAcceptSmsPhoneUrgent(r12.accept_sms_phone_urgent.booleanValue());
        com.bytedance.lark.pb.basic.v1.Chatter.TimeZone r23 = r12.time_zone;
        if (r23 != null) goto L88;
        TimeZone r24 = null;
    L89:
        r1.setTimeZone(r24);
        r1.setAnonymous(r12.is_anonymous.booleanValue());
        r1.setCustomStatus(ChatterCustomStatus.fromPB(r12.status));
        AvatarMedal r25 = r12.avatar_medal;
        if (r25 == null) goto L92;
        r1.setAvatarMedal(new com.ss.android.lark.chat.entity.chatter.AvatarMedal(r25.key, r25.name, r25.show_switch.booleanValue()));
    L92:
        r1.setSpecialFocus(r12.is_special_focus.booleanValue());
        r1.setDefaultAvatar(r12.is_default_avatar.booleanValue());
        r1.setTagData(a0.a(r12.tag_info));
        BotMutedInfo.a r26 = BotMutedInfo.Companion;
        com.bytedance.lark.pb.basic.v1.Chatter.BotMutedInfo r27 = r12.muted_info;
        r26.getClass();
        if (r27 == null) goto L96;
        r0 = new BotMutedInfo(r27.muted_scenes);
    L96:
        r1.setMutedInfo(r0);
        r1.setFullDepartmentName(r12.chat_chatter_list_department_name);
        r1.setMajorLanguage(r12.major_language);
        r1.setCommonLocales(r12.common_locales);
        return r1;
    L88:
        r24 = new TimeZone();
        r24.setTimeZoneId(r23.time_zone_id);
        goto L89
    L46:
        if (r13.longValue() <= 0) goto L52;
        String r28 = r12.private_description;
        if (r28 == null) goto L52;
        if (r28.isEmpty() == true) goto L52;
        r1.setPrivateDescription(new UserPrivateDescription(r1.getId(), r12.private_description_id, r12.private_description));
        goto L53
    L42:
        r11 = r9.type;
        goto L43
    L39:
        r10 = r9.text;
        goto L40
    L32:
        r1.setNamePinyin(r12.name_pinyin);
        goto L33
    L28:
        r8 = new ArrayList();
        goto L29
    L25:
        r7 = null;
        goto L26
    L20:
        r5 = new ArrayList();
        goto L21
    L17:
        r4 = null;
        goto L18
    L11:
        if (r2.isEmpty() == true) goto L14;
        r1.setAvatarUrls(r12.avatar_urls);
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.Map] */
    public static com.ss.android.lark.chat.entity.chatter.a b(Entity r11, String r12) {
        com.ss.android.lark.chat.entity.chatter.a r1 = new com.ss.android.lark.chat.entity.chatter.a();
        if (r11 != null) goto L5;
        return r1;
    L5:
        HashMap r2 = new HashMap();
        Map r3 = r11.chat_chatters;
        Map r4 = r11.chatter_id_to_sensitive_info;
        ?? r5 = new HashMap();
        if (r3.isEmpty() == true) goto L14;
        Iterator r13 = r3.entrySet().iterator();
    L9:
        if (r13.hasNext() == false) goto L15;
        Map.Entry r6 = (Map.Entry) r13.next();
        String r7 = (String) r6.getKey();
        Map r8 = ((Entity.ChatChatter) r6.getValue()).chatters;
        r5.putAll(r8);
        Iterator r9 = r8.keySet().iterator();
    L12:
        if (r9.hasNext() == false) goto L9;
        r2.put((String) r9.next(), r7);
    L15:
        Iterator r14 = r5.entrySet().iterator();
    L17:
        if (r14.hasNext() == false) goto L50;
        com.bytedance.lark.pb.basic.v1.Chatter r10 = (com.bytedance.lark.pb.basic.v1.Chatter) ((Map.Entry) r14.next()).getValue();
        Chatter r15 = a(r10);
        if (r15 == null) goto L17;
        String r16 = r15.getId();
        long r17 = CastLongProtector.parseLong(r16);     // Catch: Throwable -> L23
    L26:
        if (CollectionUtils.isEmpty(r4) == true) goto L34;
        ChatterSensitiveInfo.a r18 = new ChatterSensitiveInfo.a();
        if (r4.containsKey(Long.valueOf(r17)) == false) goto L33;
        com.bytedance.lark.pb.basic.v1.ChatterSensitiveInfo r19 = (com.bytedance.lark.pb.basic.v1.ChatterSensitiveInfo) r4.get(Long.valueOf(r17));
        if (r19 == null) goto L32;
        String r20 = r19.department_name;
        Intrinsics.checkNotNullParameter(r20, "chatterDepartmentName");
        r18.a = r20;
        goto L33
    L32:
        Log.e("ModelParserChatter", "pbChatterSensitiveInfo is null");
    L33:
        ChatterSensitiveInfo r21 = new ChatterSensitiveInfo();
        r21.setChatterDepartmentName(r18.a);
        r15.setChatterSensitiveInfo(r21);
    L34:
        ChatChatter r22 = new ChatChatter(r15);
        r22.setChatId(r12);
        com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra r23 = r10.chat_extra;
        if (r23 == null) goto L47;
        if (TextUtils.isEmpty(r23.chat_id) == true) goto L47;
        String r24 = r23.chat_id;
        String r25 = r23.nick_name;
        int r26 = r23.oncall_role.getValue();
        com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo r27 = r23.tag_infos;
        ArrayList r28 = new ArrayList();
        if (r27 == null) goto L45;
        Iterator r29 = r27.tags.iterator();
    L43:
        if (r29.hasNext() == false) goto L45;
        r28.add(TagInfo.map((com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo) r29.next()));
    L45:
        r22.setTagInfos(r28);
        r22.setChatId(r24);
        r22.setNickName(r25);
        r22.setOnCallRole(r26);
    L49:
        r1.d(r22);
    L47:
        if (r2.containsKey(r16) == false) goto L49;
        r22.setChatId((String) r2.get(r16));
    L23:
        th = move-exception;
        Log.e("ModelParserChatter", "string to long error: " + th);
        r17 = 0;
        goto L26
    L50:
        return r1;
    L14:
        r5 = r11.chatters;
        goto L15
    }
}
