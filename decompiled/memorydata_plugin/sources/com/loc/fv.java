package com.loc;

import android.content.Context;
import android.database.Cursor;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class fv {
    private static String a() {
        String r0 = Proxy.getDefaultHost();     // Catch: Throwable -> L4
    L6:
        if (r0 != null) goto L11;
        return "null";
    L11:
        return r0;
    L4:
        th = move-exception;
        q.b(th, "pu", "gdh");
        r0 = null;
        goto L6
    }

    private static String a(String r0) {
        return fx.c(r0);
    }

    public static java.net.Proxy a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        q.b(th, "pu", "gp");
        return null;
    L4:
        if (Build.VERSION.SDK_INT < 11) goto L6;
        java.net.Proxy r4 = a(r3, new URI("http://restsdk.amap.com"));     // Catch: Throwable -> L8
    L11:
        return r4;
    L6:
        r4 = b(r3);     // Catch: Throwable -> L8
        goto L11
    }

    private static java.net.Proxy a(Context r2, URI r3) {
        if (c((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")) == true) goto L18;
    L17:
        return null;
    L18:
        List<java.net.Proxy> r4 = ProxySelector.getDefault().select(r3);     // Catch: Throwable -> L15
        if (r4 != null) goto L7;
        return null;
    L7:
        if (r4.isEmpty() == true) goto L21;
        java.net.Proxy r5 = (java.net.Proxy) ZeusTransformUtils.preCheckCast(r4.get(0), java.net.Proxy.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r5 == null) goto L22;
        if (r5.type() != java.net.Proxy.Type.DIRECT) goto L14;
        return null;
    L14:
        return r5;
    L22:
        return null;
    L21:
        return null;
    L15:
        th = move-exception;
        q.b(th, "pu", "gpsc");
        goto L17
    }

    private static int b() {
        return Proxy.getDefaultPort();
    L4:
        th = move-exception;
        q.b(th, "pu", "gdp");
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.content.ContentResolver, android.database.Cursor, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [int] */
    /* JADX WARN: Type inference failed for: r11v9, types: [int] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v13 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r17v9 */
    private static java.net.Proxy b(Context r20) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        if (c(r8) == false) goto L125;
        Uri r11 = Uri.parse("content://telephony/carriers/preferapn");
        ?? r10 = r8.getContentResolver();
        String r12 = null;
        ?? r17 = 80;
        r17 = 80;
        r17 = 80;
        r17 = 80;
        r17 = 80;
        boolean r18 = false;
        Cursor r13 = ZeusProviderTransform.query(r10, r11, null, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63 SecurityException -> L72
        if (r13 != null) goto L139;
    L55:
        r17 = -1;
        r12 = null;
    L56:
        if (r13 != null) goto L134;
    L62:
        ?? r14 = r17;
    L106:
        if (r12 != null) goto L128;
    L113:
        if (r18 == false) goto L143;
        return new java.net.Proxy(java.net.Proxy.Type.HTTP, InetSocketAddress.createUnresolved(r12, r14));
    L111:
        th = move-exception;
        n.a(th, "pu", "gp2");
        th.printStackTrace();
        return null;
    L143:
        return null;
    L128:
        if (r12.length() <= 0) goto L113;
        if (r14 == (-1)) goto L113;
        r18 = true;
        goto L113
    L134:
        r13.close();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        Throwable r1 = th;
        r17 = r17;
    L61:
        q.b(r1, "pu", "gPx2");
        goto L62
    L139:
    L53:
        e = e;
        ?? r15 = -1;
    L74:
        r12 = null;
    L75:
        q.b(e, "pu", "ghp");     // Catch: Throwable -> L117
        String r0 = fp.l(r8);     // Catch: Throwable -> L117
        if (r0 == null) goto L100;
        String r2 = r0.toLowerCase(Locale.US);     // Catch: Throwable -> L117
        String r9 = a();     // Catch: Throwable -> L117
        r15 = b();     // Catch: Throwable -> L117
        if (r2.indexOf("ctwap") == (-1)) goto L90;
        if (TextUtils.isEmpty(r9) == false) goto L82;
    L84:
        boolean r3 = false;
    L85:
        if (r3 == true) goto L87;
        r12 = a("QMTAuMC4wLjIwMA==");     // Catch: Throwable -> L117
    L87:
        if (r15 != (-1)) goto L100;
    L101:
        if (r13 == null) goto L62;
        r13.close();     // Catch: Throwable -> L104
    L104:
        th = move-exception;
        r1 = th;
        r17 = r17;
        goto L61
    L82:
        if (r9.equals("null") == true) goto L84;
        r12 = r9;
        r3 = true;
        goto L85
    L90:
        if (r2.indexOf("wap") == (-1)) goto L100;
        if (TextUtils.isEmpty(r9) == false) goto L94;
    L96:
        boolean r4 = false;
    L97:
        if (r4 == true) goto L101;
        r12 = a("QMTAuMC4wLjE3Mg==");     // Catch: Throwable -> L117
        goto L101
    L94:
        if (r9.equals("null") == true) goto L96;
        r12 = r9;
        r4 = true;
    L100:
        r17 = r15;
    L51:
        th = th;
        r15 = -1;
    L65:
        r12 = null;
    L66:
        q.b(th, "pu", "gPx1");     // Catch: Throwable -> L117
        th.printStackTrace();     // Catch: Throwable -> L117
        r14 = r15;
        if (r13 == null) goto L106;
        r13.close();     // Catch: Throwable -> L70
        r14 = r15;
    L70:
        th = move-exception;
        q.b(th, "pu", "gPx2");
        r14 = r15;
        goto L106
    L8:
        if (r13.moveToFirst() == false) goto L55;
        String r5 = r13.getString(r13.getColumnIndex("apn"));     // Catch: Throwable -> L51 SecurityException -> L53
        String r6 = r5;
        r15 = r11;
        if (r5 == null) goto L138;
        Locale r16 = Locale.US;     // Catch: Throwable -> L51 SecurityException -> L53
        r6 = r5.toLowerCase(r16);     // Catch: Throwable -> L51 SecurityException -> L53
        r15 = r16;
    L138:
        if (r6 != null) goto L14;
    L35:
        if (r6 == null) goto L55;
        if (r6.contains("wap") == false) goto L55;
        String r7 = a();     // Catch: Throwable -> L51 SecurityException -> L53
        int r19 = b();     // Catch: Throwable -> L51 SecurityException -> L53
        if (TextUtils.isEmpty(r7) == false) goto L42;
    L44:
        boolean r21 = false;
        r12 = null;
    L45:
        if (r21 == false) goto L47;
    L48:
        if (r19 == (-1)) goto L56;
    L50:
        r17 = r19;
        goto L56
    L47:
        r12 = a("QMTAuMC4wLjE3Mg==");     // Catch: Throwable -> L25 SecurityException -> L27
        goto L48
    L42:
        if (r7.equals("null") == true) goto L44;
        r12 = r7;
        r21 = true;
        goto L45
    L14:
        if (r6.contains("ctwap") == false) goto L35;
        String r22 = a();     // Catch: Throwable -> L51 SecurityException -> L53
        r19 = b();     // Catch: Throwable -> L51 SecurityException -> L53
        if (TextUtils.isEmpty(r22) == false) goto L19;
    L21:
        boolean r23 = false;
        r12 = null;
    L22:
        if (r23 == true) goto L29;
        r12 = a("QMTAuMC4wLjIwMA==");     // Catch: Throwable -> L25 SecurityException -> L27
    L29:
        if (r19 != (-1)) goto L50;
    L19:
        if (r22.equals("null") == true) goto L21;
        r12 = r22;
        r23 = true;
    L27:
        e = e;
    L25:
        th = th;
    L33:
        e = e;
    L31:
        th = th;
        goto L65
    L117:
        th = move-exception;
        if (r10 == 0) goto L141;
        r10.close();     // Catch: Throwable -> L122
        throw th;
    L122:
        th = move-exception;
        q.b(th, "pu", "gPx2");
        throw th;
    L141:
        throw th;
    L72:
        e = e;
        r15 = -1;
        r13 = null;
    L63:
        th = th;
        r15 = -1;
        r13 = null;
        goto L65
    L125:
        return null;
    }

    private static boolean c(Context r2) {
        if (fp.j((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")) != 0) goto L6;
        return true;
    L6:
        return false;
    }
}
