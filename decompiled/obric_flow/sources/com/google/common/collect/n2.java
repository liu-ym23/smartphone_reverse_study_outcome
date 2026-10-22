package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n2 {
    final boolean supportsFastOffset;

    public n2() {
        this(false);
    }

    public static n2 bigIntegers() {
        return DiscreteDomain$BigIntegerDomain.access$300();
    }

    public static n2 integers() {
        return DiscreteDomain$IntegerDomain.access$000();
    }

    public static n2 longs() {
        return DiscreteDomain$LongDomain.access$200();
    }

    public abstract long distance(Comparable r5, Comparable r10);

    public Comparable maxValue() {
        throw new NoSuchElementException();
    }

    public Comparable minValue() {
        throw new NoSuchElementException();
    }

    public abstract Comparable next(Comparable r5);

    public abstract Comparable offset(Comparable r5, long r10);

    public abstract Comparable previous(Comparable r5);

    public n2(boolean r5) {
        this.supportsFastOffset = r5;
    }
}
