package com.lynx.tasm;

/* JADX INFO: loaded from: classes2.dex */
public final enum LynxBooleanOption extends Enum<LynxBooleanOption> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxBooleanOption f9962a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LynxBooleanOption f9963b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LynxBooleanOption f9964c = null;
    public static final /* synthetic */ LynxBooleanOption[] d = null;

    static {
        LynxBooleanOption r5 = new LynxBooleanOption("UNSET", 0);
        f9962a = r5;
        LynxBooleanOption r10 = new LynxBooleanOption("TRUE", 1);
        f9963b = r10;
        LynxBooleanOption r11 = new LynxBooleanOption("FALSE", 2);
        f9964c = r11;
        d = new LynxBooleanOption[]{r5, r10, r11};
    }

    public LynxBooleanOption(String r5, int r10) {
        super(r5, r10);
    }

    public static LynxBooleanOption valueOf(String r5) {
        return (LynxBooleanOption) Enum.valueOf(LynxBooleanOption.class, r5);
    }

    public static LynxBooleanOption[] values() {
        return (LynxBooleanOption[]) d.clone();
    }
}
