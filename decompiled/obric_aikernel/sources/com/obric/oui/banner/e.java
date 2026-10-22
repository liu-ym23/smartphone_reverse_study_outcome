package com.obric.oui.banner;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6243a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f6244b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f6245c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f6246d = null;

    static {
        int[] r10 = new int[BannerStyle.values().length];
        f6243a = r10;
        BannerStyle r11 = BannerStyle.TRIPTYCH;
        r10[r11.ordinal()] = 1;
        int[] r12 = new int[BannerStyle.values().length];
        f6244b = r12;
        r12[r11.ordinal()] = 1;
        int[] r13 = new int[BannerStyle.values().length];
        f6245c = r13;
        BannerStyle r14 = BannerStyle.FILL;
        r13[r14.ordinal()] = 1;
        BannerStyle r15 = BannerStyle.INDENT;
        r13[r15.ordinal()] = 2;
        r13[r11.ordinal()] = 3;
        int[] r16 = new int[BannerStyle.values().length];
        f6246d = r16;
        r16[r14.ordinal()] = 1;
        r16[r15.ordinal()] = 2;
        r16[r11.ordinal()] = 3;
    }
}
