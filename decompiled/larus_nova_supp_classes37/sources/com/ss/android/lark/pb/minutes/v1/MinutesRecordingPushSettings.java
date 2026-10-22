package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesRecordingPushSettings extends Message<MinutesRecordingPushSettings, Builder> {
    public static final ProtoAdapter<MinutesRecordingPushSettings> ADAPTER = null;
    public static final FeatureStatus DEFAULT_AI_VIEW = null;
    public static final String DEFAULT_SESSION_ID = "";
    public static final ProtoAdapter_MinutesRecordingPushSettings RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FeatureStatus ai_view;
    public final String session_id;

    public static final class Builder extends Message.Builder<MinutesRecordingPushSettings, Builder> implements d<MinutesRecordingPushSettings> {
        public FeatureStatus ai_view;
        public String session_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesRecordingPushSettings m1859build() {
            String r0 = this.session_id;
            if (r0 == null) goto L7;
            return new MinutesRecordingPushSettings(this.session_id, this.ai_view, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "session_id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1859build();
        }

        public Builder ai_view(FeatureStatus r1) {
            this.ai_view = r1;
            return this;
        }

        public Builder session_id(String r1) {
            this.session_id = r1;
            return this;
        }
    }

    public static final enum FeatureStatus extends Enum<FeatureStatus> implements WireEnum {
        private static final /* synthetic */ FeatureStatus[] $VALUES = null;
        public static final ProtoAdapter<FeatureStatus> ADAPTER = null;
        public static final FeatureStatus FEATURE_STATUS_DISABLED = null;
        public static final FeatureStatus FEATURE_STATUS_OFF = null;
        public static final FeatureStatus FEATURE_STATUS_ON = null;
        public static final FeatureStatus FEATURE_STATUS_UNKNOWN = null;
        private final int value;

        static {
            FeatureStatus r0 = new FeatureStatus("FEATURE_STATUS_UNKNOWN", 0, 0);
            FEATURE_STATUS_UNKNOWN = r0;
            FeatureStatus r1 = new FeatureStatus("FEATURE_STATUS_DISABLED", 1, 1);
            FEATURE_STATUS_DISABLED = r1;
            FeatureStatus r3 = new FeatureStatus("FEATURE_STATUS_ON", 2, 2);
            FEATURE_STATUS_ON = r3;
            FeatureStatus r5 = new FeatureStatus("FEATURE_STATUS_OFF", 3, 3);
            FEATURE_STATUS_OFF = r5;
            $VALUES = new FeatureStatus[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(FeatureStatus.class);
        }

        public static FeatureStatus[] values() {
            return (FeatureStatus[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FeatureStatus fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return FEATURE_STATUS_OFF;
        L14:
            return FEATURE_STATUS_ON;
        L16:
            return FEATURE_STATUS_DISABLED;
        L18:
            return FEATURE_STATUS_UNKNOWN;
        }

        public static FeatureStatus valueOf(String r1) {
            return (FeatureStatus) a.a(FeatureStatus.class, r1);
        }

        private FeatureStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_MinutesRecordingPushSettings extends ProtoAdapter<MinutesRecordingPushSettings> implements c<MinutesRecordingPushSettings> {
        public ProtoAdapter_MinutesRecordingPushSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingPushSettings.class);
        }

        public MinutesRecordingPushSettings decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.session_id = "";
            r0.ai_view = FeatureStatus.FEATURE_STATUS_UNKNOWN;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.session_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.ai_view = (FeatureStatus) FeatureStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m1859build();
        }

        public int encodedSize(MinutesRecordingPushSettings r5) {
            int r0 = ProtoAdapter.STRING.encodedSizeWithTag(1, r5.session_id);
            FeatureStatus r1 = r5.ai_view;
            if (r1 == null) goto L5;
            int r2 = FeatureStatus.ADAPTER.encodedSizeWithTag(2, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1860decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesRecordingPushSettings) r1);
        }

        public void encode(ProtoWriter r4, MinutesRecordingPushSettings r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.session_id);
            FeatureStatus r0 = r5.ai_view;
            if (r0 == null) goto L5;
            FeatureStatus.ADAPTER.encodeWithTag(r4, 2, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesRecordingPushSettings) r2);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingPushSettings r0 = new ProtoAdapter_MinutesRecordingPushSettings();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
        DEFAULT_AI_VIEW = FeatureStatus.FEATURE_STATUS_UNKNOWN;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1858newBuilder() {
        Builder r0 = new Builder();
        r0.session_id = this.session_id;
        r0.ai_view = this.ai_view;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesRecordingPushSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1858newBuilder();
    }

    public MinutesRecordingPushSettings(String r2, FeatureStatus r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public MinutesRecordingPushSettings(String r2, FeatureStatus r3, ByteString r4) {
        super(ADAPTER, r4);
        this.session_id = r2;
        this.ai_view = r3;
    }
}
