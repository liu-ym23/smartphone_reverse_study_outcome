package q0;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21458a = null;

    static {
        int[] r5 = new int[Bitmap.Config.values().length];
        f21458a = r5;
        r5[Bitmap.Config.ALPHA_8.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L14:
        f21458a[Bitmap.Config.RGB_565.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L18:
        f21458a[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L22:
        f21458a[Bitmap.Config.RGBA_F16.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L16:
        f21458a[Bitmap.Config.ARGB_8888.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
        return;
    }
}
