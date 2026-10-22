package com.ss.android.lark.pb.recognition;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PutSpeechConfigResponse extends Message<PutSpeechConfigResponse, Builder> {
    public static final ProtoAdapter<PutSpeechConfigResponse> ADAPTER = null;
    public static final Integer DEFAULT_CODE = null;
    public static final String DEFAULT_REQUEST_NO = "";
    private static final long serialVersionUID = 0;
    public final Integer mcode;
    public final String mrequest_no;

    public static final class Builder extends Message.Builder<PutSpeechConfigResponse, Builder> {
        public Integer mcode;
        public String mrequest_no;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PutSpeechConfigResponse m2093build() {
            return new PutSpeechConfigResponse(this.mcode, this.mrequest_no, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2093build();
        }

        public Builder code(Integer r1) {
            this.mcode = r1;
            return this;
        }

        public Builder request_no(String r1) {
            this.mrequest_no = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PutSpeechConfigResponse extends ProtoAdapter<PutSpeechConfigResponse> {
        public ProtoAdapter_PutSpeechConfigResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutSpeechConfigResponse.class);
        }

        public PutSpeechConfigResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mcode = 0;
            r0.mrequest_no = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mcode = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mrequest_no = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2093build();
        }

        public int encodedSize(PutSpeechConfigResponse r5) {
            Integer r0 = r5.mcode;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mrequest_no;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2094decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PutSpeechConfigResponse) r1);
        }

        public void encode(ProtoWriter r4, PutSpeechConfigResponse r5) throws IOException {
            Integer r0 = r5.mcode;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mrequest_no;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PutSpeechConfigResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutSpeechConfigResponse();
        DEFAULT_CODE = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2092newBuilder() {
        Builder r0 = new Builder();
        r0.mcode = this.mcode;
        r0.mrequest_no = this.mrequest_no;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PutSpeechConfigResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2092newBuilder();
    }

    public PutSpeechConfigResponse(Integer r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PutSpeechConfigResponse(Integer r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mcode = r2;
        this.mrequest_no = r3;
    }
}
