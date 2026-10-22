package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GetTTNetParametersRequest extends Message<GetTTNetParametersRequest, Builder> {
    public static final ProtoAdapter<GetTTNetParametersRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<GetTTNetParametersRequest, Builder> {
        public GetTTNetParametersRequest build() {
            return new GetTTNetParametersRequest(super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m105build() {
            return build();
        }
    }

    public static final class ProtoAdapter_GetTTNetParametersRequest extends ProtoAdapter<GetTTNetParametersRequest> {
        public ProtoAdapter_GetTTNetParametersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTTNetParametersRequest.class);
        }

        public GetTTNetParametersRequest decode(ProtoReader r7) throws IOException {
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

        public int encodedSize(GetTTNetParametersRequest r1) {
            return r1.unknownFields().size();
        }

        public GetTTNetParametersRequest redact(GetTTNetParametersRequest r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m106decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetTTNetParametersRequest) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((GetTTNetParametersRequest) r1);
        }

        public void encode(ProtoWriter r1, GetTTNetParametersRequest r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetTTNetParametersRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetTTNetParametersRequest();
    }

    public GetTTNetParametersRequest() {
        this(ByteString.EMPTY);
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().replace(0, 2, "GetTTNetParametersRequest{");
        r0.append('}');
        return r0.toString();
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m104newBuilder() {
        return newBuilder();
    }

    public GetTTNetParametersRequest(ByteString r2) {
        super(ADAPTER, r2);
    }

    public boolean equals(Object r1) {
        return r1 instanceof GetTTNetParametersRequest;
    }
}
