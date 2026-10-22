package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GetAdminSettingsResponse extends Message<GetAdminSettingsResponse, Builder> {
    public static final ProtoAdapter<GetAdminSettingsResponse> ADAPTER = null;
    public static final Boolean DEFAULT_ALLOW_USER_CHANGE_PSTN_AUDIO_TYPE = null;
    public static final Boolean DEFAULT_AUTO_SHARE_SCREEN_CCM_PERMISSION = null;
    public static final Boolean DEFAULT_CAN_PERSONAL_INSTALL = null;
    public static final Boolean DEFAULT_ENABLE_1080P_VIDEO = null;
    public static final Boolean DEFAULT_ENABLE_4K_SHARE = null;
    public static final Boolean DEFAULT_ENABLE_CHECK_SCREEN_SHARE = null;
    public static final Boolean DEFAULT_ENABLE_CUSTOM_MEETING_BACKGROUND = null;
    public static final Boolean DEFAULT_ENABLE_LIVE = null;
    public static final Boolean DEFAULT_ENABLE_LOCAL_RECORD = null;
    public static final Boolean DEFAULT_ENABLE_MEETING_BACKGROUND = null;
    public static final Boolean DEFAULT_ENABLE_MEETING_PASSWORD = null;
    public static final Boolean DEFAULT_ENABLE_PSTN_CALLOUT_SCOPE_ANY = null;
    public static final Boolean DEFAULT_ENABLE_RECORD = null;
    public static final Boolean DEFAULT_ENABLE_RECORD_AI_SUMMARY = null;
    public static final Boolean DEFAULT_ENABLE_SIP = null;
    public static final Boolean DEFAULT_ENABLE_SUBTITLE = null;
    public static final Boolean DEFAULT_ENABLE_VIRTUAL_AVATAR = null;
    public static final Boolean DEFAULT_ENABLE_VOICEPRINT = null;
    public static final Integer DEFAULT_JOIN_GROUP_MEETING_PRIVILEGE_TYPE = null;
    public static final Integer DEFAULT_JOIN_USER_INSTANT_MEETING_PRIVILEGE_TYPE = null;
    public static final Integer DEFAULT_JOIN_USER_RESERVED_MEETING_PRIVILEGE_TYPE = null;
    public static final Boolean DEFAULT_MEETING_FORCE_RECORD = null;
    public static final Boolean DEFAULT_PSTN_ENABLE_INCOMING_CALL = null;
    public static final Boolean DEFAULT_PSTN_ENABLE_OUTGOING_CALL = null;
    public static final Boolean DEFAULT_PSTN_HIDE_PHONE_NUMBER = null;
    public static final Boolean DEFAULT_PSTN_JOIN_MEETING_PROMPT = null;
    public static final Boolean DEFAULT_RECORD_AUTO_APPLY_START = null;
    public static final Boolean DEFAULT_RECORD_AUTO_START = null;
    public static final Boolean DEFAULT_RECORD_NEED_APPROVE = null;
    public static final Integer DEFAULT_SIP_DEFAULT_LAYOUT = null;
    public static final Boolean DEFAULT_SIP_ENABLE_DUAL_STREAM = null;
    public static final Boolean DEFAULT_SIP_ENABLE_ENTER_LEAVE_PROMPT = null;
    public static final Boolean DEFAULT_SIP_ENABLE_FECC = null;
    public static final Boolean DEFAULT_SIP_ENABLE_IM = null;
    public static final Boolean DEFAULT_SIP_ENABLE_SHOW_NAME = null;
    public static final Boolean DEFAULT_SIP_LIVE_NEED_APPROVE = null;
    public static final Boolean DEFAULT_SIP_NEED_ENCRYPT = null;
    public static final String DEFAULT_SIP_PROMPT_LANGUAGE = "";
    public static final Boolean DEFAULT_SIP_RECORD_NEED_APPROVE = null;
    public static final Integer DEFAULT_SIP_VIDEO_LOOP_INTERVAL = null;
    public static final Boolean DEFAULT_VOICE_FORCE_RECORD = null;
    private static final long serialVersionUID = 0;
    public final Boolean mallow_user_change_pstn_audio_type;
    public final Boolean mauto_share_screen_ccm_permission;
    public final Bandwidth mbandwidth;
    public final Boolean mcan_personal_install;
    public final Boolean menable_1080p_video;
    public final Boolean menable_4k_share;
    public final Boolean menable_check_screen_share;
    public final Boolean menable_custom_meeting_background;
    public final Boolean menable_live;
    public final Boolean menable_local_record;
    public final Boolean menable_meeting_background;
    public final Boolean menable_meeting_password;
    public final Boolean menable_pstn_callout_scope_any;
    public final Boolean menable_record;
    public final Boolean menable_record_ai_summary;
    public final Boolean menable_sip;
    public final Boolean menable_subtitle;
    public final Boolean menable_virtual_avatar;
    public final Boolean menable_voiceprint;
    public final Integer mjoin_group_meeting_privilege_type;
    public final Integer mjoin_user_instant_meeting_privilege_type;
    public final Integer mjoin_user_reserved_meeting_privilege_type;
    public final List<MeetingBackground> mmeeting_background_list;
    public final Boolean mmeeting_force_record;
    public final Boolean mpstn_enable_incoming_call;
    public final Boolean mpstn_enable_outgoing_call;
    public final Boolean mpstn_hide_phone_number;
    public final List<String> mpstn_incoming_call_country_default;
    public final List<PSTNPhone> mpstn_incoming_call_phone_list;
    public final Boolean mpstn_join_meeting_prompt;
    public final List<String> mpstn_outgoing_call_country_default;
    public final List<String> mpstn_outgoing_call_country_list;
    public final Boolean mrecord_auto_apply_start;
    public final Boolean mrecord_auto_start;
    public final Boolean mrecord_need_approve;
    public final RTCProxy mrtc_proxy;
    public final List<RTCProxy> mrtc_proxy_list;
    public final ShareScreenConfirm mshare_screen_confirm;
    public final Integer msip_default_layout;
    public final Boolean msip_enable_dual_stream;
    public final Boolean msip_enable_enter_leave_prompt;
    public final Boolean msip_enable_fecc;
    public final Boolean msip_enable_im;
    public final Boolean msip_enable_show_name;
    public final Boolean msip_live_need_approve;
    public final Boolean msip_need_encrypt;
    public final String msip_prompt_language;
    public final Boolean msip_record_need_approve;
    public final Integer msip_video_loop_interval;
    public final List<String> mspeed_up_nodes;
    public final Boolean mvoice_force_record;

    public static final class Builder extends Message.Builder<GetAdminSettingsResponse, Builder> {
        public Boolean mallow_user_change_pstn_audio_type;
        public Boolean mauto_share_screen_ccm_permission;
        public Bandwidth mbandwidth;
        public Boolean mcan_personal_install;
        public Boolean menable_1080p_video;
        public Boolean menable_4k_share;
        public Boolean menable_check_screen_share;
        public Boolean menable_custom_meeting_background;
        public Boolean menable_live;
        public Boolean menable_local_record;
        public Boolean menable_meeting_background;
        public Boolean menable_meeting_password;
        public Boolean menable_pstn_callout_scope_any;
        public Boolean menable_record;
        public Boolean menable_record_ai_summary;
        public Boolean menable_sip;
        public Boolean menable_subtitle;
        public Boolean menable_virtual_avatar;
        public Boolean menable_voiceprint;
        public Integer mjoin_group_meeting_privilege_type;
        public Integer mjoin_user_instant_meeting_privilege_type;
        public Integer mjoin_user_reserved_meeting_privilege_type;
        public List<MeetingBackground> mmeeting_background_list;
        public Boolean mmeeting_force_record;
        public Boolean mpstn_enable_incoming_call;
        public Boolean mpstn_enable_outgoing_call;
        public Boolean mpstn_hide_phone_number;
        public List<String> mpstn_incoming_call_country_default;
        public List<PSTNPhone> mpstn_incoming_call_phone_list;
        public Boolean mpstn_join_meeting_prompt;
        public List<String> mpstn_outgoing_call_country_default;
        public List<String> mpstn_outgoing_call_country_list;
        public Boolean mrecord_auto_apply_start;
        public Boolean mrecord_auto_start;
        public Boolean mrecord_need_approve;
        public RTCProxy mrtc_proxy;
        public List<RTCProxy> mrtc_proxy_list;
        public ShareScreenConfirm mshare_screen_confirm;
        public Integer msip_default_layout;
        public Boolean msip_enable_dual_stream;
        public Boolean msip_enable_enter_leave_prompt;
        public Boolean msip_enable_fecc;
        public Boolean msip_enable_im;
        public Boolean msip_enable_show_name;
        public Boolean msip_live_need_approve;
        public Boolean msip_need_encrypt;
        public String msip_prompt_language;
        public Boolean msip_record_need_approve;
        public Integer msip_video_loop_interval;
        public List<String> mspeed_up_nodes;
        public Boolean mvoice_force_record;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetAdminSettingsResponse m3113build() {
            return new GetAdminSettingsResponse(this.menable_record, this.menable_subtitle, this.mrecord_need_approve, this.mpstn_enable_outgoing_call, this.mpstn_hide_phone_number, this.mpstn_enable_incoming_call, this.mpstn_incoming_call_country_default, this.mpstn_incoming_call_phone_list, this.mpstn_outgoing_call_country_default, this.mpstn_outgoing_call_country_list, this.mpstn_join_meeting_prompt, this.msip_need_encrypt, this.msip_prompt_language, this.msip_record_need_approve, this.msip_live_need_approve, this.msip_enable_dual_stream, this.msip_enable_im, this.msip_enable_enter_leave_prompt, this.msip_enable_show_name, this.msip_default_layout, this.msip_video_loop_interval, this.msip_enable_fecc, this.menable_meeting_background, this.menable_custom_meeting_background, this.mmeeting_background_list, this.menable_virtual_avatar, this.mrtc_proxy, this.menable_sip, this.mcan_personal_install, this.menable_check_screen_share, this.mrecord_auto_start, this.mrecord_auto_apply_start, this.mjoin_group_meeting_privilege_type, this.mjoin_user_instant_meeting_privilege_type, this.mjoin_user_reserved_meeting_privilege_type, this.menable_pstn_callout_scope_any, this.menable_voiceprint, this.mallow_user_change_pstn_audio_type, this.menable_live, this.mspeed_up_nodes, this.mauto_share_screen_ccm_permission, this.mrtc_proxy_list, this.mshare_screen_confirm, this.mbandwidth, this.menable_local_record, this.menable_record_ai_summary, this.menable_meeting_password, this.mmeeting_force_record, this.mvoice_force_record, this.menable_4k_share, this.menable_1080p_video, super.buildUnknownFields());
        }

        public Builder() {
            this.mpstn_incoming_call_country_default = Internal.newMutableList();
            this.mpstn_incoming_call_phone_list = Internal.newMutableList();
            this.mpstn_outgoing_call_country_default = Internal.newMutableList();
            this.mpstn_outgoing_call_country_list = Internal.newMutableList();
            this.mmeeting_background_list = Internal.newMutableList();
            this.mspeed_up_nodes = Internal.newMutableList();
            this.mrtc_proxy_list = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3113build();
        }

        public Builder allow_user_change_pstn_audio_type(Boolean r1) {
            this.mallow_user_change_pstn_audio_type = r1;
            return this;
        }

        public Builder auto_share_screen_ccm_permission(Boolean r1) {
            this.mauto_share_screen_ccm_permission = r1;
            return this;
        }

        public Builder bandwidth(Bandwidth r1) {
            this.mbandwidth = r1;
            return this;
        }

        public Builder can_personal_install(Boolean r1) {
            this.mcan_personal_install = r1;
            return this;
        }

        public Builder enable_1080p_video(Boolean r1) {
            this.menable_1080p_video = r1;
            return this;
        }

        public Builder enable_4k_share(Boolean r1) {
            this.menable_4k_share = r1;
            return this;
        }

        public Builder enable_check_screen_share(Boolean r1) {
            this.menable_check_screen_share = r1;
            return this;
        }

        public Builder enable_custom_meeting_background(Boolean r1) {
            this.menable_custom_meeting_background = r1;
            return this;
        }

        public Builder enable_live(Boolean r1) {
            this.menable_live = r1;
            return this;
        }

        public Builder enable_local_record(Boolean r1) {
            this.menable_local_record = r1;
            return this;
        }

        public Builder enable_meeting_background(Boolean r1) {
            this.menable_meeting_background = r1;
            return this;
        }

        public Builder enable_meeting_password(Boolean r1) {
            this.menable_meeting_password = r1;
            return this;
        }

        public Builder enable_pstn_callout_scope_any(Boolean r1) {
            this.menable_pstn_callout_scope_any = r1;
            return this;
        }

        public Builder enable_record(Boolean r1) {
            this.menable_record = r1;
            return this;
        }

        public Builder enable_record_ai_summary(Boolean r1) {
            this.menable_record_ai_summary = r1;
            return this;
        }

        public Builder enable_sip(Boolean r1) {
            this.menable_sip = r1;
            return this;
        }

        public Builder enable_subtitle(Boolean r1) {
            this.menable_subtitle = r1;
            return this;
        }

        public Builder enable_virtual_avatar(Boolean r1) {
            this.menable_virtual_avatar = r1;
            return this;
        }

        public Builder enable_voiceprint(Boolean r1) {
            this.menable_voiceprint = r1;
            return this;
        }

        public Builder join_group_meeting_privilege_type(Integer r1) {
            this.mjoin_group_meeting_privilege_type = r1;
            return this;
        }

        public Builder join_user_instant_meeting_privilege_type(Integer r1) {
            this.mjoin_user_instant_meeting_privilege_type = r1;
            return this;
        }

        public Builder join_user_reserved_meeting_privilege_type(Integer r1) {
            this.mjoin_user_reserved_meeting_privilege_type = r1;
            return this;
        }

        public Builder meeting_background_list(List<MeetingBackground> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmeeting_background_list = r1;
            return this;
        }

        public Builder meeting_force_record(Boolean r1) {
            this.mmeeting_force_record = r1;
            return this;
        }

        public Builder pstn_enable_incoming_call(Boolean r1) {
            this.mpstn_enable_incoming_call = r1;
            return this;
        }

        public Builder pstn_enable_outgoing_call(Boolean r1) {
            this.mpstn_enable_outgoing_call = r1;
            return this;
        }

        public Builder pstn_hide_phone_number(Boolean r1) {
            this.mpstn_hide_phone_number = r1;
            return this;
        }

        public Builder pstn_incoming_call_country_default(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpstn_incoming_call_country_default = r1;
            return this;
        }

        public Builder pstn_incoming_call_phone_list(List<PSTNPhone> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpstn_incoming_call_phone_list = r1;
            return this;
        }

        public Builder pstn_join_meeting_prompt(Boolean r1) {
            this.mpstn_join_meeting_prompt = r1;
            return this;
        }

        public Builder pstn_outgoing_call_country_default(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpstn_outgoing_call_country_default = r1;
            return this;
        }

        public Builder pstn_outgoing_call_country_list(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpstn_outgoing_call_country_list = r1;
            return this;
        }

        public Builder record_auto_apply_start(Boolean r1) {
            this.mrecord_auto_apply_start = r1;
            return this;
        }

        public Builder record_auto_start(Boolean r1) {
            this.mrecord_auto_start = r1;
            return this;
        }

        public Builder record_need_approve(Boolean r1) {
            this.mrecord_need_approve = r1;
            return this;
        }

        public Builder rtc_proxy(RTCProxy r1) {
            this.mrtc_proxy = r1;
            return this;
        }

        public Builder rtc_proxy_list(List<RTCProxy> r1) {
            Internal.checkElementsNotNull(r1);
            this.mrtc_proxy_list = r1;
            return this;
        }

        public Builder share_screen_confirm(ShareScreenConfirm r1) {
            this.mshare_screen_confirm = r1;
            return this;
        }

        public Builder sip_default_layout(Integer r1) {
            this.msip_default_layout = r1;
            return this;
        }

        public Builder sip_enable_dual_stream(Boolean r1) {
            this.msip_enable_dual_stream = r1;
            return this;
        }

        public Builder sip_enable_enter_leave_prompt(Boolean r1) {
            this.msip_enable_enter_leave_prompt = r1;
            return this;
        }

        public Builder sip_enable_fecc(Boolean r1) {
            this.msip_enable_fecc = r1;
            return this;
        }

        public Builder sip_enable_im(Boolean r1) {
            this.msip_enable_im = r1;
            return this;
        }

        public Builder sip_enable_show_name(Boolean r1) {
            this.msip_enable_show_name = r1;
            return this;
        }

        public Builder sip_live_need_approve(Boolean r1) {
            this.msip_live_need_approve = r1;
            return this;
        }

        public Builder sip_need_encrypt(Boolean r1) {
            this.msip_need_encrypt = r1;
            return this;
        }

        public Builder sip_prompt_language(String r1) {
            this.msip_prompt_language = r1;
            return this;
        }

        public Builder sip_record_need_approve(Boolean r1) {
            this.msip_record_need_approve = r1;
            return this;
        }

        public Builder sip_video_loop_interval(Integer r1) {
            this.msip_video_loop_interval = r1;
            return this;
        }

        public Builder speed_up_nodes(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mspeed_up_nodes = r1;
            return this;
        }

        public Builder voice_force_record(Boolean r1) {
            this.mvoice_force_record = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAdminSettingsResponse extends ProtoAdapter<GetAdminSettingsResponse> {
        public ProtoAdapter_GetAdminSettingsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAdminSettingsResponse.class);
        }

        public GetAdminSettingsResponse decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.FALSE;
            r0.menable_record = r1;
            r0.menable_subtitle = r1;
            r0.mrecord_need_approve = r1;
            r0.mpstn_enable_outgoing_call = r1;
            r0.mpstn_hide_phone_number = r1;
            r0.mpstn_enable_incoming_call = r1;
            r0.mpstn_join_meeting_prompt = r1;
            r0.msip_need_encrypt = r1;
            r0.msip_prompt_language = "";
            r0.msip_record_need_approve = r1;
            r0.msip_live_need_approve = r1;
            r0.msip_enable_dual_stream = r1;
            r0.msip_enable_im = r1;
            r0.msip_enable_enter_leave_prompt = r1;
            r0.msip_enable_show_name = r1;
            r0.msip_default_layout = 0;
            r0.msip_video_loop_interval = 0;
            r0.msip_enable_fecc = r1;
            r0.menable_meeting_background = r1;
            r0.menable_custom_meeting_background = r1;
            r0.menable_virtual_avatar = r1;
            r0.menable_sip = r1;
            r0.mcan_personal_install = r1;
            r0.menable_check_screen_share = r1;
            r0.mrecord_auto_start = r1;
            r0.mrecord_auto_apply_start = r1;
            r0.mjoin_group_meeting_privilege_type = 0;
            r0.mjoin_user_instant_meeting_privilege_type = 0;
            r0.mjoin_user_reserved_meeting_privilege_type = 0;
            r0.menable_pstn_callout_scope_any = r1;
            r0.menable_voiceprint = r1;
            r0.mallow_user_change_pstn_audio_type = r1;
            r0.menable_live = r1;
            r0.mauto_share_screen_ccm_permission = r1;
            r0.menable_local_record = r1;
            r0.menable_record_ai_summary = r1;
            r0.menable_meeting_password = r1;
            r0.mmeeting_force_record = r1;
            r0.mvoice_force_record = r1;
            r0.menable_4k_share = r1;
            r0.menable_1080p_video = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L61;
            switch(r3) {
                case 1: goto L60;
                case 2: goto L59;
                case 3: goto L58;
                case 4: goto L57;
                case 5: goto L56;
                case 6: goto L55;
                case 7: goto L54;
                case 8: goto L53;
                case 9: goto L52;
                case 10: goto L51;
                case 11: goto L50;
                case 12: goto L49;
                case 13: goto L48;
                case 14: goto L47;
                case 15: goto L46;
                case 16: goto L45;
                case 17: goto L44;
                case 18: goto L43;
                case 19: goto L42;
                case 20: goto L41;
                case 21: goto L40;
                case 22: goto L39;
                case 23: goto L38;
                case 24: goto L37;
                case 25: goto L36;
                case 26: goto L35;
                case 27: goto L34;
                case 28: goto L33;
                case 29: goto L32;
                case 30: goto L31;
                case 31: goto L30;
                case 32: goto L29;
                case 33: goto L28;
                case 34: goto L27;
                case 35: goto L26;
                case 36: goto L25;
                case 37: goto L24;
                case 38: goto L23;
                case 39: goto L22;
                case 40: goto L21;
                case 41: goto L20;
                case 42: goto L19;
                case 43: goto L63;
                case 44: goto L14;
                case 45: goto L13;
                case 46: goto L12;
                case 47: goto L11;
                case 48: goto L10;
                case 49: goto L9;
                case 50: goto L8;
                case 51: goto L7;
                default: goto L6;
            };
        L63:
            r0.mshare_screen_confirm = (ShareScreenConfirm) ShareScreenConfirm.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.menable_1080p_video = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L8:
            r0.menable_4k_share = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L9:
            r0.mvoice_force_record = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L10:
            r0.mmeeting_force_record = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L11:
            r0.menable_meeting_password = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L12:
            r0.menable_record_ai_summary = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L13:
            r0.menable_local_record = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L14:
            r0.mbandwidth = (Bandwidth) Bandwidth.ADAPTER.decode(r9);
            goto L3
        L19:
            r0.mrtc_proxy_list.add((RTCProxy) RTCProxy.ADAPTER.decode(r9));
            goto L3
        L20:
            r0.mauto_share_screen_ccm_permission = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L21:
            r0.mspeed_up_nodes.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L22:
            r0.menable_live = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L23:
            r0.mallow_user_change_pstn_audio_type = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L24:
            r0.menable_voiceprint = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L25:
            r0.menable_pstn_callout_scope_any = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L26:
            r0.mjoin_user_reserved_meeting_privilege_type = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L27:
            r0.mjoin_user_instant_meeting_privilege_type = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L28:
            r0.mjoin_group_meeting_privilege_type = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L29:
            r0.mrecord_auto_apply_start = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L30:
            r0.mrecord_auto_start = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L31:
            r0.menable_check_screen_share = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L32:
            r0.mcan_personal_install = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L33:
            r0.menable_sip = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L34:
            r0.mrtc_proxy = (RTCProxy) RTCProxy.ADAPTER.decode(r9);
            goto L3
        L35:
            r0.menable_virtual_avatar = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L36:
            r0.mmeeting_background_list.add((MeetingBackground) MeetingBackground.ADAPTER.decode(r9));
            goto L3
        L37:
            r0.menable_custom_meeting_background = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L38:
            r0.menable_meeting_background = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L39:
            r0.msip_enable_fecc = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L40:
            r0.msip_video_loop_interval = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L41:
            r0.msip_default_layout = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L42:
            r0.msip_enable_show_name = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L43:
            r0.msip_enable_enter_leave_prompt = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L44:
            r0.msip_enable_im = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L45:
            r0.msip_enable_dual_stream = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L46:
            r0.msip_live_need_approve = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L47:
            r0.msip_record_need_approve = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L48:
            r0.msip_prompt_language = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L49:
            r0.msip_need_encrypt = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L50:
            r0.mpstn_join_meeting_prompt = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L51:
            r0.mpstn_outgoing_call_country_list.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L52:
            r0.mpstn_outgoing_call_country_default.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L53:
            r0.mpstn_incoming_call_phone_list.add((PSTNPhone) PSTNPhone.ADAPTER.decode(r9));
            goto L3
        L54:
            r0.mpstn_incoming_call_country_default.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L55:
            r0.mpstn_enable_incoming_call = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L56:
            r0.mpstn_hide_phone_number = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L57:
            r0.mpstn_enable_outgoing_call = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L58:
            r0.mrecord_need_approve = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L59:
            r0.menable_subtitle = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L60:
            r0.menable_record = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L61:
            r9.endMessage(r2);
            return r0.m3113build();
        }

        public int encodedSize(GetAdminSettingsResponse r7) {
            Boolean r0 = r7.menable_record;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r7.menable_subtitle;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r6 = r7.mrecord_need_approve;
            if (r6 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r6);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r7.mpstn_enable_outgoing_call;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Boolean r13 = r7.mpstn_hide_phone_number;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Boolean r16 = r7.mpstn_enable_incoming_call;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            ProtoAdapter r19 = ProtoAdapter.STRING;
            int r20 = (((r18 + r19.asRepeated().encodedSizeWithTag(7, r7.mpstn_incoming_call_country_default)) + PSTNPhone.ADAPTER.asRepeated().encodedSizeWithTag(8, r7.mpstn_incoming_call_phone_list)) + r19.asRepeated().encodedSizeWithTag(9, r7.mpstn_outgoing_call_country_default)) + r19.asRepeated().encodedSizeWithTag(10, r7.mpstn_outgoing_call_country_list);
            Boolean r21 = r7.mpstn_join_meeting_prompt;
            if (r21 == null) goto L29;
            int r22 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r21);
        L30:
            int r23 = r20 + r22;
            Boolean r24 = r7.msip_need_encrypt;
            if (r24 == null) goto L33;
            int r25 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r24);
        L34:
            int r26 = r23 + r25;
            String r27 = r7.msip_prompt_language;
            if (r27 == null) goto L37;
            int r28 = r19.encodedSizeWithTag(13, r27);
        L38:
            int r29 = r26 + r28;
            Boolean r30 = r7.msip_record_need_approve;
            if (r30 == null) goto L41;
            int r31 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r30);
        L42:
            int r32 = r29 + r31;
            Boolean r33 = r7.msip_live_need_approve;
            if (r33 == null) goto L45;
            int r34 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r33);
        L46:
            int r35 = r32 + r34;
            Boolean r36 = r7.msip_enable_dual_stream;
            if (r36 == null) goto L49;
            int r37 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r36);
        L50:
            int r38 = r35 + r37;
            Boolean r39 = r7.msip_enable_im;
            if (r39 == null) goto L53;
            int r40 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r39);
        L54:
            int r41 = r38 + r40;
            Boolean r42 = r7.msip_enable_enter_leave_prompt;
            if (r42 == null) goto L57;
            int r43 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r42);
        L58:
            int r44 = r41 + r43;
            Boolean r45 = r7.msip_enable_show_name;
            if (r45 == null) goto L61;
            int r46 = ProtoAdapter.BOOL.encodedSizeWithTag(19, r45);
        L62:
            int r47 = r44 + r46;
            Integer r48 = r7.msip_default_layout;
            if (r48 == null) goto L65;
            int r49 = ProtoAdapter.INT32.encodedSizeWithTag(20, r48);
        L66:
            int r50 = r47 + r49;
            Integer r51 = r7.msip_video_loop_interval;
            if (r51 == null) goto L69;
            int r52 = ProtoAdapter.INT32.encodedSizeWithTag(21, r51);
        L70:
            int r53 = r50 + r52;
            Boolean r54 = r7.msip_enable_fecc;
            if (r54 == null) goto L73;
            int r55 = ProtoAdapter.BOOL.encodedSizeWithTag(22, r54);
        L74:
            int r56 = r53 + r55;
            Boolean r57 = r7.menable_meeting_background;
            if (r57 == null) goto L77;
            int r58 = ProtoAdapter.BOOL.encodedSizeWithTag(23, r57);
        L78:
            int r59 = r56 + r58;
            Boolean r60 = r7.menable_custom_meeting_background;
            if (r60 == null) goto L81;
            int r61 = ProtoAdapter.BOOL.encodedSizeWithTag(24, r60);
        L82:
            int r62 = (r59 + r61) + MeetingBackground.ADAPTER.asRepeated().encodedSizeWithTag(25, r7.mmeeting_background_list);
            Boolean r63 = r7.menable_virtual_avatar;
            if (r63 == null) goto L85;
            int r64 = ProtoAdapter.BOOL.encodedSizeWithTag(26, r63);
        L86:
            int r65 = r62 + r64;
            RTCProxy r66 = r7.mrtc_proxy;
            if (r66 == null) goto L89;
            int r67 = RTCProxy.ADAPTER.encodedSizeWithTag(27, r66);
        L90:
            int r68 = r65 + r67;
            Boolean r69 = r7.menable_sip;
            if (r69 == null) goto L93;
            int r70 = ProtoAdapter.BOOL.encodedSizeWithTag(28, r69);
        L94:
            int r71 = r68 + r70;
            Boolean r72 = r7.mcan_personal_install;
            if (r72 == null) goto L97;
            int r73 = ProtoAdapter.BOOL.encodedSizeWithTag(29, r72);
        L98:
            int r74 = r71 + r73;
            Boolean r75 = r7.menable_check_screen_share;
            if (r75 == null) goto L101;
            int r76 = ProtoAdapter.BOOL.encodedSizeWithTag(30, r75);
        L102:
            int r77 = r74 + r76;
            Boolean r78 = r7.mrecord_auto_start;
            if (r78 == null) goto L105;
            int r79 = ProtoAdapter.BOOL.encodedSizeWithTag(31, r78);
        L106:
            int r80 = r77 + r79;
            Boolean r81 = r7.mrecord_auto_apply_start;
            if (r81 == null) goto L109;
            int r82 = ProtoAdapter.BOOL.encodedSizeWithTag(32, r81);
        L110:
            int r83 = r80 + r82;
            Integer r84 = r7.mjoin_group_meeting_privilege_type;
            if (r84 == null) goto L113;
            int r85 = ProtoAdapter.INT32.encodedSizeWithTag(33, r84);
        L114:
            int r86 = r83 + r85;
            Integer r87 = r7.mjoin_user_instant_meeting_privilege_type;
            if (r87 == null) goto L117;
            int r88 = ProtoAdapter.INT32.encodedSizeWithTag(34, r87);
        L118:
            int r89 = r86 + r88;
            Integer r90 = r7.mjoin_user_reserved_meeting_privilege_type;
            if (r90 == null) goto L121;
            int r91 = ProtoAdapter.INT32.encodedSizeWithTag(35, r90);
        L122:
            int r92 = r89 + r91;
            Boolean r93 = r7.menable_pstn_callout_scope_any;
            if (r93 == null) goto L125;
            int r94 = ProtoAdapter.BOOL.encodedSizeWithTag(36, r93);
        L126:
            int r95 = r92 + r94;
            Boolean r96 = r7.menable_voiceprint;
            if (r96 == null) goto L129;
            int r97 = ProtoAdapter.BOOL.encodedSizeWithTag(37, r96);
        L130:
            int r98 = r95 + r97;
            Boolean r99 = r7.mallow_user_change_pstn_audio_type;
            if (r99 == null) goto L133;
            int r100 = ProtoAdapter.BOOL.encodedSizeWithTag(38, r99);
        L134:
            int r101 = r98 + r100;
            Boolean r102 = r7.menable_live;
            if (r102 == null) goto L137;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(39, r102);
        L138:
            int r104 = (r101 + r103) + r19.asRepeated().encodedSizeWithTag(40, r7.mspeed_up_nodes);
            Boolean r105 = r7.mauto_share_screen_ccm_permission;
            if (r105 == null) goto L141;
            int r106 = ProtoAdapter.BOOL.encodedSizeWithTag(41, r105);
        L142:
            int r107 = (r104 + r106) + RTCProxy.ADAPTER.asRepeated().encodedSizeWithTag(42, r7.mrtc_proxy_list);
            ShareScreenConfirm r108 = r7.mshare_screen_confirm;
            if (r108 == null) goto L145;
            int r109 = ShareScreenConfirm.ADAPTER.encodedSizeWithTag(43, r108);
        L146:
            int r110 = r107 + r109;
            Bandwidth r111 = r7.mbandwidth;
            if (r111 == null) goto L149;
            int r112 = Bandwidth.ADAPTER.encodedSizeWithTag(44, r111);
        L150:
            int r113 = r110 + r112;
            Boolean r114 = r7.menable_local_record;
            if (r114 == null) goto L153;
            int r115 = ProtoAdapter.BOOL.encodedSizeWithTag(45, r114);
        L154:
            int r116 = r113 + r115;
            Boolean r117 = r7.menable_record_ai_summary;
            if (r117 == null) goto L157;
            int r118 = ProtoAdapter.BOOL.encodedSizeWithTag(46, r117);
        L158:
            int r119 = r116 + r118;
            Boolean r120 = r7.menable_meeting_password;
            if (r120 == null) goto L161;
            int r121 = ProtoAdapter.BOOL.encodedSizeWithTag(47, r120);
        L162:
            int r122 = r119 + r121;
            Boolean r123 = r7.mmeeting_force_record;
            if (r123 == null) goto L165;
            int r124 = ProtoAdapter.BOOL.encodedSizeWithTag(48, r123);
        L166:
            int r125 = r122 + r124;
            Boolean r126 = r7.mvoice_force_record;
            if (r126 == null) goto L169;
            int r127 = ProtoAdapter.BOOL.encodedSizeWithTag(49, r126);
        L170:
            int r128 = r125 + r127;
            Boolean r129 = r7.menable_4k_share;
            if (r129 == null) goto L173;
            int r130 = ProtoAdapter.BOOL.encodedSizeWithTag(50, r129);
        L174:
            int r131 = r128 + r130;
            Boolean r132 = r7.menable_1080p_video;
            if (r132 == null) goto L178;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(51, r132);
        L178:
            return (r131 + r1) + r7.unknownFields().size();
        L173:
            r130 = 0;
            goto L174
        L169:
            r127 = 0;
            goto L170
        L165:
            r124 = 0;
            goto L166
        L161:
            r121 = 0;
            goto L162
        L157:
            r118 = 0;
            goto L158
        L153:
            r115 = 0;
            goto L154
        L149:
            r112 = 0;
            goto L150
        L145:
            r109 = 0;
            goto L146
        L141:
            r106 = 0;
            goto L142
        L137:
            r103 = 0;
            goto L138
        L133:
            r100 = 0;
            goto L134
        L129:
            r97 = 0;
            goto L130
        L125:
            r94 = 0;
            goto L126
        L121:
            r91 = 0;
            goto L122
        L117:
            r88 = 0;
            goto L118
        L113:
            r85 = 0;
            goto L114
        L109:
            r82 = 0;
            goto L110
        L105:
            r79 = 0;
            goto L106
        L101:
            r76 = 0;
            goto L102
        L97:
            r73 = 0;
            goto L98
        L93:
            r70 = 0;
            goto L94
        L89:
            r67 = 0;
            goto L90
        L85:
            r64 = 0;
            goto L86
        L81:
            r61 = 0;
            goto L82
        L77:
            r58 = 0;
            goto L78
        L73:
            r55 = 0;
            goto L74
        L69:
            r52 = 0;
            goto L70
        L65:
            r49 = 0;
            goto L66
        L61:
            r46 = 0;
            goto L62
        L57:
            r43 = 0;
            goto L58
        L53:
            r40 = 0;
            goto L54
        L49:
            r37 = 0;
            goto L50
        L45:
            r34 = 0;
            goto L46
        L41:
            r31 = 0;
            goto L42
        L37:
            r28 = 0;
            goto L38
        L33:
            r25 = 0;
            goto L34
        L29:
            r22 = 0;
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
        public /* bridge */ /* synthetic */ Object m3114decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetAdminSettingsResponse) r1);
        }

        public void encode(ProtoWriter r5, GetAdminSettingsResponse r6) throws IOException {
            Boolean r0 = r6.menable_record;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r5, 1, r0);
        L5:
            Boolean r1 = r6.menable_subtitle;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r5, 2, r1);
        L8:
            Boolean r2 = r6.mrecord_need_approve;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r5, 3, r2);
        L11:
            Boolean r3 = r6.mpstn_enable_outgoing_call;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r5, 4, r3);
        L14:
            Boolean r4 = r6.mpstn_hide_phone_number;
            if (r4 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r5, 5, r4);
        L17:
            Boolean r7 = r6.mpstn_enable_incoming_call;
            if (r7 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r5, 6, r7);
        L20:
            ProtoAdapter r8 = ProtoAdapter.STRING;
            r8.asRepeated().encodeWithTag(r5, 7, r6.mpstn_incoming_call_country_default);
            PSTNPhone.ADAPTER.asRepeated().encodeWithTag(r5, 8, r6.mpstn_incoming_call_phone_list);
            r8.asRepeated().encodeWithTag(r5, 9, r6.mpstn_outgoing_call_country_default);
            r8.asRepeated().encodeWithTag(r5, 10, r6.mpstn_outgoing_call_country_list);
            Boolean r9 = r6.mpstn_join_meeting_prompt;
            if (r9 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r5, 11, r9);
        L23:
            Boolean r10 = r6.msip_need_encrypt;
            if (r10 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r5, 12, r10);
        L26:
            String r11 = r6.msip_prompt_language;
            if (r11 == null) goto L29;
            r8.encodeWithTag(r5, 13, r11);
        L29:
            Boolean r12 = r6.msip_record_need_approve;
            if (r12 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r5, 14, r12);
        L32:
            Boolean r13 = r6.msip_live_need_approve;
            if (r13 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r5, 15, r13);
        L35:
            Boolean r14 = r6.msip_enable_dual_stream;
            if (r14 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r5, 16, r14);
        L38:
            Boolean r15 = r6.msip_enable_im;
            if (r15 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r5, 17, r15);
        L41:
            Boolean r16 = r6.msip_enable_enter_leave_prompt;
            if (r16 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r5, 18, r16);
        L44:
            Boolean r17 = r6.msip_enable_show_name;
            if (r17 == null) goto L47;
            ProtoAdapter.BOOL.encodeWithTag(r5, 19, r17);
        L47:
            Integer r18 = r6.msip_default_layout;
            if (r18 == null) goto L50;
            ProtoAdapter.INT32.encodeWithTag(r5, 20, r18);
        L50:
            Integer r19 = r6.msip_video_loop_interval;
            if (r19 == null) goto L53;
            ProtoAdapter.INT32.encodeWithTag(r5, 21, r19);
        L53:
            Boolean r20 = r6.msip_enable_fecc;
            if (r20 == null) goto L56;
            ProtoAdapter.BOOL.encodeWithTag(r5, 22, r20);
        L56:
            Boolean r21 = r6.menable_meeting_background;
            if (r21 == null) goto L59;
            ProtoAdapter.BOOL.encodeWithTag(r5, 23, r21);
        L59:
            Boolean r22 = r6.menable_custom_meeting_background;
            if (r22 == null) goto L62;
            ProtoAdapter.BOOL.encodeWithTag(r5, 24, r22);
        L62:
            MeetingBackground.ADAPTER.asRepeated().encodeWithTag(r5, 25, r6.mmeeting_background_list);
            Boolean r23 = r6.menable_virtual_avatar;
            if (r23 == null) goto L65;
            ProtoAdapter.BOOL.encodeWithTag(r5, 26, r23);
        L65:
            RTCProxy r24 = r6.mrtc_proxy;
            if (r24 == null) goto L68;
            RTCProxy.ADAPTER.encodeWithTag(r5, 27, r24);
        L68:
            Boolean r25 = r6.menable_sip;
            if (r25 == null) goto L71;
            ProtoAdapter.BOOL.encodeWithTag(r5, 28, r25);
        L71:
            Boolean r26 = r6.mcan_personal_install;
            if (r26 == null) goto L74;
            ProtoAdapter.BOOL.encodeWithTag(r5, 29, r26);
        L74:
            Boolean r27 = r6.menable_check_screen_share;
            if (r27 == null) goto L77;
            ProtoAdapter.BOOL.encodeWithTag(r5, 30, r27);
        L77:
            Boolean r28 = r6.mrecord_auto_start;
            if (r28 == null) goto L80;
            ProtoAdapter.BOOL.encodeWithTag(r5, 31, r28);
        L80:
            Boolean r29 = r6.mrecord_auto_apply_start;
            if (r29 == null) goto L83;
            ProtoAdapter.BOOL.encodeWithTag(r5, 32, r29);
        L83:
            Integer r30 = r6.mjoin_group_meeting_privilege_type;
            if (r30 == null) goto L86;
            ProtoAdapter.INT32.encodeWithTag(r5, 33, r30);
        L86:
            Integer r31 = r6.mjoin_user_instant_meeting_privilege_type;
            if (r31 == null) goto L89;
            ProtoAdapter.INT32.encodeWithTag(r5, 34, r31);
        L89:
            Integer r32 = r6.mjoin_user_reserved_meeting_privilege_type;
            if (r32 == null) goto L92;
            ProtoAdapter.INT32.encodeWithTag(r5, 35, r32);
        L92:
            Boolean r33 = r6.menable_pstn_callout_scope_any;
            if (r33 == null) goto L95;
            ProtoAdapter.BOOL.encodeWithTag(r5, 36, r33);
        L95:
            Boolean r34 = r6.menable_voiceprint;
            if (r34 == null) goto L98;
            ProtoAdapter.BOOL.encodeWithTag(r5, 37, r34);
        L98:
            Boolean r35 = r6.mallow_user_change_pstn_audio_type;
            if (r35 == null) goto L101;
            ProtoAdapter.BOOL.encodeWithTag(r5, 38, r35);
        L101:
            Boolean r36 = r6.menable_live;
            if (r36 == null) goto L104;
            ProtoAdapter.BOOL.encodeWithTag(r5, 39, r36);
        L104:
            r8.asRepeated().encodeWithTag(r5, 40, r6.mspeed_up_nodes);
            Boolean r37 = r6.mauto_share_screen_ccm_permission;
            if (r37 == null) goto L107;
            ProtoAdapter.BOOL.encodeWithTag(r5, 41, r37);
        L107:
            RTCProxy.ADAPTER.asRepeated().encodeWithTag(r5, 42, r6.mrtc_proxy_list);
            ShareScreenConfirm r38 = r6.mshare_screen_confirm;
            if (r38 == null) goto L110;
            ShareScreenConfirm.ADAPTER.encodeWithTag(r5, 43, r38);
        L110:
            Bandwidth r39 = r6.mbandwidth;
            if (r39 == null) goto L113;
            Bandwidth.ADAPTER.encodeWithTag(r5, 44, r39);
        L113:
            Boolean r40 = r6.menable_local_record;
            if (r40 == null) goto L116;
            ProtoAdapter.BOOL.encodeWithTag(r5, 45, r40);
        L116:
            Boolean r41 = r6.menable_record_ai_summary;
            if (r41 == null) goto L119;
            ProtoAdapter.BOOL.encodeWithTag(r5, 46, r41);
        L119:
            Boolean r42 = r6.menable_meeting_password;
            if (r42 == null) goto L122;
            ProtoAdapter.BOOL.encodeWithTag(r5, 47, r42);
        L122:
            Boolean r43 = r6.mmeeting_force_record;
            if (r43 == null) goto L125;
            ProtoAdapter.BOOL.encodeWithTag(r5, 48, r43);
        L125:
            Boolean r44 = r6.mvoice_force_record;
            if (r44 == null) goto L128;
            ProtoAdapter.BOOL.encodeWithTag(r5, 49, r44);
        L128:
            Boolean r45 = r6.menable_4k_share;
            if (r45 == null) goto L131;
            ProtoAdapter.BOOL.encodeWithTag(r5, 50, r45);
        L131:
            Boolean r46 = r6.menable_1080p_video;
            if (r46 == null) goto L134;
            ProtoAdapter.BOOL.encodeWithTag(r5, 51, r46);
        L134:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetAdminSettingsResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetAdminSettingsResponse();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_ENABLE_RECORD = r0;
        DEFAULT_ENABLE_SUBTITLE = r0;
        DEFAULT_RECORD_NEED_APPROVE = r0;
        DEFAULT_PSTN_ENABLE_OUTGOING_CALL = r0;
        DEFAULT_PSTN_HIDE_PHONE_NUMBER = r0;
        DEFAULT_PSTN_ENABLE_INCOMING_CALL = r0;
        DEFAULT_PSTN_JOIN_MEETING_PROMPT = r0;
        DEFAULT_SIP_NEED_ENCRYPT = r0;
        DEFAULT_SIP_RECORD_NEED_APPROVE = r0;
        DEFAULT_SIP_LIVE_NEED_APPROVE = r0;
        DEFAULT_SIP_ENABLE_DUAL_STREAM = r0;
        DEFAULT_SIP_ENABLE_IM = r0;
        DEFAULT_SIP_ENABLE_ENTER_LEAVE_PROMPT = r0;
        DEFAULT_SIP_ENABLE_SHOW_NAME = r0;
        DEFAULT_SIP_DEFAULT_LAYOUT = 0;
        DEFAULT_SIP_VIDEO_LOOP_INTERVAL = 0;
        DEFAULT_SIP_ENABLE_FECC = r0;
        DEFAULT_ENABLE_MEETING_BACKGROUND = r0;
        DEFAULT_ENABLE_CUSTOM_MEETING_BACKGROUND = r0;
        DEFAULT_ENABLE_VIRTUAL_AVATAR = r0;
        DEFAULT_ENABLE_SIP = r0;
        DEFAULT_CAN_PERSONAL_INSTALL = r0;
        DEFAULT_ENABLE_CHECK_SCREEN_SHARE = r0;
        DEFAULT_RECORD_AUTO_START = r0;
        DEFAULT_RECORD_AUTO_APPLY_START = r0;
        DEFAULT_JOIN_GROUP_MEETING_PRIVILEGE_TYPE = 0;
        DEFAULT_JOIN_USER_INSTANT_MEETING_PRIVILEGE_TYPE = 0;
        DEFAULT_JOIN_USER_RESERVED_MEETING_PRIVILEGE_TYPE = 0;
        DEFAULT_ENABLE_PSTN_CALLOUT_SCOPE_ANY = r0;
        DEFAULT_ENABLE_VOICEPRINT = r0;
        DEFAULT_ALLOW_USER_CHANGE_PSTN_AUDIO_TYPE = r0;
        DEFAULT_ENABLE_LIVE = r0;
        DEFAULT_AUTO_SHARE_SCREEN_CCM_PERMISSION = r0;
        DEFAULT_ENABLE_LOCAL_RECORD = r0;
        DEFAULT_ENABLE_RECORD_AI_SUMMARY = r0;
        DEFAULT_ENABLE_MEETING_PASSWORD = r0;
        DEFAULT_MEETING_FORCE_RECORD = r0;
        DEFAULT_VOICE_FORCE_RECORD = r0;
        DEFAULT_ENABLE_4K_SHARE = r0;
        DEFAULT_ENABLE_1080P_VIDEO = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3112newBuilder() {
        Builder r0 = new Builder();
        r0.menable_record = this.menable_record;
        r0.menable_subtitle = this.menable_subtitle;
        r0.mrecord_need_approve = this.mrecord_need_approve;
        r0.mpstn_enable_outgoing_call = this.mpstn_enable_outgoing_call;
        r0.mpstn_hide_phone_number = this.mpstn_hide_phone_number;
        r0.mpstn_enable_incoming_call = this.mpstn_enable_incoming_call;
        r0.mpstn_incoming_call_country_default = Internal.copyOf("mpstn_incoming_call_country_default", this.mpstn_incoming_call_country_default);
        r0.mpstn_incoming_call_phone_list = Internal.copyOf("mpstn_incoming_call_phone_list", this.mpstn_incoming_call_phone_list);
        r0.mpstn_outgoing_call_country_default = Internal.copyOf("mpstn_outgoing_call_country_default", this.mpstn_outgoing_call_country_default);
        r0.mpstn_outgoing_call_country_list = Internal.copyOf("mpstn_outgoing_call_country_list", this.mpstn_outgoing_call_country_list);
        r0.mpstn_join_meeting_prompt = this.mpstn_join_meeting_prompt;
        r0.msip_need_encrypt = this.msip_need_encrypt;
        r0.msip_prompt_language = this.msip_prompt_language;
        r0.msip_record_need_approve = this.msip_record_need_approve;
        r0.msip_live_need_approve = this.msip_live_need_approve;
        r0.msip_enable_dual_stream = this.msip_enable_dual_stream;
        r0.msip_enable_im = this.msip_enable_im;
        r0.msip_enable_enter_leave_prompt = this.msip_enable_enter_leave_prompt;
        r0.msip_enable_show_name = this.msip_enable_show_name;
        r0.msip_default_layout = this.msip_default_layout;
        r0.msip_video_loop_interval = this.msip_video_loop_interval;
        r0.msip_enable_fecc = this.msip_enable_fecc;
        r0.menable_meeting_background = this.menable_meeting_background;
        r0.menable_custom_meeting_background = this.menable_custom_meeting_background;
        r0.mmeeting_background_list = Internal.copyOf("mmeeting_background_list", this.mmeeting_background_list);
        r0.menable_virtual_avatar = this.menable_virtual_avatar;
        r0.mrtc_proxy = this.mrtc_proxy;
        r0.menable_sip = this.menable_sip;
        r0.mcan_personal_install = this.mcan_personal_install;
        r0.menable_check_screen_share = this.menable_check_screen_share;
        r0.mrecord_auto_start = this.mrecord_auto_start;
        r0.mrecord_auto_apply_start = this.mrecord_auto_apply_start;
        r0.mjoin_group_meeting_privilege_type = this.mjoin_group_meeting_privilege_type;
        r0.mjoin_user_instant_meeting_privilege_type = this.mjoin_user_instant_meeting_privilege_type;
        r0.mjoin_user_reserved_meeting_privilege_type = this.mjoin_user_reserved_meeting_privilege_type;
        r0.menable_pstn_callout_scope_any = this.menable_pstn_callout_scope_any;
        r0.menable_voiceprint = this.menable_voiceprint;
        r0.mallow_user_change_pstn_audio_type = this.mallow_user_change_pstn_audio_type;
        r0.menable_live = this.menable_live;
        r0.mspeed_up_nodes = Internal.copyOf("mspeed_up_nodes", this.mspeed_up_nodes);
        r0.mauto_share_screen_ccm_permission = this.mauto_share_screen_ccm_permission;
        r0.mrtc_proxy_list = Internal.copyOf("mrtc_proxy_list", this.mrtc_proxy_list);
        r0.mshare_screen_confirm = this.mshare_screen_confirm;
        r0.mbandwidth = this.mbandwidth;
        r0.menable_local_record = this.menable_local_record;
        r0.menable_record_ai_summary = this.menable_record_ai_summary;
        r0.menable_meeting_password = this.menable_meeting_password;
        r0.mmeeting_force_record = this.mmeeting_force_record;
        r0.mvoice_force_record = this.mvoice_force_record;
        r0.menable_4k_share = this.menable_4k_share;
        r0.menable_1080p_video = this.menable_1080p_video;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetAdminSettingsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3112newBuilder();
    }

    public GetAdminSettingsResponse(Boolean r54, Boolean r55, Boolean r56, Boolean r57, Boolean r58, Boolean r59, List<String> r60, List<PSTNPhone> r61, List<String> r62, List<String> r63, Boolean r64, Boolean r65, String r66, Boolean r67, Boolean r68, Boolean r69, Boolean r70, Boolean r71, Boolean r72, Integer r73, Integer r74, Boolean r75, Boolean r76, Boolean r77, List<MeetingBackground> r78, Boolean r79, RTCProxy r80, Boolean r81, Boolean r82, Boolean r83, Boolean r84, Boolean r85, Integer r86, Integer r87, Integer r88, Boolean r89, Boolean r90, Boolean r91, Boolean r92, List<String> r93, Boolean r94, List<RTCProxy> r95, ShareScreenConfirm r96, Bandwidth r97, Boolean r98, Boolean r99, Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104) {
        this(r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, ByteString.EMPTY);
    }

    public GetAdminSettingsResponse(Boolean r4, Boolean r5, Boolean r6, Boolean r7, Boolean r8, Boolean r9, List<String> r10, List<PSTNPhone> r11, List<String> r12, List<String> r13, Boolean r14, Boolean r15, String r16, Boolean r17, Boolean r18, Boolean r19, Boolean r20, Boolean r21, Boolean r22, Integer r23, Integer r24, Boolean r25, Boolean r26, Boolean r27, List<MeetingBackground> r28, Boolean r29, RTCProxy r30, Boolean r31, Boolean r32, Boolean r33, Boolean r34, Boolean r35, Integer r36, Integer r37, Integer r38, Boolean r39, Boolean r40, Boolean r41, Boolean r42, List<String> r43, Boolean r44, List<RTCProxy> r45, ShareScreenConfirm r46, Bandwidth r47, Boolean r48, Boolean r49, Boolean r50, Boolean r51, Boolean r52, Boolean r53, Boolean r54, ByteString r55) {
        super(ADAPTER, r55);
        this.menable_record = r4;
        this.menable_subtitle = r5;
        this.mrecord_need_approve = r6;
        this.mpstn_enable_outgoing_call = r7;
        this.mpstn_hide_phone_number = r8;
        this.mpstn_enable_incoming_call = r9;
        this.mpstn_incoming_call_country_default = Internal.immutableCopyOf("mpstn_incoming_call_country_default", r10);
        this.mpstn_incoming_call_phone_list = Internal.immutableCopyOf("mpstn_incoming_call_phone_list", r11);
        this.mpstn_outgoing_call_country_default = Internal.immutableCopyOf("mpstn_outgoing_call_country_default", r12);
        this.mpstn_outgoing_call_country_list = Internal.immutableCopyOf("mpstn_outgoing_call_country_list", r13);
        this.mpstn_join_meeting_prompt = r14;
        this.msip_need_encrypt = r15;
        this.msip_prompt_language = r16;
        this.msip_record_need_approve = r17;
        this.msip_live_need_approve = r18;
        this.msip_enable_dual_stream = r19;
        this.msip_enable_im = r20;
        this.msip_enable_enter_leave_prompt = r21;
        this.msip_enable_show_name = r22;
        this.msip_default_layout = r23;
        this.msip_video_loop_interval = r24;
        this.msip_enable_fecc = r25;
        this.menable_meeting_background = r26;
        this.menable_custom_meeting_background = r27;
        this.mmeeting_background_list = Internal.immutableCopyOf("mmeeting_background_list", r28);
        this.menable_virtual_avatar = r29;
        this.mrtc_proxy = r30;
        this.menable_sip = r31;
        this.mcan_personal_install = r32;
        this.menable_check_screen_share = r33;
        this.mrecord_auto_start = r34;
        this.mrecord_auto_apply_start = r35;
        this.mjoin_group_meeting_privilege_type = r36;
        this.mjoin_user_instant_meeting_privilege_type = r37;
        this.mjoin_user_reserved_meeting_privilege_type = r38;
        this.menable_pstn_callout_scope_any = r39;
        this.menable_voiceprint = r40;
        this.mallow_user_change_pstn_audio_type = r41;
        this.menable_live = r42;
        this.mspeed_up_nodes = Internal.immutableCopyOf("mspeed_up_nodes", r43);
        this.mauto_share_screen_ccm_permission = r44;
        this.mrtc_proxy_list = Internal.immutableCopyOf("mrtc_proxy_list", r45);
        this.mshare_screen_confirm = r46;
        this.mbandwidth = r47;
        this.menable_local_record = r48;
        this.menable_record_ai_summary = r49;
        this.menable_meeting_password = r50;
        this.mmeeting_force_record = r51;
        this.mvoice_force_record = r52;
        this.menable_4k_share = r53;
        this.menable_1080p_video = r54;
    }
}
