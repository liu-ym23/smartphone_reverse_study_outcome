package com.lynx.tasm.ui.image;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum ImageResizeMethod extends Enum<ImageResizeMethod> {
    public static final ImageResizeMethod AUTO = null;
    public static final ImageResizeMethod RESIZE = null;
    public static final ImageResizeMethod SCALE = null;
    public static final /* synthetic */ ImageResizeMethod[] a = null;

    static {
        ImageResizeMethod r0 = new ImageResizeMethod("AUTO", 0);
        AUTO = r0;
        ImageResizeMethod r1 = new ImageResizeMethod("RESIZE", 1);
        RESIZE = r1;
        ImageResizeMethod r3 = new ImageResizeMethod("SCALE", 2);
        SCALE = r3;
        a = new ImageResizeMethod[]{r0, r1, r3};
    }

    public static ImageResizeMethod[] values() {
        return (ImageResizeMethod[]) a.clone();
    }

    public static ImageResizeMethod valueOf(String r1) {
        return (ImageResizeMethod) r27.a.a(ImageResizeMethod.class, r1);
    }

    public ImageResizeMethod(String r1, int r2) {
        super(r1, r2);
    }
}
