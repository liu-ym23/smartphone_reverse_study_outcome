package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.vc_common.ByteviewUser;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CustomSummarySpeakerSummary extends Message<CustomSummarySpeakerSummary, Builder> {
    public static final ProtoAdapter<CustomSummarySpeakerSummary> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_CONTENT_PERCENTAGE = "";
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final String mcontent_percentage;
    public final ByteviewUser mfrom_speaker;
    public final ByteviewUser mspeaker;
    public final List<MeetingAISSDInfo.VoicePrintMethodType> mspeaker_detect_type;
    public final MeetingAISSDInfo.SSDType mspeaker_type;

    public static final class Builder extends Message.Builder<CustomSummarySpeakerSummary, Builder> {
        public String mcontent;
        public String mcontent_percentage;
        public ByteviewUser mfrom_speaker;
        public ByteviewUser mspeaker;
        public List<MeetingAISSDInfo.VoicePrintMethodType> mspeaker_detect_type;
        public MeetingAISSDInfo.SSDType mspeaker_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CustomSummarySpeakerSummary m3266build() {
            return new CustomSummarySpeakerSummary(this.mspeaker, this.mcontent, this.mcontent_percentage, this.mspeaker_type, this.mfrom_speaker, this.mspeaker_detect_type, super.buildUnknownFields());
        }

        public Builder() {
            this.mspeaker_detect_type = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3266build();
        }

        public Builder content(String r1) {
            this.mcontent = r1;
            return this;
        }

        public Builder content_percentage(String r1) {
            this.mcontent_percentage = r1;
            return this;
        }

        public Builder from_speaker(ByteviewUser r1) {
            this.mfrom_speaker = r1;
            return this;
        }

        public Builder speaker(ByteviewUser r1) {
            this.mspeaker = r1;
            return this;
        }

        public Builder speaker_detect_type(List<MeetingAISSDInfo.VoicePrintMethodType> r1) {
            Internal.checkElementsNotNull(r1);
            this.mspeaker_detect_type = r1;
            return this;
        }

        public Builder speaker_type(MeetingAISSDInfo.SSDType r1) {
            this.mspeaker_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummarySpeakerSummary extends ProtoAdapter<CustomSummarySpeakerSummary> {
        public ProtoAdapter_CustomSummarySpeakerSummary() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummarySpeakerSummary.class);
        }

        public CustomSummarySpeakerSummary decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mcontent = "";
            r0.mcontent_percentage = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L19;
            switch(r3) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L23;
                case 5: goto L11;
                case 6: goto L21;
                default: goto L6;
            };
        L21:
            r0.mspeaker_detect_type.add((MeetingAISSDInfo.VoicePrintMethodType) MeetingAISSDInfo.VoicePrintMethodType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r0.mspeaker_type = (MeetingAISSDInfo.SSDType) MeetingAISSDInfo.SSDType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r0.mfrom_speaker = (ByteviewUser) ByteviewUser.ADAPTER.decode(r9);
            goto L3
        L16:
            r0.mcontent_percentage = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L17:
            r0.mcontent = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L18:
            r0.mspeaker = (ByteviewUser) ByteviewUser.ADAPTER.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L19:
            r9.endMessage(r1);
            return r0.m3266build();
        }

        public int encodedSize(CustomSummarySpeakerSummary r6) {
            ByteviewUser r0 = r6.mspeaker;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ByteviewUser.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mcontent;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mcontent_percentage;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            MeetingAISSDInfo.SSDType r10 = r6.mspeaker_type;
            if (r10 == null) goto L17;
            int r11 = MeetingAISSDInfo.SSDType.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            ByteviewUser r13 = r6.mfrom_speaker;
            if (r13 == null) goto L22;
            r1 = ByteviewUser.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            return ((r12 + r1) + MeetingAISSDInfo.VoicePrintMethodType.ADAPTER.asRepeated().encodedSizeWithTag(6, r6.mspeaker_detect_type)) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m3267decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CustomSummarySpeakerSummary) r1);
        }

        public void encode(ProtoWriter r4, CustomSummarySpeakerSummary r5) throws IOException {
            ByteviewUser r0 = r5.mspeaker;
            if (r0 == null) goto L5;
            ByteviewUser.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mcontent;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mcontent_percentage;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            MeetingAISSDInfo.SSDType r3 = r5.mspeaker_type;
            if (r3 == null) goto L14;
            MeetingAISSDInfo.SSDType.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            ByteviewUser r6 = r5.mfrom_speaker;
            if (r6 == null) goto L17;
            ByteviewUser.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            MeetingAISSDInfo.VoicePrintMethodType.ADAPTER.asRepeated().encodeWithTag(r4, 6, r5.mspeaker_detect_type);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CustomSummarySpeakerSummary) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummarySpeakerSummary();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3265newBuilder() {
        Builder r0 = new Builder();
        r0.mspeaker = this.mspeaker;
        r0.mcontent = this.mcontent;
        r0.mcontent_percentage = this.mcontent_percentage;
        r0.mspeaker_type = this.mspeaker_type;
        r0.mfrom_speaker = this.mfrom_speaker;
        r0.mspeaker_detect_type = Internal.copyOf("mspeaker_detect_type", this.mspeaker_detect_type);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CustomSummarySpeakerSummary.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3265newBuilder();
    }

    public CustomSummarySpeakerSummary(ByteviewUser r9, String r10, String r11, MeetingAISSDInfo.SSDType r12, ByteviewUser r13, List<MeetingAISSDInfo.VoicePrintMethodType> r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public CustomSummarySpeakerSummary(ByteviewUser r2, String r3, String r4, MeetingAISSDInfo.SSDType r5, ByteviewUser r6, List<MeetingAISSDInfo.VoicePrintMethodType> r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mspeaker = r2;
        this.mcontent = r3;
        this.mcontent_percentage = r4;
        this.mspeaker_type = r5;
        this.mfrom_speaker = r6;
        this.mspeaker_detect_type = Internal.immutableCopyOf("mspeaker_detect_type", r7);
    }
}
