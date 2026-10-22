package org.jsoup.a;

import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static String a(String r1) {
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1.toLowerCase(Locale.ENGLISH);
    }

    public static String a(String r0, boolean r1) {
        if (r1 == false) goto L5;
        return a(r0);
    L5:
        return b(r0);
    }

    public static String b(String r0) {
        return a(r0).trim();
    }
}
