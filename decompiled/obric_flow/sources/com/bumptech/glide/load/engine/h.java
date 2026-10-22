package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.EncodeStrategy;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1506a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f1507b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f1508c = null;

    static {
        int[] r5 = new int[EncodeStrategy.values().length];
        f1508c = r5;
        r5[EncodeStrategy.SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
    L28:
        f1508c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
    L6:
        int[] r10 = new int[DecodeJob$Stage.values().length];
        f1507b = r10;
        r10[DecodeJob$Stage.RESOURCE_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
    L36:
        f1507b[DecodeJob$Stage.DATA_CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
    L46:
        f1507b[DecodeJob$Stage.SOURCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
    L32:
        f1507b[DecodeJob$Stage.FINISHED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
    L38:
        f1507b[DecodeJob$Stage.INITIALIZE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
    L13:
        int[] r11 = new int[DecodeJob$RunReason.values().length];
        f1506a = r11;
        r11[DecodeJob$RunReason.INITIALIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
    L42:
        f1506a[DecodeJob$RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
    L30:
        f1506a[DecodeJob$RunReason.DECODE_DATA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        return;
    }
}
