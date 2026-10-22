package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Message<c, a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f11571b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.LocationInfo#ADAPTER", tag = 1)
    @ia.b("locationInfo")
    public final i f11572a;

    public static final class a extends Message.Builder<c, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i f11573a;

        public final c a() {
            return new c(this.f11573a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<c> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, c.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final c decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L9;
            if (r12 != 1) goto L7;
            r10.f11573a = (i) i.f11610x.decode(r8);
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
        public final void encode(ProtoWriter r8, c r10) {
            c r11 = r10;
            i.f11610x.encodeWithTag(r8, 1, r11.f11572a);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(c r8) {
            c r10 = r8;
            int r11 = i.f11610x.encodedSizeWithTag(1, r10.f11572a);
            return r10.unknownFields().l() + r11;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final c redact(c r8) {
            c r10 = r8;
            r10.getClass();
            a r11 = new a();
            r11.f11573a = r10.f11572a;
            r11.addUnknownFields(r10.unknownFields());
            i r12 = r11.f11573a;
            if (r12 == null) goto L5;
            r11.f11573a = (i) i.f11610x.redact(r12);
        L5:
            r11.clearUnknownFields();
            return r11.a();
        }
    }

    static {
        f11571b = new b();
    }

    public c(i r8, jf.g r10) {
        super(f11571b, r10);
        this.f11572a = r8;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L14;
        if (Internal.equals(this.f11572a, r10.f11572a) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L10;
        int r10 = unknownFields().hashCode() * 37;
        i r11 = this.f11572a;
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
        r8.f11573a = this.f11572a;
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        if (this.f11572a == null) goto L6;
        r8.append(", locationInfo");
    L6:
        return android.aimedia.a.g(r8, 0, 2, "DecodeLocationResponse{", '}');
    }
}
