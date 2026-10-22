package com.squareup.javapoet;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f14997a = null;

    static {
        int[] r5 = new int[LineWrapper$FlushType.values().length];
        f14997a = r5;
        r5[LineWrapper$FlushType.WRAP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L10:
        f14997a[LineWrapper$FlushType.SPACE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L12:
        f14997a[LineWrapper$FlushType.EMPTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
        return;
    }
}
