package com.google.common.math;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f9305a = null;

    static {
        int[] r5 = new int[RoundingMode.values().length];
        f9305a = r5;
        r5[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
    L20:
        f9305a[RoundingMode.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
    L24:
        f9305a[RoundingMode.FLOOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
    L34:
        f9305a[RoundingMode.UP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
    L22:
        f9305a[RoundingMode.CEILING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
    L26:
        f9305a[RoundingMode.HALF_DOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
    L28:
        f9305a[RoundingMode.HALF_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
    L30:
        f9305a[RoundingMode.HALF_EVEN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
        return;
    }
}
