package org.apache.poi.common.usermodel.fonts;

import com.bytedance.crash.constants.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes4.dex */
public final enum FontGroup extends Enum<FontGroup> {
    private static final /* synthetic */ FontGroup[] $VALUES = null;
    public static final FontGroup COMPLEX_SCRIPT = null;
    public static final FontGroup EAST_ASIAN = null;
    public static final FontGroup LATIN = null;
    public static final FontGroup SYMBOL = null;
    private static NavigableMap<Integer, Range> UCS_RANGES;

    public static class FontGroupRange {
        private final FontGroup fontGroup;
        private int len;

        FontGroupRange(FontGroup r2) {
            this.len = 0;
            this.fontGroup = r2;
        }

        static /* synthetic */ FontGroup access$000(FontGroupRange r0) {
            return r0.fontGroup;
        }

        void increaseLength(int r2) {
            this.len += r2;
        }
    }

    private static class Range {
        private final FontGroup fontGroup;
        private final int upper;

        Range(int r1, FontGroup r2) {
            this.upper = r1;
            this.fontGroup = r2;
        }

        FontGroup getFontGroup() {
            return this.fontGroup;
        }

        int getUpper() {
            return this.upper;
        }
    }

    static {
        FontGroup r0 = new FontGroup("LATIN", 0);
        LATIN = r0;
        FontGroup r1 = new FontGroup("EAST_ASIAN", 1);
        EAST_ASIAN = r1;
        FontGroup r3 = new FontGroup("SYMBOL", 2);
        SYMBOL = r3;
        FontGroup r5 = new FontGroup("COMPLEX_SCRIPT", 3);
        COMPLEX_SCRIPT = r5;
        $VALUES = new FontGroup[]{r0, r1, r3, r5};
        TreeMap r4 = new TreeMap();
        UCS_RANGES = r4;
        r4.put(0, new Range(127, r0));
        UCS_RANGES.put(128, new Range(166, r0));
        UCS_RANGES.put(169, new Range(175, r0));
        UCS_RANGES.put(178, new Range(179, r0));
        UCS_RANGES.put(181, new Range(Constants.UPLOAD_DISASTER_ESCAPE, r0));
        UCS_RANGES.put(216, new Range(246, r0));
        UCS_RANGES.put(248, new Range(1423, r0));
        UCS_RANGES.put(1424, new Range(1871, r5));
        UCS_RANGES.put(1920, new Range(1983, r5));
        UCS_RANGES.put(2304, new Range(4255, r5));
        UCS_RANGES.put(4256, new Range(4351, r0));
        UCS_RANGES.put(4608, new Range(4991, r0));
        UCS_RANGES.put(5024, new Range(6015, r0));
        UCS_RANGES.put(7424, new Range(7551, r0));
        UCS_RANGES.put(7680, new Range(8191, r0));
        UCS_RANGES.put(6016, new Range(6319, r5));
        UCS_RANGES.put(8192, new Range(8203, r0));
        UCS_RANGES.put(8204, new Range(8207, r5));
        UCS_RANGES.put(8208, new Range(8233, r0));
        UCS_RANGES.put(8234, new Range(8239, r5));
        UCS_RANGES.put(8240, new Range(8262, r0));
        UCS_RANGES.put(8266, new Range(9311, r0));
        UCS_RANGES.put(9840, new Range(9841, r5));
        UCS_RANGES.put(10176, new Range(11263, r0));
        UCS_RANGES.put(12441, new Range(12442, r1));
        UCS_RANGES.put(55349, new Range(55349, r0));
        UCS_RANGES.put(61440, new Range(61695, r3));
        UCS_RANGES.put(64256, new Range(64279, r0));
        UCS_RANGES.put(64285, new Range(64335, r5));
        UCS_RANGES.put(65104, new Range(65135, r0));
    }

    private FontGroup(String r1, int r2) {
        super(r1, r2);
    }

    public static FontGroup getFontGroupFirst(String r1) {
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        return lookup(r1.codePointAt(0));
    L8:
        return LATIN;
    }

    public static List<FontGroupRange> getFontGroupRanges(String r8) {
        ArrayList r0 = new ArrayList();
        if (r8 != null) goto L5;
    L20:
        return r0;
    L5:
        if (r8.isEmpty() == true) goto L20;
        FontGroupRange r1 = null;
        int r2 = r8.length();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L20;
        int r4 = r8.codePointAt(r3);
        int r5 = Character.charCount(r4);
        if (r1 != null) goto L12;
    L14:
        FontGroup r6 = lookup(r4);
    L15:
        if (r1 != null) goto L17;
    L18:
        r1 = new FontGroupRange(r6);
        r0.add(r1);
    L19:
        r1.increaseLength(r5);
        r3 = r3 + r5;
        goto L8
    L17:
        if (FontGroupRange.access$000(r1) == r6) goto L19;
    L12:
        if (" \n\r".indexOf(r4) <= (-1)) goto L14;
        r6 = FontGroupRange.access$000(r1);
        goto L15
    }

    private static FontGroup lookup(int r3) {
        Map.Entry<Integer, Range> r0 = UCS_RANGES.floorEntry(Integer.valueOf(r3));
        if (r0 == null) goto L5;
        Range r1 = (Range) ZeusTransformUtils.preCheckCast(r0.getValue(), Range.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L11;
        if (r3 > r1.getUpper()) goto L11;
        return r1.getFontGroup();
    L11:
        return EAST_ASIAN;
    L5:
        r1 = null;
        goto L6
    }

    public static FontGroup valueOf(String r2) {
        return (FontGroup) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontGroup.class, r2), FontGroup.class, "com.obric.memorydata.plugin");
    }

    public static FontGroup[] values() {
        return (FontGroup[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontGroup[].class, "com.obric.memorydata.plugin");
    }
}
