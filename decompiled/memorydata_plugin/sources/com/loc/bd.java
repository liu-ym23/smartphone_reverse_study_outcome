package com.loc;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class bd extends bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f5350a = 13;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f5351b = 6;
    private Context e;

    static {
    }

    public bd(Context r3, bf r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r4);
        this.e = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
    }

    private static byte[] a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r2 = new byte[0];
        fx.a(r0, "1.2." + f5350a + "." + f5351b);     // Catch: Throwable -> L8
        fx.a(r0, LocationInfoConst.SYSTEM);     // Catch: Throwable -> L8
        fx.a(r0, fp.k());     // Catch: Throwable -> L8
        fx.a(r0, fp.h());     // Catch: Throwable -> L8
        fx.a(r0, fp.f(r6));     // Catch: Throwable -> L8
        fx.a(r0, Build.MANUFACTURER);     // Catch: Throwable -> L8
        fx.a(r0, Build.MODEL);     // Catch: Throwable -> L8
        fx.a(r0, Build.DEVICE);     // Catch: Throwable -> L8
        fx.a(r0, fp.n());     // Catch: Throwable -> L8
        fx.a(r0, fm.c(r6));     // Catch: Throwable -> L8
        fx.a(r0, fm.d(r6));     // Catch: Throwable -> L8
        fx.a(r0, fm.f(r6));     // Catch: Throwable -> L8
        r0.write(new byte[]{0});     // Catch: Throwable -> L8
        r2 = r0.toByteArray();     // Catch: Throwable -> L8
        r0.close();     // Catch: Throwable -> L6
    L18:
    L11:
        return r2;
    L6:
        th = move-exception;
        th.printStackTrace();
    L8:
        th = move-exception;
        q.b(th, "sm", "gh");     // Catch: Throwable -> L12
        r0.close();     // Catch: Throwable -> L6
    L12:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L15
    L17:
        throw th;
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    @Override // com.loc.bf
    public final byte[] a(byte[] r4) {
        byte[] r3 = a(this.e);
        byte[] r0 = new byte[r3.length + r4.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        System.arraycopy(r4, 0, r0, r3.length, r4.length);
        return r0;
    }
}
