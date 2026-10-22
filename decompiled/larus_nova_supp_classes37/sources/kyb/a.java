package kyb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Object... r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        Object r3 = r5[r2];
        r0.append(" ");
        if (r3 == null) goto L7;
        r0.append(r3);
    L8:
        r2 = r2 + 1;
        goto L3
    L7:
        r0.append("null");
        goto L8
    L10:
        return r0.toString();
    }
}
