package com.google.common.base;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f8647a = null;

    static {
        int[] r5 = new int[AbstractIterator$State.values().length];
        f8647a = r5;
        r5[AbstractIterator$State.DONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f8647a[AbstractIterator$State.READY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
