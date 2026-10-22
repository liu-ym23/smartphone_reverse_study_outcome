package com.obric.memorydata.recommend.screenshotupload;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u0014*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0014B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/BasePipelineManager;", ExifInterface.GPS_DIRECTION_TRUE, "", "pipelines", "", "Lcom/obric/memorydata/recommend/screenshotupload/Pipeline;", "<init>", "(Ljava/util/List;)V", "workerHandler", "Landroid/os/Handler;", "getWorkerHandler", "()Landroid/os/Handler;", "workerHandler$delegate", "Lkotlin/Lazy;", "messageCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "process", "", "input", "(Ljava/lang/Object;)V", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0676a f12536a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<c<T>> f12537b;
    private final Lazy c;
    private final AtomicInteger d;

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.screenshotupload.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/BasePipelineManager$Companion;", "", "<init>", "()V", "TAG", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0676a {
        private C0676a() {
        }

        public /* synthetic */ C0676a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12536a = new C0676a(null);
    }

    public a(List<? extends c<T>> r3) {
        List<c<T>> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "pipelines");
        this.f12537b = r4;
        this.c = LazyKt.lazy($$Lambda$a$vzL2GNPNFeoR9CrOXwHfqcSVnZQ.INSTANCE);
        this.d = new AtomicInteger(0);
    }

    private final Handler a() {
        return (Handler) ZeusTransformUtils.preCheckCast(this.c.getValue(), Handler.class, "com.obric.memorydata.plugin");
    }

    private static final void a(a r9, f r10, long r11) {
        Iterator<c<T>> r0 = r9.f12537b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.memorydata.plugin");
        if (r1.a(r10) == true) goto L4;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BasePipelineManager", "pipeline process failed, pipeline: " + r1, null, 4, null);
    L8:
        RunLog.INSTANCE.debug("BasePipelineManager", "cost: " + (System.currentTimeMillis() - r11));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BasePipelineManager", "PipelineManager End", false, 4, null);
        r9.d.decrementAndGet();
    }

    private static final Handler b() {
        HandlerThread r0 = new HandlerThread("pipeline_manager");
        r0.start();
        return new Handler(r0.getLooper());
    }

    public static /* synthetic */ Handler lambda$vzL2GNPNFeoR9CrOXwHfqcSVnZQ() {
        return b();
    }

    public static /* synthetic */ void lambda$xHs3CeSQLs8JyOOKgIGCOkIBK5g(a r0, f r1, long r2) {
        a(r0, r1, r2);
    }

    public final void a(T r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BasePipelineManager", "PipelineManager Start", false, 4, null);
        int r0 = this.d.incrementAndGet();
        if (r0 <= 5) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BasePipelineManager", "wait message too many, count: " + r0, null, 4, null);
        com.bytedance.services.apm.api.a.a("PipelineManager message count > 5, current count: " + r0);
        if (r0 <= 20) goto L7;
        a().removeCallbacksAndMessages(null);
        this.d.getAndAdd(-r0);
    L7:
        final long r1 = System.currentTimeMillis();
        final f r2 = new f(r10);
        a().post(new $$Lambda$a$xHs3CeSQLs8JyOOKgIGCOkIBK5g(this, r2, r1));
    }
}
