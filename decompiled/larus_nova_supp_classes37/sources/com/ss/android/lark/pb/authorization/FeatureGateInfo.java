package com.ss.android.lark.pb.authorization;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FeatureGateInfo extends Message<FeatureGateInfo, Builder> {
    public static final ProtoAdapter<FeatureGateInfo> ADAPTER = null;
    public static final Boolean DEFAULT_IS_OPEN = null;
    private static final long serialVersionUID = 0;
    public final FeatureGateType mfg_type;
    public final Boolean mis_open;

    public static final class Builder extends Message.Builder<FeatureGateInfo, Builder> {
        public FeatureGateType mfg_type;
        public Boolean mis_open;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FeatureGateInfo m839build() {
            return new FeatureGateInfo(this.mfg_type, this.mis_open, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m839build();
        }

        public Builder fg_type(FeatureGateType r1) {
            this.mfg_type = r1;
            return this;
        }

        public Builder is_open(Boolean r1) {
            this.mis_open = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_FeatureGateInfo extends ProtoAdapter<FeatureGateInfo> {
        public ProtoAdapter_FeatureGateInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, FeatureGateInfo.class);
        }

        public FeatureGateInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mis_open = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mfg_type = (FeatureGateType) FeatureGateType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mis_open = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m839build();
        }

        public int encodedSize(FeatureGateInfo r5) {
            FeatureGateType r0 = r5.mfg_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = FeatureGateType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r5.mis_open;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m840decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FeatureGateInfo) r1);
        }

        public void encode(ProtoWriter r4, FeatureGateInfo r5) throws IOException {
            FeatureGateType r0 = r5.mfg_type;
            if (r0 == null) goto L5;
            FeatureGateType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mis_open;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FeatureGateInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeatureGateInfo();
        DEFAULT_IS_OPEN = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m838newBuilder() {
        Builder r0 = new Builder();
        r0.mfg_type = this.mfg_type;
        r0.mis_open = this.mis_open;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FeatureGateInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m838newBuilder();
    }

    public FeatureGateInfo(FeatureGateType r2, Boolean r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public FeatureGateInfo(FeatureGateType r2, Boolean r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mfg_type = r2;
        this.mis_open = r3;
    }
}
