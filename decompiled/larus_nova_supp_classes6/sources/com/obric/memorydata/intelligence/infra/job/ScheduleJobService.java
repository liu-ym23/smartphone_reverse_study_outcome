package com.obric.memorydata.intelligence.infra.job;

import android.app.job.JobParameters;
import android.app.job.JobService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ScheduleJobService extends JobService {
    public ScheduleJobService() {
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters r2) {
        IScheduleJobDelegate r0 = ScheduleJobRegistry.getDelegate();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.onStartJob(this, r2);
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters r2) {
        IScheduleJobDelegate r0 = ScheduleJobRegistry.getDelegate();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.onStopJob(this, r2);
    }
}
