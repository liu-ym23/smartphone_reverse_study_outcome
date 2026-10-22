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
public final class ChatSecurityConfig extends com.squareup.wire.Message<ChatSecurityConfig, Builder> {
    public static final ProtoAdapter<ChatSecurityConfig> ADAPTER = null;
    public static final Integer DEFAULT_LIMIT = null;
    public static final Boolean DEFAULT_OPEN_SECURITY = null;
    public static final Integer DEFAULT_URGENT_LIMIT = null;
    private static final long serialVersionUID = 0;
    public final Integer mlimit;
    public final Boolean mopen_security;
    public final Read mread;
    public final Integer murgent_limit;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatSecurityConfig, Builder> {
        public Integer mlimit;
        public Boolean mopen_security;
        public Read mread;
        public Integer murgent_limit;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatSecurityConfig m1145build() {
            return new ChatSecurityConfig(this.mopen_security, this.mlimit, this.mread, this.murgent_limit, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1145build();
        }

        public Builder limit(Integer r1) {
            this.mlimit = r1;
            return this;
        }

        public Builder open_security(Boolean r1) {
            this.mopen_security = r1;
            return this;
        }

        public Builder read(Read r1) {
            this.mread = r1;
            return this;
        }

        public Builder urgent_limit(Integer r1) {
            this.murgent_limit = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatSecurityConfig extends ProtoAdapter<ChatSecurityConfig> {
        public ProtoAdapter_ChatSecurityConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatSecurityConfig.class);
        }

        public ChatSecurityConfig decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mopen_security = Boolean.FALSE;
            r0.mlimit = 0;
            r0.murgent_limit = 0;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mopen_security = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mlimit = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mread = (Read) Read.ADAPTER.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.murgent_limit = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m1145build();
        }

        public int encodedSize(ChatSecurityConfig r6) {
            Boolean r0 = r6.mopen_security;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Integer r3 = r6.mlimit;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Read r7 = r6.mread;
            if (r7 == null) goto L13;
            int r8 = Read.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Integer r10 = r6.murgent_limit;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.INT32.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m1146decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatSecurityConfig) r1);
        }

        public void encode(ProtoWriter r4, ChatSecurityConfig r5) throws IOException {
            Boolean r0 = r5.mopen_security;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Integer r1 = r5.mlimit;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
        L8:
            Read r2 = r5.mread;
            if (r2 == null) goto L11;
            Read.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            Integer r3 = r5.murgent_limit;
            if (r3 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatSecurityConfig) r2);
        }
    }

    public static final class Read extends com.squareup.wire.Message<Read, Builder> {
        public static final ProtoAdapter<Read> ADAPTER = null;
        public static final Integer DEFAULT_LIMIT = null;
        private static final long serialVersionUID = 0;
        public final Integer mlimit;
        public final ReadShowType mread_show_type;

        public static final class Builder extends com.squareup.wire.Message.Builder<Read, Builder> {
            public Integer mlimit;
            public ReadShowType mread_show_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Read m1148build() {
                return new Read(this.mread_show_type, this.mlimit, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1148build();
            }

            public Builder limit(Integer r1) {
                this.mlimit = r1;
                return this;
            }

            public Builder read_show_type(ReadShowType r1) {
                this.mread_show_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Read extends ProtoAdapter<Read> {
            public ProtoAdapter_Read() {
                super(FieldEncoding.LENGTH_DELIMITED, Read.class);
            }

            public Read decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mlimit = 0;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mread_show_type = (ReadShowType) ReadShowType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mlimit = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L15:
                r9.endMessage(r1);
                return r0.m1148build();
            }

            public int encodedSize(Read r5) {
                ReadShowType r0 = r5.mread_show_type;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ReadShowType.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Integer r3 = r5.mlimit;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1149decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Read) r1);
            }

            public void encode(ProtoWriter r4, Read r5) throws IOException {
                ReadShowType r0 = r5.mread_show_type;
                if (r0 == null) goto L5;
                ReadShowType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Integer r1 = r5.mlimit;
                if (r1 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Read) r2);
            }
        }

        public static final enum ReadShowType extends Enum<ReadShowType> implements WireEnum {
            private static final /* synthetic */ ReadShowType[] $VALUES = null;
            public static final ProtoAdapter<ReadShowType> ADAPTER = null;
            public static final ReadShowType NO_LIMIT = null;
            public static final ReadShowType ONE_COLUMN_WITH_LIMIT = null;
            public static final ReadShowType TWO_COLUMN_WITH_LIMIT = null;
            public static final ReadShowType UNKNOWN = null;
            private final int value;

            static {
                ReadShowType r0 = new ReadShowType("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                ReadShowType r1 = new ReadShowType("NO_LIMIT", 1, 1);
                NO_LIMIT = r1;
                ReadShowType r3 = new ReadShowType("TWO_COLUMN_WITH_LIMIT", 2, 2);
                TWO_COLUMN_WITH_LIMIT = r3;
                ReadShowType r5 = new ReadShowType("ONE_COLUMN_WITH_LIMIT", 3, 3);
                ONE_COLUMN_WITH_LIMIT = r5;
                $VALUES = new ReadShowType[]{r0, r1, r3, r5};
                ADAPTER = ProtoAdapter.newEnumAdapter(ReadShowType.class);
            }

            public static ReadShowType[] values() {
                return (ReadShowType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static ReadShowType fromValue(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return ONE_COLUMN_WITH_LIMIT;
            L14:
                return TWO_COLUMN_WITH_LIMIT;
            L16:
                return NO_LIMIT;
            L18:
                return UNKNOWN;
            }

            public static ReadShowType valueOf(String r1) {
                return (ReadShowType) a.a(ReadShowType.class, r1);
            }

            private ReadShowType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Read();
            DEFAULT_LIMIT = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1147newBuilder() {
            Builder r0 = new Builder();
            r0.mread_show_type = this.mread_show_type;
            r0.mlimit = this.mlimit;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Read.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1147newBuilder();
        }

        public Read(ReadShowType r2, Integer r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public Read(ReadShowType r2, Integer r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mread_show_type = r2;
            this.mlimit = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatSecurityConfig();
        DEFAULT_OPEN_SECURITY = Boolean.FALSE;
        DEFAULT_LIMIT = 0;
        DEFAULT_URGENT_LIMIT = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1144newBuilder() {
        Builder r0 = new Builder();
        r0.mopen_security = this.mopen_security;
        r0.mlimit = this.mlimit;
        r0.mread = this.mread;
        r0.murgent_limit = this.murgent_limit;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatSecurityConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1144newBuilder();
    }

    public ChatSecurityConfig(Boolean r7, Integer r8, Read r9, Integer r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public ChatSecurityConfig(Boolean r2, Integer r3, Read r4, Integer r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mopen_security = r2;
        this.mlimit = r3;
        this.mread = r4;
        this.murgent_limit = r5;
    }
}
