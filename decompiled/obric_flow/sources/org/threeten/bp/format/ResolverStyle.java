package org.threeten.bp.format;

/* JADX INFO: loaded from: classes3.dex */
public final enum ResolverStyle extends Enum<ResolverStyle> {
    public static final ResolverStyle LENIENT = null;
    public static final ResolverStyle SMART = null;
    public static final ResolverStyle STRICT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResolverStyle[] f21191a = null;

    static {
        ResolverStyle r5 = new ResolverStyle("STRICT", 0);
        STRICT = r5;
        ResolverStyle r10 = new ResolverStyle("SMART", 1);
        SMART = r10;
        ResolverStyle r11 = new ResolverStyle("LENIENT", 2);
        LENIENT = r11;
        f21191a = new ResolverStyle[]{r5, r10, r11};
    }

    public static ResolverStyle valueOf(String r5) {
        return (ResolverStyle) Enum.valueOf(ResolverStyle.class, r5);
    }

    public static ResolverStyle[] values() {
        return (ResolverStyle[]) f21191a.clone();
    }
}
