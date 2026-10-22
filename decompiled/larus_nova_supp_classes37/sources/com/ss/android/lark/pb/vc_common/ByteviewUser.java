package com.ss.android.lark.pb.vc_common;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.annotation.Debug;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ByteviewUser extends Message<ByteviewUser, Builder> {
    public static final ProtoAdapter<ByteviewUser> ADAPTER = null;
    public static final String DEFAULT_DEVICE_ID = "";
    public static final String DEFAULT_USER_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MDEVICE_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MUSER_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MUSER_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String mdevice_id;
    public final String muser_id;
    public final ParticipantType muser_type;

    public static final class Builder extends Message.Builder<ByteviewUser, Builder> {
        public String mdevice_id;
        public String muser_id;
        public ParticipantType muser_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ByteviewUser m3092build() {
            String r0 = this.muser_id;
            if (r0 == null) goto L11;
            if (this.mdevice_id == null) goto L11;
            if (this.muser_type == null) goto L11;
            return new ByteviewUser(this.muser_id, this.mdevice_id, this.muser_type, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "muser_id", this.mdevice_id, "mdevice_id", this.muser_type, "muser_type"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3092build();
        }

        public Builder device_id(String r1) {
            this.mdevice_id = r1;
            return this;
        }

        public Builder user_id(String r1) {
            this.muser_id = r1;
            return this;
        }

        public Builder user_type(ParticipantType r1) {
            this.muser_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ByteviewUser extends ProtoAdapter<ByteviewUser> {
        public ProtoAdapter_ByteviewUser() {
            super(FieldEncoding.LENGTH_DELIMITED, ByteviewUser.class);
        }

        public ByteviewUser decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.muser_id = "";
            r0.mdevice_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.muser_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mdevice_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.muser_type = (ParticipantType) ParticipantType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
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
            return r0.m3092build();
        }

        public int encodedSize(ByteviewUser r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return ((r0.encodedSizeWithTag(1, r5.muser_id) + r0.encodedSizeWithTag(2, r5.mdevice_id)) + ParticipantType.ADAPTER.encodedSizeWithTag(3, r5.muser_type)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3093decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ByteviewUser) r1);
        }

        public void encode(ProtoWriter r4, ByteviewUser r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.muser_id);
            r0.encodeWithTag(r4, 2, r5.mdevice_id);
            ParticipantType.ADAPTER.encodeWithTag(r4, 3, r5.muser_type);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ByteviewUser) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ByteviewUser();
        FIELD_OPTIONS_MUSER_ID = new FieldOptions.Builder().debug(new Debug.Builder().m815build()).build();
        FIELD_OPTIONS_MDEVICE_ID = new FieldOptions.Builder().debug(new Debug.Builder().m815build()).build();
        FIELD_OPTIONS_MUSER_TYPE = new FieldOptions.Builder().debug(new Debug.Builder().m815build()).build();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3091newBuilder() {
        Builder r0 = new Builder();
        r0.muser_id = this.muser_id;
        r0.mdevice_id = this.mdevice_id;
        r0.muser_type = this.muser_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ByteviewUser.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3091newBuilder();
    }

    public ByteviewUser(String r2, String r3, ParticipantType r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ByteviewUser(String r2, String r3, ParticipantType r4, ByteString r5) {
        super(ADAPTER, r5);
        this.muser_id = r2;
        this.mdevice_id = r3;
        this.muser_type = r4;
    }
}
