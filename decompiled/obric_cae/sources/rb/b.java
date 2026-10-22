package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Message<b, a> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0147b f11566m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", tag = 1)
    @ia.b("center")
    public final n f11567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    @ia.b("radius")
    public final Double f11568b;

    public static final class a extends Message.Builder<b, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f11569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f11570b;

        public a() {
            this.f11570b = Double.valueOf(0.0d);
        }

        public final b a() {
            return new b(this.f11569a, this.f11570b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    /* JADX INFO: renamed from: rb.b$b, reason: collision with other inner class name */
    public static final class C0147b extends ProtoAdapter<b> {
        public C0147b() {
            super(FieldEncoding.LENGTH_DELIMITED, b.class);
        }

        public static b a(b r8) {
            r8.getClass();
            a r10 = new a();
            r10.f11569a = r8.f11567a;
            r10.f11570b = r8.f11568b;
            r10.addUnknownFields(r8.unknownFields());
            n r11 = r10.f11569a;
            if (r11 == null) goto L5;
            r10.f11569a = (n) n.f11677m.redact(r11);
        L5:
            r10.clearUnknownFields();
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final b decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L12;
            if (r12 != 1) goto L8;
            r10.f11569a = (n) n.f11677m.decode(r8);
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r10.f11570b = ProtoAdapter.DOUBLE.decode(r8);
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
        public final void encode(ProtoWriter r8, b r10) {
            b r11 = r10;
            n.f11677m.encodeWithTag(r8, 1, r11.f11567a);
            ProtoAdapter.DOUBLE.encodeWithTag(r8, 2, r11.f11568b);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(b r8) {
            b r10 = r8;
            int r11 = n.f11677m.encodedSizeWithTag(1, r10.f11567a);
            int r12 = ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r10.f11568b) + r11;
            return r10.unknownFields().l() + r12;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final /* bridge */ /* synthetic */ b redact(b r8) {
            return a(r8);
        }
    }

    static {
        f11566m = new C0147b();
    }

    public b(n r8, Double r10, jf.g r11) {
        super(f11566m, r11);
        this.f11567a = r8;
        this.f11568b = r10;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f11567a, r10.f11567a) == false) goto L16;
        if (Internal.equals(this.f11568b, r10.f11568b) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L13;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = 0;
        n r12 = this.f11567a;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Double r15 = this.f11568b;
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
        r8.f11569a = this.f11567a;
        r8.f11570b = this.f11568b;
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        n r10 = this.f11567a;
        if (r10 == null) goto L5;
        r8.append(", center=");
        r8.append(r10);
    L5:
        Double r11 = this.f11568b;
        if (r11 == null) goto L9;
        r8.append(", radius=");
        r8.append(r11);
    L9:
        return android.aimedia.a.g(r8, 0, 2, "Circle{", '}');
    }
}
