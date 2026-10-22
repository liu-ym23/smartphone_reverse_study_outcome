package com.google.common.util.concurrent;

import java.util.function.DoubleBinaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class s implements DoubleBinaryOperator {
    @Override // java.util.function.DoubleBinaryOperator
    public final double applyAsDouble(double r5, double r10) {
        return Double.sum(r5, r10);
    }
}
