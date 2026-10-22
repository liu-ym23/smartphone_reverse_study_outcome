package g9;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean a(String r10) {
        Class.forName(r10);     // Catch: ClassNotFoundException -> L5
        return true;
    L5:
        return false;
    }
}
