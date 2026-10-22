package ne;

/* JADX INFO: loaded from: classes2.dex */
public class j extends g {
    public static /* synthetic */ int A0(CharSequence r8, String r10, int r11, boolean r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = false;
    L9:
        return y0(r11, r8, r10, r12);
    }

    public static int B0(String r8, String r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        int r12 = x0(r8);
    L6:
        he.i.f(r8, "<this>");
        he.i.f(r10, "string");
        return r8.lastIndexOf(r10, r12);
    L5:
        r12 = 0;
        goto L6
    }

    public static a C0(CharSequence r8, String[] r10, boolean r11, int r12) {
        E0(r12);
        return new a(r8, 0, r12, new h(yd.e.r0(r10), r11));
    }

    public static final boolean D0(CharSequence r8, CharSequence r10, int r11, int r12, boolean r13) {
        he.i.f(r8, "<this>");
        he.i.f(r10, "other");
        if (r11 >= 0) goto L5;
    L17:
        return false;
    L5:
        if ((r8.length() - r12) < 0) goto L17;
        if (r11 > (r10.length() - r12)) goto L17;
        int r14 = 0;
    L10:
        if (r14 >= r12) goto L15;
        if (l6.a.I(r8.charAt(0 + r14), r10.charAt(r11 + r14), r13) == false) goto L13;
        r14 = r14 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    public static final void E0(int r8) {
        if (r8 < 0) goto L4;
        boolean r10 = true;
    L5:
        if (r10 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(defpackage.a.d("Limit must be non-negative, but was ", r8).toString());
    L4:
        r10 = false;
        goto L5
    }

    public static final String F0(CharSequence r8, ke.c r10) {
        he.i.f(r8, "<this>");
        he.i.f(r10, "range");
        return r8.subSequence(Integer.valueOf(r10.f9109a).intValue(), Integer.valueOf(r10.f9110b).intValue() + 1).toString();
    }

    public static String G0(String r8) {
        he.i.f(r8, "<this>");
        he.i.f(r8, "missingDelimiterValue");
        int r10 = r8.lastIndexOf(46, x0(r8));
        if (r10 == (-1)) goto L7;
        String r11 = r8.substring(r10 + 1, r8.length());
        he.i.e(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11;
    L7:
        return r8;
    }

    public static final CharSequence H0(String r8) {
        int r10 = r8.length() - 1;
        int r11 = 0;
        boolean r12 = false;
    L3:
        if (r11 > r10) goto L16;
        if (r12 == true) goto L6;
        int r13 = r11;
    L7:
        boolean r14 = l6.a.i0(r8.charAt(r13));
        if (r12 == false) goto L9;
        if (r14 == false) goto L16;
        r10 = r10 - 1;
        goto L3
    L9:
        if (r14 == false) goto L10;
        r11 = r11 + 1;
        goto L3
    L10:
        r12 = true;
        goto L3
    L6:
        r13 = r10;
    L16:
        return r8.subSequence(r11, r10 + 1);
    }

    public static boolean w0(String r8, String r10) {
        if (A0(r8, r10, 0, false, 2) < 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static final int x0(CharSequence r8) {
        he.i.f(r8, "<this>");
        return r8.length() - 1;
    }

    public static final int y0(int r8, CharSequence r10, String r11, boolean r12) {
        he.i.f(r10, "<this>");
        he.i.f(r11, "string");
        if (r12 == true) goto L9;
        if ((r10 instanceof String) == false) goto L9;
        return ((String) r10).indexOf(r11, r8);
    L9:
        return z0(r10, r11, r8, r10.length(), r12, false);
    }

    public static final int z0(CharSequence r8, CharSequence r10, int r11, int r12, boolean r13, boolean r14) {
        if (r14 == false) goto L5;
        int r15 = x0(r8);
        if (r11 <= r15) goto L14;
        r11 = r15;
    L14:
        if (r12 >= 0) goto L16;
        r12 = 0;
    L16:
        ke.a r16 = new ke.a(r11, r12, -1);
    L17:
        boolean r17 = r8 instanceof String;
        int r18 = r16.f9109a;
        int r19 = r16.f9111m;
        int r110 = r16.f9110b;
        if (r17 == true) goto L20;
    L30:
        if (r19 <= 0) goto L32;
        if (r18 > r110) goto L32;
    L35:
        if (D0(r10, r8, r18, r10.length(), r13) == true) goto L36;
        if (r18 == r110) goto L39;
        r18 = r18 + r19;
    L39:
        return -1;
    L36:
        return r18;
    L32:
        if (r19 >= 0) goto L39;
        if (r110 > r18) goto L39;
    L20:
        if ((r10 instanceof String) == false) goto L30;
        if (r19 <= 0) goto L23;
        if (r18 > r110) goto L23;
    L26:
        if (g.t0(0, r18, r10.length(), (String) r10, (String) r8, r13) == true) goto L27;
        if (r18 == r110) goto L39;
        r18 = r18 + r19;
        goto L26
    L27:
        return r18;
    L23:
        if (r19 >= 0) goto L39;
        if (r110 > r18) goto L39;
    L5:
        if (r11 >= 0) goto L7;
        r11 = 0;
    L7:
        int r20 = r8.length();
        if (r12 <= r20) goto L10;
        r12 = r20;
    L10:
        r16 = new ke.c(r11, r12);
        goto L17
    }
}
