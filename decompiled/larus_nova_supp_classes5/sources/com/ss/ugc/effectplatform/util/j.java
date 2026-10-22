package com.ss.ugc.effectplatform.util;

import java.io.File;
import java.io.FilenameFilter;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j implements FilenameFilter {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r4, String r5) {
        if (r4.isDirectory() == true) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r5, "kgsl", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
