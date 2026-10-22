package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum PrintCellComments extends Enum<PrintCellComments> {
    private static final /* synthetic */ PrintCellComments[] $VALUES = null;
    public static final PrintCellComments AS_DISPLAYED = null;
    public static final PrintCellComments AT_END = null;
    public static final PrintCellComments NONE = null;
    private static PrintCellComments[] _table;
    private int comments;

    static {
        int r2 = 0;
        PrintCellComments r0 = new PrintCellComments("NONE", 0, 1);
        NONE = r0;
        PrintCellComments r1 = new PrintCellComments("AS_DISPLAYED", 1, 2);
        AS_DISPLAYED = r1;
        PrintCellComments r4 = new PrintCellComments("AT_END", 2, 3);
        AT_END = r4;
        $VALUES = new PrintCellComments[]{r0, r1, r4};
        _table = new PrintCellComments[4];
        PrintCellComments[] r3 = values();
        int r5 = r3.length;
    L3:
        if (r2 >= r5) goto L5;
        PrintCellComments r6 = r3[r2];
        _table[r6.getValue()] = r6;
        r2 = r2 + 1;
        goto L3
    }

    private PrintCellComments(String r1, int r2, int r3) {
        super(r1, r2);
        this.comments = r3;
    }

    public static PrintCellComments valueOf(int r1) {
        return _table[r1];
    }

    public static PrintCellComments valueOf(String r2) {
        return (PrintCellComments) ZeusTransformUtils.preCheckCast(Enum.valueOf(PrintCellComments.class, r2), PrintCellComments.class, "com.obric.memorydata.plugin");
    }

    public static PrintCellComments[] values() {
        return (PrintCellComments[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PrintCellComments[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.comments;
    }
}
