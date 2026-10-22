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
public final class CreateSpeakerInfoResponse extends Message<CreateSpeakerInfoResponse, Builder> {
    public static final ProtoAdapter<CreateSpeakerInfoResponse> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SPEAKER_NAME_DUPLICATED = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_speaker_name_duplicated;
    public final SpeakerInfo mspeaker_info;

    public static final class Builder extends Message.Builder<CreateSpeakerInfoResponse, Builder> {
        public Boolean mis_speaker_name_duplicated;
        public SpeakerInfo mspeaker_info;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CreateSpeakerInfoResponse m3104build() {
            Boolean r0 = this.mis_speaker_name_duplicated;
            if (r0 == null) goto L7;
            return new CreateSpeakerInfoResponse(this.mis_speaker_name_duplicated, this.mspeaker_info, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mis_speaker_name_duplicated"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3104build();
        }

        public Builder is_speaker_name_duplicated(Boolean r1) {
            this.mis_speaker_name_duplicated = r1;
            return this;
        }

        public Builder speaker_info(SpeakerInfo r1) {
            this.mspeaker_info = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateSpeakerInfoResponse extends ProtoAdapter<CreateSpeakerInfoResponse> {
        public ProtoAdapter_CreateSpeakerInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateSpeakerInfoResponse.class);
        }

        public CreateSpeakerInfoResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mis_speaker_name_duplicated = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mis_speaker_name_duplicated = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mspeaker_info = (SpeakerInfo) SpeakerInfo.ADAPTER.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m3104build();
        }

        public int encodedSize(CreateSpeakerInfoResponse r5) {
            int r0 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.mis_speaker_name_duplicated);
            SpeakerInfo r1 = r5.mspeaker_info;
            if (r1 == null) goto L5;
            int r2 = SpeakerInfo.ADAPTER.encodedSizeWithTag(2, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3105decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CreateSpeakerInfoResponse) r1);
        }

        public void encode(ProtoWriter r4, CreateSpeakerInfoResponse r5) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.mis_speaker_name_duplicated);
            SpeakerInfo r0 = r5.mspeaker_info;
            if (r0 == null) goto L5;
            SpeakerInfo.ADAPTER.encodeWithTag(r4, 2, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CreateSpeakerInfoResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CreateSpeakerInfoResponse();
        DEFAULT_IS_SPEAKER_NAME_DUPLICATED = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3103newBuilder() {
        Builder r0 = new Builder();
        r0.mis_speaker_name_duplicated = this.mis_speaker_name_duplicated;
        r0.mspeaker_info = this.mspeaker_info;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CreateSpeakerInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3103newBuilder();
    }

    public CreateSpeakerInfoResponse(Boolean r2, SpeakerInfo r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public CreateSpeakerInfoResponse(Boolean r2, SpeakerInfo r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mis_speaker_name_duplicated = r2;
        this.mspeaker_info = r3;
    }
}
