package com.lynx.animax.loader;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum AnimaXLoaderScheme extends Enum<AnimaXLoaderScheme> {
    public static final AnimaXLoaderScheme ASSET = null;
    public static final AnimaXLoaderScheme CONTENT_URI = null;
    public static final AnimaXLoaderScheme DATA_URL = null;
    public static final AnimaXLoaderScheme FILE = null;
    public static final AnimaXLoaderScheme HTTP = null;
    public static final /* synthetic */ AnimaXLoaderScheme[] a = null;

    static {
        AnimaXLoaderScheme r0 = new AnimaXLoaderScheme("ASSET", 0);
        ASSET = r0;
        AnimaXLoaderScheme r1 = new AnimaXLoaderScheme("FILE", 1);
        FILE = r1;
        AnimaXLoaderScheme r3 = new AnimaXLoaderScheme("HTTP", 2);
        HTTP = r3;
        AnimaXLoaderScheme r5 = new AnimaXLoaderScheme("DATA_URL", 3);
        DATA_URL = r5;
        AnimaXLoaderScheme r7 = new AnimaXLoaderScheme("CONTENT_URI", 4);
        CONTENT_URI = r7;
        a = new AnimaXLoaderScheme[]{r0, r1, r3, r5, r7};
    }

    public static AnimaXLoaderScheme[] values() {
        return (AnimaXLoaderScheme[]) a.clone();
    }

    public static AnimaXLoaderScheme valueOf(String r1) {
        return (AnimaXLoaderScheme) a.a(AnimaXLoaderScheme.class, r1);
    }

    public AnimaXLoaderScheme(String r1, int r2) {
        super(r1, r2);
    }
}
