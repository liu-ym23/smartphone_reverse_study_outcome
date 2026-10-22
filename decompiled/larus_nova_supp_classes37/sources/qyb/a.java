package qyb;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final boolean a(String r1) {
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        return !r2;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L10
    }
}
