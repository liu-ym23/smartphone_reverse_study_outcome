package com.ss.android.lark.pb.entities;

import com.google.protobuf.server.FieldOptions;
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
public final class Chatter extends com.squareup.wire.Message<Chatter, Builder> {
    public static final ProtoAdapter<Chatter> ADAPTER = null;
    public static final Boolean DEFAULT_ACCEPT_SMS_PHONE_URGENT = null;
    public static final String DEFAULT_ACCOUNT_ID = "";
    public static final Integer DEFAULT_ACTIVE_STATUS = null;
    public static final String DEFAULT_ALIAS = "";
    public static final String DEFAULT_ANOTHER_NAME = "";
    public static final String DEFAULT_AVATAR_URL = "";
    public static final String DEFAULT_CREATOR_ID = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Long DEFAULT_DONOT_DISTURB_BEFORE_MS = null;
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_ENTERPRISE_EMAIL = "";
    public static final String DEFAULT_EN_US_NAME = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_ANONYMOUS = null;
    public static final Boolean DEFAULT_IS_FROZEN = null;
    public static final Boolean DEFAULT_IS_GUEST = null;
    public static final Boolean DEFAULT_IS_REGISTERED = null;
    public static final Boolean DEFAULT_IS_SPECIAL_FOCUS = null;
    public static final Boolean DEFAULT_IS_TENANT_CERTIFICATION = null;
    public static final Long DEFAULT_LAST_LOGIN_TIME = null;
    public static final String DEFAULT_MAJOR_LANGUAGE = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAME_PINYIN = "";
    public static final String DEFAULT_NAME_PY = "";
    public static final Integer DEFAULT_STATUS = null;
    public static final String DEFAULT_TENANT_ID = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final FieldOptions FIELD_OPTIONS_MID = null;
    private static final long serialVersionUID = 0;
    public final Boolean maccept_sms_phone_urgent;
    public final String maccount_id;
    public final Integer mactive_status;
    public final String malias;
    public final String manother_name;
    public final ImageSet mavatar;
    public final Image mavatar_image;
    public final AvatarMedal mavatar_medal;
    public final String mavatar_url;
    public final BotConfig mbot_config;
    public final List<String> mcommon_locales;
    public final String mcreator_id;
    public final List<ChatterCustomStatus> mcustom_statuses;
    public final List<Department> mdepartment;
    public final String mdescription;
    public final DescriptionFlag mdescription_flag;
    public final I18nVal mdisplay_name;
    public final Long mdonot_disturb_before_ms;
    public final String memail;
    public final String men_us_name;
    public final String menterprise_email;
    public final Map<String, String> mi18n_descriptions;
    public final I18nInf mi18n_inf;
    public final String mid;
    public final Map<String, String> minternational_name;
    public final Boolean mis_anonymous;
    public final Boolean mis_frozen;
    public final Boolean mis_guest;
    public final Boolean mis_registered;
    public final Boolean mis_special_focus;
    public final Boolean mis_tenant_certification;
    public final Long mlast_login_time;
    public final String mmajor_language;
    public final BotMutedInfo mmuted_info;
    public final String mname;
    public final String mname_pinyin;
    public final String mname_py;
    public final Integer mstatus;
    public final SubChatterType msub_type;
    public final TagData mtag_data;
    public final String mtenant_id;
    public final TenantNameStatus mtenant_name_status;
    public final TimeZone mtime_zone;
    public final ChatterType mtype;
    public final Long mupdate_time;
    public final UserConfig muser_config;
    public final WorkStatus mwork_status;

    public static final class Builder extends com.squareup.wire.Message.Builder<Chatter, Builder> {
        public Boolean maccept_sms_phone_urgent;
        public String maccount_id;
        public Integer mactive_status;
        public String malias;
        public String manother_name;
        public ImageSet mavatar;
        public Image mavatar_image;
        public AvatarMedal mavatar_medal;
        public String mavatar_url;
        public BotConfig mbot_config;
        public List<String> mcommon_locales;
        public String mcreator_id;
        public List<ChatterCustomStatus> mcustom_statuses;
        public List<Department> mdepartment;
        public String mdescription;
        public DescriptionFlag mdescription_flag;
        public I18nVal mdisplay_name;
        public Long mdonot_disturb_before_ms;
        public String memail;
        public String men_us_name;
        public String menterprise_email;
        public Map<String, String> mi18n_descriptions;
        public I18nInf mi18n_inf;
        public String mid;
        public Map<String, String> minternational_name;
        public Boolean mis_anonymous;
        public Boolean mis_frozen;
        public Boolean mis_guest;
        public Boolean mis_registered;
        public Boolean mis_special_focus;
        public Boolean mis_tenant_certification;
        public Long mlast_login_time;
        public String mmajor_language;
        public BotMutedInfo mmuted_info;
        public String mname;
        public String mname_pinyin;
        public String mname_py;
        public Integer mstatus;
        public SubChatterType msub_type;
        public TagData mtag_data;
        public String mtenant_id;
        public TenantNameStatus mtenant_name_status;
        public TimeZone mtime_zone;
        public ChatterType mtype;
        public Long mupdate_time;
        public UserConfig muser_config;
        public WorkStatus mwork_status;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Chatter m1172build() {
            return new Chatter(this.mid, this.mname, this.mavatar, this.mstatus, this.mavatar_url, this.mupdate_time, this.mname_pinyin, this.mcreator_id, this.mtype, this.mdescription, this.mis_registered, this.mname_py, this.men_us_name, this.mtenant_id, this.mdescription_flag, this.mbot_config, this.minternational_name, this.malias, this.mwork_status, this.mi18n_descriptions, this.maccount_id, this.mi18n_inf, this.muser_config, this.memail, this.mdonot_disturb_before_ms, this.maccept_sms_phone_urgent, this.mlast_login_time, this.mavatar_image, this.mtime_zone, this.mis_guest, this.mis_frozen, this.mis_anonymous, this.mdepartment, this.menterprise_email, this.mcustom_statuses, this.mavatar_medal, this.manother_name, this.mactive_status, this.mis_special_focus, this.mmajor_language, this.mmuted_info, this.mdisplay_name, this.mtag_data, this.mis_tenant_certification, this.mtenant_name_status, this.mcommon_locales, this.msub_type, super.buildUnknownFields());
        }

