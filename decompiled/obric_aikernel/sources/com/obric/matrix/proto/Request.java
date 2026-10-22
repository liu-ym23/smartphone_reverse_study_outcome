package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import d6.c;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
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

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    @c("accessToken")
    public final String accessToken;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @c("appKey")
    public final String appKey;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    @c("appPkg")
    public final String appPkg;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @c("appVersionCode")
    public final String appVersionCode;

    @WireField(adapter = "com.obric.matrix.proto.RequestBody#ADAPTER", tag = 11)
    @c("body")
    public final RequestBody body;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @c("channel")
    public final String channel;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @c("cmd")
    public final Integer cmd;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @c("deviceId")
    public final String deviceId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @c("extraParams")
    public final Map<String, String> extraParams;

    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 13)
    @c("monitorInfo")
    public final MonitorInfo monitorInfo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @c("sdkVersion")
    public final String sdkVersion;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @c("sequenceId")
    public final String sequenceId;

    public static final class a extends Message.Builder<Request, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f6016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f6018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f6019d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f6020e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f6021f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f6022g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Map<String, String> f6023h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f6024i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public RequestBody f6025j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f6026k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public MonitorInfo f6027l;

        public a() {
            this.f6016a = 0;
            this.f6017b = "";
            this.f6018c = "";
            this.f6019d = "";
            this.f6020e = "";
            this.f6021f = "";
            this.f6022g = "";
            this.f6024i = "";
            this.f6026k = "";
            this.f6023h = Internal.newMutableMap();
        }

        public a a(String r10) {
            this.f6026k = r10;
            return this;
        }

        public a b(String r10) {
            this.f6019d = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return f();
        }

        public a c(String r10) {
            this.f6024i = r10;
            return this;
        }

        public a d(String r10) {
            this.f6022g = r10;
            return this;
        }

        public a e(RequestBody r10) {
            this.f6025j = r10;
            return this;
        }

        public Request f() {
            return new Request(this.f6016a, this.f6017b, this.f6018c, this.f6019d, this.f6020e, this.f6021f, this.f6022g, this.f6023h, this.f6024i, this.f6025j, this.f6026k, this.f6027l, super.buildUnknownFields());
        }

        public a g(String r10) {
            this.f6021f = r10;
            return this;
        }

        public a h(Integer r10) {
            this.f6016a = r10;
            return this;
        }

        public a i(String r10) {
            this.f6020e = r10;
            return this;
        }

        public a j(MonitorInfo r10) {
            this.f6027l = r10;
            return this;
        }

        public a k(String r10) {
            this.f6018c = r10;
            return this;
        }

        public a l(String r10) {
            this.f6017b = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<Request> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f6028a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, Request.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f6028a = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public Request a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L19;
            switch(r13) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L6;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L7:
            r11.j(MonitorInfo.ADAPTER.decode(r10));
            goto L3
        L8:
            r11.a(ProtoAdapter.STRING.decode(r10));
            goto L3
        L9:
            r11.e(RequestBody.ADAPTER.decode(r10));
            goto L3
        L10:
            r11.c(ProtoAdapter.STRING.decode(r10));
            goto L3
        L11:
            r11.f6023h.putAll(this.f6028a.decode(r10));
            goto L3
        L12:
            r11.d(ProtoAdapter.STRING.decode(r10));
            goto L3
        L13:
            r11.g(ProtoAdapter.STRING.decode(r10));
            goto L3
        L14:
            r11.i(ProtoAdapter.STRING.decode(r10));
            goto L3
        L15:
            r11.b(ProtoAdapter.STRING.decode(r10));
            goto L3
        L16:
            r11.k(ProtoAdapter.STRING.decode(r10));
            goto L3
        L17:
            r11.l(ProtoAdapter.STRING.decode(r10));
            goto L3
        L18:
            r11.h(ProtoAdapter.INT32.decode(r10));
            goto L3
        L6:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L19:
            r10.endMessage(r12);
            return r11.f();
        }

        public void b(ProtoWriter r10, Request r11) {
            ProtoAdapter.INT32.encodeWithTag(r10, 1, r11.cmd);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            r12.encodeWithTag(r10, 2, r11.sequenceId);
            r12.encodeWithTag(r10, 3, r11.sdkVersion);
            r12.encodeWithTag(r10, 4, r11.appKey);
            r12.encodeWithTag(r10, 5, r11.deviceId);
            r12.encodeWithTag(r10, 6, r11.channel);
            r12.encodeWithTag(r10, 7, r11.appVersionCode);
            this.f6028a.encodeWithTag(r10, 9, r11.extraParams);
            r12.encodeWithTag(r10, 10, r11.appPkg);
            RequestBody.ADAPTER.encodeWithTag(r10, 11, r11.body);
            r12.encodeWithTag(r10, 12, r11.accessToken);
            MonitorInfo.ADAPTER.encodeWithTag(r10, 13, r11.monitorInfo);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(Request r10) {
            int r11 = ProtoAdapter.INT32.encodedSizeWithTag(1, r10.cmd);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            return (((((((((((r11 + r12.encodedSizeWithTag(2, r10.sequenceId)) + r12.encodedSizeWithTag(3, r10.sdkVersion)) + r12.encodedSizeWithTag(4, r10.appKey)) + r12.encodedSizeWithTag(5, r10.deviceId)) + r12.encodedSizeWithTag(6, r10.channel)) + r12.encodedSizeWithTag(7, r10.appVersionCode)) + this.f6028a.encodedSizeWithTag(9, r10.extraParams)) + r12.encodedSizeWithTag(10, r10.appPkg)) + RequestBody.ADAPTER.encodedSizeWithTag(11, r10.body)) + r12.encodedSizeWithTag(12, r10.accessToken)) + MonitorInfo.ADAPTER.encodedSizeWithTag(13, r10.monitorInfo)) + r10.unknownFields().size();
        }

        public Request d(Request r10) {
            a r11 = r10.newBuilder();
            RequestBody r12 = r11.f6025j;
            if (r12 == null) goto L5;
            r11.f6025j = RequestBody.ADAPTER.redact(r12);
        L5:
            MonitorInfo r13 = r11.f6027l;
            if (r13 == null) goto L8;
            r11.f6027l = MonitorInfo.ADAPTER.redact(r13);
        L8:
            r11.clearUnknownFields();
            return r11.f();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Request decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Request r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Request r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Request redact(Request r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_CMD = 0;
    }

    public Request(Integer r15, String r16, String r17, String r18, String r19, String r20, String r21, Map<String, String> r22, String r23, RequestBody r24, String r25, MonitorInfo r26) {
        this(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, ByteString.EMPTY);
    }

    public Request(Integer r10, String r11, String r12, String r13, String r14, String r15, String r16, Map<String, String> r17, String r18, RequestBody r19, String r110, MonitorInfo r111, ByteString r112) {
        super(ADAPTER, r112);
        this.cmd = r10;
        this.sequenceId = r11;
        this.sdkVersion = r12;
        this.appKey = r13;
        this.deviceId = r14;
        this.channel = r15;
        this.appVersionCode = r16;
        this.extraParams = Internal.immutableCopyOf("extraParams", r17);
        this.appPkg = r18;
        this.body = r19;
        this.accessToken = r110;
        this.monitorInfo = r111;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Request) == true) goto L8;
        return false;
    L8:
        Request r11 = (Request) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L36;
        if (Internal.equals(this.cmd, r11.cmd) == false) goto L36;
        if (Internal.equals(this.sequenceId, r11.sequenceId) == false) goto L36;
        if (Internal.equals(this.sdkVersion, r11.sdkVersion) == false) goto L36;
        if (Internal.equals(this.appKey, r11.appKey) == false) goto L36;
        if (Internal.equals(this.deviceId, r11.deviceId) == false) goto L36;
        if (Internal.equals(this.channel, r11.channel) == false) goto L36;
        if (Internal.equals(this.appVersionCode, r11.appVersionCode) == false) goto L36;
        if (this.extraParams.equals(r11.extraParams) == false) goto L36;
        if (Internal.equals(this.appPkg, r11.appPkg) == false) goto L36;
        if (Internal.equals(this.body, r11.body) == false) goto L36;
        if (Internal.equals(this.accessToken, r11.accessToken) == false) goto L36;
        if (Internal.equals(this.monitorInfo, r11.monitorInfo) == false) goto L36;
        return true;
    L36:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L49;
        int r11 = unknownFields().hashCode() * 37;
        Integer r12 = this.cmd;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        String r16 = this.sequenceId;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        String r19 = this.sdkVersion;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (r18 + r20) * 37;
        String r22 = this.appKey;
        if (r22 == null) goto L19;
        int r23 = r22.hashCode();
    L20:
        int r24 = (r21 + r23) * 37;
        String r25 = this.deviceId;
        if (r25 == null) goto L23;
        int r26 = r25.hashCode();
    L24:
        int r27 = (r24 + r26) * 37;
        String r28 = this.channel;
        if (r28 == null) goto L27;
        int r29 = r28.hashCode();
    L28:
        int r30 = (r27 + r29) * 37;
        String r31 = this.appVersionCode;
        if (r31 == null) goto L31;
        int r32 = r31.hashCode();
    L32:
        int r33 = (((r30 + r32) * 37) + this.extraParams.hashCode()) * 37;
        String r34 = this.appPkg;
        if (r34 == null) goto L35;
        int r35 = r34.hashCode();
    L36:
        int r36 = (r33 + r35) * 37;
        RequestBody r37 = this.body;
        if (r37 == null) goto L39;
        int r38 = r37.hashCode();
    L40:
        int r39 = (r36 + r38) * 37;
        String r40 = this.accessToken;
        if (r40 == null) goto L43;
        int r41 = r40.hashCode();
    L44:
        int r42 = (r39 + r41) * 37;
        MonitorInfo r43 = this.monitorInfo;
        if (r43 == null) goto L47;
        r13 = r43.hashCode();
    L47:
        int r44 = r42 + r13;
        this.hashCode = r44;
        return r44;
    L43:
        r41 = 0;
        goto L44
    L39:
        r38 = 0;
        goto L40
    L35:
        r35 = 0;
        goto L36
    L31:
        r32 = 0;
        goto L32
    L27:
        r29 = 0;
        goto L28
    L23:
        r26 = 0;
        goto L24
    L19:
        r23 = 0;
        goto L20
    L15:
        r20 = 0;
        goto L16
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L49:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f6016a = this.cmd;
        r10.f6017b = this.sequenceId;
        r10.f6018c = this.sdkVersion;
        r10.f6019d = this.appKey;
        r10.f6020e = this.deviceId;
        r10.f6021f = this.channel;
        r10.f6022g = this.appVersionCode;
        r10.f6023h = Internal.copyOf("extraParams", this.extraParams);
        r10.f6024i = this.appPkg;
        r10.f6025j = this.body;
        r10.f6026k = this.accessToken;
        r10.f6027l = this.monitorInfo;
        r10.addUnknownFields(unknownFields());
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.cmd == null) goto L6;
        r10.append(", cmd=");
        r10.append(this.cmd);
    L6:
        if (this.sequenceId == null) goto L9;
        r10.append(", sequenceId=");
        r10.append(this.sequenceId);
    L9:
        if (this.sdkVersion == null) goto L12;
        r10.append(", sdkVersion=");
        r10.append(this.sdkVersion);
    L12:
        if (this.appKey == null) goto L15;
        r10.append(", appKey=");
        r10.append(this.appKey);
    L15:
        if (this.deviceId == null) goto L18;
        r10.append(", deviceId=");
        r10.append(this.deviceId);
    L18:
        if (this.channel == null) goto L21;
        r10.append(", channel=");
        r10.append(this.channel);
    L21:
        if (this.appVersionCode == null) goto L23;
        r10.append(", appVersionCode=");
        r10.append(this.appVersionCode);
    L23:
        Map<String, String> r11 = this.extraParams;
        if (r11 == null) goto L29;
        if (r11.isEmpty() == true) goto L29;
        r10.append(", extraParams=");
        r10.append(this.extraParams);
    L29:
        if (this.appPkg == null) goto L32;
        r10.append(", appPkg=");
        r10.append(this.appPkg);
    L32:
        if (this.body == null) goto L35;
        r10.append(", body=");
        r10.append(this.body);
    L35:
        if (this.accessToken == null) goto L38;
        r10.append(", accessToken=");
        r10.append(this.accessToken);
    L38:
        if (this.monitorInfo == null) goto L40;
        r10.append(", monitorInfo=");
        r10.append(this.monitorInfo);
    L40:
        StringBuilder r12 = r10.replace(0, 2, "Request{");
        r12.append('}');
        return r12.toString();
    }
}
