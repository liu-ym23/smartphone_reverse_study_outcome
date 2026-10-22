package r5;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static boolean a(String r8, String r10) {
        if (b(r8) == true) goto L5;
    L6:
        if (r8 != null) goto L8;
    L10:
        return false;
    L8:
        if (r8.equals(r10) == false) goto L10;
    L9:
        return true;
    L5:
        if (b(r10) == true) goto L9;
        goto L6
    }

    public static boolean b(String r8) {
        if (r8 != null) goto L4;
        return true;
    L4:
        if (r8.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }
}
