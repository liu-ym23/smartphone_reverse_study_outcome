package com.google.common.cache;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class LongAddables$PureJavaLongAddable extends AtomicLong implements r0 {
    private LongAddables$PureJavaLongAddable() {
    }

    @Override // com.google.common.cache.r0
    public void add(long r5) {
        getAndAdd(r5);
    }

    @Override // com.google.common.cache.r0
    public void increment() {
        getAndIncrement();
    }

    @Override // com.google.common.cache.r0
    public long sum() {
        return get();
    }

    public /* synthetic */ LongAddables$PureJavaLongAddable(s0 r5) {
        this();
    }
}
