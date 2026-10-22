package com.obric.cae.location.report;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f7257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7258b;
    public final ArrayList c;
    public final Object d;
    public final ArrayList e;
    public final ConcurrentHashMap<f, C0358a> f;
    public final Object g;
    public final ArrayList h;
    public ScheduledExecutorService i;

    /* JADX INFO: renamed from: com.obric.cae.location.report.a$a, reason: collision with other inner class name */
    public static class C0358a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f7260b;
        public double c;
        public float d;
        public String e;
        public int f;
        public int g;
        public final List<String> h;
        public final List<Integer> i;
        public final List<Float> j;
        public final List<Boolean> k;

        public C0358a(long r2, double r4, double r6, float r8, String r9, int r10, int r11) {
            this.h = new ArrayList();
            this.i = new ArrayList();
            this.j = new ArrayList();
            this.k = new ArrayList();
            this.f7259a = r2;
            this.f7260b = r4;
            this.c = r6;
            this.d = r8;
            this.e = r9;
            this.f = r10;
            this.g = r11;
        }

        public void a(String r2, int r3, float r4, boolean r5) {
            this.h.add(r2);
            this.i.add(Integer.valueOf(r3));
            this.j.add(Float.valueOf(r4));
            this.k.add(Boolean.valueOf(r5));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7262b;
        public final String c;
        public final String d;
        public final double e;
        public final boolean f;
        public final int g;
        public final List<c> h;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f7263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7264b;
        public final String c;
        public final String d;
        public final String e;
        public final double f;
        public final List<Double> g;
        public final List<Double> h;
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public StarGeofence f7266b;
        public int c;

        public d(long r1, StarGeofence r3, int r4) {
            this.f7265a = r1;
            this.f7266b = r3;
            this.c = r4;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Long> f7268b;
        public List<Float> c;
        public List<Float> d;
        public List<Float> e;
        public int f;
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f7269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f7270b;

        public f(double r1, double r3) {
            this.f7269a = r1;
            this.f7270b = r3;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (r7 != null) goto L8;
        L17:
            return false;
        L8:
            if (getClass() != r7.getClass()) goto L17;
            f r8 = (f) ZeusTransformUtils.preCheckCast(r7, f.class, "com.obric.memorydata.plugin");
            if (Double.compare(r8.f7269a, this.f7269a) != 0) goto L16;
            if (Double.compare(r8.f7270b, this.f7270b) != 0) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Double.valueOf(this.f7269a), Double.valueOf(this.f7270b)});
        }
    }

    public static abstract class g {
        public g() {
        }

        public abstract void a();
    }

    public class h extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f7271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f7272b;
        public final /* synthetic */ a c;

        public h(a r1, Looper r2) {
            this.c = r1;
            super(r2);
            this.f7271a = new ArrayList();
            this.f7272b = new ArrayList();
        }

        @Override // android.os.Handler
        public synchronized void handleMessage(Message r4) {
            monitor-enter(this);
            int r5 = r4.what;     // Catch: Throwable -> L37
            if (r5 != 0) goto L8;
            ArrayList r6 = this.f7271a;     // Catch: Throwable -> L37
            Object r0 = this.c.b();     // Catch: Throwable -> L37
        L6:
            r6.add(r0);     // Catch: Throwable -> L37
        L35:
            monitor-exit(this);
            return;
        L8:
            if (r5 != 1) goto L11;
            r6 = this.f7272b;     // Catch: Throwable -> L37
            r0 = this.c.c();     // Catch: Throwable -> L37
            goto L6
        L11:
            if (r5 != 3) goto L16;
            com.obric.cae.location.report.c.b r7 = this.c.d();     // Catch: Throwable -> L37
            if (r7 == null) goto L35;
            r7.a();     // Catch: Throwable -> L37
            goto L35
        L16:
            if (r5 != 2) goto L35;
            if (this.f7272b.isEmpty() == true) goto L27;
            Iterator r8 = this.f7272b.iterator();     // Catch: Throwable -> L37
        L21:
            if (r8.hasNext() == false) goto L25;
            g r1 = (g) ZeusTransformUtils.preCheckCast(r8.next(), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
            if (r1 == null) goto L21;
            r1.a();     // Catch: Throwable -> L37
            goto L21
        L25:
            this.f7272b.clear();     // Catch: Throwable -> L37
        L27:
            if (this.f7271a.isEmpty() == true) goto L35;
            Iterator r9 = this.f7271a.iterator();     // Catch: Throwable -> L37
        L30:
            if (r9.hasNext() == false) goto L34;
            g r2 = (g) ZeusTransformUtils.preCheckCast(r9.next(), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
            if (r2 == null) goto L30;
            r2.a();     // Catch: Throwable -> L37
            goto L30
        L34:
            this.f7271a.clear();     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            throw th;
        }
    }

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f7258b = new Object();
        this.c = new ArrayList();
        this.d = new Object();
        this.e = new ArrayList();
        this.f = new ConcurrentHashMap();
        this.g = new Object();
        this.h = new ArrayList();
        e();
        f();
    }

    private /* synthetic */ Thread a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        a();
        return new Thread(r4, "StarLocation-ReportJson-Periodic");
    }

    public static /* synthetic */ Thread lambda$JrVEQAuawbJiqoaeNGEVHthEjfI(a r0, Runnable r1) {
        return r0.a(r1);
    }

    public abstract void a();

    public void a(long r19, Location r21, String r22, int r23, int r24, StarGeofence.GeoEvent r25, float r26, boolean r27) {
        double r7 = r21.getLatitude();
        double r9 = r21.getLongitude();
        f r15 = new f(r7, r9);
        Object r14 = this.d;
        monitor-enter(r14);
        C0358a r4 = (C0358a) ZeusTransformUtils.preCheckCast(this.f.get(r15), C0358a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r4 == null) goto L11;
        if ((r19 - r4.f7259a) >= 1000) goto L11;
        r4.a(r22, r25.getValue(), r26, r27);     // Catch: Throwable -> L17
    L12:
        monitor-exit(r14);     // Catch: Throwable -> L21
        h r0 = this.f7257a;
        if (r0 == null) goto L24;
        r0.sendEmptyMessage(1);
        return;
    L24:
        return;
    L11:
        C0358a r13 = new C0358a(r19, r7, r9, r21.getAccuracy(), r21.getProvider(), r23, r24);     // Catch: Throwable -> L21
        r13.a(r22, r25.getValue(), r26, r27);     // Catch: Throwable -> L21
        this.f.put(r15, r13);     // Catch: Throwable -> L21
    L21:
        th = th;
    L19:
        monitor-exit(r14);     // Catch: Throwable -> L21
        throw th;
    L17:
        th = th;
        goto L19
    }

    public void a(long r4, StarGeofence r6, int r7) {
        Object r0 = this.d;
        monitor-enter(r0);
        this.e.add(new d(r4, r6, r7));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        h r3 = this.f7257a;
        if (r3 == null) goto L15;
        r3.sendEmptyMessage(1);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public abstract com.obric.cae.location.report.c.C0359c b();

    public abstract com.obric.cae.location.report.c.a c();

    public abstract com.obric.cae.location.report.c.b d();

    public final void e() {
        HandlerThread r0 = new HandlerThread("star_location_report");
        r0.start();
        this.f7257a = new h(this, r0.getLooper());
    }

    public final void f() {
        ScheduledExecutorService r2 = Executors.newScheduledThreadPool(1, new $$Lambda$a$JrVEQAuawbJiqoaeNGEVHthEjfI(this));
        this.i = r2;
        r2.scheduleWithFixedDelay(new $$Lambda$7ryNGiqNHljR3H0AhOaIkRUcXM(this), 1, 120, TimeUnit.MINUTES);
    }

    public final void g() {
        h r1 = this.f7257a;
        if (r1 == null) goto L6;
        r1.sendEmptyMessage(2);
        return;
    }
}
