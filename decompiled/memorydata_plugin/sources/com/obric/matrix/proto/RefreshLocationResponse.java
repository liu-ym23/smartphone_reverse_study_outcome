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
public final class RefreshLocationResponse extends Message<RefreshLocationResponse, a> {
    public static final ProtoAdapter<RefreshLocationResponse> ADAPTER = null;
    public static final Integer DEFAULT_RESULTCODE = null;
    public static final Integer DEFAULT_RESULTMSG = null;
    private static final long serialVersionUID = 0;

    @SerializedName("resultCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer resultCode;

    @SerializedName("resultMsg")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer resultMsg;

    public static final class a extends Message.Builder<RefreshLocationResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f8200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f8201b;

        public a() {
            this.f8200a = 0;
            this.f8201b = 0;
        }

        public a a(Integer r1) {
            this.f8200a = r1;
            return this;
        }

        public RefreshLocationResponse a() {
            return new RefreshLocationResponse(this.f8200a, this.f8201b, super.buildUnknownFields());
        }

        public a b(Integer r1) {
            this.f8201b = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<RefreshLocationResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, RefreshLocationResponse.class);
        }

        public int a(RefreshLocationResponse r4) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r4.resultCode) + ProtoAdapter.INT32.encodedSizeWithTag(2, r4.resultMsg)) + r4.unknownFields().size();
        }

        public RefreshLocationResponse a(ProtoReader r6) {
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
            r5.b((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, RefreshLocationResponse r4) {
            ProtoAdapter.INT32.encodeWithTag(r3, 1, r4.resultCode);
            ProtoAdapter.INT32.encodeWithTag(r3, 2, r4.resultMsg);
            r3.writeBytes(r4.unknownFields());
        }

        public RefreshLocationResponse b(RefreshLocationResponse r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ RefreshLocationResponse decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, RefreshLocationResponse r4) {
            a(r3, (RefreshLocationResponse) ZeusTransformUtils.preCheckCast(r4, RefreshLocationResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(RefreshLocationResponse r3) {
            return a((RefreshLocationResponse) ZeusTransformUtils.preCheckCast(r3, RefreshLocationResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ RefreshLocationResponse redact(RefreshLocationResponse r3) {
            return b((RefreshLocationResponse) ZeusTransformUtils.preCheckCast(r3, RefreshLocationResponse.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_RESULTCODE = 0;
        DEFAULT_RESULTMSG = 0;
    }

    public RefreshLocationResponse(Integer r2, Integer r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public RefreshLocationResponse(Integer r2, Integer r3, ByteString r4) {
        super(ADAPTER, r4);
        this.resultCode = r2;
        this.resultMsg = r3;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RefreshLocationResponse.class) == true) goto L8;
        return false;
    L8:
        RefreshLocationResponse r6 = (RefreshLocationResponse) ZeusTransformUtils.preCheckCast(r5, RefreshLocationResponse.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.resultCode, r6.resultCode) == false) goto L16;
        if (Internal.equals(this.resultMsg, r6.resultMsg) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.resultCode;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.resultMsg;
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
        r0.f8200a = this.resultCode;
        r0.f8201b = this.resultMsg;
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
        if (this.resultCode == null) goto L6;
        r0.append(", resultCode=").append(this.resultCode);
    L6:
        if (this.resultMsg == null) goto L9;
        r0.append(", resultMsg=").append(this.resultMsg);
    L9:
        return r0.replace(0, 2, "RefreshLocationResponse{").append('}').toString();
    }
}
