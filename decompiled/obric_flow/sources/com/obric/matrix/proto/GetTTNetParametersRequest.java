package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class GetTTNetParametersRequest extends Message<GetTTNetParametersRequest, Builder> {
    public static final ProtoAdapter<GetTTNetParametersRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<GetTTNetParametersRequest, Builder> {
        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.squareup.wire.Message.Builder
        public GetTTNetParametersRequest build() {
            return new GetTTNetParametersRequest(buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_GetTTNetParametersRequest extends ProtoAdapter<GetTTNetParametersRequest> {
        public ProtoAdapter_GetTTNetParametersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTTNetParametersRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTTNetParametersRequest decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, GetTTNetParametersRequest r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTTNetParametersRequest r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTTNetParametersRequest redact(GetTTNetParametersRequest r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTTNetParametersRequest decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L6;
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L6:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, GetTTNetParametersRequest r10) throws IOException {
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetTTNetParametersRequest r5) {
            return r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GetTTNetParametersRequest redact2(GetTTNetParametersRequest r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetTTNetParametersRequest();
    }

    public GetTTNetParametersRequest() {
        this(ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        return r5 instanceof GetTTNetParametersRequest;
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder().replace(0, 2, "GetTTNetParametersRequest{");
        r5.append('}');
        return r5.toString();
    }

    public GetTTNetParametersRequest(ByteString r5) {
        super(ADAPTER, r5);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
