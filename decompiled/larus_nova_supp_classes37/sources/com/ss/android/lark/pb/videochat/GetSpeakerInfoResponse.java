package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GetSpeakerInfoResponse extends Message<GetSpeakerInfoResponse, Builder> {
    public static final ProtoAdapter<GetSpeakerInfoResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, LarkSpeakerInfo> mlark_speaker_info_map;
    public final Map<String, SpeakerInfo> mspeaker_info_map;

    public static final class Builder extends Message.Builder<GetSpeakerInfoResponse, Builder> {
        public Map<String, LarkSpeakerInfo> mlark_speaker_info_map;
        public Map<String, SpeakerInfo> mspeaker_info_map;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetSpeakerInfoResponse m3143build() {
            return new GetSpeakerInfoResponse(this.mspeaker_info_map, this.mlark_speaker_info_map, super.buildUnknownFields());
        }

        public Builder() {
            this.mspeaker_info_map = Internal.newMutableMap();
            this.mlark_speaker_info_map = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3143build();
        }

        public Builder lark_speaker_info_map(Map<String, LarkSpeakerInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mlark_speaker_info_map = r1;
            return this;
        }

        public Builder speaker_info_map(Map<String, SpeakerInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mspeaker_info_map = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSpeakerInfoResponse extends ProtoAdapter<GetSpeakerInfoResponse> {
        private final ProtoAdapter<Map<String, LarkSpeakerInfo>> mlark_speaker_info_map;
        private final ProtoAdapter<Map<String, SpeakerInfo>> mspeaker_info_map;

        public ProtoAdapter_GetSpeakerInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSpeakerInfoResponse.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mspeaker_info_map = ProtoAdapter.newMapAdapter(r0, SpeakerInfo.ADAPTER);
            this.mlark_speaker_info_map = ProtoAdapter.newMapAdapter(r0, LarkSpeakerInfo.ADAPTER);
        }

        public GetSpeakerInfoResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mspeaker_info_map.putAll((Map) this.mspeaker_info_map.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mlark_speaker_info_map.putAll((Map) this.mlark_speaker_info_map.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m3143build();
        }

        public int encodedSize(GetSpeakerInfoResponse r5) {
            return (this.mspeaker_info_map.encodedSizeWithTag(1, r5.mspeaker_info_map) + this.mlark_speaker_info_map.encodedSizeWithTag(2, r5.mlark_speaker_info_map)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3144decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetSpeakerInfoResponse) r1);
        }

        public void encode(ProtoWriter r4, GetSpeakerInfoResponse r5) throws IOException {
            this.mspeaker_info_map.encodeWithTag(r4, 1, r5.mspeaker_info_map);
            this.mlark_speaker_info_map.encodeWithTag(r4, 2, r5.mlark_speaker_info_map);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetSpeakerInfoResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSpeakerInfoResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3142newBuilder() {
        Builder r0 = new Builder();
        r0.mspeaker_info_map = Internal.copyOf("mspeaker_info_map", this.mspeaker_info_map);
        r0.mlark_speaker_info_map = Internal.copyOf("mlark_speaker_info_map", this.mlark_speaker_info_map);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetSpeakerInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3142newBuilder();
    }

    public GetSpeakerInfoResponse(Map<String, SpeakerInfo> r2, Map<String, LarkSpeakerInfo> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public GetSpeakerInfoResponse(Map<String, SpeakerInfo> r2, Map<String, LarkSpeakerInfo> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mspeaker_info_map = Internal.immutableCopyOf("mspeaker_info_map", r2);
        this.mlark_speaker_info_map = Internal.immutableCopyOf("mlark_speaker_info_map", r3);
    }
}
