package com.bytedance.android.monitorV2;

import android.content.SharedPreferences;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.monitorV2.listener.a f3535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f3536b;

    public e(h r5) {
        this.f3536b = r5;
        this.f3535a = new com.bytedance.android.monitorV2.listener.a(0);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences r5, String r10) {
        boolean r11 = r5.getBoolean("monitor_validation_switch", false);
        com.bytedance.android.monitorV2.listener.a r12 = this.f3535a;
        h r13 = this.f3536b;
        if (r11 == false) goto L23;
        CopyOnWriteArrayList r14 = r13.f3585i;
        if (r14 != null) goto L7;
    L16:
        monitor-enter(r12);
        r13.f3585i.add(r12);     // Catch: Throwable -> L20
        monitor-exit(r12);     // Catch: Throwable -> L20
        com.bytedance.apm.j.f3887a = true;
        td.b.f22124a = true;
    L36:
        boolean r15 = u4.c.f22245a;
        u4.c.f22245a = r5.getBoolean("monitor_immediate_switch", false);
        com.bytedance.apm.util.a.d = r5.getBoolean("monitor_hdt_ignore_sample", false);
        com.bytedance.apm.util.a.e = r5.getBoolean("monitor_skip_inject_check", false);
        return;
    L20:
        th = move-exception;
        throw th;
    L7:
        if (r14.size() == 0) goto L16;
        monitor-enter(r12);
        r13.f3585i.remove(r12);     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L23:
        CopyOnWriteArrayList r16 = r13.f3585i;
        if (r16 != null) goto L26;
    L35:
        com.bytedance.apm.j.f3887a = false;
        td.b.f22124a = false;
        goto L36
    L26:
        if (r16.size() == 0) goto L35;
        monitor-enter(r12);
        r13.f3585i.remove(r12);     // Catch: Throwable -> L32
        monitor-exit(r12);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }
}
