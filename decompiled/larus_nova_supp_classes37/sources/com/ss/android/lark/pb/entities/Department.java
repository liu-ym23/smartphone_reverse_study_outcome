package com.ss.android.lark.pb.entities;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Department extends com.squareup.wire.Message<Department, Builder> {
    public static final ProtoAdapter<Department> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Boolean DEFAULT_HAS_CHILD = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_LEADER_ID = "";
    public static final Integer DEFAULT_MEMBER_COUNT = null;
    public static final Integer DEFAULT_MEMBER_COUNT_BY_DISPLAY_RULE = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAME_PINYIN = "";
    public static final String DEFAULT_PARENT_ID = "";
    public static final Integer DEFAULT_STATUS = null;
    public static final FieldOptions FIELD_OPTIONS_MID = null;
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final List<DepartmentLeader> mdeptLeaders;
    public final Boolean mhas_child;
    public final Map<String, String> mi18n_name;
    public final String mid;
    public final String mleader_id;
    public final Integer mmember_count;
    public final Integer mmember_count_by_display_rule;
    public final String mname;
    public final String mname_pinyin;
    public final String mparent_id;
    public final Integer mstatus;

    public static final class Builder extends com.squareup.wire.Message.Builder<Department, Builder> {
        public String mchat_id;
        public List<DepartmentLeader> mdeptLeaders;
        public Boolean mhas_child;
        public Map<String, String> mi18n_name;
        public String mid;
        public String mleader_id;
        public Integer mmember_count;
        public Integer mmember_count_by_display_rule;
        public String mname;
        public String mname_pinyin;
        public String mparent_id;
        public Integer mstatus;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Department m1199build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new Department(this.mid, this.mname, this.mparent_id, this.mleader_id, this.mmember_count, this.mstatus, this.mname_pinyin, this.mchat_id, this.mhas_child, this.mi18n_name, this.mdeptLeaders, this.mmember_count_by_display_rule, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
            this.mi18n_name = Internal.newMutableMap();
            this.mdeptLeaders = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1199build();
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder deptLeaders(List<DepartmentLeader> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdeptLeaders = r1;
            return this;
        }

        public Builder has_child(Boolean r1) {
            this.mhas_child = r1;
            return this;
        }

        public Builder i18n_name(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_name = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder leader_id(String r1) {
            this.mleader_id = r1;
            return this;
        }

        public Builder member_count(Integer r1) {
            this.mmember_count = r1;
            return this;
        }

        public Builder member_count_by_display_rule(Integer r1) {
            this.mmember_count_by_display_rule = r1;
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

        public Builder parent_id(String r1) {
            this.mparent_id = r1;
            return this;
        }

        public Builder status(Integer r1) {
            this.mstatus = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Department extends ProtoAdapter<Department> {
        private final ProtoAdapter<Map<String, String>> mi18n_name;

        public ProtoAdapter_Department() {
            super(FieldEncoding.LENGTH_DELIMITED, Department.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mi18n_name = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public Department decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mname = "";
            r0.mparent_id = "";
            r0.mleader_id = "";
            r0.mmember_count = 0;
            r0.mstatus = 0;
            r0.mname_pinyin = "";
            r0.mchat_id = "";
            r0.mhas_child = Boolean.FALSE;
            r0.mmember_count_by_display_rule = 0;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L19;
            switch(r3) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            r0.mmember_count_by_display_rule = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L8:
            r0.mdeptLeaders.add((DepartmentLeader) DepartmentLeader.ADAPTER.decode(r7));
            goto L3
        L9:
            r0.mi18n_name.putAll((Map) this.mi18n_name.decode(r7));
            goto L3
        L10:
            r0.mhas_child = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mname_pinyin = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            r0.mstatus = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L14:
            r0.mmember_count = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L15:
            r0.mleader_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L16:
            r0.mparent_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L17:
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L18:
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L19:
            r7.endMessage(r1);
            return r0.m1199build();
        }

        public int encodedSize(Department r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            String r2 = r7.mname;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.mparent_id;
            if (r6 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            String r10 = r7.mleader_id;
            if (r10 == null) goto L13;
            int r11 = r0.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            Integer r13 = r7.mmember_count;
            if (r13 == null) goto L17;
            int r14 = ProtoAdapter.INT32.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            Integer r16 = r7.mstatus;
            if (r16 == null) goto L21;
            int r17 = ProtoAdapter.INT32.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            String r19 = r7.mname_pinyin;
            if (r19 == null) goto L25;
            int r20 = r0.encodedSizeWithTag(7, r19);
        L26:
            int r21 = r18 + r20;
            String r22 = r7.mchat_id;
            if (r22 == null) goto L29;
            int r23 = r0.encodedSizeWithTag(8, r22);
        L30:
            int r24 = r21 + r23;
            Boolean r25 = r7.mhas_child;
            if (r25 == null) goto L33;
            int r26 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r25);
        L34:
            int r27 = ((r24 + r26) + this.mi18n_name.encodedSizeWithTag(10, r7.mi18n_name)) + DepartmentLeader.ADAPTER.asRepeated().encodedSizeWithTag(11, r7.mdeptLeaders);
            Integer r28 = r7.mmember_count_by_display_rule;
            if (r28 == null) goto L38;
            r3 = ProtoAdapter.INT32.encodedSizeWithTag(12, r28);
        L38:
            return (r27 + r3) + r7.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m1200decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Department) r1);
        }

        public void encode(ProtoWriter r5, Department r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            String r1 = r6.mname;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 2, r1);
        L5:
            String r2 = r6.mparent_id;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 3, r2);
        L8:
            String r3 = r6.mleader_id;
            if (r3 == null) goto L11;
            r0.encodeWithTag(r5, 4, r3);
        L11:
            Integer r4 = r6.mmember_count;
            if (r4 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r5, 5, r4);
        L14:
            Integer r7 = r6.mstatus;
            if (r7 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r5, 6, r7);
        L17:
            String r8 = r6.mname_pinyin;
            if (r8 == null) goto L20;
            r0.encodeWithTag(r5, 7, r8);
        L20:
            String r9 = r6.mchat_id;
            if (r9 == null) goto L23;
            r0.encodeWithTag(r5, 8, r9);
        L23:
            Boolean r10 = r6.mhas_child;
            if (r10 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r5, 9, r10);
        L26:
            this.mi18n_name.encodeWithTag(r5, 10, r6.mi18n_name);
            DepartmentLeader.ADAPTER.asRepeated().encodeWithTag(r5, 11, r6.mdeptLeaders);
            Integer r11 = r6.mmember_count_by_display_rule;
            if (r11 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r5, 12, r11);
        L29:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Department) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Department();
        FIELD_OPTIONS_MID = new FieldOptions.Builder().id("department_id").build();
        DEFAULT_MEMBER_COUNT = 0;
        DEFAULT_STATUS = 0;
        DEFAULT_HAS_CHILD = Boolean.FALSE;
        DEFAULT_MEMBER_COUNT_BY_DISPLAY_RULE = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1198newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.mparent_id = this.mparent_id;
        r0.mleader_id = this.mleader_id;
        r0.mmember_count = this.mmember_count;
        r0.mstatus = this.mstatus;
        r0.mname_pinyin = this.mname_pinyin;
        r0.mchat_id = this.mchat_id;
        r0.mhas_child = this.mhas_child;
        r0.mi18n_name = Internal.copyOf("mi18n_name", this.mi18n_name);
        r0.mdeptLeaders = Internal.copyOf("mdeptLeaders", this.mdeptLeaders);
        r0.mmember_count_by_display_rule = this.mmember_count_by_display_rule;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Department.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1198newBuilder();
    }

    public Department(String r15, String r16, String r17, String r18, Integer r19, Integer r20, String r21, String r22, Boolean r23, Map<String, String> r24, List<DepartmentLeader> r25, Integer r26) {
        this(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, ByteString.EMPTY);
    }

    public Department(String r2, String r3, String r4, String r5, Integer r6, Integer r7, String r8, String r9, Boolean r10, Map<String, String> r11, List<DepartmentLeader> r12, Integer r13, ByteString r14) {
        super(ADAPTER, r14);
        this.mid = r2;
        this.mname = r3;
        this.mparent_id = r4;
        this.mleader_id = r5;
        this.mmember_count = r6;
        this.mstatus = r7;
        this.mname_pinyin = r8;
        this.mchat_id = r9;
        this.mhas_child = r10;
        this.mi18n_name = Internal.immutableCopyOf("mi18n_name", r11);
        this.mdeptLeaders = Internal.immutableCopyOf("mdeptLeaders", r12);
        this.mmember_count_by_display_rule = r13;
    }
}
