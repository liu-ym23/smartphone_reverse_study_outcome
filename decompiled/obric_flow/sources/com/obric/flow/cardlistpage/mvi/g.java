package com.obric.flow.cardlistpage.mvi;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f11534a = null;

    static {
        int[] r5 = new int[MviLogLevel.values().length];
        r5[MviLogLevel.VERBOSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
    L15:
        r5[MviLogLevel.DEBUG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
    L23:
        r5[MviLogLevel.INFO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
    L17:
        r5[MviLogLevel.WARN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
    L19:
        r5[MviLogLevel.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
    L8:
        f11534a = r5;
    }
}
