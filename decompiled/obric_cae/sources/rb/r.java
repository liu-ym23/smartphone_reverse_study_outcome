package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends Message<r, a> {
    public static final b A = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.BizExampleResponse#ADAPTER", tag = 100000)
    @ia.b("bizExampleResponse")
    public final rb.a f11710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SendWsMessageResponse#ADAPTER", tag = 101001)
    @ia.b("sendWsMessageResponse")
    public final t f11711b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgResponse#ADAPTER", tag = 101002)
    @ia.b("subscribeWsMsgResponse")
    public final y f11712m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsStatusResponse#ADAPTER", tag = 101003)
    @ia.b("subscribeWsStatusResponse")
    public final z f11713n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByProviderResponse#ADAPTER", tag = 101004)
    @ia.b("subscribeWsMsgByProviderResponse")
    public final x f11714o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByCallBackResponse#ADAPTER", tag = 101005)
    @ia.b("subscribeWsMsgByCallBackResponse")
    public final w f11715p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByBroadCastResponse#ADAPTER", tag = 101006)
    @ia.b("subscribeWsMsgByBroadCastResponse")
    public final v f11716q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.GetLocationResponse#ADAPTER", tag = 102001)
    @ia.b("getLocationResponse")
    public final g f11717r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.RefreshLocationResponse#ADAPTER", tag = 102002)
    @ia.b("refreshLocationResponse")
    public final p f11718s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.DecodeLocationResponse#ADAPTER", tag = 102003)
    @ia.b("decodeLocationResponse")
    public final c f11719t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.GetIntersectFencesResponse#ADAPTER", tag = 102004)
    @ia.b("getIntersectFencesResponse")
    public final f f11720u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse#ADAPTER", tag = 111001)
    @ia.b("startPicoLinksResponse")
    public final u f11721v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.OnePartyCommonNetworkResponse#ADAPTER", tag = 112001)
    @ia.b("onePartyCommonNetworkResponse")
    public final m f11722w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SendApplogEventResponse#ADAPTER", tag = 112002)
    @ia.b("sendApplogEventResponse")
    public final s f11723x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.GenericNetworkResponse#ADAPTER", tag = 112003)
    @ia.b("genericNetworkResponse")
    public final e f11724y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.GetTTNetParametersResponse#ADAPTER", tag = 112004)
    @ia.b("getTTNetParametersResponse")
    public final h f11725z;

    public static final class a extends Message.Builder<r, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public rb.a f11726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public t f11727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public y f11728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public z f11729d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public x f11730e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public w f11731f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public v f11732g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public g f11733h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public p f11734i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public c f11735j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public f f11736k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public u f11737l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public m f11738m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public s f11739n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public e f11740o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public h f11741p;

        public final r a() {
            return new r(this.f11726a, this.f11727b, this.f11728c, this.f11729d, this.f11730e, this.f11731f, this.f11732g, this.f11733h, this.f11734i, this.f11735j, this.f11736k, this.f11737l, this.f11738m, this.f11739n, this.f11740o, this.f11741p, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<r> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, r.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final r decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L29;
            if (r12 != 100000) goto L8;
            r10.f11726a = (rb.a) rb.a.f11541b.decode(r8);
            goto L3
        L8:
            if (r12 != 111001) goto L9;
            r10.f11737l = (u) u.f11746m.decode(r8);
            goto L3
        L9:
            switch(r12) {
                case 101001: goto L18;
                case 101002: goto L17;
                case 101003: goto L16;
                case 101004: goto L15;
                case 101005: goto L14;
                case 101006: goto L13;
                default: goto L10;
            };
        L13:
            r10.f11732g = (v) v.f11758b.decode(r8);
            goto L3
        L14:
            r10.f11731f = (w) w.f11761b.decode(r8);
            goto L3
        L15:
            r10.f11730e = (x) x.f11764m.decode(r8);
            goto L3
        L16:
            r10.f11729d = (z) z.f11772o.decode(r8);
            goto L3
        L17:
            r10.f11728c = (y) y.f11769b.decode(r8);
            goto L3
        L18:
            r10.f11727b = (t) t.f11743b.decode(r8);
            goto L3
        L10:
            switch(r12) {
                case 102001: goto L22;
                case 102002: goto L21;
                case 102003: goto L20;
                case 102004: goto L19;
                default: goto L11;
            };
        L19:
            r10.f11736k = (f) f.f11597n.decode(r8);
            goto L3
        L20:
            r10.f11735j = (c) c.f11571b.decode(r8);
            goto L3
        L21:
            r10.f11734i = (p) p.f11685m.decode(r8);
            goto L3
        L22:
            r10.f11733h = (g) g.f11604b.decode(r8);
            goto L3
        L11:
            switch(r12) {
                case 112001: goto L26;
                case 112002: goto L25;
                case 112003: goto L24;
                case 112004: goto L23;
                default: goto L12;
            };
        L23:
            r10.f11741p = (h) h.f11607b.decode(r8);
            goto L3
        L24:
            r10.f11740o = (e) e.f11590n.decode(r8);
            goto L3
        L25:
            r10.f11739n = (s) s.f11742a.decode(r8);
            goto L3
        L26:
            r10.f11738m = (m) m.f11667o.decode(r8);
            goto L3
        L12:
            FieldEncoding r13 = r8.peekFieldEncoding();
            r10.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r8));
            goto L3
        L29:
            r8.endMessage(r11);
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, r r10) {
            r r11 = r10;
            rb.a.f11541b.encodeWithTag(r8, 100000, r11.f11710a);
            t.f11743b.encodeWithTag(r8, 101001, r11.f11711b);
            y.f11769b.encodeWithTag(r8, 101002, r11.f11712m);
            z.f11772o.encodeWithTag(r8, 101003, r11.f11713n);
            x.f11764m.encodeWithTag(r8, 101004, r11.f11714o);
            w.f11761b.encodeWithTag(r8, 101005, r11.f11715p);
            v.f11758b.encodeWithTag(r8, 101006, r11.f11716q);
            g.f11604b.encodeWithTag(r8, 102001, r11.f11717r);
            p.f11685m.encodeWithTag(r8, 102002, r11.f11718s);
            c.f11571b.encodeWithTag(r8, 102003, r11.f11719t);
            f.f11597n.encodeWithTag(r8, 102004, r11.f11720u);
            u.f11746m.encodeWithTag(r8, 111001, r11.f11721v);
            m.f11667o.encodeWithTag(r8, 112001, r11.f11722w);
            s.f11742a.encodeWithTag(r8, 112002, r11.f11723x);
            e.f11590n.encodeWithTag(r8, 112003, r11.f11724y);
            h.f11607b.encodeWithTag(r8, 112004, r11.f11725z);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(r r8) {
            r r10 = r8;
            int r11 = rb.a.f11541b.encodedSizeWithTag(100000, r10.f11710a);
            int r12 = t.f11743b.encodedSizeWithTag(101001, r10.f11711b) + r11;
            int r13 = y.f11769b.encodedSizeWithTag(101002, r10.f11712m) + r12;
            int r14 = z.f11772o.encodedSizeWithTag(101003, r10.f11713n) + r13;
            int r15 = x.f11764m.encodedSizeWithTag(101004, r10.f11714o) + r14;
            int r16 = w.f11761b.encodedSizeWithTag(101005, r10.f11715p) + r15;
            int r17 = v.f11758b.encodedSizeWithTag(101006, r10.f11716q) + r16;
            int r18 = g.f11604b.encodedSizeWithTag(102001, r10.f11717r) + r17;
            int r19 = p.f11685m.encodedSizeWithTag(102002, r10.f11718s) + r18;
            int r20 = c.f11571b.encodedSizeWithTag(102003, r10.f11719t) + r19;
            int r21 = f.f11597n.encodedSizeWithTag(102004, r10.f11720u) + r20;
            int r22 = u.f11746m.encodedSizeWithTag(111001, r10.f11721v) + r21;
            int r23 = m.f11667o.encodedSizeWithTag(112001, r10.f11722w) + r22;
            int r24 = s.f11742a.encodedSizeWithTag(112002, r10.f11723x) + r23;
            int r25 = e.f11590n.encodedSizeWithTag(112003, r10.f11724y) + r24;
            int r26 = h.f11607b.encodedSizeWithTag(112004, r10.f11725z) + r25;
            return r10.unknownFields().l() + r26;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final r redact(r r8) {
            a r10 = r8.t();
            rb.a r11 = r10.f11726a;
            if (r11 == null) goto L5;
            r10.f11726a = (rb.a) rb.a.f11541b.redact(r11);
        L5:
            t r12 = r10.f11727b;
            if (r12 == null) goto L8;
            r10.f11727b = (t) t.f11743b.redact(r12);
        L8:
            y r13 = r10.f11728c;
            if (r13 == null) goto L11;
            r10.f11728c = (y) y.f11769b.redact(r13);
        L11:
            z r14 = r10.f11729d;
            if (r14 == null) goto L14;
            r10.f11729d = (z) z.f11772o.redact(r14);
        L14:
            x r15 = r10.f11730e;
            if (r15 == null) goto L17;
            r10.f11730e = (x) x.f11764m.redact(r15);
        L17:
            w r16 = r10.f11731f;
            if (r16 == null) goto L20;
            r10.f11731f = (w) w.f11761b.redact(r16);
        L20:
            v r17 = r10.f11732g;
            if (r17 == null) goto L23;
            r10.f11732g = (v) v.f11758b.redact(r17);
        L23:
            g r18 = r10.f11733h;
            if (r18 == null) goto L26;
            r10.f11733h = (g) g.f11604b.redact(r18);
        L26:
            p r19 = r10.f11734i;
            if (r19 == null) goto L29;
            r10.f11734i = (p) p.f11685m.redact(r19);
        L29:
            c r20 = r10.f11735j;
            if (r20 == null) goto L32;
            r10.f11735j = (c) c.f11571b.redact(r20);
        L32:
            f r21 = r10.f11736k;
            if (r21 == null) goto L35;
            r10.f11736k = (f) f.f11597n.redact(r21);
        L35:
            u r22 = r10.f11737l;
            if (r22 == null) goto L38;
            r10.f11737l = (u) u.f11746m.redact(r22);
        L38:
            m r23 = r10.f11738m;
            if (r23 == null) goto L41;
            r10.f11738m = (m) m.f11667o.redact(r23);
        L41:
            s r24 = r10.f11739n;
            if (r24 == null) goto L44;
            r10.f11739n = (s) s.f11742a.redact(r24);
        L44:
            e r25 = r10.f11740o;
            if (r25 == null) goto L47;
            r10.f11740o = (e) e.f11590n.redact(r25);
        L47:
            h r26 = r10.f11741p;
            if (r26 == null) goto L50;
            r10.f11741p = (h) h.f11607b.redact(r26);
        L50:
            r10.clearUnknownFields();
            return r10.a();
        }
    }

    static {
        A = new b();
    }

    public r(rb.a r8, t r10, y r11, z r12, x r13, w r14, v r15, g r16, p r17, c r18, f r19, u r110, m r111, s r112, e r113, h r114, jf.g r20) {
        super(A, r20);
        this.f11710a = r8;
        this.f11711b = r10;
        this.f11712m = r11;
        this.f11713n = r12;
        this.f11714o = r13;
        this.f11715p = r14;
        this.f11716q = r15;
        this.f11717r = r16;
        this.f11718s = r17;
        this.f11719t = r18;
        this.f11720u = r19;
        this.f11721v = r110;
        this.f11722w = r111;
        this.f11723x = r112;
        this.f11724y = r113;
        this.f11725z = r114;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof r) == true) goto L8;
        return false;
    L8:
        r r10 = (r) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L44;
        if (Internal.equals(this.f11710a, r10.f11710a) == false) goto L44;
        if (Internal.equals(this.f11711b, r10.f11711b) == false) goto L44;
        if (Internal.equals(this.f11712m, r10.f11712m) == false) goto L44;
        if (Internal.equals(this.f11713n, r10.f11713n) == false) goto L44;
        if (Internal.equals(this.f11714o, r10.f11714o) == false) goto L44;
        if (Internal.equals(this.f11715p, r10.f11715p) == false) goto L44;
        if (Internal.equals(this.f11716q, r10.f11716q) == false) goto L44;
        if (Internal.equals(this.f11717r, r10.f11717r) == false) goto L44;
        if (Internal.equals(this.f11718s, r10.f11718s) == false) goto L44;
        if (Internal.equals(this.f11719t, r10.f11719t) == false) goto L44;
        if (Internal.equals(this.f11720u, r10.f11720u) == false) goto L44;
        if (Internal.equals(this.f11721v, r10.f11721v) == false) goto L44;
        if (Internal.equals(this.f11722w, r10.f11722w) == false) goto L44;
        if (Internal.equals(this.f11723x, r10.f11723x) == false) goto L44;
        if (Internal.equals(this.f11724y, r10.f11724y) == false) goto L44;
        if (Internal.equals(this.f11725z, r10.f11725z) == false) goto L44;
        return true;
    L44:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L69;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = 0;
        rb.a r12 = this.f11710a;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        t r15 = this.f11711b;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        y r18 = this.f11712m;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        z r21 = this.f11713n;
        if (r21 == null) goto L19;
        int r22 = r21.hashCode();
    L20:
        int r23 = (r20 + r22) * 37;
        x r24 = this.f11714o;
        if (r24 == null) goto L23;
        int r25 = r24.hashCode();
    L24:
        int r26 = (r23 + r25) * 37;
        w r27 = this.f11715p;
        if (r27 == null) goto L27;
        int r28 = r27.hashCode();
    L28:
        int r29 = (r26 + r28) * 37;
        v r30 = this.f11716q;
        if (r30 == null) goto L31;
        int r31 = r30.hashCode();
    L32:
        int r32 = (r29 + r31) * 37;
        g r33 = this.f11717r;
        if (r33 == null) goto L35;
        int r34 = r33.hashCode();
    L36:
        int r35 = (r32 + r34) * 37;
        p r36 = this.f11718s;
        if (r36 == null) goto L39;
        int r37 = r36.hashCode();
    L40:
        int r38 = (r35 + r37) * 37;
        c r39 = this.f11719t;
        if (r39 == null) goto L43;
        int r40 = r39.hashCode();
    L44:
        int r41 = (r38 + r40) * 37;
        f r42 = this.f11720u;
        if (r42 == null) goto L47;
        int r43 = r42.hashCode();
    L48:
        int r44 = (r41 + r43) * 37;
        u r45 = this.f11721v;
        if (r45 == null) goto L51;
        int r46 = r45.hashCode();
    L52:
        int r47 = (r44 + r46) * 37;
        m r48 = this.f11722w;
        if (r48 == null) goto L55;
        int r49 = r48.hashCode();
    L56:
        int r50 = (r47 + r49) * 37;
        s r51 = this.f11723x;
        if (r51 == null) goto L59;
        int r52 = r51.hashCode();
    L60:
        int r53 = (r50 + r52) * 37;
        e r54 = this.f11724y;
        if (r54 == null) goto L63;
        int r55 = r54.hashCode();
    L64:
        int r56 = (r53 + r55) * 37;
        h r57 = this.f11725z;
        if (r57 == null) goto L67;
        r11 = r57.hashCode();
    L67:
        int r58 = r56 + r11;
        this.hashCode = r58;
        return r58;
    L63:
        r55 = 0;
        goto L64
    L59:
        r52 = 0;
        goto L60
    L55:
        r49 = 0;
        goto L56
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
    L69:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return t();
    }

    public final a t() {
        a r8 = new a();
        r8.f11726a = this.f11710a;
        r8.f11727b = this.f11711b;
        r8.f11728c = this.f11712m;
        r8.f11729d = this.f11713n;
        r8.f11730e = this.f11714o;
        r8.f11731f = this.f11715p;
        r8.f11732g = this.f11716q;
        r8.f11733h = this.f11717r;
        r8.f11734i = this.f11718s;
        r8.f11735j = this.f11719t;
        r8.f11736k = this.f11720u;
        r8.f11737l = this.f11721v;
        r8.f11738m = this.f11722w;
        r8.f11739n = this.f11723x;
        r8.f11740o = this.f11724y;
        r8.f11741p = this.f11725z;
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        rb.a r10 = this.f11710a;
        if (r10 == null) goto L5;
        r8.append(", bizExampleResponse=");
        r8.append(r10);
    L5:
        t r11 = this.f11711b;
        if (r11 == null) goto L8;
        r8.append(", sendWsMessageResponse=");
        r8.append(r11);
    L8:
        y r12 = this.f11712m;
        if (r12 == null) goto L11;
        r8.append(", subscribeWsMsgResponse=");
        r8.append(r12);
    L11:
        z r13 = this.f11713n;
        if (r13 == null) goto L14;
        r8.append(", subscribeWsStatusResponse=");
        r8.append(r13);
    L14:
        x r14 = this.f11714o;
        if (r14 == null) goto L17;
        r8.append(", subscribeWsMsgByProviderResponse=");
        r8.append(r14);
    L17:
        w r15 = this.f11715p;
        if (r15 == null) goto L20;
        r8.append(", subscribeWsMsgByCallBackResponse=");
        r8.append(r15);
    L20:
        v r16 = this.f11716q;
        if (r16 == null) goto L23;
        r8.append(", subscribeWsMsgByBroadCastResponse=");
        r8.append(r16);
    L23:
        g r17 = this.f11717r;
        if (r17 == null) goto L26;
        r8.append(", getLocationResponse=");
        r8.append(r17);
    L26:
        p r18 = this.f11718s;
        if (r18 == null) goto L29;
        r8.append(", refreshLocationResponse=");
        r8.append(r18);
    L29:
        c r19 = this.f11719t;
        if (r19 == null) goto L32;
        r8.append(", decodeLocationResponse=");
        r8.append(r19);
    L32:
        f r20 = this.f11720u;
        if (r20 == null) goto L35;
        r8.append(", getIntersectFencesResponse=");
        r8.append(r20);
    L35:
        u r21 = this.f11721v;
        if (r21 == null) goto L38;
        r8.append(", startPicoLinksResponse=");
        r8.append(r21);
    L38:
        m r22 = this.f11722w;
        if (r22 == null) goto L41;
        r8.append(", onePartyCommonNetworkResponse=");
        r8.append(r22);
    L41:
        s r23 = this.f11723x;
        if (r23 == null) goto L44;
        r8.append(", sendApplogEventResponse=");
        r8.append(r23);
    L44:
        e r24 = this.f11724y;
        if (r24 == null) goto L47;
        r8.append(", genericNetworkResponse=");
        r8.append(r24);
    L47:
        h r25 = this.f11725z;
        if (r25 == null) goto L51;
        r8.append(", getTTNetParametersResponse=");
        r8.append(r25);
    L51:
        return android.aimedia.a.g(r8, 0, 2, "ResponseBody{", '}');
    }
}
