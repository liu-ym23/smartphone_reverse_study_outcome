package com.tom_roush.pdfbox.pdmodel.interactive.pagenavigation;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.tom_roush.pdfbox.a.b;
import com.tom_roush.pdfbox.a.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public enum PDTransitionDirection extends Enum<PDTransitionDirection> {
    private static final /* synthetic */ PDTransitionDirection[] $VALUES = null;
    public static final PDTransitionDirection BOTTOM_TO_TOP = null;
    public static final PDTransitionDirection LEFT_TO_RIGHT = null;
    public static final PDTransitionDirection NONE = null;
    public static final PDTransitionDirection RIGHT_TO_LEFT = null;
    public static final PDTransitionDirection TOP_LEFT_TO_BOTTOM_RIGHT = null;
    public static final PDTransitionDirection TOP_TO_BOTTOM = null;
    private final int degrees;

    static {
        final int r2 = 0;
        PDTransitionDirection r0 = new PDTransitionDirection("LEFT_TO_RIGHT", 0, 0);
        LEFT_TO_RIGHT = r0;
        PDTransitionDirection r1 = new PDTransitionDirection("BOTTOM_TO_TOP", 1, 90);
        BOTTOM_TO_TOP = r1;
        PDTransitionDirection r3 = new PDTransitionDirection("RIGHT_TO_LEFT", 2, SubsamplingScaleImageView.ORIENTATION_180);
        RIGHT_TO_LEFT = r3;
        PDTransitionDirection r5 = new PDTransitionDirection("TOP_TO_BOTTOM", 3, SubsamplingScaleImageView.ORIENTATION_270);
        TOP_TO_BOTTOM = r5;
        PDTransitionDirection r7 = new PDTransitionDirection("TOP_LEFT_TO_BOTTOM_RIGHT", 4, 315);
        TOP_LEFT_TO_BOTTOM_RIGHT = r7;
        final String r11 = "NONE";
        final int r12 = 5;
        PDTransitionDirection r9 = new AnonymousClass1(r11, r12, r2);
        NONE = r9;
        $VALUES = new PDTransitionDirection[]{r0, r1, r3, r5, r7, r9};
    }

    private PDTransitionDirection(String r1, int r2, int r3) {
        super(r1, r2);
        this.degrees = r3;
    }

    /* synthetic */ PDTransitionDirection(String r1, int r2, int r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    public static PDTransitionDirection valueOf(String r2) {
        return (PDTransitionDirection) ZeusTransformUtils.preCheckCast(Enum.valueOf(PDTransitionDirection.class, r2), PDTransitionDirection.class, "com.obric.memorydata.plugin");
    }

    public static PDTransitionDirection[] values() {
        return (PDTransitionDirection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PDTransitionDirection[].class, "com.obric.memorydata.plugin");
    }

    public b getCOSBase() {
        return h.a(this.degrees);
    }
}
