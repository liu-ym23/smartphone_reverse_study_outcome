package com.google.common.collect;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class t6 implements i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t6 f9169a = null;

    static {
        f9169a = new t6();
    }

    @Override // com.google.common.collect.i6
    public final h6 a(MapMakerInternalMap.Segment r5, h6 r10, h6 r11) {
        MapMakerInternalMap.WeakKeyStrongValueSegment r12 = (MapMakerInternalMap.WeakKeyStrongValueSegment) r5;
        u6 r13 = (u6) r10;
        u6 r14 = (u6) r11;
        if (r13.get() != 0) goto L5;
        return null;
    L5:
        u6 r15 = new u6(MapMakerInternalMap.WeakKeyStrongValueSegment.access$300(r12), r13.get(), r13.f8938a, r14);
        r15.f9185c = r13.f9185c;
        return r15;
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Strength b() {
        return MapMakerInternalMap.Strength.STRONG;
    }

    @Override // com.google.common.collect.i6
    public final void c(MapMakerInternalMap.Segment r5, h6 r10, Object r11) {
        MapMakerInternalMap.WeakKeyStrongValueSegment r12 = (MapMakerInternalMap.WeakKeyStrongValueSegment) r5;
        ((u6) r10).f9185c = r11;
    }

    @Override // com.google.common.collect.i6
    public final h6 d(MapMakerInternalMap.Segment r5, Object r10, int r11, h6 r12) {
        ReferenceQueue r13 = MapMakerInternalMap.WeakKeyStrongValueSegment.access$300((MapMakerInternalMap.WeakKeyStrongValueSegment) r5);
        return new u6(r13, r10, r11, (u6) r12);
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Strength e() {
        return MapMakerInternalMap.Strength.WEAK;
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Segment f(MapMakerInternalMap r5, int r10, int r11) {
        return new MapMakerInternalMap.WeakKeyStrongValueSegment(r5, r10, r11);
    }
}
