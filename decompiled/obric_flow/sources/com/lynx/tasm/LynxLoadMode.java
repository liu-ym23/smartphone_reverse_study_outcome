package com.lynx.tasm;

/* JADX INFO: loaded from: classes2.dex */
public final enum LynxLoadMode extends Enum<LynxLoadMode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxLoadMode f10003a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LynxLoadMode f10004b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LynxLoadMode f10005c = null;
    public static final LynxLoadMode d = null;
    public static final LynxLoadMode e = null;
    public static final /* synthetic */ LynxLoadMode[] f = null;

    static {
        LynxLoadMode r5 = new LynxLoadMode("NORMAL", 0);
        f10003a = r5;
        LynxLoadMode r10 = new LynxLoadMode("PRE_PAINTING", 1);
        f10004b = r10;
        LynxLoadMode r11 = new LynxLoadMode("PRE_PAINTING_DRAW", 2);
        f10005c = r11;
        LynxLoadMode r12 = new LynxLoadMode("RENDER_SSR", 3);
        d = r12;
        LynxLoadMode r13 = new LynxLoadMode("HYDRATE_SSR", 4);
        e = r13;
        f = new LynxLoadMode[]{r5, r10, r11, r12, r13};
    }

    public LynxLoadMode(String r5, int r10) {
        super(r5, r10);
    }

    public static LynxLoadMode valueOf(String r5) {
        return (LynxLoadMode) Enum.valueOf(LynxLoadMode.class, r5);
    }

    public static LynxLoadMode[] values() {
        return (LynxLoadMode[]) f.clone();
    }
}
