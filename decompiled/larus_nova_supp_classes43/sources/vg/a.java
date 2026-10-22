package vg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    static {
    }

    public static String a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "param");
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L9:
        return "";
    L8:
        if (Intrinsics.areEqual("null", r1) == true) goto L9;
        return r1;
    L5:
        r0 = false;
        goto L6
    }
}
