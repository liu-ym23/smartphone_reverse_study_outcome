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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GenericNetworkRequest extends Message<GenericNetworkRequest, Builder> {
    public static final ProtoAdapter<GenericNetworkRequest> ADAPTER = null;
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final ByteString DEFAULT_BODY = null;
    public static final NETWORK_METHOD DEFAULT_METHOD = null;
    public static final Boolean DEFAULT_NEEDACCESSTOKEN = null;
    public static final String DEFAULT_PATH = "";
    private static final long serialVersionUID = 0;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String accessToken;

    @SerializedName("body")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 5)
    public final ByteString body;

    @SerializedName("headerParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> headerParams;

    @SerializedName("method")
    @WireField(adapter = "com.obric.matrix.proto.NETWORK_METHOD#ADAPTER", label = WireField.Label.REQUIRED, tag = 2)
    public final NETWORK_METHOD method;

    @SerializedName("needAccessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean needAccessToken;

    @SerializedName("path")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String path;

    @SerializedName("queryParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> queryParams;

    public static final class Builder extends Message.Builder<GenericNetworkRequest, Builder> {
        public String accessToken;
        public ByteString body;
        public Map<String, String> headerParams;
        public NETWORK_METHOD method;
        public Boolean needAccessToken;
        public String path;
        public Map<String, String> queryParams;

        public GenericNetworkRequest build() {
            String r0 = this.path;
            if (r0 == null) goto L9;
            if (this.method == null) goto L9;
            return new GenericNetworkRequest(this.path, this.method, this.headerParams, this.queryParams, this.body, this.needAccessToken, this.accessToken, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "path", this.method, "method"});
        }

        public Builder() {
            this.path = "";
            this.method = NETWORK_METHOD.METHOD_GET;
            this.body = ByteString.EMPTY;
            this.needAccessToken = Boolean.FALSE;
            this.accessToken = "";
            this.headerParams = Internal.newMutableMap();
            this.queryParams = Internal.newMutableMap();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m87build() {
            return build();
        }

        public Builder accessToken(String r1) {
            this.accessToken = r1;
            return this;
        }

        public Builder body(ByteString r1) {
            this.body = r1;
            return this;
        }

        public Builder headerParams(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.headerParams = r1;
            return this;
        }

        public Builder method(NETWORK_METHOD r1) {
            this.method = r1;
            return this;
        }

        public Builder needAccessToken(Boolean r1) {
            this.needAccessToken = r1;
            return this;
        }

        public Builder path(String r1) {
            this.path = r1;
            return this;
        }

        public Builder queryParams(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.queryParams = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GenericNetworkRequest extends ProtoAdapter<GenericNetworkRequest> {
        private final ProtoAdapter<Map<String, String>> headerParams;
        private final ProtoAdapter<Map<String, String>> queryParams;

        public ProtoAdapter_GenericNetworkRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GenericNetworkRequest.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.headerParams = ProtoAdapter.newMapAdapter(r0, r0);
            this.queryParams = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public GenericNetworkRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L19;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r0.method((NETWORK_METHOD) NETWORK_METHOD.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.accessToken((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L8:
            r0.needAccessToken((Boolean) ProtoAdapter.BOOL.decode(r9));
            goto L3
        L9:
            r0.body((ByteString) ProtoAdapter.BYTES.decode(r9));
            goto L3
        L10:
            r0.queryParams.putAll((Map) this.queryParams.decode(r9));
            goto L3
        L11:
            r0.headerParams.putAll((Map) this.headerParams.decode(r9));
            goto L3
        L16:
            r0.path((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L17:
            r9.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(GenericNetworkRequest r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return ((((((r0.encodedSizeWithTag(1, r6.path) + NETWORK_METHOD.ADAPTER.encodedSizeWithTag(2, r6.method)) + this.headerParams.encodedSizeWithTag(3, r6.headerParams)) + this.queryParams.encodedSizeWithTag(4, r6.queryParams)) + ProtoAdapter.BYTES.encodedSizeWithTag(5, r6.body)) + ProtoAdapter.BOOL.encodedSizeWithTag(6, r6.needAccessToken)) + r0.encodedSizeWithTag(7, r6.accessToken)) + r6.unknownFields().size();
        }

        public GenericNetworkRequest redact(GenericNetworkRequest r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m88decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GenericNetworkRequest) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((GenericNetworkRequest) r1);
        }

        public void encode(ProtoWriter r5, GenericNetworkRequest r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.path);
            NETWORK_METHOD.ADAPTER.encodeWithTag(r5, 2, r6.method);
            this.headerParams.encodeWithTag(r5, 3, r6.headerParams);
            this.queryParams.encodeWithTag(r5, 4, r6.queryParams);
            ProtoAdapter.BYTES.encodeWithTag(r5, 5, r6.body);
            ProtoAdapter.BOOL.encodeWithTag(r5, 6, r6.needAccessToken);
            r0.encodeWithTag(r5, 7, r6.accessToken);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GenericNetworkRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GenericNetworkRequest();
        DEFAULT_METHOD = NETWORK_METHOD.METHOD_GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_NEEDACCESSTOKEN = Boolean.FALSE;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L17;
        int r1 = ((((((((unknownFields().hashCode() * 37) + this.path.hashCode()) * 37) + this.method.hashCode()) * 37) + this.headerParams.hashCode()) * 37) + this.queryParams.hashCode()) * 37;
        ByteString r2 = this.body;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Boolean r6 = this.needAccessToken;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.accessToken;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = r8 + r3;
        ((Message) this).hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.path = this.path;
        r0.method = this.method;
        r0.headerParams = Internal.copyOf("headerParams", this.headerParams);
        r0.queryParams = Internal.copyOf("queryParams", this.queryParams);
        r0.body = this.body;
        r0.needAccessToken = this.needAccessToken;
        r0.accessToken = this.accessToken;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(", path=");
        r0.append(this.path);
        r0.append(", method=");
        r0.append(this.method);
        Map<String, String> r1 = this.headerParams;
        if (r1 != null) goto L5;
    L7:
        Map<String, String> r2 = this.queryParams;
        if (r2 == null) goto L13;
        if (r2.isEmpty() == true) goto L13;
        r0.append(", queryParams=");
        r0.append(this.queryParams);
    L13:
        if (this.body == null) goto L16;
        r0.append(", body=");
        r0.append(this.body);
    L16:
        if (this.needAccessToken == null) goto L19;
        r0.append(", needAccessToken=");
        r0.append(this.needAccessToken);
    L19:
        if (this.accessToken == null) goto L21;
        r0.append(", accessToken=");
        r0.append(this.accessToken);
    L21:
        StringBuilder r3 = r0.replace(0, 2, "GenericNetworkRequest{");
        r3.append('}');
        return r3.toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", headerParams=");
        r0.append(this.headerParams);
        goto L7
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m86newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GenericNetworkRequest) == true) goto L8;
        return false;
    L8:
        GenericNetworkRequest r6 = (GenericNetworkRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L25:
        return false;
    L11:
        if (this.path.equals(r6.path) == false) goto L25;
        if (this.method.equals(r6.method) == false) goto L25;
        if (this.headerParams.equals(r6.headerParams) == false) goto L25;
        if (this.queryParams.equals(r6.queryParams) == false) goto L25;
        if (Internal.equals(this.body, r6.body) == false) goto L25;
        if (Internal.equals(this.needAccessToken, r6.needAccessToken) == false) goto L25;
        if (Internal.equals(this.accessToken, r6.accessToken) == false) goto L25;
        return true;
    }

    public GenericNetworkRequest(String r10, NETWORK_METHOD r11, Map<String, String> r12, Map<String, String> r13, ByteString r14, Boolean r15, String r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public GenericNetworkRequest(String r2, NETWORK_METHOD r3, Map<String, String> r4, Map<String, String> r5, ByteString r6, Boolean r7, String r8, ByteString r9) {
        super(ADAPTER, r9);
        this.path = r2;
        this.method = r3;
        this.headerParams = Internal.immutableCopyOf("headerParams", r4);
        this.queryParams = Internal.immutableCopyOf("queryParams", r5);
        this.body = r6;
        this.needAccessToken = r7;
        this.accessToken = r8;
    }
}
