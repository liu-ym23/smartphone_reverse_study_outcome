package hga;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public static final String a(String r2) {
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        return "***" + StringsKt.takeLast(r2, 4);
    L5:
        r0 = false;
        goto L6
    }
}
