package com.lynx.tasm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum LynxUIRendererBuilder$LynxUIRenderMode extends Enum<LynxUIRendererBuilder$LynxUIRenderMode> {
    public static final LynxUIRendererBuilder$LynxUIRenderMode Clay = null;
    public static final LynxUIRendererBuilder$LynxUIRenderMode Native = null;
    public static final /* synthetic */ LynxUIRendererBuilder$LynxUIRenderMode[] a = null;

    static {
        LynxUIRendererBuilder$LynxUIRenderMode r0 = new LynxUIRendererBuilder$LynxUIRenderMode("Native", 0);
        Native = r0;
        LynxUIRendererBuilder$LynxUIRenderMode r1 = new LynxUIRendererBuilder$LynxUIRenderMode("Clay", 1);
        Clay = r1;
        a = new LynxUIRendererBuilder$LynxUIRenderMode[]{r0, r1};
    }

    public static LynxUIRendererBuilder$LynxUIRenderMode[] values() {
        return (LynxUIRendererBuilder$LynxUIRenderMode[]) a.clone();
    }

    public static LynxUIRendererBuilder$LynxUIRenderMode valueOf(String r1) {
        return (LynxUIRendererBuilder$LynxUIRenderMode) r27.a.a(LynxUIRendererBuilder$LynxUIRenderMode.class, r1);
    }

    public LynxUIRendererBuilder$LynxUIRenderMode(String r1, int r2) {
        super(r1, r2);
    }
}
