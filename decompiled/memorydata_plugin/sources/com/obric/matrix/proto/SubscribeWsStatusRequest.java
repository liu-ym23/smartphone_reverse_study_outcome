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
public final class SubscribeWsStatusRequest extends Message<SubscribeWsStatusRequest, a> {
    public static final ProtoAdapter<SubscribeWsStatusRequest> ADAPTER = null;
    public static final Integer DEFAULT_OPT = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("opt")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer opt;

    @SerializedName(ObricMemoryConstants.KEY_PACKAGE_NAME)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String packageName;

    public static final class a extends Message.Builder<SubscribeWsStatusRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f8247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8248b;

        public a() {
            this.f8247a = 0;
            this.f8248b = "";
        }

        public a a(Integer r1) {
            this.f8247a = r1;
            return this;
        }

        public a a(String r1) {
            this.f8248b = r1;
            return this;
        }

        public SubscribeWsStatusRequest a() {
            return new SubscribeWsStatusRequest(this.f8247a, this.f8248b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<SubscribeWsStatusRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsStatusRequest.class);
        }

        public int a(SubscribeWsStatusRequest r4) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r4.opt) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.packageName)) + r4.unknownFields().size();
        }

        public SubscribeWsStatusRequest a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, SubscribeWsStatusRequest r4) {
            ProtoAdapter.INT32.encodeWithTag(r3, 1, r4.opt);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.packageName);
            r3.writeBytes(r4.unknownFields());
        }

        public SubscribeWsStatusRequest b(SubscribeWsStatusRequest r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SubscribeWsStatusRequest decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, SubscribeWsStatusRequest r4) {
            a(r3, (SubscribeWsStatusRequest) ZeusTransformUtils.preCheckCast(r4, SubscribeWsStatusRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(SubscribeWsStatusRequest r3) {
            return a((SubscribeWsStatusRequest) ZeusTransformUtils.preCheckCast(r3, SubscribeWsStatusRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SubscribeWsStatusRequest redact(SubscribeWsStatusRequest r3) {
            return b((SubscribeWsStatusRequest) ZeusTransformUtils.preCheckCast(r3, SubscribeWsStatusRequest.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_OPT = 0;
    }

    public SubscribeWsStatusRequest(Integer r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SubscribeWsStatusRequest(Integer r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.opt = r2;
        this.packageName = r3;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SubscribeWsStatusRequest.class) == true) goto L8;
        return false;
    L8:
        SubscribeWsStatusRequest r6 = (SubscribeWsStatusRequest) ZeusTransformUtils.preCheckCast(r5, SubscribeWsStatusRequest.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.opt, r6.opt) == false) goto L16;
        if (Internal.equals(this.packageName, r6.packageName) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.opt;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.packageName;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        int r7 = r5 + r3;
        this.hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8247a = this.opt;
        r0.f8248b = this.packageName;
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
        if (this.opt == null) goto L6;
        r0.append(", opt=").append(this.opt);
    L6:
        if (this.packageName == null) goto L9;
        r0.append(", packageName=").append(this.packageName);
    L9:
        return r0.replace(0, 2, "SubscribeWsStatusRequest{").append('}').toString();
    }
}
