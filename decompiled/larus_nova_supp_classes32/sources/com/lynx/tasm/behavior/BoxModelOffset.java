package com.lynx.tasm.behavior;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
final enum BoxModelOffset extends Enum<BoxModelOffset> {
    public static final BoxModelOffset BORDER_BOTTOM = null;
    public static final BoxModelOffset BORDER_LEFT = null;
    public static final BoxModelOffset BORDER_RIGHT = null;
    public static final BoxModelOffset BORDER_TOP = null;
    public static final BoxModelOffset LAYOUT_BOTTOM = null;
    public static final BoxModelOffset LAYOUT_LEFT = null;
    public static final BoxModelOffset LAYOUT_RIGHT = null;
    public static final BoxModelOffset LAYOUT_TOP = null;
    public static final BoxModelOffset MARGIN_BOTTOM = null;
    public static final BoxModelOffset MARGIN_LEFT = null;
    public static final BoxModelOffset MARGIN_RIGHT = null;
    public static final BoxModelOffset MARGIN_TOP = null;
    public static final BoxModelOffset PAD_BOTTOM = null;
    public static final BoxModelOffset PAD_LEFT = null;
    public static final BoxModelOffset PAD_RIGHT = null;
    public static final BoxModelOffset PAD_TOP = null;
    public static final /* synthetic */ BoxModelOffset[] a = null;

    static {
        BoxModelOffset r0 = new BoxModelOffset("PAD_LEFT", 0);
        PAD_LEFT = r0;
        BoxModelOffset r1 = new BoxModelOffset("PAD_TOP", 1);
        PAD_TOP = r1;
        BoxModelOffset r3 = new BoxModelOffset("PAD_RIGHT", 2);
        PAD_RIGHT = r3;
        BoxModelOffset r5 = new BoxModelOffset("PAD_BOTTOM", 3);
        PAD_BOTTOM = r5;
        BoxModelOffset r7 = new BoxModelOffset("BORDER_LEFT", 4);
        BORDER_LEFT = r7;
        BoxModelOffset r9 = new BoxModelOffset("BORDER_TOP", 5);
        BORDER_TOP = r9;
        BoxModelOffset r11 = new BoxModelOffset("BORDER_RIGHT", 6);
        BORDER_RIGHT = r11;
        BoxModelOffset r13 = new BoxModelOffset("BORDER_BOTTOM", 7);
        BORDER_BOTTOM = r13;
        BoxModelOffset r15 = new BoxModelOffset("MARGIN_LEFT", 8);
        MARGIN_LEFT = r15;
        BoxModelOffset r14 = new BoxModelOffset("MARGIN_TOP", 9);
        MARGIN_TOP = r14;
        BoxModelOffset r12 = new BoxModelOffset("MARGIN_RIGHT", 10);
        MARGIN_RIGHT = r12;
        BoxModelOffset r10 = new BoxModelOffset("MARGIN_BOTTOM", 11);
        MARGIN_BOTTOM = r10;
        BoxModelOffset r8 = new BoxModelOffset("LAYOUT_LEFT", 12);
        LAYOUT_LEFT = r8;
        BoxModelOffset r6 = new BoxModelOffset("LAYOUT_TOP", 13);
        LAYOUT_TOP = r6;
        BoxModelOffset r4 = new BoxModelOffset("LAYOUT_RIGHT", 14);
        LAYOUT_RIGHT = r4;
        BoxModelOffset r2 = new BoxModelOffset("LAYOUT_BOTTOM", 15);
        LAYOUT_BOTTOM = r2;
        a = new BoxModelOffset[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
    }

    public static BoxModelOffset[] values() {
        return (BoxModelOffset[]) a.clone();
    }

    public static BoxModelOffset valueOf(String r1) {
        return (BoxModelOffset) r27.a.a(BoxModelOffset.class, r1);
    }

    public BoxModelOffset(String r1, int r2) {
        super(r1, r2);
    }
}
