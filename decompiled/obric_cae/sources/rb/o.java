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
public final class o extends Message<o, a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f11682b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    @ia.b("vertices")
    public final List<n> f11683a;

    public static final class a extends Message.Builder<o, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<n> f11684a;

        public a() {
            this.f11684a = Internal.newMutableList();
        }

        public final o a() {
            return new o(this.f11684a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<o> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, o.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final o decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L9;
            if (r12 != 1) goto L7;
            r10.f11684a.add((n) n.f11677m.decode(r8));
            goto L3
        L7:
            FieldEncoding r13 = r8.peekFieldEncoding();
            r10.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r8));
            goto L3
        L9:
            r8.endMessage(r11);
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, o r10) {
            o r11 = r10;
            n.f11677m.asRepeated().encodeWithTag(r8, 1, r11.f11683a);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(o r8) {
            o r10 = r8;
            int r11 = n.f11677m.asRepeated().encodedSizeWithTag(1, r10.f11683a);
            return r10.unknownFields().l() + r11;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final o redact(o r8) {
            o r10 = r8;
            r10.getClass();
            a r11 = new a();
            r11.f11684a = Internal.copyOf("vertices", r10.f11683a);
            r11.addUnknownFields(r10.unknownFields());
            Internal.redactElements(r11.f11684a, n.f11677m);
            r11.clearUnknownFields();
            return r11.a();
        }
    }

    static {
        f11682b = new b();
    }

    public o(List<n> r8, jf.g r10) {
        super(f11682b, r10);
        this.f11683a = Internal.immutableCopyOf("vertices", r8);
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof o) == true) goto L8;
        return false;
    L8:
        o r10 = (o) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L14;
        if (this.f11683a.equals(r10.f11683a) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L6;
        int r10 = (unknownFields().hashCode() * 37) + this.f11683a.hashCode();
        this.hashCode = r10;
        return r10;
    L6:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final Message.Builder newBuilder() {
        a r8 = new a();
        r8.f11684a = Internal.copyOf("vertices", this.f11683a);
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        List<n> r10 = this.f11683a;
        if (r10 == null) goto L8;
        if (r10.isEmpty() == true) goto L8;
        r8.append(", vertices=");
        r8.append(r10);
    L8:
        return android.aimedia.a.g(r8, 0, 2, "Polygon{", '}');
    }
}
