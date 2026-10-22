package org.threeten.bp.format;

/* JADX INFO: loaded from: classes3.dex */
public final enum SignStyle extends Enum<SignStyle> {
    public static final SignStyle ALWAYS = null;
    public static final SignStyle EXCEEDS_PAD = null;
    public static final SignStyle NEVER = null;
    public static final SignStyle NORMAL = null;
    public static final SignStyle NOT_NEGATIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SignStyle[] f21192a = null;

    static {
        SignStyle r5 = new SignStyle("NORMAL", 0);
        NORMAL = r5;
        SignStyle r10 = new SignStyle("ALWAYS", 1);
        ALWAYS = r10;
        SignStyle r11 = new SignStyle("NEVER", 2);
        NEVER = r11;
        SignStyle r12 = new SignStyle("NOT_NEGATIVE", 3);
        NOT_NEGATIVE = r12;
        SignStyle r13 = new SignStyle("EXCEEDS_PAD", 4);
        EXCEEDS_PAD = r13;
        f21192a = new SignStyle[]{r5, r10, r11, r12, r13};
    }

    public static SignStyle valueOf(String r5) {
        return (SignStyle) Enum.valueOf(SignStyle.class, r5);
    }

    public static SignStyle[] values() {
        return (SignStyle[]) f21192a.clone();
    }

    public boolean parse(boolean r5, boolean r10, boolean r11) {
        int r12 = ordinal();
        if (r12 == 0) goto L12;
        if (r12 != 1) goto L6;
    L11:
        return true;
    L6:
        if (r12 == 4) goto L11;
        if (r10 == true) goto L16;
        if (r11 == false) goto L10;
        return false;
    L10:
        return true;
    L16:
        return false;
    L12:
        if (r5 == false) goto L15;
        if (r10 == false) goto L15;
        return false;
    L15:
        return true;
    }
}
