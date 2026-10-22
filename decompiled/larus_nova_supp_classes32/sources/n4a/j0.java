package n4a;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class j0 extends a5 {
    public final Context k;
    public final e5 l;
    public byte[] m;

    public static byte[] l() {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        r2.write(f5.j("PANDORA$"));     // Catch: Throwable -> L9
        r2.write(new byte[]{1});     // Catch: Throwable -> L9
        r2.write(new byte[]{0});     // Catch: Throwable -> L9
        byte[] r3 = r2.toByteArray();     // Catch: Throwable -> L9
        r2.close();     // Catch: Throwable -> L6
    L8:
        return r3;
    L6:
        th = move-exception;
        n.a(th, "bre", "gbh");
    L9:
        th = move-exception;
        n.a(th, "bre", "gbh");     // Catch: Throwable -> L17
        r2.close();     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        n.a(th, "bre", "gbh");
        return null;
    L17:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        n.a(th, "bre", "gbh");
        goto L22
    }

    @Override // com.loc.bo
    public Map<String, String> h() {
        String r0 = v4.g(this.k);
        String r1 = w4.a();
        String r2 = w4.b(this.k, r1, "key=".concat(String.valueOf(r0)));
        HashMap r3 = new HashMap();
        r3.put("ts", r1);
        r3.put("key", r0);
        r3.put("scode", r2);
        return r3;
    }

    @Override // com.loc.bo
    public final byte[] i() {
        byte[] r2 = this.m;
        if (r2 == null) goto L5;
        return r2;
    L5:
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();
        r3.write(l());     // Catch: Throwable -> L12
        r3.write(m());     // Catch: Throwable -> L12
        r3.write(n());     // Catch: Throwable -> L12
        r3.write(o());     // Catch: Throwable -> L12
        byte[] r4 = r3.toByteArray();     // Catch: Throwable -> L12
        this.m = r4;     // Catch: Throwable -> L12
        r3.close();     // Catch: Throwable -> L9
    L11:
        return r4;
    L9:
        th = move-exception;
        n.a(th, "bre", "geb");
    L12:
        th = move-exception;
        n.a(th, "bre", "geb");     // Catch: Throwable -> L20
        r3.close();     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        n.a(th, "bre", "geb");
        return null;
    L20:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L23
    L25:
        throw th;
    L23:
        th = move-exception;
        n.a(th, "bre", "geb");
        goto L25
    }

    public abstract byte[] p();

    public abstract byte[] q();

    public String r() {
        return "2.1";
    }

    public boolean s() {
        return true;
    }

    public String t() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.l.b(), this.l.a()});
    }

    public boolean u() {
        return false;
    }

    public final byte[] m() {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        r2.write(new byte[]{3});     // Catch: Throwable -> L16
        if (s() == false) goto L18;
        Context r5 = this.k;     // Catch: Throwable -> L16
        boolean r7 = u();     // Catch: Throwable -> L16
        e5 r8 = this.l;     // Catch: Throwable -> L16
        if (r8 != null) goto L8;
    L10:
        boolean r9 = false;
    L58:
        byte[] r6 = w4.e(w4.d(r5, r7, r9));     // Catch: Throwable -> L13
    L15:
        r2.write(f5.i(r6.length));     // Catch: Throwable -> L16
        r2.write(r6);     // Catch: Throwable -> L16
    L19:
        byte[] r10 = f5.j(r());     // Catch: Throwable -> L16
        if (r10 != null) goto L22;
    L24:
        r2.write(new byte[]{0, 0});     // Catch: Throwable -> L16
    L25:
        byte[] r11 = f5.j(t());     // Catch: Throwable -> L16
        if (r11 != null) goto L28;
    L30:
        r2.write(new byte[]{0, 0});     // Catch: Throwable -> L16
    L31:
        byte[] r3 = r2.toByteArray();     // Catch: Throwable -> L16
        r2.close();     // Catch: Throwable -> L34
    L36:
        return r3;
    L34:
        th = move-exception;
        n.a(th, "bre", "gred");
        goto L36
    L28:
        if (r11.length <= 0) goto L30;
        r2.write(f5.i(r11.length));     // Catch: Throwable -> L16
        r2.write(r11);     // Catch: Throwable -> L16
        goto L31
    L22:
        if (r10.length <= 0) goto L24;
        r2.write(f5.i(r10.length));     // Catch: Throwable -> L16
        r2.write(r10);     // Catch: Throwable -> L16
        goto L25
    L13:
        th = move-exception;
        n.a(th, "CI", "gz");     // Catch: Throwable -> L16
        r6 = null;
        goto L15
    L8:
        if ("navi".equals(r8.a()) == false) goto L10;
        r9 = true;
        goto L58
    L18:
        r2.write(new byte[]{0, 0});     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        n.a(th, "bre", "gpd");     // Catch: Throwable -> L44
        r2.close();     // Catch: Throwable -> L40
    L43:
        return new byte[]{0};
    L40:
        th = move-exception;
        n.a(th, "bre", "gred");
    L44:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L47
    L49:
        throw th;
    L47:
        th = move-exception;
        n.a(th, "bre", "gred");
        goto L49
    }

    public final byte[] n() {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        byte[] r5 = p();     // Catch: Throwable -> L14
        if (r5 != null) goto L6;
    L16:
        r2.write(new byte[]{0});     // Catch: Throwable -> L14
        byte[] r3 = r2.toByteArray();     // Catch: Throwable -> L14
        r2.close();     // Catch: Throwable -> L19
    L21:
        return r3;
    L19:
        th = move-exception;
        n.a(th, "bre", "grrd");
        goto L21
    L6:
        if (r5.length == 0) goto L16;
        r2.write(new byte[]{1});     // Catch: Throwable -> L14
        r2.write(f5.i(r5.length));     // Catch: Throwable -> L14
        r2.write(r5);     // Catch: Throwable -> L14
        byte[] r4 = r2.toByteArray();     // Catch: Throwable -> L14
        r2.close();     // Catch: Throwable -> L11
    L13:
        return r4;
    L11:
        th = move-exception;
        n.a(th, "bre", "grrd");
    L14:
        th = move-exception;
        n.a(th, "bre", "grrd");     // Catch: Throwable -> L29
        r2.close();     // Catch: Throwable -> L25
    L28:
        return new byte[]{0};
    L25:
        th = move-exception;
        n.a(th, "bre", "grrd");
    L29:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L32
    L34:
        throw th;
    L32:
        th = move-exception;
        n.a(th, "bre", "grrd");
        goto L34
    }

    public final byte[] o() {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        byte[] r5 = q();     // Catch: Throwable -> L14
        if (r5 != null) goto L6;
    L16:
        r2.write(new byte[]{0});     // Catch: Throwable -> L14
        byte[] r3 = r2.toByteArray();     // Catch: Throwable -> L14
        r2.close();     // Catch: Throwable -> L19
    L21:
        return r3;
    L19:
        th = move-exception;
        n.a(th, "bre", "gred");
        goto L21
    L6:
        if (r5.length == 0) goto L16;
        r2.write(new byte[]{1});     // Catch: Throwable -> L14
        byte[] r6 = y4.a(r5);     // Catch: Throwable -> L14
        r2.write(f5.i(r6.length));     // Catch: Throwable -> L14
        r2.write(r6);     // Catch: Throwable -> L14
        byte[] r4 = r2.toByteArray();     // Catch: Throwable -> L14
        r2.close();     // Catch: Throwable -> L11
    L13:
        return r4;
    L11:
        th = move-exception;
        n.a(th, "bre", "gred");
    L14:
        th = move-exception;
        n.a(th, "bre", "gred");     // Catch: Throwable -> L29
        r2.close();     // Catch: Throwable -> L25
    L28:
        return new byte[]{0};
    L25:
        th = move-exception;
        n.a(th, "bre", "gred");
    L29:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L32
    L34:
        throw th;
    L32:
        th = move-exception;
        n.a(th, "bre", "gred");
        goto L34
    }

    public j0(Context r1, e5 r2) {
        if (r1 == null) goto L5;
        this.k = r1.getApplicationContext();
    L5:
        this.l = r2;
        this.c = true;
    }
}
