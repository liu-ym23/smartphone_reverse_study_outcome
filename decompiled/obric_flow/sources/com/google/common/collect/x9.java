package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class x9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f9226a = null;

    static {
        int[] r5 = new int[BoundType.values().length];
        f9226a = r5;
        r5[BoundType.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f9226a[BoundType.CLOSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
