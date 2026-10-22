package com.ss.android.lark.preload;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum PreloadTarget extends Enum<PreloadTarget> {
    public static final PreloadTarget DOC = null;
    public static final PreloadTarget MAIL = null;
    public static final PreloadTarget MINI_APP = null;
    public static final /* synthetic */ PreloadTarget[] a = null;
    private int value;

    static {
        PreloadTarget r0 = new PreloadTarget("DOC", 0, 1);
        DOC = r0;
        PreloadTarget r1 = new PreloadTarget("MINI_APP", 1, 2);
        MINI_APP = r1;
        PreloadTarget r4 = new PreloadTarget("MAIL", 2, 3);
        MAIL = r4;
        a = new PreloadTarget[]{r0, r1, r4};
    }

    public static PreloadTarget[] values() {
        return (PreloadTarget[]) a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static PreloadTarget valueOf(String r1) {
        return (PreloadTarget) r27.a.a(PreloadTarget.class, r1);
    }

    public PreloadTarget(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
