package com.obric.oui.titlebar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7723a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f7724b = null;

    static {
        int[] r10 = new int[OCTitleBar.TitlePosition.values().length];
        f7723a = r10;
        OCTitleBar.TitlePosition r11 = OCTitleBar.TitlePosition.FIXED_CENTER;
        r10[r11.ordinal()] = 1;
        OCTitleBar.TitlePosition r12 = OCTitleBar.TitlePosition.FLOW_WITH_ACTION;
        r10[r12.ordinal()] = 2;
        OCTitleBar.TitlePosition r13 = OCTitleBar.TitlePosition.LEFT_IN_ACTION;
        r10[r13.ordinal()] = 3;
        int[] r14 = new int[OCTitleBar.TitlePosition.values().length];
        f7724b = r14;
        r14[r11.ordinal()] = 1;
        r14[r12.ordinal()] = 2;
        r14[r13.ordinal()] = 3;
    }
}
