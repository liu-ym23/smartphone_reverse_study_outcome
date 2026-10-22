package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nThreadPoolDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadPoolDispatcher.kt\nkotlinx/coroutines/ThreadPoolDispatcherKt__ThreadPoolDispatcherKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n1#2:48\n*E\n"})
final /* synthetic */ class w2 {
    public static /* synthetic */ Thread a(int r10, String r11, AtomicInteger r12, Runnable r13) {
        return c(r10, r11, r12, r13);
    }

    public static final ExecutorCoroutineDispatcher b(final int r10, final String r11) {
        boolean r12 = true;
        if (r10 >= 1) goto L6;
        r12 = false;
    L6:
        if (r12 == false) goto L10;
        final AtomicInteger r13 = new AtomicInteger();
        return m1.b(Executors.newScheduledThreadPool(r10, new v2(r10, r11, r13)));
    L10:
        throw new IllegalArgumentException(("Expected at least one thread, but " + r10 + " specified").toString());
    }

    private static final Thread c(int r10, String r11, AtomicInteger r12, Runnable r13) {
        if (r10 == 1) goto L6;
        r11 = r11 + '-' + r12.incrementAndGet();
    L6:
        Thread r14 = new Thread(r13, r11);
        r14.setDaemon(true);
        return r14;
    }
}
