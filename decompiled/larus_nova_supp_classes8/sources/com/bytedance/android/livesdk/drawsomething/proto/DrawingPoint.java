package com.bytedance.android.livesdk.drawsomething.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class DrawingPoint extends Message<DrawingPoint, Builder> {
    public static final ProtoAdapter<DrawingPoint> ADAPTER = null;
    public static final Integer DEFAULT_X = null;
    public static final Integer DEFAULT_Y = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer x;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer y;

    public static final class Builder extends Message.Builder<DrawingPoint, Builder> {
        public Integer x;
        public Integer y;

        public DrawingPoint build() {
            return new DrawingPoint(this.x, this.y, super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m1177build() {
            return build();
        }

        public Builder x(Integer r1) {
            this.x = r1;
            return this;
        }

        public Builder y(Integer r1) {
            this.y = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DrawingPoint extends ProtoAdapter<DrawingPoint> {
        public ProtoAdapter_DrawingPoint() {
            super(FieldEncoding.LENGTH_DELIMITED, DrawingPoint.class);
        }

        public DrawingPoint decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.x((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.y((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(DrawingPoint r5) {
            Integer r0 = r5.x;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
        L6:
            Integer r3 = r5.y;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        public DrawingPoint redact(DrawingPoint r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1178decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DrawingPoint) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((DrawingPoint) r1);
        }

        public void encode(ProtoWriter r4, DrawingPoint r5) throws IOException {
            Integer r0 = r5.x;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
        L5:
            Integer r1 = r5.y;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DrawingPoint) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DrawingPoint();
        DEFAULT_X = 0;
        DEFAULT_Y = 0;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.x;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.y;
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
        r0.x = this.x;
        r0.y = this.y;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.x == null) goto L6;
        r0.append(", x=");
        r0.append(this.x);
    L6:
        if (this.y == null) goto L8;
        r0.append(", y=");
        r0.append(this.y);
    L8:
        StringBuilder r1 = r0.replace(0, 2, "DrawingPoint{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m1176newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof DrawingPoint) == true) goto L8;
        return false;
    L8:
        DrawingPoint r6 = (DrawingPoint) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.x, r6.x) == false) goto L15;
        if (Internal.equals(this.y, r6.y) == false) goto L15;
        return true;
    }

    public DrawingPoint(Integer r2, Integer r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public DrawingPoint(Integer r2, Integer r3, ByteString r4) {
        super(ADAPTER, r4);
        this.x = r2;
        this.y = r3;
    }
}
