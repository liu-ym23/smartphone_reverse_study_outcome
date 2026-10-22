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
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class Polygon extends Message<Polygon, Builder> {
    public static final ProtoAdapter<Polygon> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("vertices")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Point> vertices;

    public static final class Builder extends Message.Builder<Polygon, Builder> {
        public List<Point> vertices;

        public Builder() {
            this.vertices = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder vertices(List<Point> r5) {
            Internal.checkElementsNotNull(r5);
            this.vertices = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public Polygon build() {
            return new Polygon(this.vertices, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Polygon extends ProtoAdapter<Polygon> {
        public ProtoAdapter_Polygon() {
            super(FieldEncoding.LENGTH_DELIMITED, Polygon.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Polygon decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, Polygon r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Polygon r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Polygon redact(Polygon r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Polygon decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L9;
            if (r12 != 1) goto L7;
            r5.vertices.add(Point.ADAPTER.decode(r10));
            goto L3
        L7:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L9:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, Polygon r10) throws IOException {
            Point.ADAPTER.asRepeated().encodeWithTag(r5, 1, r10.vertices);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Polygon r5) {
            int r10 = Point.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.vertices);
            return r5.unknownFields().size() + r10;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Polygon redact2(Polygon r5) {
            Builder r10 = r5.newBuilder();
            Internal.redactElements(r10.vertices, Point.ADAPTER);
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Polygon();
    }

    public Polygon(List<Point> r5) {
        this(r5, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Polygon) == true) goto L8;
        return false;
    L8:
        Polygon r10 = (Polygon) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L14;
        if (this.vertices.equals(r10.vertices) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L6;
        int r10 = (unknownFields().hashCode() * 37) + this.vertices.hashCode();
        this.hashCode = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        List<Point> r10 = this.vertices;
        if (r10 == null) goto L8;
        if (r10.isEmpty() == true) goto L8;
        r5.append(", vertices=");
        r5.append(this.vertices);
    L8:
        return a.s(r5, 0, 2, "Polygon{", '}');
    }

    public Polygon(List<Point> r5, ByteString r10) {
        super(ADAPTER, r10);
        this.vertices = Internal.immutableCopyOf("vertices", r5);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.vertices = Internal.copyOf("vertices", this.vertices);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
