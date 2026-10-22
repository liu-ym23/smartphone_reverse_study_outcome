package com.tom_roush.pdfbox.a;

import java.io.IOException;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes6.dex */
public abstract class k extends b {

    @Deprecated
    public static final h g = null;

    @Deprecated
    public static final h h = null;

    static {
        g = h.f16054a;
        h = h.f16055b;
    }

    public k() {
    }

    public static k a(String r6) {
        if (r6.length() != 1) goto L20;
        char r0 = r6.charAt(0);
        if ('0' > r0) goto L11;
        if (r0 > '9') goto L11;
        return h.a(((long) r0) - 48);
    L11:
        if (r0 == '-') goto L18;
        if (r0 == '.') goto L18;
        throw new IOException("Not a number: " + r6);
    L18:
        return h.f16054a;
    L20:
        if (b(r6) == true) goto L22;
        if (r6.charAt(0) != '+') goto L28;
        return h.a(Long.parseLong(r6.substring(1)));
    L28:
        return h.a(Long.parseLong(r6));
    L30:
        if (r6.startsWith(Marker.ANY_NON_NULL_MARKER) == false) goto L32;
    L35:
        String r1 = r6.substring(1);
    L37:
        if (r1.matches("[0-9]*") == false) goto L44;
        if (r6.startsWith("-") == false) goto L42;
        return h.f;
    L42:
        return h.e;
    L44:
        throw new IOException("Not a number: " + r6);
    L32:
        if (r6.startsWith("-") == true) goto L35;
        r1 = r6;
        goto L37
    L22:
        return new f(r6);
    }

    private static boolean b(String r5) {
        int r0 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        char r3 = r5.charAt(r2);
        if (r3 == '.') goto L10;
        if (r3 == 'e') goto L16;
        r2 = r2 + 1;
        goto L3
    L16:
        return true;
    L10:
        return true;
    L12:
        return false;
    }

    public abstract float a();

    public abstract long b();

    public abstract int c();
}
