package com.tom_roush.pdfbox.rendering;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum RenderDestination extends Enum<RenderDestination> {
    private static final /* synthetic */ RenderDestination[] $VALUES = null;
    public static final RenderDestination EXPORT = null;
    public static final RenderDestination PRINT = null;
    public static final RenderDestination VIEW = null;

    static {
        RenderDestination r0 = new RenderDestination("EXPORT", 0);
        EXPORT = r0;
        RenderDestination r1 = new RenderDestination("VIEW", 1);
        VIEW = r1;
        RenderDestination r3 = new RenderDestination("PRINT", 2);
        PRINT = r3;
        $VALUES = new RenderDestination[]{r0, r1, r3};
    }

    private RenderDestination(String r1, int r2) {
        super(r1, r2);
    }

    public static RenderDestination valueOf(String r2) {
        return (RenderDestination) ZeusTransformUtils.preCheckCast(Enum.valueOf(RenderDestination.class, r2), RenderDestination.class, "com.obric.memorydata.plugin");
    }

    public static RenderDestination[] values() {
        return (RenderDestination[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RenderDestination[].class, "com.obric.memorydata.plugin");
    }
}
