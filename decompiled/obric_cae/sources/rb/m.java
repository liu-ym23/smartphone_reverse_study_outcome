package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends Message<m, a> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b f11667o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    @ia.b("isSucceed")
    public final Boolean f11668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @ia.b("body")
    public final String f11669b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @ia.b("serverLogId")
    public final String f11670m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @ia.b("extraMap")
    public final Map<String, String> f11671n;

    public static final class a extends Message.Builder<m, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f11672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11673b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11674c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f11675d;

        public a() {
            this.f11672a = Boolean.FALSE;
            this.f11673b = "";
            this.f11674c = "";
            this.f11675d = Internal.newMutableMap();
        }

        public final m a() {
            return new m(this.f11672a, this.f11673b, this.f11674c, this.f11675d, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter<Map<String, String>> f11676a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, m.class);
            ProtoAdapter<String> r8 = ProtoAdapter.STRING;
            this.f11676a = ProtoAdapter.newMapAdapter(r8, r8);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final m decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L18;
            if (r12 != 1) goto L8;
            r10.f11672a = ProtoAdapter.BOOL.decode(r8);
            goto L3
        L8:
            if (r12 != 2) goto L10;
            r10.f11673b = ProtoAdapter.STRING.decode(r8);
            goto L3
        L10:
            if (r12 != 3) goto L12;
            r10.f11674c = ProtoAdapter.STRING.decode(r8);
            goto L3
        L12:
            if (r12 != 4) goto L13;
            r10.f11675d.putAll(this.f11676a.decode(r8));
            goto L3
        L13:
            FieldEncoding r13 = r8.peekFieldEncoding();
            r10.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r8));
            goto L3
        L18:
            r8.endMessage(r11);
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, m r10) {
            m r11 = r10;
            ProtoAdapter.BOOL.encodeWithTag(r8, 1, r11.f11668a);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            r12.encodeWithTag(r8, 2, r11.f11669b);
            r12.encodeWithTag(r8, 3, r11.f11670m);
            Map<String, String> r13 = r11.f11671n;
            this.f11676a.encodeWithTag(r8, 4, r13);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(m r8) {
            m r10 = r8;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r10.f11668a);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            int r13 = r12.encodedSizeWithTag(2, r10.f11669b) + r11;
            int r14 = r12.encodedSizeWithTag(3, r10.f11670m) + r13;
            Map<String, String> r15 = r10.f11671n;
            int r16 = this.f11676a.encodedSizeWithTag(4, r15) + r14;
            return r10.unknownFields().l() + r16;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final m redact(m r8) {
            a r10 = r8.t();
            r10.clearUnknownFields();
            return r10.a();
        }
    }

    static {
        f11667o = new b();
    }

    public m(Boolean r8, String r10, String r11, Map<String, String> r12, jf.g r13) {
        super(f11667o, r13);
        this.f11668a = r8;
        this.f11669b = r10;
        this.f11670m = r11;
        this.f11671n = Internal.immutableCopyOf("extraMap", r12);
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof m) == true) goto L8;
        return false;
    L8:
        m r10 = (m) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L20;
        if (Internal.equals(this.f11668a, r10.f11668a) == false) goto L20;
        if (Internal.equals(this.f11669b, r10.f11669b) == false) goto L20;
        if (Internal.equals(this.f11670m, r10.f11670m) == false) goto L20;
        if (this.f11671n.equals(r10.f11671n) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L17;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = 0;
        Boolean r12 = this.f11668a;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        String r15 = this.f11669b;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        String r18 = this.f11670m;
        if (r18 == null) goto L15;
        r11 = r18.hashCode();
    L15:
        int r19 = ((r17 + r11) * 37) + this.f11671n.hashCode();
        this.hashCode = r19;
        return r19;
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L17:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return t();
    }

    public final a t() {
        a r8 = new a();
        r8.f11672a = this.f11668a;
        r8.f11673b = this.f11669b;
        r8.f11674c = this.f11670m;
        r8.f11675d = Internal.copyOf("extraMap", this.f11671n);
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        Boolean r10 = this.f11668a;
        if (r10 == null) goto L5;
        r8.append(", isSucceed=");
        r8.append(r10);
    L5:
        String r11 = this.f11669b;
        if (r11 == null) goto L8;
        r8.append(", body=");
        r8.append(r11);
    L8:
        String r12 = this.f11670m;
        if (r12 == null) goto L11;
        r8.append(", serverLogId=");
        r8.append(r12);
    L11:
        Map<String, String> r13 = this.f11671n;
        if (r13 == null) goto L17;
        if (r13.isEmpty() == true) goto L17;
        r8.append(", extraMap=");
        r8.append(r13);
    L17:
        return android.aimedia.a.g(r8, 0, 2, "OnePartyCommonNetworkResponse{", '}');
    }
}
