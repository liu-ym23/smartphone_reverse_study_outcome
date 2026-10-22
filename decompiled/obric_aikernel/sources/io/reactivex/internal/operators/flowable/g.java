package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;

/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f9515a = null;

    static {
        int[] r10 = new int[BackpressureOverflowStrategy.values().length];
        f9515a = r10;
        r10[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f9515a[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
