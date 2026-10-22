package ms.bd.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class b4 {
    public static final /* synthetic */ int a = 0;

    static {
        String r0 = (String) p2.a(16777217, 0, 0, "3f539c", new byte[]{25, 56, 7, 25, 59});
    }

    public static String a(String r2) {
        if (r2 != null) goto L4;
        return "";
    L4:
        if (r2.length() > 0) goto L7;
        return "";
    L7:
        return r2.trim().replace('\'', ' ').replace('\"', ' ').replace('\r', ' ').replace('\n', ' ');
    }
}
