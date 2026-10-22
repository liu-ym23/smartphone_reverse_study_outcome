package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends Message<p, a> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f11685m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @ia.b("resultCode")
    public final Integer f11686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @ia.b("resultMsg")
    public final Integer f11687b;

    public static final class a extends Message.Builder<p, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f11688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f11689b;

        public a() {
            this.f11688a = 0;
            this.f11689b = 0;
        }

        public final p a() {
            return new p(this.f11688a, this.f11689b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<p> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, p.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final p decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L12;
            if (r12 != 1) goto L8;
            r10.f11688a = ProtoAdapter.INT32.decode(r8);
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r10.f11689b = ProtoAdapter.INT32.decode(r8);
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
        public final void encode(ProtoWriter r8, p r10) {
            p r11 = r10;
            ProtoAdapter<Integer> r12 = ProtoAdapter.INT32;
            r12.encodeWithTag(r8, 1, r11.f11686a);
            r12.encodeWithTag(r8, 2, r11.f11687b);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(p r8) {
            p r10 = r8;
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            int r12 = r11.encodedSizeWithTag(1, r10.f11686a);
            int r13 = r11.encodedSizeWithTag(2, r10.f11687b) + r12;
            return r10.unknownFields().l() + r13;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final p redact(p r8) {
            p r10 = r8;
            r10.getClass();
            a r11 = new a();
            r11.f11688a = r10.f11686a;
            r11.f11689b = r10.f11687b;
            r11.addUnknownFields(r10.unknownFields());
            r11.clearUnknownFields();
            return r11.a();
        }
    }

    static {
        f11685m = new b();
    }

    public p(Integer r8, Integer r10, jf.g r11) {
        super(f11685m, r11);
        this.f11686a = r8;
        this.f11687b = r10;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof p) == true) goto L8;
        return false;
    L8:
        p r10 = (p) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f11686a, r10.f11686a) == false) goto L16;
        if (Internal.equals(this.f11687b, r10.f11687b) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L13;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = 0;
        Integer r12 = this.f11686a;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Integer r15 = this.f11687b;
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
        r8.f11688a = this.f11686a;
        r8.f11689b = this.f11687b;
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        Integer r10 = this.f11686a;
        if (r10 == null) goto L5;
        r8.append(", resultCode=");
        r8.append(r10);
    L5:
        Integer r11 = this.f11687b;
        if (r11 == null) goto L9;
        r8.append(", resultMsg=");
        r8.append(r11);
    L9:
        return android.aimedia.a.g(r8, 0, 2, "RefreshLocationResponse{", '}');
    }
}
