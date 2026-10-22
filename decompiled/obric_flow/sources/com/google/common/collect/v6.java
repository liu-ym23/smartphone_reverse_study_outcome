package com.google.common.collect;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class v6 implements i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f9197a = null;

    static {
        f9197a = new v6();
    }

    @Override // com.google.common.collect.i6
    public final h6 a(MapMakerInternalMap.Segment r5, h6 r10, h6 r11) {
        MapMakerInternalMap.WeakKeyWeakValueSegment r12 = (MapMakerInternalMap.WeakKeyWeakValueSegment) r5;
        w6 r13 = (w6) r10;
        w6 r14 = (w6) r11;
        if (r13.get() != 0) goto L6;
        return null;
    L6:
        if (MapMakerInternalMap.Segment.isCollected(r13) == true) goto L11;
        ReferenceQueue r15 = MapMakerInternalMap.WeakKeyWeakValueSegment.access$400(r12);
        ReferenceQueue r16 = MapMakerInternalMap.WeakKeyWeakValueSegment.access$500(r12);
        w6 r17 = new w6(r15, r13.get(), r13.f8938a, r14);
        r17.f9209c = r13.f9209c.b(r16, r17);
        return r17;
    L11:
        return null;
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Strength b() {
        return MapMakerInternalMap.Strength.WEAK;
    }

    @Override // com.google.common.collect.i6
    public final void c(MapMakerInternalMap.Segment r5, h6 r10, Object r11) {
        w6 r12 = (w6) r10;
        ReferenceQueue r13 = MapMakerInternalMap.WeakKeyWeakValueSegment.access$500((MapMakerInternalMap.WeakKeyWeakValueSegment) r5);
        y6 r14 = r12.f9209c;
        r12.f9209c = new z6(r13, r11, r12);
        r14.clear();
    }

    @Override // com.google.common.collect.i6
    public final h6 d(MapMakerInternalMap.Segment r5, Object r10, int r11, h6 r12) {
        ReferenceQueue r13 = MapMakerInternalMap.WeakKeyWeakValueSegment.access$400((MapMakerInternalMap.WeakKeyWeakValueSegment) r5);
        return new w6(r13, r10, r11, (w6) r12);
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Strength e() {
        return MapMakerInternalMap.Strength.WEAK;
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Segment f(MapMakerInternalMap r5, int r10, int r11) {
        return new MapMakerInternalMap.WeakKeyWeakValueSegment(r5, r10, r11);
    }
}
