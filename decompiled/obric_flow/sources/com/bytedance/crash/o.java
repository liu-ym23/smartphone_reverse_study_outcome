package com.bytedance.crash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.engine.h0;
import com.bytedance.crash.nativecrash.NativeImpl;
import com.bytedance.crash.upload.r;
import com.bytedance.crash.upload.s;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.services.apm.api.IFdCheck;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4080a;

    public o(boolean r5) {
        this.f4080a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r10 = this.f4080a;
        if (com.bytedance.crash.upload.b.g == true) goto L8;
        com.bytedance.crash.upload.b.g = true;
        boolean r5 = com.bytedance.crash.upload.b.o(null);
        com.bytedance.crash.upload.b.r();
        if (r5 == false) goto L8;
        io.reactivex.exceptions.a.i("start fetch apmConfig");
        com.bytedance.crash.upload.b.f4094b = 40;
        l9.o.e().b(com.bytedance.crash.upload.b.f4093a);
    L8:
        Context r11 = n.f4057a;
        l9.l.f();
        com.bytedance.ies.argus.bean.b r12 = com.bytedance.ies.argus.bean.b.a();
        boolean r13 = false;
        if (r12.f5125b != (-1)) goto L127;
        File r14 = (File) r12.f5126c;
        if (((File[]) r12.f5127h) != null) goto L16;
        File[] r15 = r14.listFiles(new l9.p(1));
        r12.f5127h = r15;
        if (r15 != null) goto L16;
        r12.f5127h = new File[0];
    L16:
        File[] r16 = (File[]) r12.f5127h;
        if (r16 != null) goto L19;
    L20:
        r12.f5125b = 2;
        goto L127
    L19:
        if (r16.length == 0) goto L20;
    L127:
        u8.a.f22265b = true;     // Catch: Throwable -> L122
    L131:
        kn.e.e();     // Catch: Throwable -> L123
    L23:
        int r17 = NativeImpl.a();
        if (p.e == false) goto L26;
        c.f4025a.getClass();
        m.b.f("NativeLibraryLoad faild " + r17);
    L29:
        if (i9.f.f17537a == true) goto L38;
        i9.f.f17537a = true;
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "disable_kill_history"}) == 1) goto L38;
        i9.f.g();
        monitor-enter(i9.f.class);
        io.reactivex.exceptions.a.i("start child monitor");     // Catch: Throwable -> L119
        new Thread(new com.bytedance.android.anniex.worker.a(21), "monitor-terminal").start();     // Catch: Throwable -> L119
        monitor-exit(i9.f.class);     // Catch: Throwable -> L119
    L119:
        th = move-exception;
        throw th;
    L38:
        m.b r18 = c.f4025a;
        monitor-enter(l9.l.class);
    L43:
        th = move-exception;
        throw th;
    L41:
        if (l9.l.f != null) goto L45;
        l9.l.f = new l9.l();     // Catch: Throwable -> L43
    L45:
        monitor-exit(l9.l.class);     // Catch: Throwable -> L43
        s r19 = s.d();
        if (r19 == null) goto L63;
        r19.r();
        if (r19.f4156a.size() <= 0) goto L57;
        r19.t();
        if (l9.c.d() == false) goto L54;
        io.reactivex.exceptions.a.i("Disaster:disable network disaster!!!");
        r19.q();
        r19.t();
    L54:
        if (ym.m.q(n.f4057a) == true) goto L56;
        io.reactivex.exceptions.a.i("disaster:not main process");
        goto L57
    L56:
        l9.o.e().b(new a6.a(r19, 11));
    L57:
        File r20 = r19.f4157b;
        if (r20.exists() == false) goto L133;
    L60:
        r r21 = r19.e;
        if (r21 == null) goto L63;
        r21.startWatching();
        goto L63
    L133:
        r20.createNewFile();     // Catch: IOException -> L124
    L63:
        l9.o.e().c(new com.bytedance.android.anniex.container.popup.c(r11, 1), 0);
        StringBuilder r22 = new StringBuilder("initAsync:anr:");
        r22.append(r10);
        r22.append(" ");
        if (n.f4060h == true) goto L66;
    L68:
        r22.append(r13);
        io.reactivex.exceptions.a.i(r22.toString());
        if (r10 == true) goto L71;
    L95:
        com.bytedance.crash.upload.n r110 = com.bytedance.crash.upload.n.a();
        r110.getClass();
        if (com.bytedance.crash.upload.n.f.isEmpty() == false) goto L98;
        r110.f4145a.c(r110.f4147c, 30000);
    L139:
        og.a.f20567a.put(IFdCheck.class, new NpthCore$5());     // Catch: Throwable -> L125
    L137:
        File r111 = r11.getExternalFilesDir("fastbot");     // Catch: Throwable -> L126
        if (ym.m.q(n.f4057a) == false) goto L109;
        if (r111 == null) goto L109;
        if (r111.exists() == false) goto L109;
        String r112 = r111.getAbsolutePath();     // Catch: Throwable -> L126
        t9.a r23 = new t9.a();     // Catch: Throwable -> L126
        ec.b r24 = zm.p.f23512j;     // Catch: Throwable -> L126
        if (r24 == null) goto L108;
        r24.stopWatching();     // Catch: Throwable -> L126
    L108:
        ec.b r25 = new ec.b(r112, r23, r112);     // Catch: Throwable -> L126
        zm.p.f23512j = r25;     // Catch: Throwable -> L126
        r25.startWatching();     // Catch: Throwable -> L126
    L109:
        long r26 = NativeTools.k().getSymbolAddress("libc.so", "malloc_info", true);
        if (r26 == 0) goto L112;
        NativeTools.k().setMallocInfoFunc(r26);
    L112:
        NativeTools.k().getClass();
        com.bytedance.android.anniex.base.service.e.l("afterNpthInit", "noValue");
        long r27 = n.f4071t;
        io.reactivex.exceptions.a.i("afterNpthInit delay:" + r27);
        if (r27 <= 0) goto L115;
        l9.o.e().c(new com.bytedance.android.anniex.worker.a(5), r27);
        return;
    L115:
        l9.n.b("npthStart", null, a.a.f15a);
        return;
    L98:
        r110.f4145a.b(r110.f4147c);
        goto L139
    L71:
        if (n.f4060h == true) goto L73;
    L86:
        w8.b r28 = (w8.b) w8.f.c(r11).f22816a;
        if (r28.f22769c == true) goto L94;
        r28.f22767a = new h0(r28);
        if (a.a.d == true) goto L93;
        a.a.d = true;
    L93:
        r28.d = n.f4059c;
        r28.f22769c = true;
    L94:
        new Thread(new com.bytedance.android.anniex.worker.a(3), "NPTH-AnrMonitor").start();
        new Handler(Looper.getMainLooper()).post(new com.bytedance.android.anniex.worker.a(4));
        p.f4083c = r10;
        goto L95
    L73:
        if (n.g == false) goto L86;
        File r29 = w8.e.f22803a;
        monitor-enter(w8.e.class);
    L83:
        th = move-exception;
        throw th;
    L77:
        if (w8.e.f == false) goto L80;
        monitor-exit(w8.e.class);
        goto L86
    L80:
        w8.e.f = true;     // Catch: Throwable -> L83
        new Thread(new so.e(5), "NPTH-ANR").start();     // Catch: Throwable -> L83
        monitor-exit(w8.e.class);
        goto L86
    L66:
        if (n.g == false) goto L68;
        r13 = true;
        goto L68
    L26:
        if (r17 == 0) goto L29;
        c.f4025a.getClass();
        m.b.f("createCallbackThread faild " + r17);
        goto L29
    }
}
