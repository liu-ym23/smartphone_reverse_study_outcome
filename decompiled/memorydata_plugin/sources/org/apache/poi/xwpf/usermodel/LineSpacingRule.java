package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final enum LineSpacingRule extends Enum<LineSpacingRule> {
    private static final /* synthetic */ LineSpacingRule[] $VALUES = null;
    public static final LineSpacingRule AT_LEAST = null;
    public static final LineSpacingRule AUTO = null;
    public static final LineSpacingRule EXACT = null;
    private static Map<Integer, LineSpacingRule> imap;
    private final int value;

    static {
        int r2 = 0;
        LineSpacingRule r0 = new LineSpacingRule("AUTO", 0, 1);
        AUTO = r0;
        LineSpacingRule r1 = new LineSpacingRule("EXACT", 1, 2);
        EXACT = r1;
        LineSpacingRule r4 = new LineSpacingRule("AT_LEAST", 2, 3);
        AT_LEAST = r4;
        $VALUES = new LineSpacingRule[]{r0, r1, r4};
        imap = new HashMap();
        LineSpacingRule[] r3 = values();
        int r5 = r3.length;
    L3:
        if (r2 >= r5) goto L5;
        LineSpacingRule r6 = r3[r2];
        imap.put(Integer.valueOf(r6.getValue()), r6);
        r2 = r2 + 1;
        goto L3
    }

    private LineSpacingRule(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static LineSpacingRule valueOf(int r3) {
        LineSpacingRule r0 = (LineSpacingRule) ZeusTransformUtils.preCheckCast(imap.get(Integer.valueOf(r3)), LineSpacingRule.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Unknown line type: " + r3);
    }

    public static LineSpacingRule valueOf(String r2) {
        return (LineSpacingRule) ZeusTransformUtils.preCheckCast(Enum.valueOf(LineSpacingRule.class, r2), LineSpacingRule.class, "com.obric.memorydata.plugin");
    }

    public static LineSpacingRule[] values() {
        return (LineSpacingRule[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LineSpacingRule[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
