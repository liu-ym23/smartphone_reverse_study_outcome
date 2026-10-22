package com.obric.oui.sheet.v2;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7432a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f7433b = null;

    static {
        int[] r10 = new int[OSheetTitleBar.TitlePosition.values().length];
        f7432a = r10;
        OSheetTitleBar.TitlePosition r11 = OSheetTitleBar.TitlePosition.FIXED_CENTER;
        r10[r11.ordinal()] = 1;
        OSheetTitleBar.TitlePosition r12 = OSheetTitleBar.TitlePosition.FLOW_WITH_ACTION;
        r10[r12.ordinal()] = 2;
        OSheetTitleBar.TitlePosition r13 = OSheetTitleBar.TitlePosition.LEFT_IN_ACTION;
        r10[r13.ordinal()] = 3;
        int[] r14 = new int[OSheetTitleBar.TitlePosition.values().length];
        f7433b = r14;
        r14[r11.ordinal()] = 1;
        r14[r12.ordinal()] = 2;
        r14[r13.ordinal()] = 3;
    }
}
