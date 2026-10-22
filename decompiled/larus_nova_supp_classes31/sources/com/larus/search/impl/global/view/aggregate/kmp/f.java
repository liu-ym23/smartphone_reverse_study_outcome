package com.larus.search.impl.global.view.aggregate.kmp;

import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public static final String a(List r2) {
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r0 = r3.next();
        if ((!StringsKt.isBlank((String) r0)) == false) goto L4;
    L9:
        String r1 = (String) r0;
        if (r1 != null) goto L16;
        return "";
    L16:
        return r1;
    L8:
        r0 = null;
        goto L9
    }

    public static String b(String r12) {
        if (r12 != null) goto L4;
        r12 = "";
    L4:
        String r13 = StringsKt.replace$default(StringsKt.replace$default(r12, "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r13.length() > 32) goto L8;
        return r13;
    L8:
        return StringsKt.take(r13, 32) + "...";
    }
}
