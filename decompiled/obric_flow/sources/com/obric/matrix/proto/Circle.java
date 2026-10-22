package com.obric.matrix.proto;

import androidx.room.jarjarred.org.antlr.runtime.a;
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

/* JADX INFO: loaded from: classes3.dex */
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

        public Builder() {
            this.radius = Double.valueOf(0.0d);
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder center(Point r5) {
            this.center = r5;
            return this;
        }

        public Builder radius(Double r5) {
            this.radius = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public Circle build() {
            return new Circle(this.center, this.radius, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Circle extends ProtoAdapter<Circle> {
        public ProtoAdapter_Circle() {
            super(FieldEncoding.LENGTH_DELIMITED, Circle.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Circle decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, Circle r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Circle r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Circle redact(Circle r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Circle decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L12;
            if (r12 != 1) goto L8;
            r5.center(Point.ADAPTER.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r5.radius(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L9:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L12:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, Circle r10) throws IOException {
            Point.ADAPTER.encodeWithTag(r5, 1, r10.center);
            ProtoAdapter.DOUBLE.encodeWithTag(r5, 2, r10.radius);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Circle r5) {
            int r10 = Point.ADAPTER.encodedSizeWithTag(1, r5.center);
            int r11 = ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r5.radius) + r10;
            return r5.unknownFields().size() + r11;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Circle redact2(Circle r5) {
            Builder r10 = r5.newBuilder();
            Point r11 = r10.center;
            if (r11 == null) goto L5;
            r10.center = Point.ADAPTER.redact(r11);
        L5:
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Circle();
        DEFAULT_RADIUS = Double.valueOf(0.0d);
    }

    public Circle(Point r5, Double r10) {
        this(r5, r10, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Circle) == true) goto L8;
        return false;
    L8:
        Circle r10 = (Circle) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.center, r10.center) == false) goto L16;
        if (Internal.equals(this.radius, r10.radius) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L13;
        int r10 = unknownFields().hashCode() * 37;
        Point r11 = this.center;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Double r15 = this.radius;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        int r16 = r14 + r12;
        this.hashCode = r16;
        return r16;
    L7:
        r13 = 0;
        goto L8
    L13:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.center == null) goto L6;
        r5.append(", center=");
        r5.append(this.center);
    L6:
        if (this.radius == null) goto L9;
        r5.append(", radius=");
        r5.append(this.radius);
    L9:
        return a.s(r5, 0, 2, "Circle{", '}');
    }

    public Circle(Point r5, Double r10, ByteString r11) {
        super(ADAPTER, r11);
        this.center = r5;
        this.radius = r10;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.center = this.center;
        r5.radius = this.radius;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
