package org.apache.logging.log4j.util;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static char a(int r1) {
        if (r1 >= 0) goto L4;
        return 0;
    L4:
        if (r1 < 16) goto L7;
        return 0;
    L7:
        if (r1 >= 10) goto L10;
        return b(r1);
    L10:
        return c(r1);
    }

    private static char b(int r0) {
        return (char) (r0 + 48);
    }

    private static char c(int r0) {
        return (char) ((r0 + 65) - 10);
    }
}
