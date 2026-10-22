package kotlinx.serialization.internal;

import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes3.dex */
public final class o1 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.serialization.c f19322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.serialization.c f19323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kotlinx.serialization.c f19324c;
    public final kotlinx.serialization.descriptors.h d;

    public o1(kotlinx.serialization.c r5, kotlinx.serialization.c r10, kotlinx.serialization.c r11) {
        Intrinsics.checkNotNullParameter(r5, "aSerializer");
        Intrinsics.checkNotNullParameter(r10, "bSerializer");
        Intrinsics.checkNotNullParameter(r11, "cSerializer");
        this.f19322a = r5;
        this.f19323b = r10;
        this.f19324c = r11;
        this.d = kotlinx.serialization.descriptors.k.a("kotlin.Triple", new kotlinx.serialization.descriptors.g[0], new TripleSerializer$descriptor$1(this));
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r10) {
        Intrinsics.checkNotNullParameter(r10, "decoder");
        kotlinx.serialization.descriptors.h r5 = this.d;
        eu.a r11 = r10.i(r5);
        Object r12 = z0.f19380c;
        Object r13 = r12;
        Object r14 = r13;
        Object r15 = r14;
    L3:
        int r16 = r11.l(r5);
        if (r16 == (-1)) goto L15;
        if (r16 != 0) goto L7;
        r13 = f4.a.f(r11, r5, 0, this.f19322a);
        goto L3
    L7:
        if (r16 != 1) goto L9;
        r14 = f4.a.f(r11, r5, 1, this.f19323b);
        goto L3
    L9:
        if (r16 != 2) goto L12;
        r15 = f4.a.f(r11, r5, 2, this.f19324c);
        goto L3
    L12:
        throw new SerializationException(ai.j0.g(r16, "Unexpected index "));
    L15:
        r11.u(r5);
        if (r13 == r12) goto L26;
        if (r14 == r12) goto L24;
        if (r15 == r12) goto L22;
        return new Triple(r13, r14, r15);
    L22:
        throw new SerializationException("Element 'third' is missing");
    L24:
        throw new SerializationException("Element 'second' is missing");
    L26:
        throw new SerializationException("Element 'first' is missing");
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return this.d;
    }
}
