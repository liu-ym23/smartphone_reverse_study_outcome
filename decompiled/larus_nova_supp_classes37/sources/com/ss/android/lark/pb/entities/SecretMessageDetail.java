package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SecretMessageDetail extends com.squareup.wire.Message<SecretMessageDetail, Builder> {
    public static final ProtoAdapter<SecretMessageDetail> ADAPTER = null;
    public static final ByteString DEFAULT_CONTENT = null;
    public static final String DEFAULT_FROM_DEVICE_ID = "";
    public static final ByteString DEFAULT_HEADER = null;
    public static final ByteString DEFAULT_SENDER_PUBLIC_KEY = null;
    private static final long serialVersionUID = 0;
    public final ByteString mcontent;
    public final String mfrom_device_id;
    public final ByteString mheader;
    public final ByteString msender_public_key;

    public static final class Builder extends com.squareup.wire.Message.Builder<SecretMessageDetail, Builder> {
        public ByteString mcontent;
        public String mfrom_device_id;
        public ByteString mheader;
        public ByteString msender_public_key;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SecretMessageDetail m1538build() {
            return new SecretMessageDetail(this.mcontent, this.msender_public_key, this.mheader, this.mfrom_device_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1538build();
        }

        public Builder content(ByteString r1) {
            this.mcontent = r1;
            return this;
        }

        public Builder from_device_id(String r1) {
            this.mfrom_device_id = r1;
            return this;
        }

        public Builder header(ByteString r1) {
            this.mheader = r1;
            return this;
        }

        public Builder sender_public_key(ByteString r1) {
            this.msender_public_key = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SecretMessageDetail extends ProtoAdapter<SecretMessageDetail> {
        public ProtoAdapter_SecretMessageDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, SecretMessageDetail.class);
        }

        public SecretMessageDetail decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            ByteString r1 = ByteString.EMPTY;
            r0.mcontent = r1;
            r0.msender_public_key = r1;
            r0.mheader = r1;
            r0.mfrom_device_id = "";
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mcontent = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.msender_public_key = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mheader = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mfrom_device_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r2);
            return r0.m1538build();
        }

        public int encodedSize(SecretMessageDetail r6) {
            ByteString r0 = r6.mcontent;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r0);
        L6:
            ByteString r3 = r6.msender_public_key;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ByteString r7 = r6.mheader;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mfrom_device_id;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m1539decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SecretMessageDetail) r1);
        }

        public void encode(ProtoWriter r4, SecretMessageDetail r5) throws IOException {
            ByteString r0 = r5.mcontent;
            if (r0 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r4, 1, r0);
        L5:
            ByteString r1 = r5.msender_public_key;
            if (r1 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r4, 2, r1);
        L8:
            ByteString r2 = r5.mheader;
            if (r2 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mfrom_device_id;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SecretMessageDetail) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SecretMessageDetail();
        ByteString r0 = ByteString.EMPTY;
        DEFAULT_CONTENT = r0;
        DEFAULT_SENDER_PUBLIC_KEY = r0;
        DEFAULT_HEADER = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1537newBuilder() {
        Builder r0 = new Builder();
        r0.mcontent = this.mcontent;
        r0.msender_public_key = this.msender_public_key;
        r0.mheader = this.mheader;
        r0.mfrom_device_id = this.mfrom_device_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SecretMessageDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1537newBuilder();
    }

    public SecretMessageDetail(ByteString r7, ByteString r8, ByteString r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public SecretMessageDetail(ByteString r2, ByteString r3, ByteString r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mcontent = r2;
        this.msender_public_key = r3;
        this.mheader = r4;
        this.mfrom_device_id = r5;
    }
}
