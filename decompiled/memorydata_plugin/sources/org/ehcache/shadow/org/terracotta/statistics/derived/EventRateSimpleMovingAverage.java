package org.ehcache.shadow.org.terracotta.statistics.derived;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;
import org.ehcache.shadow.org.terracotta.statistics.StatisticType;
import org.ehcache.shadow.org.terracotta.statistics.k;
import org.ehcache.shadow.org.terracotta.statistics.l;

/* JADX INFO: loaded from: classes7.dex */
public class EventRateSimpleMovingAverage implements l<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<CounterPartition> f18149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<CounterPartition> f18150b;
    private volatile long c;

    static class CounterPartition extends LongAdder {
        private static final long serialVersionUID = 1;
        private final long end;
        private final long start;

        CounterPartition(long r1, long r3) {
            this.start = r1;
            this.end = r1 + r3;
        }

        public long end() {
            return this.end;
        }

        public boolean isBefore(long r3) {
            if (this.end >= r3) goto L5;
            return true;
        L5:
            return false;
        }

        public long start() {
            return this.start;
        }

        public boolean targetFor(long r3) {
            if (this.end <= r3) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public Double a() {
        return b();
    }

    public Double b() {
        long r0 = k.a();
        long r2 = r0 - this.c;
        CounterPartition r4 = (CounterPartition) ZeusTransformUtils.preCheckCast(this.f18150b.get(), CounterPartition.class, "com.obric.memorydata.plugin");
        if (r4.isBefore(r2) == false) goto L5;
        long r11 = r2;
        long r9 = 0;
    L6:
        Iterator<CounterPartition> r15 = this.f18149a.iterator();
    L8:
        if (r15.hasNext() == false) goto L17;
        CounterPartition r5 = (CounterPartition) ZeusTransformUtils.preCheckCast(r15.next(), CounterPartition.class, "com.obric.memorydata.plugin");
        if (r5 == r4) goto L17;
        if (r5.isBefore(r2) == true) goto L14;
        r11 = Math.min(r11, r5.start());
        r9 = r9 + r5.sum();
        goto L8
    L14:
        r15.remove();
    L17:
        if (r9 != 0) goto L21;
        return Double.valueOf(0.0d);
    L21:
        return Double.valueOf((TimeUnit.SECONDS.toNanos(1) * r9) / (r0 - r11));
    L5:
        r9 = r4.sum();
        r11 = Math.min(r2, r4.start());
        goto L6
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.l
    public StatisticType type() {
        return StatisticType.RATE;
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.l
    public /* synthetic */ Serializable value() {
        return a();
    }
}
