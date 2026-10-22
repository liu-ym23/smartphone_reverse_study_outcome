package oo;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f20802a = null;

    static {
        int[] r5 = new int[Bitmap.Config.values().length];
        f20802a = r5;
        r5[Bitmap.Config.ARGB_8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L12:
        f20802a[Bitmap.Config.ALPHA_8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L14:
        f20802a[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L18:
        f20802a[Bitmap.Config.RGB_565.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
        return;
    }
}
