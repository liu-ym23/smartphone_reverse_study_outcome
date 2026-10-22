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
public final class GetLocationRequest extends Message<GetLocationRequest, a> {
    public static final ProtoAdapter<GetLocationRequest> ADAPTER = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @c("packageName")
    public final String packageName;

    public static final class a extends Message.Builder<GetLocationRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5962a;

        public a() {
            this.f5962a = "";
        }

        public GetLocationRequest a() {
            return new GetLocationRequest(this.f5962a, super.buildUnknownFields());
        }

        public a b(String r10) {
            this.f5962a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<GetLocationRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, GetLocationRequest.class);
        }

        public GetLocationRequest a(ProtoReader r10) {
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

        public void b(ProtoWriter r10, GetLocationRequest r11) {
            ProtoAdapter.STRING.encodeWithTag(r10, 1, r11.packageName);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(GetLocationRequest r10) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r10.packageName) + r10.unknownFields().size();
        }

        public GetLocationRequest d(GetLocationRequest r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetLocationRequest decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, GetLocationRequest r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetLocationRequest r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetLocationRequest redact(GetLocationRequest r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public GetLocationRequest(String r10) {
        this(r10, ByteString.EMPTY);
    }

    public GetLocationRequest(String r10, ByteString r11) {
        super(ADAPTER, r11);
        this.packageName = r10;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof GetLocationRequest) == true) goto L8;
        return false;
    L8:
        GetLocationRequest r11 = (GetLocationRequest) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L14;
        if (Internal.equals(this.packageName, r11.packageName) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L10;
        int r11 = unknownFields().hashCode() * 37;
        String r12 = this.packageName;
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
        r10.f5962a = this.packageName;
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
        if (this.packageName == null) goto L5;
        r10.append(", packageName=");
        r10.append(this.packageName);
    L5:
        StringBuilder r11 = r10.replace(0, 2, "GetLocationRequest{");
        r11.append('}');
        return r11.toString();
    }
}
