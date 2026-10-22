package rb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends Message<u, a> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c f11746m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse$Phase#ADAPTER", tag = 1)
    @ia.b("phase")
    public final b f11747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @ia.b("phaseData")
    public final Map<String, String> f11748b;

    public static final class a extends Message.Builder<u, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f11749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f11750b;

        public a() {
            this.f11749a = b.f11751b;
            this.f11750b = Internal.newMutableMap();
        }

        public final u a() {
            return new u(this.f11749a, this.f11750b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final enum b extends Enum<b> implements WireEnum {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f11751b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final b f11752m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final b f11753n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f11754o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final /* synthetic */ b[] f11755p = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11756a;

        public static final class a extends EnumAdapter<b> {
            public a() {
                super(b.class);
            }

            @Override // com.squareup.wire.EnumAdapter
            public final WireEnum fromValue(int r8) {
                if (r8 == 0) goto L11;
                if (r8 == 1) goto L14;
                if (r8 == 2) goto L13;
                return null;
            L13:
                return b.f11753n;
            L14:
                return b.f11752m;
            L11:
                return b.f11751b;
            }
        }

        static {
            b r8 = new b("SYNC_INVOKE", 0, 0);
            f11751b = r8;
            b r10 = new b("ASYNC_CALLBACK", 1, 1);
            f11752m = r10;
            b r11 = new b("URL_REDIRECT", 2, 2);
            f11753n = r11;
            f11755p = new b[]{r8, r10, r11};
            f11754o = new a();
        }

        public b(String r8, int r10, int r11) {
            super(r8, r10);
            this.f11756a = r11;
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f11755p.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.f11756a;
        }
    }

    public static final class c extends ProtoAdapter<u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter<Map<String, String>> f11757a;

        public c() {
            super(FieldEncoding.LENGTH_DELIMITED, u.class);
            ProtoAdapter<String> r8 = ProtoAdapter.STRING;
            this.f11757a = ProtoAdapter.newMapAdapter(r8, r8);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final u decode(ProtoReader r10) {
            a r8 = new a();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L15;
            if (r12 != 1) goto L8;
            r8.f11749a = (b) b.f11754o.decode(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r8.addUnknownField(r12, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r8.f11750b.putAll(this.f11757a.decode(r10));
            goto L3
        L9:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r8.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L15:
            r10.endMessage(r11);
            return r8.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, u r10) {
            u r11 = r10;
            b.f11754o.encodeWithTag(r8, 1, r11.f11747a);
            this.f11757a.encodeWithTag(r8, 2, r11.f11748b);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(u r8) {
            u r10 = r8;
            int r11 = b.f11754o.encodedSizeWithTag(1, r10.f11747a);
            int r12 = this.f11757a.encodedSizeWithTag(2, r10.f11748b) + r11;
            return r10.unknownFields().l() + r12;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final u redact(u r8) {
            u r10 = r8;
            r10.getClass();
            a r11 = new a();
            r11.f11749a = r10.f11747a;
            r11.f11750b = Internal.copyOf("phaseData", r10.f11748b);
            r11.addUnknownFields(r10.unknownFields());
            r11.clearUnknownFields();
            return r11.a();
        }
    }

    static {
        f11746m = new c();
        b r8 = b.f11751b;
    }

    public u(b r8, Map<String, String> r10, jf.g r11) {
        super(f11746m, r11);
        this.f11747a = r8;
        this.f11748b = Internal.immutableCopyOf("phaseData", r10);
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof u) == true) goto L8;
        return false;
    L8:
        u r10 = (u) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f11747a, r10.f11747a) == false) goto L16;
        if (this.f11748b.equals(r10.f11748b) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L10;
        int r10 = unknownFields().hashCode() * 37;
        b r11 = this.f11747a;
        if (r11 == null) goto L7;
        int r12 = r11.hashCode();
    L8:
        int r13 = ((r10 + r12) * 37) + this.f11748b.hashCode();
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
        r8.f11749a = this.f11747a;
        r8.f11750b = Internal.copyOf("phaseData", this.f11748b);
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        b r10 = this.f11747a;
        if (r10 == null) goto L5;
        r8.append(", phase=");
        r8.append(r10);
    L5:
        Map<String, String> r11 = this.f11748b;
        if (r11 == null) goto L11;
        if (r11.isEmpty() == true) goto L11;
        r8.append(", phaseData=");
        r8.append(r11);
    L11:
        return android.aimedia.a.g(r8, 0, 2, "StartPicoLinksResponse{", '}');
    }
}
