package kotlinx.serialization.internal;

import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.serialization.c f19327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.serialization.c f19328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f19329c;
    public final kotlinx.serialization.descriptors.h d;

    public p0(final kotlinx.serialization.c r5, final kotlinx.serialization.c r10, int r11) {
        this.f19329c = r11;
        switch(r11) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "keySerializer");
        Intrinsics.checkNotNullParameter(r10, "valueSerializer");
        this(r5, r10, (byte) 0);
        this.d = kotlinx.serialization.descriptors.k.b("kotlin.collections.Map.Entry", kotlinx.serialization.descriptors.n.d, new kotlinx.serialization.descriptors.g[0], new MapEntrySerializer$descriptor$1(r5, r10));
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "keySerializer");
        Intrinsics.checkNotNullParameter(r10, "valueSerializer");
        this(r5, r10, (byte) 0);
        this.d = kotlinx.serialization.descriptors.k.a("kotlin.Pair", new kotlinx.serialization.descriptors.g[0], new PairSerializer$descriptor$1(r5, r10));
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r10) {
        Intrinsics.checkNotNullParameter(r10, "decoder");
        kotlinx.serialization.descriptors.g r5 = getDescriptor();
        eu.a r11 = r10.i(r5);
        Object r12 = z0.f19380c;
        Object r13 = r12;
        Object r14 = r13;
    L3:
        int r15 = r11.l(getDescriptor());
        if (r15 == (-1)) goto L12;
        if (r15 != 0) goto L7;
        r13 = f4.a.f(r11, getDescriptor(), 0, this.f19327a);
        goto L3
    L7:
        if (r15 != 1) goto L10;
        r14 = f4.a.f(r11, getDescriptor(), 1, this.f19328b);
        goto L3
    L10:
        throw new SerializationException(ai.j0.g(r15, "Invalid index: "));
    L12:
        if (r13 == r12) goto L23;
        if (r14 == r12) goto L21;
        switch(this.f19329c) {
            case 0: goto L17;
            default: goto L16;
        };
    L16:
        Object r16 = TuplesKt.to(r13, r14);
    L18:
        r11.u(r5);
        return r16;
    L17:
        r16 = new o0(r13, r14);
        goto L18
    L21:
        throw new SerializationException("Element 'value' is missing");
    L23:
        throw new SerializationException("Element 'key' is missing");
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        switch(this.f19329c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.d;
    L7:
        return this.d;
    }

    public p0(kotlinx.serialization.c r5, kotlinx.serialization.c r10, byte r11) {
        this.f19327a = r5;
        this.f19328b = r10;
    }
}
