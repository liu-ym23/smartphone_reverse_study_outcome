package com.gyf.barlibrary;

/* JADX INFO: loaded from: classes2.dex */
public final enum BarHide extends Enum<BarHide> {
    public static final BarHide FLAG_HIDE_BAR = null;
    public static final BarHide FLAG_HIDE_NAVIGATION_BAR = null;
    public static final BarHide FLAG_HIDE_STATUS_BAR = null;
    public static final BarHide FLAG_SHOW_BAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BarHide[] f9465a = null;

    static {
        BarHide r5 = new BarHide("FLAG_HIDE_STATUS_BAR", 0);
        FLAG_HIDE_STATUS_BAR = r5;
        BarHide r10 = new BarHide("FLAG_HIDE_NAVIGATION_BAR", 1);
        FLAG_HIDE_NAVIGATION_BAR = r10;
        BarHide r11 = new BarHide("FLAG_HIDE_BAR", 2);
        FLAG_HIDE_BAR = r11;
        BarHide r12 = new BarHide("FLAG_SHOW_BAR", 3);
        FLAG_SHOW_BAR = r12;
        f9465a = new BarHide[]{r5, r10, r11, r12};
    }

    public static BarHide valueOf(String r5) {
        return (BarHide) Enum.valueOf(BarHide.class, r5);
    }

    public static BarHide[] values() {
        return (BarHide[]) f9465a.clone();
    }
}
