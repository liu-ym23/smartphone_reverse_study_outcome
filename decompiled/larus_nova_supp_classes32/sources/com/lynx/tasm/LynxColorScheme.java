package com.lynx.tasm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum LynxColorScheme extends Enum<LynxColorScheme> {
    public static final LynxColorScheme DARK = null;
    public static final LynxColorScheme LIGHT = null;
    public static final /* synthetic */ LynxColorScheme[] a = null;
    private final int mId;

    static {
        LynxColorScheme r0 = new LynxColorScheme("LIGHT", 0, 0);
        LIGHT = r0;
        LynxColorScheme r1 = new LynxColorScheme("DARK", 1, 1);
        DARK = r1;
        a = new LynxColorScheme[]{r0, r1};
    }

    public static LynxColorScheme[] values() {
        return (LynxColorScheme[]) a.clone();
    }

    public int id() {
        return this.mId;
    }

    public static LynxColorScheme valueOf(String r1) {
        return (LynxColorScheme) r27.a.a(LynxColorScheme.class, r1);
    }

    public LynxColorScheme(String r1, int r2, int r3) {
        super(r1, r2);
        this.mId = r3;
    }
}
