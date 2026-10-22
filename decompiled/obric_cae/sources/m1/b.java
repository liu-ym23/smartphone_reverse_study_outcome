package m1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.PersistableBundle;
import androidx.lifecycle.s;
import androidx.work.d;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.m;
import androidx.work.n;
import androidx.work.q;
import androidx.work.u;
import j1.b0;
import j1.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import r1.i;
import r1.l;
import r1.t;
import s1.h;

/* JADX INFO: loaded from: classes.dex */
public final class b implements r {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f9248o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JobScheduler f9250b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b0 f9251m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f9252n;

    static {
        f9248o = m.f("SystemJobScheduler");
    }

    public b(Context r8, b0 r10) {
        JobScheduler r11 = (JobScheduler) r8.getSystemService("jobscheduler");
        a r12 = new a(r8);
        this.f9249a = r8;
        this.f9251m = r10;
        this.f9250b = r11;
        this.f9252n = r12;
    }

    public static void c(JobScheduler r8, int r10) {
        r8.cancel(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        m r11 = m.d();
        String r12 = String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(r10)});
        r11.c(f9248o, r12, th);
    }

    public static ArrayList e(Context r8, JobScheduler r10) {
        List<JobInfo> r11 = r10.getAllPendingJobs();     // Catch: Throwable -> L5
    L7:
        if (r11 != null) goto L9;
        return null;
    L9:
        ArrayList r12 = new ArrayList(r11.size());
        ComponentName r13 = new ComponentName(r8, SystemJobService.class);
        Iterator<JobInfo> r14 = r11.iterator();
    L11:
        if (r14.hasNext() == false) goto L15;
        JobInfo r15 = r14.next();
        if (r13.equals(r15.getService()) == false) goto L11;
        r12.add(r15);
        goto L11
    L15:
        return r12;
    L5:
        th = move-exception;
        m.d().c(f9248o, "getAllPendingJobs() is not reliable on this device.", th);
        r11 = null;
        goto L7
    }

    public static l f(JobInfo r8) {
        PersistableBundle r10 = r8.getExtras();
        if (r10 != null) goto L11;
        return null;
    L11:
        if (r10.containsKey("EXTRA_WORK_SPEC_ID") == false) goto L13;
        int r11 = r10.getInt("EXTRA_WORK_SPEC_GENERATION", 0);     // Catch: NullPointerException -> L10
        return new l(r10.getString("EXTRA_WORK_SPEC_ID"), r11);
    L13:
        return null;
    L14:
        return null;
    }

    @Override // j1.r
    public final void a(t... r12) {
        b0 r8 = this.f9251m;
        WorkDatabase r10 = r8.f8453c;
        final s r11 = new s(r10);
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L25;
        t r15 = r12[r14];
        r10.beginTransaction();
        t r16 = r10.f().g(r15.f11339a);     // Catch: Throwable -> L22
        String r17 = f9248o;
        String r18 = r15.f11339a;
        if (r16 != null) goto L11;
        m r19 = m.d();     // Catch: Throwable -> L22
        String r20 = "Skipping scheduling " + r18 + " because it's no longer in the DB";     // Catch: Throwable -> L22
    L9:
        r19.g(r17, r20);     // Catch: Throwable -> L22
    L20:
        r10.setTransactionSuccessful();     // Catch: Throwable -> L22
        r10.endTransaction();
        r14 = r14 + 1;
        goto L3
    L11:
        if (r16.f11340b == u.a.f2952a) goto L13;
        r19 = m.d();     // Catch: Throwable -> L22
        r20 = "Skipping scheduling " + r18 + " because it is no longer enqueued";     // Catch: Throwable -> L22
        goto L9
    L13:
        l r21 = l6.a.L(r15);     // Catch: Throwable -> L22
        i r22 = r10.c().b(r21);     // Catch: Throwable -> L22
        if (r22 == null) goto L16;
        int r23 = r22.f11319c;     // Catch: Throwable -> L22
    L17:
        if (r22 != null) goto L19;
        r8.f8453c.c().a(new i(r21.f11324a, r21.f11325b, r23));     // Catch: Throwable -> L22
    L19:
        g(r15, r23);     // Catch: Throwable -> L22
        goto L20
    L16:
        r8.f8452b.getClass();     // Catch: Throwable -> L22
        final int r24 = r8.f8452b.f2803h;     // Catch: Throwable -> L22
        Object r25 = ((WorkDatabase) r11.f2194b).runInTransaction(new h(r11, r24));     // Catch: Throwable -> L22
        he.i.e(r25, "workDatabase.runInTransa…            id\n        })");     // Catch: Throwable -> L22
        r23 = ((Number) r25).intValue();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    @Override // j1.r
    public final void b(String r8) {
        Context r10 = this.f9249a;
        JobScheduler r11 = this.f9250b;
        ArrayList r12 = e(r10, r11);
        if (r12 != null) goto L5;
        ArrayList r13 = null;
    L14:
        if (r13 != null) goto L16;
        return;
    L16:
        if (r13.isEmpty() == true) goto L32;
        Iterator r14 = r13.iterator();
    L19:
        if (r14.hasNext() == false) goto L21;
        c(r11, ((Integer) r14.next()).intValue());
        goto L19
    L21:
        this.f9251m.f8453c.c().d(r8);
        return;
    L32:
        return;
    L5:
        ArrayList r15 = new ArrayList(2);
        Iterator r16 = r12.iterator();
    L7:
        if (r16.hasNext() == false) goto L13;
        JobInfo r17 = (JobInfo) r16.next();
        l r18 = f(r17);
        if (r18 == null) goto L7;
        if (r8.equals(r18.f11324a) == false) goto L7;
        r15.add(Integer.valueOf(r17.getId()));
        goto L7
    L13:
        r13 = r15;
        goto L14
    }

    @Override // j1.r
    public final boolean d() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(t r12, int r13) {
        JobScheduler r8 = this.f9250b;
        a r10 = this.f9252n;
        r10.getClass();
        d r11 = r12.f11348j;
        PersistableBundle r14 = new PersistableBundle();
        String r15 = r12.f11339a;
        r14.putString("EXTRA_WORK_SPEC_ID", r15);
        r14.putInt("EXTRA_WORK_SPEC_GENERATION", r12.f11358t);
        r14.putBoolean("EXTRA_IS_PERIODIC", r12.f());
        JobInfo.Builder r16 = new JobInfo.Builder(r13, r10.f9247a).setRequiresCharging(r11.f2809b);
        boolean r17 = r11.f2810c;
        JobInfo.Builder r18 = r16.setRequiresDeviceIdle(r17).setExtras(r14);
        n r19 = n.f2937p;
        int r20 = 0;
        n r21 = r11.f2808a;
        if (r21 != r19) goto L5;
        r18.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
    L18:
        if (r17 == false) goto L20;
    L24:
        long r22 = Math.max(r12.a() - System.currentTimeMillis(), 0);
        if (r22 <= 0) goto L28;
        r18.setMinimumLatency(r22);
    L30:
        Set<d.b> r23 = r11.f2815h;
        if ((!r23.isEmpty()) == false) goto L37;
        Iterator<d.b> r24 = r23.iterator();
    L34:
        if (r24.hasNext() == false) goto L36;
        d.b r25 = r24.next();
        r18.addTriggerContentUri(new JobInfo.TriggerContentUri(r25.f2820a, r25.f2821b ? 1 : 0));
        goto L34
    L36:
        r18.setTriggerContentUpdateDelay(r11.f2813f);
        r18.setTriggerContentMaxDelay(r11.f2814g);
    L37:
        r18.setPersisted(false);
        r18.setRequiresBatteryNotLow(r11.f2811d);
        r18.setRequiresStorageNotLow(r11.f2812e);
        if (r12.f11349k <= 0) goto L40;
        Object[] r26 = true;
    L41:
        if (r22 <= 0) goto L43;
        Object[] r27 = true;
    L45:
        if (r12.f11355q == false) goto L49;
        if (r26 == true) goto L49;
        if (r27 == true) goto L49;
        r18.setExpedited(true);
    L49:
        JobInfo r28 = r18.build();
        String r29 = f9248o;
        m.d().a(r29, "Scheduling work ID " + r15 + "Job ID " + r13);
    L61:
        e = move-exception;
        ArrayList r110 = e(this.f9249a, r8);
        if (r110 == null) goto L65;
        r20 = r110.size();
    L65:
        Locale r111 = Locale.getDefault();
        Integer r30 = Integer.valueOf(r20);
        b0 r112 = this.f9251m;
        String r113 = String.format(r111, "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{r30, Integer.valueOf(r112.f8453c.f().d().size()), Integer.valueOf(r112.f8452b.f2804i)});
        m.d().b(r29, r113);
        IllegalStateException r31 = new IllegalStateException(r113, e);
        r112.f8452b.getClass();
        throw r31;
    L58:
        th = move-exception;
        m.d().c(r29, "Unable to schedule " + r12, th);
        return;
    L51:
        if (r8.schedule(r28) != 0) goto L70;
        m.d().g(r29, "Unable to schedule work ID " + r15);     // Catch: Throwable -> L58 IllegalStateException -> L61
        if (r12.f11355q == true) goto L55;
        return;
    L55:
        if (r12.f11356r != q.f2942a) goto L72;
        r12.f11355q = false;     // Catch: Throwable -> L58 IllegalStateException -> L61
        m.d().a(r29, String.format("Scheduling a non-expedited job (work ID %s)", new Object[]{r15}));     // Catch: Throwable -> L58 IllegalStateException -> L61
        g(r12, r13);     // Catch: Throwable -> L58 IllegalStateException -> L61
    L73:
        return;
    L72:
        return;
    L70:
        return;
    L43:
        r27 = false;
        goto L45
    L40:
        r26 = false;
        goto L41
    L28:
        if (r12.f11355q == true) goto L30;
        r18.setImportantWhileForeground(true);
        goto L30
    L20:
        if (r12.f11350l != androidx.work.a.f2792b) goto L22;
        int r32 = 0;
    L23:
        r18.setBackoffCriteria(r12.f11351m, r32);
        goto L24
    L22:
        r32 = 1;
        goto L23
    L5:
        int r33 = r21.ordinal();
        if (r33 == 0) goto L16;
        if (r33 == 1) goto L15;
        int r34 = 2;
        if (r33 == 2) goto L17;
        r34 = 3;
        if (r33 == 3) goto L17;
        r34 = 4;
        if (r33 == 4) goto L17;
        m.d().a(a.f9246b, "API version too low. Cannot convert network type value " + r21);
    L17:
        r18.setRequiredNetworkType(r34);
    L15:
        r34 = 1;
        goto L17
    L16:
        r34 = 0;
        goto L17
    }
}
