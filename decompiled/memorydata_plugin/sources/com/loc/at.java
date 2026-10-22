package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class at {
    public static int a(as r10) {
        ah r2 = null;
    L40:
        th = move-exception;
        th.printStackTrace();
    L46:
        return -1;
    L42:
        th = th;
    L61:
        q.b(th, "leg", "uts");     // Catch: Throwable -> L47
        if (r2 == null) goto L46;
        r2.close();     // Catch: Throwable -> L40
    L54:
    L47:
        th = move-exception;
        if (r2 != null) goto L65;
    L53:
        throw th;
    L65:
        r2.close();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        th.printStackTrace();
        goto L53
    L4:
        if (r10.f.c() == false) goto L37;
        r10.f.a(true);     // Catch: Throwable -> L42
        ah r3 = ah.a(new File(r10.f5328a), r10.f5329b);     // Catch: Throwable -> L42
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L35
        byte[] r6 = a(r3, r10, r5);     // Catch: Throwable -> L35
        if (r6 != null) goto L9;
    L57:
        r3.close();     // Catch: Throwable -> L32
    L34:
        return -1;
    L32:
        th = move-exception;
        th.printStackTrace();
        goto L34
    L9:
        if (r6.length == 0) goto L57;
        p r7 = new p(r6, r10.c);     // Catch: Throwable -> L35
        ak.a();     // Catch: Throwable -> L35
        JSONObject r8 = new JSONObject(new String(ak.a(r7).f5322a));     // Catch: Throwable -> L35
        if (r8.has("code") == true) goto L14;
    L29:
        r2 = r3;
        goto L37
    L14:
        if (r8.getInt("code") != 1) goto L29;
        if (r10.f == null) goto L20;
        if (r6 == null) goto L20;
        r10.f.a(r6.length);     // Catch: Throwable -> L35
    L20:
        if (r10.f.b() >= Integer.MAX_VALUE) goto L59;
        a(r3, r5);     // Catch: Throwable -> L35
    L27:
        return r6.length;
    L59:
        r3.d();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        q.b(th, "ofm", "dlo");     // Catch: Throwable -> L35
    L35:
        th = th;
        r2 = r3;
    L37:
        if (r2 == null) goto L46;
        r2.close();     // Catch: Throwable -> L40
        goto L54
    }

    private static void a(ah r3, List<String> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L16;
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L10
    L6:
        if (r6.hasNext() == false) goto L8;
        r3.c((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        goto L6
    L8:
        r3.close();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        q.b(th, "ofm", "dlo");
        return;
    }

    public static void a(String r4, byte[] r5, as r6) {
        OutputStream r0 = null;
    L23:
        th = th;
        ah r1 = null;
    L25:
        if (r0 != null) goto L42;
    L30:
        if (r1 == null) goto L48;
        r1.close();     // Catch: Throwable -> L33
        throw th;
    L33:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L48:
        throw th;
    L42:
        r0.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
        goto L30
    L4:
        if (a(r6.f5328a, r4) == false) goto L6;
        return;
    L6:
        File r2 = new File(r6.f5328a);     // Catch: Throwable -> L23
        if (r2.exists() == true) goto L9;
        r2.mkdirs();     // Catch: Throwable -> L23
    L9:
        r1 = ah.a(r2, r6.f5329b);     // Catch: Throwable -> L23
        r1.a(r6.d);     // Catch: Throwable -> L21
        byte[] r7 = r6.e.b(r5);     // Catch: Throwable -> L21
        ah.a r8 = r1.b(r4);     // Catch: Throwable -> L21
        r0 = r8.a();     // Catch: Throwable -> L21
        r0.write(r7);     // Catch: Throwable -> L21
        r8.b();     // Catch: Throwable -> L21
        r1.c();     // Catch: Throwable -> L21
        if (r0 == null) goto L44;
        r0.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
    L44:
        r1.close();     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L21:
        th = th;
        goto L25
    }

    private static boolean a(String r2, String r3) {
        return new File(r2, r3 + ".0").exists();
    L4:
        th = move-exception;
        q.b(th, "leg", "fet");
        return false;
    }

    private static byte[] a(ah r8, as r9, List<String> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        File r1 = r8.b();     // Catch: Throwable -> L20
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
        String r7 = r6.split("\\.")[0];     // Catch: Throwable -> L20
        byte[] r12 = ay.a(r8, r7);     // Catch: Throwable -> L20
        r5 = r5 + r12.length;     // Catch: Throwable -> L20
        r11.add(r7);     // Catch: Throwable -> L20
        if (r5 > r9.f.b()) goto L15;
        r9.g.b(r12);     // Catch: Throwable -> L20
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
        q.b(th, "leg", "gCo");
        goto L23
    }
}
