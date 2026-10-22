package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final enum BreakType extends Enum<BreakType> {
    private static final /* synthetic */ BreakType[] $VALUES = null;
    public static final BreakType COLUMN = null;
    public static final BreakType PAGE = null;
    public static final BreakType TEXT_WRAPPING = null;
    private static Map<Integer, BreakType> imap;
    private final int value;

    static {
        int r2 = 0;
        BreakType r0 = new BreakType("PAGE", 0, 1);
        PAGE = r0;
        BreakType r1 = new BreakType("COLUMN", 1, 2);
        COLUMN = r1;
        BreakType r4 = new BreakType("TEXT_WRAPPING", 2, 3);
        TEXT_WRAPPING = r4;
        $VALUES = new BreakType[]{r0, r1, r4};
        imap = new HashMap();
        BreakType[] r3 = values();
        int r5 = r3.length;
    L3:
        if (r2 >= r5) goto L5;
        BreakType r6 = r3[r2];
        imap.put(Integer.valueOf(r6.getValue()), r6);
        r2 = r2 + 1;
        goto L3
    }

    private BreakType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static BreakType valueOf(int r3) {
        BreakType r0 = (BreakType) ZeusTransformUtils.preCheckCast(imap.get(Integer.valueOf(r3)), BreakType.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Unknown break type: " + r3);
    }

    public static BreakType valueOf(String r2) {
        return (BreakType) ZeusTransformUtils.preCheckCast(Enum.valueOf(BreakType.class, r2), BreakType.class, "com.obric.memorydata.plugin");
    }

    public static BreakType[] values() {
        return (BreakType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BreakType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
