package rb;

import com.obric.cae.location.database.StarCellDbManager;
import com.obric.cae.location.database.StarLocationDbManager;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends Message<i, a> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final b f11610x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    @ia.b(StarCellDbManager.CellInfoEntry.LONGITUDE)
    public final Double f11611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    @ia.b("latitude")
    public final Double f11612b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @ia.b("country")
    public final String f11613m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @ia.b("countryCode")
    public final String f11614n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @ia.b("administrativeArea")
    public final String f11615o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @ia.b("city")
    public final String f11616p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @ia.b("district")
    public final String f11617q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @ia.b("town")
    public final String f11618r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @ia.b("street")
    public final String f11619s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    @ia.b("subAdministrativeArea")
    public final String f11620t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    @ia.b(StarLocationDbManager.CityEntry.LOCALITY)
    public final String f11621u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    @ia.b(StarLocationDbManager.CityEntry.SUB_LOCALITY)
    public final String f11622v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    @ia.b("addressLine")
    public final String f11623w;

    public static final class a extends Message.Builder<i, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f11624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f11625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11627d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f11628e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f11629f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f11630g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f11631h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f11632i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f11633j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f11634k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f11635l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f11636m;

        public a() {
            Double r8 = Double.valueOf(0.0d);
            this.f11624a = r8;
            this.f11625b = r8;
            this.f11626c = "";
            this.f11627d = "";
            this.f11628e = "";
            this.f11629f = "";
            this.f11630g = "";
            this.f11631h = "";
            this.f11632i = "";
            this.f11633j = "";
            this.f11634k = "";
            this.f11635l = "";
            this.f11636m = "";
        }

        public final i a() {
            return new i(this.f11624a, this.f11625b, this.f11626c, this.f11627d, this.f11628e, this.f11629f, this.f11630g, this.f11631h, this.f11632i, this.f11633j, this.f11634k, this.f11635l, this.f11636m, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<i> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, i.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final i decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L20;
            switch(r12) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L7:
            r10.f11636m = ProtoAdapter.STRING.decode(r8);
            goto L3
        L8:
            r10.f11635l = ProtoAdapter.STRING.decode(r8);
            goto L3
        L9:
            r10.f11634k = ProtoAdapter.STRING.decode(r8);
            goto L3
        L10:
            r10.f11633j = ProtoAdapter.STRING.decode(r8);
            goto L3
        L11:
            r10.f11632i = ProtoAdapter.STRING.decode(r8);
            goto L3
        L12:
            r10.f11631h = ProtoAdapter.STRING.decode(r8);
            goto L3
        L13:
            r10.f11630g = ProtoAdapter.STRING.decode(r8);
            goto L3
        L14:
            r10.f11629f = ProtoAdapter.STRING.decode(r8);
            goto L3
        L15:
            r10.f11628e = ProtoAdapter.STRING.decode(r8);
            goto L3
        L16:
            r10.f11627d = ProtoAdapter.STRING.decode(r8);
            goto L3
        L17:
            r10.f11626c = ProtoAdapter.STRING.decode(r8);
            goto L3
        L18:
            r10.f11625b = ProtoAdapter.DOUBLE.decode(r8);
            goto L3
        L19:
            r10.f11624a = ProtoAdapter.DOUBLE.decode(r8);
            goto L3
        L6:
            FieldEncoding r13 = r8.peekFieldEncoding();
            r10.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r8));
            goto L3
        L20:
            r8.endMessage(r11);
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, i r10) {
            i r11 = r10;
            ProtoAdapter<Double> r12 = ProtoAdapter.DOUBLE;
            r12.encodeWithTag(r8, 1, r11.f11611a);
            r12.encodeWithTag(r8, 2, r11.f11612b);
            ProtoAdapter<String> r13 = ProtoAdapter.STRING;
            r13.encodeWithTag(r8, 3, r11.f11613m);
            r13.encodeWithTag(r8, 4, r11.f11614n);
            r13.encodeWithTag(r8, 5, r11.f11615o);
            r13.encodeWithTag(r8, 6, r11.f11616p);
            r13.encodeWithTag(r8, 7, r11.f11617q);
            r13.encodeWithTag(r8, 8, r11.f11618r);
            r13.encodeWithTag(r8, 9, r11.f11619s);
            r13.encodeWithTag(r8, 10, r11.f11620t);
            r13.encodeWithTag(r8, 11, r11.f11621u);
            r13.encodeWithTag(r8, 12, r11.f11622v);
            r13.encodeWithTag(r8, 13, r11.f11623w);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(i r8) {
            i r10 = r8;
            ProtoAdapter<Double> r11 = ProtoAdapter.DOUBLE;
            int r12 = r11.encodedSizeWithTag(1, r10.f11611a);
            int r13 = r11.encodedSizeWithTag(2, r10.f11612b) + r12;
            ProtoAdapter<String> r14 = ProtoAdapter.STRING;
            int r15 = r14.encodedSizeWithTag(3, r10.f11613m) + r13;
            int r16 = r14.encodedSizeWithTag(4, r10.f11614n) + r15;
            int r17 = r14.encodedSizeWithTag(5, r10.f11615o) + r16;
            int r18 = r14.encodedSizeWithTag(6, r10.f11616p) + r17;
            int r19 = r14.encodedSizeWithTag(7, r10.f11617q) + r18;
            int r20 = r14.encodedSizeWithTag(8, r10.f11618r) + r19;
            int r21 = r14.encodedSizeWithTag(9, r10.f11619s) + r20;
            int r22 = r14.encodedSizeWithTag(10, r10.f11620t) + r21;
            int r23 = r14.encodedSizeWithTag(11, r10.f11621u) + r22;
            int r24 = r14.encodedSizeWithTag(12, r10.f11622v) + r23;
            int r25 = r14.encodedSizeWithTag(13, r10.f11623w) + r24;
            return r10.unknownFields().l() + r25;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final i redact(i r8) {
            a r10 = r8.t();
            r10.clearUnknownFields();
            return r10.a();
        }
    }

    static {
        f11610x = new b();
    }

    public i(Double r8, Double r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110, String r111, jf.g r112) {
        super(f11610x, r112);
        this.f11611a = r8;
        this.f11612b = r10;
        this.f11613m = r11;
        this.f11614n = r12;
        this.f11615o = r13;
        this.f11616p = r14;
        this.f11617q = r15;
        this.f11618r = r16;
        this.f11619s = r17;
        this.f11620t = r18;
        this.f11621u = r19;
        this.f11622v = r110;
        this.f11623w = r111;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof i) == true) goto L8;
        return false;
    L8:
        i r10 = (i) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L38;
        if (Internal.equals(this.f11611a, r10.f11611a) == false) goto L38;
        if (Internal.equals(this.f11612b, r10.f11612b) == false) goto L38;
        if (Internal.equals(this.f11613m, r10.f11613m) == false) goto L38;
        if (Internal.equals(this.f11614n, r10.f11614n) == false) goto L38;
        if (Internal.equals(this.f11615o, r10.f11615o) == false) goto L38;
        if (Internal.equals(this.f11616p, r10.f11616p) == false) goto L38;
        if (Internal.equals(this.f11617q, r10.f11617q) == false) goto L38;
        if (Internal.equals(this.f11618r, r10.f11618r) == false) goto L38;
        if (Internal.equals(this.f11619s, r10.f11619s) == false) goto L38;
        if (Internal.equals(this.f11620t, r10.f11620t) == false) goto L38;
        if (Internal.equals(this.f11621u, r10.f11621u) == false) goto L38;
        if (Internal.equals(this.f11622v, r10.f11622v) == false) goto L38;
        if (Internal.equals(this.f11623w, r10.f11623w) == false) goto L38;
        return true;
    L38:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L57;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = 0;
        Double r12 = this.f11611a;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Double r15 = this.f11612b;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        String r18 = this.f11613m;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        String r21 = this.f11614n;
        if (r21 == null) goto L19;
        int r22 = r21.hashCode();
    L20:
        int r23 = (r20 + r22) * 37;
        String r24 = this.f11615o;
        if (r24 == null) goto L23;
        int r25 = r24.hashCode();
    L24:
        int r26 = (r23 + r25) * 37;
        String r27 = this.f11616p;
        if (r27 == null) goto L27;
        int r28 = r27.hashCode();
    L28:
        int r29 = (r26 + r28) * 37;
        String r30 = this.f11617q;
        if (r30 == null) goto L31;
        int r31 = r30.hashCode();
    L32:
        int r32 = (r29 + r31) * 37;
        String r33 = this.f11618r;
        if (r33 == null) goto L35;
        int r34 = r33.hashCode();
    L36:
        int r35 = (r32 + r34) * 37;
        String r36 = this.f11619s;
        if (r36 == null) goto L39;
        int r37 = r36.hashCode();
    L40:
        int r38 = (r35 + r37) * 37;
        String r39 = this.f11620t;
        if (r39 == null) goto L43;
        int r40 = r39.hashCode();
    L44:
        int r41 = (r38 + r40) * 37;
        String r42 = this.f11621u;
        if (r42 == null) goto L47;
        int r43 = r42.hashCode();
    L48:
        int r44 = (r41 + r43) * 37;
        String r45 = this.f11622v;
        if (r45 == null) goto L51;
        int r46 = r45.hashCode();
    L52:
        int r47 = (r44 + r46) * 37;
        String r48 = this.f11623w;
        if (r48 == null) goto L55;
        r11 = r48.hashCode();
    L55:
        int r49 = r47 + r11;
        this.hashCode = r49;
        return r49;
    L51:
        r46 = 0;
        goto L52
    L47:
        r43 = 0;
        goto L48
    L43:
        r40 = 0;
        goto L44
    L39:
        r37 = 0;
        goto L40
    L35:
        r34 = 0;
        goto L36
    L31:
        r31 = 0;
        goto L32
    L27:
        r28 = 0;
        goto L28
    L23:
        r25 = 0;
        goto L24
    L19:
        r22 = 0;
        goto L20
    L15:
        r19 = 0;
        goto L16
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L57:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return t();
    }

    public final a t() {
        a r8 = new a();
        r8.f11624a = this.f11611a;
        r8.f11625b = this.f11612b;
        r8.f11626c = this.f11613m;
        r8.f11627d = this.f11614n;
        r8.f11628e = this.f11615o;
        r8.f11629f = this.f11616p;
        r8.f11630g = this.f11617q;
        r8.f11631h = this.f11618r;
        r8.f11632i = this.f11619s;
        r8.f11633j = this.f11620t;
        r8.f11634k = this.f11621u;
        r8.f11635l = this.f11622v;
        r8.f11636m = this.f11623w;
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        Double r10 = this.f11611a;
        if (r10 == null) goto L5;
        r8.append(", longitude=");
        r8.append(r10);
    L5:
        Double r11 = this.f11612b;
        if (r11 == null) goto L8;
        r8.append(", latitude=");
        r8.append(r11);
    L8:
        String r12 = this.f11613m;
        if (r12 == null) goto L11;
        r8.append(", country=");
        r8.append(r12);
    L11:
        String r13 = this.f11614n;
        if (r13 == null) goto L14;
        r8.append(", countryCode=");
        r8.append(r13);
    L14:
        String r14 = this.f11615o;
        if (r14 == null) goto L17;
        r8.append(", administrativeArea=");
        r8.append(r14);
    L17:
        String r15 = this.f11616p;
        if (r15 == null) goto L20;
        r8.append(", city=");
        r8.append(r15);
    L20:
        String r16 = this.f11617q;
        if (r16 == null) goto L23;
        r8.append(", district=");
        r8.append(r16);
    L23:
        String r17 = this.f11618r;
        if (r17 == null) goto L26;
        r8.append(", town=");
        r8.append(r17);
    L26:
        String r18 = this.f11619s;
        if (r18 == null) goto L29;
        r8.append(", street=");
        r8.append(r18);
    L29:
        String r19 = this.f11620t;
        if (r19 == null) goto L32;
        r8.append(", subAdministrativeArea=");
        r8.append(r19);
    L32:
        String r20 = this.f11621u;
        if (r20 == null) goto L35;
        r8.append(", locality=");
        r8.append(r20);
    L35:
        String r21 = this.f11622v;
        if (r21 == null) goto L38;
        r8.append(", subLocality=");
        r8.append(r21);
    L38:
        String r22 = this.f11623w;
        if (r22 == null) goto L42;
        r8.append(", addressLine=");
        r8.append(r22);
    L42:
        return android.aimedia.a.g(r8, 0, 2, "LocationInfo{", '}');
    }
}
