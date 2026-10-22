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
public final class Response extends Message<Response, a> {
    public static final ProtoAdapter<Response> ADAPTER = null;
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final Integer DEFAULT_CMD = null;
    public static final String DEFAULT_ERRORMSG = "";
    public static final String DEFAULT_LOGID = "";
    public static final String DEFAULT_SEQUENCEID = "";
    public static final Integer DEFAULT_STATUSCODE = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @c("accessToken")
    public final String accessToken;

    @WireField(adapter = "com.obric.matrix.proto.ResponseBody#ADAPTER", tag = 7)
    @c("body")
    public final ResponseBody body;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @c("cmd")
    public final Integer cmd;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @c("errorMsg")
    public final String errorMsg;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    @c("extraParams")
    public final Map<String, String> extraParams;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @c("logId")
    public final String logId;

    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 9)
    @c("monitorInfo")
    public final MonitorInfo monitorInfo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @c("sequenceId")
    public final String sequenceId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @c("statusCode")
    public final Integer statusCode;

    public static final class a extends Message.Builder<Response, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f6046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f6047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f6048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f6049d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f6050e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ResponseBody f6051f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f6052g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public MonitorInfo f6053h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Map<String, String> f6054i;

        public a() {
            this.f6046a = 0;
            this.f6047b = 0;
            this.f6048c = "";
            this.f6049d = "";
            this.f6050e = "";
            this.f6052g = "";
            this.f6054i = Internal.newMutableMap();
        }

        public a a(String r10) {
            this.f6052g = r10;
            return this;
        }

        public a b(ResponseBody r10) {
            this.f6051f = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return c();
        }

        public Response c() {
            return new Response(this.f6046a, this.f6047b, this.f6048c, this.f6049d, this.f6050e, this.f6051f, this.f6052g, this.f6053h, this.f6054i, super.buildUnknownFields());
        }

        public a d(Integer r10) {
            this.f6046a = r10;
            return this;
        }

        public a e(String r10) {
            this.f6048c = r10;
            return this;
        }

        public a f(String r10) {
            this.f6049d = r10;
            return this;
        }

        public a g(MonitorInfo r10) {
            this.f6053h = r10;
            return this;
        }

        public a h(String r10) {
            this.f6050e = r10;
            return this;
        }

        public a i(Integer r10) {
            this.f6047b = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<Response> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f6055a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, Response.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f6055a = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public Response a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L16;
            switch(r13) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L6;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r11.f6054i.putAll(this.f6055a.decode(r10));
            goto L3
        L8:
            r11.g(MonitorInfo.ADAPTER.decode(r10));
            goto L3
        L9:
            r11.a(ProtoAdapter.STRING.decode(r10));
            goto L3
        L10:
            r11.b(ResponseBody.ADAPTER.decode(r10));
            goto L3
        L11:
            r11.h(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            r11.f(ProtoAdapter.STRING.decode(r10));
            goto L3
        L13:
            r11.e(ProtoAdapter.STRING.decode(r10));
            goto L3
        L14:
            r11.i(ProtoAdapter.INT32.decode(r10));
            goto L3
        L15:
            r11.d(ProtoAdapter.INT32.decode(r10));
            goto L3
        L6:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L16:
            r10.endMessage(r12);
            return r11.c();
        }

        public void b(ProtoWriter r10, Response r11) {
            ProtoAdapter<Integer> r12 = ProtoAdapter.INT32;
            r12.encodeWithTag(r10, 1, r11.cmd);
            r12.encodeWithTag(r10, 2, r11.statusCode);
            ProtoAdapter<String> r13 = ProtoAdapter.STRING;
            r13.encodeWithTag(r10, 3, r11.errorMsg);
            r13.encodeWithTag(r10, 4, r11.logId);
            r13.encodeWithTag(r10, 6, r11.sequenceId);
            ResponseBody.ADAPTER.encodeWithTag(r10, 7, r11.body);
            r13.encodeWithTag(r10, 8, r11.accessToken);
            MonitorInfo.ADAPTER.encodeWithTag(r10, 9, r11.monitorInfo);
            this.f6055a.encodeWithTag(r10, 10, r11.extraParams);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(Response r10) {
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            int r12 = r11.encodedSizeWithTag(1, r10.cmd) + r11.encodedSizeWithTag(2, r10.statusCode);
            ProtoAdapter<String> r13 = ProtoAdapter.STRING;
            return (((((((r12 + r13.encodedSizeWithTag(3, r10.errorMsg)) + r13.encodedSizeWithTag(4, r10.logId)) + r13.encodedSizeWithTag(6, r10.sequenceId)) + ResponseBody.ADAPTER.encodedSizeWithTag(7, r10.body)) + r13.encodedSizeWithTag(8, r10.accessToken)) + MonitorInfo.ADAPTER.encodedSizeWithTag(9, r10.monitorInfo)) + this.f6055a.encodedSizeWithTag(10, r10.extraParams)) + r10.unknownFields().size();
        }

        public Response d(Response r10) {
            a r11 = r10.newBuilder();
            ResponseBody r12 = r11.f6051f;
            if (r12 == null) goto L5;
            r11.f6051f = ResponseBody.ADAPTER.redact(r12);
        L5:
            MonitorInfo r13 = r11.f6053h;
            if (r13 == null) goto L8;
            r11.f6053h = MonitorInfo.ADAPTER.redact(r13);
        L8:
            r11.clearUnknownFields();
            return r11.c();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Response decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Response r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Response r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Response redact(Response r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_CMD = 0;
        DEFAULT_STATUSCODE = 0;
    }

    public Response(Integer r12, Integer r13, String r14, String r15, String r16, ResponseBody r17, String r18, MonitorInfo r19, Map<String, String> r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public Response(Integer r10, Integer r11, String r12, String r13, String r14, ResponseBody r15, String r16, MonitorInfo r17, Map<String, String> r18, ByteString r19) {
        super(ADAPTER, r19);
        this.cmd = r10;
        this.statusCode = r11;
        this.errorMsg = r12;
        this.logId = r13;
        this.sequenceId = r14;
        this.body = r15;
        this.accessToken = r16;
        this.monitorInfo = r17;
        this.extraParams = Internal.immutableCopyOf("extraParams", r18);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Response) == true) goto L8;
        return false;
    L8:
        Response r11 = (Response) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L30;
        if (Internal.equals(this.cmd, r11.cmd) == false) goto L30;
        if (Internal.equals(this.statusCode, r11.statusCode) == false) goto L30;
        if (Internal.equals(this.errorMsg, r11.errorMsg) == false) goto L30;
        if (Internal.equals(this.logId, r11.logId) == false) goto L30;
        if (Internal.equals(this.sequenceId, r11.sequenceId) == false) goto L30;
        if (Internal.equals(this.body, r11.body) == false) goto L30;
        if (Internal.equals(this.accessToken, r11.accessToken) == false) goto L30;
        if (Internal.equals(this.monitorInfo, r11.monitorInfo) == false) goto L30;
        if (this.extraParams.equals(r11.extraParams) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L37;
        int r11 = unknownFields().hashCode() * 37;
        Integer r12 = this.cmd;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Integer r16 = this.statusCode;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        String r19 = this.errorMsg;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (r18 + r20) * 37;
        String r22 = this.logId;
        if (r22 == null) goto L19;
        int r23 = r22.hashCode();
    L20:
        int r24 = (r21 + r23) * 37;
        String r25 = this.sequenceId;
        if (r25 == null) goto L23;
        int r26 = r25.hashCode();
    L24:
        int r27 = (r24 + r26) * 37;
        ResponseBody r28 = this.body;
        if (r28 == null) goto L27;
        int r29 = r28.hashCode();
    L28:
        int r30 = (r27 + r29) * 37;
        String r31 = this.accessToken;
        if (r31 == null) goto L31;
        int r32 = r31.hashCode();
    L32:
        int r33 = (r30 + r32) * 37;
        MonitorInfo r34 = this.monitorInfo;
        if (r34 == null) goto L35;
        r13 = r34.hashCode();
    L35:
        int r35 = ((r33 + r13) * 37) + this.extraParams.hashCode();
        this.hashCode = r35;
        return r35;
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
    L37:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f6046a = this.cmd;
        r10.f6047b = this.statusCode;
        r10.f6048c = this.errorMsg;
        r10.f6049d = this.logId;
        r10.f6050e = this.sequenceId;
        r10.f6051f = this.body;
        r10.f6052g = this.accessToken;
        r10.f6053h = this.monitorInfo;
        r10.f6054i = Internal.copyOf("extraParams", this.extraParams);
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
        if (this.statusCode == null) goto L9;
        r10.append(", statusCode=");
        r10.append(this.statusCode);
    L9:
        if (this.errorMsg == null) goto L12;
        r10.append(", errorMsg=");
        r10.append(this.errorMsg);
    L12:
        if (this.logId == null) goto L15;
        r10.append(", logId=");
        r10.append(this.logId);
    L15:
        if (this.sequenceId == null) goto L18;
        r10.append(", sequenceId=");
        r10.append(this.sequenceId);
    L18:
        if (this.body == null) goto L21;
        r10.append(", body=");
        r10.append(this.body);
    L21:
        if (this.accessToken == null) goto L24;
        r10.append(", accessToken=");
        r10.append(this.accessToken);
    L24:
        if (this.monitorInfo == null) goto L26;
        r10.append(", monitorInfo=");
        r10.append(this.monitorInfo);
    L26:
        Map<String, String> r11 = this.extraParams;
        if (r11 != null) goto L29;
    L31:
        StringBuilder r12 = r10.replace(0, 2, "Response{");
        r12.append('}');
        return r12.toString();
    L29:
        if (r11.isEmpty() == true) goto L31;
        r10.append(", extraParams=");
        r10.append(this.extraParams);
        goto L31
    }
}
