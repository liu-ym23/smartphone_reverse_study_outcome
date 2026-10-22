package qab;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r2, String r3, String... r4) {
        StringBuilder r0 = new StringBuilder("{\"module\":\"todo\", \"context_id\":\"");
        r0.append(r2);
        r0.append("\", \"api_name\":\"GetParsedRruleTextRequest\", \"api_opt\":\"");
        r0.append(r3);
        r0.append("\"");
        if (r4 == null) goto L8;
        int r5 = 0;
    L6:
        if (r5 >= (r4.length - 1)) goto L8;
        r0.append(", \"");
        int r1 = r5 + 1;
        r0.append(r4[r5]);
        r0.append("\":\"");
        r5 = r1 + 1;
        r0.append(r4[r1]);
        r0.append("\"");
    L8:
        r0.append("}");
        return r0.toString();
    }
}
