package com.ss.android.ugc.effectmanager;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum FetchModelType extends Enum<FetchModelType> {
    private static final /* synthetic */ FetchModelType[] $VALUES = null;
    public static final FetchModelType ORIGIN = null;
    public static final FetchModelType ZIP = null;
    private int value;

    static {
        FetchModelType r0 = new FetchModelType("ORIGIN", 0, 0);
        ORIGIN = r0;
        FetchModelType r1 = new FetchModelType("ZIP", 1, 1);
        ZIP = r1;
        $VALUES = new FetchModelType[]{r0, r1};
    }

    public static FetchModelType[] values() {
        return (FetchModelType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static FetchModelType fromValue(int r5) {
        FetchModelType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        FetchModelType r3 = r0[r2];
        if (r3.value == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return ORIGIN;
    }

    public static FetchModelType valueOf(String r1) {
        return (FetchModelType) a.a(FetchModelType.class, r1);
    }

    private FetchModelType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
