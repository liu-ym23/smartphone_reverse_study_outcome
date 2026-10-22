package org.ehcache.core.spi.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a<V> implements Store.d<V> {
    private static final AtomicLongFieldUpdater<a> d = null;
    private static final AtomicLongFieldUpdater<a> e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f18060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f18061b;
    private volatile long c;

    static {
        d = AtomicLongFieldUpdater.newUpdater(a.class, "b");
        e = AtomicLongFieldUpdater.newUpdater(a.class, "c");
    }

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, a.class) == false) goto L12;
        a r7 = (a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.memorydata.plugin");
        if (r7.f18060a == this.f18060a) goto L7;
        return false;
    L7:
        if (r7.c == this.c) goto L9;
        return false;
    L9:
        if (r7.f18061b != this.f18061b) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public int hashCode() {
        long r0 = this.f18060a;
        int r1 = (((((int) (r0 ^ (r0 >>> 32))) + 31) * 31) + ((int) (this.f18061b ^ (this.f18061b >>> 32)))) * 31;
        long r3 = this.c;
        return r1 + ((int) ((this.c >>> 32) ^ r3));
    }

    public String toString() {
        return String.format("%s", new Object[]{get()});
    }
}
