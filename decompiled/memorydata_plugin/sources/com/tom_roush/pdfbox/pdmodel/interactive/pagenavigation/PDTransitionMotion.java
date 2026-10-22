package com.tom_roush.pdfbox.pdmodel.interactive.pagenavigation;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum PDTransitionMotion extends Enum<PDTransitionMotion> {
    private static final /* synthetic */ PDTransitionMotion[] $VALUES = null;
    public static final PDTransitionMotion I = null;
    public static final PDTransitionMotion O = null;

    static {
        PDTransitionMotion r0 = new PDTransitionMotion("I", 0);
        I = r0;
        PDTransitionMotion r1 = new PDTransitionMotion("O", 1);
        O = r1;
        $VALUES = new PDTransitionMotion[]{r0, r1};
    }

    private PDTransitionMotion(String r1, int r2) {
        super(r1, r2);
    }

    public static PDTransitionMotion valueOf(String r2) {
        return (PDTransitionMotion) ZeusTransformUtils.preCheckCast(Enum.valueOf(PDTransitionMotion.class, r2), PDTransitionMotion.class, "com.obric.memorydata.plugin");
    }

    public static PDTransitionMotion[] values() {
        return (PDTransitionMotion[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PDTransitionMotion[].class, "com.obric.memorydata.plugin");
    }
}
