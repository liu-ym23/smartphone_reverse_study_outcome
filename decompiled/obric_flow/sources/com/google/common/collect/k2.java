package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f9054a = null;

    static {
        int[] r5 = new int[BoundType.values().length];
        f9054a = r5;
        r5[BoundType.CLOSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f9054a[BoundType.OPEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
