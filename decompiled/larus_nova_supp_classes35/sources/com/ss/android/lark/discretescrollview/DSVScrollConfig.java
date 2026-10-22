package com.ss.android.lark.discretescrollview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract enum DSVScrollConfig extends Enum<DSVScrollConfig> {
    public static final DSVScrollConfig BACKWARD_ONLY = null;
    public static final DSVScrollConfig DISABLED = null;
    public static final DSVScrollConfig ENABLED = null;
    public static final DSVScrollConfig FORWARD_ONLY = null;
    public static final /* synthetic */ DSVScrollConfig[] a = null;

    public DSVScrollConfig() {
        throw null;
    }

    public abstract boolean isScrollBlocked(Direction r1);

    static {
        final String r1 = "ENABLED";
        final int r2 = 0;
        DSVScrollConfig r0 = new AnonymousClass1(r1, r2);
        ENABLED = r0;
        final String r3 = "FORWARD_ONLY";
        final int r4 = 1;
        DSVScrollConfig r5 = new AnonymousClass2(r3, r4);
        FORWARD_ONLY = r5;
        final String r6 = "BACKWARD_ONLY";
        final int r7 = 2;
        DSVScrollConfig r8 = new AnonymousClass3(r6, r7);
        BACKWARD_ONLY = r8;
        final String r9 = "DISABLED";
        final int r10 = 3;
        DSVScrollConfig r11 = new AnonymousClass4(r9, r10);
        DISABLED = r11;
        a = new DSVScrollConfig[]{r0, r5, r8, r11};
    }

    public static DSVScrollConfig[] values() {
        return (DSVScrollConfig[]) a.clone();
    }

    public static DSVScrollConfig valueOf(String r1) {
        return (DSVScrollConfig) r27.a.a(DSVScrollConfig.class, r1);
    }

    public DSVScrollConfig(String r1, int r2, AnonymousClass1 r3) {
        super(r1, r2);
    }
}
