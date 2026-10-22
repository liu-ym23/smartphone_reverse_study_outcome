package com.google.common.collect;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class r6 implements i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r6 f9149a = null;

    static {
        f9149a = new r6();
    }

    @Override // com.google.common.collect.i6
    public final h6 a(MapMakerInternalMap.Segment r5, h6 r10, h6 r11) {
        MapMakerInternalMap.WeakKeyDummyValueSegment r12 = (MapMakerInternalMap.WeakKeyDummyValueSegment) r5;
        s6 r13 = (s6) r10;
        s6 r14 = (s6) r11;
        if (r13.get() != 0) goto L6;
        return null;
    L6:
        return new s6(MapMakerInternalMap.WeakKeyDummyValueSegment.access$200(r12), r13.get(), r13.f8938a, r14);
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Strength b() {
        return MapMakerInternalMap.Strength.STRONG;
    }

    @Override // com.google.common.collect.i6
    public final /* bridge */ /* synthetic */ void c(MapMakerInternalMap.Segment r5, h6 r10, Object r11) {
        MapMakerInternalMap.WeakKeyDummyValueSegment r12 = (MapMakerInternalMap.WeakKeyDummyValueSegment) r5;
        s6 r13 = (s6) r10;
        MapMaker$Dummy r14 = (MapMaker$Dummy) r11;
    }

    @Override // com.google.common.collect.i6
    public final h6 d(MapMakerInternalMap.Segment r5, Object r10, int r11, h6 r12) {
        ReferenceQueue r13 = MapMakerInternalMap.WeakKeyDummyValueSegment.access$200((MapMakerInternalMap.WeakKeyDummyValueSegment) r5);
        return new s6(r13, r10, r11, (s6) r12);
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Strength e() {
        return MapMakerInternalMap.Strength.WEAK;
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Segment f(MapMakerInternalMap r5, int r10, int r11) {
        return new MapMakerInternalMap.WeakKeyDummyValueSegment(r5, r10, r11);
    }
}