        public Builder() {
            this.minternational_name = Internal.newMutableMap();
            this.mi18n_descriptions = Internal.newMutableMap();
            this.mdepartment = Internal.newMutableList();
            this.mcustom_statuses = Internal.newMutableList();
            this.mcommon_locales = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1172build();
        }

        public Builder accept_sms_phone_urgent(Boolean r1) {
            this.maccept_sms_phone_urgent = r1;
            return this;
        }

        public Builder account_id(String r1) {
            this.maccount_id = r1;
            return this;
        }

        public Builder active_status(Integer r1) {
            this.mactive_status = r1;
            return this;
        }

        public Builder alias(String r1) {
            this.malias = r1;
            return this;
        }

        public Builder another_name(String r1) {
            this.manother_name = r1;
            return this;
        }

        public Builder avatar(ImageSet r1) {
            this.mavatar = r1;
            return this;
        }

        public Builder avatar_image(Image r1) {
            this.mavatar_image = r1;
            return this;
        }

        public Builder avatar_medal(AvatarMedal r1) {
            this.mavatar_medal = r1;
            return this;
        }

        public Builder avatar_url(String r1) {
            this.mavatar_url = r1;
            return this;
        }

        public Builder bot_config(BotConfig r1) {
            this.mbot_config = r1;
            return this;
        }

        public Builder common_locales(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mcommon_locales = r1;
            return this;
        }

        public Builder creator_id(String r1) {
            this.mcreator_id = r1;
            return this;
        }

        public Builder custom_statuses(List<ChatterCustomStatus> r1) {
            Internal.checkElementsNotNull(r1);
            this.mcustom_statuses = r1;
            return this;
        }

