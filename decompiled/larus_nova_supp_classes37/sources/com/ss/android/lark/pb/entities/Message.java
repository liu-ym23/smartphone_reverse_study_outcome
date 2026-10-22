package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Message extends com.squareup.wire.Message<Message, Builder> {
    public static final ProtoAdapter<Message> ADAPTER = null;
    public static final Integer DEFAULT_BADGE_COUNT = null;
    public static final String DEFAULT_CHANNEL_ID = "";
    public static final Integer DEFAULT_CHARACTER_LENGTH = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_CID = "";
    public static final Long DEFAULT_CIPHER_ID = null;
    public static final ByteString DEFAULT_CONTENT = null;
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final Long DEFAULT_CREATE_TIME_MS = null;
    public static final Long DEFAULT_EDIT_TIME_MS = null;
    public static final Integer DEFAULT_EDIT_VERSION = null;
    public static final Integer DEFAULT_FILTER_MUTE_BOT_BADGE_COUNT = null;
    public static final Long DEFAULT_FILTER_MUTE_BOT_BADGE_COUNT_VERSION = null;
    public static final Long DEFAULT_FOLD_ID = null;
    public static final String DEFAULT_FROM_ID = "";
    public static final Boolean DEFAULT_HAS_FOLLOW_UP = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_AUTO_TRANSLATED_BY_RECEIVER = null;
    public static final Boolean DEFAULT_IS_BADGED = null;
    public static final Boolean DEFAULT_IS_BATCH_COPY_MESSAGES = null;
    public static final Boolean DEFAULT_IS_DING = null;
    public static final Boolean DEFAULT_IS_ENCRYPTED = null;
    public static final Boolean DEFAULT_IS_INCLUDE_DOC_URL = null;
    public static final Boolean DEFAULT_IS_NOTIFIED = null;
    public static final Boolean DEFAULT_IS_NO_TRACE_REMOVED = null;
    public static final Boolean DEFAULT_IS_REMOVED = null;
    public static final Boolean DEFAULT_IS_SPECIAL_FOCUS = null;
    public static final Boolean DEFAULT_IS_STATIC_RESOURCE_MESSAGE_DELETED = null;
    public static final Boolean DEFAULT_IS_TRUNCATED = null;
    public static final Boolean DEFAULT_IS_VISIBLE = null;
    public static final Boolean DEFAULT_IS_VISIBLE_V2 = null;
    public static final Long DEFAULT_LAST_MODIFY_TIME = null;
    public static final String DEFAULT_MESSAGE_LANGUAGE = "";
    public static final Long DEFAULT_MESSAGE_PIPE_VERSION = null;
    public static final Integer DEFAULT_NO_BADGED_COUNT = null;
    public static final Integer DEFAULT_NO_REPLY_COUNT = null;
    public static final String DEFAULT_ORIGINAL_SENDER_ID = "";
    public static final String DEFAULT_PARENT_ID = "";
    public static final String DEFAULT_PARENT_SOURCE_MESSAGE_ID = "";
    public static final Integer DEFAULT_POSITION = null;
    public static final Long DEFAULT_REMOVER_ID = null;
    public static final String DEFAULT_REPLY_COUNT = "";
    public static final String DEFAULT_ROOT_ID = "";
    public static final String DEFAULT_ROOT_SOURCE_MESSAGE_ID = "";
    public static final Boolean DEFAULT_SEND_TO_CHAT = null;
    public static final Boolean DEFAULT_SET_CONTENT_GRAY = null;
    public static final Long DEFAULT_SYNC_TO_CHAT_RELATED_MESSAGE_ID = null;
    public static final Long DEFAULT_SYNC_TO_CHAT_THREAD_ROOT_ID = null;
    public static final Integer DEFAULT_THREAD_BADGE_COUNT = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_POSITION = null;
    public static final Integer DEFAULT_THREAD_REPLY_COUNT = null;
    public static final String DEFAULT_TRANSLATE_LANGUAGE = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    private static final long serialVersionUID = 0;
    public final DeletedMessageUsersInfo mDeletedMessageUsersInfo;
    public final AIInfo mai_info;
    public final AnonymousInfo manonymous_info;
    public final List<String> mat_out_chatter_ids;
    public final List<Long> mat_user_group_chatter_ids;
    public final List<Long> mat_user_id_list;
    public final AuthorizedSource mauthorized_source;
    public final Integer mbadge_count;
    public final String mchannel_id;
    public final ChannelType mchannel_type;
    public final Integer mcharacter_length;
    public final String mchat_id;
    public final ChatType mchat_type;
    public final String mcid;
    public final Long mcipher_id;
    public final ByteString mcontent;
    public final ContentState mcontent_state;
    public final COTInfo mcot_info;
    public final Long mcreate_time;
    public final Long mcreate_time_ms;
    public final CryptoInfo mcrypto_info;
    public final DisabledAction mdisabled_action;
    public final DisplayMode mdisplay_mode;
    public final DoubaoAppShowInfo mdoubao_app_show_info;
    public final Long medit_time_ms;
    public final Integer medit_version;
    public final EncryptedInfo mencrypted_info;
    public final Integer mfilter_mute_bot_badge_count;
    public final Long mfilter_mute_bot_badge_count_version;
    public final Long mfold_id;
    public final String mfrom_id;
    public final FromType mfrom_type;
    public final StreamStatus mgeneric_stream_status;
    public final Boolean mhas_follow_up;
    public final I18nInfo mi18n_info;
    public final String mid;
    public final Map<String, ImageTranslationAbility> mimages_translation_ability;
    public final Map<String, ImageTranslationAbilityV2> mimages_translation_ability_v2;
    public final Boolean mis_auto_translated_by_receiver;
    public final Boolean mis_badged;
    public final Boolean mis_batch_copy_messages;
    public final Boolean mis_ding;
    public final Boolean mis_encrypted;
    public final Boolean mis_include_doc_url;
    public final Boolean mis_no_trace_removed;
    public final Boolean mis_notified;
    public final Boolean mis_removed;
    public final Boolean mis_special_focus;
    public final Boolean mis_static_resource_message_deleted;
    public final Boolean mis_truncated;
    public final Boolean mis_visible;
    public final Boolean mis_visible_v2;
    public final Long mlast_modify_time;
    public final String mmessage_language;
    public final List<String> mmessage_languages;
    public final Long mmessage_pipe_version;
    public final Integer mno_badged_count;
    public final Integer mno_reply_count;
    public final String moriginal_sender_id;
    public final String mparent_id;
    public final String mparent_source_message_id;
    public final PartialReplyInfo mpartial_reply_info;
    public final Integer mposition;
    public final Map<String, UrlPreviewHangPoint> mreference_url_preview_hang_point_map;
    public final List<Reference> mreferences;
    public final Long mremover_id;
    public final RemoverType mremover_type;
    public final String mreply_count;
    public final RestrictedModeBurnedInfo mrestricted_mode_burned_info;
    public final String mroot_id;
    public final String mroot_source_message_id;
    public final Boolean msend_to_chat;
    public final MessageSensitivity msensitivity;
    public final Boolean mset_content_gray;
    public final Status mstatus;
    public final StreamStatus mstream_status;
    public final SyncToChatMessageType msync_to_chat_message_type;
    public final Long msync_to_chat_related_message_id;
    public final Long msync_to_chat_thread_root_id;
    public final Integer mthread_badge_count;
    public final String mthread_id;
    public final ThreadMessageType mthread_message_type;
    public final Integer mthread_position;
    public final Integer mthread_reply_count;
    public final String mtranslate_language;
    public final TranslateMessageDisplayRule mtranslate_message_display_rule;
    public final TranslateSource mtranslate_source;
    public final Type mtype;
    public final Long mupdate_time;
    public final Long mupdate_time_ms;
    public final Map<String, UrlPreviewHangPoint> murl_preview_hang_point_map;
    public final Version mversion;

    public static final class AIInfo extends com.squareup.wire.Message<AIInfo, Builder> {
        public static final ProtoAdapter<AIInfo> ADAPTER = null;
        public static final String DEFAULT_ANSWER_RAW_DATA = "";
        public static final Boolean DEFAULT_CAN_SHOW_AI_PROGRESS = null;
        public static final Long DEFAULT_CHAT_MODE_ID = null;
        public static final String DEFAULT_ENTERPRISE_QA_GENERAL_INFO = "";
        public static final Boolean DEFAULT_IS_NEW_TOPIC = null;
        public static final Long DEFAULT_ROOT_ROUND_ID = null;
        public static final Boolean DEFAULT_ROUND_FINISHED = null;
        public static final Integer DEFAULT_ROUND_FIRST_POSITION = null;
        public static final Long DEFAULT_ROUND_ID = null;
        public static final String DEFAULT_SESSION_ID = "";
        private static final long serialVersionUID = 0;
        public final AIMessageType mai_message_type;
        public final String manswer_raw_data;
        public final ButtonConfig mbutton_config;
        public final Boolean mcan_show_ai_progress;
        public final Long mchat_mode_id;
        public final String menterprise_qa_general_info;
        public final Boolean mis_new_topic;
        public final Long mroot_round_id;
        public final RoundFinishStatus mround_finish_status;
        public final Boolean mround_finished;
        public final Integer mround_first_position;
        public final Long mround_id;
        public final String msession_id;

        public static final enum AIMessageType extends Enum<AIMessageType> implements WireEnum {
            private static final /* synthetic */ AIMessageType[] $VALUES = null;
            public static final ProtoAdapter<AIMessageType> ADAPTER = null;
            public static final AIMessageType GUIDE_MESSAGE = null;
            public static final AIMessageType NOT_STREAM_ANSWER = null;
            public static final AIMessageType Notice = null;
            public static final AIMessageType OTHER = null;
            public static final AIMessageType QUESTION = null;
            public static final AIMessageType STREAM_ANSWER = null;
            public static final AIMessageType SYSTEM_MESSAGE = null;
            private final int value;

            static {
                AIMessageType r0 = new AIMessageType("OTHER", 0, 0);
                OTHER = r0;
                AIMessageType r1 = new AIMessageType("QUESTION", 1, 1);
                QUESTION = r1;
                AIMessageType r3 = new AIMessageType("STREAM_ANSWER", 2, 2);
                STREAM_ANSWER = r3;
                AIMessageType r5 = new AIMessageType("NOT_STREAM_ANSWER", 3, 3);
                NOT_STREAM_ANSWER = r5;
                AIMessageType r7 = new AIMessageType("SYSTEM_MESSAGE", 4, 4);
                SYSTEM_MESSAGE = r7;
                AIMessageType r9 = new AIMessageType("GUIDE_MESSAGE", 5, 5);
                GUIDE_MESSAGE = r9;
                AIMessageType r11 = new AIMessageType("Notice", 6, 6);
                Notice = r11;
                $VALUES = new AIMessageType[]{r0, r1, r3, r5, r7, r9, r11};
                ADAPTER = ProtoAdapter.newEnumAdapter(AIMessageType.class);
            }

            public static AIMessageType[] values() {
                return (AIMessageType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static AIMessageType fromValue(int r0) {
                switch(r0) {
                    case 0: goto L18;
                    case 1: goto L16;
                    case 2: goto L14;
                    case 3: goto L12;
                    case 4: goto L10;
                    case 5: goto L8;
                    case 6: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return Notice;
            L8:
                return GUIDE_MESSAGE;
            L10:
                return SYSTEM_MESSAGE;
            L12:
                return NOT_STREAM_ANSWER;
            L14:
                return STREAM_ANSWER;
            L16:
                return QUESTION;
            L18:
                return OTHER;
            }

            public static AIMessageType valueOf(String r1) {
                return (AIMessageType) a.a(AIMessageType.class, r1);
            }

            private AIMessageType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class Builder extends com.squareup.wire.Message.Builder<AIInfo, Builder> {
            public AIMessageType mai_message_type;
            public String manswer_raw_data;
            public ButtonConfig mbutton_config;
            public Boolean mcan_show_ai_progress;
            public Long mchat_mode_id;
            public String menterprise_qa_general_info;
            public Boolean mis_new_topic;
            public Long mroot_round_id;
            public RoundFinishStatus mround_finish_status;
            public Boolean mround_finished;
            public Integer mround_first_position;
            public Long mround_id;
            public String msession_id;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AIInfo m1302build() {
                return new AIInfo(this.mchat_mode_id, this.manswer_raw_data, this.mround_id, this.mround_first_position, this.mround_finished, this.mai_message_type, this.mround_finish_status, this.mcan_show_ai_progress, this.msession_id, this.mis_new_topic, this.mbutton_config, this.mroot_round_id, this.menterprise_qa_general_info, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1302build();
            }

            public Builder ai_message_type(AIMessageType r1) {
                this.mai_message_type = r1;
                return this;
            }

            public Builder answer_raw_data(String r1) {
                this.manswer_raw_data = r1;
                return this;
            }

            public Builder button_config(ButtonConfig r1) {
                this.mbutton_config = r1;
                return this;
            }

            public Builder can_show_ai_progress(Boolean r1) {
                this.mcan_show_ai_progress = r1;
                return this;
            }

            public Builder chat_mode_id(Long r1) {
                this.mchat_mode_id = r1;
                return this;
            }

            public Builder enterprise_qa_general_info(String r1) {
                this.menterprise_qa_general_info = r1;
                return this;
            }

            public Builder is_new_topic(Boolean r1) {
                this.mis_new_topic = r1;
                return this;
            }

            public Builder root_round_id(Long r1) {
                this.mroot_round_id = r1;
                return this;
            }

            public Builder round_finish_status(RoundFinishStatus r1) {
                this.mround_finish_status = r1;
                return this;
            }

            public Builder round_finished(Boolean r1) {
                this.mround_finished = r1;
                return this;
            }

            public Builder round_first_position(Integer r1) {
                this.mround_first_position = r1;
                return this;
            }

            public Builder round_id(Long r1) {
                this.mround_id = r1;
                return this;
            }

            public Builder session_id(String r1) {
                this.msession_id = r1;
                return this;
            }
        }

        public static final class ButtonConfig extends com.squareup.wire.Message<ButtonConfig, Builder> {
            public static final ProtoAdapter<ButtonConfig> ADAPTER = null;
            public static final String DEFAULT_AI_ANSWER_MARKDOWN_DATA = "";
            public static final String DEFAULT_BUTTON_LIST_JSON = "";
            private static final long serialVersionUID = 0;
            public final String mai_answer_markdown_data;
            public final String mbutton_list_json;
            public final List<Button> mcustomize_buttons;
            public final Strategy mstrategy;

            public static final class Builder extends com.squareup.wire.Message.Builder<ButtonConfig, Builder> {
                public String mai_answer_markdown_data;
                public String mbutton_list_json;
                public List<Button> mcustomize_buttons;
                public Strategy mstrategy;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public ButtonConfig m1304build() {
                    return new ButtonConfig(this.mstrategy, this.mcustomize_buttons, this.mai_answer_markdown_data, this.mbutton_list_json, super.buildUnknownFields());
                }

                public Builder() {
                    this.mcustomize_buttons = Internal.newMutableList();
                }

                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return m1304build();
                }

                public Builder ai_answer_markdown_data(String r1) {
                    this.mai_answer_markdown_data = r1;
                    return this;
                }

                public Builder button_list_json(String r1) {
                    this.mbutton_list_json = r1;
                    return this;
                }

                public Builder customize_buttons(List<Button> r1) {
                    Internal.checkElementsNotNull(r1);
                    this.mcustomize_buttons = r1;
                    return this;
                }

                public Builder strategy(Strategy r1) {
                    this.mstrategy = r1;
                    return this;
                }
            }

            public static final enum Button extends Enum<Button> implements WireEnum {
                private static final /* synthetic */ Button[] $VALUES = null;
                public static final ProtoAdapter<Button> ADAPTER = null;
                public static final Button COPY = null;
                public static final Button DISLIKE = null;
                public static final Button LIKE = null;
                public static final Button REGENERATE = null;
                public static final Button SHARE = null;
                public static final Button UNKNOWN = null;
                private final int value;

                static {
                    Button r0 = new Button("UNKNOWN", 0, 0);
                    UNKNOWN = r0;
                    Button r1 = new Button("LIKE", 1, 1);
                    LIKE = r1;
                    Button r3 = new Button("DISLIKE", 2, 2);
                    DISLIKE = r3;
                    Button r5 = new Button("REGENERATE", 3, 3);
                    REGENERATE = r5;
                    Button r7 = new Button("SHARE", 4, 4);
                    SHARE = r7;
                    Button r9 = new Button("COPY", 5, 5);
                    COPY = r9;
                    $VALUES = new Button[]{r0, r1, r3, r5, r7, r9};
                    ADAPTER = ProtoAdapter.newEnumAdapter(Button.class);
                }

                public static Button[] values() {
                    return (Button[]) $VALUES.clone();
                }

                public final int getValue() {
                    return this.value;
                }

                public static Button fromValue(int r1) {
                    if (r1 == 0) goto L26;
                    if (r1 == 1) goto L24;
                    if (r1 == 2) goto L22;
                    if (r1 == 3) goto L20;
                    if (r1 == 4) goto L18;
                    if (r1 == 5) goto L16;
                    return null;
                L16:
                    return COPY;
                L18:
                    return SHARE;
                L20:
                    return REGENERATE;
                L22:
                    return DISLIKE;
                L24:
                    return LIKE;
                L26:
                    return UNKNOWN;
                }

                public static Button valueOf(String r1) {
                    return (Button) a.a(Button.class, r1);
                }

                private Button(String r1, int r2, int r3) {
                    super(r1, r2);
                    this.value = r3;
                }
            }

            public static final class ProtoAdapter_ButtonConfig extends ProtoAdapter<ButtonConfig> {
                public ProtoAdapter_ButtonConfig() {
                    super(FieldEncoding.LENGTH_DELIMITED, ButtonConfig.class);
                }

                public ButtonConfig decode(ProtoReader r9) throws IOException {
                    Builder r0 = new Builder();
                    r0.mai_answer_markdown_data = "";
                    r0.mbutton_list_json = "";
                    long r1 = r9.beginMessage();
                L3:
                    int r3 = r9.nextTag();
                    if (r3 == (-1)) goto L24;
                    if (r3 != 1) goto L8;
                    r0.mstrategy = (Strategy) Strategy.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
                L22:
                    e = move-exception;
                    r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L8:
                    if (r3 != 2) goto L10;
                    r0.mcustomize_buttons.add((Button) Button.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
                L18:
                    e = move-exception;
                    r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r3 != 3) goto L12;
                    r0.mai_answer_markdown_data = (String) ProtoAdapter.STRING.decode(r9);
                    goto L3
                L12:
                    if (r3 != 4) goto L13;
                    r0.mbutton_list_json = (String) ProtoAdapter.STRING.decode(r9);
                    goto L3
                L13:
                    FieldEncoding r4 = r9.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                    goto L3
                L24:
                    r9.endMessage(r1);
                    return r0.m1304build();
                }

                public int encodedSize(ButtonConfig r6) {
                    Strategy r0 = r6.mstrategy;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = Strategy.ADAPTER.encodedSizeWithTag(1, r0);
                L6:
                    int r3 = r2 + Button.ADAPTER.asRepeated().encodedSizeWithTag(2, r6.mcustomize_buttons);
                    String r4 = r6.mai_answer_markdown_data;
                    if (r4 == null) goto L9;
                    int r5 = ProtoAdapter.STRING.encodedSizeWithTag(3, r4);
                L10:
                    int r7 = r3 + r5;
                    String r8 = r6.mbutton_list_json;
                    if (r8 == null) goto L14;
                    r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r8);
                L14:
                    return (r7 + r1) + r6.unknownFields().size();
                L9:
                    r5 = 0;
                    goto L10
                L5:
                    r2 = 0;
                    goto L6
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m1305decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((ButtonConfig) r1);
                }

                public void encode(ProtoWriter r4, ButtonConfig r5) throws IOException {
                    Strategy r0 = r5.mstrategy;
                    if (r0 == null) goto L5;
                    Strategy.ADAPTER.encodeWithTag(r4, 1, r0);
                L5:
                    Button.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mcustomize_buttons);
                    String r1 = r5.mai_answer_markdown_data;
                    if (r1 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r4, 3, r1);
                L8:
                    String r2 = r5.mbutton_list_json;
                    if (r2 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r4, 4, r2);
                L11:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (ButtonConfig) r2);
                }
            }

            public static final enum Strategy extends Enum<Strategy> implements WireEnum {
                private static final /* synthetic */ Strategy[] $VALUES = null;
                public static final ProtoAdapter<Strategy> ADAPTER = null;
                public static final Strategy CUSTOMIZE = null;
                public static final Strategy DEFAULT = null;
                private final int value;

                static {
                    Strategy r0 = new Strategy("DEFAULT", 0, 0);
                    DEFAULT = r0;
                    Strategy r1 = new Strategy("CUSTOMIZE", 1, 1);
                    CUSTOMIZE = r1;
                    $VALUES = new Strategy[]{r0, r1};
                    ADAPTER = ProtoAdapter.newEnumAdapter(Strategy.class);
                }

                public static Strategy[] values() {
                    return (Strategy[]) $VALUES.clone();
                }

                public final int getValue() {
                    return this.value;
                }

                public static Strategy fromValue(int r1) {
                    if (r1 == 0) goto L10;
                    if (r1 == 1) goto L8;
                    return null;
                L8:
                    return CUSTOMIZE;
                L10:
                    return DEFAULT;
                }

                public static Strategy valueOf(String r1) {
                    return (Strategy) a.a(Strategy.class, r1);
                }

                private Strategy(String r1, int r2, int r3) {
                    super(r1, r2);
                    this.value = r3;
                }
            }

            static {
                ADAPTER = new ProtoAdapter_ButtonConfig();
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1303newBuilder() {
                Builder r0 = new Builder();
                r0.mstrategy = this.mstrategy;
                r0.mcustomize_buttons = Internal.copyOf("mcustomize_buttons", this.mcustomize_buttons);
                r0.mai_answer_markdown_data = this.mai_answer_markdown_data;
                r0.mbutton_list_json = this.mbutton_list_json;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return ButtonConfig.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return m1303newBuilder();
            }

            public ButtonConfig(Strategy r7, List<Button> r8, String r9, String r10) {
                this(r7, r8, r9, r10, ByteString.EMPTY);
            }

            public ButtonConfig(Strategy r2, List<Button> r3, String r4, String r5, ByteString r6) {
                super(ADAPTER, r6);
                this.mstrategy = r2;
                this.mcustomize_buttons = Internal.immutableCopyOf("mcustomize_buttons", r3);
                this.mai_answer_markdown_data = r4;
                this.mbutton_list_json = r5;
            }
        }

        public static final class ProtoAdapter_AIInfo extends ProtoAdapter<AIInfo> {
            public ProtoAdapter_AIInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, AIInfo.class);
            }

            public AIInfo decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mchat_mode_id = 0L;
                r0.manswer_raw_data = "";
                r0.mround_id = 0L;
                r0.mround_first_position = 0;
                Boolean r3 = Boolean.FALSE;
                r0.mround_finished = r3;
                r0.mcan_show_ai_progress = r3;
                r0.msession_id = "";
                r0.mis_new_topic = r3;
                r0.mroot_round_id = 0L;
                r0.menterprise_qa_general_info = "";
                long r1 = r9.beginMessage();
            L3:
                int r4 = r9.nextTag();
                if (r4 == (-1)) goto L26;
                switch(r4) {
                    case 1: goto L25;
                    case 2: goto L24;
                    case 3: goto L23;
                    case 4: goto L22;
                    case 5: goto L21;
                    case 6: goto L28;
                    case 7: goto L30;
                    case 8: goto L12;
                    case 9: goto L11;
                    case 10: goto L10;
                    case 11: goto L9;
                    case 12: goto L8;
                    case 13: goto L7;
                    default: goto L6;
                };
            L28:
                r0.mai_message_type = (AIMessageType) AIMessageType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r0.addUnknownField(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L30:
                r0.mround_finish_status = (RoundFinishStatus) RoundFinishStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.menterprise_qa_general_info = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                r0.mroot_round_id = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L9:
                r0.mbutton_config = (ButtonConfig) ButtonConfig.ADAPTER.decode(r9);
                goto L3
            L10:
                r0.mis_new_topic = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L11:
                r0.msession_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L12:
                r0.mcan_show_ai_progress = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L21:
                r0.mround_finished = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L22:
                r0.mround_first_position = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L23:
                r0.mround_id = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L24:
                r0.manswer_raw_data = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L25:
                r0.mchat_mode_id = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L6:
                FieldEncoding r5 = r9.peekFieldEncoding();
                r0.addUnknownField(r4, r5, r5.rawProtoAdapter().decode(r9));
                goto L3
            L26:
                r9.endMessage(r1);
                return r0.m1302build();
            }

            public int encodedSize(AIInfo r6) {
                Long r0 = r6.mchat_mode_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.manswer_raw_data;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Long r7 = r6.mround_id;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                Integer r10 = r6.mround_first_position;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.INT32.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                Boolean r13 = r6.mround_finished;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                AIMessageType r16 = r6.mai_message_type;
                if (r16 == null) goto L25;
                int r17 = AIMessageType.ADAPTER.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                RoundFinishStatus r19 = r6.mround_finish_status;
                if (r19 == null) goto L29;
                int r20 = RoundFinishStatus.ADAPTER.encodedSizeWithTag(7, r19);
            L30:
                int r21 = r18 + r20;
                Boolean r22 = r6.mcan_show_ai_progress;
                if (r22 == null) goto L33;
                int r23 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r22);
            L34:
                int r24 = r21 + r23;
                String r25 = r6.msession_id;
                if (r25 == null) goto L37;
                int r26 = ProtoAdapter.STRING.encodedSizeWithTag(9, r25);
            L38:
                int r27 = r24 + r26;
                Boolean r28 = r6.mis_new_topic;
                if (r28 == null) goto L41;
                int r29 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r28);
            L42:
                int r30 = r27 + r29;
                ButtonConfig r31 = r6.mbutton_config;
                if (r31 == null) goto L45;
                int r32 = ButtonConfig.ADAPTER.encodedSizeWithTag(11, r31);
            L46:
                int r33 = r30 + r32;
                Long r34 = r6.mroot_round_id;
                if (r34 == null) goto L49;
                int r35 = ProtoAdapter.INT64.encodedSizeWithTag(12, r34);
            L50:
                int r36 = r33 + r35;
                String r37 = r6.menterprise_qa_general_info;
                if (r37 == null) goto L54;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(13, r37);
            L54:
                return (r36 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1306decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AIInfo) r1);
            }

            public void encode(ProtoWriter r4, AIInfo r5) throws IOException {
                Long r0 = r5.mchat_mode_id;
                if (r0 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.manswer_raw_data;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                Long r2 = r5.mround_id;
                if (r2 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
            L11:
                Integer r3 = r5.mround_first_position;
                if (r3 == null) goto L14;
                ProtoAdapter.INT32.encodeWithTag(r4, 4, r3);
            L14:
                Boolean r6 = r5.mround_finished;
                if (r6 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
            L17:
                AIMessageType r7 = r5.mai_message_type;
                if (r7 == null) goto L20;
                AIMessageType.ADAPTER.encodeWithTag(r4, 6, r7);
            L20:
                RoundFinishStatus r8 = r5.mround_finish_status;
                if (r8 == null) goto L23;
                RoundFinishStatus.ADAPTER.encodeWithTag(r4, 7, r8);
            L23:
                Boolean r9 = r5.mcan_show_ai_progress;
                if (r9 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r4, 8, r9);
            L26:
                String r10 = r5.msession_id;
                if (r10 == null) goto L29;
                ProtoAdapter.STRING.encodeWithTag(r4, 9, r10);
            L29:
                Boolean r11 = r5.mis_new_topic;
                if (r11 == null) goto L32;
                ProtoAdapter.BOOL.encodeWithTag(r4, 10, r11);
            L32:
                ButtonConfig r12 = r5.mbutton_config;
                if (r12 == null) goto L35;
                ButtonConfig.ADAPTER.encodeWithTag(r4, 11, r12);
            L35:
                Long r13 = r5.mroot_round_id;
                if (r13 == null) goto L38;
                ProtoAdapter.INT64.encodeWithTag(r4, 12, r13);
            L38:
                String r14 = r5.menterprise_qa_general_info;
                if (r14 == null) goto L41;
                ProtoAdapter.STRING.encodeWithTag(r4, 13, r14);
            L41:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AIInfo) r2);
            }
        }

        public static final enum RoundFinishStatus extends Enum<RoundFinishStatus> implements WireEnum {
            private static final /* synthetic */ RoundFinishStatus[] $VALUES = null;
            public static final ProtoAdapter<RoundFinishStatus> ADAPTER = null;
            public static final RoundFinishStatus DONE = null;
            public static final RoundFinishStatus INTERRUPT = null;
            public static final RoundFinishStatus RESPONDING = null;
            public static final RoundFinishStatus ROUND_ERROR = null;
            public static final RoundFinishStatus UNKNOWN = null;
            private final int value;

            static {
                RoundFinishStatus r0 = new RoundFinishStatus("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                RoundFinishStatus r1 = new RoundFinishStatus("RESPONDING", 1, 1);
                RESPONDING = r1;
                RoundFinishStatus r3 = new RoundFinishStatus("DONE", 2, 2);
                DONE = r3;
                RoundFinishStatus r5 = new RoundFinishStatus("INTERRUPT", 3, 3);
                INTERRUPT = r5;
                RoundFinishStatus r7 = new RoundFinishStatus("ROUND_ERROR", 4, 4);
                ROUND_ERROR = r7;
                $VALUES = new RoundFinishStatus[]{r0, r1, r3, r5, r7};
                ADAPTER = ProtoAdapter.newEnumAdapter(RoundFinishStatus.class);
            }

            public static RoundFinishStatus[] values() {
                return (RoundFinishStatus[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static RoundFinishStatus fromValue(int r1) {
                if (r1 == 0) goto L22;
                if (r1 == 1) goto L20;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L16;
                if (r1 == 4) goto L14;
                return null;
            L14:
                return ROUND_ERROR;
            L16:
                return INTERRUPT;
            L18:
                return DONE;
            L20:
                return RESPONDING;
            L22:
                return UNKNOWN;
            }

            public static RoundFinishStatus valueOf(String r1) {
                return (RoundFinishStatus) a.a(RoundFinishStatus.class, r1);
            }

            private RoundFinishStatus(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AIInfo();
            DEFAULT_CHAT_MODE_ID = 0L;
            DEFAULT_ROUND_ID = 0L;
            DEFAULT_ROUND_FIRST_POSITION = 0;
            Boolean r1 = Boolean.FALSE;
            DEFAULT_ROUND_FINISHED = r1;
            DEFAULT_CAN_SHOW_AI_PROGRESS = r1;
            DEFAULT_IS_NEW_TOPIC = r1;
            DEFAULT_ROOT_ROUND_ID = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1301newBuilder() {
            Builder r0 = new Builder();
            r0.mchat_mode_id = this.mchat_mode_id;
            r0.manswer_raw_data = this.manswer_raw_data;
            r0.mround_id = this.mround_id;
            r0.mround_first_position = this.mround_first_position;
            r0.mround_finished = this.mround_finished;
            r0.mai_message_type = this.mai_message_type;
            r0.mround_finish_status = this.mround_finish_status;
            r0.mcan_show_ai_progress = this.mcan_show_ai_progress;
            r0.msession_id = this.msession_id;
            r0.mis_new_topic = this.mis_new_topic;
            r0.mbutton_config = this.mbutton_config;
            r0.mroot_round_id = this.mroot_round_id;
            r0.menterprise_qa_general_info = this.menterprise_qa_general_info;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AIInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1301newBuilder();
        }

        public AIInfo(Long r16, String r17, Long r18, Integer r19, Boolean r20, AIMessageType r21, RoundFinishStatus r22, Boolean r23, String r24, Boolean r25, ButtonConfig r26, Long r27, String r28) {
            this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
        }

        public AIInfo(Long r2, String r3, Long r4, Integer r5, Boolean r6, AIMessageType r7, RoundFinishStatus r8, Boolean r9, String r10, Boolean r11, ButtonConfig r12, Long r13, String r14, ByteString r15) {
            super(ADAPTER, r15);
            this.mchat_mode_id = r2;
            this.manswer_raw_data = r3;
            this.mround_id = r4;
            this.mround_first_position = r5;
            this.mround_finished = r6;
            this.mai_message_type = r7;
            this.mround_finish_status = r8;
            this.mcan_show_ai_progress = r9;
            this.msession_id = r10;
            this.mis_new_topic = r11;
            this.mbutton_config = r12;
            this.mroot_round_id = r13;
            this.menterprise_qa_general_info = r14;
        }
    }

    public static final enum AgentSendMessageSourceDisplayPolicy extends Enum<AgentSendMessageSourceDisplayPolicy> implements WireEnum {
        private static final /* synthetic */ AgentSendMessageSourceDisplayPolicy[] $VALUES = null;
        public static final ProtoAdapter<AgentSendMessageSourceDisplayPolicy> ADAPTER = null;
        public static final AgentSendMessageSourceDisplayPolicy INLINE = null;
        public static final AgentSendMessageSourceDisplayPolicy MENU = null;
        public static final AgentSendMessageSourceDisplayPolicy UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY = null;
        private final int value;

        static {
            AgentSendMessageSourceDisplayPolicy r0 = new AgentSendMessageSourceDisplayPolicy("UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY", 0, 0);
            UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY = r0;
            AgentSendMessageSourceDisplayPolicy r1 = new AgentSendMessageSourceDisplayPolicy("MENU", 1, 1);
            MENU = r1;
            AgentSendMessageSourceDisplayPolicy r3 = new AgentSendMessageSourceDisplayPolicy("INLINE", 2, 2);
            INLINE = r3;
            $VALUES = new AgentSendMessageSourceDisplayPolicy[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(AgentSendMessageSourceDisplayPolicy.class);
        }

        public static AgentSendMessageSourceDisplayPolicy[] values() {
            return (AgentSendMessageSourceDisplayPolicy[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AgentSendMessageSourceDisplayPolicy fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return INLINE;
        L12:
            return MENU;
        L14:
            return UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY;
        }

        public static AgentSendMessageSourceDisplayPolicy valueOf(String r1) {
            return (AgentSendMessageSourceDisplayPolicy) a.a(AgentSendMessageSourceDisplayPolicy.class, r1);
        }

        private AgentSendMessageSourceDisplayPolicy(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class AnonymousInfo extends com.squareup.wire.Message<AnonymousInfo, Builder> {
        public static final ProtoAdapter<AnonymousInfo> ADAPTER = null;
        public static final String DEFAULT_ANONYMOUS_CHATTER_ID = "";
        public static final Boolean DEFAULT_IS_ANONYMOUS = null;
        public static final Boolean DEFAULT_IS_SENDER = null;
        private static final long serialVersionUID = 0;
        public final String manonymous_chatter_id;
        public final Boolean mis_anonymous;
        public final Boolean mis_sender;

        public static final class Builder extends com.squareup.wire.Message.Builder<AnonymousInfo, Builder> {
            public String manonymous_chatter_id;
            public Boolean mis_anonymous;
            public Boolean mis_sender;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AnonymousInfo m1308build() {
                Boolean r0 = this.mis_anonymous;
                if (r0 == null) goto L7;
                return new AnonymousInfo(this.mis_anonymous, this.mis_sender, this.manonymous_chatter_id, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "mis_anonymous"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1308build();
            }

            public Builder anonymous_chatter_id(String r1) {
                this.manonymous_chatter_id = r1;
                return this;
            }

            public Builder is_anonymous(Boolean r1) {
                this.mis_anonymous = r1;
                return this;
            }

            public Builder is_sender(Boolean r1) {
                this.mis_sender = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_AnonymousInfo extends ProtoAdapter<AnonymousInfo> {
            public ProtoAdapter_AnonymousInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, AnonymousInfo.class);
            }

            public AnonymousInfo decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.mis_anonymous = r1;
                r0.mis_sender = r1;
                r0.manonymous_chatter_id = "";
                long r2 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mis_anonymous = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mis_sender = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.manonymous_chatter_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r2);
                return r0.m1308build();
            }

            public int encodedSize(AnonymousInfo r6) {
                ProtoAdapter r0 = ProtoAdapter.BOOL;
                int r1 = r0.encodedSizeWithTag(1, r6.mis_anonymous);
                Boolean r2 = r6.mis_sender;
                int r3 = 0;
                if (r2 == null) goto L5;
                int r4 = r0.encodedSizeWithTag(2, r2);
            L6:
                int r5 = r1 + r4;
                String r7 = r6.manonymous_chatter_id;
                if (r7 == null) goto L10;
                r3 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L10:
                return (r5 + r3) + r6.unknownFields().size();
            L5:
                r4 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1309decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AnonymousInfo) r1);
            }

            public void encode(ProtoWriter r4, AnonymousInfo r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.BOOL;
                r0.encodeWithTag(r4, 1, r5.mis_anonymous);
                Boolean r1 = r5.mis_sender;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r4, 2, r1);
            L5:
                String r2 = r5.manonymous_chatter_id;
                if (r2 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AnonymousInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AnonymousInfo();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_IS_ANONYMOUS = r0;
            DEFAULT_IS_SENDER = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1307newBuilder() {
            Builder r0 = new Builder();
            r0.mis_anonymous = this.mis_anonymous;
            r0.mis_sender = this.mis_sender;
            r0.manonymous_chatter_id = this.manonymous_chatter_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AnonymousInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1307newBuilder();
        }

        public AnonymousInfo(Boolean r2, Boolean r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public AnonymousInfo(Boolean r2, Boolean r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mis_anonymous = r2;
            this.mis_sender = r3;
            this.manonymous_chatter_id = r4;
        }
    }

    public static final class AuthorizedSource extends com.squareup.wire.Message<AuthorizedSource, Builder> {
        public static final ProtoAdapter<AuthorizedSource> ADAPTER = null;
        public static final Long DEFAULT_SOURCE_ID = null;
        private static final long serialVersionUID = 0;
        public final AuthorizedSourceType mauthorized_source_type;
        public final AgentSendMessageSourceDisplayPolicy mdisplay_policy;
        public final Long msource_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<AuthorizedSource, Builder> {
            public AuthorizedSourceType mauthorized_source_type;
            public AgentSendMessageSourceDisplayPolicy mdisplay_policy;
            public Long msource_id;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AuthorizedSource m1311build() {
                Long r0 = this.msource_id;
                if (r0 == null) goto L9;
                if (this.mauthorized_source_type == null) goto L9;
                return new AuthorizedSource(this.msource_id, this.mauthorized_source_type, this.mdisplay_policy, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "msource_id", this.mauthorized_source_type, "mauthorized_source_type"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1311build();
            }

            public Builder authorized_source_type(AuthorizedSourceType r1) {
                this.mauthorized_source_type = r1;
                return this;
            }

            public Builder display_policy(AgentSendMessageSourceDisplayPolicy r1) {
                this.mdisplay_policy = r1;
                return this;
            }

            public Builder source_id(Long r1) {
                this.msource_id = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_AuthorizedSource extends ProtoAdapter<AuthorizedSource> {
            public ProtoAdapter_AuthorizedSource() {
                super(FieldEncoding.LENGTH_DELIMITED, AuthorizedSource.class);
            }

            public AuthorizedSource decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.msource_id = 0L;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.msource_id = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mauthorized_source_type = (AuthorizedSourceType) AuthorizedSourceType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mdisplay_policy = (AgentSendMessageSourceDisplayPolicy) AgentSendMessageSourceDisplayPolicy.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m1311build();
            }

            public int encodedSize(AuthorizedSource r5) {
                int r0 = ProtoAdapter.INT64.encodedSizeWithTag(1, r5.msource_id) + AuthorizedSourceType.ADAPTER.encodedSizeWithTag(2, r5.mauthorized_source_type);
                AgentSendMessageSourceDisplayPolicy r1 = r5.mdisplay_policy;
                if (r1 == null) goto L5;
                int r2 = AgentSendMessageSourceDisplayPolicy.ADAPTER.encodedSizeWithTag(3, r1);
            L7:
                return (r0 + r2) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1312decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AuthorizedSource) r1);
            }

            public void encode(ProtoWriter r4, AuthorizedSource r5) throws IOException {
                ProtoAdapter.INT64.encodeWithTag(r4, 1, r5.msource_id);
                AuthorizedSourceType.ADAPTER.encodeWithTag(r4, 2, r5.mauthorized_source_type);
                AgentSendMessageSourceDisplayPolicy r0 = r5.mdisplay_policy;
                if (r0 == null) goto L5;
                AgentSendMessageSourceDisplayPolicy.ADAPTER.encodeWithTag(r4, 3, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AuthorizedSource) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AuthorizedSource();
            DEFAULT_SOURCE_ID = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1310newBuilder() {
            Builder r0 = new Builder();
            r0.msource_id = this.msource_id;
            r0.mauthorized_source_type = this.mauthorized_source_type;
            r0.mdisplay_policy = this.mdisplay_policy;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AuthorizedSource.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1310newBuilder();
        }

        public AuthorizedSource(Long r2, AuthorizedSourceType r3, AgentSendMessageSourceDisplayPolicy r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public AuthorizedSource(Long r2, AuthorizedSourceType r3, AgentSendMessageSourceDisplayPolicy r4, ByteString r5) {
            super(ADAPTER, r5);
            this.msource_id = r2;
            this.mauthorized_source_type = r3;
            this.mdisplay_policy = r4;
        }
    }

    public static final enum AuthorizedSourceType extends Enum<AuthorizedSourceType> implements WireEnum {
        private static final /* synthetic */ AuthorizedSourceType[] $VALUES = null;
        public static final ProtoAdapter<AuthorizedSourceType> ADAPTER = null;
        public static final AuthorizedSourceType APP = null;
        public static final AuthorizedSourceType UNKNOWN_AUTHORIZED_SOURCE_TYPE = null;
        private final int value;

        static {
            AuthorizedSourceType r0 = new AuthorizedSourceType("UNKNOWN_AUTHORIZED_SOURCE_TYPE", 0, 0);
            UNKNOWN_AUTHORIZED_SOURCE_TYPE = r0;
            AuthorizedSourceType r1 = new AuthorizedSourceType("APP", 1, 1);
            APP = r1;
            $VALUES = new AuthorizedSourceType[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(AuthorizedSourceType.class);
        }

        public static AuthorizedSourceType[] values() {
            return (AuthorizedSourceType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AuthorizedSourceType fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return APP;
        L10:
            return UNKNOWN_AUTHORIZED_SOURCE_TYPE;
        }

        public static AuthorizedSourceType valueOf(String r1) {
            return (AuthorizedSourceType) a.a(AuthorizedSourceType.class, r1);
        }

        private AuthorizedSourceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<Message, Builder> {
        public DeletedMessageUsersInfo mDeletedMessageUsersInfo;
        public AIInfo mai_info;
        public AnonymousInfo manonymous_info;
        public List<String> mat_out_chatter_ids;
        public List<Long> mat_user_group_chatter_ids;
        public List<Long> mat_user_id_list;
        public AuthorizedSource mauthorized_source;
        public Integer mbadge_count;
        public String mchannel_id;
        public ChannelType mchannel_type;
        public Integer mcharacter_length;
        public String mchat_id;
        public ChatType mchat_type;
        public String mcid;
        public Long mcipher_id;
        public ByteString mcontent;
        public ContentState mcontent_state;
        public COTInfo mcot_info;
        public Long mcreate_time;
        public Long mcreate_time_ms;
        public CryptoInfo mcrypto_info;
        public DisabledAction mdisabled_action;
        public DisplayMode mdisplay_mode;
        public DoubaoAppShowInfo mdoubao_app_show_info;
        public Long medit_time_ms;
        public Integer medit_version;
        public EncryptedInfo mencrypted_info;
        public Integer mfilter_mute_bot_badge_count;
        public Long mfilter_mute_bot_badge_count_version;
        public Long mfold_id;
        public String mfrom_id;
        public FromType mfrom_type;
        public StreamStatus mgeneric_stream_status;
        public Boolean mhas_follow_up;
        public I18nInfo mi18n_info;
        public String mid;
        public Map<String, ImageTranslationAbility> mimages_translation_ability;
        public Map<String, ImageTranslationAbilityV2> mimages_translation_ability_v2;
        public Boolean mis_auto_translated_by_receiver;
        public Boolean mis_badged;
        public Boolean mis_batch_copy_messages;
        public Boolean mis_ding;
        public Boolean mis_encrypted;
        public Boolean mis_include_doc_url;
        public Boolean mis_no_trace_removed;
        public Boolean mis_notified;
        public Boolean mis_removed;
        public Boolean mis_special_focus;
        public Boolean mis_static_resource_message_deleted;
        public Boolean mis_truncated;
        public Boolean mis_visible;
        public Boolean mis_visible_v2;
        public Long mlast_modify_time;
        public String mmessage_language;
        public List<String> mmessage_languages;
        public Long mmessage_pipe_version;
        public Integer mno_badged_count;
        public Integer mno_reply_count;
        public String moriginal_sender_id;
        public String mparent_id;
        public String mparent_source_message_id;
        public PartialReplyInfo mpartial_reply_info;
        public Integer mposition;
        public Map<String, UrlPreviewHangPoint> mreference_url_preview_hang_point_map;
        public List<Reference> mreferences;
        public Long mremover_id;
        public RemoverType mremover_type;
        public String mreply_count;
        public RestrictedModeBurnedInfo mrestricted_mode_burned_info;
        public String mroot_id;
        public String mroot_source_message_id;
        public Boolean msend_to_chat;
        public MessageSensitivity msensitivity;
        public Boolean mset_content_gray;
        public Status mstatus;
        public StreamStatus mstream_status;
        public SyncToChatMessageType msync_to_chat_message_type;
        public Long msync_to_chat_related_message_id;
        public Long msync_to_chat_thread_root_id;
        public Integer mthread_badge_count;
        public String mthread_id;
        public ThreadMessageType mthread_message_type;
        public Integer mthread_position;
        public Integer mthread_reply_count;
        public String mtranslate_language;
        public TranslateMessageDisplayRule mtranslate_message_display_rule;
        public TranslateSource mtranslate_source;
        public Type mtype;
        public Long mupdate_time;
        public Long mupdate_time_ms;
        public Map<String, UrlPreviewHangPoint> murl_preview_hang_point_map;
        public Version mversion;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Message m1313build() {
            return new Message(this.mid, this.mtype, this.mfrom_id, this.mcreate_time, this.mcontent, this.mstatus, this.mfrom_type, this.mroot_id, this.mparent_id, this.mchat_id, this.mlast_modify_time, this.mcid, this.mposition, this.mupdate_time, this.mis_notified, this.mreply_count, this.mparent_source_message_id, this.mroot_source_message_id, this.mis_ding, this.mthread_id, this.msend_to_chat, this.mis_truncated, this.mis_removed, this.mchannel_id, this.mchannel_type, this.mis_visible, this.mcrypto_info, this.mthread_position, this.mremover_id, this.mtranslate_language, this.mremover_type, this.mi18n_info, this.mno_badged_count, this.mis_badged, this.mbadge_count, this.mthread_badge_count, this.mthread_reply_count, this.mat_out_chatter_ids, this.mmessage_language, this.mtranslate_message_display_rule, this.mis_no_trace_removed, this.mis_auto_translated_by_receiver, this.msensitivity, this.mis_visible_v2, this.mtranslate_source, this.mchat_type, this.moriginal_sender_id, this.mis_static_resource_message_deleted, this.mimages_translation_ability, this.mversion, this.mimages_translation_ability_v2, this.mmessage_pipe_version, this.mis_batch_copy_messages, this.manonymous_info, this.murl_preview_hang_point_map, this.mis_special_focus, this.mcontent_state, this.mis_include_doc_url, this.mcipher_id, this.mcharacter_length, this.mthread_message_type, this.mcreate_time_ms, this.mis_encrypted, this.mat_user_id_list, this.mencrypted_info, this.medit_version, this.medit_time_ms, this.mmessage_languages, this.mfold_id, this.mdisplay_mode, this.mdisabled_action, this.mset_content_gray, this.mrestricted_mode_burned_info, this.mstream_status, this.mai_info, this.mupdate_time_ms, this.mreferences, this.mreference_url_preview_hang_point_map, this.mno_reply_count, this.msync_to_chat_thread_root_id, this.msync_to_chat_message_type, this.msync_to_chat_related_message_id, this.mpartial_reply_info, this.mauthorized_source, this.mDeletedMessageUsersInfo, this.mhas_follow_up, this.mgeneric_stream_status, this.mat_user_group_chatter_ids, this.mfilter_mute_bot_badge_count, this.mfilter_mute_bot_badge_count_version, this.mdoubao_app_show_info, this.mcot_info, super.buildUnknownFields());
        }

        public Builder() {
            this.mat_out_chatter_ids = Internal.newMutableList();
            this.mimages_translation_ability = Internal.newMutableMap();
            this.mimages_translation_ability_v2 = Internal.newMutableMap();
            this.murl_preview_hang_point_map = Internal.newMutableMap();
            this.mat_user_id_list = Internal.newMutableList();
            this.mmessage_languages = Internal.newMutableList();
            this.mreferences = Internal.newMutableList();
            this.mreference_url_preview_hang_point_map = Internal.newMutableMap();
            this.mat_user_group_chatter_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1313build();
        }

        public Builder DeletedMessageUsersInfo(DeletedMessageUsersInfo r1) {
            this.mDeletedMessageUsersInfo = r1;
            return this;
        }

        public Builder ai_info(AIInfo r1) {
            this.mai_info = r1;
            return this;
        }

        public Builder anonymous_info(AnonymousInfo r1) {
            this.manonymous_info = r1;
            return this;
        }

        public Builder at_out_chatter_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mat_out_chatter_ids = r1;
            return this;
        }

        public Builder at_user_group_chatter_ids(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mat_user_group_chatter_ids = r1;
            return this;
        }

        public Builder at_user_id_list(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mat_user_id_list = r1;
            return this;
        }

        public Builder authorized_source(AuthorizedSource r1) {
            this.mauthorized_source = r1;
            return this;
        }

        public Builder badge_count(Integer r1) {
            this.mbadge_count = r1;
            return this;
        }

        public Builder channel_id(String r1) {
            this.mchannel_id = r1;
            return this;
        }

        public Builder channel_type(ChannelType r1) {
            this.mchannel_type = r1;
            return this;
        }

        public Builder character_length(Integer r1) {
            this.mcharacter_length = r1;
            return this;
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder chat_type(ChatType r1) {
            this.mchat_type = r1;
            return this;
        }

        public Builder cid(String r1) {
            this.mcid = r1;
            return this;
        }

        public Builder cipher_id(Long r1) {
            this.mcipher_id = r1;
            return this;
        }

        public Builder content(ByteString r1) {
            this.mcontent = r1;
            return this;
        }

        public Builder content_state(ContentState r1) {
            this.mcontent_state = r1;
            return this;
        }

        public Builder cot_info(COTInfo r1) {
            this.mcot_info = r1;
            return this;
        }

        public Builder create_time(Long r1) {
            this.mcreate_time = r1;
            return this;
        }

        public Builder create_time_ms(Long r1) {
            this.mcreate_time_ms = r1;
            return this;
        }

        public Builder crypto_info(CryptoInfo r1) {
            this.mcrypto_info = r1;
            return this;
        }

        public Builder disabled_action(DisabledAction r1) {
            this.mdisabled_action = r1;
            return this;
        }

        public Builder display_mode(DisplayMode r1) {
            this.mdisplay_mode = r1;
            return this;
        }

        public Builder doubao_app_show_info(DoubaoAppShowInfo r1) {
            this.mdoubao_app_show_info = r1;
            return this;
        }

        public Builder edit_time_ms(Long r1) {
            this.medit_time_ms = r1;
            return this;
        }

        public Builder edit_version(Integer r1) {
            this.medit_version = r1;
            return this;
        }

        public Builder encrypted_info(EncryptedInfo r1) {
            this.mencrypted_info = r1;
            return this;
        }

        public Builder filter_mute_bot_badge_count(Integer r1) {
            this.mfilter_mute_bot_badge_count = r1;
            return this;
        }

        public Builder filter_mute_bot_badge_count_version(Long r1) {
            this.mfilter_mute_bot_badge_count_version = r1;
            return this;
        }

        public Builder fold_id(Long r1) {
            this.mfold_id = r1;
            return this;
        }

        public Builder from_id(String r1) {
            this.mfrom_id = r1;
            return this;
        }

        public Builder from_type(FromType r1) {
            this.mfrom_type = r1;
            return this;
        }

        public Builder generic_stream_status(StreamStatus r1) {
            this.mgeneric_stream_status = r1;
            return this;
        }

        public Builder has_follow_up(Boolean r1) {
            this.mhas_follow_up = r1;
            return this;
        }

        public Builder i18n_info(I18nInfo r1) {
            this.mi18n_info = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder images_translation_ability(Map<String, ImageTranslationAbility> r1) {
            Internal.checkElementsNotNull(r1);
            this.mimages_translation_ability = r1;
            return this;
        }

        public Builder images_translation_ability_v2(Map<String, ImageTranslationAbilityV2> r1) {
            Internal.checkElementsNotNull(r1);
            this.mimages_translation_ability_v2 = r1;
            return this;
        }

        public Builder is_auto_translated_by_receiver(Boolean r1) {
            this.mis_auto_translated_by_receiver = r1;
            return this;
        }

        public Builder is_badged(Boolean r1) {
            this.mis_badged = r1;
            return this;
        }

        public Builder is_batch_copy_messages(Boolean r1) {
            this.mis_batch_copy_messages = r1;
            return this;
        }

        public Builder is_ding(Boolean r1) {
            this.mis_ding = r1;
            return this;
        }

        public Builder is_encrypted(Boolean r1) {
            this.mis_encrypted = r1;
            return this;
        }

        public Builder is_include_doc_url(Boolean r1) {
            this.mis_include_doc_url = r1;
            return this;
        }

        public Builder is_no_trace_removed(Boolean r1) {
            this.mis_no_trace_removed = r1;
            return this;
        }

        public Builder is_notified(Boolean r1) {
            this.mis_notified = r1;
            return this;
        }

        public Builder is_removed(Boolean r1) {
            this.mis_removed = r1;
            return this;
        }

        public Builder is_special_focus(Boolean r1) {
            this.mis_special_focus = r1;
            return this;
        }

        public Builder is_static_resource_message_deleted(Boolean r1) {
            this.mis_static_resource_message_deleted = r1;
            return this;
        }

        public Builder is_truncated(Boolean r1) {
            this.mis_truncated = r1;
            return this;
        }

        public Builder is_visible(Boolean r1) {
            this.mis_visible = r1;
            return this;
        }

        public Builder is_visible_v2(Boolean r1) {
            this.mis_visible_v2 = r1;
            return this;
        }

        public Builder last_modify_time(Long r1) {
            this.mlast_modify_time = r1;
            return this;
        }

        public Builder message_language(String r1) {
            this.mmessage_language = r1;
            return this;
        }

        public Builder message_languages(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmessage_languages = r1;
            return this;
        }

        public Builder message_pipe_version(Long r1) {
            this.mmessage_pipe_version = r1;
            return this;
        }

        public Builder no_badged_count(Integer r1) {
            this.mno_badged_count = r1;
            return this;
        }

        public Builder no_reply_count(Integer r1) {
            this.mno_reply_count = r1;
            return this;
        }

        public Builder original_sender_id(String r1) {
            this.moriginal_sender_id = r1;
            return this;
        }

        public Builder parent_id(String r1) {
            this.mparent_id = r1;
            return this;
        }

        public Builder parent_source_message_id(String r1) {
            this.mparent_source_message_id = r1;
            return this;
        }

        public Builder partial_reply_info(PartialReplyInfo r1) {
            this.mpartial_reply_info = r1;
            return this;
        }

        public Builder position(Integer r1) {
            this.mposition = r1;
            return this;
        }

        public Builder reference_url_preview_hang_point_map(Map<String, UrlPreviewHangPoint> r1) {
            Internal.checkElementsNotNull(r1);
            this.mreference_url_preview_hang_point_map = r1;
            return this;
        }

        public Builder references(List<Reference> r1) {
            Internal.checkElementsNotNull(r1);
            this.mreferences = r1;
            return this;
        }

        public Builder remover_id(Long r1) {
            this.mremover_id = r1;
            return this;
        }

        public Builder remover_type(RemoverType r1) {
            this.mremover_type = r1;
            return this;
        }

        public Builder reply_count(String r1) {
            this.mreply_count = r1;
            return this;
        }

        public Builder restricted_mode_burned_info(RestrictedModeBurnedInfo r1) {
            this.mrestricted_mode_burned_info = r1;
            return this;
        }

        public Builder root_id(String r1) {
            this.mroot_id = r1;
            return this;
        }

        public Builder root_source_message_id(String r1) {
            this.mroot_source_message_id = r1;
            return this;
        }

        public Builder send_to_chat(Boolean r1) {
            this.msend_to_chat = r1;
            return this;
        }

        public Builder sensitivity(MessageSensitivity r1) {
            this.msensitivity = r1;
            return this;
        }

        public Builder set_content_gray(Boolean r1) {
            this.mset_content_gray = r1;
            return this;
        }

        public Builder status(Status r1) {
            this.mstatus = r1;
            return this;
        }

        public Builder stream_status(StreamStatus r1) {
            this.mstream_status = r1;
            return this;
        }

        public Builder sync_to_chat_message_type(SyncToChatMessageType r1) {
            this.msync_to_chat_message_type = r1;
            return this;
        }

        public Builder sync_to_chat_related_message_id(Long r1) {
            this.msync_to_chat_related_message_id = r1;
            return this;
        }

        public Builder sync_to_chat_thread_root_id(Long r1) {
            this.msync_to_chat_thread_root_id = r1;
            return this;
        }

        public Builder thread_badge_count(Integer r1) {
            this.mthread_badge_count = r1;
            return this;
        }

        public Builder thread_id(String r1) {
            this.mthread_id = r1;
            return this;
        }

        public Builder thread_message_type(ThreadMessageType r1) {
            this.mthread_message_type = r1;
            return this;
        }

        public Builder thread_position(Integer r1) {
            this.mthread_position = r1;
            return this;
        }

        public Builder thread_reply_count(Integer r1) {
            this.mthread_reply_count = r1;
            return this;
        }

        public Builder translate_language(String r1) {
            this.mtranslate_language = r1;
            return this;
        }

        public Builder translate_message_display_rule(TranslateMessageDisplayRule r1) {
            this.mtranslate_message_display_rule = r1;
            return this;
        }

        public Builder translate_source(TranslateSource r1) {
            this.mtranslate_source = r1;
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

        public Builder url_preview_hang_point_map(Map<String, UrlPreviewHangPoint> r1) {
            Internal.checkElementsNotNull(r1);
            this.murl_preview_hang_point_map = r1;
            return this;
        }

        public Builder version(Version r1) {
            this.mversion = r1;
            return this;
        }
    }

    public static final enum ChatType extends Enum<ChatType> implements WireEnum {
        private static final /* synthetic */ ChatType[] $VALUES = null;
        public static final ProtoAdapter<ChatType> ADAPTER = null;
        public static final ChatType GROUP = null;
        public static final ChatType P2P = null;
        public static final ChatType TOPIC_GROUP = null;
        public static final ChatType UNKNOWN_CHAT_TYPE = null;
        private final int value;

        static {
            ChatType r0 = new ChatType("UNKNOWN_CHAT_TYPE", 0, 0);
            UNKNOWN_CHAT_TYPE = r0;
            ChatType r1 = new ChatType("P2P", 1, 1);
            P2P = r1;
            ChatType r3 = new ChatType("GROUP", 2, 2);
            GROUP = r3;
            ChatType r5 = new ChatType("TOPIC_GROUP", 3, 3);
            TOPIC_GROUP = r5;
            $VALUES = new ChatType[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(ChatType.class);
        }

        public static ChatType[] values() {
            return (ChatType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ChatType fromValue(int r1) {
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
            return UNKNOWN_CHAT_TYPE;
        }

        public static ChatType valueOf(String r1) {
            return (ChatType) a.a(ChatType.class, r1);
        }

        private ChatType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum ContentDeleteType extends Enum<ContentDeleteType> implements WireEnum {
        private static final /* synthetic */ ContentDeleteType[] $VALUES = null;
        public static final ProtoAdapter<ContentDeleteType> ADAPTER = null;
        public static final ContentDeleteType REMOVED = null;
        public static final ContentDeleteType REPLACED = null;
        public static final ContentDeleteType UNKNOWN_DELETE_TYPE = null;
        private final int value;

        static {
            ContentDeleteType r0 = new ContentDeleteType("UNKNOWN_DELETE_TYPE", 0, 0);
            UNKNOWN_DELETE_TYPE = r0;
            ContentDeleteType r1 = new ContentDeleteType("REMOVED", 1, 1);
            REMOVED = r1;
            ContentDeleteType r3 = new ContentDeleteType("REPLACED", 2, 2);
            REPLACED = r3;
            $VALUES = new ContentDeleteType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(ContentDeleteType.class);
        }

        public static ContentDeleteType[] values() {
            return (ContentDeleteType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ContentDeleteType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return REPLACED;
        L12:
            return REMOVED;
        L14:
            return UNKNOWN_DELETE_TYPE;
        }

        public static ContentDeleteType valueOf(String r1) {
            return (ContentDeleteType) a.a(ContentDeleteType.class, r1);
        }

        private ContentDeleteType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ContentState extends com.squareup.wire.Message<ContentState, Builder> {
        public static final ProtoAdapter<ContentState> ADAPTER = null;
        public static final Boolean DEFAULT_FILE_SHARE_PERMISSION_BLOCKED = null;
        public static final Boolean DEFAULT_IS_CLEANED = null;
        public static final Boolean DEFAULT_IS_DECRYPT_FAIL = null;
        public static final Boolean DEFAULT_IS_HYBRID_COLD = null;
        public static final Boolean DEFAULT_IS_RESTRICTED = null;
        private static final long serialVersionUID = 0;
        public final CleanType mclean_type;
        public final ContentDeleteType mcontent_delete_type;
        public final MessageDLPReviewState mdlp_review_state;
        public final Boolean mfile_share_permission_blocked;
        public final Boolean mis_cleaned;
        public final Boolean mis_decrypt_fail;
        public final Boolean mis_hybrid_cold;
        public final Boolean mis_restricted;

        public static final class Builder extends com.squareup.wire.Message.Builder<ContentState, Builder> {
            public CleanType mclean_type;
            public ContentDeleteType mcontent_delete_type;
            public MessageDLPReviewState mdlp_review_state;
            public Boolean mfile_share_permission_blocked;
            public Boolean mis_cleaned;
            public Boolean mis_decrypt_fail;
            public Boolean mis_hybrid_cold;
            public Boolean mis_restricted;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ContentState m1315build() {
                return new ContentState(this.mcontent_delete_type, this.mis_decrypt_fail, this.mdlp_review_state, this.mis_restricted, this.mfile_share_permission_blocked, this.mis_cleaned, this.mis_hybrid_cold, this.mclean_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1315build();
            }

            public Builder clean_type(CleanType r1) {
                this.mclean_type = r1;
                return this;
            }

            public Builder content_delete_type(ContentDeleteType r1) {
                this.mcontent_delete_type = r1;
                return this;
            }

            public Builder dlp_review_state(MessageDLPReviewState r1) {
                this.mdlp_review_state = r1;
                return this;
            }

            public Builder file_share_permission_blocked(Boolean r1) {
                this.mfile_share_permission_blocked = r1;
                return this;
            }

            public Builder is_cleaned(Boolean r1) {
                this.mis_cleaned = r1;
                return this;
            }

            public Builder is_decrypt_fail(Boolean r1) {
                this.mis_decrypt_fail = r1;
                return this;
            }

            public Builder is_hybrid_cold(Boolean r1) {
                this.mis_hybrid_cold = r1;
                return this;
            }

            public Builder is_restricted(Boolean r1) {
                this.mis_restricted = r1;
                return this;
            }
        }

        public static final enum CleanType extends Enum<CleanType> implements WireEnum {
            private static final /* synthetic */ CleanType[] $VALUES = null;
            public static final ProtoAdapter<CleanType> ADAPTER = null;
            public static final CleanType FreeMsgExpired = null;
            private final int value;

            static {
                CleanType r0 = new CleanType("FreeMsgExpired", 0, 1);
                FreeMsgExpired = r0;
                $VALUES = new CleanType[]{r0};
                ADAPTER = ProtoAdapter.newEnumAdapter(CleanType.class);
            }

            public static CleanType[] values() {
                return (CleanType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static CleanType fromValue(int r1) {
                if (r1 == 1) goto L7;
                return null;
            L7:
                return FreeMsgExpired;
            }

            public static CleanType valueOf(String r1) {
                return (CleanType) a.a(CleanType.class, r1);
            }

            private CleanType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_ContentState extends ProtoAdapter<ContentState> {
            public ProtoAdapter_ContentState() {
                super(FieldEncoding.LENGTH_DELIMITED, ContentState.class);
            }

            public ContentState decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.mis_decrypt_fail = r1;
                r0.mis_restricted = r1;
                r0.mfile_share_permission_blocked = r1;
                r0.mis_cleaned = r1;
                r0.mis_hybrid_cold = r1;
                long r2 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L24;
                switch(r3) {
                    case 1: goto L28;
                    case 2: goto L19;
                    case 3: goto L26;
                    case 4: goto L14;
                    case 5: goto L6;
                    case 6: goto L13;
                    case 7: goto L12;
                    case 8: goto L11;
                    case 9: goto L30;
                    default: goto L6;
                };
            L26:
                r0.mdlp_review_state = (MessageDLPReviewState) MessageDLPReviewState.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L28:
                r0.mcontent_delete_type = (ContentDeleteType) ContentDeleteType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L30:
                r0.mclean_type = (CleanType) CleanType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r0.mis_hybrid_cold = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L12:
                r0.mis_cleaned = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L13:
                r0.mfile_share_permission_blocked = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L14:
                r0.mis_restricted = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L19:
                r0.mis_decrypt_fail = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L24:
                r9.endMessage(r2);
                return r0.m1315build();
            }

            public int encodedSize(ContentState r6) {
                ContentDeleteType r0 = r6.mcontent_delete_type;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ContentDeleteType.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r6.mis_decrypt_fail;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                MessageDLPReviewState r7 = r6.mdlp_review_state;
                if (r7 == null) goto L13;
                int r8 = MessageDLPReviewState.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                Boolean r10 = r6.mis_restricted;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                Boolean r13 = r6.mfile_share_permission_blocked;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r13);
            L22:
                int r15 = r12 + r14;
                Boolean r16 = r6.mis_cleaned;
                if (r16 == null) goto L25;
                int r17 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r16);
            L26:
                int r18 = r15 + r17;
                Boolean r19 = r6.mis_hybrid_cold;
                if (r19 == null) goto L29;
                int r20 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r19);
            L30:
                int r21 = r18 + r20;
                CleanType r22 = r6.mclean_type;
                if (r22 == null) goto L34;
                r1 = CleanType.ADAPTER.encodedSizeWithTag(9, r22);
            L34:
                return (r21 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1316decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ContentState) r1);
            }

            public void encode(ProtoWriter r4, ContentState r5) throws IOException {
                ContentDeleteType r0 = r5.mcontent_delete_type;
                if (r0 == null) goto L5;
                ContentDeleteType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mis_decrypt_fail;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                MessageDLPReviewState r2 = r5.mdlp_review_state;
                if (r2 == null) goto L11;
                MessageDLPReviewState.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                Boolean r3 = r5.mis_restricted;
                if (r3 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
            L14:
                Boolean r6 = r5.mfile_share_permission_blocked;
                if (r6 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r4, 6, r6);
            L17:
                Boolean r7 = r5.mis_cleaned;
                if (r7 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r4, 7, r7);
            L20:
                Boolean r8 = r5.mis_hybrid_cold;
                if (r8 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r4, 8, r8);
            L23:
                CleanType r9 = r5.mclean_type;
                if (r9 == null) goto L26;
                CleanType.ADAPTER.encodeWithTag(r4, 9, r9);
            L26:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ContentState) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ContentState();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_IS_DECRYPT_FAIL = r0;
            DEFAULT_IS_RESTRICTED = r0;
            DEFAULT_FILE_SHARE_PERMISSION_BLOCKED = r0;
            DEFAULT_IS_CLEANED = r0;
            DEFAULT_IS_HYBRID_COLD = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1314newBuilder() {
            Builder r0 = new Builder();
            r0.mcontent_delete_type = this.mcontent_delete_type;
            r0.mis_decrypt_fail = this.mis_decrypt_fail;
            r0.mdlp_review_state = this.mdlp_review_state;
            r0.mis_restricted = this.mis_restricted;
            r0.mfile_share_permission_blocked = this.mfile_share_permission_blocked;
            r0.mis_cleaned = this.mis_cleaned;
            r0.mis_hybrid_cold = this.mis_hybrid_cold;
            r0.mclean_type = this.mclean_type;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ContentState.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1314newBuilder();
        }

        public ContentState(ContentDeleteType r11, Boolean r12, MessageDLPReviewState r13, Boolean r14, Boolean r15, Boolean r16, Boolean r17, CleanType r18) {
            this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
        }

        public ContentState(ContentDeleteType r2, Boolean r3, MessageDLPReviewState r4, Boolean r5, Boolean r6, Boolean r7, Boolean r8, CleanType r9, ByteString r10) {
            super(ADAPTER, r10);
            this.mcontent_delete_type = r2;
            this.mis_decrypt_fail = r3;
            this.mdlp_review_state = r4;
            this.mis_restricted = r5;
            this.mfile_share_permission_blocked = r6;
            this.mis_cleaned = r7;
            this.mis_hybrid_cold = r8;
            this.mclean_type = r9;
        }
    }

    public static final class DisabledAction extends com.squareup.wire.Message<DisabledAction, Builder> {
        public static final ProtoAdapter<DisabledAction> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<Integer, Behavior> mactions;

        public static final enum Action extends Enum<Action> implements WireEnum {
            private static final /* synthetic */ Action[] $VALUES = null;
            public static final ProtoAdapter<Action> ADAPTER = null;
            public static final Action ADD_STICKER = null;
            public static final Action ADD_TASK = null;
            public static final Action ALL_ACTION = null;
            public static final Action CHAT_PIN = null;
            public static final Action CLIP_TO_TOP = null;
            public static final Action COPY = null;
            public static final Action COPY_MESSAGE_LINK = null;
            public static final Action DELETE = null;
            public static final Action DERIVE = null;
            public static final Action DOWNLOAD = null;
            public static final Action EDIT_MESSAGE = null;
            public static final Action FAVORITE = null;
            public static final Action FLAG = null;
            public static final Action MULTI_SELECT = null;
            public static final Action PIN = null;
            public static final Action REACTION = null;
            public static final Action RECALL = null;
            public static final Action REPLY = null;
            public static final Action REPLY_IN_THREAD = null;
            public static final Action SAVE_TO_LOCAL = null;
            public static final Action SAVE_TO_SPACE = null;
            public static final Action SEND_URGENT = null;
            public static final Action TRANSLATE = null;
            public static final Action TRANSMIT = null;
            public static final Action UNKNOWN_ACTION = null;
            public static final Action WIDGETS = null;
            private final int value;

            static {
                Action r0 = new Action("UNKNOWN_ACTION", 0, 0);
                UNKNOWN_ACTION = r0;
                Action r1 = new Action("ALL_ACTION", 1, 1);
                ALL_ACTION = r1;
                Action r3 = new Action("REACTION", 2, 2);
                REACTION = r3;
                Action r5 = new Action("REPLY", 3, 3);
                REPLY = r5;
                Action r7 = new Action("TRANSMIT", 4, 4);
                TRANSMIT = r7;
                Action r9 = new Action("REPLY_IN_THREAD", 5, 5);
                REPLY_IN_THREAD = r9;
                Action r11 = new Action("SEND_URGENT", 6, 6);
                SEND_URGENT = r11;
                Action r13 = new Action("RECALL", 7, 7);
                RECALL = r13;
                Action r15 = new Action("EDIT_MESSAGE", 8, 8);
                EDIT_MESSAGE = r15;
                Action r14 = new Action("MULTI_SELECT", 9, 9);
                MULTI_SELECT = r14;
                Action r12 = new Action("FLAG", 10, 10);
                FLAG = r12;
                Action r10 = new Action("FAVORITE", 11, 11);
                FAVORITE = r10;
                Action r8 = new Action("PIN", 12, 12);
                PIN = r8;
                Action r6 = new Action("CLIP_TO_TOP", 13, 13);
                CLIP_TO_TOP = r6;
                Action r4 = new Action("ADD_TASK", 14, 14);
                ADD_TASK = r4;
                Action r2 = new Action("TRANSLATE", 15, 15);
                TRANSLATE = r2;
                Action r16 = new Action("DELETE", 16, 16);
                DELETE = r16;
                Action r17 = new Action("SAVE_TO_LOCAL", 17, 17);
                SAVE_TO_LOCAL = r17;
                Action r18 = new Action("SAVE_TO_SPACE", 18, 18);
                SAVE_TO_SPACE = r18;
                Action r19 = new Action("ADD_STICKER", 19, 19);
                ADD_STICKER = r19;
                Action r20 = new Action("DOWNLOAD", 20, 20);
                DOWNLOAD = r20;
                Action r21 = new Action("COPY", 21, 21);
                COPY = r21;
                Action r22 = new Action("COPY_MESSAGE_LINK", 22, 22);
                COPY_MESSAGE_LINK = r22;
                Action r23 = new Action("WIDGETS", 23, 23);
                WIDGETS = r23;
                Action r24 = new Action("CHAT_PIN", 24, 24);
                CHAT_PIN = r24;
                Action r25 = new Action("DERIVE", 25, 25);
                DERIVE = r25;
                $VALUES = new Action[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25};
                ADAPTER = ProtoAdapter.newEnumAdapter(Action.class);
            }

            public static Action[] values() {
                return (Action[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Action fromValue(int r0) {
                switch(r0) {
                    case 0: goto L56;
                    case 1: goto L54;
                    case 2: goto L52;
                    case 3: goto L50;
                    case 4: goto L48;
                    case 5: goto L46;
                    case 6: goto L44;
                    case 7: goto L42;
                    case 8: goto L40;
                    case 9: goto L38;
                    case 10: goto L36;
                    case 11: goto L34;
                    case 12: goto L32;
                    case 13: goto L30;
                    case 14: goto L28;
                    case 15: goto L26;
                    case 16: goto L24;
                    case 17: goto L22;
                    case 18: goto L20;
                    case 19: goto L18;
                    case 20: goto L16;
                    case 21: goto L14;
                    case 22: goto L12;
                    case 23: goto L10;
                    case 24: goto L8;
                    case 25: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return DERIVE;
            L8:
                return CHAT_PIN;
            L10:
                return WIDGETS;
            L12:
                return COPY_MESSAGE_LINK;
            L14:
                return COPY;
            L16:
                return DOWNLOAD;
            L18:
                return ADD_STICKER;
            L20:
                return SAVE_TO_SPACE;
            L22:
                return SAVE_TO_LOCAL;
            L24:
                return DELETE;
            L26:
                return TRANSLATE;
            L28:
                return ADD_TASK;
            L30:
                return CLIP_TO_TOP;
            L32:
                return PIN;
            L34:
                return FAVORITE;
            L36:
                return FLAG;
            L38:
                return MULTI_SELECT;
            L40:
                return EDIT_MESSAGE;
            L42:
                return RECALL;
            L44:
                return SEND_URGENT;
            L46:
                return REPLY_IN_THREAD;
            L48:
                return TRANSMIT;
            L50:
                return REPLY;
            L52:
                return REACTION;
            L54:
                return ALL_ACTION;
            L56:
                return UNKNOWN_ACTION;
            }

            public static Action valueOf(String r1) {
                return (Action) a.a(Action.class, r1);
            }

            private Action(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class Behavior extends com.squareup.wire.Message<Behavior, Builder> {
            public static final ProtoAdapter<Behavior> ADAPTER = null;
            public static final Integer DEFAULT_CODE = null;
            private static final long serialVersionUID = 0;
            public final Integer mcode;
            public final DisplayMode mdisplay_mode;

            public static final class Builder extends com.squareup.wire.Message.Builder<Behavior, Builder> {
                public Integer mcode;
                public DisplayMode mdisplay_mode;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public Behavior m1319build() {
                    return new Behavior(this.mdisplay_mode, this.mcode, super.buildUnknownFields());
                }

                public Builder() {
                }

                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return m1319build();
                }

                public Builder code(Integer r1) {
                    this.mcode = r1;
                    return this;
                }

                public Builder display_mode(DisplayMode r1) {
                    this.mdisplay_mode = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_Behavior extends ProtoAdapter<Behavior> {
                public ProtoAdapter_Behavior() {
                    super(FieldEncoding.LENGTH_DELIMITED, Behavior.class);
                }

                public Behavior decode(ProtoReader r9) throws IOException {
                    Builder r0 = new Builder();
                    r0.mcode = 0;
                    long r1 = r9.beginMessage();
                L3:
                    int r3 = r9.nextTag();
                    if (r3 == (-1)) goto L15;
                    if (r3 != 1) goto L8;
                    r0.mdisplay_mode = (DisplayMode) DisplayMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
                L13:
                    e = move-exception;
                    r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L8:
                    if (r3 != 2) goto L9;
                    r0.mcode = (Integer) ProtoAdapter.INT32.decode(r9);
                    goto L3
                L9:
                    FieldEncoding r4 = r9.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                    goto L3
                L15:
                    r9.endMessage(r1);
                    return r0.m1319build();
                }

                public int encodedSize(Behavior r5) {
                    DisplayMode r0 = r5.mdisplay_mode;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = DisplayMode.ADAPTER.encodedSizeWithTag(1, r0);
                L6:
                    Integer r3 = r5.mcode;
                    if (r3 == null) goto L10;
                    r1 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
                L10:
                    return (r2 + r1) + r5.unknownFields().size();
                L5:
                    r2 = 0;
                    goto L6
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m1320decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((Behavior) r1);
                }

                public void encode(ProtoWriter r4, Behavior r5) throws IOException {
                    DisplayMode r0 = r5.mdisplay_mode;
                    if (r0 == null) goto L5;
                    DisplayMode.ADAPTER.encodeWithTag(r4, 1, r0);
                L5:
                    Integer r1 = r5.mcode;
                    if (r1 == null) goto L8;
                    ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
                L8:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (Behavior) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Behavior();
                DEFAULT_CODE = 0;
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1318newBuilder() {
                Builder r0 = new Builder();
                r0.mdisplay_mode = this.mdisplay_mode;
                r0.mcode = this.mcode;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return Behavior.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return m1318newBuilder();
            }

            public Behavior(DisplayMode r2, Integer r3) {
                this(r2, r3, ByteString.EMPTY);
            }

            public Behavior(DisplayMode r2, Integer r3, ByteString r4) {
                super(ADAPTER, r4);
                this.mdisplay_mode = r2;
                this.mcode = r3;
            }
        }

        public static final class Builder extends com.squareup.wire.Message.Builder<DisabledAction, Builder> {
            public Map<Integer, Behavior> mactions;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DisabledAction m1321build() {
                return new DisabledAction(this.mactions, super.buildUnknownFields());
            }

            public Builder() {
                this.mactions = Internal.newMutableMap();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1321build();
            }

            public Builder actions(Map<Integer, Behavior> r1) {
                Internal.checkElementsNotNull(r1);
                this.mactions = r1;
                return this;
            }
        }

        public static final enum DisplayMode extends Enum<DisplayMode> implements WireEnum {
            private static final /* synthetic */ DisplayMode[] $VALUES = null;
            public static final ProtoAdapter<DisplayMode> ADAPTER = null;
            public static final DisplayMode DISABLE = null;
            public static final DisplayMode INVISIBLE = null;
            public static final DisplayMode UNKNOWN_MODE = null;
            private final int value;

            static {
                DisplayMode r0 = new DisplayMode("UNKNOWN_MODE", 0, 0);
                UNKNOWN_MODE = r0;
                DisplayMode r1 = new DisplayMode("DISABLE", 1, 1);
                DISABLE = r1;
                DisplayMode r3 = new DisplayMode("INVISIBLE", 2, 2);
                INVISIBLE = r3;
                $VALUES = new DisplayMode[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(DisplayMode.class);
            }

            public static DisplayMode[] values() {
                return (DisplayMode[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static DisplayMode fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return INVISIBLE;
            L12:
                return DISABLE;
            L14:
                return UNKNOWN_MODE;
            }

            public static DisplayMode valueOf(String r1) {
                return (DisplayMode) a.a(DisplayMode.class, r1);
            }

            private DisplayMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_DisabledAction extends ProtoAdapter<DisabledAction> {
            private final ProtoAdapter<Map<Integer, Behavior>> mactions;

            public ProtoAdapter_DisabledAction() {
                super(FieldEncoding.LENGTH_DELIMITED, DisabledAction.class);
                this.mactions = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, Behavior.ADAPTER);
            }

            public DisabledAction decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mactions.putAll((Map) this.mactions.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1321build();
            }

            public int encodedSize(DisabledAction r4) {
                return this.mactions.encodedSizeWithTag(1, r4.mactions) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1322decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DisabledAction) r1);
            }

            public void encode(ProtoWriter r4, DisabledAction r5) throws IOException {
                this.mactions.encodeWithTag(r4, 1, r5.mactions);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DisabledAction) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DisabledAction();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1317newBuilder() {
            Builder r0 = new Builder();
            r0.mactions = Internal.copyOf("mactions", this.mactions);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DisabledAction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1317newBuilder();
        }

        public DisabledAction(Map<Integer, Behavior> r2) {
            this(r2, ByteString.EMPTY);
        }

        public DisabledAction(Map<Integer, Behavior> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mactions = Internal.immutableCopyOf("mactions", r2);
        }
    }

    public static final enum DisplayMode extends Enum<DisplayMode> implements WireEnum {
        private static final /* synthetic */ DisplayMode[] $VALUES = null;
        public static final ProtoAdapter<DisplayMode> ADAPTER = null;
        public static final DisplayMode DEFAULT_DISPLAY_MODE = null;
        public static final DisplayMode THREAD_DISPLAY_MODE = null;
        public static final DisplayMode UNKNOWN_DISPLAY_MODE = null;
        private final int value;

        static {
            DisplayMode r0 = new DisplayMode("UNKNOWN_DISPLAY_MODE", 0, 0);
            UNKNOWN_DISPLAY_MODE = r0;
            DisplayMode r1 = new DisplayMode("DEFAULT_DISPLAY_MODE", 1, 1);
            DEFAULT_DISPLAY_MODE = r1;
            DisplayMode r3 = new DisplayMode("THREAD_DISPLAY_MODE", 2, 2);
            THREAD_DISPLAY_MODE = r3;
            $VALUES = new DisplayMode[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(DisplayMode.class);
        }

        public static DisplayMode[] values() {
            return (DisplayMode[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static DisplayMode fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return THREAD_DISPLAY_MODE;
        L12:
            return DEFAULT_DISPLAY_MODE;
        L14:
            return UNKNOWN_DISPLAY_MODE;
        }

        public static DisplayMode valueOf(String r1) {
            return (DisplayMode) a.a(DisplayMode.class, r1);
        }

        private DisplayMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class DoubaoAppShowInfo extends com.squareup.wire.Message<DoubaoAppShowInfo, Builder> {
        public static final ProtoAdapter<DoubaoAppShowInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final JoinChatInfo mjoin_chat_info;
        public final NewContactInfo mnew_contact_info;

        public static final class Builder extends com.squareup.wire.Message.Builder<DoubaoAppShowInfo, Builder> {
            public JoinChatInfo mjoin_chat_info;
            public NewContactInfo mnew_contact_info;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DoubaoAppShowInfo m1324build() {
                return new DoubaoAppShowInfo(this.mnew_contact_info, this.mjoin_chat_info, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1324build();
            }

            public Builder join_chat_info(JoinChatInfo r1) {
                this.mjoin_chat_info = r1;
                this.mnew_contact_info = null;
                return this;
            }

            public Builder new_contact_info(NewContactInfo r1) {
                this.mnew_contact_info = r1;
                this.mjoin_chat_info = null;
                return this;
            }
        }

        public static final class JoinChatInfo extends com.squareup.wire.Message<JoinChatInfo, Builder> {
            public static final ProtoAdapter<JoinChatInfo> ADAPTER = null;
            public static final Long DEFAULT_INVITER_USER_ID = null;
            public static final Long DEFAULT_JOIN_SYSTEM_CONTENT_TYPE = null;
            public static final String DEFAULT_JOIN_SYSTEM_CONTENT_TYPE_TEMPLATE = "";
            public static final Long DEFAULT_STRANGER_SYSTEM_CONTENT_TYPE = null;
            public static final String DEFAULT_STRANGER_SYSTEM_CONTENT_TYPE_TEMPLATE = "";
            private static final long serialVersionUID = 0;
            public final List<Long> minvitee_user_ids;
            public final Long minviter_user_id;
            public final Long mjoin_system_content_type;
            public final String mjoin_system_content_type_template;
            public final Long mstranger_system_content_type;
            public final String mstranger_system_content_type_template;
            public final List<Long> mstranger_user_ids;

            public static final class Builder extends com.squareup.wire.Message.Builder<JoinChatInfo, Builder> {
                public List<Long> minvitee_user_ids;
                public Long minviter_user_id;
                public Long mjoin_system_content_type;
                public String mjoin_system_content_type_template;
                public Long mstranger_system_content_type;
                public String mstranger_system_content_type_template;
                public List<Long> mstranger_user_ids;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public JoinChatInfo m1326build() {
                    return new JoinChatInfo(this.minviter_user_id, this.minvitee_user_ids, this.mstranger_user_ids, this.mjoin_system_content_type, this.mstranger_system_content_type, this.mjoin_system_content_type_template, this.mstranger_system_content_type_template, super.buildUnknownFields());
                }

                public Builder() {
                    this.minvitee_user_ids = Internal.newMutableList();
                    this.mstranger_user_ids = Internal.newMutableList();
                }

                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return m1326build();
                }

                public Builder invitee_user_ids(List<Long> r1) {
                    Internal.checkElementsNotNull(r1);
                    this.minvitee_user_ids = r1;
                    return this;
                }

                public Builder inviter_user_id(Long r1) {
                    this.minviter_user_id = r1;
                    return this;
                }

                public Builder join_system_content_type(Long r1) {
                    this.mjoin_system_content_type = r1;
                    return this;
                }

                public Builder join_system_content_type_template(String r1) {
                    this.mjoin_system_content_type_template = r1;
                    return this;
                }

                public Builder stranger_system_content_type(Long r1) {
                    this.mstranger_system_content_type = r1;
                    return this;
                }

                public Builder stranger_system_content_type_template(String r1) {
                    this.mstranger_system_content_type_template = r1;
                    return this;
                }

                public Builder stranger_user_ids(List<Long> r1) {
                    Internal.checkElementsNotNull(r1);
                    this.mstranger_user_ids = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_JoinChatInfo extends ProtoAdapter<JoinChatInfo> {
                public ProtoAdapter_JoinChatInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, JoinChatInfo.class);
                }

                public JoinChatInfo decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.minviter_user_id = 0L;
                    r0.mjoin_system_content_type = 0L;
                    r0.mstranger_system_content_type = 0L;
                    r0.mjoin_system_content_type_template = "";
                    r0.mstranger_system_content_type_template = "";
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L14;
                    switch(r3) {
                        case 1: goto L13;
                        case 2: goto L12;
                        case 3: goto L11;
                        case 4: goto L10;
                        case 5: goto L9;
                        case 6: goto L8;
                        case 7: goto L7;
                        default: goto L6;
                    };
                L7:
                    r0.mstranger_system_content_type_template = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L8:
                    r0.mjoin_system_content_type_template = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L9:
                    r0.mstranger_system_content_type = (Long) ProtoAdapter.INT64.decode(r7);
                    goto L3
                L10:
                    r0.mjoin_system_content_type = (Long) ProtoAdapter.INT64.decode(r7);
                    goto L3
                L11:
                    r0.mstranger_user_ids.add((Long) ProtoAdapter.INT64.decode(r7));
                    goto L3
                L12:
                    r0.minvitee_user_ids.add((Long) ProtoAdapter.INT64.decode(r7));
                    goto L3
                L13:
                    r0.minviter_user_id = (Long) ProtoAdapter.INT64.decode(r7);
                    goto L3
                L6:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L14:
                    r7.endMessage(r1);
                    return r0.m1326build();
                }

                public int encodedSize(JoinChatInfo r7) {
                    Long r0 = r7.minviter_user_id;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
                L6:
                    ProtoAdapter r3 = ProtoAdapter.INT64;
                    int r4 = (r2 + r3.asRepeated().encodedSizeWithTag(2, r7.minvitee_user_ids)) + r3.asRepeated().encodedSizeWithTag(3, r7.mstranger_user_ids);
                    Long r5 = r7.mjoin_system_content_type;
                    if (r5 == null) goto L9;
                    int r6 = r3.encodedSizeWithTag(4, r5);
                L10:
                    int r8 = r4 + r6;
                    Long r9 = r7.mstranger_system_content_type;
                    if (r9 == null) goto L13;
                    int r10 = r3.encodedSizeWithTag(5, r9);
                L14:
                    int r11 = r8 + r10;
                    String r12 = r7.mjoin_system_content_type_template;
                    if (r12 == null) goto L17;
                    int r13 = ProtoAdapter.STRING.encodedSizeWithTag(6, r12);
                L18:
                    int r14 = r11 + r13;
                    String r15 = r7.mstranger_system_content_type_template;
                    if (r15 == null) goto L22;
                    r1 = ProtoAdapter.STRING.encodedSizeWithTag(7, r15);
                L22:
                    return (r14 + r1) + r7.unknownFields().size();
                L17:
                    r13 = 0;
                    goto L18
                L13:
                    r10 = 0;
                    goto L14
                L9:
                    r6 = 0;
                    goto L10
                L5:
                    r2 = 0;
                    goto L6
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m1327decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((JoinChatInfo) r1);
                }

                public void encode(ProtoWriter r5, JoinChatInfo r6) throws IOException {
                    Long r0 = r6.minviter_user_id;
                    if (r0 == null) goto L5;
                    ProtoAdapter.INT64.encodeWithTag(r5, 1, r0);
                L5:
                    ProtoAdapter r1 = ProtoAdapter.INT64;
                    r1.asRepeated().encodeWithTag(r5, 2, r6.minvitee_user_ids);
                    r1.asRepeated().encodeWithTag(r5, 3, r6.mstranger_user_ids);
                    Long r2 = r6.mjoin_system_content_type;
                    if (r2 == null) goto L8;
                    r1.encodeWithTag(r5, 4, r2);
                L8:
                    Long r3 = r6.mstranger_system_content_type;
                    if (r3 == null) goto L11;
                    r1.encodeWithTag(r5, 5, r3);
                L11:
                    String r4 = r6.mjoin_system_content_type_template;
                    if (r4 == null) goto L14;
                    ProtoAdapter.STRING.encodeWithTag(r5, 6, r4);
                L14:
                    String r7 = r6.mstranger_system_content_type_template;
                    if (r7 == null) goto L17;
                    ProtoAdapter.STRING.encodeWithTag(r5, 7, r7);
                L17:
                    r5.writeBytes(r6.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (JoinChatInfo) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_JoinChatInfo();
                DEFAULT_INVITER_USER_ID = 0L;
                DEFAULT_JOIN_SYSTEM_CONTENT_TYPE = 0L;
                DEFAULT_STRANGER_SYSTEM_CONTENT_TYPE = 0L;
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1325newBuilder() {
                Builder r0 = new Builder();
                r0.minviter_user_id = this.minviter_user_id;
                r0.minvitee_user_ids = Internal.copyOf("minvitee_user_ids", this.minvitee_user_ids);
                r0.mstranger_user_ids = Internal.copyOf("mstranger_user_ids", this.mstranger_user_ids);
                r0.mjoin_system_content_type = this.mjoin_system_content_type;
                r0.mstranger_system_content_type = this.mstranger_system_content_type;
                r0.mjoin_system_content_type_template = this.mjoin_system_content_type_template;
                r0.mstranger_system_content_type_template = this.mstranger_system_content_type_template;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return JoinChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return m1325newBuilder();
            }

            public JoinChatInfo(Long r10, List<Long> r11, List<Long> r12, Long r13, Long r14, String r15, String r16) {
                this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
            }

            public JoinChatInfo(Long r2, List<Long> r3, List<Long> r4, Long r5, Long r6, String r7, String r8, ByteString r9) {
                super(ADAPTER, r9);
                this.minviter_user_id = r2;
                this.minvitee_user_ids = Internal.immutableCopyOf("minvitee_user_ids", r3);
                this.mstranger_user_ids = Internal.immutableCopyOf("mstranger_user_ids", r4);
                this.mjoin_system_content_type = r5;
                this.mstranger_system_content_type = r6;
                this.mjoin_system_content_type_template = r7;
                this.mstranger_system_content_type_template = r8;
            }
        }

        public static final class NewContactInfo extends com.squareup.wire.Message<NewContactInfo, Builder> {
            public static final ProtoAdapter<NewContactInfo> ADAPTER = null;
            public static final Long DEFAULT_PASS_SYSTEM_CONTENT_TYPE = null;
            public static final String DEFAULT_PASS_SYSTEM_CONTENT_TYPE_TEMPLATE = "";
            public static final Long DEFAULT_READ_SYSTEM_CONTENT_TYPE = null;
            public static final String DEFAULT_READ_SYSTEM_CONTENT_TYPE_TEMPLATE = "";
            public static final Long DEFAULT_RECEIVER_USER_ID = null;
            public static final Long DEFAULT_SENDER_USER_ID = null;
            private static final long serialVersionUID = 0;
            public final Long mpass_system_content_type;
            public final String mpass_system_content_type_template;
            public final Long mread_system_content_type;
            public final String mread_system_content_type_template;
            public final Long mreceiver_user_id;
            public final Long msender_user_id;

            public static final class Builder extends com.squareup.wire.Message.Builder<NewContactInfo, Builder> {
                public Long mpass_system_content_type;
                public String mpass_system_content_type_template;
                public Long mread_system_content_type;
                public String mread_system_content_type_template;
                public Long mreceiver_user_id;
                public Long msender_user_id;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public NewContactInfo m1329build() {
                    return new NewContactInfo(this.msender_user_id, this.mreceiver_user_id, this.mpass_system_content_type, this.mread_system_content_type, this.mpass_system_content_type_template, this.mread_system_content_type_template, super.buildUnknownFields());
                }

                public Builder() {
                }

                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return m1329build();
                }

                public Builder pass_system_content_type(Long r1) {
                    this.mpass_system_content_type = r1;
                    return this;
                }

                public Builder pass_system_content_type_template(String r1) {
                    this.mpass_system_content_type_template = r1;
                    return this;
                }

                public Builder read_system_content_type(Long r1) {
                    this.mread_system_content_type = r1;
                    return this;
                }

                public Builder read_system_content_type_template(String r1) {
                    this.mread_system_content_type_template = r1;
                    return this;
                }

                public Builder receiver_user_id(Long r1) {
                    this.mreceiver_user_id = r1;
                    return this;
                }

                public Builder sender_user_id(Long r1) {
                    this.msender_user_id = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_NewContactInfo extends ProtoAdapter<NewContactInfo> {
                public ProtoAdapter_NewContactInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, NewContactInfo.class);
                }

                public NewContactInfo decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.msender_user_id = 0L;
                    r0.mreceiver_user_id = 0L;
                    r0.mpass_system_content_type = 0L;
                    r0.mread_system_content_type = 0L;
                    r0.mpass_system_content_type_template = "";
                    r0.mread_system_content_type_template = "";
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
                    r0.mread_system_content_type_template = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L8:
                    r0.mpass_system_content_type_template = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L9:
                    r0.mread_system_content_type = (Long) ProtoAdapter.INT64.decode(r7);
                    goto L3
                L10:
                    r0.mpass_system_content_type = (Long) ProtoAdapter.INT64.decode(r7);
                    goto L3
                L11:
                    r0.mreceiver_user_id = (Long) ProtoAdapter.INT64.decode(r7);
                    goto L3
                L12:
                    r0.msender_user_id = (Long) ProtoAdapter.INT64.decode(r7);
                    goto L3
                L6:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L13:
                    r7.endMessage(r1);
                    return r0.m1329build();
                }

                public int encodedSize(NewContactInfo r6) {
                    Long r0 = r6.msender_user_id;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
                L6:
                    Long r3 = r6.mreceiver_user_id;
                    if (r3 == null) goto L9;
                    int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
                L10:
                    int r5 = r2 + r4;
                    Long r7 = r6.mpass_system_content_type;
                    if (r7 == null) goto L13;
                    int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
                L14:
                    int r9 = r5 + r8;
                    Long r10 = r6.mread_system_content_type;
                    if (r10 == null) goto L17;
                    int r11 = ProtoAdapter.INT64.encodedSizeWithTag(4, r10);
                L18:
                    int r12 = r9 + r11;
                    String r13 = r6.mpass_system_content_type_template;
                    if (r13 == null) goto L21;
                    int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
                L22:
                    int r15 = r12 + r14;
                    String r16 = r6.mread_system_content_type_template;
                    if (r16 == null) goto L26;
                    r1 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
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
                public /* bridge */ /* synthetic */ Object m1330decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((NewContactInfo) r1);
                }

                public void encode(ProtoWriter r4, NewContactInfo r5) throws IOException {
                    Long r0 = r5.msender_user_id;
                    if (r0 == null) goto L5;
                    ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
                L5:
                    Long r1 = r5.mreceiver_user_id;
                    if (r1 == null) goto L8;
                    ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
                L8:
                    Long r2 = r5.mpass_system_content_type;
                    if (r2 == null) goto L11;
                    ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
                L11:
                    Long r3 = r5.mread_system_content_type;
                    if (r3 == null) goto L14;
                    ProtoAdapter.INT64.encodeWithTag(r4, 4, r3);
                L14:
                    String r6 = r5.mpass_system_content_type_template;
                    if (r6 == null) goto L17;
                    ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
                L17:
                    String r7 = r5.mread_system_content_type_template;
                    if (r7 == null) goto L20;
                    ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
                L20:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (NewContactInfo) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_NewContactInfo();
                DEFAULT_SENDER_USER_ID = 0L;
                DEFAULT_RECEIVER_USER_ID = 0L;
                DEFAULT_PASS_SYSTEM_CONTENT_TYPE = 0L;
                DEFAULT_READ_SYSTEM_CONTENT_TYPE = 0L;
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1328newBuilder() {
                Builder r0 = new Builder();
                r0.msender_user_id = this.msender_user_id;
                r0.mreceiver_user_id = this.mreceiver_user_id;
                r0.mpass_system_content_type = this.mpass_system_content_type;
                r0.mread_system_content_type = this.mread_system_content_type;
                r0.mpass_system_content_type_template = this.mpass_system_content_type_template;
                r0.mread_system_content_type_template = this.mread_system_content_type_template;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return NewContactInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return m1328newBuilder();
            }

            public NewContactInfo(Long r9, Long r10, Long r11, Long r12, String r13, String r14) {
                this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
            }

            public NewContactInfo(Long r2, Long r3, Long r4, Long r5, String r6, String r7, ByteString r8) {
                super(ADAPTER, r8);
                this.msender_user_id = r2;
                this.mreceiver_user_id = r3;
                this.mpass_system_content_type = r4;
                this.mread_system_content_type = r5;
                this.mpass_system_content_type_template = r6;
                this.mread_system_content_type_template = r7;
            }
        }

        public static final class ProtoAdapter_DoubaoAppShowInfo extends ProtoAdapter<DoubaoAppShowInfo> {
            public ProtoAdapter_DoubaoAppShowInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, DoubaoAppShowInfo.class);
            }

            public DoubaoAppShowInfo decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.new_contact_info((NewContactInfo) NewContactInfo.ADAPTER.decode(r7));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.join_chat_info((JoinChatInfo) JoinChatInfo.ADAPTER.decode(r7));
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1324build();
            }

            public int encodedSize(DoubaoAppShowInfo r5) {
                NewContactInfo r0 = r5.mnew_contact_info;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = NewContactInfo.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                JoinChatInfo r3 = r5.mjoin_chat_info;
                if (r3 == null) goto L10;
                r1 = JoinChatInfo.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1331decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DoubaoAppShowInfo) r1);
            }

            public void encode(ProtoWriter r4, DoubaoAppShowInfo r5) throws IOException {
                NewContactInfo r0 = r5.mnew_contact_info;
                if (r0 == null) goto L5;
                NewContactInfo.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                JoinChatInfo r1 = r5.mjoin_chat_info;
                if (r1 == null) goto L8;
                JoinChatInfo.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DoubaoAppShowInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DoubaoAppShowInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1323newBuilder() {
            Builder r0 = new Builder();
            r0.mnew_contact_info = this.mnew_contact_info;
            r0.mjoin_chat_info = this.mjoin_chat_info;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DoubaoAppShowInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1323newBuilder();
        }

        public DoubaoAppShowInfo(NewContactInfo r2, JoinChatInfo r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public DoubaoAppShowInfo(NewContactInfo r2, JoinChatInfo r3, ByteString r4) {
            super(ADAPTER, r4);
            if (Internal.countNonNull(r2, r3) > 1) goto L7;
            this.mnew_contact_info = r2;
            this.mjoin_chat_info = r3;
            return;
        L7:
            throw new IllegalArgumentException("at most one of mnew_contact_info, mjoin_chat_info may be non-null");
        }
    }

    public static final enum FromType extends Enum<FromType> implements WireEnum {
        private static final /* synthetic */ FromType[] $VALUES = null;
        public static final ProtoAdapter<FromType> ADAPTER = null;
        public static final FromType BOT = null;
        public static final FromType USER = null;
        private final int value;

        static {
            FromType r0 = new FromType("USER", 0, 1);
            USER = r0;
            FromType r1 = new FromType("BOT", 1, 2);
            BOT = r1;
            $VALUES = new FromType[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(FromType.class);
        }

        public static FromType[] values() {
            return (FromType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FromType fromValue(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return null;
        L9:
            return BOT;
        L11:
            return USER;
        }

        public static FromType valueOf(String r1) {
            return (FromType) a.a(FromType.class, r1);
        }

        private FromType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum MessageAttachmentType extends Enum<MessageAttachmentType> implements WireEnum {
        private static final /* synthetic */ MessageAttachmentType[] $VALUES = null;
        public static final ProtoAdapter<MessageAttachmentType> ADAPTER = null;
        public static final MessageAttachmentType ATTACHMENT_FILE = null;
        public static final MessageAttachmentType ATTACHMENT_FOLDER = null;
        public static final MessageAttachmentType ATTACHMENT_IMAGE = null;
        public static final MessageAttachmentType ATTACHMENT_LINK = null;
        public static final MessageAttachmentType ATTACHMENT_POST_FILE = null;
        public static final MessageAttachmentType ATTACHMENT_VIDEO = null;
        public static final MessageAttachmentType UNKNOWN_ATTACHMENT_TYPE = null;
        private final int value;

        static {
            MessageAttachmentType r0 = new MessageAttachmentType("UNKNOWN_ATTACHMENT_TYPE", 0, 0);
            UNKNOWN_ATTACHMENT_TYPE = r0;
            MessageAttachmentType r1 = new MessageAttachmentType("ATTACHMENT_IMAGE", 1, 1);
            ATTACHMENT_IMAGE = r1;
            MessageAttachmentType r3 = new MessageAttachmentType("ATTACHMENT_VIDEO", 2, 2);
            ATTACHMENT_VIDEO = r3;
            MessageAttachmentType r5 = new MessageAttachmentType("ATTACHMENT_FILE", 3, 3);
            ATTACHMENT_FILE = r5;
            MessageAttachmentType r7 = new MessageAttachmentType("ATTACHMENT_LINK", 4, 4);
            ATTACHMENT_LINK = r7;
            MessageAttachmentType r9 = new MessageAttachmentType("ATTACHMENT_FOLDER", 5, 5);
            ATTACHMENT_FOLDER = r9;
            MessageAttachmentType r11 = new MessageAttachmentType("ATTACHMENT_POST_FILE", 6, 6);
            ATTACHMENT_POST_FILE = r11;
            $VALUES = new MessageAttachmentType[]{r0, r1, r3, r5, r7, r9, r11};
            ADAPTER = ProtoAdapter.newEnumAdapter(MessageAttachmentType.class);
        }

        public static MessageAttachmentType[] values() {
            return (MessageAttachmentType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static MessageAttachmentType fromValue(int r0) {
            switch(r0) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return ATTACHMENT_POST_FILE;
        L8:
            return ATTACHMENT_FOLDER;
        L10:
            return ATTACHMENT_LINK;
        L12:
            return ATTACHMENT_FILE;
        L14:
            return ATTACHMENT_VIDEO;
        L16:
            return ATTACHMENT_IMAGE;
        L18:
            return UNKNOWN_ATTACHMENT_TYPE;
        }

        public static MessageAttachmentType valueOf(String r1) {
            return (MessageAttachmentType) a.a(MessageAttachmentType.class, r1);
        }

        private MessageAttachmentType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum MessageDLPReviewState extends Enum<MessageDLPReviewState> implements WireEnum {
        private static final /* synthetic */ MessageDLPReviewState[] $VALUES = null;
        public static final ProtoAdapter<MessageDLPReviewState> ADAPTER = null;
        public static final MessageDLPReviewState BLOCK = null;
        public static final MessageDLPReviewState INACTIVE = null;
        public static final MessageDLPReviewState IN_PROGRESS = null;
        public static final MessageDLPReviewState PASS = null;
        public static final MessageDLPReviewState UNKNOWN_STATE = null;
        private final int value;

        static {
            MessageDLPReviewState r0 = new MessageDLPReviewState("UNKNOWN_STATE", 0, 0);
            UNKNOWN_STATE = r0;
            MessageDLPReviewState r1 = new MessageDLPReviewState("IN_PROGRESS", 1, 1);
            IN_PROGRESS = r1;
            MessageDLPReviewState r3 = new MessageDLPReviewState("PASS", 2, 2);
            PASS = r3;
            MessageDLPReviewState r5 = new MessageDLPReviewState("BLOCK", 3, 3);
            BLOCK = r5;
            MessageDLPReviewState r7 = new MessageDLPReviewState("INACTIVE", 4, 4);
            INACTIVE = r7;
            $VALUES = new MessageDLPReviewState[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(MessageDLPReviewState.class);
        }

        public static MessageDLPReviewState[] values() {
            return (MessageDLPReviewState[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static MessageDLPReviewState fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return INACTIVE;
        L16:
            return BLOCK;
        L18:
            return PASS;
        L20:
            return IN_PROGRESS;
        L22:
            return UNKNOWN_STATE;
        }

        public static MessageDLPReviewState valueOf(String r1) {
            return (MessageDLPReviewState) a.a(MessageDLPReviewState.class, r1);
        }

        private MessageDLPReviewState(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum MessageSensitivity extends Enum<MessageSensitivity> implements WireEnum {
        private static final /* synthetic */ MessageSensitivity[] $VALUES = null;
        public static final ProtoAdapter<MessageSensitivity> ADAPTER = null;
        public static final MessageSensitivity DANGEROUS = null;
        public static final MessageSensitivity SAFE = null;
        public static final MessageSensitivity UNKNOWN_SENSITIVITY = null;
        private final int value;

        static {
            MessageSensitivity r0 = new MessageSensitivity("UNKNOWN_SENSITIVITY", 0, 0);
            UNKNOWN_SENSITIVITY = r0;
            MessageSensitivity r1 = new MessageSensitivity("SAFE", 1, 1);
            SAFE = r1;
            MessageSensitivity r3 = new MessageSensitivity("DANGEROUS", 2, 2);
            DANGEROUS = r3;
            $VALUES = new MessageSensitivity[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(MessageSensitivity.class);
        }

        public static MessageSensitivity[] values() {
            return (MessageSensitivity[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static MessageSensitivity fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return DANGEROUS;
        L12:
            return SAFE;
        L14:
            return UNKNOWN_SENSITIVITY;
        }

        public static MessageSensitivity valueOf(String r1) {
            return (MessageSensitivity) a.a(MessageSensitivity.class, r1);
        }

        private MessageSensitivity(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_Message extends ProtoAdapter<Message> {
        private final ProtoAdapter<Map<String, ImageTranslationAbility>> mimages_translation_ability;
        private final ProtoAdapter<Map<String, ImageTranslationAbilityV2>> mimages_translation_ability_v2;
        private final ProtoAdapter<Map<String, UrlPreviewHangPoint>> mreference_url_preview_hang_point_map;
        private final ProtoAdapter<Map<String, UrlPreviewHangPoint>> murl_preview_hang_point_map;

        public ProtoAdapter_Message() {
            super(FieldEncoding.LENGTH_DELIMITED, Message.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mimages_translation_ability = ProtoAdapter.newMapAdapter(r0, ImageTranslationAbility.ADAPTER);
            this.mimages_translation_ability_v2 = ProtoAdapter.newMapAdapter(r0, ImageTranslationAbilityV2.ADAPTER);
            ProtoAdapter<UrlPreviewHangPoint> r1 = UrlPreviewHangPoint.ADAPTER;
            this.murl_preview_hang_point_map = ProtoAdapter.newMapAdapter(r0, r1);
            this.mreference_url_preview_hang_point_map = ProtoAdapter.newMapAdapter(r0, r1);
        }

        public Message decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mfrom_id = "";
            r0.mcreate_time = 0L;
            r0.mcontent = ByteString.EMPTY;
            r0.mroot_id = "";
            r0.mparent_id = "";
            r0.mchat_id = "";
            r0.mlast_modify_time = 0L;
            r0.mcid = "";
            r0.mposition = 0;
            r0.mupdate_time = 0L;
            Boolean r4 = Boolean.FALSE;
            r0.mis_notified = r4;
            r0.mreply_count = "";
            r0.mparent_source_message_id = "";
            r0.mroot_source_message_id = "";
            r0.mis_ding = r4;
            r0.mthread_id = "";
            r0.msend_to_chat = r4;
            r0.mis_truncated = r4;
            r0.mis_removed = r4;
            r0.mchannel_id = "";
            Boolean r5 = Boolean.TRUE;
            r0.mis_visible = r5;
            r0.mthread_position = 0;
            r0.mremover_id = 0L;
            r0.mtranslate_language = "";
            r0.mno_badged_count = 0;
            r0.mis_badged = r4;
            r0.mbadge_count = 0;
            r0.mthread_badge_count = 0;
            r0.mthread_reply_count = 0;
            r0.mmessage_language = "";
            r0.mis_no_trace_removed = r4;
            r0.mis_auto_translated_by_receiver = r4;
            r0.mis_visible_v2 = r5;
            r0.moriginal_sender_id = "";
            r0.mis_static_resource_message_deleted = r4;
            r0.mmessage_pipe_version = 0L;
            r0.mis_batch_copy_messages = r4;
            r0.mis_special_focus = r4;
            r0.mis_include_doc_url = r4;
            r0.mcipher_id = 0L;
            r0.mcharacter_length = 0;
            r0.mcreate_time_ms = 0L;
            r0.mis_encrypted = r4;
            r0.medit_version = 0;
            r0.medit_time_ms = 0L;
            r0.mfold_id = 0L;
            r0.mset_content_gray = r4;
            r0.mupdate_time_ms = 0L;
            r0.mno_reply_count = 0;
            r0.msync_to_chat_thread_root_id = 0L;
            r0.msync_to_chat_related_message_id = 0L;
            r0.mhas_follow_up = r4;
            r0.mfilter_mute_bot_badge_count = 0;
            r0.mfilter_mute_bot_badge_count_version = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L138;
            switch(r3) {
                case 1: goto L137;
                case 2: goto L140;
                case 3: goto L132;
                case 4: goto L131;
                case 5: goto L130;
                case 6: goto L150;
                case 7: goto L160;
                case 8: goto L121;
                case 9: goto L120;
                case 10: goto L119;
                case 11: goto L118;
                case 12: goto L117;
                case 13: goto L116;
                case 14: goto L115;
                case 15: goto L114;
                case 16: goto L113;
                case 17: goto L112;
                case 18: goto L111;
                case 19: goto L110;
                case 20: goto L109;
                case 21: goto L108;
                case 22: goto L107;
                case 23: goto L106;
                case 24: goto L105;
                case 25: goto L142;
                case 26: goto L100;
                case 27: goto L99;
                case 28: goto L98;
                case 29: goto L97;
                case 30: goto L96;
                case 31: goto L152;
                case 32: goto L91;
                case 33: goto L90;
                case 34: goto L89;
                case 35: goto L88;
                case 36: goto L87;
                case 37: goto L86;
                case 38: goto L85;
                case 39: goto L84;
                case 40: goto L83;
                case 41: goto L82;
                case 42: goto L81;
                case 43: goto L162;
                case 44: goto L76;
                case 45: goto L144;
                case 46: goto L148;
                case 47: goto L67;
                case 48: goto L66;
                case 49: goto L65;
                case 50: goto L64;
                case 51: goto L63;
                case 52: goto L62;
                case 53: goto L61;
                case 54: goto L60;
                case 55: goto L59;
                case 56: goto L58;
                case 57: goto L57;
                case 58: goto L56;
                case 59: goto L55;
                case 60: goto L54;
                case 61: goto L154;
                case 62: goto L49;
                case 63: goto L48;
                case 64: goto L47;
                case 65: goto L46;
                case 66: goto L45;
                case 67: goto L44;
                case 68: goto L43;
                case 69: goto L42;
                case 70: goto L158;
                case 71: goto L37;
                case 72: goto L36;
                case 73: goto L35;
                case 74: goto L156;
                case 75: goto L30;
                case 76: goto L29;
                case 77: goto L28;
                case 78: goto L27;
                case 79: goto L26;
                case 80: goto L25;
                case 81: goto L146;
                case 82: goto L20;
                case 83: goto L19;
                case 84: goto L18;
                case 85: goto L17;
                case 86: goto L16;
                case 87: goto L164;
                case 88: goto L11;
                case 89: goto L10;
                case 90: goto L9;
                case 91: goto L8;
                case 92: goto L7;
                default: goto L6;
            };
        L140:
            r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L135
        L135:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L142:
            r0.mchannel_type = (ChannelType) ChannelType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L103
        L103:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L144:
            r0.mtranslate_source = (TranslateSource) TranslateSource.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L74
        L74:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L146:
            r0.msync_to_chat_message_type = (SyncToChatMessageType) SyncToChatMessageType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L148:
            r0.mchat_type = (ChatType) ChatType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L70
        L70:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L150:
            r0.mstatus = (Status) Status.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L128
        L128:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L152:
            r0.mremover_type = (RemoverType) RemoverType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L94
        L94:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L154:
            r0.mthread_message_type = (ThreadMessageType) ThreadMessageType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L52
        L52:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L156:
            r0.mstream_status = (StreamStatus) StreamStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
        L33:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L158:
            r0.mdisplay_mode = (DisplayMode) DisplayMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L40
        L40:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L160:
            r0.mfrom_type = (FromType) FromType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L124
        L124:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L162:
            r0.msensitivity = (MessageSensitivity) MessageSensitivity.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L79
        L79:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L164:
            r0.mgeneric_stream_status = (StreamStatus) StreamStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mcot_info = (COTInfo) COTInfo.ADAPTER.decode(r9);
            goto L3
        L8:
            r0.mdoubao_app_show_info = (DoubaoAppShowInfo) DoubaoAppShowInfo.ADAPTER.decode(r9);
            goto L3
        L9:
            r0.mfilter_mute_bot_badge_count_version = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            r0.mfilter_mute_bot_badge_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L11:
            r0.mat_user_group_chatter_ids.add((Long) ProtoAdapter.INT64.decode(r9));
            goto L3
        L16:
            r0.mhas_follow_up = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L17:
            r0.mDeletedMessageUsersInfo = (DeletedMessageUsersInfo) DeletedMessageUsersInfo.ADAPTER.decode(r9);
            goto L3
        L18:
            r0.mauthorized_source = (AuthorizedSource) AuthorizedSource.ADAPTER.decode(r9);
            goto L3
        L19:
            r0.mpartial_reply_info = (PartialReplyInfo) PartialReplyInfo.ADAPTER.decode(r9);
            goto L3
        L20:
            r0.msync_to_chat_related_message_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L25:
            r0.msync_to_chat_thread_root_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L26:
            r0.mno_reply_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L27:
            r0.mreference_url_preview_hang_point_map.putAll((Map) this.mreference_url_preview_hang_point_map.decode(r9));
            goto L3
        L28:
            r0.mreferences.add((Reference) Reference.ADAPTER.decode(r9));
            goto L3
        L29:
            r0.mupdate_time_ms = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L30:
            r0.mai_info = (AIInfo) AIInfo.ADAPTER.decode(r9);
            goto L3
        L35:
            r0.mrestricted_mode_burned_info = (RestrictedModeBurnedInfo) RestrictedModeBurnedInfo.ADAPTER.decode(r9);
            goto L3
        L36:
            r0.mset_content_gray = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L37:
            r0.mdisabled_action = (DisabledAction) DisabledAction.ADAPTER.decode(r9);
            goto L3
        L42:
            r0.mfold_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L43:
            r0.mmessage_languages.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L44:
            r0.medit_time_ms = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L45:
            r0.medit_version = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L46:
            r0.mencrypted_info = (EncryptedInfo) EncryptedInfo.ADAPTER.decode(r9);
            goto L3
        L47:
            r0.mat_user_id_list.add((Long) ProtoAdapter.INT64.decode(r9));
            goto L3
        L48:
            r0.mis_encrypted = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L49:
            r0.mcreate_time_ms = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L54:
            r0.mcharacter_length = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L55:
            r0.mcipher_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L56:
            r0.mis_include_doc_url = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L57:
            r0.mcontent_state = (ContentState) ContentState.ADAPTER.decode(r9);
            goto L3
        L58:
            r0.mis_special_focus = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L59:
            r0.murl_preview_hang_point_map.putAll((Map) this.murl_preview_hang_point_map.decode(r9));
            goto L3
        L60:
            r0.manonymous_info = (AnonymousInfo) AnonymousInfo.ADAPTER.decode(r9);
            goto L3
        L61:
            r0.mis_batch_copy_messages = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L62:
            r0.mmessage_pipe_version = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L63:
            r0.mimages_translation_ability_v2.putAll((Map) this.mimages_translation_ability_v2.decode(r9));
            goto L3
        L64:
            r0.mversion = (Version) Version.ADAPTER.decode(r9);
            goto L3
        L65:
            r0.mimages_translation_ability.putAll((Map) this.mimages_translation_ability.decode(r9));
            goto L3
        L66:
            r0.mis_static_resource_message_deleted = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L67:
            r0.moriginal_sender_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L76:
            r0.mis_visible_v2 = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L81:
            r0.mis_auto_translated_by_receiver = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L82:
            r0.mis_no_trace_removed = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L83:
            r0.mtranslate_message_display_rule = (TranslateMessageDisplayRule) TranslateMessageDisplayRule.ADAPTER.decode(r9);
            goto L3
        L84:
            r0.mmessage_language = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L85:
            r0.mat_out_chatter_ids.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L86:
            r0.mthread_reply_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L87:
            r0.mthread_badge_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L88:
            r0.mbadge_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L89:
            r0.mis_badged = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L90:
            r0.mno_badged_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L91:
            r0.mi18n_info = (I18nInfo) I18nInfo.ADAPTER.decode(r9);
            goto L3
        L96:
            r0.mtranslate_language = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L97:
            r0.mremover_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L98:
            r0.mthread_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L99:
            r0.mcrypto_info = (CryptoInfo) CryptoInfo.ADAPTER.decode(r9);
            goto L3
        L100:
            r0.mis_visible = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L105:
            r0.mchannel_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L106:
            r0.mis_removed = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L107:
            r0.mis_truncated = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L108:
            r0.msend_to_chat = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L109:
            r0.mthread_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L110:
            r0.mis_ding = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L111:
            r0.mroot_source_message_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L112:
            r0.mparent_source_message_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L113:
            r0.mreply_count = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L114:
            r0.mis_notified = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L115:
            r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L116:
            r0.mposition = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L117:
            r0.mcid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L118:
            r0.mlast_modify_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L119:
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L120:
            r0.mparent_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L121:
            r0.mroot_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L130:
            r0.mcontent = (ByteString) ProtoAdapter.BYTES.decode(r9);
            goto L3
        L131:
            r0.mcreate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L132:
            r0.mfrom_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L137:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r6 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r6, r6.rawProtoAdapter().decode(r9));
            goto L3
        L138:
            r9.endMessage(r1);
            return r0.m1313build();
        }

        public int encodedSize(Message r8) {
            String r0 = r8.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Type r3 = r8.mtype;
            if (r3 == null) goto L9;
            int r4 = Type.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r6 = r8.mfrom_id;
            if (r6 == null) goto L13;
            int r7 = ProtoAdapter.STRING.encodedSizeWithTag(3, r6);
        L14:
            int r9 = r5 + r7;
            Long r10 = r8.mcreate_time;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT64.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            ByteString r13 = r8.mcontent;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.BYTES.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Status r16 = r8.mstatus;
            if (r16 == null) goto L25;
            int r17 = Status.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            FromType r19 = r8.mfrom_type;
            if (r19 == null) goto L29;
            int r20 = FromType.ADAPTER.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r8.mroot_id;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            String r25 = r8.mparent_id;
            if (r25 == null) goto L37;
            int r26 = ProtoAdapter.STRING.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            String r28 = r8.mchat_id;
            if (r28 == null) goto L41;
            int r29 = ProtoAdapter.STRING.encodedSizeWithTag(10, r28);
        L42:
            int r30 = r27 + r29;
            Long r31 = r8.mlast_modify_time;
            if (r31 == null) goto L45;
            int r32 = ProtoAdapter.INT64.encodedSizeWithTag(11, r31);
        L46:
            int r33 = r30 + r32;
            String r34 = r8.mcid;
            if (r34 == null) goto L49;
            int r35 = ProtoAdapter.STRING.encodedSizeWithTag(12, r34);
        L50:
            int r36 = r33 + r35;
            Integer r37 = r8.mposition;
            if (r37 == null) goto L53;
            int r38 = ProtoAdapter.INT32.encodedSizeWithTag(13, r37);
        L54:
            int r39 = r36 + r38;
            Long r40 = r8.mupdate_time;
            if (r40 == null) goto L57;
            int r41 = ProtoAdapter.INT64.encodedSizeWithTag(14, r40);
        L58:
            int r42 = r39 + r41;
            Boolean r43 = r8.mis_notified;
            if (r43 == null) goto L61;
            int r44 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r43);
        L62:
            int r45 = r42 + r44;
            String r46 = r8.mreply_count;
            if (r46 == null) goto L65;
            int r47 = ProtoAdapter.STRING.encodedSizeWithTag(16, r46);
        L66:
            int r48 = r45 + r47;
            String r49 = r8.mparent_source_message_id;
            if (r49 == null) goto L69;
            int r50 = ProtoAdapter.STRING.encodedSizeWithTag(17, r49);
        L70:
            int r51 = r48 + r50;
            String r52 = r8.mroot_source_message_id;
            if (r52 == null) goto L73;
            int r53 = ProtoAdapter.STRING.encodedSizeWithTag(18, r52);
        L74:
            int r54 = r51 + r53;
            Boolean r55 = r8.mis_ding;
            if (r55 == null) goto L77;
            int r56 = ProtoAdapter.BOOL.encodedSizeWithTag(19, r55);
        L78:
            int r57 = r54 + r56;
            String r58 = r8.mthread_id;
            if (r58 == null) goto L81;
            int r59 = ProtoAdapter.STRING.encodedSizeWithTag(20, r58);
        L82:
            int r60 = r57 + r59;
            Boolean r61 = r8.msend_to_chat;
            if (r61 == null) goto L85;
            int r62 = ProtoAdapter.BOOL.encodedSizeWithTag(21, r61);
        L86:
            int r63 = r60 + r62;
            Boolean r64 = r8.mis_truncated;
            if (r64 == null) goto L89;
            int r65 = ProtoAdapter.BOOL.encodedSizeWithTag(22, r64);
        L90:
            int r66 = r63 + r65;
            Boolean r67 = r8.mis_removed;
            if (r67 == null) goto L93;
            int r68 = ProtoAdapter.BOOL.encodedSizeWithTag(23, r67);
        L94:
            int r69 = r66 + r68;
            String r70 = r8.mchannel_id;
            if (r70 == null) goto L97;
            int r71 = ProtoAdapter.STRING.encodedSizeWithTag(24, r70);
        L98:
            int r72 = r69 + r71;
            ChannelType r73 = r8.mchannel_type;
            if (r73 == null) goto L101;
            int r74 = ChannelType.ADAPTER.encodedSizeWithTag(25, r73);
        L102:
            int r75 = r72 + r74;
            Boolean r76 = r8.mis_visible;
            if (r76 == null) goto L105;
            int r77 = ProtoAdapter.BOOL.encodedSizeWithTag(26, r76);
        L106:
            int r78 = r75 + r77;
            CryptoInfo r79 = r8.mcrypto_info;
            if (r79 == null) goto L109;
            int r80 = CryptoInfo.ADAPTER.encodedSizeWithTag(27, r79);
        L110:
            int r81 = r78 + r80;
            Integer r82 = r8.mthread_position;
            if (r82 == null) goto L113;
            int r83 = ProtoAdapter.INT32.encodedSizeWithTag(28, r82);
        L114:
            int r84 = r81 + r83;
            Long r85 = r8.mremover_id;
            if (r85 == null) goto L117;
            int r86 = ProtoAdapter.INT64.encodedSizeWithTag(29, r85);
        L118:
            int r87 = r84 + r86;
            String r88 = r8.mtranslate_language;
            if (r88 == null) goto L121;
            int r89 = ProtoAdapter.STRING.encodedSizeWithTag(30, r88);
        L122:
            int r90 = r87 + r89;
            RemoverType r91 = r8.mremover_type;
            if (r91 == null) goto L125;
            int r92 = RemoverType.ADAPTER.encodedSizeWithTag(31, r91);
        L126:
            int r93 = r90 + r92;
            I18nInfo r94 = r8.mi18n_info;
            if (r94 == null) goto L129;
            int r95 = I18nInfo.ADAPTER.encodedSizeWithTag(32, r94);
        L130:
            int r96 = r93 + r95;
            Integer r97 = r8.mno_badged_count;
            if (r97 == null) goto L133;
            int r98 = ProtoAdapter.INT32.encodedSizeWithTag(33, r97);
        L134:
            int r99 = r96 + r98;
            Boolean r100 = r8.mis_badged;
            if (r100 == null) goto L137;
            int r101 = ProtoAdapter.BOOL.encodedSizeWithTag(34, r100);
        L138:
            int r102 = r99 + r101;
            Integer r103 = r8.mbadge_count;
            if (r103 == null) goto L141;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(35, r103);
        L142:
            int r105 = r102 + r104;
            Integer r106 = r8.mthread_badge_count;
            if (r106 == null) goto L145;
            int r107 = ProtoAdapter.INT32.encodedSizeWithTag(36, r106);
        L146:
            int r108 = r105 + r107;
            Integer r109 = r8.mthread_reply_count;
            if (r109 == null) goto L149;
            int r110 = ProtoAdapter.INT32.encodedSizeWithTag(37, r109);
        L150:
            int r111 = r108 + r110;
            ProtoAdapter r112 = ProtoAdapter.STRING;
            int r113 = r111 + r112.asRepeated().encodedSizeWithTag(38, r8.mat_out_chatter_ids);
            String r114 = r8.mmessage_language;
            if (r114 == null) goto L153;
            int r115 = r112.encodedSizeWithTag(39, r114);
        L154:
            int r116 = r113 + r115;
            TranslateMessageDisplayRule r117 = r8.mtranslate_message_display_rule;
            if (r117 == null) goto L157;
            int r118 = TranslateMessageDisplayRule.ADAPTER.encodedSizeWithTag(40, r117);
        L158:
            int r119 = r116 + r118;
            Boolean r120 = r8.mis_no_trace_removed;
            if (r120 == null) goto L161;
            int r121 = ProtoAdapter.BOOL.encodedSizeWithTag(41, r120);
        L162:
            int r122 = r119 + r121;
            Boolean r123 = r8.mis_auto_translated_by_receiver;
            if (r123 == null) goto L165;
            int r124 = ProtoAdapter.BOOL.encodedSizeWithTag(42, r123);
        L166:
            int r125 = r122 + r124;
            MessageSensitivity r126 = r8.msensitivity;
            if (r126 == null) goto L169;
            int r127 = MessageSensitivity.ADAPTER.encodedSizeWithTag(43, r126);
        L170:
            int r128 = r125 + r127;
            Boolean r129 = r8.mis_visible_v2;
            if (r129 == null) goto L173;
            int r130 = ProtoAdapter.BOOL.encodedSizeWithTag(44, r129);
        L174:
            int r131 = r128 + r130;
            TranslateSource r132 = r8.mtranslate_source;
            if (r132 == null) goto L177;
            int r133 = TranslateSource.ADAPTER.encodedSizeWithTag(45, r132);
        L178:
            int r134 = r131 + r133;
            ChatType r135 = r8.mchat_type;
            if (r135 == null) goto L181;
            int r136 = ChatType.ADAPTER.encodedSizeWithTag(46, r135);
        L182:
            int r137 = r134 + r136;
            String r138 = r8.moriginal_sender_id;
            if (r138 == null) goto L185;
            int r139 = r112.encodedSizeWithTag(47, r138);
        L186:
            int r140 = r137 + r139;
            Boolean r141 = r8.mis_static_resource_message_deleted;
            if (r141 == null) goto L189;
            int r142 = ProtoAdapter.BOOL.encodedSizeWithTag(48, r141);
        L190:
            int r143 = (r140 + r142) + this.mimages_translation_ability.encodedSizeWithTag(49, r8.mimages_translation_ability);
            Version r144 = r8.mversion;
            if (r144 == null) goto L193;
            int r145 = Version.ADAPTER.encodedSizeWithTag(50, r144);
        L194:
            int r146 = (r143 + r145) + this.mimages_translation_ability_v2.encodedSizeWithTag(51, r8.mimages_translation_ability_v2);
            Long r147 = r8.mmessage_pipe_version;
            if (r147 == null) goto L197;
            int r148 = ProtoAdapter.INT64.encodedSizeWithTag(52, r147);
        L198:
            int r149 = r146 + r148;
            Boolean r150 = r8.mis_batch_copy_messages;
            if (r150 == null) goto L201;
            int r151 = ProtoAdapter.BOOL.encodedSizeWithTag(53, r150);
        L202:
            int r152 = r149 + r151;
            AnonymousInfo r153 = r8.manonymous_info;
            if (r153 == null) goto L205;
            int r154 = AnonymousInfo.ADAPTER.encodedSizeWithTag(54, r153);
        L206:
            int r155 = (r152 + r154) + this.murl_preview_hang_point_map.encodedSizeWithTag(55, r8.murl_preview_hang_point_map);
            Boolean r156 = r8.mis_special_focus;
            if (r156 == null) goto L209;
            int r157 = ProtoAdapter.BOOL.encodedSizeWithTag(56, r156);
        L210:
            int r158 = r155 + r157;
            ContentState r159 = r8.mcontent_state;
            if (r159 == null) goto L213;
            int r160 = ContentState.ADAPTER.encodedSizeWithTag(57, r159);
        L214:
            int r161 = r158 + r160;
            Boolean r162 = r8.mis_include_doc_url;
            if (r162 == null) goto L217;
            int r163 = ProtoAdapter.BOOL.encodedSizeWithTag(58, r162);
        L218:
            int r164 = r161 + r163;
            Long r165 = r8.mcipher_id;
            if (r165 == null) goto L221;
            int r166 = ProtoAdapter.INT64.encodedSizeWithTag(59, r165);
        L222:
            int r167 = r164 + r166;
            Integer r168 = r8.mcharacter_length;
            if (r168 == null) goto L225;
            int r169 = ProtoAdapter.INT32.encodedSizeWithTag(60, r168);
        L226:
            int r170 = r167 + r169;
            ThreadMessageType r171 = r8.mthread_message_type;
            if (r171 == null) goto L229;
            int r172 = ThreadMessageType.ADAPTER.encodedSizeWithTag(61, r171);
        L230:
            int r173 = r170 + r172;
            Long r174 = r8.mcreate_time_ms;
            if (r174 == null) goto L233;
            int r175 = ProtoAdapter.INT64.encodedSizeWithTag(62, r174);
        L234:
            int r176 = r173 + r175;
            Boolean r177 = r8.mis_encrypted;
            if (r177 == null) goto L237;
            int r178 = ProtoAdapter.BOOL.encodedSizeWithTag(63, r177);
        L238:
            int r179 = r176 + r178;
            ProtoAdapter r180 = ProtoAdapter.INT64;
            int r181 = r179 + r180.asRepeated().encodedSizeWithTag(64, r8.mat_user_id_list);
            EncryptedInfo r182 = r8.mencrypted_info;
            if (r182 == null) goto L241;
            int r183 = EncryptedInfo.ADAPTER.encodedSizeWithTag(65, r182);
        L242:
            int r184 = r181 + r183;
            Integer r185 = r8.medit_version;
            if (r185 == null) goto L245;
            int r186 = ProtoAdapter.INT32.encodedSizeWithTag(66, r185);
        L246:
            int r187 = r184 + r186;
            Long r188 = r8.medit_time_ms;
            if (r188 == null) goto L249;
            int r189 = r180.encodedSizeWithTag(67, r188);
        L250:
            int r190 = (r187 + r189) + r112.asRepeated().encodedSizeWithTag(68, r8.mmessage_languages);
            Long r191 = r8.mfold_id;
            if (r191 == null) goto L253;
            int r192 = r180.encodedSizeWithTag(69, r191);
        L254:
            int r193 = r190 + r192;
            DisplayMode r194 = r8.mdisplay_mode;
            if (r194 == null) goto L257;
            int r195 = DisplayMode.ADAPTER.encodedSizeWithTag(70, r194);
        L258:
            int r196 = r193 + r195;
            DisabledAction r197 = r8.mdisabled_action;
            if (r197 == null) goto L261;
            int r198 = DisabledAction.ADAPTER.encodedSizeWithTag(71, r197);
        L262:
            int r199 = r196 + r198;
            Boolean r200 = r8.mset_content_gray;
            if (r200 == null) goto L265;
            int r201 = ProtoAdapter.BOOL.encodedSizeWithTag(72, r200);
        L266:
            int r202 = r199 + r201;
            RestrictedModeBurnedInfo r203 = r8.mrestricted_mode_burned_info;
            if (r203 == null) goto L269;
            int r204 = RestrictedModeBurnedInfo.ADAPTER.encodedSizeWithTag(73, r203);
        L270:
            int r205 = r202 + r204;
            StreamStatus r206 = r8.mstream_status;
            if (r206 == null) goto L273;
            int r207 = StreamStatus.ADAPTER.encodedSizeWithTag(74, r206);
        L274:
            int r208 = r205 + r207;
            AIInfo r209 = r8.mai_info;
            if (r209 == null) goto L277;
            int r210 = AIInfo.ADAPTER.encodedSizeWithTag(75, r209);
        L278:
            int r211 = r208 + r210;
            Long r212 = r8.mupdate_time_ms;
            if (r212 == null) goto L281;
            int r213 = r180.encodedSizeWithTag(76, r212);
        L282:
            int r214 = ((r211 + r213) + Reference.ADAPTER.asRepeated().encodedSizeWithTag(77, r8.mreferences)) + this.mreference_url_preview_hang_point_map.encodedSizeWithTag(78, r8.mreference_url_preview_hang_point_map);
            Integer r215 = r8.mno_reply_count;
            if (r215 == null) goto L285;
            int r216 = ProtoAdapter.INT32.encodedSizeWithTag(79, r215);
        L286:
            int r217 = r214 + r216;
            Long r218 = r8.msync_to_chat_thread_root_id;
            if (r218 == null) goto L289;
            int r219 = r180.encodedSizeWithTag(80, r218);
        L290:
            int r220 = r217 + r219;
            SyncToChatMessageType r221 = r8.msync_to_chat_message_type;
            if (r221 == null) goto L293;
            int r222 = SyncToChatMessageType.ADAPTER.encodedSizeWithTag(81, r221);
        L294:
            int r223 = r220 + r222;
            Long r224 = r8.msync_to_chat_related_message_id;
            if (r224 == null) goto L297;
            int r225 = r180.encodedSizeWithTag(82, r224);
        L298:
            int r226 = r223 + r225;
            PartialReplyInfo r227 = r8.mpartial_reply_info;
            if (r227 == null) goto L301;
            int r228 = PartialReplyInfo.ADAPTER.encodedSizeWithTag(83, r227);
        L302:
            int r229 = r226 + r228;
            AuthorizedSource r230 = r8.mauthorized_source;
            if (r230 == null) goto L305;
            int r231 = AuthorizedSource.ADAPTER.encodedSizeWithTag(84, r230);
        L306:
            int r232 = r229 + r231;
            DeletedMessageUsersInfo r233 = r8.mDeletedMessageUsersInfo;
            if (r233 == null) goto L309;
            int r234 = DeletedMessageUsersInfo.ADAPTER.encodedSizeWithTag(85, r233);
        L310:
            int r235 = r232 + r234;
            Boolean r236 = r8.mhas_follow_up;
            if (r236 == null) goto L313;
            int r237 = ProtoAdapter.BOOL.encodedSizeWithTag(86, r236);
        L314:
            int r238 = r235 + r237;
            StreamStatus r239 = r8.mgeneric_stream_status;
            if (r239 == null) goto L317;
            int r240 = StreamStatus.ADAPTER.encodedSizeWithTag(87, r239);
        L318:
            int r241 = (r238 + r240) + r180.asRepeated().encodedSizeWithTag(88, r8.mat_user_group_chatter_ids);
            Integer r242 = r8.mfilter_mute_bot_badge_count;
            if (r242 == null) goto L321;
            int r243 = ProtoAdapter.INT32.encodedSizeWithTag(89, r242);
        L322:
            int r244 = r241 + r243;
            Long r245 = r8.mfilter_mute_bot_badge_count_version;
            if (r245 == null) goto L325;
            int r246 = r180.encodedSizeWithTag(90, r245);
        L326:
            int r247 = r244 + r246;
            DoubaoAppShowInfo r248 = r8.mdoubao_app_show_info;
            if (r248 == null) goto L329;
            int r249 = DoubaoAppShowInfo.ADAPTER.encodedSizeWithTag(91, r248);
        L330:
            int r250 = r247 + r249;
            COTInfo r251 = r8.mcot_info;
            if (r251 == null) goto L334;
            r1 = COTInfo.ADAPTER.encodedSizeWithTag(92, r251);
        L334:
            return (r250 + r1) + r8.unknownFields().size();
        L329:
            r249 = 0;
            goto L330
        L325:
            r246 = 0;
            goto L326
        L321:
            r243 = 0;
            goto L322
        L317:
            r240 = 0;
            goto L318
        L313:
            r237 = 0;
            goto L314
        L309:
            r234 = 0;
            goto L310
        L305:
            r231 = 0;
            goto L306
        L301:
            r228 = 0;
            goto L302
        L297:
            r225 = 0;
            goto L298
        L293:
            r222 = 0;
            goto L294
        L289:
            r219 = 0;
            goto L290
        L285:
            r216 = 0;
            goto L286
        L281:
            r213 = 0;
            goto L282
        L277:
            r210 = 0;
            goto L278
        L273:
            r207 = 0;
            goto L274
        L269:
            r204 = 0;
            goto L270
        L265:
            r201 = 0;
            goto L266
        L261:
            r198 = 0;
            goto L262
        L257:
            r195 = 0;
            goto L258
        L253:
            r192 = 0;
            goto L254
        L249:
            r189 = 0;
            goto L250
        L245:
            r186 = 0;
            goto L246
        L241:
            r183 = 0;
            goto L242
        L237:
            r178 = 0;
            goto L238
        L233:
            r175 = 0;
            goto L234
        L229:
            r172 = 0;
            goto L230
        L225:
            r169 = 0;
            goto L226
        L221:
            r166 = 0;
            goto L222
        L217:
            r163 = 0;
            goto L218
        L213:
            r160 = 0;
            goto L214
        L209:
            r157 = 0;
            goto L210
        L205:
            r154 = 0;
            goto L206
        L201:
            r151 = 0;
            goto L202
        L197:
            r148 = 0;
            goto L198
        L193:
            r145 = 0;
            goto L194
        L189:
            r142 = 0;
            goto L190
        L185:
            r139 = 0;
            goto L186
        L181:
            r136 = 0;
            goto L182
        L177:
            r133 = 0;
            goto L178
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
            r7 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1332decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Message) r1);
        }

        public void encode(ProtoWriter r6, Message r7) throws IOException {
            String r0 = r7.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r6, 1, r0);
        L5:
            Type r1 = r7.mtype;
            if (r1 == null) goto L8;
            Type.ADAPTER.encodeWithTag(r6, 2, r1);
        L8:
            String r2 = r7.mfrom_id;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r6, 3, r2);
        L11:
            Long r3 = r7.mcreate_time;
            if (r3 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r6, 4, r3);
        L14:
            ByteString r4 = r7.mcontent;
            if (r4 == null) goto L17;
            ProtoAdapter.BYTES.encodeWithTag(r6, 5, r4);
        L17:
            Status r5 = r7.mstatus;
            if (r5 == null) goto L20;
            Status.ADAPTER.encodeWithTag(r6, 6, r5);
        L20:
            FromType r8 = r7.mfrom_type;
            if (r8 == null) goto L23;
            FromType.ADAPTER.encodeWithTag(r6, 7, r8);
        L23:
            String r9 = r7.mroot_id;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r6, 8, r9);
        L26:
            String r10 = r7.mparent_id;
            if (r10 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r6, 9, r10);
        L29:
            String r11 = r7.mchat_id;
            if (r11 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r6, 10, r11);
        L32:
            Long r12 = r7.mlast_modify_time;
            if (r12 == null) goto L35;
            ProtoAdapter.INT64.encodeWithTag(r6, 11, r12);
        L35:
            String r13 = r7.mcid;
            if (r13 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r6, 12, r13);
        L38:
            Integer r14 = r7.mposition;
            if (r14 == null) goto L41;
            ProtoAdapter.INT32.encodeWithTag(r6, 13, r14);
        L41:
            Long r15 = r7.mupdate_time;
            if (r15 == null) goto L44;
            ProtoAdapter.INT64.encodeWithTag(r6, 14, r15);
        L44:
            Boolean r16 = r7.mis_notified;
            if (r16 == null) goto L47;
            ProtoAdapter.BOOL.encodeWithTag(r6, 15, r16);
        L47:
            String r17 = r7.mreply_count;
            if (r17 == null) goto L50;
            ProtoAdapter.STRING.encodeWithTag(r6, 16, r17);
        L50:
            String r18 = r7.mparent_source_message_id;
            if (r18 == null) goto L53;
            ProtoAdapter.STRING.encodeWithTag(r6, 17, r18);
        L53:
            String r19 = r7.mroot_source_message_id;
            if (r19 == null) goto L56;
            ProtoAdapter.STRING.encodeWithTag(r6, 18, r19);
        L56:
            Boolean r20 = r7.mis_ding;
            if (r20 == null) goto L59;
            ProtoAdapter.BOOL.encodeWithTag(r6, 19, r20);
        L59:
            String r21 = r7.mthread_id;
            if (r21 == null) goto L62;
            ProtoAdapter.STRING.encodeWithTag(r6, 20, r21);
        L62:
            Boolean r22 = r7.msend_to_chat;
            if (r22 == null) goto L65;
            ProtoAdapter.BOOL.encodeWithTag(r6, 21, r22);
        L65:
            Boolean r23 = r7.mis_truncated;
            if (r23 == null) goto L68;
            ProtoAdapter.BOOL.encodeWithTag(r6, 22, r23);
        L68:
            Boolean r24 = r7.mis_removed;
            if (r24 == null) goto L71;
            ProtoAdapter.BOOL.encodeWithTag(r6, 23, r24);
        L71:
            String r25 = r7.mchannel_id;
            if (r25 == null) goto L74;
            ProtoAdapter.STRING.encodeWithTag(r6, 24, r25);
        L74:
            ChannelType r26 = r7.mchannel_type;
            if (r26 == null) goto L77;
            ChannelType.ADAPTER.encodeWithTag(r6, 25, r26);
        L77:
            Boolean r27 = r7.mis_visible;
            if (r27 == null) goto L80;
            ProtoAdapter.BOOL.encodeWithTag(r6, 26, r27);
        L80:
            CryptoInfo r28 = r7.mcrypto_info;
            if (r28 == null) goto L83;
            CryptoInfo.ADAPTER.encodeWithTag(r6, 27, r28);
        L83:
            Integer r29 = r7.mthread_position;
            if (r29 == null) goto L86;
            ProtoAdapter.INT32.encodeWithTag(r6, 28, r29);
        L86:
            Long r30 = r7.mremover_id;
            if (r30 == null) goto L89;
            ProtoAdapter.INT64.encodeWithTag(r6, 29, r30);
        L89:
            String r31 = r7.mtranslate_language;
            if (r31 == null) goto L92;
            ProtoAdapter.STRING.encodeWithTag(r6, 30, r31);
        L92:
            RemoverType r32 = r7.mremover_type;
            if (r32 == null) goto L95;
            RemoverType.ADAPTER.encodeWithTag(r6, 31, r32);
        L95:
            I18nInfo r33 = r7.mi18n_info;
            if (r33 == null) goto L98;
            I18nInfo.ADAPTER.encodeWithTag(r6, 32, r33);
        L98:
            Integer r34 = r7.mno_badged_count;
            if (r34 == null) goto L101;
            ProtoAdapter.INT32.encodeWithTag(r6, 33, r34);
        L101:
            Boolean r35 = r7.mis_badged;
            if (r35 == null) goto L104;
            ProtoAdapter.BOOL.encodeWithTag(r6, 34, r35);
        L104:
            Integer r36 = r7.mbadge_count;
            if (r36 == null) goto L107;
            ProtoAdapter.INT32.encodeWithTag(r6, 35, r36);
        L107:
            Integer r37 = r7.mthread_badge_count;
            if (r37 == null) goto L110;
            ProtoAdapter.INT32.encodeWithTag(r6, 36, r37);
        L110:
            Integer r38 = r7.mthread_reply_count;
            if (r38 == null) goto L113;
            ProtoAdapter.INT32.encodeWithTag(r6, 37, r38);
        L113:
            ProtoAdapter r39 = ProtoAdapter.STRING;
            r39.asRepeated().encodeWithTag(r6, 38, r7.mat_out_chatter_ids);
            String r40 = r7.mmessage_language;
            if (r40 == null) goto L116;
            r39.encodeWithTag(r6, 39, r40);
        L116:
            TranslateMessageDisplayRule r41 = r7.mtranslate_message_display_rule;
            if (r41 == null) goto L119;
            TranslateMessageDisplayRule.ADAPTER.encodeWithTag(r6, 40, r41);
        L119:
            Boolean r42 = r7.mis_no_trace_removed;
            if (r42 == null) goto L122;
            ProtoAdapter.BOOL.encodeWithTag(r6, 41, r42);
        L122:
            Boolean r43 = r7.mis_auto_translated_by_receiver;
            if (r43 == null) goto L125;
            ProtoAdapter.BOOL.encodeWithTag(r6, 42, r43);
        L125:
            MessageSensitivity r44 = r7.msensitivity;
            if (r44 == null) goto L128;
            MessageSensitivity.ADAPTER.encodeWithTag(r6, 43, r44);
        L128:
            Boolean r45 = r7.mis_visible_v2;
            if (r45 == null) goto L131;
            ProtoAdapter.BOOL.encodeWithTag(r6, 44, r45);
        L131:
            TranslateSource r46 = r7.mtranslate_source;
            if (r46 == null) goto L134;
            TranslateSource.ADAPTER.encodeWithTag(r6, 45, r46);
        L134:
            ChatType r47 = r7.mchat_type;
            if (r47 == null) goto L137;
            ChatType.ADAPTER.encodeWithTag(r6, 46, r47);
        L137:
            String r48 = r7.moriginal_sender_id;
            if (r48 == null) goto L140;
            r39.encodeWithTag(r6, 47, r48);
        L140:
            Boolean r49 = r7.mis_static_resource_message_deleted;
            if (r49 == null) goto L143;
            ProtoAdapter.BOOL.encodeWithTag(r6, 48, r49);
        L143:
            this.mimages_translation_ability.encodeWithTag(r6, 49, r7.mimages_translation_ability);
            Version r50 = r7.mversion;
            if (r50 == null) goto L146;
            Version.ADAPTER.encodeWithTag(r6, 50, r50);
        L146:
            this.mimages_translation_ability_v2.encodeWithTag(r6, 51, r7.mimages_translation_ability_v2);
            Long r51 = r7.mmessage_pipe_version;
            if (r51 == null) goto L149;
            ProtoAdapter.INT64.encodeWithTag(r6, 52, r51);
        L149:
            Boolean r52 = r7.mis_batch_copy_messages;
            if (r52 == null) goto L152;
            ProtoAdapter.BOOL.encodeWithTag(r6, 53, r52);
        L152:
            AnonymousInfo r53 = r7.manonymous_info;
            if (r53 == null) goto L155;
            AnonymousInfo.ADAPTER.encodeWithTag(r6, 54, r53);
        L155:
            this.murl_preview_hang_point_map.encodeWithTag(r6, 55, r7.murl_preview_hang_point_map);
            Boolean r54 = r7.mis_special_focus;
            if (r54 == null) goto L158;
            ProtoAdapter.BOOL.encodeWithTag(r6, 56, r54);
        L158:
            ContentState r55 = r7.mcontent_state;
            if (r55 == null) goto L161;
            ContentState.ADAPTER.encodeWithTag(r6, 57, r55);
        L161:
            Boolean r56 = r7.mis_include_doc_url;
            if (r56 == null) goto L164;
            ProtoAdapter.BOOL.encodeWithTag(r6, 58, r56);
        L164:
            Long r57 = r7.mcipher_id;
            if (r57 == null) goto L167;
            ProtoAdapter.INT64.encodeWithTag(r6, 59, r57);
        L167:
            Integer r58 = r7.mcharacter_length;
            if (r58 == null) goto L170;
            ProtoAdapter.INT32.encodeWithTag(r6, 60, r58);
        L170:
            ThreadMessageType r59 = r7.mthread_message_type;
            if (r59 == null) goto L173;
            ThreadMessageType.ADAPTER.encodeWithTag(r6, 61, r59);
        L173:
            Long r60 = r7.mcreate_time_ms;
            if (r60 == null) goto L176;
            ProtoAdapter.INT64.encodeWithTag(r6, 62, r60);
        L176:
            Boolean r61 = r7.mis_encrypted;
            if (r61 == null) goto L179;
            ProtoAdapter.BOOL.encodeWithTag(r6, 63, r61);
        L179:
            ProtoAdapter r62 = ProtoAdapter.INT64;
            r62.asRepeated().encodeWithTag(r6, 64, r7.mat_user_id_list);
            EncryptedInfo r63 = r7.mencrypted_info;
            if (r63 == null) goto L182;
            EncryptedInfo.ADAPTER.encodeWithTag(r6, 65, r63);
        L182:
            Integer r64 = r7.medit_version;
            if (r64 == null) goto L185;
            ProtoAdapter.INT32.encodeWithTag(r6, 66, r64);
        L185:
            Long r65 = r7.medit_time_ms;
            if (r65 == null) goto L188;
            r62.encodeWithTag(r6, 67, r65);
        L188:
            r39.asRepeated().encodeWithTag(r6, 68, r7.mmessage_languages);
            Long r66 = r7.mfold_id;
            if (r66 == null) goto L191;
            r62.encodeWithTag(r6, 69, r66);
        L191:
            DisplayMode r67 = r7.mdisplay_mode;
            if (r67 == null) goto L194;
            DisplayMode.ADAPTER.encodeWithTag(r6, 70, r67);
        L194:
            DisabledAction r68 = r7.mdisabled_action;
            if (r68 == null) goto L197;
            DisabledAction.ADAPTER.encodeWithTag(r6, 71, r68);
        L197:
            Boolean r69 = r7.mset_content_gray;
            if (r69 == null) goto L200;
            ProtoAdapter.BOOL.encodeWithTag(r6, 72, r69);
        L200:
            RestrictedModeBurnedInfo r70 = r7.mrestricted_mode_burned_info;
            if (r70 == null) goto L203;
            RestrictedModeBurnedInfo.ADAPTER.encodeWithTag(r6, 73, r70);
        L203:
            StreamStatus r71 = r7.mstream_status;
            if (r71 == null) goto L206;
            StreamStatus.ADAPTER.encodeWithTag(r6, 74, r71);
        L206:
            AIInfo r72 = r7.mai_info;
            if (r72 == null) goto L209;
            AIInfo.ADAPTER.encodeWithTag(r6, 75, r72);
        L209:
            Long r73 = r7.mupdate_time_ms;
            if (r73 == null) goto L212;
            r62.encodeWithTag(r6, 76, r73);
        L212:
            Reference.ADAPTER.asRepeated().encodeWithTag(r6, 77, r7.mreferences);
            this.mreference_url_preview_hang_point_map.encodeWithTag(r6, 78, r7.mreference_url_preview_hang_point_map);
            Integer r74 = r7.mno_reply_count;
            if (r74 == null) goto L215;
            ProtoAdapter.INT32.encodeWithTag(r6, 79, r74);
        L215:
            Long r75 = r7.msync_to_chat_thread_root_id;
            if (r75 == null) goto L218;
            r62.encodeWithTag(r6, 80, r75);
        L218:
            SyncToChatMessageType r76 = r7.msync_to_chat_message_type;
            if (r76 == null) goto L221;
            SyncToChatMessageType.ADAPTER.encodeWithTag(r6, 81, r76);
        L221:
            Long r77 = r7.msync_to_chat_related_message_id;
            if (r77 == null) goto L224;
            r62.encodeWithTag(r6, 82, r77);
        L224:
            PartialReplyInfo r78 = r7.mpartial_reply_info;
            if (r78 == null) goto L227;
            PartialReplyInfo.ADAPTER.encodeWithTag(r6, 83, r78);
        L227:
            AuthorizedSource r79 = r7.mauthorized_source;
            if (r79 == null) goto L230;
            AuthorizedSource.ADAPTER.encodeWithTag(r6, 84, r79);
        L230:
            DeletedMessageUsersInfo r80 = r7.mDeletedMessageUsersInfo;
            if (r80 == null) goto L233;
            DeletedMessageUsersInfo.ADAPTER.encodeWithTag(r6, 85, r80);
        L233:
            Boolean r81 = r7.mhas_follow_up;
            if (r81 == null) goto L236;
            ProtoAdapter.BOOL.encodeWithTag(r6, 86, r81);
        L236:
            StreamStatus r82 = r7.mgeneric_stream_status;
            if (r82 == null) goto L239;
            StreamStatus.ADAPTER.encodeWithTag(r6, 87, r82);
        L239:
            r62.asRepeated().encodeWithTag(r6, 88, r7.mat_user_group_chatter_ids);
            Integer r83 = r7.mfilter_mute_bot_badge_count;
            if (r83 == null) goto L242;
            ProtoAdapter.INT32.encodeWithTag(r6, 89, r83);
        L242:
            Long r84 = r7.mfilter_mute_bot_badge_count_version;
            if (r84 == null) goto L245;
            r62.encodeWithTag(r6, 90, r84);
        L245:
            DoubaoAppShowInfo r85 = r7.mdoubao_app_show_info;
            if (r85 == null) goto L248;
            DoubaoAppShowInfo.ADAPTER.encodeWithTag(r6, 91, r85);
        L248:
            COTInfo r86 = r7.mcot_info;
            if (r86 == null) goto L251;
            COTInfo.ADAPTER.encodeWithTag(r6, 92, r86);
        L251:
            r6.writeBytes(r7.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Message) r2);
        }
    }

    public static final class Reference extends com.squareup.wire.Message<Reference, Builder> {
        public static final ProtoAdapter<Reference> ADAPTER = null;
        public static final String DEFAULT_TITLE = "";
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final String mtitle;
        public final String murl;

        public static final class Builder extends com.squareup.wire.Message.Builder<Reference, Builder> {
            public String mtitle;
            public String murl;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Reference m1334build() {
                return new Reference(this.murl, this.mtitle, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1334build();
            }

            public Builder title(String r1) {
                this.mtitle = r1;
                return this;
            }

            public Builder url(String r1) {
                this.murl = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Reference extends ProtoAdapter<Reference> {
            public ProtoAdapter_Reference() {
                super(FieldEncoding.LENGTH_DELIMITED, Reference.class);
            }

            public Reference decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.murl = "";
                r0.mtitle = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.murl = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mtitle = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1334build();
            }

            public int encodedSize(Reference r5) {
                String r0 = r5.murl;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r5.mtitle;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1335decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Reference) r1);
            }

            public void encode(ProtoWriter r4, Reference r5) throws IOException {
                String r0 = r5.murl;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mtitle;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Reference) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Reference();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1333newBuilder() {
            Builder r0 = new Builder();
            r0.murl = this.murl;
            r0.mtitle = this.mtitle;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Reference.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1333newBuilder();
        }

        public Reference(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public Reference(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.murl = r2;
            this.mtitle = r3;
        }
    }

    public static final enum RemoverType extends Enum<RemoverType> implements WireEnum {
        private static final /* synthetic */ RemoverType[] $VALUES = null;
        public static final ProtoAdapter<RemoverType> ADAPTER = null;
        public static final RemoverType DOUBAO_QUERY_OWNER = null;
        public static final RemoverType ENTERPRISEADMIN = null;
        public static final RemoverType GROUPADMIN = null;
        public static final RemoverType GROUPOWNER = null;
        public static final RemoverType SYSADMIN = null;
        public static final RemoverType UNKNOWN_REMOVERTYPE = null;
        private final int value;

        static {
            RemoverType r0 = new RemoverType("UNKNOWN_REMOVERTYPE", 0, 0);
            UNKNOWN_REMOVERTYPE = r0;
            RemoverType r1 = new RemoverType("GROUPOWNER", 1, 1);
            GROUPOWNER = r1;
            RemoverType r3 = new RemoverType("SYSADMIN", 2, 2);
            SYSADMIN = r3;
            RemoverType r5 = new RemoverType("GROUPADMIN", 3, 3);
            GROUPADMIN = r5;
            RemoverType r7 = new RemoverType("ENTERPRISEADMIN", 4, 4);
            ENTERPRISEADMIN = r7;
            RemoverType r9 = new RemoverType("DOUBAO_QUERY_OWNER", 5, 5);
            DOUBAO_QUERY_OWNER = r9;
            $VALUES = new RemoverType[]{r0, r1, r3, r5, r7, r9};
            ADAPTER = ProtoAdapter.newEnumAdapter(RemoverType.class);
        }

        public static RemoverType[] values() {
            return (RemoverType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static RemoverType fromValue(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return DOUBAO_QUERY_OWNER;
        L18:
            return ENTERPRISEADMIN;
        L20:
            return GROUPADMIN;
        L22:
            return SYSADMIN;
        L24:
            return GROUPOWNER;
        L26:
            return UNKNOWN_REMOVERTYPE;
        }

        public static RemoverType valueOf(String r1) {
            return (RemoverType) a.a(RemoverType.class, r1);
        }

        private RemoverType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class RestrictedModeBurnedInfo extends com.squareup.wire.Message<RestrictedModeBurnedInfo, Builder> {
        public static final ProtoAdapter<RestrictedModeBurnedInfo> ADAPTER = null;
        public static final Integer DEFAULT_BURNED_SECONDS = null;
        public static final Boolean DEFAULT_IS_BURNED = null;
        private static final long serialVersionUID = 0;
        public final Integer mburned_seconds;
        public final Boolean mis_burned;

        public static final class Builder extends com.squareup.wire.Message.Builder<RestrictedModeBurnedInfo, Builder> {
            public Integer mburned_seconds;
            public Boolean mis_burned;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public RestrictedModeBurnedInfo m1337build() {
                return new RestrictedModeBurnedInfo(this.mburned_seconds, this.mis_burned, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1337build();
            }

            public Builder burned_seconds(Integer r1) {
                this.mburned_seconds = r1;
                return this;
            }

            public Builder is_burned(Boolean r1) {
                this.mis_burned = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_RestrictedModeBurnedInfo extends ProtoAdapter<RestrictedModeBurnedInfo> {
            public ProtoAdapter_RestrictedModeBurnedInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, RestrictedModeBurnedInfo.class);
            }

            public RestrictedModeBurnedInfo decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mburned_seconds = 0;
                r0.mis_burned = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mburned_seconds = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mis_burned = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1337build();
            }

            public int encodedSize(RestrictedModeBurnedInfo r5) {
                Integer r0 = r5.mburned_seconds;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r5.mis_burned;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1338decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((RestrictedModeBurnedInfo) r1);
            }

            public void encode(ProtoWriter r4, RestrictedModeBurnedInfo r5) throws IOException {
                Integer r0 = r5.mburned_seconds;
                if (r0 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mis_burned;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (RestrictedModeBurnedInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RestrictedModeBurnedInfo();
            DEFAULT_BURNED_SECONDS = 0;
            DEFAULT_IS_BURNED = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1336newBuilder() {
            Builder r0 = new Builder();
            r0.mburned_seconds = this.mburned_seconds;
            r0.mis_burned = this.mis_burned;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return RestrictedModeBurnedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1336newBuilder();
        }

        public RestrictedModeBurnedInfo(Integer r2, Boolean r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public RestrictedModeBurnedInfo(Integer r2, Boolean r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mburned_seconds = r2;
            this.mis_burned = r3;
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status DELETED = null;
        public static final Status MODIFIED = null;
        public static final Status NORMAL = null;
        public static final Status UNKNOWN_STATUS = null;
        private final int value;

        static {
            Status r0 = new Status("UNKNOWN_STATUS", 0, 0);
            UNKNOWN_STATUS = r0;
            Status r1 = new Status("NORMAL", 1, 1);
            NORMAL = r1;
            Status r3 = new Status("DELETED", 2, 2);
            DELETED = r3;
            Status r5 = new Status("MODIFIED", 3, 3);
            MODIFIED = r5;
            $VALUES = new Status[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return MODIFIED;
        L14:
            return DELETED;
        L16:
            return NORMAL;
        L18:
            return UNKNOWN_STATUS;
        }

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        private Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum StreamStatus extends Enum<StreamStatus> implements WireEnum {
        private static final /* synthetic */ StreamStatus[] $VALUES = null;
        public static final ProtoAdapter<StreamStatus> ADAPTER = null;
        public static final StreamStatus STREAM_BREAK = null;
        public static final StreamStatus STREAM_ERROR = null;
        public static final StreamStatus STREAM_OVER = null;
        public static final StreamStatus STREAM_PREPARE = null;
        public static final StreamStatus STREAM_TRANSMIT = null;
        public static final StreamStatus STREAM_UNKNOWN = null;
        private final int value;

        static {
            StreamStatus r0 = new StreamStatus("STREAM_UNKNOWN", 0, 0);
            STREAM_UNKNOWN = r0;
            StreamStatus r1 = new StreamStatus("STREAM_TRANSMIT", 1, 1);
            STREAM_TRANSMIT = r1;
            StreamStatus r3 = new StreamStatus("STREAM_OVER", 2, 2);
            STREAM_OVER = r3;
            StreamStatus r5 = new StreamStatus("STREAM_ERROR", 3, 3);
            STREAM_ERROR = r5;
            StreamStatus r7 = new StreamStatus("STREAM_BREAK", 4, 4);
            STREAM_BREAK = r7;
            StreamStatus r9 = new StreamStatus("STREAM_PREPARE", 5, 5);
            STREAM_PREPARE = r9;
            $VALUES = new StreamStatus[]{r0, r1, r3, r5, r7, r9};
            ADAPTER = ProtoAdapter.newEnumAdapter(StreamStatus.class);
        }

        public static StreamStatus[] values() {
            return (StreamStatus[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static StreamStatus fromValue(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return STREAM_PREPARE;
        L18:
            return STREAM_BREAK;
        L20:
            return STREAM_ERROR;
        L22:
            return STREAM_OVER;
        L24:
            return STREAM_TRANSMIT;
        L26:
            return STREAM_UNKNOWN;
        }

        public static StreamStatus valueOf(String r1) {
            return (StreamStatus) a.a(StreamStatus.class, r1);
        }

        private StreamStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum SyncToChatMessageType extends Enum<SyncToChatMessageType> implements WireEnum {
        private static final /* synthetic */ SyncToChatMessageType[] $VALUES = null;
        public static final ProtoAdapter<SyncToChatMessageType> ADAPTER = null;
        public static final SyncToChatMessageType SYNC_TO_CHAT_SOURCE_MESSAGE = null;
        public static final SyncToChatMessageType SYNC_TO_CHAT_TARGET_MESSAGE = null;
        public static final SyncToChatMessageType UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE = null;
        private final int value;

        static {
            SyncToChatMessageType r0 = new SyncToChatMessageType("UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE", 0, 0);
            UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE = r0;
            SyncToChatMessageType r1 = new SyncToChatMessageType("SYNC_TO_CHAT_TARGET_MESSAGE", 1, 1);
            SYNC_TO_CHAT_TARGET_MESSAGE = r1;
            SyncToChatMessageType r3 = new SyncToChatMessageType("SYNC_TO_CHAT_SOURCE_MESSAGE", 2, 2);
            SYNC_TO_CHAT_SOURCE_MESSAGE = r3;
            $VALUES = new SyncToChatMessageType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(SyncToChatMessageType.class);
        }

        public static SyncToChatMessageType[] values() {
            return (SyncToChatMessageType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SyncToChatMessageType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return SYNC_TO_CHAT_SOURCE_MESSAGE;
        L12:
            return SYNC_TO_CHAT_TARGET_MESSAGE;
        L14:
            return UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE;
        }

        public static SyncToChatMessageType valueOf(String r1) {
            return (SyncToChatMessageType) a.a(SyncToChatMessageType.class, r1);
        }

        private SyncToChatMessageType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum ThreadMessageType extends Enum<ThreadMessageType> implements WireEnum {
        private static final /* synthetic */ ThreadMessageType[] $VALUES = null;
        public static final ProtoAdapter<ThreadMessageType> ADAPTER = null;
        public static final ThreadMessageType THREAD_REPLY_MESSAGE = null;
        public static final ThreadMessageType THREAD_ROOT_MESSAGE = null;
        public static final ThreadMessageType UNKNOWN_THREAD_MESSAGE = null;
        private final int value;

        static {
            ThreadMessageType r0 = new ThreadMessageType("UNKNOWN_THREAD_MESSAGE", 0, 0);
            UNKNOWN_THREAD_MESSAGE = r0;
            ThreadMessageType r1 = new ThreadMessageType("THREAD_ROOT_MESSAGE", 1, 1);
            THREAD_ROOT_MESSAGE = r1;
            ThreadMessageType r3 = new ThreadMessageType("THREAD_REPLY_MESSAGE", 2, 2);
            THREAD_REPLY_MESSAGE = r3;
            $VALUES = new ThreadMessageType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(ThreadMessageType.class);
        }

        public static ThreadMessageType[] values() {
            return (ThreadMessageType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ThreadMessageType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return THREAD_REPLY_MESSAGE;
        L12:
            return THREAD_ROOT_MESSAGE;
        L14:
            return UNKNOWN_THREAD_MESSAGE;
        }

        public static ThreadMessageType valueOf(String r1) {
            return (ThreadMessageType) a.a(ThreadMessageType.class, r1);
        }

        private ThreadMessageType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AUDIO = null;
        public static final Type CALENDAR = null;
        public static final Type CARD = null;
        public static final Type CLOUD_FILE = null;
        public static final Type COMMERCIALIZED_HONGBAO = null;
        public static final Type DIAGNOSE = null;
        public static final Type DOUBAO = null;
        public static final Type EMAIL = null;
        public static final Type FILE = null;
        public static final Type FOLDER = null;
        public static final Type GENERAL_CALENDAR = null;
        public static final Type HONGBAO = null;
        public static final Type IMAGE = null;
        public static final Type LINK = null;
        public static final Type LOCATION = null;
        public static final Type MEDIA = null;
        public static final Type MERGE_FORWARD = null;
        public static final Type POST = null;
        public static final Type SHARE_CALENDAR_EVENT = null;
        public static final Type SHARE_GROUP_CHAT = null;
        public static final Type SHARE_USER_CARD = null;
        public static final Type STICKER = null;
        public static final Type SYSTEM = null;
        public static final Type TEXT = null;
        public static final Type TODO = null;
        public static final Type UNKNOWN = null;
        public static final Type VIDEO_CHAT = null;
        public static final Type VOTE = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("POST", 1, 2);
            POST = r1;
            Type r3 = new Type("FILE", 2, 3);
            FILE = r3;
            Type r4 = new Type("TEXT", 3, 4);
            TEXT = r4;
            Type r7 = new Type("IMAGE", 4, 5);
            IMAGE = r7;
            Type r9 = new Type("SYSTEM", 5, 6);
            SYSTEM = r9;
            Type r11 = new Type("AUDIO", 6, 7);
            AUDIO = r11;
            Type r13 = new Type("EMAIL", 7, 8);
            EMAIL = r13;
            Type r15 = new Type("SHARE_GROUP_CHAT", 8, 9);
            SHARE_GROUP_CHAT = r15;
            Type r14 = new Type("STICKER", 9, 10);
            STICKER = r14;
            Type r12 = new Type("MERGE_FORWARD", 10, 11);
            MERGE_FORWARD = r12;
            Type r10 = new Type("CALENDAR", 11, 12);
            CALENDAR = r10;
            Type r8 = new Type("CLOUD_FILE", 12, 13);
            CLOUD_FILE = r8;
            Type r6 = new Type("CARD", 13, 14);
            CARD = r6;
            Type r5 = new Type("MEDIA", 14, 15);
            MEDIA = r5;
            Type r2 = new Type("SHARE_CALENDAR_EVENT", 15, 16);
            SHARE_CALENDAR_EVENT = r2;
            Type r16 = new Type("HONGBAO", 16, 17);
            HONGBAO = r16;
            Type r17 = new Type("GENERAL_CALENDAR", 17, 18);
            GENERAL_CALENDAR = r17;
            Type r18 = new Type("VIDEO_CHAT", 18, 19);
            VIDEO_CHAT = r18;
            Type r19 = new Type("LOCATION", 19, 20);
            LOCATION = r19;
            Type r20 = new Type("COMMERCIALIZED_HONGBAO", 20, 22);
            COMMERCIALIZED_HONGBAO = r20;
            Type r21 = new Type("SHARE_USER_CARD", 21, 23);
            SHARE_USER_CARD = r21;
            Type r22 = new Type("TODO", 22, 24);
            TODO = r22;
            Type r23 = new Type("FOLDER", 23, 25);
            FOLDER = r23;
            Type r24 = new Type("DIAGNOSE", 24, 26);
            DIAGNOSE = r24;
            Type r25 = new Type("VOTE", 25, 27);
            VOTE = r25;
            Type r26 = new Type("LINK", 26, 28);
            LINK = r26;
            Type r27 = new Type("DOUBAO", 27, 29);
            DOUBAO = r27;
            $VALUES = new Type[]{r0, r1, r3, r4, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r5, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r0) {
            switch(r0) {
                case 0: goto L60;
                case 1: goto L3;
                case 2: goto L58;
                case 3: goto L56;
                case 4: goto L54;
                case 5: goto L52;
                case 6: goto L50;
                case 7: goto L48;
                case 8: goto L46;
                case 9: goto L44;
                case 10: goto L42;
                case 11: goto L40;
                case 12: goto L38;
                case 13: goto L36;
                case 14: goto L34;
                case 15: goto L32;
                case 16: goto L30;
                case 17: goto L28;
                case 18: goto L26;
                case 19: goto L24;
                case 20: goto L22;
                case 21: goto L3;
                case 22: goto L20;
                case 23: goto L18;
                case 24: goto L16;
                case 25: goto L14;
                case 26: goto L12;
                case 27: goto L10;
                case 28: goto L8;
                case 29: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return DOUBAO;
        L8:
            return LINK;
        L10:
            return VOTE;
        L12:
            return DIAGNOSE;
        L14:
            return FOLDER;
        L16:
            return TODO;
        L18:
            return SHARE_USER_CARD;
        L20:
            return COMMERCIALIZED_HONGBAO;
        L22:
            return LOCATION;
        L24:
            return VIDEO_CHAT;
        L26:
            return GENERAL_CALENDAR;
        L28:
            return HONGBAO;
        L30:
            return SHARE_CALENDAR_EVENT;
        L32:
            return MEDIA;
        L34:
            return CARD;
        L36:
            return CLOUD_FILE;
        L38:
            return CALENDAR;
        L40:
            return MERGE_FORWARD;
        L42:
            return STICKER;
        L44:
            return SHARE_GROUP_CHAT;
        L46:
            return EMAIL;
        L48:
            return AUDIO;
        L50:
            return SYSTEM;
        L52:
            return IMAGE;
        L54:
            return TEXT;
        L56:
            return FILE;
        L58:
            return POST;
        L60:
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

    public static final class Version extends com.squareup.wire.Message<Version, Builder> {
        public static final ProtoAdapter<Version> ADAPTER = null;
        public static final Integer DEFAULT_CONTENT_VERSION = null;
        public static final Integer DEFAULT_VERSION = null;
        private static final long serialVersionUID = 0;
        public final Integer mcontent_version;
        public final Integer mversion;

        public static final class Builder extends com.squareup.wire.Message.Builder<Version, Builder> {
            public Integer mcontent_version;
            public Integer mversion;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Version m1340build() {
                return new Version(this.mcontent_version, this.mversion, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1340build();
            }

            public Builder content_version(Integer r1) {
                this.mcontent_version = r1;
                return this;
            }

            public Builder version(Integer r1) {
                this.mversion = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Version extends ProtoAdapter<Version> {
            public ProtoAdapter_Version() {
                super(FieldEncoding.LENGTH_DELIMITED, Version.class);
            }

            public Version decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mcontent_version = 0;
                r0.mversion = 0;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mcontent_version = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mversion = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1340build();
            }

            public int encodedSize(Version r5) {
                Integer r0 = r5.mcontent_version;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
            L6:
                Integer r3 = r5.mversion;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1341decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Version) r1);
            }

            public void encode(ProtoWriter r4, Version r5) throws IOException {
                Integer r0 = r5.mcontent_version;
                if (r0 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
            L5:
                Integer r1 = r5.mversion;
                if (r1 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Version) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Version();
            DEFAULT_CONTENT_VERSION = 0;
            DEFAULT_VERSION = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1339newBuilder() {
            Builder r0 = new Builder();
            r0.mcontent_version = this.mcontent_version;
            r0.mversion = this.mversion;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Version.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1339newBuilder();
        }

        public Version(Integer r2, Integer r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public Version(Integer r2, Integer r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mcontent_version = r2;
            this.mversion = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Message();
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_CONTENT = ByteString.EMPTY;
        DEFAULT_LAST_MODIFY_TIME = 0L;
        DEFAULT_POSITION = 0;
        DEFAULT_UPDATE_TIME = 0L;
        Boolean r2 = Boolean.FALSE;
        DEFAULT_IS_NOTIFIED = r2;
        DEFAULT_IS_DING = r2;
        DEFAULT_SEND_TO_CHAT = r2;
        DEFAULT_IS_TRUNCATED = r2;
        DEFAULT_IS_REMOVED = r2;
        Boolean r3 = Boolean.TRUE;
        DEFAULT_IS_VISIBLE = r3;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_REMOVER_ID = 0L;
        DEFAULT_NO_BADGED_COUNT = 0;
        DEFAULT_IS_BADGED = r2;
        DEFAULT_BADGE_COUNT = 0;
        DEFAULT_THREAD_BADGE_COUNT = 0;
        DEFAULT_THREAD_REPLY_COUNT = 0;
        DEFAULT_IS_NO_TRACE_REMOVED = r2;
        DEFAULT_IS_AUTO_TRANSLATED_BY_RECEIVER = r2;
        DEFAULT_IS_VISIBLE_V2 = r3;
        DEFAULT_IS_STATIC_RESOURCE_MESSAGE_DELETED = r2;
        DEFAULT_MESSAGE_PIPE_VERSION = 0L;
        DEFAULT_IS_BATCH_COPY_MESSAGES = r2;
        DEFAULT_IS_SPECIAL_FOCUS = r2;
        DEFAULT_IS_INCLUDE_DOC_URL = r2;
        DEFAULT_CIPHER_ID = 0L;
        DEFAULT_CHARACTER_LENGTH = 0;
        DEFAULT_CREATE_TIME_MS = 0L;
        DEFAULT_IS_ENCRYPTED = r2;
        DEFAULT_EDIT_VERSION = 0;
        DEFAULT_EDIT_TIME_MS = 0L;
        DEFAULT_FOLD_ID = 0L;
        DEFAULT_SET_CONTENT_GRAY = r2;
        DEFAULT_UPDATE_TIME_MS = 0L;
        DEFAULT_NO_REPLY_COUNT = 0;
        DEFAULT_SYNC_TO_CHAT_THREAD_ROOT_ID = 0L;
        DEFAULT_SYNC_TO_CHAT_RELATED_MESSAGE_ID = 0L;
        DEFAULT_HAS_FOLLOW_UP = r2;
        DEFAULT_FILTER_MUTE_BOT_BADGE_COUNT = 0;
        DEFAULT_FILTER_MUTE_BOT_BADGE_COUNT_VERSION = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1300newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtype = this.mtype;
        r0.mfrom_id = this.mfrom_id;
        r0.mcreate_time = this.mcreate_time;
        r0.mcontent = this.mcontent;
        r0.mstatus = this.mstatus;
        r0.mfrom_type = this.mfrom_type;
        r0.mroot_id = this.mroot_id;
        r0.mparent_id = this.mparent_id;
        r0.mchat_id = this.mchat_id;
        r0.mlast_modify_time = this.mlast_modify_time;
        r0.mcid = this.mcid;
        r0.mposition = this.mposition;
        r0.mupdate_time = this.mupdate_time;
        r0.mis_notified = this.mis_notified;
        r0.mreply_count = this.mreply_count;
        r0.mparent_source_message_id = this.mparent_source_message_id;
        r0.mroot_source_message_id = this.mroot_source_message_id;
        r0.mis_ding = this.mis_ding;
        r0.mthread_id = this.mthread_id;
        r0.msend_to_chat = this.msend_to_chat;
        r0.mis_truncated = this.mis_truncated;
        r0.mis_removed = this.mis_removed;
        r0.mchannel_id = this.mchannel_id;
        r0.mchannel_type = this.mchannel_type;
        r0.mis_visible = this.mis_visible;
        r0.mcrypto_info = this.mcrypto_info;
        r0.mthread_position = this.mthread_position;
        r0.mremover_id = this.mremover_id;
        r0.mtranslate_language = this.mtranslate_language;
        r0.mremover_type = this.mremover_type;
        r0.mi18n_info = this.mi18n_info;
        r0.mno_badged_count = this.mno_badged_count;
        r0.mis_badged = this.mis_badged;
        r0.mbadge_count = this.mbadge_count;
        r0.mthread_badge_count = this.mthread_badge_count;
        r0.mthread_reply_count = this.mthread_reply_count;
        r0.mat_out_chatter_ids = Internal.copyOf("mat_out_chatter_ids", this.mat_out_chatter_ids);
        r0.mmessage_language = this.mmessage_language;
        r0.mtranslate_message_display_rule = this.mtranslate_message_display_rule;
        r0.mis_no_trace_removed = this.mis_no_trace_removed;
        r0.mis_auto_translated_by_receiver = this.mis_auto_translated_by_receiver;
        r0.msensitivity = this.msensitivity;
        r0.mis_visible_v2 = this.mis_visible_v2;
        r0.mtranslate_source = this.mtranslate_source;
        r0.mchat_type = this.mchat_type;
        r0.moriginal_sender_id = this.moriginal_sender_id;
        r0.mis_static_resource_message_deleted = this.mis_static_resource_message_deleted;
        r0.mimages_translation_ability = Internal.copyOf("mimages_translation_ability", this.mimages_translation_ability);
        r0.mversion = this.mversion;
        r0.mimages_translation_ability_v2 = Internal.copyOf("mimages_translation_ability_v2", this.mimages_translation_ability_v2);
        r0.mmessage_pipe_version = this.mmessage_pipe_version;
        r0.mis_batch_copy_messages = this.mis_batch_copy_messages;
        r0.manonymous_info = this.manonymous_info;
        r0.murl_preview_hang_point_map = Internal.copyOf("murl_preview_hang_point_map", this.murl_preview_hang_point_map);
        r0.mis_special_focus = this.mis_special_focus;
        r0.mcontent_state = this.mcontent_state;
        r0.mis_include_doc_url = this.mis_include_doc_url;
        r0.mcipher_id = this.mcipher_id;
        r0.mcharacter_length = this.mcharacter_length;
        r0.mthread_message_type = this.mthread_message_type;
        r0.mcreate_time_ms = this.mcreate_time_ms;
        r0.mis_encrypted = this.mis_encrypted;
        r0.mat_user_id_list = Internal.copyOf("mat_user_id_list", this.mat_user_id_list);
        r0.mencrypted_info = this.mencrypted_info;
        r0.medit_version = this.medit_version;
        r0.medit_time_ms = this.medit_time_ms;
        r0.mmessage_languages = Internal.copyOf("mmessage_languages", this.mmessage_languages);
        r0.mfold_id = this.mfold_id;
        r0.mdisplay_mode = this.mdisplay_mode;
        r0.mdisabled_action = this.mdisabled_action;
        r0.mset_content_gray = this.mset_content_gray;
        r0.mrestricted_mode_burned_info = this.mrestricted_mode_burned_info;
        r0.mstream_status = this.mstream_status;
        r0.mai_info = this.mai_info;
        r0.mupdate_time_ms = this.mupdate_time_ms;
        r0.mreferences = Internal.copyOf("mreferences", this.mreferences);
        r0.mreference_url_preview_hang_point_map = Internal.copyOf("mreference_url_preview_hang_point_map", this.mreference_url_preview_hang_point_map);
        r0.mno_reply_count = this.mno_reply_count;
        r0.msync_to_chat_thread_root_id = this.msync_to_chat_thread_root_id;
        r0.msync_to_chat_message_type = this.msync_to_chat_message_type;
        r0.msync_to_chat_related_message_id = this.msync_to_chat_related_message_id;
        r0.mpartial_reply_info = this.mpartial_reply_info;
        r0.mauthorized_source = this.mauthorized_source;
        r0.mDeletedMessageUsersInfo = this.mDeletedMessageUsersInfo;
        r0.mhas_follow_up = this.mhas_follow_up;
        r0.mgeneric_stream_status = this.mgeneric_stream_status;
        r0.mat_user_group_chatter_ids = Internal.copyOf("mat_user_group_chatter_ids", this.mat_user_group_chatter_ids);
        r0.mfilter_mute_bot_badge_count = this.mfilter_mute_bot_badge_count;
        r0.mfilter_mute_bot_badge_count_version = this.mfilter_mute_bot_badge_count_version;
        r0.mdoubao_app_show_info = this.mdoubao_app_show_info;
        r0.mcot_info = this.mcot_info;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Message.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1300newBuilder();
    }

    public Message(String r95, Type r96, String r97, Long r98, ByteString r99, Status r100, FromType r101, String r102, String r103, String r104, Long r105, String r106, Integer r107, Long r108, Boolean r109, String r110, String r111, String r112, Boolean r113, String r114, Boolean r115, Boolean r116, Boolean r117, String r118, ChannelType r119, Boolean r120, CryptoInfo r121, Integer r122, Long r123, String r124, RemoverType r125, I18nInfo r126, Integer r127, Boolean r128, Integer r129, Integer r130, Integer r131, List<String> r132, String r133, TranslateMessageDisplayRule r134, Boolean r135, Boolean r136, MessageSensitivity r137, Boolean r138, TranslateSource r139, ChatType r140, String r141, Boolean r142, Map<String, ImageTranslationAbility> r143, Version r144, Map<String, ImageTranslationAbilityV2> r145, Long r146, Boolean r147, AnonymousInfo r148, Map<String, UrlPreviewHangPoint> r149, Boolean r150, ContentState r151, Boolean r152, Long r153, Integer r154, ThreadMessageType r155, Long r156, Boolean r157, List<Long> r158, EncryptedInfo r159, Integer r160, Long r161, List<String> r162, Long r163, DisplayMode r164, DisabledAction r165, Boolean r166, RestrictedModeBurnedInfo r167, StreamStatus r168, AIInfo r169, Long r170, List<Reference> r171, Map<String, UrlPreviewHangPoint> r172, Integer r173, Long r174, SyncToChatMessageType r175, Long r176, PartialReplyInfo r177, AuthorizedSource r178, DeletedMessageUsersInfo r179, Boolean r180, StreamStatus r181, List<Long> r182, Integer r183, Long r184, DoubaoAppShowInfo r185, COTInfo r186) {
        this(r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, ByteString.EMPTY);
    }

    public Message(String r4, Type r5, String r6, Long r7, ByteString r8, Status r9, FromType r10, String r11, String r12, String r13, Long r14, String r15, Integer r16, Long r17, Boolean r18, String r19, String r20, String r21, Boolean r22, String r23, Boolean r24, Boolean r25, Boolean r26, String r27, ChannelType r28, Boolean r29, CryptoInfo r30, Integer r31, Long r32, String r33, RemoverType r34, I18nInfo r35, Integer r36, Boolean r37, Integer r38, Integer r39, Integer r40, List<String> r41, String r42, TranslateMessageDisplayRule r43, Boolean r44, Boolean r45, MessageSensitivity r46, Boolean r47, TranslateSource r48, ChatType r49, String r50, Boolean r51, Map<String, ImageTranslationAbility> r52, Version r53, Map<String, ImageTranslationAbilityV2> r54, Long r55, Boolean r56, AnonymousInfo r57, Map<String, UrlPreviewHangPoint> r58, Boolean r59, ContentState r60, Boolean r61, Long r62, Integer r63, ThreadMessageType r64, Long r65, Boolean r66, List<Long> r67, EncryptedInfo r68, Integer r69, Long r70, List<String> r71, Long r72, DisplayMode r73, DisabledAction r74, Boolean r75, RestrictedModeBurnedInfo r76, StreamStatus r77, AIInfo r78, Long r79, List<Reference> r80, Map<String, UrlPreviewHangPoint> r81, Integer r82, Long r83, SyncToChatMessageType r84, Long r85, PartialReplyInfo r86, AuthorizedSource r87, DeletedMessageUsersInfo r88, Boolean r89, StreamStatus r90, List<Long> r91, Integer r92, Long r93, DoubaoAppShowInfo r94, COTInfo r95, ByteString r96) {
        super(ADAPTER, r96);
        this.mid = r4;
        this.mtype = r5;
        this.mfrom_id = r6;
        this.mcreate_time = r7;
        this.mcontent = r8;
        this.mstatus = r9;
        this.mfrom_type = r10;
        this.mroot_id = r11;
        this.mparent_id = r12;
        this.mchat_id = r13;
        this.mlast_modify_time = r14;
        this.mcid = r15;
        this.mposition = r16;
        this.mupdate_time = r17;
        this.mis_notified = r18;
        this.mreply_count = r19;
        this.mparent_source_message_id = r20;
        this.mroot_source_message_id = r21;
        this.mis_ding = r22;
        this.mthread_id = r23;
        this.msend_to_chat = r24;
        this.mis_truncated = r25;
        this.mis_removed = r26;
        this.mchannel_id = r27;
        this.mchannel_type = r28;
        this.mis_visible = r29;
        this.mcrypto_info = r30;
        this.mthread_position = r31;
        this.mremover_id = r32;
        this.mtranslate_language = r33;
        this.mremover_type = r34;
        this.mi18n_info = r35;
        this.mno_badged_count = r36;
        this.mis_badged = r37;
        this.mbadge_count = r38;
        this.mthread_badge_count = r39;
        this.mthread_reply_count = r40;
        this.mat_out_chatter_ids = Internal.immutableCopyOf("mat_out_chatter_ids", r41);
        this.mmessage_language = r42;
        this.mtranslate_message_display_rule = r43;
        this.mis_no_trace_removed = r44;
        this.mis_auto_translated_by_receiver = r45;
        this.msensitivity = r46;
        this.mis_visible_v2 = r47;
        this.mtranslate_source = r48;
        this.mchat_type = r49;
        this.moriginal_sender_id = r50;
        this.mis_static_resource_message_deleted = r51;
        this.mimages_translation_ability = Internal.immutableCopyOf("mimages_translation_ability", r52);
        this.mversion = r53;
        this.mimages_translation_ability_v2 = Internal.immutableCopyOf("mimages_translation_ability_v2", r54);
        this.mmessage_pipe_version = r55;
        this.mis_batch_copy_messages = r56;
        this.manonymous_info = r57;
        this.murl_preview_hang_point_map = Internal.immutableCopyOf("murl_preview_hang_point_map", r58);
        this.mis_special_focus = r59;
        this.mcontent_state = r60;
        this.mis_include_doc_url = r61;
        this.mcipher_id = r62;
        this.mcharacter_length = r63;
        this.mthread_message_type = r64;
        this.mcreate_time_ms = r65;
        this.mis_encrypted = r66;
        this.mat_user_id_list = Internal.immutableCopyOf("mat_user_id_list", r67);
        this.mencrypted_info = r68;
        this.medit_version = r69;
        this.medit_time_ms = r70;
        this.mmessage_languages = Internal.immutableCopyOf("mmessage_languages", r71);
        this.mfold_id = r72;
        this.mdisplay_mode = r73;
        this.mdisabled_action = r74;
        this.mset_content_gray = r75;
        this.mrestricted_mode_burned_info = r76;
        this.mstream_status = r77;
        this.mai_info = r78;
        this.mupdate_time_ms = r79;
        this.mreferences = Internal.immutableCopyOf("mreferences", r80);
        this.mreference_url_preview_hang_point_map = Internal.immutableCopyOf("mreference_url_preview_hang_point_map", r81);
        this.mno_reply_count = r82;
        this.msync_to_chat_thread_root_id = r83;
        this.msync_to_chat_message_type = r84;
        this.msync_to_chat_related_message_id = r85;
        this.mpartial_reply_info = r86;
        this.mauthorized_source = r87;
        this.mDeletedMessageUsersInfo = r88;
        this.mhas_follow_up = r89;
        this.mgeneric_stream_status = r90;
        this.mat_user_group_chatter_ids = Internal.immutableCopyOf("mat_user_group_chatter_ids", r91);
        this.mfilter_mute_bot_badge_count = r92;
        this.mfilter_mute_bot_badge_count_version = r93;
        this.mdoubao_app_show_info = r94;
        this.mcot_info = r95;
    }
}
