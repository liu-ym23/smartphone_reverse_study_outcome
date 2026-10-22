package com.google.common.collect;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class o6 implements i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o6 f9105a = null;

    static {
        f9105a = new o6();
    }

    @Override // com.google.common.collect.i6
    public final h6 a(MapMakerInternalMap.Segment r5, h6 r10, h6 r11) {
        MapMakerInternalMap.StrongKeyWeakValueSegment r12 = (MapMakerInternalMap.StrongKeyWeakValueSegment) r5;
        p6 r13 = (p6) r10;
        p6 r14 = (p6) r11;
        if (MapMakerInternalMap.Segment.isCollected(r13) == false) goto L5;
        return null;
    L5:
        ReferenceQueue r15 = MapMakerInternalMap.StrongKeyWeakValueSegment.access$100(r12);
        p6 r16 = new p6(r13.f8923a, r13.f8924b, r14);
        r16.d = r13.d.b(r15, r16);
        return r16;
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Strength b() {
        return MapMakerInternalMap.Strength.WEAK;
    }

    @Override // com.google.common.collect.i6
    public final void c(MapMakerInternalMap.Segment r5, h6 r10, Object r11) {
        p6 r12 = (p6) r10;
        ReferenceQueue r13 = MapMakerInternalMap.StrongKeyWeakValueSegment.access$100((MapMakerInternalMap.StrongKeyWeakValueSegment) r5);
        y6 r14 = r12.d;
        r12.d = new z6(r13, r11, r12);
        r14.clear();
    }

    @Override // com.google.common.collect.i6
    public final h6 d(MapMakerInternalMap.Segment r5, Object r10, int r11, h6 r12) {
        MapMakerInternalMap.StrongKeyWeakValueSegment r13 = (MapMakerInternalMap.StrongKeyWeakValueSegment) r5;
        return new p6(r10, r11, (p6) r12);
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Strength e() {
        return MapMakerInternalMap.Strength.STRONG;
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Segment f(MapMakerInternalMap r5, int r10, int r11) {
        return new MapMakerInternalMap.StrongKeyWeakValueSegment(r5, r10, r11);
    }
}
