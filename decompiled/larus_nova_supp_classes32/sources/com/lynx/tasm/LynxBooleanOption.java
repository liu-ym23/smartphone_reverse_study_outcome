package com.lynx.tasm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum LynxBooleanOption extends Enum<LynxBooleanOption> {
    public static final LynxBooleanOption FALSE = null;
    public static final LynxBooleanOption TRUE = null;
    public static final LynxBooleanOption UNSET = null;
    public static final /* synthetic */ LynxBooleanOption[] a = null;

    static {
        LynxBooleanOption r0 = new LynxBooleanOption("UNSET", 0);
        UNSET = r0;
        LynxBooleanOption r1 = new LynxBooleanOption("TRUE", 1);
        TRUE = r1;
        LynxBooleanOption r3 = new LynxBooleanOption("FALSE", 2);
        FALSE = r3;
        a = new LynxBooleanOption[]{r0, r1, r3};
    }

    public static LynxBooleanOption[] values() {
        return (LynxBooleanOption[]) a.clone();
    }

    public static LynxBooleanOption valueOf(String r1) {
        return (LynxBooleanOption) r27.a.a(LynxBooleanOption.class, r1);
    }

    public LynxBooleanOption(String r1, int r2) {
        super(r1, r2);
    }
}
