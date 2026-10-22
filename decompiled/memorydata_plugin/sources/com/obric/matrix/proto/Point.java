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
public final class Point extends Message<Point, a> {
    public static final ProtoAdapter<Point> ADAPTER = null;
    public static final Double DEFAULT_LATITUDE = null;
    public static final Double DEFAULT_LONGITUDE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("latitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double latitude;

    @SerializedName("longitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    public final Double longitude;

    public static final class a extends Message.Builder<Point, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f8195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f8196b;

        public a() {
            Double r0 = Double.valueOf(0.0d);
            this.f8195a = r0;
            this.f8196b = r0;
        }

        public a a(Double r1) {
            this.f8195a = r1;
            return this;
        }

        public Point a() {
            return new Point(this.f8195a, this.f8196b, super.buildUnknownFields());
        }

        public a b(Double r1) {
            this.f8196b = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<Point> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, Point.class);
        }

        public int a(Point r4) {
            return (ProtoAdapter.DOUBLE.encodedSizeWithTag(1, r4.longitude) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r4.latitude)) + r4.unknownFields().size();
        }

        public Point a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.a((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.b((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, Point r4) {
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 1, r4.longitude);
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 2, r4.latitude);
            r3.writeBytes(r4.unknownFields());
        }

        public Point b(Point r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Point decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, Point r4) {
            a(r3, (Point) ZeusTransformUtils.preCheckCast(r4, Point.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(Point r3) {
            return a((Point) ZeusTransformUtils.preCheckCast(r3, Point.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Point redact(Point r3) {
            return b((Point) ZeusTransformUtils.preCheckCast(r3, Point.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        Double r0 = Double.valueOf(0.0d);
        DEFAULT_LONGITUDE = r0;
        DEFAULT_LATITUDE = r0;
    }

    public Point(Double r2, Double r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Point(Double r2, Double r3, ByteString r4) {
        super(ADAPTER, r4);
        this.longitude = r2;
        this.latitude = r3;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Point.class) == true) goto L8;
        return false;
    L8:
        Point r6 = (Point) ZeusTransformUtils.preCheckCast(r5, Point.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.longitude, r6.longitude) == false) goto L16;
        if (Internal.equals(this.latitude, r6.latitude) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Double r2 = this.longitude;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.latitude;
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
        r0.f8195a = this.longitude;
        r0.f8196b = this.latitude;
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
        if (this.longitude == null) goto L6;
        r0.append(", longitude=").append(this.longitude);
    L6:
        if (this.latitude == null) goto L9;
        r0.append(", latitude=").append(this.latitude);
    L9:
        return r0.replace(0, 2, "Point{").append('}').toString();
    }
}
