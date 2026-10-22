package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import androidx.lifecycle.p;
import androidx.work.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import s1.v;
import s1.w;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
public class SystemAlarmService extends p implements d.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f2849n = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f2850b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2851m;

    static {
        f2849n = m.f("SystemAlarmService");
    }

    public SystemAlarmService() {
    }

    public final void a() {
        this.f2851m = true;
        m.d().a(f2849n, "All commands completed in dispatcher");
        String r8 = v.f12005a;
        LinkedHashMap r10 = new LinkedHashMap();
        w r11 = w.f12006a;
        monitor-enter(r11);
        r10.putAll(w.f12007b);     // Catch: Throwable -> L19
        j r12 = j.f13877a;     // Catch: Throwable -> L19
        monitor-exit(r11);
        Iterator r13 = r10.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L17;
        Map.Entry r14 = (Map.Entry) r13.next();
        PowerManager.WakeLock r15 = (PowerManager.WakeLock) r14.getKey();
        String r16 = (String) r14.getValue();
        if (r15 != null) goto L12;
    L14:
        boolean r17 = false;
    L15:
        if (r17 == false) goto L8;
        m.d().g(v.f12005a, "WakeLock held for " + r16);
        goto L8
    L12:
        if (r15.isHeld() != true) goto L14;
        r17 = true;
        goto L15
    L17:
        stopSelf();
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // androidx.lifecycle.p, android.app.Service
    public final void onCreate() {
        super.onCreate();
        d r8 = new d(this);
        this.f2850b = r8;
        if (r8.f2883s == null) goto L5;
        m.d().b(d.f2874t, "A completion listener for SystemAlarmDispatcher already exists.");
    L6:
        this.f2851m = false;
        return;
    L5:
        r8.f2883s = this;
        goto L6
    }

    @Override // androidx.lifecycle.p, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f2851m = true;
        d r8 = this.f2850b;
        r8.getClass();
        m.d().a(d.f2874t, "Destroying SystemAlarmDispatcher");
        j1.p r10 = r8.f2878n;
        Object r11 = r10.f8535v;
        monitor-enter(r11);
        r10.f8534u.remove(r8);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        r8.f2883s = null;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.lifecycle.p, android.app.Service
    public final int onStartCommand(Intent r8, int r10, int r11) {
        super.onStartCommand(r8, r10, r11);
        if (this.f2851m == false) goto L16;
        m.d().e(f2849n, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
        d r12 = this.f2850b;
        r12.getClass();
        m r13 = m.d();
        String r14 = d.f2874t;
        r13.a(r14, "Destroying SystemAlarmDispatcher");
        j1.p r15 = r12.f2878n;
        Object r16 = r15.f8535v;
        monitor-enter(r16);
        r15.f8534u.remove(r12);     // Catch: Throwable -> L13
        monitor-exit(r16);     // Catch: Throwable -> L13
        r12.f2883s = null;
        d r17 = new d(this);
        this.f2850b = r17;
        if (r17.f2883s == null) goto L11;
        m.d().b(r14, "A completion listener for SystemAlarmDispatcher already exists.");
    L12:
        this.f2851m = false;
        goto L16
    L11:
        r17.f2883s = this;
    L13:
        th = move-exception;
        throw th;
    L16:
        if (r8 == null) goto L22;
        this.f2850b.a(r8, r11);
        return 3;
    L22:
        return 3;
    }
}
