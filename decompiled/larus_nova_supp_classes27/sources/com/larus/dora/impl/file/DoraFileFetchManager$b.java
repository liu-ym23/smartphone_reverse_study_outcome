package com.larus.dora.impl.file;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public /* synthetic */ class DoraFileFetchManager$b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[DoraFileTaskStatus.values().length];
        r0[DoraFileTaskStatus.UPLOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
    L23:
        r0[DoraFileTaskStatus.PENDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
    L35:
        r0[DoraFileTaskStatus.START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
    L25:
        r0[DoraFileTaskStatus.RUNNING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
    L27:
        r0[DoraFileTaskStatus.FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
    L21:
        r0[DoraFileTaskStatus.PAUSED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
    L29:
        r0[DoraFileTaskStatus.DONE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
    L31:
        r0[DoraFileTaskStatus.CANCELED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
    L11:
        a = r0;
    }
}
