package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DocSecLabel extends Message<DocSecLabel, Builder> {
    public static final ProtoAdapter<DocSecLabel> ADAPTER = null;
    public static final String DEFAULT_LABELID = "";
    public static final String DEFAULT_LABELNAMECN = "";
    public static final String DEFAULT_LABELNAMEEN = "";
    private static final long serialVersionUID = 0;
    public final String mLabelID;
    public final String mLabelNameCN;
    public final String mLabelNameEN;

    public static final class Builder extends Message.Builder<DocSecLabel, Builder> {
        public String mLabelID;
        public String mLabelNameCN;
        public String mLabelNameEN;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DocSecLabel m2159build() {
            return new DocSecLabel(this.mLabelID, this.mLabelNameCN, this.mLabelNameEN, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2159build();
        }

        public Builder LabelID(String r1) {
            this.mLabelID = r1;
            return this;
        }

        public Builder LabelNameCN(String r1) {
            this.mLabelNameCN = r1;
            return this;
        }

        public Builder LabelNameEN(String r1) {
            this.mLabelNameEN = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DocSecLabel extends ProtoAdapter<DocSecLabel> {
        public ProtoAdapter_DocSecLabel() {
            super(FieldEncoding.LENGTH_DELIMITED, DocSecLabel.class);
        }

        public DocSecLabel decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mLabelID = "";
            r0.mLabelNameCN = "";
            r0.mLabelNameEN = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mLabelID = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mLabelNameCN = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mLabelNameEN = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2159build();
        }

        public int encodedSize(DocSecLabel r6) {
            String r0 = r6.mLabelID;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mLabelNameCN;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mLabelNameEN;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m2160decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DocSecLabel) r1);
        }

        public void encode(ProtoWriter r4, DocSecLabel r5) throws IOException {
            String r0 = r5.mLabelID;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mLabelNameCN;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mLabelNameEN;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DocSecLabel) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocSecLabel();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2158newBuilder() {
        Builder r0 = new Builder();
        r0.mLabelID = this.mLabelID;
        r0.mLabelNameCN = this.mLabelNameCN;
        r0.mLabelNameEN = this.mLabelNameEN;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DocSecLabel.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2158newBuilder();
    }

    public DocSecLabel(String r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public DocSecLabel(String r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mLabelID = r2;
        this.mLabelNameCN = r3;
        this.mLabelNameEN = r4;
    }
}
