package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CryptoMessageDetail extends com.squareup.wire.Message<CryptoMessageDetail, Builder> {
    public static final ProtoAdapter<CryptoMessageDetail> ADAPTER = null;
    public static final ByteString DEFAULT_ADDITIONAL_DATA = null;
    public static final ByteString DEFAULT_CONTENT = null;
    public static final String DEFAULT_FROM_DEVICE_ID = "";
    public static final ByteString DEFAULT_NONCE = null;
    public static final ByteString DEFAULT_SENDER_PUBLIC_KEY = null;
    private static final long serialVersionUID = 0;
    public final ByteString madditional_data;
    public final ByteString mcontent;
    public final String mfrom_device_id;
    public final ByteString mnonce;
    public final ByteString msender_public_key;

    public static final class Builder extends com.squareup.wire.Message.Builder<CryptoMessageDetail, Builder> {
        public ByteString madditional_data;
        public ByteString mcontent;
        public String mfrom_device_id;
        public ByteString mnonce;
        public ByteString msender_public_key;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CryptoMessageDetail m1193build() {
            return new CryptoMessageDetail(this.mcontent, this.mfrom_device_id, this.msender_public_key, this.mnonce, this.madditional_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1193build();
        }

        public Builder additional_data(ByteString r1) {
            this.madditional_data = r1;
            return this;
        }

        public Builder content(ByteString r1) {
            this.mcontent = r1;
            return this;
        }

        public Builder from_device_id(String r1) {
            this.mfrom_device_id = r1;
            return this;
        }

        public Builder nonce(ByteString r1) {
            this.mnonce = r1;
            return this;
        }

        public Builder sender_public_key(ByteString r1) {
            this.msender_public_key = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CryptoMessageDetail extends ProtoAdapter<CryptoMessageDetail> {
        public ProtoAdapter_CryptoMessageDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, CryptoMessageDetail.class);
        }

        public CryptoMessageDetail decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            ByteString r1 = ByteString.EMPTY;
            r0.mcontent = r1;
            r0.mfrom_device_id = "";
            r0.msender_public_key = r1;
            r0.mnonce = r1;
            r0.madditional_data = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mcontent = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mfrom_device_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.msender_public_key = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mnonce = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.madditional_data = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r2);
            return r0.m1193build();
        }

        public int encodedSize(CryptoMessageDetail r6) {
            ByteString r0 = r6.mcontent;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mfrom_device_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ByteString r7 = r6.msender_public_key;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            ByteString r10 = r6.mnonce;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            ByteString r13 = r6.madditional_data;
            if (r13 == null) goto L22;
            r1 = ProtoAdapter.BYTES.encodedSizeWithTag(5, r13);
        L22:
            return (r12 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m1194decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CryptoMessageDetail) r1);
        }

        public void encode(ProtoWriter r4, CryptoMessageDetail r5) throws IOException {
            ByteString r0 = r5.mcontent;
            if (r0 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mfrom_device_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            ByteString r2 = r5.msender_public_key;
            if (r2 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r4, 3, r2);
        L11:
            ByteString r3 = r5.mnonce;
            if (r3 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r4, 4, r3);
        L14:
            ByteString r6 = r5.madditional_data;
            if (r6 == null) goto L17;
            ProtoAdapter.BYTES.encodeWithTag(r4, 5, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CryptoMessageDetail) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CryptoMessageDetail();
        ByteString r0 = ByteString.EMPTY;
        DEFAULT_CONTENT = r0;
        DEFAULT_SENDER_PUBLIC_KEY = r0;
        DEFAULT_NONCE = r0;
        DEFAULT_ADDITIONAL_DATA = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1192newBuilder() {
        Builder r0 = new Builder();
        r0.mcontent = this.mcontent;
        r0.mfrom_device_id = this.mfrom_device_id;
        r0.msender_public_key = this.msender_public_key;
        r0.mnonce = this.mnonce;
        r0.madditional_data = this.madditional_data;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CryptoMessageDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1192newBuilder();
    }

    public CryptoMessageDetail(ByteString r8, String r9, ByteString r10, ByteString r11, ByteString r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public CryptoMessageDetail(ByteString r2, String r3, ByteString r4, ByteString r5, ByteString r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mcontent = r2;
        this.mfrom_device_id = r3;
        this.msender_public_key = r4;
        this.mnonce = r5;
        this.madditional_data = r6;
    }
}
