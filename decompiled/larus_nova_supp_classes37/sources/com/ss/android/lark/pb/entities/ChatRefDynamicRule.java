package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ChatRefDynamicRule extends com.squareup.wire.Message<ChatRefDynamicRule, Builder> {
    public static final ProtoAdapter<ChatRefDynamicRule> ADAPTER = null;
    public static final Boolean DEFAULT_ALLOW_ALL_EMPLOYEE_TYPE = null;
    public static final Boolean DEFAULT_EDITABLE = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_REF_ID = "";
    public static final String DEFAULT_REF_NAME = "";
    private static final long serialVersionUID = 0;
    public final Boolean mallow_all_employee_type;
    public final Boolean meditable;
    public final List<String> memployee_types;
    public final String mid;
    public final String mref_id;
    public final String mref_name;
    public final RuleType mrule_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatRefDynamicRule, Builder> {
        public Boolean mallow_all_employee_type;
        public Boolean meditable;
        public List<String> memployee_types;
        public String mid;
        public String mref_id;
        public String mref_name;
        public RuleType mrule_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatRefDynamicRule m1142build() {
            RuleType r0 = this.mrule_type;
            if (r0 == null) goto L7;
            return new ChatRefDynamicRule(this.mid, this.mrule_type, this.mref_id, this.mref_name, this.memployee_types, this.mallow_all_employee_type, this.meditable, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mrule_type"});
        }

        public Builder() {
            this.memployee_types = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1142build();
        }

        public Builder allow_all_employee_type(Boolean r1) {
            this.mallow_all_employee_type = r1;
            return this;
        }

        public Builder editable(Boolean r1) {
            this.meditable = r1;
            return this;
        }

        public Builder employee_types(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.memployee_types = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder ref_id(String r1) {
            this.mref_id = r1;
            return this;
        }

        public Builder ref_name(String r1) {
            this.mref_name = r1;
            return this;
        }

        public Builder rule_type(RuleType r1) {
            this.mrule_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatRefDynamicRule extends ProtoAdapter<ChatRefDynamicRule> {
        public ProtoAdapter_ChatRefDynamicRule() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatRefDynamicRule.class);
        }

        public ChatRefDynamicRule decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mref_id = "";
            r0.mref_name = "";
            Boolean r1 = Boolean.FALSE;
            r0.mallow_all_employee_type = r1;
            r0.meditable = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L19;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r0.mrule_type = (RuleType) RuleType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.meditable = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L8:
            r0.mallow_all_employee_type = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L9:
            r0.memployee_types.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L10:
            r0.mref_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            r0.mref_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L17:
            r9.endMessage(r2);
            return r0.m1142build();
        }

        public int encodedSize(ChatRefDynamicRule r6) {
            String r0 = r6.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            int r3 = r2 + RuleType.ADAPTER.encodedSizeWithTag(2, r6.mrule_type);
            String r4 = r6.mref_id;
            if (r4 == null) goto L9;
            int r5 = ProtoAdapter.STRING.encodedSizeWithTag(3, r4);
        L10:
            int r7 = r3 + r5;
            String r8 = r6.mref_name;
            if (r8 == null) goto L13;
            int r9 = ProtoAdapter.STRING.encodedSizeWithTag(4, r8);
        L14:
            int r10 = (r7 + r9) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, r6.memployee_types);
            Boolean r11 = r6.mallow_all_employee_type;
            if (r11 == null) goto L17;
            int r12 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r11);
        L18:
            int r13 = r10 + r12;
            Boolean r14 = r6.meditable;
            if (r14 == null) goto L22;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r14);
        L22:
            return (r13 + r1) + r6.unknownFields().size();
        L17:
            r12 = 0;
            goto L18
        L13:
            r9 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1143decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatRefDynamicRule) r1);
        }

        public void encode(ProtoWriter r4, ChatRefDynamicRule r5) throws IOException {
            String r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            RuleType.ADAPTER.encodeWithTag(r4, 2, r5.mrule_type);
            String r1 = r5.mref_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r1);
        L8:
            String r2 = r5.mref_name;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r2);
        L11:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 5, r5.memployee_types);
            Boolean r3 = r5.mallow_all_employee_type;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r3);
        L14:
            Boolean r6 = r5.meditable;
            if (r6 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r4, 7, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatRefDynamicRule) r2);
        }
    }

    public static final enum RuleType extends Enum<RuleType> implements WireEnum {
        private static final /* synthetic */ RuleType[] $VALUES = null;
        public static final ProtoAdapter<RuleType> ADAPTER = null;
        public static final RuleType DEPARTMENT = null;
        public static final RuleType UNKNOWN_RULE = null;
        private final int value;

        static {
            RuleType r0 = new RuleType("UNKNOWN_RULE", 0, 0);
            UNKNOWN_RULE = r0;
            RuleType r1 = new RuleType("DEPARTMENT", 1, 1);
            DEPARTMENT = r1;
            $VALUES = new RuleType[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(RuleType.class);
        }

        public static RuleType[] values() {
            return (RuleType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static RuleType fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return DEPARTMENT;
        L10:
            return UNKNOWN_RULE;
        }

        public static RuleType valueOf(String r1) {
            return (RuleType) a.a(RuleType.class, r1);
        }

        private RuleType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatRefDynamicRule();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_ALLOW_ALL_EMPLOYEE_TYPE = r0;
        DEFAULT_EDITABLE = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1141newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mrule_type = this.mrule_type;
        r0.mref_id = this.mref_id;
        r0.mref_name = this.mref_name;
        r0.memployee_types = Internal.copyOf("memployee_types", this.memployee_types);
        r0.mallow_all_employee_type = this.mallow_all_employee_type;
        r0.meditable = this.meditable;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatRefDynamicRule.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1141newBuilder();
    }

    public ChatRefDynamicRule(String r10, RuleType r11, String r12, String r13, List<String> r14, Boolean r15, Boolean r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public ChatRefDynamicRule(String r2, RuleType r3, String r4, String r5, List<String> r6, Boolean r7, Boolean r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mid = r2;
        this.mrule_type = r3;
        this.mref_id = r4;
        this.mref_name = r5;
        this.memployee_types = Internal.immutableCopyOf("memployee_types", r6);
        this.mallow_all_employee_type = r7;
        this.meditable = r8;
    }
}
