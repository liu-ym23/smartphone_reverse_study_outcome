package org.apache.logging.log4j.util;

import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static <T extends Enum<T>> T a(Class<T> r1, String r2) {
        return (T) a(r1, r2, null);
    }

    public static <T extends Enum<T>> T a(Class<T> r0, String r1, T r2) {
        if (r1 != null) goto L5;
        return r2;
    L5:
        return (T) Enum.valueOf(r0, r1.toUpperCase(Locale.ENGLISH));
    }
}
