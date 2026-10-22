package po1;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final int a;
    public final byte[] b;
    public final String c;
    public byte[] d;

    public b(int r2, String r3, boolean r4) {
        this.d = null;
        this.a = r2;
        this.c = r3;
        byte[] r5 = a.a;
        this.b = r3.getBytes(Charset.forName("ISO-8859-1"));
        int r6 = 0;
    L4:
        if (r6 >= 4) goto L16;
        byte r7 = this.b[r6];
        if (r7 < 65) goto L15;
        if (r7 > 122) goto L15;
        if (r7 <= 90) goto L13;
        if (r7 < 97) goto L15;
    L13:
        r6 = r6 + 1;
    L15:
        throw new RuntimeException();
    L16:
        if (r4 == false) goto L29;
        byte[] r8 = this.d;
        if (r8 != null) goto L20;
    L21:
        this.d = new byte[this.a];
        return;
    L20:
        if (r8.length < this.a) goto L21;
        return;
    }
}
