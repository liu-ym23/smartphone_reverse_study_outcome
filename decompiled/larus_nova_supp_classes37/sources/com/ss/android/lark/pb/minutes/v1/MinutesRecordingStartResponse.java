package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesRecordingStartResponse extends Message<MinutesRecordingStartResponse, Builder> {
    public static final ProtoAdapter<MinutesRecordingStartResponse> ADAPTER = null;
    public static final String DEFAULT_BUSINESS_ID = "";
    public static final String DEFAULT_RECORDING_ID = "";
    public static final String DEFAULT_RTC_APP_ID = "";
    public static final String DEFAULT_RTC_INFO = "";
    public static final String DEFAULT_SESSION_ID = "";
    public static final Long DEFAULT_VENDOR_TYPE = null;
    public static final ProtoAdapter_MinutesRecordingStartResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String business_id;
    public final String recording_id;
    public final String rtc_app_id;
    public final String rtc_info;
    public final String session_id;
    public final Long vendor_type;

    public static final class Builder extends Message.Builder<MinutesRecordingStartResponse, Builder> implements d<MinutesRecordingStartResponse> {
        public String business_id;
        public String recording_id;
        public String rtc_app_id;
        public String rtc_info;
        public String session_id;
        public Long vendor_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesRecordingStartResponse m1883build() {
            String r0 = this.session_id;
            if (r0 == null) goto L11;
            if (this.rtc_info == null) goto L11;
            if (this.vendor_type == null) goto L11;
            return new MinutesRecordingStartResponse(this.session_id, this.rtc_info, this.vendor_type, this.rtc_app_id, this.business_id, this.recording_id, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "session_id", this.rtc_info, "rtc_info", this.vendor_type, "vendor_type"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1883build();
        }

        public Builder business_id(String r1) {
            this.business_id = r1;
            return this;
        }

        public Builder recording_id(String r1) {
            this.recording_id = r1;
            return this;
        }

        public Builder rtc_app_id(String r1) {
            this.rtc_app_id = r1;
            return this;
        }

        public Builder rtc_info(String r1) {
            this.rtc_info = r1;
            return this;
        }

        public Builder session_id(String r1) {
            this.session_id = r1;
            return this;
        }

        public Builder vendor_type(Long r1) {
            this.vendor_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesRecordingStartResponse extends ProtoAdapter<MinutesRecordingStartResponse> implements c<MinutesRecordingStartResponse> {
        public ProtoAdapter_MinutesRecordingStartResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingStartResponse.class);
        }

        public MinutesRecordingStartResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.session_id = "";
            r0.rtc_info = "";
            r0.vendor_type = 0L;
            r0.rtc_app_id = "";
            r0.business_id = "";
            r0.recording_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.recording_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            r0.business_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            r0.rtc_app_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.vendor_type = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L11:
            r0.rtc_info = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.session_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.m1883build();
        }

        public int encodedSize(MinutesRecordingStartResponse r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = (r0.encodedSizeWithTag(1, r6.session_id) + r0.encodedSizeWithTag(2, r6.rtc_info)) + ProtoAdapter.INT64.encodedSizeWithTag(3, r6.vendor_type);
            String r2 = r6.rtc_app_id;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(4, r2);
        L6:
            int r5 = r1 + r4;
            String r7 = r6.business_id;
            if (r7 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(5, r7);
        L10:
            int r9 = r5 + r8;
            String r10 = r6.recording_id;
            if (r10 == null) goto L14;
            r3 = r0.encodedSizeWithTag(6, r10);
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
        public /* bridge */ /* synthetic */ Object m1884decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesRecordingStartResponse) r1);
        }

        public void encode(ProtoWriter r5, MinutesRecordingStartResponse r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.session_id);
            r0.encodeWithTag(r5, 2, r6.rtc_info);
            ProtoAdapter.INT64.encodeWithTag(r5, 3, r6.vendor_type);
            String r1 = r6.rtc_app_id;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 4, r1);
        L5:
            String r2 = r6.business_id;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 5, r2);
        L8:
            String r3 = r6.recording_id;
            if (r3 == null) goto L11;
            r0.encodeWithTag(r5, 6, r3);
        L11:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesRecordingStartResponse) r2);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingStartResponse r0 = new ProtoAdapter_MinutesRecordingStartResponse();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
        DEFAULT_VENDOR_TYPE = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1882newBuilder() {
        Builder r0 = new Builder();
        r0.session_id = this.session_id;
        r0.rtc_info = this.rtc_info;
        r0.vendor_type = this.vendor_type;
        r0.rtc_app_id = this.rtc_app_id;
        r0.business_id = this.business_id;
        r0.recording_id = this.recording_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesRecordingStartResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1882newBuilder();
    }

    public MinutesRecordingStartResponse(String r9, String r10, Long r11, String r12, String r13, String r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public MinutesRecordingStartResponse(String r2, String r3, Long r4, String r5, String r6, String r7, ByteString r8) {
        super(ADAPTER, r8);
        this.session_id = r2;
        this.rtc_info = r3;
        this.vendor_type = r4;
        this.rtc_app_id = r5;
        this.business_id = r6;
        this.recording_id = r7;
    }
}
