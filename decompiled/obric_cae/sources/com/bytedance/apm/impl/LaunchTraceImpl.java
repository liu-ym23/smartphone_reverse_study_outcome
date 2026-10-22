package com.bytedance.apm.impl;

import android.os.Handler;
import android.os.SystemClock;
import c2.k;
import c3.c;
import c3.d;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.services.apm.api.ILaunchTrace;
import i2.e;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class LaunchTraceImpl implements ILaunchTrace {
    public LaunchTraceImpl() {
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void cancelTrace() {
        if (c3.a.f3308b == false) goto L5;
        t2.b.Z();
    L5:
        d r8 = c3.a.f3307a;
        if (r8 == null) goto L9;
        r8.f3322c.clear();
        c3.a.f3307a = null;
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endSpan(String r8, String r10) {
        d r11 = c3.a.f3307a;
        if (r11 == null) goto L9;
        ConcurrentHashMap<String, r2.a> r12 = r11.f3322c;
        r2.a r13 = r12.get(r8 + "#" + r10);
        if (r13 == null) goto L10;
        long r14 = System.currentTimeMillis();
        String r15 = Thread.currentThread().getName();
        r13.f11388b = r14;
        r13.f11389c = r15;
        r12.put(r8 + "#" + r10, r13);
        return;
    L10:
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endTrace(int r15, String r16, long r17) {
        if (c3.a.f3308b == false) goto L5;
        t2.b.Z();
    L5:
        d r10 = c3.a.f3307a;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r15 == (-1)) goto L10;
    L14:
        boolean r8 = r10.a();
        s2.a r11 = s2.a.C0150a.f12020a;
        if (r8 == true) goto L17;
    L20:
        long r12 = System.currentTimeMillis();
        r10.f3321b = r12;
        long r13 = r12 - r10.f3320a;
        if (r17 <= 0) goto L26;
        if (r13 <= r17) goto L26;
        return;
    L26:
        if (r10.a() == false) goto L48;
        if (h8.a.f7925k == false) goto L48;
        if (d.f3319f == false) goto L48;
        d.f3319f = false;
        long r14 = r10.f3320a;
        long r18 = r10.f3321b;
        e.C0090e r19 = e.f8122r;     // Catch: Throwable -> L63
        if (r19 == null) goto L43;
        e.C0090e r20 = e.f8123s;     // Catch: Throwable -> L63
        if (r20 == null) goto L43;
        if (r19 == r20) goto L43;
        int r21 = r19.f8125b;     // Catch: Throwable -> L63
        if (r21 != 0) goto L41;
        r21 = e.f8109e - 1;     // Catch: Throwable -> L63
    L41:
        long[] r22 = e.a(r20.f8124a, r21);     // Catch: Throwable -> L63
    L44:
        long[] r23 = r22;
        long r24 = SystemClock.uptimeMillis();
        if (r23 == null) goto L48;
        b3.b.C0032b.f3038a.c(new c(r23, r24, r18, r14, r15));
    L43:
        r22 = null;
    L48:
        if (r10.a() == false) goto L59;
        monitor-enter(r11);
    L56:
        th = move-exception;
        throw th;
    L51:
        if (r11.f12019b != null) goto L53;
        r11.f12019b = new c3.a.C0038a(new c3.a.C0038a.C0039a());     // Catch: Throwable -> L56
    L53:
        c3.a.C0038a r25 = r11.f12019b;     // Catch: Throwable -> L56
        monitor-exit(r11);
        r25.getClass();
    L59:
        b3.b.C0032b.f3038a.c(new c3.b(r10, r15, r16));
        if (r10.a() == false) goto L69;
        int r26 = t2.c.f12267a;
        return;
    L69:
        return;
    L17:
        if (t2.b.F == true) goto L20;
        t2.b.F = true;
        r11.a().getClass();
        goto L20
    L10:
        if (k.d() == false) goto L14;
        throw new IllegalArgumentException("Launch mode is both none");
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startSpan(String r8, String r10) {
        d r11 = c3.a.f3307a;
        if (r11 == null) goto L9;
        ConcurrentHashMap<String, r2.a> r12 = r11.f3322c;
        if (r12.get(r8 + "#" + r10) != null) goto L10;
        r12.put(r8 + "#" + r10, new r2.a(System.currentTimeMillis()));
        return;
    L10:
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startTrace() {
        d r8 = new d();
        c3.a.f3307a = r8;
        r8.f3320a = System.currentTimeMillis();
        if (k.f() == false) goto L62;
        boolean r10 = EvilMethodSwitcher.isOpenLaunchEvilMethod();
        c3.a.f3308b = r10;
        if (r10 == true) goto L7;
        return;
    L7:
        monitor-enter(t2.b.class);
    L59:
        th = move-exception;
        throw th;
    L9:
        if (t2.b.f12241a == true) goto L57;
        t2.b.f12241a = true;     // Catch: Throwable -> L59
        if (t2.b.f12242b == true) goto L56;
        t2.b.f12242b = true;     // Catch: Throwable -> L59
        long r11 = EvilMethodSwitcher.getLaunchEvilThresholdMs();     // Catch: Throwable -> L59
        if (r11 >= 70) goto L16;
        r11 = 1000;
    L16:
        h8.a.f7923i = r11;     // Catch: Throwable -> L59
        h8.a.f7925k = true;     // Catch: Throwable -> L59
        if (EvilMethodSwitcher.isMessageKeyEnable() == false) goto L19;
        PerfConfig.setReportMessage();     // Catch: Throwable -> L59
    L19:
        i2.b r12 = i2.b.f8089k;     // Catch: Throwable -> L59
        r12.d();     // Catch: Throwable -> L59
        e.f();     // Catch: Throwable -> L59
        h8.a.f7924j = true;     // Catch: Throwable -> L59
        EvilMethodSwitcher.isLaunchLimitEvilMethodDepth();     // Catch: Throwable -> L59
        h8.a r13 = new h8.a(true);     // Catch: Throwable -> L59
        t2.b.f12243c = r13;     // Catch: Throwable -> L59
        monitor-enter(r13);     // Catch: Throwable -> L59
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L59
    L22:
        if (r13.f7932g == false) goto L26;
    L23:
        monitor-exit(r13);     // Catch: Throwable -> L59
        a8.e.a(true, "launch", null);     // Catch: Throwable -> L59
        new Handler().postDelayed(new t2.a(), 10000);     // Catch: Throwable -> L59
        goto L56
    L26:
        if (h8.a.f7925k == true) goto L28;
    L50:
        r13.f7932g = true;     // Catch: Throwable -> L53
        goto L23
    L28:
        if (h8.a.f7924j == false) goto L50;
        if (r12.f8090a == true) goto L48;
        monitor-enter(r12);     // Catch: Throwable -> L53
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53
    L33:
        if (k.f() == true) goto L36;
    L40:
        monitor-exit(r12);     // Catch: Throwable -> L53
        goto L48
    L36:
        if (r12.f8099j == false) goto L43;
        if (r12.f8090a == true) goto L40;
        r12.f8090a = true;     // Catch: Throwable -> L44
        goto L40
    L43:
        throw new RuntimeException("never init!");     // Catch: Throwable -> L44
    L48:
        if (r12.f8093d.contains(r13) == true) goto L50;
        r12.f8093d.add(r13);     // Catch: Throwable -> L53
    L56:
        com.bytedance.apm.block.c.f3756c = true;     // Catch: Throwable -> L59
        com.bytedance.apm.block.c.f3754a.add("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L59
    L57:
        monitor-exit(t2.b.class);
        return;
    }
}
