package com.cronutils.model.field.value;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum SpecialChar extends Enum<SpecialChar> {
    public static final SpecialChar HASH = null;
    public static final SpecialChar L = null;
    public static final SpecialChar LW = null;
    public static final SpecialChar NONE = null;
    public static final SpecialChar QUESTION_MARK = null;
    public static final SpecialChar W = null;
    public static final /* synthetic */ SpecialChar[] a = null;

    static {
        SpecialChar r0 = new SpecialChar("LW", 0);
        LW = r0;
        SpecialChar r1 = new SpecialChar("L", 1);
        L = r1;
        SpecialChar r3 = new SpecialChar("W", 2);
        W = r3;
        SpecialChar r5 = new SpecialChar("HASH", 3);
        HASH = r5;
        SpecialChar r7 = new SpecialChar("QUESTION_MARK", 4);
        QUESTION_MARK = r7;
        SpecialChar r9 = new SpecialChar("NONE", 5);
        NONE = r9;
        a = new SpecialChar[]{r0, r1, r3, r5, r7, r9};
    }

    public static SpecialChar[] values() {
        return (SpecialChar[]) a.clone();
    }

    public static SpecialChar valueOf(String r1) {
        return (SpecialChar) a.a(SpecialChar.class, r1);
    }

    public SpecialChar(String r1, int r2) {
        super(r1, r2);
    }
}
