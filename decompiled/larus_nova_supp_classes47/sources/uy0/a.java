package uy0;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "path");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r4;
    L8:
        if (StringsKt.endsWith$default(r4, "/", false, 2, null) == false) goto L11;
        return r4;
    L11:
        return r4.concat("/");
    L5:
        r0 = false;
        goto L6
    }

    public static String b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "path");
        int r0 = StringsKt.lastIndexOf$default(r7, "/", 0, false, 6, null);
        if (r0 == (-1)) goto L7;
        int r1 = r0 + 1;
        if (r1 >= r7.length()) goto L7;
        return r7.substring(r1);
    L7:
        return null;
    }
}
