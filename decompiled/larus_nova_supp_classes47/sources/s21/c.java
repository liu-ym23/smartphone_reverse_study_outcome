package s21;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final String a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "str");
        if (r2.length() > r3) goto L5;
        return r2;
    L5:
        return r2.substring(0, r3 - 1) + "...";
    }
}
