package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t implements DoubleUnaryOperator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DoubleBinaryOperator f9435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ double f9436c;

    public /* synthetic */ t(int r5, double r10, DoubleBinaryOperator r11) {
        this.f9434a = r5;
        this.f9435b = r11;
        this.f9436c = r10;
    }

    @Override // java.util.function.DoubleUnaryOperator
    public final double applyAsDouble(double r5) {
        double r10 = this.f9436c;
        DoubleBinaryOperator r11 = this.f9435b;
        switch(this.f9434a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L7;
            default: goto L5;
        };
    L8:
        AtomicLongFieldUpdater r12 = AtomicDouble.f9382b;
        return r11.applyAsDouble(r5, r10);
    L10:
        AtomicLongFieldUpdater r13 = AtomicDouble.f9382b;
        return r11.applyAsDouble(r5, r10);
    L5:
        return r11.applyAsDouble(r5, r10);
    L7:
        return r11.applyAsDouble(r5, r10);
    }
}
