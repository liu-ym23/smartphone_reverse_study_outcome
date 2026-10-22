package x09;

import java.util.ArrayList;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final String a(String r13) {
        Intrinsics.checkNotNullParameter(r13, "colorStr");
        String r14 = StringsKt.replace$default(r13, "#", "", false, 4, null).toUpperCase(Locale.ROOT);
        if (new Regex("[0-9A-F]+").matches(r14) == true) goto L5;
        return null;
    L5:
        int r0 = r14.length();
        if (r0 != 3) goto L8;
        StringBuilder r1 = new StringBuilder("#");
        ArrayList r4 = new ArrayList(r14.length());
        int r2 = 0;
    L13:
        if (r2 >= r14.length()) goto L15;
        r4.add(StringsKt.repeat(String.valueOf(r14.charAt(r2)), 2));
        r2 = r2 + 1;
        goto L13
    L15:
        r1.append(CollectionsKt.joinToString$default(r4, "", null, null, 0, null, null, 62, null));
        return r1.toString();
    L8:
        if (r0 == 6) goto L18;
        return null;
    L18:
        return "#".concat(r14);
    }
}
