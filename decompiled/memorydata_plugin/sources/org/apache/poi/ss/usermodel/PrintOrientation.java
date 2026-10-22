package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum PrintOrientation extends Enum<PrintOrientation> {
    private static final /* synthetic */ PrintOrientation[] $VALUES = null;
    public static final PrintOrientation DEFAULT = null;
    public static final PrintOrientation LANDSCAPE = null;
    public static final PrintOrientation PORTRAIT = null;
    private static PrintOrientation[] _table;
    private int orientation;

    static {
        int r2 = 0;
        PrintOrientation r0 = new PrintOrientation("DEFAULT", 0, 1);
        DEFAULT = r0;
        PrintOrientation r1 = new PrintOrientation("PORTRAIT", 1, 2);
        PORTRAIT = r1;
        PrintOrientation r4 = new PrintOrientation("LANDSCAPE", 2, 3);
        LANDSCAPE = r4;
        $VALUES = new PrintOrientation[]{r0, r1, r4};
        _table = new PrintOrientation[4];
        PrintOrientation[] r3 = values();
        int r5 = r3.length;
    L3:
        if (r2 >= r5) goto L5;
        PrintOrientation r6 = r3[r2];
        _table[r6.getValue()] = r6;
        r2 = r2 + 1;
        goto L3
    }

    private PrintOrientation(String r1, int r2, int r3) {
        super(r1, r2);
        this.orientation = r3;
    }

    public static PrintOrientation valueOf(int r1) {
        return _table[r1];
    }

    public static PrintOrientation valueOf(String r2) {
        return (PrintOrientation) ZeusTransformUtils.preCheckCast(Enum.valueOf(PrintOrientation.class, r2), PrintOrientation.class, "com.obric.memorydata.plugin");
    }

    public static PrintOrientation[] values() {
        return (PrintOrientation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PrintOrientation[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.orientation;
    }
}
