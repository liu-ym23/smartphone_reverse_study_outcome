package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5337b;
    private String c;
    private String d;
    private String e;

    public aw(Context r4, String r5, String r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r7) == true) goto L9;
        if (r7.length() > 256) goto L9;
        this.f5336a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.c = r5;
        this.d = r6;
        this.f5337b = r7;
        return;
    L9:
        throw new l("无效的参数 - IllegalArgumentException");
    }

    private static byte[] a(int r3) {
        return new byte[]{(byte) ((r3 >> 24) & 255), (byte) ((r3 >> 16) & 255), (byte) ((r3 >> 8) & 255), (byte) (r3 & 255)};
    }

    private byte[] b(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        byte[] r1 = fx.a(this.e);
        if (r1 != null) goto L11;
        return new byte[]{0, 0};
    L11:
        return fx.a(r1.length);
    L5:
        return new byte[]{0, 0};
    }

    public final void a(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L9;
        if (r3.length() > 65536) goto L9;
        this.e = r3;
        return;
    L9:
        throw new l("无效的参数 - IllegalArgumentException");
    }

    public final byte[] a() {
        int r0 = 0;
        byte[] r1 = new byte[0];
        ByteArrayOutputStream r2 = null;
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: Throwable -> L14
        fx.a(r3, this.c);     // Catch: Throwable -> L12
        fx.a(r3, this.d);     // Catch: Throwable -> L12
        fx.a(r3, this.f5337b);     // Catch: Throwable -> L12
        fx.a(r3, String.valueOf(fp.j(this.f5336a)));     // Catch: Throwable -> L12
        r0 = (int) (System.currentTimeMillis() / 1000);
    L7:
        r3.write(a(r0));     // Catch: Throwable -> L12
        r3.write(b(this.e));     // Catch: Throwable -> L12
        r3.write(fx.a(this.e));     // Catch: Throwable -> L12
        r1 = r3.toByteArray();     // Catch: Throwable -> L12
        r3.close();     // Catch: Throwable -> L10
    L37:
    L18:
        return r1;
    L12:
        th = th;
        r2 = r3;
    L29:
        q.b(th, "se", "tds");     // Catch: Throwable -> L19
        if (r2 == null) goto L18;
        r2.close();     // Catch: Throwable -> L10
    L19:
        th = move-exception;
        if (r2 != null) goto L33;
    L25:
        throw th;
    L33:
        r2.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
    L14:
        th = th;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }
}
