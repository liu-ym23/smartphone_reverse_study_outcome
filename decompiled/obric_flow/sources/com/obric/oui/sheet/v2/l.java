package com.obric.oui.sheet.v2;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f14509a = null;

    static {
        int[] r5 = new int[OSheet$HeightMode.values().length];
        r5[OSheet$HeightMode.FULL_HEIGHT.ordinal()] = 1;
        r5[OSheet$HeightMode.WRAP_HEIGHT.ordinal()] = 2;
        f14509a = r5;
        int[] r10 = new int[OSheet$Header.values().length];
        r10[OSheet$Header.PAGE.ordinal()] = 1;
        r10[OSheet$Header.ACTION.ordinal()] = 2;
        r10[OSheet$Header.MODAL.ordinal()] = 3;
        r10[OSheet$Header.ONLY_TITLE.ordinal()] = 4;
        r10[OSheet$Header.PAGE_WITH_CLOSE.ordinal()] = 5;
    }
}
