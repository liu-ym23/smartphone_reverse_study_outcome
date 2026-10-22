package com.lynx.tasm.behavior.ui.utils;

/* JADX INFO: loaded from: classes2.dex */
final enum BackgroundDrawable$RoundRectPath$Pos extends Enum<BackgroundDrawable$RoundRectPath$Pos> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BackgroundDrawable$RoundRectPath$Pos f10727a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BackgroundDrawable$RoundRectPath$Pos f10728b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BackgroundDrawable$RoundRectPath$Pos f10729c = null;
    public static final BackgroundDrawable$RoundRectPath$Pos d = null;
    public static final BackgroundDrawable$RoundRectPath$Pos e = null;
    public static final /* synthetic */ BackgroundDrawable$RoundRectPath$Pos[] f = null;

    static {
        BackgroundDrawable$RoundRectPath$Pos r5 = new BackgroundDrawable$RoundRectPath$Pos("CENTER", 0);
        f10727a = r5;
        BackgroundDrawable$RoundRectPath$Pos r10 = new BackgroundDrawable$RoundRectPath$Pos("INNER2", 1);
        f10728b = r10;
        BackgroundDrawable$RoundRectPath$Pos r11 = new BackgroundDrawable$RoundRectPath$Pos("OUTER2", 2);
        f10729c = r11;
        BackgroundDrawable$RoundRectPath$Pos r12 = new BackgroundDrawable$RoundRectPath$Pos("INNER3", 3);
        d = r12;
        BackgroundDrawable$RoundRectPath$Pos r13 = new BackgroundDrawable$RoundRectPath$Pos("OUTER3", 4);
        e = r13;
        f = new BackgroundDrawable$RoundRectPath$Pos[]{r5, r10, r11, r12, r13};
    }

    public BackgroundDrawable$RoundRectPath$Pos(String r5, int r10) {
        super(r5, r10);
    }

    public static BackgroundDrawable$RoundRectPath$Pos valueOf(String r5) {
        return (BackgroundDrawable$RoundRectPath$Pos) Enum.valueOf(BackgroundDrawable$RoundRectPath$Pos.class, r5);
    }

    public static BackgroundDrawable$RoundRectPath$Pos[] values() {
        return (BackgroundDrawable$RoundRectPath$Pos[]) f.clone();
    }
}
