package com.ctc.wstx.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f3700a;

    static {
    }

    public static String a() {
        String r0 = f3700a;
        if (r0 != null) goto L14;
        String r1 = System.getProperty("line.separator");     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        String r2 = "\n";
    L8:
        f3700a = r2;     // Catch: Throwable -> L10
        return r1;
    L7:
        r2 = r1;
    L10:
        f3700a = "\n";
        return "\n";
    L14:
        return r0;
    }

    public static String a(String r6, boolean r7) {
        int r0 = r6.length();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L11;
        char r4 = r6.charAt(r2);
        if (r4 <= ' ') goto L11;
        if (Character.isLetterOrDigit(r4) == false) goto L11;
        r2 = r2 + 1;
    L11:
        if (r2 != r0) goto L13;
        return r6;
    L13:
        StringBuilder r5 = new StringBuilder();
        if (r2 <= 0) goto L16;
        r5.append(r6.substring(0, r2));
    L16:
        if (r2 >= r0) goto L26;
        char r1 = r6.charAt(r2);
        if (r1 <= ' ') goto L24;
        if (Character.isLetterOrDigit(r1) == false) goto L24;
        if (r7 == false) goto L23;
        r1 = Character.toUpperCase(r1);
    L23:
        r5.append(r1);
    L24:
        r2 = r2 + 1;
        goto L16
    L26:
        return r5.toString();
    }

    public static String a(Collection<?> r4, String r5, String r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        r6 = r5;
    L5:
        int r0 = r7.size();
        StringBuilder r1 = new StringBuilder((r0 << 3) + 16);
        Iterator r8 = r7.iterator();
        int r2 = 0;
    L7:
        if (r8.hasNext() == false) goto L16;
        if (r2 == 0) goto L14;
        if (r2 != (r0 - 1)) goto L13;
        r1.append(r6);
        goto L14
    L13:
        r1.append(r5);
    L14:
        r2 = r2 + 1;
        r1.append(r8.next());
        goto L7
    L16:
        return r1.toString();
    }

    public static String a(char[] r5, int r6, int r7) {
        int r8 = r7 - 1;
        int r0 = r6;
    L4:
        if (r0 > r8) goto L8;
        if (r5[r0] != ' ') goto L8;
        r0 = r0 + 1;
    L8:
        if (r0 <= r8) goto L11;
        return "";
    L11:
        int r2 = r8;
    L12:
        if (r2 <= r0) goto L16;
        if (r5[r2] != ' ') goto L16;
        r2 = r2 - 1;
    L16:
        int r3 = r0 + 1;
    L17:
        if (r3 >= r2) goto L25;
        if (r5[r3] == ' ') goto L21;
        r3 = r3 + 1;
        goto L17
    L21:
        if (r5[r3 + 1] == ' ') goto L25;
        r3 = r3 + 2;
    L25:
        if (r3 < r2) goto L32;
        if (r0 != r6) goto L31;
        if (r2 != r8) goto L31;
        return null;
    L31:
        return new String(r5, r0, (r2 - r0) + 1);
    L32:
        StringBuilder r9 = new StringBuilder(r2 - r0);
        r9.append(r5, r0, r3 - r0);
    L33:
        if (r3 > r2) goto L43;
        int r10 = r3 + 1;
        char r1 = r5[r3];
        if (r1 == ' ') goto L36;
        r9.append(r1);
        r3 = r10;
        goto L33
    L36:
        r9.append(' ');
    L37:
        int r4 = r10 + 1;
        char r11 = r5[r10];
        if (r11 != ' ') goto L39;
        r10 = r4;
        goto L37
    L39:
        r9.append(r11);
        r3 = r4;
        goto L33
    L43:
        return r9.toString();
    }

    public static void a(StringBuilder r1) {
        r1.append(a());
    }

    public static boolean a(String r12, String r13) {
        int r0 = r12.length();
        int r1 = r13.length();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 < r0) goto L9;
        if (r4 < r1) goto L9;
        return true;
    L9:
        if (r3 < r0) goto L11;
        int r6 = r3;
        int r5 = 65536;
    L12:
        if (r4 < r1) goto L14;
        int r7 = r4;
        int r8 = 65536;
    L15:
        if (r5 == r8) goto L16;
    L18:
        if (r5 > 32) goto L20;
    L48:
        if (r6 >= r0) goto L49;
        int r9 = r6 + 1;
        char r10 = r12.charAt(r6);
        r6 = r9;
        r5 = r10;
        goto L18
    L49:
        r5 = 65536;
        goto L18
    L20:
        if (r5 == 95) goto L48;
        if (r5 == 45) goto L48;
    L24:
        if (r8 <= 32) goto L45;
        if (r8 == 95) goto L45;
        if (r8 == 45) goto L45;
        if (r5 == r8) goto L16;
        if (r5 == 65536) goto L44;
        if (r8 == 65536) goto L44;
        if (r5 >= 127) goto L37;
        if (r5 > 90) goto L38;
        if (r5 < 65) goto L38;
        r5 = r5 + 32;
    L38:
        if (r8 >= 127) goto L42;
        if (r8 > 90) goto L43;
        if (r8 < 65) goto L43;
        r8 = r8 + 32;
    L43:
        if (r5 == r8) goto L16;
    L42:
        r8 = Character.toLowerCase((char) r8);
        goto L43
    L37:
        r5 = Character.toLowerCase((char) r5);
    L44:
        return false;
    L45:
        if (r7 >= r1) goto L46;
        int r11 = r7 + 1;
        char r14 = r13.charAt(r7);
        r7 = r11;
        r8 = r14;
        goto L24
    L46:
        r8 = 65536;
    L16:
        r3 = r6;
        r4 = r7;
        goto L3
    L14:
        r7 = r4 + 1;
        r8 = r13.charAt(r4);
        goto L15
    L11:
        r6 = r3 + 1;
        r5 = r12.charAt(r3);
        goto L12
    }

    public static boolean a(String r4, char[] r5, int r6, int r7) {
        if (r4.length() == r7) goto L5;
        return false;
    L5:
        int r0 = 0;
    L6:
        if (r0 >= r7) goto L11;
        if (r4.charAt(r0) != r5[r6 + r0]) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static boolean b(String r13, String r14) {
        int r0 = r13.length();
        int r1 = r14.length();
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 < r0) goto L9;
        if (r4 < r1) goto L9;
        return true;
    L9:
        if (r3 < r0) goto L11;
        int r7 = r3;
        char r5 = 0;
    L12:
        if (r4 < r1) goto L14;
        int r8 = r4;
        char r6 = 0;
    L15:
        if (r5 == r6) goto L16;
    L18:
        if (r5 > ' ') goto L20;
    L39:
        if (r7 >= r0) goto L40;
        int r9 = r7 + 1;
        char r10 = r13.charAt(r7);
        r7 = r9;
        r5 = r10;
        goto L18
    L40:
        r5 = 0;
        goto L18
    L20:
        if (r5 == '_') goto L39;
        if (r5 == '-') goto L39;
    L24:
        if (r6 <= ' ') goto L36;
        if (r6 == '_') goto L36;
        if (r6 == '-') goto L36;
        if (r5 == r6) goto L16;
        if (r6 == 0) goto L30;
        if (r5 == 0) goto L32;
        if (Character.toLowerCase(r5) == Character.toLowerCase(r6)) goto L16;
        return false;
    L32:
        return false;
    L30:
        return true;
    L36:
        if (r8 >= r1) goto L37;
        int r11 = r8 + 1;
        char r12 = r14.charAt(r8);
        r8 = r11;
        r6 = r12;
        goto L24
    L37:
        r6 = 0;
    L16:
        r3 = r7;
        r4 = r8;
        goto L4
    L14:
        r8 = r4 + 1;
        r6 = r14.charAt(r4);
        goto L15
    L11:
        r7 = r3 + 1;
        r5 = r13.charAt(r3);
        goto L12
    }
}
