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
public final class DecodeLocationRequest extends Message<DecodeLocationRequest, a> {
    public static final ProtoAdapter<DecodeLocationRequest> ADAPTER = null;
    public static final Double DEFAULT_LATITUDE = null;
    public static final Double DEFAULT_LONGITUDE = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 3)
    @c("latitude")
    public final Double latitude;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    @c("longitude")
    public final Double longitude;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @c("packageName")
    public final String packageName;

    public static final class a extends Message.Builder<DecodeLocationRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f5926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Double f5927c;

        public a() {
            this.f5925a = "";
            Double r10 = Double.valueOf(0.0d);
            this.f5926b = r10;
            this.f5927c = r10;
        }

        public DecodeLocationRequest a() {
            return new DecodeLocationRequest(this.f5925a, this.f5926b, this.f5927c, super.buildUnknownFields());
        }

        public a b(Double r10) {
            this.f5927c = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Double r10) {
            this.f5926b = r10;
            return this;
        }

        public a d(String r10) {
            this.f5925a = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<DecodeLocationRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, DecodeLocationRequest.class);
        }

        public DecodeLocationRequest a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L15;
            if (r13 != 1) goto L8;
            r11.d(ProtoAdapter.STRING.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L10;
            r11.c(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L10:
            if (r13 != 3) goto L11;
            r11.b(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L11:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L15:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, DecodeLocationRequest r11) {
            ProtoAdapter.STRING.encodeWithTag(r10, 1, r11.packageName);
            ProtoAdapter<Double> r12 = ProtoAdapter.DOUBLE;
            r12.encodeWithTag(r10, 2, r11.longitude);
            r12.encodeWithTag(r10, 3, r11.latitude);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(DecodeLocationRequest r10) {
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(1, r10.packageName);
            ProtoAdapter<Double> r12 = ProtoAdapter.DOUBLE;
            return ((r11 + r12.encodedSizeWithTag(2, r10.longitude)) + r12.encodedSizeWithTag(3, r10.latitude)) + r10.unknownFields().size();
        }

        public DecodeLocationRequest d(DecodeLocationRequest r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DecodeLocationRequest decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, DecodeLocationRequest r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DecodeLocationRequest r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DecodeLocationRequest redact(DecodeLocationRequest r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        Double r10 = Double.valueOf(0.0d);
        DEFAULT_LONGITUDE = r10;
        DEFAULT_LATITUDE = r10;
    }

    public DecodeLocationRequest(String r10, Double r11, Double r12) {
        this(r10, r11, r12, ByteString.EMPTY);
    }

    public DecodeLocationRequest(String r10, Double r11, Double r12, ByteString r13) {
        super(ADAPTER, r13);
        this.packageName = r10;
        this.longitude = r11;
        this.latitude = r12;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof DecodeLocationRequest) == true) goto L8;
        return false;
    L8:
        DecodeLocationRequest r11 = (DecodeLocationRequest) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L18;
        if (Internal.equals(this.packageName, r11.packageName) == false) goto L18;
        if (Internal.equals(this.longitude, r11.longitude) == false) goto L18;
        if (Internal.equals(this.latitude, r11.latitude) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L17;
        int r11 = unknownFields().hashCode() * 37;
        String r12 = this.packageName;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Double r16 = this.longitude;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        Double r19 = this.latitude;
        if (r19 == null) goto L15;
        r13 = r19.hashCode();
    L15:
        int r20 = r18 + r13;
        this.hashCode = r20;
        return r20;
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L17:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f5925a = this.packageName;
        r10.f5926b = this.longitude;
        r10.f5927c = this.latitude;
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
        if (this.packageName == null) goto L6;
        r10.append(", packageName=");
        r10.append(this.packageName);
    L6:
        if (this.longitude == null) goto L9;
        r10.append(", longitude=");
        r10.append(this.longitude);
    L9:
        if (this.latitude == null) goto L11;
        r10.append(", latitude=");
        r10.append(this.latitude);
    L11:
        StringBuilder r11 = r10.replace(0, 2, "DecodeLocationRequest{");
        r11.append('}');
        return r11.toString();
    }
}
