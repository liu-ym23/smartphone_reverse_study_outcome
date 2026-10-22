package com.lynx.tasm.ui.image;

/* JADX INFO: loaded from: classes2.dex */
public final enum ImageResizeMethod extends Enum<ImageResizeMethod> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImageResizeMethod f10988a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ImageResizeMethod f10989b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ImageResizeMethod f10990c = null;
    public static final /* synthetic */ ImageResizeMethod[] d = null;

    static {
        ImageResizeMethod r5 = new ImageResizeMethod("AUTO", 0);
        f10988a = r5;
        ImageResizeMethod r10 = new ImageResizeMethod("RESIZE", 1);
        f10989b = r10;
        ImageResizeMethod r11 = new ImageResizeMethod("SCALE", 2);
        f10990c = r11;
        d = new ImageResizeMethod[]{r5, r10, r11};
    }

    public ImageResizeMethod(String r5, int r10) {
        super(r5, r10);
    }

    public static ImageResizeMethod valueOf(String r5) {
        return (ImageResizeMethod) Enum.valueOf(ImageResizeMethod.class, r5);
    }

    public static ImageResizeMethod[] values() {
        return (ImageResizeMethod[]) d.clone();
    }
}
