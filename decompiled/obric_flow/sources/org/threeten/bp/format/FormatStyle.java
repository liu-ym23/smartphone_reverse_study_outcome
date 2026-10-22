package org.threeten.bp.format;

/* JADX INFO: loaded from: classes3.dex */
public final enum FormatStyle extends Enum<FormatStyle> {
    public static final FormatStyle FULL = null;
    public static final FormatStyle LONG = null;
    public static final FormatStyle MEDIUM = null;
    public static final FormatStyle SHORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FormatStyle[] f21190a = null;

    static {
        FormatStyle r5 = new FormatStyle("FULL", 0);
        FULL = r5;
        FormatStyle r10 = new FormatStyle("LONG", 1);
        LONG = r10;
        FormatStyle r11 = new FormatStyle("MEDIUM", 2);
        MEDIUM = r11;
        FormatStyle r12 = new FormatStyle("SHORT", 3);
        SHORT = r12;
        f21190a = new FormatStyle[]{r5, r10, r11, r12};
    }

    public static FormatStyle valueOf(String r5) {
        return (FormatStyle) Enum.valueOf(FormatStyle.class, r5);
    }

    public static FormatStyle[] values() {
        return (FormatStyle[]) f21190a.clone();
    }
}
