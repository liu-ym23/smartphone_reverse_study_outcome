package kotlinx.coroutines.scheduling;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.ak;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000\"\u0019\u0010\u000f\u001a\u00020\u0010*\u00020\u00118À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0012¨\u0006\u0013"}, d2 = {"BlockingContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "CORE_POOL_SIZE", "", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "NonBlockingContext", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f17623a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f17624b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final long e = 0;
    public static f f;
    public static final h g = null;
    public static final h h = null;

    static {
        f17623a = ak.a("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
        f17624b = ak.a("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);
        c = ak.a("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast(ak.a(), 2), 1, 0, 8, null);
        d = ak.a("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        e = TimeUnit.SECONDS.toNanos(ak.a("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));
        f = (f) ZeusTransformUtils.preCheckCast(d.f17619a, f.class, "com.obric.memorydata.plugin");
        g = (h) ZeusTransformUtils.preCheckCast(new i(0), h.class, "com.obric.memorydata.plugin");
        h = (h) ZeusTransformUtils.preCheckCast(new i(1), h.class, "com.obric.memorydata.plugin");
    }
}
