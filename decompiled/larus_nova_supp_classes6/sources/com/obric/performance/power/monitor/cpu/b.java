package com.obric.performance.power.monitor.cpu;

import java.io.File;
import java.io.FilenameFilter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b implements FilenameFilter {
    public b() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "dir");
        Intrinsics.checkNotNullParameter(r6, "name");
        if (StringsKt.startsWith$default(r6, "cpu", false, 2, null) == true) goto L5;
    L17:
        return false;
    L5:
        if (r6.length() < 4) goto L17;
        int r7 = r6.length();
        int r0 = 3;
    L7:
        if (r0 >= r7) goto L15;
        if (Intrinsics.compare(r6.charAt(r0), 48) < 0) goto L14;
        if (Intrinsics.compare(r6.charAt(r0), 57) > 0) goto L14;
        r0 = r0 + 1;
    L14:
        return false;
    L15:
        return true;
    }
}
