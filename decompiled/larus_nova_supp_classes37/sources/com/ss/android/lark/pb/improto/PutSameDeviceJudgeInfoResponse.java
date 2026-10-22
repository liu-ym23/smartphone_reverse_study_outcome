package com.ss.android.lark.pb.improto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PutSameDeviceJudgeInfoResponse extends Message<PutSameDeviceJudgeInfoResponse, Builder> {
    public static final ProtoAdapter<PutSameDeviceJudgeInfoResponse> ADAPTER = null;
    public static final Integer DEFAULT_STATUS_CODE = null;
    public static final String DEFAULT_STATUS_MESSAGE = "";
    private static final long serialVersionUID = 0;
    public final Integer mstatus_code;
    public final String mstatus_message;

    public static final class Builder extends Message.Builder<PutSameDeviceJudgeInfoResponse, Builder> {
        public Integer mstatus_code;
        public String mstatus_message;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PutSameDeviceJudgeInfoResponse m1766build() {
            return new PutSameDeviceJudgeInfoResponse(this.mstatus_code, this.mstatus_message, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1766build();
        }

        public Builder status_code(Integer r1) {
            this.mstatus_code = r1;
            return this;
        }

        public Builder status_message(String r1) {
            this.mstatus_message = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PutSameDeviceJudgeInfoResponse extends ProtoAdapter<PutSameDeviceJudgeInfoResponse> {
        public ProtoAdapter_PutSameDeviceJudgeInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutSameDeviceJudgeInfoResponse.class);
        }

        public PutSameDeviceJudgeInfoResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mstatus_code = 0;
            r0.mstatus_message = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mstatus_code = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mstatus_message = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1766build();
        }

        public int encodedSize(PutSameDeviceJudgeInfoResponse r5) {
            Integer r0 = r5.mstatus_code;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mstatus_message;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1767decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PutSameDeviceJudgeInfoResponse) r1);
        }

        public void encode(ProtoWriter r4, PutSameDeviceJudgeInfoResponse r5) throws IOException {
            Integer r0 = r5.mstatus_code;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mstatus_message;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PutSameDeviceJudgeInfoResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutSameDeviceJudgeInfoResponse();
        DEFAULT_STATUS_CODE = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1765newBuilder() {
        Builder r0 = new Builder();
        r0.mstatus_code = this.mstatus_code;
        r0.mstatus_message = this.mstatus_message;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PutSameDeviceJudgeInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1765newBuilder();
    }

    public PutSameDeviceJudgeInfoResponse(Integer r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PutSameDeviceJudgeInfoResponse(Integer r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mstatus_code = r2;
        this.mstatus_message = r3;
    }
}
