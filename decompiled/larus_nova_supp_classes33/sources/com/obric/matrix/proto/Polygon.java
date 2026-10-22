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
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class Polygon extends Message<Polygon, Builder> {
    public static final ProtoAdapter<Polygon> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("vertices")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Point> vertices;

    public static final class Builder extends Message.Builder<Polygon, Builder> {
        public List<Point> vertices;

        public Polygon build() {
            return new Polygon(this.vertices, super.buildUnknownFields());
        }

        public Builder() {
            this.vertices = Internal.newMutableList();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m140build() {
            return build();
        }

        public Builder vertices(List<Point> r1) {
            Internal.checkElementsNotNull(r1);
            this.vertices = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Polygon extends ProtoAdapter<Polygon> {
        public ProtoAdapter_Polygon() {
            super(FieldEncoding.LENGTH_DELIMITED, Polygon.class);
        }

        public Polygon decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.vertices.add((Point) Point.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(Polygon r4) {
            return Point.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.vertices) + r4.unknownFields().size();
        }

        public Polygon redact(Polygon r3) {
            Builder r4 = r3.newBuilder();
            Internal.redactElements(r4.vertices, Point.ADAPTER);
            r4.clearUnknownFields();
            return r4.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m141decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Polygon) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((Polygon) r1);
        }

        public void encode(ProtoWriter r4, Polygon r5) throws IOException {
            Point.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.vertices);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Polygon) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Polygon();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.vertices.hashCode();
        ((Message) this).hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.vertices = Internal.copyOf("vertices", this.vertices);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<Point> r1 = this.vertices;
        if (r1 != null) goto L5;
    L7:
        StringBuilder r2 = r0.replace(0, 2, "Polygon{");
        r2.append('}');
        return r2.toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", vertices=");
        r0.append(this.vertices);
        goto L7
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m139newBuilder() {
        return newBuilder();
    }

    public Polygon(List<Point> r2) {
        this(r2, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Polygon) == true) goto L8;
        return false;
    L8:
        Polygon r6 = (Polygon) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.vertices.equals(r6.vertices) == false) goto L13;
        return true;
    }

    public Polygon(List<Point> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.vertices = Internal.immutableCopyOf("vertices", r2);
    }
}
