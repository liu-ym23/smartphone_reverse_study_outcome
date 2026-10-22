package com.obric.assistant.live.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/live/service/ObricLiveCountDownService;", "Landroid/app/job/JobService;", "<init>", "()V", "onStartJob", "", "params", "Landroid/app/job/JobParameters;", "onStopJob", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLiveCountDownService extends JobService {

    public static final class a {
    }

    static {
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters r1) {
        return false;
    }

    public ObricLiveCountDownService() {
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters r4) {
        FLogger.a.i("ObricLiveCountDownService", "time out");
        ObricLiveServiceDelegate.b.i();
        jobFinished(r4, false);
        return false;
    }
}
