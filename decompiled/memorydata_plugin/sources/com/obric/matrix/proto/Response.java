package com.obric.matrix.proto;

import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
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
public final class Response extends Message<Response, a> {
    public static final ProtoAdapter<Response> ADAPTER = null;
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final Integer DEFAULT_CMD = null;
    public static final String DEFAULT_ERRORMSG = "";
    public static final String DEFAULT_LOGID = "";
    public static final String DEFAULT_SEQUENCEID = "";
    public static final Integer DEFAULT_STATUSCODE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String accessToken;

    @SerializedName("body")
    @WireField(adapter = "com.obric.matrix.proto.ResponseBody#ADAPTER", tag = 7)
    public final ResponseBody body;

    @SerializedName("cmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer cmd;

    @SerializedName(DTraitConstant.ERROR)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String errorMsg;

    @SerializedName("extraParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final Map<String, String> extraParams;

    @SerializedName("logId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String logId;

    @SerializedName("monitorInfo")
    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 9)
    public final MonitorInfo monitorInfo;

    @SerializedName("sequenceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String sequenceId;

    @SerializedName("statusCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer statusCode;

    public static final class a extends Message.Builder<Response, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f8207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f8208b;
        public String c;
        public String d;
        public String e;
        public ResponseBody f;
        public String g;
        public MonitorInfo h;
        public Map<String, String> i;

        public a() {
            this.f8207a = 0;
            this.f8208b = 0;
            this.c = "";
            this.d = "";
            this.e = "";
            this.g = "";
            this.i = Internal.newMutableMap();
        }

        public a a(MonitorInfo r1) {
            this.h = r1;
            return this;
        }

        public a a(ResponseBody r1) {
            this.f = r1;
            return this;
        }

        public a a(Integer r1) {
            this.f8207a = r1;
            return this;
        }

        public a a(String r1) {
            this.c = r1;
            return this;
        }

        public Response a() {
            return new Response(this.f8207a, this.f8208b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, super.buildUnknownFields());
        }

        public a b(Integer r1) {
            this.f8208b = r1;
            return this;
        }

        public a b(String r1) {
            this.d = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a c(String r1) {
            this.e = r1;
            return this;
        }

        public a d(String r1) {
            this.g = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<Response> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8209a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, Response.class);
            this.f8209a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(Response r5) {
            return ((((((((ProtoAdapter.INT32.encodedSizeWithTag(1, r5.cmd) + ProtoAdapter.INT32.encodedSizeWithTag(2, r5.statusCode)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r5.errorMsg)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r5.logId)) + ProtoAdapter.STRING.encodedSizeWithTag(6, r5.sequenceId)) + ResponseBody.ADAPTER.encodedSizeWithTag(7, r5.body)) + ProtoAdapter.STRING.encodedSizeWithTag(8, r5.accessToken)) + MonitorInfo.ADAPTER.encodedSizeWithTag(9, r5.monitorInfo)) + this.f8209a.encodedSizeWithTag(10, r5.extraParams)) + r5.unknownFields().size();
        }

        public Response a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L7;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                default: goto L7;
            };
        L8:
            r0.i.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8209a.decode(r8), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            r0.a((MonitorInfo) ZeusTransformUtils.preCheckCast(MonitorInfo.ADAPTER.decode(r8), MonitorInfo.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            r0.d((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            r0.a((ResponseBody) ZeusTransformUtils.preCheckCast(ResponseBody.ADAPTER.decode(r8), ResponseBody.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            r0.c((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L13:
            r0.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L14:
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L15:
            r0.b((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L16:
            r0.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L17:
            r8.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, Response r5) {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.cmd);
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r5.statusCode);
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r5.errorMsg);
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r5.logId);
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r5.sequenceId);
            ResponseBody.ADAPTER.encodeWithTag(r4, 7, r5.body);
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r5.accessToken);
            MonitorInfo.ADAPTER.encodeWithTag(r4, 9, r5.monitorInfo);
            this.f8209a.encodeWithTag(r4, 10, r5.extraParams);
            r4.writeBytes(r5.unknownFields());
        }

        public Response b(Response r3) {
            a r2 = r3.newBuilder();
            if (r2.f == null) goto L6;
            r2.f = (ResponseBody) ZeusTransformUtils.preCheckCast(ResponseBody.ADAPTER.redact(r2.f), ResponseBody.class, "com.obric.memorydata.plugin");
        L6:
            if (r2.h == null) goto L8;
            r2.h = (MonitorInfo) ZeusTransformUtils.preCheckCast(MonitorInfo.ADAPTER.redact(r2.h), MonitorInfo.class, "com.obric.memorydata.plugin");
        L8:
            r2.clearUnknownFields();
            return r2.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Response decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, Response r4) {
            a(r3, (Response) ZeusTransformUtils.preCheckCast(r4, Response.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(Response r3) {
            return a((Response) ZeusTransformUtils.preCheckCast(r3, Response.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Response redact(Response r3) {
            return b((Response) ZeusTransformUtils.preCheckCast(r3, Response.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_CMD = 0;
        DEFAULT_STATUSCODE = 0;
    }

    public Response(Integer r13, Integer r14, String r15, String r16, String r17, ResponseBody r18, String r19, MonitorInfo r20, Map<String, String> r21) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public Response(Integer r3, Integer r4, String r5, String r6, String r7, ResponseBody r8, String r9, MonitorInfo r10, Map<String, String> r11, ByteString r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r12);
        this.cmd = r3;
        this.statusCode = r4;
        this.errorMsg = r5;
        this.logId = r6;
        this.sequenceId = r7;
        this.body = r8;
        this.accessToken = r9;
        this.monitorInfo = r10;
        this.extraParams = Internal.immutableCopyOf("extraParams", r13);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Response.class) == true) goto L8;
        return false;
    L8:
        Response r6 = (Response) ZeusTransformUtils.preCheckCast(r5, Response.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L30;
        if (Internal.equals(this.cmd, r6.cmd) == false) goto L30;
        if (Internal.equals(this.statusCode, r6.statusCode) == false) goto L30;
        if (Internal.equals(this.errorMsg, r6.errorMsg) == false) goto L30;
        if (Internal.equals(this.logId, r6.logId) == false) goto L30;
        if (Internal.equals(this.sequenceId, r6.sequenceId) == false) goto L30;
        if (Internal.equals(this.body, r6.body) == false) goto L30;
        if (Internal.equals(this.accessToken, r6.accessToken) == false) goto L30;
        if (Internal.equals(this.monitorInfo, r6.monitorInfo) == false) goto L30;
        if (this.extraParams.equals(r6.extraParams) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L37;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.cmd;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.statusCode;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.errorMsg;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.logId;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.sequenceId;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        ResponseBody r18 = this.body;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.accessToken;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        MonitorInfo r24 = this.monitorInfo;
        if (r24 == null) goto L35;
        r3 = r24.hashCode();
    L35:
        int r25 = ((r23 + r3) * 37) + this.extraParams.hashCode();
        this.hashCode = r25;
        return r25;
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
    L37:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8207a = this.cmd;
        r0.f8208b = this.statusCode;
        r0.c = this.errorMsg;
        r0.d = this.logId;
        r0.e = this.sequenceId;
        r0.f = this.body;
        r0.g = this.accessToken;
        r0.h = this.monitorInfo;
        r0.i = Internal.copyOf("extraParams", this.extraParams);
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
        if (this.statusCode == null) goto L9;
        r0.append(", statusCode=").append(this.statusCode);
    L9:
        if (this.errorMsg == null) goto L12;
        r0.append(", errorMsg=").append(this.errorMsg);
    L12:
        if (this.logId == null) goto L15;
        r0.append(", logId=").append(this.logId);
    L15:
        if (this.sequenceId == null) goto L18;
        r0.append(", sequenceId=").append(this.sequenceId);
    L18:
        if (this.body == null) goto L21;
        r0.append(", body=").append(this.body);
    L21:
        if (this.accessToken == null) goto L24;
        r0.append(", accessToken=").append(this.accessToken);
    L24:
        if (this.monitorInfo == null) goto L26;
        r0.append(", monitorInfo=").append(this.monitorInfo);
    L26:
        Map<String, String> r1 = this.extraParams;
        if (r1 == null) goto L32;
        if (r1.isEmpty() == true) goto L32;
        r0.append(", extraParams=").append(this.extraParams);
    L32:
        return r0.replace(0, 2, "Response{").append('}').toString();
    }
}
