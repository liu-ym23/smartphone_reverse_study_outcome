package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class SubscribeWsMsgRequest extends Message<SubscribeWsMsgRequest, a> {
    public static final ProtoAdapter<SubscribeWsMsgRequest> ADAPTER = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final Integer DEFAULT_OPT = null;
    public static final String DEFAULT_PACKAGENAME = "";
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("method")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer method;

    @SerializedName("opt")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer opt;

    @SerializedName(ObricMemoryConstants.KEY_PACKAGE_NAME)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String packageName;

    @SerializedName("service")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer service;

    public static final class a extends Message.Builder<SubscribeWsMsgRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f8244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f8245b;
        public String c;
        public Integer d;

        public a() {
            this.f8244a = 0;
            this.f8245b = 0;
            this.c = "";
            this.d = 0;
        }

        public a a(Integer r1) {
            this.f8244a = r1;
            return this;
        }

        public a a(String r1) {
            this.c = r1;
            return this;
        }

        public SubscribeWsMsgRequest a() {
            return new SubscribeWsMsgRequest(this.f8244a, this.f8245b, this.c, this.d, super.buildUnknownFields());
        }

        public a b(Integer r1) {
            this.f8245b = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r1) {
            this.d = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<SubscribeWsMsgRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgRequest.class);
        }

        public int a(SubscribeWsMsgRequest r4) {
            return (((ProtoAdapter.INT32.encodedSizeWithTag(1, r4.service) + ProtoAdapter.INT32.encodedSizeWithTag(2, r4.method)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r4.packageName)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r4.opt)) + r4.unknownFields().size();
        }

        public SubscribeWsMsgRequest a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r5.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.b((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            if (r2 != 4) goto L13;
            r5.c((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L13:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, SubscribeWsMsgRequest r4) {
            ProtoAdapter.INT32.encodeWithTag(r3, 1, r4.service);
            ProtoAdapter.INT32.encodeWithTag(r3, 2, r4.method);
            ProtoAdapter.STRING.encodeWithTag(r3, 3, r4.packageName);
            ProtoAdapter.INT32.encodeWithTag(r3, 4, r4.opt);
            r3.writeBytes(r4.unknownFields());
        }

        public SubscribeWsMsgRequest b(SubscribeWsMsgRequest r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SubscribeWsMsgRequest decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, SubscribeWsMsgRequest r4) {
            a(r3, (SubscribeWsMsgRequest) ZeusTransformUtils.preCheckCast(r4, SubscribeWsMsgRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(SubscribeWsMsgRequest r3) {
            return a((SubscribeWsMsgRequest) ZeusTransformUtils.preCheckCast(r3, SubscribeWsMsgRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SubscribeWsMsgRequest redact(SubscribeWsMsgRequest r3) {
            return b((SubscribeWsMsgRequest) ZeusTransformUtils.preCheckCast(r3, SubscribeWsMsgRequest.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_OPT = 0;
    }

    public SubscribeWsMsgRequest(Integer r7, Integer r8, String r9, Integer r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public SubscribeWsMsgRequest(Integer r2, Integer r3, String r4, Integer r5, ByteString r6) {
        super(ADAPTER, r6);
        this.service = r2;
        this.method = r3;
        this.packageName = r4;
        this.opt = r5;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SubscribeWsMsgRequest.class) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgRequest r6 = (SubscribeWsMsgRequest) ZeusTransformUtils.preCheckCast(r5, SubscribeWsMsgRequest.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.service, r6.service) == false) goto L20;
        if (Internal.equals(this.method, r6.method) == false) goto L20;
        if (Internal.equals(this.packageName, r6.packageName) == false) goto L20;
        if (Internal.equals(this.opt, r6.opt) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.service;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.method;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.packageName;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.opt;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
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
        r0.f8244a = this.service;
        r0.f8245b = this.method;
        r0.c = this.packageName;
        r0.d = this.opt;
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
        if (this.service == null) goto L6;
        r0.append(", service=").append(this.service);
    L6:
        if (this.method == null) goto L9;
        r0.append(", method=").append(this.method);
    L9:
        if (this.packageName == null) goto L12;
        r0.append(", packageName=").append(this.packageName);
    L12:
        if (this.opt == null) goto L15;
        r0.append(", opt=").append(this.opt);
    L15:
        return r0.replace(0, 2, "SubscribeWsMsgRequest{").append('}').toString();
    }
}
