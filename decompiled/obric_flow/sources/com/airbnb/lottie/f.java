package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1259a = null;

    static {
        int[] r5 = new int[RenderMode.values().length];
        f1259a = r5;
        r5[RenderMode.HARDWARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L10:
        f1259a[RenderMode.SOFTWARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L12:
        f1259a[RenderMode.AUTOMATIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
        return;
    }
}
