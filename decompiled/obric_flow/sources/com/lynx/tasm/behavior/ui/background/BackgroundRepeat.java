package com.lynx.tasm.behavior.ui.background;

/* JADX INFO: loaded from: classes2.dex */
public final enum BackgroundRepeat extends Enum<BackgroundRepeat> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BackgroundRepeat f10424a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BackgroundRepeat f10425b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BackgroundRepeat f10426c = null;
    public static final BackgroundRepeat d = null;
    public static final BackgroundRepeat e = null;
    public static final BackgroundRepeat f = null;
    public static final /* synthetic */ BackgroundRepeat[] g = null;

    static {
        BackgroundRepeat r5 = new BackgroundRepeat("REPEAT", 0);
        f10424a = r5;
        BackgroundRepeat r10 = new BackgroundRepeat("NO_REPEAT", 1);
        f10425b = r10;
        BackgroundRepeat r11 = new BackgroundRepeat("REPEAT_X", 2);
        f10426c = r11;
        BackgroundRepeat r12 = new BackgroundRepeat("REPEAT_Y", 3);
        d = r12;
        BackgroundRepeat r13 = new BackgroundRepeat("ROUND", 4);
        e = r13;
        BackgroundRepeat r14 = new BackgroundRepeat("SPACE", 5);
        f = r14;
        g = new BackgroundRepeat[]{r5, r10, r11, r12, r13, r14};
    }

    public BackgroundRepeat(String r5, int r10) {
        super(r5, r10);
    }

    public static BackgroundRepeat valueOf(String r5) {
        return (BackgroundRepeat) Enum.valueOf(BackgroundRepeat.class, r5);
    }

    public static BackgroundRepeat[] values() {
        return (BackgroundRepeat[]) g.clone();
    }
}
