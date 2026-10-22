package com.ss.android.lark.pb.usearch;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ResultMeta extends Message<ResultMeta, Builder> {
    public static final ProtoAdapter<ResultMeta> ADAPTER = null;
    public static final FieldOptions FIELD_OPTIONS_MSECTION_META = null;
    public static final FieldOptions FIELD_OPTIONS_MSLASH_COMMAND_META = null;
    private static final long serialVersionUID = 0;
    public final AggregatedMessageMeta maggre_message_meta;
    public final AppMeta mapp_meta;
    public final BannerMeta mbanner_meta;
    public final BotMeta mbot_meta;
    public final CalendarMeta mcalendar_meta;
    public final CryptoP2PChatMeta mcrypto_p2p_chat_meta;
    public final CustomizationMeta mcustomization_meta;
    public final DepartmentMeta mdepartment_meta;
    public final DocMeta mdoc_meta;
    public final FacilityMeta mfacility_meta;
    public final GroupChatMeta mgroup_chat_meta;
    public final LarkMinutesMeta mlark_minutes_meta;
    public final MailContactMeta mmail_contact_meta;
    public final MessageFileMeta mmessage_file_meta;
    public final MessageMeta mmessage_meta;
    public final MyAIMeta mmy_ai_meta;
    public final OncallMeta moncall_meta;
    public final PassageMeta mpassage_meta;
    public final PhoenixMeta mphoenix_meta;
    public final QACardMeta mqa_meta;
    public final ResourceMeta mresource_meta;
    public final SectionMeta msection_meta;
    public final ShieldP2PChatMeta mshield_p2p_chat_meta;
    public final SlashCommandMeta mslash_command_meta;
    public final ThreadMeta mthread_meta;
    public final URLMeta murl_meta;
    public final UserGroupMeta muser_group_meta;
    public final UserMeta muser_meta;
    public final WikiMeta mwiki_meta;
    public final WikiSpaceMeta mwiki_space_meta;

    public static final class Builder extends Message.Builder<ResultMeta, Builder> {
        public AggregatedMessageMeta maggre_message_meta;
        public AppMeta mapp_meta;
        public BannerMeta mbanner_meta;
        public BotMeta mbot_meta;
        public CalendarMeta mcalendar_meta;
        public CryptoP2PChatMeta mcrypto_p2p_chat_meta;
        public CustomizationMeta mcustomization_meta;
        public DepartmentMeta mdepartment_meta;
        public DocMeta mdoc_meta;
        public FacilityMeta mfacility_meta;
        public GroupChatMeta mgroup_chat_meta;
        public LarkMinutesMeta mlark_minutes_meta;
        public MailContactMeta mmail_contact_meta;
        public MessageFileMeta mmessage_file_meta;
        public MessageMeta mmessage_meta;
        public MyAIMeta mmy_ai_meta;
        public OncallMeta moncall_meta;
        public PassageMeta mpassage_meta;
        public PhoenixMeta mphoenix_meta;
        public QACardMeta mqa_meta;
        public ResourceMeta mresource_meta;
        public SectionMeta msection_meta;
        public ShieldP2PChatMeta mshield_p2p_chat_meta;
        public SlashCommandMeta mslash_command_meta;
        public ThreadMeta mthread_meta;
        public URLMeta murl_meta;
        public UserGroupMeta muser_group_meta;
        public UserMeta muser_meta;
        public WikiMeta mwiki_meta;
        public WikiSpaceMeta mwiki_space_meta;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ResultMeta m2801build() {
            return new ResultMeta(this.muser_meta, this.mbot_meta, this.mgroup_chat_meta, this.mcrypto_p2p_chat_meta, this.mmessage_meta, this.moncall_meta, this.mthread_meta, this.murl_meta, this.mqa_meta, this.mdepartment_meta, this.mdoc_meta, this.mapp_meta, this.mslash_command_meta, this.mwiki_meta, this.msection_meta, this.mresource_meta, this.mcustomization_meta, this.mfacility_meta, this.mmail_contact_meta, this.mcalendar_meta, this.mlark_minutes_meta, this.mbanner_meta, this.mwiki_space_meta, this.mphoenix_meta, this.mshield_p2p_chat_meta, this.muser_group_meta, this.mmessage_file_meta, this.mmy_ai_meta, this.mpassage_meta, this.maggre_message_meta, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2801build();
        }

        public Builder aggre_message_meta(AggregatedMessageMeta r1) {
            this.maggre_message_meta = r1;
            return this;
        }

        public Builder app_meta(AppMeta r1) {
            this.mapp_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder banner_meta(BannerMeta r1) {
            this.mbanner_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder bot_meta(BotMeta r1) {
            this.mbot_meta = r1;
            this.muser_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder calendar_meta(CalendarMeta r1) {
            this.mcalendar_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder crypto_p2p_chat_meta(CryptoP2PChatMeta r1) {
            this.mcrypto_p2p_chat_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder customization_meta(CustomizationMeta r1) {
            this.mcustomization_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder department_meta(DepartmentMeta r1) {
            this.mdepartment_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder doc_meta(DocMeta r1) {
            this.mdoc_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder facility_meta(FacilityMeta r1) {
            this.mfacility_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder group_chat_meta(GroupChatMeta r1) {
            this.mgroup_chat_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder lark_minutes_meta(LarkMinutesMeta r1) {
            this.mlark_minutes_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder mail_contact_meta(MailContactMeta r1) {
            this.mmail_contact_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder message_file_meta(MessageFileMeta r1) {
            this.mmessage_file_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder message_meta(MessageMeta r1) {
            this.mmessage_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder my_ai_meta(MyAIMeta r1) {
            this.mmy_ai_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder oncall_meta(OncallMeta r1) {
            this.moncall_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder passage_meta(PassageMeta r1) {
            this.mpassage_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            return this;
        }

        public Builder phoenix_meta(PhoenixMeta r1) {
            this.mphoenix_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder qa_meta(QACardMeta r1) {
            this.mqa_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder resource_meta(ResourceMeta r1) {
            this.mresource_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder section_meta(SectionMeta r1) {
            this.msection_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder shield_p2p_chat_meta(ShieldP2PChatMeta r1) {
            this.mshield_p2p_chat_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder slash_command_meta(SlashCommandMeta r1) {
            this.mslash_command_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder thread_meta(ThreadMeta r1) {
            this.mthread_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder url_meta(URLMeta r1) {
            this.murl_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder user_group_meta(UserGroupMeta r1) {
            this.muser_group_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder user_meta(UserMeta r1) {
            this.muser_meta = r1;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder wiki_meta(WikiMeta r1) {
            this.mwiki_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mwiki_space_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }

        public Builder wiki_space_meta(WikiSpaceMeta r1) {
            this.mwiki_space_meta = r1;
            this.muser_meta = null;
            this.mbot_meta = null;
            this.mgroup_chat_meta = null;
            this.mcrypto_p2p_chat_meta = null;
            this.mmessage_meta = null;
            this.moncall_meta = null;
            this.mthread_meta = null;
            this.murl_meta = null;
            this.mqa_meta = null;
            this.mdepartment_meta = null;
            this.mdoc_meta = null;
            this.mapp_meta = null;
            this.mslash_command_meta = null;
            this.mwiki_meta = null;
            this.msection_meta = null;
            this.mresource_meta = null;
            this.mcustomization_meta = null;
            this.mfacility_meta = null;
            this.mmail_contact_meta = null;
            this.mcalendar_meta = null;
            this.mlark_minutes_meta = null;
            this.mbanner_meta = null;
            this.mphoenix_meta = null;
            this.mshield_p2p_chat_meta = null;
            this.muser_group_meta = null;
            this.mmessage_file_meta = null;
            this.mmy_ai_meta = null;
            this.mpassage_meta = null;
            return this;
        }
    }

    public static final class ProtoAdapter_ResultMeta extends ProtoAdapter<ResultMeta> {
        public ProtoAdapter_ResultMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, ResultMeta.class);
        }

        public ResultMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L37;
            switch(r3) {
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
                case 18: goto L19;
                case 19: goto L18;
                case 20: goto L17;
                case 21: goto L16;
                case 22: goto L15;
                case 23: goto L14;
                case 24: goto L13;
                case 25: goto L12;
                case 26: goto L11;
                case 27: goto L10;
                case 28: goto L9;
                case 29: goto L8;
                case 30: goto L7;
                default: goto L6;
            };
        L7:
            r0.passage_meta((PassageMeta) PassageMeta.ADAPTER.decode(r7));
            goto L3
        L8:
            r0.my_ai_meta((MyAIMeta) MyAIMeta.ADAPTER.decode(r7));
            goto L3
        L9:
            r0.message_file_meta((MessageFileMeta) MessageFileMeta.ADAPTER.decode(r7));
            goto L3
        L10:
            r0.user_group_meta((UserGroupMeta) UserGroupMeta.ADAPTER.decode(r7));
            goto L3
        L11:
            r0.shield_p2p_chat_meta((ShieldP2PChatMeta) ShieldP2PChatMeta.ADAPTER.decode(r7));
            goto L3
        L12:
            r0.phoenix_meta((PhoenixMeta) PhoenixMeta.ADAPTER.decode(r7));
            goto L3
        L13:
            r0.wiki_space_meta((WikiSpaceMeta) WikiSpaceMeta.ADAPTER.decode(r7));
            goto L3
        L14:
            r0.banner_meta((BannerMeta) BannerMeta.ADAPTER.decode(r7));
            goto L3
        L15:
            r0.lark_minutes_meta((LarkMinutesMeta) LarkMinutesMeta.ADAPTER.decode(r7));
            goto L3
        L16:
            r0.calendar_meta((CalendarMeta) CalendarMeta.ADAPTER.decode(r7));
            goto L3
        L17:
            r0.mail_contact_meta((MailContactMeta) MailContactMeta.ADAPTER.decode(r7));
            goto L3
        L18:
            r0.aggre_message_meta((AggregatedMessageMeta) AggregatedMessageMeta.ADAPTER.decode(r7));
            goto L3
        L19:
            r0.facility_meta((FacilityMeta) FacilityMeta.ADAPTER.decode(r7));
            goto L3
        L20:
            r0.customization_meta((CustomizationMeta) CustomizationMeta.ADAPTER.decode(r7));
            goto L3
        L21:
            r0.resource_meta((ResourceMeta) ResourceMeta.ADAPTER.decode(r7));
            goto L3
        L22:
            r0.section_meta((SectionMeta) SectionMeta.ADAPTER.decode(r7));
            goto L3
        L23:
            r0.wiki_meta((WikiMeta) WikiMeta.ADAPTER.decode(r7));
            goto L3
        L24:
            r0.slash_command_meta((SlashCommandMeta) SlashCommandMeta.ADAPTER.decode(r7));
            goto L3
        L25:
            r0.app_meta((AppMeta) AppMeta.ADAPTER.decode(r7));
            goto L3
        L26:
            r0.doc_meta((DocMeta) DocMeta.ADAPTER.decode(r7));
            goto L3
        L27:
            r0.department_meta((DepartmentMeta) DepartmentMeta.ADAPTER.decode(r7));
            goto L3
        L28:
            r0.qa_meta((QACardMeta) QACardMeta.ADAPTER.decode(r7));
            goto L3
        L29:
            r0.url_meta((URLMeta) URLMeta.ADAPTER.decode(r7));
            goto L3
        L30:
            r0.thread_meta((ThreadMeta) ThreadMeta.ADAPTER.decode(r7));
            goto L3
        L31:
            r0.oncall_meta((OncallMeta) OncallMeta.ADAPTER.decode(r7));
            goto L3
        L32:
            r0.message_meta((MessageMeta) MessageMeta.ADAPTER.decode(r7));
            goto L3
        L33:
            r0.crypto_p2p_chat_meta((CryptoP2PChatMeta) CryptoP2PChatMeta.ADAPTER.decode(r7));
            goto L3
        L34:
            r0.group_chat_meta((GroupChatMeta) GroupChatMeta.ADAPTER.decode(r7));
            goto L3
        L35:
            r0.bot_meta((BotMeta) BotMeta.ADAPTER.decode(r7));
            goto L3
        L36:
            r0.user_meta((UserMeta) UserMeta.ADAPTER.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L37:
            r7.endMessage(r1);
            return r0.m2801build();
        }

        public int encodedSize(ResultMeta r6) {
            UserMeta r0 = r6.muser_meta;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = UserMeta.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            BotMeta r3 = r6.mbot_meta;
            if (r3 == null) goto L9;
            int r4 = BotMeta.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            GroupChatMeta r7 = r6.mgroup_chat_meta;
            if (r7 == null) goto L13;
            int r8 = GroupChatMeta.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            CryptoP2PChatMeta r10 = r6.mcrypto_p2p_chat_meta;
            if (r10 == null) goto L17;
            int r11 = CryptoP2PChatMeta.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            MessageMeta r13 = r6.mmessage_meta;
            if (r13 == null) goto L21;
            int r14 = MessageMeta.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            OncallMeta r16 = r6.moncall_meta;
            if (r16 == null) goto L25;
            int r17 = OncallMeta.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            ThreadMeta r19 = r6.mthread_meta;
            if (r19 == null) goto L29;
            int r20 = ThreadMeta.ADAPTER.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            URLMeta r22 = r6.murl_meta;
            if (r22 == null) goto L33;
            int r23 = URLMeta.ADAPTER.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            QACardMeta r25 = r6.mqa_meta;
            if (r25 == null) goto L37;
            int r26 = QACardMeta.ADAPTER.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            DepartmentMeta r28 = r6.mdepartment_meta;
            if (r28 == null) goto L41;
            int r29 = DepartmentMeta.ADAPTER.encodedSizeWithTag(10, r28);
        L42:
            int r30 = r27 + r29;
            DocMeta r31 = r6.mdoc_meta;
            if (r31 == null) goto L45;
            int r32 = DocMeta.ADAPTER.encodedSizeWithTag(11, r31);
        L46:
            int r33 = r30 + r32;
            AppMeta r34 = r6.mapp_meta;
            if (r34 == null) goto L49;
            int r35 = AppMeta.ADAPTER.encodedSizeWithTag(12, r34);
        L50:
            int r36 = r33 + r35;
            SlashCommandMeta r37 = r6.mslash_command_meta;
            if (r37 == null) goto L53;
            int r38 = SlashCommandMeta.ADAPTER.encodedSizeWithTag(13, r37);
        L54:
            int r39 = r36 + r38;
            WikiMeta r40 = r6.mwiki_meta;
            if (r40 == null) goto L57;
            int r41 = WikiMeta.ADAPTER.encodedSizeWithTag(14, r40);
        L58:
            int r42 = r39 + r41;
            SectionMeta r43 = r6.msection_meta;
            if (r43 == null) goto L61;
            int r44 = SectionMeta.ADAPTER.encodedSizeWithTag(15, r43);
        L62:
            int r45 = r42 + r44;
            ResourceMeta r46 = r6.mresource_meta;
            if (r46 == null) goto L65;
            int r47 = ResourceMeta.ADAPTER.encodedSizeWithTag(16, r46);
        L66:
            int r48 = r45 + r47;
            CustomizationMeta r49 = r6.mcustomization_meta;
            if (r49 == null) goto L69;
            int r50 = CustomizationMeta.ADAPTER.encodedSizeWithTag(17, r49);
        L70:
            int r51 = r48 + r50;
            FacilityMeta r52 = r6.mfacility_meta;
            if (r52 == null) goto L73;
            int r53 = FacilityMeta.ADAPTER.encodedSizeWithTag(18, r52);
        L74:
            int r54 = r51 + r53;
            MailContactMeta r55 = r6.mmail_contact_meta;
            if (r55 == null) goto L77;
            int r56 = MailContactMeta.ADAPTER.encodedSizeWithTag(20, r55);
        L78:
            int r57 = r54 + r56;
            CalendarMeta r58 = r6.mcalendar_meta;
            if (r58 == null) goto L81;
            int r59 = CalendarMeta.ADAPTER.encodedSizeWithTag(21, r58);
        L82:
            int r60 = r57 + r59;
            LarkMinutesMeta r61 = r6.mlark_minutes_meta;
            if (r61 == null) goto L85;
            int r62 = LarkMinutesMeta.ADAPTER.encodedSizeWithTag(22, r61);
        L86:
            int r63 = r60 + r62;
            BannerMeta r64 = r6.mbanner_meta;
            if (r64 == null) goto L89;
            int r65 = BannerMeta.ADAPTER.encodedSizeWithTag(23, r64);
        L90:
            int r66 = r63 + r65;
            WikiSpaceMeta r67 = r6.mwiki_space_meta;
            if (r67 == null) goto L93;
            int r68 = WikiSpaceMeta.ADAPTER.encodedSizeWithTag(24, r67);
        L94:
            int r69 = r66 + r68;
            PhoenixMeta r70 = r6.mphoenix_meta;
            if (r70 == null) goto L97;
            int r71 = PhoenixMeta.ADAPTER.encodedSizeWithTag(25, r70);
        L98:
            int r72 = r69 + r71;
            ShieldP2PChatMeta r73 = r6.mshield_p2p_chat_meta;
            if (r73 == null) goto L101;
            int r74 = ShieldP2PChatMeta.ADAPTER.encodedSizeWithTag(26, r73);
        L102:
            int r75 = r72 + r74;
            UserGroupMeta r76 = r6.muser_group_meta;
            if (r76 == null) goto L105;
            int r77 = UserGroupMeta.ADAPTER.encodedSizeWithTag(27, r76);
        L106:
            int r78 = r75 + r77;
            MessageFileMeta r79 = r6.mmessage_file_meta;
            if (r79 == null) goto L109;
            int r80 = MessageFileMeta.ADAPTER.encodedSizeWithTag(28, r79);
        L110:
            int r81 = r78 + r80;
            MyAIMeta r82 = r6.mmy_ai_meta;
            if (r82 == null) goto L113;
            int r83 = MyAIMeta.ADAPTER.encodedSizeWithTag(29, r82);
        L114:
            int r84 = r81 + r83;
            PassageMeta r85 = r6.mpassage_meta;
            if (r85 == null) goto L117;
            int r86 = PassageMeta.ADAPTER.encodedSizeWithTag(30, r85);
        L118:
            int r87 = r84 + r86;
            AggregatedMessageMeta r88 = r6.maggre_message_meta;
            if (r88 == null) goto L122;
            r1 = AggregatedMessageMeta.ADAPTER.encodedSizeWithTag(19, r88);
        L122:
            return (r87 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2802decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ResultMeta) r1);
        }

        public void encode(ProtoWriter r4, ResultMeta r5) throws IOException {
            UserMeta r0 = r5.muser_meta;
            if (r0 == null) goto L5;
            UserMeta.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            BotMeta r1 = r5.mbot_meta;
            if (r1 == null) goto L8;
            BotMeta.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            GroupChatMeta r2 = r5.mgroup_chat_meta;
            if (r2 == null) goto L11;
            GroupChatMeta.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            CryptoP2PChatMeta r3 = r5.mcrypto_p2p_chat_meta;
            if (r3 == null) goto L14;
            CryptoP2PChatMeta.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            MessageMeta r6 = r5.mmessage_meta;
            if (r6 == null) goto L17;
            MessageMeta.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            OncallMeta r7 = r5.moncall_meta;
            if (r7 == null) goto L20;
            OncallMeta.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            ThreadMeta r8 = r5.mthread_meta;
            if (r8 == null) goto L23;
            ThreadMeta.ADAPTER.encodeWithTag(r4, 7, r8);
        L23:
            URLMeta r9 = r5.murl_meta;
            if (r9 == null) goto L26;
            URLMeta.ADAPTER.encodeWithTag(r4, 8, r9);
        L26:
            QACardMeta r10 = r5.mqa_meta;
            if (r10 == null) goto L29;
            QACardMeta.ADAPTER.encodeWithTag(r4, 9, r10);
        L29:
            DepartmentMeta r11 = r5.mdepartment_meta;
            if (r11 == null) goto L32;
            DepartmentMeta.ADAPTER.encodeWithTag(r4, 10, r11);
        L32:
            DocMeta r12 = r5.mdoc_meta;
            if (r12 == null) goto L35;
            DocMeta.ADAPTER.encodeWithTag(r4, 11, r12);
        L35:
            AppMeta r13 = r5.mapp_meta;
            if (r13 == null) goto L38;
            AppMeta.ADAPTER.encodeWithTag(r4, 12, r13);
        L38:
            SlashCommandMeta r14 = r5.mslash_command_meta;
            if (r14 == null) goto L41;
            SlashCommandMeta.ADAPTER.encodeWithTag(r4, 13, r14);
        L41:
            WikiMeta r15 = r5.mwiki_meta;
            if (r15 == null) goto L44;
            WikiMeta.ADAPTER.encodeWithTag(r4, 14, r15);
        L44:
            SectionMeta r16 = r5.msection_meta;
            if (r16 == null) goto L47;
            SectionMeta.ADAPTER.encodeWithTag(r4, 15, r16);
        L47:
            ResourceMeta r17 = r5.mresource_meta;
            if (r17 == null) goto L50;
            ResourceMeta.ADAPTER.encodeWithTag(r4, 16, r17);
        L50:
            CustomizationMeta r18 = r5.mcustomization_meta;
            if (r18 == null) goto L53;
            CustomizationMeta.ADAPTER.encodeWithTag(r4, 17, r18);
        L53:
            FacilityMeta r19 = r5.mfacility_meta;
            if (r19 == null) goto L56;
            FacilityMeta.ADAPTER.encodeWithTag(r4, 18, r19);
        L56:
            MailContactMeta r20 = r5.mmail_contact_meta;
            if (r20 == null) goto L59;
            MailContactMeta.ADAPTER.encodeWithTag(r4, 20, r20);
        L59:
            CalendarMeta r21 = r5.mcalendar_meta;
            if (r21 == null) goto L62;
            CalendarMeta.ADAPTER.encodeWithTag(r4, 21, r21);
        L62:
            LarkMinutesMeta r22 = r5.mlark_minutes_meta;
            if (r22 == null) goto L65;
            LarkMinutesMeta.ADAPTER.encodeWithTag(r4, 22, r22);
        L65:
            BannerMeta r23 = r5.mbanner_meta;
            if (r23 == null) goto L68;
            BannerMeta.ADAPTER.encodeWithTag(r4, 23, r23);
        L68:
            WikiSpaceMeta r24 = r5.mwiki_space_meta;
            if (r24 == null) goto L71;
            WikiSpaceMeta.ADAPTER.encodeWithTag(r4, 24, r24);
        L71:
            PhoenixMeta r25 = r5.mphoenix_meta;
            if (r25 == null) goto L74;
            PhoenixMeta.ADAPTER.encodeWithTag(r4, 25, r25);
        L74:
            ShieldP2PChatMeta r26 = r5.mshield_p2p_chat_meta;
            if (r26 == null) goto L77;
            ShieldP2PChatMeta.ADAPTER.encodeWithTag(r4, 26, r26);
        L77:
            UserGroupMeta r27 = r5.muser_group_meta;
            if (r27 == null) goto L80;
            UserGroupMeta.ADAPTER.encodeWithTag(r4, 27, r27);
        L80:
            MessageFileMeta r28 = r5.mmessage_file_meta;
            if (r28 == null) goto L83;
            MessageFileMeta.ADAPTER.encodeWithTag(r4, 28, r28);
        L83:
            MyAIMeta r29 = r5.mmy_ai_meta;
            if (r29 == null) goto L86;
            MyAIMeta.ADAPTER.encodeWithTag(r4, 29, r29);
        L86:
            PassageMeta r30 = r5.mpassage_meta;
            if (r30 == null) goto L89;
            PassageMeta.ADAPTER.encodeWithTag(r4, 30, r30);
        L89:
            AggregatedMessageMeta r31 = r5.maggre_message_meta;
            if (r31 == null) goto L92;
            AggregatedMessageMeta.ADAPTER.encodeWithTag(r4, 19, r31);
        L92:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ResultMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ResultMeta();
        FieldOptions.Builder r0 = new FieldOptions.Builder();
        Boolean r1 = Boolean.TRUE;
        FIELD_OPTIONS_MSLASH_COMMAND_META = r0.security_field(r1).build();
        FIELD_OPTIONS_MSECTION_META = new FieldOptions.Builder().security_field(r1).build();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2800newBuilder() {
        Builder r0 = new Builder();
        r0.muser_meta = this.muser_meta;
        r0.mbot_meta = this.mbot_meta;
        r0.mgroup_chat_meta = this.mgroup_chat_meta;
        r0.mcrypto_p2p_chat_meta = this.mcrypto_p2p_chat_meta;
        r0.mmessage_meta = this.mmessage_meta;
        r0.moncall_meta = this.moncall_meta;
        r0.mthread_meta = this.mthread_meta;
        r0.murl_meta = this.murl_meta;
        r0.mqa_meta = this.mqa_meta;
        r0.mdepartment_meta = this.mdepartment_meta;
        r0.mdoc_meta = this.mdoc_meta;
        r0.mapp_meta = this.mapp_meta;
        r0.mslash_command_meta = this.mslash_command_meta;
        r0.mwiki_meta = this.mwiki_meta;
        r0.msection_meta = this.msection_meta;
        r0.mresource_meta = this.mresource_meta;
        r0.mcustomization_meta = this.mcustomization_meta;
        r0.mfacility_meta = this.mfacility_meta;
        r0.mmail_contact_meta = this.mmail_contact_meta;
        r0.mcalendar_meta = this.mcalendar_meta;
        r0.mlark_minutes_meta = this.mlark_minutes_meta;
        r0.mbanner_meta = this.mbanner_meta;
        r0.mwiki_space_meta = this.mwiki_space_meta;
        r0.mphoenix_meta = this.mphoenix_meta;
        r0.mshield_p2p_chat_meta = this.mshield_p2p_chat_meta;
        r0.muser_group_meta = this.muser_group_meta;
        r0.mmessage_file_meta = this.mmessage_file_meta;
        r0.mmy_ai_meta = this.mmy_ai_meta;
        r0.mpassage_meta = this.mpassage_meta;
        r0.maggre_message_meta = this.maggre_message_meta;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ResultMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2800newBuilder();
    }

    public ResultMeta(UserMeta r33, BotMeta r34, GroupChatMeta r35, CryptoP2PChatMeta r36, MessageMeta r37, OncallMeta r38, ThreadMeta r39, URLMeta r40, QACardMeta r41, DepartmentMeta r42, DocMeta r43, AppMeta r44, SlashCommandMeta r45, WikiMeta r46, SectionMeta r47, ResourceMeta r48, CustomizationMeta r49, FacilityMeta r50, MailContactMeta r51, CalendarMeta r52, LarkMinutesMeta r53, BannerMeta r54, WikiSpaceMeta r55, PhoenixMeta r56, ShieldP2PChatMeta r57, UserGroupMeta r58, MessageFileMeta r59, MyAIMeta r60, PassageMeta r61, AggregatedMessageMeta r62) {
        this(r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, ByteString.EMPTY);
    }

    public ResultMeta(UserMeta r18, BotMeta r19, GroupChatMeta r20, CryptoP2PChatMeta r21, MessageMeta r22, OncallMeta r23, ThreadMeta r24, URLMeta r25, QACardMeta r26, DepartmentMeta r27, DocMeta r28, AppMeta r29, SlashCommandMeta r30, WikiMeta r31, SectionMeta r32, ResourceMeta r33, CustomizationMeta r34, FacilityMeta r35, MailContactMeta r36, CalendarMeta r37, LarkMinutesMeta r38, BannerMeta r39, WikiSpaceMeta r40, PhoenixMeta r41, ShieldP2PChatMeta r42, UserGroupMeta r43, MessageFileMeta r44, MyAIMeta r45, PassageMeta r46, AggregatedMessageMeta r47, ByteString r48) {
        super(ADAPTER, r48);
        if (Internal.countNonNull(r18, r19, r20, r21, new Object[]{r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46}) > 1) goto L7;
        this.muser_meta = r18;
        this.mbot_meta = r19;
        this.mgroup_chat_meta = r20;
        this.mcrypto_p2p_chat_meta = r21;
        this.mmessage_meta = r22;
        this.moncall_meta = r23;
        this.mthread_meta = r24;
        this.murl_meta = r25;
        this.mqa_meta = r26;
        this.mdepartment_meta = r27;
        this.mdoc_meta = r28;
        this.mapp_meta = r29;
        this.mslash_command_meta = r30;
        this.mwiki_meta = r31;
        this.msection_meta = r32;
        this.mresource_meta = r33;
        this.mcustomization_meta = r34;
        this.mfacility_meta = r35;
        this.mmail_contact_meta = r36;
        this.mcalendar_meta = r37;
        this.mlark_minutes_meta = r38;
        this.mbanner_meta = r39;
        this.mwiki_space_meta = r40;
        this.mphoenix_meta = r41;
        this.mshield_p2p_chat_meta = r42;
        this.muser_group_meta = r43;
        this.mmessage_file_meta = r44;
        this.mmy_ai_meta = r45;
        this.mpassage_meta = r46;
        this.maggre_message_meta = r47;
        return;
    L7:
        throw new IllegalArgumentException("at most one of muser_meta, mbot_meta, mgroup_chat_meta, mcrypto_p2p_chat_meta, mmessage_meta, moncall_meta, mthread_meta, murl_meta, mqa_meta, mdepartment_meta, mdoc_meta, mapp_meta, mslash_command_meta, mwiki_meta, msection_meta, mresource_meta, mcustomization_meta, mfacility_meta, mmail_contact_meta, mcalendar_meta, mlark_minutes_meta, mbanner_meta, mwiki_space_meta, mphoenix_meta, mshield_p2p_chat_meta, muser_group_meta, mmessage_file_meta, mmy_ai_meta, mpassage_meta may be non-null");
    }
}
