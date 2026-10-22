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
public final class SetSpeakerInfoRequest extends Message<SetSpeakerInfoRequest, Builder> {
    public static final ProtoAdapter<SetSpeakerInfoRequest> ADAPTER = null;
    public static final String DEFAULT_CLUSTER_ID = "";
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_OPERATOR_ID = "";
    public static final Long DEFAULT_SEG_ID = null;
    private static final long serialVersionUID = 0;
    public final String mcluster_id;
    public final LarkSpeakerInfo mlark_speaker_info;
    public final String mmeeting_id;
    public final String moperator_id;
    public final Long mseg_id;
    public final SpeakerInfo mspeaker_info;
    public final SpeakerInfoType mspeaker_info_type;

    public static final class Builder extends Message.Builder<SetSpeakerInfoRequest, Builder> {
        public String mcluster_id;
        public LarkSpeakerInfo mlark_speaker_info;
        public String mmeeting_id;
        public String moperator_id;
        public Long mseg_id;
        public SpeakerInfo mspeaker_info;
        public SpeakerInfoType mspeaker_info_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SetSpeakerInfoRequest m3185build() {
            String r0 = this.moperator_id;
            if (r0 == null) goto L13;
            if (this.mmeeting_id == null) goto L13;
            if (this.mcluster_id == null) goto L13;
            if (this.mspeaker_info_type == null) goto L13;
            return new SetSpeakerInfoRequest(this.moperator_id, this.mmeeting_id, this.mcluster_id, this.mspeaker_info_type, this.mspeaker_info, this.mlark_speaker_info, this.mseg_id, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r0, "moperator_id", this.mmeeting_id, "mmeeting_id", this.mcluster_id, "mcluster_id", this.mspeaker_info_type, "mspeaker_info_type"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3185build();
        }

        public Builder cluster_id(String r1) {
            this.mcluster_id = r1;
            return this;
        }

        public Builder lark_speaker_info(LarkSpeakerInfo r1) {
            this.mlark_speaker_info = r1;
            return this;
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }

        public Builder operator_id(String r1) {
            this.moperator_id = r1;
            return this;
        }

        public Builder seg_id(Long r1) {
            this.mseg_id = r1;
            return this;
        }

        public Builder speaker_info(SpeakerInfo r1) {
            this.mspeaker_info = r1;
            return this;
        }

        public Builder speaker_info_type(SpeakerInfoType r1) {
            this.mspeaker_info_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SetSpeakerInfoRequest extends ProtoAdapter<SetSpeakerInfoRequest> {
        public ProtoAdapter_SetSpeakerInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetSpeakerInfoRequest.class);
        }

        public SetSpeakerInfoRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.moperator_id = "";
            r0.mmeeting_id = "";
            r0.mcluster_id = "";
            r0.mseg_id = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L19;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r0.mspeaker_info_type = (SpeakerInfoType) SpeakerInfoType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mseg_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            r0.mlark_speaker_info = (LarkSpeakerInfo) LarkSpeakerInfo.ADAPTER.decode(r9);
            goto L3
        L9:
            r0.mspeaker_info = (SpeakerInfo) SpeakerInfo.ADAPTER.decode(r9);
            goto L3
        L14:
            r0.mcluster_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mmeeting_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.moperator_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L17:
            r9.endMessage(r1);
            return r0.m3185build();
        }

        public int encodedSize(SetSpeakerInfoRequest r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = ((r0.encodedSizeWithTag(1, r6.moperator_id) + r0.encodedSizeWithTag(2, r6.mmeeting_id)) + r0.encodedSizeWithTag(3, r6.mcluster_id)) + SpeakerInfoType.ADAPTER.encodedSizeWithTag(4, r6.mspeaker_info_type);
            SpeakerInfo r2 = r6.mspeaker_info;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = SpeakerInfo.ADAPTER.encodedSizeWithTag(5, r2);
        L6:
            int r5 = r1 + r4;
            LarkSpeakerInfo r7 = r6.mlark_speaker_info;
            if (r7 == null) goto L9;
            int r8 = LarkSpeakerInfo.ADAPTER.encodedSizeWithTag(6, r7);
        L10:
            int r9 = r5 + r8;
            Long r10 = r6.mseg_id;
            if (r10 == null) goto L14;
            r3 = ProtoAdapter.INT64.encodedSizeWithTag(7, r10);
        L14:
            return (r9 + r3) + r6.unknownFields().size();
        L9:
            r8 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3186decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SetSpeakerInfoRequest) r1);
        }

        public void encode(ProtoWriter r4, SetSpeakerInfoRequest r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.moperator_id);
            r0.encodeWithTag(r4, 2, r5.mmeeting_id);
            r0.encodeWithTag(r4, 3, r5.mcluster_id);
            SpeakerInfoType.ADAPTER.encodeWithTag(r4, 4, r5.mspeaker_info_type);
            SpeakerInfo r1 = r5.mspeaker_info;
            if (r1 == null) goto L5;
            SpeakerInfo.ADAPTER.encodeWithTag(r4, 5, r1);
        L5:
            LarkSpeakerInfo r2 = r5.mlark_speaker_info;
            if (r2 == null) goto L8;
            LarkSpeakerInfo.ADAPTER.encodeWithTag(r4, 6, r2);
        L8:
            Long r3 = r5.mseg_id;
            if (r3 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r4, 7, r3);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SetSpeakerInfoRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SetSpeakerInfoRequest();
        DEFAULT_SEG_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3184newBuilder() {
        Builder r0 = new Builder();
        r0.moperator_id = this.moperator_id;
        r0.mmeeting_id = this.mmeeting_id;
        r0.mcluster_id = this.mcluster_id;
        r0.mspeaker_info_type = this.mspeaker_info_type;
        r0.mspeaker_info = this.mspeaker_info;
        r0.mlark_speaker_info = this.mlark_speaker_info;
        r0.mseg_id = this.mseg_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SetSpeakerInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3184newBuilder();
    }

    public SetSpeakerInfoRequest(String r10, String r11, String r12, SpeakerInfoType r13, SpeakerInfo r14, LarkSpeakerInfo r15, Long r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public SetSpeakerInfoRequest(String r2, String r3, String r4, SpeakerInfoType r5, SpeakerInfo r6, LarkSpeakerInfo r7, Long r8, ByteString r9) {
        super(ADAPTER, r9);
        this.moperator_id = r2;
        this.mmeeting_id = r3;
        this.mcluster_id = r4;
        this.mspeaker_info_type = r5;
        this.mspeaker_info = r6;
        this.mlark_speaker_info = r7;
        this.mseg_id = r8;
    }
}
