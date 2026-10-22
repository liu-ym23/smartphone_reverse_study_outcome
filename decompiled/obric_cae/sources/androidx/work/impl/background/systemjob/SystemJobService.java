package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.PersistableBundle;
import androidx.work.WorkerParameters;
import androidx.work.m;
import j1.b0;
import j1.c;
import j1.p;
import j1.t;
import java.util.Arrays;
import java.util.HashMap;
import r1.l;
import r6.d;
import s1.q;

/* JADX INFO: loaded from: classes.dex */
public class SystemJobService extends JobService implements c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f2889n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f2890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f2891b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f2892m;

    public static class a {
        public static String[] a(JobParameters r8) {
            return r8.getTriggeredContentAuthorities();
        }

        public static Uri[] b(JobParameters r8) {
            return r8.getTriggeredContentUris();
        }
    }

    public static class b {
        public static Network a(JobParameters r8) {
            return r8.getNetwork();
        }
    }

    static {
        f2889n = m.f("SystemJobService");
    }

    public SystemJobService() {
        this.f2891b = new HashMap();
        this.f2892m = new d();
    }

    public static l a(JobParameters r8) {
        PersistableBundle r10 = r8.getExtras();     // Catch: NullPointerException -> L11
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.containsKey("EXTRA_WORK_SPEC_ID") == false) goto L14;
        return new l(r10.getString("EXTRA_WORK_SPEC_ID"), r10.getInt("EXTRA_WORK_SPEC_GENERATION"));
    L14:
        return null;
    L15:
        return null;
    }

    @Override // j1.c
    public final void f(l r8, boolean r10) {
        m.d().a(f2889n, r8.f11324a + " executed on JobScheduler");
        HashMap r11 = this.f2891b;
        monitor-enter(r11);
        JobParameters r12 = (JobParameters) this.f2891b.remove(r8);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        this.f2892m.d(r8);
        if (r12 == null) goto L15;
        jobFinished(r12, r10);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        b0 r8 = b0.f(getApplicationContext());     // Catch: IllegalStateException -> L5
        this.f2890a = r8;     // Catch: IllegalStateException -> L5
        r8.f8456f.a(this);     // Catch: IllegalStateException -> L5
        return;
    L6:
        if (Application.class.equals(getApplication().getClass()) == false) goto L10;
        m.d().g(f2889n, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        return;
    L10:
        throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        b0 r8 = this.f2890a;
        if (r8 == null) goto L12;
        p r10 = r8.f8456f;
        Object r11 = r10.f8535v;
        monitor-enter(r11);
        r10.f8534u.remove(this);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters r8) {
        if (this.f2890a != null) goto L6;
        m.d().a(f2889n, "WorkManager is not initialized; requesting retry.");
        jobFinished(r8, true);
        return false;
    L6:
        l r10 = a(r8);
        if (r10 != null) goto L10;
        m.d().b(f2889n, "WorkSpec id not found!");
        return false;
    L10:
        HashMap r11 = this.f2891b;
        monitor-enter(r11);
    L27:
        th = move-exception;
        throw th;
    L13:
        if (this.f2891b.containsKey(r10) == false) goto L17;
        m.d().a(f2889n, "Job is already being executed by SystemJobService: " + r10);     // Catch: Throwable -> L27
        monitor-exit(r11);     // Catch: Throwable -> L27
        return false;
    L17:
        m.d().a(f2889n, "onStartJob for " + r10);     // Catch: Throwable -> L27
        this.f2891b.put(r10, r8);     // Catch: Throwable -> L27
        monitor-exit(r11);     // Catch: Throwable -> L27
        WorkerParameters.a r12 = new WorkerParameters.a();
        if (a.b(r8) == null) goto L23;
        r12.f2789b = Arrays.asList(a.b(r8));
    L23:
        if (a.a(r8) == null) goto L25;
        r12.f2788a = Arrays.asList(a.a(r8));
    L25:
        r12.f2790c = b.a(r8);
        b0 r13 = this.f2890a;
        r13.f8454d.a(new q(r13, this.f2892m.f(r10), r12));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters r8) {
        if (this.f2890a != null) goto L6;
        m.d().a(f2889n, "WorkManager is not initialized; requesting retry.");
        return true;
    L6:
        l r10 = a(r8);
        if (r10 != null) goto L10;
        m.d().b(f2889n, "WorkSpec id not found!");
        return false;
    L10:
        m.d().a(f2889n, "onStopJob for " + r10);
        HashMap r11 = this.f2891b;
        monitor-enter(r11);
        this.f2891b.remove(r10);     // Catch: Throwable -> L26
        monitor-exit(r11);     // Catch: Throwable -> L26
        t r12 = this.f2892m.d(r10);
        if (r12 == null) goto L17;
        b0 r13 = this.f2890a;
        r13.f8454d.a(new s1.t(r13, r12, false));
    L17:
        p r14 = this.f2890a.f8456f;
        String r15 = r10.f11324a;
        Object r16 = r14.f8535v;
        monitor-enter(r16);
        boolean r17 = r14.f8533t.contains(r15);     // Catch: Throwable -> L23
        monitor-exit(r16);     // Catch: Throwable -> L23
        return !r17;
    L23:
        th = move-exception;
        throw th;
    L26:
        th = move-exception;
        throw th;
    }
}
