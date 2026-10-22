package androidx.work;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import s1.a0;
import s1.b0;
import s1.c0;
import s1.z;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    private Context mAppContext;
    private volatile boolean mStopped;
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    public static abstract class a {

        /* JADX INFO: renamed from: androidx.work.l$a$a, reason: collision with other inner class name */
        public static final class C0025a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final e f2926a;

            public C0025a() {
                this.f2926a = e.f2823c;
            }

            public final boolean equals(Object r8) {
                if (this != r8) goto L5;
                return true;
            L5:
                if (r8 != null) goto L7;
                return false;
            L7:
                if (C0025a.class == r8.getClass()) goto L10;
                return false;
            L10:
                return this.f2926a.equals(((C0025a) r8).f2926a);
            }

            public final int hashCode() {
                int r8 = C0025a.class.getName().hashCode() * 31;
                return this.f2926a.hashCode() + r8;
            }

            public final String toString() {
                return "Failure {mOutputData=" + this.f2926a + '}';
            }
        }

        public static final class b extends a {
            public b() {
            }

            public final boolean equals(Object r8) {
                if (this != r8) goto L5;
                return true;
            L5:
                if (r8 != null) goto L7;
            L9:
                return false;
            L7:
                if (b.class != r8.getClass()) goto L9;
                return true;
            }

            public final int hashCode() {
                return b.class.getName().hashCode();
            }

            public final String toString() {
                return "Retry";
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final e f2927a;

            public c() {
                this(e.f2823c);
            }

            public final boolean equals(Object r8) {
                if (this != r8) goto L5;
                return true;
            L5:
                if (r8 != null) goto L7;
                return false;
            L7:
                if (c.class == r8.getClass()) goto L10;
                return false;
            L10:
                return this.f2927a.equals(((c) r8).f2927a);
            }

            public final int hashCode() {
                int r8 = c.class.getName().hashCode() * 31;
                return this.f2927a.hashCode() + r8;
            }

            public final String toString() {
                return "Success {mOutputData=" + this.f2927a + '}';
            }

            public c(e r8) {
                this.f2927a = r8;
            }
        }

        public a() {
        }
    }

    public l(Context r8, WorkerParameters r10) {
        if (r8 == null) goto L10;
        if (r10 == null) goto L8;
        this.mAppContext = r8;
        this.mWorkerParams = r10;
        return;
    L8:
        throw new IllegalArgumentException("WorkerParameters is null");
    L10:
        throw new IllegalArgumentException("Application Context is null");
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.f2783f;
    }

    public ga.a<h> getForegroundInfoAsync() {
        t1.c r8 = new t1.c();
        r8.k(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return r8;
    }

    public final UUID getId() {
        return this.mWorkerParams.f2778a;
    }

    public final e getInputData() {
        return this.mWorkerParams.f2779b;
    }

    public final Network getNetwork() {
        return this.mWorkerParams.f2781d.f2790c;
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.f2782e;
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.f2780c;
    }

    public u1.a getTaskExecutor() {
        return this.mWorkerParams.f2784g;
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.f2781d.f2788a;
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.f2781d.f2789b;
    }

    public y getWorkerFactory() {
        return this.mWorkerParams.f2785h;
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public void onStopped() {
    }

    public final ga.a<Void> setForegroundAsync(h r10) {
        i r8 = this.mWorkerParams.f2787j;
        Context r11 = getApplicationContext();
        UUID r12 = getId();
        a0 r13 = (a0) r8;
        r13.getClass();
        t1.c r14 = new t1.c();
        z r15 = new z(r13, r14, r12, r10, r11);
        r13.f11947a.a(r15);
        return r14;
    }

    public ga.a<Void> setProgressAsync(e r8) {
        s r10 = this.mWorkerParams.f2786i;
        getApplicationContext();
        UUID r11 = getId();
        c0 r12 = (c0) r10;
        r12.getClass();
        t1.c r13 = new t1.c();
        b0 r14 = new b0(r12, r11, r8, r13);
        r12.f11960b.a(r14);
        return r13;
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract ga.a<a> startWork();

    public final void stop() {
        this.mStopped = true;
        onStopped();
    }
}
