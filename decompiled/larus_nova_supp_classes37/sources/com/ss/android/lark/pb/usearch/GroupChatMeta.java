package com.ss.android.lark.pb.usearch;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Chat;
import com.ss.android.lark.pb.entities.TagData;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GroupChatMeta extends Message<GroupChatMeta, Builder> {
    public static final ProtoAdapter<GroupChatMeta> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Boolean DEFAULT_ENABLED_EMAIL = null;
    public static final String DEFAULT_ENTERPRISE_EMAIL = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_CROSS_WITH_KA = null;
    public static final Boolean DEFAULT_IS_CRYPTO = null;
    public static final Boolean DEFAULT_IS_DEPARTMENT = null;
    public static final Boolean DEFAULT_IS_IN_TEAM = null;
    public static final Boolean DEFAULT_IS_MEETING = null;
    public static final Boolean DEFAULT_IS_MEMBER = null;
    public static final Boolean DEFAULT_IS_PUBLIC_V2 = null;
    public static final Boolean DEFAULT_IS_SHIELD = null;
    public static final Boolean DEFAULT_IS_TENANT = null;
    public static final Long DEFAULT_LAST_MESSAGE_TIME = null;
    public static final String DEFAULT_ONCALL_ID = "";
    public static final Integer DEFAULT_USER_COUNT = null;
    public static final Boolean DEFAULT_USER_COUNT_INVISIBLE = null;
    public static final FieldOptions FIELD_OPTIONS_MID = null;
    private static final long serialVersionUID = 0;
    public final String mdescription;
    public final Boolean menabled_email;
    public final String menterprise_email;
    public final String mid;
    public final Boolean mis_cross_tenant;
    public final Boolean mis_cross_with_ka;
    public final Boolean mis_crypto;
    public final Boolean mis_department;
    public final Boolean mis_in_team;
    public final Boolean mis_meeting;
    public final Boolean mis_member;
    public final Boolean mis_public_v2;
    public final Boolean mis_shield;
    public final Boolean mis_tenant;
    public final Long mlast_message_time;
    public final Chat.ChatMode mmode;
    public final String moncall_id;
    public final TagData mrelation_tag;
    public final Integer muser_count;
    public final Boolean muser_count_invisible;

    public static final class Builder extends Message.Builder<GroupChatMeta, Builder> {
        public String mdescription;
        public Boolean menabled_email;
        public String menterprise_email;
        public String mid;
        public Boolean mis_cross_tenant;
        public Boolean mis_cross_with_ka;
        public Boolean mis_crypto;
        public Boolean mis_department;
        public Boolean mis_in_team;
        public Boolean mis_meeting;
        public Boolean mis_member;
        public Boolean mis_public_v2;
        public Boolean mis_shield;
        public Boolean mis_tenant;
        public Long mlast_message_time;
        public Chat.ChatMode mmode;
        public String moncall_id;
        public TagData mrelation_tag;
        public Integer muser_count;
        public Boolean muser_count_invisible;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GroupChatMeta m2669build() {
            String r1 = this.mid;
            if (r1 == null) goto L7;
            return new GroupChatMeta(this.mid, this.mmode, this.mis_department, this.mis_tenant, this.mis_cross_tenant, this.moncall_id, this.mis_crypto, this.mis_public_v2, this.mis_member, this.mis_meeting, this.muser_count, this.mlast_message_time, this.mis_cross_with_ka, this.menabled_email, this.mdescription, this.mis_shield, this.mis_in_team, this.mrelation_tag, this.menterprise_email, this.muser_count_invisible, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r1, "mid"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2669build();
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder enabled_email(Boolean r1) {
            this.menabled_email = r1;
            return this;
        }

        public Builder enterprise_email(String r1) {
            this.menterprise_email = r1;
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

        public Builder is_cross_with_ka(Boolean r1) {
            this.mis_cross_with_ka = r1;
            return this;
        }

        public Builder is_crypto(Boolean r1) {
            this.mis_crypto = r1;
            return this;
        }

        public Builder is_department(Boolean r1) {
            this.mis_department = r1;
            return this;
        }

        public Builder is_in_team(Boolean r1) {
            this.mis_in_team = r1;
            return this;
        }

        public Builder is_meeting(Boolean r1) {
            this.mis_meeting = r1;
            return this;
        }

        public Builder is_member(Boolean r1) {
            this.mis_member = r1;
            return this;
        }

        public Builder is_public_v2(Boolean r1) {
            this.mis_public_v2 = r1;
            return this;
        }

        public Builder is_shield(Boolean r1) {
            this.mis_shield = r1;
            return this;
        }

        public Builder is_tenant(Boolean r1) {
            this.mis_tenant = r1;
            return this;
        }

        public Builder last_message_time(Long r1) {
            this.mlast_message_time = r1;
            return this;
        }

        public Builder mode(Chat.ChatMode r1) {
            this.mmode = r1;
            return this;
        }

        public Builder oncall_id(String r1) {
            this.moncall_id = r1;
            return this;
        }

        public Builder relation_tag(TagData r1) {
            this.mrelation_tag = r1;
            return this;
        }

        public Builder user_count(Integer r1) {
            this.muser_count = r1;
            return this;
        }

        public Builder user_count_invisible(Boolean r1) {
            this.muser_count_invisible = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GroupChatMeta extends ProtoAdapter<GroupChatMeta> {
        public ProtoAdapter_GroupChatMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, GroupChatMeta.class);
        }

        public GroupChatMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            Boolean r2 = Boolean.FALSE;
            r0.mis_department = r2;
            r0.mis_tenant = r2;
            r0.mis_cross_tenant = r2;
            r0.moncall_id = "";
            r0.mis_crypto = r2;
            r0.mis_public_v2 = r2;
            r0.mis_member = r2;
            r0.mis_meeting = r2;
            r0.muser_count = 0;
            r0.mlast_message_time = 0L;
            r0.mis_cross_with_ka = r2;
            r0.menabled_email = r2;
            r0.mdescription = "";
            r0.mis_shield = r2;
            r0.mis_in_team = r2;
            r0.menterprise_email = "";
            r0.muser_count_invisible = r2;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L30;
            switch(r3) {
                case 1: goto L29;
                case 2: goto L32;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L17;
                case 11: goto L16;
                case 12: goto L15;
                case 13: goto L14;
                case 14: goto L13;
                case 15: goto L12;
                case 16: goto L11;
                case 17: goto L10;
                case 18: goto L9;
                case 19: goto L8;
                case 20: goto L7;
                default: goto L6;
            };
        L32:
            r0.mmode = (Chat.ChatMode) Chat.ChatMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.muser_count_invisible = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L8:
            r0.menterprise_email = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            r0.mrelation_tag = (TagData) TagData.ADAPTER.decode(r9);
            goto L3
        L10:
            r0.mis_in_team = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L11:
            r0.mis_shield = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L12:
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.menabled_email = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L14:
            r0.mis_cross_with_ka = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L15:
            r0.mlast_message_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L16:
            r0.muser_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L17:
            r0.mis_meeting = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L18:
            r0.mis_member = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L19:
            r0.mis_public_v2 = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L20:
            r0.mis_crypto = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L21:
            r0.moncall_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L22:
            r0.mis_cross_tenant = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L23:
            r0.mis_tenant = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L24:
            r0.mis_department = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L29:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L30:
            r9.endMessage(r1);
            return r0.m2669build();
        }

        public int encodedSize(GroupChatMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            Chat.ChatMode r2 = r7.mmode;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = Chat.ChatMode.ADAPTER.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            Boolean r6 = r7.mis_department;
            if (r6 == null) goto L9;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            Boolean r10 = r7.mis_tenant;
            if (r10 == null) goto L13;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            Boolean r13 = r7.mis_cross_tenant;
            if (r13 == null) goto L17;
            int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            String r16 = r7.moncall_id;
            if (r16 == null) goto L21;
            int r17 = r0.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            Boolean r19 = r7.mis_crypto;
            if (r19 == null) goto L25;
            int r20 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r19);
        L26:
            int r21 = r18 + r20;
            Boolean r22 = r7.mis_public_v2;
            if (r22 == null) goto L29;
            int r23 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r22);
        L30:
            int r24 = r21 + r23;
            Boolean r25 = r7.mis_member;
            if (r25 == null) goto L33;
            int r26 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r25);
        L34:
            int r27 = r24 + r26;
            Boolean r28 = r7.mis_meeting;
            if (r28 == null) goto L37;
            int r29 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r28);
        L38:
            int r30 = r27 + r29;
            Integer r31 = r7.muser_count;
            if (r31 == null) goto L41;
            int r32 = ProtoAdapter.INT32.encodedSizeWithTag(11, r31);
        L42:
            int r33 = r30 + r32;
            Long r34 = r7.mlast_message_time;
            if (r34 == null) goto L45;
            int r35 = ProtoAdapter.INT64.encodedSizeWithTag(12, r34);
        L46:
            int r36 = r33 + r35;
            Boolean r37 = r7.mis_cross_with_ka;
            if (r37 == null) goto L49;
            int r38 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r37);
        L50:
            int r39 = r36 + r38;
            Boolean r40 = r7.menabled_email;
            if (r40 == null) goto L53;
            int r41 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r40);
        L54:
            int r42 = r39 + r41;
            String r43 = r7.mdescription;
            if (r43 == null) goto L57;
            int r44 = r0.encodedSizeWithTag(15, r43);
        L58:
            int r45 = r42 + r44;
            Boolean r46 = r7.mis_shield;
            if (r46 == null) goto L61;
            int r47 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r46);
        L62:
            int r48 = r45 + r47;
            Boolean r49 = r7.mis_in_team;
            if (r49 == null) goto L65;
            int r50 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r49);
        L66:
            int r51 = r48 + r50;
            TagData r52 = r7.mrelation_tag;
            if (r52 == null) goto L69;
            int r53 = TagData.ADAPTER.encodedSizeWithTag(18, r52);
        L70:
            int r54 = r51 + r53;
            String r55 = r7.menterprise_email;
            if (r55 == null) goto L73;
            int r56 = r0.encodedSizeWithTag(19, r55);
        L74:
            int r57 = r54 + r56;
            Boolean r58 = r7.muser_count_invisible;
            if (r58 == null) goto L78;
            r3 = ProtoAdapter.BOOL.encodedSizeWithTag(20, r58);
        L78:
            return (r57 + r3) + r7.unknownFields().size();
        L73:
            r56 = 0;
            goto L74
        L69:
            r53 = 0;
            goto L70
        L65:
            r50 = 0;
            goto L66
        L61:
            r47 = 0;
            goto L62
        L57:
            r44 = 0;
            goto L58
        L53:
            r41 = 0;
            goto L54
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
        public /* bridge */ /* synthetic */ Object m2670decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GroupChatMeta) r1);
        }

        public void encode(ProtoWriter r5, GroupChatMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            Chat.ChatMode r1 = r6.mmode;
            if (r1 == null) goto L5;
            Chat.ChatMode.ADAPTER.encodeWithTag(r5, 2, r1);
        L5:
            Boolean r2 = r6.mis_department;
            if (r2 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r5, 3, r2);
        L8:
            Boolean r3 = r6.mis_tenant;
            if (r3 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r5, 4, r3);
        L11:
            Boolean r4 = r6.mis_cross_tenant;
            if (r4 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r5, 5, r4);
        L14:
            String r7 = r6.moncall_id;
            if (r7 == null) goto L17;
            r0.encodeWithTag(r5, 6, r7);
        L17:
            Boolean r8 = r6.mis_crypto;
            if (r8 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r5, 7, r8);
        L20:
            Boolean r9 = r6.mis_public_v2;
            if (r9 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r5, 8, r9);
        L23:
            Boolean r10 = r6.mis_member;
            if (r10 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r5, 9, r10);
        L26:
            Boolean r11 = r6.mis_meeting;
            if (r11 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r5, 10, r11);
        L29:
            Integer r12 = r6.muser_count;
            if (r12 == null) goto L32;
            ProtoAdapter.INT32.encodeWithTag(r5, 11, r12);
        L32:
            Long r13 = r6.mlast_message_time;
            if (r13 == null) goto L35;
            ProtoAdapter.INT64.encodeWithTag(r5, 12, r13);
        L35:
            Boolean r14 = r6.mis_cross_with_ka;
            if (r14 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r5, 13, r14);
        L38:
            Boolean r15 = r6.menabled_email;
            if (r15 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r5, 14, r15);
        L41:
            String r16 = r6.mdescription;
            if (r16 == null) goto L44;
            r0.encodeWithTag(r5, 15, r16);
        L44:
            Boolean r17 = r6.mis_shield;
            if (r17 == null) goto L47;
            ProtoAdapter.BOOL.encodeWithTag(r5, 16, r17);
        L47:
            Boolean r18 = r6.mis_in_team;
            if (r18 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r5, 17, r18);
        L50:
            TagData r19 = r6.mrelation_tag;
            if (r19 == null) goto L53;
            TagData.ADAPTER.encodeWithTag(r5, 18, r19);
        L53:
            String r20 = r6.menterprise_email;
            if (r20 == null) goto L56;
            r0.encodeWithTag(r5, 19, r20);
        L56:
            Boolean r21 = r6.muser_count_invisible;
            if (r21 == null) goto L59;
            ProtoAdapter.BOOL.encodeWithTag(r5, 20, r21);
        L59:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GroupChatMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GroupChatMeta();
        FIELD_OPTIONS_MID = new FieldOptions.Builder().id("chat_id").build();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_DEPARTMENT = r0;
        DEFAULT_IS_TENANT = r0;
        DEFAULT_IS_CROSS_TENANT = r0;
        DEFAULT_IS_CRYPTO = r0;
        DEFAULT_IS_PUBLIC_V2 = r0;
        DEFAULT_IS_MEMBER = r0;
        DEFAULT_IS_MEETING = r0;
        DEFAULT_USER_COUNT = 0;
        DEFAULT_LAST_MESSAGE_TIME = 0L;
        DEFAULT_IS_CROSS_WITH_KA = r0;
        DEFAULT_ENABLED_EMAIL = r0;
        DEFAULT_IS_SHIELD = r0;
        DEFAULT_IS_IN_TEAM = r0;
        DEFAULT_USER_COUNT_INVISIBLE = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2668newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mmode = this.mmode;
        r0.mis_department = this.mis_department;
        r0.mis_tenant = this.mis_tenant;
        r0.mis_cross_tenant = this.mis_cross_tenant;
        r0.moncall_id = this.moncall_id;
        r0.mis_crypto = this.mis_crypto;
        r0.mis_public_v2 = this.mis_public_v2;
        r0.mis_member = this.mis_member;
        r0.mis_meeting = this.mis_meeting;
        r0.muser_count = this.muser_count;
        r0.mlast_message_time = this.mlast_message_time;
        r0.mis_cross_with_ka = this.mis_cross_with_ka;
        r0.menabled_email = this.menabled_email;
        r0.mdescription = this.mdescription;
        r0.mis_shield = this.mis_shield;
        r0.mis_in_team = this.mis_in_team;
        r0.mrelation_tag = this.mrelation_tag;
        r0.menterprise_email = this.menterprise_email;
        r0.muser_count_invisible = this.muser_count_invisible;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GroupChatMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2668newBuilder();
    }

    public GroupChatMeta(String r23, Chat.ChatMode r24, Boolean r25, Boolean r26, Boolean r27, String r28, Boolean r29, Boolean r30, Boolean r31, Boolean r32, Integer r33, Long r34, Boolean r35, Boolean r36, String r37, Boolean r38, Boolean r39, TagData r40, String r41, Boolean r42) {
        this(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, ByteString.EMPTY);
    }

    public GroupChatMeta(String r4, Chat.ChatMode r5, Boolean r6, Boolean r7, Boolean r8, String r9, Boolean r10, Boolean r11, Boolean r12, Boolean r13, Integer r14, Long r15, Boolean r16, Boolean r17, String r18, Boolean r19, Boolean r20, TagData r21, String r22, Boolean r23, ByteString r24) {
        super(ADAPTER, r24);
        this.mid = r4;
        this.mmode = r5;
        this.mis_department = r6;
        this.mis_tenant = r7;
        this.mis_cross_tenant = r8;
        this.moncall_id = r9;
        this.mis_crypto = r10;
        this.mis_public_v2 = r11;
        this.mis_member = r12;
        this.mis_meeting = r13;
        this.muser_count = r14;
        this.mlast_message_time = r15;
        this.mis_cross_with_ka = r16;
        this.menabled_email = r17;
        this.mdescription = r18;
        this.mis_shield = r19;
        this.mis_in_team = r20;
        this.mrelation_tag = r21;
        this.menterprise_email = r22;
        this.muser_count_invisible = r23;
    }
}
