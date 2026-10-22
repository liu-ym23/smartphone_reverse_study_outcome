package com.google.common.hash;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class LongAddables$PureJavaLongAddable extends AtomicLong implements r {
    private LongAddables$PureJavaLongAddable() {
    }

    @Override // com.google.common.hash.r
    public void add(long r5) {
        getAndAdd(r5);
    }

    @Override // com.google.common.hash.r
    public void increment() {
        getAndIncrement();
    }

    @Override // com.google.common.hash.r
    public long sum() {
        return get();
    }

    public /* synthetic */ LongAddables$PureJavaLongAddable(s r5) {
        this();
    }
}
