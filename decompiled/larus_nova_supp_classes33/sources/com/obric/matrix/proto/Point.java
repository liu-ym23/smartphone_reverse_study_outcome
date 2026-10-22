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
public final class Point extends Message<Point, Builder> {
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

    public static final class Builder extends Message.Builder<Point, Builder> {
        public Double latitude;
        public Double longitude;

        public Point build() {
            return new Point(this.longitude, this.latitude, super.buildUnknownFields());
        }

        public Builder() {
            Double r0 = Double.valueOf(0.0d);
            this.longitude = r0;
            this.latitude = r0;
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m137build() {
            return build();
        }

        public Builder latitude(Double r1) {
            this.latitude = r1;
            return this;
        }

        public Builder longitude(Double r1) {
            this.longitude = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Point extends ProtoAdapter<Point> {
        public ProtoAdapter_Point() {
            super(FieldEncoding.LENGTH_DELIMITED, Point.class);
        }

        public Point decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.longitude((Double) ProtoAdapter.DOUBLE.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.latitude((Double) ProtoAdapter.DOUBLE.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(Point r5) {
            ProtoAdapter r0 = ProtoAdapter.DOUBLE;
            return (r0.encodedSizeWithTag(1, r5.longitude) + r0.encodedSizeWithTag(2, r5.latitude)) + r5.unknownFields().size();
        }

        public Point redact(Point r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m138decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Point) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((Point) r1);
        }

        public void encode(ProtoWriter r4, Point r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.DOUBLE;
            r0.encodeWithTag(r4, 1, r5.longitude);
            r0.encodeWithTag(r4, 2, r5.latitude);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Point) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Point();
        Double r0 = Double.valueOf(0.0d);
        DEFAULT_LONGITUDE = r0;
        DEFAULT_LATITUDE = r0;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
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
        r0.longitude = this.longitude;
        r0.latitude = this.latitude;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.longitude == null) goto L6;
        r0.append(", longitude=");
        r0.append(this.longitude);
    L6:
        if (this.latitude == null) goto L8;
        r0.append(", latitude=");
        r0.append(this.latitude);
    L8:
        StringBuilder r1 = r0.replace(0, 2, "Point{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m136newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Point) == true) goto L8;
        return false;
    L8:
        Point r6 = (Point) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.longitude, r6.longitude) == false) goto L15;
        if (Internal.equals(this.latitude, r6.latitude) == false) goto L15;
        return true;
    }

    public Point(Double r2, Double r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Point(Double r2, Double r3, ByteString r4) {
        super(ADAPTER, r4);
        this.longitude = r2;
        this.latitude = r3;
    }
}
