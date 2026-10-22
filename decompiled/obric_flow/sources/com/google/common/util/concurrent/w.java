package com.google.common.util.concurrent;

import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class w implements LongUnaryOperator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LongBinaryOperator f9442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f9443c;

    public /* synthetic */ w(LongBinaryOperator r5, long r10, int r11) {
        this.f9441a = r11;
        this.f9442b = r5;
        this.f9443c = r10;
    }

    @Override // java.util.function.LongUnaryOperator
    public final long applyAsLong(long r5) {
        switch(this.f9441a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f9442b.applyAsLong(r5, this.f9443c);
    L7:
        return this.f9442b.applyAsLong(r5, this.f9443c);
    }
}
