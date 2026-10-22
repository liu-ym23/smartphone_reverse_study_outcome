package com.ss.android.lark.preload;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum PreloadSource extends Enum<PreloadSource> {
    public static final PreloadSource BOT_CHAT = null;
    public static final PreloadSource DOC_FEED = null;
    public static final PreloadSource DOC_TAB = null;
    public static final PreloadSource UNKNOWN = null;
    public static final /* synthetic */ PreloadSource[] a = null;

    static {
        PreloadSource r0 = new PreloadSource("UNKNOWN", 0);
        UNKNOWN = r0;
        PreloadSource r1 = new PreloadSource("DOC_FEED", 1);
        DOC_FEED = r1;
        PreloadSource r3 = new PreloadSource("DOC_TAB", 2);
        DOC_TAB = r3;
        PreloadSource r5 = new PreloadSource("BOT_CHAT", 3);
        BOT_CHAT = r5;
        a = new PreloadSource[]{r0, r1, r3, r5};
    }

    public static PreloadSource[] values() {
        return (PreloadSource[]) a.clone();
    }

    public static PreloadSource valueOf(String r1) {
        return (PreloadSource) r27.a.a(PreloadSource.class, r1);
    }

    public PreloadSource(String r1, int r2) {
        super(r1, r2);
    }
}
