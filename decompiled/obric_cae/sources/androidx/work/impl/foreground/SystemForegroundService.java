package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.p;
import androidx.work.h;
import androidx.work.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import q1.c;
import r1.l;

/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundService extends p implements androidx.work.impl.foreground.a.InterfaceC0024a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f2894p = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f2895b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2896m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public androidx.work.impl.foreground.a f2897n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public NotificationManager f2898o;

    public static class a {
        public static void a(Service r8, int r10, Notification r11, int r12) {
            r8.startForeground(r10, r11, r12);     // Catch: ForegroundServiceStartNotAllowedException -> L4
            return;
        L4:
            e = move-exception;
            m r13 = m.d();
            String r14 = SystemForegroundService.f2894p;
            if (((m.a) r13).f2930c > 5) goto L11;
            Log.w(r14, "Unable to start foreground service", e);
            return;
        }
    }

    static {
        f2894p = m.f("SystemFgService");
    }

    public SystemForegroundService() {
    }

    public final void a() {
        this.f2895b = new Handler(Looper.getMainLooper());
        this.f2898o = (NotificationManager) getApplicationContext().getSystemService("notification");
        androidx.work.impl.foreground.a r8 = new androidx.work.impl.foreground.a(getApplicationContext());
        this.f2897n = r8;
        if (r8.f2908s == null) goto L5;
        m.d().b(androidx.work.impl.foreground.a.f2899t, "A callback already exists.");
        return;
    L5:
        r8.f2908s = this;
    }

    @Override // androidx.lifecycle.p, android.app.Service
    public final void onCreate() {
        super.onCreate();
        a();
    }

    @Override // androidx.lifecycle.p, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        androidx.work.impl.foreground.a r8 = this.f2897n;
        r8.f2908s = null;
        Object r10 = r8.f2902m;
        monitor-enter(r10);
        r8.f2907r.e();     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        j1.p r11 = r8.f2900a.f8456f;
        Object r12 = r11.f8535v;
        monitor-enter(r12);
        r11.f8534u.remove(r8);     // Catch: Throwable -> L11
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // androidx.lifecycle.p, android.app.Service
    public final int onStartCommand(Intent r8, int r10, int r11) {
        super.onStartCommand(r8, r10, r11);
        boolean r12 = this.f2896m;
        String r13 = f2894p;
        int r14 = 0;
        if (r12 == false) goto L19;
        m.d().e(r13, "Re-initializing SystemForegroundService after a request to shut-down.");
        androidx.work.impl.foreground.a r15 = this.f2897n;
        r15.f2908s = null;
        Object r16 = r15.f2902m;
        monitor-enter(r16);
        r15.f2907r.e();     // Catch: Throwable -> L16
        monitor-exit(r16);     // Catch: Throwable -> L16
        j1.p r17 = r15.f2900a.f8456f;
        Object r18 = r17.f8535v;
        monitor-enter(r18);
        r17.f8534u.remove(r15);     // Catch: Throwable -> L13
        monitor-exit(r18);     // Catch: Throwable -> L13
        a();
        this.f2896m = false;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    L19:
        if (r8 == null) goto L60;
        androidx.work.impl.foreground.a r19 = this.f2897n;
        r19.getClass();
        String r20 = r8.getAction();
        boolean r21 = "ACTION_START_FOREGROUND".equals(r20);
        String r22 = androidx.work.impl.foreground.a.f2899t;
        if (r21 == false) goto L24;
        m.d().e(r22, "Started foreground service " + r8);
        r19.f2901b.a(new q1.b(r19, r8.getStringExtra("KEY_WORKSPEC_ID")));
    L25:
        int r23 = r8.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int r110 = r8.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String r24 = r8.getStringExtra("KEY_WORKSPEC_ID");
        l r25 = new l(r24, r8.getIntExtra("KEY_GENERATION", 0));
        Notification r26 = (Notification) r8.getParcelableExtra("KEY_NOTIFICATION");
        m.d().a(r22, "Notifying with (id:" + r23 + ", workSpecId: " + r24 + ", notificationType :" + r110 + ")");
        if (r26 != null) goto L28;
        return 3;
    L28:
        if (r19.f2908s == null) goto L62;
        h r27 = new h(r23, r110, r26);
        LinkedHashMap r28 = r19.f2904o;
        r28.put(r25, r27);
        if (r19.f2903n != null) goto L32;
        r19.f2903n = r25;
        SystemForegroundService r29 = (SystemForegroundService) r19.f2908s;
        r29.f2895b.post(new b(r29, r23, r26, r110));
        return 3;
    L32:
        SystemForegroundService r30 = (SystemForegroundService) r19.f2908s;
        r30.f2895b.post(new c(r30, r23, r26));
        if (r110 == 0) goto L64;
        Iterator r31 = r28.entrySet().iterator();
    L36:
        if (r31.hasNext() == false) goto L38;
        r14 = r14 | ((h) ((Map.Entry) r31.next()).getValue()).f2833b;
        goto L36
    L38:
        h r32 = (h) r28.get(r19.f2903n);
        if (r32 == null) goto L65;
        SystemForegroundService r33 = (SystemForegroundService) r19.f2908s;
        r33.f2895b.post(new b(r33, r32.f2832a, r32.f2834c, r14));
        return 3;
    L65:
        return 3;
    L64:
        return 3;
    L62:
        return 3;
    L24:
        if ("ACTION_NOTIFY".equals(r20) == true) goto L25;
        if ("ACTION_CANCEL_WORK".equals(r20) == false) goto L49;
        m.d().e(r22, "Stopping foreground work for " + r8);
        String r34 = r8.getStringExtra("KEY_WORKSPEC_ID");
        if (r34 != null) goto L46;
        return 3;
    L46:
        if (TextUtils.isEmpty(r34) == true) goto L68;
        r19.f2900a.d(UUID.fromString(r34));
        return 3;
    L68:
        return 3;
    L49:
        if ("ACTION_STOP_FOREGROUND".equals(r20) == false) goto L70;
        m.d().e(r22, "Stopping foreground service");
        androidx.work.impl.foreground.a.InterfaceC0024a r35 = r19.f2908s;
        if (r35 == null) goto L71;
        SystemForegroundService r36 = (SystemForegroundService) r35;
        r36.f2896m = true;
        m.d().a(r13, "All commands completed.");
        r36.stopForeground(true);
        r36.stopSelf();
        return 3;
    L71:
        return 3;
    L70:
        return 3;
    L60:
        return 3;
    }
}
