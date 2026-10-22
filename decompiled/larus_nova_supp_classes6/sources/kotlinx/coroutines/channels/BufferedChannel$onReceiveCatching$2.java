package kotlinx.coroutines.channels;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public /* synthetic */ class BufferedChannel$onReceiveCatching$2 extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, Object, Object, Object> {
    public static final BufferedChannel$onReceiveCatching$2 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannel$onReceiveCatching$2();
    }

    public BufferedChannel$onReceiveCatching$2() {
        super(3, BufferedChannel.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(BufferedChannel<?> r1, Object r2, Object r3) {
        AtomicLongFieldUpdater r4 = BufferedChannel.d;
        r1.getClass();
        if (r3 != e.l) goto L5;
        g.c r5 = g.b;
        final Throwable r6 = r1.m();
        r3 = new g$a(r6);
    L7:
        return new g(r3);
    L5:
        g.c r7 = g.b;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((BufferedChannel) r1, r2, r3);
    }
}
