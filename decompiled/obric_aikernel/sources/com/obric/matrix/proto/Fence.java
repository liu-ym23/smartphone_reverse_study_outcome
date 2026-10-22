package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import d6.c;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class Fence extends Message<Fence, a> {
    public static final ProtoAdapter<Fence> ADAPTER = null;
    public static final String DEFAULT_FENCEID = "";
    public static final Integer DEFAULT_SHAPE = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.obric.matrix.proto.Circle#ADAPTER", tag = 3)
    @c("circular")
    public final Circle circular;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @c("fenceid")
    public final String fenceid;

    @WireField(adapter = "com.obric.matrix.proto.MultiPolygon#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    @c("multi_polygon")
    public final List<MultiPolygon> multi_polygon;

    @WireField(adapter = "com.obric.matrix.proto.Polygon#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    @c("polygons")
    public final List<Polygon> polygons;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @c("properties")
    public final Map<String, String> properties;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @c("shape")
    public final Integer shape;

    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    @c("vertices")
    public final List<Point> vertices;

    public static final class a extends Message.Builder<Fence, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f5930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Circle f5931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<Point> f5932d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f5933e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<Polygon> f5934f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<MultiPolygon> f5935g;

        public a() {
            this.f5929a = "";
            this.f5930b = 0;
            this.f5932d = Internal.newMutableList();
            this.f5933e = Internal.newMutableMap();
            this.f5934f = Internal.newMutableList();
            this.f5935g = Internal.newMutableList();
        }

        public Fence a() {
            return new Fence(this.f5929a, this.f5930b, this.f5931c, this.f5932d, this.f5933e, this.f5934f, this.f5935g, super.buildUnknownFields());
        }

        public a b(Circle r10) {
            this.f5931c = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(String r10) {
            this.f5929a = r10;
            return this;
        }

        public a d(Integer r10) {
            this.f5930b = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<Fence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f5936a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, Fence.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f5936a = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public Fence a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L15;
            switch(r13) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            List r14 = r11.f5935g;
            Message r15 = (MultiPolygon) MultiPolygon.ADAPTER.decode(r10);
        L11:
            r14.add(r15);
            goto L3
        L8:
            r14 = r11.f5934f;
            r15 = (Polygon) Polygon.ADAPTER.decode(r10);
            goto L11
        L9:
            r11.f5933e.putAll(this.f5936a.decode(r10));
            goto L3
        L10:
            r14 = r11.f5932d;
            r15 = (Point) Point.ADAPTER.decode(r10);
            goto L11
        L12:
            r11.b(Circle.ADAPTER.decode(r10));
            goto L3
        L13:
            r11.d(ProtoAdapter.INT32.decode(r10));
            goto L3
        L14:
            r11.c(ProtoAdapter.STRING.decode(r10));
            goto L3
        L6:
            FieldEncoding r16 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r16, r16.rawProtoAdapter().decode(r10));
            goto L3
        L15:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, Fence r11) {
            ProtoAdapter.STRING.encodeWithTag(r10, 1, r11.fenceid);
            ProtoAdapter.INT32.encodeWithTag(r10, 2, r11.shape);
            Circle.ADAPTER.encodeWithTag(r10, 3, r11.circular);
            Point.ADAPTER.asRepeated().encodeWithTag(r10, 4, r11.vertices);
            this.f5936a.encodeWithTag(r10, 5, r11.properties);
            Polygon.ADAPTER.asRepeated().encodeWithTag(r10, 6, r11.polygons);
            MultiPolygon.ADAPTER.asRepeated().encodeWithTag(r10, 7, r11.multi_polygon);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(Fence r10) {
            return ((((((ProtoAdapter.STRING.encodedSizeWithTag(1, r10.fenceid) + ProtoAdapter.INT32.encodedSizeWithTag(2, r10.shape)) + Circle.ADAPTER.encodedSizeWithTag(3, r10.circular)) + Point.ADAPTER.asRepeated().encodedSizeWithTag(4, r10.vertices)) + this.f5936a.encodedSizeWithTag(5, r10.properties)) + Polygon.ADAPTER.asRepeated().encodedSizeWithTag(6, r10.polygons)) + MultiPolygon.ADAPTER.asRepeated().encodedSizeWithTag(7, r10.multi_polygon)) + r10.unknownFields().size();
        }

        public Fence d(Fence r10) {
            a r11 = r10.newBuilder();
            Circle r12 = r11.f5931c;
            if (r12 == null) goto L5;
            r11.f5931c = Circle.ADAPTER.redact(r12);
        L5:
            Internal.redactElements(r11.f5932d, Point.ADAPTER);
            Internal.redactElements(r11.f5934f, Polygon.ADAPTER);
            Internal.redactElements(r11.f5935g, MultiPolygon.ADAPTER);
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Fence decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Fence r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Fence r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Fence redact(Fence r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SHAPE = 0;
    }

    public Fence(String r10, Integer r11, Circle r12, List<Point> r13, Map<String, String> r14, List<Polygon> r15, List<MultiPolygon> r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public Fence(String r10, Integer r11, Circle r12, List<Point> r13, Map<String, String> r14, List<Polygon> r15, List<MultiPolygon> r16, ByteString r17) {
        super(ADAPTER, r17);
        this.fenceid = r10;
        this.shape = r11;
        this.circular = r12;
        this.vertices = Internal.immutableCopyOf("vertices", r13);
        this.properties = Internal.immutableCopyOf("properties", r14);
        this.polygons = Internal.immutableCopyOf("polygons", r15);
        this.multi_polygon = Internal.immutableCopyOf("multi_polygon", r16);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Fence) == true) goto L8;
        return false;
    L8:
        Fence r11 = (Fence) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L26;
        if (Internal.equals(this.fenceid, r11.fenceid) == false) goto L26;
        if (Internal.equals(this.shape, r11.shape) == false) goto L26;
        if (Internal.equals(this.circular, r11.circular) == false) goto L26;
        if (this.vertices.equals(r11.vertices) == false) goto L26;
        if (this.properties.equals(r11.properties) == false) goto L26;
        if (this.polygons.equals(r11.polygons) == false) goto L26;
        if (this.multi_polygon.equals(r11.multi_polygon) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L17;
        int r11 = unknownFields().hashCode() * 37;
        String r12 = this.fenceid;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Integer r16 = this.shape;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        Circle r19 = this.circular;
        if (r19 == null) goto L15;
        r13 = r19.hashCode();
    L15:
        int r20 = ((((((((r18 + r13) * 37) + this.vertices.hashCode()) * 37) + this.properties.hashCode()) * 37) + this.polygons.hashCode()) * 37) + this.multi_polygon.hashCode();
        this.hashCode = r20;
        return r20;
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L17:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f5929a = this.fenceid;
        r10.f5930b = this.shape;
        r10.f5931c = this.circular;
        r10.f5932d = Internal.copyOf("vertices", this.vertices);
        r10.f5933e = Internal.copyOf("properties", this.properties);
        r10.f5934f = Internal.copyOf("polygons", this.polygons);
        r10.f5935g = Internal.copyOf("multi_polygon", this.multi_polygon);
        r10.addUnknownFields(unknownFields());
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.fenceid == null) goto L6;
        r10.append(", fenceid=");
        r10.append(this.fenceid);
    L6:
        if (this.shape == null) goto L9;
        r10.append(", shape=");
        r10.append(this.shape);
    L9:
        if (this.circular == null) goto L11;
        r10.append(", circular=");
        r10.append(this.circular);
    L11:
        List<Point> r11 = this.vertices;
        if (r11 != null) goto L14;
    L16:
        Map<String, String> r12 = this.properties;
        if (r12 != null) goto L19;
    L21:
        List<Polygon> r13 = this.polygons;
        if (r13 != null) goto L24;
    L26:
        List<MultiPolygon> r14 = this.multi_polygon;
        if (r14 != null) goto L29;
    L31:
        StringBuilder r15 = r10.replace(0, 2, "Fence{");
        r15.append('}');
        return r15.toString();
    L29:
        if (r14.isEmpty() == true) goto L31;
        r10.append(", multi_polygon=");
        r10.append(this.multi_polygon);
        goto L31
    L24:
        if (r13.isEmpty() == true) goto L26;
        r10.append(", polygons=");
        r10.append(this.polygons);
        goto L26
    L19:
        if (r12.isEmpty() == true) goto L21;
        r10.append(", properties=");
        r10.append(this.properties);
        goto L21
    L14:
        if (r11.isEmpty() == true) goto L16;
        r10.append(", vertices=");
        r10.append(this.vertices);
        goto L16
    }
}
