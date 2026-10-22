package com.obric.memorydata.infra.job;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.SparseArray;
import com.obric.memorydata.intelligence.infra.job.InternalScheduleJobService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/infra/job/JobRepository;", "", "<init>", "()V", "jobs", "Landroid/util/SparseArray;", "Lcom/obric/memorydata/infra/job/Job;", "registerJob", "", "job", "unregisterJob", "getJob", "jobId", "", "onStartJob", "", "jobService", "Landroid/app/job/JobService;", "jobParameters", "Landroid/app/job/JobParameters;", "onStopJob", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9879a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SparseArray<a> f9880b = null;

    static {
        f9879a = new b();
        f9880b = new SparseArray();
    }

    private b() {
    }

    private final a a(int r2) {
        return (a) ZeusTransformUtils.preCheckCast(f9880b.get(r2), a.class, "com.obric.memorydata.plugin");
    }

    public final void a(a r2) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "job");
        SparseArray<a> r3 = f9880b;
        if (r3.size() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        InternalScheduleJobService.Companion.a();
    L8:
        r3.put(r1.a().getId(), r1);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean a(JobService r3, JobParameters r4) {
        JobService r5 = (JobService) ZeusTransformUtils.wrapperContextForParams(r3, JobService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "jobService");
        Intrinsics.checkNotNullParameter(r4, "jobParameters");
        a r2 = a(r4.getJobId());
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.a(r5, r4);
    }

    public final boolean b(JobService r3, JobParameters r4) {
        JobService r5 = (JobService) ZeusTransformUtils.wrapperContextForParams(r3, JobService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "jobService");
        Intrinsics.checkNotNullParameter(r4, "jobParameters");
        a r2 = a(r4.getJobId());
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.b(r5, r4);
    }
}
