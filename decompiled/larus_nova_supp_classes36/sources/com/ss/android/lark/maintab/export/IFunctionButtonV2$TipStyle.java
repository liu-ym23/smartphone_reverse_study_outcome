package com.ss.android.lark.maintab.export;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum IFunctionButtonV2$TipStyle extends Enum<IFunctionButtonV2$TipStyle> {
    public static final IFunctionButtonV2$TipStyle Custom = null;
    public static final IFunctionButtonV2$TipStyle RedDot = null;
    public static final /* synthetic */ IFunctionButtonV2$TipStyle[] a = null;
    private int value;

    static {
        IFunctionButtonV2$TipStyle r0 = new IFunctionButtonV2$TipStyle("RedDot", 0, 0);
        RedDot = r0;
        IFunctionButtonV2$TipStyle r1 = new IFunctionButtonV2$TipStyle("Custom", 1, 1);
        Custom = r1;
        a = new IFunctionButtonV2$TipStyle[]{r0, r1};
    }

    public static IFunctionButtonV2$TipStyle[] values() {
        return (IFunctionButtonV2$TipStyle[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static IFunctionButtonV2$TipStyle forNumber(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return RedDot;
    L8:
        return Custom;
    L10:
        return RedDot;
    }

    public static IFunctionButtonV2$TipStyle valueOf(String r1) {
        return (IFunctionButtonV2$TipStyle) r27.a.a(IFunctionButtonV2$TipStyle.class, r1);
    }

    public static IFunctionButtonV2$TipStyle valueOf(int r0) {
        return forNumber(r0);
    }

    public IFunctionButtonV2$TipStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
