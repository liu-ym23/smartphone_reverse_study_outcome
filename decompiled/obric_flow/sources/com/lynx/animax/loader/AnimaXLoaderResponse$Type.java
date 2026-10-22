package com.lynx.animax.loader;

/* JADX INFO: loaded from: classes2.dex */
public final enum AnimaXLoaderResponse$Type extends Enum<AnimaXLoaderResponse$Type> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnimaXLoaderResponse$Type f9628a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AnimaXLoaderResponse$Type f9629b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AnimaXLoaderResponse$Type f9630c = null;
    public static final /* synthetic */ AnimaXLoaderResponse$Type[] d = null;

    static {
        AnimaXLoaderResponse$Type r5 = new AnimaXLoaderResponse$Type("STRING_FILE_PATH", 0);
        AnimaXLoaderResponse$Type r10 = new AnimaXLoaderResponse$Type("BYTE_ARRAY", 1);
        f9628a = r10;
        AnimaXLoaderResponse$Type r11 = new AnimaXLoaderResponse$Type("BITMAP", 2);
        f9629b = r11;
        AnimaXLoaderResponse$Type r12 = new AnimaXLoaderResponse$Type("ERROR", 3);
        f9630c = r12;
        d = new AnimaXLoaderResponse$Type[]{r5, r10, r11, r12};
    }

    public AnimaXLoaderResponse$Type(String r5, int r10) {
        super(r5, r10);
    }

    public static AnimaXLoaderResponse$Type valueOf(String r5) {
        return (AnimaXLoaderResponse$Type) Enum.valueOf(AnimaXLoaderResponse$Type.class, r5);
    }

    public static AnimaXLoaderResponse$Type[] values() {
        return (AnimaXLoaderResponse$Type[]) d.clone();
    }
}
