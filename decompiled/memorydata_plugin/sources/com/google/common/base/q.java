package com.google.common.base;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class q {
    private static String a(Object r5) {
        if (r5 != null) goto L10;
        return "null";
    L10:
        return r5.toString();
    L7:
        e = move-exception;
        String r6 = r5.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(r5));
        Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + r6, e);
        return "<" + r6 + " threw " + e.getClass().getName() + ">";
    }

    public static String a(String r0) {
        return m.b(r0);
    }

    public static String a(String r6, Object... r7) {
        String r8 = String.valueOf(r6);
        int r0 = 0;
        if (r7 != null) goto L5;
        r7 = new Object[]{"(Object[])null"};
    L9:
        StringBuilder r1 = new StringBuilder(r8.length() + (r7.length * 16));
        int r2 = 0;
    L11:
        if (r0 >= r7.length) goto L16;
        int r3 = r8.indexOf("%s", r2);
        if (r3 == (-1)) goto L16;
        r1.append(r8, r2, r3);
        r1.append(r7[r0]);
        r2 = r3 + 2;
        r0 = r0 + 1;
    L16:
        r1.append(r8, r2, r8.length());
        if (r0 >= r7.length) goto L24;
        r1.append(" [");
        int r9 = r0 + 1;
        r1.append(r7[r0]);
    L20:
        if (r9 >= r7.length) goto L22;
        r1.append(", ");
        r1.append(r7[r9]);
        r9 = r9 + 1;
        goto L20
    L22:
        r1.append(']');
    L24:
        return r1.toString();
    L5:
        int r4 = 0;
    L7:
        if (r4 >= r7.length) goto L9;
        r7[r4] = a(r7[r4]);
        r4 = r4 + 1;
        goto L7
    }

    public static boolean b(String r0) {
        return m.a(r0);
    }
}
