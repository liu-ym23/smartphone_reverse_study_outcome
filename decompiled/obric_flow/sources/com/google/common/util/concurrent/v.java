package com.google.common.util.concurrent;

import java.util.function.LongBinaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class v implements LongBinaryOperator {
    @Override // java.util.function.LongBinaryOperator
    public final long applyAsLong(long r5, long r10) {
        return Long.sum(r5, r10);
    }
}
