package com.bytedance.applog.priority.original;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class Worker$globalSchedulerExecutor$2 extends Lambda implements Function0<ScheduledExecutorService> {
    final /* synthetic */ v this$0;

    Worker$globalSchedulerExecutor$2(v r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
    private static final Thread m79invoke$lambda1(v r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Thread r0 = new Thread(r5, "WorkerScheduler-" + r3);
        r0.setDaemon(true);
        return r0;
    }

    public static /* synthetic */ Thread lambda$YEcIbsVNbpU0CgTHxHf15afysno(v r0, Runnable r1) {
        return m79invoke$lambda1(r0, r1);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ScheduledExecutorService invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ScheduledExecutorService invoke2() {
        final v r1 = this.this$0;
        return Executors.newSingleThreadScheduledExecutor(new $$Lambda$Worker$globalSchedulerExecutor$2$YEcIbsVNbpU0CgTHxHf15afysno(r1));
    }
}
