package com.bytedance.android.ec.core.utils;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l1 implements WeakHandler.IHandler {
    public final long a;
    public final long b;
    public long c;
    public long d;
    public boolean e;
    public boolean f;
    public boolean g;
    public final WeakHandler h;
    public final a i;
    public final List<a> j;

    public interface a {
        void onFinish();

        void onStart();

        void onTick(long r1);
    }

    public final synchronized void a() {
        monitor-enter(this);
        this.e = true;     // Catch: Throwable -> L7
        this.f = false;     // Catch: Throwable -> L7
        this.g = false;     // Catch: Throwable -> L7
        this.h.removeMessages(1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f == false) goto L6;
        this.g = true;     // Catch: Throwable -> L8
        this.h.removeMessages(1);     // Catch: Throwable -> L8
        this.d = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final synchronized void c() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.g == false) goto L6;
        this.g = false;     // Catch: Throwable -> L8
        long r0 = SystemClock.elapsedRealtime() - this.d;     // Catch: Throwable -> L8
        long r10 = this.b;     // Catch: Throwable -> L8
        long r11 = r10 - (r0 % r10);     // Catch: Throwable -> L8
        WeakHandler r1 = this.h;     // Catch: Throwable -> L8
        r1.sendMessageDelayed(r1.obtainMessage(1), r11);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final synchronized void d() {
        monitor-enter(this);
        this.g = false;     // Catch: Throwable -> L26
        this.e = false;     // Catch: Throwable -> L26
        this.f = true;     // Catch: Throwable -> L26
        if (this.a > 0) goto L16;
        this.f = false;     // Catch: Throwable -> L26
        a r0 = this.i;     // Catch: Throwable -> L26
        if (r0 == null) goto L9;
        r0.onFinish();     // Catch: Throwable -> L26
    L9:
        Iterator r1 = ((ArrayList) this.j).iterator();     // Catch: Throwable -> L26
    L11:
        if (r1.hasNext() == false) goto L14;
        ((a) r1.next()).onFinish();     // Catch: Throwable -> L26
        goto L11
    L14:
        monitor-exit(this);
        return;
    L16:
        a r10 = this.i;     // Catch: Throwable -> L26
        if (r10 == null) goto L19;
        r10.onStart();     // Catch: Throwable -> L26
    L19:
        Iterator r11 = ((ArrayList) this.j).iterator();     // Catch: Throwable -> L26
    L21:
        if (r11.hasNext() == false) goto L23;
        ((a) r11.next()).onStart();     // Catch: Throwable -> L26
        goto L21
    L23:
        this.c = SystemClock.elapsedRealtime() + this.a;     // Catch: Throwable -> L26
        WeakHandler r12 = this.h;     // Catch: Throwable -> L26
        r12.sendMessage(r12.obtainMessage(1));     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public final void handleMsg(Message r10) {
        monitor-enter(this);
    L40:
        th = move-exception;
        throw th;
    L4:
        if (this.e == false) goto L6;
    L38:
        monitor-exit(this);     // Catch: Throwable -> L40
        return;
    L6:
        if (this.g == true) goto L38;
        long r0 = this.c - SystemClock.elapsedRealtime();     // Catch: Throwable -> L40
        long r11 = 0;
        if (r0 > 0) goto L17;
        this.f = false;     // Catch: Throwable -> L40
        a r12 = this.i;     // Catch: Throwable -> L40
        if (r12 == null) goto L13;
        r12.onFinish();     // Catch: Throwable -> L40
    L13:
        Iterator r13 = ((ArrayList) this.j).iterator();     // Catch: Throwable -> L40
    L15:
        if (r13.hasNext() == false) goto L36;
        ((a) r13.next()).onFinish();     // Catch: Throwable -> L40
    L36:
        monitor-exit(this);     // Catch: Throwable -> L40
        return;
    L17:
        long r14 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L40
        a r15 = this.i;     // Catch: Throwable -> L40
        if (r15 == null) goto L20;
        r15.onTick(r0);     // Catch: Throwable -> L40
    L20:
        Iterator r16 = ((ArrayList) this.j).iterator();     // Catch: Throwable -> L40
    L22:
        if (r16.hasNext() == false) goto L24;
        ((a) r16.next()).onTick(r0);     // Catch: Throwable -> L40
        goto L22
    L24:
        long r17 = SystemClock.elapsedRealtime() - r14;     // Catch: Throwable -> L40
        long r18 = this.b;     // Catch: Throwable -> L40
        if (r0 >= r18) goto L30;
        long r1 = r0 - r17;     // Catch: Throwable -> L40
        if (r1 < 0) goto L35;
        r11 = r1;
    L35:
        WeakHandler r19 = this.h;     // Catch: Throwable -> L40
        r19.sendMessageDelayed(r19.obtainMessage(1), r11);     // Catch: Throwable -> L40
        goto L36
    L30:
        long r20 = r18 - r17;     // Catch: Throwable -> L40
    L32:
        if (r20 >= 0) goto L34;
        r20 = r20 + this.b;     // Catch: Throwable -> L40
        goto L32
    L34:
        r11 = r20;
        goto L35
    }

    public l1(long r10, long r11, a r12) {
        this.e = false;
        this.f = false;
        this.g = false;
        this.j = new ArrayList();
        this.a = r10;
        this.b = r11;
        this.h = new WeakHandler(Looper.getMainLooper(), this);
        this.i = r12;
    }
}
