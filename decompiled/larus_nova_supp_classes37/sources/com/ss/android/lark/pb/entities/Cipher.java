package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Cipher extends com.squareup.wire.Message<Cipher, Builder> {
    public static final ProtoAdapter<Cipher> ADAPTER = null;
    public static final ByteString DEFAULT_ADDITIONAL_DATA = null;
    public static final ByteString DEFAULT_NONCE = null;
    public static final ByteString DEFAULT_SECRET = null;
    private static final long serialVersionUID = 0;
    public final ByteString madditional_data;
    public final ByteString mnonce;
    public final ByteString msecret;

    public static final class Builder extends com.squareup.wire.Message.Builder<Cipher, Builder> {
        public ByteString madditional_data;
        public ByteString mnonce;
        public ByteString msecret;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Cipher m1181build() {
            return new Cipher(this.msecret, this.mnonce, this.madditional_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1181build();
        }

        public Builder additional_data(ByteString r1) {
            this.madditional_data = r1;
            return this;
        }

        public Builder nonce(ByteString r1) {
            this.mnonce = r1;
            return this;
        }

        public Builder secret(ByteString r1) {
            this.msecret = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Cipher extends ProtoAdapter<Cipher> {
        public ProtoAdapter_Cipher() {
            super(FieldEncoding.LENGTH_DELIMITED, Cipher.class);
        }

        public Cipher decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            ByteString r1 = ByteString.EMPTY;
            r0.msecret = r1;
            r0.mnonce = r1;
            r0.madditional_data = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.msecret = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mnonce = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.madditional_data = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r2);
            return r0.m1181build();
        }

        public int encodedSize(Cipher r6) {
            ByteString r0 = r6.msecret;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r0);
        L6:
            ByteString r3 = r6.mnonce;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ByteString r7 = r6.madditional_data;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m1182decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Cipher) r1);
        }

        public void encode(ProtoWriter r4, Cipher r5) throws IOException {
            ByteString r0 = r5.msecret;
            if (r0 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r4, 1, r0);
        L5:
            ByteString r1 = r5.mnonce;
            if (r1 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r4, 2, r1);
        L8:
            ByteString r2 = r5.madditional_data;
            if (r2 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Cipher) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Cipher();
        ByteString r0 = ByteString.EMPTY;
        DEFAULT_SECRET = r0;
        DEFAULT_NONCE = r0;
        DEFAULT_ADDITIONAL_DATA = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1180newBuilder() {
        Builder r0 = new Builder();
        r0.msecret = this.msecret;
        r0.mnonce = this.mnonce;
        r0.madditional_data = this.madditional_data;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Cipher.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1180newBuilder();
    }

    public Cipher(ByteString r2, ByteString r3, ByteString r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public Cipher(ByteString r2, ByteString r3, ByteString r4, ByteString r5) {
        super(ADAPTER, r5);
        this.msecret = r2;
        this.mnonce = r3;
        this.madditional_data = r4;
    }
}
