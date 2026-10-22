package com.google.common.collect;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8892c;
    public MapMakerInternalMap.Strength d;
    public MapMakerInternalMap.Strength e;
    public com.google.common.base.p f;

    public a6() {
        this.f8891b = -1;
        this.f8892c = -1;
    }

    public final MapMakerInternalMap.Strength a() {
        return (MapMakerInternalMap.Strength) com.google.common.base.b0.y(this.d, MapMakerInternalMap.Strength.STRONG);
    }

    public final MapMakerInternalMap.Strength b() {
        return (MapMakerInternalMap.Strength) com.google.common.base.b0.y(this.e, MapMakerInternalMap.Strength.STRONG);
    }

    public final ConcurrentMap c() {
        if (this.f8890a == true) goto L13;
        int r5 = this.f8891b;
        if (r5 != (-1)) goto L7;
        r5 = 16;
    L7:
        int r10 = this.f8892c;
        if (r10 != (-1)) goto L11;
        r10 = 4;
    L11:
        return new ConcurrentHashMap(r5, 0.75f, r10);
    L13:
        return MapMakerInternalMap.create(this);
    }

    public final void d(MapMakerInternalMap.Strength r5) {
        MapMakerInternalMap.Strength r10 = this.d;
        if (r10 != null) goto L5;
        boolean r11 = true;
    L6:
        com.google.common.base.b0.s("Key strength was already set to %s", r11, r10);
        r5.getClass();
        this.d = r5;
        if (r5 == MapMakerInternalMap.Strength.STRONG) goto L10;
        this.f8890a = true;
        return;
    L10:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void e() {
        d(MapMakerInternalMap.Strength.WEAK);
    }

    public final String toString() {
        com.google.common.base.w r5 = com.google.common.base.b0.E(this);
        int r10 = this.f8891b;
        if (r10 == (-1)) goto L5;
        r5.c("initialCapacity", String.valueOf(r10));
    L5:
        int r11 = this.f8892c;
        if (r11 == (-1)) goto L8;
        r5.c("concurrencyLevel", String.valueOf(r11));
    L8:
        MapMakerInternalMap.Strength r12 = this.d;
        if (r12 == null) goto L11;
        r5.b(com.google.common.base.b0.D(r12.toString()), "keyStrength");
    L11:
        MapMakerInternalMap.Strength r13 = this.e;
        if (r13 == null) goto L15;
        r5.b(com.google.common.base.b0.D(r13.toString()), "valueStrength");
    L15:
        if (this.f == null) goto L18;
        com.google.common.base.w r14 = new com.google.common.base.w();
        ((com.google.common.base.w) r5.d).f8673c = r14;
        r5.d = r14;
        r14.d = "keyEquivalence";
    L18:
        return r5.toString();
    }
}
