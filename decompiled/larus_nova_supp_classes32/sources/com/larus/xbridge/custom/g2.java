package com.larus.xbridge.custom;

import android.util.Base64;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g2 implements te7.b {
    public final /* synthetic */ RequestMethod a;
    public final /* synthetic */ com.bytedance.sdk.xbridge.cn.network.a.b b;
    public final /* synthetic */ IBDXBridgeContext c;
    public final /* synthetic */ CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> d;

    public final void a(te7.i r14) {
        final String r0 = r14.c();
        boolean r2 = true;
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        BufferedInputStream r4 = null;
        ByteArrayOutputStream r5 = null;
        r5 = null;
        r5 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L22;
        Throwable r3 = r14.d();
        if (r3 == null) goto L21;
        r0 = r3.getMessage();
        if (r0 == null) goto L21;
        if (r0.length() > 0) goto L19;
        r2 = false;
    L19:
        if (r2 == true) goto L22;
    L21:
        r0 = null;
    L22:
        InputStream r6 = r14.e();
        final int r7 = r14.b.element;
        final Integer r11 = r14.b();
        if (r6 != null) goto L26;
        int r15 = RequestMethod.e;
        RequestMethod r16 = this.a;
        this.b.getUrl();
        RequestMethod.a(r16);
        final CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r17 = this.d;
        com.larus.utils.t0.c(new d2(r17, r0, r7, r11));
        return;
    L26:
        final LinkedHashMap r8 = r14.a;
        BufferedInputStream r9 = new BufferedInputStream(r6);     // Catch: Throwable -> L43 Exception -> L45
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();     // Catch: Exception -> L41 Throwable -> L57
        byte[] r12 = new byte[4096];     // Catch: Throwable -> L37 Exception -> L39
    L31:
        int r13 = r9.read(r12);     // Catch: Throwable -> L37 Exception -> L39
        if (r13 == (-1)) goto L34;
        r10.write(r12, 0, r13);     // Catch: Throwable -> L37 Exception -> L39
        goto L31
    L34:
        final String r18 = Base64.encodeToString(r10.toByteArray(), 2);     // Catch: Throwable -> L37 Exception -> L39
        RequestMethod r19 = this.a;     // Catch: Throwable -> L37 Exception -> L39
        this.b.getUrl();     // Catch: Throwable -> L37 Exception -> L39
        RequestMethod.a(r19);     // Catch: Throwable -> L37 Exception -> L39
        final CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r20 = this.d;     // Catch: Throwable -> L37 Exception -> L39
        com.larus.utils.t0.c(new e2(r20, r8, r18, r7, r11));     // Catch: Throwable -> L37 Exception -> L39
        r14.a();     // Catch: IOException -> L54
        r9.close();     // Catch: IOException -> L54
        r10.close();     // Catch: IOException -> L54
        return;
    L39:
        final Exception e = e;
        r5 = r10;
    L47:
        RequestMethod r21 = this.a;     // Catch: Throwable -> L57
        this.b.getUrl();     // Catch: Throwable -> L57
        RequestMethod.a(r21);     // Catch: Throwable -> L57
        final CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r22 = this.d;     // Catch: Throwable -> L57
        com.larus.utils.t0.c(new f2(r22, e, r7, r11));     // Catch: Throwable -> L57
        r14.a();     // Catch: IOException -> L54
        if (r9 == null) goto L51;
        r9.close();     // Catch: IOException -> L54
    L51:
        if (r5 == null) goto L79;
        r5.close();     // Catch: IOException -> L54
        return;
    L79:
        return;
    L37:
        Throwable th = th;
        r5 = r10;
    L59:
        ByteArrayOutputStream r110 = r5;
        r4 = r9;
        ByteArrayOutputStream r23 = r110;
    L72:
        r14.a();     // Catch: IOException -> L66
        if (r4 == null) goto L63;
        r4.close();     // Catch: IOException -> L66
    L63:
        if (r23 == null) goto L82;
        r23.close();     // Catch: IOException -> L66
        throw th;
    L82:
        throw th;
    L66:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L41:
        e = move-exception;
        e = e;
    L57:
        th = move-exception;
        th = th;
        goto L59
    L54:
        e = move-exception;
        e.printStackTrace();
        return;
    L45:
        e = move-exception;
        e = e;
        r9 = null;
    L43:
        th = move-exception;
        th = th;
        r23 = null;
        goto L72
    L5:
        r1 = false;
        goto L6
    }

    public g2(RequestMethod r1, com.bytedance.sdk.xbridge.cn.network.a.b r2, IBDXBridgeContext r3, long r4, CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r6;
    }
}
