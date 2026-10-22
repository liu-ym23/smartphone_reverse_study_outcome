package com.ss.android.lark.maincore;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum ITitleController$Style extends Enum<ITitleController$Style> {
    public static final ITitleController$Style New = null;
    public static final ITitleController$Style Old = null;
    public static final /* synthetic */ ITitleController$Style[] a = null;
    private int value;

    static {
        ITitleController$Style r0 = new ITitleController$Style("Old", 0, 0);
        Old = r0;
        ITitleController$Style r1 = new ITitleController$Style("New", 1, 1);
        New = r1;
        a = new ITitleController$Style[]{r0, r1};
    }

    public static ITitleController$Style[] values() {
        return (ITitleController$Style[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static ITitleController$Style forNumber(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return New;
    L10:
        return Old;
    }

    public static ITitleController$Style valueOf(String r1) {
        return (ITitleController$Style) a.a(ITitleController$Style.class, r1);
    }

    public static ITitleController$Style valueOf(int r0) {
        return forNumber(r0);
    }

    public ITitleController$Style(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
