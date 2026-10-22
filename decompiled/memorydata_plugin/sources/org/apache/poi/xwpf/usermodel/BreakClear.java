package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final enum BreakClear extends Enum<BreakClear> {
    private static final /* synthetic */ BreakClear[] $VALUES = null;
    public static final BreakClear ALL = null;
    public static final BreakClear LEFT = null;
    public static final BreakClear NONE = null;
    public static final BreakClear RIGHT = null;
    private static final Map<Integer, BreakClear> imap = null;
    private final int value;

    static {
        int r2 = 0;
        BreakClear r0 = new BreakClear("NONE", 0, 1);
        NONE = r0;
        BreakClear r1 = new BreakClear("LEFT", 1, 2);
        LEFT = r1;
        BreakClear r4 = new BreakClear("RIGHT", 2, 3);
        RIGHT = r4;
        BreakClear r6 = new BreakClear("ALL", 3, 4);
        ALL = r6;
        $VALUES = new BreakClear[]{r0, r1, r4, r6};
        imap = new HashMap();
        BreakClear[] r3 = values();
        int r5 = r3.length;
    L3:
        if (r2 >= r5) goto L5;
        BreakClear r7 = r3[r2];
        imap.put(Integer.valueOf(r7.getValue()), r7);
        r2 = r2 + 1;
        goto L3
    }

    private BreakClear(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static BreakClear valueOf(int r3) {
        BreakClear r0 = (BreakClear) ZeusTransformUtils.preCheckCast(imap.get(Integer.valueOf(r3)), BreakClear.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Unknown break clear type: " + r3);
    }

    public static BreakClear valueOf(String r2) {
        return (BreakClear) ZeusTransformUtils.preCheckCast(Enum.valueOf(BreakClear.class, r2), BreakClear.class, "com.obric.memorydata.plugin");
    }

    public static BreakClear[] values() {
        return (BreakClear[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BreakClear[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
