package kotlinx.serialization.json.internal;

import ai.j0;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.internal.n1;
import kotlinx.serialization.json.b0;
import kotlinx.serialization.json.q;
import kotlinx.serialization.json.u;
import kotlinx.serialization.json.x;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends n1 implements kotlinx.serialization.json.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kotlinx.serialization.json.b f19416c;
    public final kotlinx.serialization.json.i d;

    public a(kotlinx.serialization.json.b r5) {
        this.f19416c = r5;
        this.d = r5.f19384a;
    }

    public static q N(b0 r5, String r10) {
        if ((r5 instanceof q) == false) goto L5;
        q r11 = (q) r5;
    L6:
        if (r11 == null) goto L9;
        return r11;
    L9:
        throw f.d(-1, "Unexpected 'null' literal when non-nullable " + r10 + " was expected");
    L5:
        r11 = null;
        goto L6
    }

    @Override // kotlinx.serialization.internal.n1, eu.b
    public boolean B() {
        return !(P() instanceof u);
    }

    @Override // kotlinx.serialization.json.j
    public final kotlinx.serialization.json.b C() {
        return this.f19416c;
    }

    @Override // kotlinx.serialization.internal.n1
    public final byte F(Object r5) {
        String r10 = (String) r5;
        Intrinsics.checkNotNullParameter(r10, "tag");
        int r11 = kotlinx.serialization.json.m.b(R(r10));     // Catch: IllegalArgumentException -> L15
        if ((-128) <= r11) goto L6;
    L9:
        Byte r12 = null;
    L10:
        if (r12 != null) goto L12;
        U("byte");     // Catch: IllegalArgumentException -> L15
        throw null;     // Catch: IllegalArgumentException -> L15
    L12:
        return r12.byteValue();
    L6:
        if (r11 > 127) goto L9;
        r12 = Byte.valueOf((byte) r11);     // Catch: IllegalArgumentException -> L15
    L15:
        U("byte");
        throw null;
    }

    @Override // kotlinx.serialization.internal.n1
    public final double G(Object r5) {
        String r10 = (String) r5;
        Intrinsics.checkNotNullParameter(r10, "tag");
        b0 r11 = R(r10);
        int r12 = kotlinx.serialization.json.m.f19441a;     // Catch: IllegalArgumentException -> L14
        Intrinsics.checkNotNullParameter(r11, "<this>");     // Catch: IllegalArgumentException -> L14
        double r13 = Double.parseDouble(r11.b());     // Catch: IllegalArgumentException -> L14
        if (this.f19416c.f19384a.f19411k == false) goto L7;
    L13:
        return r13;
    L7:
        if (Double.isInfinite(r13) == true) goto L12;
        if (Double.isNaN(r13) == false) goto L13;
    L12:
        throw f.a(Double.valueOf(r13), r10, P().toString());
    L14:
        U("double");
        throw null;
    }

    @Override // kotlinx.serialization.internal.n1
    public final float H(Object r5) {
        String r10 = (String) r5;
        Intrinsics.checkNotNullParameter(r10, "tag");
        b0 r11 = R(r10);
        int r12 = kotlinx.serialization.json.m.f19441a;     // Catch: IllegalArgumentException -> L14
        Intrinsics.checkNotNullParameter(r11, "<this>");     // Catch: IllegalArgumentException -> L14
        float r13 = Float.parseFloat(r11.b());     // Catch: IllegalArgumentException -> L14
        if (this.f19416c.f19384a.f19411k == false) goto L7;
    L13:
        return r13;
    L7:
        if (Float.isInfinite(r13) == true) goto L12;
        if (Float.isNaN(r13) == false) goto L13;
    L12:
        throw f.a(Float.valueOf(r13), r10, P().toString());
    L14:
        U("float");
        throw null;
    }

    @Override // kotlinx.serialization.internal.n1
    public final eu.b I(Object r5, kotlinx.serialization.descriptors.g r10) {
        String r11 = (String) r5;
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r10, "inlineDescriptor");
        Set r12 = o.f19439a;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isInline() == true) goto L5;
    L7:
        Intrinsics.checkNotNullParameter(r10, "inlineDescriptor");
        this.f19317a.add(r11);
        return this;
    L5:
        if (o.f19439a.contains(r10) == false) goto L7;
        return new d(new bi.e(R(r11).b(), 3), this.f19416c);
    }

    @Override // kotlinx.serialization.internal.n1
    public final long J(Object r5) {
        String r10 = (String) r5;
        Intrinsics.checkNotNullParameter(r10, "tag");
        b0 r11 = R(r10);
        int r12 = kotlinx.serialization.json.m.f19441a;     // Catch: IllegalArgumentException -> L9
        Intrinsics.checkNotNullParameter(r11, "<this>");     // Catch: IllegalArgumentException -> L9
        return new bi.e(r11.b(), 3).l();
    L6:
        e = move-exception;
        throw new NumberFormatException(e.getMessage());     // Catch: IllegalArgumentException -> L9
    L9:
        U("long");
        throw null;
    }

    @Override // kotlinx.serialization.internal.n1
    public final short K(Object r5) {
        String r10 = (String) r5;
        Intrinsics.checkNotNullParameter(r10, "tag");
        int r11 = kotlinx.serialization.json.m.b(R(r10));     // Catch: IllegalArgumentException -> L15
        if ((-32768) <= r11) goto L6;
    L9:
        Short r12 = null;
    L10:
        if (r12 != null) goto L12;
        U("short");     // Catch: IllegalArgumentException -> L15
        throw null;     // Catch: IllegalArgumentException -> L15
    L12:
        return r12.shortValue();
    L6:
        if (r11 > 32767) goto L9;
        r12 = Short.valueOf((short) r11);     // Catch: IllegalArgumentException -> L15
    L15:
        U("short");
        throw null;
    }

    @Override // kotlinx.serialization.internal.n1
    public final String L(Object r5) {
        String r10 = (String) r5;
        Intrinsics.checkNotNullParameter(r10, "tag");
        b0 r11 = R(r10);
        if (this.f19416c.f19384a.f19407c == true) goto L10;
        if (N(r11, "string").f19445a == true) goto L10;
        String r12 = j0.k("String literal for key '", r10, "' should be quoted.\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.");
        throw f.c(-1, P().toString(), r12);
    L10:
        if ((r11 instanceof u) == true) goto L14;
        return r11.b();
    L14:
        throw f.c(-1, P().toString(), "Unexpected 'null' value instead of string literal");
    }

    public abstract kotlinx.serialization.json.l O(String r5);

    public final kotlinx.serialization.json.l P() {
        String r5 = (String) CollectionsKt.lastOrNull(this.f19317a);
        if (r5 == null) goto L7;
        kotlinx.serialization.json.l r10 = O(r5);
        if (r10 == null) goto L7;
        return r10;
    L7:
        return T();
    }

    public String Q(kotlinx.serialization.descriptors.g r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return r5.e(r10);
    }

    public final b0 R(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        kotlinx.serialization.json.l r10 = O(r5);
        if ((r10 instanceof b0) == false) goto L5;
        b0 r11 = (b0) r10;
    L6:
        if (r11 == null) goto L9;
        return r11;
    L9:
        throw f.c(-1, P().toString(), "Expected JsonPrimitive at " + r5 + ", found " + r10);
    L5:
        r11 = null;
        goto L6
    }

    public final String S(kotlinx.serialization.descriptors.g r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r11 = Q(r5, r10);
        Intrinsics.checkNotNullParameter(r11, "nestedName");
        String r12 = (String) CollectionsKt.lastOrNull(this.f19317a);
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        Intrinsics.checkNotNullParameter(r12, "parentName");
        Intrinsics.checkNotNullParameter(r11, "childName");
        return r11;
    }

    public abstract kotlinx.serialization.json.l T();

    public final void U(String r5) {
        String r10 = j0.k("Failed to parse literal as '", r5, "' value");
        throw f.c(-1, P().toString(), r10);
    }

    @Override // kotlinx.serialization.json.j
    public final kotlinx.serialization.json.l f() {
        return P();
    }

    @Override // kotlinx.serialization.internal.n1
    public final boolean h(Object r5) {
        String r10 = (String) r5;
        Intrinsics.checkNotNullParameter(r10, "tag");
        b0 r11 = R(r10);
        if (this.f19416c.f19384a.f19407c == true) goto L24;
        if (N(r11, "boolean").f19445a == false) goto L24;
        throw f.c(-1, P().toString(), j0.k("Boolean literal for key '", r10, "' should be unquoted.\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON."));
    L24:
        int r12 = kotlinx.serialization.json.m.f19441a;     // Catch: IllegalArgumentException -> L22
        Intrinsics.checkNotNullParameter(r11, "<this>");     // Catch: IllegalArgumentException -> L22
        String r13 = r11.b();     // Catch: IllegalArgumentException -> L22
        String[] r14 = p.f19440a;     // Catch: IllegalArgumentException -> L22
        Intrinsics.checkNotNullParameter(r13, "<this>");     // Catch: IllegalArgumentException -> L22
        if (StringsKt.l(r13, "true") == false) goto L14;
        Boolean r15 = Boolean.TRUE;     // Catch: IllegalArgumentException -> L22
    L17:
        if (r15 == null) goto L21;
        return r15.booleanValue();
    L21:
        throw new IllegalArgumentException();     // Catch: IllegalArgumentException -> L22
    L14:
        if (StringsKt.l(r13, "false") == false) goto L16;
        r15 = Boolean.FALSE;     // Catch: IllegalArgumentException -> L22
        goto L17
    L16:
        r15 = null;
    L22:
        U("boolean");
        throw null;
    }

    @Override // eu.b
    public eu.a i(kotlinx.serialization.descriptors.g r11) {
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        kotlinx.serialization.json.l r5 = P();
        kotlinx.serialization.descriptors.k r10 = r11.getKind();
        if (Intrinsics.areEqual(r10, kotlinx.serialization.descriptors.n.f19244c) == false) goto L5;
        boolean r12 = true;
    L6:
        kotlinx.serialization.json.b r13 = this.f19416c;
        if (r12 == false) goto L14;
        if ((r5 instanceof kotlinx.serialization.json.d) == false) goto L12;
        eu.a r14 = new j(r13, (kotlinx.serialization.json.d) r5);
    L37:
        return r14;
    L12:
        throw f.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(kotlinx.serialization.json.d.class) + " as the serialized body of " + r11.h() + ", but had " + Reflection.getOrCreateKotlinClass(r5.getClass()));
    L14:
        if (Intrinsics.areEqual(r10, kotlinx.serialization.descriptors.n.d) == false) goto L35;
        kotlinx.serialization.descriptors.g r15 = f.f(r11.g(0), r13.f19385b);
        kotlinx.serialization.descriptors.k r16 = r15.getKind();
        if ((r16 instanceof kotlinx.serialization.descriptors.f) == true) goto L30;
        if (Intrinsics.areEqual(r16, kotlinx.serialization.descriptors.m.f19242b) == true) goto L30;
        if (r13.f19384a.d == false) goto L28;
        if ((r5 instanceof kotlinx.serialization.json.d) == false) goto L26;
        r14 = new j(r13, (kotlinx.serialization.json.d) r5);
        goto L37
    L26:
        throw f.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(kotlinx.serialization.json.d.class) + " as the serialized body of " + r11.h() + ", but had " + Reflection.getOrCreateKotlinClass(r5.getClass()));
    L28:
        throw f.b(r15);
    L30:
        if ((r5 instanceof x) == false) goto L33;
        r14 = new k(r13, (x) r5);
        goto L37
    L33:
        throw f.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(x.class) + " as the serialized body of " + r11.h() + ", but had " + Reflection.getOrCreateKotlinClass(r5.getClass()));
    L35:
        if ((r5 instanceof x) == false) goto L39;
        r14 = new i(r13, (x) r5, null, null);
        goto L37
    L39:
        throw f.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(x.class) + " as the serialized body of " + r11.h() + ", but had " + Reflection.getOrCreateKotlinClass(r5.getClass()));
    L5:
        r12 = r10 instanceof kotlinx.serialization.descriptors.d;
        goto L6
    }

    @Override // eu.b
    public final eu.b m(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        if (CollectionsKt.lastOrNull(this.f19317a) == null) goto L5;
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return I(M(), r5);
    L5:
        kotlinx.serialization.json.l r10 = T();
        return new h(this.f19416c, r10).m(r5);
    }

    @Override // eu.a
    public void u(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
    }

    @Override // kotlinx.serialization.internal.n1, eu.b
    public final Object w(kotlinx.serialization.b r5) {
        Intrinsics.checkNotNullParameter(r5, "deserializer");
        return f.i(this, r5);
    }

    @Override // eu.a
    public final jk.a x() {
        return this.f19416c.f19385b;
    }
}
