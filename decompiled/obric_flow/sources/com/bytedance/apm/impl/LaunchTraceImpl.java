package com.bytedance.apm.impl;

import a7.c;
import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.j;
import com.bytedance.services.apm.api.ILaunchTrace;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import jg.i;
import m6.b;
import mh.e;
import q7.a;

/* JADX INFO: loaded from: classes2.dex */
public class LaunchTraceImpl implements ILaunchTrace {
    public LaunchTraceImpl() {
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void cancelTrace() {
        if (e.f20096h == false) goto L5;
        e.u();
    L5:
        c r5 = e.g;
        if (r5 == null) goto L9;
        ((ConcurrentHashMap) r5.f144c).clear();
        e.g = null;
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endSpan(String r10, String r11) {
        c r5 = e.g;
        if (r5 == null) goto L9;
        ConcurrentHashMap r12 = (ConcurrentHashMap) r5.f144c;
        b r13 = (b) r12.get(r10 + "#" + r11);
        if (r13 == null) goto L10;
        long r14 = System.currentTimeMillis();
        String r15 = Thread.currentThread().getName();
        r13.f20017b = r14;
        r13.f20018c = r15;
        r12.put(r10 + "#" + r11, r13);
        return;
    L10:
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endTrace(int r16, String r17, long r18) {
        if (e.f20096h == false) goto L5;
        e.u();
    L5:
        c r11 = e.g;
        if (r11 != null) goto L8;
        return;
    L8:
        if (r16 == (-1)) goto L10;
    L14:
        boolean r5 = r11.f();
        a r12 = o6.a.f20411a;
        if (r5 == true) goto L17;
    L20:
        long r10 = System.currentTimeMillis();
        r11.f143b = r10;
        long r13 = r10 - r11.f142a;
        if (r18 <= 0) goto L26;
        if (r13 <= r18) goto L26;
        return;
    L26:
        if (r11.f() == false) goto L35;
        if (xg.b.f23142k == false) goto L35;
        if (c.f == false) goto L35;
        c.f = false;
        long r14 = r11.f142a;
        long r15 = r11.f143b;
        long[] r19 = MethodCollector.getInstance().copyAllData();
        long r20 = SystemClock.uptimeMillis();
        if (r19 == null) goto L35;
        z6.b.f23409a.d(new a7.b(r19, r20, r15, r14, r16));
    L35:
        if (r11.f() == false) goto L37;
        r12.l().getClass();
    L37:
        z6.b.f23409a.d(new a7.a(r11, r16, r17, 0));
        if (r11.f() == false) goto L42;
        ExecutorService r21 = com.bytedance.apm.launch.evil.a.f3895a;
        return;
    L42:
        return;
    L17:
        if (o6.a.f20412b == true) goto L20;
        o6.a.f20412b = true;
        r12.i().getClass();
        goto L20
    L10:
        if (j.f3887a == false) goto L14;
        throw new IllegalArgumentException("Launch mode is both none");
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startSpan(String r5, String r10) {
        c r11 = e.g;
        if (r11 == null) goto L9;
        ConcurrentHashMap r12 = (ConcurrentHashMap) r11.f144c;
        if (((b) r12.get(r5 + "#" + r10)) != null) goto L10;
        long r13 = System.currentTimeMillis();
        b r14 = new b();
        r14.f20016a = r13;
        r12.put(r5 + "#" + r10, r14);
        return;
    L10:
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startTrace() {
        c r5 = new c();
        e.g = r5;
        r5.f142a = System.currentTimeMillis();
        if (j.d() == false) goto L29;
        boolean r10 = EvilMethodSwitcher.isOpenLaunchEvilMethod();
        e.f20096h = r10;
        if (r10 == true) goto L7;
        return;
    L7:
        monitor-enter(e.class);
    L21:
        th = move-exception;
        throw th;
    L9:
        if (e.d == false) goto L13;
        monitor-exit(e.class);
        return;
    L13:
        e.d = true;     // Catch: Throwable -> L21
        if (e.e == true) goto L24;
        e.e = true;     // Catch: Throwable -> L21
        long r11 = EvilMethodSwitcher.getLaunchEvilThresholdMs();     // Catch: Throwable -> L21
        if (r11 >= 70) goto L18;
        r11 = 1000;
    L18:
        xg.b.f23140i = r11;     // Catch: Throwable -> L21
        xg.b.f23142k = true;     // Catch: Throwable -> L21
        if (EvilMethodSwitcher.isMessageKeyEnable() == false) goto L23;
        PerfConfig.setReportMessage();     // Catch: Throwable -> L21
    L23:
        d6.c.f16598k.b();     // Catch: Throwable -> L21
        MethodCollector.getInstance().onStart();     // Catch: Throwable -> L21
        xg.b.f23141j = true;     // Catch: Throwable -> L21
        EvilMethodSwitcher.isLaunchLimitEvilMethodDepth();     // Catch: Throwable -> L21
        xg.b r12 = new xg.b(true);     // Catch: Throwable -> L21
        e.f = r12;     // Catch: Throwable -> L21
        r12.b();     // Catch: Throwable -> L21
        i.a(true, "launch", null);     // Catch: Throwable -> L21
        new Handler().postDelayed(new com.bytedance.android.anniex.worker.a(2), 10000);     // Catch: Throwable -> L21
    L24:
        com.bytedance.apm.block.b.f3854c = true;     // Catch: Throwable -> L21
        com.bytedance.apm.block.b.f3852a.add("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L21
        monitor-exit(e.class);
        return;
    }
}
