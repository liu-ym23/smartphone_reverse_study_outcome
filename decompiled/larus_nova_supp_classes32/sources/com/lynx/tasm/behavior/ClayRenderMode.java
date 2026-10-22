package com.lynx.tasm.behavior;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum ClayRenderMode extends Enum<ClayRenderMode> {
    public static final ClayRenderMode DELEGATE = null;
    public static final ClayRenderMode SURFACE = null;
    public static final ClayRenderMode SYNC = null;
    public static final ClayRenderMode TEXTURE = null;
    public static final /* synthetic */ ClayRenderMode[] a = null;

    static {
        ClayRenderMode r0 = new ClayRenderMode("SURFACE", 0);
        SURFACE = r0;
        ClayRenderMode r1 = new ClayRenderMode("TEXTURE", 1);
        TEXTURE = r1;
        ClayRenderMode r3 = new ClayRenderMode("SYNC", 2);
        SYNC = r3;
        ClayRenderMode r5 = new ClayRenderMode("DELEGATE", 3);
        DELEGATE = r5;
        a = new ClayRenderMode[]{r0, r1, r3, r5};
    }

    public static ClayRenderMode[] values() {
        return (ClayRenderMode[]) a.clone();
    }

    public static ClayRenderMode valueOf(String r1) {
        return (ClayRenderMode) r27.a.a(ClayRenderMode.class, r1);
    }

    public ClayRenderMode(String r1, int r2) {
        super(r1, r2);
    }
}
