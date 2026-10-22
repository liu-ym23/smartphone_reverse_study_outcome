package op1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r7) {
        if (r7 != null) goto L5;
        return "";
    L5:
        char[] r8 = r7.toCharArray();
        StringBuffer r0 = new StringBuffer();
        int r1 = r8.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        String r3 = Integer.toHexString(r8[r2]);
        r0.append("\\u");
        if (r3.length() >= 4) goto L10;
        r0.append("0000".substring(r3.length(), 4));
    L10:
        r0.append(r3);
        r2 = r2 + 1;
        goto L6
    L12:
        return r0.toString();
    }
}
