package kotlinx.serialization.json.internal;

import java.util.Map;
import juc.n;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import luc.o;
import ouc.f;
import ouc.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k0 extends muc.b implements ouc.u {
    public final l a;
    public final ouc.a b;
    public final WriteMode c;
    public final ouc.u[] d;
    public final kotlinx.serialization.modules.d e;
    public final f f;
    public boolean g;
    public String h;
    public String i;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WriteMode.values().length];
            r0[WriteMode.LIST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[WriteMode.MAP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[WriteMode.POLY_OBJ.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Override // muc.b, muc.f
    public final void encodeNull() {
        this.a.h("null");
    }

    @Override // ouc.u
    public final ouc.a getJson() {
        return this.b;
    }

    @Override // muc.f
    public final kotlinx.serialization.modules.d getSerializersModule() {
        return this.e;
    }

    @Override // ouc.u
    public final void a(ouc.i r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        if (this.h != null) goto L5;
    L9:
        encodeSerializableValue(r.a, r2);
        return;
    L5:
        if ((r2 instanceof ouc.d0) == true) goto L9;
        h0.d(this.i, r2);
        throw null;
    }

    @Override // muc.b, muc.f
    public final muc.d beginStructure(luc.f r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        WriteMode r0 = s0.b(this.b, r5);
        char r1 = r0.begin;
        if (r1 == 0) goto L5;
        this.a.e(r1);
        this.a.a();
    L5:
        String r2 = this.h;
        if (r2 == null) goto L12;
        String r3 = this.i;
        if (r3 != null) goto L10;
        r3 = r5.f();
    L10:
        this.a.b();
        encodeString(r2);
        this.a.e(':');
        this.a.k();
        encodeString(r3);
        this.h = null;
        this.i = null;
    L12:
        if (this.c != r0) goto L14;
        return this;
    L14:
        ouc.u[] r6 = this.d;
        if (r6 == null) goto L20;
        ouc.u r7 = r6[r0.ordinal()];
        if (r7 == null) goto L20;
        return r7;
    L20:
        return new k0(this.a, this.b, r0, this.d);
    }

    @Override // muc.b, muc.f
    public final void encodeBoolean(boolean r2) {
        if (this.g == false) goto L5;
        encodeString(String.valueOf(r2));
        return;
    L5:
        this.a.a.b(String.valueOf(r2));
    }

    @Override // muc.b, muc.f
    public final void encodeByte(byte r2) {
        if (this.g == false) goto L5;
        encodeString(String.valueOf(r2));
        return;
    L5:
        this.a.d(r2);
    }

    @Override // muc.b, muc.f
    public final void encodeChar(char r1) {
        encodeString(String.valueOf(r1));
    }

    @Override // muc.b, muc.f
    public final void encodeDouble(double r3) {
        if (this.g == false) goto L5;
        encodeString(String.valueOf(r3));
    L7:
        if (this.f.k == false) goto L9;
        return;
    L9:
        if (Double.isInfinite(r3) == false) goto L11;
    L13:
        boolean r0 = false;
    L14:
        if (r0 == false) goto L17;
        return;
    L17:
        throw s.a(Double.valueOf(r3), this.a.a.toString());
    L11:
        if (Double.isNaN(r3) == true) goto L13;
        r0 = true;
        goto L14
    L5:
        this.a.a.b(String.valueOf(r3));
        goto L7
    }

    @Override // muc.b, muc.f
    public final void encodeFloat(float r3) {
        if (this.g == false) goto L5;
        encodeString(String.valueOf(r3));
    L7:
        if (this.f.k == false) goto L9;
        return;
    L9:
        if (Float.isInfinite(r3) == false) goto L11;
    L13:
        boolean r0 = false;
    L14:
        if (r0 == false) goto L17;
        return;
    L17:
        throw s.a(Float.valueOf(r3), this.a.a.toString());
    L11:
        if (Float.isNaN(r3) == true) goto L13;
        r0 = true;
        goto L14
    L5:
        this.a.a.b(String.valueOf(r3));
        goto L7
    }

    @Override // muc.b, muc.f
    public final muc.f encodeInline(luc.f r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        if (l0.a(r5) == false) goto L9;
        l r6 = this.a;
        if ((r6 instanceof n) == true) goto L26;
        r6 = new n(r6.a, this.g);
    L26:
        return new k0(r6, this.b, this.c, null);
    L9:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isInline() == true) goto L12;
    L14:
        boolean r0 = false;
    L15:
        if (r0 == false) goto L22;
        l r7 = this.a;
        if ((r7 instanceof m) == true) goto L27;
        r7 = new m(r7.a, this.g);
    L27:
        return new k0(r7, this.b, this.c, null);
    L22:
        if (this.h == null) goto L25;
        this.i = r5.f();
        return this;
    L25:
        return super.encodeInline(r5);
    L12:
        if (Intrinsics.areEqual(r5, ouc.k.a) == false) goto L14;
        r0 = true;
        goto L15
    }

    @Override // muc.b, muc.f
    public final void encodeInt(int r2) {
        if (this.g == false) goto L5;
        encodeString(String.valueOf(r2));
        return;
    L5:
        this.a.f(r2);
    }

    @Override // muc.b, muc.f
    public final void encodeLong(long r2) {
        if (this.g == false) goto L5;
        encodeString(String.valueOf(r2));
        return;
    L5:
        this.a.g(r2);
    }

    @Override // muc.b, muc.f
    public final void encodeShort(short r2) {
        if (this.g == false) goto L5;
        encodeString(String.valueOf(r2));
        return;
    L5:
        this.a.i(r2);
    }

    @Override // muc.b, muc.f
    public final void encodeString(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a.j(r2);
    }

    @Override // muc.b, muc.d
    public final void endStructure(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if (this.c.end == 0) goto L6;
        this.a.l();
        this.a.c();
        this.a.e(this.c.end);
        return;
    }

    @Override // muc.b
    public final boolean encodeElement(luc.f r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "descriptor");
        WriteMode r0 = this.c;
        int r1 = a.a[r0.ordinal()];
        if (r1 == 1) goto L24;
        boolean r3 = false;
        if (r1 != 2) goto L7;
        l r9 = this.a;
        if (r9.b == false) goto L19;
        this.g = true;
        r9.b();
    L28:
        return true;
    L19:
        if ((r8 % 2) != 0) goto L21;
        r9.e(',');
        this.a.b();
        r3 = true;
    L22:
        this.g = r3;
        goto L28
    L21:
        r9.e(':');
        this.a.k();
        goto L22
    L7:
        if (r1 == 3) goto L12;
        l r2 = this.a;
        if (r2.b == true) goto L11;
        r2.e(',');
    L11:
        this.a.b();
        ouc.a r4 = this.b;
        p.a<Map<String, Integer>> r5 = u.a;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r4, "json");
        u.e(r7, r4);
        encodeString(r7.b(r8));
        this.a.e(':');
        this.a.k();
        goto L28
    L12:
        if (r8 != 0) goto L14;
        this.g = true;
    L14:
        if (r8 != 1) goto L28;
        this.a.e(',');
        this.a.k();
        this.g = false;
        goto L28
    L24:
        l r10 = this.a;
        if (r10.b == true) goto L27;
        r10.e(',');
    L27:
        this.a.b();
        goto L28
    }

    @Override // muc.b, muc.f
    public final void encodeEnum(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "enumDescriptor");
        encodeString(r2.b(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // muc.b, muc.f
    public final <T> void encodeSerializableValue(n<? super T> r6, T r7) {
        Intrinsics.checkNotNullParameter(r6, "serializer");
        if (getJson().a.i == false) goto L5;
        r6.serialize(this, r7);
        return;
    L5:
        boolean r0 = r6 instanceof nuc.b;
        boolean r1 = false;
        if (r0 == true) goto L8;
        int r3 = h0.a.a[getJson().a.p.ordinal()];
        if (r3 != 1) goto L13;
    L23:
        if (r1 == false) goto L25;
        String r2 = h0.c(r6.getDescriptor(), getJson());
    L26:
        if (r0 == false) goto L35;
        nuc.b r4 = (nuc.b) r6;
        if (r7 == 0) goto L34;
        n<? super T> r5 = juc.h.b(r4, this, r7);
        if (r2 == null) goto L32;
        h0.a(r6, r5, r2);
    L32:
        h0.b(r5.getDescriptor().getKind());
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>");
        r6 = r5;
        goto L35
    L34:
        throw new IllegalArgumentException(("Value for serializer " + r4.getDescriptor() + " should always be non-null. Please report issue to the kotlinx.serialization tracker.").toString());
    L35:
        if (r2 == null) goto L37;
        String r8 = r6.getDescriptor().f();
        this.h = r2;
        this.i = r8;
    L37:
        r6.serialize(this, r7);
        return;
    L25:
        r2 = null;
        goto L26
    L13:
        if (r3 == 2) goto L23;
        if (r3 != 3) goto L22;
        o r9 = r6.getDescriptor().getKind();
        if (Intrinsics.areEqual(r9, luc.p.a.a) == false) goto L19;
    L9:
        r1 = true;
        goto L23
    L19:
        if (Intrinsics.areEqual(r9, luc.p.d.a) == false) goto L23;
    L22:
        throw new NoWhenBranchMatchedException();
    L8:
        if (getJson().a.p == ClassDiscriminatorMode.NONE) goto L23;
        goto L9
    }

    @Override // muc.b, muc.d
    public final boolean shouldEncodeElementDefault(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return this.f.a;
    }

    public k0(l r2, ouc.a r3, WriteMode r4, ouc.u[] r5) {
        Intrinsics.checkNotNullParameter(r2, "composer");
        Intrinsics.checkNotNullParameter(r3, "json");
        Intrinsics.checkNotNullParameter(r4, "mode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r3.b;
        this.f = r3.a;
        int r6 = r4.ordinal();
        if (r5 == null) goto L9;
        ouc.u r7 = r5[r6];
        if (r7 != null) goto L7;
        if (r7 != this) goto L7;
        return;
    L7:
        r5[r6] = this;
        return;
    }

    @Override // muc.b, muc.d
    public final <T> void encodeNullableSerializableElement(luc.f r2, int r3, n<? super T> r4, T r5) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        Intrinsics.checkNotNullParameter(r4, "serializer");
        if (r5 == null) goto L5;
    L6:
        super.encodeNullableSerializableElement(r2, r3, r4, r5);
        return;
    L5:
        if (this.f.f == true) goto L6;
    }
}
