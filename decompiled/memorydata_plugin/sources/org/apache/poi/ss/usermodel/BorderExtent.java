package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum BorderExtent extends Enum<BorderExtent> {
    private static final /* synthetic */ BorderExtent[] $VALUES = null;
    public static final BorderExtent ALL = null;
    public static final BorderExtent BOTTOM = null;
    public static final BorderExtent HORIZONTAL = null;
    public static final BorderExtent INSIDE = null;
    public static final BorderExtent INSIDE_HORIZONTAL = null;
    public static final BorderExtent INSIDE_VERTICAL = null;
    public static final BorderExtent LEFT = null;
    public static final BorderExtent NONE = null;
    public static final BorderExtent OUTSIDE = null;
    public static final BorderExtent OUTSIDE_HORIZONTAL = null;
    public static final BorderExtent OUTSIDE_VERTICAL = null;
    public static final BorderExtent RIGHT = null;
    public static final BorderExtent TOP = null;
    public static final BorderExtent VERTICAL = null;

    static {
        BorderExtent r0 = new BorderExtent("NONE", 0);
        NONE = r0;
        BorderExtent r1 = new BorderExtent("ALL", 1);
        ALL = r1;
        BorderExtent r3 = new BorderExtent("INSIDE", 2);
        INSIDE = r3;
        BorderExtent r5 = new BorderExtent("OUTSIDE", 3);
        OUTSIDE = r5;
        BorderExtent r7 = new BorderExtent("TOP", 4);
        TOP = r7;
        BorderExtent r9 = new BorderExtent("BOTTOM", 5);
        BOTTOM = r9;
        BorderExtent r11 = new BorderExtent("LEFT", 6);
        LEFT = r11;
        BorderExtent r13 = new BorderExtent("RIGHT", 7);
        RIGHT = r13;
        BorderExtent r15 = new BorderExtent("HORIZONTAL", 8);
        HORIZONTAL = r15;
        BorderExtent r14 = new BorderExtent("INSIDE_HORIZONTAL", 9);
        INSIDE_HORIZONTAL = r14;
        BorderExtent r12 = new BorderExtent("OUTSIDE_HORIZONTAL", 10);
        OUTSIDE_HORIZONTAL = r12;
        BorderExtent r10 = new BorderExtent("VERTICAL", 11);
        VERTICAL = r10;
        BorderExtent r8 = new BorderExtent("INSIDE_VERTICAL", 12);
        INSIDE_VERTICAL = r8;
        BorderExtent r6 = new BorderExtent("OUTSIDE_VERTICAL", 13);
        OUTSIDE_VERTICAL = r6;
        $VALUES = new BorderExtent[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
    }

    private BorderExtent(String r1, int r2) {
        super(r1, r2);
    }

    public static BorderExtent valueOf(String r2) {
        return (BorderExtent) ZeusTransformUtils.preCheckCast(Enum.valueOf(BorderExtent.class, r2), BorderExtent.class, "com.obric.memorydata.plugin");
    }

    public static BorderExtent[] values() {
        return (BorderExtent[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BorderExtent[].class, "com.obric.memorydata.plugin");
    }
}
