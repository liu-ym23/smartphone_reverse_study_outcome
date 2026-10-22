package com.obric.matrix.proto;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.a;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class GetTTNetParametersResponse extends Message<GetTTNetParametersResponse, Builder> {
    public static final ProtoAdapter<GetTTNetParametersResponse> ADAPTER = null;
    public static final String DEFAULT_PARAMETERS = "";
    private static final long serialVersionUID = 0;

    @SerializedName("parameters")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String parameters;

    public static final class Builder extends Message.Builder<GetTTNetParametersResponse, Builder> {
        public String parameters;

        public Builder() {
            this.parameters = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder parameters(String r5) {
            this.parameters = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public GetTTNetParametersResponse build() {
            String r5 = this.parameters;
            if (r5 == null) goto L7;
            return new GetTTNetParametersResponse(this.parameters, buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r5, "parameters"});
        }
    }

    public static final class ProtoAdapter_GetTTNetParametersResponse extends ProtoAdapter<GetTTNetParametersResponse> {
        public ProtoAdapter_GetTTNetParametersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTTNetParametersResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTTNetParametersResponse decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, GetTTNetParametersResponse r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTTNetParametersResponse r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTTNetParametersResponse redact(GetTTNetParametersResponse r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTTNetParametersResponse decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L9;
            if (r12 != 1) goto L7;
            r5.parameters(ProtoAdapter.STRING.decode(r10));
            goto L3
        L7:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L9:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, GetTTNetParametersResponse r10) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r5, 1, r10.parameters);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetTTNetParametersResponse r5) {
            int r10 = ProtoAdapter.STRING.encodedSizeWithTag(1, r5.parameters);
            return r5.unknownFields().size() + r10;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GetTTNetParametersResponse redact2(GetTTNetParametersResponse r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetTTNetParametersResponse();
    }

    public GetTTNetParametersResponse(String r5) {
        this(r5, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetTTNetParametersResponse) == true) goto L8;
        return false;
    L8:
        GetTTNetParametersResponse r10 = (GetTTNetParametersResponse) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L14;
        if (this.parameters.equals(r10.parameters) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L6;
        int r10 = (unknownFields().hashCode() * 37) + this.parameters.hashCode();
        this.hashCode = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = j0.u(", parameters=");
        r5.append(this.parameters);
        return a.s(r5, 0, 2, "GetTTNetParametersResponse{", '}');
    }

    public GetTTNetParametersResponse(String r5, ByteString r10) {
        super(ADAPTER, r10);
        this.parameters = r5;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.parameters = this.parameters;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
