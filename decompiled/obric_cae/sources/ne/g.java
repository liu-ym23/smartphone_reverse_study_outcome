package ne;

import java.util.Collection;
import java.util.Iterator;
import yd.n;

/* JADX INFO: loaded from: classes2.dex */
public class g extends f {
    public static final boolean r0(String r8, String r10) {
        if (r8 != null) goto L8;
        if (r10 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r8.equalsIgnoreCase(r10);
    }

    public static final boolean s0(CharSequence r8) {
        he.i.f(r8, "<this>");
        if (r8.length() == 0) goto L22;
        Iterable r10 = new ke.c(0, r8.length() - 1);
        if ((r10 instanceof Collection) == true) goto L7;
    L9:
        Iterator r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L8;
        if (l6.a.i0(r8.charAt(((n) r11).nextInt())) == true) goto L11;
        boolean r12 = false;
    L15:
        if (r12 == false) goto L18;
        return true;
    L18:
        return false;
    L8:
        r12 = true;
        goto L15
    L7:
        if (((Collection) r10).isEmpty() == false) goto L9;
    L22:
        return true;
    }

    public static final boolean t0(int r8, int r10, int r11, String r12, String r13, boolean r14) {
        he.i.f(r12, "<this>");
        he.i.f(r13, "other");
        if (r14 == true) goto L6;
        return r12.regionMatches(r8, r13, r10, r11);
    L6:
        return r12.regionMatches(r14, r8, r13, r10, r11);
    }

    public static String u0(String r8, String r10, String r11) {
        int r12 = j.y0(0, r8, r10, false);
        if (r12 < 0) goto L23;
        int r13 = r10.length();
        int r14 = 1;
        if (r13 < 1) goto L9;
        r14 = r13;
    L9:
        int r15 = r11.length() + (r8.length() - r13);
        if (r15 < 0) goto L19;
        StringBuilder r16 = new StringBuilder(r15);
        int r17 = 0;
    L12:
        r16.append(r8, r17, r12);
        r16.append(r11);
        r17 = r12 + r13;
        if (r12 >= r8.length()) goto L16;
        r12 = j.y0(r12 + r14, r8, r10, false);
        if (r12 > 0) goto L12;
    L16:
        r16.append(r8, r17, r8.length());
        String r18 = r16.toString();
        he.i.e(r18, "stringBuilder.append(this, i, length).toString()");
        return r18;
    L19:
        throw new OutOfMemoryError();
    L23:
        return r8;
    }

    public static boolean v0(String r8, String r10) {
        he.i.f(r8, "<this>");
        return r8.startsWith(r10);
    }
}
