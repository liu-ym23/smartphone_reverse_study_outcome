package com.obric.memorydata.infra.job;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.Context;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.obric.memorydata.intelligence.infra.job.InternalScheduleJobService;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/infra/job/Job;", "", "provideJobId", "Lcom/obric/memorydata/infra/job/JobId;", "build", "", "builder", "Landroid/app/job/JobInfo$Builder;", "schedule", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "cancelOnly", "removeOnly", "onStartJob", "", "jobService", "Landroid/app/job/JobService;", "jobParameters", "Landroid/app/job/JobParameters;", "onStopJob", "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0475a f9877a = null;

    /* JADX INFO: renamed from: com.obric.memorydata.infra.job.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/infra/job/Job$Companion;", "", "<init>", "()V", "TAG", "", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0475a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0475a f9878a = null;

        static {
            f9878a = new C0475a();
        }

        private C0475a() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        public static void a(a r8) {
            a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r8, a.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "Job", "schedule job: " + r9.a(), false, 4, null);
            com.obric.memorydata.infra.job.b.f9879a.a(r9);
            JobInfo.Builder r0 = new JobInfo.Builder(r9.a().getId(), InternalScheduleJobService.Companion.b());
            r9.a(r0);
            Object r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("jobscheduler");
            if (ZeusTransformUtils.instanceOf(r10, JobScheduler.class) == false) goto L5;
            JobScheduler r11 = (JobScheduler) ZeusTransformUtils.preCheckCast(r10, JobScheduler.class, "com.obric.memorydata.plugin");
        L6:
            if (r11 == null) goto L9;
            r11.schedule(r0.build());
            return;
        L9:
            return;
        L5:
            r11 = null;
            goto L6
        }
    }

    static {
        f9877a = C0475a.f9878a;
    }

    JobId a();

    void a(JobInfo.Builder r1);

    boolean a(JobService r1, JobParameters r2);

    boolean b(JobService r1, JobParameters r2);
}
