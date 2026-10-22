package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final enum PageMargin extends Enum<PageMargin> {
    private static final /* synthetic */ PageMargin[] $VALUES = null;
    public static final PageMargin BOTTOM = null;
    public static final PageMargin FOOTER = null;
    public static final PageMargin HEADER = null;
    public static final PageMargin LEFT = null;
    private static final Map<Short, PageMargin> PAGE_MARGIN_BY_LEGACY_API_VALUE = null;
    public static final PageMargin RIGHT = null;
    public static final PageMargin TOP = null;
    private final short legacyApiValue;

    static {
        int r2 = 0;
        PageMargin r0 = new PageMargin("LEFT", 0, 0);
        LEFT = r0;
        PageMargin r1 = new PageMargin("RIGHT", 1, 1);
        RIGHT = r1;
        PageMargin r3 = new PageMargin("TOP", 2, 2);
        TOP = r3;
        PageMargin r5 = new PageMargin("BOTTOM", 3, 3);
        BOTTOM = r5;
        PageMargin r7 = new PageMargin("HEADER", 4, 4);
        HEADER = r7;
        PageMargin r9 = new PageMargin("FOOTER", 5, 5);
        FOOTER = r9;
        $VALUES = new PageMargin[]{r0, r1, r3, r5, r7, r9};
        PAGE_MARGIN_BY_LEGACY_API_VALUE = new HashMap();
        PageMargin[] r4 = values();
        int r6 = r4.length;
    L3:
        if (r2 >= r6) goto L5;
        PageMargin r8 = r4[r2];
        PAGE_MARGIN_BY_LEGACY_API_VALUE.put(Short.valueOf(r8.legacyApiValue), r8);
        r2 = r2 + 1;
        goto L3
    }

    private PageMargin(String r1, int r2, short r3) {
        super(r1, r2);
        this.legacyApiValue = r3;
    }

    public static PageMargin getByShortValue(short r2) {
        return (PageMargin) ZeusTransformUtils.preCheckCast(PAGE_MARGIN_BY_LEGACY_API_VALUE.get(Short.valueOf(r2)), PageMargin.class, "com.obric.memorydata.plugin");
    }

    public static PageMargin valueOf(String r2) {
        return (PageMargin) ZeusTransformUtils.preCheckCast(Enum.valueOf(PageMargin.class, r2), PageMargin.class, "com.obric.memorydata.plugin");
    }

    public static PageMargin[] values() {
        return (PageMargin[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PageMargin[].class, "com.obric.memorydata.plugin");
    }

    public short getLegacyApiValue() {
        return this.legacyApiValue;
    }
}
