package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7367a = null;

    static {
        int[] r5 = new int[ReadableType.values().length];
        r5[ReadableType.String.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
    L23:
        r5[ReadableType.Number.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
    L35:
        r5[ReadableType.Long.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
    L25:
        r5[ReadableType.Int.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
    L27:
        r5[ReadableType.Boolean.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
    L21:
        r5[ReadableType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
    L29:
        r5[ReadableType.Array.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
    L31:
        r5[ReadableType.Null.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
    L11:
        f7367a = r5;
    }
}
