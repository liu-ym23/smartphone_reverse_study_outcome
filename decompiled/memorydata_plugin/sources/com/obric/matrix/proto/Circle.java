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
public final class Circle extends Message<Circle, a> {
    public static final ProtoAdapter<Circle> ADAPTER = null;
    public static final Double DEFAULT_RADIUS = null;
    private static final long serialVersionUID = 0;

    @SerializedName("center")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", tag = 1)
    public final Point center;

    @SerializedName("radius")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double radius;

    public static final class a extends Message.Builder<Circle, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Point f8154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f8155b;

        public a() {
            this.f8155b = Double.valueOf(0.0d);
        }

        public a a(Point r1) {
            this.f8154a = r1;
            return this;
        }

        public a a(Double r1) {
            this.f8155b = r1;
            return this;
        }

        public Circle a() {
            return new Circle(this.f8154a, this.f8155b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<Circle> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, Circle.class);
        }

        public int a(Circle r4) {
            return (Point.ADAPTER.encodedSizeWithTag(1, r4.center) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r4.radius)) + r4.unknownFields().size();
        }

        public Circle a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.a((Point) ZeusTransformUtils.preCheckCast(Point.ADAPTER.decode(r6), Point.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.a((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, Circle r4) {
            Point.ADAPTER.encodeWithTag(r3, 1, r4.center);
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 2, r4.radius);
            r3.writeBytes(r4.unknownFields());
        }

        public Circle b(Circle r3) {
            a r2 = r3.newBuilder();
            if (r2.f8154a == null) goto L5;
            r2.f8154a = (Point) ZeusTransformUtils.preCheckCast(Point.ADAPTER.redact(r2.f8154a), Point.class, "com.obric.memorydata.plugin");
        L5:
            r2.clearUnknownFields();
            return r2.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Circle decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, Circle r4) {
            a(r3, (Circle) ZeusTransformUtils.preCheckCast(r4, Circle.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(Circle r3) {
            return a((Circle) ZeusTransformUtils.preCheckCast(r3, Circle.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Circle redact(Circle r3) {
            return b((Circle) ZeusTransformUtils.preCheckCast(r3, Circle.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_RADIUS = Double.valueOf(0.0d);
    }

    public Circle(Point r2, Double r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Circle(Point r2, Double r3, ByteString r4) {
        super(ADAPTER, r4);
        this.center = r2;
        this.radius = r3;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Circle.class) == true) goto L8;
        return false;
    L8:
        Circle r6 = (Circle) ZeusTransformUtils.preCheckCast(r5, Circle.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.center, r6.center) == false) goto L16;
        if (Internal.equals(this.radius, r6.radius) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Point r2 = this.center;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.radius;
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
        r0.f8154a = this.center;
        r0.f8155b = this.radius;
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
        if (this.center == null) goto L6;
        r0.append(", center=").append(this.center);
    L6:
        if (this.radius == null) goto L9;
        r0.append(", radius=").append(this.radius);
    L9:
        return r0.replace(0, 2, "Circle{").append('}').toString();
    }
}