        public Builder department(List<Department> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdepartment = r1;
            return this;
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder description_flag(DescriptionFlag r1) {
            this.mdescription_flag = r1;
            return this;
        }

        public Builder display_name(I18nVal r1) {
            this.mdisplay_name = r1;
            return this;
        }

        public Builder donot_disturb_before_ms(Long r1) {
            this.mdonot_disturb_before_ms = r1;
            return this;
        }

        public Builder email(String r1) {
            this.memail = r1;
            return this;
        }

        public Builder en_us_name(String r1) {
            this.men_us_name = r1;
            return this;
        }

        public Builder enterprise_email(String r1) {
            this.menterprise_email = r1;
            return this;
        }

        public Builder i18n_descriptions(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_descriptions = r1;
            return this;
        }

        public Builder i18n_inf(I18nInf r1) {
            this.mi18n_inf = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder international_name(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.minternational_name = r1;
            return this;
        }

        public Builder is_anonymous(Boolean r1) {
            this.mis_anonymous = r1;
            return this;
        }

        public Builder is_frozen(Boolean r1) {
            this.mis_frozen = r1;
            return this;
        }

        public Builder is_guest(Boolean r1) {
            this.mis_guest = r1;
            return this;
        }

        public Builder is_registered(Boolean r1) {
            this.mis_registered = r1;
            return this;
        }

        public Builder is_special_focus(Boolean r1) {
            this.mis_special_focus = r1;
            return this;
        }

        public Builder is_tenant_certification(Boolean r1) {
            this.mis_tenant_certification = r1;
            return this;
        }

        public Builder last_login_time(Long r1) {
            this.mlast_login_time = r1;
            return this;
        }

        public Builder major_language(String r1) {
            this.mmajor_language = r1;
            return this;
        }

        public Builder muted_info(BotMutedInfo r1) {
            this.mmuted_info = r1;
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

        public Builder status(Integer r1) {
            this.mstatus = r1;
            return this;
        }

        public Builder sub_type(SubChatterType r1) {
            this.msub_type = r1;
            return this;
        }

        public Builder tag_data(TagData r1) {
            this.mtag_data = r1;
            return this;
        }

        public Builder tenant_id(String r1) {
            this.mtenant_id = r1;
            return this;
        }

        public Builder tenant_name_status(TenantNameStatus r1) {
            this.mtenant_name_status = r1;
            return this;
        }

        public Builder time_zone(TimeZone r1) {
            this.mtime_zone = r1;
            return this;
        }

        public Builder type(ChatterType r1) {
            this.mtype = r1;
            return this;
        }

        public Builder update_time(Long r1) {
            this.mupdate_time = r1;
            return this;
        }

        public Builder user_config(UserConfig r1) {
            this.muser_config = r1;
            return this;
        }

        public Builder work_status(WorkStatus r1) {
            this.mwork_status = r1;
            return this;
        }
    }

    public static final enum DescriptionFlag extends Enum<DescriptionFlag> implements WireEnum {
        private static final /* synthetic */ DescriptionFlag[] $VALUES = null;
        public static final ProtoAdapter<DescriptionFlag> ADAPTER = null;
        public static final DescriptionFlag DEFAULT = null;
        public static final DescriptionFlag ON_BUSINESS = null;
        public static final DescriptionFlag ON_LEAVE = null;
        public static final DescriptionFlag ON_MEETING = null;
        private final int value;

        static {
            DescriptionFlag r0 = new DescriptionFlag("DEFAULT", 0, 0);
            DEFAULT = r0;
            DescriptionFlag r1 = new DescriptionFlag("ON_BUSINESS", 1, 1);
            ON_BUSINESS = r1;
            DescriptionFlag r3 = new DescriptionFlag("ON_LEAVE", 2, 2);
            ON_LEAVE = r3;
            DescriptionFlag r5 = new DescriptionFlag("ON_MEETING", 3, 3);
            ON_MEETING = r5;
            $VALUES = new DescriptionFlag[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(DescriptionFlag.class);
        }

        public static DescriptionFlag[] values() {
            return (DescriptionFlag[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static DescriptionFlag fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return ON_MEETING;
        L14:
            return ON_LEAVE;
        L16:
            return ON_BUSINESS;
        L18:
            return DEFAULT;
        }

        public static DescriptionFlag valueOf(String r1) {
            return (DescriptionFlag) a.a(DescriptionFlag.class, r1);
        }

        private DescriptionFlag(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class I18nInf extends com.squareup.wire.Message<I18nInf, Builder> {
        public static final ProtoAdapter<I18nInf> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<String, String> mi18n_descriptions;

        public static final class Builder extends com.squareup.wire.Message.Builder<I18nInf, Builder> {
            public Map<String, String> mi18n_descriptions;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public I18nInf m1174build() {
                return new I18nInf(this.mi18n_descriptions, super.buildUnknownFields());
            }

            public Builder() {
                this.mi18n_descriptions = Internal.newMutableMap();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1174build();
            }

            public Builder i18n_descriptions(Map<String, String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mi18n_descriptions = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_I18nInf extends ProtoAdapter<I18nInf> {
            private final ProtoAdapter<Map<String, String>> mi18n_descriptions;

            public ProtoAdapter_I18nInf() {
                super(FieldEncoding.LENGTH_DELIMITED, I18nInf.class);
                ProtoAdapter r0 = ProtoAdapter.STRING;
                this.mi18n_descriptions = ProtoAdapter.newMapAdapter(r0, r0);
            }

            public I18nInf decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mi18n_descriptions.putAll((Map) this.mi18n_descriptions.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1174build();
            }

            public int encodedSize(I18nInf r4) {
                return this.mi18n_descriptions.encodedSizeWithTag(1, r4.mi18n_descriptions) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1175decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((I18nInf) r1);
            }

            public void encode(ProtoWriter r4, I18nInf r5) throws IOException {
                this.mi18n_descriptions.encodeWithTag(r4, 1, r5.mi18n_descriptions);
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
        public Builder m1173newBuilder() {
            Builder r0 = new Builder();
            r0.mi18n_descriptions = Internal.copyOf("mi18n_descriptions", this.mi18n_descriptions);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return I18nInf.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1173newBuilder();
        }

        public I18nInf(Map<String, String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public I18nInf(Map<String, String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mi18n_descriptions = Internal.immutableCopyOf("mi18n_descriptions", r2);
        }
    }

    public static final class ProtoAdapter_Chatter extends ProtoAdapter<Chatter> {
        private final ProtoAdapter<Map<String, String>> mi18n_descriptions;
        private final ProtoAdapter<Map<String, String>> minternational_name;

        public ProtoAdapter_Chatter() {
            super(FieldEncoding.LENGTH_DELIMITED, Chatter.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.minternational_name = ProtoAdapter.newMapAdapter(r0, r0);
            this.mi18n_descriptions = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public Chatter decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mname = "";
            r0.mstatus = 0;
            r0.mavatar_url = "";
            r0.mupdate_time = 0L;
            r0.mname_pinyin = "";
            r0.mcreator_id = "";
            r0.mdescription = "";
            Boolean r4 = Boolean.FALSE;
            r0.mis_registered = r4;
            r0.mname_py = "";
            r0.men_us_name = "";
            r0.mtenant_id = "";
            r0.malias = "";
            r0.maccount_id = "";
            r0.memail = "";
            r0.mdonot_disturb_before_ms = 0L;
            r0.maccept_sms_phone_urgent = r4;
            r0.mlast_login_time = 0L;
            r0.mis_guest = r4;
            r0.mis_frozen = r4;
            r0.mis_anonymous = r4;
            r0.menterprise_email = "";
            r0.manother_name = "";
            r0.mactive_status = 0;
            r0.mis_special_focus = r4;
            r0.mmajor_language = "";
            r0.mis_tenant_certification = r4;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L66;
            switch(r3) {
                case 1: goto L65;
                case 2: goto L64;
                case 3: goto L63;
                case 4: goto L62;
                case 5: goto L61;
                case 6: goto L60;
                case 7: goto L59;
                case 8: goto L58;
                case 9: goto L70;
                case 10: goto L6;
                case 11: goto L53;
                case 12: goto L52;
                case 13: goto L51;
                case 14: goto L50;
                case 15: goto L49;
                case 16: goto L74;
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
                case 43: goto L18;
                case 44: goto L17;
                case 45: goto L16;
                case 46: goto L72;
                case 47: goto L11;
                case 48: goto L68;
                default: goto L6;
            };
        L68:
            r0.msub_type = (SubChatterType) SubChatterType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L70:
            r0.mtype = (ChatterType) ChatterType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L56
        L56:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L72:
            r0.mtenant_name_status = (TenantNameStatus) TenantNameStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L74:
            r0.mdescription_flag = (DescriptionFlag) DescriptionFlag.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L47
        L47:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r0.mcommon_locales.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L16:
            r0.mis_tenant_certification = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L17:
            r0.mtag_data = (TagData) TagData.ADAPTER.decode(r9);
            goto L3
        L18:
            r0.mdisplay_name = (I18nVal) I18nVal.ADAPTER.decode(r9);
            goto L3
        L19:
            r0.mmuted_info = (BotMutedInfo) BotMutedInfo.ADAPTER.decode(r9);
            goto L3
        L20:
            r0.mmajor_language = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L21:
            r0.mis_special_focus = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L22:
            r0.mactive_status = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L23:
            r0.manother_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L24:
            r0.mavatar_medal = (AvatarMedal) AvatarMedal.ADAPTER.decode(r9);
            goto L3
        L25:
            r0.mcustom_statuses.add((ChatterCustomStatus) ChatterCustomStatus.ADAPTER.decode(r9));
            goto L3
        L26:
            r0.menterprise_email = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L27:
            r0.mdepartment.add((Department) Department.ADAPTER.decode(r9));
            goto L3
        L28:
            r0.mis_anonymous = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L29:
            r0.mis_frozen = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L30:
            r0.mis_guest = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L31:
            r0.mtime_zone = (TimeZone) TimeZone.ADAPTER.decode(r9);
            goto L3
        L32:
            r0.mavatar_image = (Image) Image.ADAPTER.decode(r9);
            goto L3
        L33:
            r0.mlast_login_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L34:
            r0.maccept_sms_phone_urgent = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L35:
            r0.mdonot_disturb_before_ms = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L36:
            r0.memail = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L37:
            r0.muser_config = (UserConfig) UserConfig.ADAPTER.decode(r9);
            goto L3
        L38:
            r0.mi18n_inf = (I18nInf) I18nInf.ADAPTER.decode(r9);
            goto L3
        L39:
            r0.maccount_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L40:
            r0.mi18n_descriptions.putAll((Map) this.mi18n_descriptions.decode(r9));
            goto L3
        L41:
            r0.mwork_status = (WorkStatus) WorkStatus.ADAPTER.decode(r9);
            goto L3
        L42:
            r0.malias = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L43:
            r0.minternational_name.putAll((Map) this.minternational_name.decode(r9));
            goto L3
        L44:
            r0.mbot_config = (BotConfig) BotConfig.ADAPTER.decode(r9);
            goto L3
        L49:
            r0.mtenant_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L50:
            r0.men_us_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L51:
            r0.mname_py = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L52:
            r0.mis_registered = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L53:
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L58:
            r0.mcreator_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L59:
            r0.mname_pinyin = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L60:
            r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L61:
            r0.mavatar_url = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L62:
            r0.mstatus = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L63:
            r0.mavatar = (ImageSet) ImageSet.ADAPTER.decode(r9);
            goto L3
        L64:
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L65:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r5 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r5, r5.rawProtoAdapter().decode(r9));
            goto L3
        L66:
            r9.endMessage(r1);
            return r0.m1172build();
        }

        public int encodedSize(Chatter r6) {
            String r0 = r6.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mname;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ImageSet r7 = r6.mavatar;
            if (r7 == null) goto L13;
            int r8 = ImageSet.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Integer r10 = r6.mstatus;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT32.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mavatar_url;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Long r16 = r6.mupdate_time;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.INT64.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.mname_pinyin;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r6.mcreator_id;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            ChatterType r25 = r6.mtype;
            if (r25 == null) goto L37;
            int r26 = ChatterType.ADAPTER.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            String r28 = r6.mdescription;
            if (r28 == null) goto L41;
            int r29 = ProtoAdapter.STRING.encodedSizeWithTag(11, r28);
        L42:
            int r30 = r27 + r29;
            Boolean r31 = r6.mis_registered;
            if (r31 == null) goto L45;
            int r32 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r31);
        L46:
            int r33 = r30 + r32;
            String r34 = r6.mname_py;
            if (r34 == null) goto L49;
            int r35 = ProtoAdapter.STRING.encodedSizeWithTag(13, r34);
        L50:
            int r36 = r33 + r35;
            String r37 = r6.men_us_name;
            if (r37 == null) goto L53;
            int r38 = ProtoAdapter.STRING.encodedSizeWithTag(14, r37);
        L54:
            int r39 = r36 + r38;
            String r40 = r6.mtenant_id;
            if (r40 == null) goto L57;
            int r41 = ProtoAdapter.STRING.encodedSizeWithTag(15, r40);
        L58:
            int r42 = r39 + r41;
            DescriptionFlag r43 = r6.mdescription_flag;
            if (r43 == null) goto L61;
            int r44 = DescriptionFlag.ADAPTER.encodedSizeWithTag(16, r43);
        L62:
            int r45 = r42 + r44;
            BotConfig r46 = r6.mbot_config;
            if (r46 == null) goto L65;
            int r47 = BotConfig.ADAPTER.encodedSizeWithTag(17, r46);
        L66:
            int r48 = (r45 + r47) + this.minternational_name.encodedSizeWithTag(18, r6.minternational_name);
            String r49 = r6.malias;
            if (r49 == null) goto L69;
            int r50 = ProtoAdapter.STRING.encodedSizeWithTag(19, r49);
        L70:
            int r51 = r48 + r50;
            WorkStatus r52 = r6.mwork_status;
            if (r52 == null) goto L73;
            int r53 = WorkStatus.ADAPTER.encodedSizeWithTag(20, r52);
        L74:
            int r54 = (r51 + r53) + this.mi18n_descriptions.encodedSizeWithTag(21, r6.mi18n_descriptions);
            String r55 = r6.maccount_id;
            if (r55 == null) goto L77;
            int r56 = ProtoAdapter.STRING.encodedSizeWithTag(22, r55);
        L78:
            int r57 = r54 + r56;
            I18nInf r58 = r6.mi18n_inf;
            if (r58 == null) goto L81;
            int r59 = I18nInf.ADAPTER.encodedSizeWithTag(23, r58);
        L82:
            int r60 = r57 + r59;
            UserConfig r61 = r6.muser_config;
            if (r61 == null) goto L85;
            int r62 = UserConfig.ADAPTER.encodedSizeWithTag(24, r61);
        L86:
            int r63 = r60 + r62;
            String r64 = r6.memail;
            if (r64 == null) goto L89;
            int r65 = ProtoAdapter.STRING.encodedSizeWithTag(25, r64);
        L90:
            int r66 = r63 + r65;
            Long r67 = r6.mdonot_disturb_before_ms;
            if (r67 == null) goto L93;
            int r68 = ProtoAdapter.INT64.encodedSizeWithTag(26, r67);
        L94:
            int r69 = r66 + r68;
            Boolean r70 = r6.maccept_sms_phone_urgent;
            if (r70 == null) goto L97;
            int r71 = ProtoAdapter.BOOL.encodedSizeWithTag(27, r70);
        L98:
            int r72 = r69 + r71;
            Long r73 = r6.mlast_login_time;
            if (r73 == null) goto L101;
            int r74 = ProtoAdapter.INT64.encodedSizeWithTag(28, r73);
        L102:
            int r75 = r72 + r74;
            Image r76 = r6.mavatar_image;
            if (r76 == null) goto L105;
            int r77 = Image.ADAPTER.encodedSizeWithTag(29, r76);
        L106:
            int r78 = r75 + r77;
            TimeZone r79 = r6.mtime_zone;
            if (r79 == null) goto L109;
            int r80 = TimeZone.ADAPTER.encodedSizeWithTag(30, r79);
        L110:
            int r81 = r78 + r80;
            Boolean r82 = r6.mis_guest;
            if (r82 == null) goto L113;
            int r83 = ProtoAdapter.BOOL.encodedSizeWithTag(31, r82);
        L114:
            int r84 = r81 + r83;
            Boolean r85 = r6.mis_frozen;
            if (r85 == null) goto L117;
            int r86 = ProtoAdapter.BOOL.encodedSizeWithTag(32, r85);
        L118:
            int r87 = r84 + r86;
            Boolean r88 = r6.mis_anonymous;
            if (r88 == null) goto L121;
            int r89 = ProtoAdapter.BOOL.encodedSizeWithTag(33, r88);
        L122:
            int r90 = (r87 + r89) + Department.ADAPTER.asRepeated().encodedSizeWithTag(34, r6.mdepartment);
            String r91 = r6.menterprise_email;
            if (r91 == null) goto L125;
            int r92 = ProtoAdapter.STRING.encodedSizeWithTag(35, r91);
        L126:
            int r93 = (r90 + r92) + ChatterCustomStatus.ADAPTER.asRepeated().encodedSizeWithTag(36, r6.mcustom_statuses);
            AvatarMedal r94 = r6.mavatar_medal;
            if (r94 == null) goto L129;
            int r95 = AvatarMedal.ADAPTER.encodedSizeWithTag(37, r94);
        L130:
            int r96 = r93 + r95;
            String r97 = r6.manother_name;
            if (r97 == null) goto L133;
            int r98 = ProtoAdapter.STRING.encodedSizeWithTag(38, r97);
        L134:
            int r99 = r96 + r98;
            Integer r100 = r6.mactive_status;
            if (r100 == null) goto L137;
            int r101 = ProtoAdapter.INT32.encodedSizeWithTag(39, r100);
        L138:
            int r102 = r99 + r101;
            Boolean r103 = r6.mis_special_focus;
            if (r103 == null) goto L141;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(40, r103);
        L142:
            int r105 = r102 + r104;
            String r106 = r6.mmajor_language;
            if (r106 == null) goto L145;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(41, r106);
        L146:
            int r108 = r105 + r107;
            BotMutedInfo r109 = r6.mmuted_info;
            if (r109 == null) goto L149;
            int r110 = BotMutedInfo.ADAPTER.encodedSizeWithTag(42, r109);
        L150:
            int r111 = r108 + r110;
            I18nVal r112 = r6.mdisplay_name;
            if (r112 == null) goto L153;
            int r113 = I18nVal.ADAPTER.encodedSizeWithTag(43, r112);
        L154:
            int r114 = r111 + r113;
            TagData r115 = r6.mtag_data;
            if (r115 == null) goto L157;
            int r116 = TagData.ADAPTER.encodedSizeWithTag(44, r115);
        L158:
            int r117 = r114 + r116;
            Boolean r118 = r6.mis_tenant_certification;
            if (r118 == null) goto L161;
            int r119 = ProtoAdapter.BOOL.encodedSizeWithTag(45, r118);
        L162:
            int r120 = r117 + r119;
            TenantNameStatus r121 = r6.mtenant_name_status;
            if (r121 == null) goto L165;
            int r122 = TenantNameStatus.ADAPTER.encodedSizeWithTag(46, r121);
        L166:
            int r123 = (r120 + r122) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(47, r6.mcommon_locales);
            SubChatterType r124 = r6.msub_type;
            if (r124 == null) goto L170;
            r1 = SubChatterType.ADAPTER.encodedSizeWithTag(48, r124);
        L170:
            return (r123 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m1176decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Chatter) r1);
        }

        public void encode(ProtoWriter r4, Chatter r5) throws IOException {
            String r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mname;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            ImageSet r2 = r5.mavatar;
            if (r2 == null) goto L11;
            ImageSet.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            Integer r3 = r5.mstatus;
            if (r3 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mavatar_url;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            Long r7 = r5.mupdate_time;
            if (r7 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r4, 6, r7);
        L20:
            String r8 = r5.mname_pinyin;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
        L23:
            String r9 = r5.mcreator_id;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r9);
        L26:
            ChatterType r10 = r5.mtype;
            if (r10 == null) goto L29;
            ChatterType.ADAPTER.encodeWithTag(r4, 9, r10);
        L29:
            String r11 = r5.mdescription;
            if (r11 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r4, 11, r11);
        L32:
            Boolean r12 = r5.mis_registered;
            if (r12 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r4, 12, r12);
        L35:
            String r13 = r5.mname_py;
            if (r13 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r4, 13, r13);
        L38:
            String r14 = r5.men_us_name;
            if (r14 == null) goto L41;
            ProtoAdapter.STRING.encodeWithTag(r4, 14, r14);
        L41:
            String r15 = r5.mtenant_id;
            if (r15 == null) goto L44;
            ProtoAdapter.STRING.encodeWithTag(r4, 15, r15);
        L44:
            DescriptionFlag r16 = r5.mdescription_flag;
            if (r16 == null) goto L47;
            DescriptionFlag.ADAPTER.encodeWithTag(r4, 16, r16);
        L47:
            BotConfig r17 = r5.mbot_config;
            if (r17 == null) goto L50;
            BotConfig.ADAPTER.encodeWithTag(r4, 17, r17);
        L50:
            this.minternational_name.encodeWithTag(r4, 18, r5.minternational_name);
            String r18 = r5.malias;
            if (r18 == null) goto L53;
            ProtoAdapter.STRING.encodeWithTag(r4, 19, r18);
        L53:
            WorkStatus r19 = r5.mwork_status;
            if (r19 == null) goto L56;
            WorkStatus.ADAPTER.encodeWithTag(r4, 20, r19);
        L56:
            this.mi18n_descriptions.encodeWithTag(r4, 21, r5.mi18n_descriptions);
            String r20 = r5.maccount_id;
            if (r20 == null) goto L59;
            ProtoAdapter.STRING.encodeWithTag(r4, 22, r20);
        L59:
            I18nInf r21 = r5.mi18n_inf;
            if (r21 == null) goto L62;
            I18nInf.ADAPTER.encodeWithTag(r4, 23, r21);
        L62:
            UserConfig r22 = r5.muser_config;
            if (r22 == null) goto L65;
            UserConfig.ADAPTER.encodeWithTag(r4, 24, r22);
        L65:
            String r23 = r5.memail;
            if (r23 == null) goto L68;
            ProtoAdapter.STRING.encodeWithTag(r4, 25, r23);
        L68:
            Long r24 = r5.mdonot_disturb_before_ms;
            if (r24 == null) goto L71;
            ProtoAdapter.INT64.encodeWithTag(r4, 26, r24);
        L71:
            Boolean r25 = r5.maccept_sms_phone_urgent;
            if (r25 == null) goto L74;
            ProtoAdapter.BOOL.encodeWithTag(r4, 27, r25);
        L74:
            Long r26 = r5.mlast_login_time;
            if (r26 == null) goto L77;
            ProtoAdapter.INT64.encodeWithTag(r4, 28, r26);
        L77:
            Image r27 = r5.mavatar_image;
            if (r27 == null) goto L80;
            Image.ADAPTER.encodeWithTag(r4, 29, r27);
        L80:
            TimeZone r28 = r5.mtime_zone;
            if (r28 == null) goto L83;
            TimeZone.ADAPTER.encodeWithTag(r4, 30, r28);
        L83:
            Boolean r29 = r5.mis_guest;
            if (r29 == null) goto L86;
            ProtoAdapter.BOOL.encodeWithTag(r4, 31, r29);
        L86:
            Boolean r30 = r5.mis_frozen;
            if (r30 == null) goto L89;
            ProtoAdapter.BOOL.encodeWithTag(r4, 32, r30);
        L89:
            Boolean r31 = r5.mis_anonymous;
            if (r31 == null) goto L92;
            ProtoAdapter.BOOL.encodeWithTag(r4, 33, r31);
        L92:
            Department.ADAPTER.asRepeated().encodeWithTag(r4, 34, r5.mdepartment);
            String r32 = r5.menterprise_email;
            if (r32 == null) goto L95;
            ProtoAdapter.STRING.encodeWithTag(r4, 35, r32);
        L95:
            ChatterCustomStatus.ADAPTER.asRepeated().encodeWithTag(r4, 36, r5.mcustom_statuses);
            AvatarMedal r33 = r5.mavatar_medal;
            if (r33 == null) goto L98;
            AvatarMedal.ADAPTER.encodeWithTag(r4, 37, r33);
        L98:
            String r34 = r5.manother_name;
            if (r34 == null) goto L101;
            ProtoAdapter.STRING.encodeWithTag(r4, 38, r34);
        L101:
            Integer r35 = r5.mactive_status;
            if (r35 == null) goto L104;
            ProtoAdapter.INT32.encodeWithTag(r4, 39, r35);
        L104:
            Boolean r36 = r5.mis_special_focus;
            if (r36 == null) goto L107;
            ProtoAdapter.BOOL.encodeWithTag(r4, 40, r36);
        L107:
            String r37 = r5.mmajor_language;
            if (r37 == null) goto L110;
            ProtoAdapter.STRING.encodeWithTag(r4, 41, r37);
        L110:
            BotMutedInfo r38 = r5.mmuted_info;
            if (r38 == null) goto L113;
            BotMutedInfo.ADAPTER.encodeWithTag(r4, 42, r38);
        L113:
            I18nVal r39 = r5.mdisplay_name;
            if (r39 == null) goto L116;
            I18nVal.ADAPTER.encodeWithTag(r4, 43, r39);
        L116:
            TagData r40 = r5.mtag_data;
            if (r40 == null) goto L119;
            TagData.ADAPTER.encodeWithTag(r4, 44, r40);
        L119:
            Boolean r41 = r5.mis_tenant_certification;
            if (r41 == null) goto L122;
            ProtoAdapter.BOOL.encodeWithTag(r4, 45, r41);
        L122:
            TenantNameStatus r42 = r5.mtenant_name_status;
            if (r42 == null) goto L125;
            TenantNameStatus.ADAPTER.encodeWithTag(r4, 46, r42);
        L125:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 47, r5.mcommon_locales);
            SubChatterType r43 = r5.msub_type;
            if (r43 == null) goto L128;
            SubChatterType.ADAPTER.encodeWithTag(r4, 48, r43);
        L128:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Chatter) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Chatter();
        FIELD_OPTIONS_MID = new FieldOptions.Builder().id("user_id").build();
        DEFAULT_STATUS = 0;
        DEFAULT_UPDATE_TIME = 0L;
        Boolean r2 = Boolean.FALSE;
        DEFAULT_IS_REGISTERED = r2;
        DEFAULT_DONOT_DISTURB_BEFORE_MS = 0L;
        DEFAULT_ACCEPT_SMS_PHONE_URGENT = r2;
        DEFAULT_LAST_LOGIN_TIME = 0L;
        DEFAULT_IS_GUEST = r2;
        DEFAULT_IS_FROZEN = r2;
        DEFAULT_IS_ANONYMOUS = r2;
        DEFAULT_ACTIVE_STATUS = 0;
        DEFAULT_IS_SPECIAL_FOCUS = r2;
        DEFAULT_IS_TENANT_CERTIFICATION = r2;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1171newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.mavatar = this.mavatar;
        r0.mstatus = this.mstatus;
        r0.mavatar_url = this.mavatar_url;
        r0.mupdate_time = this.mupdate_time;
        r0.mname_pinyin = this.mname_pinyin;
        r0.mcreator_id = this.mcreator_id;
        r0.mtype = this.mtype;
        r0.mdescription = this.mdescription;
        r0.mis_registered = this.mis_registered;
        r0.mname_py = this.mname_py;
        r0.men_us_name = this.men_us_name;
        r0.mtenant_id = this.mtenant_id;
        r0.mdescription_flag = this.mdescription_flag;
        r0.mbot_config = this.mbot_config;
        r0.minternational_name = Internal.copyOf("minternational_name", this.minternational_name);
        r0.malias = this.malias;
        r0.mwork_status = this.mwork_status;
        r0.mi18n_descriptions = Internal.copyOf("mi18n_descriptions", this.mi18n_descriptions);
        r0.maccount_id = this.maccount_id;
        r0.mi18n_inf = this.mi18n_inf;
        r0.muser_config = this.muser_config;
        r0.memail = this.memail;
        r0.mdonot_disturb_before_ms = this.mdonot_disturb_before_ms;
        r0.maccept_sms_phone_urgent = this.maccept_sms_phone_urgent;
        r0.mlast_login_time = this.mlast_login_time;
        r0.mavatar_image = this.mavatar_image;
        r0.mtime_zone = this.mtime_zone;
        r0.mis_guest = this.mis_guest;
        r0.mis_frozen = this.mis_frozen;
        r0.mis_anonymous = this.mis_anonymous;
        r0.mdepartment = Internal.copyOf("mdepartment", this.mdepartment);
        r0.menterprise_email = this.menterprise_email;
        r0.mcustom_statuses = Internal.copyOf("mcustom_statuses", this.mcustom_statuses);
        r0.mavatar_medal = this.mavatar_medal;
        r0.manother_name = this.manother_name;
        r0.mactive_status = this.mactive_status;
        r0.mis_special_focus = this.mis_special_focus;
        r0.mmajor_language = this.mmajor_language;
        r0.mmuted_info = this.mmuted_info;
        r0.mdisplay_name = this.mdisplay_name;
        r0.mtag_data = this.mtag_data;
        r0.mis_tenant_certification = this.mis_tenant_certification;
        r0.mtenant_name_status = this.mtenant_name_status;
        r0.mcommon_locales = Internal.copyOf("mcommon_locales", this.mcommon_locales);
        r0.msub_type = this.msub_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Chatter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1171newBuilder();
    }

    public Chatter(String r50, String r51, ImageSet r52, Integer r53, String r54, Long r55, String r56, String r57, ChatterType r58, String r59, Boolean r60, String r61, String r62, String r63, DescriptionFlag r64, BotConfig r65, Map<String, String> r66, String r67, WorkStatus r68, Map<String, String> r69, String r70, I18nInf r71, UserConfig r72, String r73, Long r74, Boolean r75, Long r76, Image r77, TimeZone r78, Boolean r79, Boolean r80, Boolean r81, List<Department> r82, String r83, List<ChatterCustomStatus> r84, AvatarMedal r85, String r86, Integer r87, Boolean r88, String r89, BotMutedInfo r90, I18nVal r91, TagData r92, Boolean r93, TenantNameStatus r94, List<String> r95, SubChatterType r96) {
        this(r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, ByteString.EMPTY);
    }

    public Chatter(String r4, String r5, ImageSet r6, Integer r7, String r8, Long r9, String r10, String r11, ChatterType r12, String r13, Boolean r14, String r15, String r16, String r17, DescriptionFlag r18, BotConfig r19, Map<String, String> r20, String r21, WorkStatus r22, Map<String, String> r23, String r24, I18nInf r25, UserConfig r26, String r27, Long r28, Boolean r29, Long r30, Image r31, TimeZone r32, Boolean r33, Boolean r34, Boolean r35, List<Department> r36, String r37, List<ChatterCustomStatus> r38, AvatarMedal r39, String r40, Integer r41, Boolean r42, String r43, BotMutedInfo r44, I18nVal r45, TagData r46, Boolean r47, TenantNameStatus r48, List<String> r49, SubChatterType r50, ByteString r51) {
        super(ADAPTER, r51);
        this.mid = r4;
        this.mname = r5;
        this.mavatar = r6;
        this.mstatus = r7;
        this.mavatar_url = r8;
        this.mupdate_time = r9;
        this.mname_pinyin = r10;
        this.mcreator_id = r11;
        this.mtype = r12;
        this.mdescription = r13;
        this.mis_registered = r14;
        this.mname_py = r15;
        this.men_us_name = r16;
        this.mtenant_id = r17;
        this.mdescription_flag = r18;
        this.mbot_config = r19;
        this.minternational_name = Internal.immutableCopyOf("minternational_name", r20);
        this.malias = r21;
        this.mwork_status = r22;
        this.mi18n_descriptions = Internal.immutableCopyOf("mi18n_descriptions", r23);
        this.maccount_id = r24;
        this.mi18n_inf = r25;
        this.muser_config = r26;
        this.memail = r27;
        this.mdonot_disturb_before_ms = r28;
        this.maccept_sms_phone_urgent = r29;
        this.mlast_login_time = r30;
        this.mavatar_image = r31;
        this.mtime_zone = r32;
        this.mis_guest = r33;
        this.mis_frozen = r34;
        this.mis_anonymous = r35;
        this.mdepartment = Internal.immutableCopyOf("mdepartment", r36);
        this.menterprise_email = r37;
        this.mcustom_statuses = Internal.immutableCopyOf("mcustom_statuses", r38);
        this.mavatar_medal = r39;
        this.manother_name = r40;
        this.mactive_status = r41;
        this.mis_special_focus = r42;
        this.mmajor_language = r43;
        this.mmuted_info = r44;
        this.mdisplay_name = r45;
        this.mtag_data = r46;
        this.mis_tenant_certification = r47;
        this.mtenant_name_status = r48;
        this.mcommon_locales = Internal.immutableCopyOf("mcommon_locales", r49);
        this.msub_type = r50;
    }
}
