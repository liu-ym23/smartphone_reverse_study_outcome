package rb;

import com.obric.cae.location.database.StarCellDbManager;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends Message<n, a> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f11677m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    @ia.b(StarCellDbManager.CellInfoEntry.LONGITUDE)
    public final Double f11678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    @ia.b("latitude")
    public final Double f11679b;

    public static final class a extends Message.Builder<n, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f11680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f11681b;

        public a() {
            Double r8 = Double.valueOf(0.0d);
            this.f11680a = r8;
            this.f11681b = r8;
        }

        public final n a() {
            return new n(this.f11680a, this.f11681b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<n> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, n.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final n decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L12;
            if (r12 != 1) goto L8;
            r10.f11680a = ProtoAdapter.DOUBLE.decode(r8);
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r10.f11681b = ProtoAdapter.DOUBLE.decode(r8);
            goto L3
        L9:
            FieldEncoding r13 = r8.peekFieldEncoding();
            r10.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r8));
            goto L3
        L12:
            r8.endMessage(r11);
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, n r10) {
            n r11 = r10;
            ProtoAdapter<Double> r12 = ProtoAdapter.DOUBLE;
            r12.encodeWithTag(r8, 1, r11.f11678a);
            r12.encodeWithTag(r8, 2, r11.f11679b);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(n r8) {
            n r10 = r8;
            ProtoAdapter<Double> r11 = ProtoAdapter.DOUBLE;
            int r12 = r11.encodedSizeWithTag(1, r10.f11678a);
            int r13 = r11.encodedSizeWithTag(2, r10.f11679b) + r12;
            return r10.unknownFields().l() + r13;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final n redact(n r8) {
            n r10 = r8;
            r10.getClass();
            a r11 = new a();
            r11.f11680a = r10.f11678a;
            r11.f11681b = r10.f11679b;
            r11.addUnknownFields(r10.unknownFields());
            r11.clearUnknownFields();
            return r11.a();
        }
    }

    static {
        f11677m = new b();
    }

    public n(Double r8, Double r10, jf.g r11) {
        super(f11677m, r11);
        this.f11678a = r8;
        this.f11679b = r10;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof n) == true) goto L8;
        return false;
    L8:
        n r10 = (n) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f11678a, r10.f11678a) == false) goto L16;
        if (Internal.equals(this.f11679b, r10.f11679b) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L13;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = 0;
        Double r12 = this.f11678a;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Double r15 = this.f11679b;
        if (r15 == null) goto L11;
        r11 = r15.hashCode();
    L11:
        int r16 = r14 + r11;
        this.hashCode = r16;
        return r16;
    L7:
        r13 = 0;
        goto L8
    L13:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final Message.Builder newBuilder() {
        a r8 = new a();
        r8.f11680a = this.f11678a;
        r8.f11681b = this.f11679b;
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        Double r10 = this.f11678a;
        if (r10 == null) goto L5;
        r8.append(", longitude=");
        r8.append(r10);
    L5:
        Double r11 = this.f11679b;
        if (r11 == null) goto L9;
        r8.append(", latitude=");
        r8.append(r11);
    L9:
        return android.aimedia.a.g(r8, 0, 2, "Point{", '}');
    }
}
