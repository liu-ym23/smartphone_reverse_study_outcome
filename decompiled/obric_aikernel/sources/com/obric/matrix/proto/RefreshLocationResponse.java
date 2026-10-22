package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import d6.c;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class RefreshLocationResponse extends Message<RefreshLocationResponse, a> {
    public static final ProtoAdapter<RefreshLocationResponse> ADAPTER = null;
    public static final Integer DEFAULT_RESULTCODE = null;
    public static final Integer DEFAULT_RESULTMSG = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @c("resultCode")
    public final Integer resultCode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @c("resultMsg")
    public final Integer resultMsg;

    public static final class a extends Message.Builder<RefreshLocationResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f6014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f6015b;

        public a() {
            this.f6014a = 0;
            this.f6015b = 0;
        }

        public RefreshLocationResponse a() {
            return new RefreshLocationResponse(this.f6014a, this.f6015b, super.buildUnknownFields());
        }

        public a b(Integer r10) {
            this.f6014a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r10) {
            this.f6015b = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<RefreshLocationResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, RefreshLocationResponse.class);
        }

        public RefreshLocationResponse a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L12;
            if (r13 != 1) goto L8;
            r11.b(ProtoAdapter.INT32.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L9;
            r11.c(ProtoAdapter.INT32.decode(r10));
            goto L3
        L9:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L12:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, RefreshLocationResponse r11) {
            ProtoAdapter<Integer> r12 = ProtoAdapter.INT32;
            r12.encodeWithTag(r10, 1, r11.resultCode);
            r12.encodeWithTag(r10, 2, r11.resultMsg);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(RefreshLocationResponse r10) {
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            return (r11.encodedSizeWithTag(1, r10.resultCode) + r11.encodedSizeWithTag(2, r10.resultMsg)) + r10.unknownFields().size();
        }

        public RefreshLocationResponse d(RefreshLocationResponse r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RefreshLocationResponse decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, RefreshLocationResponse r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RefreshLocationResponse r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RefreshLocationResponse redact(RefreshLocationResponse r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_RESULTCODE = 0;
        DEFAULT_RESULTMSG = 0;
    }

    public RefreshLocationResponse(Integer r10, Integer r11) {
        this(r10, r11, ByteString.EMPTY);
    }

    public RefreshLocationResponse(Integer r10, Integer r11, ByteString r12) {
        super(ADAPTER, r12);
        this.resultCode = r10;
        this.resultMsg = r11;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof RefreshLocationResponse) == true) goto L8;
        return false;
    L8:
        RefreshLocationResponse r11 = (RefreshLocationResponse) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L16;
        if (Internal.equals(this.resultCode, r11.resultCode) == false) goto L16;
        if (Internal.equals(this.resultMsg, r11.resultMsg) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L13;
        int r11 = unknownFields().hashCode() * 37;
        Integer r12 = this.resultCode;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Integer r16 = this.resultMsg;
        if (r16 == null) goto L11;
        r13 = r16.hashCode();
    L11:
        int r17 = r15 + r13;
        this.hashCode = r17;
        return r17;
    L7:
        r14 = 0;
        goto L8
    L13:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f6014a = this.resultCode;
        r10.f6015b = this.resultMsg;
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
        if (this.resultCode == null) goto L6;
        r10.append(", resultCode=");
        r10.append(this.resultCode);
    L6:
        if (this.resultMsg == null) goto L8;
        r10.append(", resultMsg=");
        r10.append(this.resultMsg);
    L8:
        StringBuilder r11 = r10.replace(0, 2, "RefreshLocationResponse{");
        r11.append('}');
        return r11.toString();
    }
}
