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
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class BizExampleRequest extends Message<BizExampleRequest, a> {
    public static final ProtoAdapter<BizExampleRequest> ADAPTER = null;
    public static final String DEFAULT_STRPARAM = "";
    private static final long serialVersionUID = 0;

    @SerializedName("strParam")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String strParam;

    public static final class a extends Message.Builder<BizExampleRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8152a;

        public a() {
            this.f8152a = "";
        }

        public a a(String r1) {
            this.f8152a = r1;
            return this;
        }

        public BizExampleRequest a() {
            return new BizExampleRequest(this.f8152a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<BizExampleRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, BizExampleRequest.class);
        }

        public int a(BizExampleRequest r3) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r3.strParam) + r3.unknownFields().size();
        }

        public BizExampleRequest a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, BizExampleRequest r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.strParam);
            r3.writeBytes(r4.unknownFields());
        }

        public BizExampleRequest b(BizExampleRequest r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ BizExampleRequest decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, BizExampleRequest r4) {
            a(r3, (BizExampleRequest) ZeusTransformUtils.preCheckCast(r4, BizExampleRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(BizExampleRequest r3) {
            return a((BizExampleRequest) ZeusTransformUtils.preCheckCast(r3, BizExampleRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ BizExampleRequest redact(BizExampleRequest r3) {
            return b((BizExampleRequest) ZeusTransformUtils.preCheckCast(r3, BizExampleRequest.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public BizExampleRequest(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public BizExampleRequest(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.strParam = r2;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BizExampleRequest.class) == true) goto L8;
        return false;
    L8:
        BizExampleRequest r6 = (BizExampleRequest) ZeusTransformUtils.preCheckCast(r5, BizExampleRequest.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.strParam, r6.strParam) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.strParam;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = r1 + r3;
        this.hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8152a = this.strParam;
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
        if (this.strParam == null) goto L6;
        r0.append(", strParam=").append(this.strParam);
    L6:
        return r0.replace(0, 2, "BizExampleRequest{").append('}').toString();
    }
}
