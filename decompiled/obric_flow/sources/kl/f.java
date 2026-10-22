package kl;

import com.gyf.barlibrary.BarHide;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18668a = null;

    static {
        int[] r5 = new int[BarHide.values().length];
        f18668a = r5;
        r5[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L12:
        f18668a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L14:
        f18668a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L18:
        f18668a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
        return;
    }
}
