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
public final class Crypto extends com.squareup.wire.Message<Crypto, Builder> {
    public static final ProtoAdapter<Crypto> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Cipher mcipher;
    public final Type mtype;

    public static final class Builder extends com.squareup.wire.Message.Builder<Crypto, Builder> {
        public Cipher mcipher;
        public Type mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Crypto m1184build() {
            return new Crypto(this.mtype, this.mcipher, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1184build();
        }

        public Builder cipher(Cipher r1) {
            this.mcipher = r1;
            return this;
        }

        public Builder type(Type r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Crypto extends ProtoAdapter<Crypto> {
        public ProtoAdapter_Crypto() {
            super(FieldEncoding.LENGTH_DELIMITED, Crypto.class);
        }

        public Crypto decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mcipher = (Cipher) Cipher.ADAPTER.decode(r9);
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m1184build();
        }

        public int encodedSize(Crypto r5) {
            Type r0 = r5.mtype;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = Type.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Cipher r3 = r5.mcipher;
            if (r3 == null) goto L10;
            r1 = Cipher.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1185decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Crypto) r1);
        }

        public void encode(ProtoWriter r4, Crypto r5) throws IOException {
            Type r0 = r5.mtype;
            if (r0 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            Cipher r1 = r5.mcipher;
            if (r1 == null) goto L8;
            Cipher.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Crypto) r2);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AES_256_GCM = null;
        public static final Type AES_CTR = null;
        public static final Type CRYPTO_SDK_DOWNGRADE = null;
        public static final Type CRYPTO_SDK_THIRDPARTY = null;
        public static final Type CRYPTO_SDK_UNIFIED = null;
        public static final Type SM4_128 = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("AES_256_GCM", 1, 1);
            AES_256_GCM = r1;
            Type r3 = new Type("AES_CTR", 2, 2);
            AES_CTR = r3;
            Type r5 = new Type("CRYPTO_SDK_UNIFIED", 3, 3);
            CRYPTO_SDK_UNIFIED = r5;
            Type r7 = new Type("CRYPTO_SDK_DOWNGRADE", 4, 4);
            CRYPTO_SDK_DOWNGRADE = r7;
            Type r9 = new Type("CRYPTO_SDK_THIRDPARTY", 5, 5);
            CRYPTO_SDK_THIRDPARTY = r9;
            Type r11 = new Type("SM4_128", 6, 6);
            SM4_128 = r11;
            $VALUES = new Type[]{r0, r1, r3, r5, r7, r9, r11};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r0) {
            switch(r0) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return SM4_128;
        L8:
            return CRYPTO_SDK_THIRDPARTY;
        L10:
            return CRYPTO_SDK_DOWNGRADE;
        L12:
            return CRYPTO_SDK_UNIFIED;
        L14:
            return AES_CTR;
        L16:
            return AES_256_GCM;
        L18:
            return UNKNOWN;
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        private Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Crypto();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1183newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.mcipher = this.mcipher;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Crypto.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1183newBuilder();
    }

    public Crypto(Type r2, Cipher r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Crypto(Type r2, Cipher r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtype = r2;
        this.mcipher = r3;
    }
}
