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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class GenericNetworkRequest extends Message<GenericNetworkRequest, a> {
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

    public static final class a extends Message.Builder<GenericNetworkRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public NETWORK_METHOD f8163b;
        public Map<String, String> c;
        public Map<String, String> d;
        public ByteString e;
        public Boolean f;
        public String g;

        public a() {
            this.f8162a = "";
            this.f8163b = NETWORK_METHOD.METHOD_GET;
            this.e = ByteString.EMPTY;
            this.f = false;
            this.g = "";
            this.c = Internal.newMutableMap();
            this.d = Internal.newMutableMap();
        }

        public a a(NETWORK_METHOD r1) {
            this.f8163b = r1;
            return this;
        }

        public a a(Boolean r1) {
            this.f = r1;
            return this;
        }

        public a a(String r1) {
            this.f8162a = r1;
            return this;
        }

        public a a(ByteString r1) {
            this.e = r1;
            return this;
        }

        public GenericNetworkRequest a() {
            String r0 = this.f8162a;
            if (r0 == null) goto L9;
            if (this.f8163b == null) goto L9;
            return new GenericNetworkRequest(this.f8162a, this.f8163b, this.c, this.d, this.e, this.f, this.g, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "path", this.f8163b, "method"});
        }

        public a b(String r1) {
            this.g = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<GenericNetworkRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8165b;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, GenericNetworkRequest.class);
            this.f8164a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
            this.f8165b = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(GenericNetworkRequest r5) {
            return ((((((ProtoAdapter.STRING.encodedSizeWithTag(1, r5.path) + NETWORK_METHOD.ADAPTER.encodedSizeWithTag(2, r5.method)) + this.f8164a.encodedSizeWithTag(3, r5.headerParams)) + this.f8165b.encodedSizeWithTag(4, r5.queryParams)) + ProtoAdapter.BYTES.encodedSizeWithTag(5, r5.body)) + ProtoAdapter.BOOL.encodedSizeWithTag(6, r5.needAccessToken)) + ProtoAdapter.STRING.encodedSizeWithTag(7, r5.accessToken)) + r5.unknownFields().size();
        }

        public GenericNetworkRequest a(ProtoReader r9) {
            a r0 = new a();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L19;
            switch(r3) {
                case 1: goto L18;
                case 2: goto L21;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                default: goto L7;
            };
        L21:
            r0.a((NETWORK_METHOD) ZeusTransformUtils.preCheckCast(NETWORK_METHOD.ADAPTER.decode(r9), NETWORK_METHOD.class, "com.obric.memorydata.plugin"));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            r0.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r9), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            r0.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r9), Boolean.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            r0.a((ByteString) ZeusTransformUtils.preCheckCast(ProtoAdapter.BYTES.decode(r9), ByteString.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            Map<String, String> r4 = r0.d;
            ProtoAdapter<Map<String, String>> r5 = this.f8165b;
        L13:
            r4.putAll((Map) ZeusTransformUtils.preCheckCast(r5.decode(r9), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            r4 = r0.c;
            r5 = this.f8164a;
            goto L13
        L18:
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r9), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r6 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r6, r6.rawProtoAdapter().decode(r9));
            goto L3
        L19:
            r9.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, GenericNetworkRequest r5) {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.path);
            NETWORK_METHOD.ADAPTER.encodeWithTag(r4, 2, r5.method);
            this.f8164a.encodeWithTag(r4, 3, r5.headerParams);
            this.f8165b.encodeWithTag(r4, 4, r5.queryParams);
            ProtoAdapter.BYTES.encodeWithTag(r4, 5, r5.body);
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r5.needAccessToken);
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r5.accessToken);
            r4.writeBytes(r5.unknownFields());
        }

        public GenericNetworkRequest b(GenericNetworkRequest r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ GenericNetworkRequest decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, GenericNetworkRequest r4) {
            a(r3, (GenericNetworkRequest) ZeusTransformUtils.preCheckCast(r4, GenericNetworkRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(GenericNetworkRequest r3) {
            return a((GenericNetworkRequest) ZeusTransformUtils.preCheckCast(r3, GenericNetworkRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ GenericNetworkRequest redact(GenericNetworkRequest r3) {
            return b((GenericNetworkRequest) ZeusTransformUtils.preCheckCast(r3, GenericNetworkRequest.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_METHOD = NETWORK_METHOD.METHOD_GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_NEEDACCESSTOKEN = false;
    }

    public GenericNetworkRequest(String r12, NETWORK_METHOD r13, Map<String, String> r14, Map<String, String> r15, ByteString r16, Boolean r17, String r18) {
        this(r12, r13, (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin"), r16, r17, r18, ByteString.EMPTY);
    }

    public GenericNetworkRequest(String r3, NETWORK_METHOD r4, Map<String, String> r5, Map<String, String> r6, ByteString r7, Boolean r8, String r9, ByteString r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r10);
        this.path = r3;
        this.method = r4;
        this.headerParams = Internal.immutableCopyOf("headerParams", r11);
        this.queryParams = Internal.immutableCopyOf("queryParams", r12);
        this.body = r7;
        this.needAccessToken = r8;
        this.accessToken = r9;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GenericNetworkRequest.class) == true) goto L8;
        return false;
    L8:
        GenericNetworkRequest r6 = (GenericNetworkRequest) ZeusTransformUtils.preCheckCast(r5, GenericNetworkRequest.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L26;
        if (this.path.equals(r6.path) == false) goto L26;
        if (this.method.equals(r6.method) == false) goto L26;
        if (this.headerParams.equals(r6.headerParams) == false) goto L26;
        if (this.queryParams.equals(r6.queryParams) == false) goto L26;
        if (Internal.equals(this.body, r6.body) == false) goto L26;
        if (Internal.equals(this.needAccessToken, r6.needAccessToken) == false) goto L26;
        if (Internal.equals(this.accessToken, r6.accessToken) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
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
        this.hashCode = r10;
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

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8162a = this.path;
        r0.f8163b = this.method;
        r0.c = Internal.copyOf("headerParams", this.headerParams);
        r0.d = Internal.copyOf("queryParams", this.queryParams);
        r0.e = this.body;
        r0.f = this.needAccessToken;
        r0.g = this.accessToken;
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
        r0.append(", path=").append(this.path);
        r0.append(", method=").append(this.method);
        Map<String, String> r1 = this.headerParams;
        if (r1 != null) goto L5;
    L7:
        Map<String, String> r2 = this.queryParams;
        if (r2 == null) goto L13;
        if (r2.isEmpty() == true) goto L13;
        r0.append(", queryParams=").append(this.queryParams);
    L13:
        if (this.body == null) goto L16;
        r0.append(", body=").append(this.body);
    L16:
        if (this.needAccessToken == null) goto L19;
        r0.append(", needAccessToken=").append(this.needAccessToken);
    L19:
        if (this.accessToken == null) goto L22;
        r0.append(", accessToken=").append(this.accessToken);
    L22:
        return r0.replace(0, 2, "GenericNetworkRequest{").append('}').toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", headerParams=").append(this.headerParams);
        goto L7
    }
}
