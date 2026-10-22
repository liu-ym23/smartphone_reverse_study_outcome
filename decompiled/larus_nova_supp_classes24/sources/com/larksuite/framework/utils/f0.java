package com.larksuite.framework.utils;

import android.text.TextUtils;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f0 {
    public static final BitSet a = null;

    public class a extends ThreadLocal<StringBuilder> {
        @Override // java.lang.ThreadLocal
        public final StringBuilder initialValue() {
            return new StringBuilder(8192);
        }

        public a() {
        }
    }

    static {
        new String[]{"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};
        new a();
        a = new BitSet(256);
        int r0 = 97;
    L4:
        if (r0 > 122) goto L6;
        a.set(r0);
        r0 = r0 + 1;
        goto L4
    L6:
        int r1 = 65;
    L8:
        if (r1 > 90) goto L10;
        a.set(r1);
        r1 = r1 + 1;
        goto L8
    L10:
        int r2 = 48;
    L12:
        if (r2 > 57) goto L14;
        a.set(r2);
        r2 = r2 + 1;
        goto L12
    L14:
        BitSet r3 = a;
        r3.set(43);
        r3.set(45);
        r3.set(95);
        r3.set(46);
        r3.set(42);
    }

    public static boolean a(String r6) {
        if (r6 != null) goto L5;
    L25:
        return true;
    L5:
        if (r6.length() == 0) goto L25;
        int r1 = r6.length();
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L25;
        int r4 = r6.codePointAt(r3);
        if (r4 != 32) goto L12;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == false) goto L23;
        r3 = r3 + 1;
        goto L8
    L23:
        return false;
    L12:
        if (r4 == 9) goto L21;
        if (r4 == 10) goto L21;
        if (r4 == 12) goto L21;
        if (r4 == 13) goto L21;
        r5 = false;
        goto L22
    }

    public static boolean b(String r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= r4.length()) goto L19;
        char r2 = r4.charAt(r1);
        if (r2 < 'a') goto L13;
        if (r2 > 'z') goto L13;
    L17:
        r1 = r1 + 1;
    L13:
        if (r2 < 'A') goto L18;
        if (r2 <= 'Z') goto L17;
    L18:
        return false;
    L19:
        return true;
    }

    public static String d(Collection r3) {
        Iterator r4 = r3.iterator();
        if (r4.hasNext() == true) goto L5;
        return "";
    L5:
        String r0 = r4.next().toString();
        if (r4.hasNext() == false) goto L16;
        StringBuilder r1 = new StringBuilder(64);
        r1.append(r0);
    L10:
        if (r4.hasNext() == false) goto L13;
        r1.append(",");
        r1.append(r4.next());
        goto L10
    L13:
        return r1.toString();
    L16:
        return r0;
    }

    public static boolean c(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return TextUtils.isEmpty(r2);
    L7:
        return r1.equals(r2);
    }
}
