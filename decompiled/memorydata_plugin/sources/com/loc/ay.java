package com.loc;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class ay {
    public static as a(WeakReference<as> r2) {
        if (r2 != null) goto L4;
    L5:
        r2 = new WeakReference(new as());
    L7:
        return (as) ZeusTransformUtils.preCheckCast(r2.get(), as.class, "com.obric.memorydata.plugin");
    L4:
        if (r2.get() != null) goto L7;
        goto L5
    }

    public static String a() {
        return fx.a(System.currentTimeMillis());
    }

    public static String a(Context r3, fw r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        String r1 = fp.e();     // Catch: Throwable -> L5
        r0.append("\"sim\":\"").append(r1).append("\",\"sdkversion\":\"").append(r4.c()).append("\",\"product\":\"").append(r4.a()).append("\",\"ed\":\"").append(r4.d()).append("\",\"nt\":\"").append(fp.c(r5)).append("\",\"np\":\"").append(fp.b(r5)).append("\",\"mnc\":\"").append(fp.d()).append("\",\"ant\":\"").append(fp.d(r5)).append("\"");     // Catch: Throwable -> L5
    L8:
        return r0.toString();
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    public static String a(String r2, String r3, int r4, String r5, String r6) {
        StringBuffer r0 = new StringBuffer();
        r0.append(r2).append(",\"timestamp\":\"");
        r0.append(r3);
        r0.append("\",\"et\":\"");
        r0.append(r4);
        r0.append("\",\"classname\":\"");
        r0.append(r5);
        r0.append("\",");
        r0.append("\"detail\":\"");
        r0.append(r6);
        r0.append("\"");
        return r0.toString();
    }

    public static void a(Context r2, as r3, String r4, int r5, int r6, String r7) {
        r3.f5328a = o.c((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r4);
        r3.d = r5;
        r3.f5329b = r6;
        r3.c = r7;
    }

    static byte[] a(ah r4, String r5) {
        byte[] r0 = new byte[0];
        InputStream r1 = null;
        ah.b r6 = r4.a(r5);     // Catch: Throwable -> L38
        if (r6 != null) goto L68;
        if (r6 != null) goto L78;
    L37:
        return r0;
    L78:
        r6.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.printStackTrace();
        goto L37
    L68:
        InputStream r2 = r6.a();     // Catch: Throwable -> L30
        if (r2 != null) goto L18;
        if (r2 != null) goto L74;
    L12:
        if (r6 != null) goto L64;
    L17:
        return r0;
    L64:
        r6.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    L74:
        r2.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    L18:
        r0 = new byte[r2.available()];     // Catch: Throwable -> L30
        r2.read(r0);     // Catch: Throwable -> L30
        if (r2 != null) goto L70;
    L24:
        if (r6 != null) goto L82;
    L29:
        return r0;
    L82:
        r6.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L29
    L70:
        r2.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.printStackTrace();
    L30:
        th = th;
    L80:
        q.b(th, "sui", "rdS");     // Catch: Throwable -> L52
        if (0 != 0) goto L86;
    L46:
        if (r6 != null) goto L76;
    L51:
        return r0;
    L76:
        r6.close();     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        th.printStackTrace();
        goto L51
    L86:
        r1.close();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        th.printStackTrace();
    L52:
        th = move-exception;
        if (0 != 0) goto L72;
    L58:
        if (r6 == null) goto L88;
        r6.close();     // Catch: Throwable -> L61
        throw th;
    L61:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L88:
        throw th;
    L72:
        r1.close();     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        th.printStackTrace();
    L38:
        th = th;
        r6 = null;
        goto L80
    }
}
