package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
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
public final class DecodeLocationRequest extends Message<DecodeLocationRequest, a> {
    public static final ProtoAdapter<DecodeLocationRequest> ADAPTER = null;
    public static final Double DEFAULT_LATITUDE = null;
    public static final Double DEFAULT_LONGITUDE = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("latitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 3)
    public final Double latitude;

    @SerializedName("longitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double longitude;

    @SerializedName(ObricMemoryConstants.KEY_PACKAGE_NAME)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String packageName;

    public static final class a extends Message.Builder<DecodeLocationRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f8157b;
        public Double c;

        public a() {
            this.f8156a = "";
            Double r0 = Double.valueOf(0.0d);
            this.f8157b = r0;
            this.c = r0;
        }

        public a a(Double r1) {
            this.f8157b = r1;
            return this;
        }

        public a a(String r1) {
            this.f8156a = r1;
            return this;
        }

        public DecodeLocationRequest a() {
            return new DecodeLocationRequest(this.f8156a, this.f8157b, this.c, super.buildUnknownFields());
        }

        public a b(Double r1) {
            this.c = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<DecodeLocationRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, DecodeLocationRequest.class);
        }

        public int a(DecodeLocationRequest r4) {
            return ((ProtoAdapter.STRING.encodedSizeWithTag(1, r4.packageName) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r4.longitude)) + ProtoAdapter.DOUBLE.encodedSizeWithTag(3, r4.latitude)) + r4.unknownFields().size();
        }

        public DecodeLocationRequest a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L15;
            if (r2 != 1) goto L8;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.a((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            if (r2 != 3) goto L11;
            r5.b((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L15:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, DecodeLocationRequest r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.packageName);
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 2, r4.longitude);
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 3, r4.latitude);
            r3.writeBytes(r4.unknownFields());
        }

        public DecodeLocationRequest b(DecodeLocationRequest r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ DecodeLocationRequest decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, DecodeLocationRequest r4) {
            a(r3, (DecodeLocationRequest) ZeusTransformUtils.preCheckCast(r4, DecodeLocationRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(DecodeLocationRequest r3) {
            return a((DecodeLocationRequest) ZeusTransformUtils.preCheckCast(r3, DecodeLocationRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ DecodeLocationRequest redact(DecodeLocationRequest r3) {
            return b((DecodeLocationRequest) ZeusTransformUtils.preCheckCast(r3, DecodeLocationRequest.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        Double r0 = Double.valueOf(0.0d);
        DEFAULT_LONGITUDE = r0;
        DEFAULT_LATITUDE = r0;
    }

    public DecodeLocationRequest(String r2, Double r3, Double r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public DecodeLocationRequest(String r2, Double r3, Double r4, ByteString r5) {
        super(ADAPTER, r5);
        this.packageName = r2;
        this.longitude = r3;
        this.latitude = r4;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DecodeLocationRequest.class) == true) goto L8;
        return false;
    L8:
        DecodeLocationRequest r6 = (DecodeLocationRequest) ZeusTransformUtils.preCheckCast(r5, DecodeLocationRequest.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (Internal.equals(this.packageName, r6.packageName) == false) goto L18;
        if (Internal.equals(this.longitude, r6.longitude) == false) goto L18;
        if (Internal.equals(this.latitude, r6.latitude) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.packageName;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.longitude;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Double r9 = this.latitude;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = r8 + r3;
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8156a = this.packageName;
        r0.f8157b = this.longitude;
        r0.c = this.latitude;
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
        if (this.packageName == null) goto L6;
        r0.append(", packageName=").append(this.packageName);
    L6:
        if (this.longitude == null) goto L9;
        r0.append(", longitude=").append(this.longitude);
    L9:
        if (this.latitude == null) goto L12;
        r0.append(", latitude=").append(this.latitude);
    L12:
        return r0.replace(0, 2, "DecodeLocationRequest{").append('}').toString();
    }
}
