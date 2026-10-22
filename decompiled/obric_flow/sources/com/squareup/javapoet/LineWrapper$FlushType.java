package com.squareup.javapoet;

/* JADX INFO: loaded from: classes3.dex */
final enum LineWrapper$FlushType extends Enum<LineWrapper$FlushType> {
    public static final LineWrapper$FlushType EMPTY = null;
    public static final LineWrapper$FlushType SPACE = null;
    public static final LineWrapper$FlushType WRAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LineWrapper$FlushType[] f14946a = null;

    static {
        LineWrapper$FlushType r5 = new LineWrapper$FlushType("WRAP", 0);
        WRAP = r5;
        LineWrapper$FlushType r10 = new LineWrapper$FlushType("SPACE", 1);
        SPACE = r10;
        LineWrapper$FlushType r11 = new LineWrapper$FlushType("EMPTY", 2);
        EMPTY = r11;
        f14946a = new LineWrapper$FlushType[]{r5, r10, r11};
    }

    public static LineWrapper$FlushType valueOf(String r5) {
        return (LineWrapper$FlushType) Enum.valueOf(LineWrapper$FlushType.class, r5);
    }

    public static LineWrapper$FlushType[] values() {
        return (LineWrapper$FlushType[]) f14946a.clone();
    }
}
