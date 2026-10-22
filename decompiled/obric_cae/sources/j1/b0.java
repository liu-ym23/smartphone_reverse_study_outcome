package j1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.utils.ForceStopRunnable;
import com.obric.cae.R;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class b0 extends androidx.work.v {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static b0 f8448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static b0 f8449l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f8450m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f8451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.work.c f8452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WorkDatabase f8453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u1.a f8454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<r> f8455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f8456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s1.n f8457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BroadcastReceiver.PendingResult f8459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p.c f8460j;

    public static class a {
        public static boolean a(Context r8) {
            return r8.isDeviceProtectedStorage();
        }
    }

    static {
        androidx.work.m.f("WorkManagerImpl");
        f8448k = null;
        f8449l = null;
        f8450m = new Object();
    }

    public b0(Context r12, androidx.work.c r13, u1.b r14) {
        boolean r8 = r12.getResources().getBoolean(R.bool.workmanager_test_configuration);
        final Context r10 = r12.getApplicationContext();
        s1.p r11 = r14.f12420a;
        he.i.f(r10, "context");
        he.i.f(r11, "queryExecutor");
        if (r8 == false) goto L5;
        androidx.room.r.a r15 = new androidx.room.r.a(r10, WorkDatabase.class, null);
        r15.f2672j = true;
    L6:
        r15.f2669g = r11;
        b r16 = b.f8447a;
        he.i.f(r16, QesdkUtils.TAGS.JSON_TAG_CALLBACK);
        r15.f2666d.add(r16);
        r15.a(new x0.a[]{g.f8479c});
        r15.a(new x0.a[]{new q(r10, 2, 3)});
        r15.a(new x0.a[]{h.f8482c});
        r15.a(new x0.a[]{i.f8485c});
        r15.a(new x0.a[]{new q(r10, 5, 6)});
        r15.a(new x0.a[]{j.f8511c});
        r15.a(new x0.a[]{k.f8512c});
        r15.a(new x0.a[]{l.f8513c});
        r15.a(new x0.a[]{new c0(r10)});
        r15.a(new x0.a[]{new q(r10, 10, 11)});
        r15.a(new x0.a[]{d.f8462c});
        r15.a(new x0.a[]{e.f8469c});
        r15.a(new x0.a[]{f.f8477c});
        r15.f2674l = false;
        r15.f2675m = true;
        WorkDatabase r17 = (WorkDatabase) r15.b();
        Context r18 = r12.getApplicationContext();
        androidx.work.m.a r19 = new androidx.work.m.a(r13.f2802g);
        Object r20 = androidx.work.m.f2928a;
        monitor-enter(r20);
        androidx.work.m.f2929b = r19;     // Catch: Throwable -> L16
        monitor-exit(r20);     // Catch: Throwable -> L16
        p.c r21 = new p.c(r18, r14);
        this.f8460j = r21;
        String r22 = s.f8540a;
        m1.b r23 = new m1.b(r18, this);
        s1.m.a(r18, SystemJobService.class, true);
        androidx.work.m.d().a(s.f8540a, "Created SystemJobScheduler and enabled SystemJobService");
        List<r> r24 = Arrays.asList(new r[]{r23, new k1.c(r18, r13, r21, this)});
        p r25 = new p(r12, r13, r14, r17, r24);
        Context r110 = r12.getApplicationContext();
        this.f8451a = r110;
        this.f8452b = r13;
        this.f8454d = r14;
        this.f8453c = r17;
        this.f8455e = r24;
        this.f8456f = r25;
        this.f8457g = new s1.n(r17);
        this.f8458h = false;
        if (a.a(r110) == true) goto L15;
        this.f8454d.a(new ForceStopRunnable(r110, this));
        return;
    L15:
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    L16:
        th = move-exception;
        throw th;
    L5:
        r15 = androidx.room.q.a(r10, WorkDatabase.class, "androidx.work.workdb");
        r15.f2671i = new v(r10);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b0 f(Context r8) {
        Object r10 = f8450m;
        monitor-enter(r10);
        monitor-enter(r10);     // Catch: Throwable -> L21
        b0 r11 = f8448k;     // Catch: Throwable -> L18
        if (r11 != null) goto L9;
        r11 = f8449l;     // Catch: Throwable -> L18
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L18
        if (r11 != null) goto L16;
        Context r12 = r8.getApplicationContext();     // Catch: Throwable -> L21
        if ((r12 instanceof androidx.work.c.b) == false) goto L15;
        i(r12, ((androidx.work.c.b) r12).a());     // Catch: Throwable -> L21
        r11 = f(r12);     // Catch: Throwable -> L21
        goto L16
    L15:
        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");     // Catch: Throwable -> L21
    L16:
        monitor-exit(r10);     // Catch: Throwable -> L21
        return r11;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public static void i(Context r8, androidx.work.c r10) {
        Object r11 = f8450m;
        monitor-enter(r11);
        b0 r12 = f8448k;     // Catch: Throwable -> L18
        if (r12 != null) goto L7;
    L11:
        if (r12 != null) goto L16;
        Context r13 = r8.getApplicationContext();     // Catch: Throwable -> L18
        if (f8449l != null) goto L15;
        f8449l = new b0(r13, r10, new u1.b(r10.f2797b));     // Catch: Throwable -> L18
    L15:
        f8448k = f8449l;     // Catch: Throwable -> L18
    L16:
        monitor-exit(r11);     // Catch: Throwable -> L18
        return;
    L7:
        if (f8449l == null) goto L11;
        throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.v
    public final m a() {
        s1.d r8 = new s1.d(this, "ZppLocationWork", true);
        this.f8454d.a(r8);
        return r8.f11971a;
    }

    @Override // androidx.work.v
    public final androidx.work.p b(String r8, List r10) {
        return new u(this, r8, androidx.work.g.f2827a, r10).z();
    }

    public final m d(UUID r8) {
        s1.b r10 = new s1.b(this, r8);
        this.f8454d.a(r10);
        return r10.f11971a;
    }

    public final androidx.work.p e(List<? extends androidx.work.w> r8) {
        if (r8.isEmpty() == true) goto L7;
        return new u(this, null, androidx.work.g.f2828b, r8, 0).z();
    L7:
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    public final androidx.lifecycle.r g(UUID r8) {
        androidx.room.v r10 = this.f8453c.f().v(Collections.singletonList(r8.toString()));
        a0 r11 = new a0();
        u1.a r12 = this.f8454d;
        Object r13 = new Object();
        androidx.lifecycle.r r14 = new androidx.lifecycle.r();
        s1.i r15 = new s1.i(r12, r13, r11, r14);
        if (r10 == null) goto L21;
        androidx.lifecycle.r.a<?> r16 = new androidx.lifecycle.r.a(r10, r15);
        androidx.lifecycle.r.a<?> r17 = r14.f2189l.b(r10, r16);
        if (r17 != null) goto L7;
    L11:
        if (r17 == null) goto L14;
    L19:
        return r14;
    L14:
        if (r14.f2100c <= 0) goto L16;
        boolean r18 = true;
    L17:
        if (r18 == false) goto L19;
        r10.d(r16);
        goto L19
    L16:
        r18 = false;
        goto L17
    L7:
        if (r17.f2191b == r15) goto L11;
        throw new IllegalArgumentException("This source was already added with the different observer");
    L21:
        throw new NullPointerException("source cannot be null");
    }

    public final t1.c h(String r8) {
        s1.r r10 = s1.s.a(this, r8);
        ((u1.b) this.f8454d).c().execute(r10);
        return r10.b();
    }

    public final void j() {
        Object r8 = f8450m;
        monitor-enter(r8);
        this.f8458h = true;     // Catch: Throwable -> L10
        BroadcastReceiver.PendingResult r10 = this.f8459i;     // Catch: Throwable -> L10
        if (r10 == null) goto L8;
        r10.finish();     // Catch: Throwable -> L10
        this.f8459i = null;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void k() {
        Context r8 = this.f8451a;
        String r10 = m1.b.f9248o;
        JobScheduler r11 = (JobScheduler) r8.getSystemService("jobscheduler");
        if (r11 == null) goto L12;
        ArrayList r12 = m1.b.e(r8, r11);
        if (r12 == null) goto L12;
        if (r12.isEmpty() == true) goto L12;
        Iterator r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        m1.b.c(r11, ((JobInfo) r13.next()).getId());
    L12:
        this.f8453c.f().j();
        s.a(this.f8452b, this.f8453c, this.f8455e);
    }
}
