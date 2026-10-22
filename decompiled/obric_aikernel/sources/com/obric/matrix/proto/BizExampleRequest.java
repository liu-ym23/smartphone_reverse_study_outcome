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
public final class BizExampleRequest extends Message<BizExampleRequest, a> {
    public static final ProtoAdapter<BizExampleRequest> ADAPTER = null;
    public static final String DEFAULT_STRPARAM = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @c("strParam")
    public final String strParam;

    public static final class a extends Message.Builder<BizExampleRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5921a;

        public a() {
            this.f5921a = "";
        }

        public BizExampleRequest a() {
            return new BizExampleRequest(this.f5921a, super.buildUnknownFields());
        }

        public a b(String r10) {
            this.f5921a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<BizExampleRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, BizExampleRequest.class);
        }

        public BizExampleRequest a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L9;
            if (r13 != 1) goto L7;
            r11.b(ProtoAdapter.STRING.decode(r10));
            goto L3
        L7:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L9:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, BizExampleRequest r11) {
            ProtoAdapter.STRING.encodeWithTag(r10, 1, r11.strParam);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(BizExampleRequest r10) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r10.strParam) + r10.unknownFields().size();
        }

        public BizExampleRequest d(BizExampleRequest r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BizExampleRequest decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, BizExampleRequest r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BizExampleRequest r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BizExampleRequest redact(BizExampleRequest r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public BizExampleRequest(String r10) {
        this(r10, ByteString.EMPTY);
    }

    public BizExampleRequest(String r10, ByteString r11) {
        super(ADAPTER, r11);
        this.strParam = r10;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof BizExampleRequest) == true) goto L8;
        return false;
    L8:
        BizExampleRequest r11 = (BizExampleRequest) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L14;
        if (Internal.equals(this.strParam, r11.strParam) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L10;
        int r11 = unknownFields().hashCode() * 37;
        String r12 = this.strParam;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = r11 + r13;
        this.hashCode = r14;
        return r14;
    L7:
        r13 = 0;
        goto L8
    L10:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f5921a = this.strParam;
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
        if (this.strParam == null) goto L5;
        r10.append(", strParam=");
        r10.append(this.strParam);
    L5:
        StringBuilder r11 = r10.replace(0, 2, "BizExampleRequest{");
        r11.append('}');
        return r11.toString();
    }
}
