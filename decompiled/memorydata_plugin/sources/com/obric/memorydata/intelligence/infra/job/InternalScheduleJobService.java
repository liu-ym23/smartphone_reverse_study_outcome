package com.obric.memorydata.intelligence.infra.job;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import com.obric.memorydata.infra.job.b;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/intelligence/infra/job/InternalScheduleJobService;", "Lcom/obric/memorydata/intelligence/infra/job/IScheduleJobDelegate;", "<init>", "()V", "onStartJob", "", "service", "Landroid/app/job/JobService;", TrackerImpl.PARAMS, "Landroid/app/job/JobParameters;", "onStopJob", "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InternalScheduleJobService implements IScheduleJobDelegate {
    public static final a Companion = null;
    private static final String TAG = "ScheduleJobService";
    private static final Lazy<ComponentName> componentName$delegate = null;
    private static final Lazy<InternalScheduleJobService> delegate$delegate = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/intelligence/infra/job/InternalScheduleJobService$Companion;", "", "<init>", "()V", "TAG", "", "delegate", "Lcom/obric/memorydata/intelligence/infra/job/InternalScheduleJobService;", "getDelegate", "()Lcom/obric/memorydata/intelligence/infra/job/InternalScheduleJobService;", "delegate$delegate", "Lkotlin/Lazy;", "register", "", "unregister", "componentName", "Landroid/content/ComponentName;", "getComponentName", "()Landroid/content/ComponentName;", "componentName$delegate", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final InternalScheduleJobService c() {
            return (InternalScheduleJobService) ZeusTransformUtils.preCheckCast(InternalScheduleJobService.access$getDelegate$delegate$cp().getValue(), InternalScheduleJobService.class, "com.obric.memorydata.plugin");
        }

        public final void a() {
            ScheduleJobRegistry.registerDelegate((IScheduleJobDelegate) ZeusTransformUtils.preCheckCast(c(), IScheduleJobDelegate.class, "com.obric.memorydata.plugin"));
        }

        public final ComponentName b() {
            return (ComponentName) ZeusTransformUtils.preCheckCast(InternalScheduleJobService.access$getComponentName$delegate$cp().getValue(), ComponentName.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        Companion = new a(null);
        delegate$delegate = LazyKt.lazy($$Lambda$InternalScheduleJobService$BJ2mlWt_sVz0BReM8FtScd9VqWo.INSTANCE);
        componentName$delegate = LazyKt.lazy($$Lambda$InternalScheduleJobService$JbbyDehs8HtZPNTpGSnTWG_yd0.INSTANCE);
    }

    public InternalScheduleJobService() {
    }

    public static final /* synthetic */ Lazy access$getComponentName$delegate$cp() {
        return componentName$delegate;
    }

    public static final /* synthetic */ Lazy access$getDelegate$delegate$cp() {
        return delegate$delegate;
    }

    private static final ComponentName componentName_delegate$lambda$1() {
        return new ComponentName((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ScheduleJobService.class);
    }

    private static final InternalScheduleJobService delegate_delegate$lambda$0() {
        return new InternalScheduleJobService();
    }

    public static /* synthetic */ InternalScheduleJobService lambda$BJ2mlWt_sVz0BReM8FtScd9VqWo() {
        return delegate_delegate$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$JbbyDehs8Ht-ZPNTpGSnTWG_yd0, reason: not valid java name */
    public static /* synthetic */ ComponentName m676lambda$JbbyDehs8HtZPNTpGSnTWG_yd0() {
        return componentName_delegate$lambda$1();
    }

    public boolean onStartJob(JobService r7, JobParameters r8) {
        JobService r6 = (JobService) ZeusTransformUtils.wrapperContextForParams(r7, JobService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "service");
        Intrinsics.checkNotNullParameter(r8, TrackerImpl.PARAMS);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onStartJob, id=" + r8.getJobId(), false, 4, null);
        return b.f9879a.a(r6, r8);
    }

    public boolean onStopJob(JobService r7, JobParameters r8) {
        JobService r6 = (JobService) ZeusTransformUtils.wrapperContextForParams(r7, JobService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "service");
        Intrinsics.checkNotNullParameter(r8, TrackerImpl.PARAMS);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onStopJob, id=" + r8.getJobId(), false, 4, null);
        return b.f9879a.b(r6, r8);
    }
}
