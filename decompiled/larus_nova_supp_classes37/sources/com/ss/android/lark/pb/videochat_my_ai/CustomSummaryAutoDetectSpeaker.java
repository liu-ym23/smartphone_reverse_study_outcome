package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CustomSummaryAutoDetectSpeaker extends Message<CustomSummaryAutoDetectSpeaker, Builder> {
    public static final ProtoAdapter<CustomSummaryAutoDetectSpeaker> ADAPTER = null;
    public static final String DEFAULT_SUBTITLE_CONTENT = "";
    public static final Long DEFAULT_USER_ID = null;
    private static final long serialVersionUID = 0;
    public final MeetingAISSDInfo.SSDType mspeaker_type;
    public final String msubtitle_content;
    public final Long muser_id;

    public static final class Builder extends Message.Builder<CustomSummaryAutoDetectSpeaker, Builder> {
        public MeetingAISSDInfo.SSDType mspeaker_type;
        public String msubtitle_content;
        public Long muser_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CustomSummaryAutoDetectSpeaker m3242build() {
            return new CustomSummaryAutoDetectSpeaker(this.muser_id, this.mspeaker_type, this.msubtitle_content, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3242build();
        }

        public Builder speaker_type(MeetingAISSDInfo.SSDType r1) {
            this.mspeaker_type = r1;
            return this;
        }

        public Builder subtitle_content(String r1) {
            this.msubtitle_content = r1;
            return this;
        }

        public Builder user_id(Long r1) {
            this.muser_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummaryAutoDetectSpeaker extends ProtoAdapter<CustomSummaryAutoDetectSpeaker> {
        public ProtoAdapter_CustomSummaryAutoDetectSpeaker() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummaryAutoDetectSpeaker.class);
        }

        public CustomSummaryAutoDetectSpeaker decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.muser_id = 0L;
            r0.msubtitle_content = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.muser_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mspeaker_type = (MeetingAISSDInfo.SSDType) MeetingAISSDInfo.SSDType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.msubtitle_content = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m3242build();
        }

        public int encodedSize(CustomSummaryAutoDetectSpeaker r6) {
            Long r0 = r6.muser_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            MeetingAISSDInfo.SSDType r3 = r6.mspeaker_type;
            if (r3 == null) goto L9;
            int r4 = MeetingAISSDInfo.SSDType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.msubtitle_content;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3243decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CustomSummaryAutoDetectSpeaker) r1);
        }

        public void encode(ProtoWriter r4, CustomSummaryAutoDetectSpeaker r5) throws IOException {
            Long r0 = r5.muser_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            MeetingAISSDInfo.SSDType r1 = r5.mspeaker_type;
            if (r1 == null) goto L8;
            MeetingAISSDInfo.SSDType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.msubtitle_content;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CustomSummaryAutoDetectSpeaker) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummaryAutoDetectSpeaker();
        DEFAULT_USER_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3241newBuilder() {
        Builder r0 = new Builder();
        r0.muser_id = this.muser_id;
        r0.mspeaker_type = this.mspeaker_type;
        r0.msubtitle_content = this.msubtitle_content;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CustomSummaryAutoDetectSpeaker.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3241newBuilder();
    }

    public CustomSummaryAutoDetectSpeaker(Long r2, MeetingAISSDInfo.SSDType r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public CustomSummaryAutoDetectSpeaker(Long r2, MeetingAISSDInfo.SSDType r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.muser_id = r2;
        this.mspeaker_type = r3;
        this.msubtitle_content = r4;
    }
}
