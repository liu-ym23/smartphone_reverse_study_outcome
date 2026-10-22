package n4a;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.jsbridge.LynxResourceModule;
import com.miui.easygo.constant.EasyGoConstant;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o0 {
    public static void b(n0 r7) {
        h0 r1 = null;
    L39:
        th = move-exception;
        r.f(th, "leg", "uts");     // Catch: Throwable -> L51
        if (r1 == null) goto L77;
    L62:
        r1.close();     // Catch: Throwable -> L44
        return;
    L44:
        th = move-exception;
        th.printStackTrace();
        return;
    L77:
        return;
    L51:
        th = move-exception;
        if (r1 != null) goto L68;
    L57:
        throw th;
    L68:
        r1.close();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        th.printStackTrace();
        goto L57
    L4:
        if (r7.f.e() == false) goto L41;
        r7.f.a();     // Catch: Throwable -> L39
        r1 = h0.b(new PolarisFileWrapper(r7.a), r7.b);     // Catch: Throwable -> L39
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L39
        byte[] r3 = c(r1, r7, r2);     // Catch: Throwable -> L39
        if (r3 != null) goto L8;
    L66:
        r1.close();     // Catch: Throwable -> L36
        return;
    L36:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r3.length == 0) goto L66;
        com.loc.a r4 = new com.loc.a(r3, r7.c);     // Catch: Throwable -> L39
        com.loc.c.c();     // Catch: Throwable -> L39
        JSONObject r5 = new JSONObject(new String(com.loc.c.a(r4).a));     // Catch: Throwable -> L39
        if (r5.has(LynxResourceModule.CODE_KEY) == false) goto L41;
        if (r5.getInt(LynxResourceModule.CODE_KEY) != 1) goto L41;
        h1 r0 = r7.f;     // Catch: Throwable -> L39
        if (r0 == null) goto L19;
        r0.b(r3.length);     // Catch: Throwable -> L39
    L19:
        if (r7.f.d() < Integer.MAX_VALUE) goto L60;
        r1.close();     // Catch: Throwable -> L31
        h0.g(r1.a);     // Catch: Throwable -> L31
    L74:
        return;
    L31:
        th = move-exception;
        r.f(th, "ofm", "dlo");     // Catch: Throwable -> L39
        return;
    L60:
        Iterator r8 = r2.iterator();     // Catch: Throwable -> L26
    L22:
        if (r8.hasNext() == false) goto L24;
        r1.h((String) r8.next());     // Catch: Throwable -> L26
        goto L22
    L24:
        r1.close();     // Catch: Throwable -> L26
    L72:
        return;
    L26:
        th = move-exception;
        r.f(th, "ofm", "dlo");     // Catch: Throwable -> L39
        return;
    L41:
        if (r1 != null) goto L62;
    }

    public static void a(String r6, byte[] r7, n0 r8) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        OutputStream r0 = null;
    L45:
        th = th;
        h0 r1 = null;
    L47:
        if (r0 != null) goto L66;
    L52:
        if (r1 == null) goto L75;
        r1.close();     // Catch: Throwable -> L55
        throw th;
    L55:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L75:
        throw th;
    L66:
        r0.close();     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        th.printStackTrace();
        goto L52
    L73:
        boolean r2 = new PolarisFileWrapper(r8.a, r6 + ".0").exists();     // Catch: Throwable -> L7
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        PolarisFileWrapper r3 = new PolarisFileWrapper(r8.a);     // Catch: Throwable -> L45
        if (r3.exists() == true) goto L14;
        r3.mkdirs();     // Catch: Throwable -> L45
    L14:
        r1 = h0.b(r3, r8.b);     // Catch: Throwable -> L45
        int r4 = r8.d;     // Catch: Throwable -> L43
        if (r4 >= 10) goto L19;
        r4 = 10;
    L21:
        r1.j = r4;     // Catch: Throwable -> L43
        byte[] r9 = r8.e.b(r7);     // Catch: Throwable -> L43
        h0.d r10 = r1.f(r6);     // Catch: Throwable -> L43
        OutputStream r11 = r10.a();     // Catch: Throwable -> L43
        r11.write(r9);     // Catch: Throwable -> L41
        if (r10.c == false) goto L25;
        h0.e(r10.d, r10, false);     // Catch: Throwable -> L41
        r10.d.h(r10.a.a);     // Catch: Throwable -> L41
    L26:
        monitor-enter(r1);     // Catch: Throwable -> L41
        r1.p();     // Catch: Throwable -> L38
        r1.q();     // Catch: Throwable -> L38
        r1.i.flush();     // Catch: Throwable -> L38
        monitor-exit(r1);     // Catch: Throwable -> L41
        r11.close();     // Catch: Throwable -> L31
    L64:
        r1.close();     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        th.printStackTrace();
        return;
    L31:
        th = move-exception;
        th.printStackTrace();
        goto L64
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L25:
        h0.e(r10.d, r10, true);     // Catch: Throwable -> L41
    L41:
        th = th;
        r0 = r11;
        goto L47
    L19:
        if (r4 <= 10000) goto L21;
        r4 = 10000;
    L43:
        th = th;
        goto L47
    L7:
        th = move-exception;
        r.f(th, "leg", "fet");     // Catch: Throwable -> L45
        r2 = false;
        goto L9
    }

    public static byte[] c(h0 r8, n0 r9, List<String> r10) {
        File r1 = r8.a;     // Catch: Throwable -> L20
        if (r1 == null) goto L23;
        if (r1.exists() == false) goto L23;
        String[] r2 = r1.list();     // Catch: Throwable -> L20
        int r3 = r2.length;     // Catch: Throwable -> L20
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 >= r3) goto L15;
        String r6 = r2[r4];     // Catch: Throwable -> L20
        if (r6.contains(".0") == false) goto L14;
        String r7 = r6.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN)[0];     // Catch: Throwable -> L20
        byte[] r11 = t0.c(r8, r7);     // Catch: Throwable -> L20
        r5 = r5 + r11.length;     // Catch: Throwable -> L20
        ((ArrayList) r10).add(r7);     // Catch: Throwable -> L20
        if (r5 > r9.f.d()) goto L15;
        r9.g.c(r11);     // Catch: Throwable -> L20
    L14:
        r4 = r4 + 1;     // Catch: Throwable -> L20
    L15:
        if (r5 > 0) goto L18;
        return null;
    L18:
        return r9.g.a();
    L23:
        return new byte[0];
    L20:
        th = move-exception;
        r.f(th, "leg", "gCo");
        goto L23
    }
}
