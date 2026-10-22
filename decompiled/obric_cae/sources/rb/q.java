package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends Message<q, a> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final b f11690t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @ia.b("cmd")
    public final Integer f11691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @ia.b("statusCode")
    public final Integer f11692b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @ia.b("errorMsg")
    public final String f11693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @ia.b("logId")
    public final String f11694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @ia.b("sequenceId")
    public final String f11695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.ResponseBody#ADAPTER", tag = 7)
    @ia.b("body")
    public final r f11696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @ia.b("accessToken")
    public final String f11697q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 9)
    @ia.b("monitorInfo")
    public final k f11698r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    @ia.b("extraParams")
    public final Map<String, String> f11699s;

    public static final class a extends Message.Builder<q, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f11700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f11701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11703d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f11704e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public r f11705f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f11706g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public k f11707h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Map<String, String> f11708i;

        public a() {
            this.f11700a = 0;
            this.f11701b = 0;
            this.f11702c = "";
            this.f11703d = "";
            this.f11704e = "";
            this.f11706g = "";
            this.f11708i = Internal.newMutableMap();
        }

        public final q a() {
            return new q(this.f11700a, this.f11701b, this.f11702c, this.f11703d, this.f11704e, this.f11705f, this.f11706g, this.f11707h, this.f11708i, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter<Map<String, String>> f11709a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, q.class);
            ProtoAdapter<String> r8 = ProtoAdapter.STRING;
            this.f11709a = ProtoAdapter.newMapAdapter(r8, r8);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final q decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L16;
            switch(r12) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L6;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r10.f11708i.putAll(this.f11709a.decode(r8));
            goto L3
        L8:
            r10.f11707h = (k) k.f11653p.decode(r8);
            goto L3
        L9:
            r10.f11706g = ProtoAdapter.STRING.decode(r8);
            goto L3
        L10:
            r10.f11705f = (r) r.A.decode(r8);
            goto L3
        L11:
            r10.f11704e = ProtoAdapter.STRING.decode(r8);
            goto L3
        L12:
            r10.f11703d = ProtoAdapter.STRING.decode(r8);
            goto L3
        L13:
            r10.f11702c = ProtoAdapter.STRING.decode(r8);
            goto L3
        L14:
            r10.f11701b = ProtoAdapter.INT32.decode(r8);
            goto L3
        L15:
            r10.f11700a = ProtoAdapter.INT32.decode(r8);
            goto L3
        L6:
            FieldEncoding r13 = r8.peekFieldEncoding();
            r10.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r8));
            goto L3
        L16:
            r8.endMessage(r11);
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, q r10) {
            q r11 = r10;
            ProtoAdapter<Integer> r12 = ProtoAdapter.INT32;
            r12.encodeWithTag(r8, 1, r11.f11691a);
            r12.encodeWithTag(r8, 2, r11.f11692b);
            ProtoAdapter<String> r13 = ProtoAdapter.STRING;
            r13.encodeWithTag(r8, 3, r11.f11693m);
            r13.encodeWithTag(r8, 4, r11.f11694n);
            r13.encodeWithTag(r8, 6, r11.f11695o);
            r.A.encodeWithTag(r8, 7, r11.f11696p);
            r13.encodeWithTag(r8, 8, r11.f11697q);
            k.f11653p.encodeWithTag(r8, 9, r11.f11698r);
            this.f11709a.encodeWithTag(r8, 10, r11.f11699s);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(q r8) {
            q r10 = r8;
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            int r12 = r11.encodedSizeWithTag(1, r10.f11691a);
            int r13 = r11.encodedSizeWithTag(2, r10.f11692b) + r12;
            ProtoAdapter<String> r14 = ProtoAdapter.STRING;
            int r15 = r14.encodedSizeWithTag(3, r10.f11693m) + r13;
            int r16 = r14.encodedSizeWithTag(4, r10.f11694n) + r15;
            int r17 = r14.encodedSizeWithTag(6, r10.f11695o) + r16;
            int r18 = r.A.encodedSizeWithTag(7, r10.f11696p) + r17;
            int r19 = r14.encodedSizeWithTag(8, r10.f11697q) + r18;
            int r20 = k.f11653p.encodedSizeWithTag(9, r10.f11698r) + r19;
            int r21 = this.f11709a.encodedSizeWithTag(10, r10.f11699s) + r20;
            return r10.unknownFields().l() + r21;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final q redact(q r8) {
            a r10 = r8.t();
            r r11 = r10.f11705f;
            if (r11 == null) goto L5;
            r10.f11705f = (r) r.A.redact(r11);
        L5:
            k r12 = r10.f11707h;
            if (r12 == null) goto L8;
            r10.f11707h = (k) k.f11653p.redact(r12);
        L8:
            r10.clearUnknownFields();
            return r10.a();
        }
    }

    static {
        f11690t = new b();
    }

    public q(Integer r8, Integer r10, String r11, String r12, String r13, r r14, String r15, k r16, Map<String, String> r17, jf.g r18) {
        super(f11690t, r18);
        this.f11691a = r8;
        this.f11692b = r10;
        this.f11693m = r11;
        this.f11694n = r12;
        this.f11695o = r13;
        this.f11696p = r14;
        this.f11697q = r15;
        this.f11698r = r16;
        this.f11699s = Internal.immutableCopyOf("extraParams", r17);
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof q) == true) goto L8;
        return false;
    L8:
        q r10 = (q) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L30;
        if (Internal.equals(this.f11691a, r10.f11691a) == false) goto L30;
        if (Internal.equals(this.f11692b, r10.f11692b) == false) goto L30;
        if (Internal.equals(this.f11693m, r10.f11693m) == false) goto L30;
        if (Internal.equals(this.f11694n, r10.f11694n) == false) goto L30;
        if (Internal.equals(this.f11695o, r10.f11695o) == false) goto L30;
        if (Internal.equals(this.f11696p, r10.f11696p) == false) goto L30;
        if (Internal.equals(this.f11697q, r10.f11697q) == false) goto L30;
        if (Internal.equals(this.f11698r, r10.f11698r) == false) goto L30;
        if (this.f11699s.equals(r10.f11699s) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L37;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = 0;
        Integer r12 = this.f11691a;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Integer r15 = this.f11692b;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        String r18 = this.f11693m;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        String r21 = this.f11694n;
        if (r21 == null) goto L19;
        int r22 = r21.hashCode();
    L20:
        int r23 = (r20 + r22) * 37;
        String r24 = this.f11695o;
        if (r24 == null) goto L23;
        int r25 = r24.hashCode();
    L24:
        int r26 = (r23 + r25) * 37;
        r r27 = this.f11696p;
        if (r27 == null) goto L27;
        int r28 = r27.hashCode();
    L28:
        int r29 = (r26 + r28) * 37;
        String r30 = this.f11697q;
        if (r30 == null) goto L31;
        int r31 = r30.hashCode();
    L32:
        int r32 = (r29 + r31) * 37;
        k r33 = this.f11698r;
        if (r33 == null) goto L35;
        r11 = r33.hashCode();
    L35:
        int r34 = ((r32 + r11) * 37) + this.f11699s.hashCode();
        this.hashCode = r34;
        return r34;
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
    L37:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return t();
    }

    public final a t() {
        a r8 = new a();
        r8.f11700a = this.f11691a;
        r8.f11701b = this.f11692b;
        r8.f11702c = this.f11693m;
        r8.f11703d = this.f11694n;
        r8.f11704e = this.f11695o;
        r8.f11705f = this.f11696p;
        r8.f11706g = this.f11697q;
        r8.f11707h = this.f11698r;
        r8.f11708i = Internal.copyOf("extraParams", this.f11699s);
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        Integer r10 = this.f11691a;
        if (r10 == null) goto L5;
        r8.append(", cmd=");
        r8.append(r10);
    L5:
        Integer r11 = this.f11692b;
        if (r11 == null) goto L8;
        r8.append(", statusCode=");
        r8.append(r11);
    L8:
        String r12 = this.f11693m;
        if (r12 == null) goto L11;
        r8.append(", errorMsg=");
        r8.append(r12);
    L11:
        String r13 = this.f11694n;
        if (r13 == null) goto L14;
        r8.append(", logId=");
        r8.append(r13);
    L14:
        String r14 = this.f11695o;
        if (r14 == null) goto L17;
        r8.append(", sequenceId=");
        r8.append(r14);
    L17:
        r r15 = this.f11696p;
        if (r15 == null) goto L20;
        r8.append(", body=");
        r8.append(r15);
    L20:
        String r16 = this.f11697q;
        if (r16 == null) goto L23;
        r8.append(", accessToken=");
        r8.append(r16);
    L23:
        k r17 = this.f11698r;
        if (r17 == null) goto L26;
        r8.append(", monitorInfo=");
        r8.append(r17);
    L26:
        Map<String, String> r18 = this.f11699s;
        if (r18 == null) goto L32;
        if (r18.isEmpty() == true) goto L32;
        r8.append(", extraParams=");
        r8.append(r18);
    L32:
        return android.aimedia.a.g(r8, 0, 2, "Response{", '}');
    }
}
