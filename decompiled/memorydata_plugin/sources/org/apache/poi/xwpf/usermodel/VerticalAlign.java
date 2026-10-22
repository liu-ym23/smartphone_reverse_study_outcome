package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final enum VerticalAlign extends Enum<VerticalAlign> {
    private static final /* synthetic */ VerticalAlign[] $VALUES = null;
    public static final VerticalAlign BASELINE = null;
    public static final VerticalAlign SUBSCRIPT = null;
    public static final VerticalAlign SUPERSCRIPT = null;
    private static Map<Integer, VerticalAlign> imap;
    private final int value;

    static {
        int r2 = 0;
        VerticalAlign r0 = new VerticalAlign("BASELINE", 0, 1);
        BASELINE = r0;
        VerticalAlign r1 = new VerticalAlign("SUPERSCRIPT", 1, 2);
        SUPERSCRIPT = r1;
        VerticalAlign r4 = new VerticalAlign("SUBSCRIPT", 2, 3);
        SUBSCRIPT = r4;
        $VALUES = new VerticalAlign[]{r0, r1, r4};
        imap = new HashMap();
        VerticalAlign[] r3 = values();
        int r5 = r3.length;
    L3:
        if (r2 >= r5) goto L5;
        VerticalAlign r6 = r3[r2];
        imap.put(Integer.valueOf(r6.getValue()), r6);
        r2 = r2 + 1;
        goto L3
    }

    private VerticalAlign(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static VerticalAlign valueOf(int r3) {
        VerticalAlign r0 = (VerticalAlign) ZeusTransformUtils.preCheckCast(imap.get(Integer.valueOf(r3)), VerticalAlign.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Unknown vertical alignment: " + r3);
    }

    public static VerticalAlign valueOf(String r2) {
        return (VerticalAlign) ZeusTransformUtils.preCheckCast(Enum.valueOf(VerticalAlign.class, r2), VerticalAlign.class, "com.obric.memorydata.plugin");
    }

    public static VerticalAlign[] values() {
        return (VerticalAlign[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), VerticalAlign[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
