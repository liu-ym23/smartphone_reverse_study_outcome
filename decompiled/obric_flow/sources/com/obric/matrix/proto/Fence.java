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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class Fence extends Message<Fence, Builder> {
    public static final ProtoAdapter<Fence> ADAPTER = null;
    public static final String DEFAULT_FENCEID = "";
    public static final Integer DEFAULT_SHAPE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("circular")
    @WireField(adapter = "com.obric.matrix.proto.Circle#ADAPTER", tag = 3)
    public final Circle circular;

    @SerializedName("fenceid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String fenceid;

    @SerializedName("multi_polygon")
    @WireField(adapter = "com.obric.matrix.proto.MultiPolygon#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    public final List<MultiPolygon> multi_polygon;

    @SerializedName("polygons")
    @WireField(adapter = "com.obric.matrix.proto.Polygon#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<Polygon> polygons;

    @SerializedName("properties")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final Map<String, String> properties;

    @SerializedName("shape")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer shape;

    @SerializedName("vertices")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<Point> vertices;

    public static final class Builder extends Message.Builder<Fence, Builder> {
        public Circle circular;
        public String fenceid;
        public List<MultiPolygon> multi_polygon;
        public List<Polygon> polygons;
        public Map<String, String> properties;
        public Integer shape;
        public List<Point> vertices;

        public Builder() {
            this.fenceid = "";
            this.shape = 0;
            this.vertices = Internal.newMutableList();
            this.properties = Internal.newMutableMap();
            this.polygons = Internal.newMutableList();
            this.multi_polygon = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder circular(Circle r5) {
            this.circular = r5;
            return this;
        }

        public Builder fenceid(String r5) {
            this.fenceid = r5;
            return this;
        }

        public Builder multi_polygon(List<MultiPolygon> r5) {
            Internal.checkElementsNotNull(r5);
            this.multi_polygon = r5;
            return this;
        }

        public Builder polygons(List<Polygon> r5) {
            Internal.checkElementsNotNull(r5);
            this.polygons = r5;
            return this;
        }

        public Builder properties(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.properties = r5;
            return this;
        }

        public Builder shape(Integer r5) {
            this.shape = r5;
            return this;
        }

        public Builder vertices(List<Point> r5) {
            Internal.checkElementsNotNull(r5);
            this.vertices = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public Fence build() {
            return new Fence(this.fenceid, this.shape, this.circular, this.vertices, this.properties, this.polygons, this.multi_polygon, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Fence extends ProtoAdapter<Fence> {
        private final ProtoAdapter<Map<String, String>> properties;

        public ProtoAdapter_Fence() {
            super(FieldEncoding.LENGTH_DELIMITED, Fence.class);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            this.properties = ProtoAdapter.newMapAdapter(r5, r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Fence decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, Fence r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Fence r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Fence redact(Fence r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Fence decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L14;
            switch(r12) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r5.multi_polygon.add(MultiPolygon.ADAPTER.decode(r10));
            goto L3
        L8:
            r5.polygons.add(Polygon.ADAPTER.decode(r10));
            goto L3
        L9:
            r5.properties.putAll(this.properties.decode(r10));
            goto L3
        L10:
            r5.vertices.add(Point.ADAPTER.decode(r10));
            goto L3
        L11:
            r5.circular(Circle.ADAPTER.decode(r10));
            goto L3
        L12:
            r5.shape(ProtoAdapter.INT32.decode(r10));
            goto L3
        L13:
            r5.fenceid(ProtoAdapter.STRING.decode(r10));
            goto L3
        L6:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L14:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, Fence r10) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r5, 1, r10.fenceid);
            ProtoAdapter.INT32.encodeWithTag(r5, 2, r10.shape);
            Circle.ADAPTER.encodeWithTag(r5, 3, r10.circular);
            Point.ADAPTER.asRepeated().encodeWithTag(r5, 4, r10.vertices);
            this.properties.encodeWithTag(r5, 5, r10.properties);
            Polygon.ADAPTER.asRepeated().encodeWithTag(r5, 6, r10.polygons);
            MultiPolygon.ADAPTER.asRepeated().encodeWithTag(r5, 7, r10.multi_polygon);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Fence r5) {
            int r10 = ProtoAdapter.STRING.encodedSizeWithTag(1, r5.fenceid);
            int r11 = ProtoAdapter.INT32.encodedSizeWithTag(2, r5.shape) + r10;
            int r12 = Circle.ADAPTER.encodedSizeWithTag(3, r5.circular) + r11;
            int r13 = Point.ADAPTER.asRepeated().encodedSizeWithTag(4, r5.vertices) + r12;
            int r14 = this.properties.encodedSizeWithTag(5, r5.properties) + r13;
            int r15 = Polygon.ADAPTER.asRepeated().encodedSizeWithTag(6, r5.polygons) + r14;
            int r16 = MultiPolygon.ADAPTER.asRepeated().encodedSizeWithTag(7, r5.multi_polygon) + r15;
            return r5.unknownFields().size() + r16;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Fence redact2(Fence r5) {
            Builder r10 = r5.newBuilder();
            Circle r11 = r10.circular;
            if (r11 == null) goto L5;
            r10.circular = Circle.ADAPTER.redact(r11);
        L5:
            Internal.redactElements(r10.vertices, Point.ADAPTER);
            Internal.redactElements(r10.polygons, Polygon.ADAPTER);
            Internal.redactElements(r10.multi_polygon, MultiPolygon.ADAPTER);
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Fence();
        DEFAULT_SHAPE = 0;
    }

    public Fence(String r10, Integer r11, Circle r12, List<Point> r13, Map<String, String> r14, List<Polygon> r15, List<MultiPolygon> r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Fence) == true) goto L8;
        return false;
    L8:
        Fence r10 = (Fence) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L26;
        if (Internal.equals(this.fenceid, r10.fenceid) == false) goto L26;
        if (Internal.equals(this.shape, r10.shape) == false) goto L26;
        if (Internal.equals(this.circular, r10.circular) == false) goto L26;
        if (this.vertices.equals(r10.vertices) == false) goto L26;
        if (this.properties.equals(r10.properties) == false) goto L26;
        if (this.polygons.equals(r10.polygons) == false) goto L26;
        if (this.multi_polygon.equals(r10.multi_polygon) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L17;
        int r10 = unknownFields().hashCode() * 37;
        String r11 = this.fenceid;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Integer r15 = this.shape;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        Circle r18 = this.circular;
        if (r18 == null) goto L15;
        r12 = r18.hashCode();
    L15:
        int r19 = this.multi_polygon.hashCode() + ((this.polygons.hashCode() + ((this.properties.hashCode() + ((this.vertices.hashCode() + ((r17 + r12) * 37)) * 37)) * 37)) * 37);
        this.hashCode = r19;
        return r19;
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L17:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.fenceid == null) goto L6;
        r5.append(", fenceid=");
        r5.append(this.fenceid);
    L6:
        if (this.shape == null) goto L9;
        r5.append(", shape=");
        r5.append(this.shape);
    L9:
        if (this.circular == null) goto L11;
        r5.append(", circular=");
        r5.append(this.circular);
    L11:
        List<Point> r10 = this.vertices;
        if (r10 != null) goto L14;
    L16:
        Map<String, String> r11 = this.properties;
        if (r11 != null) goto L19;
    L21:
        List<Polygon> r12 = this.polygons;
        if (r12 != null) goto L24;
    L26:
        List<MultiPolygon> r13 = this.multi_polygon;
        if (r13 == null) goto L32;
        if (r13.isEmpty() == true) goto L32;
        r5.append(", multi_polygon=");
        r5.append(this.multi_polygon);
    L32:
        return a.s(r5, 0, 2, "Fence{", '}');
    L24:
        if (r12.isEmpty() == true) goto L26;
        r5.append(", polygons=");
        r5.append(this.polygons);
        goto L26
    L19:
        if (r11.isEmpty() == true) goto L21;
        r5.append(", properties=");
        r5.append(this.properties);
        goto L21
    L14:
        if (r10.isEmpty() == true) goto L16;
        r5.append(", vertices=");
        r5.append(this.vertices);
        goto L16
    }

    public Fence(String r5, Integer r10, Circle r11, List<Point> r12, Map<String, String> r13, List<Polygon> r14, List<MultiPolygon> r15, ByteString r16) {
        super(ADAPTER, r16);
        this.fenceid = r5;
        this.shape = r10;
        this.circular = r11;
        this.vertices = Internal.immutableCopyOf("vertices", r12);
        this.properties = Internal.immutableCopyOf("properties", r13);
        this.polygons = Internal.immutableCopyOf("polygons", r14);
        this.multi_polygon = Internal.immutableCopyOf("multi_polygon", r15);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.fenceid = this.fenceid;
        r5.shape = this.shape;
        r5.circular = this.circular;
        r5.vertices = Internal.copyOf("vertices", this.vertices);
        r5.properties = Internal.copyOf("properties", this.properties);
        r5.polygons = Internal.copyOf("polygons", this.polygons);
        r5.multi_polygon = Internal.copyOf("multi_polygon", this.multi_polygon);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
