package com.obric.matrix.proto;

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
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class Polygon extends Message<Polygon, a> {
    public static final ProtoAdapter<Polygon> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("vertices")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Point> vertices;

    public static final class a extends Message.Builder<Polygon, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<Point> f8197a;

        public a() {
            this.f8197a = Internal.newMutableList();
        }

        public Polygon a() {
            return new Polygon(this.f8197a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<Polygon> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, Polygon.class);
        }

        public int a(Polygon r3) {
            return Point.ADAPTER.asRepeated().encodedSizeWithTag(1, r3.vertices) + r3.unknownFields().size();
        }

        public Polygon a(ProtoReader r7) {
            a r6 = new a();
            long r0 = r7.beginMessage();
        L3:
            int r2 = r7.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r6.f8197a.add((Point) ZeusTransformUtils.preCheckCast(Point.ADAPTER.decode(r7), Point.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r7.peekFieldEncoding();
            r6.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r0);
            return r6.a();
        }

        public void a(ProtoWriter r3, Polygon r4) {
            Point.ADAPTER.asRepeated().encodeWithTag(r3, 1, r4.vertices);
            r3.writeBytes(r4.unknownFields());
        }

        public Polygon b(Polygon r2) {
            a r1 = r2.newBuilder();
            Internal.redactElements(r1.f8197a, Point.ADAPTER);
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Polygon decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, Polygon r4) {
            a(r3, (Polygon) ZeusTransformUtils.preCheckCast(r4, Polygon.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(Polygon r3) {
            return a((Polygon) ZeusTransformUtils.preCheckCast(r3, Polygon.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Polygon redact(Polygon r3) {
            return b((Polygon) ZeusTransformUtils.preCheckCast(r3, Polygon.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public Polygon(List<Point> r3) {
        this((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public Polygon(List<Point> r3, ByteString r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r4);
        this.vertices = Internal.immutableCopyOf("vertices", r5);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Polygon.class) == true) goto L8;
        return false;
    L8:
        Polygon r6 = (Polygon) ZeusTransformUtils.preCheckCast(r5, Polygon.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.vertices.equals(r6.vertices) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.vertices.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8197a = Internal.copyOf("vertices", this.vertices);
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
        List<Point> r1 = this.vertices;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", vertices=").append(this.vertices);
    L8:
        return r0.replace(0, 2, "Polygon{").append('}').toString();
    }
}
