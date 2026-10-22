package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PassageMeta extends Message<PassageMeta, Builder> {
    public static final ProtoAdapter<PassageMeta> ADAPTER = null;
    public static final String DEFAULT_EXTRA = "";
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mextra;
    public final String mid;

    public static final class Builder extends Message.Builder<PassageMeta, Builder> {
        public String mextra;
        public String mid;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PassageMeta m2747build() {
            return new PassageMeta(this.mid, this.mextra, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2747build();
        }

        public Builder extra(String r1) {
            this.mextra = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PassageMeta extends ProtoAdapter<PassageMeta> {
        public ProtoAdapter_PassageMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, PassageMeta.class);
        }

        public PassageMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mextra = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 255) goto L9;
            r0.mextra = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2747build();
        }

        public int encodedSize(PassageMeta r5) {
            String r0 = r5.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mextra;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(255, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2748decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PassageMeta) r1);
        }

        public void encode(ProtoWriter r4, PassageMeta r5) throws IOException {
            String r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mextra;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 255, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PassageMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PassageMeta();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2746newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mextra = this.mextra;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PassageMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2746newBuilder();
    }

    public PassageMeta(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PassageMeta(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mid = r2;
        this.mextra = r3;
    }
}
