package com.lark.kmp.pb.im.v1;

import com.lark.kmp.pb.basic.v1.AvatarMeta;
import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.pb.basic.v1.ChatMailSetting;
import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u009d\u00012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004\u009c\u0001\u009d\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u009a\u0001\u001a\u00020\u0002H\u0016J\t\u0010\u009b\u0001\u001a\u00020\nH\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001d\u0010\u001fR \u0010!\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010 \u0012\u0004\b\"\u0010#\u001a\u0004\b!\u0010\u001fR\u0015\u0010$\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b$\u0010\u001fR\u0015\u0010%\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010*\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b*\u0010\u001fR\u0015\u0010+\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010)\u001a\u0004\b,\u0010(R\u0015\u0010-\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b-\u0010\u001fR\u0015\u0010.\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b/\u0010\u001fR\u0013\u00100\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\fR\u0015\u00102\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b2\u0010\u001fR\u0013\u00103\u001a\u0004\u0018\u000104¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0015\u00107\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b8\u0010\u001bR\u0015\u00109\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b9\u0010\u001fR\u0015\u0010:\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b:\u0010\u001fR\u0013\u0010;\u001a\u0004\u0018\u00010<¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001d\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190@¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0015\u0010C\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\bC\u0010\u001fR\u0015\u0010D\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\bD\u0010\u001fR\u0015\u0010E\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\bE\u0010\u001fR\u0013\u0010F\u001a\u0004\u0018\u00010G¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010J\u001a\u0004\u0018\u00010K¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0013\u0010N\u001a\u0004\u0018\u00010O¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010R\u001a\u0004\u0018\u00010O¢\u0006\b\n\u0000\u001a\u0004\bS\u0010QR\u0013\u0010T\u001a\u0004\u0018\u00010U¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0013\u0010X\u001a\u0004\u0018\u00010Y¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0015\u0010\\\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b]\u0010\u001fR\u0013\u0010^\u001a\u0004\u0018\u00010_¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0013\u0010b\u001a\u0004\u0018\u00010c¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0013\u0010f\u001a\u0004\u0018\u00010g¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0013\u0010j\u001a\u0004\u0018\u00010k¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0013\u0010n\u001a\u0004\u0018\u00010o¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0013\u0010r\u001a\u0004\u0018\u00010s¢\u0006\b\n\u0000\u001a\u0004\bt\u0010uR\u0013\u0010v\u001a\u0004\u0018\u00010w¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u0013\u0010z\u001a\u0004\u0018\u00010{¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0015\u0010~\u001a\u0004\u0018\u00010\u007f¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0017\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0017\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0017\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0017\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001¨\u0006\u009e\u0001"}, d2 = {"Lcom/lark/kmp/pb/im/v1/UpdateChatRequest;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/UpdateChatRequest$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/UpdateChatRequest$Builder;Lokio/ByteString;)V", "chat_id", "", "getChat_id", "()Ljava/lang/String;", "name", "getName", "icon_data", "getIcon_data", "()Lokio/ByteString;", "description", "getDescription", "announcement", "getAnnouncement", "owner_id", "getOwner_id", "chatter_count", "", "getChatter_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "is_archive", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_public", "is_public$annotations", "()V", "is_inner", "organization_id", "", "getOrganization_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "is_group_companies", "group_companies_id", "getGroup_companies_id", "is_remind", "off_edit_info", "getOff_edit_info", "icon_key", "getIcon_key", "is_dissolved", "message_position", "Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition$Enum;", "getMessage_position", "()Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition$Enum;", "burn_life", "getBurn_life", "is_auto_translate", "is_public_v2", "avatar_meta", "Lcom/lark/kmp/pb/basic/v1/AvatarMeta;", "getAvatar_meta", "()Lcom/lark/kmp/pb/basic/v1/AvatarMeta;", "patch_chatter_extra_states", "", "getPatch_chatter_extra_states", "()Ljava/util/Map;", "is_mute_at_all", "is_delayed", "is_frozen", "add_member_permission", "Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission$Enum;", "getAdd_member_permission", "()Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission$Enum;", "at_all_permission", "Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission$Enum;", "getAt_all_permission", "()Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission$Enum;", "join_message_visible", "Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible$Enum;", "getJoin_message_visible", "()Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible$Enum;", "quit_message_visible", "getQuit_message_visible", "share_card_permission", "Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission$Enum;", "getShare_card_permission", "()Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission$Enum;", "add_member_apply", "Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply$Enum;", "getAdd_member_apply", "()Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply$Enum;", "allow_mail_send", "getAllow_mail_send", "mail_send_permission", "Lcom/lark/kmp/pb/basic/v1/ChatMailSetting$SendPermission;", "getMail_send_permission", "()Lcom/lark/kmp/pb/basic/v1/ChatMailSetting$SendPermission;", "anonymous_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting$Enum;", "getAnonymous_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting$Enum;", "message_visibility_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting$Enum;", "getMessage_visibility_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting$Enum;", "create_urgent_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting$Enum;", "getCreate_urgent_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting$Enum;", "create_video_conference_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting$Enum;", "getCreate_video_conference_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting$Enum;", "pin_permission_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting$Enum;", "getPin_permission_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting$Enum;", "top_notice_permission_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting$Enum;", "getTop_notice_permission_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting$Enum;", "typing_translate_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting;", "getTyping_translate_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting;", "chat_tab_permission_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting$Enum;", "getChat_tab_permission_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting$Enum;", "restricted_mode_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting;", "getRestricted_mode_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting;", "def_display_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting$Enum;", "getDef_display_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting$Enum;", "chat_display_mode_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting$Enum;", "getChat_display_mode_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting$Enum;", "chat_pin_permission_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting$Enum;", "getChat_pin_permission_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting$Enum;", "user_count_visible_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting$Enum;", "getUser_count_visible_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting$Enum;", "doubao_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$DoubaoSetting;", "getDoubao_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$DoubaoSetting;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UpdateChatRequest extends Message<UpdateChatRequest, a> {
    public static final ProtoAdapter<UpdateChatRequest> ADAPTER = null;
    public static final b Companion = null;
    public static final Chat.AddMemberApply.Enum DEFAULT_ADD_MEMBER_APPLY = null;
    public static final Chat.AddMemberPermission.Enum DEFAULT_ADD_MEMBER_PERMISSION = null;
    public static final boolean DEFAULT_ALLOW_MAIL_SEND = true;
    public static final Chat.AtAllPermission.Enum DEFAULT_AT_ALL_PERMISSION = null;
    public static final Chat.ChatPinPermissionSetting.Enum DEFAULT_CHAT_PIN_PERMISSION_SETTING = null;
    public static final Chat.ChatTabPermissionSetting.Enum DEFAULT_CHAT_TAB_PERMISSION_SETTING = null;
    public static final Chat.CreateUrgentSetting.Enum DEFAULT_CREATE_URGENT_SETTING = null;
    public static final Chat.CreateVideoConferenceSetting.Enum DEFAULT_CREATE_VIDEO_CONFERENCE_SETTING = null;
    public static final long DEFAULT_GROUP_COMPANIES_ID = 0;
    public static final boolean DEFAULT_IS_ARCHIVE = false;
    public static final boolean DEFAULT_IS_AUTO_TRANSLATE = false;
    public static final boolean DEFAULT_IS_DISSOLVED = false;
    public static final boolean DEFAULT_IS_GROUP_COMPANIES = false;
    public static final boolean DEFAULT_IS_INNER = false;
    public static final boolean DEFAULT_IS_PUBLIC_V2 = false;
    public static final boolean DEFAULT_IS_REMIND = true;
    public static final Chat.SystemMessageVisible.Enum DEFAULT_JOIN_MESSAGE_VISIBLE = null;
    public static final ChatMailSetting.SendPermission DEFAULT_MAIL_SEND_PERMISSION = null;
    public static final Chat.MessagePosition.Enum DEFAULT_MESSAGE_POSITION = null;
    public static final Chat.MessageVisibilitySetting.Enum DEFAULT_MESSAGE_VISIBILITY_SETTING = null;
    public static final boolean DEFAULT_OFF_EDIT_INFO = false;
    public static final long DEFAULT_ORGANIZATION_ID = 0;
    public static final Chat.PinPermissionSetting.Enum DEFAULT_PIN_PERMISSION_SETTING = null;
    public static final Chat.SystemMessageVisible.Enum DEFAULT_QUIT_MESSAGE_VISIBLE = null;
    public static final Chat.ShareCardPermission.Enum DEFAULT_SHARE_CARD_PERMISSION = null;
    public static final Chat.TopNoticePermissionSetting.Enum DEFAULT_TOP_NOTICE_PERMISSION_SETTING = null;
    public static final Chat.UserCountVisibleSetting.Enum DEFAULT_USER_COUNT_VISIBLE_SETTING = null;
    public static final c<UpdateChatRequest> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final Chat.AddMemberApply.Enum add_member_apply;
    private final Chat.AddMemberPermission.Enum add_member_permission;
    private final Boolean allow_mail_send;
    private final String announcement;
    private final Chat.AnonymousSetting.Enum anonymous_setting;
    private final Chat.AtAllPermission.Enum at_all_permission;
    private final AvatarMeta avatar_meta;
    private final Integer burn_life;
    private final Chat.ChatDisplayModeSetting.Enum chat_display_mode_setting;
    private final String chat_id;
    private final Chat.ChatPinPermissionSetting.Enum chat_pin_permission_setting;
    private final Chat.ChatTabPermissionSetting.Enum chat_tab_permission_setting;
    private final Integer chatter_count;
    private final Chat.CreateUrgentSetting.Enum create_urgent_setting;
    private final Chat.CreateVideoConferenceSetting.Enum create_video_conference_setting;
    private final Chat.DefDisplaySetting.Enum def_display_setting;
    private final String description;
    private final Chat.DoubaoSetting doubao_setting;
    private final Long group_companies_id;
    private final ByteString icon_data;
    private final String icon_key;
    private final Boolean is_archive;
    private final Boolean is_auto_translate;
    private final Boolean is_delayed;
    private final Boolean is_dissolved;
    private final Boolean is_frozen;
    private final Boolean is_group_companies;
    private final Boolean is_inner;
    private final Boolean is_mute_at_all;
    private final Boolean is_public;
    private final Boolean is_public_v2;
    private final Boolean is_remind;
    private final Chat.SystemMessageVisible.Enum join_message_visible;
    private final ChatMailSetting.SendPermission mail_send_permission;
    private final Chat.MessagePosition.Enum message_position;
    private final Chat.MessageVisibilitySetting.Enum message_visibility_setting;
    private final String name;
    private final Boolean off_edit_info;
    private final Long organization_id;
    private final String owner_id;
    private final Map<Integer, Integer> patch_chatter_extra_states;
    private final Chat.PinPermissionSetting.Enum pin_permission_setting;
    private final Chat.SystemMessageVisible.Enum quit_message_visible;
    private final Chat.RestrictedModeSetting restricted_mode_setting;
    private final Chat.ShareCardPermission.Enum share_card_permission;
    private final Chat.TopNoticePermissionSetting.Enum top_notice_permission_setting;
    private final Chat.TypingTranslateSetting typing_translate_setting;
    private final Chat.UserCountVisibleSetting.Enum user_count_visible_setting;

    public static final class a extends Message.a<UpdateChatRequest, a> implements d<UpdateChatRequest> {
        public Boolean A;
        public Boolean B;
        public Boolean C;
        public Chat.AddMemberPermission.Enum D;
        public Chat.AtAllPermission.Enum E;
        public Chat.SystemMessageVisible.Enum F;
        public Chat.SystemMessageVisible.Enum G;
        public Chat.ShareCardPermission.Enum H;
        public Chat.AddMemberApply.Enum I;
        public Boolean J;
        public ChatMailSetting.SendPermission K;
        public Chat.AnonymousSetting.Enum L;
        public Chat.MessageVisibilitySetting.Enum M;
        public Chat.CreateUrgentSetting.Enum N;
        public Chat.CreateVideoConferenceSetting.Enum O;
        public Chat.PinPermissionSetting.Enum P;
        public Chat.TopNoticePermissionSetting.Enum Q;
        public Chat.TypingTranslateSetting R;
        public Chat.ChatTabPermissionSetting.Enum S;
        public Chat.RestrictedModeSetting T;
        public Chat.DefDisplaySetting.Enum U;
        public Chat.ChatDisplayModeSetting.Enum V;
        public Chat.ChatPinPermissionSetting.Enum W;
        public Chat.UserCountVisibleSetting.Enum X;
        public Chat.DoubaoSetting Y;
        public String d;
        public String e;
        public ByteString f;
        public String g;
        public String h;
        public String i;
        public Integer j;
        public Boolean k;
        public Boolean l;
        public Boolean m;
        public Long n;
        public Boolean o;
        public Long p;
        public Boolean q;
        public Boolean r;
        public String s;
        public Boolean t;
        public Chat.MessagePosition.Enum u;
        public Integer v;
        public Boolean w;
        public Boolean x;
        public AvatarMeta y;
        public Map<Integer, Integer> z;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new UpdateChatRequest(this, c(), null);
        }

        public a() {
            this.z = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ UpdateChatRequest(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "is_public is deprecated")
    public static /* synthetic */ void is_public$annotations() {
    }

    static {
        Companion = new b();
        DEFAULT_MESSAGE_POSITION = Chat.MessagePosition.Enum.RECENT_LEFT;
        DEFAULT_ADD_MEMBER_PERMISSION = Chat.AddMemberPermission.Enum.ALL_MEMBERS;
        DEFAULT_AT_ALL_PERMISSION = Chat.AtAllPermission.Enum.ALL_MEMBERS;
        Chat.SystemMessageVisible.Enum r0 = Chat.SystemMessageVisible.Enum.ONLY_OWNER;
        DEFAULT_JOIN_MESSAGE_VISIBLE = r0;
        DEFAULT_QUIT_MESSAGE_VISIBLE = r0;
        DEFAULT_SHARE_CARD_PERMISSION = Chat.ShareCardPermission.Enum.ALLOWED;
        DEFAULT_ADD_MEMBER_APPLY = Chat.AddMemberApply.Enum.NO_APPLY;
        DEFAULT_MAIL_SEND_PERMISSION = ChatMailSetting.SendPermission.GROUP_MEMBERS;
        DEFAULT_MESSAGE_VISIBILITY_SETTING = Chat.MessageVisibilitySetting.Enum.ALL_MESSAGES;
        DEFAULT_CREATE_URGENT_SETTING = Chat.CreateUrgentSetting.Enum.ALL_MEMBERS;
        DEFAULT_CREATE_VIDEO_CONFERENCE_SETTING = Chat.CreateVideoConferenceSetting.Enum.ALL_MEMBERS;
        DEFAULT_PIN_PERMISSION_SETTING = Chat.PinPermissionSetting.Enum.ALL_MEMBERS;
        DEFAULT_TOP_NOTICE_PERMISSION_SETTING = Chat.TopNoticePermissionSetting.Enum.ALL_MEMBERS;
        DEFAULT_CHAT_TAB_PERMISSION_SETTING = Chat.ChatTabPermissionSetting.Enum.ALL_MEMBERS;
        DEFAULT_CHAT_PIN_PERMISSION_SETTING = Chat.ChatPinPermissionSetting.Enum.ALL_MEMBERS;
        DEFAULT_USER_COUNT_VISIBLE_SETTING = Chat.UserCountVisibleSetting.Enum.ALL_MEMBERS;
        UpdateChatRequest$Companion$ADAPTER$1 r3 = new UpdateChatRequest$Companion$ADAPTER$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(UpdateChatRequest.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.UpdateChatRequest>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.chat_id;
        r0.e = this.name;
        r0.f = this.icon_data;
        r0.g = this.description;
        r0.h = this.announcement;
        r0.i = this.owner_id;
        r0.j = this.chatter_count;
        r0.k = this.is_archive;
        r0.l = this.is_public;
        r0.m = this.is_inner;
        r0.n = this.organization_id;
        r0.o = this.is_group_companies;
        r0.p = this.group_companies_id;
        r0.q = this.is_remind;
        r0.r = this.off_edit_info;
        r0.s = this.icon_key;
        r0.t = this.is_dissolved;
        r0.u = this.message_position;
        r0.v = this.burn_life;
        r0.w = this.is_auto_translate;
        r0.x = this.is_public_v2;
        r0.y = this.avatar_meta;
        r0.z = this.patch_chatter_extra_states;
        r0.A = this.is_mute_at_all;
        r0.B = this.is_delayed;
        r0.C = this.is_frozen;
        r0.D = this.add_member_permission;
        r0.E = this.at_all_permission;
        r0.F = this.join_message_visible;
        r0.G = this.quit_message_visible;
        r0.H = this.share_card_permission;
        r0.I = this.add_member_apply;
        r0.J = this.allow_mail_send;
        r0.K = this.mail_send_permission;
        r0.L = this.anonymous_setting;
        r0.M = this.message_visibility_setting;
        r0.N = this.create_urgent_setting;
        r0.O = this.create_video_conference_setting;
        r0.P = this.pin_permission_setting;
        r0.Q = this.top_notice_permission_setting;
        r0.R = this.typing_translate_setting;
        r0.S = this.chat_tab_permission_setting;
        r0.T = this.restricted_mode_setting;
        r0.U = this.def_display_setting;
        r0.V = this.chat_display_mode_setting;
        r0.W = this.chat_pin_permission_setting;
        r0.X = this.user_count_visible_setting;
        r0.Y = this.doubao_setting;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(UpdateChatRequest.class).getSimpleName() + '@' + hashCode();
    }

    public final Chat.AddMemberApply.Enum getAdd_member_apply() {
        return this.add_member_apply;
    }

    public final Chat.AddMemberPermission.Enum getAdd_member_permission() {
        return this.add_member_permission;
    }

    public final Boolean getAllow_mail_send() {
        return this.allow_mail_send;
    }

    public final String getAnnouncement() {
        return this.announcement;
    }

    public final Chat.AnonymousSetting.Enum getAnonymous_setting() {
        return this.anonymous_setting;
    }

    public final Chat.AtAllPermission.Enum getAt_all_permission() {
        return this.at_all_permission;
    }

    public final AvatarMeta getAvatar_meta() {
        return this.avatar_meta;
    }

    public final Integer getBurn_life() {
        return this.burn_life;
    }

    public final Chat.ChatDisplayModeSetting.Enum getChat_display_mode_setting() {
        return this.chat_display_mode_setting;
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    public final Chat.ChatPinPermissionSetting.Enum getChat_pin_permission_setting() {
        return this.chat_pin_permission_setting;
    }

    public final Chat.ChatTabPermissionSetting.Enum getChat_tab_permission_setting() {
        return this.chat_tab_permission_setting;
    }

    public final Integer getChatter_count() {
        return this.chatter_count;
    }

    public final Chat.CreateUrgentSetting.Enum getCreate_urgent_setting() {
        return this.create_urgent_setting;
    }

    public final Chat.CreateVideoConferenceSetting.Enum getCreate_video_conference_setting() {
        return this.create_video_conference_setting;
    }

    public final Chat.DefDisplaySetting.Enum getDef_display_setting() {
        return this.def_display_setting;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Chat.DoubaoSetting getDoubao_setting() {
        return this.doubao_setting;
    }

    public final Long getGroup_companies_id() {
        return this.group_companies_id;
    }

    public final ByteString getIcon_data() {
        return this.icon_data;
    }

    public final String getIcon_key() {
        return this.icon_key;
    }

    public final Chat.SystemMessageVisible.Enum getJoin_message_visible() {
        return this.join_message_visible;
    }

    public final ChatMailSetting.SendPermission getMail_send_permission() {
        return this.mail_send_permission;
    }

    public final Chat.MessagePosition.Enum getMessage_position() {
        return this.message_position;
    }

    public final Chat.MessageVisibilitySetting.Enum getMessage_visibility_setting() {
        return this.message_visibility_setting;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getOff_edit_info() {
        return this.off_edit_info;
    }

    public final Long getOrganization_id() {
        return this.organization_id;
    }

    public final String getOwner_id() {
        return this.owner_id;
    }

    public final Map<Integer, Integer> getPatch_chatter_extra_states() {
        return this.patch_chatter_extra_states;
    }

    public final Chat.PinPermissionSetting.Enum getPin_permission_setting() {
        return this.pin_permission_setting;
    }

    public final Chat.SystemMessageVisible.Enum getQuit_message_visible() {
        return this.quit_message_visible;
    }

    public final Chat.RestrictedModeSetting getRestricted_mode_setting() {
        return this.restricted_mode_setting;
    }

    public final Chat.ShareCardPermission.Enum getShare_card_permission() {
        return this.share_card_permission;
    }

    public final Chat.TopNoticePermissionSetting.Enum getTop_notice_permission_setting() {
        return this.top_notice_permission_setting;
    }

    public final Chat.TypingTranslateSetting getTyping_translate_setting() {
        return this.typing_translate_setting;
    }

    public final Chat.UserCountVisibleSetting.Enum getUser_count_visible_setting() {
        return this.user_count_visible_setting;
    }

    public final Boolean is_archive() {
        return this.is_archive;
    }

    public final Boolean is_auto_translate() {
        return this.is_auto_translate;
    }

    public final Boolean is_delayed() {
        return this.is_delayed;
    }

    public final Boolean is_dissolved() {
        return this.is_dissolved;
    }

    public final Boolean is_frozen() {
        return this.is_frozen;
    }

    public final Boolean is_group_companies() {
        return this.is_group_companies;
    }

    public final Boolean is_inner() {
        return this.is_inner;
    }

    public final Boolean is_mute_at_all() {
        return this.is_mute_at_all;
    }

    public final Boolean is_public() {
        return this.is_public;
    }

    public final Boolean is_public_v2() {
        return this.is_public_v2;
    }

    public final Boolean is_remind() {
        return this.is_remind;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public UpdateChatRequest(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.chat_id = r4;
        this.name = r2.e;
        this.icon_data = r2.f;
        this.description = r2.g;
        this.announcement = r2.h;
        this.owner_id = r2.i;
        this.chatter_count = r2.j;
        this.is_archive = r2.k;
        this.is_public = r2.l;
        this.is_inner = r2.m;
        this.organization_id = r2.n;
        this.is_group_companies = r2.o;
        this.group_companies_id = r2.p;
        this.is_remind = r2.q;
        this.off_edit_info = r2.r;
        this.icon_key = r2.s;
        this.is_dissolved = r2.t;
        this.message_position = r2.u;
        this.burn_life = r2.v;
        this.is_auto_translate = r2.w;
        this.is_public_v2 = r2.x;
        this.avatar_meta = r2.y;
        this.patch_chatter_extra_states = com.lark.wire.internal.a.d("patch_chatter_extra_states", r2.z);
        this.is_mute_at_all = r2.A;
        this.is_delayed = r2.B;
        this.is_frozen = r2.C;
        this.add_member_permission = r2.D;
        this.at_all_permission = r2.E;
        this.join_message_visible = r2.F;
        this.quit_message_visible = r2.G;
        this.share_card_permission = r2.H;
        this.add_member_apply = r2.I;
        this.allow_mail_send = r2.J;
        this.mail_send_permission = r2.K;
        this.anonymous_setting = r2.L;
        this.message_visibility_setting = r2.M;
        this.create_urgent_setting = r2.N;
        this.create_video_conference_setting = r2.O;
        this.pin_permission_setting = r2.P;
        this.top_notice_permission_setting = r2.Q;
        this.typing_translate_setting = r2.R;
        this.chat_tab_permission_setting = r2.S;
        this.restricted_mode_setting = r2.T;
        this.def_display_setting = r2.U;
        this.chat_display_mode_setting = r2.V;
        this.chat_pin_permission_setting = r2.W;
        this.user_count_visible_setting = r2.X;
        this.doubao_setting = r2.Y;
    }

    public /* synthetic */ UpdateChatRequest(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
