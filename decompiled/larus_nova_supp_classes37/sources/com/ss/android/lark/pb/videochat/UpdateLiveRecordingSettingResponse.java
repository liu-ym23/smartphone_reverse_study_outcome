package com.ss.android.lark.pb.videochat;

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
public final class UpdateLiveRecordingSettingResponse extends Message<UpdateLiveRecordingSettingResponse, Builder> {
    public static final ProtoAdapter<UpdateLiveRecordingSettingResponse> ADAPTER = null;
    public static final String DEFAULT_FAIL_TOAST_I18N_KEY = "";
    private static final long serialVersionUID = 0;
    public final String mfail_toast_i18n_key;
    public final Status mstatus;

    public static final class Builder extends Message.Builder<UpdateLiveRecordingSettingResponse, Builder> {
        public String mfail_toast_i18n_key;
        public Status mstatus;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UpdateLiveRecordingSettingResponse m3200build() {
            return new UpdateLiveRecordingSettingResponse(this.mstatus, this.mfail_toast_i18n_key, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3200build();
        }

        public Builder fail_toast_i18n_key(String r1) {
            this.mfail_toast_i18n_key = r1;
            return this;
        }

        public Builder status(Status r1) {
            this.mstatus = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateLiveRecordingSettingResponse extends ProtoAdapter<UpdateLiveRecordingSettingResponse> {
        public ProtoAdapter_UpdateLiveRecordingSettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateLiveRecordingSettingResponse.class);
        }

        public UpdateLiveRecordingSettingResponse decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mfail_toast_i18n_key = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mstatus = (Status) Status.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mfail_toast_i18n_key = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m3200build();
        }

        public int encodedSize(UpdateLiveRecordingSettingResponse r5) {
            Status r0 = r5.mstatus;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = Status.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mfail_toast_i18n_key;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3201decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UpdateLiveRecordingSettingResponse) r1);
        }

        public void encode(ProtoWriter r4, UpdateLiveRecordingSettingResponse r5) throws IOException {
            Status r0 = r5.mstatus;
            if (r0 == null) goto L5;
            Status.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mfail_toast_i18n_key;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UpdateLiveRecordingSettingResponse) r2);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status FAIL = null;
        public static final Status FATAL = null;
        public static final Status LIMIT_REACHED = null;
        public static final Status RECORDING_DEGRADED = null;
        public static final Status SUCCESS = null;
        public static final Status UNKNOWN = null;
        private final int value;

        static {
            Status r0 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Status r1 = new Status("SUCCESS", 1, 1);
            SUCCESS = r1;
            Status r3 = new Status("FAIL", 2, 2);
            FAIL = r3;
            Status r5 = new Status("FATAL", 3, 3);
            FATAL = r5;
            Status r7 = new Status("LIMIT_REACHED", 4, 4);
            LIMIT_REACHED = r7;
            Status r9 = new Status("RECORDING_DEGRADED", 5, 5);
            RECORDING_DEGRADED = r9;
            $VALUES = new Status[]{r0, r1, r3, r5, r7, r9};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return RECORDING_DEGRADED;
        L18:
            return LIMIT_REACHED;
        L20:
            return FATAL;
        L22:
            return FAIL;
        L24:
            return SUCCESS;
        L26:
            return UNKNOWN;
        }

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        private Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateLiveRecordingSettingResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3199newBuilder() {
        Builder r0 = new Builder();
        r0.mstatus = this.mstatus;
        r0.mfail_toast_i18n_key = this.mfail_toast_i18n_key;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UpdateLiveRecordingSettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3199newBuilder();
    }

    public UpdateLiveRecordingSettingResponse(Status r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public UpdateLiveRecordingSettingResponse(Status r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mstatus = r2;
        this.mfail_toast_i18n_key = r3;
    }
}
