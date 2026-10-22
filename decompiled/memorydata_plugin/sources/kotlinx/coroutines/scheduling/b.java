package kotlinx.coroutines.scheduling;

import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.internal.s;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017J\r\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\nJ\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "()V", IslandSession.REOPEN_VALUE_CLOSE, "", "limitedParallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "", "shutdown", "shutdown$kotlinx_coroutines_core", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class b extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f17618b = null;

    static {
        f17618b = new b();
    }

    private b() {
        super(k.c, k.d, k.e, k.f17623a);
    }

    @Override // kotlinx.coroutines.scheduling.e, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.ah
    public ah limitedParallelism(int r2) {
        s.a(r2);
        if (r2 < k.c) goto L7;
        return (ah) ZeusTransformUtils.preCheckCast(this, ah.class, "com.obric.memorydata.plugin");
    L7:
        return super.limitedParallelism(r2);
    }

    @Override // kotlinx.coroutines.ah
    public String toString() {
        return "Dispatchers.Default";
    }
}
