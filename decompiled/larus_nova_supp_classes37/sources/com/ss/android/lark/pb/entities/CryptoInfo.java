package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CryptoInfo extends com.squareup.wire.Message<CryptoInfo, Builder> {
    public static final ProtoAdapter<CryptoInfo> ADAPTER = null;
    public static final Integer DEFAULT_BURNED_SECONDS = null;
    public static final String DEFAULT_SECRET_VERSION = "";
    private static final long serialVersionUID = 0;
    public final Integer mburned_seconds;
    public final CryptoType mcrypto_type;
    public final CryptoMessageDetail mfallback_detail;
    public final SecretMessageDetail msecret_message_detail;
    public final String msecret_version;

    public static final class Builder extends com.squareup.wire.Message.Builder<CryptoInfo, Builder> {
        public Integer mburned_seconds;
        public CryptoType mcrypto_type;
        public CryptoMessageDetail mfallback_detail;
        public SecretMessageDetail msecret_message_detail;
        public String msecret_version;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CryptoInfo m1190build() {
            return new CryptoInfo(this.mcrypto_type, this.msecret_version, this.mburned_seconds, this.mfallback_detail, this.msecret_message_detail, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1190build();
        }

        public Builder burned_seconds(Integer r1) {
            this.mburned_seconds = r1;
            return this;
        }

        public Builder crypto_type(CryptoType r1) {
            this.mcrypto_type = r1;
            return this;
        }

        public Builder fallback_detail(CryptoMessageDetail r1) {
            this.mfallback_detail = r1;
            return this;
        }

        public Builder secret_message_detail(SecretMessageDetail r1) {
            this.msecret_message_detail = r1;
            return this;
        }

        public Builder secret_version(String r1) {
            this.msecret_version = r1;
            return this;
        }
    }

    public static final enum CryptoType extends Enum<CryptoType> implements WireEnum {
        private static final /* synthetic */ CryptoType[] $VALUES = null;
        public static final ProtoAdapter<CryptoType> ADAPTER = null;
        public static final CryptoType E2EE = null;
        public static final CryptoType PLAIN_TEXT = null;
        public static final CryptoType THIRD_PARTY = null;
        public static final CryptoType UNKNOWN = null;
        private final int value;

        static {
            CryptoType r0 = new CryptoType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            CryptoType r1 = new CryptoType("PLAIN_TEXT", 1, 1);
            PLAIN_TEXT = r1;
            CryptoType r3 = new CryptoType("E2EE", 2, 2);
            E2EE = r3;
            CryptoType r5 = new CryptoType("THIRD_PARTY", 3, 3);
            THIRD_PARTY = r5;
            $VALUES = new CryptoType[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(CryptoType.class);
        }

        public static CryptoType[] values() {
            return (CryptoType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CryptoType fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return THIRD_PARTY;
        L14:
            return E2EE;
        L16:
            return PLAIN_TEXT;
        L18:
            return UNKNOWN;
        }

        public static CryptoType valueOf(String r1) {
            return (CryptoType) a.a(CryptoType.class, r1);
        }

        private CryptoType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_CryptoInfo extends ProtoAdapter<CryptoInfo> {
        public ProtoAdapter_CryptoInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CryptoInfo.class);
        }

        public CryptoInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.msecret_version = "";
            r0.mburned_seconds = 0;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.mcrypto_type = (CryptoType) CryptoType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.msecret_version = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mburned_seconds = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mfallback_detail = (CryptoMessageDetail) CryptoMessageDetail.ADAPTER.decode(r9);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.msecret_message_detail = (SecretMessageDetail) SecretMessageDetail.ADAPTER.decode(r9);
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.m1190build();
        }

        public int encodedSize(CryptoInfo r6) {
            CryptoType r0 = r6.mcrypto_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = CryptoType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.msecret_version;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Integer r7 = r6.mburned_seconds;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT32.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            CryptoMessageDetail r10 = r6.mfallback_detail;
            if (r10 == null) goto L17;
            int r11 = CryptoMessageDetail.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            SecretMessageDetail r13 = r6.msecret_message_detail;
            if (r13 == null) goto L22;
            r1 = SecretMessageDetail.ADAPTER.encodedSizeWithTag(5, r13);
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
        public /* bridge */ /* synthetic */ Object m1191decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CryptoInfo) r1);
        }

        public void encode(ProtoWriter r4, CryptoInfo r5) throws IOException {
            CryptoType r0 = r5.mcrypto_type;
            if (r0 == null) goto L5;
            CryptoType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.msecret_version;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            Integer r2 = r5.mburned_seconds;
            if (r2 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r2);
        L11:
            CryptoMessageDetail r3 = r5.mfallback_detail;
            if (r3 == null) goto L14;
            CryptoMessageDetail.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            SecretMessageDetail r6 = r5.msecret_message_detail;
            if (r6 == null) goto L17;
            SecretMessageDetail.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CryptoInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CryptoInfo();
        DEFAULT_BURNED_SECONDS = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1189newBuilder() {
        Builder r0 = new Builder();
        r0.mcrypto_type = this.mcrypto_type;
        r0.msecret_version = this.msecret_version;
        r0.mburned_seconds = this.mburned_seconds;
        r0.mfallback_detail = this.mfallback_detail;
        r0.msecret_message_detail = this.msecret_message_detail;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CryptoInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1189newBuilder();
    }

    public CryptoInfo(CryptoType r8, String r9, Integer r10, CryptoMessageDetail r11, SecretMessageDetail r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public CryptoInfo(CryptoType r2, String r3, Integer r4, CryptoMessageDetail r5, SecretMessageDetail r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mcrypto_type = r2;
        this.msecret_version = r3;
        this.mburned_seconds = r4;
        this.mfallback_detail = r5;
        this.msecret_message_detail = r6;
    }
}
