package com.larus.bmhome.utils;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s3 {
    static {
    }

    public static String a(String r30) {
        Intrinsics.checkNotNullParameter(r30, "tsvText");
        if (r30.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "<table></table>";
    L9:
        StringBuilder r1 = new StringBuilder("<table style=\"border-collapse:collapse;\"><tbody>");
        Iterator r2 = StringsKt.split$default(r30, new String[]{"\n"}, false, 0, 6, null).iterator();
    L11:
        if (r2.hasNext() == false) goto L22;
        String r9 = (String) r2.next();
        if (r9.length() != 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == true) goto L11;
        r1.append("<tr>");
        Iterator r4 = StringsKt.split$default(r9, new String[]{"\t"}, false, 0, 6, null).iterator();
    L19:
        if (r4.hasNext() == false) goto L21;
        String r5 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String) r4.next(), "&", "&amp;", false, 4, null), "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null), "\"", "&quot;", false, 4, null), "'", "&#39;", false, 4, null);
        r1.append("<td style=\"border:1px solid #d0d0d0;padding:4px;\">");
        r1.append(r5);
        r1.append("</td>");
        goto L19
    L21:
        r1.append("</tr>");
        goto L11
    L15:
        r3 = false;
        goto L16
    L22:
        r1.append("</tbody></table>");
        return r1.toString();
    L5:
        r0 = false;
        goto L6
    }
}
