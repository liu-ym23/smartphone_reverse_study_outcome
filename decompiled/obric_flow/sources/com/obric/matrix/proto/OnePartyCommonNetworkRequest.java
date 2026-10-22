package com.obric.matrix.proto;

import androidx.room.jarjarred.org.antlr.runtime.a;
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
public final class OnePartyCommonNetworkRequest extends Message<OnePartyCommonNetworkRequest, Builder> {
    public static final ProtoAdapter<OnePartyCommonNetworkRequest> ADAPTER = null;
    public static final Boolean DEFAULT_ADDCOMMONPARAM = null;
    public static final ByteString DEFAULT_BODY = null;
    public static final String DEFAULT_HOST = "";
    public static final NETWORK_METHOD DEFAULT_METHOD = null;
    public static final String DEFAULT_PATH = "";
    private static final long serialVersionUID = 0;

    @SerializedName("addCommonParam")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean addCommonParam;

    @SerializedName("body")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 6)
    public final ByteString body;

    @SerializedName("extraMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final Map<String, String> extraMap;

    @SerializedName("fieldMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final Map<String, String> fieldMap;

    @SerializedName("headerParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> headerParams;

    @SerializedName("host")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String host;

    @SerializedName("method")
    @WireField(adapter = "com.obric.matrix.proto.NETWORK_METHOD#ADAPTER", label = WireField.Label.REQUIRED, tag = 3)
    public final NETWORK_METHOD method;

    @SerializedName(SVGRenderEngine.PATH)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String path;

    @SerializedName("queryParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final Map<String, String> queryParams;

    public static final class Builder extends Message.Builder<OnePartyCommonNetworkRequest, Builder> {
        public Boolean addCommonParam;
        public ByteString body;
        public Map<String, String> extraMap;
        public Map<String, String> fieldMap;
        public Map<String, String> headerParams;
        public String host;
        public NETWORK_METHOD method;
        public String path;
        public Map<String, String> queryParams;

        public Builder() {
            this.path = "";
            this.host = "";
            this.method = NETWORK_METHOD.METHOD_GET;
            this.body = ByteString.EMPTY;
            this.addCommonParam = Boolean.FALSE;
            this.headerParams = Internal.newMutableMap();
            this.queryParams = Internal.newMutableMap();
            this.fieldMap = Internal.newMutableMap();
            this.extraMap = Internal.newMutableMap();
        }

        public Builder addCommonParam(Boolean r5) {
            this.addCommonParam = r5;
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

        public Builder extraMap(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.extraMap = r5;
            return this;
        }

        public Builder fieldMap(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.fieldMap = r5;
            return this;
        }

        public Builder headerParams(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.headerParams = r5;
            return this;
        }

        public Builder host(String r5) {
            this.host = r5;
            return this;
        }

        public Builder method(NETWORK_METHOD r5) {
            this.method = r5;
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
        public OnePartyCommonNetworkRequest build() {
            NETWORK_METHOD r5 = this.method;
            if (r5 == null) goto L7;
            return new OnePartyCommonNetworkRequest(this.path, this.host, this.method, this.headerParams, this.queryParams, this.body, this.fieldMap, this.addCommonParam, this.extraMap, buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r5, "method"});
        }
    }

    public static final class ProtoAdapter_OnePartyCommonNetworkRequest extends ProtoAdapter<OnePartyCommonNetworkRequest> {
        private final ProtoAdapter<Map<String, String>> extraMap;
        private final ProtoAdapter<Map<String, String>> fieldMap;
        private final ProtoAdapter<Map<String, String>> headerParams;
        private final ProtoAdapter<Map<String, String>> queryParams;

        public ProtoAdapter_OnePartyCommonNetworkRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, OnePartyCommonNetworkRequest.class);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            this.headerParams = ProtoAdapter.newMapAdapter(r5, r5);
            this.queryParams = ProtoAdapter.newMapAdapter(r5, r5);
            this.fieldMap = ProtoAdapter.newMapAdapter(r5, r5);
            this.extraMap = ProtoAdapter.newMapAdapter(r5, r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OnePartyCommonNetworkRequest decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, OnePartyCommonNetworkRequest r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OnePartyCommonNetworkRequest r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OnePartyCommonNetworkRequest redact(OnePartyCommonNetworkRequest r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OnePartyCommonNetworkRequest decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L19;
            switch(r12) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L21;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r5.method(NETWORK_METHOD.ADAPTER.decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r5.addUnknownField(r12, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r5.extraMap.putAll(this.extraMap.decode(r10));
            goto L3
        L8:
            r5.addCommonParam(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L9:
            r5.fieldMap.putAll(this.fieldMap.decode(r10));
            goto L3
        L10:
            r5.body(ProtoAdapter.BYTES.decode(r10));
            goto L3
        L11:
            r5.queryParams.putAll(this.queryParams.decode(r10));
            goto L3
        L12:
            r5.headerParams.putAll(this.headerParams.decode(r10));
            goto L3
        L17:
            r5.host(ProtoAdapter.STRING.decode(r10));
            goto L3
        L18:
            r5.path(ProtoAdapter.STRING.decode(r10));
            goto L3
        L6:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L19:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, OnePartyCommonNetworkRequest r10) throws IOException {
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            r11.encodeWithTag(r5, 1, r10.path);
            r11.encodeWithTag(r5, 2, r10.host);
            NETWORK_METHOD.ADAPTER.encodeWithTag(r5, 3, r10.method);
            this.headerParams.encodeWithTag(r5, 4, r10.headerParams);
            this.queryParams.encodeWithTag(r5, 5, r10.queryParams);
            ProtoAdapter.BYTES.encodeWithTag(r5, 6, r10.body);
            this.fieldMap.encodeWithTag(r5, 7, r10.fieldMap);
            ProtoAdapter.BOOL.encodeWithTag(r5, 8, r10.addCommonParam);
            this.extraMap.encodeWithTag(r5, 9, r10.extraMap);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OnePartyCommonNetworkRequest r5) {
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            int r11 = r10.encodedSizeWithTag(1, r5.path);
            int r12 = r10.encodedSizeWithTag(2, r5.host) + r11;
            int r13 = NETWORK_METHOD.ADAPTER.encodedSizeWithTag(3, r5.method) + r12;
            int r14 = this.headerParams.encodedSizeWithTag(4, r5.headerParams) + r13;
            int r15 = this.queryParams.encodedSizeWithTag(5, r5.queryParams) + r14;
            int r16 = ProtoAdapter.BYTES.encodedSizeWithTag(6, r5.body) + r15;
            int r17 = this.fieldMap.encodedSizeWithTag(7, r5.fieldMap) + r16;
            int r18 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r5.addCommonParam) + r17;
            int r19 = this.extraMap.encodedSizeWithTag(9, r5.extraMap) + r18;
            return r5.unknownFields().size() + r19;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public OnePartyCommonNetworkRequest redact2(OnePartyCommonNetworkRequest r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OnePartyCommonNetworkRequest();
        DEFAULT_METHOD = NETWORK_METHOD.METHOD_GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_ADDCOMMONPARAM = Boolean.FALSE;
    }

    public OnePartyCommonNetworkRequest(String r12, String r13, NETWORK_METHOD r14, Map<String, String> r15, Map<String, String> r16, ByteString r17, Map<String, String> r18, Boolean r19, Map<String, String> r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof OnePartyCommonNetworkRequest) == true) goto L8;
        return false;
    L8:
        OnePartyCommonNetworkRequest r10 = (OnePartyCommonNetworkRequest) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L30;
        if (Internal.equals(this.path, r10.path) == false) goto L30;
        if (Internal.equals(this.host, r10.host) == false) goto L30;
        if (this.method.equals(r10.method) == false) goto L30;
        if (this.headerParams.equals(r10.headerParams) == false) goto L30;
        if (this.queryParams.equals(r10.queryParams) == false) goto L30;
        if (Internal.equals(this.body, r10.body) == false) goto L30;
        if (this.fieldMap.equals(r10.fieldMap) == false) goto L30;
        if (Internal.equals(this.addCommonParam, r10.addCommonParam) == false) goto L30;
        if (this.extraMap.equals(r10.extraMap) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L21;
        int r10 = unknownFields().hashCode() * 37;
        String r11 = this.path;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        String r15 = this.host;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (this.queryParams.hashCode() + ((this.headerParams.hashCode() + ((this.method.hashCode() + ((r14 + r16) * 37)) * 37)) * 37)) * 37;
        ByteString r18 = this.body;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (this.fieldMap.hashCode() + ((r17 + r19) * 37)) * 37;
        Boolean r21 = this.addCommonParam;
        if (r21 == null) goto L19;
        r12 = r21.hashCode();
    L19:
        int r22 = ((r20 + r12) * 37) + this.extraMap.hashCode();
        this.hashCode = r22;
        return r22;
    L15:
        r19 = 0;
        goto L16
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L21:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.path == null) goto L6;
        r5.append(", path=");
        r5.append(this.path);
    L6:
        if (this.host == null) goto L8;
        r5.append(", host=");
        r5.append(this.host);
    L8:
        r5.append(", method=");
        r5.append(this.method);
        Map<String, String> r10 = this.headerParams;
        if (r10 != null) goto L11;
    L13:
        Map<String, String> r11 = this.queryParams;
        if (r11 == null) goto L19;
        if (r11.isEmpty() == true) goto L19;
        r5.append(", queryParams=");
        r5.append(this.queryParams);
    L19:
        if (this.body == null) goto L21;
        r5.append(", body=");
        r5.append(this.body);
    L21:
        Map<String, String> r12 = this.fieldMap;
        if (r12 == null) goto L27;
        if (r12.isEmpty() == true) goto L27;
        r5.append(", fieldMap=");
        r5.append(this.fieldMap);
    L27:
        if (this.addCommonParam == null) goto L29;
        r5.append(", addCommonParam=");
        r5.append(this.addCommonParam);
    L29:
        Map<String, String> r13 = this.extraMap;
        if (r13 == null) goto L35;
        if (r13.isEmpty() == true) goto L35;
        r5.append(", extraMap=");
        r5.append(this.extraMap);
    L35:
        return a.s(r5, 0, 2, "OnePartyCommonNetworkRequest{", '}');
    L11:
        if (r10.isEmpty() == true) goto L13;
        r5.append(", headerParams=");
        r5.append(this.headerParams);
        goto L13
    }

    public OnePartyCommonNetworkRequest(String r5, String r10, NETWORK_METHOD r11, Map<String, String> r12, Map<String, String> r13, ByteString r14, Map<String, String> r15, Boolean r16, Map<String, String> r17, ByteString r18) {
        super(ADAPTER, r18);
        this.path = r5;
        this.host = r10;
        this.method = r11;
        this.headerParams = Internal.immutableCopyOf("headerParams", r12);
        this.queryParams = Internal.immutableCopyOf("queryParams", r13);
        this.body = r14;
        this.fieldMap = Internal.immutableCopyOf("fieldMap", r15);
        this.addCommonParam = r16;
        this.extraMap = Internal.immutableCopyOf("extraMap", r17);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.path = this.path;
        r5.host = this.host;
        r5.method = this.method;
        r5.headerParams = Internal.copyOf("headerParams", this.headerParams);
        r5.queryParams = Internal.copyOf("queryParams", this.queryParams);
        r5.body = this.body;
        r5.fieldMap = Internal.copyOf("fieldMap", this.fieldMap);
        r5.addCommonParam = this.addCommonParam;
        r5.extraMap = Internal.copyOf("extraMap", this.extraMap);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
