package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends Message<z, a> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b f11772o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @ia.b("channelType")
    public final Integer f11773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @ia.b("connectionState")
    public final Integer f11774b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @ia.b("channelId")
    public final Integer f11775m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    @ia.b("isConnected")
    public final Boolean f11776n;

    public static final class a extends Message.Builder<z, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f11777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f11778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f11779c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f11780d;

        public a() {
            this.f11777a = 0;
            this.f11778b = 0;
            this.f11779c = 0;
            this.f11780d = Boolean.FALSE;
        }

        public final z a() {
            return new z(this.f11777a, this.f11778b, this.f11779c, this.f11780d, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<z> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, z.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final z decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L18;
            if (r12 != 1) goto L8;
            r10.f11777a = ProtoAdapter.INT32.decode(r8);
            goto L3
        L8:
            if (r12 != 2) goto L10;
            r10.f11778b = ProtoAdapter.INT32.decode(r8);
            goto L3
        L10:
            if (r12 != 3) goto L12;
            r10.f11779c = ProtoAdapter.INT32.decode(r8);
            goto L3
        L12:
            if (r12 != 4) goto L13;
            r10.f11780d = ProtoAdapter.BOOL.decode(r8);
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
        public final void encode(ProtoWriter r8, z r10) {
            z r11 = r10;
            ProtoAdapter<Integer> r12 = ProtoAdapter.INT32;
            r12.encodeWithTag(r8, 1, r11.f11773a);
            r12.encodeWithTag(r8, 2, r11.f11774b);
            r12.encodeWithTag(r8, 3, r11.f11775m);
            ProtoAdapter.BOOL.encodeWithTag(r8, 4, r11.f11776n);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(z r8) {
            z r10 = r8;
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            int r12 = r11.encodedSizeWithTag(1, r10.f11773a);
            int r13 = r11.encodedSizeWithTag(2, r10.f11774b) + r12;
            int r14 = r11.encodedSizeWithTag(3, r10.f11775m) + r13;
            int r15 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10.f11776n) + r14;
            return r10.unknownFields().l() + r15;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final z redact(z r8) {
            a r10 = r8.t();
            r10.clearUnknownFields();
            return r10.a();
        }
    }

    static {
        f11772o = new b();
    }

    public z(Integer r8, Integer r10, Integer r11, Boolean r12, jf.g r13) {
        super(f11772o, r13);
        this.f11773a = r8;
        this.f11774b = r10;
        this.f11775m = r11;
        this.f11776n = r12;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof z) == true) goto L8;
        return false;
    L8:
        z r10 = (z) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L20;
        if (Internal.equals(this.f11773a, r10.f11773a) == false) goto L20;
        if (Internal.equals(this.f11774b, r10.f11774b) == false) goto L20;
        if (Internal.equals(this.f11775m, r10.f11775m) == false) goto L20;
        if (Internal.equals(this.f11776n, r10.f11776n) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L21;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = 0;
        Integer r12 = this.f11773a;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Integer r15 = this.f11774b;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        Integer r18 = this.f11775m;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        Boolean r21 = this.f11776n;
        if (r21 == null) goto L19;
        r11 = r21.hashCode();
    L19:
        int r22 = r20 + r11;
        this.hashCode = r22;
        return r22;
    L15:
        r19 = 0;
        goto L16
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L21:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return t();
    }

    public final a t() {
        a r8 = new a();
        r8.f11777a = this.f11773a;
        r8.f11778b = this.f11774b;
        r8.f11779c = this.f11775m;
        r8.f11780d = this.f11776n;
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        Integer r10 = this.f11773a;
        if (r10 == null) goto L5;
        r8.append(", channelType=");
        r8.append(r10);
    L5:
        Integer r11 = this.f11774b;
        if (r11 == null) goto L8;
        r8.append(", connectionState=");
        r8.append(r11);
    L8:
        Integer r12 = this.f11775m;
        if (r12 == null) goto L11;
        r8.append(", channelId=");
        r8.append(r12);
    L11:
        Boolean r13 = this.f11776n;
        if (r13 == null) goto L15;
        r8.append(", isConnected=");
        r8.append(r13);
    L15:
        return android.aimedia.a.g(r8, 0, 2, "SubscribeWsStatusResponse{", '}');
    }
}
