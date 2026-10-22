package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class JobScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f8319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityJobRunnable f8320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f8321c;
    public final Runnable d;
    public EncodedImage e;
    public int f;
    public JobState g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f8322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f8323i;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.JobScheduler$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JobScheduler f8325a;

        public AnonymousClass3(JobScheduler r5) {
            this.f8325a = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JobScheduler r5 = this.f8325a;
            r5.f8319a.execute(r5.f8321c);
        }
    }

    public interface JobRunnable {
        void a(EncodedImage r5, int r10);
    }

    public static class JobStartExecutorSupplier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ScheduledExecutorService f8326a;
    }

    public static final enum JobState extends Enum<JobState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final JobState f8327a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final JobState f8328b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final JobState f8329c = null;
        public static final JobState d = null;
        public static final /* synthetic */ JobState[] e = null;

        static {
            JobState r5 = new JobState("IDLE", 0);
            f8327a = r5;
            JobState r10 = new JobState("QUEUED", 1);
            f8328b = r10;
            JobState r11 = new JobState("RUNNING", 2);
            f8329c = r11;
            JobState r12 = new JobState("RUNNING_AND_PENDING", 3);
            d = r12;
            e = new JobState[]{r5, r10, r11, r12};
        }

        public JobState(String r5, int r10) {
            super(r5, r10);
        }

        public static JobState valueOf(String r5) {
            return (JobState) Enum.valueOf(JobState.class, r5);
        }

        public static JobState[] values() {
            return (JobState[]) e.clone();
        }
    }

    public static abstract class PriorityJobRunnable implements JobRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Priority f8330a;

        public PriorityJobRunnable(Priority r5) {
            this.f8330a = r5;
        }
    }

    public JobScheduler(ExecutorService r5, PriorityJobRunnable r10) {
        this.f8319a = r5;
        this.f8320b = r10;
        r10.f8330a.ordinal();
        this.f8321c = new AnonymousClass1(this);
        this.d = new AnonymousClass3(this);
        this.e = null;
        this.f = 0;
        this.g = JobState.f8327a;
        this.f8322h = 0;
        this.f8323i = 0;
    }

    public static void a(JobScheduler r5) {
        r5.getClass();
        long r10 = SystemClock.uptimeMillis();
        monitor-enter(r5);
        EncodedImage r11 = r5.e;     // Catch: Throwable -> L24
        int r12 = r5.f;     // Catch: Throwable -> L24
        r5.e = null;     // Catch: Throwable -> L24
        r5.f = 0;     // Catch: Throwable -> L24
        r5.g = JobState.f8329c;     // Catch: Throwable -> L24
        r5.f8323i = r10;     // Catch: Throwable -> L24
        monitor-exit(r5);     // Catch: Throwable -> L24
    L13:
        th = move-exception;
        if (r11 == null) goto L22;
        r11.close();
    L22:
        r5.c();
        throw th;
    L7:
        if (BaseConsumer.a(r12) == false) goto L9;
    L15:
        r5.f8320b.a(r11, r12);     // Catch: Throwable -> L13
    L16:
        if (r11 == null) goto L18;
        r11.close();
    L18:
        r5.c();
        return;
    L9:
        if (BaseConsumer.a(r12, 4) == true) goto L15;
        if (EncodedImage.c(r11) == false) goto L16;
    L24:
        th = move-exception;
        throw th;
    }

    public final synchronized long b() {
        monitor-enter(this);
        long r5 = this.f8323i - this.f8322h;
        monitor-exit(this);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    public final void c() {
        long r5 = SystemClock.uptimeMillis();
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.g != JobState.d) goto L9;
        long r10 = Math.max(this.f8323i + ((long) 100), r5);     // Catch: Throwable -> L7
        this.f8322h = r5;     // Catch: Throwable -> L7
        this.g = JobState.f8328b;     // Catch: Throwable -> L7
        boolean r11 = true;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r11 == false) goto L25;
        long r12 = r10 - r5;
        Runnable r13 = this.d;
        if (r12 > 0) goto L15;
        ((AnonymousClass3) r13).run();
        return;
    L15:
        if (JobStartExecutorSupplier.f8326a != null) goto L17;
        JobStartExecutorSupplier.f8326a = Executors.newSingleThreadScheduledExecutor();
    L17:
        JobStartExecutorSupplier.f8326a.schedule(r13, r12, TimeUnit.MILLISECONDS);
        return;
    L25:
        return;
    L9:
        this.g = JobState.f8327a;     // Catch: Throwable -> L7
        r11 = false;
        r10 = 0;
        goto L10
    }

    public final void d() {
        long r5 = SystemClock.uptimeMillis();
        monitor-enter(this);
        EncodedImage r10 = this.e;     // Catch: Throwable -> L13
        int r11 = this.f;     // Catch: Throwable -> L13
        if (BaseConsumer.a(r11) == false) goto L7;
    L15:
        int r12 = this.g.ordinal();     // Catch: Throwable -> L13
        if (r12 != 0) goto L18;
        long r13 = Math.max(this.f8323i + ((long) 100), r5);     // Catch: Throwable -> L13
        this.f8322h = r5;     // Catch: Throwable -> L13
        this.g = JobState.f8328b;     // Catch: Throwable -> L13
        boolean r14 = true;
    L23:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (r14 == false) goto L36;
        long r15 = r13 - r5;
        Runnable r16 = this.d;
        if (r15 > 0) goto L28;
        ((AnonymousClass3) r16).run();
        return;
    L28:
        if (JobStartExecutorSupplier.f8326a != null) goto L30;
        JobStartExecutorSupplier.f8326a = Executors.newSingleThreadScheduledExecutor();
    L30:
        JobStartExecutorSupplier.f8326a.schedule(r16, r15, TimeUnit.MILLISECONDS);
        return;
    L36:
        return;
    L18:
        if (r12 != 2) goto L21;
        this.g = JobState.d;     // Catch: Throwable -> L13
    L21:
        r14 = false;
        r13 = 0;
        goto L23
    L7:
        if (BaseConsumer.a(r11, 4) == true) goto L15;
        if (EncodedImage.c(r10) == true) goto L15;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void a() {
        monitor-enter(this);
        EncodedImage r5 = this.e;     // Catch: Throwable -> L8
        this.e = null;     // Catch: Throwable -> L8
        this.f = 0;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r5 == null) goto L13;
        r5.close();
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final boolean a(EncodedImage r5, int r10) {
        if (BaseConsumer.a(r10) == false) goto L5;
    L11:
        monitor-enter(this);
        EncodedImage r11 = this.e;     // Catch: Throwable -> L18
        this.e = EncodedImage.a(r5);     // Catch: Throwable -> L18
        this.f = r10;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        if (r11 == null) goto L23;
        r11.close();
        return true;
    L23:
        return true;
    L18:
        th = move-exception;
        throw th;
    L5:
        if (BaseConsumer.a(r10, 4) == true) goto L11;
        if (EncodedImage.c(r5) == true) goto L11;
        return false;
    }
}
