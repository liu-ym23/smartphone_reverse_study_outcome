package com.ss.android.lark.pb.ai_knowledge;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CheckUserHasSentQueryResponse extends Message<CheckUserHasSentQueryResponse, Builder> {
    public static final ProtoAdapter<CheckUserHasSentQueryResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_SENT = null;
    private static final long serialVersionUID = 0;
    public final Boolean mhas_sent;

    public static final class Builder extends Message.Builder<CheckUserHasSentQueryResponse, Builder> {
        public Boolean mhas_sent;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CheckUserHasSentQueryResponse m791build() {
            return new CheckUserHasSentQueryResponse(this.mhas_sent, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m791build();
        }

        public Builder has_sent(Boolean r1) {
            this.mhas_sent = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckUserHasSentQueryResponse extends ProtoAdapter<CheckUserHasSentQueryResponse> {
        public ProtoAdapter_CheckUserHasSentQueryResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckUserHasSentQueryResponse.class);
        }

        public CheckUserHasSentQueryResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mhas_sent = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mhas_sent = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m791build();
        }

        public int encodedSize(CheckUserHasSentQueryResponse r4) {
            Boolean r0 = r4.mhas_sent;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m792decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CheckUserHasSentQueryResponse) r1);
        }

        public void encode(ProtoWriter r4, CheckUserHasSentQueryResponse r5) throws IOException {
            Boolean r0 = r5.mhas_sent;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CheckUserHasSentQueryResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CheckUserHasSentQueryResponse();
        DEFAULT_HAS_SENT = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m790newBuilder() {
        Builder r0 = new Builder();
        r0.mhas_sent = this.mhas_sent;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CheckUserHasSentQueryResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m790newBuilder();
    }

    public CheckUserHasSentQueryResponse(Boolean r2) {
        this(r2, ByteString.EMPTY);
    }

    public CheckUserHasSentQueryResponse(Boolean r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mhas_sent = r2;
    }
}
