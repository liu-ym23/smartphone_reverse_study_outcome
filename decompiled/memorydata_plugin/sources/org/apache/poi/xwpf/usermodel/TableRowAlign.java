package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final enum TableRowAlign extends Enum<TableRowAlign> {
    private static final /* synthetic */ TableRowAlign[] $VALUES = null;
    public static final TableRowAlign CENTER = null;
    public static final TableRowAlign LEFT = null;
    public static final TableRowAlign RIGHT = null;
    private static Map<Integer, TableRowAlign> imap;
    private final int value;

    static {
        int r2 = 0;
        TableRowAlign r0 = new TableRowAlign("LEFT", 0, 5);
        LEFT = r0;
        TableRowAlign r1 = new TableRowAlign("CENTER", 1, 1);
        CENTER = r1;
        TableRowAlign r3 = new TableRowAlign("RIGHT", 2, 2);
        RIGHT = r3;
        $VALUES = new TableRowAlign[]{r0, r1, r3};
        imap = new HashMap();
        TableRowAlign[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r2 >= r5) goto L5;
        TableRowAlign r6 = r4[r2];
        imap.put(Integer.valueOf(r6.getValue()), r6);
        r2 = r2 + 1;
        goto L3
    }

    private TableRowAlign(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static TableRowAlign valueOf(int r3) {
        TableRowAlign r0 = (TableRowAlign) ZeusTransformUtils.preCheckCast(imap.get(Integer.valueOf(r3)), TableRowAlign.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Unknown table row alignment: " + r3);
    }

    public static TableRowAlign valueOf(String r2) {
        return (TableRowAlign) ZeusTransformUtils.preCheckCast(Enum.valueOf(TableRowAlign.class, r2), TableRowAlign.class, "com.obric.memorydata.plugin");
    }

    public static TableRowAlign[] values() {
        return (TableRowAlign[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TableRowAlign[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
