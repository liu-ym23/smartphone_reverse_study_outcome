package com.lynx.animax.loader;

/* JADX INFO: loaded from: classes2.dex */
public final enum AnimaXLoaderScheme extends Enum<AnimaXLoaderScheme> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnimaXLoaderScheme f9632a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AnimaXLoaderScheme f9633b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AnimaXLoaderScheme f9634c = null;
    public static final AnimaXLoaderScheme d = null;
    public static final /* synthetic */ AnimaXLoaderScheme[] e = null;

    static {
        AnimaXLoaderScheme r5 = new AnimaXLoaderScheme("ASSET", 0);
        f9632a = r5;
        AnimaXLoaderScheme r10 = new AnimaXLoaderScheme("FILE", 1);
        f9633b = r10;
        AnimaXLoaderScheme r11 = new AnimaXLoaderScheme("HTTP", 2);
        f9634c = r11;
        AnimaXLoaderScheme r12 = new AnimaXLoaderScheme("DATA_URL", 3);
        d = r12;
        e = new AnimaXLoaderScheme[]{r5, r10, r11, r12};
    }

    public AnimaXLoaderScheme(String r5, int r10) {
        super(r5, r10);
    }

    public static AnimaXLoaderScheme valueOf(String r5) {
        return (AnimaXLoaderScheme) Enum.valueOf(AnimaXLoaderScheme.class, r5);
    }

    public static AnimaXLoaderScheme[] values() {
        return (AnimaXLoaderScheme[]) e.clone();
    }
}
