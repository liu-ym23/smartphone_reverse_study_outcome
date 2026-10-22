package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends Message<k, a> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f11653p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    @ia.b("thirdStartTime")
    public final Long f11654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    @ia.b("thirdJavaJniCallTime")
    public final Long f11655b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    @ia.b("matrixBindRevTime")
    public final Long f11656m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @ia.b("matrixBindProcessEndTime")
    public final Long f11657n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    @ia.b("thirdJavaRevResResult")
    public final Long f11658o;

    public static final class a extends Message.Builder<k, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f11659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f11660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f11661c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f11662d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f11663e;

        public a() {
            this.f11659a = 0L;
            this.f11660b = 0L;
            this.f11661c = 0L;
            this.f11662d = 0L;
            this.f11663e = 0L;
        }

        public final k a() {
            return new k(this.f11659a, this.f11660b, this.f11661c, this.f11662d, this.f11663e, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<k> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, k.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final k decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L21;
            if (r12 != 1) goto L8;
            r10.f11659a = ProtoAdapter.INT64.decode(r8);
            goto L3
        L8:
            if (r12 != 2) goto L10;
            r10.f11660b = ProtoAdapter.INT64.decode(r8);
            goto L3
        L10:
            if (r12 != 3) goto L12;
            r10.f11661c = ProtoAdapter.INT64.decode(r8);
            goto L3
        L12:
            if (r12 != 4) goto L14;
            r10.f11662d = ProtoAdapter.INT64.decode(r8);
            goto L3
        L14:
            if (r12 != 5) goto L15;
            r10.f11663e = ProtoAdapter.INT64.decode(r8);
            goto L3
        L15:
            FieldEncoding r13 = r8.peekFieldEncoding();
            r10.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r8));
            goto L3
        L21:
            r8.endMessage(r11);
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, k r10) {
            k r11 = r10;
            ProtoAdapter<Long> r12 = ProtoAdapter.INT64;
            r12.encodeWithTag(r8, 1, r11.f11654a);
            r12.encodeWithTag(r8, 2, r11.f11655b);
            r12.encodeWithTag(r8, 3, r11.f11656m);
            r12.encodeWithTag(r8, 4, r11.f11657n);
            r12.encodeWithTag(r8, 5, r11.f11658o);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(k r8) {
            k r10 = r8;
            ProtoAdapter<Long> r11 = ProtoAdapter.INT64;
            int r12 = r11.encodedSizeWithTag(1, r10.f11654a);
            int r13 = r11.encodedSizeWithTag(2, r10.f11655b) + r12;
            int r14 = r11.encodedSizeWithTag(3, r10.f11656m) + r13;
            int r15 = r11.encodedSizeWithTag(4, r10.f11657n) + r14;
            int r16 = r11.encodedSizeWithTag(5, r10.f11658o) + r15;
            return r10.unknownFields().l() + r16;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final k redact(k r8) {
            a r10 = r8.t();
            r10.clearUnknownFields();
            return r10.a();
        }
    }

    static {
        f11653p = new b();
    }

    public k(Long r8, Long r10, Long r11, Long r12, Long r13, jf.g r14) {
        super(f11653p, r14);
        this.f11654a = r8;
        this.f11655b = r10;
        this.f11656m = r11;
        this.f11657n = r12;
        this.f11658o = r13;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof k) == true) goto L8;
        return false;
    L8:
        k r10 = (k) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L22;
        if (Internal.equals(this.f11654a, r10.f11654a) == false) goto L22;
        if (Internal.equals(this.f11655b, r10.f11655b) == false) goto L22;
        if (Internal.equals(this.f11656m, r10.f11656m) == false) goto L22;
        if (Internal.equals(this.f11657n, r10.f11657n) == false) goto L22;
        if (Internal.equals(this.f11658o, r10.f11658o) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L25;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = 0;
        Long r12 = this.f11654a;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Long r15 = this.f11655b;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        Long r18 = this.f11656m;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        Long r21 = this.f11657n;
        if (r21 == null) goto L19;
        int r22 = r21.hashCode();
    L20:
        int r23 = (r20 + r22) * 37;
        Long r24 = this.f11658o;
        if (r24 == null) goto L23;
        r11 = r24.hashCode();
    L23:
        int r25 = r23 + r11;
        this.hashCode = r25;
        return r25;
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
    L25:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return t();
    }

    public final a t() {
        a r8 = new a();
        r8.f11659a = this.f11654a;
        r8.f11660b = this.f11655b;
        r8.f11661c = this.f11656m;
        r8.f11662d = this.f11657n;
        r8.f11663e = this.f11658o;
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        Long r10 = this.f11654a;
        if (r10 == null) goto L5;
        r8.append(", thirdStartTime=");
        r8.append(r10);
    L5:
        Long r11 = this.f11655b;
        if (r11 == null) goto L8;
        r8.append(", thirdJavaJniCallTime=");
        r8.append(r11);
    L8:
        Long r12 = this.f11656m;
        if (r12 == null) goto L11;
        r8.append(", matrixBindRevTime=");
        r8.append(r12);
    L11:
        Long r13 = this.f11657n;
        if (r13 == null) goto L14;
        r8.append(", matrixBindProcessEndTime=");
        r8.append(r13);
    L14:
        Long r14 = this.f11658o;
        if (r14 == null) goto L18;
        r8.append(", thirdJavaRevResResult=");
        r8.append(r14);
    L18:
        return android.aimedia.a.g(r8, 0, 2, "MonitorInfo{", '}');
    }
}
