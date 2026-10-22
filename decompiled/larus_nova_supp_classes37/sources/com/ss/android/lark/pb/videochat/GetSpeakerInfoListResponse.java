package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GetSpeakerInfoListResponse extends Message<GetSpeakerInfoListResponse, Builder> {
    public static final ProtoAdapter<GetSpeakerInfoListResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<LarkSpeakerInfo> mlark_speaker_info_list;
    public final List<SpeakerInfo> mspeaker_info_list;

    public static final class Builder extends Message.Builder<GetSpeakerInfoListResponse, Builder> {
        public List<LarkSpeakerInfo> mlark_speaker_info_list;
        public List<SpeakerInfo> mspeaker_info_list;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetSpeakerInfoListResponse m3137build() {
            return new GetSpeakerInfoListResponse(this.mspeaker_info_list, this.mlark_speaker_info_list, super.buildUnknownFields());
        }

        public Builder() {
            this.mspeaker_info_list = Internal.newMutableList();
            this.mlark_speaker_info_list = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3137build();
        }

        public Builder lark_speaker_info_list(List<LarkSpeakerInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mlark_speaker_info_list = r1;
            return this;
        }

        public Builder speaker_info_list(List<SpeakerInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mspeaker_info_list = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSpeakerInfoListResponse extends ProtoAdapter<GetSpeakerInfoListResponse> {
        public ProtoAdapter_GetSpeakerInfoListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSpeakerInfoListResponse.class);
        }

        public GetSpeakerInfoListResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mspeaker_info_list.add((SpeakerInfo) SpeakerInfo.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mlark_speaker_info_list.add((LarkSpeakerInfo) LarkSpeakerInfo.ADAPTER.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m3137build();
        }

        public int encodedSize(GetSpeakerInfoListResponse r5) {
            return (SpeakerInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.mspeaker_info_list) + LarkSpeakerInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mlark_speaker_info_list)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3138decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetSpeakerInfoListResponse) r1);
        }

        public void encode(ProtoWriter r4, GetSpeakerInfoListResponse r5) throws IOException {
            SpeakerInfo.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mspeaker_info_list);
            LarkSpeakerInfo.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mlark_speaker_info_list);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetSpeakerInfoListResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSpeakerInfoListResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3136newBuilder() {
        Builder r0 = new Builder();
        r0.mspeaker_info_list = Internal.copyOf("mspeaker_info_list", this.mspeaker_info_list);
        r0.mlark_speaker_info_list = Internal.copyOf("mlark_speaker_info_list", this.mlark_speaker_info_list);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetSpeakerInfoListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3136newBuilder();
    }

    public GetSpeakerInfoListResponse(List<SpeakerInfo> r2, List<LarkSpeakerInfo> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public GetSpeakerInfoListResponse(List<SpeakerInfo> r2, List<LarkSpeakerInfo> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mspeaker_info_list = Internal.immutableCopyOf("mspeaker_info_list", r2);
        this.mlark_speaker_info_list = Internal.immutableCopyOf("mlark_speaker_info_list", r3);
    }
}
