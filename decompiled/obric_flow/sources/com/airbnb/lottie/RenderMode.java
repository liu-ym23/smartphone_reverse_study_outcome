package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public final enum RenderMode extends Enum<RenderMode> {
    public static final RenderMode AUTOMATIC = null;
    public static final RenderMode HARDWARE = null;
    public static final RenderMode SOFTWARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderMode[] f1246a = null;

    static {
        RenderMode r5 = new RenderMode("AUTOMATIC", 0);
        AUTOMATIC = r5;
        RenderMode r10 = new RenderMode("HARDWARE", 1);
        HARDWARE = r10;
        RenderMode r11 = new RenderMode("SOFTWARE", 2);
        SOFTWARE = r11;
        f1246a = new RenderMode[]{r5, r10, r11};
    }

    public static RenderMode valueOf(String r5) {
        return (RenderMode) Enum.valueOf(RenderMode.class, r5);
    }

    public static RenderMode[] values() {
        return (RenderMode[]) f1246a.clone();
    }
}
