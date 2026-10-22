package tsc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g {
    public g() {
    }

    public static String a(m r2) {
        String r0 = r2.a;
        if ("br".equals(r0) == false) goto L6;
        return "\n";
    L6:
        if ("img".equals(r0) == false) goto L13;
        String r3 = r2.b().get("alt");
        if (r3 != null) goto L10;
    L11:
        return "￼";
    L10:
        if (r3.length() == 0) goto L11;
        return r3;
    L13:
        if ("iframe".equals(r0) == false) goto L15;
        return " ";
    L15:
        return null;
    }
}
