package com.bytedance.apm.block;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import androidx.fragment.app.Fragment;
import b27.a;
import bt3.f;
import com.bytedance.apm.config.e;
import com.bytedance.apm.d;
import com.bytedance.apm.h;
import ff7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b extends a implements c, h {
    public boolean b;
    public boolean c;
    public final k d;

    public final void onActivityCreated(Activity r1, Bundle r2) {
    }

    public final void onActivityPause(Activity r1) {
    }

    public final void onActivityResume(Activity r1) {
    }

    public final void onActivityStarted(Activity r1) {
    }

    public final void onChange(Activity r1, Fragment r2) {
    }

    public b() {
        if (k.t == null) goto L5;
    L14:
        this.d = k.t;
        return;
    L5:
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (k.t != null) goto L9;
        k.t = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // com.bytedance.apm.h
    public final void a(e r12) {
        long r0 = r12.l;
        long r2 = r12.h;
        boolean r4 = r12.e;
        boolean r5 = r12.d;
        this.d.m = r4;
        k r6 = this.d;
        r6.getClass();
        if (r0 >= 70) goto L5;
        r0 = 2500;
    L5:
        r6.d = r0;
        if (r6.e >= r0) goto L8;
        r6.e = r0 + 50;
    L8:
        k r1 = this.d;
        long r7 = r1.d;
        if (r2 >= r7) goto L11;
        r2 = 5000;
    L11:
        r1.e = r2;
        if (r2 >= r7) goto L14;
        r1.e = r7 + 50;
    L14:
        r1.f = r5;
        r1.n = r12.n;
        if (d.u == false) goto L17;
    L20:
        boolean r13 = true;
    L21:
        r1.o = r13;
        return;
    L17:
        if (r12.g == true) goto L20;
        r13 = false;
        goto L21
    }

    public final void c(String r10) {
        ((a) this).a = true;
        if (this.c == false) goto L33;
        k r1 = this.d;
        r1.getClass();
        if (r1.a.d == null) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L34;
        c r3 = r1.l;     // Catch: Exception -> L30
        if (r3 == null) goto L18;
        long[] r4 = es3.h.z.b.a;     // Catch: Exception -> L30
        if ((r4[0] - r4[2]) <= 100) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L18;
        r3.e = true;     // Catch: Exception -> L30
        goto L18
    L15:
        r5 = false;
    L18:
        c r0 = r1.k;     // Catch: Exception -> L30
        if (r0 != null) goto L21;
        r1.k = new c(a.b, r10);     // Catch: Exception -> L30
    L23:
        if (r1.f == false) goto L35;
        f r11 = r1.a;     // Catch: Exception -> L30
        k.a r6 = r1.r;     // Catch: Exception -> L30
        long r7 = r1.d;     // Catch: Exception -> L30
        r11.b(Message.obtain(r11.d, r6), r7);     // Catch: Exception -> L30
        if (r1.b == true) goto L27;
        return;
    L27:
        if (r1.o == false) goto L37;
        f r12 = r1.a;     // Catch: Exception -> L30
        k.b r8 = r1.s;     // Catch: Exception -> L30
        long r9 = r1.e;     // Catch: Exception -> L30
        r12.b(Message.obtain(r12.d, r8), r9);     // Catch: Exception -> L30
        return;
    L37:
        return;
    L35:
        return;
    L21:
        r0.g = a.b;     // Catch: Exception -> L30
        r0.b = r10;     // Catch: Exception -> L30
        r0.h = -1;     // Catch: Exception -> L30
        r0.a = false;     // Catch: Exception -> L30
        goto L23
    L34:
        return;
    L8:
        r2 = false;
    L38:
        return;
    }

    public final void onBackground(Activity r2) {
        if (this.c == false) goto L10;
        this.c = false;
        this.d.h(false);
        if (d.j() == false) goto L9;
        ps3.b.a(new String[]{"BlockDetector stop: "});
        return;
    L9:
        return;
    }

    public final void onFront(Activity r1) {
        if (this.b == true) goto L5;
        return;
    L5:
        if (this.c == true) goto L13;
        this.c = true;
        if (d.j() == false) goto L12;
        ps3.b.a(new String[]{"BlockDetector start: "});
        return;
    L12:
        return;
    }

    public final void d(long r1, long r3, long r5, long r7, boolean r9) {
        ((a) this).a = false;
        if (this.c == false) goto L6;
        this.d.h(r9);
        return;
    }
}
