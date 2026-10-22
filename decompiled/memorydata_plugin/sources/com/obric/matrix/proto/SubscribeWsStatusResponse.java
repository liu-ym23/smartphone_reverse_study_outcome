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
public final class SubscribeWsStatusResponse extends Message<SubscribeWsStatusResponse, a> {
    public static final ProtoAdapter<SubscribeWsStatusResponse> ADAPTER = null;
    public static final Integer DEFAULT_CHANNELID = null;
    public static final Integer DEFAULT_CHANNELTYPE = null;
    public static final Integer DEFAULT_CONNECTIONSTATE = null;
    public static final Boolean DEFAULT_ISCONNECTED = null;
    private static final long serialVersionUID = 0;

    @SerializedName("channelId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer channelId;

    @SerializedName("channelType")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer channelType;

    @SerializedName("connectionState")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer connectionState;

    @SerializedName("isConnected")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    public final Boolean isConnected;

    public static final class a extends Message.Builder<SubscribeWsStatusResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f8249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f8250b;
        public Integer c;
        public Boolean d;

        public a() {
            this.f8249a = 0;
            this.f8250b = 0;
            this.c = 0;
            this.d = false;
        }

        public a a(Boolean r1) {
            this.d = r1;
            return this;
        }

        public a a(Integer r1) {
            this.f8249a = r1;
            return this;
        }

        public SubscribeWsStatusResponse a() {
            return new SubscribeWsStatusResponse(this.f8249a, this.f8250b, this.c, this.d, super.buildUnknownFields());
        }

        public a b(Integer r1) {
            this.f8250b = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r1) {
            this.c = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<SubscribeWsStatusResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsStatusResponse.class);
        }

        public int a(SubscribeWsStatusResponse r4) {
            return (((ProtoAdapter.INT32.encodedSizeWithTag(1, r4.channelType) + ProtoAdapter.INT32.encodedSizeWithTag(2, r4.connectionState)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r4.channelId)) + ProtoAdapter.BOOL.encodedSizeWithTag(4, r4.isConnected)) + r4.unknownFields().size();
        }

        public SubscribeWsStatusResponse a(ProtoReader r6) {
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
            r5.c((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            if (r2 != 4) goto L13;
            r5.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r6), Boolean.class, "com.obric.memorydata.plugin"));
            goto L3
        L13:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, SubscribeWsStatusResponse r4) {
            ProtoAdapter.INT32.encodeWithTag(r3, 1, r4.channelType);
            ProtoAdapter.INT32.encodeWithTag(r3, 2, r4.connectionState);
            ProtoAdapter.INT32.encodeWithTag(r3, 3, r4.channelId);
            ProtoAdapter.BOOL.encodeWithTag(r3, 4, r4.isConnected);
            r3.writeBytes(r4.unknownFields());
        }

        public SubscribeWsStatusResponse b(SubscribeWsStatusResponse r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SubscribeWsStatusResponse decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, SubscribeWsStatusResponse r4) {
            a(r3, (SubscribeWsStatusResponse) ZeusTransformUtils.preCheckCast(r4, SubscribeWsStatusResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(SubscribeWsStatusResponse r3) {
            return a((SubscribeWsStatusResponse) ZeusTransformUtils.preCheckCast(r3, SubscribeWsStatusResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SubscribeWsStatusResponse redact(SubscribeWsStatusResponse r3) {
            return b((SubscribeWsStatusResponse) ZeusTransformUtils.preCheckCast(r3, SubscribeWsStatusResponse.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_CHANNELTYPE = 0;
        DEFAULT_CONNECTIONSTATE = 0;
        DEFAULT_CHANNELID = 0;
        DEFAULT_ISCONNECTED = false;
    }

    public SubscribeWsStatusResponse(Integer r7, Integer r8, Integer r9, Boolean r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public SubscribeWsStatusResponse(Integer r2, Integer r3, Integer r4, Boolean r5, ByteString r6) {
        super(ADAPTER, r6);
        this.channelType = r2;
        this.connectionState = r3;
        this.channelId = r4;
        this.isConnected = r5;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SubscribeWsStatusResponse.class) == true) goto L8;
        return false;
    L8:
        SubscribeWsStatusResponse r6 = (SubscribeWsStatusResponse) ZeusTransformUtils.preCheckCast(r5, SubscribeWsStatusResponse.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.channelType, r6.channelType) == false) goto L20;
        if (Internal.equals(this.connectionState, r6.connectionState) == false) goto L20;
        if (Internal.equals(this.channelId, r6.channelId) == false) goto L20;
        if (Internal.equals(this.isConnected, r6.isConnected) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.channelType;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.connectionState;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.channelId;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Boolean r12 = this.isConnected;
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
        r0.f8249a = this.channelType;
        r0.f8250b = this.connectionState;
        r0.c = this.channelId;
        r0.d = this.isConnected;
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
        if (this.channelType == null) goto L6;
        r0.append(", channelType=").append(this.channelType);
    L6:
        if (this.connectionState == null) goto L9;
        r0.append(", connectionState=").append(this.connectionState);
    L9:
        if (this.channelId == null) goto L12;
        r0.append(", channelId=").append(this.channelId);
    L12:
        if (this.isConnected == null) goto L15;
        r0.append(", isConnected=").append(this.isConnected);
    L15:
        return r0.replace(0, 2, "SubscribeWsStatusResponse{").append('}').toString();
    }
}
