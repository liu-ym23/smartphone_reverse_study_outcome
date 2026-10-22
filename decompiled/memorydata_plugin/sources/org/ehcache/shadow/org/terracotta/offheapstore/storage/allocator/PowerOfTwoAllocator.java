package org.ehcache.shadow.org.terracotta.offheapstore.storage.allocator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.ehcache.shadow.org.terracotta.offheapstore.util.b;
import org.ehcache.shadow.org.terracotta.offheapstore.util.c;

/* JADX INFO: loaded from: classes7.dex */
public class PowerOfTwoAllocator extends org.ehcache.shadow.org.terracotta.offheapstore.util.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f18125a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f18126b = false;
    private volatile int c;

    /* JADX INFO: renamed from: org.ehcache.shadow.org.terracotta.offheapstore.storage.allocator.PowerOfTwoAllocator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract enum Packing extends Enum<Packing> {
        private static final /* synthetic */ Packing[] $VALUES = null;
        public static final Packing CEILING = null;
        public static final Packing FLOOR = null;

        static {
            final String r1 = "FLOOR";
            final int r2 = 0;
            Packing r0 = new AnonymousClass1(r1, r2);
            FLOOR = r0;
            final String r3 = "CEILING";
            final int r4 = 1;
            Packing r5 = new AnonymousClass2(r3, r4);
            CEILING = r5;
            $VALUES = new Packing[]{r0, r5};
        }

        private Packing(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ Packing(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static Packing valueOf(String r2) {
            return (Packing) ZeusTransformUtils.preCheckCast(Enum.valueOf(Packing.class, r2), Packing.class, "com.obric.memorydata.plugin");
        }

        public static Packing[] values() {
            return (Packing[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Packing[].class, "com.obric.memorydata.plugin");
        }

        abstract org.ehcache.shadow.org.terracotta.offheapstore.util.a.b<a> fallback(org.ehcache.shadow.org.terracotta.offheapstore.util.a.b<a> r1);

        abstract org.ehcache.shadow.org.terracotta.offheapstore.util.a.b<a> prefered(org.ehcache.shadow.org.terracotta.offheapstore.util.a.b<a> r1);

        abstract a slice(a r1, int r2);
    }

    static {
        f18125a = Boolean.getBoolean(PowerOfTwoAllocator.class.getName() + ".DEBUG");
        f18126b = c.a(PowerOfTwoAllocator.class);
    }

    private boolean a(a r1) {
        return a(r1);
    }

    private void insert(a r2) {
        if (a(r2) == false) goto L6;
        return;
    L6:
        throw new AssertionError(r2 + " is already inserted");
    }

    public int a() {
        return this.c;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        a r0 = (a) ZeusTransformUtils.preCheckCast(d().f(), a.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder("PowerOfTwoAllocator: Occupied ");
        r1.append(b.a(a())).append("B");
        StringBuilder r2 = r1.append(" [Largest Available Area ");
        if (r0 != null) goto L5;
        int r3 = 0;
    L6:
        r2.append(b.a(Integer.highestOneBit(r3))).append("B]");
        if (f18125a == false) goto L10;
        r1.append("\nFree Regions = ").append(super.toString()).append("");
    L10:
        return r1.toString();
    L5:
        r3 = r0.a();
        goto L6
    }
}
