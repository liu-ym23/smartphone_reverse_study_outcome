package com.larus.bmhome.chat.doclink;

import com.larus.utils.y0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l {
    public static final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = StringsKt.trim(r2).toString();
        if (StringsKt.isBlank(r3) == false) goto L7;
        return "";
    L7:
        if (y0.e(r3) == false) goto L10;
        return r3;
    L10:
        return "https://" + r3;
    }
}
