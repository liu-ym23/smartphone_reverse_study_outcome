package com.ss.android.lark.pb.usearch;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.ChatterCustomStatus;
import com.ss.android.lark.pb.entities.TagData;
import com.ss.android.lark.pb.misc.DeniedReason;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserMeta extends Message<UserMeta, Builder> {
    public static final ProtoAdapter<UserMeta> ADAPTER = null;
    public static final Boolean DEFAULT_ACCEPT_SMS_PHONE_URGENT = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Long DEFAULT_DO_NOT_DISTURB_END_TIME = null;
    public static final String DEFAULT_ENTERPRISE_MAIL_ADDRESS = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_REGISTERED = null;
    public static final String DEFAULT_MAIL_ADDRESS = "";
    public static final String DEFAULT_TENANT_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MID = null;
    public static final FieldOptions FIELD_OPTIONS_MTENANT_ID = null;
    private static final long serialVersionUID = 0;
    public final Boolean maccept_sms_phone_urgent;
    public final DeniedReason mblock_status;
    public final String mchat_id;
    public final List<ChatterCustomStatus> mcustom_statuses;
    public final String mdescription;
    public final Long mdo_not_disturb_end_time;
    public final EmployeeKind memployee_kind;
    public final String menterprise_mail_address;
    public final ExtraFields mextraFields;
    public final Map<String, String> mi18n_names;
    public final String mid;
    public final Boolean mis_cross_tenant;
    public final Boolean mis_registered;
    public final String mmail_address;
    public final TagData mrelation_tag;
    public final String mtenant_id;

    public static final class Builder extends Message.Builder<UserMeta, Builder> {
        public Boolean maccept_sms_phone_urgent;
        public DeniedReason mblock_status;
        public String mchat_id;
        public List<ChatterCustomStatus> mcustom_statuses;
        public String mdescription;
        public Long mdo_not_disturb_end_time;
        public EmployeeKind memployee_kind;
        public String menterprise_mail_address;
        public ExtraFields mextraFields;
        public Map<String, String> mi18n_names;
        public String mid;
        public Boolean mis_cross_tenant;
        public Boolean mis_registered;
        public String mmail_address;
        public TagData mrelation_tag;
        public String mtenant_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UserMeta m2969build() {
            String r1 = this.mid;
            if (r1 == null) goto L7;
            return new UserMeta(this.mid, this.mis_registered, this.mtenant_id, this.mmail_address, this.mdo_not_disturb_end_time, this.maccept_sms_phone_urgent, this.mchat_id, this.mextraFields, this.menterprise_mail_address, this.mcustom_statuses, this.mi18n_names, this.mis_cross_tenant, this.mrelation_tag, this.mblock_status, this.mdescription, this.memployee_kind, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r1, "mid"});
        }

        public Builder() {
            this.mcustom_statuses = Internal.newMutableList();
            this.mi18n_names = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2969build();
        }

        public Builder accept_sms_phone_urgent(Boolean r1) {
            this.maccept_sms_phone_urgent = r1;
            return this;
        }

        public Builder block_status(DeniedReason r1) {
            this.mblock_status = r1;
            return this;
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder custom_statuses(List<ChatterCustomStatus> r1) {
            Internal.checkElementsNotNull(r1);
            this.mcustom_statuses = r1;
            return this;
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder do_not_disturb_end_time(Long r1) {
            this.mdo_not_disturb_end_time = r1;
            return this;
        }

        public Builder employee_kind(EmployeeKind r1) {
            this.memployee_kind = r1;
            return this;
        }

        public Builder enterprise_mail_address(String r1) {
            this.menterprise_mail_address = r1;
            return this;
        }

        public Builder extraFields(ExtraFields r1) {
            this.mextraFields = r1;
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

        public Builder is_cross_tenant(Boolean r1) {
            this.mis_cross_tenant = r1;
            return this;
        }

        public Builder is_registered(Boolean r1) {
            this.mis_registered = r1;
            return this;
        }

        public Builder mail_address(String r1) {
            this.mmail_address = r1;
            return this;
        }

        public Builder relation_tag(TagData r1) {
            this.mrelation_tag = r1;
            return this;
        }

        public Builder tenant_id(String r1) {
            this.mtenant_id = r1;
            return this;
        }
    }

    public static final class ExtraFields extends Message<ExtraFields, Builder> {
        public static final ProtoAdapter<ExtraFields> ADAPTER = null;
        public static final Boolean DEFAULT_IS_DIRECTLY_IN_TEAM = null;
        public static final Boolean DEFAULT_IS_IN_CHAT = null;
        public static final Boolean DEFAULT_IS_READ_MESSAGE = null;
        private static final long serialVersionUID = 0;
        public final Boolean mis_directly_in_team;
        public final Boolean mis_in_chat;
        public final Boolean mis_read_message;

        public static final class Builder extends Message.Builder<ExtraFields, Builder> {
            public Boolean mis_directly_in_team;
            public Boolean mis_in_chat;
            public Boolean mis_read_message;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ExtraFields m2971build() {
                return new ExtraFields(this.mis_in_chat, this.mis_read_message, this.mis_directly_in_team, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2971build();
            }

            public Builder is_directly_in_team(Boolean r1) {
                this.mis_directly_in_team = r1;
                return this;
            }

            public Builder is_in_chat(Boolean r1) {
                this.mis_in_chat = r1;
                return this;
            }

            public Builder is_read_message(Boolean r1) {
                this.mis_read_message = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ExtraFields extends ProtoAdapter<ExtraFields> {
            public ProtoAdapter_ExtraFields() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtraFields.class);
            }

            public ExtraFields decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.mis_in_chat = r1;
                r0.mis_read_message = r1;
                r0.mis_directly_in_team = r1;
                long r2 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mis_in_chat = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mis_read_message = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mis_directly_in_team = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r2);
                return r0.m2971build();
            }

            public int encodedSize(ExtraFields r6) {
                Boolean r0 = r6.mis_in_chat;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r6.mis_read_message;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Boolean r7 = r6.mis_directly_in_team;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
            L14:
                return (r5 + r1) + r6.unknownFields().size();
            L9:
                r4 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2972decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ExtraFields) r1);
            }

            public void encode(ProtoWriter r4, ExtraFields r5) throws IOException {
                Boolean r0 = r5.mis_in_chat;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mis_read_message;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                Boolean r2 = r5.mis_directly_in_team;
                if (r2 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ExtraFields) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ExtraFields();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_IS_IN_CHAT = r0;
            DEFAULT_IS_READ_MESSAGE = r0;
            DEFAULT_IS_DIRECTLY_IN_TEAM = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2970newBuilder() {
            Builder r0 = new Builder();
            r0.mis_in_chat = this.mis_in_chat;
            r0.mis_read_message = this.mis_read_message;
            r0.mis_directly_in_team = this.mis_directly_in_team;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ExtraFields.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2970newBuilder();
        }

        public ExtraFields(Boolean r2, Boolean r3, Boolean r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public ExtraFields(Boolean r2, Boolean r3, Boolean r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mis_in_chat = r2;
            this.mis_read_message = r3;
            this.mis_directly_in_team = r4;
        }
    }

    public static final class ProtoAdapter_UserMeta extends ProtoAdapter<UserMeta> {
        private final ProtoAdapter<Map<String, String>> mi18n_names;

        public ProtoAdapter_UserMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, UserMeta.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mi18n_names = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public UserMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            Boolean r2 = Boolean.FALSE;
            r0.mis_registered = r2;
            r0.mtenant_id = "";
            r0.mmail_address = "";
            r0.mdo_not_disturb_end_time = 0L;
            r0.maccept_sms_phone_urgent = r2;
            r0.mchat_id = "";
            r0.menterprise_mail_address = "";
            r0.mis_cross_tenant = r2;
            r0.mdescription = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L29;
            switch(r3) {
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L22;
                case 8: goto L21;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L18;
                case 12: goto L17;
                case 13: goto L16;
                case 14: goto L33;
                case 15: goto L11;
                case 16: goto L31;
                default: goto L6;
            };
        L31:
            r0.memployee_kind = (EmployeeKind) EmployeeKind.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L33:
            r0.mblock_status = (DeniedReason) DeniedReason.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.mrelation_tag = (TagData) TagData.ADAPTER.decode(r9);
            goto L3
        L17:
            r0.mis_cross_tenant = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L18:
            r0.mi18n_names.putAll((Map) this.mi18n_names.decode(r9));
            goto L3
        L19:
            r0.mcustom_statuses.add((ChatterCustomStatus) ChatterCustomStatus.ADAPTER.decode(r9));
            goto L3
        L20:
            r0.menterprise_mail_address = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L21:
            r0.mextraFields = (ExtraFields) ExtraFields.ADAPTER.decode(r9);
            goto L3
        L22:
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L23:
            r0.maccept_sms_phone_urgent = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L24:
            r0.mdo_not_disturb_end_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L25:
            r0.mmail_address = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L26:
            r0.mtenant_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L27:
            r0.mis_registered = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L28:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L29:
            r9.endMessage(r1);
            return r0.m2969build();
        }

        public int encodedSize(UserMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            Boolean r2 = r7.mis_registered;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.mtenant_id;
            if (r6 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            String r10 = r7.mmail_address;
            if (r10 == null) goto L13;
            int r11 = r0.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            Long r13 = r7.mdo_not_disturb_end_time;
            if (r13 == null) goto L17;
            int r14 = ProtoAdapter.INT64.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            Boolean r16 = r7.maccept_sms_phone_urgent;
            if (r16 == null) goto L21;
            int r17 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            String r19 = r7.mchat_id;
            if (r19 == null) goto L25;
            int r20 = r0.encodedSizeWithTag(7, r19);
        L26:
            int r21 = r18 + r20;
            ExtraFields r22 = r7.mextraFields;
            if (r22 == null) goto L29;
            int r23 = ExtraFields.ADAPTER.encodedSizeWithTag(8, r22);
        L30:
            int r24 = r21 + r23;
            String r25 = r7.menterprise_mail_address;
            if (r25 == null) goto L33;
            int r26 = r0.encodedSizeWithTag(9, r25);
        L34:
            int r27 = ((r24 + r26) + ChatterCustomStatus.ADAPTER.asRepeated().encodedSizeWithTag(10, r7.mcustom_statuses)) + this.mi18n_names.encodedSizeWithTag(11, r7.mi18n_names);
            Boolean r28 = r7.mis_cross_tenant;
            if (r28 == null) goto L37;
            int r29 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r28);
        L38:
            int r30 = r27 + r29;
            TagData r31 = r7.mrelation_tag;
            if (r31 == null) goto L41;
            int r32 = TagData.ADAPTER.encodedSizeWithTag(13, r31);
        L42:
            int r33 = r30 + r32;
            DeniedReason r34 = r7.mblock_status;
            if (r34 == null) goto L45;
            int r35 = DeniedReason.ADAPTER.encodedSizeWithTag(14, r34);
        L46:
            int r36 = r33 + r35;
            String r37 = r7.mdescription;
            if (r37 == null) goto L49;
            int r38 = r0.encodedSizeWithTag(15, r37);
        L50:
            int r39 = r36 + r38;
            EmployeeKind r40 = r7.memployee_kind;
            if (r40 == null) goto L54;
            r3 = EmployeeKind.ADAPTER.encodedSizeWithTag(16, r40);
        L54:
            return (r39 + r3) + r7.unknownFields().size();
        L49:
            r38 = 0;
            goto L50
        L45:
            r35 = 0;
            goto L46
        L41:
            r32 = 0;
            goto L42
        L37:
            r29 = 0;
            goto L38
        L33:
            r26 = 0;
            goto L34
        L29:
            r23 = 0;
            goto L30
        L25:
            r20 = 0;
            goto L26
        L21:
            r17 = 0;
            goto L22
        L17:
            r14 = 0;
            goto L18
        L13:
            r11 = 0;
            goto L14
        L9:
            r8 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2973decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UserMeta) r1);
        }

        public void encode(ProtoWriter r5, UserMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            Boolean r1 = r6.mis_registered;
            if (r1 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r5, 2, r1);
        L5:
            String r2 = r6.mtenant_id;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 3, r2);
        L8:
            String r3 = r6.mmail_address;
            if (r3 == null) goto L11;
            r0.encodeWithTag(r5, 4, r3);
        L11:
            Long r4 = r6.mdo_not_disturb_end_time;
            if (r4 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r5, 5, r4);
        L14:
            Boolean r7 = r6.maccept_sms_phone_urgent;
            if (r7 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r5, 6, r7);
        L17:
            String r8 = r6.mchat_id;
            if (r8 == null) goto L20;
            r0.encodeWithTag(r5, 7, r8);
        L20:
            ExtraFields r9 = r6.mextraFields;
            if (r9 == null) goto L23;
            ExtraFields.ADAPTER.encodeWithTag(r5, 8, r9);
        L23:
            String r10 = r6.menterprise_mail_address;
            if (r10 == null) goto L26;
            r0.encodeWithTag(r5, 9, r10);
        L26:
            ChatterCustomStatus.ADAPTER.asRepeated().encodeWithTag(r5, 10, r6.mcustom_statuses);
            this.mi18n_names.encodeWithTag(r5, 11, r6.mi18n_names);
            Boolean r11 = r6.mis_cross_tenant;
            if (r11 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r5, 12, r11);
        L29:
            TagData r12 = r6.mrelation_tag;
            if (r12 == null) goto L32;
            TagData.ADAPTER.encodeWithTag(r5, 13, r12);
        L32:
            DeniedReason r13 = r6.mblock_status;
            if (r13 == null) goto L35;
            DeniedReason.ADAPTER.encodeWithTag(r5, 14, r13);
        L35:
            String r14 = r6.mdescription;
            if (r14 == null) goto L38;
            r0.encodeWithTag(r5, 15, r14);
        L38:
            EmployeeKind r15 = r6.memployee_kind;
            if (r15 == null) goto L41;
            EmployeeKind.ADAPTER.encodeWithTag(r5, 16, r15);
        L41:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UserMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserMeta();
        FIELD_OPTIONS_MID = new FieldOptions.Builder().id("user_id").build();
        FIELD_OPTIONS_MTENANT_ID = new FieldOptions.Builder().id("tenant_id").build();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().id("chat_id").build();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_REGISTERED = r0;
        DEFAULT_DO_NOT_DISTURB_END_TIME = 0L;
        DEFAULT_ACCEPT_SMS_PHONE_URGENT = r0;
        DEFAULT_IS_CROSS_TENANT = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2968newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mis_registered = this.mis_registered;
        r0.mtenant_id = this.mtenant_id;
        r0.mmail_address = this.mmail_address;
        r0.mdo_not_disturb_end_time = this.mdo_not_disturb_end_time;
        r0.maccept_sms_phone_urgent = this.maccept_sms_phone_urgent;
        r0.mchat_id = this.mchat_id;
        r0.mextraFields = this.mextraFields;
        r0.menterprise_mail_address = this.menterprise_mail_address;
        r0.mcustom_statuses = Internal.copyOf("mcustom_statuses", this.mcustom_statuses);
        r0.mi18n_names = Internal.copyOf("mi18n_names", this.mi18n_names);
        r0.mis_cross_tenant = this.mis_cross_tenant;
        r0.mrelation_tag = this.mrelation_tag;
        r0.mblock_status = this.mblock_status;
        r0.mdescription = this.mdescription;
        r0.memployee_kind = this.memployee_kind;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UserMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2968newBuilder();
    }

    public UserMeta(String r19, Boolean r20, String r21, String r22, Long r23, Boolean r24, String r25, ExtraFields r26, String r27, List<ChatterCustomStatus> r28, Map<String, String> r29, Boolean r30, TagData r31, DeniedReason r32, String r33, EmployeeKind r34) {
        this(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, ByteString.EMPTY);
    }

    public UserMeta(String r4, Boolean r5, String r6, String r7, Long r8, Boolean r9, String r10, ExtraFields r11, String r12, List<ChatterCustomStatus> r13, Map<String, String> r14, Boolean r15, TagData r16, DeniedReason r17, String r18, EmployeeKind r19, ByteString r20) {
        super(ADAPTER, r20);
        this.mid = r4;
        this.mis_registered = r5;
        this.mtenant_id = r6;
        this.mmail_address = r7;
        this.mdo_not_disturb_end_time = r8;
        this.maccept_sms_phone_urgent = r9;
        this.mchat_id = r10;
        this.mextraFields = r11;
        this.menterprise_mail_address = r12;
        this.mcustom_statuses = Internal.immutableCopyOf("mcustom_statuses", r13);
        this.mi18n_names = Internal.immutableCopyOf("mi18n_names", r14);
        this.mis_cross_tenant = r15;
        this.mrelation_tag = r16;
        this.mblock_status = r17;
        this.mdescription = r18;
        this.memployee_kind = r19;
    }
}
