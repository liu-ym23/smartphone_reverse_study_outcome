package com.lynx.clay.embedding.engine.plugins.platformview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum LynxUIClayUIBridge$CompositionPreference extends Enum<LynxUIClayUIBridge$CompositionPreference> {
    public static final LynxUIClayUIBridge$CompositionPreference AUTO = null;
    public static final LynxUIClayUIBridge$CompositionPreference HYBRID_COMPOSITION = null;
    public static final LynxUIClayUIBridge$CompositionPreference OFFSCREEN_SURFACE = null;
    public static final LynxUIClayUIBridge$CompositionPreference TEXTURE_LAYER = null;
    public static final /* synthetic */ LynxUIClayUIBridge$CompositionPreference[] a = null;

    static {
        LynxUIClayUIBridge$CompositionPreference r0 = new LynxUIClayUIBridge$CompositionPreference("AUTO", 0);
        AUTO = r0;
        LynxUIClayUIBridge$CompositionPreference r1 = new LynxUIClayUIBridge$CompositionPreference("HYBRID_COMPOSITION", 1);
        HYBRID_COMPOSITION = r1;
        LynxUIClayUIBridge$CompositionPreference r3 = new LynxUIClayUIBridge$CompositionPreference("TEXTURE_LAYER", 2);
        TEXTURE_LAYER = r3;
        LynxUIClayUIBridge$CompositionPreference r5 = new LynxUIClayUIBridge$CompositionPreference("OFFSCREEN_SURFACE", 3);
        OFFSCREEN_SURFACE = r5;
        a = new LynxUIClayUIBridge$CompositionPreference[]{r0, r1, r3, r5};
    }

    public static LynxUIClayUIBridge$CompositionPreference[] values() {
        return (LynxUIClayUIBridge$CompositionPreference[]) a.clone();
    }

    public static LynxUIClayUIBridge$CompositionPreference valueOf(String r1) {
        return (LynxUIClayUIBridge$CompositionPreference) r27.a.a(LynxUIClayUIBridge$CompositionPreference.class, r1);
    }

    public LynxUIClayUIBridge$CompositionPreference(String r1, int r2) {
        super(r1, r2);
    }
}
