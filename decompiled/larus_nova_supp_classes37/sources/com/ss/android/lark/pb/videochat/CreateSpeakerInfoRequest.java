package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CreateSpeakerInfoRequest extends Message<CreateSpeakerInfoRequest, Builder> {
    public static final ProtoAdapter<CreateSpeakerInfoRequest> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_OPERATOR_ID = "";
    private static final long serialVersionUID = 0;
    public final String mmeeting_id;
    public final String mname;
    public final String moperator_id;

    public static final class Builder extends Message.Builder<CreateSpeakerInfoRequest, Builder> {
        public String mmeeting_id;
        public String mname;
        public String moperator_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CreateSpeakerInfoRequest m3101build() {
            String r0 = this.moperator_id;
            if (r0 == null) goto L9;
            if (this.mmeeting_id == null) goto L9;
            return new CreateSpeakerInfoRequest(this.moperator_id, this.mmeeting_id, this.mname, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "moperator_id", this.mmeeting_id, "mmeeting_id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3101build();
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder operator_id(String r1) {
            this.moperator_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateSpeakerInfoRequest extends ProtoAdapter<CreateSpeakerInfoRequest> {
        public ProtoAdapter_CreateSpeakerInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateSpeakerInfoRequest.class);
        }

        public CreateSpeakerInfoRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.moperator_id = "";
            r0.mmeeting_id = "";
            r0.mname = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.moperator_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mmeeting_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m3101build();
        }

        public int encodedSize(CreateSpeakerInfoRequest r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r5.moperator_id) + r0.encodedSizeWithTag(2, r5.mmeeting_id);
            String r2 = r5.mname;
            if (r2 == null) goto L5;
            int r3 = r0.encodedSizeWithTag(3, r2);
        L7:
            return (r1 + r3) + r5.unknownFields().size();
        L5:
            r3 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3102decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CreateSpeakerInfoRequest) r1);
        }

        public void encode(ProtoWriter r4, CreateSpeakerInfoRequest r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.moperator_id);
            r0.encodeWithTag(r4, 2, r5.mmeeting_id);
            String r1 = r5.mname;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 3, r1);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CreateSpeakerInfoRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CreateSpeakerInfoRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3100newBuilder() {
        Builder r0 = new Builder();
        r0.moperator_id = this.moperator_id;
        r0.mmeeting_id = this.mmeeting_id;
        r0.mname = this.mname;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CreateSpeakerInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3100newBuilder();
    }

    public CreateSpeakerInfoRequest(String r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public CreateSpeakerInfoRequest(String r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.moperator_id = r2;
        this.mmeeting_id = r3;
        this.mname = r4;
    }
}
