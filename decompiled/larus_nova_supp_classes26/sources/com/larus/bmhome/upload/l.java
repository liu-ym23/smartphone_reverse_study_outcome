package com.larus.bmhome.upload;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l {
    public static final String a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r4 = "h264";
        if (StringsKt.contains$default(r5, "avc", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r5, "h264", false, 2, null) == true) goto L18;
        r4 = "h265";
        if (StringsKt.contains$default(r5, "hevc", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r5, "h265", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r5, "dolby-vision", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r5, '/', false, 2, null) == true) goto L20;
        return r5;
    L20:
        return StringsKt.substringAfterLast$default(r5, '/', null, 2, null);
    L18:
        return r4;
    }
}
