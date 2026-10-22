package n4a;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p0 {
    public final Context a;
    public final e5 b;
    public final String c;

    public p0(Context r1, e5 r2, String r3) {
        this.a = r1.getApplicationContext();
        this.b = r2;
        this.c = r3;
    }

    public final byte[] a() {
        Context r0 = this.a;
        e5 r1 = this.b;
        String r2 = this.c;
        StringBuilder r3 = new StringBuilder();
        r3.append("\"sdkversion\":\"");     // Catch: Throwable -> L10
        r3.append(r1.b());     // Catch: Throwable -> L10
        r3.append("\",\"product\":\"");     // Catch: Throwable -> L10
        r3.append(r1.a());     // Catch: Throwable -> L10
        r3.append("\",\"nt\":\"");     // Catch: Throwable -> L10
        int r4 = x4.d(r0);     // Catch: Throwable -> L6
    L8:
        r3.append(r4);     // Catch: Throwable -> L10
        r3.append("\",\"details\":");     // Catch: Throwable -> L10
        r3.append(r2);     // Catch: Throwable -> L10
    L13:
        return f5.j(r3.toString());
    L6:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L10
        r4 = -1;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }
}
