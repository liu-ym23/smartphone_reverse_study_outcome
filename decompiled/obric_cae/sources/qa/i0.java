package qa;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class i0 extends n4 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f10516k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final s4 f10517l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f10518m;

    public i0(Context r8, s4 r10) {
        if (r8 == null) goto L5;
        this.f10516k = r8.getApplicationContext();
    L5:
        this.f10517l = r10;
        this.f10799c = true;
    }

    public static byte[] l() {
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();
        r8.write(t4.i("PANDORA$"));     // Catch: Throwable -> L9
        r8.write(new byte[]{1});     // Catch: Throwable -> L9
        r8.write(new byte[]{0});     // Catch: Throwable -> L9
        byte[] r10 = r8.toByteArray();     // Catch: Throwable -> L9
        r8.close();     // Catch: Throwable -> L6
    L8:
        return r10;
    L6:
        th = move-exception;
        l.a("bre", "gbh", th);
    L9:
        th = move-exception;
        l.a("bre", "gbh", th);     // Catch: Throwable -> L17
        r8.close();     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        l.a("bre", "gbh", th);
        return null;
    L17:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        l.a("bre", "gbh", th);
        goto L22
    }

    @Override // qa.m0
    public Map<String, String> h() {
        Context r8 = this.f10516k;
        String r10 = h4.g(r8);
        String r11 = j4.a();
        String r12 = j4.b(r8, r11, "key=".concat(String.valueOf(r10)));
        HashMap r13 = new HashMap();
        r13.put("ts", r11);
        r13.put("key", r10);
        r13.put("scode", r12);
        return r13;
    }

    @Override // qa.m0
    public final byte[] i() {
        byte[] r8 = this.f10518m;
        if (r8 == null) goto L5;
        return r8;
    L5:
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        r10.write(l());     // Catch: Throwable -> L12
        r10.write(m());     // Catch: Throwable -> L12
        r10.write(n());     // Catch: Throwable -> L12
        r10.write(o());     // Catch: Throwable -> L12
        byte[] r11 = r10.toByteArray();     // Catch: Throwable -> L12
        this.f10518m = r11;     // Catch: Throwable -> L12
        r10.close();     // Catch: Throwable -> L9
    L11:
        return r11;
    L9:
        th = move-exception;
        l.a("bre", "geb", th);
    L12:
        th = move-exception;
        l.a("bre", "geb", th);     // Catch: Throwable -> L20
        r10.close();     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        l.a("bre", "geb", th);
        return null;
    L20:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L23
    L25:
        throw th;
    L23:
        th = move-exception;
        l.a("bre", "geb", th);
        goto L25
    }

    public final byte[] m() {
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();
        r8.write(new byte[]{3});     // Catch: Throwable -> L16
        if (s() == false) goto L18;
        Context r10 = this.f10516k;     // Catch: Throwable -> L16
        boolean r11 = u();     // Catch: Throwable -> L16
        s4 r12 = this.f10517l;     // Catch: Throwable -> L16
        if (r12 != null) goto L8;
    L10:
        boolean r13 = false;
    L60:
        byte[] r14 = j4.e(j4.d(r10, r11, r13));     // Catch: Throwable -> L13
    L15:
        r8.write(t4.h(r14.length));     // Catch: Throwable -> L16
        r8.write(r14);     // Catch: Throwable -> L16
    L19:
        byte[] r15 = t4.i(r());     // Catch: Throwable -> L16
        if (r15 != null) goto L22;
    L24:
        r8.write(new byte[]{0, 0});     // Catch: Throwable -> L16
    L25:
        byte[] r16 = t4.i(t());     // Catch: Throwable -> L16
        if (r16 != null) goto L28;
    L30:
        r8.write(new byte[]{0, 0});     // Catch: Throwable -> L16
    L31:
        byte[] r17 = r8.toByteArray();     // Catch: Throwable -> L16
        r8.close();     // Catch: Throwable -> L34
    L36:
        return r17;
    L34:
        th = move-exception;
        l.a("bre", "gred", th);
        goto L36
    L28:
        if (r16.length <= 0) goto L30;
        r8.write(t4.h(r16.length));     // Catch: Throwable -> L16
        r8.write(r16);     // Catch: Throwable -> L16
        goto L31
    L22:
        if (r15.length <= 0) goto L24;
        r8.write(t4.h(r15.length));     // Catch: Throwable -> L16
        r8.write(r15);     // Catch: Throwable -> L16
        goto L25
    L13:
        th = move-exception;
        l.a("CI", "gz", th);     // Catch: Throwable -> L16
        r14 = null;
        goto L15
    L8:
        if ("navi".equals(r12.a()) == false) goto L10;
        r13 = true;
        goto L60
    L18:
        r8.write(new byte[]{0, 0});     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        l.a("bre", "gpd", th);     // Catch: Throwable -> L44
        r8.close();     // Catch: Throwable -> L40
    L43:
        return new byte[]{0};
    L40:
        th = move-exception;
        l.a("bre", "gred", th);
    L44:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L47
    L49:
        throw th;
    L47:
        th = move-exception;
        l.a("bre", "gred", th);
        goto L49
    }

    public final byte[] n() {
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();
        byte[] r10 = p();     // Catch: Throwable -> L14
        if (r10 != null) goto L6;
    L16:
        r8.write(new byte[]{0});     // Catch: Throwable -> L14
        byte[] r11 = r8.toByteArray();     // Catch: Throwable -> L14
        r8.close();     // Catch: Throwable -> L19
    L21:
        return r11;
    L19:
        th = move-exception;
        l.a("bre", "grrd", th);
        goto L21
    L6:
        if (r10.length == 0) goto L16;
        r8.write(new byte[]{1});     // Catch: Throwable -> L14
        r8.write(t4.h(r10.length));     // Catch: Throwable -> L14
        r8.write(r10);     // Catch: Throwable -> L14
        byte[] r12 = r8.toByteArray();     // Catch: Throwable -> L14
        r8.close();     // Catch: Throwable -> L11
    L13:
        return r12;
    L11:
        th = move-exception;
        l.a("bre", "grrd", th);
    L14:
        th = move-exception;
        l.a("bre", "grrd", th);     // Catch: Throwable -> L29
        r8.close();     // Catch: Throwable -> L25
    L28:
        return new byte[]{0};
    L25:
        th = move-exception;
        l.a("bre", "grrd", th);
    L29:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L32
    L34:
        throw th;
    L32:
        th = move-exception;
        l.a("bre", "grrd", th);
        goto L34
    }

    public final byte[] o() {
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();
        byte[] r10 = q();     // Catch: Throwable -> L14
        if (r10 != null) goto L6;
    L16:
        r8.write(new byte[]{0});     // Catch: Throwable -> L14
        byte[] r11 = r8.toByteArray();     // Catch: Throwable -> L14
        r8.close();     // Catch: Throwable -> L19
    L21:
        return r11;
    L19:
        th = move-exception;
        l.a("bre", "gred", th);
        goto L21
    L6:
        if (r10.length == 0) goto L16;
        r8.write(new byte[]{1});     // Catch: Throwable -> L14
        byte[] r12 = l4.a(r10);     // Catch: Throwable -> L14
        r8.write(t4.h(r12.length));     // Catch: Throwable -> L14
        r8.write(r12);     // Catch: Throwable -> L14
        byte[] r13 = r8.toByteArray();     // Catch: Throwable -> L14
        r8.close();     // Catch: Throwable -> L11
    L13:
        return r13;
    L11:
        th = move-exception;
        l.a("bre", "gred", th);
    L14:
        th = move-exception;
        l.a("bre", "gred", th);     // Catch: Throwable -> L29
        r8.close();     // Catch: Throwable -> L25
    L28:
        return new byte[]{0};
    L25:
        th = move-exception;
        l.a("bre", "gred", th);
    L29:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L32
    L34:
        throw th;
    L32:
        th = move-exception;
        l.a("bre", "gred", th);
        goto L34
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
        s4 r8 = this.f10517l;
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{r8.b(), r8.a()});
    }

    public boolean u() {
        return false;
    }
}
