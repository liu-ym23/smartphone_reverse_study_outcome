package wh0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Integer r2, Integer r3) {
        if (r3 != null) goto L6;
    L8:
        if (r2 != null) goto L11;
        return false;
    L11:
        if (r2.intValue() != 30) goto L13;
        return true;
    L13:
        return false;
    L6:
        if (r3.intValue() != 15) goto L8;
        return true;
    }

    public static boolean b(Integer r2, Integer r3) {
        if (r3 != null) goto L6;
    L8:
        if (r2 != null) goto L11;
        return false;
    L11:
        if (r2.intValue() != 35) goto L13;
        return true;
    L13:
        return false;
    L6:
        if (r3.intValue() != 16) goto L8;
        return true;
    }
}
