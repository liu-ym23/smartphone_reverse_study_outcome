package com.lynx.tasm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum LynxLoadMode extends Enum<LynxLoadMode> {
    public static final LynxLoadMode HYDRATE_SSR = null;
    public static final LynxLoadMode NORMAL = null;
    public static final LynxLoadMode PRE_PAINTING = null;
    public static final LynxLoadMode PRE_PAINTING_DRAW = null;
    public static final LynxLoadMode RENDER_SSR = null;
    public static final /* synthetic */ LynxLoadMode[] a = null;
    private int mId;

    static {
        LynxLoadMode r0 = new LynxLoadMode("NORMAL", 0, 0);
        NORMAL = r0;
        LynxLoadMode r1 = new LynxLoadMode("PRE_PAINTING", 1, 1);
        PRE_PAINTING = r1;
        LynxLoadMode r3 = new LynxLoadMode("PRE_PAINTING_DRAW", 2, 2);
        PRE_PAINTING_DRAW = r3;
        LynxLoadMode r5 = new LynxLoadMode("RENDER_SSR", 3, 3);
        RENDER_SSR = r5;
        LynxLoadMode r7 = new LynxLoadMode("HYDRATE_SSR", 4, 4);
        HYDRATE_SSR = r7;
        a = new LynxLoadMode[]{r0, r1, r3, r5, r7};
    }

    public static LynxLoadMode[] values() {
        return (LynxLoadMode[]) a.clone();
    }

    public int id() {
        return this.mId;
    }

    public static LynxLoadMode valueOf(String r1) {
        return (LynxLoadMode) r27.a.a(LynxLoadMode.class, r1);
    }

    public LynxLoadMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.mId = r3;
    }
}
