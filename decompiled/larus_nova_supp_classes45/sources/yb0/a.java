package yb0;

import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    static {
    }

    public static String a(String r16, String r17) {
        int r3 = 1;
        if (r16 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        return "";
    L12:
        if (r17.length() != 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == true) goto L88;
        if (r16 != null) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == false) goto L25;
    L55:
        boolean r2 = true;
    L56:
        String r0 = "";
    L58:
        if (r0.length() != 0) goto L60;
        boolean r7 = true;
    L61:
        if (r7 == true) goto L89;
        StringBuilder r8 = new StringBuilder();
        int r9 = r17.length();
        int r11 = 0;
    L64:
        if (r11 >= r9) goto L69;
        char r12 = r17.charAt(r11);
        if (Character.isLetterOrDigit(r12) == false) goto L68;
        r8.append(r12);
    L68:
        r11 = r11 + 1;
        goto L64
    L69:
        int r1 = r8.toString().length();
        if (r1 > 0) goto L72;
    L74:
        r2 = false;
    L75:
        if (r2 == true) goto L77;
        return "";
    L77:
        if (r0.length() >= 2) goto L80;
        return "";
    L80:
        return r0;
    L72:
        if ((((double) r0.length()) / ((double) r1)) < 0.5d) goto L74;
    L89:
        return "";
    L60:
        r7 = false;
        goto L61
    L25:
        if (r17.length() != 0) goto L27;
        boolean r13 = true;
    L28:
        if (r13 == true) goto L55;
        if (r16 == null) goto L54;
        Locale r14 = Locale.ROOT;
        String r15 = r16.toLowerCase(r14);
        String r18 = r17.toLowerCase(r14);
        int r19 = r15.length();
        int r21 = r18.length();
        int[] r22 = new int[r21 + 1];
        int r110 = -1;
        if (1 > r19) goto L48;
        int r111 = 0;
        int r112 = 1;
    L34:
        if (r3 > r21) goto L45;
        int r113 = 1;
        int r114 = 0;
    L36:
        int r115 = r22[r113];
        if (r15.charAt(r112 - 1) != r18.charAt(r113 - 1)) goto L42;
        r2 = true;
        int r116 = r114 + 1;
        r22[r113] = r116;
        if (r116 <= r111) goto L43;
        r110 = r112;
        r111 = r116;
    L43:
        if (r113 == r21) goto L46;
        r113 = r113 + 1;
        r114 = r115;
    L46:
        if (r112 == r19) goto L49;
        r112 = r112 + 1;
        r3 = 1;
    L49:
        if (r111 == 0) goto L56;
        if (r110 <= 0) goto L56;
        r0 = r16.substring(r110 - r111, r110);
        goto L58
    L42:
        r2 = true;
        r22[r113] = 0;
        goto L43
    L45:
        r2 = true;
        goto L46
    L48:
        r2 = true;
        r111 = 0;
        goto L49
    L54:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L27:
        r13 = false;
        goto L28
    L19:
        if (r16.length() == 0) goto L22;
        r6 = false;
        goto L23
    L88:
        return "";
    L14:
        r5 = false;
        goto L15
    L5:
        if (r16.length() == 0) goto L8;
        r4 = false;
        goto L10
    }
}
