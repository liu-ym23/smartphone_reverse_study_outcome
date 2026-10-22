package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class k6 implements i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k6 f9056a = null;

    static {
        f9056a = new k6();
    }

    @Override // com.google.common.collect.i6
    public final h6 a(MapMakerInternalMap.Segment r5, h6 r10, h6 r11) {
        MapMakerInternalMap.StrongKeyDummyValueSegment r12 = (MapMakerInternalMap.StrongKeyDummyValueSegment) r5;
        l6 r13 = (l6) r10;
        Object r14 = r13.f8923a;
        int r15 = r13.f8924b;
        return new l6(r14, r15, (l6) r11);
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Strength b() {
        return MapMakerInternalMap.Strength.STRONG;
    }

    @Override // com.google.common.collect.i6
    public final /* bridge */ /* synthetic */ void c(MapMakerInternalMap.Segment r5, h6 r10, Object r11) {
        MapMakerInternalMap.StrongKeyDummyValueSegment r12 = (MapMakerInternalMap.StrongKeyDummyValueSegment) r5;
        l6 r13 = (l6) r10;
        MapMaker$Dummy r14 = (MapMaker$Dummy) r11;
    }

    @Override // com.google.common.collect.i6
    public final h6 d(MapMakerInternalMap.Segment r5, Object r10, int r11, h6 r12) {
        MapMakerInternalMap.StrongKeyDummyValueSegment r13 = (MapMakerInternalMap.StrongKeyDummyValueSegment) r5;
        return new l6(r10, r11, (l6) r12);
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Strength e() {
        return MapMakerInternalMap.Strength.STRONG;
    }

    @Override // com.google.common.collect.i6
    public final MapMakerInternalMap.Segment f(MapMakerInternalMap r5, int r10, int r11) {
        return new MapMakerInternalMap.StrongKeyDummyValueSegment(r5, r10, r11);
    }
}
