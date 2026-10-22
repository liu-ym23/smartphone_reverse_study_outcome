package org.threeten.bp.format;

/* JADX INFO: loaded from: classes3.dex */
final enum DateTimeFormatterBuilder$SettingsParser extends Enum<DateTimeFormatterBuilder$SettingsParser> implements g {
    public static final DateTimeFormatterBuilder$SettingsParser INSENSITIVE = null;
    public static final DateTimeFormatterBuilder$SettingsParser LENIENT = null;
    public static final DateTimeFormatterBuilder$SettingsParser SENSITIVE = null;
    public static final DateTimeFormatterBuilder$SettingsParser STRICT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DateTimeFormatterBuilder$SettingsParser[] f21189a = null;

    static {
        DateTimeFormatterBuilder$SettingsParser r5 = new DateTimeFormatterBuilder$SettingsParser("SENSITIVE", 0);
        SENSITIVE = r5;
        DateTimeFormatterBuilder$SettingsParser r10 = new DateTimeFormatterBuilder$SettingsParser("INSENSITIVE", 1);
        INSENSITIVE = r10;
        DateTimeFormatterBuilder$SettingsParser r11 = new DateTimeFormatterBuilder$SettingsParser("STRICT", 2);
        STRICT = r11;
        DateTimeFormatterBuilder$SettingsParser r12 = new DateTimeFormatterBuilder$SettingsParser("LENIENT", 3);
        LENIENT = r12;
        f21189a = new DateTimeFormatterBuilder$SettingsParser[]{r5, r10, r11, r12};
    }

    public static DateTimeFormatterBuilder$SettingsParser valueOf(String r5) {
        return (DateTimeFormatterBuilder$SettingsParser) Enum.valueOf(DateTimeFormatterBuilder$SettingsParser.class, r5);
    }

    public static DateTimeFormatterBuilder$SettingsParser[] values() {
        return (DateTimeFormatterBuilder$SettingsParser[]) f21189a.clone();
    }

    @Override // org.threeten.bp.format.g
    public int parse(u r5, CharSequence r10, int r11) {
        int r12 = ordinal();
        if (r12 != 0) goto L5;
        r5.d = true;
    L15:
        return r11;
    L5:
        if (r12 != 1) goto L7;
        r5.d = false;
        goto L15
    L7:
        if (r12 != 2) goto L9;
        r5.e = true;
        goto L15
    L9:
        if (r12 != 3) goto L15;
        r5.e = false;
        goto L15
    }

    @Override // org.threeten.bp.format.g
    public boolean print(w r5, StringBuilder r10) {
        return true;
    }

    @Override // java.lang.Enum
    public String toString() {
        int r5 = ordinal();
        if (r5 != 0) goto L5;
        return "ParseCaseSensitive(true)";
    L5:
        if (r5 != 1) goto L7;
        return "ParseCaseSensitive(false)";
    L7:
        if (r5 != 2) goto L9;
        return "ParseStrict(true)";
    L9:
        if (r5 != 3) goto L13;
        return "ParseStrict(false)";
    L13:
        throw new IllegalStateException("Unreachable");
    }
}
