package com.bumptech.glide;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1398a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f1399b = null;

    static {
        int[] r5 = new int[Priority.values().length];
        f1399b = r5;
        r5[Priority.LOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
    L34:
        f1399b[Priority.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
    L44:
        f1399b[Priority.HIGH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
    L54:
        f1399b[Priority.IMMEDIATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
    L10:
        int[] r10 = new int[ImageView.ScaleType.values().length];
        f1398a = r10;
        r10[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
    L36:
        f1398a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
    L42:
        f1398a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
    L48:
        f1398a[ImageView.ScaleType.FIT_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
    L32:
        f1398a[ImageView.ScaleType.FIT_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
    L40:
        f1398a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
    L52:
        f1398a[ImageView.ScaleType.CENTER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
    L38:
        f1398a[ImageView.ScaleType.MATRIX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
        return;
    }
}
