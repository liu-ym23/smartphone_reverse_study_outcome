package com.obric.matrix.proto;

import com.amap.api.fence.GeoFence;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class Fence extends Message<Fence, a> {
    public static final ProtoAdapter<Fence> ADAPTER = null;
    public static final String DEFAULT_FENCEID = "";
    public static final Integer DEFAULT_SHAPE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("circular")
    @WireField(adapter = "com.obric.matrix.proto.Circle#ADAPTER", tag = 3)
    public final Circle circular;

    @SerializedName(GeoFence.BUNDLE_KEY_FENCEID)
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

    public static final class a extends Message.Builder<Fence, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f8160b;
        public Circle c;
        public List<Point> d;
        public Map<String, String> e;
        public List<Polygon> f;
        public List<MultiPolygon> g;

        public a() {
            this.f8159a = "";
            this.f8160b = 0;
            this.d = Internal.newMutableList();
            this.e = Internal.newMutableMap();
            this.f = Internal.newMutableList();
            this.g = Internal.newMutableList();
        }

        public a a(Circle r1) {
            this.c = r1;
            return this;
        }

        public a a(Integer r1) {
            this.f8160b = r1;
            return this;
        }

        public a a(String r1) {
            this.f8159a = r1;
            return this;
        }

        public Fence a() {
            return new Fence(this.f8159a, this.f8160b, this.c, this.d, this.e, this.f, this.g, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<Fence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8161a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, Fence.class);
            this.f8161a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(Fence r5) {
            return ((((((ProtoAdapter.STRING.encodedSizeWithTag(1, r5.fenceid) + ProtoAdapter.INT32.encodedSizeWithTag(2, r5.shape)) + Circle.ADAPTER.encodedSizeWithTag(3, r5.circular)) + Point.ADAPTER.asRepeated().encodedSizeWithTag(4, r5.vertices)) + this.f8161a.encodedSizeWithTag(5, r5.properties)) + Polygon.ADAPTER.asRepeated().encodedSizeWithTag(6, r5.polygons)) + MultiPolygon.ADAPTER.asRepeated().encodedSizeWithTag(7, r5.multi_polygon)) + r5.unknownFields().size();
        }

        public Fence a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            List r4 = r0.g;
            Message r5 = (MultiPolygon) ZeusTransformUtils.preCheckCast(MultiPolygon.ADAPTER.decode(r8), MultiPolygon.class, "com.obric.memorydata.plugin");
        L12:
            r4.add(r5);
            goto L3
        L9:
            r4 = r0.f;
            r5 = (Polygon) ZeusTransformUtils.preCheckCast(Polygon.ADAPTER.decode(r8), Polygon.class, "com.obric.memorydata.plugin");
            goto L12
        L10:
            r0.e.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8161a.decode(r8), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            r4 = r0.d;
            r5 = (Point) ZeusTransformUtils.preCheckCast(Point.ADAPTER.decode(r8), Point.class, "com.obric.memorydata.plugin");
            goto L12
        L13:
            r0.a((Circle) ZeusTransformUtils.preCheckCast(Circle.ADAPTER.decode(r8), Circle.class, "com.obric.memorydata.plugin"));
            goto L3
        L14:
            r0.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L15:
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r6 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r6, r6.rawProtoAdapter().decode(r8));
            goto L3
        L16:
            r8.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, Fence r5) {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.fenceid);
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r5.shape);
            Circle.ADAPTER.encodeWithTag(r4, 3, r5.circular);
            Point.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.vertices);
            this.f8161a.encodeWithTag(r4, 5, r5.properties);
            Polygon.ADAPTER.asRepeated().encodeWithTag(r4, 6, r5.polygons);
            MultiPolygon.ADAPTER.asRepeated().encodeWithTag(r4, 7, r5.multi_polygon);
            r4.writeBytes(r5.unknownFields());
        }

        public Fence b(Fence r3) {
            a r2 = r3.newBuilder();
            if (r2.c == null) goto L5;
            r2.c = (Circle) ZeusTransformUtils.preCheckCast(Circle.ADAPTER.redact(r2.c), Circle.class, "com.obric.memorydata.plugin");
        L5:
            Internal.redactElements(r2.d, Point.ADAPTER);
            Internal.redactElements(r2.f, Polygon.ADAPTER);
            Internal.redactElements(r2.g, MultiPolygon.ADAPTER);
            r2.clearUnknownFields();
            return r2.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Fence decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, Fence r4) {
            a(r3, (Fence) ZeusTransformUtils.preCheckCast(r4, Fence.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(Fence r3) {
            return a((Fence) ZeusTransformUtils.preCheckCast(r3, Fence.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Fence redact(Fence r3) {
            return b((Fence) ZeusTransformUtils.preCheckCast(r3, Fence.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SHAPE = 0;
    }

    public Fence(String r12, Integer r13, Circle r14, List<Point> r15, Map<String, String> r16, List<Polygon> r17, List<MultiPolygon> r18) {
        this(r12, r13, r14, (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public Fence(String r3, Integer r4, Circle r5, List<Point> r6, Map<String, String> r7, List<Polygon> r8, List<MultiPolygon> r9, ByteString r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r10);
        this.fenceid = r3;
        this.shape = r4;
        this.circular = r5;
        this.vertices = Internal.immutableCopyOf("vertices", r11);
        this.properties = Internal.immutableCopyOf("properties", r12);
        this.polygons = Internal.immutableCopyOf("polygons", r13);
        this.multi_polygon = Internal.immutableCopyOf("multi_polygon", r14);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Fence.class) == true) goto L8;
        return false;
    L8:
        Fence r6 = (Fence) ZeusTransformUtils.preCheckCast(r5, Fence.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L26;
        if (Internal.equals(this.fenceid, r6.fenceid) == false) goto L26;
        if (Internal.equals(this.shape, r6.shape) == false) goto L26;
        if (Internal.equals(this.circular, r6.circular) == false) goto L26;
        if (this.vertices.equals(r6.vertices) == false) goto L26;
        if (this.properties.equals(r6.properties) == false) goto L26;
        if (this.polygons.equals(r6.polygons) == false) goto L26;
        if (this.multi_polygon.equals(r6.multi_polygon) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.fenceid;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.shape;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Circle r9 = this.circular;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = ((((((((r8 + r3) * 37) + this.vertices.hashCode()) * 37) + this.properties.hashCode()) * 37) + this.polygons.hashCode()) * 37) + this.multi_polygon.hashCode();
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8159a = this.fenceid;
        r0.f8160b = this.shape;
        r0.c = this.circular;
        r0.d = Internal.copyOf("vertices", this.vertices);
        r0.e = Internal.copyOf("properties", this.properties);
        r0.f = Internal.copyOf("polygons", this.polygons);
        r0.g = Internal.copyOf("multi_polygon", this.multi_polygon);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.fenceid == null) goto L6;
        r0.append(", fenceid=").append(this.fenceid);
    L6:
        if (this.shape == null) goto L9;
        r0.append(", shape=").append(this.shape);
    L9:
        if (this.circular == null) goto L11;
        r0.append(", circular=").append(this.circular);
    L11:
        List<Point> r1 = this.vertices;
        if (r1 != null) goto L14;
    L16:
        Map<String, String> r2 = this.properties;
        if (r2 != null) goto L19;
    L21:
        List<Polygon> r3 = this.polygons;
        if (r3 != null) goto L24;
    L26:
        List<MultiPolygon> r4 = this.multi_polygon;
        if (r4 == null) goto L32;
        if (r4.isEmpty() == true) goto L32;
        r0.append(", multi_polygon=").append(this.multi_polygon);
    L32:
        return r0.replace(0, 2, "Fence{").append('}').toString();
    L24:
        if (r3.isEmpty() == true) goto L26;
        r0.append(", polygons=").append(this.polygons);
        goto L26
    L19:
        if (r2.isEmpty() == true) goto L21;
        r0.append(", properties=").append(this.properties);
        goto L21
    L14:
        if (r1.isEmpty() == true) goto L16;
        r0.append(", vertices=").append(this.vertices);
        goto L16
    }
}
