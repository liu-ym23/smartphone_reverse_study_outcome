package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends Message<f, a> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f11597n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Fence#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    @ia.b("fences")
    public final List<d> f11598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 2)
    @ia.b("overlap_froms")
    public final List<Double> f11599b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 3)
    @ia.b("overlap_targets")
    public final List<Double> f11600m;

    public static final class a extends Message.Builder<f, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<d> f11601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Double> f11602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<Double> f11603c;

        public a() {
            this.f11601a = Internal.newMutableList();
            this.f11602b = Internal.newMutableList();
            this.f11603c = Internal.newMutableList();
        }

        public final f a() {
            return new f(this.f11601a, this.f11602b, this.f11603c, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<f> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, f.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final f decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L17;
            if (r12 == 1) goto L15;
            if (r12 == 2) goto L13;
            if (r12 != 3) goto L11;
            List r13 = r10.f11603c;
        L14:
            Object r14 = (Double) ProtoAdapter.DOUBLE.decode(r8);
        L16:
            r13.add(r14);
            goto L3
        L11:
            FieldEncoding r15 = r8.peekFieldEncoding();
            r10.addUnknownField(r12, r15, r15.rawProtoAdapter().decode(r8));
            goto L3
        L13:
            r13 = r10.f11602b;
            goto L14
        L15:
            r13 = r10.f11601a;
            r14 = (d) d.f11574r.decode(r8);
            goto L16
        L17:
            r8.endMessage(r11);
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, f r10) {
            f r11 = r10;
            d.f11574r.asRepeated().encodeWithTag(r8, 1, r11.f11598a);
            ProtoAdapter<Double> r12 = ProtoAdapter.DOUBLE;
            r12.asRepeated().encodeWithTag(r8, 2, r11.f11599b);
            r12.asRepeated().encodeWithTag(r8, 3, r11.f11600m);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(f r8) {
            f r10 = r8;
            int r11 = d.f11574r.asRepeated().encodedSizeWithTag(1, r10.f11598a);
            ProtoAdapter<Double> r12 = ProtoAdapter.DOUBLE;
            int r13 = r12.asRepeated().encodedSizeWithTag(2, r10.f11599b) + r11;
            int r14 = r12.asRepeated().encodedSizeWithTag(3, r10.f11600m) + r13;
            return r10.unknownFields().l() + r14;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final f redact(f r8) {
            a r10 = r8.t();
            Internal.redactElements(r10.f11601a, d.f11574r);
            r10.clearUnknownFields();
            return r10.a();
        }
    }

    static {
        f11597n = new b();
    }

    public f(List<d> r8, List<Double> r10, List<Double> r11, jf.g r12) {
        super(f11597n, r12);
        this.f11598a = Internal.immutableCopyOf("fences", r8);
        this.f11599b = Internal.immutableCopyOf("overlap_froms", r10);
        this.f11600m = Internal.immutableCopyOf("overlap_targets", r11);
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r10 = (f) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L18;
        if (this.f11598a.equals(r10.f11598a) == false) goto L18;
        if (this.f11599b.equals(r10.f11599b) == false) goto L18;
        if (this.f11600m.equals(r10.f11600m) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L6;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = (this.f11598a.hashCode() + r10) * 37;
        int r12 = ((this.f11599b.hashCode() + r11) * 37) + this.f11600m.hashCode();
        this.hashCode = r12;
        return r12;
    L6:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return t();
    }

    public final a t() {
        a r8 = new a();
        r8.f11601a = Internal.copyOf("fences", this.f11598a);
        r8.f11602b = Internal.copyOf("overlap_froms", this.f11599b);
        r8.f11603c = Internal.copyOf("overlap_targets", this.f11600m);
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        List<d> r10 = this.f11598a;
        if (r10 != null) goto L5;
    L7:
        List<Double> r11 = this.f11599b;
        if (r11 != null) goto L10;
    L12:
        List<Double> r12 = this.f11600m;
        if (r12 == null) goto L18;
        if (r12.isEmpty() == true) goto L18;
        r8.append(", overlap_targets=");
        r8.append(r12);
    L18:
        return android.aimedia.a.g(r8, 0, 2, "GetIntersectFencesResponse{", '}');
    L10:
        if (r11.isEmpty() == true) goto L12;
        r8.append(", overlap_froms=");
        r8.append(r11);
        goto L12
    L5:
        if (r10.isEmpty() == true) goto L7;
        r8.append(", fences=");
        r8.append(r10);
        goto L7
    }
}
