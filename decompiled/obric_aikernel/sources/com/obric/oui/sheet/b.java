package com.obric.oui.sheet;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7407a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f7408b = null;

    static {
        int[] r10 = new int[OInsetSheetTitleBar.TitlePosition.values().length];
        f7407a = r10;
        OInsetSheetTitleBar.TitlePosition r11 = OInsetSheetTitleBar.TitlePosition.FIXED_CENTER;
        r10[r11.ordinal()] = 1;
        OInsetSheetTitleBar.TitlePosition r12 = OInsetSheetTitleBar.TitlePosition.FLOW_WITH_ACTION;
        r10[r12.ordinal()] = 2;
        OInsetSheetTitleBar.TitlePosition r13 = OInsetSheetTitleBar.TitlePosition.LEFT_IN_ACTION;
        r10[r13.ordinal()] = 3;
        int[] r14 = new int[OInsetSheetTitleBar.TitlePosition.values().length];
        f7408b = r14;
        r14[r11.ordinal()] = 1;
        r14[r12.ordinal()] = 2;
        r14[r13.ordinal()] = 3;
    }
}
