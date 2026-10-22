package com.larus.dora.impl.file.upload;

import com.larus.dora.impl.file.DoraFileType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public /* synthetic */ class DoraFileUploaderImpl$c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[DoraFileType.values().length];
        r0[DoraFileType.CRASH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r0[DoraFileType.PERFORMANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r0[DoraFileType.LOG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r0[DoraFileType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        a = r0;
    }
}
