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
public final class SendWsMessageResponse extends Message<SendWsMessageResponse, a> {
    public static final ProtoAdapter<SendWsMessageResponse> ADAPTER = null;
    public static final Boolean DEFAULT_RESULT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("result")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean result;

    public static final class a extends Message.Builder<SendWsMessageResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f8227a;

        public a() {
            this.f8227a = false;
        }

        public a a(Boolean r1) {
            this.f8227a = r1;
            return this;
        }

        public SendWsMessageResponse a() {
            return new SendWsMessageResponse(this.f8227a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<SendWsMessageResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SendWsMessageResponse.class);
        }

        public int a(SendWsMessageResponse r3) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r3.result) + r3.unknownFields().size();
        }

        public SendWsMessageResponse a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r6), Boolean.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, SendWsMessageResponse r4) {
            ProtoAdapter.BOOL.encodeWithTag(r3, 1, r4.result);
            r3.writeBytes(r4.unknownFields());
        }

        public SendWsMessageResponse b(SendWsMessageResponse r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SendWsMessageResponse decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, SendWsMessageResponse r4) {
            a(r3, (SendWsMessageResponse) ZeusTransformUtils.preCheckCast(r4, SendWsMessageResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(SendWsMessageResponse r3) {
            return a((SendWsMessageResponse) ZeusTransformUtils.preCheckCast(r3, SendWsMessageResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SendWsMessageResponse redact(SendWsMessageResponse r3) {
            return b((SendWsMessageResponse) ZeusTransformUtils.preCheckCast(r3, SendWsMessageResponse.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_RESULT = false;
    }

    public SendWsMessageResponse(Boolean r2) {
        this(r2, ByteString.EMPTY);
    }

    public SendWsMessageResponse(Boolean r2, ByteString r3) {
        super(ADAPTER, r3);
        this.result = r2;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SendWsMessageResponse.class) == true) goto L8;
        return false;
    L8:
        SendWsMessageResponse r6 = (SendWsMessageResponse) ZeusTransformUtils.preCheckCast(r5, SendWsMessageResponse.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.result, r6.result) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.result;
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
        r0.f8227a = this.result;
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
        if (this.result == null) goto L6;
        r0.append(", result=").append(this.result);
    L6:
        return r0.replace(0, 2, "SendWsMessageResponse{").append('}').toString();
    }
}
