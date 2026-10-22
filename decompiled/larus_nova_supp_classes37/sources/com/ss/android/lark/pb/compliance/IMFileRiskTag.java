package com.ss.android.lark.pb.compliance;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IMFileRiskTag extends Message<IMFileRiskTag, Builder> {
    public static final ProtoAdapter<IMFileRiskTag> ADAPTER = null;
    public static final Boolean DEFAULT_IS_RISK_FILE = null;
    public static final Boolean DEFAULT_IS_RISK_TAG_EXIST = null;
    public static final String DEFAULT_OBJECT_ID = "";
    public static final Boolean DEFAULT_RESTRICT_OPERATION = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_risk_file;
    public final Boolean mis_risk_tag_exist;
    public final String mobject_id;
    public final Boolean mrestrict_operation;

    public static final class Builder extends Message.Builder<IMFileRiskTag, Builder> {
        public Boolean mis_risk_file;
        public Boolean mis_risk_tag_exist;
        public String mobject_id;
        public Boolean mrestrict_operation;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public IMFileRiskTag m953build() {
            return new IMFileRiskTag(this.mobject_id, this.mis_risk_tag_exist, this.mis_risk_file, this.mrestrict_operation, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m953build();
        }

        public Builder is_risk_file(Boolean r1) {
            this.mis_risk_file = r1;
            return this;
        }

        public Builder is_risk_tag_exist(Boolean r1) {
            this.mis_risk_tag_exist = r1;
            return this;
        }

        public Builder object_id(String r1) {
            this.mobject_id = r1;
            return this;
        }

        public Builder restrict_operation(Boolean r1) {
            this.mrestrict_operation = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_IMFileRiskTag extends ProtoAdapter<IMFileRiskTag> {
        public ProtoAdapter_IMFileRiskTag() {
            super(FieldEncoding.LENGTH_DELIMITED, IMFileRiskTag.class);
        }

        public IMFileRiskTag decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mobject_id = "";
            Boolean r1 = Boolean.FALSE;
            r0.mis_risk_tag_exist = r1;
            r0.mis_risk_file = r1;
            r0.mrestrict_operation = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mobject_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mis_risk_tag_exist = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mis_risk_file = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mrestrict_operation = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r2);
            return r0.m953build();
        }

        public int encodedSize(IMFileRiskTag r6) {
            String r0 = r6.mobject_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r6.mis_risk_tag_exist;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mis_risk_file;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.mrestrict_operation;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m954decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((IMFileRiskTag) r1);
        }

        public void encode(ProtoWriter r4, IMFileRiskTag r5) throws IOException {
            String r0 = r5.mobject_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mis_risk_tag_exist;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mis_risk_file;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            Boolean r3 = r5.mrestrict_operation;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (IMFileRiskTag) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_IMFileRiskTag();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_RISK_TAG_EXIST = r0;
        DEFAULT_IS_RISK_FILE = r0;
        DEFAULT_RESTRICT_OPERATION = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m952newBuilder() {
        Builder r0 = new Builder();
        r0.mobject_id = this.mobject_id;
        r0.mis_risk_tag_exist = this.mis_risk_tag_exist;
        r0.mis_risk_file = this.mis_risk_file;
        r0.mrestrict_operation = this.mrestrict_operation;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return IMFileRiskTag.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m952newBuilder();
    }

    public IMFileRiskTag(String r7, Boolean r8, Boolean r9, Boolean r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public IMFileRiskTag(String r2, Boolean r3, Boolean r4, Boolean r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mobject_id = r2;
        this.mis_risk_tag_exist = r3;
        this.mis_risk_file = r4;
        this.mrestrict_operation = r5;
    }
}
