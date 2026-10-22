package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class EncryptedInfo extends com.squareup.wire.Message<EncryptedInfo, Builder> {
    public static final ProtoAdapter<EncryptedInfo> ADAPTER = null;
    public static final ByteString DEFAULT_DATA_SECRET = null;
    public static final ByteString DEFAULT_ENCRYPTED_DATA = null;
    public static final ByteString DEFAULT_ENCRYPTED_DATA_SECRET = null;
    public static final Boolean DEFAULT_IS_TRANSMIT = null;
    private static final long serialVersionUID = 0;
    public final ByteString mdata_secret;
    public final ByteString mencrypted_data;
    public final ByteString mencrypted_data_secret;
    public final Map<String, String> mfile_keys;
    public final Map<String, String> mimage_keys;
    public final Boolean mis_transmit;
    public final ResCryptoType mres_crypto_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<EncryptedInfo, Builder> {
        public ByteString mdata_secret;
        public ByteString mencrypted_data;
        public ByteString mencrypted_data_secret;
        public Map<String, String> mfile_keys;
        public Map<String, String> mimage_keys;
        public Boolean mis_transmit;
        public ResCryptoType mres_crypto_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public EncryptedInfo m1211build() {
            return new EncryptedInfo(this.mdata_secret, this.mencrypted_data_secret, this.mencrypted_data, this.mimage_keys, this.mfile_keys, this.mis_transmit, this.mres_crypto_type, super.buildUnknownFields());
        }

        public Builder() {
            this.mimage_keys = Internal.newMutableMap();
            this.mfile_keys = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1211build();
        }

        public Builder data_secret(ByteString r1) {
            this.mdata_secret = r1;
            return this;
        }

        public Builder encrypted_data(ByteString r1) {
            this.mencrypted_data = r1;
            return this;
        }

        public Builder encrypted_data_secret(ByteString r1) {
            this.mencrypted_data_secret = r1;
            return this;
        }

        public Builder file_keys(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfile_keys = r1;
            return this;
        }

        public Builder image_keys(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mimage_keys = r1;
            return this;
        }

        public Builder is_transmit(Boolean r1) {
            this.mis_transmit = r1;
            return this;
        }

        public Builder res_crypto_type(ResCryptoType r1) {
            this.mres_crypto_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_EncryptedInfo extends ProtoAdapter<EncryptedInfo> {
        private final ProtoAdapter<Map<String, String>> mfile_keys;
        private final ProtoAdapter<Map<String, String>> mimage_keys;

        public ProtoAdapter_EncryptedInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, EncryptedInfo.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mimage_keys = ProtoAdapter.newMapAdapter(r0, r0);
            this.mfile_keys = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public EncryptedInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            ByteString r1 = ByteString.EMPTY;
            r0.mdata_secret = r1;
            r0.mencrypted_data_secret = r1;
            r0.mencrypted_data = r1;
            r0.mis_transmit = Boolean.FALSE;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L19;
                default: goto L6;
            };
        L19:
            r0.mres_crypto_type = (ResCryptoType) ResCryptoType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r0.mis_transmit = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L12:
            r0.mfile_keys.putAll((Map) this.mfile_keys.decode(r9));
            goto L3
        L13:
            r0.mimage_keys.putAll((Map) this.mimage_keys.decode(r9));
            goto L3
        L14:
            r0.mencrypted_data = (ByteString) ProtoAdapter.BYTES.decode(r9);
            goto L3
        L15:
            r0.mencrypted_data_secret = (ByteString) ProtoAdapter.BYTES.decode(r9);
            goto L3
        L16:
            r0.mdata_secret = (ByteString) ProtoAdapter.BYTES.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L17:
            r9.endMessage(r2);
            return r0.m1211build();
        }

        public int encodedSize(EncryptedInfo r6) {
            ByteString r0 = r6.mdata_secret;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r0);
        L6:
            ByteString r3 = r6.mencrypted_data_secret;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ByteString r7 = r6.mencrypted_data;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r7);
        L14:
            int r9 = ((r5 + r8) + this.mimage_keys.encodedSizeWithTag(4, r6.mimage_keys)) + this.mfile_keys.encodedSizeWithTag(5, r6.mfile_keys);
            Boolean r10 = r6.mis_transmit;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r10);
        L18:
            int r12 = r9 + r11;
            ResCryptoType r13 = r6.mres_crypto_type;
            if (r13 == null) goto L22;
            r1 = ResCryptoType.ADAPTER.encodedSizeWithTag(7, r13);
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
        public /* bridge */ /* synthetic */ Object m1212decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((EncryptedInfo) r1);
        }

        public void encode(ProtoWriter r4, EncryptedInfo r5) throws IOException {
            ByteString r0 = r5.mdata_secret;
            if (r0 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r4, 1, r0);
        L5:
            ByteString r1 = r5.mencrypted_data_secret;
            if (r1 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r4, 2, r1);
        L8:
            ByteString r2 = r5.mencrypted_data;
            if (r2 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r4, 3, r2);
        L11:
            this.mimage_keys.encodeWithTag(r4, 4, r5.mimage_keys);
            this.mfile_keys.encodeWithTag(r4, 5, r5.mfile_keys);
            Boolean r3 = r5.mis_transmit;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r3);
        L14:
            ResCryptoType r6 = r5.mres_crypto_type;
            if (r6 == null) goto L17;
            ResCryptoType.ADAPTER.encodeWithTag(r4, 7, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (EncryptedInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EncryptedInfo();
        ByteString r0 = ByteString.EMPTY;
        DEFAULT_DATA_SECRET = r0;
        DEFAULT_ENCRYPTED_DATA_SECRET = r0;
        DEFAULT_ENCRYPTED_DATA = r0;
        DEFAULT_IS_TRANSMIT = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1210newBuilder() {
        Builder r0 = new Builder();
        r0.mdata_secret = this.mdata_secret;
        r0.mencrypted_data_secret = this.mencrypted_data_secret;
        r0.mencrypted_data = this.mencrypted_data;
        r0.mimage_keys = Internal.copyOf("mimage_keys", this.mimage_keys);
        r0.mfile_keys = Internal.copyOf("mfile_keys", this.mfile_keys);
        r0.mis_transmit = this.mis_transmit;
        r0.mres_crypto_type = this.mres_crypto_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return EncryptedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1210newBuilder();
    }

    public EncryptedInfo(ByteString r10, ByteString r11, ByteString r12, Map<String, String> r13, Map<String, String> r14, Boolean r15, ResCryptoType r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public EncryptedInfo(ByteString r2, ByteString r3, ByteString r4, Map<String, String> r5, Map<String, String> r6, Boolean r7, ResCryptoType r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mdata_secret = r2;
        this.mencrypted_data_secret = r3;
        this.mencrypted_data = r4;
        this.mimage_keys = Internal.immutableCopyOf("mimage_keys", r5);
        this.mfile_keys = Internal.immutableCopyOf("mfile_keys", r6);
        this.mis_transmit = r7;
        this.mres_crypto_type = r8;
    }
}
