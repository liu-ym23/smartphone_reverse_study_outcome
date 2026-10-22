package kotlinx.serialization.json.internal;

import java.util.Map;
import juc.n;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import luc.e;
import luc.o;
import nuc.n1;
import ouc.f;
import ouc.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@ExperimentalSerializationApi
public abstract class g extends n1 implements ouc.u {
    public final ouc.a b;
    public final Function1<ouc.i, Unit> c;
    public final f d;
    public String e;
    public String f;

    @Override // muc.f
    public final void encodeNotNullMark() {
    }

    public abstract ouc.i q();

    public abstract void r(String r1, ouc.i r2);

    @Override // muc.f
    public final void encodeNull() {
        String r0 = (String) CollectionsKt.lastOrNull(this.a);
        if (r0 != null) goto L6;
        this.c.invoke(ouc.a0.INSTANCE);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r0, "tag");
        r(r0, ouc.a0.INSTANCE);
    }

    @Override // muc.f
    public final kotlinx.serialization.modules.d getSerializersModule() {
        return this.b.b;
    }

    @Override // ouc.u
    public final ouc.a getJson() {
        return this.b;
    }

    @Override // ouc.u
    public final void a(ouc.i r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        if (this.e != null) goto L5;
    L9:
        encodeSerializableValue(r.a, r2);
        return;
    L5:
        if ((r2 instanceof ouc.d0) == true) goto L9;
        h0.d(this.f, r2);
        throw null;
    }

    @Override // muc.f
    public final muc.d beginStructure(luc.f r6) {
        Intrinsics.checkNotNullParameter(r6, "descriptor");
        if (CollectionsKt.lastOrNull(this.a) != null) goto L5;
        Function1<ouc.i, Unit> r0 = this.c;
    L6:
        o r1 = r6.getKind();
        if (Intrinsics.areEqual(r1, luc.p.b.a) == false) goto L9;
    L25:
        g r2 = new d0(this.b, r0);
    L26:
        String r3 = this.e;
        if (r3 != null) goto L29;
    L39:
        return r2;
    L29:
        if ((r2 instanceof f0) == false) goto L34;
        f0 r4 = (f0) r2;
        r4.r("key", ouc.k.c(r3));
        String r5 = this.f;
        if (r5 != null) goto L33;
        r5 = r6.f();
    L33:
        r4.r("value", ouc.k.c(r5));
    L38:
        this.e = null;
        this.f = null;
        goto L39
    L34:
        String r7 = this.f;
        if (r7 != null) goto L37;
        r7 = r6.f();
    L37:
        r2.r(r3, ouc.k.c(r7));
        goto L38
    L9:
        if ((r1 instanceof luc.d) == true) goto L25;
        if (Intrinsics.areEqual(r1, luc.p.c.a) == false) goto L24;
        ouc.a r8 = this.b;
        luc.f r9 = s0.a(r6.h(0), r8.b);
        o r10 = r9.getKind();
        if ((r10 instanceof e) == false) goto L16;
    L23:
        r2 = new f0(this.b, r0);
        goto L26
    L16:
        if (Intrinsics.areEqual(r10, o.b.a) == true) goto L23;
        if (r8.a.d == false) goto L22;
        r2 = new d0(this.b, r0);
        goto L26
    L22:
        throw s.b(r9);
    L24:
        r2 = new b0(this.b, r0);
        goto L26
    L5:
        r0 = new d(this);
        goto L6
    }

    @Override // nuc.x2, muc.f
    public final muc.f encodeInline(luc.f r4) {
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        if (CollectionsKt.lastOrNull(this.a) == null) goto L9;
        if (this.e == null) goto L10;
        this.f = r4.f();
    L10:
        return super.encodeInline(r4);
    L9:
        return new x(this.b, this.c).encodeInline(r4);
    }

    @Override // nuc.x2
    public final void m(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        this.c.invoke(q());
    }

    public g(ouc.a r1, Function1 r2) {
        this.b = r1;
        this.c = r2;
        this.d = r1.a;
    }

    @Override // nuc.x2
    public final void b(String r2, boolean r3) {
        String r4 = r2;
        Intrinsics.checkNotNullParameter(r4, "tag");
        r(r4, ouc.k.a(Boolean.valueOf(r3)));
    }

    @Override // nuc.x2
    public final void c(String r2, byte r3) {
        String r4 = r2;
        Intrinsics.checkNotNullParameter(r4, "tag");
        r(r4, ouc.k.b(Byte.valueOf(r3)));
    }

    @Override // nuc.x2
    public final void d(String r2, char r3) {
        String r4 = r2;
        Intrinsics.checkNotNullParameter(r4, "tag");
        r(r4, ouc.k.c(String.valueOf(r3)));
    }

    @Override // nuc.x2
    public final void e(String r2, double r3) {
        String r4 = r2;
        Intrinsics.checkNotNullParameter(r4, "tag");
        r(r4, ouc.k.b(Double.valueOf(r3)));
        if (this.d.k == false) goto L5;
        return;
    L5:
        if (Double.isInfinite(r3) == false) goto L7;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == true) goto L15;
        Double r5 = Double.valueOf(r3);
        String r6 = q().toString();
        Intrinsics.checkNotNullParameter(r5, "value");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r6, "output");
        throw new JsonEncodingException(s.h(r5, r4, r6));
    L15:
        return;
    L7:
        if (Double.isNaN(r3) == true) goto L9;
        r0 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nuc.x2, muc.f
    public final <T> void encodeSerializableValue(n<? super T> r6, T r7) {
        Intrinsics.checkNotNullParameter(r6, "serializer");
        boolean r1 = false;
        if (CollectionsKt.lastOrNull(this.a) != null) goto L14;
        luc.f r0 = s0.a(r6.getDescriptor(), this.b.b);
        if ((r0.getKind() instanceof e) == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        new x(this.b, this.c).encodeSerializableValue(r6, r7);
        return;
    L7:
        if (r0.getKind() == o.b.a) goto L10;
        r2 = false;
    L14:
        f r3 = this.b.a;
        if (r3.i == false) goto L17;
        r6.serialize(this, r7);
        return;
    L17:
        boolean r4 = r6 instanceof nuc.b;
        if (r4 == true) goto L20;
        int r5 = h0.a.a[r3.p.ordinal()];
        if (r5 != 1) goto L25;
    L35:
        if (r1 == false) goto L37;
        String r8 = h0.c(r6.getDescriptor(), this.b);
    L38:
        if (r4 == false) goto L47;
        nuc.b r9 = (nuc.b) r6;
        if (r7 == 0) goto L46;
        n<? super T> r10 = juc.h.b(r9, this, r7);
        if (r8 == null) goto L44;
        h0.a(r6, r10, r8);
    L44:
        h0.b(r10.getDescriptor().getKind());
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>");
        r6 = r10;
        goto L47
    L46:
        throw new IllegalArgumentException(("Value for serializer " + r9.getDescriptor() + " should always be non-null. Please report issue to the kotlinx.serialization tracker.").toString());
    L47:
        if (r8 == null) goto L49;
        String r11 = r6.getDescriptor().f();
        this.e = r8;
        this.f = r11;
    L49:
        r6.serialize(this, r7);
        return;
    L37:
        r8 = null;
        goto L38
    L25:
        if (r5 == 2) goto L35;
        if (r5 != 3) goto L34;
        o r12 = r6.getDescriptor().getKind();
        if (Intrinsics.areEqual(r12, luc.p.a.a) == false) goto L31;
    L32:
        r1 = true;
        goto L35
    L31:
        if (Intrinsics.areEqual(r12, luc.p.d.a) == false) goto L35;
    L34:
        throw new NoWhenBranchMatchedException();
    L20:
        if (r3.p == ClassDiscriminatorMode.NONE) goto L35;
        goto L35
    }

    @Override // nuc.x2
    public final void g(String r3, float r4) {
        String r5 = r3;
        Intrinsics.checkNotNullParameter(r5, "tag");
        r(r5, ouc.k.b(Float.valueOf(r4)));
        if (this.d.k == false) goto L5;
        return;
    L5:
        if (Float.isInfinite(r4) == false) goto L7;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == true) goto L15;
        Float r6 = Float.valueOf(r4);
        String r1 = q().toString();
        Intrinsics.checkNotNullParameter(r6, "value");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r1, "output");
        throw new JsonEncodingException(s.h(r6, r5, r1));
    L15:
        return;
    L7:
        if (Float.isNaN(r4) == true) goto L9;
        r0 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // nuc.x2
    public final muc.f h(String r3, luc.f r4) {
        String r5 = r3;
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r4, "inlineDescriptor");
        if (l0.a(r4) == true) goto L15;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.isInline() == true) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L16;
        Intrinsics.checkNotNullParameter(r4, "inlineDescriptor");
        this.a.add((Tag) r5);
        return this;
    L16:
        return new e(this, r5, r4);
    L8:
        if (Intrinsics.areEqual(r4, ouc.k.a) == false) goto L10;
        r1 = true;
        goto L11
    L15:
        return new f(this, r5);
    }

    @Override // nuc.x2
    public final void i(String r2, int r3) {
        String r4 = r2;
        Intrinsics.checkNotNullParameter(r4, "tag");
        r(r4, ouc.k.b(Integer.valueOf(r3)));
    }

    @Override // nuc.x2
    public final void j(String r2, long r3) {
        String r4 = r2;
        Intrinsics.checkNotNullParameter(r4, "tag");
        r(r4, ouc.k.b(Long.valueOf(r3)));
    }

    @Override // nuc.x2
    public final void k(String r2, short r3) {
        String r4 = r2;
        Intrinsics.checkNotNullParameter(r4, "tag");
        r(r4, ouc.k.b(Short.valueOf(r3)));
    }

    @Override // nuc.x2
    public final void l(String r2, String r3) {
        String r4 = r2;
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r3, "value");
        r(r4, ouc.k.c(r3));
    }

    @Override // nuc.n1
    public String p(luc.f r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        ouc.a r0 = this.b;
        p.a<Map<String, Integer>> r1 = u.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r0, "json");
        u.e(r3, r0);
        return r3.b(r4);
    }

    @Override // muc.d
    public final boolean shouldEncodeElementDefault(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return this.d.a;
    }

    @Override // nuc.x2
    public final void f(String r2, luc.f r3, int r4) {
        String r5 = r2;
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r3, "enumDescriptor");
        r(r5, ouc.k.c(r3.b(r4)));
    }
}
