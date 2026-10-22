package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n1 implements eu.b, eu.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f19317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19318b;

    public n1() {
        this.f19317a = new ArrayList();
    }

    @Override // eu.a
    public final long A(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return J(((kotlinx.serialization.json.internal.a) this).S(r5, r10));
    }

    @Override // eu.b
    public abstract boolean B();

    @Override // eu.a
    public final eu.b D(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return I(((kotlinx.serialization.json.internal.a) this).S(r5, r10), r5.g(r10));
    }

    @Override // eu.b
    public final byte E() {
        return F(M());
    }

    public abstract byte F(Object r5);

    public abstract double G(Object r5);

    public abstract float H(Object r5);

    public abstract eu.b I(Object r5, kotlinx.serialization.descriptors.g r10);

    public abstract long J(Object r5);

    public abstract short K(Object r5);

    public abstract String L(Object r5);

    public final Object M() {
        ArrayList r5 = this.f19317a;
        Object r10 = r5.remove(CollectionsKt.getLastIndex(r5));
        this.f19318b = true;
        return r10;
    }

    @Override // eu.a
    public final float a(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return H(((kotlinx.serialization.json.internal.a) this).S(r5, r10));
    }

    @Override // eu.a
    public final char b(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        kotlinx.serialization.json.internal.a r11 = (kotlinx.serialization.json.internal.a) this;
        String r12 = r11.S(r5, r10);
        Intrinsics.checkNotNullParameter(r12, "tag");
        return StringsKt.I(r11.R(r12).b());
    L5:
        r11.U("char");
        throw null;
    }

    @Override // eu.b
    public final int c(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "enumDescriptor");
        Object r10 = M();
        kotlinx.serialization.json.internal.a r11 = (kotlinx.serialization.json.internal.a) this;
        String r12 = (String) r10;
        Intrinsics.checkNotNullParameter(r12, "tag");
        Intrinsics.checkNotNullParameter(r5, "enumDescriptor");
        String r13 = r11.R(r12).b();
        return kotlinx.serialization.json.internal.f.l(r5, r11.f19416c, r13, "");
    }

    @Override // eu.a
    public final byte d(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return F(((kotlinx.serialization.json.internal.a) this).S(r5, r10));
    }

    @Override // eu.a
    public final boolean e(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return h(((kotlinx.serialization.json.internal.a) this).S(r5, r10));
    }

    @Override // eu.b
    public final int g() {
        Object r5 = M();
        kotlinx.serialization.json.internal.a r10 = (kotlinx.serialization.json.internal.a) this;
        String r11 = (String) r5;
        Intrinsics.checkNotNullParameter(r11, "tag");
        return kotlinx.serialization.json.m.b(r10.R(r11));
    L5:
        r10.U("int");
        throw null;
    }

    public abstract boolean h(Object r5);

    @Override // eu.b
    public final long j() {
        return J(M());
    }

    @Override // eu.a
    public final String k(kotlinx.serialization.descriptors.g r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return L(((kotlinx.serialization.json.internal.a) this).S(r5, r10));
    }

    @Override // eu.a
    public final double n(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return G(((kotlinx.serialization.json.internal.a) this).S(r5, r10));
    }

    @Override // eu.b
    public final short o() {
        return K(M());
    }

    @Override // eu.b
    public final float p() {
        return H(M());
    }

    @Override // eu.b
    public final double q() {
        return G(M());
    }

    @Override // eu.a
    public final short r(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return K(((kotlinx.serialization.json.internal.a) this).S(r5, r10));
    }

    @Override // eu.b
    public final boolean s() {
        return h(M());
    }

    @Override // eu.b
    public final char t() {
        Object r5 = M();
        kotlinx.serialization.json.internal.a r10 = (kotlinx.serialization.json.internal.a) this;
        String r11 = (String) r5;
        Intrinsics.checkNotNullParameter(r11, "tag");
        return StringsKt.I(r10.R(r11).b());
    L5:
        r10.U("char");
        throw null;
    }

    @Override // eu.a
    public final int v(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        kotlinx.serialization.json.internal.a r11 = (kotlinx.serialization.json.internal.a) this;
        String r12 = r11.S(r5, r10);
        Intrinsics.checkNotNullParameter(r12, "tag");
        return kotlinx.serialization.json.m.b(r11.R(r12));
    L5:
        r11.U("int");
        throw null;
    }

    @Override // eu.b
    public abstract Object w(kotlinx.serialization.b r5);

    @Override // eu.a
    public final Object y(kotlinx.serialization.descriptors.g r5, int r10, final kotlinx.serialization.b r11, final Object r12) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Intrinsics.checkNotNullParameter(r11, "deserializer");
        String r13 = ((kotlinx.serialization.json.internal.a) this).S(r5, r10);
        Function0<Object> r14 = new TaggedDecoder$decodeSerializableElement$1(this, r11, r12);
        this.f19317a.add(r13);
        Object r15 = r14.invoke();
        if (this.f19318b == true) goto L5;
        M();
    L5:
        this.f19318b = false;
        return r15;
    }

    @Override // eu.b
    public final String z() {
        return L(M());
    }
}
