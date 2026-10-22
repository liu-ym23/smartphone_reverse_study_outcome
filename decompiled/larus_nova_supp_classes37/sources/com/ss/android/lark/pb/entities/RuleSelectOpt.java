package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RuleSelectOpt extends com.squareup.wire.Message<RuleSelectOpt, Builder> {
    public static final ProtoAdapter<RuleSelectOpt> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mid;
    public final String mname;

    public static final class Builder extends com.squareup.wire.Message.Builder<RuleSelectOpt, Builder> {
        public String mid;
        public String mname;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public RuleSelectOpt m1535build() {
            return new RuleSelectOpt(this.mid, this.mname, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1535build();
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_RuleSelectOpt extends ProtoAdapter<RuleSelectOpt> {
        public ProtoAdapter_RuleSelectOpt() {
            super(FieldEncoding.LENGTH_DELIMITED, RuleSelectOpt.class);
        }

        public RuleSelectOpt decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mname = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1535build();
        }

        public int encodedSize(RuleSelectOpt r5) {
            String r0 = r5.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mname;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1536decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((RuleSelectOpt) r1);
        }

        public void encode(ProtoWriter r4, RuleSelectOpt r5) throws IOException {
            String r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mname;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (RuleSelectOpt) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RuleSelectOpt();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1534newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return RuleSelectOpt.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1534newBuilder();
    }

    public RuleSelectOpt(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public RuleSelectOpt(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mid = r2;
        this.mname = r3;
    }
}
