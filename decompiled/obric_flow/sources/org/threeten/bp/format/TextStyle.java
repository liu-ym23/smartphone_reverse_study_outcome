package org.threeten.bp.format;

/* JADX INFO: loaded from: classes3.dex */
public final enum TextStyle extends Enum<TextStyle> {
    public static final TextStyle FULL = null;
    public static final TextStyle FULL_STANDALONE = null;
    public static final TextStyle NARROW = null;
    public static final TextStyle NARROW_STANDALONE = null;
    public static final TextStyle SHORT = null;
    public static final TextStyle SHORT_STANDALONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextStyle[] f21193a = null;

    static {
        TextStyle r5 = new TextStyle("FULL", 0);
        FULL = r5;
        TextStyle r10 = new TextStyle("FULL_STANDALONE", 1);
        FULL_STANDALONE = r10;
        TextStyle r11 = new TextStyle("SHORT", 2);
        SHORT = r11;
        TextStyle r12 = new TextStyle("SHORT_STANDALONE", 3);
        SHORT_STANDALONE = r12;
        TextStyle r13 = new TextStyle("NARROW", 4);
        NARROW = r13;
        TextStyle r14 = new TextStyle("NARROW_STANDALONE", 5);
        NARROW_STANDALONE = r14;
        f21193a = new TextStyle[]{r5, r10, r11, r12, r13, r14};
    }

    public static TextStyle valueOf(String r5) {
        return (TextStyle) Enum.valueOf(TextStyle.class, r5);
    }

    public static TextStyle[] values() {
        return (TextStyle[]) f21193a.clone();
    }

    public TextStyle asNormal() {
        return values()[ordinal() & (-2)];
    }

    public TextStyle asStandalone() {
        return values()[ordinal() | 1];
    }

    public boolean isStandalone() {
        if ((ordinal() & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
