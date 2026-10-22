package com.lynx.react.bridge.mapbuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[MapBuffer.DataType.values().length];
        a = r0;
        r0[MapBuffer.DataType.ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L18:
        a[MapBuffer.DataType.INT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L22:
        a[MapBuffer.DataType.BOOL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
    L30:
        a[MapBuffer.DataType.LONG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
    L20:
        a[MapBuffer.DataType.STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
    L24:
        a[MapBuffer.DataType.DOUBLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
    L26:
        a[MapBuffer.DataType.NULL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
        return;
    }
}
