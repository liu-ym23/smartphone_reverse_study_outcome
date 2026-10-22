package com.bytedance.android.bytehook;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public /* synthetic */ class ByteHook$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ByteHook$RecordItem.values().length];
        a = r0;
        r0[ByteHook$RecordItem.TIMESTAMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
    L20:
        a[ByteHook$RecordItem.CALLER_LIB_NAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
    L24:
        a[ByteHook$RecordItem.OP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
    L34:
        a[ByteHook$RecordItem.LIB_NAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
    L22:
        a[ByteHook$RecordItem.SYM_NAME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
    L26:
        a[ByteHook$RecordItem.NEW_ADDR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
    L28:
        a[ByteHook$RecordItem.ERRNO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
    L30:
        a[ByteHook$RecordItem.STUB.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
        return;
    }
}
