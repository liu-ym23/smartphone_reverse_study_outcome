package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class MapMaker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f4517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f4518b;
    int c;
    MapMakerInternalMap.Strength d;
    MapMakerInternalMap.Strength e;
    Equivalence<Object> f;

    static final enum Dummy extends Enum<Dummy> {
        private static final /* synthetic */ Dummy[] $VALUES = null;
        public static final Dummy VALUE = null;

        private static /* synthetic */ Dummy[] $values() {
            return new Dummy[]{VALUE};
        }

        static {
            VALUE = new Dummy("VALUE", 0);
            $VALUES = $values();
        }

        private Dummy(String r1, int r2) {
            super(r1, r2);
        }

        public static Dummy valueOf(String r2) {
            return (Dummy) ZeusTransformUtils.preCheckCast(Enum.valueOf(Dummy.class, r2), Dummy.class, "com.obric.memorydata.plugin");
        }

        public static Dummy[] values() {
            return (Dummy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Dummy[].class, "com.obric.memorydata.plugin");
        }
    }

    public MapMaker() {
        this.f4518b = -1;
        this.c = -1;
    }

    Equivalence<Object> a() {
        return (Equivalence) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a(this.f, e().defaultEquivalence()), Equivalence.class, "com.obric.memorydata.plugin");
    }

    public MapMaker a(int r6) {
        int r0 = this.f4518b;
        boolean r1 = true;
        if (r0 != (-1)) goto L5;
        boolean r3 = true;
    L6:
        com.google.common.base.n.b(r3, "initial capacity was already set to %s", r0);
        if (r6 >= 0) goto L10;
        r1 = false;
    L10:
        com.google.common.base.n.a(r1);
        this.f4518b = r6;
        return this;
    L5:
        r3 = false;
        goto L6
    }

    MapMaker a(Equivalence<Object> r5) {
        Equivalence<Object> r0 = this.f;
        if (r0 != null) goto L5;
        boolean r2 = true;
    L6:
        com.google.common.base.n.b(r2, "key equivalence was already set to %s", r0);
        this.f = (Equivalence) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), Equivalence.class, "com.obric.memorydata.plugin");
        this.f4517a = true;
        return this;
    L5:
        r2 = false;
        goto L6
    }

    MapMaker a(MapMakerInternalMap.Strength r5) {
        MapMakerInternalMap.Strength r0 = this.d;
        if (r0 != null) goto L5;
        boolean r2 = true;
    L6:
        com.google.common.base.n.b(r2, "Key strength was already set to %s", r0);
        this.d = (MapMakerInternalMap.Strength) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), MapMakerInternalMap.Strength.class, "com.obric.memorydata.plugin");
        if (r5 == MapMakerInternalMap.Strength.STRONG) goto L9;
        this.f4517a = true;
    L9:
        return this;
    L5:
        r2 = false;
        goto L6
    }

    int b() {
        int r1 = this.f4518b;
        if (r1 != (-1)) goto L6;
        return 16;
    L6:
        return r1;
    }

    public MapMaker b(int r6) {
        int r0 = this.c;
        boolean r1 = true;
        if (r0 != (-1)) goto L5;
        boolean r3 = true;
    L6:
        com.google.common.base.n.b(r3, "concurrency level was already set to %s", r0);
        if (r6 > 0) goto L10;
        r1 = false;
    L10:
        com.google.common.base.n.a(r1);
        this.c = r6;
        return this;
    L5:
        r3 = false;
        goto L6
    }

    MapMaker b(MapMakerInternalMap.Strength r5) {
        MapMakerInternalMap.Strength r0 = this.e;
        if (r0 != null) goto L5;
        boolean r2 = true;
    L6:
        com.google.common.base.n.b(r2, "Value strength was already set to %s", r0);
        this.e = (MapMakerInternalMap.Strength) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), MapMakerInternalMap.Strength.class, "com.obric.memorydata.plugin");
        if (r5 == MapMakerInternalMap.Strength.STRONG) goto L9;
        this.f4517a = true;
    L9:
        return this;
    L5:
        r2 = false;
        goto L6
    }

    int c() {
        int r1 = this.c;
        if (r1 != (-1)) goto L6;
        return 4;
    L6:
        return r1;
    }

    public MapMaker d() {
        return a(MapMakerInternalMap.Strength.WEAK);
    }

    MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a(this.d, MapMakerInternalMap.Strength.STRONG), MapMakerInternalMap.Strength.class, "com.obric.memorydata.plugin");
    }

    MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a(this.e, MapMakerInternalMap.Strength.STRONG), MapMakerInternalMap.Strength.class, "com.obric.memorydata.plugin");
    }

    public <K, V> ConcurrentMap<K, V> g() {
        if (this.f4517a == true) goto L7;
        return new ConcurrentHashMap(b(), 0.75f, c());
    L7:
        return MapMakerInternalMap.create(this);
    }

    public String toString() {
        com.google.common.base.i.a r0 = com.google.common.base.i.a(this);
        int r1 = this.f4518b;
        if (r1 == (-1)) goto L5;
        r0.a("initialCapacity", r1);
    L5:
        int r2 = this.c;
        if (r2 == (-1)) goto L8;
        r0.a("concurrencyLevel", r2);
    L8:
        MapMakerInternalMap.Strength r3 = this.d;
        if (r3 == null) goto L11;
        r0.a("keyStrength", com.google.common.base.a.a(r3.toString()));
    L11:
        MapMakerInternalMap.Strength r4 = this.e;
        if (r4 == null) goto L15;
        r0.a("valueStrength", com.google.common.base.a.a(r4.toString()));
    L15:
        if (this.f == null) goto L18;
        r0.a("keyEquivalence");
    L18:
        return r0.toString();
    }
}
