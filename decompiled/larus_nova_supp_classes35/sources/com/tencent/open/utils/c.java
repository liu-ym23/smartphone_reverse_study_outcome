package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.tencent.open.log.SLog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class c {
    private static String c;
    private String a;
    private d b;
    private long d;
    private Handler e;
    private WeakReference<Activity> f;
    private Runnable g;

    public static /* synthetic */ String a() {
        return c;
    }

    public c(Activity r2) {
        this.g = new AnonymousClass2(this);
        this.f = new WeakReference(r2);
        final Looper r3 = r2.getMainLooper();
        this.e = new AnonymousClass1(this, r3);
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_tencent_open_utils_c_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r7) throws IOException {
        String r3 = r7.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r4 = r7.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r3, r4) == false) goto L11;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r3 + " path=" + r4);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r7);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r7.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public static Bitmap a(String r6) {
        SLog.v("AsynLoadImg", "getbitmap:" + r6);
        HttpURLConnection r4 = (HttpURLConnection) INVOKEVIRTUAL_com_tencent_open_utils_c_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r6));     // Catch: IOException -> L5 OutOfMemoryError -> L8
        r4.setDoInput(true);     // Catch: IOException -> L5 OutOfMemoryError -> L8
        r4.connect();     // Catch: IOException -> L5 OutOfMemoryError -> L8
        InputStream r5 = r4.getInputStream();     // Catch: IOException -> L5 OutOfMemoryError -> L8
        Bitmap r7 = BitmapFactory.decodeStream(r5);     // Catch: IOException -> L5 OutOfMemoryError -> L8
        r5.close();     // Catch: IOException -> L5 OutOfMemoryError -> L8
        SLog.v("AsynLoadImg", "image download finished." + r6);     // Catch: IOException -> L5 OutOfMemoryError -> L8
        return r7;
    L5:
        e = move-exception;
        e.printStackTrace();
        SLog.v("AsynLoadImg", "getbitmap bmp fail---");
        return null;
    L8:
        e = move-exception;
        e.printStackTrace();
        SLog.v("AsynLoadImg", "getbitmap bmp fail---");
        return null;
    }

    public static /* synthetic */ String b(c r0) {
        return r0.a;
    }

    public static /* synthetic */ Handler c(c r0) {
        return r0.e;
    }

    public static /* synthetic */ long d(c r2) {
        return r2.d;
    }

    public static /* synthetic */ d a(c r0) {
        return r0.b;
    }

    public void a(String r7, d r8) {
        SLog.v("AsynLoadImg", "--save---");
        if (r7 != null) goto L5;
    L24:
        r8.a(1, null);
        return;
    L5:
        if (r7.equals(BuildConfig.FLAVOR) == true) goto L24;
        if (m.a() == true) goto L12;
        r8.a(2, null);
        return;
    L12:
        if (this.f.get() == null) goto L22;
        Activity r2 = this.f.get();
        File r4 = m.h(r2, "Images");
        File r5 = Environment.getExternalStorageDirectory();
        if (r4 != null) goto L17;
        SLog.e("AsynLoadImg", "externalImageFile is null");
        r8.a(2, null);
        return;
    L17:
        StringBuilder r0 = new StringBuilder();
        if (k.d(r2) == false) goto L20;
        String r1 = r4.getAbsolutePath();
    L21:
        r0.append(r1);
        r0.append("/tmp/");
        c = r0.toString();
        goto L22
    L20:
        r1 = r5.getAbsolutePath();
    L22:
        this.d = System.currentTimeMillis();
        this.a = r7;
        this.b = r8;
        ThreadMethodProxy.start(new PthreadThreadV2(this.g, "/open/utils/c"));
    }

    public boolean a(Bitmap r7, String r8) {
        String r2 = c;
        BufferedOutputStream r3 = null;
        PolarisFileWrapper r4 = new PolarisFileWrapper(r2);     // Catch: Throwable -> L18 IOException -> L20
        if (r4.exists() == true) goto L6;
        r4.mkdir();     // Catch: Throwable -> L18 IOException -> L20
    L6:
        SLog.v("AsynLoadImg", "saveFile:" + r8);     // Catch: Throwable -> L18 IOException -> L20
        BufferedOutputStream r1 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r2 + r8)));     // Catch: Throwable -> L18 IOException -> L20
        r7.compress(Bitmap.CompressFormat.JPEG, 80, r1);     // Catch: Throwable -> L14 IOException -> L16
        r1.flush();     // Catch: Throwable -> L14 IOException -> L16
        r1.close();     // Catch: IOException -> L10
        return true;
    L10:
        e = move-exception;
        e.printStackTrace();
        return true;
    L16:
        e = e;
        r3 = r1;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L18
        SLog.e("AsynLoadImg", "saveFile bmp fail---", e);     // Catch: Throwable -> L18
        if (r3 == null) goto L46;
        r3.close();     // Catch: IOException -> L25
        return false;
    L25:
        e = move-exception;
        e.printStackTrace();
        return false;
    L46:
        return false;
    L14:
        th = th;
        r3 = r1;
    L29:
        if (r3 != null) goto L35;
    L34:
        throw th;
    L35:
        r3.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L18:
        th = th;
    L20:
        e = e;
        goto L21
    }
}
