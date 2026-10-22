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

    @SerializedName("path")
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

        public OnePartyCommonNetworkRequest build() {
            NETWORK_METHOD r0 = this.method;
            if (r0 == null) goto L7;
            return new OnePartyCommonNetworkRequest(this.path, this.host, this.method, this.headerParams, this.queryParams, this.body, this.fieldMap, this.addCommonParam, this.extraMap, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "method"});
        }

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

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m125build() {
            return build();
        }

        public Builder addCommonParam(Boolean r1) {
            this.addCommonParam = r1;
            return this;
        }

        public Builder body(ByteString r1) {
            this.body = r1;
            return this;
        }

        public Builder extraMap(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.extraMap = r1;
            return this;
        }

        public Builder fieldMap(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.fieldMap = r1;
            return this;
        }

        public Builder headerParams(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.headerParams = r1;
            return this;
        }

        public Builder host(String r1) {
            this.host = r1;
            return this;
        }

        public Builder method(NETWORK_METHOD r1) {
            this.method = r1;
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

    public static final class ProtoAdapter_OnePartyCommonNetworkRequest extends ProtoAdapter<OnePartyCommonNetworkRequest> {
        private final ProtoAdapter<Map<String, String>> extraMap;
        private final ProtoAdapter<Map<String, String>> fieldMap;
        private final ProtoAdapter<Map<String, String>> headerParams;
        private final ProtoAdapter<Map<String, String>> queryParams;

        public ProtoAdapter_OnePartyCommonNetworkRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, OnePartyCommonNetworkRequest.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.headerParams = ProtoAdapter.newMapAdapter(r0, r0);
            this.queryParams = ProtoAdapter.newMapAdapter(r0, r0);
            this.fieldMap = ProtoAdapter.newMapAdapter(r0, r0);
            this.extraMap = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public OnePartyCommonNetworkRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L19;
            switch(r3) {
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
            r0.method((NETWORK_METHOD) NETWORK_METHOD.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.extraMap.putAll((Map) this.extraMap.decode(r9));
            goto L3
        L8:
            r0.addCommonParam((Boolean) ProtoAdapter.BOOL.decode(r9));
            goto L3
        L9:
            r0.fieldMap.putAll((Map) this.fieldMap.decode(r9));
            goto L3
        L10:
            r0.body((ByteString) ProtoAdapter.BYTES.decode(r9));
            goto L3
        L11:
            r0.queryParams.putAll((Map) this.queryParams.decode(r9));
            goto L3
        L12:
            r0.headerParams.putAll((Map) this.headerParams.decode(r9));
            goto L3
        L17:
            r0.host((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L18:
            r0.path((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L19:
            r9.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(OnePartyCommonNetworkRequest r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return ((((((((r0.encodedSizeWithTag(1, r5.path) + r0.encodedSizeWithTag(2, r5.host)) + NETWORK_METHOD.ADAPTER.encodedSizeWithTag(3, r5.method)) + this.headerParams.encodedSizeWithTag(4, r5.headerParams)) + this.queryParams.encodedSizeWithTag(5, r5.queryParams)) + ProtoAdapter.BYTES.encodedSizeWithTag(6, r5.body)) + this.fieldMap.encodedSizeWithTag(7, r5.fieldMap)) + ProtoAdapter.BOOL.encodedSizeWithTag(8, r5.addCommonParam)) + this.extraMap.encodedSizeWithTag(9, r5.extraMap)) + r5.unknownFields().size();
        }

        public OnePartyCommonNetworkRequest redact(OnePartyCommonNetworkRequest r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m126decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((OnePartyCommonNetworkRequest) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((OnePartyCommonNetworkRequest) r1);
        }

        public void encode(ProtoWriter r4, OnePartyCommonNetworkRequest r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.path);
            r0.encodeWithTag(r4, 2, r5.host);
            NETWORK_METHOD.ADAPTER.encodeWithTag(r4, 3, r5.method);
            this.headerParams.encodeWithTag(r4, 4, r5.headerParams);
            this.queryParams.encodeWithTag(r4, 5, r5.queryParams);
            ProtoAdapter.BYTES.encodeWithTag(r4, 6, r5.body);
            this.fieldMap.encodeWithTag(r4, 7, r5.fieldMap);
            ProtoAdapter.BOOL.encodeWithTag(r4, 8, r5.addCommonParam);
            this.extraMap.encodeWithTag(r4, 9, r5.extraMap);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (OnePartyCommonNetworkRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OnePartyCommonNetworkRequest();
        DEFAULT_METHOD = NETWORK_METHOD.METHOD_GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_ADDCOMMONPARAM = Boolean.FALSE;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.path;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.host;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (((((((r5 + r7) * 37) + this.method.hashCode()) * 37) + this.headerParams.hashCode()) * 37) + this.queryParams.hashCode()) * 37;
        ByteString r9 = this.body;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (((r8 + r10) * 37) + this.fieldMap.hashCode()) * 37;
        Boolean r12 = this.addCommonParam;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = ((r11 + r3) * 37) + this.extraMap.hashCode();
        ((Message) this).hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.path = this.path;
        r0.host = this.host;
        r0.method = this.method;
        r0.headerParams = Internal.copyOf("headerParams", this.headerParams);
        r0.queryParams = Internal.copyOf("queryParams", this.queryParams);
        r0.body = this.body;
        r0.fieldMap = Internal.copyOf("fieldMap", this.fieldMap);
        r0.addCommonParam = this.addCommonParam;
        r0.extraMap = Internal.copyOf("extraMap", this.extraMap);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.path == null) goto L6;
        r0.append(", path=");
        r0.append(this.path);
    L6:
        if (this.host == null) goto L8;
        r0.append(", host=");
        r0.append(this.host);
    L8:
        r0.append(", method=");
        r0.append(this.method);
        Map<String, String> r1 = this.headerParams;
        if (r1 != null) goto L11;
    L13:
        Map<String, String> r2 = this.queryParams;
        if (r2 == null) goto L19;
        if (r2.isEmpty() == true) goto L19;
        r0.append(", queryParams=");
        r0.append(this.queryParams);
    L19:
        if (this.body == null) goto L21;
        r0.append(", body=");
        r0.append(this.body);
    L21:
        Map<String, String> r3 = this.fieldMap;
        if (r3 == null) goto L27;
        if (r3.isEmpty() == true) goto L27;
        r0.append(", fieldMap=");
        r0.append(this.fieldMap);
    L27:
        if (this.addCommonParam == null) goto L29;
        r0.append(", addCommonParam=");
        r0.append(this.addCommonParam);
    L29:
        Map<String, String> r4 = this.extraMap;
        if (r4 != null) goto L32;
    L34:
        StringBuilder r5 = r0.replace(0, 2, "OnePartyCommonNetworkRequest{");
        r5.append('}');
        return r5.toString();
    L32:
        if (r4.isEmpty() == true) goto L34;
        r0.append(", extraMap=");
        r0.append(this.extraMap);
        goto L34
    L11:
        if (r1.isEmpty() == true) goto L13;
        r0.append(", headerParams=");
        r0.append(this.headerParams);
        goto L13
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m124newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof OnePartyCommonNetworkRequest) == true) goto L8;
        return false;
    L8:
        OnePartyCommonNetworkRequest r6 = (OnePartyCommonNetworkRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L29:
        return false;
    L11:
        if (Internal.equals(this.path, r6.path) == false) goto L29;
        if (Internal.equals(this.host, r6.host) == false) goto L29;
        if (this.method.equals(r6.method) == false) goto L29;
        if (this.headerParams.equals(r6.headerParams) == false) goto L29;
        if (this.queryParams.equals(r6.queryParams) == false) goto L29;
        if (Internal.equals(this.body, r6.body) == false) goto L29;
        if (this.fieldMap.equals(r6.fieldMap) == false) goto L29;
        if (Internal.equals(this.addCommonParam, r6.addCommonParam) == false) goto L29;
        if (this.extraMap.equals(r6.extraMap) == false) goto L29;
        return true;
    }

    public OnePartyCommonNetworkRequest(String r12, String r13, NETWORK_METHOD r14, Map<String, String> r15, Map<String, String> r16, ByteString r17, Map<String, String> r18, Boolean r19, Map<String, String> r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public OnePartyCommonNetworkRequest(String r2, String r3, NETWORK_METHOD r4, Map<String, String> r5, Map<String, String> r6, ByteString r7, Map<String, String> r8, Boolean r9, Map<String, String> r10, ByteString r11) {
        super(ADAPTER, r11);
        this.path = r2;
        this.host = r3;
        this.method = r4;
        this.headerParams = Internal.immutableCopyOf("headerParams", r5);
        this.queryParams = Internal.immutableCopyOf("queryParams", r6);
        this.body = r7;
        this.fieldMap = Internal.immutableCopyOf("fieldMap", r8);
        this.addCommonParam = r9;
        this.extraMap = Internal.immutableCopyOf("extraMap", r10);
    }
}
