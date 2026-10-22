package p3;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static <T> T a(T r10, String r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(r11 + " must not be null");
    }

    public static void b(boolean r10, String r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(r11);
    }
}
