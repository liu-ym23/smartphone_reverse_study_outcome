package org.ehcache.shadow.org.terracotta.offheapstore.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.List;
import org.ehcache.shadow.org.terracotta.offheapstore.storage.allocator.PowerOfTwoAllocator;
import org.ehcache.shadow.org.terracotta.offheapstore.util.MemoryUnit;
import org.ehcache.shadow.org.terracotta.offheapstore.util.b;
import org.slf4j.c;
import org.slf4j.d;

/* JADX INFO: loaded from: classes7.dex */
public class UpfrontAllocatingPageSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f18121a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f18122b = null;
    private static final long c = 0;
    private static final Comparator<a> d = null;
    private final List<PowerOfTwoAllocator> e;
    private final List<PowerOfTwoAllocator> f;
    private final List<ByteBuffer> g;

    public static final enum ThresholdDirection extends Enum<ThresholdDirection> {
        private static final /* synthetic */ ThresholdDirection[] $VALUES = null;
        public static final ThresholdDirection FALLING = null;
        public static final ThresholdDirection RISING = null;

        static {
            ThresholdDirection r0 = new ThresholdDirection("RISING", 0);
            RISING = r0;
            ThresholdDirection r1 = new ThresholdDirection("FALLING", 1);
            FALLING = r1;
            $VALUES = new ThresholdDirection[]{r0, r1};
        }

        private ThresholdDirection(String r1, int r2) {
            super(r1, r2);
        }

        public static ThresholdDirection valueOf(String r2) {
            return (ThresholdDirection) ZeusTransformUtils.preCheckCast(Enum.valueOf(ThresholdDirection.class, r2), ThresholdDirection.class, "com.obric.memorydata.plugin");
        }

        public static ThresholdDirection[] values() {
            return (ThresholdDirection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ThresholdDirection[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f18121a = UpfrontAllocatingPageSource.class.getName() + ".allocationDump";
        f18122b = d.a(UpfrontAllocatingPageSource.class);
        c = MemoryUnit.GIGABYTES.toBytes(4);
        d = $$Lambda$UpfrontAllocatingPageSource$7rBxVV_rWJ_by9SiVggnbWAVe_8.INSTANCE;
    }

    private static /* synthetic */ int a(a r2, a r3) {
        if (r2.b() != r3.b()) goto L7;
        int r4 = r2.a();
        int r5 = r3.a();
    L6:
        return r4 - r5;
    L7:
        r4 = r2.b();
        r5 = r3.b();
        goto L6
    }

    public static /* synthetic */ int lambda$7rBxVV_rWJ_by9SiVggnbWAVe_8(a r0, a r1) {
        return a(r0, r1);
    }

    public synchronized String toString() {
        monitor-enter(this);
        StringBuilder r0 = new StringBuilder("UpfrontAllocatingPageSource");     // Catch: Throwable -> L10
        int r1 = 0;
    L5:
        if (r1 >= this.g.size()) goto L7;
        int r3 = r1 + 1;     // Catch: Throwable -> L10
        r0.append("\nChunk ").append(r3).append('\n');     // Catch: Throwable -> L10
        r0.append("Size             : ").append(b.a(((ByteBuffer) ZeusTransformUtils.preCheckCast(this.g.get(r1), ByteBuffer.class, "com.obric.memorydata.plugin")).capacity())).append("B\n");     // Catch: Throwable -> L10
        r0.append("Free Allocator   : ").append(this.e.get(r1)).append('\n');     // Catch: Throwable -> L10
        r0.append("Victim Allocator : ").append(this.f.get(r1));     // Catch: Throwable -> L10
        r1 = r3;
        goto L5
    L7:
        String r2 = r0.toString();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r2;
    L10:
        th = move-exception;
        throw th;
    }
}
