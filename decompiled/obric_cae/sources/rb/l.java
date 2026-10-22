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
public final class l extends Message<l, a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f11664b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Polygon#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    @ia.b("polygons")
    public final List<o> f11665a;

    public static final class a extends Message.Builder<l, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<o> f11666a;

        public a() {
            this.f11666a = Internal.newMutableList();
        }

        public final l a() {
            return new l(this.f11666a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<l> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, l.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final l decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L9;
            if (r12 != 1) goto L7;
            r10.f11666a.add((o) o.f11682b.decode(r8));
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
        public final void encode(ProtoWriter r8, l r10) {
            l r11 = r10;
            o.f11682b.asRepeated().encodeWithTag(r8, 1, r11.f11665a);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(l r8) {
            l r10 = r8;
            int r11 = o.f11682b.asRepeated().encodedSizeWithTag(1, r10.f11665a);
            return r10.unknownFields().l() + r11;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final l redact(l r8) {
            l r10 = r8;
            r10.getClass();
            a r11 = new a();
            r11.f11666a = Internal.copyOf("polygons", r10.f11665a);
            r11.addUnknownFields(r10.unknownFields());
            Internal.redactElements(r11.f11666a, o.f11682b);
            r11.clearUnknownFields();
            return r11.a();
        }
    }

    static {
        f11664b = new b();
    }

    public l(List<o> r8, jf.g r10) {
        super(f11664b, r10);
        this.f11665a = Internal.immutableCopyOf("polygons", r8);
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof l) == true) goto L8;
        return false;
    L8:
        l r10 = (l) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L14;
        if (this.f11665a.equals(r10.f11665a) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L6;
        int r10 = (unknownFields().hashCode() * 37) + this.f11665a.hashCode();
        this.hashCode = r10;
        return r10;
    L6:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final Message.Builder newBuilder() {
        a r8 = new a();
        r8.f11666a = Internal.copyOf("polygons", this.f11665a);
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        List<o> r10 = this.f11665a;
        if (r10 == null) goto L8;
        if (r10.isEmpty() == true) goto L8;
        r8.append(", polygons=");
        r8.append(r10);
    L8:
        return android.aimedia.a.g(r8, 0, 2, "MultiPolygon{", '}');
    }
}
