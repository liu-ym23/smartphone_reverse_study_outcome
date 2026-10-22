package com.obric.matrix.proto;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GetTTNetParametersResponse extends Message<GetTTNetParametersResponse, Builder> {
    public static final ProtoAdapter<GetTTNetParametersResponse> ADAPTER = null;
    public static final String DEFAULT_PARAMETERS = "";
    private static final long serialVersionUID = 0;

    @SerializedName("parameters")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String parameters;

    public static final class Builder extends Message.Builder<GetTTNetParametersResponse, Builder> {
        public String parameters;

        public GetTTNetParametersResponse build() {
            String r0 = this.parameters;
            if (r0 == null) goto L7;
            return new GetTTNetParametersResponse(this.parameters, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "parameters"});
        }

        public Builder() {
            this.parameters = "";
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m108build() {
            return build();
        }

        public Builder parameters(String r1) {
            this.parameters = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTTNetParametersResponse extends ProtoAdapter<GetTTNetParametersResponse> {
        public ProtoAdapter_GetTTNetParametersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTTNetParametersResponse.class);
        }

        public GetTTNetParametersResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.parameters((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(GetTTNetParametersResponse r4) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r4.parameters) + r4.unknownFields().size();
        }

        public GetTTNetParametersResponse redact(GetTTNetParametersResponse r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m109decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetTTNetParametersResponse) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((GetTTNetParametersResponse) r1);
        }

        public void encode(ProtoWriter r4, GetTTNetParametersResponse r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.parameters);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetTTNetParametersResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetTTNetParametersResponse();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.parameters.hashCode();
        ((Message) this).hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.parameters = this.parameters;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(", parameters=");
        r0.append(this.parameters);
        StringBuilder r1 = r0.replace(0, 2, "GetTTNetParametersResponse{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m107newBuilder() {
        return newBuilder();
    }

    public GetTTNetParametersResponse(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetTTNetParametersResponse) == true) goto L8;
        return false;
    L8:
        GetTTNetParametersResponse r6 = (GetTTNetParametersResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.parameters.equals(r6.parameters) == false) goto L13;
        return true;
    }

    public GetTTNetParametersResponse(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.parameters = r2;
    }
}
