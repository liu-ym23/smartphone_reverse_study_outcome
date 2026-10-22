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
public final class Request extends Message<Request, a> {
    public static final ProtoAdapter<Request> ADAPTER = null;
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final String DEFAULT_APPKEY = "";
    public static final String DEFAULT_APPPKG = "";
    public static final String DEFAULT_APPVERSIONCODE = "";
    public static final String DEFAULT_CHANNEL = "";
    public static final Integer DEFAULT_CMD = null;
    public static final String DEFAULT_DEVICEID = "";
    public static final String DEFAULT_SDKVERSION = "";
    public static final String DEFAULT_SEQUENCEID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String accessToken;

    @SerializedName("appKey")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String appKey;

    @SerializedName("appPkg")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String appPkg;

    @SerializedName("appVersionCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String appVersionCode;

    @SerializedName("body")
    @WireField(adapter = "com.obric.matrix.proto.RequestBody#ADAPTER", tag = 11)
    public final RequestBody body;

    @SerializedName("channel")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String channel;

    @SerializedName("cmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer cmd;

    @SerializedName("deviceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String deviceId;

    @SerializedName("extraParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final Map<String, String> extraParams;

    @SerializedName("monitorInfo")
    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 13)
    public final MonitorInfo monitorInfo;

    @SerializedName("sdkVersion")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String sdkVersion;

    @SerializedName("sequenceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String sequenceId;

    public static final class a extends Message.Builder<Request, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f8202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8203b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public Map<String, String> h;
        public String i;
        public RequestBody j;
        public String k;
        public MonitorInfo l;

        public a() {
            this.f8202a = 0;
            this.f8203b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.i = "";
            this.k = "";
            this.h = Internal.newMutableMap();
        }

        public a a(MonitorInfo r1) {
            this.l = r1;
            return this;
        }

        public a a(RequestBody r1) {
            this.j = r1;
            return this;
        }

        public a a(Integer r1) {
            this.f8202a = r1;
            return this;
        }

        public a a(String r1) {
            this.f8203b = r1;
            return this;
        }

        public Request a() {
            return new Request(this.f8202a, this.f8203b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, super.buildUnknownFields());
        }

        public a b(String r1) {
            this.c = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a c(String r1) {
            this.d = r1;
            return this;
        }

        public a d(String r1) {
            this.e = r1;
            return this;
        }

        public a e(String r1) {
            this.f = r1;
            return this;
        }

        public a f(String r1) {
            this.g = r1;
            return this;
        }

        public a g(String r1) {
            this.i = r1;
            return this;
        }

        public a h(String r1) {
            this.k = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<Request> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8204a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, Request.class);
            this.f8204a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(Request r5) {
            return (((((((((((ProtoAdapter.INT32.encodedSizeWithTag(1, r5.cmd) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.sequenceId)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r5.sdkVersion)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r5.appKey)) + ProtoAdapter.STRING.encodedSizeWithTag(5, r5.deviceId)) + ProtoAdapter.STRING.encodedSizeWithTag(6, r5.channel)) + ProtoAdapter.STRING.encodedSizeWithTag(7, r5.appVersionCode)) + this.f8204a.encodedSizeWithTag(9, r5.extraParams)) + ProtoAdapter.STRING.encodedSizeWithTag(10, r5.appPkg)) + RequestBody.ADAPTER.encodedSizeWithTag(11, r5.body)) + ProtoAdapter.STRING.encodedSizeWithTag(12, r5.accessToken)) + MonitorInfo.ADAPTER.encodedSizeWithTag(13, r5.monitorInfo)) + r5.unknownFields().size();
        }

        public Request a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L20;
            switch(r3) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L7;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r0.a((MonitorInfo) ZeusTransformUtils.preCheckCast(MonitorInfo.ADAPTER.decode(r8), MonitorInfo.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            r0.h((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            r0.a((RequestBody) ZeusTransformUtils.preCheckCast(RequestBody.ADAPTER.decode(r8), RequestBody.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            r0.g((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            r0.h.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8204a.decode(r8), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L13:
            r0.f((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L14:
            r0.e((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L15:
            r0.d((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L16:
            r0.c((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L17:
            r0.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L18:
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L19:
            r0.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L20:
            r8.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, Request r5) {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.cmd);
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.sequenceId);
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r5.sdkVersion);
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r5.appKey);
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r5.deviceId);
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r5.channel);
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r5.appVersionCode);
            this.f8204a.encodeWithTag(r4, 9, r5.extraParams);
            ProtoAdapter.STRING.encodeWithTag(r4, 10, r5.appPkg);
            RequestBody.ADAPTER.encodeWithTag(r4, 11, r5.body);
            ProtoAdapter.STRING.encodeWithTag(r4, 12, r5.accessToken);
            MonitorInfo.ADAPTER.encodeWithTag(r4, 13, r5.monitorInfo);
            r4.writeBytes(r5.unknownFields());
        }

        public Request b(Request r3) {
            a r2 = r3.newBuilder();
            if (r2.j == null) goto L6;
            r2.j = (RequestBody) ZeusTransformUtils.preCheckCast(RequestBody.ADAPTER.redact(r2.j), RequestBody.class, "com.obric.memorydata.plugin");
        L6:
            if (r2.l == null) goto L8;
            r2.l = (MonitorInfo) ZeusTransformUtils.preCheckCast(MonitorInfo.ADAPTER.redact(r2.l), MonitorInfo.class, "com.obric.memorydata.plugin");
        L8:
            r2.clearUnknownFields();
            return r2.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Request decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, Request r4) {
            a(r3, (Request) ZeusTransformUtils.preCheckCast(r4, Request.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(Request r3) {
            return a((Request) ZeusTransformUtils.preCheckCast(r3, Request.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Request redact(Request r3) {
            return b((Request) ZeusTransformUtils.preCheckCast(r3, Request.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_CMD = 0;
    }

    public Request(Integer r16, String r17, String r18, String r19, String r20, String r21, String r22, Map<String, String> r23, String r24, RequestBody r25, String r26, MonitorInfo r27) {
        this(r16, r17, r18, r19, r20, r21, r22, (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin"), r24, r25, r26, r27, ByteString.EMPTY);
    }

    public Request(Integer r3, String r4, String r5, String r6, String r7, String r8, String r9, Map<String, String> r10, String r11, RequestBody r12, String r13, MonitorInfo r14, ByteString r15) {
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r15);
        this.cmd = r3;
        this.sequenceId = r4;
        this.sdkVersion = r5;
        this.appKey = r6;
        this.deviceId = r7;
        this.channel = r8;
        this.appVersionCode = r9;
        this.extraParams = Internal.immutableCopyOf("extraParams", r16);
        this.appPkg = r11;
        this.body = r12;
        this.accessToken = r13;
        this.monitorInfo = r14;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Request.class) == true) goto L8;
        return false;
    L8:
        Request r6 = (Request) ZeusTransformUtils.preCheckCast(r5, Request.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L36;
        if (Internal.equals(this.cmd, r6.cmd) == false) goto L36;
        if (Internal.equals(this.sequenceId, r6.sequenceId) == false) goto L36;
        if (Internal.equals(this.sdkVersion, r6.sdkVersion) == false) goto L36;
        if (Internal.equals(this.appKey, r6.appKey) == false) goto L36;
        if (Internal.equals(this.deviceId, r6.deviceId) == false) goto L36;
        if (Internal.equals(this.channel, r6.channel) == false) goto L36;
        if (Internal.equals(this.appVersionCode, r6.appVersionCode) == false) goto L36;
        if (this.extraParams.equals(r6.extraParams) == false) goto L36;
        if (Internal.equals(this.appPkg, r6.appPkg) == false) goto L36;
        if (Internal.equals(this.body, r6.body) == false) goto L36;
        if (Internal.equals(this.accessToken, r6.accessToken) == false) goto L36;
        if (Internal.equals(this.monitorInfo, r6.monitorInfo) == false) goto L36;
        return true;
    L36:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L49;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.cmd;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.sequenceId;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.sdkVersion;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.appKey;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.deviceId;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.channel;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.appVersionCode;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (((r20 + r22) * 37) + this.extraParams.hashCode()) * 37;
        String r24 = this.appPkg;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        RequestBody r27 = this.body;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        String r30 = this.accessToken;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        MonitorInfo r33 = this.monitorInfo;
        if (r33 == null) goto L47;
        r3 = r33.hashCode();
    L47:
        int r34 = r32 + r3;
        this.hashCode = r34;
        return r34;
    L43:
        r31 = 0;
        goto L44
    L39:
        r28 = 0;
        goto L40
    L35:
        r25 = 0;
        goto L36
    L31:
        r22 = 0;
        goto L32
    L27:
        r19 = 0;
        goto L28
    L23:
        r16 = 0;
        goto L24
    L19:
        r13 = 0;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L49:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8202a = this.cmd;
        r0.f8203b = this.sequenceId;
        r0.c = this.sdkVersion;
        r0.d = this.appKey;
        r0.e = this.deviceId;
        r0.f = this.channel;
        r0.g = this.appVersionCode;
        r0.h = Internal.copyOf("extraParams", this.extraParams);
        r0.i = this.appPkg;
        r0.j = this.body;
        r0.k = this.accessToken;
        r0.l = this.monitorInfo;
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
        if (this.cmd == null) goto L6;
        r0.append(", cmd=").append(this.cmd);
    L6:
        if (this.sequenceId == null) goto L9;
        r0.append(", sequenceId=").append(this.sequenceId);
    L9:
        if (this.sdkVersion == null) goto L12;
        r0.append(", sdkVersion=").append(this.sdkVersion);
    L12:
        if (this.appKey == null) goto L15;
        r0.append(", appKey=").append(this.appKey);
    L15:
        if (this.deviceId == null) goto L18;
        r0.append(", deviceId=").append(this.deviceId);
    L18:
        if (this.channel == null) goto L21;
        r0.append(", channel=").append(this.channel);
    L21:
        if (this.appVersionCode == null) goto L23;
        r0.append(", appVersionCode=").append(this.appVersionCode);
    L23:
        Map<String, String> r1 = this.extraParams;
        if (r1 == null) goto L29;
        if (r1.isEmpty() == true) goto L29;
        r0.append(", extraParams=").append(this.extraParams);
    L29:
        if (this.appPkg == null) goto L32;
        r0.append(", appPkg=").append(this.appPkg);
    L32:
        if (this.body == null) goto L35;
        r0.append(", body=").append(this.body);
    L35:
        if (this.accessToken == null) goto L38;
        r0.append(", accessToken=").append(this.accessToken);
    L38:
        if (this.monitorInfo == null) goto L41;
        r0.append(", monitorInfo=").append(this.monitorInfo);
    L41:
        return r0.replace(0, 2, "Request{").append('}').toString();
    }
}
