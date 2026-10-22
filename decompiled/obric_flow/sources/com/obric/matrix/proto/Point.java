package com.obric.matrix.proto;

import androidx.room.jarjarred.org.antlr.runtime.a;
import cn.nubia.neopush.commons.Constant;
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
public final class Point extends Message<Point, Builder> {
    public static final ProtoAdapter<Point> ADAPTER = null;
    public static final Double DEFAULT_LATITUDE = null;
    public static final Double DEFAULT_LONGITUDE = null;
    private static final long serialVersionUID = 0;

    @SerializedName(Constant.LATITUDE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double latitude;

    @SerializedName(Constant.LONGITUDE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    public final Double longitude;

    public static final class Builder extends Message.Builder<Point, Builder> {
        public Double latitude;
        public Double longitude;

        public Builder() {
            Double r5 = Double.valueOf(0.0d);
            this.longitude = r5;
            this.latitude = r5;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder latitude(Double r5) {
            this.latitude = r5;
            return this;
        }

        public Builder longitude(Double r5) {
            this.longitude = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public Point build() {
            return new Point(this.longitude, this.latitude, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Point extends ProtoAdapter<Point> {
        public ProtoAdapter_Point() {
            super(FieldEncoding.LENGTH_DELIMITED, Point.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Point decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, Point r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Point r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Point redact(Point r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Point decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L12;
            if (r12 != 1) goto L8;
            r5.longitude(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r5.latitude(ProtoAdapter.DOUBLE.decode(r10));
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
        public void encode2(ProtoWriter r5, Point r10) throws IOException {
            ProtoAdapter<Double> r11 = ProtoAdapter.DOUBLE;
            r11.encodeWithTag(r5, 1, r10.longitude);
            r11.encodeWithTag(r5, 2, r10.latitude);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Point r5) {
            ProtoAdapter<Double> r10 = ProtoAdapter.DOUBLE;
            int r11 = r10.encodedSizeWithTag(1, r5.longitude);
            int r12 = r10.encodedSizeWithTag(2, r5.latitude) + r11;
            return r5.unknownFields().size() + r12;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Point redact2(Point r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Point();
        Double r5 = Double.valueOf(0.0d);
        DEFAULT_LONGITUDE = r5;
        DEFAULT_LATITUDE = r5;
    }

    public Point(Double r5, Double r10) {
        this(r5, r10, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Point) == true) goto L8;
        return false;
    L8:
        Point r10 = (Point) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.longitude, r10.longitude) == false) goto L16;
        if (Internal.equals(this.latitude, r10.latitude) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L13;
        int r10 = unknownFields().hashCode() * 37;
        Double r11 = this.longitude;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Double r15 = this.latitude;
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
        if (this.longitude == null) goto L6;
        r5.append(", longitude=");
        r5.append(this.longitude);
    L6:
        if (this.latitude == null) goto L9;
        r5.append(", latitude=");
        r5.append(this.latitude);
    L9:
        return a.s(r5, 0, 2, "Point{", '}');
    }

    public Point(Double r5, Double r10, ByteString r11) {
        super(ADAPTER, r11);
        this.longitude = r5;
        this.latitude = r10;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.longitude = this.longitude;
        r5.latitude = this.latitude;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
