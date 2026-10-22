package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class Circle extends Message<Circle, Builder> {
    public static final ProtoAdapter<Circle> ADAPTER = null;
    public static final Double DEFAULT_RADIUS = null;
    private static final long serialVersionUID = 0;

    @SerializedName("center")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", tag = 1)
    public final Point center;

    @SerializedName("radius")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double radius;

    public static final class Builder extends Message.Builder<Circle, Builder> {
        public Point center;
        public Double radius;

        public Circle build() {
            return new Circle(this.center, this.radius, super.buildUnknownFields());
        }

        public Builder() {
            this.radius = Double.valueOf(0.0d);
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m75build() {
            return build();
        }

        public Builder center(Point r1) {
            this.center = r1;
            return this;
        }

        public Builder radius(Double r1) {
            this.radius = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Circle extends ProtoAdapter<Circle> {
        public ProtoAdapter_Circle() {
            super(FieldEncoding.LENGTH_DELIMITED, Circle.class);
        }

        public Circle decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.center((Point) Point.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.radius((Double) ProtoAdapter.DOUBLE.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(Circle r5) {
            return (Point.ADAPTER.encodedSizeWithTag(1, r5.center) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r5.radius)) + r5.unknownFields().size();
        }

        public Circle redact(Circle r3) {
            Builder r4 = r3.newBuilder();
            Point r0 = r4.center;
            if (r0 == null) goto L5;
            r4.center = (Point) Point.ADAPTER.redact(r0);
        L5:
            r4.clearUnknownFields();
            return r4.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m76decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Circle) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((Circle) r1);
        }

        public void encode(ProtoWriter r4, Circle r5) throws IOException {
            Point.ADAPTER.encodeWithTag(r4, 1, r5.center);
            ProtoAdapter.DOUBLE.encodeWithTag(r4, 2, r5.radius);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Circle) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Circle();
        DEFAULT_RADIUS = Double.valueOf(0.0d);
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
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
        ((Message) this).hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.center = this.center;
        r0.radius = this.radius;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.center == null) goto L6;
        r0.append(", center=");
        r0.append(this.center);
    L6:
        if (this.radius == null) goto L8;
        r0.append(", radius=");
        r0.append(this.radius);
    L8:
        StringBuilder r1 = r0.replace(0, 2, "Circle{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m74newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Circle) == true) goto L8;
        return false;
    L8:
        Circle r6 = (Circle) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.center, r6.center) == false) goto L15;
        if (Internal.equals(this.radius, r6.radius) == false) goto L15;
        return true;
    }

    public Circle(Point r2, Double r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Circle(Point r2, Double r3, ByteString r4) {
        super(ADAPTER, r4);
        this.center = r2;
        this.radius = r3;
    }
}
