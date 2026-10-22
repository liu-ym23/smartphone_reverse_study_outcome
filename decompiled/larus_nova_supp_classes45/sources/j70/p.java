package j70;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p {
    public static final HashMap<String, String> a = null;

    public static String a(double r3) {
        if (r3 >= 1.0d) goto L8;
        if (r3 < 0) goto L8;
        return "P0";
    L8:
        if (r3 >= 2.0d) goto L11;
        return "P1";
    L11:
        if (r3 >= 3.0d) goto L13;
        return "P2";
    L13:
        return "OTHER";
    }

    static {
        a = new HashMap();
    }
}
