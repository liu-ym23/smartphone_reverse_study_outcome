package com.obric.memorydata.intelligence.b.a;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobService;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.infra.job.JobId;
import com.obric.memorydata.intelligence.b.e;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/intelligence/predict/job/PredictInitJob;", "Lcom/obric/memorydata/infra/job/Job;", "<init>", "()V", "TAG", "", "provideJobId", "Lcom/obric/memorydata/infra/job/JobId;", "build", "", "builder", "Landroid/app/job/JobInfo$Builder;", "onStartJob", "", "jobService", "Landroid/app/job/JobService;", "jobParameters", "Landroid/app/job/JobParameters;", "onStopJob", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements com.obric.memorydata.infra.job.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9938b = null;

    static {
        f9938b = new a();
    }

    private a() {
    }

    private static final void c(JobService r2, JobParameters r3) {
        JobService r4 = (JobService) ZeusTransformUtils.wrapperContextForParams(r2, JobService.class, "com.obric.memorydata.plugin");
        e.f9945a.b();
        if (e.f9945a.a() == true) goto L5;
        e.f9945a.a(true);
    L5:
        r4.jobFinished(r3, false);
    }

    public static /* synthetic */ void lambda$dd0MAWQMW1JFnf79yXm3mLAfSpE(JobService r0, JobParameters r1) {
        c(r0, r1);
    }

    @Override // com.obric.memorydata.infra.job.a
    public JobId a() {
        return JobId.PREDICT_NEXT_HOUR_APP_INIT;
    }

    @Override // com.obric.memorydata.infra.job.a
    public void a(JobInfo.Builder r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.setRequiresDeviceIdle(true).setPeriodic(WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS);
    }

    @Override // com.obric.memorydata.infra.job.a
    public boolean a(JobService r2, final JobParameters r3) {
        final JobService r1 = (JobService) ZeusTransformUtils.wrapperContextForParams(r2, JobService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "jobService");
        Intrinsics.checkNotNullParameter(r3, "jobParameters");
        GlobalHandlerUtil.Companion.getInstance().sendMsg(new $$Lambda$a$dd0MAWQMW1JFnf79yXm3mLAfSpE(r1, r3));
        return true;
    }

    public void b() {
        com.obric.memorydata.infra.job.a.b.a(this);
    }

    @Override // com.obric.memorydata.infra.job.a
    public boolean b(JobService r7, JobParameters r8) {
        Intrinsics.checkNotNullParameter((JobService) ZeusTransformUtils.wrapperContextForParams(r7, JobService.class, "com.obric.memorydata.plugin"), "jobService");
        Intrinsics.checkNotNullParameter(r8, "jobParameters");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictInitJob", "ignore job stop, stop reason: " + r8.getStopReason(), null, 4, null);
        return false;
    }
}
