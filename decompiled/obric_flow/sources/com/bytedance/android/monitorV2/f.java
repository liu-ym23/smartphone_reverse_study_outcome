package com.bytedance.android.monitorV2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import l9.o;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3578b;

    public f() {
        this.f3577a = 0;
        this.f3578b = new HashSet();
    }

    private final void b(Activity r5) {
    }

    private final void c(Activity r5) {
    }

    private final void d(Activity r5, Bundle r10) {
    }

    private final void e(Activity r5, Bundle r10) {
    }

    private final void f(Activity r5) {
    }

    public void a(Activity r5) {
        HashSet r10 = (HashSet) this.f3578b;
        if (r5 != null) goto L12;
        boolean r11 = false;
    L6:
        if (r11 == false) goto L14;
        r10.add(Integer.valueOf(r5.hashCode()));     // Catch: Exception -> L9
        Window r12 = r5.getWindow();     // Catch: Exception -> L9
        r12.setCallback(new g(r12.getCallback()));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        mn.h.g("default_handle", e);
        return;
    L14:
        return;
    L12:
        r11 = !r10.contains(Integer.valueOf(r5.hashCode()));     // Catch: Exception -> L9
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r10, Bundle r11) {
        switch(this.f3577a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        m9.c r12 = (m9.c) this.f3578b;
        r12.getClass();
        r12.g = r10.getClass().getName();
        r12.f20037h = System.currentTimeMillis();
        if (r11 == null) goto L7;
        boolean r13 = true;
    L8:
        m9.c.f20030w = r13;
        m9.c.f20031x = true;
        r12.f20034a.add(r12.g);
        r12.f20035b.add(Long.valueOf(r12.f20037h));
        String r5 = r12.g;
        long r14 = r12.f20037h;
        o.e().b(new m9.a(r10.hashCode(), r14, r5, "onCreate", r12));
        r12.f.add(new WeakReference(r10));
        return;
    L7:
        r13 = false;
        goto L8
    L10:
        a(r10);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r10) {
        switch(this.f3577a) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        m9.c r5 = (m9.c) this.f3578b;
        r5.getClass();
        String r11 = r10.getClass().getName();
        int r12 = r5.f20034a.indexOf(r11);
        if (r12 > (-1)) goto L7;
    L9:
        r5.f20036c.add(r11);
        long r13 = System.currentTimeMillis();
        r5.d.add(Long.valueOf(r13));
        m9.c.d(r10.hashCode(), r13, r11, "onDestroy", (m9.c) this.f3578b);
        return;
    L7:
        if (r12 >= r5.f20034a.size()) goto L9;
        r5.f20034a.remove(r12);
        r5.f20035b.remove(r12);
        goto L9
    L11:
        ((HashSet) this.f3578b).remove(Integer.valueOf(r10.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r10) {
        switch(this.f3577a) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        m9.c r5 = (m9.c) this.f3578b;
        r5.getClass();
        r5.f20043n = r10.getClass().getName();
        r5.f20044o = System.currentTimeMillis();
        int r11 = r5.f20049u - 1;
        r5.f20049u = r11;
        if (r11 != 0) goto L7;
        r5.f20047r = false;
        m9.c.f20031x = false;
        r5.s = SystemClock.uptimeMillis();
    L9:
        String r12 = r5.f20043n;
        m9.c.d(r10.hashCode(), r5.f20044o, r12, "onPause", r5);
        return;
    L7:
        if (r11 >= 0) goto L9;
        r5.f20049u = 0;
        r5.f20047r = false;
        m9.c.f20031x = false;
        r5.s = SystemClock.uptimeMillis();
        goto L9
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r10) {
        switch(this.f3577a) {
            case 0: goto L23;
            default: goto L4;
        };
    L4:
        m9.c r11 = (m9.c) this.f3578b;
        r11.getClass();
        r11.f20040k = r10.getClass().getName();
        r11.f20042m = new WeakReference(r10);
        long r5 = System.currentTimeMillis();
        r11.f20041l = r5;
        r11.f20049u++;
        if (r11.f20047r == true) goto L21;
        r11.f20047r = true;
        if (m9.c.f20029v == false) goto L9;
        m9.c.f20029v = false;
        m9.c.f20032y = 1;
        m9.c.A = r5;
    L9:
        String r12 = r11.f20040k;
        if (r12 != null) goto L12;
    L14:
        boolean r13 = m9.c.f20031x;
        if (r13 == true) goto L17;
    L19:
        if (r13 == true) goto L21;
        m9.c.f20032y = 3;
        m9.c.A = r11.f20041l;
        goto L21
    L17:
        if (m9.c.f20030w == true) goto L19;
        m9.c.f20032y = 4;
        m9.c.A = r11.f20041l;
        goto L21
    L12:
        if (r12.equals(r11.f20043n) == true) goto L14;
    L21:
        String r14 = r11.f20040k;
        long r15 = r11.f20041l;
        o.e().b(new m9.a(r10.hashCode(), r15, r14, "onResume", r11));
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r5, Bundle r10) {
        int r11 = this.f3577a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r10) {
        switch(this.f3577a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        m9.c r5 = (m9.c) this.f3578b;
        r5.getClass();
        r5.f20038i = r10.getClass().getName();
        r5.f20039j = System.currentTimeMillis();
        String r11 = r5.f20038i;
        long r12 = r5.f20039j;
        m9.c.d(r10.hashCode(), r12, r11, "onStart", r5);
        return;
    L6:
        a(r10);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r10) {
        switch(this.f3577a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        m9.c r5 = (m9.c) this.f3578b;
        r5.getClass();
        r5.f20045p = r10.getClass().getName();
        r5.f20046q = System.currentTimeMillis();
        String r11 = r5.f20045p;
        long r12 = r5.f20046q;
        m9.c.d(r10.hashCode(), r12, r11, "onStop", r5);
        return;
    }

    public f(m9.c r5) {
        this.f3577a = 1;
        this.f3578b = r5;
    }
}
