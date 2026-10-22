package bytekn.foundation.encryption;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public static final String a(byte[] r7) {
        String r0 = d0.b.a;
        StringBuilder r2 = new StringBuilder(r7.length * 2);
        int r1 = r7.length;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L6;
        int r5 = r7[r4] & 255;
        r2.append(r0.charAt((r5 >>> 4) & 15));
        r2.append(r0.charAt((r5 >>> 0) & 15));
        r4 = r4 + 1;
        goto L3
    L6:
        return r2.toString();
    }
}
