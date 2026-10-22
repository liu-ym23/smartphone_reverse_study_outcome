package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.m;
import j1.b0;
import j1.p;
import java.util.ArrayList;
import java.util.Iterator;
import r1.l;
import s1.d0;
import s1.v;

/* JADX INFO: loaded from: classes.dex */
public final class d implements j1.c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f2874t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u1.a f2876b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d0 f2877m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final p f2878n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b0 f2879o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final androidx.work.impl.background.systemalarm.a f2880p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList f2881q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Intent f2882r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public c f2883s;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f2884a;

        public a(d r8) {
            this.f2884a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList r8 = this.f2884a.f2881q;
            monitor-enter(r8);
            d r10 = this.f2884a;     // Catch: Throwable -> L19
            r10.f2882r = (Intent) r10.f2881q.get(0);     // Catch: Throwable -> L19
            monitor-exit(r8);     // Catch: Throwable -> L19
            Intent r11 = this.f2884a.f2882r;
            if (r11 == null) goto L18;
            String r12 = r11.getAction();
            int r13 = this.f2884a.f2882r.getIntExtra("KEY_START_ID", 0);
            m r14 = m.d();
            String r15 = d.f2874t;
            r14.a(r15, "Processing command " + this.f2884a.f2882r + ", " + r13);
            PowerManager.WakeLock r16 = v.a(this.f2884a.f2875a, r12 + " (" + r13 + ")");
            m.d().a(r15, "Acquiring operation wake lock (" + r12 + ") " + r16);     // Catch: Throwable -> L11
            r16.acquire();     // Catch: Throwable -> L11
            d r17 = this.f2884a;     // Catch: Throwable -> L11
            r17.f2880p.a(r13, r17.f2882r, r17);     // Catch: Throwable -> L11
            m.d().a(r15, "Releasing operation wake lock (" + r12 + ") " + r16);
            r16.release();
            d r18 = this.f2884a;
            u1.b.a r19 = ((u1.b) r18.f2876b).f12422c;
            RunnableC0023d r20 = new RunnableC0023d(r18);
        L14:
            r19.execute(r20);
            return;
        L11:
            th = move-exception;
            m r21 = m.d();     // Catch: Throwable -> L15
            String r22 = d.f2874t;     // Catch: Throwable -> L15
            r21.c(r22, "Unexpected error in onHandleIntent", th);     // Catch: Throwable -> L15
            m.d().a(r22, "Releasing operation wake lock (" + r12 + ") " + r16);
            r16.release();
            d r23 = this.f2884a;
            r19 = ((u1.b) r23.f2876b).f12422c;
            r20 = new RunnableC0023d(r23);
        L15:
            th = move-exception;
            m.d().a(d.f2874t, "Releasing operation wake lock (" + r12 + ") " + r16);
            r16.release();
            d r24 = this.f2884a;
            ((u1.b) r24.f2876b).f12422c.execute(new RunnableC0023d(r24));
            throw th;
        L18:
            return;
        L19:
            th = move-exception;
            throw th;
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f2885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Intent f2886b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f2887m;

        public b(int r8, Intent r10, d r11) {
            this.f2885a = r11;
            this.f2886b = r10;
            this.f2887m = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r8 = this.f2887m;
            this.f2885a.a(this.f2886b, r8);
        }
    }

    public interface c {
    }

    /* JADX INFO: renamed from: androidx.work.impl.background.systemalarm.d$d, reason: collision with other inner class name */
    public static class RunnableC0023d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f2888a;

        public RunnableC0023d(d r8) {
            this.f2888a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r8 = this.f2888a;
            r8.getClass();
            m r10 = m.d();
            String r11 = d.f2874t;
            r10.a(r11, "Checking if commands are complete.");
            d.b();
            ArrayList r12 = r8.f2881q;
            monitor-enter(r12);
        L38:
            th = move-exception;
            throw th;
        L5:
            if (r8.f2882r == null) goto L11;
            m.d().a(r11, "Removing command " + r8.f2882r);     // Catch: Throwable -> L38
            if (((Intent) r8.f2881q.remove(0)).equals(r8.f2882r) == false) goto L10;
            r8.f2882r = null;     // Catch: Throwable -> L38
            goto L11
        L10:
            throw new IllegalStateException("Dequeue-d command is not the first.");     // Catch: Throwable -> L38
        L11:
            s1.p r13 = ((u1.b) r8.f2876b).f12420a;     // Catch: Throwable -> L38
            androidx.work.impl.background.systemalarm.a r14 = r8.f2880p;     // Catch: Throwable -> L38
            Object r15 = r14.f2855m;     // Catch: Throwable -> L38
            monitor-enter(r15);     // Catch: Throwable -> L38
            boolean r16 = !r14.f2854b.isEmpty();     // Catch: Throwable -> L35
            monitor-exit(r15);     // Catch: Throwable -> L35
            if (r16 == true) goto L31;
            if (r8.f2881q.isEmpty() == false) goto L31;
            Object r17 = r13.f11992n;     // Catch: Throwable -> L38
            monitor-enter(r17);     // Catch: Throwable -> L38
            boolean r18 = !r13.f11989a.isEmpty();     // Catch: Throwable -> L27
            monitor-exit(r17);     // Catch: Throwable -> L27
            if (r18 == true) goto L31;
            m.d().a(r11, "No more commands & intents.");     // Catch: Throwable -> L38
            c r19 = r8.f2883s;     // Catch: Throwable -> L38
            if (r19 == null) goto L33;
            ((SystemAlarmService) r19).a();     // Catch: Throwable -> L38
        L33:
            monitor-exit(r12);     // Catch: Throwable -> L38
            return;
        L27:
            th = move-exception;
            throw th;     // Catch: Throwable -> L38
        L31:
            if (r8.f2881q.isEmpty() == true) goto L33;
            r8.c();     // Catch: Throwable -> L38
            goto L33
        L35:
            th = move-exception;
            throw th;     // Catch: Throwable -> L38
        }
    }

    static {
        f2874t = m.f("SystemAlarmDispatcher");
    }

    public d(Context r8) {
        Context r10 = r8.getApplicationContext();
        this.f2875a = r10;
        this.f2880p = new androidx.work.impl.background.systemalarm.a(r10, new r6.d());
        b0 r11 = b0.f(r8);
        this.f2879o = r11;
        this.f2877m = new d0(r11.f8452b.f2800e);
        p r12 = r11.f8456f;
        this.f2878n = r12;
        this.f2876b = r11.f8454d;
        r12.a(this);
        this.f2881q = new ArrayList();
        this.f2882r = null;
    }

    public static void b() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Needs to be invoked on the main thread.");
    }

    public final void a(Intent r8, int r10) {
        m r11 = m.d();
        String r12 = f2874t;
        r11.a(r12, "Adding command " + r8 + " (" + r10 + ")");
        b();
        String r13 = r8.getAction();
        if (TextUtils.isEmpty(r13) == false) goto L7;
        m.d().g(r12, "Unknown command. Ignoring");
        return;
    L7:
        if ("ACTION_CONSTRAINTS_CHANGED".equals(r13) == false) goto L24;
        b();
        ArrayList r14 = this.f2881q;
        monitor-enter(r14);
        Iterator r15 = this.f2881q.iterator();     // Catch: Throwable -> L21
    L12:
        if (r15.hasNext() == false) goto L17;
        if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) r15.next()).getAction()) == false) goto L12;
        monitor-exit(r14);     // Catch: Throwable -> L21
        boolean r16 = true;
    L19:
        if (r16 == false) goto L24;
        return;
    L17:
        monitor-exit(r14);     // Catch: Throwable -> L21
        r16 = false;
    L21:
        th = move-exception;
        throw th;
    L24:
        r8.putExtra("KEY_START_ID", r10);
        ArrayList r17 = this.f2881q;
        monitor-enter(r17);
        boolean r18 = !this.f2881q.isEmpty();     // Catch: Throwable -> L31
        this.f2881q.add(r8);     // Catch: Throwable -> L31
        if (r18 == true) goto L29;
        c();     // Catch: Throwable -> L31
    L29:
        monitor-exit(r17);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;
    }

    public final void c() {
        b();
        PowerManager.WakeLock r8 = v.a(this.f2875a, "ProcessCommand");
        r8.acquire();     // Catch: Throwable -> L6
        this.f2879o.f8454d.a(new a(this));     // Catch: Throwable -> L6
        r8.release();
        return;
    L6:
        th = move-exception;
        r8.release();
        throw th;
    }

    @Override // j1.c
    public final void f(l r8, boolean r10) {
        u1.b.a r11 = ((u1.b) this.f2876b).f12422c;
        String r12 = androidx.work.impl.background.systemalarm.a.f2852o;
        Intent r13 = new Intent(this.f2875a, SystemAlarmService.class);
        r13.setAction("ACTION_EXECUTION_COMPLETED");
        r13.putExtra("KEY_NEEDS_RESCHEDULE", r10);
        androidx.work.impl.background.systemalarm.a.c(r13, r8);
        r11.execute(new b(0, r13, this));
    }
}
