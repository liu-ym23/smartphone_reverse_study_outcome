package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class GetTTNetParametersResponse extends Message<GetTTNetParametersResponse, a> {
    public static final ProtoAdapter<GetTTNetParametersResponse> ADAPTER = null;
    public static final String DEFAULT_PARAMETERS = "";
    private static final long serialVersionUID = 0;

    @SerializedName("parameters")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String parameters;

    public static final class a extends Message.Builder<GetTTNetParametersResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8175a;

        public a() {
            this.f8175a = "";
        }

        public a a(String r1) {
            this.f8175a = r1;
            return this;
        }

        public GetTTNetParametersResponse a() {
            String r0 = this.f8175a;
            if (r0 == null) goto L7;
            return new GetTTNetParametersResponse(this.f8175a, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "parameters"});
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<GetTTNetParametersResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTTNetParametersResponse.class);
        }

        public int a(GetTTNetParametersResponse r3) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r3.parameters) + r3.unknownFields().size();
        }

        public GetTTNetParametersResponse a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, GetTTNetParametersResponse r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.parameters);
            r3.writeBytes(r4.unknownFields());
        }

        public GetTTNetParametersResponse b(GetTTNetParametersResponse r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ GetTTNetParametersResponse decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, GetTTNetParametersResponse r4) {
            a(r3, (GetTTNetParametersResponse) ZeusTransformUtils.preCheckCast(r4, GetTTNetParametersResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(GetTTNetParametersResponse r3) {
            return a((GetTTNetParametersResponse) ZeusTransformUtils.preCheckCast(r3, GetTTNetParametersResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ GetTTNetParametersResponse redact(GetTTNetParametersResponse r3) {
            return b((GetTTNetParametersResponse) ZeusTransformUtils.preCheckCast(r3, GetTTNetParametersResponse.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public GetTTNetParametersResponse(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public GetTTNetParametersResponse(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.parameters = r2;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GetTTNetParametersResponse.class) == true) goto L8;
        return false;
    L8:
        GetTTNetParametersResponse r6 = (GetTTNetParametersResponse) ZeusTransformUtils.preCheckCast(r5, GetTTNetParametersResponse.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.parameters.equals(r6.parameters) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.parameters.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8175a = this.parameters;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(", parameters=").append(this.parameters);
        return r0.replace(0, 2, "GetTTNetParametersResponse{").append('}').toString();
    }
}
