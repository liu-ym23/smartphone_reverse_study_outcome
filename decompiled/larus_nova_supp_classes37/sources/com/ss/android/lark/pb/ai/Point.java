package com.ss.android.lark.pb.ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Point extends Message<Point, Builder> {
    public static final ProtoAdapter<Point> ADAPTER = null;
    public static final Double DEFAULT_X = null;
    public static final Double DEFAULT_Y = null;
    private static final long serialVersionUID = 0;
    public final Double mx;
    public final Double my;

    public static final class Builder extends Message.Builder<Point, Builder> {
        public Double mx;
        public Double my;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Point m764build() {
            Double r0 = this.mx;
            if (r0 == null) goto L9;
            if (this.my == null) goto L9;
            return new Point(this.mx, this.my, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mx", this.my, "my"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m764build();
        }

        public Builder x(Double r1) {
            this.mx = r1;
            return this;
        }

        public Builder y(Double r1) {
            this.my = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Point extends ProtoAdapter<Point> {
        public ProtoAdapter_Point() {
            super(FieldEncoding.LENGTH_DELIMITED, Point.class);
        }

        public Point decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Double r1 = Double.valueOf(0.0d);
            r0.mx = r1;
            r0.my = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mx = (Double) ProtoAdapter.DOUBLE.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.my = (Double) ProtoAdapter.DOUBLE.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r2);
            return r0.m764build();
        }

        public int encodedSize(Point r5) {
            ProtoAdapter r0 = ProtoAdapter.DOUBLE;
            return (r0.encodedSizeWithTag(1, r5.mx) + r0.encodedSizeWithTag(2, r5.my)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m765decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Point) r1);
        }

        public void encode(ProtoWriter r4, Point r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.DOUBLE;
            r0.encodeWithTag(r4, 1, r5.mx);
            r0.encodeWithTag(r4, 2, r5.my);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Point) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Point();
        Double r0 = Double.valueOf(0.0d);
        DEFAULT_X = r0;
        DEFAULT_Y = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m763newBuilder() {
        Builder r0 = new Builder();
        r0.mx = this.mx;
        r0.my = this.my;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Point.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m763newBuilder();
    }

    public Point(Double r2, Double r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Point(Double r2, Double r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mx = r2;
        this.my = r3;
    }
}
