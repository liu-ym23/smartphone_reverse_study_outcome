package com.tom_roush.pdfbox.pdmodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum PageLayout extends Enum<PageLayout> {
    private static final /* synthetic */ PageLayout[] $VALUES = null;
    public static final PageLayout ONE_COLUMN = null;
    public static final PageLayout SINGLE_PAGE = null;
    public static final PageLayout TWO_COLUMN_LEFT = null;
    public static final PageLayout TWO_COLUMN_RIGHT = null;
    public static final PageLayout TWO_PAGE_LEFT = null;
    public static final PageLayout TWO_PAGE_RIGHT = null;
    private final String value;

    static {
        PageLayout r0 = new PageLayout("SINGLE_PAGE", 0, "SinglePage");
        SINGLE_PAGE = r0;
        PageLayout r1 = new PageLayout("ONE_COLUMN", 1, "OneColumn");
        ONE_COLUMN = r1;
        PageLayout r3 = new PageLayout("TWO_COLUMN_LEFT", 2, "TwoColumnLeft");
        TWO_COLUMN_LEFT = r3;
        PageLayout r5 = new PageLayout("TWO_COLUMN_RIGHT", 3, "TwoColumnRight");
        TWO_COLUMN_RIGHT = r5;
        PageLayout r7 = new PageLayout("TWO_PAGE_LEFT", 4, "TwoPageLeft");
        TWO_PAGE_LEFT = r7;
        PageLayout r9 = new PageLayout("TWO_PAGE_RIGHT", 5, "TwoPageRight");
        TWO_PAGE_RIGHT = r9;
        $VALUES = new PageLayout[]{r0, r1, r3, r5, r7, r9};
    }

    private PageLayout(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static PageLayout fromString(String r5) {
        PageLayout[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        PageLayout r3 = r0[r2];
        if (r3.value.equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException(r5);
    }

    public static PageLayout valueOf(String r2) {
        return (PageLayout) ZeusTransformUtils.preCheckCast(Enum.valueOf(PageLayout.class, r2), PageLayout.class, "com.obric.memorydata.plugin");
    }

    public static PageLayout[] values() {
        return (PageLayout[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PageLayout[].class, "com.obric.memorydata.plugin");
    }

    public String stringValue() {
        return this.value;
    }
}
