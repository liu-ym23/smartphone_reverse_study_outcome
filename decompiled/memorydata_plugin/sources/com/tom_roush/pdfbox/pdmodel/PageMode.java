package com.tom_roush.pdfbox.pdmodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum PageMode extends Enum<PageMode> {
    private static final /* synthetic */ PageMode[] $VALUES = null;
    public static final PageMode FULL_SCREEN = null;
    public static final PageMode USE_ATTACHMENTS = null;
    public static final PageMode USE_NONE = null;
    public static final PageMode USE_OPTIONAL_CONTENT = null;
    public static final PageMode USE_OUTLINES = null;
    public static final PageMode USE_THUMBS = null;
    private final String value;

    static {
        PageMode r0 = new PageMode("USE_NONE", 0, "UseNone");
        USE_NONE = r0;
        PageMode r1 = new PageMode("USE_OUTLINES", 1, "UseOutlines");
        USE_OUTLINES = r1;
        PageMode r3 = new PageMode("USE_THUMBS", 2, "UseThumbs");
        USE_THUMBS = r3;
        PageMode r5 = new PageMode("FULL_SCREEN", 3, "FullScreen");
        FULL_SCREEN = r5;
        PageMode r7 = new PageMode("USE_OPTIONAL_CONTENT", 4, "UseOC");
        USE_OPTIONAL_CONTENT = r7;
        PageMode r9 = new PageMode("USE_ATTACHMENTS", 5, "UseAttachments");
        USE_ATTACHMENTS = r9;
        $VALUES = new PageMode[]{r0, r1, r3, r5, r7, r9};
    }

    private PageMode(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static PageMode fromString(String r5) {
        PageMode[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        PageMode r3 = r0[r2];
        if (r3.value.equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException(r5);
    }

    public static PageMode valueOf(String r2) {
        return (PageMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(PageMode.class, r2), PageMode.class, "com.obric.memorydata.plugin");
    }

    public static PageMode[] values() {
        return (PageMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PageMode[].class, "com.obric.memorydata.plugin");
    }

    public String stringValue() {
        return this.value;
    }
}
