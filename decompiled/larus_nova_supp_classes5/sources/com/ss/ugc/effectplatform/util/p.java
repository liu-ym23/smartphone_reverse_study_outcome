package com.ss.ugc.effectplatform.util;

import bytekn.foundation.io.file.FileManager;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class p {
    public static final String a(String r4) {
        String r0 = FileManager.a;
        String r1 = FileManager.a;
        if (StringsKt.endsWith$default(r4, r1, false, 2, null) == false) goto L6;
        return r4;
    L6:
        return r4 + r1;
    }
}
