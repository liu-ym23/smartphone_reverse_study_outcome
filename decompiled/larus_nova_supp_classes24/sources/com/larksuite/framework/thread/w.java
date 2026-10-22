package com.larksuite.framework.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class w extends Handler {
    public long a;
    public long b;
    public String c;
    public final String d;
    public final String e;
    public final List<a0> f;

    public final String a() {
        if (this.c != null) goto L6;
        this.c = ThreadMethodProxy.currentThread().getName();
    L6:
        return this.c;
    }

    public final List<a0> b() {
        List<a0> r0 = this.f;
        monitor-enter(r0);
        LinkedList r1 = new LinkedList(this.f);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public w(Looper r3) {
        super(r3);
        this.a = 1000;
        this.b = 1000;
        this.e = "LarkHandler";
        this.f = new LinkedList();
    }

    public final void c(String r4) {
        List<a0> r0 = this.f;
        monitor-enter(r0);
        Iterator<a0> r1 = this.f.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L10;
        if (TextUtils.equals(r1.next().a, r4) == false) goto L6;
        r1.remove();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message r15) {
        Runnable r0 = r15.getCallback();
        if (TextUtils.isEmpty(this.d) == false) goto L7;
        if (r0 == null) goto L6;
        String r1 = r0.getClass().toString();
    L8:
        String r2 = r1;
        if (this.c != null) goto L11;
        this.c = ThreadMethodProxy.currentThread().getName();
    L11:
        long r3 = SystemClock.uptimeMillis();
        List<a0> r4 = this.f;
        monitor-enter(r4);
        ((LinkedList) this.f).add(new a0(r2, ThreadMethodProxy.currentThread(), System.currentTimeMillis()));     // Catch: Throwable -> L23
        monitor-exit(r4);     // Catch: Throwable -> L23
        Log.i("CoreThreadPool LarkHandler", "startTask:" + r2);
        super.dispatchMessage(r15);
        c(r2);
        long r5 = SystemClock.uptimeMillis();
        long r6 = r3 - r15.getWhen();
        long r8 = r5 - r3;
        if (r6 <= this.a) goto L18;
    L19:
        Log.w("CoreThreadPool LarkHandler", this.c + " " + r2 + ", dispatchtime & runtime is(ms) " + r6 + "， " + r8 + ", limit is  " + this.a + "," + this.b);
        l.a(r2, this.c, r6, r8, this.a, this.b);
        CoreThreadPool.a r16 = CoreThreadPool.mCoreThreadPoolDep;
        if (r16 == null) goto L29;
        r16.b();
        return;
    L29:
        return;
    L18:
        if (r8 > this.b) goto L19;
        return;
    L23:
        th = move-exception;
        throw th;
    L6:
        r1 = this.e + "_" + r15.what;
        goto L8
    L7:
        r1 = this.d;
        goto L8
    }

    public w(Looper r3, Handler.Callback r4) {
        super(r3, r4);
        this.a = 1000;
        this.b = 1000;
        this.e = "LarkHandler";
        this.f = new LinkedList();
        if (r4 == null) goto L6;
        this.d = r4.getClass().toString();
        return;
    }

    @Override // android.os.Handler
    public final boolean sendMessageAtTime(Message r4, long r5) {
        Runnable r0 = r4.getCallback();
        if (TextUtils.isEmpty(this.d) == false) goto L7;
        if (r0 == null) goto L6;
        String r1 = r0.getClass().toString();
    L8:
        Log.i("CoreThreadPool LarkHandler", "sendMessageAtTime taskname is: " + r1);
        return super.sendMessageAtTime(r4, r5);
    L6:
        r1 = this.e + "_" + r4.what;
        goto L8
    L7:
        r1 = this.d;
        goto L8
    }

    public w(Looper r3, String r4) {
        super(r3);
        this.a = 1000;
        this.b = 1000;
        this.e = "LarkHandler";
        this.f = new LinkedList();
        this.c = r4;
    }
}
