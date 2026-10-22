package com.lynx.tasm.fontface;

/* JADX INFO: loaded from: classes2.dex */
public final enum FontFace$TYPE extends Enum<FontFace$TYPE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FontFace$TYPE f10850a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FontFace$TYPE f10851b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ FontFace$TYPE[] f10852c = null;

    static {
        FontFace$TYPE r5 = new FontFace$TYPE("URL", 0);
        f10850a = r5;
        FontFace$TYPE r10 = new FontFace$TYPE("LOCAL", 1);
        f10851b = r10;
        f10852c = new FontFace$TYPE[]{r5, r10};
    }

    public FontFace$TYPE(String r5, int r10) {
        super(r5, r10);
    }

    public static FontFace$TYPE valueOf(String r5) {
        return (FontFace$TYPE) Enum.valueOf(FontFace$TYPE.class, r5);
    }

    public static FontFace$TYPE[] values() {
        return (FontFace$TYPE[]) f10852c.clone();
    }
}
