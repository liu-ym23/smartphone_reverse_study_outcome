package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f17665a = null;

    static {
        int[] r5 = new int[BackpressureOverflowStrategy.values().length];
        f17665a = r5;
        r5[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f17665a[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
