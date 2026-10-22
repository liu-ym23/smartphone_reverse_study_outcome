package kotlinx.serialization.json.internal;

import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import luc.e;
import luc.o;
import nuc.m1;
import ouc.f;
import ouc.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class c extends m1 implements ouc.h {
    public final ouc.a c;
    public final String d;
    public final f e;

    public void endStructure(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
    }

    public abstract ouc.i r(String r1);

    public abstract ouc.i t();

    @Override // muc.e, muc.c
    public final kotlinx.serialization.modules.d getSerializersModule() {
        return this.c.b;
    }

    public final ouc.i s() {
        String r0 = (String) CollectionsKt.lastOrNull(this.a);
        if (r0 == null) goto L7;
        ouc.i r1 = r(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return t();
    }

    @Override // ouc.h
    public final ouc.i a() {
        return s();
    }

    @Override // muc.e
    public boolean decodeNotNullMark() {
        return !(s() instanceof ouc.a0);
    }

    @Override // ouc.h
    public final ouc.a getJson() {
        return this.c;
    }

    @Override // nuc.w2
    public final boolean b(String r5) {
        String r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "tag");
        ouc.i r1 = r(r6);
        if ((r1 instanceof ouc.g0) == false) goto L14;
        ouc.g0 r2 = (ouc.g0) r1;
        Boolean r3 = ouc.k.f(r2);     // Catch: IllegalArgumentException -> L11
        if (r3 != null) goto L8;
        v(r2, "boolean", r6);     // Catch: IllegalArgumentException -> L11
        throw null;     // Catch: IllegalArgumentException -> L11
    L8:
        return r3.booleanValue();
    L11:
        v(r2, "boolean", r6);
        throw null;
    L14:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.g0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r1.getClass()).getSimpleName() + " as the serialized body of boolean at element: " + u(r6), r1.toString());
    }

    @Override // muc.e
    public muc.c beginStructure(luc.f r11) {
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        ouc.b r0 = s();
        o r1 = r11.getKind();
        if (Intrinsics.areEqual(r1, luc.p.b.a) == false) goto L5;
    L33:
        ouc.a r2 = this.c;
        String r12 = r11.f();
        if ((r0 instanceof ouc.b) == false) goto L38;
        muc.c r3 = new c0(r2, r0);
    L36:
        return r3;
    L38:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.b.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName() + " as the serialized body of " + r12 + " at element: " + q(), r0.toString());
    L5:
        if ((r1 instanceof luc.d) == true) goto L33;
        if (Intrinsics.areEqual(r1, luc.p.c.a) == false) goto L28;
        ouc.a r4 = this.c;
        luc.f r5 = s0.a(r11.h(0), r4.b);
        o r8 = r5.getKind();
        if ((r8 instanceof e) == false) goto L12;
    L23:
        ouc.a r6 = this.c;
        String r13 = r11.f();
        if ((r0 instanceof ouc.d0) == false) goto L27;
        r3 = new e0(r6, (ouc.d0) r0);
        goto L36
    L27:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.d0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName() + " as the serialized body of " + r13 + " at element: " + q(), r0.toString());
    L12:
        if (Intrinsics.areEqual(r8, o.b.a) == true) goto L23;
        if (r4.a.d == false) goto L22;
        ouc.a r7 = this.c;
        String r14 = r11.f();
        if ((r0 instanceof ouc.b) == false) goto L20;
        r3 = new c0(r7, r0);
        goto L36
    L20:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.b.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName() + " as the serialized body of " + r14 + " at element: " + q(), r0.toString());
    L22:
        throw s.b(r5);
    L28:
        ouc.a r9 = this.c;
        String r15 = r11.f();
        if ((r0 instanceof ouc.d0) == false) goto L32;
        r3 = new a0(r9, (ouc.d0) r0, this.d, 8);
        goto L36
    L32:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.d0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName() + " as the serialized body of " + r15 + " at element: " + q(), r0.toString());
    }

    @Override // nuc.w2
    public final byte c(String r6) {
        String r7 = r6;
        Intrinsics.checkNotNullParameter(r7, "tag");
        ouc.i r1 = r(r7);
        if ((r1 instanceof ouc.g0) == false) goto L23;
        ouc.g0 r2 = (ouc.g0) r1;
        int r3 = ouc.k.k(r2);     // Catch: IllegalArgumentException -> L20
        if ((-128) <= r3) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L14;
        Byte r5 = Byte.valueOf((byte) r3);     // Catch: IllegalArgumentException -> L20
    L15:
        if (r5 != null) goto L17;
        v(r2, "byte", r7);     // Catch: IllegalArgumentException -> L20
        throw null;     // Catch: IllegalArgumentException -> L20
    L17:
        return r5.byteValue();
    L14:
        r5 = null;
        goto L15
    L8:
        if (r3 > 127) goto L10;
        r4 = true;
    L20:
        v(r2, "byte", r7);
        throw null;
    L23:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.g0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r1.getClass()).getSimpleName() + " as the serialized body of byte at element: " + u(r7), r1.toString());
    }

    @Override // nuc.w2
    public final char d(String r4) {
        String r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "tag");
        ouc.i r0 = r(r5);
        if ((r0 instanceof ouc.g0) == false) goto L10;
        ouc.g0 r1 = (ouc.g0) r0;
        return StringsKt.single(r1.a());
    L7:
        v(r1, "char", r5);
        throw null;
    L10:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.g0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName() + " as the serialized body of char at element: " + u(r5), r0.toString());
    }

    @Override // nuc.w2, muc.e
    public final muc.e decodeInline(luc.f r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        if (CollectionsKt.lastOrNull(this.a) == null) goto L6;
        return super.decodeInline(r5);
    L6:
        return new w(this.c, t(), this.d).decodeInline(r5);
    }

    @Override // nuc.w2, muc.e
    public final <T> T decodeSerializableValue(juc.c<? extends T> r6) {
        Intrinsics.checkNotNullParameter(r6, "deserializer");
        if ((r6 instanceof nuc.b) == false) goto L21;
        if (getJson().a.i == true) goto L21;
        nuc.b r0 = (nuc.b) r6;
        String r1 = h0.c(r0.getDescriptor(), getJson());
        ouc.d0 r2 = a();
        String r3 = r0.getDescriptor().f();
        if ((r2 instanceof ouc.d0) == false) goto L19;
        ouc.d0 r4 = r2;
        ouc.i r5 = (ouc.i) r4.get(r1);
        if (r5 == null) goto L12;
        String r7 = ouc.k.g(ouc.k.o(r5));
    L22:
        juc.c r8 = juc.h.a((nuc.b) r6, this, r7);     // Catch: SerializationException -> L15
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
        return (T) p0.a(getJson(), r1, r4, r8);
    L15:
        e = move-exception;
        String r9 = e.getMessage();
        Intrinsics.checkNotNull(r9);
        throw s.d(-1, r9, r4.toString());
    L12:
        r7 = null;
        goto L22
    L19:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.d0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r2.getClass()).getSimpleName() + " as the serialized body of " + r3 + " at element: " + q(), r2.toString());
    L21:
        return r6.deserialize(this);
    }

    @Override // nuc.w2
    public final double e(String r5) {
        String r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "tag");
        ouc.i r0 = r(r6);
        if ((r0 instanceof ouc.g0) == false) goto L22;
        ouc.g0 r1 = (ouc.g0) r0;
        double r2 = ouc.k.h(r1);     // Catch: IllegalArgumentException -> L19
        if (this.c.a.k == false) goto L9;
    L18:
        return r2;
    L9:
        if (Double.isInfinite(r2) == false) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L18;
        Double r4 = Double.valueOf(r2);
        String r7 = s().toString();
        Intrinsics.checkNotNullParameter(r4, "value");
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "output");
        throw s.c(-1, s.h(r4, r6, r7));
    L11:
        if (Double.isNaN(r2) == true) goto L13;
        r3 = true;
    L19:
        v(r1, "double", r6);
        throw null;
    L22:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.g0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName() + " as the serialized body of double at element: " + u(r6), r0.toString());
    }

    @Override // nuc.w2
    public final float g(String r5) {
        String r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "tag");
        ouc.i r0 = r(r6);
        if ((r0 instanceof ouc.g0) == false) goto L22;
        ouc.g0 r1 = (ouc.g0) r0;
        nuc.r0 r2 = ouc.k.a;     // Catch: IllegalArgumentException -> L19
        Intrinsics.checkNotNullParameter(r1, "<this>");     // Catch: IllegalArgumentException -> L19
        float r3 = CastFloatProtector.parseFloat(r1.a());     // Catch: IllegalArgumentException -> L19
        if (this.c.a.k == false) goto L9;
    L18:
        return r3;
    L9:
        if (Float.isInfinite(r3) == false) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L18;
        Float r7 = Float.valueOf(r3);
        String r8 = s().toString();
        Intrinsics.checkNotNullParameter(r7, "value");
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r8, "output");
        throw s.c(-1, s.h(r7, r6, r8));
    L11:
        if (Float.isNaN(r3) == true) goto L13;
        r4 = true;
    L19:
        v(r1, "float", r6);
        throw null;
    L22:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.g0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName() + " as the serialized body of float at element: " + u(r6), r0.toString());
    }

    @Override // nuc.w2
    public final int i(String r4) {
        String r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "tag");
        ouc.i r0 = r(r5);
        if ((r0 instanceof ouc.g0) == false) goto L10;
        ouc.g0 r1 = (ouc.g0) r0;
        return ouc.k.k(r1);
    L7:
        v(r1, "int", r5);
        throw null;
    L10:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.g0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName() + " as the serialized body of int at element: " + u(r5), r0.toString());
    }

    @Override // nuc.w2
    public final long j(String r4) {
        String r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "tag");
        ouc.i r0 = r(r5);
        if ((r0 instanceof ouc.g0) == false) goto L10;
        ouc.g0 r1 = (ouc.g0) r0;
        return ouc.k.p(r1);
    L7:
        v(r1, "long", r5);
        throw null;
    L10:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.g0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName() + " as the serialized body of long at element: " + u(r5), r0.toString());
    }

    @Override // nuc.w2
    public final short k(String r6) {
        String r7 = r6;
        Intrinsics.checkNotNullParameter(r7, "tag");
        ouc.i r1 = r(r7);
        if ((r1 instanceof ouc.g0) == false) goto L23;
        ouc.g0 r2 = (ouc.g0) r1;
        int r3 = ouc.k.k(r2);     // Catch: IllegalArgumentException -> L20
        if ((-32768) <= r3) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L14;
        Short r5 = Short.valueOf((short) r3);     // Catch: IllegalArgumentException -> L20
    L15:
        if (r5 != null) goto L17;
        v(r2, "short", r7);     // Catch: IllegalArgumentException -> L20
        throw null;     // Catch: IllegalArgumentException -> L20
    L17:
        return r5.shortValue();
    L14:
        r5 = null;
        goto L15
    L8:
        if (r3 > 32767) goto L10;
        r4 = true;
    L20:
        v(r2, "short", r7);
        throw null;
    L23:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.g0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r1.getClass()).getSimpleName() + " as the serialized body of short at element: " + u(r7), r1.toString());
    }

    @Override // nuc.w2
    public final String l(String r5) {
        String r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "tag");
        ouc.g0 r0 = r(r6);
        if ((r0 instanceof ouc.g0) == false) goto L18;
        ouc.g0 r1 = r0;
        if ((r1 instanceof x) == false) goto L16;
        x r2 = (x) r1;
        if (r2.a == true) goto L14;
        if (this.c.a.c == true) goto L14;
        throw s.d(-1, "String literal for key '" + r6 + "' should be quoted at element: " + u(r6) + ".\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.", s().toString());
    L14:
        return r2.c;
    L16:
        throw s.d(-1, "Expected string value for a non-null key '" + r6 + "', got null literal instead at element: " + u(r6), s().toString());
    L18:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.g0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName() + " as the serialized body of string at element: " + u(r6), r0.toString());
    }

    public final String u(String r3) {
        Intrinsics.checkNotNullParameter(r3, "currentTag");
        return q() + '.' + r3;
    }

    @Override // nuc.w2
    public final int f(String r5, luc.f r6) {
        String r7 = r5;
        Intrinsics.checkNotNullParameter(r7, "tag");
        Intrinsics.checkNotNullParameter(r6, "enumDescriptor");
        ouc.a r0 = this.c;
        ouc.g0 r1 = r(r7);
        String r2 = r6.f();
        if ((r1 instanceof ouc.g0) == false) goto L7;
        return u.d(r6, r0, r1.a(), "");
    L7:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.g0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r1.getClass()).getSimpleName() + " as the serialized body of " + r2 + " at element: " + u(r7), r1.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // nuc.w2
    public final muc.e h(String r4, luc.f r5) {
        String r6 = r4;
        Intrinsics.checkNotNullParameter(r6, "tag");
        Intrinsics.checkNotNullParameter(r5, "inlineDescriptor");
        if (l0.a(r5) == false) goto L13;
        ouc.a r0 = this.c;
        ouc.i r1 = r(r6);
        String r7 = r5.f();
        if ((r1 instanceof ouc.g0) == false) goto L12;
        String r8 = ((ouc.g0) r1).a();
        Intrinsics.checkNotNullParameter(r0, "json");
        Intrinsics.checkNotNullParameter(r8, "source");
        if (r0.a.o == true) goto L9;
        m0 r9 = new m0(r8);
    L15:
        return new r(r9, this.c);
    L9:
        r9 = new n0(r8);
        goto L15
    L12:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.g0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r1.getClass()).getSimpleName() + " as the serialized body of " + r7 + " at element: " + u(r6), r1.toString());
    L13:
        Intrinsics.checkNotNullParameter(r5, "inlineDescriptor");
        this.a.add((Tag) r6);
        return this;
    }

    public c(ouc.a r1, ouc.i r2, String r3) {
        this.c = r1;
        this.d = r3;
        this.e = r1.a;
    }

    public final void v(ouc.g0 r5, String r6, String r7) {
        if (StringsKt.startsWith$default(r6, "i", false, 2, null) == false) goto L5;
        StringBuilder r0 = new StringBuilder("an ");
    L6:
        r0.append(r6);
        throw s.d(-1, "Failed to parse literal '" + r5 + "' as " + r0.toString() + " value at element: " + u(r7), s().toString());
    L5:
        r0 = new StringBuilder("a ");
        goto L6
    }
}
