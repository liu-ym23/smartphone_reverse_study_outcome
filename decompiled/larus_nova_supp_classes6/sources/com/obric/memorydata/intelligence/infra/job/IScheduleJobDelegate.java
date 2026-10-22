package com.obric.memorydata.intelligence.infra.job;

import android.app.job.JobParameters;
import android.app.job.JobService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IScheduleJobDelegate {
    boolean onStartJob(JobService r1, JobParameters r2);

    boolean onStopJob(JobService r1, JobParameters r2);
}
