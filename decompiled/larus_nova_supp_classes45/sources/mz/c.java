package mz;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static boolean b(String r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean a(String r1, String r2) {
        if (b(r1) == true) goto L5;
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.equals(r2) == false) goto L10;
    L9:
        return true;
    L5:
        if (b(r2) == true) goto L9;
        goto L6
    }
}
