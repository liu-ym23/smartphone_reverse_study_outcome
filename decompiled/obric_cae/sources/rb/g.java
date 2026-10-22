package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends Message<g, a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f11604b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.LocationInfo#ADAPTER", tag = 1)
    @ia.b("locationInfo")
    public final i f11605a;

    public static final class a extends Message.Builder<g, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i f11606a;

        public final g a() {
            return new g(this.f11606a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<g> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, g.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final g decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L9;
            if (r12 != 1) goto L7;
            r10.f11606a = (i) i.f11610x.decode(r8);
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
        public final void encode(ProtoWriter r8, g r10) {
            g r11 = r10;
            i.f11610x.encodeWithTag(r8, 1, r11.f11605a);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(g r8) {
            g r10 = r8;
            int r11 = i.f11610x.encodedSizeWithTag(1, r10.f11605a);
            return r10.unknownFields().l() + r11;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final g redact(g r8) {
            g r10 = r8;
            r10.getClass();
            a r11 = new a();
            r11.f11606a = r10.f11605a;
            r11.addUnknownFields(r10.unknownFields());
            i r12 = r11.f11606a;
            if (r12 == null) goto L5;
            r11.f11606a = (i) i.f11610x.redact(r12);
        L5:
            r11.clearUnknownFields();
            return r11.a();
        }
    }

    static {
        f11604b = new b();
    }

    public g(i r8, jf.g r10) {
        super(f11604b, r10);
        this.f11605a = r8;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L14;
        if (Internal.equals(this.f11605a, r10.f11605a) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L10;
        int r10 = unknownFields().hashCode() * 37;
        i r11 = this.f11605a;
        if (r11 == null) goto L7;
        int r12 = r11.hashCode();
    L8:
        int r13 = r10 + r12;
        this.hashCode = r13;
        return r13;
    L7:
        r12 = 0;
        goto L8
    L10:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final Message.Builder newBuilder() {
        a r8 = new a();
        r8.f11606a = this.f11605a;
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        i r10 = this.f11605a;
        if (r10 == null) goto L6;
        r8.append(", locationInfo=");
        r8.append(r10);
    L6:
        return android.aimedia.a.g(r8, 0, 2, "GetLocationResponse{", '}');
    }
}
