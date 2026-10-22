package com.ss.android.lark.pb.ai_engine;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FeedsbackResponse extends Message<FeedsbackResponse, Builder> {
    public static final ProtoAdapter<FeedsbackResponse> ADAPTER = null;
    public static final Long DEFAULT_CODE = null;
    public static final String DEFAULT_MESSAGE = "";
    private static final long serialVersionUID = 0;
    public final Long mcode;
    public final String mmessage;

    public static final class Builder extends Message.Builder<FeedsbackResponse, Builder> {
        public Long mcode;
        public String mmessage;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FeedsbackResponse m788build() {
            return new FeedsbackResponse(this.mcode, this.mmessage, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m788build();
        }

        public Builder code(Long r1) {
            this.mcode = r1;
            return this;
        }

        public Builder message(String r1) {
            this.mmessage = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedsbackResponse extends ProtoAdapter<FeedsbackResponse> {
        public ProtoAdapter_FeedsbackResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedsbackResponse.class);
        }

        public FeedsbackResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mcode = 0L;
            r0.mmessage = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mcode = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mmessage = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m788build();
        }

        public int encodedSize(FeedsbackResponse r5) {
            Long r0 = r5.mcode;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mmessage;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m789decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FeedsbackResponse) r1);
        }

        public void encode(ProtoWriter r4, FeedsbackResponse r5) throws IOException {
            Long r0 = r5.mcode;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mmessage;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FeedsbackResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedsbackResponse();
        DEFAULT_CODE = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m787newBuilder() {
        Builder r0 = new Builder();
        r0.mcode = this.mcode;
        r0.mmessage = this.mmessage;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FeedsbackResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m787newBuilder();
    }

    public FeedsbackResponse(Long r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public FeedsbackResponse(Long r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mcode = r2;
        this.mmessage = r3;
    }
}
