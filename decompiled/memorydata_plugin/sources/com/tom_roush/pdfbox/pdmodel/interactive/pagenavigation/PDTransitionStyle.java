package com.tom_roush.pdfbox.pdmodel.interactive.pagenavigation;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum PDTransitionStyle extends Enum<PDTransitionStyle> {
    private static final /* synthetic */ PDTransitionStyle[] $VALUES = null;
    public static final PDTransitionStyle Blinds = null;
    public static final PDTransitionStyle Box = null;
    public static final PDTransitionStyle Cover = null;
    public static final PDTransitionStyle Dissolve = null;
    public static final PDTransitionStyle Fade = null;
    public static final PDTransitionStyle Fly = null;
    public static final PDTransitionStyle Glitter = null;
    public static final PDTransitionStyle Push = null;
    public static final PDTransitionStyle R = null;
    public static final PDTransitionStyle Split = null;
    public static final PDTransitionStyle Uncover = null;
    public static final PDTransitionStyle Wipe = null;

    static {
        PDTransitionStyle r0 = new PDTransitionStyle("Split", 0);
        Split = r0;
        PDTransitionStyle r1 = new PDTransitionStyle("Blinds", 1);
        Blinds = r1;
        PDTransitionStyle r3 = new PDTransitionStyle("Box", 2);
        Box = r3;
        PDTransitionStyle r5 = new PDTransitionStyle("Wipe", 3);
        Wipe = r5;
        PDTransitionStyle r7 = new PDTransitionStyle("Dissolve", 4);
        Dissolve = r7;
        PDTransitionStyle r9 = new PDTransitionStyle("Glitter", 5);
        Glitter = r9;
        PDTransitionStyle r11 = new PDTransitionStyle("R", 6);
        R = r11;
        PDTransitionStyle r13 = new PDTransitionStyle("Fly", 7);
        Fly = r13;
        PDTransitionStyle r15 = new PDTransitionStyle("Push", 8);
        Push = r15;
        PDTransitionStyle r14 = new PDTransitionStyle("Cover", 9);
        Cover = r14;
        PDTransitionStyle r12 = new PDTransitionStyle("Uncover", 10);
        Uncover = r12;
        PDTransitionStyle r10 = new PDTransitionStyle("Fade", 11);
        Fade = r10;
        $VALUES = new PDTransitionStyle[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
    }

    private PDTransitionStyle(String r1, int r2) {
        super(r1, r2);
    }

    public static PDTransitionStyle valueOf(String r2) {
        return (PDTransitionStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(PDTransitionStyle.class, r2), PDTransitionStyle.class, "com.obric.memorydata.plugin");
    }

    public static PDTransitionStyle[] values() {
        return (PDTransitionStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PDTransitionStyle[].class, "com.obric.memorydata.plugin");
    }
}
