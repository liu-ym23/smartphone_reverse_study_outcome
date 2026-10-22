package com.bumptech.glide.load.engine;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.iesgurd.core.ReqType;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f1509c;
    public static long d;
    public static long e;
    public static long f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1511b;

    public h0(Context r5, boolean r10) {
        this.f1511b = r5;
        this.f1510a = r10;
    }

    public void a(long r21, Thread r23, Throwable r24, String r25, String r26, boolean r27) {
        boolean r15 = this.f1510a;
        String r5 = com.bytedance.crash.util.g.f4181a;
        Context r16 = (Context) this.f1511b;
        File r12 = new File(new File(com.bytedance.crash.util.g.h(r16), x8.a.f22983b), r25);
        r12.mkdirs();
        File r10 = new File(r12, "lock");
        r10.createNewFile();     // Catch: Throwable -> L5
        int r11 = NativeTools.k().G(r10.getAbsolutePath());     // Catch: Throwable -> L5
    L7:
        String r18 = "NPTH_CATCH";
        z8.c r13 = l9.l.f().g(CrashType.JAVA, null, new d9.c(com.bytedance.crash.util.h.l(r24), r24, r21, r26, r27, r23, r25, r12, this.f1510a), true);
        if (r11 <= 0) goto L11;
        NativeTools.k().w(r11);
    L11:
        if (com.bytedance.android.anniex.base.service.f.n() == true) goto L18;
        int r14 = com.bytedance.android.anniex.base.service.f.f3130a;
        if (r14 == 24) goto L18;
        if (r14 == 23) goto L18;
        if (com.bytedance.crash.n.f4062j.isEngMode() == true) goto L18;
        return;
    L18:
        String r17 = "no_space";
        z8.c.l(r13.b(), "filters", "no_space", "direct");
        int r19 = com.bytedance.android.anniex.base.service.f.f3130a;
        if (r19 == 24) goto L21;
        if (r19 == 23) goto L21;
    L22:
        JSONObject r20 = r13.f23416a;
        r20 = com.bytedance.crash.upload.g.a(r20, r15, com.bytedance.crash.n.f(), r25);     // Catch: JSONException -> L76
    L24:
        JSONObject r22 = r20;
        File r28 = com.bytedance.crash.util.g.f(r16);
        com.bytedance.crash.util.h.a(r24);
        if (r15 == false) goto L27;
        CrashType r29 = CrashType.LAUNCH;
    L28:
        Context r30 = com.bytedance.crash.n.f4057a;
        if (r15 == false) goto L83;
        r29 = CrashType.LAUNCH;
    L83:
        io.reactivex.exceptions.a.c("notifyJavaCrashEx: enter");     // Catch: Throwable -> L34
        if (com.bytedance.crash.n.f4062j.isEngMode() == false) goto L36;
        ArrayList r31 = new ArrayList();     // Catch: Throwable -> L34
        r31.add(r12.getAbsolutePath());     // Catch: Throwable -> L34
        r17 = r28.getAbsolutePath();     // Catch: Throwable -> L34
        r31.add(r17);     // Catch: Throwable -> L34
        cl.a.x(r31);     // Catch: Throwable -> L34
    L36:
        Iterator r32 = ((ListMap) com.bytedance.crash.p.f.f210b).a(r29).iterator();     // Catch: Throwable -> L34
    L38:
        if (r32.hasNext() == false) goto L39;
        if (r32.next() != null) goto L52;
        io.reactivex.exceptions.a.c("notifyJavaCrashEx: begin");     // Catch: Throwable -> L46
        ym.m.o((Context) com.bytedance.crash.n.d().f17502b);     // Catch: Throwable -> L46
        throw null;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);     // Catch: Throwable -> L34
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L34
        r17 = r18;
        m.b.h(r17, th);     // Catch: Throwable -> L50
        r18 = r17;
    L50:
        th = th;
    L54:
        io.reactivex.exceptions.a.f(th);
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h(r17, th);
    L56:
        if (com.bytedance.crash.p.f4084h == false) goto L59;
        io.reactivex.exceptions.a.c("disposeException: isStopUpload == true, return");
        return;
    L59:
        com.lynx.jsbridge.a.j(r28, r22);
        if (Looper.getMainLooper() != Looper.myLooper()) goto L64;
        CountDownLatch r33 = new CountDownLatch(1);
        new Thread(new com.bytedance.apm.f(this, r22, r28, r12, r33)).start();     // Catch: Throwable -> L75
        r33.await(5, TimeUnit.SECONDS);     // Catch: Throwable -> L75
        return;
    L95:
        return;
    L64:
        if (r15 == false) goto L66;
        CrashType r34 = CrashType.LAUNCH;
    L67:
        String r35 = r34.getName();
        if (r15 == false) goto L70;
        String r36 = com.bytedance.crash.n.f4062j.getLaunchCrashUploadUrl();
    L72:
        if (com.bytedance.crash.upload.b.a(r35, com.bytedance.crash.upload.b.i(r36, r22.optJSONObject("header")), r22.toString(), null, new c5.a[]{new c5.a(new File[]{r28}, true)}).c() == false) goto L93;
        cl.a.C(r12);
        return;
    L93:
        return;
    L70:
        r36 = com.bytedance.crash.n.f4062j.getJavaCrashUploadUrl();
        goto L72
    L66:
        r34 = CrashType.JAVA;
        goto L67
    L52:
        r17 = r18;
        throw new ClassCastException();     // Catch: Throwable -> L50
    L39:
        ConfigManager r37 = com.bytedance.crash.n.f4062j;     // Catch: Throwable -> L34
        if (r37.isEngMode() == false) goto L56;
        io.reactivex.exceptions.a.c("notifyJavaCrashEx: sleep time = " + r37.getDelayTime());     // Catch: Throwable -> L34
        Thread.sleep(r37.getDelayTime());     // Catch: Throwable -> L34
        io.reactivex.exceptions.a.c("notifyJavaCrashEx: sleep end");     // Catch: Throwable -> L34
    L34:
        th = th;
        r17 = r18;
        goto L54
    L27:
        r29 = CrashType.JAVA;
    L21:
        z8.c.l(r13.b(), "filters", "fd_leak", "true");
    L5:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        r11 = -1;
        goto L7
    }

    public synchronized void b(d0 r5, boolean r10) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f1510a == true) goto L10;
        if (r10 == true) goto L10;
        this.f1510a = true;     // Catch: Throwable -> L8
        r5.recycle();     // Catch: Throwable -> L8
        this.f1510a = false;     // Catch: Throwable -> L8
    L11:
        monitor-exit(this);
        return;
    L10:
        ((Handler) this.f1511b).obtainMessage(1, r5).sendToTarget();     // Catch: Throwable -> L8
        goto L11
    }

    public h0(ReqType r5) {
        this.f1511b = r5;
    }

    public h0(w8.b r5) {
        jm.a r10 = new jm.a(this, 15);
        this.f1511b = r5;
        JSONObject r11 = l9.c.e();
        if (mh.e.c(r11, -1, new String[]{"custom_event_settings", "npth_simple_setting", "disable_kill_history"}) != 1) goto L6;
        l9.o.e().c(r10, 5000);
        return;
    }

    public h0() {
        this.f1511b = new Handler(Looper.getMainLooper(), new g0());
    }
}
