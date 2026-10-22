package hda;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c1 {
    public static final String a(String r1) {
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = StringsKt.trim(r1).toString();
        if (r2 == null) goto L8;
        if ((!StringsKt.isBlank(r2)) == false) goto L8;
        return r2;
    L8:
        return null;
    }

    public static final String b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return b1.a(r1);
    }

    public static final String c(String r2) {
        if (r2 == null) goto L10;
        String r3 = b(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r3)) == true) goto L9;
        return null;
    L9:
        return r3;
    L10:
        return null;
    }
}
