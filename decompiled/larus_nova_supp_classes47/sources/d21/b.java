package d21;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public b() {
    }

    public static String a(String r3) {
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return r3;
    L9:
        if (r3.length() > 5) goto L12;
        return r3;
    L12:
        return r3.substring(0, 5) + "...";
    L5:
        r0 = false;
        goto L6
    }
}
