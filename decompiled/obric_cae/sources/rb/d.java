package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Message<d, a> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final b f11574r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @ia.b("fenceid")
    public final String f11575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @ia.b("shape")
    public final Integer f11576b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Circle#ADAPTER", tag = 3)
    @ia.b("circular")
    public final rb.b f11577m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    @ia.b("vertices")
    public final List<n> f11578n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @ia.b("properties")
    public final Map<String, String> f11579o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Polygon#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    @ia.b("polygons")
    public final List<o> f11580p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.MultiPolygon#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    @ia.b("multi_polygon")
    public final List<l> f11581q;

    public static final class a extends Message.Builder<d, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f11583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public rb.b f11584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<n> f11585d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f11586e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<o> f11587f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<l> f11588g;

        public a() {
            this.f11582a = "";
            this.f11583b = 0;
            this.f11585d = Internal.newMutableList();
            this.f11586e = Internal.newMutableMap();
            this.f11587f = Internal.newMutableList();
            this.f11588g = Internal.newMutableList();
        }

        public final d a() {
            return new d(this.f11582a, this.f11583b, this.f11584c, this.f11585d, this.f11586e, this.f11587f, this.f11588g, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter<Map<String, String>> f11589a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, d.class);
            ProtoAdapter<String> r8 = ProtoAdapter.STRING;
            this.f11589a = ProtoAdapter.newMapAdapter(r8, r8);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final d decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L15;
            switch(r12) {
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
            List r13 = r10.f11588g;
            Message r14 = (l) l.f11664b.decode(r8);
        L11:
            r13.add(r14);
            goto L3
        L8:
            r13 = r10.f11587f;
            r14 = (o) o.f11682b.decode(r8);
            goto L11
        L9:
            r10.f11586e.putAll(this.f11589a.decode(r8));
            goto L3
        L10:
            r13 = r10.f11585d;
            r14 = (n) n.f11677m.decode(r8);
            goto L11
        L12:
            r10.f11584c = (rb.b) rb.b.f11566m.decode(r8);
            goto L3
        L13:
            r10.f11583b = ProtoAdapter.INT32.decode(r8);
            goto L3
        L14:
            r10.f11582a = ProtoAdapter.STRING.decode(r8);
            goto L3
        L6:
            FieldEncoding r15 = r8.peekFieldEncoding();
            r10.addUnknownField(r12, r15, r15.rawProtoAdapter().decode(r8));
            goto L3
        L15:
            r8.endMessage(r11);
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, d r10) {
            d r11 = r10;
            ProtoAdapter.STRING.encodeWithTag(r8, 1, r11.f11575a);
            ProtoAdapter.INT32.encodeWithTag(r8, 2, r11.f11576b);
            rb.b.f11566m.encodeWithTag(r8, 3, r11.f11577m);
            n.f11677m.asRepeated().encodeWithTag(r8, 4, r11.f11578n);
            this.f11589a.encodeWithTag(r8, 5, r11.f11579o);
            o.f11682b.asRepeated().encodeWithTag(r8, 6, r11.f11580p);
            l.f11664b.asRepeated().encodeWithTag(r8, 7, r11.f11581q);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(d r8) {
            d r10 = r8;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(1, r10.f11575a);
            int r12 = ProtoAdapter.INT32.encodedSizeWithTag(2, r10.f11576b) + r11;
            int r13 = rb.b.f11566m.encodedSizeWithTag(3, r10.f11577m) + r12;
            int r14 = n.f11677m.asRepeated().encodedSizeWithTag(4, r10.f11578n) + r13;
            int r15 = this.f11589a.encodedSizeWithTag(5, r10.f11579o) + r14;
            int r16 = o.f11682b.asRepeated().encodedSizeWithTag(6, r10.f11580p) + r15;
            int r17 = l.f11664b.asRepeated().encodedSizeWithTag(7, r10.f11581q) + r16;
            return r10.unknownFields().l() + r17;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final d redact(d r8) {
            a r10 = r8.t();
            rb.b r11 = r10.f11584c;
            if (r11 == null) goto L5;
            r10.f11584c = (rb.b) rb.b.f11566m.redact(r11);
        L5:
            Internal.redactElements(r10.f11585d, n.f11677m);
            Internal.redactElements(r10.f11587f, o.f11682b);
            Internal.redactElements(r10.f11588g, l.f11664b);
            r10.clearUnknownFields();
            return r10.a();
        }
    }

    static {
        f11574r = new b();
    }

    public d(String r8, Integer r10, rb.b r11, List<n> r12, Map<String, String> r13, List<o> r14, List<l> r15, jf.g r16) {
        super(f11574r, r16);
        this.f11575a = r8;
        this.f11576b = r10;
        this.f11577m = r11;
        this.f11578n = Internal.immutableCopyOf("vertices", r12);
        this.f11579o = Internal.immutableCopyOf("properties", r13);
        this.f11580p = Internal.immutableCopyOf("polygons", r14);
        this.f11581q = Internal.immutableCopyOf("multi_polygon", r15);
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L26;
        if (Internal.equals(this.f11575a, r10.f11575a) == false) goto L26;
        if (Internal.equals(this.f11576b, r10.f11576b) == false) goto L26;
        if (Internal.equals(this.f11577m, r10.f11577m) == false) goto L26;
        if (this.f11578n.equals(r10.f11578n) == false) goto L26;
        if (this.f11579o.equals(r10.f11579o) == false) goto L26;
        if (this.f11580p.equals(r10.f11580p) == false) goto L26;
        if (this.f11581q.equals(r10.f11581q) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L17;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = 0;
        String r12 = this.f11575a;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Integer r15 = this.f11576b;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        rb.b r18 = this.f11577m;
        if (r18 == null) goto L15;
        r11 = r18.hashCode();
    L15:
        int r19 = this.f11581q.hashCode() + ((this.f11580p.hashCode() + ((this.f11579o.hashCode() + ((this.f11578n.hashCode() + ((r17 + r11) * 37)) * 37)) * 37)) * 37);
        this.hashCode = r19;
        return r19;
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L17:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return t();
    }

    public final a t() {
        a r8 = new a();
        r8.f11582a = this.f11575a;
        r8.f11583b = this.f11576b;
        r8.f11584c = this.f11577m;
        r8.f11585d = Internal.copyOf("vertices", this.f11578n);
        r8.f11586e = Internal.copyOf("properties", this.f11579o);
        r8.f11587f = Internal.copyOf("polygons", this.f11580p);
        r8.f11588g = Internal.copyOf("multi_polygon", this.f11581q);
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        String r10 = this.f11575a;
        if (r10 == null) goto L5;
        r8.append(", fenceid=");
        r8.append(r10);
    L5:
        Integer r11 = this.f11576b;
        if (r11 == null) goto L8;
        r8.append(", shape=");
        r8.append(r11);
    L8:
        rb.b r12 = this.f11577m;
        if (r12 == null) goto L11;
        r8.append(", circular=");
        r8.append(r12);
    L11:
        List<n> r13 = this.f11578n;
        if (r13 != null) goto L14;
    L16:
        Map<String, String> r14 = this.f11579o;
        if (r14 != null) goto L19;
    L21:
        List<o> r15 = this.f11580p;
        if (r15 != null) goto L24;
    L26:
        List<l> r16 = this.f11581q;
        if (r16 == null) goto L32;
        if (r16.isEmpty() == true) goto L32;
        r8.append(", multi_polygon=");
        r8.append(r16);
    L32:
        return android.aimedia.a.g(r8, 0, 2, "Fence{", '}');
    L24:
        if (r15.isEmpty() == true) goto L26;
        r8.append(", polygons=");
        r8.append(r15);
        goto L26
    L19:
        if (r14.isEmpty() == true) goto L21;
        r8.append(", properties=");
        r8.append(r14);
        goto L21
    L14:
        if (r13.isEmpty() == true) goto L16;
        r8.append(", vertices=");
        r8.append(r13);
        goto L16
    }
}
