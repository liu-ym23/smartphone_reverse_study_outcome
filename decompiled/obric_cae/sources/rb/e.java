package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends Message<e, a> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f11590n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 1)
    @ia.b("isSucceed")
    public final Boolean f11591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    @ia.b("body")
    public final String f11592b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 3)
    @ia.b("serverLogId")
    public final String f11593m;

    public static final class a extends Message.Builder<e, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f11594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11596c;

        public a() {
            this.f11594a = Boolean.FALSE;
            this.f11595b = "";
            this.f11596c = "";
        }

        public final e a() {
            Boolean r8 = this.f11594a;
            if (r8 == null) goto L11;
            if (this.f11595b == null) goto L11;
            if (this.f11596c == null) goto L11;
            return new e(this.f11594a, this.f11595b, this.f11596c, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r8, "isSucceed", this.f11595b, "body", this.f11596c, "serverLogId"});
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<e> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, e.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final e decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L15;
            if (r12 != 1) goto L8;
            r10.f11594a = ProtoAdapter.BOOL.decode(r8);
            goto L3
        L8:
            if (r12 != 2) goto L10;
            r10.f11595b = ProtoAdapter.STRING.decode(r8);
            goto L3
        L10:
            if (r12 != 3) goto L11;
            r10.f11596c = ProtoAdapter.STRING.decode(r8);
            goto L3
        L11:
            FieldEncoding r13 = r8.peekFieldEncoding();
            r10.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r8));
            goto L3
        L15:
            r8.endMessage(r11);
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, e r10) {
            e r11 = r10;
            ProtoAdapter.BOOL.encodeWithTag(r8, 1, r11.f11591a);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            r12.encodeWithTag(r8, 2, r11.f11592b);
            r12.encodeWithTag(r8, 3, r11.f11593m);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(e r8) {
            e r10 = r8;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r10.f11591a);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            int r13 = r12.encodedSizeWithTag(2, r10.f11592b) + r11;
            int r14 = r12.encodedSizeWithTag(3, r10.f11593m) + r13;
            return r10.unknownFields().l() + r14;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final e redact(e r8) {
            e r10 = r8;
            r10.getClass();
            a r11 = new a();
            r11.f11594a = r10.f11591a;
            r11.f11595b = r10.f11592b;
            r11.f11596c = r10.f11593m;
            r11.addUnknownFields(r10.unknownFields());
            r11.clearUnknownFields();
            return r11.a();
        }
    }

    static {
        f11590n = new b();
    }

    public e(Boolean r8, String r10, String r11, jf.g r12) {
        super(f11590n, r12);
        this.f11591a = r8;
        this.f11592b = r10;
        this.f11593m = r11;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r10 = (e) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L18;
        if (this.f11591a.equals(r10.f11591a) == false) goto L18;
        if (this.f11592b.equals(r10.f11592b) == false) goto L18;
        if (this.f11593m.equals(r10.f11593m) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L6;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = (this.f11591a.hashCode() + r10) * 37;
        int r12 = defpackage.a.b(this.f11592b, r11, 37) + this.f11593m.hashCode();
        this.hashCode = r12;
        return r12;
    L6:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final Message.Builder newBuilder() {
        a r8 = new a();
        r8.f11594a = this.f11591a;
        r8.f11595b = this.f11592b;
        r8.f11596c = this.f11593m;
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = android.aimedia.a.j(", isSucceed=");
        r8.append(this.f11591a);
        r8.append(", body=");
        r8.append(this.f11592b);
        r8.append(", serverLogId=");
        r8.append(this.f11593m);
        return android.aimedia.a.g(r8, 0, 2, "GenericNetworkResponse{", '}');
    }
}
