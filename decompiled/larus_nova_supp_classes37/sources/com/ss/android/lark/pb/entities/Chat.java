package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Chat extends com.squareup.wire.Message<Chat, Builder> {
    public static final ProtoAdapter<Chat> ADAPTER = null;
    public static final Boolean DEFAULT_ALLOW_POST = null;
    public static final Long DEFAULT_BURNED_TIME = null;
    public static final Long DEFAULT_CHAT_CHATTER_VERSION = null;
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Boolean DEFAULT_ENABLE_WATERMARK = null;
    public static final Long DEFAULT_FILTER_MUTE_BOT_BADGE_COUNT_VERSION = null;
    public static final Integer DEFAULT_FIRST_CHAT_MESSAGE_POSITION = null;
    public static final Boolean DEFAULT_HAS_CHAT_MENU = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_ADMIN = null;
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_CROSS_TENANT_V1 = null;
    public static final Boolean DEFAULT_IS_CROSS_WITH_KA = null;
    public static final Boolean DEFAULT_IS_CRYPTO = null;
    public static final Boolean DEFAULT_IS_CUSTOMER_SERVICE = null;
    public static final Boolean DEFAULT_IS_CUSTOM_ICON = null;
    public static final Boolean DEFAULT_IS_DEPARTMENT = null;
    public static final Boolean DEFAULT_IS_DEPARTMENT_V1 = null;
    public static final Boolean DEFAULT_IS_DISSOLVED = null;
    public static final Boolean DEFAULT_IS_EDU = null;
    public static final Boolean DEFAULT_IS_FROZEN = null;
    public static final Boolean DEFAULT_IS_INVISIBLE = null;
    public static final Boolean DEFAULT_IS_LARGE_GROUP = null;
    public static final Boolean DEFAULT_IS_MEETING = null;
    public static final Boolean DEFAULT_IS_P2P_AI = null;
    public static final Boolean DEFAULT_IS_P2P_OFFICIAL_BOT_AI = null;
    public static final Boolean DEFAULT_IS_PRIVATE_MODE = null;
    public static final Boolean DEFAULT_IS_PUBLIC = null;
    public static final Boolean DEFAULT_IS_PUBLIC_V2 = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Boolean DEFAULT_IS_SAME_PAGE_MEETING = null;
    public static final Boolean DEFAULT_IS_SUPER = null;
    public static final Boolean DEFAULT_IS_TEAM = null;
    public static final Boolean DEFAULT_IS_TENANT = null;
    public static final Long DEFAULT_JOIN_TIME_MS = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_LAST_MESSAGE_ID = "";
    public static final Integer DEFAULT_LAST_MESSAGE_POSITION = null;
    public static final Integer DEFAULT_LAST_MESSAGE_POSITION_BADGE_COUNT = null;
    public static final Integer DEFAULT_LAST_MESSAGE_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = null;
    public static final String DEFAULT_LAST_THREAD_ID = "";
    public static final Integer DEFAULT_LAST_THREAD_MESSAGE_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = null;
    public static final Integer DEFAULT_LAST_THREAD_POSITION = null;
    public static final Integer DEFAULT_LAST_THREAD_POSITION_BADGE_COUNT = null;
    public static final String DEFAULT_LAST_VISIBLE_MESSAGE_ID = "";
    public static final Integer DEFAULT_LAST_VISIBLE_MESSAGE_NO_BADGED_COUNT = null;
    public static final Integer DEFAULT_LAST_VISIBLE_MESSAGE_POSITION = null;
    public static final String DEFAULT_LAST_VISIBLE_THREAD_ID = "";
    public static final Integer DEFAULT_LAST_VISIBLE_THREAD_POSITION = null;
    public static final Integer DEFAULT_MEMBER_COUNT = null;
    public static final Long DEFAULT_MY_THREADS_LAST_DISPLAY_MESSAGE_ID = null;
    public static final Long DEFAULT_MY_THREADS_LAST_TIMESTAMP = null;
    public static final Long DEFAULT_MY_THREADS_READ_TIMESTAMP = null;
    public static final Integer DEFAULT_MY_THREADS_UNREAD_COUNT = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAME_PINYIN = "";
    public static final String DEFAULT_NAME_PY = "";
    public static final Integer DEFAULT_NEW_MESSAGE_COUNT = null;
    public static final Integer DEFAULT_NEW_THREAD_COUNT = null;
    public static final Integer DEFAULT_NO_BADGED_NEW_MESSAGE_COUNT = null;
    public static final Integer DEFAULT_NO_BADGED_NEW_THREAD_COUNT = null;
    public static final Boolean DEFAULT_OFF_EDIT_GROUP_CHAT_INFO = null;
    public static final Long DEFAULT_ONCALL_ID = null;
    public static final String DEFAULT_OPEN_CHAT_ID = "";
    public static final String DEFAULT_OWNER_ID = "";
    public static final Integer DEFAULT_PUT_CHATTER_APPLY_COUNT = null;
    public static final Integer DEFAULT_READ_POSITION = null;
    public static final Integer DEFAULT_READ_POSITION_BADGE_COUNT = null;
    public static final Integer DEFAULT_READ_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = null;
    public static final Integer DEFAULT_READ_THREAD_POSITION = null;
    public static final Integer DEFAULT_READ_THREAD_POSITION_BADGE_COUNT = null;
    public static final Integer DEFAULT_READ_THREAD_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = null;
    public static final Boolean DEFAULT_SHOW_BANNER = null;
    public static final String DEFAULT_SIDEBAR_ID = "";
    public static final String DEFAULT_TENANT_ID = "";
    public static final Integer DEFAULT_THREAD_START_POSITION = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    public static final Long DEFAULT_USER_CLEAN_MESSAGE_TIME_MS = null;
    public static final Integer DEFAULT_USER_COUNT = null;
    private static final long serialVersionUID = 0;
    public final Boolean mallow_post;
    public final Announcement mannouncement;
    public final Image mavatar;
    public final BannerSetting mbanner_setting;
    public final ChatBizContent mbiz_content;
    public final Map<Integer, Long> mbiz_version_map;
    public final Long mburned_time;
    public final Long mchat_chatter_version;
    public final ChatConfig mchat_config;
    public final ChatEntitySetting mchat_entity_setting;
    public final GeneralChatSetting mchat_general_setting;
    public final ChatMode mchat_mode;
    public final ChatSecurityConfig mchat_security_config;
    public final Map<Integer, Integer> mchatter_extra_states;
    public final Long mcreate_time;
    public final CryptoChatInfo mcrypto_chat_info;
    public final String mdescription;
    public final Boolean menable_watermark;
    public final Map<String, String> mextra;
    public final Long mfilter_mute_bot_badge_count_version;
    public final Integer mfirst_chat_message_position;
    public final Map<Integer, Boolean> mgroup_type;
    public final Boolean mhas_chat_menu;
    public final I18nInf mi18n_inf;
    public final Map<String, String> mi18n_names;
    public final String mid;
    public final Boolean mis_admin;
    public final Boolean mis_cross_tenant;
    public final Boolean mis_cross_tenant_v1;
    public final Boolean mis_cross_with_ka;
    public final Boolean mis_crypto;
    public final Boolean mis_custom_icon;
    public final Boolean mis_customer_service;
    public final Boolean mis_department;
    public final Boolean mis_department_v1;
    public final Boolean mis_dissolved;
    public final Boolean mis_edu;
    public final Boolean mis_frozen;
    public final Boolean mis_invisible;
    public final Boolean mis_large_group;
    public final Boolean mis_meeting;
    public final Boolean mis_p2p_ai;
    public final Boolean mis_p2p_official_bot_ai;
    public final Boolean mis_private_mode;
    public final Boolean mis_public;
    public final Boolean mis_public_v2;
    public final Boolean mis_remind;
    public final Boolean mis_same_page_meeting;
    public final Boolean mis_super;
    public final Boolean mis_team;
    public final Boolean mis_tenant;
    public final Long mjoin_time_ms;
    public final String mkey;
    public final String mlast_message_id;
    public final Integer mlast_message_position;
    public final Integer mlast_message_position_badge_count;
    public final Integer mlast_message_position_filter_mute_bot_badge_count;
    public final String mlast_thread_id;
    public final Integer mlast_thread_message_position_filter_mute_bot_badge_count;
    public final Integer mlast_thread_position;
    public final Integer mlast_thread_position_badge_count;
    public final String mlast_visible_message_id;
    public final Integer mlast_visible_message_no_badged_count;
    public final Integer mlast_visible_message_position;
    public final String mlast_visible_thread_id;
    public final Integer mlast_visible_thread_position;
    public final Integer mmember_count;
    public final MessageLastVisibleInfoPatch mmessage_last_visible_patch;
    public final Image mmini_avatar;
    public final Long mmy_threads_last_display_message_id;
    public final Long mmy_threads_last_timestamp;
    public final Long mmy_threads_read_timestamp;
    public final Integer mmy_threads_unread_count;
    public final String mname;
    public final String mname_pinyin;
    public final String mname_py;
    public final Integer mnew_message_count;
    public final Integer mnew_thread_count;
    public final Integer mno_badged_new_message_count;
    public final Integer mno_badged_new_thread_count;
    public final Boolean moff_edit_group_chat_info;
    public final Long moncall_id;
    public final String mopen_chat_id;
    public final String mowner_id;
    public final ChatPostType mpost_type;
    public final Integer mput_chatter_apply_count;
    public final Integer mread_position;
    public final Integer mread_position_badge_count;
    public final Integer mread_position_filter_mute_bot_badge_count;
    public final Integer mread_thread_position;
    public final Integer mread_thread_position_badge_count;
    public final Integer mread_thread_position_filter_mute_bot_badge_count;
    public final Role mrole;
    public final Boolean mshow_banner;
    public final String msidebar_id;
    public final Status mstatus;
    public final SupportView msupport_view;
    public final SystemBannedInfo msystem_banned_info;
    public final TagData mtag_data;
    public final List<Integer> mtags;
    public final String mtenant_id;
    public final MessageLastVisibleInfoPatch mthread_last_visible_patch;
    public final Integer mthread_start_position;
    public final TnsOpKind mtns_op_kind;
    public final ChatToolkit mtoolkit;
    public final Type mtype;
    public final Long mupdate_time;
    public final Long mupdate_time_ms;
    public final ChatUserAutoMuteSetting muser_auto_mute_setting;
    public final Long muser_clean_message_time_ms;
    public final Integer muser_count;
    public final ChatSetting muser_setting;

    public static final class Announcement extends com.squareup.wire.Message<Announcement, Builder> {
        public static final ProtoAdapter<Announcement> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_DOC_URL = "";
        public static final Boolean DEFAULT_ENABLE_OPENDOC = null;
        public static final String DEFAULT_LAST_EDITOR_ID = "";
        public static final Long DEFAULT_UPDATE_TIME = null;
        public static final Boolean DEFAULT_USE_OPENDOC = null;
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final String mdoc_url;
        public final Boolean menable_opendoc;
        public final String mlast_editor_id;
        public final Long mupdate_time;
        public final Boolean muse_opendoc;

        public static final class Builder extends com.squareup.wire.Message.Builder<Announcement, Builder> {
            public String mcontent;
            public String mdoc_url;
            public Boolean menable_opendoc;
            public String mlast_editor_id;
            public Long mupdate_time;
            public Boolean muse_opendoc;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Announcement m1062build() {
                return new Announcement(this.mcontent, this.mupdate_time, this.mlast_editor_id, this.mdoc_url, this.menable_opendoc, this.muse_opendoc, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1062build();
            }

            public Builder content(String r1) {
                this.mcontent = r1;
                return this;
            }

            public Builder doc_url(String r1) {
                this.mdoc_url = r1;
                return this;
            }

            public Builder enable_opendoc(Boolean r1) {
                this.menable_opendoc = r1;
                return this;
            }

            public Builder last_editor_id(String r1) {
                this.mlast_editor_id = r1;
                return this;
            }

            public Builder update_time(Long r1) {
                this.mupdate_time = r1;
                return this;
            }

            public Builder use_opendoc(Boolean r1) {
                this.muse_opendoc = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Announcement extends ProtoAdapter<Announcement> {
            public ProtoAdapter_Announcement() {
                super(FieldEncoding.LENGTH_DELIMITED, Announcement.class);
            }

            public Announcement decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mcontent = "";
                r0.mupdate_time = 0L;
                r0.mlast_editor_id = "";
                r0.mdoc_url = "";
                r0.menable_opendoc = Boolean.FALSE;
                r0.muse_opendoc = Boolean.TRUE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L13;
                switch(r3) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r0.muse_opendoc = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L8:
                r0.menable_opendoc = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L9:
                r0.mdoc_url = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                r0.mlast_editor_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L12:
                r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L6:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L13:
                r7.endMessage(r1);
                return r0.m1062build();
            }

            public int encodedSize(Announcement r6) {
                String r0 = r6.mcontent;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                Long r3 = r6.mupdate_time;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mlast_editor_id;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.mdoc_url;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                Boolean r13 = r6.menable_opendoc;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                Boolean r16 = r6.muse_opendoc;
                if (r16 == null) goto L26;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r16);
            L26:
                return (r15 + r1) + r6.unknownFields().size();
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r4 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1063decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Announcement) r1);
            }

            public void encode(ProtoWriter r4, Announcement r5) throws IOException {
                String r0 = r5.mcontent;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                Long r1 = r5.mupdate_time;
                if (r1 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mlast_editor_id;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.mdoc_url;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                Boolean r6 = r5.menable_opendoc;
                if (r6 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
            L17:
                Boolean r7 = r5.muse_opendoc;
                if (r7 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r4, 6, r7);
            L20:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Announcement) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Announcement();
            DEFAULT_UPDATE_TIME = 0L;
            DEFAULT_ENABLE_OPENDOC = Boolean.FALSE;
            DEFAULT_USE_OPENDOC = Boolean.TRUE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1061newBuilder() {
            Builder r0 = new Builder();
            r0.mcontent = this.mcontent;
            r0.mupdate_time = this.mupdate_time;
            r0.mlast_editor_id = this.mlast_editor_id;
            r0.mdoc_url = this.mdoc_url;
            r0.menable_opendoc = this.menable_opendoc;
            r0.muse_opendoc = this.muse_opendoc;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Announcement.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1061newBuilder();
        }

        public Announcement(String r9, Long r10, String r11, String r12, Boolean r13, Boolean r14) {
            this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
        }

        public Announcement(String r2, Long r3, String r4, String r5, Boolean r6, Boolean r7, ByteString r8) {
            super(ADAPTER, r8);
            this.mcontent = r2;
            this.mupdate_time = r3;
            this.mlast_editor_id = r4;
            this.mdoc_url = r5;
            this.menable_opendoc = r6;
            this.muse_opendoc = r7;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<Chat, Builder> {
        public Boolean mallow_post;
        public Announcement mannouncement;
        public Image mavatar;
        public BannerSetting mbanner_setting;
        public ChatBizContent mbiz_content;
        public Map<Integer, Long> mbiz_version_map;
        public Long mburned_time;
        public Long mchat_chatter_version;
        public ChatConfig mchat_config;
        public ChatEntitySetting mchat_entity_setting;
        public GeneralChatSetting mchat_general_setting;
        public ChatMode mchat_mode;
        public ChatSecurityConfig mchat_security_config;
        public Map<Integer, Integer> mchatter_extra_states;
        public Long mcreate_time;
        public CryptoChatInfo mcrypto_chat_info;
        public String mdescription;
        public Boolean menable_watermark;
        public Map<String, String> mextra;
        public Long mfilter_mute_bot_badge_count_version;
        public Integer mfirst_chat_message_position;
        public Map<Integer, Boolean> mgroup_type;
        public Boolean mhas_chat_menu;
        public I18nInf mi18n_inf;
        public Map<String, String> mi18n_names;
        public String mid;
        public Boolean mis_admin;
        public Boolean mis_cross_tenant;
        public Boolean mis_cross_tenant_v1;
        public Boolean mis_cross_with_ka;
        public Boolean mis_crypto;
        public Boolean mis_custom_icon;
        public Boolean mis_customer_service;
        public Boolean mis_department;
        public Boolean mis_department_v1;
        public Boolean mis_dissolved;
        public Boolean mis_edu;
        public Boolean mis_frozen;
        public Boolean mis_invisible;
        public Boolean mis_large_group;
        public Boolean mis_meeting;
        public Boolean mis_p2p_ai;
        public Boolean mis_p2p_official_bot_ai;
        public Boolean mis_private_mode;
        public Boolean mis_public;
        public Boolean mis_public_v2;
        public Boolean mis_remind;
        public Boolean mis_same_page_meeting;
        public Boolean mis_super;
        public Boolean mis_team;
        public Boolean mis_tenant;
        public Long mjoin_time_ms;
        public String mkey;
        public String mlast_message_id;
        public Integer mlast_message_position;
        public Integer mlast_message_position_badge_count;
        public Integer mlast_message_position_filter_mute_bot_badge_count;
        public String mlast_thread_id;
        public Integer mlast_thread_message_position_filter_mute_bot_badge_count;
        public Integer mlast_thread_position;
        public Integer mlast_thread_position_badge_count;
        public String mlast_visible_message_id;
        public Integer mlast_visible_message_no_badged_count;
        public Integer mlast_visible_message_position;
        public String mlast_visible_thread_id;
        public Integer mlast_visible_thread_position;
        public Integer mmember_count;
        public MessageLastVisibleInfoPatch mmessage_last_visible_patch;
        public Image mmini_avatar;
        public Long mmy_threads_last_display_message_id;
        public Long mmy_threads_last_timestamp;
        public Long mmy_threads_read_timestamp;
        public Integer mmy_threads_unread_count;
        public String mname;
        public String mname_pinyin;
        public String mname_py;
        public Integer mnew_message_count;
        public Integer mnew_thread_count;
        public Integer mno_badged_new_message_count;
        public Integer mno_badged_new_thread_count;
        public Boolean moff_edit_group_chat_info;
        public Long moncall_id;
        public String mopen_chat_id;
        public String mowner_id;
        public ChatPostType mpost_type;
        public Integer mput_chatter_apply_count;
        public Integer mread_position;
        public Integer mread_position_badge_count;
        public Integer mread_position_filter_mute_bot_badge_count;
        public Integer mread_thread_position;
        public Integer mread_thread_position_badge_count;
        public Integer mread_thread_position_filter_mute_bot_badge_count;
        public Role mrole;
        public Boolean mshow_banner;
        public String msidebar_id;
        public Status mstatus;
        public SupportView msupport_view;
        public SystemBannedInfo msystem_banned_info;
        public TagData mtag_data;
        public List<Integer> mtags;
        public String mtenant_id;
        public MessageLastVisibleInfoPatch mthread_last_visible_patch;
        public Integer mthread_start_position;
        public TnsOpKind mtns_op_kind;
        public ChatToolkit mtoolkit;
        public Type mtype;
        public Long mupdate_time;
        public Long mupdate_time_ms;
        public ChatUserAutoMuteSetting muser_auto_mute_setting;
        public Long muser_clean_message_time_ms;
        public Integer muser_count;
        public ChatSetting muser_setting;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Chat m1064build() {
            return new Chat(this.mid, this.mtype, this.mlast_message_id, this.mname, this.mavatar, this.mowner_id, this.mnew_message_count, this.mstatus, this.mupdate_time, this.mkey, this.mdescription, this.mmember_count, this.mis_department, this.mis_public, this.mlast_message_position, this.muser_count, this.mname_pinyin, this.mcreate_time, this.mis_customer_service, this.mrole, this.mis_custom_icon, this.mno_badged_new_message_count, this.moff_edit_group_chat_info, this.mannouncement, this.mtenant_id, this.mupdate_time_ms, this.mis_remind, this.mchat_entity_setting, this.muser_setting, this.mis_dissolved, this.mis_meeting, this.mlast_visible_message_id, this.mmessage_last_visible_patch, this.mlast_thread_id, this.mnew_thread_count, this.mlast_thread_position, this.mis_crypto, this.mno_badged_new_thread_count, this.mthread_start_position, this.mchat_mode, this.mchat_config, this.mis_cross_tenant, this.mis_tenant, this.msupport_view, this.mjoin_time_ms, this.moncall_id, this.mlast_visible_message_position, this.mlast_visible_message_no_badged_count, this.mread_position, this.mread_position_badge_count, this.mlast_message_position_badge_count, this.menable_watermark, this.mmini_avatar, this.msidebar_id, this.mname_py, this.mi18n_names, this.mi18n_inf, this.mread_thread_position, this.mread_thread_position_badge_count, this.mlast_thread_position_badge_count, this.mlast_visible_thread_position, this.mlast_visible_thread_id, this.mthread_last_visible_patch, this.mchat_security_config, this.mis_public_v2, this.mpost_type, this.mallow_post, this.mburned_time, this.mput_chatter_apply_count, this.mshow_banner, this.mis_large_group, this.mfirst_chat_message_position, this.mtags, this.mextra, this.mis_same_page_meeting, this.mmy_threads_read_timestamp, this.mmy_threads_last_timestamp, this.mis_edu, this.mmy_threads_last_display_message_id, this.mmy_threads_unread_count, this.mis_cross_with_ka, this.mis_admin, this.mis_super, this.mis_team, this.mbiz_content, this.mchatter_extra_states, this.mis_private_mode, this.mopen_chat_id, this.mtoolkit, this.mchat_general_setting, this.mtag_data, this.mgroup_type, this.mbiz_version_map, this.mcrypto_chat_info, this.mis_frozen, this.mchat_chatter_version, this.mis_department_v1, this.mis_p2p_ai, this.mbanner_setting, this.mhas_chat_menu, this.mis_p2p_official_bot_ai, this.mis_invisible, this.mis_cross_tenant_v1, this.muser_auto_mute_setting, this.mread_position_filter_mute_bot_badge_count, this.mlast_message_position_filter_mute_bot_badge_count, this.mread_thread_position_filter_mute_bot_badge_count, this.mlast_thread_message_position_filter_mute_bot_badge_count, this.mfilter_mute_bot_badge_count_version, this.muser_clean_message_time_ms, this.mtns_op_kind, this.msystem_banned_info, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_names = Internal.newMutableMap();
            this.mtags = Internal.newMutableList();
            this.mextra = Internal.newMutableMap();
            this.mchatter_extra_states = Internal.newMutableMap();
            this.mgroup_type = Internal.newMutableMap();
            this.mbiz_version_map = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1064build();
        }

        public Builder allow_post(Boolean r1) {
            this.mallow_post = r1;
            return this;
        }

        public Builder announcement(Announcement r1) {
            this.mannouncement = r1;
            return this;
        }

        public Builder avatar(Image r1) {
            this.mavatar = r1;
            return this;
        }

        public Builder banner_setting(BannerSetting r1) {
            this.mbanner_setting = r1;
            return this;
        }

        public Builder biz_content(ChatBizContent r1) {
            this.mbiz_content = r1;
            return this;
        }

        public Builder biz_version_map(Map<Integer, Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mbiz_version_map = r1;
            return this;
        }

        public Builder burned_time(Long r1) {
            this.mburned_time = r1;
            return this;
        }

        public Builder chat_chatter_version(Long r1) {
            this.mchat_chatter_version = r1;
            return this;
        }

        public Builder chat_config(ChatConfig r1) {
            this.mchat_config = r1;
            return this;
        }

        public Builder chat_entity_setting(ChatEntitySetting r1) {
            this.mchat_entity_setting = r1;
            return this;
        }

        public Builder chat_general_setting(GeneralChatSetting r1) {
            this.mchat_general_setting = r1;
            return this;
        }

        public Builder chat_mode(ChatMode r1) {
            this.mchat_mode = r1;
            return this;
        }

        public Builder chat_security_config(ChatSecurityConfig r1) {
            this.mchat_security_config = r1;
            return this;
        }

        public Builder chatter_extra_states(Map<Integer, Integer> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchatter_extra_states = r1;
            return this;
        }

        public Builder create_time(Long r1) {
            this.mcreate_time = r1;
            return this;
        }

        public Builder crypto_chat_info(CryptoChatInfo r1) {
            this.mcrypto_chat_info = r1;
            return this;
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder enable_watermark(Boolean r1) {
            this.menable_watermark = r1;
            return this;
        }

        public Builder extra(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mextra = r1;
            return this;
        }

        public Builder filter_mute_bot_badge_count_version(Long r1) {
            this.mfilter_mute_bot_badge_count_version = r1;
            return this;
        }

        public Builder first_chat_message_position(Integer r1) {
            this.mfirst_chat_message_position = r1;
            return this;
        }

        public Builder group_type(Map<Integer, Boolean> r1) {
            Internal.checkElementsNotNull(r1);
            this.mgroup_type = r1;
            return this;
        }

        public Builder has_chat_menu(Boolean r1) {
            this.mhas_chat_menu = r1;
            return this;
        }

        public Builder i18n_inf(I18nInf r1) {
            this.mi18n_inf = r1;
            return this;
        }

        public Builder i18n_names(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_names = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder is_admin(Boolean r1) {
            this.mis_admin = r1;
            return this;
        }

        public Builder is_cross_tenant(Boolean r1) {
            this.mis_cross_tenant = r1;
            return this;
        }

        public Builder is_cross_tenant_v1(Boolean r1) {
            this.mis_cross_tenant_v1 = r1;
            return this;
        }

        public Builder is_cross_with_ka(Boolean r1) {
            this.mis_cross_with_ka = r1;
            return this;
        }

        public Builder is_crypto(Boolean r1) {
            this.mis_crypto = r1;
            return this;
        }

        public Builder is_custom_icon(Boolean r1) {
            this.mis_custom_icon = r1;
            return this;
        }

        public Builder is_customer_service(Boolean r1) {
            this.mis_customer_service = r1;
            return this;
        }

        public Builder is_department(Boolean r1) {
            this.mis_department = r1;
            return this;
        }

        public Builder is_department_v1(Boolean r1) {
            this.mis_department_v1 = r1;
            return this;
        }

        public Builder is_dissolved(Boolean r1) {
            this.mis_dissolved = r1;
            return this;
        }

        public Builder is_edu(Boolean r1) {
            this.mis_edu = r1;
            return this;
        }

        public Builder is_frozen(Boolean r1) {
            this.mis_frozen = r1;
            return this;
        }

        public Builder is_invisible(Boolean r1) {
            this.mis_invisible = r1;
            return this;
        }

        public Builder is_large_group(Boolean r1) {
            this.mis_large_group = r1;
            return this;
        }

        public Builder is_meeting(Boolean r1) {
            this.mis_meeting = r1;
            return this;
        }

        public Builder is_p2p_ai(Boolean r1) {
            this.mis_p2p_ai = r1;
            return this;
        }

        public Builder is_p2p_official_bot_ai(Boolean r1) {
            this.mis_p2p_official_bot_ai = r1;
            return this;
        }

        public Builder is_private_mode(Boolean r1) {
            this.mis_private_mode = r1;
            return this;
        }

        public Builder is_public(Boolean r1) {
            this.mis_public = r1;
            return this;
        }

        public Builder is_public_v2(Boolean r1) {
            this.mis_public_v2 = r1;
            return this;
        }

        public Builder is_remind(Boolean r1) {
            this.mis_remind = r1;
            return this;
        }

        public Builder is_same_page_meeting(Boolean r1) {
            this.mis_same_page_meeting = r1;
            return this;
        }

        public Builder is_super(Boolean r1) {
            this.mis_super = r1;
            return this;
        }

        public Builder is_team(Boolean r1) {
            this.mis_team = r1;
            return this;
        }

        public Builder is_tenant(Boolean r1) {
            this.mis_tenant = r1;
            return this;
        }

        public Builder join_time_ms(Long r1) {
            this.mjoin_time_ms = r1;
            return this;
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder last_message_id(String r1) {
            this.mlast_message_id = r1;
            return this;
        }

        public Builder last_message_position(Integer r1) {
            this.mlast_message_position = r1;
            return this;
        }

        public Builder last_message_position_badge_count(Integer r1) {
            this.mlast_message_position_badge_count = r1;
            return this;
        }

        public Builder last_message_position_filter_mute_bot_badge_count(Integer r1) {
            this.mlast_message_position_filter_mute_bot_badge_count = r1;
            return this;
        }

        public Builder last_thread_id(String r1) {
            this.mlast_thread_id = r1;
            return this;
        }

        public Builder last_thread_message_position_filter_mute_bot_badge_count(Integer r1) {
            this.mlast_thread_message_position_filter_mute_bot_badge_count = r1;
            return this;
        }

        public Builder last_thread_position(Integer r1) {
            this.mlast_thread_position = r1;
            return this;
        }

        public Builder last_thread_position_badge_count(Integer r1) {
            this.mlast_thread_position_badge_count = r1;
            return this;
        }

        public Builder last_visible_message_id(String r1) {
            this.mlast_visible_message_id = r1;
            return this;
        }

        public Builder last_visible_message_no_badged_count(Integer r1) {
            this.mlast_visible_message_no_badged_count = r1;
            return this;
        }

        public Builder last_visible_message_position(Integer r1) {
            this.mlast_visible_message_position = r1;
            return this;
        }

        public Builder last_visible_thread_id(String r1) {
            this.mlast_visible_thread_id = r1;
            return this;
        }

        public Builder last_visible_thread_position(Integer r1) {
            this.mlast_visible_thread_position = r1;
            return this;
        }

        public Builder member_count(Integer r1) {
            this.mmember_count = r1;
            return this;
        }

        public Builder message_last_visible_patch(MessageLastVisibleInfoPatch r1) {
            this.mmessage_last_visible_patch = r1;
            return this;
        }

        public Builder mini_avatar(Image r1) {
            this.mmini_avatar = r1;
            return this;
        }

        public Builder my_threads_last_display_message_id(Long r1) {
            this.mmy_threads_last_display_message_id = r1;
            return this;
        }

        public Builder my_threads_last_timestamp(Long r1) {
            this.mmy_threads_last_timestamp = r1;
            return this;
        }

        public Builder my_threads_read_timestamp(Long r1) {
            this.mmy_threads_read_timestamp = r1;
            return this;
        }

        public Builder my_threads_unread_count(Integer r1) {
            this.mmy_threads_unread_count = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder name_pinyin(String r1) {
            this.mname_pinyin = r1;
            return this;
        }

        public Builder name_py(String r1) {
            this.mname_py = r1;
            return this;
        }

        public Builder new_message_count(Integer r1) {
            this.mnew_message_count = r1;
            return this;
        }

        public Builder new_thread_count(Integer r1) {
            this.mnew_thread_count = r1;
            return this;
        }

        public Builder no_badged_new_message_count(Integer r1) {
            this.mno_badged_new_message_count = r1;
            return this;
        }

        public Builder no_badged_new_thread_count(Integer r1) {
            this.mno_badged_new_thread_count = r1;
            return this;
        }

        public Builder off_edit_group_chat_info(Boolean r1) {
            this.moff_edit_group_chat_info = r1;
            return this;
        }

        public Builder oncall_id(Long r1) {
            this.moncall_id = r1;
            return this;
        }

        public Builder open_chat_id(String r1) {
            this.mopen_chat_id = r1;
            return this;
        }

        public Builder owner_id(String r1) {
            this.mowner_id = r1;
            return this;
        }

        public Builder post_type(ChatPostType r1) {
            this.mpost_type = r1;
            return this;
        }

        public Builder put_chatter_apply_count(Integer r1) {
            this.mput_chatter_apply_count = r1;
            return this;
        }

        public Builder read_position(Integer r1) {
            this.mread_position = r1;
            return this;
        }

        public Builder read_position_badge_count(Integer r1) {
            this.mread_position_badge_count = r1;
            return this;
        }

        public Builder read_position_filter_mute_bot_badge_count(Integer r1) {
            this.mread_position_filter_mute_bot_badge_count = r1;
            return this;
        }

        public Builder read_thread_position(Integer r1) {
            this.mread_thread_position = r1;
            return this;
        }

        public Builder read_thread_position_badge_count(Integer r1) {
            this.mread_thread_position_badge_count = r1;
            return this;
        }

        public Builder read_thread_position_filter_mute_bot_badge_count(Integer r1) {
            this.mread_thread_position_filter_mute_bot_badge_count = r1;
            return this;
        }

        public Builder role(Role r1) {
            this.mrole = r1;
            return this;
        }

        public Builder show_banner(Boolean r1) {
            this.mshow_banner = r1;
            return this;
        }

        public Builder sidebar_id(String r1) {
            this.msidebar_id = r1;
            return this;
        }

        public Builder status(Status r1) {
            this.mstatus = r1;
            return this;
        }

        public Builder support_view(SupportView r1) {
            this.msupport_view = r1;
            return this;
        }

        public Builder system_banned_info(SystemBannedInfo r1) {
            this.msystem_banned_info = r1;
            return this;
        }

        public Builder tag_data(TagData r1) {
            this.mtag_data = r1;
            return this;
        }

        public Builder tags(List<Integer> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtags = r1;
            return this;
        }

        public Builder tenant_id(String r1) {
            this.mtenant_id = r1;
            return this;
        }

        public Builder thread_last_visible_patch(MessageLastVisibleInfoPatch r1) {
            this.mthread_last_visible_patch = r1;
            return this;
        }

        public Builder thread_start_position(Integer r1) {
            this.mthread_start_position = r1;
            return this;
        }

        public Builder tns_op_kind(TnsOpKind r1) {
            this.mtns_op_kind = r1;
            return this;
        }

        public Builder toolkit(ChatToolkit r1) {
            this.mtoolkit = r1;
            return this;
        }

        public Builder type(Type r1) {
            this.mtype = r1;
            return this;
        }

        public Builder update_time(Long r1) {
            this.mupdate_time = r1;
            return this;
        }

        public Builder update_time_ms(Long r1) {
            this.mupdate_time_ms = r1;
            return this;
        }

        public Builder user_auto_mute_setting(ChatUserAutoMuteSetting r1) {
            this.muser_auto_mute_setting = r1;
            return this;
        }

        public Builder user_clean_message_time_ms(Long r1) {
            this.muser_clean_message_time_ms = r1;
            return this;
        }

        public Builder user_count(Integer r1) {
            this.muser_count = r1;
            return this;
        }

        public Builder user_setting(ChatSetting r1) {
            this.muser_setting = r1;
            return this;
        }
    }

    public static final enum ChatMode extends Enum<ChatMode> implements WireEnum {
        private static final /* synthetic */ ChatMode[] $VALUES = null;
        public static final ProtoAdapter<ChatMode> ADAPTER = null;
        public static final ChatMode DEFAULT = null;
        public static final ChatMode THREAD = null;
        public static final ChatMode THREAD_V2 = null;
        public static final ChatMode UNKNOWN_CHAT_MODE = null;
        private final int value;

        static {
            ChatMode r0 = new ChatMode("UNKNOWN_CHAT_MODE", 0, 0);
            UNKNOWN_CHAT_MODE = r0;
            ChatMode r1 = new ChatMode("DEFAULT", 1, 1);
            DEFAULT = r1;
            ChatMode r3 = new ChatMode("THREAD", 2, 2);
            THREAD = r3;
            ChatMode r5 = new ChatMode("THREAD_V2", 3, 3);
            THREAD_V2 = r5;
            $VALUES = new ChatMode[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(ChatMode.class);
        }

        public static ChatMode[] values() {
            return (ChatMode[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ChatMode fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return THREAD_V2;
        L14:
            return THREAD;
        L16:
            return DEFAULT;
        L18:
            return UNKNOWN_CHAT_MODE;
        }

        public static ChatMode valueOf(String r1) {
            return (ChatMode) a.a(ChatMode.class, r1);
        }

        private ChatMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class I18nInf extends com.squareup.wire.Message<I18nInf, Builder> {
        public static final ProtoAdapter<I18nInf> ADAPTER = null;
        public static final String DEFAULT_VERSION = "";
        private static final long serialVersionUID = 0;
        public final Map<String, Double> mchat_name_language_ratio;
        public final I18nNameType mi18n_name_type;
        public final Map<String, String> mi18n_names;
        public final Map<String, String> mi18n_translated_names;
        public final String mversion;

        public static final class Builder extends com.squareup.wire.Message.Builder<I18nInf, Builder> {
            public Map<String, Double> mchat_name_language_ratio;
            public I18nNameType mi18n_name_type;
            public Map<String, String> mi18n_names;
            public Map<String, String> mi18n_translated_names;
            public String mversion;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public I18nInf m1066build() {
                return new I18nInf(this.mi18n_names, this.mi18n_translated_names, this.mi18n_name_type, this.mchat_name_language_ratio, this.mversion, super.buildUnknownFields());
            }

            public Builder() {
                this.mi18n_names = Internal.newMutableMap();
                this.mi18n_translated_names = Internal.newMutableMap();
                this.mchat_name_language_ratio = Internal.newMutableMap();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1066build();
            }

            public Builder chat_name_language_ratio(Map<String, Double> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_name_language_ratio = r1;
                return this;
            }

            public Builder i18n_name_type(I18nNameType r1) {
                this.mi18n_name_type = r1;
                return this;
            }

            public Builder i18n_names(Map<String, String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mi18n_names = r1;
                return this;
            }

            public Builder i18n_translated_names(Map<String, String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mi18n_translated_names = r1;
                return this;
            }

            public Builder version(String r1) {
                this.mversion = r1;
                return this;
            }
        }

        public static final enum I18nNameType extends Enum<I18nNameType> implements WireEnum {
            private static final /* synthetic */ I18nNameType[] $VALUES = null;
            public static final ProtoAdapter<I18nNameType> ADAPTER = null;
            public static final I18nNameType CUSTOM = null;
            public static final I18nNameType DEFAULT = null;
            public static final I18nNameType TRANSLATE = null;
            public static final I18nNameType UNKNOWN = null;
            private final int value;

            static {
                I18nNameType r0 = new I18nNameType("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                I18nNameType r1 = new I18nNameType("DEFAULT", 1, 1);
                DEFAULT = r1;
                I18nNameType r3 = new I18nNameType("CUSTOM", 2, 2);
                CUSTOM = r3;
                I18nNameType r5 = new I18nNameType("TRANSLATE", 3, 3);
                TRANSLATE = r5;
                $VALUES = new I18nNameType[]{r0, r1, r3, r5};
                ADAPTER = ProtoAdapter.newEnumAdapter(I18nNameType.class);
            }

            public static I18nNameType[] values() {
                return (I18nNameType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static I18nNameType fromValue(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return TRANSLATE;
            L14:
                return CUSTOM;
            L16:
                return DEFAULT;
            L18:
                return UNKNOWN;
            }

            public static I18nNameType valueOf(String r1) {
                return (I18nNameType) a.a(I18nNameType.class, r1);
            }

            private I18nNameType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_I18nInf extends ProtoAdapter<I18nInf> {
            private final ProtoAdapter<Map<String, Double>> mchat_name_language_ratio;
            private final ProtoAdapter<Map<String, String>> mi18n_names;
            private final ProtoAdapter<Map<String, String>> mi18n_translated_names;

            public ProtoAdapter_I18nInf() {
                super(FieldEncoding.LENGTH_DELIMITED, I18nInf.class);
                ProtoAdapter r0 = ProtoAdapter.STRING;
                this.mi18n_names = ProtoAdapter.newMapAdapter(r0, r0);
                this.mi18n_translated_names = ProtoAdapter.newMapAdapter(r0, r0);
                this.mchat_name_language_ratio = ProtoAdapter.newMapAdapter(r0, ProtoAdapter.DOUBLE);
            }

            public I18nInf decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mversion = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L24;
                if (r3 != 1) goto L8;
                r0.mi18n_names.putAll((Map) this.mi18n_names.decode(r9));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mi18n_translated_names.putAll((Map) this.mi18n_translated_names.decode(r9));
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mi18n_name_type = (I18nNameType) I18nNameType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.mchat_name_language_ratio.putAll((Map) this.mchat_name_language_ratio.decode(r9));
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.mversion = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L15:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L24:
                r9.endMessage(r1);
                return r0.m1066build();
            }

            public int encodedSize(I18nInf r6) {
                int r0 = this.mi18n_names.encodedSizeWithTag(1, r6.mi18n_names) + this.mi18n_translated_names.encodedSizeWithTag(2, r6.mi18n_translated_names);
                I18nNameType r1 = r6.mi18n_name_type;
                int r2 = 0;
                if (r1 == null) goto L5;
                int r3 = I18nNameType.ADAPTER.encodedSizeWithTag(3, r1);
            L6:
                int r4 = (r0 + r3) + this.mchat_name_language_ratio.encodedSizeWithTag(4, r6.mchat_name_language_ratio);
                String r5 = r6.mversion;
                if (r5 == null) goto L10;
                r2 = ProtoAdapter.STRING.encodedSizeWithTag(5, r5);
            L10:
                return (r4 + r2) + r6.unknownFields().size();
            L5:
                r3 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1067decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((I18nInf) r1);
            }

            public void encode(ProtoWriter r4, I18nInf r5) throws IOException {
                this.mi18n_names.encodeWithTag(r4, 1, r5.mi18n_names);
                this.mi18n_translated_names.encodeWithTag(r4, 2, r5.mi18n_translated_names);
                I18nNameType r0 = r5.mi18n_name_type;
                if (r0 == null) goto L5;
                I18nNameType.ADAPTER.encodeWithTag(r4, 3, r0);
            L5:
                this.mchat_name_language_ratio.encodeWithTag(r4, 4, r5.mchat_name_language_ratio);
                String r1 = r5.mversion;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 5, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (I18nInf) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_I18nInf();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1065newBuilder() {
            Builder r0 = new Builder();
            r0.mi18n_names = Internal.copyOf("mi18n_names", this.mi18n_names);
            r0.mi18n_translated_names = Internal.copyOf("mi18n_translated_names", this.mi18n_translated_names);
            r0.mi18n_name_type = this.mi18n_name_type;
            r0.mchat_name_language_ratio = Internal.copyOf("mchat_name_language_ratio", this.mchat_name_language_ratio);
            r0.mversion = this.mversion;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return I18nInf.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1065newBuilder();
        }

        public I18nInf(Map<String, String> r8, Map<String, String> r9, I18nNameType r10, Map<String, Double> r11, String r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public I18nInf(Map<String, String> r2, Map<String, String> r3, I18nNameType r4, Map<String, Double> r5, String r6, ByteString r7) {
            super(ADAPTER, r7);
            this.mi18n_names = Internal.immutableCopyOf("mi18n_names", r2);
            this.mi18n_translated_names = Internal.immutableCopyOf("mi18n_translated_names", r3);
            this.mi18n_name_type = r4;
            this.mchat_name_language_ratio = Internal.immutableCopyOf("mchat_name_language_ratio", r5);
            this.mversion = r6;
        }
    }

    public static final class ProtoAdapter_Chat extends ProtoAdapter<Chat> {
        private final ProtoAdapter<Map<Integer, Long>> mbiz_version_map;
        private final ProtoAdapter<Map<Integer, Integer>> mchatter_extra_states;
        private final ProtoAdapter<Map<String, String>> mextra;
        private final ProtoAdapter<Map<Integer, Boolean>> mgroup_type;
        private final ProtoAdapter<Map<String, String>> mi18n_names;

        public ProtoAdapter_Chat() {
            super(FieldEncoding.LENGTH_DELIMITED, Chat.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mi18n_names = ProtoAdapter.newMapAdapter(r0, r0);
            this.mextra = ProtoAdapter.newMapAdapter(r0, r0);
            ProtoAdapter r1 = ProtoAdapter.INT32;
            this.mchatter_extra_states = ProtoAdapter.newMapAdapter(r1, r1);
            this.mgroup_type = ProtoAdapter.newMapAdapter(r1, ProtoAdapter.BOOL);
            this.mbiz_version_map = ProtoAdapter.newMapAdapter(r1, ProtoAdapter.INT64);
        }

        public Chat decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mlast_message_id = "";
            r0.mname = "";
            r0.mowner_id = "";
            r0.mnew_message_count = 0;
            r0.mupdate_time = 0L;
            r0.mkey = "";
            r0.mdescription = "";
            r0.mmember_count = 0;
            Boolean r4 = Boolean.FALSE;
            r0.mis_department = r4;
            r0.mis_public = r4;
            r0.mlast_message_position = 0;
            r0.muser_count = 0;
            r0.mname_pinyin = "";
            r0.mcreate_time = 0L;
            r0.mis_customer_service = r4;
            r0.mis_custom_icon = r4;
            r0.mno_badged_new_message_count = 0;
            r0.moff_edit_group_chat_info = r4;
            r0.mtenant_id = "";
            r0.mupdate_time_ms = 0L;
            r0.mis_remind = Boolean.TRUE;
            r0.mis_dissolved = r4;
            r0.mis_meeting = r4;
            r0.mlast_visible_message_id = "";
            r0.mlast_thread_id = "";
            r0.mnew_thread_count = 0;
            r0.mlast_thread_position = 0;
            r0.mis_crypto = r4;
            r0.mno_badged_new_thread_count = 0;
            r0.mthread_start_position = 0;
            r0.mis_cross_tenant = r4;
            r0.mis_tenant = r4;
            r0.mjoin_time_ms = 0L;
            r0.moncall_id = 0L;
            r0.mlast_visible_message_position = 0;
            r0.mlast_visible_message_no_badged_count = 0;
            r0.mread_position = 0;
            r0.mread_position_badge_count = 0;
            r0.mlast_message_position_badge_count = 0;
            r0.menable_watermark = r4;
            r0.msidebar_id = "";
            r0.mname_py = "";
            r0.mread_thread_position = 0;
            r0.mread_thread_position_badge_count = 0;
            r0.mlast_thread_position_badge_count = 0;
            r0.mlast_visible_thread_position = 0;
            r0.mlast_visible_thread_id = "";
            r0.mis_public_v2 = r4;
            r0.mallow_post = r4;
            r0.mburned_time = 0L;
            r0.mput_chatter_apply_count = 0;
            r0.mshow_banner = r4;
            r0.mis_large_group = r4;
            r0.mfirst_chat_message_position = 0;
            r0.mis_same_page_meeting = r4;
            r0.mmy_threads_read_timestamp = 0L;
            r0.mmy_threads_last_timestamp = 0L;
            r0.mis_edu = r4;
            r0.mmy_threads_last_display_message_id = 0L;
            r0.mmy_threads_unread_count = 0;
            r0.mis_cross_with_ka = r4;
            r0.mis_admin = r4;
            r0.mis_super = r4;
            r0.mis_team = r4;
            r0.mis_private_mode = r4;
            r0.mopen_chat_id = "";
            r0.mis_frozen = r4;
            r0.mchat_chatter_version = 0L;
            r0.mis_department_v1 = r4;
            r0.mis_p2p_ai = r4;
            r0.mhas_chat_menu = r4;
            r0.mis_p2p_official_bot_ai = r4;
            r0.mis_invisible = r4;
            r0.mis_cross_tenant_v1 = r4;
            r0.mread_position_filter_mute_bot_badge_count = 0;
            r0.mlast_message_position_filter_mute_bot_badge_count = 0;
            r0.mread_thread_position_filter_mute_bot_badge_count = 0;
            r0.mlast_thread_message_position_filter_mute_bot_badge_count = 0;
            r0.mfilter_mute_bot_badge_count_version = 0L;
            r0.muser_clean_message_time_ms = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L141;
            switch(r3) {
                case 1: goto L140;
                case 2: goto L145;
                case 3: goto L135;
                case 4: goto L134;
                case 5: goto L133;
                case 6: goto L132;
                case 7: goto L131;
                case 8: goto L151;
                case 9: goto L126;
                case 10: goto L125;
                case 11: goto L124;
                case 12: goto L123;
                case 13: goto L122;
                case 14: goto L121;
                case 15: goto L120;
                case 16: goto L119;
                case 17: goto L118;
                case 18: goto L117;
                case 19: goto L116;
                case 20: goto L147;
                case 21: goto L111;
                case 22: goto L110;
                case 23: goto L109;
                case 24: goto L108;
                case 25: goto L107;
                case 26: goto L106;
                case 27: goto L105;
                case 28: goto L104;
                case 29: goto L103;
                case 30: goto L102;
                case 31: goto L101;
                case 32: goto L100;
                case 33: goto L99;
                case 34: goto L98;
                case 35: goto L97;
                case 36: goto L96;
                case 37: goto L95;
                case 38: goto L94;
                case 39: goto L155;
                case 40: goto L89;
                case 41: goto L88;
                case 42: goto L87;
                case 43: goto L153;
                case 44: goto L82;
                case 45: goto L81;
                case 46: goto L80;
                case 47: goto L79;
                case 48: goto L78;
                case 49: goto L77;
                case 50: goto L76;
                case 51: goto L75;
                case 52: goto L74;
                case 53: goto L73;
                default: goto L6;
            };
        L145:
            r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L138
        L138:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L147:
            r0.mrole = (Role) Role.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L114
        L114:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L151:
            r0.mstatus = (Status) Status.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L129
        L129:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L153:
            r0.msupport_view = (SupportView) SupportView.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L85
        L85:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L155:
            r0.mchat_mode = (ChatMode) ChatMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L92
        L92:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L73:
            r0.msidebar_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L74:
            r0.mmini_avatar = (Image) Image.ADAPTER.decode(r9);
            goto L3
        L75:
            r0.menable_watermark = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L76:
            r0.mlast_message_position_badge_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L77:
            r0.mread_position_badge_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L78:
            r0.mread_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L79:
            r0.mlast_visible_message_no_badged_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L80:
            r0.mlast_visible_message_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L81:
            r0.moncall_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L82:
            r0.mjoin_time_ms = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L87:
            r0.mis_tenant = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L88:
            r0.mis_cross_tenant = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L89:
            r0.mchat_config = (ChatConfig) ChatConfig.ADAPTER.decode(r9);
            goto L3
        L94:
            r0.mthread_start_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L95:
            r0.mno_badged_new_thread_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L96:
            r0.mis_crypto = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L97:
            r0.mlast_thread_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L98:
            r0.mnew_thread_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L99:
            r0.mlast_thread_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L100:
            r0.mlast_visible_message_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L101:
            r0.mis_meeting = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L102:
            r0.mis_dissolved = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L103:
            r0.muser_setting = (ChatSetting) ChatSetting.ADAPTER.decode(r9);
            goto L3
        L104:
            r0.mchat_entity_setting = (ChatEntitySetting) ChatEntitySetting.ADAPTER.decode(r9);
            goto L3
        L105:
            r0.mis_remind = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L106:
            r0.mupdate_time_ms = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L107:
            r0.mtenant_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L108:
            r0.mannouncement = (Announcement) Announcement.ADAPTER.decode(r9);
            goto L3
        L109:
            r0.moff_edit_group_chat_info = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L110:
            r0.mno_badged_new_message_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L111:
            r0.mis_custom_icon = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L116:
            r0.mis_customer_service = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L117:
            r0.mcreate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L118:
            r0.mname_pinyin = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L119:
            r0.muser_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L120:
            r0.mlast_message_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L121:
            r0.mis_public = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L122:
            r0.mis_department = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L123:
            r0.mmember_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L124:
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L125:
            r0.mkey = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L126:
            r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L131:
            r0.mnew_message_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L132:
            r0.mowner_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L133:
            r0.mavatar = (Image) Image.ADAPTER.decode(r9);
            goto L3
        L134:
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L135:
            r0.mlast_message_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L140:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            switch(r3) {
                case 100: goto L72;
                case 101: goto L71;
                case 102: goto L70;
                case 103: goto L69;
                case 104: goto L68;
                case 105: goto L67;
                case 106: goto L66;
                case 107: goto L65;
                case 108: goto L64;
                case 109: goto L63;
                case 110: goto L149;
                case 111: goto L58;
                case 112: goto L57;
                case 113: goto L56;
                case 114: goto L55;
                case 115: goto L54;
                case 116: goto L53;
                case 117: goto L52;
                case 118: goto L51;
                case 119: goto L50;
                case 120: goto L49;
                case 121: goto L48;
                case 122: goto L47;
                case 123: goto L46;
                case 124: goto L45;
                case 125: goto L44;
                case 126: goto L43;
                case 127: goto L42;
                case 128: goto L41;
                case 129: goto L40;
                case 130: goto L39;
                case 131: goto L38;
                case 132: goto L37;
                case 133: goto L36;
                case 134: goto L35;
                case 135: goto L34;
                case 136: goto L33;
                case 137: goto L32;
                case 138: goto L31;
                case 139: goto L30;
                case 140: goto L29;
                case 141: goto L28;
                case 142: goto L27;
                case 143: goto L26;
                case 144: goto L25;
                case 145: goto L24;
                case 146: goto L23;
                case 147: goto L22;
                case 148: goto L21;
                case 149: goto L20;
                case 150: goto L19;
                case 151: goto L18;
                case 152: goto L17;
                case 153: goto L16;
                case 154: goto L15;
                case 155: goto L14;
                case 156: goto L13;
                case 157: goto L143;
                case 158: goto L8;
                default: goto L7;
            };
        L143:
            r0.mtns_op_kind = (TnsOpKind) TnsOpKind.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L149:
            r0.mpost_type = (ChatPostType) ChatPostType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L61
        L61:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            r0.msystem_banned_info = (SystemBannedInfo) SystemBannedInfo.ADAPTER.decode(r9);
            goto L3
        L13:
            r0.muser_clean_message_time_ms = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L14:
            r0.mfilter_mute_bot_badge_count_version = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L15:
            r0.mlast_thread_message_position_filter_mute_bot_badge_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L16:
            r0.mread_thread_position_filter_mute_bot_badge_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L17:
            r0.mlast_message_position_filter_mute_bot_badge_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L18:
            r0.mread_position_filter_mute_bot_badge_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L19:
            r0.muser_auto_mute_setting = (ChatUserAutoMuteSetting) ChatUserAutoMuteSetting.ADAPTER.decode(r9);
            goto L3
        L20:
            r0.mis_cross_tenant_v1 = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L21:
            r0.mis_invisible = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L22:
            r0.mis_p2p_official_bot_ai = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L23:
            r0.mhas_chat_menu = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L24:
            r0.mbanner_setting = (BannerSetting) BannerSetting.ADAPTER.decode(r9);
            goto L3
        L25:
            r0.mis_p2p_ai = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L26:
            r0.mis_department_v1 = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L27:
            r0.mchat_chatter_version = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L28:
            r0.mis_frozen = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L29:
            r0.mcrypto_chat_info = (CryptoChatInfo) CryptoChatInfo.ADAPTER.decode(r9);
            goto L3
        L30:
            r0.mbiz_version_map.putAll((Map) this.mbiz_version_map.decode(r9));
            goto L3
        L31:
            r0.mgroup_type.putAll((Map) this.mgroup_type.decode(r9));
            goto L3
        L32:
            r0.mtag_data = (TagData) TagData.ADAPTER.decode(r9);
            goto L3
        L33:
            r0.mchat_general_setting = (GeneralChatSetting) GeneralChatSetting.ADAPTER.decode(r9);
            goto L3
        L34:
            r0.mtoolkit = (ChatToolkit) ChatToolkit.ADAPTER.decode(r9);
            goto L3
        L35:
            r0.mopen_chat_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L36:
            r0.mis_private_mode = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L37:
            r0.mthread_last_visible_patch = (MessageLastVisibleInfoPatch) MessageLastVisibleInfoPatch.ADAPTER.decode(r9);
            goto L3
        L38:
            r0.mmessage_last_visible_patch = (MessageLastVisibleInfoPatch) MessageLastVisibleInfoPatch.ADAPTER.decode(r9);
            goto L3
        L39:
            r0.mchatter_extra_states.putAll((Map) this.mchatter_extra_states.decode(r9));
            goto L3
        L40:
            r0.mbiz_content = (ChatBizContent) ChatBizContent.ADAPTER.decode(r9);
            goto L3
        L41:
            r0.mis_team = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L42:
            r0.mis_super = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L43:
            r0.mis_admin = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L44:
            r0.mis_cross_with_ka = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L45:
            r0.mmy_threads_unread_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L46:
            r0.mmy_threads_last_display_message_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L47:
            r0.mis_edu = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L48:
            r0.mmy_threads_last_timestamp = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L49:
            r0.mmy_threads_read_timestamp = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L50:
            r0.mis_same_page_meeting = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L51:
            r0.mextra.putAll((Map) this.mextra.decode(r9));
            goto L3
        L52:
            r0.mtags.add((Integer) ProtoAdapter.INT32.decode(r9));
            goto L3
        L53:
            r0.mfirst_chat_message_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L54:
            r0.mis_large_group = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L55:
            r0.mshow_banner = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L56:
            r0.mput_chatter_apply_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L57:
            r0.mburned_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L58:
            r0.mallow_post = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L63:
            r0.mis_public_v2 = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L64:
            r0.mchat_security_config = (ChatSecurityConfig) ChatSecurityConfig.ADAPTER.decode(r9);
            goto L3
        L65:
            r0.mlast_visible_thread_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L66:
            r0.mlast_visible_thread_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L67:
            r0.mlast_thread_position_badge_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L68:
            r0.mread_thread_position_badge_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L69:
            r0.mread_thread_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L70:
            r0.mi18n_inf = (I18nInf) I18nInf.ADAPTER.decode(r9);
            goto L3
        L71:
            r0.mi18n_names.putAll((Map) this.mi18n_names.decode(r9));
            goto L3
        L72:
            r0.mname_py = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L7:
            FieldEncoding r5 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r5, r5.rawProtoAdapter().decode(r9));
            goto L3
        L141:
            r9.endMessage(r1);
            return r0.m1064build();
        }

        public int encodedSize(Chat r7) {
            String r0 = r7.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Type r3 = r7.mtype;
            if (r3 == null) goto L9;
            int r4 = Type.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r6 = r7.mlast_message_id;
            if (r6 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r6);
        L14:
            int r9 = r5 + r8;
            String r10 = r7.mname;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Image r13 = r7.mavatar;
            if (r13 == null) goto L21;
            int r14 = Image.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r7.mowner_id;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Integer r19 = r7.mnew_message_count;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.INT32.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            Status r22 = r7.mstatus;
            if (r22 == null) goto L33;
            int r23 = Status.ADAPTER.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            Long r25 = r7.mupdate_time;
            if (r25 == null) goto L37;
            int r26 = ProtoAdapter.INT64.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            String r28 = r7.mkey;
            if (r28 == null) goto L41;
            int r29 = ProtoAdapter.STRING.encodedSizeWithTag(10, r28);
        L42:
            int r30 = r27 + r29;
            String r31 = r7.mdescription;
            if (r31 == null) goto L45;
            int r32 = ProtoAdapter.STRING.encodedSizeWithTag(11, r31);
        L46:
            int r33 = r30 + r32;
            Integer r34 = r7.mmember_count;
            if (r34 == null) goto L49;
            int r35 = ProtoAdapter.INT32.encodedSizeWithTag(12, r34);
        L50:
            int r36 = r33 + r35;
            Boolean r37 = r7.mis_department;
            if (r37 == null) goto L53;
            int r38 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r37);
        L54:
            int r39 = r36 + r38;
            Boolean r40 = r7.mis_public;
            if (r40 == null) goto L57;
            int r41 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r40);
        L58:
            int r42 = r39 + r41;
            Integer r43 = r7.mlast_message_position;
            if (r43 == null) goto L61;
            int r44 = ProtoAdapter.INT32.encodedSizeWithTag(15, r43);
        L62:
            int r45 = r42 + r44;
            Integer r46 = r7.muser_count;
            if (r46 == null) goto L65;
            int r47 = ProtoAdapter.INT32.encodedSizeWithTag(16, r46);
        L66:
            int r48 = r45 + r47;
            String r49 = r7.mname_pinyin;
            if (r49 == null) goto L69;
            int r50 = ProtoAdapter.STRING.encodedSizeWithTag(17, r49);
        L70:
            int r51 = r48 + r50;
            Long r52 = r7.mcreate_time;
            if (r52 == null) goto L73;
            int r53 = ProtoAdapter.INT64.encodedSizeWithTag(18, r52);
        L74:
            int r54 = r51 + r53;
            Boolean r55 = r7.mis_customer_service;
            if (r55 == null) goto L77;
            int r56 = ProtoAdapter.BOOL.encodedSizeWithTag(19, r55);
        L78:
            int r57 = r54 + r56;
            Role r58 = r7.mrole;
            if (r58 == null) goto L81;
            int r59 = Role.ADAPTER.encodedSizeWithTag(20, r58);
        L82:
            int r60 = r57 + r59;
            Boolean r61 = r7.mis_custom_icon;
            if (r61 == null) goto L85;
            int r62 = ProtoAdapter.BOOL.encodedSizeWithTag(21, r61);
        L86:
            int r63 = r60 + r62;
            Integer r64 = r7.mno_badged_new_message_count;
            if (r64 == null) goto L89;
            int r65 = ProtoAdapter.INT32.encodedSizeWithTag(22, r64);
        L90:
            int r66 = r63 + r65;
            Boolean r67 = r7.moff_edit_group_chat_info;
            if (r67 == null) goto L93;
            int r68 = ProtoAdapter.BOOL.encodedSizeWithTag(23, r67);
        L94:
            int r69 = r66 + r68;
            Announcement r70 = r7.mannouncement;
            if (r70 == null) goto L97;
            int r71 = Announcement.ADAPTER.encodedSizeWithTag(24, r70);
        L98:
            int r72 = r69 + r71;
            String r73 = r7.mtenant_id;
            if (r73 == null) goto L101;
            int r74 = ProtoAdapter.STRING.encodedSizeWithTag(25, r73);
        L102:
            int r75 = r72 + r74;
            Long r76 = r7.mupdate_time_ms;
            if (r76 == null) goto L105;
            int r77 = ProtoAdapter.INT64.encodedSizeWithTag(26, r76);
        L106:
            int r78 = r75 + r77;
            Boolean r79 = r7.mis_remind;
            if (r79 == null) goto L109;
            int r80 = ProtoAdapter.BOOL.encodedSizeWithTag(27, r79);
        L110:
            int r81 = r78 + r80;
            ChatEntitySetting r82 = r7.mchat_entity_setting;
            if (r82 == null) goto L113;
            int r83 = ChatEntitySetting.ADAPTER.encodedSizeWithTag(28, r82);
        L114:
            int r84 = r81 + r83;
            ChatSetting r85 = r7.muser_setting;
            if (r85 == null) goto L117;
            int r86 = ChatSetting.ADAPTER.encodedSizeWithTag(29, r85);
        L118:
            int r87 = r84 + r86;
            Boolean r88 = r7.mis_dissolved;
            if (r88 == null) goto L121;
            int r89 = ProtoAdapter.BOOL.encodedSizeWithTag(30, r88);
        L122:
            int r90 = r87 + r89;
            Boolean r91 = r7.mis_meeting;
            if (r91 == null) goto L125;
            int r92 = ProtoAdapter.BOOL.encodedSizeWithTag(31, r91);
        L126:
            int r93 = r90 + r92;
            String r94 = r7.mlast_visible_message_id;
            if (r94 == null) goto L129;
            int r95 = ProtoAdapter.STRING.encodedSizeWithTag(32, r94);
        L130:
            int r96 = r93 + r95;
            MessageLastVisibleInfoPatch r97 = r7.mmessage_last_visible_patch;
            if (r97 == null) goto L133;
            int r98 = MessageLastVisibleInfoPatch.ADAPTER.encodedSizeWithTag(131, r97);
        L134:
            int r99 = r96 + r98;
            String r100 = r7.mlast_thread_id;
            if (r100 == null) goto L137;
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(33, r100);
        L138:
            int r102 = r99 + r101;
            Integer r103 = r7.mnew_thread_count;
            if (r103 == null) goto L141;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(34, r103);
        L142:
            int r105 = r102 + r104;
            Integer r106 = r7.mlast_thread_position;
            if (r106 == null) goto L145;
            int r107 = ProtoAdapter.INT32.encodedSizeWithTag(35, r106);
        L146:
            int r108 = r105 + r107;
            Boolean r109 = r7.mis_crypto;
            if (r109 == null) goto L149;
            int r110 = ProtoAdapter.BOOL.encodedSizeWithTag(36, r109);
        L150:
            int r111 = r108 + r110;
            Integer r112 = r7.mno_badged_new_thread_count;
            if (r112 == null) goto L153;
            int r113 = ProtoAdapter.INT32.encodedSizeWithTag(37, r112);
        L154:
            int r114 = r111 + r113;
            Integer r115 = r7.mthread_start_position;
            if (r115 == null) goto L157;
            int r116 = ProtoAdapter.INT32.encodedSizeWithTag(38, r115);
        L158:
            int r117 = r114 + r116;
            ChatMode r118 = r7.mchat_mode;
            if (r118 == null) goto L161;
            int r119 = ChatMode.ADAPTER.encodedSizeWithTag(39, r118);
        L162:
            int r120 = r117 + r119;
            ChatConfig r121 = r7.mchat_config;
            if (r121 == null) goto L165;
            int r122 = ChatConfig.ADAPTER.encodedSizeWithTag(40, r121);
        L166:
            int r123 = r120 + r122;
            Boolean r124 = r7.mis_cross_tenant;
            if (r124 == null) goto L169;
            int r125 = ProtoAdapter.BOOL.encodedSizeWithTag(41, r124);
        L170:
            int r126 = r123 + r125;
            Boolean r127 = r7.mis_tenant;
            if (r127 == null) goto L173;
            int r128 = ProtoAdapter.BOOL.encodedSizeWithTag(42, r127);
        L174:
            int r129 = r126 + r128;
            SupportView r130 = r7.msupport_view;
            if (r130 == null) goto L177;
            int r131 = SupportView.ADAPTER.encodedSizeWithTag(43, r130);
        L178:
            int r132 = r129 + r131;
            Long r133 = r7.mjoin_time_ms;
            if (r133 == null) goto L181;
            int r134 = ProtoAdapter.INT64.encodedSizeWithTag(44, r133);
        L182:
            int r135 = r132 + r134;
            Long r136 = r7.moncall_id;
            if (r136 == null) goto L185;
            int r137 = ProtoAdapter.INT64.encodedSizeWithTag(45, r136);
        L186:
            int r138 = r135 + r137;
            Integer r139 = r7.mlast_visible_message_position;
            if (r139 == null) goto L189;
            int r140 = ProtoAdapter.INT32.encodedSizeWithTag(46, r139);
        L190:
            int r141 = r138 + r140;
            Integer r142 = r7.mlast_visible_message_no_badged_count;
            if (r142 == null) goto L193;
            int r143 = ProtoAdapter.INT32.encodedSizeWithTag(47, r142);
        L194:
            int r144 = r141 + r143;
            Integer r145 = r7.mread_position;
            if (r145 == null) goto L197;
            int r146 = ProtoAdapter.INT32.encodedSizeWithTag(48, r145);
        L198:
            int r147 = r144 + r146;
            Integer r148 = r7.mread_position_badge_count;
            if (r148 == null) goto L201;
            int r149 = ProtoAdapter.INT32.encodedSizeWithTag(49, r148);
        L202:
            int r150 = r147 + r149;
            Integer r151 = r7.mlast_message_position_badge_count;
            if (r151 == null) goto L205;
            int r152 = ProtoAdapter.INT32.encodedSizeWithTag(50, r151);
        L206:
            int r153 = r150 + r152;
            Boolean r154 = r7.menable_watermark;
            if (r154 == null) goto L209;
            int r155 = ProtoAdapter.BOOL.encodedSizeWithTag(51, r154);
        L210:
            int r156 = r153 + r155;
            Image r157 = r7.mmini_avatar;
            if (r157 == null) goto L213;
            int r158 = Image.ADAPTER.encodedSizeWithTag(52, r157);
        L214:
            int r159 = r156 + r158;
            String r160 = r7.msidebar_id;
            if (r160 == null) goto L217;
            int r161 = ProtoAdapter.STRING.encodedSizeWithTag(53, r160);
        L218:
            int r162 = r159 + r161;
            String r163 = r7.mname_py;
            if (r163 == null) goto L221;
            int r164 = ProtoAdapter.STRING.encodedSizeWithTag(100, r163);
        L222:
            int r165 = (r162 + r164) + this.mi18n_names.encodedSizeWithTag(BaseField.FIELD_TYPE_S_PHONE_NUMBER, r7.mi18n_names);
            I18nInf r166 = r7.mi18n_inf;
            if (r166 == null) goto L225;
            int r167 = I18nInf.ADAPTER.encodedSizeWithTag(BaseField.FIELD_TYPE_S_FRIEND_LINK, r166);
        L226:
            int r168 = r165 + r167;
            Integer r169 = r7.mread_thread_position;
            if (r169 == null) goto L229;
            int r170 = ProtoAdapter.INT32.encodedSizeWithTag(103, r169);
        L230:
            int r171 = r168 + r170;
            Integer r172 = r7.mread_thread_position_badge_count;
            if (r172 == null) goto L233;
            int r173 = ProtoAdapter.INT32.encodedSizeWithTag(BaseField.FIELD_TYPE_ALIAS_AND_MEMO, r172);
        L234:
            int r174 = r171 + r173;
            Integer r175 = r7.mlast_thread_position_badge_count;
            if (r175 == null) goto L237;
            int r176 = ProtoAdapter.INT32.encodedSizeWithTag(BaseField.FIELD_TYPE_MEMO_DESCRIPTION, r175);
        L238:
            int r177 = r174 + r176;
            Integer r178 = r7.mlast_visible_thread_position;
            if (r178 == null) goto L241;
            int r179 = ProtoAdapter.INT32.encodedSizeWithTag(106, r178);
        L242:
            int r180 = r177 + r179;
            String r181 = r7.mlast_visible_thread_id;
            if (r181 == null) goto L245;
            int r182 = ProtoAdapter.STRING.encodedSizeWithTag(107, r181);
        L246:
            int r183 = r180 + r182;
            MessageLastVisibleInfoPatch r184 = r7.mthread_last_visible_patch;
            if (r184 == null) goto L249;
            int r185 = MessageLastVisibleInfoPatch.ADAPTER.encodedSizeWithTag(132, r184);
        L250:
            int r186 = r183 + r185;
            ChatSecurityConfig r187 = r7.mchat_security_config;
            if (r187 == null) goto L253;
            int r188 = ChatSecurityConfig.ADAPTER.encodedSizeWithTag(108, r187);
        L254:
            int r189 = r186 + r188;
            Boolean r190 = r7.mis_public_v2;
            if (r190 == null) goto L257;
            int r191 = ProtoAdapter.BOOL.encodedSizeWithTag(109, r190);
        L258:
            int r192 = r189 + r191;
            ChatPostType r193 = r7.mpost_type;
            if (r193 == null) goto L261;
            int r194 = ChatPostType.ADAPTER.encodedSizeWithTag(110, r193);
        L262:
            int r195 = r192 + r194;
            Boolean r196 = r7.mallow_post;
            if (r196 == null) goto L265;
            int r197 = ProtoAdapter.BOOL.encodedSizeWithTag(111, r196);
        L266:
            int r198 = r195 + r197;
            Long r199 = r7.mburned_time;
            if (r199 == null) goto L269;
            int r200 = ProtoAdapter.INT64.encodedSizeWithTag(112, r199);
        L270:
            int r201 = r198 + r200;
            Integer r202 = r7.mput_chatter_apply_count;
            if (r202 == null) goto L273;
            int r203 = ProtoAdapter.INT32.encodedSizeWithTag(113, r202);
        L274:
            int r204 = r201 + r203;
            Boolean r205 = r7.mshow_banner;
            if (r205 == null) goto L277;
            int r206 = ProtoAdapter.BOOL.encodedSizeWithTag(114, r205);
        L278:
            int r207 = r204 + r206;
            Boolean r208 = r7.mis_large_group;
            if (r208 == null) goto L281;
            int r209 = ProtoAdapter.BOOL.encodedSizeWithTag(115, r208);
        L282:
            int r210 = r207 + r209;
            Integer r211 = r7.mfirst_chat_message_position;
            if (r211 == null) goto L285;
            int r212 = ProtoAdapter.INT32.encodedSizeWithTag(116, r211);
        L286:
            int r213 = r210 + r212;
            ProtoAdapter r214 = ProtoAdapter.INT32;
            int r215 = (r213 + r214.asRepeated().encodedSizeWithTag(117, r7.mtags)) + this.mextra.encodedSizeWithTag(118, r7.mextra);
            Boolean r216 = r7.mis_same_page_meeting;
            if (r216 == null) goto L289;
            int r217 = ProtoAdapter.BOOL.encodedSizeWithTag(119, r216);
        L290:
            int r218 = r215 + r217;
            Long r219 = r7.mmy_threads_read_timestamp;
            if (r219 == null) goto L293;
            int r220 = ProtoAdapter.INT64.encodedSizeWithTag(120, r219);
        L294:
            int r221 = r218 + r220;
            Long r222 = r7.mmy_threads_last_timestamp;
            if (r222 == null) goto L297;
            int r223 = ProtoAdapter.INT64.encodedSizeWithTag(121, r222);
        L298:
            int r224 = r221 + r223;
            Boolean r225 = r7.mis_edu;
            if (r225 == null) goto L301;
            int r226 = ProtoAdapter.BOOL.encodedSizeWithTag(122, r225);
        L302:
            int r227 = r224 + r226;
            Long r228 = r7.mmy_threads_last_display_message_id;
            if (r228 == null) goto L305;
            int r229 = ProtoAdapter.INT64.encodedSizeWithTag(123, r228);
        L306:
            int r230 = r227 + r229;
            Integer r231 = r7.mmy_threads_unread_count;
            if (r231 == null) goto L309;
            int r232 = r214.encodedSizeWithTag(124, r231);
        L310:
            int r233 = r230 + r232;
            Boolean r234 = r7.mis_cross_with_ka;
            if (r234 == null) goto L313;
            int r235 = ProtoAdapter.BOOL.encodedSizeWithTag(125, r234);
        L314:
            int r236 = r233 + r235;
            Boolean r237 = r7.mis_admin;
            if (r237 == null) goto L317;
            int r238 = ProtoAdapter.BOOL.encodedSizeWithTag(126, r237);
        L318:
            int r239 = r236 + r238;
            Boolean r240 = r7.mis_super;
            if (r240 == null) goto L321;
            int r241 = ProtoAdapter.BOOL.encodedSizeWithTag(127, r240);
        L322:
            int r242 = r239 + r241;
            Boolean r243 = r7.mis_team;
            if (r243 == null) goto L325;
            int r244 = ProtoAdapter.BOOL.encodedSizeWithTag(128, r243);
        L326:
            int r245 = r242 + r244;
            ChatBizContent r246 = r7.mbiz_content;
            if (r246 == null) goto L329;
            int r247 = ChatBizContent.ADAPTER.encodedSizeWithTag(129, r246);
        L330:
            int r248 = (r245 + r247) + this.mchatter_extra_states.encodedSizeWithTag(130, r7.mchatter_extra_states);
            Boolean r249 = r7.mis_private_mode;
            if (r249 == null) goto L333;
            int r250 = ProtoAdapter.BOOL.encodedSizeWithTag(133, r249);
        L334:
            int r251 = r248 + r250;
            String r252 = r7.mopen_chat_id;
            if (r252 == null) goto L337;
            int r253 = ProtoAdapter.STRING.encodedSizeWithTag(134, r252);
        L338:
            int r254 = r251 + r253;
            ChatToolkit r255 = r7.mtoolkit;
            if (r255 == null) goto L341;
            int r256 = ChatToolkit.ADAPTER.encodedSizeWithTag(135, r255);
        L342:
            int r257 = r254 + r256;
            GeneralChatSetting r258 = r7.mchat_general_setting;
            if (r258 == null) goto L345;
            int r259 = GeneralChatSetting.ADAPTER.encodedSizeWithTag(136, r258);
        L346:
            int r260 = r257 + r259;
            TagData r261 = r7.mtag_data;
            if (r261 == null) goto L349;
            int r262 = TagData.ADAPTER.encodedSizeWithTag(137, r261);
        L350:
            int r263 = ((r260 + r262) + this.mgroup_type.encodedSizeWithTag(138, r7.mgroup_type)) + this.mbiz_version_map.encodedSizeWithTag(139, r7.mbiz_version_map);
            CryptoChatInfo r264 = r7.mcrypto_chat_info;
            if (r264 == null) goto L353;
            int r265 = CryptoChatInfo.ADAPTER.encodedSizeWithTag(140, r264);
        L354:
            int r266 = r263 + r265;
            Boolean r267 = r7.mis_frozen;
            if (r267 == null) goto L357;
            int r268 = ProtoAdapter.BOOL.encodedSizeWithTag(141, r267);
        L358:
            int r269 = r266 + r268;
            Long r270 = r7.mchat_chatter_version;
            if (r270 == null) goto L361;
            int r271 = ProtoAdapter.INT64.encodedSizeWithTag(142, r270);
        L362:
            int r272 = r269 + r271;
            Boolean r273 = r7.mis_department_v1;
            if (r273 == null) goto L365;
            int r274 = ProtoAdapter.BOOL.encodedSizeWithTag(143, r273);
        L366:
            int r275 = r272 + r274;
            Boolean r276 = r7.mis_p2p_ai;
            if (r276 == null) goto L369;
            int r277 = ProtoAdapter.BOOL.encodedSizeWithTag(144, r276);
        L370:
            int r278 = r275 + r277;
            BannerSetting r279 = r7.mbanner_setting;
            if (r279 == null) goto L373;
            int r280 = BannerSetting.ADAPTER.encodedSizeWithTag(145, r279);
        L374:
            int r281 = r278 + r280;
            Boolean r282 = r7.mhas_chat_menu;
            if (r282 == null) goto L377;
            int r283 = ProtoAdapter.BOOL.encodedSizeWithTag(146, r282);
        L378:
            int r284 = r281 + r283;
            Boolean r285 = r7.mis_p2p_official_bot_ai;
            if (r285 == null) goto L381;
            int r286 = ProtoAdapter.BOOL.encodedSizeWithTag(147, r285);
        L382:
            int r287 = r284 + r286;
            Boolean r288 = r7.mis_invisible;
            if (r288 == null) goto L385;
            int r289 = ProtoAdapter.BOOL.encodedSizeWithTag(148, r288);
        L386:
            int r290 = r287 + r289;
            Boolean r291 = r7.mis_cross_tenant_v1;
            if (r291 == null) goto L389;
            int r292 = ProtoAdapter.BOOL.encodedSizeWithTag(149, r291);
        L390:
            int r293 = r290 + r292;
            ChatUserAutoMuteSetting r294 = r7.muser_auto_mute_setting;
            if (r294 == null) goto L393;
            int r295 = ChatUserAutoMuteSetting.ADAPTER.encodedSizeWithTag(150, r294);
        L394:
            int r296 = r293 + r295;
            Integer r297 = r7.mread_position_filter_mute_bot_badge_count;
            if (r297 == null) goto L397;
            int r298 = r214.encodedSizeWithTag(151, r297);
        L398:
            int r299 = r296 + r298;
            Integer r300 = r7.mlast_message_position_filter_mute_bot_badge_count;
            if (r300 == null) goto L401;
            int r301 = r214.encodedSizeWithTag(152, r300);
        L402:
            int r302 = r299 + r301;
            Integer r303 = r7.mread_thread_position_filter_mute_bot_badge_count;
            if (r303 == null) goto L405;
            int r304 = r214.encodedSizeWithTag(153, r303);
        L406:
            int r305 = r302 + r304;
            Integer r306 = r7.mlast_thread_message_position_filter_mute_bot_badge_count;
            if (r306 == null) goto L409;
            int r307 = r214.encodedSizeWithTag(154, r306);
        L410:
            int r308 = r305 + r307;
            Long r309 = r7.mfilter_mute_bot_badge_count_version;
            if (r309 == null) goto L413;
            int r310 = ProtoAdapter.INT64.encodedSizeWithTag(155, r309);
        L414:
            int r311 = r308 + r310;
            Long r312 = r7.muser_clean_message_time_ms;
            if (r312 == null) goto L417;
            int r313 = ProtoAdapter.INT64.encodedSizeWithTag(156, r312);
        L418:
            int r314 = r311 + r313;
            TnsOpKind r315 = r7.mtns_op_kind;
            if (r315 == null) goto L421;
            int r316 = TnsOpKind.ADAPTER.encodedSizeWithTag(157, r315);
        L422:
            int r317 = r314 + r316;
            SystemBannedInfo r318 = r7.msystem_banned_info;
            if (r318 == null) goto L426;
            r1 = SystemBannedInfo.ADAPTER.encodedSizeWithTag(158, r318);
        L426:
            return (r317 + r1) + r7.unknownFields().size();
        L421:
            r316 = 0;
            goto L422
        L417:
            r313 = 0;
            goto L418
        L413:
            r310 = 0;
            goto L414
        L409:
            r307 = 0;
            goto L410
        L405:
            r304 = 0;
            goto L406
        L401:
            r301 = 0;
            goto L402
        L397:
            r298 = 0;
            goto L398
        L393:
            r295 = 0;
            goto L394
        L389:
            r292 = 0;
            goto L390
        L385:
            r289 = 0;
            goto L386
        L381:
            r286 = 0;
            goto L382
        L377:
            r283 = 0;
            goto L378
        L373:
            r280 = 0;
            goto L374
        L369:
            r277 = 0;
            goto L370
        L365:
            r274 = 0;
            goto L366
        L361:
            r271 = 0;
            goto L362
        L357:
            r268 = 0;
            goto L358
        L353:
            r265 = 0;
            goto L354
        L349:
            r262 = 0;
            goto L350
        L345:
            r259 = 0;
            goto L346
        L341:
            r256 = 0;
            goto L342
        L337:
            r253 = 0;
            goto L338
        L333:
            r250 = 0;
            goto L334
        L329:
            r247 = 0;
            goto L330
        L325:
            r244 = 0;
            goto L326
        L321:
            r241 = 0;
            goto L322
        L317:
            r238 = 0;
            goto L318
        L313:
            r235 = 0;
            goto L314
        L309:
            r232 = 0;
            goto L310
        L305:
            r229 = 0;
            goto L306
        L301:
            r226 = 0;
            goto L302
        L297:
            r223 = 0;
            goto L298
        L293:
            r220 = 0;
            goto L294
        L289:
            r217 = 0;
            goto L290
        L285:
            r212 = 0;
            goto L286
        L281:
            r209 = 0;
            goto L282
        L277:
            r206 = 0;
            goto L278
        L273:
            r203 = 0;
            goto L274
        L269:
            r200 = 0;
            goto L270
        L265:
            r197 = 0;
            goto L266
        L261:
            r194 = 0;
            goto L262
        L257:
            r191 = 0;
            goto L258
        L253:
            r188 = 0;
            goto L254
        L249:
            r185 = 0;
            goto L250
        L245:
            r182 = 0;
            goto L246
        L241:
            r179 = 0;
            goto L242
        L237:
            r176 = 0;
            goto L238
        L233:
            r173 = 0;
            goto L234
        L229:
            r170 = 0;
            goto L230
        L225:
            r167 = 0;
            goto L226
        L221:
            r164 = 0;
            goto L222
        L217:
            r161 = 0;
            goto L218
        L213:
            r158 = 0;
            goto L214
        L209:
            r155 = 0;
            goto L210
        L205:
            r152 = 0;
            goto L206
        L201:
            r149 = 0;
            goto L202
        L197:
            r146 = 0;
            goto L198
        L193:
            r143 = 0;
            goto L194
        L189:
            r140 = 0;
            goto L190
        L185:
            r137 = 0;
            goto L186
        L181:
            r134 = 0;
            goto L182
        L177:
            r131 = 0;
            goto L178
        L173:
            r128 = 0;
            goto L174
        L169:
            r125 = 0;
            goto L170
        L165:
            r122 = 0;
            goto L166
        L161:
            r119 = 0;
            goto L162
        L157:
            r116 = 0;
            goto L158
        L153:
            r113 = 0;
            goto L154
        L149:
            r110 = 0;
            goto L150
        L145:
            r107 = 0;
            goto L146
        L141:
            r104 = 0;
            goto L142
        L137:
            r101 = 0;
            goto L138
        L133:
            r98 = 0;
            goto L134
        L129:
            r95 = 0;
            goto L130
        L125:
            r92 = 0;
            goto L126
        L121:
            r89 = 0;
            goto L122
        L117:
            r86 = 0;
            goto L118
        L113:
            r83 = 0;
            goto L114
        L109:
            r80 = 0;
            goto L110
        L105:
            r77 = 0;
            goto L106
        L101:
            r74 = 0;
            goto L102
        L97:
            r71 = 0;
            goto L98
        L93:
            r68 = 0;
            goto L94
        L89:
            r65 = 0;
            goto L90
        L85:
            r62 = 0;
            goto L86
        L81:
            r59 = 0;
            goto L82
        L77:
            r56 = 0;
            goto L78
        L73:
            r53 = 0;
            goto L74
        L69:
            r50 = 0;
            goto L70
        L65:
            r47 = 0;
            goto L66
        L61:
            r44 = 0;
            goto L62
        L57:
            r41 = 0;
            goto L58
        L53:
            r38 = 0;
            goto L54
        L49:
            r35 = 0;
            goto L50
        L45:
            r32 = 0;
            goto L46
        L41:
            r29 = 0;
            goto L42
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1068decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Chat) r1);
        }

        public void encode(ProtoWriter r5, Chat r6) throws IOException {
            String r0 = r6.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r5, 1, r0);
        L5:
            Type r1 = r6.mtype;
            if (r1 == null) goto L8;
            Type.ADAPTER.encodeWithTag(r5, 2, r1);
        L8:
            String r2 = r6.mlast_message_id;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r5, 3, r2);
        L11:
            String r3 = r6.mname;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r5, 4, r3);
        L14:
            Image r4 = r6.mavatar;
            if (r4 == null) goto L17;
            Image.ADAPTER.encodeWithTag(r5, 5, r4);
        L17:
            String r7 = r6.mowner_id;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r5, 6, r7);
        L20:
            Integer r8 = r6.mnew_message_count;
            if (r8 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r5, 7, r8);
        L23:
            Status r9 = r6.mstatus;
            if (r9 == null) goto L26;
            Status.ADAPTER.encodeWithTag(r5, 8, r9);
        L26:
            Long r10 = r6.mupdate_time;
            if (r10 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r5, 9, r10);
        L29:
            String r11 = r6.mkey;
            if (r11 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r5, 10, r11);
        L32:
            String r12 = r6.mdescription;
            if (r12 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r5, 11, r12);
        L35:
            Integer r13 = r6.mmember_count;
            if (r13 == null) goto L38;
            ProtoAdapter.INT32.encodeWithTag(r5, 12, r13);
        L38:
            Boolean r14 = r6.mis_department;
            if (r14 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r5, 13, r14);
        L41:
            Boolean r15 = r6.mis_public;
            if (r15 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r5, 14, r15);
        L44:
            Integer r16 = r6.mlast_message_position;
            if (r16 == null) goto L47;
            ProtoAdapter.INT32.encodeWithTag(r5, 15, r16);
        L47:
            Integer r17 = r6.muser_count;
            if (r17 == null) goto L50;
            ProtoAdapter.INT32.encodeWithTag(r5, 16, r17);
        L50:
            String r18 = r6.mname_pinyin;
            if (r18 == null) goto L53;
            ProtoAdapter.STRING.encodeWithTag(r5, 17, r18);
        L53:
            Long r19 = r6.mcreate_time;
            if (r19 == null) goto L56;
            ProtoAdapter.INT64.encodeWithTag(r5, 18, r19);
        L56:
            Boolean r20 = r6.mis_customer_service;
            if (r20 == null) goto L59;
            ProtoAdapter.BOOL.encodeWithTag(r5, 19, r20);
        L59:
            Role r21 = r6.mrole;
            if (r21 == null) goto L62;
            Role.ADAPTER.encodeWithTag(r5, 20, r21);
        L62:
            Boolean r22 = r6.mis_custom_icon;
            if (r22 == null) goto L65;
            ProtoAdapter.BOOL.encodeWithTag(r5, 21, r22);
        L65:
            Integer r23 = r6.mno_badged_new_message_count;
            if (r23 == null) goto L68;
            ProtoAdapter.INT32.encodeWithTag(r5, 22, r23);
        L68:
            Boolean r24 = r6.moff_edit_group_chat_info;
            if (r24 == null) goto L71;
            ProtoAdapter.BOOL.encodeWithTag(r5, 23, r24);
        L71:
            Announcement r25 = r6.mannouncement;
            if (r25 == null) goto L74;
            Announcement.ADAPTER.encodeWithTag(r5, 24, r25);
        L74:
            String r26 = r6.mtenant_id;
            if (r26 == null) goto L77;
            ProtoAdapter.STRING.encodeWithTag(r5, 25, r26);
        L77:
            Long r27 = r6.mupdate_time_ms;
            if (r27 == null) goto L80;
            ProtoAdapter.INT64.encodeWithTag(r5, 26, r27);
        L80:
            Boolean r28 = r6.mis_remind;
            if (r28 == null) goto L83;
            ProtoAdapter.BOOL.encodeWithTag(r5, 27, r28);
        L83:
            ChatEntitySetting r29 = r6.mchat_entity_setting;
            if (r29 == null) goto L86;
            ChatEntitySetting.ADAPTER.encodeWithTag(r5, 28, r29);
        L86:
            ChatSetting r30 = r6.muser_setting;
            if (r30 == null) goto L89;
            ChatSetting.ADAPTER.encodeWithTag(r5, 29, r30);
        L89:
            Boolean r31 = r6.mis_dissolved;
            if (r31 == null) goto L92;
            ProtoAdapter.BOOL.encodeWithTag(r5, 30, r31);
        L92:
            Boolean r32 = r6.mis_meeting;
            if (r32 == null) goto L95;
            ProtoAdapter.BOOL.encodeWithTag(r5, 31, r32);
        L95:
            String r33 = r6.mlast_visible_message_id;
            if (r33 == null) goto L98;
            ProtoAdapter.STRING.encodeWithTag(r5, 32, r33);
        L98:
            MessageLastVisibleInfoPatch r34 = r6.mmessage_last_visible_patch;
            if (r34 == null) goto L101;
            MessageLastVisibleInfoPatch.ADAPTER.encodeWithTag(r5, 131, r34);
        L101:
            String r35 = r6.mlast_thread_id;
            if (r35 == null) goto L104;
            ProtoAdapter.STRING.encodeWithTag(r5, 33, r35);
        L104:
            Integer r36 = r6.mnew_thread_count;
            if (r36 == null) goto L107;
            ProtoAdapter.INT32.encodeWithTag(r5, 34, r36);
        L107:
            Integer r37 = r6.mlast_thread_position;
            if (r37 == null) goto L110;
            ProtoAdapter.INT32.encodeWithTag(r5, 35, r37);
        L110:
            Boolean r38 = r6.mis_crypto;
            if (r38 == null) goto L113;
            ProtoAdapter.BOOL.encodeWithTag(r5, 36, r38);
        L113:
            Integer r39 = r6.mno_badged_new_thread_count;
            if (r39 == null) goto L116;
            ProtoAdapter.INT32.encodeWithTag(r5, 37, r39);
        L116:
            Integer r40 = r6.mthread_start_position;
            if (r40 == null) goto L119;
            ProtoAdapter.INT32.encodeWithTag(r5, 38, r40);
        L119:
            ChatMode r41 = r6.mchat_mode;
            if (r41 == null) goto L122;
            ChatMode.ADAPTER.encodeWithTag(r5, 39, r41);
        L122:
            ChatConfig r42 = r6.mchat_config;
            if (r42 == null) goto L125;
            ChatConfig.ADAPTER.encodeWithTag(r5, 40, r42);
        L125:
            Boolean r43 = r6.mis_cross_tenant;
            if (r43 == null) goto L128;
            ProtoAdapter.BOOL.encodeWithTag(r5, 41, r43);
        L128:
            Boolean r44 = r6.mis_tenant;
            if (r44 == null) goto L131;
            ProtoAdapter.BOOL.encodeWithTag(r5, 42, r44);
        L131:
            SupportView r45 = r6.msupport_view;
            if (r45 == null) goto L134;
            SupportView.ADAPTER.encodeWithTag(r5, 43, r45);
        L134:
            Long r46 = r6.mjoin_time_ms;
            if (r46 == null) goto L137;
            ProtoAdapter.INT64.encodeWithTag(r5, 44, r46);
        L137:
            Long r47 = r6.moncall_id;
            if (r47 == null) goto L140;
            ProtoAdapter.INT64.encodeWithTag(r5, 45, r47);
        L140:
            Integer r48 = r6.mlast_visible_message_position;
            if (r48 == null) goto L143;
            ProtoAdapter.INT32.encodeWithTag(r5, 46, r48);
        L143:
            Integer r49 = r6.mlast_visible_message_no_badged_count;
            if (r49 == null) goto L146;
            ProtoAdapter.INT32.encodeWithTag(r5, 47, r49);
        L146:
            Integer r50 = r6.mread_position;
            if (r50 == null) goto L149;
            ProtoAdapter.INT32.encodeWithTag(r5, 48, r50);
        L149:
            Integer r51 = r6.mread_position_badge_count;
            if (r51 == null) goto L152;
            ProtoAdapter.INT32.encodeWithTag(r5, 49, r51);
        L152:
            Integer r52 = r6.mlast_message_position_badge_count;
            if (r52 == null) goto L155;
            ProtoAdapter.INT32.encodeWithTag(r5, 50, r52);
        L155:
            Boolean r53 = r6.menable_watermark;
            if (r53 == null) goto L158;
            ProtoAdapter.BOOL.encodeWithTag(r5, 51, r53);
        L158:
            Image r54 = r6.mmini_avatar;
            if (r54 == null) goto L161;
            Image.ADAPTER.encodeWithTag(r5, 52, r54);
        L161:
            String r55 = r6.msidebar_id;
            if (r55 == null) goto L164;
            ProtoAdapter.STRING.encodeWithTag(r5, 53, r55);
        L164:
            String r56 = r6.mname_py;
            if (r56 == null) goto L167;
            ProtoAdapter.STRING.encodeWithTag(r5, 100, r56);
        L167:
            this.mi18n_names.encodeWithTag(r5, BaseField.FIELD_TYPE_S_PHONE_NUMBER, r6.mi18n_names);
            I18nInf r57 = r6.mi18n_inf;
            if (r57 == null) goto L170;
            I18nInf.ADAPTER.encodeWithTag(r5, BaseField.FIELD_TYPE_S_FRIEND_LINK, r57);
        L170:
            Integer r58 = r6.mread_thread_position;
            if (r58 == null) goto L173;
            ProtoAdapter.INT32.encodeWithTag(r5, 103, r58);
        L173:
            Integer r59 = r6.mread_thread_position_badge_count;
            if (r59 == null) goto L176;
            ProtoAdapter.INT32.encodeWithTag(r5, BaseField.FIELD_TYPE_ALIAS_AND_MEMO, r59);
        L176:
            Integer r60 = r6.mlast_thread_position_badge_count;
            if (r60 == null) goto L179;
            ProtoAdapter.INT32.encodeWithTag(r5, BaseField.FIELD_TYPE_MEMO_DESCRIPTION, r60);
        L179:
            Integer r61 = r6.mlast_visible_thread_position;
            if (r61 == null) goto L182;
            ProtoAdapter.INT32.encodeWithTag(r5, 106, r61);
        L182:
            String r62 = r6.mlast_visible_thread_id;
            if (r62 == null) goto L185;
            ProtoAdapter.STRING.encodeWithTag(r5, 107, r62);
        L185:
            MessageLastVisibleInfoPatch r63 = r6.mthread_last_visible_patch;
            if (r63 == null) goto L188;
            MessageLastVisibleInfoPatch.ADAPTER.encodeWithTag(r5, 132, r63);
        L188:
            ChatSecurityConfig r64 = r6.mchat_security_config;
            if (r64 == null) goto L191;
            ChatSecurityConfig.ADAPTER.encodeWithTag(r5, 108, r64);
        L191:
            Boolean r65 = r6.mis_public_v2;
            if (r65 == null) goto L194;
            ProtoAdapter.BOOL.encodeWithTag(r5, 109, r65);
        L194:
            ChatPostType r66 = r6.mpost_type;
            if (r66 == null) goto L197;
            ChatPostType.ADAPTER.encodeWithTag(r5, 110, r66);
        L197:
            Boolean r67 = r6.mallow_post;
            if (r67 == null) goto L200;
            ProtoAdapter.BOOL.encodeWithTag(r5, 111, r67);
        L200:
            Long r68 = r6.mburned_time;
            if (r68 == null) goto L203;
            ProtoAdapter.INT64.encodeWithTag(r5, 112, r68);
        L203:
            Integer r69 = r6.mput_chatter_apply_count;
            if (r69 == null) goto L206;
            ProtoAdapter.INT32.encodeWithTag(r5, 113, r69);
        L206:
            Boolean r70 = r6.mshow_banner;
            if (r70 == null) goto L209;
            ProtoAdapter.BOOL.encodeWithTag(r5, 114, r70);
        L209:
            Boolean r71 = r6.mis_large_group;
            if (r71 == null) goto L212;
            ProtoAdapter.BOOL.encodeWithTag(r5, 115, r71);
        L212:
            Integer r72 = r6.mfirst_chat_message_position;
            if (r72 == null) goto L215;
            ProtoAdapter.INT32.encodeWithTag(r5, 116, r72);
        L215:
            ProtoAdapter r73 = ProtoAdapter.INT32;
            r73.asRepeated().encodeWithTag(r5, 117, r6.mtags);
            this.mextra.encodeWithTag(r5, 118, r6.mextra);
            Boolean r74 = r6.mis_same_page_meeting;
            if (r74 == null) goto L218;
            ProtoAdapter.BOOL.encodeWithTag(r5, 119, r74);
        L218:
            Long r75 = r6.mmy_threads_read_timestamp;
            if (r75 == null) goto L221;
            ProtoAdapter.INT64.encodeWithTag(r5, 120, r75);
        L221:
            Long r76 = r6.mmy_threads_last_timestamp;
            if (r76 == null) goto L224;
            ProtoAdapter.INT64.encodeWithTag(r5, 121, r76);
        L224:
            Boolean r77 = r6.mis_edu;
            if (r77 == null) goto L227;
            ProtoAdapter.BOOL.encodeWithTag(r5, 122, r77);
        L227:
            Long r78 = r6.mmy_threads_last_display_message_id;
            if (r78 == null) goto L230;
            ProtoAdapter.INT64.encodeWithTag(r5, 123, r78);
        L230:
            Integer r79 = r6.mmy_threads_unread_count;
            if (r79 == null) goto L233;
            r73.encodeWithTag(r5, 124, r79);
        L233:
            Boolean r80 = r6.mis_cross_with_ka;
            if (r80 == null) goto L236;
            ProtoAdapter.BOOL.encodeWithTag(r5, 125, r80);
        L236:
            Boolean r81 = r6.mis_admin;
            if (r81 == null) goto L239;
            ProtoAdapter.BOOL.encodeWithTag(r5, 126, r81);
        L239:
            Boolean r82 = r6.mis_super;
            if (r82 == null) goto L242;
            ProtoAdapter.BOOL.encodeWithTag(r5, 127, r82);
        L242:
            Boolean r83 = r6.mis_team;
            if (r83 == null) goto L245;
            ProtoAdapter.BOOL.encodeWithTag(r5, 128, r83);
        L245:
            ChatBizContent r84 = r6.mbiz_content;
            if (r84 == null) goto L248;
            ChatBizContent.ADAPTER.encodeWithTag(r5, 129, r84);
        L248:
            this.mchatter_extra_states.encodeWithTag(r5, 130, r6.mchatter_extra_states);
            Boolean r85 = r6.mis_private_mode;
            if (r85 == null) goto L251;
            ProtoAdapter.BOOL.encodeWithTag(r5, 133, r85);
        L251:
            String r86 = r6.mopen_chat_id;
            if (r86 == null) goto L254;
            ProtoAdapter.STRING.encodeWithTag(r5, 134, r86);
        L254:
            ChatToolkit r87 = r6.mtoolkit;
            if (r87 == null) goto L257;
            ChatToolkit.ADAPTER.encodeWithTag(r5, 135, r87);
        L257:
            GeneralChatSetting r88 = r6.mchat_general_setting;
            if (r88 == null) goto L260;
            GeneralChatSetting.ADAPTER.encodeWithTag(r5, 136, r88);
        L260:
            TagData r89 = r6.mtag_data;
            if (r89 == null) goto L263;
            TagData.ADAPTER.encodeWithTag(r5, 137, r89);
        L263:
            this.mgroup_type.encodeWithTag(r5, 138, r6.mgroup_type);
            this.mbiz_version_map.encodeWithTag(r5, 139, r6.mbiz_version_map);
            CryptoChatInfo r90 = r6.mcrypto_chat_info;
            if (r90 == null) goto L266;
            CryptoChatInfo.ADAPTER.encodeWithTag(r5, 140, r90);
        L266:
            Boolean r91 = r6.mis_frozen;
            if (r91 == null) goto L269;
            ProtoAdapter.BOOL.encodeWithTag(r5, 141, r91);
        L269:
            Long r92 = r6.mchat_chatter_version;
            if (r92 == null) goto L272;
            ProtoAdapter.INT64.encodeWithTag(r5, 142, r92);
        L272:
            Boolean r93 = r6.mis_department_v1;
            if (r93 == null) goto L275;
            ProtoAdapter.BOOL.encodeWithTag(r5, 143, r93);
        L275:
            Boolean r94 = r6.mis_p2p_ai;
            if (r94 == null) goto L278;
            ProtoAdapter.BOOL.encodeWithTag(r5, 144, r94);
        L278:
            BannerSetting r95 = r6.mbanner_setting;
            if (r95 == null) goto L281;
            BannerSetting.ADAPTER.encodeWithTag(r5, 145, r95);
        L281:
            Boolean r96 = r6.mhas_chat_menu;
            if (r96 == null) goto L284;
            ProtoAdapter.BOOL.encodeWithTag(r5, 146, r96);
        L284:
            Boolean r97 = r6.mis_p2p_official_bot_ai;
            if (r97 == null) goto L287;
            ProtoAdapter.BOOL.encodeWithTag(r5, 147, r97);
        L287:
            Boolean r98 = r6.mis_invisible;
            if (r98 == null) goto L290;
            ProtoAdapter.BOOL.encodeWithTag(r5, 148, r98);
        L290:
            Boolean r99 = r6.mis_cross_tenant_v1;
            if (r99 == null) goto L293;
            ProtoAdapter.BOOL.encodeWithTag(r5, 149, r99);
        L293:
            ChatUserAutoMuteSetting r100 = r6.muser_auto_mute_setting;
            if (r100 == null) goto L296;
            ChatUserAutoMuteSetting.ADAPTER.encodeWithTag(r5, 150, r100);
        L296:
            Integer r101 = r6.mread_position_filter_mute_bot_badge_count;
            if (r101 == null) goto L299;
            r73.encodeWithTag(r5, 151, r101);
        L299:
            Integer r102 = r6.mlast_message_position_filter_mute_bot_badge_count;
            if (r102 == null) goto L302;
            r73.encodeWithTag(r5, 152, r102);
        L302:
            Integer r103 = r6.mread_thread_position_filter_mute_bot_badge_count;
            if (r103 == null) goto L305;
            r73.encodeWithTag(r5, 153, r103);
        L305:
            Integer r104 = r6.mlast_thread_message_position_filter_mute_bot_badge_count;
            if (r104 == null) goto L308;
            r73.encodeWithTag(r5, 154, r104);
        L308:
            Long r105 = r6.mfilter_mute_bot_badge_count_version;
            if (r105 == null) goto L311;
            ProtoAdapter.INT64.encodeWithTag(r5, 155, r105);
        L311:
            Long r106 = r6.muser_clean_message_time_ms;
            if (r106 == null) goto L314;
            ProtoAdapter.INT64.encodeWithTag(r5, 156, r106);
        L314:
            TnsOpKind r107 = r6.mtns_op_kind;
            if (r107 == null) goto L317;
            TnsOpKind.ADAPTER.encodeWithTag(r5, 157, r107);
        L317:
            SystemBannedInfo r108 = r6.msystem_banned_info;
            if (r108 == null) goto L320;
            SystemBannedInfo.ADAPTER.encodeWithTag(r5, 158, r108);
        L320:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Chat) r2);
        }
    }

    public static final enum Role extends Enum<Role> implements WireEnum {
        private static final /* synthetic */ Role[] $VALUES = null;
        public static final ProtoAdapter<Role> ADAPTER = null;
        public static final Role IGNORE = null;
        public static final Role MEMBER = null;
        public static final Role THREAD_FOLLOWER = null;
        public static final Role VISITOR = null;
        private final int value;

        static {
            Role r0 = new Role("IGNORE", 0, 0);
            IGNORE = r0;
            Role r1 = new Role("MEMBER", 1, 1);
            MEMBER = r1;
            Role r3 = new Role("VISITOR", 2, 2);
            VISITOR = r3;
            Role r5 = new Role("THREAD_FOLLOWER", 3, 3);
            THREAD_FOLLOWER = r5;
            $VALUES = new Role[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(Role.class);
        }

        public static Role[] values() {
            return (Role[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Role fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return THREAD_FOLLOWER;
        L14:
            return VISITOR;
        L16:
            return MEMBER;
        L18:
            return IGNORE;
        }

        public static Role valueOf(String r1) {
            return (Role) a.a(Role.class, r1);
        }

        private Role(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status ARCHIVE = null;
        public static final Status DELETED = null;
        public static final Status NORMAL = null;
        private final int value;

        static {
            Status r0 = new Status("NORMAL", 0, 0);
            NORMAL = r0;
            Status r1 = new Status("ARCHIVE", 1, 1);
            ARCHIVE = r1;
            Status r3 = new Status("DELETED", 2, 2);
            DELETED = r3;
            $VALUES = new Status[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return DELETED;
        L12:
            return ARCHIVE;
        L14:
            return NORMAL;
        }

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        private Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum SupportView extends Enum<SupportView> implements WireEnum {
        private static final /* synthetic */ SupportView[] $VALUES = null;
        public static final ProtoAdapter<SupportView> ADAPTER = null;
        public static final SupportView VIEW_CRYPTO = null;
        public static final SupportView VIEW_MEETING = null;
        public static final SupportView VIEW_P2PGROUP = null;
        public static final SupportView VIEW_THREAD = null;
        public static final SupportView VIEW_UNKNOWN = null;
        private final int value;

        static {
            SupportView r0 = new SupportView("VIEW_UNKNOWN", 0, 0);
            VIEW_UNKNOWN = r0;
            SupportView r1 = new SupportView("VIEW_P2PGROUP", 1, 1);
            VIEW_P2PGROUP = r1;
            SupportView r3 = new SupportView("VIEW_MEETING", 2, 2);
            VIEW_MEETING = r3;
            SupportView r5 = new SupportView("VIEW_THREAD", 3, 3);
            VIEW_THREAD = r5;
            SupportView r7 = new SupportView("VIEW_CRYPTO", 4, 4);
            VIEW_CRYPTO = r7;
            $VALUES = new SupportView[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(SupportView.class);
        }

        public static SupportView[] values() {
            return (SupportView[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SupportView fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return VIEW_CRYPTO;
        L16:
            return VIEW_THREAD;
        L18:
            return VIEW_MEETING;
        L20:
            return VIEW_P2PGROUP;
        L22:
            return VIEW_UNKNOWN;
        }

        public static SupportView valueOf(String r1) {
            return (SupportView) a.a(SupportView.class, r1);
        }

        private SupportView(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type GROUP = null;
        public static final Type P2P = null;
        public static final Type TOPIC_GROUP = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("P2P", 1, 1);
            P2P = r1;
            Type r3 = new Type("GROUP", 2, 2);
            GROUP = r3;
            Type r5 = new Type("TOPIC_GROUP", 3, 3);
            TOPIC_GROUP = r5;
            $VALUES = new Type[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return TOPIC_GROUP;
        L14:
            return GROUP;
        L16:
            return P2P;
        L18:
            return UNKNOWN;
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        private Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Chat();
        DEFAULT_NEW_MESSAGE_COUNT = 0;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_MEMBER_COUNT = 0;
        Boolean r2 = Boolean.FALSE;
        DEFAULT_IS_DEPARTMENT = r2;
        DEFAULT_IS_PUBLIC = r2;
        DEFAULT_LAST_MESSAGE_POSITION = 0;
        DEFAULT_USER_COUNT = 0;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_IS_CUSTOMER_SERVICE = r2;
        DEFAULT_IS_CUSTOM_ICON = r2;
        DEFAULT_NO_BADGED_NEW_MESSAGE_COUNT = 0;
        DEFAULT_OFF_EDIT_GROUP_CHAT_INFO = r2;
        DEFAULT_UPDATE_TIME_MS = 0L;
        DEFAULT_IS_REMIND = Boolean.TRUE;
        DEFAULT_IS_DISSOLVED = r2;
        DEFAULT_IS_MEETING = r2;
        DEFAULT_NEW_THREAD_COUNT = 0;
        DEFAULT_LAST_THREAD_POSITION = 0;
        DEFAULT_IS_CRYPTO = r2;
        DEFAULT_NO_BADGED_NEW_THREAD_COUNT = 0;
        DEFAULT_THREAD_START_POSITION = 0;
        DEFAULT_IS_CROSS_TENANT = r2;
        DEFAULT_IS_TENANT = r2;
        DEFAULT_JOIN_TIME_MS = 0L;
        DEFAULT_ONCALL_ID = 0L;
        DEFAULT_LAST_VISIBLE_MESSAGE_POSITION = 0;
        DEFAULT_LAST_VISIBLE_MESSAGE_NO_BADGED_COUNT = 0;
        DEFAULT_READ_POSITION = 0;
        DEFAULT_READ_POSITION_BADGE_COUNT = 0;
        DEFAULT_LAST_MESSAGE_POSITION_BADGE_COUNT = 0;
        DEFAULT_ENABLE_WATERMARK = r2;
        DEFAULT_READ_THREAD_POSITION = 0;
        DEFAULT_READ_THREAD_POSITION_BADGE_COUNT = 0;
        DEFAULT_LAST_THREAD_POSITION_BADGE_COUNT = 0;
        DEFAULT_LAST_VISIBLE_THREAD_POSITION = 0;
        DEFAULT_IS_PUBLIC_V2 = r2;
        DEFAULT_ALLOW_POST = r2;
        DEFAULT_BURNED_TIME = 0L;
        DEFAULT_PUT_CHATTER_APPLY_COUNT = 0;
        DEFAULT_SHOW_BANNER = r2;
        DEFAULT_IS_LARGE_GROUP = r2;
        DEFAULT_FIRST_CHAT_MESSAGE_POSITION = 0;
        DEFAULT_IS_SAME_PAGE_MEETING = r2;
        DEFAULT_MY_THREADS_READ_TIMESTAMP = 0L;
        DEFAULT_MY_THREADS_LAST_TIMESTAMP = 0L;
        DEFAULT_IS_EDU = r2;
        DEFAULT_MY_THREADS_LAST_DISPLAY_MESSAGE_ID = 0L;
        DEFAULT_MY_THREADS_UNREAD_COUNT = 0;
        DEFAULT_IS_CROSS_WITH_KA = r2;
        DEFAULT_IS_ADMIN = r2;
        DEFAULT_IS_SUPER = r2;
        DEFAULT_IS_TEAM = r2;
        DEFAULT_IS_PRIVATE_MODE = r2;
        DEFAULT_IS_FROZEN = r2;
        DEFAULT_CHAT_CHATTER_VERSION = 0L;
        DEFAULT_IS_DEPARTMENT_V1 = r2;
        DEFAULT_IS_P2P_AI = r2;
        DEFAULT_HAS_CHAT_MENU = r2;
        DEFAULT_IS_P2P_OFFICIAL_BOT_AI = r2;
        DEFAULT_IS_INVISIBLE = r2;
        DEFAULT_IS_CROSS_TENANT_V1 = r2;
        DEFAULT_READ_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = 0;
        DEFAULT_LAST_MESSAGE_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = 0;
        DEFAULT_READ_THREAD_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = 0;
        DEFAULT_LAST_THREAD_MESSAGE_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = 0;
        DEFAULT_FILTER_MUTE_BOT_BADGE_COUNT_VERSION = 0L;
        DEFAULT_USER_CLEAN_MESSAGE_TIME_MS = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1060newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtype = this.mtype;
        r0.mlast_message_id = this.mlast_message_id;
        r0.mname = this.mname;
        r0.mavatar = this.mavatar;
        r0.mowner_id = this.mowner_id;
        r0.mnew_message_count = this.mnew_message_count;
        r0.mstatus = this.mstatus;
        r0.mupdate_time = this.mupdate_time;
        r0.mkey = this.mkey;
        r0.mdescription = this.mdescription;
        r0.mmember_count = this.mmember_count;
        r0.mis_department = this.mis_department;
        r0.mis_public = this.mis_public;
        r0.mlast_message_position = this.mlast_message_position;
        r0.muser_count = this.muser_count;
        r0.mname_pinyin = this.mname_pinyin;
        r0.mcreate_time = this.mcreate_time;
        r0.mis_customer_service = this.mis_customer_service;
        r0.mrole = this.mrole;
        r0.mis_custom_icon = this.mis_custom_icon;
        r0.mno_badged_new_message_count = this.mno_badged_new_message_count;
        r0.moff_edit_group_chat_info = this.moff_edit_group_chat_info;
        r0.mannouncement = this.mannouncement;
        r0.mtenant_id = this.mtenant_id;
        r0.mupdate_time_ms = this.mupdate_time_ms;
        r0.mis_remind = this.mis_remind;
        r0.mchat_entity_setting = this.mchat_entity_setting;
        r0.muser_setting = this.muser_setting;
        r0.mis_dissolved = this.mis_dissolved;
        r0.mis_meeting = this.mis_meeting;
        r0.mlast_visible_message_id = this.mlast_visible_message_id;
        r0.mmessage_last_visible_patch = this.mmessage_last_visible_patch;
        r0.mlast_thread_id = this.mlast_thread_id;
        r0.mnew_thread_count = this.mnew_thread_count;
        r0.mlast_thread_position = this.mlast_thread_position;
        r0.mis_crypto = this.mis_crypto;
        r0.mno_badged_new_thread_count = this.mno_badged_new_thread_count;
        r0.mthread_start_position = this.mthread_start_position;
        r0.mchat_mode = this.mchat_mode;
        r0.mchat_config = this.mchat_config;
        r0.mis_cross_tenant = this.mis_cross_tenant;
        r0.mis_tenant = this.mis_tenant;
        r0.msupport_view = this.msupport_view;
        r0.mjoin_time_ms = this.mjoin_time_ms;
        r0.moncall_id = this.moncall_id;
        r0.mlast_visible_message_position = this.mlast_visible_message_position;
        r0.mlast_visible_message_no_badged_count = this.mlast_visible_message_no_badged_count;
        r0.mread_position = this.mread_position;
        r0.mread_position_badge_count = this.mread_position_badge_count;
        r0.mlast_message_position_badge_count = this.mlast_message_position_badge_count;
        r0.menable_watermark = this.menable_watermark;
        r0.mmini_avatar = this.mmini_avatar;
        r0.msidebar_id = this.msidebar_id;
        r0.mname_py = this.mname_py;
        r0.mi18n_names = Internal.copyOf("mi18n_names", this.mi18n_names);
        r0.mi18n_inf = this.mi18n_inf;
        r0.mread_thread_position = this.mread_thread_position;
        r0.mread_thread_position_badge_count = this.mread_thread_position_badge_count;
        r0.mlast_thread_position_badge_count = this.mlast_thread_position_badge_count;
        r0.mlast_visible_thread_position = this.mlast_visible_thread_position;
        r0.mlast_visible_thread_id = this.mlast_visible_thread_id;
        r0.mthread_last_visible_patch = this.mthread_last_visible_patch;
        r0.mchat_security_config = this.mchat_security_config;
        r0.mis_public_v2 = this.mis_public_v2;
        r0.mpost_type = this.mpost_type;
        r0.mallow_post = this.mallow_post;
        r0.mburned_time = this.mburned_time;
        r0.mput_chatter_apply_count = this.mput_chatter_apply_count;
        r0.mshow_banner = this.mshow_banner;
        r0.mis_large_group = this.mis_large_group;
        r0.mfirst_chat_message_position = this.mfirst_chat_message_position;
        r0.mtags = Internal.copyOf("mtags", this.mtags);
        r0.mextra = Internal.copyOf("mextra", this.mextra);
        r0.mis_same_page_meeting = this.mis_same_page_meeting;
        r0.mmy_threads_read_timestamp = this.mmy_threads_read_timestamp;
        r0.mmy_threads_last_timestamp = this.mmy_threads_last_timestamp;
        r0.mis_edu = this.mis_edu;
        r0.mmy_threads_last_display_message_id = this.mmy_threads_last_display_message_id;
        r0.mmy_threads_unread_count = this.mmy_threads_unread_count;
        r0.mis_cross_with_ka = this.mis_cross_with_ka;
        r0.mis_admin = this.mis_admin;
        r0.mis_super = this.mis_super;
        r0.mis_team = this.mis_team;
        r0.mbiz_content = this.mbiz_content;
        r0.mchatter_extra_states = Internal.copyOf("mchatter_extra_states", this.mchatter_extra_states);
        r0.mis_private_mode = this.mis_private_mode;
        r0.mopen_chat_id = this.mopen_chat_id;
        r0.mtoolkit = this.mtoolkit;
        r0.mchat_general_setting = this.mchat_general_setting;
        r0.mtag_data = this.mtag_data;
        r0.mgroup_type = Internal.copyOf("mgroup_type", this.mgroup_type);
        r0.mbiz_version_map = Internal.copyOf("mbiz_version_map", this.mbiz_version_map);
        r0.mcrypto_chat_info = this.mcrypto_chat_info;
        r0.mis_frozen = this.mis_frozen;
        r0.mchat_chatter_version = this.mchat_chatter_version;
        r0.mis_department_v1 = this.mis_department_v1;
        r0.mis_p2p_ai = this.mis_p2p_ai;
        r0.mbanner_setting = this.mbanner_setting;
        r0.mhas_chat_menu = this.mhas_chat_menu;
        r0.mis_p2p_official_bot_ai = this.mis_p2p_official_bot_ai;
        r0.mis_invisible = this.mis_invisible;
        r0.mis_cross_tenant_v1 = this.mis_cross_tenant_v1;
        r0.muser_auto_mute_setting = this.muser_auto_mute_setting;
        r0.mread_position_filter_mute_bot_badge_count = this.mread_position_filter_mute_bot_badge_count;
        r0.mlast_message_position_filter_mute_bot_badge_count = this.mlast_message_position_filter_mute_bot_badge_count;
        r0.mread_thread_position_filter_mute_bot_badge_count = this.mread_thread_position_filter_mute_bot_badge_count;
        r0.mlast_thread_message_position_filter_mute_bot_badge_count = this.mlast_thread_message_position_filter_mute_bot_badge_count;
        r0.mfilter_mute_bot_badge_count_version = this.mfilter_mute_bot_badge_count_version;
        r0.muser_clean_message_time_ms = this.muser_clean_message_time_ms;
        r0.mtns_op_kind = this.mtns_op_kind;
        r0.msystem_banned_info = this.msystem_banned_info;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Chat.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1060newBuilder();
    }

    public Chat(String r115, Type r116, String r117, String r118, Image r119, String r120, Integer r121, Status r122, Long r123, String r124, String r125, Integer r126, Boolean r127, Boolean r128, Integer r129, Integer r130, String r131, Long r132, Boolean r133, Role r134, Boolean r135, Integer r136, Boolean r137, Announcement r138, String r139, Long r140, Boolean r141, ChatEntitySetting r142, ChatSetting r143, Boolean r144, Boolean r145, String r146, MessageLastVisibleInfoPatch r147, String r148, Integer r149, Integer r150, Boolean r151, Integer r152, Integer r153, ChatMode r154, ChatConfig r155, Boolean r156, Boolean r157, SupportView r158, Long r159, Long r160, Integer r161, Integer r162, Integer r163, Integer r164, Integer r165, Boolean r166, Image r167, String r168, String r169, Map<String, String> r170, I18nInf r171, Integer r172, Integer r173, Integer r174, Integer r175, String r176, MessageLastVisibleInfoPatch r177, ChatSecurityConfig r178, Boolean r179, ChatPostType r180, Boolean r181, Long r182, Integer r183, Boolean r184, Boolean r185, Integer r186, List<Integer> r187, Map<String, String> r188, Boolean r189, Long r190, Long r191, Boolean r192, Long r193, Integer r194, Boolean r195, Boolean r196, Boolean r197, Boolean r198, ChatBizContent r199, Map<Integer, Integer> r200, Boolean r201, String r202, ChatToolkit r203, GeneralChatSetting r204, TagData r205, Map<Integer, Boolean> r206, Map<Integer, Long> r207, CryptoChatInfo r208, Boolean r209, Long r210, Boolean r211, Boolean r212, BannerSetting r213, Boolean r214, Boolean r215, Boolean r216, Boolean r217, ChatUserAutoMuteSetting r218, Integer r219, Integer r220, Integer r221, Integer r222, Long r223, Long r224, TnsOpKind r225, SystemBannedInfo r226) {
        this(r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, ByteString.EMPTY);
    }

    public Chat(String r4, Type r5, String r6, String r7, Image r8, String r9, Integer r10, Status r11, Long r12, String r13, String r14, Integer r15, Boolean r16, Boolean r17, Integer r18, Integer r19, String r20, Long r21, Boolean r22, Role r23, Boolean r24, Integer r25, Boolean r26, Announcement r27, String r28, Long r29, Boolean r30, ChatEntitySetting r31, ChatSetting r32, Boolean r33, Boolean r34, String r35, MessageLastVisibleInfoPatch r36, String r37, Integer r38, Integer r39, Boolean r40, Integer r41, Integer r42, ChatMode r43, ChatConfig r44, Boolean r45, Boolean r46, SupportView r47, Long r48, Long r49, Integer r50, Integer r51, Integer r52, Integer r53, Integer r54, Boolean r55, Image r56, String r57, String r58, Map<String, String> r59, I18nInf r60, Integer r61, Integer r62, Integer r63, Integer r64, String r65, MessageLastVisibleInfoPatch r66, ChatSecurityConfig r67, Boolean r68, ChatPostType r69, Boolean r70, Long r71, Integer r72, Boolean r73, Boolean r74, Integer r75, List<Integer> r76, Map<String, String> r77, Boolean r78, Long r79, Long r80, Boolean r81, Long r82, Integer r83, Boolean r84, Boolean r85, Boolean r86, Boolean r87, ChatBizContent r88, Map<Integer, Integer> r89, Boolean r90, String r91, ChatToolkit r92, GeneralChatSetting r93, TagData r94, Map<Integer, Boolean> r95, Map<Integer, Long> r96, CryptoChatInfo r97, Boolean r98, Long r99, Boolean r100, Boolean r101, BannerSetting r102, Boolean r103, Boolean r104, Boolean r105, Boolean r106, ChatUserAutoMuteSetting r107, Integer r108, Integer r109, Integer r110, Integer r111, Long r112, Long r113, TnsOpKind r114, SystemBannedInfo r115, ByteString r116) {
        super(ADAPTER, r116);
        this.mid = r4;
        this.mtype = r5;
        this.mlast_message_id = r6;
        this.mname = r7;
        this.mavatar = r8;
        this.mowner_id = r9;
        this.mnew_message_count = r10;
        this.mstatus = r11;
        this.mupdate_time = r12;
        this.mkey = r13;
        this.mdescription = r14;
        this.mmember_count = r15;
        this.mis_department = r16;
        this.mis_public = r17;
        this.mlast_message_position = r18;
        this.muser_count = r19;
        this.mname_pinyin = r20;
        this.mcreate_time = r21;
        this.mis_customer_service = r22;
        this.mrole = r23;
        this.mis_custom_icon = r24;
        this.mno_badged_new_message_count = r25;
        this.moff_edit_group_chat_info = r26;
        this.mannouncement = r27;
        this.mtenant_id = r28;
        this.mupdate_time_ms = r29;
        this.mis_remind = r30;
        this.mchat_entity_setting = r31;
        this.muser_setting = r32;
        this.mis_dissolved = r33;
        this.mis_meeting = r34;
        this.mlast_visible_message_id = r35;
        this.mmessage_last_visible_patch = r36;
        this.mlast_thread_id = r37;
        this.mnew_thread_count = r38;
        this.mlast_thread_position = r39;
        this.mis_crypto = r40;
        this.mno_badged_new_thread_count = r41;
        this.mthread_start_position = r42;
        this.mchat_mode = r43;
        this.mchat_config = r44;
        this.mis_cross_tenant = r45;
        this.mis_tenant = r46;
        this.msupport_view = r47;
        this.mjoin_time_ms = r48;
        this.moncall_id = r49;
        this.mlast_visible_message_position = r50;
        this.mlast_visible_message_no_badged_count = r51;
        this.mread_position = r52;
        this.mread_position_badge_count = r53;
        this.mlast_message_position_badge_count = r54;
        this.menable_watermark = r55;
        this.mmini_avatar = r56;
        this.msidebar_id = r57;
        this.mname_py = r58;
        this.mi18n_names = Internal.immutableCopyOf("mi18n_names", r59);
        this.mi18n_inf = r60;
        this.mread_thread_position = r61;
        this.mread_thread_position_badge_count = r62;
        this.mlast_thread_position_badge_count = r63;
        this.mlast_visible_thread_position = r64;
        this.mlast_visible_thread_id = r65;
        this.mthread_last_visible_patch = r66;
        this.mchat_security_config = r67;
        this.mis_public_v2 = r68;
        this.mpost_type = r69;
        this.mallow_post = r70;
        this.mburned_time = r71;
        this.mput_chatter_apply_count = r72;
        this.mshow_banner = r73;
        this.mis_large_group = r74;
        this.mfirst_chat_message_position = r75;
        this.mtags = Internal.immutableCopyOf("mtags", r76);
        this.mextra = Internal.immutableCopyOf("mextra", r77);
        this.mis_same_page_meeting = r78;
        this.mmy_threads_read_timestamp = r79;
        this.mmy_threads_last_timestamp = r80;
        this.mis_edu = r81;
        this.mmy_threads_last_display_message_id = r82;
        this.mmy_threads_unread_count = r83;
        this.mis_cross_with_ka = r84;
        this.mis_admin = r85;
        this.mis_super = r86;
        this.mis_team = r87;
        this.mbiz_content = r88;
        this.mchatter_extra_states = Internal.immutableCopyOf("mchatter_extra_states", r89);
        this.mis_private_mode = r90;
        this.mopen_chat_id = r91;
        this.mtoolkit = r92;
        this.mchat_general_setting = r93;
        this.mtag_data = r94;
        this.mgroup_type = Internal.immutableCopyOf("mgroup_type", r95);
        this.mbiz_version_map = Internal.immutableCopyOf("mbiz_version_map", r96);
        this.mcrypto_chat_info = r97;
        this.mis_frozen = r98;
        this.mchat_chatter_version = r99;
        this.mis_department_v1 = r100;
        this.mis_p2p_ai = r101;
        this.mbanner_setting = r102;
        this.mhas_chat_menu = r103;
        this.mis_p2p_official_bot_ai = r104;
        this.mis_invisible = r105;
        this.mis_cross_tenant_v1 = r106;
        this.muser_auto_mute_setting = r107;
        this.mread_position_filter_mute_bot_badge_count = r108;
        this.mlast_message_position_filter_mute_bot_badge_count = r109;
        this.mread_thread_position_filter_mute_bot_badge_count = r110;
        this.mlast_thread_message_position_filter_mute_bot_badge_count = r111;
        this.mfilter_mute_bot_badge_count_version = r112;
        this.muser_clean_message_time_ms = r113;
        this.mtns_op_kind = r114;
        this.msystem_banned_info = r115;
    }
}
