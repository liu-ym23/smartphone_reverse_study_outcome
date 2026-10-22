package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MeetingAISSDInfo extends Message<MeetingAISSDInfo, Builder> {
    public static final ProtoAdapter<MeetingAISSDInfo> ADAPTER = null;
    public static final Long DEFAULT_SPEAKER_ID = null;
    private static final long serialVersionUID = 0;
    public final VoicePrintMethodType mspeaker_detect_type;
    public final Long mspeaker_id;
    public final SSDType mspeaker_type;

    public static final class Builder extends Message.Builder<MeetingAISSDInfo, Builder> {
        public VoicePrintMethodType mspeaker_detect_type;
        public Long mspeaker_id;
        public SSDType mspeaker_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MeetingAISSDInfo m3290build() {
            return new MeetingAISSDInfo(this.mspeaker_type, this.mspeaker_id, this.mspeaker_detect_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3290build();
        }

        public Builder speaker_detect_type(VoicePrintMethodType r1) {
            this.mspeaker_detect_type = r1;
            return this;
        }

        public Builder speaker_id(Long r1) {
            this.mspeaker_id = r1;
            return this;
        }

        public Builder speaker_type(SSDType r1) {
            this.mspeaker_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingAISSDInfo extends ProtoAdapter<MeetingAISSDInfo> {
        public ProtoAdapter_MeetingAISSDInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingAISSDInfo.class);
        }

        public MeetingAISSDInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mspeaker_id = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mspeaker_type = (SSDType) SSDType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mspeaker_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mspeaker_detect_type = (VoicePrintMethodType) VoicePrintMethodType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m3290build();
        }

        public int encodedSize(MeetingAISSDInfo r6) {
            SSDType r0 = r6.mspeaker_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = SSDType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mspeaker_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            VoicePrintMethodType r7 = r6.mspeaker_detect_type;
            if (r7 == null) goto L14;
            r1 = VoicePrintMethodType.ADAPTER.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m3291decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MeetingAISSDInfo) r1);
        }

        public void encode(ProtoWriter r4, MeetingAISSDInfo r5) throws IOException {
            SSDType r0 = r5.mspeaker_type;
            if (r0 == null) goto L5;
            SSDType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mspeaker_id;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            VoicePrintMethodType r2 = r5.mspeaker_detect_type;
            if (r2 == null) goto L11;
            VoicePrintMethodType.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MeetingAISSDInfo) r2);
        }
    }

    public static final enum SSDType extends Enum<SSDType> implements WireEnum {
        private static final /* synthetic */ SSDType[] $VALUES = null;
        public static final ProtoAdapter<SSDType> ADAPTER = null;
        public static final SSDType TYPE_SID_DETECT = null;
        public static final SSDType TYPE_SSD_DETECT = null;
        public static final SSDType TYPE_UNKNOWN = null;
        private final int value;

        static {
            SSDType r0 = new SSDType("TYPE_UNKNOWN", 0, 0);
            TYPE_UNKNOWN = r0;
            SSDType r1 = new SSDType("TYPE_SSD_DETECT", 1, 1);
            TYPE_SSD_DETECT = r1;
            SSDType r3 = new SSDType("TYPE_SID_DETECT", 2, 2);
            TYPE_SID_DETECT = r3;
            $VALUES = new SSDType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(SSDType.class);
        }

        public static SSDType[] values() {
            return (SSDType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SSDType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return TYPE_SID_DETECT;
        L12:
            return TYPE_SSD_DETECT;
        L14:
            return TYPE_UNKNOWN;
        }

        public static SSDType valueOf(String r1) {
            return (SSDType) a.a(SSDType.class, r1);
        }

        private SSDType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum VoicePrintMethodType extends Enum<VoicePrintMethodType> implements WireEnum {
        private static final /* synthetic */ VoicePrintMethodType[] $VALUES = null;
        public static final ProtoAdapter<VoicePrintMethodType> ADAPTER = null;
        public static final VoicePrintMethodType METHOD_TYPE_IDENTIFY = null;
        public static final VoicePrintMethodType METHOD_TYPE_INFERENCE = null;
        public static final VoicePrintMethodType METHOD_TYPE_UNKNOWN = null;
        private final int value;

        static {
            VoicePrintMethodType r0 = new VoicePrintMethodType("METHOD_TYPE_UNKNOWN", 0, 0);
            METHOD_TYPE_UNKNOWN = r0;
            VoicePrintMethodType r1 = new VoicePrintMethodType("METHOD_TYPE_IDENTIFY", 1, 1);
            METHOD_TYPE_IDENTIFY = r1;
            VoicePrintMethodType r3 = new VoicePrintMethodType("METHOD_TYPE_INFERENCE", 2, 2);
            METHOD_TYPE_INFERENCE = r3;
            $VALUES = new VoicePrintMethodType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(VoicePrintMethodType.class);
        }

        public static VoicePrintMethodType[] values() {
            return (VoicePrintMethodType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static VoicePrintMethodType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return METHOD_TYPE_INFERENCE;
        L12:
            return METHOD_TYPE_IDENTIFY;
        L14:
            return METHOD_TYPE_UNKNOWN;
        }

        public static VoicePrintMethodType valueOf(String r1) {
            return (VoicePrintMethodType) a.a(VoicePrintMethodType.class, r1);
        }

        private VoicePrintMethodType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingAISSDInfo();
        DEFAULT_SPEAKER_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3289newBuilder() {
        Builder r0 = new Builder();
        r0.mspeaker_type = this.mspeaker_type;
        r0.mspeaker_id = this.mspeaker_id;
        r0.mspeaker_detect_type = this.mspeaker_detect_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MeetingAISSDInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3289newBuilder();
    }

    public MeetingAISSDInfo(SSDType r2, Long r3, VoicePrintMethodType r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public MeetingAISSDInfo(SSDType r2, Long r3, VoicePrintMethodType r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mspeaker_type = r2;
        this.mspeaker_id = r3;
        this.mspeaker_detect_type = r4;
    }
}
