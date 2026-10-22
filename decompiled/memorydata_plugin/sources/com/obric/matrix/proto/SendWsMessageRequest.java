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
public final class SendWsMessageRequest extends Message<SendWsMessageRequest, a> {
    public static final ProtoAdapter<SendWsMessageRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("wsMessageInfo")
    @WireField(adapter = "com.obric.matrix.proto.WsMessageInfo#ADAPTER", tag = 1)
    public final WsMessageInfo wsMessageInfo;

    public static final class a extends Message.Builder<SendWsMessageRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WsMessageInfo f8226a;

        public a() {
        }

        public a a(WsMessageInfo r1) {
            this.f8226a = r1;
            return this;
        }

        public SendWsMessageRequest a() {
            return new SendWsMessageRequest(this.f8226a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<SendWsMessageRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SendWsMessageRequest.class);
        }

        public int a(SendWsMessageRequest r3) {
            return WsMessageInfo.ADAPTER.encodedSizeWithTag(1, r3.wsMessageInfo) + r3.unknownFields().size();
        }

        public SendWsMessageRequest a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.a((WsMessageInfo) ZeusTransformUtils.preCheckCast(WsMessageInfo.ADAPTER.decode(r6), WsMessageInfo.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, SendWsMessageRequest r4) {
            WsMessageInfo.ADAPTER.encodeWithTag(r3, 1, r4.wsMessageInfo);
            r3.writeBytes(r4.unknownFields());
        }

        public SendWsMessageRequest b(SendWsMessageRequest r3) {
            a r2 = r3.newBuilder();
            if (r2.f8226a == null) goto L5;
            r2.f8226a = (WsMessageInfo) ZeusTransformUtils.preCheckCast(WsMessageInfo.ADAPTER.redact(r2.f8226a), WsMessageInfo.class, "com.obric.memorydata.plugin");
        L5:
            r2.clearUnknownFields();
            return r2.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SendWsMessageRequest decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, SendWsMessageRequest r4) {
            a(r3, (SendWsMessageRequest) ZeusTransformUtils.preCheckCast(r4, SendWsMessageRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(SendWsMessageRequest r3) {
            return a((SendWsMessageRequest) ZeusTransformUtils.preCheckCast(r3, SendWsMessageRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SendWsMessageRequest redact(SendWsMessageRequest r3) {
            return b((SendWsMessageRequest) ZeusTransformUtils.preCheckCast(r3, SendWsMessageRequest.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public SendWsMessageRequest(WsMessageInfo r2) {
        this(r2, ByteString.EMPTY);
    }

    public SendWsMessageRequest(WsMessageInfo r2, ByteString r3) {
        super(ADAPTER, r3);
        this.wsMessageInfo = r2;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SendWsMessageRequest.class) == true) goto L8;
        return false;
    L8:
        SendWsMessageRequest r6 = (SendWsMessageRequest) ZeusTransformUtils.preCheckCast(r5, SendWsMessageRequest.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.wsMessageInfo, r6.wsMessageInfo) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        WsMessageInfo r2 = this.wsMessageInfo;
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
        r0.f8226a = this.wsMessageInfo;
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
        if (this.wsMessageInfo == null) goto L6;
        r0.append(", wsMessageInfo=").append(this.wsMessageInfo);
    L6:
        return r0.replace(0, 2, "SendWsMessageRequest{").append('}').toString();
    }
}
