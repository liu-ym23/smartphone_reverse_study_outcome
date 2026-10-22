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
public final class OnePartyCommonNetworkRequest extends Message<OnePartyCommonNetworkRequest, a> {
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

    public static final class a extends Message.Builder<OnePartyCommonNetworkRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8184b;
        public NETWORK_METHOD c;
        public Map<String, String> d;
        public Map<String, String> e;
        public ByteString f;
        public Map<String, String> g;
        public Boolean h;
        public Map<String, String> i;

        public a() {
            this.f8183a = "";
            this.f8184b = "";
            this.c = NETWORK_METHOD.METHOD_GET;
            this.f = ByteString.EMPTY;
            this.h = false;
            this.d = Internal.newMutableMap();
            this.e = Internal.newMutableMap();
            this.g = Internal.newMutableMap();
            this.i = Internal.newMutableMap();
        }

        public a a(NETWORK_METHOD r1) {
            this.c = r1;
            return this;
        }

        public a a(Boolean r1) {
            this.h = r1;
            return this;
        }

        public a a(String r1) {
            this.f8183a = r1;
            return this;
        }

        public a a(ByteString r1) {
            this.f = r1;
            return this;
        }

        public OnePartyCommonNetworkRequest a() {
            NETWORK_METHOD r0 = this.c;
            if (r0 == null) goto L7;
            return new OnePartyCommonNetworkRequest(this.f8183a, this.f8184b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "method"});
        }

        public a b(String r1) {
            this.f8184b = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<OnePartyCommonNetworkRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8186b;
        private final ProtoAdapter<Map<String, String>> c;
        private final ProtoAdapter<Map<String, String>> d;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, OnePartyCommonNetworkRequest.class);
            this.f8185a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
            this.f8186b = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
            this.c = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
            this.d = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(OnePartyCommonNetworkRequest r5) {
            return ((((((((ProtoAdapter.STRING.encodedSizeWithTag(1, r5.path) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.host)) + NETWORK_METHOD.ADAPTER.encodedSizeWithTag(3, r5.method)) + this.f8185a.encodedSizeWithTag(4, r5.headerParams)) + this.f8186b.encodedSizeWithTag(5, r5.queryParams)) + ProtoAdapter.BYTES.encodedSizeWithTag(6, r5.body)) + this.c.encodedSizeWithTag(7, r5.fieldMap)) + ProtoAdapter.BOOL.encodedSizeWithTag(8, r5.addCommonParam)) + this.d.encodedSizeWithTag(9, r5.extraMap)) + r5.unknownFields().size();
        }

        public OnePartyCommonNetworkRequest a(ProtoReader r9) {
            a r0 = new a();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            switch(r3) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L23;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                default: goto L7;
            };
        L23:
            r0.a((NETWORK_METHOD) ZeusTransformUtils.preCheckCast(NETWORK_METHOD.ADAPTER.decode(r9), NETWORK_METHOD.class, "com.obric.memorydata.plugin"));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            Map<String, String> r4 = r0.i;
            ProtoAdapter<Map<String, String>> r5 = this.d;
        L14:
            r4.putAll((Map) ZeusTransformUtils.preCheckCast(r5.decode(r9), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            r0.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r9), Boolean.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            r4 = r0.g;
            r5 = this.c;
            goto L14
        L11:
            r0.a((ByteString) ZeusTransformUtils.preCheckCast(ProtoAdapter.BYTES.decode(r9), ByteString.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            r4 = r0.e;
            r5 = this.f8186b;
            goto L14
        L13:
            r4 = r0.d;
            r5 = this.f8185a;
            goto L14
        L19:
            r0.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r9), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L20:
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r9), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r6 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r6, r6.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, OnePartyCommonNetworkRequest r5) {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.path);
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.host);
            NETWORK_METHOD.ADAPTER.encodeWithTag(r4, 3, r5.method);
            this.f8185a.encodeWithTag(r4, 4, r5.headerParams);
            this.f8186b.encodeWithTag(r4, 5, r5.queryParams);
            ProtoAdapter.BYTES.encodeWithTag(r4, 6, r5.body);
            this.c.encodeWithTag(r4, 7, r5.fieldMap);
            ProtoAdapter.BOOL.encodeWithTag(r4, 8, r5.addCommonParam);
            this.d.encodeWithTag(r4, 9, r5.extraMap);
            r4.writeBytes(r5.unknownFields());
        }

        public OnePartyCommonNetworkRequest b(OnePartyCommonNetworkRequest r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ OnePartyCommonNetworkRequest decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, OnePartyCommonNetworkRequest r4) {
            a(r3, (OnePartyCommonNetworkRequest) ZeusTransformUtils.preCheckCast(r4, OnePartyCommonNetworkRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(OnePartyCommonNetworkRequest r3) {
            return a((OnePartyCommonNetworkRequest) ZeusTransformUtils.preCheckCast(r3, OnePartyCommonNetworkRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ OnePartyCommonNetworkRequest redact(OnePartyCommonNetworkRequest r3) {
            return b((OnePartyCommonNetworkRequest) ZeusTransformUtils.preCheckCast(r3, OnePartyCommonNetworkRequest.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_METHOD = NETWORK_METHOD.METHOD_GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_ADDCOMMONPARAM = false;
    }

    public OnePartyCommonNetworkRequest(String r14, String r15, NETWORK_METHOD r16, Map<String, String> r17, Map<String, String> r18, ByteString r19, Map<String, String> r20, Boolean r21, Map<String, String> r22) {
        this(r14, r15, r16, (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin"), r19, (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin"), r21, (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public OnePartyCommonNetworkRequest(String r3, String r4, NETWORK_METHOD r5, Map<String, String> r6, Map<String, String> r7, ByteString r8, Map<String, String> r9, Boolean r10, Map<String, String> r11, ByteString r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r12);
        this.path = r3;
        this.host = r4;
        this.method = r5;
        this.headerParams = Internal.immutableCopyOf("headerParams", r13);
        this.queryParams = Internal.immutableCopyOf("queryParams", r14);
        this.body = r8;
        this.fieldMap = Internal.immutableCopyOf("fieldMap", r15);
        this.addCommonParam = r10;
        this.extraMap = Internal.immutableCopyOf("extraMap", r16);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OnePartyCommonNetworkRequest.class) == true) goto L8;
        return false;
    L8:
        OnePartyCommonNetworkRequest r6 = (OnePartyCommonNetworkRequest) ZeusTransformUtils.preCheckCast(r5, OnePartyCommonNetworkRequest.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L30;
        if (Internal.equals(this.path, r6.path) == false) goto L30;
        if (Internal.equals(this.host, r6.host) == false) goto L30;
        if (this.method.equals(r6.method) == false) goto L30;
        if (this.headerParams.equals(r6.headerParams) == false) goto L30;
        if (this.queryParams.equals(r6.queryParams) == false) goto L30;
        if (Internal.equals(this.body, r6.body) == false) goto L30;
        if (this.fieldMap.equals(r6.fieldMap) == false) goto L30;
        if (Internal.equals(this.addCommonParam, r6.addCommonParam) == false) goto L30;
        if (this.extraMap.equals(r6.extraMap) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
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
        this.hashCode = r13;
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

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8183a = this.path;
        r0.f8184b = this.host;
        r0.c = this.method;
        r0.d = Internal.copyOf("headerParams", this.headerParams);
        r0.e = Internal.copyOf("queryParams", this.queryParams);
        r0.f = this.body;
        r0.g = Internal.copyOf("fieldMap", this.fieldMap);
        r0.h = this.addCommonParam;
        r0.i = Internal.copyOf("extraMap", this.extraMap);
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
        if (this.path == null) goto L6;
        r0.append(", path=").append(this.path);
    L6:
        if (this.host == null) goto L8;
        r0.append(", host=").append(this.host);
    L8:
        r0.append(", method=").append(this.method);
        Map<String, String> r1 = this.headerParams;
        if (r1 != null) goto L11;
    L13:
        Map<String, String> r2 = this.queryParams;
        if (r2 == null) goto L19;
        if (r2.isEmpty() == true) goto L19;
        r0.append(", queryParams=").append(this.queryParams);
    L19:
        if (this.body == null) goto L21;
        r0.append(", body=").append(this.body);
    L21:
        Map<String, String> r3 = this.fieldMap;
        if (r3 == null) goto L27;
        if (r3.isEmpty() == true) goto L27;
        r0.append(", fieldMap=").append(this.fieldMap);
    L27:
        if (this.addCommonParam == null) goto L29;
        r0.append(", addCommonParam=").append(this.addCommonParam);
    L29:
        Map<String, String> r4 = this.extraMap;
        if (r4 == null) goto L35;
        if (r4.isEmpty() == true) goto L35;
        r0.append(", extraMap=").append(this.extraMap);
    L35:
        return r0.replace(0, 2, "OnePartyCommonNetworkRequest{").append('}').toString();
    L11:
        if (r1.isEmpty() == true) goto L13;
        r0.append(", headerParams=").append(this.headerParams);
        goto L13
    }
}
