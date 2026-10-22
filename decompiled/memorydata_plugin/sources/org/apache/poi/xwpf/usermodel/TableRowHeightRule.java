package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final enum TableRowHeightRule extends Enum<TableRowHeightRule> {
    private static final /* synthetic */ TableRowHeightRule[] $VALUES = null;
    public static final TableRowHeightRule AT_LEAST = null;
    public static final TableRowHeightRule AUTO = null;
    public static final TableRowHeightRule EXACT = null;
    private static Map<Integer, TableRowHeightRule> imap;
    private final int value;

    static {
        int r2 = 0;
        TableRowHeightRule r0 = new TableRowHeightRule("AUTO", 0, 1);
        AUTO = r0;
        TableRowHeightRule r1 = new TableRowHeightRule("EXACT", 1, 2);
        EXACT = r1;
        TableRowHeightRule r4 = new TableRowHeightRule("AT_LEAST", 2, 3);
        AT_LEAST = r4;
        $VALUES = new TableRowHeightRule[]{r0, r1, r4};
        imap = new HashMap();
        TableRowHeightRule[] r3 = values();
        int r5 = r3.length;
    L3:
        if (r2 >= r5) goto L5;
        TableRowHeightRule r6 = r3[r2];
        imap.put(Integer.valueOf(r6.getValue()), r6);
        r2 = r2 + 1;
        goto L3
    }

    private TableRowHeightRule(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static TableRowHeightRule valueOf(int r3) {
        TableRowHeightRule r0 = (TableRowHeightRule) ZeusTransformUtils.preCheckCast(imap.get(Integer.valueOf(r3)), TableRowHeightRule.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Unknown table row height rule: " + r3);
    }

    public static TableRowHeightRule valueOf(String r2) {
        return (TableRowHeightRule) ZeusTransformUtils.preCheckCast(Enum.valueOf(TableRowHeightRule.class, r2), TableRowHeightRule.class, "com.obric.memorydata.plugin");
    }

    public static TableRowHeightRule[] values() {
        return (TableRowHeightRule[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TableRowHeightRule[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
