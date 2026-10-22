package rb;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends Message<a0, a> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final b f11544u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    @ia.b("seqId")
    public final Long f11545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    @ia.b("logId")
    public final Long f11546b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @ia.b("service")
    public final Integer f11547m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    @ia.b(BdimCategoryConstants.INTENT_KEY_METHOD)
    public final Integer f11548n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @ia.b("payloadType")
    public final String f11549o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @ia.b("payloadEncoding")
    public final String f11550p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    @ia.b(WsConstants.KEY_PAYLOAD)
    public final jf.g f11551q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    @ia.b("cmd")
    public final Integer f11552r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    @ia.b("channelId")
    public final Integer f11553s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    @ia.b("headers")
    public final Map<String, String> f11554t;

    public static final class a extends Message.Builder<a0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f11555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f11556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f11557c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f11558d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f11559e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f11560f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public jf.g f11561g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Integer f11562h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f11563i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Map<String, String> f11564j;

        public a() {
            this.f11555a = 0L;
            this.f11556b = 0L;
            this.f11557c = 0;
            this.f11558d = 0;
            this.f11559e = "";
            this.f11560f = "";
            this.f11561g = jf.g.f8841o;
            this.f11562h = 0;
            this.f11563i = 0;
            this.f11564j = Internal.newMutableMap();
        }

        public final a0 a() {
            return new a0(this.f11555a, this.f11556b, this.f11557c, this.f11558d, this.f11559e, this.f11560f, this.f11561g, this.f11562h, this.f11563i, this.f11564j, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<a0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter<Map<String, String>> f11565a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, a0.class);
            ProtoAdapter<String> r8 = ProtoAdapter.STRING;
            this.f11565a = ProtoAdapter.newMapAdapter(r8, r8);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final a0 decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L17;
            switch(r12) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L6;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r10.f11564j.putAll(this.f11565a.decode(r8));
            goto L3
        L8:
            r10.f11563i = ProtoAdapter.INT32.decode(r8);
            goto L3
        L9:
            r10.f11562h = ProtoAdapter.INT32.decode(r8);
            goto L3
        L10:
            r10.f11561g = ProtoAdapter.BYTES.decode(r8);
            goto L3
        L11:
            r10.f11560f = ProtoAdapter.STRING.decode(r8);
            goto L3
        L12:
            r10.f11559e = ProtoAdapter.STRING.decode(r8);
            goto L3
        L13:
            r10.f11558d = ProtoAdapter.INT32.decode(r8);
            goto L3
        L14:
            r10.f11557c = ProtoAdapter.INT32.decode(r8);
            goto L3
        L15:
            r10.f11556b = ProtoAdapter.INT64.decode(r8);
            goto L3
        L16:
            r10.f11555a = ProtoAdapter.INT64.decode(r8);
            goto L3
        L6:
            FieldEncoding r13 = r8.peekFieldEncoding();
            r10.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r8));
            goto L3
        L17:
            r8.endMessage(r11);
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, a0 r10) {
            a0 r11 = r10;
            ProtoAdapter<Long> r12 = ProtoAdapter.INT64;
            r12.encodeWithTag(r8, 1, r11.f11545a);
            r12.encodeWithTag(r8, 2, r11.f11546b);
            ProtoAdapter<Integer> r13 = ProtoAdapter.INT32;
            r13.encodeWithTag(r8, 3, r11.f11547m);
            r13.encodeWithTag(r8, 4, r11.f11548n);
            ProtoAdapter<String> r14 = ProtoAdapter.STRING;
            r14.encodeWithTag(r8, 6, r11.f11549o);
            r14.encodeWithTag(r8, 7, r11.f11550p);
            ProtoAdapter.BYTES.encodeWithTag(r8, 8, r11.f11551q);
            r13.encodeWithTag(r8, 9, r11.f11552r);
            r13.encodeWithTag(r8, 10, r11.f11553s);
            Map<String, String> r15 = r11.f11554t;
            this.f11565a.encodeWithTag(r8, 11, r15);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(a0 r8) {
            a0 r10 = r8;
            ProtoAdapter<Long> r11 = ProtoAdapter.INT64;
            int r12 = r11.encodedSizeWithTag(1, r10.f11545a);
            int r13 = r11.encodedSizeWithTag(2, r10.f11546b) + r12;
            ProtoAdapter<Integer> r14 = ProtoAdapter.INT32;
            int r15 = r14.encodedSizeWithTag(3, r10.f11547m) + r13;
            int r16 = r14.encodedSizeWithTag(4, r10.f11548n) + r15;
            ProtoAdapter<String> r17 = ProtoAdapter.STRING;
            int r18 = r17.encodedSizeWithTag(6, r10.f11549o) + r16;
            int r19 = r17.encodedSizeWithTag(7, r10.f11550p) + r18;
            int r20 = ProtoAdapter.BYTES.encodedSizeWithTag(8, r10.f11551q) + r19;
            int r21 = r14.encodedSizeWithTag(9, r10.f11552r) + r20;
            int r22 = r14.encodedSizeWithTag(10, r10.f11553s) + r21;
            Map<String, String> r23 = r10.f11554t;
            int r24 = this.f11565a.encodedSizeWithTag(11, r23) + r22;
            return r10.unknownFields().l() + r24;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final a0 redact(a0 r8) {
            a r10 = r8.t();
            r10.clearUnknownFields();
            return r10.a();
        }
    }

    static {
        f11544u = new b();
        char[] r8 = jf.g.f8840n;
    }

    public a0(Long r8, Long r10, Integer r11, Integer r12, String r13, String r14, jf.g r15, Integer r16, Integer r17, Map<String, String> r18, jf.g r19) {
        super(f11544u, r19);
        this.f11545a = r8;
        this.f11546b = r10;
        this.f11547m = r11;
        this.f11548n = r12;
        this.f11549o = r13;
        this.f11550p = r14;
        this.f11551q = r15;
        this.f11552r = r16;
        this.f11553s = r17;
        this.f11554t = Internal.immutableCopyOf("headers", r18);
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r10 = (a0) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L32;
        if (Internal.equals(this.f11545a, r10.f11545a) == false) goto L32;
        if (Internal.equals(this.f11546b, r10.f11546b) == false) goto L32;
        if (Internal.equals(this.f11547m, r10.f11547m) == false) goto L32;
        if (Internal.equals(this.f11548n, r10.f11548n) == false) goto L32;
        if (Internal.equals(this.f11549o, r10.f11549o) == false) goto L32;
        if (Internal.equals(this.f11550p, r10.f11550p) == false) goto L32;
        if (Internal.equals(this.f11551q, r10.f11551q) == false) goto L32;
        if (Internal.equals(this.f11552r, r10.f11552r) == false) goto L32;
        if (Internal.equals(this.f11553s, r10.f11553s) == false) goto L32;
        if (this.f11554t.equals(r10.f11554t) == false) goto L32;
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L41;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = 0;
        Long r12 = this.f11545a;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Long r15 = this.f11546b;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        Integer r18 = this.f11547m;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        Integer r21 = this.f11548n;
        if (r21 == null) goto L19;
        int r22 = r21.hashCode();
    L20:
        int r23 = (r20 + r22) * 37;
        String r24 = this.f11549o;
        if (r24 == null) goto L23;
        int r25 = r24.hashCode();
    L24:
        int r26 = (r23 + r25) * 37;
        String r27 = this.f11550p;
        if (r27 == null) goto L27;
        int r28 = r27.hashCode();
    L28:
        int r29 = (r26 + r28) * 37;
        jf.g r30 = this.f11551q;
        if (r30 == null) goto L31;
        int r31 = r30.hashCode();
    L32:
        int r32 = (r29 + r31) * 37;
        Integer r33 = this.f11552r;
        if (r33 == null) goto L35;
        int r34 = r33.hashCode();
    L36:
        int r35 = (r32 + r34) * 37;
        Integer r36 = this.f11553s;
        if (r36 == null) goto L39;
        r11 = r36.hashCode();
    L39:
        int r37 = ((r35 + r11) * 37) + this.f11554t.hashCode();
        this.hashCode = r37;
        return r37;
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
    L41:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return t();
    }

    public final a t() {
        a r8 = new a();
        r8.f11555a = this.f11545a;
        r8.f11556b = this.f11546b;
        r8.f11557c = this.f11547m;
        r8.f11558d = this.f11548n;
        r8.f11559e = this.f11549o;
        r8.f11560f = this.f11550p;
        r8.f11561g = this.f11551q;
        r8.f11562h = this.f11552r;
        r8.f11563i = this.f11553s;
        r8.f11564j = Internal.copyOf("headers", this.f11554t);
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        Long r10 = this.f11545a;
        if (r10 == null) goto L5;
        r8.append(", seqId=");
        r8.append(r10);
    L5:
        Long r11 = this.f11546b;
        if (r11 == null) goto L8;
        r8.append(", logId=");
        r8.append(r11);
    L8:
        Integer r12 = this.f11547m;
        if (r12 == null) goto L11;
        r8.append(", service=");
        r8.append(r12);
    L11:
        Integer r13 = this.f11548n;
        if (r13 == null) goto L14;
        r8.append(", method=");
        r8.append(r13);
    L14:
        String r14 = this.f11549o;
        if (r14 == null) goto L17;
        r8.append(", payloadType=");
        r8.append(r14);
    L17:
        String r15 = this.f11550p;
        if (r15 == null) goto L20;
        r8.append(", payloadEncoding=");
        r8.append(r15);
    L20:
        jf.g r16 = this.f11551q;
        if (r16 == null) goto L23;
        r8.append(", payload=");
        r8.append(r16);
    L23:
        Integer r17 = this.f11552r;
        if (r17 == null) goto L26;
        r8.append(", cmd=");
        r8.append(r17);
    L26:
        Integer r18 = this.f11553s;
        if (r18 == null) goto L29;
        r8.append(", channelId=");
        r8.append(r18);
    L29:
        Map<String, String> r19 = this.f11554t;
        if (r19 == null) goto L35;
        if (r19.isEmpty() == true) goto L35;
        r8.append(", headers=");
        r8.append(r19);
    L35:
        return android.aimedia.a.g(r8, 0, 2, "WsMessageInfo{", '}');
    }
}
