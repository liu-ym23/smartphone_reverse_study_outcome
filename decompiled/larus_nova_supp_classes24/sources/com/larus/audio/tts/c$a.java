package com.larus.audio.tts;

import android.content.Context;
import android.system.Os;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.utils.AudioLoadManager;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.obric.assistant.network.okhttp.a;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c$a implements Runnable {
    public final String a;
    public final String b;
    public final Context c;
    public final Function1<String, Unit> d;
    public final /* synthetic */ c e;

    public final void b() {
        File r3 = null;
        String r4 = this.b;     // Catch: Throwable -> L52 Exception -> L54
        if (r4 != null) goto L6;
    L9:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        return;
    L12:
        ByteString.a r6 = ByteString.Companion;     // Catch: Throwable -> L52 Exception -> L54
        String r7 = this.b;     // Catch: Throwable -> L52 Exception -> L54
        r6.getClass();     // Catch: Throwable -> L52 Exception -> L54
        String r8 = ByteString.a.b(r7).md5().hex();     // Catch: Throwable -> L52 Exception -> L54
        PolarisFileWrapper r9 = this.e.a(this.c, r8);     // Catch: Throwable -> L52 Exception -> L54
        if (r9 != null) goto L15;
        return;
    L15:
        File r10 = new PolarisFileWrapper(r9.getParentFile(), r8 + ".download." + ThreadMethodProxy.currentThread().getId() + '.' + System.nanoTime());     // Catch: Throwable -> L52 Exception -> L54
        BufferedInputStream r11 = new BufferedInputStream(a(new URL(this.b)).getInputStream());     // Catch: Throwable -> L36 Exception -> L38
        PolarisFileOutputStreamWrapper r12 = new PolarisFileOutputStreamWrapper(r10);     // Catch: Throwable -> L47
        byte[] r13 = new byte[1024];     // Catch: Throwable -> L42
    L20:
        int r14 = r11.read(r13);     // Catch: Throwable -> L42
        if (r14 == (-1)) goto L23;
        r12.write(r13, 0, r14);     // Catch: Throwable -> L42
        goto L20
    L23:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L47
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L36 Exception -> L38
        Os.rename(r10.getAbsolutePath(), r9.getAbsolutePath());     // Catch: Throwable -> L36 Exception -> L38
        if (r9.isFile() == false) goto L41;
        r9.setLastModified(System.currentTimeMillis());     // Catch: Throwable -> L36 Exception -> L38
        Function1<String, Unit> r16 = this.d;     // Catch: Throwable -> L36 Exception -> L38
        if (r16 == null) goto L30;
        r16.invoke(r9.getAbsolutePath());     // Catch: Throwable -> L36 Exception -> L38
    L30:
        FLogger r17 = FLogger.a;     // Catch: Throwable -> L36 Exception -> L38
        this.e.getClass();     // Catch: Throwable -> L36 Exception -> L38
        r17.i("AudioDownloadQueue", "[DownloadTask]#run styleId:" + this.a + ", Download completed: " + this.b);     // Catch: Throwable -> L36 Exception -> L38
        AudioLoadManager r19 = AudioLoadManager.a;     // Catch: Throwable -> L36 Exception -> L38
        AudioLoadManager.f("downloadSuccess", this.a, this.b, null);     // Catch: Throwable -> L36 Exception -> L38
        if (r10.exists() == false) goto L34;
        r3 = r10;
    L34:
        if (r3 == null) goto L82;
    L62:
        r3.delete();
        return;
    L82:
        return;
    L41:
        throw new IOException("Unable to publish audio preload cache");     // Catch: Throwable -> L36 Exception -> L38
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L36 Exception -> L38
        throw th;     // Catch: Throwable -> L36 Exception -> L38
    L38:
        e = e;
    L56:
        AudioLoadManager r20 = AudioLoadManager.a;     // Catch: Throwable -> L36
        AudioLoadManager.f("downloadFailed", this.a, this.b, e.getMessage());     // Catch: Throwable -> L36
        g.a.ensureNotReachHere(e, "[DownloadTask]#run Download Error: " + this.b + "  error msg is : " + e.getMessage());     // Catch: Throwable -> L36
        FLogger r21 = FLogger.a;     // Catch: Throwable -> L36
        this.e.getClass();     // Catch: Throwable -> L36
        r21.e("AudioDownloadQueue", "[DownloadTask]#run styleId:" + this.a + ", Download Error: " + this.b + "  error msg is : " + e.getMessage(), e);     // Catch: Throwable -> L36
        if (r10 != null) goto L59;
        return;
    L59:
        if (r10.exists() == false) goto L61;
        r3 = r10;
    L61:
        if (r3 != null) goto L62;
        return;
    L6:
        if (r4.length() == 0) goto L9;
        r5 = false;
    L36:
        th = th;
    L64:
        if (0 != 0) goto L66;
    L70:
        throw th;
    L66:
        if (r3.exists() == false) goto L68;
        r3 = null;
    L68:
        if (r3 == null) goto L70;
        r3.delete();
    L54:
        e = e;
        r10 = null;
    L52:
        th = th;
        goto L64
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final Context getContext() {
        return this.c;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r7) throws IOException {
        String r3 = r7.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r4 = r7.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (a.c(r3, r4) == false) goto L11;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r3 + " path=" + r4);     // Catch: Throwable -> L8 IOException -> L12
        a.b(GlobalNetworkGate.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L12
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

    /* JADX WARN: Multi-variable type inference failed */
    public c$a(c r2, String r3, String r4, Context r5, Function1<? super String, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "styleId");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.e = r2;
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
