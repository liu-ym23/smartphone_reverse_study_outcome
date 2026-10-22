package com.obric.matrix.proto;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import com.google.gson.annotations.SerializedName;
import com.lynx.serval.svg.SVGRenderEngine;
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

/* JADX INFO: loaded from: classes3.dex */
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

    @SerializedName(SVGRenderEngine.PATH)
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

        public Builder() {
            this.path = "";
            this.method = NETWORK_METHOD.METHOD_GET;
            this.body = ByteString.EMPTY;
            this.needAccessToken = Boolean.FALSE;
            this.accessToken = "";
            this.headerParams = Internal.newMutableMap();
            this.queryParams = Internal.newMutableMap();
        }

        public Builder accessToken(String r5) {
            this.accessToken = r5;
            return this;
        }

        public Builder body(ByteString r5) {
            this.body = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder headerParams(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.headerParams = r5;
            return this;
        }

        public Builder method(NETWORK_METHOD r5) {
            this.method = r5;
            return this;
        }

        public Builder needAccessToken(Boolean r5) {
            this.needAccessToken = r5;
            return this;
        }

        public Builder path(String r5) {
            this.path = r5;
            return this;
        }

        public Builder queryParams(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.queryParams = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public GenericNetworkRequest build() {
            String r5 = this.path;
            if (r5 == null) goto L9;
            if (this.method == null) goto L9;
            return new GenericNetworkRequest(this.path, this.method, this.headerParams, this.queryParams, this.body, this.needAccessToken, this.accessToken, buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r5, SVGRenderEngine.PATH, this.method, "method"});
        }
    }

    public static final class ProtoAdapter_GenericNetworkRequest extends ProtoAdapter<GenericNetworkRequest> {
        private final ProtoAdapter<Map<String, String>> headerParams;
        private final ProtoAdapter<Map<String, String>> queryParams;

        public ProtoAdapter_GenericNetworkRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GenericNetworkRequest.class);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            this.headerParams = ProtoAdapter.newMapAdapter(r5, r5);
            this.queryParams = ProtoAdapter.newMapAdapter(r5, r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenericNetworkRequest decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, GenericNetworkRequest r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GenericNetworkRequest r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenericNetworkRequest redact(GenericNetworkRequest r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GenericNetworkRequest decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L17;
            switch(r12) {
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
            r5.method(NETWORK_METHOD.ADAPTER.decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r5.addUnknownField(r12, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r5.accessToken(ProtoAdapter.STRING.decode(r10));
            goto L3
        L8:
            r5.needAccessToken(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L9:
            r5.body(ProtoAdapter.BYTES.decode(r10));
            goto L3
        L10:
            r5.queryParams.putAll(this.queryParams.decode(r10));
            goto L3
        L11:
            r5.headerParams.putAll(this.headerParams.decode(r10));
            goto L3
        L16:
            r5.path(ProtoAdapter.STRING.decode(r10));
            goto L3
        L6:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L17:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, GenericNetworkRequest r10) throws IOException {
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            r11.encodeWithTag(r5, 1, r10.path);
            NETWORK_METHOD.ADAPTER.encodeWithTag(r5, 2, r10.method);
            this.headerParams.encodeWithTag(r5, 3, r10.headerParams);
            this.queryParams.encodeWithTag(r5, 4, r10.queryParams);
            ProtoAdapter.BYTES.encodeWithTag(r5, 5, r10.body);
            ProtoAdapter.BOOL.encodeWithTag(r5, 6, r10.needAccessToken);
            r11.encodeWithTag(r5, 7, r10.accessToken);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GenericNetworkRequest r10) {
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            int r11 = r5.encodedSizeWithTag(1, r10.path);
            int r12 = NETWORK_METHOD.ADAPTER.encodedSizeWithTag(2, r10.method) + r11;
            int r13 = this.headerParams.encodedSizeWithTag(3, r10.headerParams) + r12;
            int r14 = this.queryParams.encodedSizeWithTag(4, r10.queryParams) + r13;
            int r15 = ProtoAdapter.BYTES.encodedSizeWithTag(5, r10.body) + r14;
            int r16 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r10.needAccessToken) + r15;
            int r17 = r5.encodedSizeWithTag(7, r10.accessToken) + r16;
            return r10.unknownFields().size() + r17;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GenericNetworkRequest redact2(GenericNetworkRequest r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GenericNetworkRequest();
        DEFAULT_METHOD = NETWORK_METHOD.METHOD_GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_NEEDACCESSTOKEN = Boolean.FALSE;
    }

    public GenericNetworkRequest(String r10, NETWORK_METHOD r11, Map<String, String> r12, Map<String, String> r13, ByteString r14, Boolean r15, String r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GenericNetworkRequest) == true) goto L8;
        return false;
    L8:
        GenericNetworkRequest r10 = (GenericNetworkRequest) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L26;
        if (this.path.equals(r10.path) == false) goto L26;
        if (this.method.equals(r10.method) == false) goto L26;
        if (this.headerParams.equals(r10.headerParams) == false) goto L26;
        if (this.queryParams.equals(r10.queryParams) == false) goto L26;
        if (Internal.equals(this.body, r10.body) == false) goto L26;
        if (Internal.equals(this.needAccessToken, r10.needAccessToken) == false) goto L26;
        if (Internal.equals(this.accessToken, r10.accessToken) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L17;
        int r10 = (this.queryParams.hashCode() + ((this.headerParams.hashCode() + ((this.method.hashCode() + a.c(unknownFields().hashCode() * 37, 37, this.path)) * 37)) * 37)) * 37;
        ByteString r11 = this.body;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Boolean r15 = this.needAccessToken;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        String r18 = this.accessToken;
        if (r18 == null) goto L15;
        r12 = r18.hashCode();
    L15:
        int r19 = r17 + r12;
        this.hashCode = r19;
        return r19;
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L17:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = j0.u(", path=");
        r5.append(this.path);
        r5.append(", method=");
        r5.append(this.method);
        Map<String, String> r10 = this.headerParams;
        if (r10 != null) goto L5;
    L7:
        Map<String, String> r11 = this.queryParams;
        if (r11 == null) goto L13;
        if (r11.isEmpty() == true) goto L13;
        r5.append(", queryParams=");
        r5.append(this.queryParams);
    L13:
        if (this.body == null) goto L16;
        r5.append(", body=");
        r5.append(this.body);
    L16:
        if (this.needAccessToken == null) goto L19;
        r5.append(", needAccessToken=");
        r5.append(this.needAccessToken);
    L19:
        if (this.accessToken == null) goto L22;
        r5.append(", accessToken=");
        r5.append(this.accessToken);
    L22:
        return androidx.room.jarjarred.org.antlr.runtime.a.s(r5, 0, 2, "GenericNetworkRequest{", '}');
    L5:
        if (r10.isEmpty() == true) goto L7;
        r5.append(", headerParams=");
        r5.append(this.headerParams);
        goto L7
    }

    public GenericNetworkRequest(String r5, NETWORK_METHOD r10, Map<String, String> r11, Map<String, String> r12, ByteString r13, Boolean r14, String r15, ByteString r16) {
        super(ADAPTER, r16);
        this.path = r5;
        this.method = r10;
        this.headerParams = Internal.immutableCopyOf("headerParams", r11);
        this.queryParams = Internal.immutableCopyOf("queryParams", r12);
        this.body = r13;
        this.needAccessToken = r14;
        this.accessToken = r15;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.path = this.path;
        r5.method = this.method;
        r5.headerParams = Internal.copyOf("headerParams", this.headerParams);
        r5.queryParams = Internal.copyOf("queryParams", this.queryParams);
        r5.body = this.body;
        r5.needAccessToken = this.needAccessToken;
        r5.accessToken = this.accessToken;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
