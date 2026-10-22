package j1;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static boolean a(String r10, long r11, long r12) {
        if (r12 > 0) goto L5;
        return true;
    L5:
        if (r12 <= r11) goto L8;
        return true;
    L8:
        if (((a.g(r10).longValue() >>> 32) % (r11 / r12)) == 0) goto L14;
        return false;
    L14:
        return true;
    }
}
