package qa;

import com.bytedance.keva.KevaImpl;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class q0 {
    public static void a(String r8, byte[] r10, p0 r11) {
        OutputStream r12 = null;
    L45:
        th = th;
        e0 r13 = null;
    L47:
        if (r12 != null) goto L58;
    L52:
        if (r13 == null) goto L75;
        r13.close();     // Catch: Throwable -> L55
        throw th;
    L55:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L75:
        throw th;
    L58:
        r12.close();     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        th.printStackTrace();
        goto L52
    L73:
        boolean r14 = new File(r11.f10884a, r8 + ".0").exists();     // Catch: Throwable -> L7
    L9:
        if (r14 == false) goto L11;
        return;
    L11:
        File r15 = new File(r11.f10884a);     // Catch: Throwable -> L45
        if (r15.exists() == true) goto L14;
        r15.mkdirs();     // Catch: Throwable -> L45
    L14:
        r13 = e0.i(r15, r11.f10885b);     // Catch: Throwable -> L45
        int r16 = r11.f10887d;     // Catch: Throwable -> L43
        int r17 = 10;
        if (r16 >= 10) goto L18;
    L17:
        r16 = r17;
    L21:
        r13.f10350t = r16;     // Catch: Throwable -> L43
        byte[] r18 = r11.f10888e.b(r10);     // Catch: Throwable -> L43
        e0.d r19 = r13.v(r8);     // Catch: Throwable -> L43
        OutputStream r20 = r19.a();     // Catch: Throwable -> L43
        r20.write(r18);     // Catch: Throwable -> L41
        boolean r21 = r19.f10359c;     // Catch: Throwable -> L41
        e0 r22 = r19.f10360d;     // Catch: Throwable -> L41
        if (r21 == false) goto L25;
        e0.r(r22, r19, false);     // Catch: Throwable -> L41
        r22.x(r19.f10357a.f10363a);     // Catch: Throwable -> L41
    L26:
        monitor-enter(r13);     // Catch: Throwable -> L41
        r13.G();     // Catch: Throwable -> L38
        r13.H();     // Catch: Throwable -> L38
        r13.f10349s.flush();     // Catch: Throwable -> L38
        monitor-exit(r13);     // Catch: Throwable -> L41
        r20.close();     // Catch: Throwable -> L31
    L71:
        r13.close();     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        th.printStackTrace();
        return;
    L31:
        th = move-exception;
        th.printStackTrace();
        goto L71
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L25:
        e0.r(r22, r19, true);     // Catch: Throwable -> L41
    L41:
        th = th;
        r12 = r20;
        goto L47
    L18:
        r17 = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        if (r16 <= 10000) goto L21;
    L43:
        th = th;
        goto L47
    L7:
        th = move-exception;
        q.f("leg", "fet", th);     // Catch: Throwable -> L45
        r14 = false;
        goto L9
    }

    public static void b(p0 r8) {
        e0 r10 = null;
    L39:
        th = move-exception;
        q.f("leg", "uts", th);     // Catch: Throwable -> L51
        if (r10 == null) goto L77;
    L64:
        r10.close();     // Catch: Throwable -> L44
        return;
    L44:
        th = move-exception;
        th.printStackTrace();
        return;
    L77:
        return;
    L51:
        th = move-exception;
        if (r10 != null) goto L68;
    L57:
        throw th;
    L68:
        r10.close();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        th.printStackTrace();
        goto L57
    L4:
        if (r8.f10889f.e() == false) goto L41;
        r8.f10889f.a();     // Catch: Throwable -> L39
        r10 = e0.i(new File(r8.f10884a), r8.f10885b);     // Catch: Throwable -> L39
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L39
        byte[] r12 = c(r10, r8, r11);     // Catch: Throwable -> L39
        if (r12 != null) goto L8;
    L66:
        r10.close();     // Catch: Throwable -> L36
        return;
    L36:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r12.length == 0) goto L66;
        o r13 = new o(r8.f10886c, r12);     // Catch: Throwable -> L39
        h0.c();     // Catch: Throwable -> L39
        JSONObject r14 = new JSONObject(new String(h0.a(r13).f10842a));     // Catch: Throwable -> L39
        if (r14.has("code") == false) goto L41;
        if (r14.getInt("code") != 1) goto L41;
        i1 r15 = r8.f10889f;     // Catch: Throwable -> L39
        if (r15 == null) goto L19;
        r15.b(r12.length);     // Catch: Throwable -> L39
    L19:
        if (r8.f10889f.d() < Integer.MAX_VALUE) goto L60;
        r10.close();     // Catch: Throwable -> L31
        e0.w(r10.f10341a);     // Catch: Throwable -> L31
    L74:
        return;
    L31:
        th = move-exception;
        q.f("ofm", "dlo", th);     // Catch: Throwable -> L39
        return;
    L60:
        Iterator r16 = r11.iterator();     // Catch: Throwable -> L26
    L22:
        if (r16.hasNext() == false) goto L24;
        r10.x((String) r16.next());     // Catch: Throwable -> L26
        goto L22
    L24:
        r10.close();     // Catch: Throwable -> L26
    L72:
        return;
    L26:
        th = move-exception;
        q.f("ofm", "dlo", th);     // Catch: Throwable -> L39
        return;
    L41:
        if (r10 != null) goto L64;
    }

    public static byte[] c(e0 r8, p0 r10, ArrayList r11) {
        File r12 = r8.f10341a;     // Catch: Throwable -> L20
        if (r12 == null) goto L23;
        if (r12.exists() == false) goto L23;
        String[] r13 = r12.list();     // Catch: Throwable -> L20
        int r14 = r13.length;     // Catch: Throwable -> L20
        int r15 = 0;
        int r16 = 0;
    L8:
        if (r15 >= r14) goto L15;
        String r17 = r13[r15];     // Catch: Throwable -> L20
        if (r17.contains(".0") == false) goto L14;
        String r18 = r17.split("\\.")[0];     // Catch: Throwable -> L20
        byte[] r19 = v0.c(r8, r18);     // Catch: Throwable -> L20
        r16 = r16 + r19.length;     // Catch: Throwable -> L20
        r11.add(r18);     // Catch: Throwable -> L20
        if (r16 > r10.f10889f.d()) goto L15;
        r10.f10890g.c(r19);     // Catch: Throwable -> L20
    L14:
        r15 = r15 + 1;     // Catch: Throwable -> L20
    L15:
        if (r16 > 0) goto L18;
        return null;
    L18:
        return r10.f10890g.a();
    L23:
        return new byte[0];
    L20:
        th = move-exception;
        q.f("leg", "gCo", th);
        goto L23
    }
}
