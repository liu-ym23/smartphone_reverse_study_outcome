package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Env extends Message<Env, Builder> {
    public static final ProtoAdapter<Env> ADAPTER = null;
    public static final String DEFAULT_DID = "";
    public static final String DEFAULT_IP = "";
    public static final String DEFAULT_LOCATION = "";
    public static final String DEFAULT_UA = "";
    private static final long serialVersionUID = 0;
    public final ClientType mClient;
    public final String mDID;
    public final FlagType mFlag;
    public final String mIP;
    public final String mLocation;
    public final String mUA;

    public static final class Builder extends Message.Builder<Env, Builder> {
        public ClientType mClient;
        public String mDID;
        public FlagType mFlag;
        public String mIP;
        public String mLocation;
        public String mUA;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Env m2165build() {
            return new Env(this.mClient, this.mDID, this.mLocation, this.mUA, this.mIP, this.mFlag, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2165build();
        }

        public Builder Client(ClientType r1) {
            this.mClient = r1;
            return this;
        }

        public Builder DID(String r1) {
            this.mDID = r1;
            return this;
        }

        public Builder Flag(FlagType r1) {
            this.mFlag = r1;
            return this;
        }

        public Builder IP(String r1) {
            this.mIP = r1;
            return this;
        }

        public Builder Location(String r1) {
            this.mLocation = r1;
            return this;
        }

        public Builder UA(String r1) {
            this.mUA = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Env extends ProtoAdapter<Env> {
        public ProtoAdapter_Env() {
            super(FieldEncoding.LENGTH_DELIMITED, Env.class);
        }

        public Env decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mDID = "";
            r0.mLocation = "";
            r0.mUA = "";
            r0.mIP = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L19;
            switch(r3) {
                case 1: goto L21;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L23;
                default: goto L6;
            };
        L21:
            r0.mClient = (ClientType) ClientType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r0.mFlag = (FlagType) FlagType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r0.mIP = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            r0.mUA = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.mLocation = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.mDID = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L19:
            r9.endMessage(r1);
            return r0.m2165build();
        }

        public int encodedSize(Env r6) {
            ClientType r0 = r6.mClient;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ClientType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mDID;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mLocation;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mUA;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mIP;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            FlagType r16 = r6.mFlag;
            if (r16 == null) goto L26;
            r1 = FlagType.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            return (r15 + r1) + r6.unknownFields().size();
        L21:
            r14 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ Object m2166decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Env) r1);
        }

        public void encode(ProtoWriter r4, Env r5) throws IOException {
            ClientType r0 = r5.mClient;
            if (r0 == null) goto L5;
            ClientType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mDID;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mLocation;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mUA;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mIP;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            FlagType r7 = r5.mFlag;
            if (r7 == null) goto L20;
            FlagType.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Env) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Env();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2164newBuilder() {
        Builder r0 = new Builder();
        r0.mClient = this.mClient;
        r0.mDID = this.mDID;
        r0.mLocation = this.mLocation;
        r0.mUA = this.mUA;
        r0.mIP = this.mIP;
        r0.mFlag = this.mFlag;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Env.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2164newBuilder();
    }

    public Env(ClientType r9, String r10, String r11, String r12, String r13, FlagType r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public Env(ClientType r2, String r3, String r4, String r5, String r6, FlagType r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mClient = r2;
        this.mDID = r3;
        this.mLocation = r4;
        this.mUA = r5;
        this.mIP = r6;
        this.mFlag = r7;
    }
}
