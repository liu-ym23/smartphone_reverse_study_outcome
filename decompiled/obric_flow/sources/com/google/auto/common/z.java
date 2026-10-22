package com.google.auto.common;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f8638a = null;

    static {
        int[] r5 = new int[Visibility.values().length];
        f8638a = r5;
        r5[Visibility.PRIVATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f8638a[Visibility.DEFAULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
