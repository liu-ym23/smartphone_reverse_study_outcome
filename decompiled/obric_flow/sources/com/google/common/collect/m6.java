package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class m6 implements i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m6 f9076a = null;

    static {
        f9076a = new m6();
    }

    @Override // com.google.common.collect.i6
    public final h6 a(MapMakerInternalMap.Segment r5, h6 r10, h6 r11) {
        MapMakerInternalMap.StrongKeyStrongValueSegment r12 = (MapMakerInternalMap.StrongKeyStrongValueSegment) r5;
        n6 r13 = (n6) r10;
        Object r14 = r13.f8923a;
        int r15 = r13.f8924b;
        n6 r16 = new n6(r14, r15, (n6) r11);
        r16.d = r13.d;
        return r16;
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Strength b() {
        return MapMakerInternalMap.Strength.STRONG;
    }

    @Override // com.google.common.collect.i6
    public final void c(MapMakerInternalMap.Segment r5, h6 r10, Object r11) {
        MapMakerInternalMap.StrongKeyStrongValueSegment r12 = (MapMakerInternalMap.StrongKeyStrongValueSegment) r5;
        ((n6) r10).d = r11;
    }

    @Override // com.google.common.collect.i6
    public final h6 d(MapMakerInternalMap.Segment r5, Object r10, int r11, h6 r12) {
        MapMakerInternalMap.StrongKeyStrongValueSegment r13 = (MapMakerInternalMap.StrongKeyStrongValueSegment) r5;
        return new n6(r10, r11, (n6) r12);
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Strength e() {
        return MapMakerInternalMap.Strength.STRONG;
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Segment f(MapMakerInternalMap r5, int r10, int r11) {
        return new MapMakerInternalMap.StrongKeyStrongValueSegment(r5, r10, r11);
    }
}
