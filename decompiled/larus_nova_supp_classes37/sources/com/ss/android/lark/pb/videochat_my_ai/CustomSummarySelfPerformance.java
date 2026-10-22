package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.vc_common.ByteviewUser;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CustomSummarySelfPerformance extends Message<CustomSummarySelfPerformance, Builder> {
    public static final ProtoAdapter<CustomSummarySelfPerformance> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final ByteviewUser mfrom_speaker;
    public final ByteviewUser mspeaker;
    public final MeetingAISSDInfo.SSDType mspeaker_type;

    public static final class Builder extends Message.Builder<CustomSummarySelfPerformance, Builder> {
        public String mcontent;
        public ByteviewUser mfrom_speaker;
        public ByteviewUser mspeaker;
        public MeetingAISSDInfo.SSDType mspeaker_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CustomSummarySelfPerformance m3263build() {
            return new CustomSummarySelfPerformance(this.mcontent, this.mspeaker, this.mspeaker_type, this.mfrom_speaker, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3263build();
        }

        public Builder content(String r1) {
            this.mcontent = r1;
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

        public Builder speaker_type(MeetingAISSDInfo.SSDType r1) {
            this.mspeaker_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummarySelfPerformance extends ProtoAdapter<CustomSummarySelfPerformance> {
        public ProtoAdapter_CustomSummarySelfPerformance() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummarySelfPerformance.class);
        }

        public CustomSummarySelfPerformance decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mcontent = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mcontent = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mspeaker = (ByteviewUser) ByteviewUser.ADAPTER.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mspeaker_type = (MeetingAISSDInfo.SSDType) MeetingAISSDInfo.SSDType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mfrom_speaker = (ByteviewUser) ByteviewUser.ADAPTER.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m3263build();
        }

        public int encodedSize(CustomSummarySelfPerformance r6) {
            String r0 = r6.mcontent;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            ByteviewUser r3 = r6.mspeaker;
            if (r3 == null) goto L9;
            int r4 = ByteviewUser.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            MeetingAISSDInfo.SSDType r7 = r6.mspeaker_type;
            if (r7 == null) goto L13;
            int r8 = MeetingAISSDInfo.SSDType.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            ByteviewUser r10 = r6.mfrom_speaker;
            if (r10 == null) goto L18;
            r1 = ByteviewUser.ADAPTER.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m3264decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CustomSummarySelfPerformance) r1);
        }

        public void encode(ProtoWriter r4, CustomSummarySelfPerformance r5) throws IOException {
            String r0 = r5.mcontent;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            ByteviewUser r1 = r5.mspeaker;
            if (r1 == null) goto L8;
            ByteviewUser.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            MeetingAISSDInfo.SSDType r2 = r5.mspeaker_type;
            if (r2 == null) goto L11;
            MeetingAISSDInfo.SSDType.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            ByteviewUser r3 = r5.mfrom_speaker;
            if (r3 == null) goto L14;
            ByteviewUser.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CustomSummarySelfPerformance) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummarySelfPerformance();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3262newBuilder() {
        Builder r0 = new Builder();
        r0.mcontent = this.mcontent;
        r0.mspeaker = this.mspeaker;
        r0.mspeaker_type = this.mspeaker_type;
        r0.mfrom_speaker = this.mfrom_speaker;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CustomSummarySelfPerformance.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3262newBuilder();
    }

    public CustomSummarySelfPerformance(String r7, ByteviewUser r8, MeetingAISSDInfo.SSDType r9, ByteviewUser r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public CustomSummarySelfPerformance(String r2, ByteviewUser r3, MeetingAISSDInfo.SSDType r4, ByteviewUser r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mcontent = r2;
        this.mspeaker = r3;
        this.mspeaker_type = r4;
        this.mfrom_speaker = r5;
    }
}
