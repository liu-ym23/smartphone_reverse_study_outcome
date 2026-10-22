package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SendApplogEventResponse extends Message<SendApplogEventResponse, Builder> {
    public static final ProtoAdapter<SendApplogEventResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<SendApplogEventResponse, Builder> {
        public SendApplogEventResponse build() {
            return new SendApplogEventResponse(super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m176build() {
            return build();
        }
    }

    public static final class ProtoAdapter_SendApplogEventResponse extends ProtoAdapter<SendApplogEventResponse> {
        public ProtoAdapter_SendApplogEventResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SendApplogEventResponse.class);
        }

        public SendApplogEventResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L6;
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L6:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SendApplogEventResponse r1) {
            return r1.unknownFields().size();
        }

        public SendApplogEventResponse redact(SendApplogEventResponse r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m177decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SendApplogEventResponse) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SendApplogEventResponse) r1);
        }

        public void encode(ProtoWriter r1, SendApplogEventResponse r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SendApplogEventResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SendApplogEventResponse();
    }

    public SendApplogEventResponse() {
        this(ByteString.EMPTY);
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().replace(0, 2, "SendApplogEventResponse{");
        r0.append('}');
        return r0.toString();
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m175newBuilder() {
        return newBuilder();
    }

    public SendApplogEventResponse(ByteString r2) {
        super(ADAPTER, r2);
    }

    public boolean equals(Object r1) {
        return r1 instanceof SendApplogEventResponse;
    }
}
