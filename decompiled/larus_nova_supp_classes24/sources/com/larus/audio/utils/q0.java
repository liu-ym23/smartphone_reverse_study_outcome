package com.larus.audio.utils;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class q0 {
    public static final kotlinx.coroutines.flow.c1 a(File r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 > 0) goto L6;
        return null;
    L6:
        return new kotlinx.coroutines.flow.c1(new FileUtilKt$readByteArrayAsFlow$1(r2, r3, null));
    }
}
