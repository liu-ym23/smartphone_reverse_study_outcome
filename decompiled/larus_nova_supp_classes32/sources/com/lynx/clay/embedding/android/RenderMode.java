package com.lynx.clay.embedding.android;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum RenderMode extends Enum<RenderMode> {
    public static final /* synthetic */ RenderMode[] a = null;
    public static final RenderMode delegate = null;
    public static final RenderMode image = null;
    public static final RenderMode surface = null;
    public static final RenderMode sync = null;
    public static final RenderMode texture = null;

    static {
        RenderMode r0 = new RenderMode("surface", 0);
        surface = r0;
        RenderMode r1 = new RenderMode("texture", 1);
        texture = r1;
        RenderMode r3 = new RenderMode("image", 2);
        image = r3;
        RenderMode r5 = new RenderMode("sync", 3);
        sync = r5;
        RenderMode r7 = new RenderMode("delegate", 4);
        delegate = r7;
        a = new RenderMode[]{r0, r1, r3, r5, r7};
    }

    public static RenderMode[] values() {
        return (RenderMode[]) a.clone();
    }

    public static RenderMode valueOf(String r1) {
        return (RenderMode) r27.a.a(RenderMode.class, r1);
    }

    public RenderMode(String r1, int r2) {
        super(r1, r2);
    }
}
