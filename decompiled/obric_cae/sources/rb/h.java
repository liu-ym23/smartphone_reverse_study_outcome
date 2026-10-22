package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends Message<h, a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f11607b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    @ia.b("parameters")
    public final String f11608a;

    public static final class a extends Message.Builder<h, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11609a;

        public a() {
            this.f11609a = "";
        }

        public final h a() {
            String r8 = this.f11609a;
            if (r8 == null) goto L7;
            return new h(this.f11609a, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r8, "parameters"});
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<h> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, h.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final h decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L9;
            if (r12 != 1) goto L7;
            r10.f11609a = ProtoAdapter.STRING.decode(r8);
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
        public final void encode(ProtoWriter r8, h r10) {
            h r11 = r10;
            ProtoAdapter.STRING.encodeWithTag(r8, 1, r11.f11608a);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(h r8) {
            h r10 = r8;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(1, r10.f11608a);
            return r10.unknownFields().l() + r11;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final h redact(h r8) {
            h r10 = r8;
            r10.getClass();
            a r11 = new a();
            r11.f11609a = r10.f11608a;
            r11.addUnknownFields(r10.unknownFields());
            r11.clearUnknownFields();
            return r11.a();
        }
    }

    static {
        f11607b = new b();
    }

    public h(String r8, jf.g r10) {
        super(f11607b, r10);
        this.f11608a = r8;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof h) == true) goto L8;
        return false;
    L8:
        h r10 = (h) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L14;
        if (this.f11608a.equals(r10.f11608a) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L6;
        int r10 = (unknownFields().hashCode() * 37) + this.f11608a.hashCode();
        this.hashCode = r10;
        return r10;
    L6:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final Message.Builder newBuilder() {
        a r8 = new a();
        r8.f11609a = this.f11608a;
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = android.aimedia.a.j(", parameters=");
        r8.append(this.f11608a);
        return android.aimedia.a.g(r8, 0, 2, "GetTTNetParametersResponse{", '}');
    }
}
