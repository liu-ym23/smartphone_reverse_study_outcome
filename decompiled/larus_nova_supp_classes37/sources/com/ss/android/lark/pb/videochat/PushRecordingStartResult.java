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
public final class PushRecordingStartResult extends Message<PushRecordingStartResult, Builder> {
    public static final ProtoAdapter<PushRecordingStartResult> ADAPTER = null;
    public static final String DEFAULT_ERROR = "";
    public static final String DEFAULT_FAIL_TOAST_I18N_KEY = "";
    public static final String DEFAULT_MEETING_ID = "";
    public static final Integer DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    public final String merror;
    public final String mfail_toast_i18n_key;
    public final String mmeeting_id;
    public final Integer mstatus;

    public static final class Builder extends Message.Builder<PushRecordingStartResult, Builder> {
        public String merror;
        public String mfail_toast_i18n_key;
        public String mmeeting_id;
        public Integer mstatus;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PushRecordingStartResult m3173build() {
            String r0 = this.mmeeting_id;
            if (r0 == null) goto L7;
            return new PushRecordingStartResult(this.mmeeting_id, this.mstatus, this.mfail_toast_i18n_key, this.merror, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mmeeting_id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3173build();
        }

        public Builder error(String r1) {
            this.merror = r1;
            return this;
        }

        public Builder fail_toast_i18n_key(String r1) {
            this.mfail_toast_i18n_key = r1;
            return this;
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }

        public Builder status(Integer r1) {
            this.mstatus = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PushRecordingStartResult extends ProtoAdapter<PushRecordingStartResult> {
        public ProtoAdapter_PushRecordingStartResult() {
            super(FieldEncoding.LENGTH_DELIMITED, PushRecordingStartResult.class);
        }

        public PushRecordingStartResult decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mmeeting_id = "";
            r0.mstatus = 0;
            r0.mfail_toast_i18n_key = "";
            r0.merror = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mmeeting_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mstatus = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mfail_toast_i18n_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.merror = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m3173build();
        }

        public int encodedSize(PushRecordingStartResult r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mmeeting_id);
            Integer r2 = r7.mstatus;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.mfail_toast_i18n_key;
            if (r6 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            String r10 = r7.merror;
            if (r10 == null) goto L14;
            r3 = r0.encodedSizeWithTag(4, r10);
        L14:
            return (r9 + r3) + r7.unknownFields().size();
        L9:
            r8 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3174decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PushRecordingStartResult) r1);
        }

        public void encode(ProtoWriter r5, PushRecordingStartResult r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mmeeting_id);
            Integer r1 = r6.mstatus;
            if (r1 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r5, 2, r1);
        L5:
            String r2 = r6.mfail_toast_i18n_key;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 3, r2);
        L8:
            String r3 = r6.merror;
            if (r3 == null) goto L11;
            r0.encodeWithTag(r5, 4, r3);
        L11:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PushRecordingStartResult) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PushRecordingStartResult();
        DEFAULT_STATUS = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3172newBuilder() {
        Builder r0 = new Builder();
        r0.mmeeting_id = this.mmeeting_id;
        r0.mstatus = this.mstatus;
        r0.mfail_toast_i18n_key = this.mfail_toast_i18n_key;
        r0.merror = this.merror;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PushRecordingStartResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3172newBuilder();
    }

    public PushRecordingStartResult(String r7, Integer r8, String r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public PushRecordingStartResult(String r2, Integer r3, String r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mmeeting_id = r2;
        this.mstatus = r3;
        this.mfail_toast_i18n_key = r4;
        this.merror = r5;
    }
}
