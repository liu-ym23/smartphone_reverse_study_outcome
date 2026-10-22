package com.tom_roush.pdfbox.pdmodel.graphics.state;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum RenderingMode extends Enum<RenderingMode> {
    private static final /* synthetic */ RenderingMode[] $VALUES = null;
    public static final RenderingMode FILL = null;
    public static final RenderingMode FILL_CLIP = null;
    public static final RenderingMode FILL_STROKE = null;
    public static final RenderingMode FILL_STROKE_CLIP = null;
    public static final RenderingMode NEITHER = null;
    public static final RenderingMode NEITHER_CLIP = null;
    public static final RenderingMode STROKE = null;
    public static final RenderingMode STROKE_CLIP = null;
    private static final RenderingMode[] VALUES = null;
    private final int value;

    static {
        RenderingMode r0 = new RenderingMode("FILL", 0, 0);
        FILL = r0;
        RenderingMode r1 = new RenderingMode("STROKE", 1, 1);
        STROKE = r1;
        RenderingMode r3 = new RenderingMode("FILL_STROKE", 2, 2);
        FILL_STROKE = r3;
        RenderingMode r5 = new RenderingMode("NEITHER", 3, 3);
        NEITHER = r5;
        RenderingMode r7 = new RenderingMode("FILL_CLIP", 4, 4);
        FILL_CLIP = r7;
        RenderingMode r9 = new RenderingMode("STROKE_CLIP", 5, 5);
        STROKE_CLIP = r9;
        RenderingMode r11 = new RenderingMode("FILL_STROKE_CLIP", 6, 6);
        FILL_STROKE_CLIP = r11;
        RenderingMode r13 = new RenderingMode("NEITHER_CLIP", 7, 7);
        NEITHER_CLIP = r13;
        $VALUES = new RenderingMode[]{r0, r1, r3, r5, r7, r9, r11, r13};
        VALUES = values();
    }

    private RenderingMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static RenderingMode fromInt(int r1) {
        return VALUES[r1];
    }

    public static RenderingMode valueOf(String r2) {
        return (RenderingMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(RenderingMode.class, r2), RenderingMode.class, "com.obric.memorydata.plugin");
    }

    public static RenderingMode[] values() {
        return (RenderingMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RenderingMode[].class, "com.obric.memorydata.plugin");
    }

    public int intValue() {
        return this.value;
    }

    public boolean isClip() {
        if (this != FILL_CLIP) goto L5;
    L12:
        return true;
    L5:
        if (this == STROKE_CLIP) goto L12;
        if (this == FILL_STROKE_CLIP) goto L12;
        if (this == NEITHER_CLIP) goto L12;
        return false;
    }

    public boolean isFill() {
        if (this != FILL) goto L5;
    L12:
        return true;
    L5:
        if (this == FILL_STROKE) goto L12;
        if (this == FILL_CLIP) goto L12;
        if (this == FILL_STROKE_CLIP) goto L12;
        return false;
    }

    public boolean isStroke() {
        if (this != STROKE) goto L5;
    L12:
        return true;
    L5:
        if (this == FILL_STROKE) goto L12;
        if (this == STROKE_CLIP) goto L12;
        if (this == FILL_STROKE_CLIP) goto L12;
        return false;
    }
}
