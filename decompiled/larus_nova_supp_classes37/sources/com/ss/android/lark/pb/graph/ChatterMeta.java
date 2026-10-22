package com.ss.android.lark.pb.graph;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Chatter;
import com.ss.android.lark.pb.entities.Image;
import com.ss.android.lark.pb.entities.WorkStatus;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ChatterMeta extends Message<ChatterMeta, Builder> {
    public static final ProtoAdapter<ChatterMeta> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_DEFAULTDEPARTMENTNAME = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_ENTERPRISE_MAIL_ADDRESS = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PHONE = "";
    public static final Double DEFAULT_SCORE = null;
    public static final String DEFAULT_TENANT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mavatar_key;
    public final String mdefaultDepartmentName;
    public final Map<String, String> mdepartmentNameWithI18n;
    public final String mdescription;
    public final Chatter.DescriptionFlag mdescription_flag;
    public final Map<String, Double> mdouble_features;
    public final Map<String, MapFeature> mdouble_map_features;
    public final String memail;
    public final String menterprise_mail_address;
    public final String mid;
    public final Image mimage;
    public final String mname;
    public final String mphone;
    public final Double mscore;
    public final String mtenant_id;
    public final WorkStatus mwork_status;

    public static final class Builder extends Message.Builder<ChatterMeta, Builder> {
        public String mavatar_key;
        public String mdefaultDepartmentName;
        public Map<String, String> mdepartmentNameWithI18n;
        public String mdescription;
        public Chatter.DescriptionFlag mdescription_flag;
        public Map<String, Double> mdouble_features;
        public Map<String, MapFeature> mdouble_map_features;
        public String memail;
        public String menterprise_mail_address;
        public String mid;
        public Image mimage;
        public String mname;
        public String mphone;
        public Double mscore;
        public String mtenant_id;
        public WorkStatus mwork_status;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatterMeta m1697build() {
            return new ChatterMeta(this.mid, this.mname, this.mavatar_key, this.mdescription, this.mdescription_flag, this.mwork_status, this.mimage, this.mscore, this.mdouble_features, this.mdouble_map_features, this.menterprise_mail_address, this.memail, this.mphone, this.mtenant_id, this.mdepartmentNameWithI18n, this.mdefaultDepartmentName, super.buildUnknownFields());
        }

        public Builder() {
            this.mdouble_features = Internal.newMutableMap();
            this.mdouble_map_features = Internal.newMutableMap();
            this.mdepartmentNameWithI18n = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1697build();
        }

        public Builder avatar_key(String r1) {
            this.mavatar_key = r1;
            return this;
        }

        public Builder defaultDepartmentName(String r1) {
            this.mdefaultDepartmentName = r1;
            return this;
        }

        public Builder departmentNameWithI18n(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdepartmentNameWithI18n = r1;
            return this;
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder description_flag(Chatter.DescriptionFlag r1) {
            this.mdescription_flag = r1;
            return this;
        }

        public Builder double_features(Map<String, Double> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdouble_features = r1;
            return this;
        }

        public Builder double_map_features(Map<String, MapFeature> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdouble_map_features = r1;
            return this;
        }

        public Builder email(String r1) {
            this.memail = r1;
            return this;
        }

        public Builder enterprise_mail_address(String r1) {
            this.menterprise_mail_address = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder image(Image r1) {
            this.mimage = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder phone(String r1) {
            this.mphone = r1;
            return this;
        }

        public Builder score(Double r1) {
            this.mscore = r1;
            return this;
        }

        public Builder tenant_id(String r1) {
            this.mtenant_id = r1;
            return this;
        }

        public Builder work_status(WorkStatus r1) {
            this.mwork_status = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatterMeta extends ProtoAdapter<ChatterMeta> {
        private final ProtoAdapter<Map<String, String>> mdepartmentNameWithI18n;
        private final ProtoAdapter<Map<String, Double>> mdouble_features;
        private final ProtoAdapter<Map<String, MapFeature>> mdouble_map_features;

        public ProtoAdapter_ChatterMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatterMeta.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mdouble_features = ProtoAdapter.newMapAdapter(r0, ProtoAdapter.DOUBLE);
            this.mdouble_map_features = ProtoAdapter.newMapAdapter(r0, MapFeature.ADAPTER);
            this.mdepartmentNameWithI18n = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public ChatterMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mname = "";
            r0.mavatar_key = "";
            r0.mdescription = "";
            r0.mscore = Double.valueOf(0.0d);
            r0.menterprise_mail_address = "";
            r0.memail = "";
            r0.mphone = "";
            r0.mtenant_id = "";
            r0.mdefaultDepartmentName = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L26;
            switch(r3) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L28;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                case 13: goto L10;
                case 14: goto L9;
                case 15: goto L8;
                case 16: goto L7;
                default: goto L6;
            };
        L28:
            r0.mdescription_flag = (Chatter.DescriptionFlag) Chatter.DescriptionFlag.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mdefaultDepartmentName = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            r0.mdepartmentNameWithI18n.putAll((Map) this.mdepartmentNameWithI18n.decode(r9));
            goto L3
        L9:
            r0.mtenant_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            r0.mphone = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            r0.memail = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            r0.menterprise_mail_address = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.mdouble_map_features.putAll((Map) this.mdouble_map_features.decode(r9));
            goto L3
        L14:
            r0.mdouble_features.putAll((Map) this.mdouble_features.decode(r9));
            goto L3
        L15:
            r0.mscore = (Double) ProtoAdapter.DOUBLE.decode(r9);
            goto L3
        L16:
            r0.mimage = (Image) Image.ADAPTER.decode(r9);
            goto L3
        L17:
            r0.mwork_status = (WorkStatus) WorkStatus.ADAPTER.decode(r9);
            goto L3
        L22:
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L23:
            r0.mavatar_key = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L24:
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L25:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L26:
            r9.endMessage(r1);
            return r0.m1697build();
        }

        public int encodedSize(ChatterMeta r6) {
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
            String r7 = r6.mavatar_key;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mdescription;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Chatter.DescriptionFlag r13 = r6.mdescription_flag;
            if (r13 == null) goto L21;
            int r14 = Chatter.DescriptionFlag.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            WorkStatus r16 = r6.mwork_status;
            if (r16 == null) goto L25;
            int r17 = WorkStatus.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Image r19 = r6.mimage;
            if (r19 == null) goto L29;
            int r20 = Image.ADAPTER.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            Double r22 = r6.mscore;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.DOUBLE.encodedSizeWithTag(8, r22);
        L34:
            int r24 = ((r21 + r23) + this.mdouble_features.encodedSizeWithTag(9, r6.mdouble_features)) + this.mdouble_map_features.encodedSizeWithTag(10, r6.mdouble_map_features);
            String r25 = r6.menterprise_mail_address;
            if (r25 == null) goto L37;
            int r26 = ProtoAdapter.STRING.encodedSizeWithTag(11, r25);
        L38:
            int r27 = r24 + r26;
            String r28 = r6.memail;
            if (r28 == null) goto L41;
            int r29 = ProtoAdapter.STRING.encodedSizeWithTag(12, r28);
        L42:
            int r30 = r27 + r29;
            String r31 = r6.mphone;
            if (r31 == null) goto L45;
            int r32 = ProtoAdapter.STRING.encodedSizeWithTag(13, r31);
        L46:
            int r33 = r30 + r32;
            String r34 = r6.mtenant_id;
            if (r34 == null) goto L49;
            int r35 = ProtoAdapter.STRING.encodedSizeWithTag(14, r34);
        L50:
            int r36 = (r33 + r35) + this.mdepartmentNameWithI18n.encodedSizeWithTag(15, r6.mdepartmentNameWithI18n);
            String r37 = r6.mdefaultDepartmentName;
            if (r37 == null) goto L54;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(16, r37);
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
        public /* bridge */ /* synthetic */ Object m1698decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatterMeta) r1);
        }

        public void encode(ProtoWriter r4, ChatterMeta r5) throws IOException {
            String r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mname;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mavatar_key;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mdescription;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            Chatter.DescriptionFlag r6 = r5.mdescription_flag;
            if (r6 == null) goto L17;
            Chatter.DescriptionFlag.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            WorkStatus r7 = r5.mwork_status;
            if (r7 == null) goto L20;
            WorkStatus.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            Image r8 = r5.mimage;
            if (r8 == null) goto L23;
            Image.ADAPTER.encodeWithTag(r4, 7, r8);
        L23:
            Double r9 = r5.mscore;
            if (r9 == null) goto L26;
            ProtoAdapter.DOUBLE.encodeWithTag(r4, 8, r9);
        L26:
            this.mdouble_features.encodeWithTag(r4, 9, r5.mdouble_features);
            this.mdouble_map_features.encodeWithTag(r4, 10, r5.mdouble_map_features);
            String r10 = r5.menterprise_mail_address;
            if (r10 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r4, 11, r10);
        L29:
            String r11 = r5.memail;
            if (r11 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r4, 12, r11);
        L32:
            String r12 = r5.mphone;
            if (r12 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r4, 13, r12);
        L35:
            String r13 = r5.mtenant_id;
            if (r13 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r4, 14, r13);
        L38:
            this.mdepartmentNameWithI18n.encodeWithTag(r4, 15, r5.mdepartmentNameWithI18n);
            String r14 = r5.mdefaultDepartmentName;
            if (r14 == null) goto L41;
            ProtoAdapter.STRING.encodeWithTag(r4, 16, r14);
        L41:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatterMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatterMeta();
        DEFAULT_SCORE = Double.valueOf(0.0d);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1696newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.mavatar_key = this.mavatar_key;
        r0.mdescription = this.mdescription;
        r0.mdescription_flag = this.mdescription_flag;
        r0.mwork_status = this.mwork_status;
        r0.mimage = this.mimage;
        r0.mscore = this.mscore;
        r0.mdouble_features = Internal.copyOf("mdouble_features", this.mdouble_features);
        r0.mdouble_map_features = Internal.copyOf("mdouble_map_features", this.mdouble_map_features);
        r0.menterprise_mail_address = this.menterprise_mail_address;
        r0.memail = this.memail;
        r0.mphone = this.mphone;
        r0.mtenant_id = this.mtenant_id;
        r0.mdepartmentNameWithI18n = Internal.copyOf("mdepartmentNameWithI18n", this.mdepartmentNameWithI18n);
        r0.mdefaultDepartmentName = this.mdefaultDepartmentName;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatterMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1696newBuilder();
    }

    public ChatterMeta(String r19, String r20, String r21, String r22, Chatter.DescriptionFlag r23, WorkStatus r24, Image r25, Double r26, Map<String, Double> r27, Map<String, MapFeature> r28, String r29, String r30, String r31, String r32, Map<String, String> r33, String r34) {
        this(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, ByteString.EMPTY);
    }

    public ChatterMeta(String r4, String r5, String r6, String r7, Chatter.DescriptionFlag r8, WorkStatus r9, Image r10, Double r11, Map<String, Double> r12, Map<String, MapFeature> r13, String r14, String r15, String r16, String r17, Map<String, String> r18, String r19, ByteString r20) {
        super(ADAPTER, r20);
        this.mid = r4;
        this.mname = r5;
        this.mavatar_key = r6;
        this.mdescription = r7;
        this.mdescription_flag = r8;
        this.mwork_status = r9;
        this.mimage = r10;
        this.mscore = r11;
        this.mdouble_features = Internal.immutableCopyOf("mdouble_features", r12);
        this.mdouble_map_features = Internal.immutableCopyOf("mdouble_map_features", r13);
        this.menterprise_mail_address = r14;
        this.memail = r15;
        this.mphone = r16;
        this.mtenant_id = r17;
        this.mdepartmentNameWithI18n = Internal.immutableCopyOf("mdepartmentNameWithI18n", r18);
        this.mdefaultDepartmentName = r19;
    }
}
