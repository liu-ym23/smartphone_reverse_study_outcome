package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ThemeColor extends com.squareup.wire.Message<ThemeColor, Builder> {
    public static final ProtoAdapter<ThemeColor> ADAPTER = null;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_VALUE = null;
    private static final long serialVersionUID = 0;
    public final Key mkey;
    public final String mtoken;
    public final Integer mvalue;

    public static final class Builder extends com.squareup.wire.Message.Builder<ThemeColor, Builder> {
        public Key mkey;
        public String mtoken;
        public Integer mvalue;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ThemeColor m1553build() {
            return new ThemeColor(this.mtoken, this.mkey, this.mvalue, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1553build();
        }

        public Builder key(Key r1) {
            this.mkey = r1;
            return this;
        }

        public Builder token(String r1) {
            this.mtoken = r1;
            return this;
        }

        public Builder value(Integer r1) {
            this.mvalue = r1;
            return this;
        }
    }

    public static final class Key extends com.squareup.wire.Message<Key, Builder> {
        public static final ProtoAdapter<Key> ADAPTER = null;
        public static final Integer DEFAULT_ALPHA = null;
        public static final Integer DEFAULT_VALUE = null;
        private static final long serialVersionUID = 0;
        public final Integer malpha;
        public final KeyType mtype;
        public final Integer mvalue;

        public static final class Builder extends com.squareup.wire.Message.Builder<Key, Builder> {
            public Integer malpha;
            public KeyType mtype;
            public Integer mvalue;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Key m1555build() {
                KeyType r0 = this.mtype;
                if (r0 == null) goto L9;
                if (this.mvalue == null) goto L9;
                return new Key(this.mtype, this.mvalue, this.malpha, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "mtype", this.mvalue, "mvalue"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1555build();
            }

            public Builder alpha(Integer r1) {
                this.malpha = r1;
                return this;
            }

            public Builder type(KeyType r1) {
                this.mtype = r1;
                return this;
            }

            public Builder value(Integer r1) {
                this.mvalue = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Key extends ProtoAdapter<Key> {
            public ProtoAdapter_Key() {
                super(FieldEncoding.LENGTH_DELIMITED, Key.class);
            }

            public Key decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mvalue = 0;
                r0.malpha = 100;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mtype = (KeyType) KeyType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mvalue = (Integer) ProtoAdapter.UINT32.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.malpha = (Integer) ProtoAdapter.UINT32.decode(r9);
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L18:
                r9.endMessage(r1);
                return r0.m1555build();
            }

            public int encodedSize(Key r5) {
                int r0 = KeyType.ADAPTER.encodedSizeWithTag(1, r5.mtype);
                ProtoAdapter r1 = ProtoAdapter.UINT32;
                int r2 = r0 + r1.encodedSizeWithTag(2, r5.mvalue);
                Integer r3 = r5.malpha;
                if (r3 == null) goto L5;
                int r4 = r1.encodedSizeWithTag(3, r3);
            L7:
                return (r2 + r4) + r5.unknownFields().size();
            L5:
                r4 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1556decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Key) r1);
            }

            public void encode(ProtoWriter r4, Key r5) throws IOException {
                KeyType.ADAPTER.encodeWithTag(r4, 1, r5.mtype);
                ProtoAdapter r0 = ProtoAdapter.UINT32;
                r0.encodeWithTag(r4, 2, r5.mvalue);
                Integer r1 = r5.malpha;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r4, 3, r1);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Key) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Key();
            DEFAULT_VALUE = 0;
            DEFAULT_ALPHA = 100;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1554newBuilder() {
            Builder r0 = new Builder();
            r0.mtype = this.mtype;
            r0.mvalue = this.mvalue;
            r0.malpha = this.malpha;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Key.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1554newBuilder();
        }

        public Key(KeyType r2, Integer r3, Integer r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public Key(KeyType r2, Integer r3, Integer r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mtype = r2;
            this.mvalue = r3;
            this.malpha = r4;
        }
    }

    public static final enum KeyType extends Enum<KeyType> implements WireEnum {
        private static final /* synthetic */ KeyType[] $VALUES = null;
        public static final ProtoAdapter<KeyType> ADAPTER = null;
        public static final KeyType B = null;
        public static final KeyType C = null;
        public static final KeyType G = null;
        public static final KeyType I = null;
        public static final KeyType L = null;
        public static final KeyType N = null;
        public static final KeyType O = null;
        public static final KeyType P = null;
        public static final KeyType R = null;
        public static final KeyType S = null;
        public static final KeyType STATIC_WHITE = null;
        public static final KeyType T = null;
        public static final KeyType V = null;
        public static final KeyType W = null;
        public static final KeyType Y = null;
        private final int value;

        static {
            KeyType r0 = new KeyType("N", 0, 0);
            N = r0;
            KeyType r1 = new KeyType("B", 1, 1);
            B = r1;
            KeyType r3 = new KeyType("W", 2, 2);
            W = r3;
            KeyType r5 = new KeyType("T", 3, 3);
            T = r5;
            KeyType r7 = new KeyType("G", 4, 4);
            G = r7;
            KeyType r9 = new KeyType("L", 5, 5);
            L = r9;
            KeyType r11 = new KeyType("Y", 6, 6);
            Y = r11;
            KeyType r13 = new KeyType("S", 7, 7);
            S = r13;
            KeyType r15 = new KeyType("O", 8, 8);
            O = r15;
            KeyType r14 = new KeyType("R", 9, 9);
            R = r14;
            KeyType r12 = new KeyType("C", 10, 10);
            C = r12;
            KeyType r10 = new KeyType("V", 11, 11);
            V = r10;
            KeyType r8 = new KeyType("P", 12, 12);
            P = r8;
            KeyType r6 = new KeyType("I", 13, 13);
            I = r6;
            KeyType r4 = new KeyType("STATIC_WHITE", 14, 14);
            STATIC_WHITE = r4;
            $VALUES = new KeyType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
            ADAPTER = ProtoAdapter.newEnumAdapter(KeyType.class);
        }

        public static KeyType[] values() {
            return (KeyType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static KeyType fromValue(int r0) {
            switch(r0) {
                case 0: goto L34;
                case 1: goto L32;
                case 2: goto L30;
                case 3: goto L28;
                case 4: goto L26;
                case 5: goto L24;
                case 6: goto L22;
                case 7: goto L20;
                case 8: goto L18;
                case 9: goto L16;
                case 10: goto L14;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                case 14: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return STATIC_WHITE;
        L8:
            return I;
        L10:
            return P;
        L12:
            return V;
        L14:
            return C;
        L16:
            return R;
        L18:
            return O;
        L20:
            return S;
        L22:
            return Y;
        L24:
            return L;
        L26:
            return G;
        L28:
            return T;
        L30:
            return W;
        L32:
            return B;
        L34:
            return N;
        }

        public static KeyType valueOf(String r1) {
            return (KeyType) a.a(KeyType.class, r1);
        }

        private KeyType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_ThemeColor extends ProtoAdapter<ThemeColor> {
        public ProtoAdapter_ThemeColor() {
            super(FieldEncoding.LENGTH_DELIMITED, ThemeColor.class);
        }

        public ThemeColor decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtoken = "";
            r0.mvalue = 0;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mtoken = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mkey = (Key) Key.ADAPTER.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mvalue = (Integer) ProtoAdapter.UINT32.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1553build();
        }

        public int encodedSize(ThemeColor r6) {
            String r0 = r6.mtoken;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Key r3 = r6.mkey;
            if (r3 == null) goto L9;
            int r4 = Key.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Integer r7 = r6.mvalue;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.UINT32.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m1557decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ThemeColor) r1);
        }

        public void encode(ProtoWriter r4, ThemeColor r5) throws IOException {
            String r0 = r5.mtoken;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Key r1 = r5.mkey;
            if (r1 == null) goto L8;
            Key.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            Integer r2 = r5.mvalue;
            if (r2 == null) goto L11;
            ProtoAdapter.UINT32.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ThemeColor) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ThemeColor();
        DEFAULT_VALUE = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1552newBuilder() {
        Builder r0 = new Builder();
        r0.mtoken = this.mtoken;
        r0.mkey = this.mkey;
        r0.mvalue = this.mvalue;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ThemeColor.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1552newBuilder();
    }

    public ThemeColor(String r2, Key r3, Integer r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ThemeColor(String r2, Key r3, Integer r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mtoken = r2;
        this.mkey = r3;
        this.mvalue = r4;
    }
}
