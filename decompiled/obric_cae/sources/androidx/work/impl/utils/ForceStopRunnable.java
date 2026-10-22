package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.work.c;
import androidx.work.impl.WorkDatabase;
import androidx.work.m;
import j1.b0;
import j1.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import l6.a;
import m1.b;
import r1.d;
import r1.l;
import r1.q;
import r1.t;
import r1.u;
import s1.n;
import s1.o;

/* JADX INFO: loaded from: classes.dex */
public final class ForceStopRunnable implements Runnable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f2913o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f2914p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f2916b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final n f2917m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2918n;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f2919a = null;

        static {
            f2919a = m.f("ForceStopRunnable$Rcvr");
        }

        public BroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r8, Intent r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if ("ACTION_FORCE_STOP_RESCHEDULE".equals(r10.getAction()) == true) goto L6;
            return;
        L6:
            if (((m.a) m.d()).f2930c > 2) goto L8;
            Log.v(f2919a, "Rescheduling alarm that keeps track of force-stops.");
        L8:
            String r11 = ForceStopRunnable.f2913o;
            AlarmManager r12 = (AlarmManager) r8.getSystemService("alarm");
            Intent r13 = new Intent();
            r13.setComponent(new ComponentName(r8, BroadcastReceiver.class));
            r13.setAction("ACTION_FORCE_STOP_RESCHEDULE");
            PendingIntent r14 = PendingIntent.getBroadcast(r8, -1, r13, 167772160);
            long r15 = System.currentTimeMillis() + ForceStopRunnable.f2914p;
            if (r12 == null) goto L14;
            r12.setExact(0, r15, r14);
            return;
        }
    }

    static {
        f2913o = m.f("ForceStopRunnable");
        f2914p = TimeUnit.DAYS.toMillis(3650);
    }

    public ForceStopRunnable(Context r8, b0 r10) {
        this.f2915a = r8.getApplicationContext();
        this.f2916b = r10;
        this.f2917m = r10.f8457g;
        this.f2918n = 0;
    }

    public final void a() {
        n r8 = this.f2917m;
        String r10 = b.f9248o;
        Context r11 = this.f2915a;
        JobScheduler r12 = (JobScheduler) r11.getSystemService("jobscheduler");
        ArrayList r13 = b.e(r11, r12);
        b0 r14 = this.f2916b;
        ArrayList r15 = r14.f8453c.c().c();
        boolean r16 = false;
        if (r13 == null) goto L5;
        int r17 = r13.size();
    L6:
        HashSet r18 = new HashSet(r17);
        if (r13 != null) goto L9;
    L17:
        Iterator r19 = r15.iterator();
    L19:
        if (r19.hasNext() == false) goto L23;
        if (r18.contains((String) r19.next()) == true) goto L19;
        m.d().a(b.f9248o, "Reconciling jobs");
        boolean r20 = true;
    L25:
        if (r20 == false) goto L36;
        WorkDatabase r21 = r14.f8453c;
        r21.beginTransaction();
        u r110 = r21.f();     // Catch: Throwable -> L33
        Iterator r22 = r15.iterator();     // Catch: Throwable -> L33
    L29:
        if (r22.hasNext() == false) goto L31;
        r110.b(-1, (String) r22.next());     // Catch: Throwable -> L33
        goto L29
    L31:
        r21.setTransactionSuccessful();     // Catch: Throwable -> L33
        r21.endTransaction();
    L33:
        th = move-exception;
        r21.endTransaction();
        throw th;
    L36:
        WorkDatabase r23 = r14.f8453c;
        u r24 = r23.f();
        q r111 = r23.e();
        r23.beginTransaction();
        ArrayList r112 = r24.r();     // Catch: Throwable -> L94
        if (r112 != null) goto L40;
    L42:
        boolean r113 = false;
    L43:
        if (r113 == false) goto L48;
        Iterator r114 = r112.iterator();     // Catch: Throwable -> L94
    L46:
        if (r114.hasNext() == false) goto L48;
        t r115 = (t) r114.next();     // Catch: Throwable -> L94
        r24.n(androidx.work.u.a.f2952a, r115.f11339a);     // Catch: Throwable -> L94
        r24.b(-1, r115.f11339a);     // Catch: Throwable -> L94
    L48:
        r111.b();     // Catch: Throwable -> L94
        r23.setTransactionSuccessful();     // Catch: Throwable -> L94
        r23.endTransaction();
        if (r113 == true) goto L54;
        if (r20 == true) goto L54;
        boolean r25 = false;
    L55:
        Long r26 = r14.f8457g.f11988a.b().b("reschedule_needed");
        if (r26 != null) goto L58;
    L60:
        boolean r27 = false;
    L61:
        long r28 = 0;
        String r116 = f2913o;
        if (r27 == false) goto L101;
        m.d().a(r116, "Rescheduling Workers.");
        r14.k();
        n r29 = r14.f8457g;
        r29.getClass();
        r29.f11988a.b().a(new d(0L, "reschedule_needed"));
        return;
    L101:
        Intent r30 = new Intent();     // Catch: Throwable -> L84
        r30.setComponent(new ComponentName(r11, BroadcastReceiver.class));     // Catch: Throwable -> L84
        r30.setAction("ACTION_FORCE_STOP_RESCHEDULE");     // Catch: Throwable -> L84
        PendingIntent r31 = PendingIntent.getBroadcast(r11, -1, r30, 570425344);     // Catch: Throwable -> L84
        if (r31 == null) goto L67;
        r31.cancel();     // Catch: Throwable -> L84
    L67:
        List<ApplicationExitInfo> r32 = ((ActivityManager) r11.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);     // Catch: Throwable -> L84
        if (r32 != null) goto L70;
    L89:
        if (r16 == false) goto L91;
        m.d().a(r116, "Application was force-stopped, rescheduling.");
        r14.k();
        long r33 = System.currentTimeMillis();
        r8.getClass();
        r8.f11988a.b().a(new d(Long.valueOf(r33), "last_force_stop_ms"));
        return;
    L91:
        if (r25 == false) goto L120;
        m.d().a(r116, "Found unfinished work, scheduling it.");
        s.a(r14.f8452b, r14.f8453c, r14.f8455e);
        return;
    L120:
        return;
    L70:
        if (r32.isEmpty() == true) goto L89;
        Long r34 = r8.f11988a.b().b("last_force_stop_ms");     // Catch: Throwable -> L84
        if (r34 == null) goto L74;
        r28 = r34.longValue();     // Catch: Throwable -> L84
    L74:
        int r35 = 0;
    L75:
        if (r35 >= r32.size()) goto L89;
        ApplicationExitInfo r36 = r32.get(r35);     // Catch: Throwable -> L84
        if (r36.getReason() != 10) goto L83;
        if (r36.getTimestamp() < r28) goto L83;
    L88:
        r16 = true;
    L83:
        r35 = r35 + 1;
    L84:
        e = move-exception;
        if (((m.a) m.d()).f2930c > 5) goto L88;
        Log.w(r116, "Ignoring exception", e);
        goto L88
    L58:
        if (r26.longValue() != 1) goto L60;
        r27 = true;
    L54:
        r25 = true;
        goto L55
    L40:
        if (r112.isEmpty() == true) goto L42;
        r113 = true;
    L94:
        th = move-exception;
        r23.endTransaction();
        throw th;
    L23:
        r20 = false;
        goto L25
    L9:
        if (r13.isEmpty() == true) goto L17;
        Iterator r37 = r13.iterator();
    L12:
        if (r37.hasNext() == false) goto L17;
        JobInfo r38 = (JobInfo) r37.next();
        l r117 = b.f(r38);
        if (r117 != null) goto L15;
        b.c(r12, r38.getId());
        goto L12
    L15:
        r18.add(r117.f11324a);
        goto L12
    L5:
        r17 = 0;
        goto L6
    }

    public final boolean b() {
        c r8 = this.f2916b.f8452b;
        boolean r10 = TextUtils.isEmpty(r8.f2801f);
        String r11 = f2913o;
        if (r10 == false) goto L6;
        m.d().a(r11, "The default process name was not specified.");
        return true;
    L6:
        boolean r12 = o.a(this.f2915a, r8);
        m.d().a(r11, "Is default app process = " + r12);
        return r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r8 = f2913o;
        b0 r10 = this.f2916b;
    L27:
        th = move-exception;
        r10.j();
        throw th;
    L4:
        if (b() == true) goto L36;
        r10.j();
        return;
    L36:
        a.o0(this.f2915a);     // Catch: SQLiteException -> L24 Throwable -> L27
        m.d().a(r8, "Performing cleanup operations.");     // Catch: Throwable -> L27
        a();     // Catch: Throwable -> L12 Throwable -> L27
    L10:
        r10.j();
        return;
    L12:
        e = move-exception;
        int r11 = this.f2918n + 1;     // Catch: Throwable -> L27
        this.f2918n = r11;     // Catch: Throwable -> L27
        if (r11 >= 3) goto L22;
        long r12 = ((long) r11) * 300;     // Catch: Throwable -> L27
        String r13 = "Retrying after " + r12;     // Catch: Throwable -> L27
        if (((m.a) m.d()).f2930c > 3) goto L34;
        Log.d(r8, r13, e);     // Catch: Throwable -> L27
    L34:
        Thread.sleep(((long) this.f2918n) * 300);     // Catch: InterruptedException -> L30 Throwable -> L27
        goto L36
    L22:
        m.d().c(r8, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);     // Catch: Throwable -> L27
        IllegalStateException r14 = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);     // Catch: Throwable -> L27
        r10.f8452b.getClass();     // Catch: Throwable -> L27
        throw r14;     // Catch: Throwable -> L27
    L24:
        e = move-exception;
        m.d().b(r8, "Unexpected SQLite exception during migrations");     // Catch: Throwable -> L27
        IllegalStateException r15 = new IllegalStateException("Unexpected SQLite exception during migrations", e);     // Catch: Throwable -> L27
        r10.f8452b.getClass();     // Catch: Throwable -> L27
        throw r15;     // Catch: Throwable -> L27
    }
}
