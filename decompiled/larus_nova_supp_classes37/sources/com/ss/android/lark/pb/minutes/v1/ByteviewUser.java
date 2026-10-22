package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ByteviewUser extends Message<ByteviewUser, Builder> {
    public static final ProtoAdapter<ByteviewUser> ADAPTER = null;
    public static final String DEFAULT_DEVICE_ID = "";
    public static final String DEFAULT_USER_ID = "";
    public static final ParticipantType DEFAULT_USER_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String device_id;
    public final String user_id;
    public final ParticipantType user_type;

    public static final class Builder extends Message.Builder<ByteviewUser, Builder> {
        public String device_id;
        public String user_id;
        public ParticipantType user_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ByteviewUser m1835build() {
            String r0 = this.user_id;
            if (r0 == null) goto L11;
            if (this.device_id == null) goto L11;
            if (this.user_type == null) goto L11;
            return new ByteviewUser(this.user_id, this.device_id, this.user_type, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "user_id", this.device_id, "device_id", this.user_type, "user_type"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1835build();
        }

        public Builder device_id(String r1) {
            this.device_id = r1;
            return this;
        }

        public Builder user_id(String r1) {
            this.user_id = r1;
            return this;
        }

        public Builder user_type(ParticipantType r1) {
            this.user_type = r1;
            return this;
        }
    }

    public static final enum ParticipantType extends Enum<ParticipantType> implements WireEnum {
        private static final /* synthetic */ ParticipantType[] $VALUES = null;
        public static final ProtoAdapter<ParticipantType> ADAPTER = null;
        public static final ParticipantType DOC_USER = null;
        public static final ParticipantType LARK_USER = null;
        public static final ParticipantType NEO_GUEST_USER = null;
        public static final ParticipantType NEO_USER = null;
        public static final ParticipantType PSTN_USER = null;
        public static final ParticipantType ROOM = null;
        public static final ParticipantType SIP_USER = null;
        public static final ParticipantType UNKNOW = null;
        private final int value;

        static {
            ParticipantType r0 = new ParticipantType("UNKNOW", 0, 0);
            UNKNOW = r0;
            ParticipantType r1 = new ParticipantType("LARK_USER", 1, 1);
            LARK_USER = r1;
            ParticipantType r3 = new ParticipantType("ROOM", 2, 2);
            ROOM = r3;
            ParticipantType r5 = new ParticipantType("DOC_USER", 3, 3);
            DOC_USER = r5;
            ParticipantType r7 = new ParticipantType("NEO_USER", 4, 4);
            NEO_USER = r7;
            ParticipantType r9 = new ParticipantType("NEO_GUEST_USER", 5, 5);
            NEO_GUEST_USER = r9;
            ParticipantType r11 = new ParticipantType("PSTN_USER", 6, 6);
            PSTN_USER = r11;
            ParticipantType r13 = new ParticipantType("SIP_USER", 7, 7);
            SIP_USER = r13;
            $VALUES = new ParticipantType[]{r0, r1, r3, r5, r7, r9, r11, r13};
            ADAPTER = ProtoAdapter.newEnumAdapter(ParticipantType.class);
        }

        public static ParticipantType[] values() {
            return (ParticipantType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ParticipantType fromValue(int r0) {
            switch(r0) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return SIP_USER;
        L8:
            return PSTN_USER;
        L10:
            return NEO_GUEST_USER;
        L12:
            return NEO_USER;
        L14:
            return DOC_USER;
        L16:
            return ROOM;
        L18:
            return LARK_USER;
        L20:
            return UNKNOW;
        }

        public static ParticipantType valueOf(String r1) {
            return (ParticipantType) a.a(ParticipantType.class, r1);
        }

        private ParticipantType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_ByteviewUser extends ProtoAdapter<ByteviewUser> {
        public ProtoAdapter_ByteviewUser() {
            super(FieldEncoding.LENGTH_DELIMITED, ByteviewUser.class);
        }

        public ByteviewUser decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.user_id = "";
            r0.device_id = "";
            r0.user_type = ParticipantType.UNKNOW;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.user_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.device_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.user_type = (ParticipantType) ParticipantType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m1835build();
        }

        public int encodedSize(ByteviewUser r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return ((r0.encodedSizeWithTag(1, r5.user_id) + r0.encodedSizeWithTag(2, r5.device_id)) + ParticipantType.ADAPTER.encodedSizeWithTag(3, r5.user_type)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1836decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ByteviewUser) r1);
        }

        public void encode(ProtoWriter r4, ByteviewUser r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.user_id);
            r0.encodeWithTag(r4, 2, r5.device_id);
            ParticipantType.ADAPTER.encodeWithTag(r4, 3, r5.user_type);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ByteviewUser) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ByteviewUser();
        DEFAULT_USER_TYPE = ParticipantType.UNKNOW;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1834newBuilder() {
        Builder r0 = new Builder();
        r0.user_id = this.user_id;
        r0.device_id = this.device_id;
        r0.user_type = this.user_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ByteviewUser.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1834newBuilder();
    }

    public ByteviewUser(String r2, String r3, ParticipantType r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ByteviewUser(String r2, String r3, ParticipantType r4, ByteString r5) {
        super(ADAPTER, r5);
        this.user_id = r2;
        this.device_id = r3;
        this.user_type = r4;
    }
}
