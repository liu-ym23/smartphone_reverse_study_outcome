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
public final class WsMessageInfo extends Message<WsMessageInfo, a> {
    public static final ProtoAdapter<WsMessageInfo> ADAPTER = null;
    public static final Integer DEFAULT_CHANNELID = null;
    public static final Integer DEFAULT_CMD = null;
    public static final Long DEFAULT_LOGID = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_PAYLOADENCODING = "";
    public static final String DEFAULT_PAYLOADTYPE = "";
    public static final Long DEFAULT_SEQID = null;
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("channelId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    public final Integer channelId;

    @SerializedName("cmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    public final Integer cmd;

    @SerializedName("headers")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final Map<String, String> headers;

    @SerializedName("logId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long logId;

    @SerializedName("method")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer method;

    @SerializedName("payload")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    public final ByteString payload;

    @SerializedName("payloadEncoding")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String payloadEncoding;

    @SerializedName("payloadType")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String payloadType;

    @SerializedName("seqId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long seqId;

    @SerializedName("service")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer service;

    public static final class a extends Message.Builder<WsMessageInfo, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f8253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f8254b;
        public Integer c;
        public Integer d;
        public String e;
        public String f;
        public ByteString g;
        public Integer h;
        public Integer i;
        public Map<String, String> j;

        public a() {
            this.f8253a = 0L;
            this.f8254b = 0L;
            this.c = 0;
            this.d = 0;
            this.e = "";
            this.f = "";
            this.g = ByteString.EMPTY;
            this.h = 0;
            this.i = 0;
            this.j = Internal.newMutableMap();
        }

        public a a(Integer r1) {
            this.c = r1;
            return this;
        }

        public a a(Long r1) {
            this.f8253a = r1;
            return this;
        }

        public a a(String r1) {
            this.e = r1;
            return this;
        }

        public a a(ByteString r1) {
            this.g = r1;
            return this;
        }

        public WsMessageInfo a() {
            return new WsMessageInfo(this.f8253a, this.f8254b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, super.buildUnknownFields());
        }

        public a b(Integer r1) {
            this.d = r1;
            return this;
        }

        public a b(Long r1) {
            this.f8254b = r1;
            return this;
        }

        public a b(String r1) {
            this.f = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r1) {
            this.h = r1;
            return this;
        }

        public a d(Integer r1) {
            this.i = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<WsMessageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8255a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, WsMessageInfo.class);
            this.f8255a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(WsMessageInfo r5) {
            return (((((((((ProtoAdapter.INT64.encodedSizeWithTag(1, r5.seqId) + ProtoAdapter.INT64.encodedSizeWithTag(2, r5.logId)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r5.service)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r5.method)) + ProtoAdapter.STRING.encodedSizeWithTag(6, r5.payloadType)) + ProtoAdapter.STRING.encodedSizeWithTag(7, r5.payloadEncoding)) + ProtoAdapter.BYTES.encodedSizeWithTag(8, r5.payload)) + ProtoAdapter.INT32.encodedSizeWithTag(9, r5.cmd)) + ProtoAdapter.INT32.encodedSizeWithTag(10, r5.channelId)) + this.f8255a.encodedSizeWithTag(11, r5.headers)) + r5.unknownFields().size();
        }

        public WsMessageInfo a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L18;
            switch(r3) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L7;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                default: goto L7;
            };
        L8:
            r0.j.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8255a.decode(r8), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            r0.d((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            r0.c((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            r0.a((ByteString) ZeusTransformUtils.preCheckCast(ProtoAdapter.BYTES.decode(r8), ByteString.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            r0.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L13:
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L14:
            r0.b((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L15:
            r0.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L16:
            r0.b((Long) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT64.decode(r8), Long.class, "com.obric.memorydata.plugin"));
            goto L3
        L17:
            r0.a((Long) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT64.decode(r8), Long.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L18:
            r8.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, WsMessageInfo r5) {
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r5.seqId);
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r5.logId);
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r5.service);
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r5.method);
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r5.payloadType);
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r5.payloadEncoding);
            ProtoAdapter.BYTES.encodeWithTag(r4, 8, r5.payload);
            ProtoAdapter.INT32.encodeWithTag(r4, 9, r5.cmd);
            ProtoAdapter.INT32.encodeWithTag(r4, 10, r5.channelId);
            this.f8255a.encodeWithTag(r4, 11, r5.headers);
            r4.writeBytes(r5.unknownFields());
        }

        public WsMessageInfo b(WsMessageInfo r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ WsMessageInfo decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, WsMessageInfo r4) {
            a(r3, (WsMessageInfo) ZeusTransformUtils.preCheckCast(r4, WsMessageInfo.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(WsMessageInfo r3) {
            return a((WsMessageInfo) ZeusTransformUtils.preCheckCast(r3, WsMessageInfo.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ WsMessageInfo redact(WsMessageInfo r3) {
            return b((WsMessageInfo) ZeusTransformUtils.preCheckCast(r3, WsMessageInfo.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SEQID = 0L;
        DEFAULT_LOGID = 0L;
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_CMD = 0;
        DEFAULT_CHANNELID = 0;
    }

    public WsMessageInfo(Long r14, Long r15, Integer r16, Integer r17, String r18, String r19, ByteString r20, Integer r21, Integer r22, Map<String, String> r23) {
        this(r14, r15, r16, r17, r18, r19, r20, r21, r22, (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public WsMessageInfo(Long r3, Long r4, Integer r5, Integer r6, String r7, String r8, ByteString r9, Integer r10, Integer r11, Map<String, String> r12, ByteString r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r13);
        this.seqId = r3;
        this.logId = r4;
        this.service = r5;
        this.method = r6;
        this.payloadType = r7;
        this.payloadEncoding = r8;
        this.payload = r9;
        this.cmd = r10;
        this.channelId = r11;
        this.headers = Internal.immutableCopyOf("headers", r14);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, WsMessageInfo.class) == true) goto L8;
        return false;
    L8:
        WsMessageInfo r6 = (WsMessageInfo) ZeusTransformUtils.preCheckCast(r5, WsMessageInfo.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L32;
        if (Internal.equals(this.seqId, r6.seqId) == false) goto L32;
        if (Internal.equals(this.logId, r6.logId) == false) goto L32;
        if (Internal.equals(this.service, r6.service) == false) goto L32;
        if (Internal.equals(this.method, r6.method) == false) goto L32;
        if (Internal.equals(this.payloadType, r6.payloadType) == false) goto L32;
        if (Internal.equals(this.payloadEncoding, r6.payloadEncoding) == false) goto L32;
        if (Internal.equals(this.payload, r6.payload) == false) goto L32;
        if (Internal.equals(this.cmd, r6.cmd) == false) goto L32;
        if (Internal.equals(this.channelId, r6.channelId) == false) goto L32;
        if (this.headers.equals(r6.headers) == false) goto L32;
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L41;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.seqId;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.logId;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.service;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.method;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.payloadType;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.payloadEncoding;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        ByteString r21 = this.payload;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        Integer r24 = this.cmd;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        Integer r27 = this.channelId;
        if (r27 == null) goto L39;
        r3 = r27.hashCode();
    L39:
        int r28 = ((r26 + r3) * 37) + this.headers.hashCode();
        this.hashCode = r28;
        return r28;
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
    L41:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8253a = this.seqId;
        r0.f8254b = this.logId;
        r0.c = this.service;
        r0.d = this.method;
        r0.e = this.payloadType;
        r0.f = this.payloadEncoding;
        r0.g = this.payload;
        r0.h = this.cmd;
        r0.i = this.channelId;
        r0.j = Internal.copyOf("headers", this.headers);
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
        if (this.seqId == null) goto L6;
        r0.append(", seqId=").append(this.seqId);
    L6:
        if (this.logId == null) goto L9;
        r0.append(", logId=").append(this.logId);
    L9:
        if (this.service == null) goto L12;
        r0.append(", service=").append(this.service);
    L12:
        if (this.method == null) goto L15;
        r0.append(", method=").append(this.method);
    L15:
        if (this.payloadType == null) goto L18;
        r0.append(", payloadType=").append(this.payloadType);
    L18:
        if (this.payloadEncoding == null) goto L21;
        r0.append(", payloadEncoding=").append(this.payloadEncoding);
    L21:
        if (this.payload == null) goto L24;
        r0.append(", payload=").append(this.payload);
    L24:
        if (this.cmd == null) goto L27;
        r0.append(", cmd=").append(this.cmd);
    L27:
        if (this.channelId == null) goto L29;
        r0.append(", channelId=").append(this.channelId);
    L29:
        Map<String, String> r1 = this.headers;
        if (r1 == null) goto L35;
        if (r1.isEmpty() == true) goto L35;
        r0.append(", headers=").append(this.headers);
    L35:
        return r0.replace(0, 2, "WsMessageInfo{").append('}').toString();
    }
}
