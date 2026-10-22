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
public final class SubscribeWsMsgByProviderResponse extends Message<SubscribeWsMsgByProviderResponse, a> {
    public static final ProtoAdapter<SubscribeWsMsgByProviderResponse> ADAPTER = null;
    public static final String DEFAULT_EXT = "";
    public static final Boolean DEFAULT_SUBSCRIBERESULT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("ext")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String ext;

    @SerializedName("subscribeResult")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean subscribeResult;

    public static final class a extends Message.Builder<SubscribeWsMsgByProviderResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f8242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8243b;

        public a() {
            this.f8242a = false;
            this.f8243b = "";
        }

        public a a(Boolean r1) {
            this.f8242a = r1;
            return this;
        }

        public a a(String r1) {
            this.f8243b = r1;
            return this;
        }

        public SubscribeWsMsgByProviderResponse a() {
            return new SubscribeWsMsgByProviderResponse(this.f8242a, this.f8243b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<SubscribeWsMsgByProviderResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByProviderResponse.class);
        }

        public int a(SubscribeWsMsgByProviderResponse r4) {
            return (ProtoAdapter.BOOL.encodedSizeWithTag(1, r4.subscribeResult) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.ext)) + r4.unknownFields().size();
        }

        public SubscribeWsMsgByProviderResponse a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r6), Boolean.class, "com.obric.memorydata.plugin"));
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

        public void a(ProtoWriter r3, SubscribeWsMsgByProviderResponse r4) {
            ProtoAdapter.BOOL.encodeWithTag(r3, 1, r4.subscribeResult);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.ext);
            r3.writeBytes(r4.unknownFields());
        }

        public SubscribeWsMsgByProviderResponse b(SubscribeWsMsgByProviderResponse r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SubscribeWsMsgByProviderResponse decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, SubscribeWsMsgByProviderResponse r4) {
            a(r3, (SubscribeWsMsgByProviderResponse) ZeusTransformUtils.preCheckCast(r4, SubscribeWsMsgByProviderResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(SubscribeWsMsgByProviderResponse r3) {
            return a((SubscribeWsMsgByProviderResponse) ZeusTransformUtils.preCheckCast(r3, SubscribeWsMsgByProviderResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SubscribeWsMsgByProviderResponse redact(SubscribeWsMsgByProviderResponse r3) {
            return b((SubscribeWsMsgByProviderResponse) ZeusTransformUtils.preCheckCast(r3, SubscribeWsMsgByProviderResponse.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SUBSCRIBERESULT = false;
    }

    public SubscribeWsMsgByProviderResponse(Boolean r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SubscribeWsMsgByProviderResponse(Boolean r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.subscribeResult = r2;
        this.ext = r3;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SubscribeWsMsgByProviderResponse.class) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByProviderResponse r6 = (SubscribeWsMsgByProviderResponse) ZeusTransformUtils.preCheckCast(r5, SubscribeWsMsgByProviderResponse.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.subscribeResult, r6.subscribeResult) == false) goto L16;
        if (Internal.equals(this.ext, r6.ext) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.subscribeResult;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.ext;
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
        r0.f8242a = this.subscribeResult;
        r0.f8243b = this.ext;
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
        if (this.subscribeResult == null) goto L6;
        r0.append(", subscribeResult=").append(this.subscribeResult);
    L6:
        if (this.ext == null) goto L9;
        r0.append(", ext=").append(this.ext);
    L9:
        return r0.replace(0, 2, "SubscribeWsMsgByProviderResponse{").append('}').toString();
    }
}
