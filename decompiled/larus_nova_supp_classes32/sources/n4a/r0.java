package n4a;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r0 {
    public final Context a;
    public final String b;
    public final String c;
    public final String d;
    public String e;

    public r0(Context r3, String r4, String r5, String r6) throws com.loc.l {
        if (TextUtils.isEmpty(r6) == true) goto L9;
        if (r6.length() > 256) goto L9;
        this.a = r3.getApplicationContext();
        this.c = r4;
        this.d = r5;
        this.b = r6;
        return;
    L9:
        throw new com.loc.l("无效的参数 - IllegalArgumentException");
    }

    public final void a(String r3) throws com.loc.l {
        if (TextUtils.isEmpty(r3) == true) goto L9;
        if (r3.length() > 65536) goto L9;
        this.e = r3;
        return;
    L9:
        throw new com.loc.l("无效的参数 - IllegalArgumentException");
    }

    public final byte[] b() {
        byte[] r1 = new byte[0];
        ByteArrayOutputStream r2 = null;
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: Throwable -> L24
        f5.g(r3, this.c);     // Catch: Throwable -> L22
        f5.g(r3, this.d);     // Catch: Throwable -> L22
        f5.g(r3, this.b);     // Catch: Throwable -> L22
        f5.g(r3, String.valueOf(x4.r(this.a)));     // Catch: Throwable -> L22
        int r4 = (int) (System.currentTimeMillis() / 1000);
    L9:
        r3.write(new byte[]{(byte) ((r4 >> 24) & 255), (byte) ((r4 >> 16) & 255), (byte) ((r4 >> 8) & 255), (byte) (r4 & 255)});     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(this.e) == false) goto L13;
        byte[] r0 = new byte[2];     // Catch: Throwable -> L22
    L12:
        r0 = {x00a8: FILL_ARRAY_DATA  (LINE:168), data: [0, 0} // fill-array;     // Catch: Throwable -> L22
    L17:
        r3.write(r0);     // Catch: Throwable -> L22
        r3.write(f5.j(this.e));     // Catch: Throwable -> L22
        r1 = r3.toByteArray();     // Catch: Throwable -> L22
        r3.close();     // Catch: Throwable -> L20
    L38:
    L28:
        return r1;
    L13:
        byte[] r5 = f5.j(this.e);     // Catch: Throwable -> L22
        if (r5 != null) goto L16;
        r0 = new byte[2];     // Catch: Throwable -> L22
        goto L12
    L16:
        r0 = f5.i(r5.length);     // Catch: Throwable -> L22
    L7:
        r4 = 0;
    L22:
        th = th;
        r2 = r3;
    L43:
        r.f(th, "se", "tds");     // Catch: Throwable -> L29
        if (r2 == null) goto L28;
        r2.close();     // Catch: Throwable -> L20
    L29:
        th = move-exception;
        if (r2 != null) goto L36;
    L35:
        throw th;
    L36:
        r2.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.printStackTrace();
    L20:
        th = move-exception;
        th.printStackTrace();
    L24:
        th = th;
        goto L43
    }
}
