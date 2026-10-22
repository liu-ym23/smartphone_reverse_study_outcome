package o1;

/* JADX INFO: loaded from: classes.dex */
public class k {
    public static Class<?> a(String r10) {
        return Class.forName(r10);
    L4:
        return null;
    }

    public static boolean b(String r10) {
        if (a(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
