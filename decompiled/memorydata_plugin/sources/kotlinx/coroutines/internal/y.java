package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.ci;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f17603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ci f17604b = null;
    private static final boolean c = false;

    static {
        y r0 = new y();
        f17603a = r0;
        c = ak.a("kotlinx.coroutines.fast.service.loader", true);
        f17604b = r0.a();
    }

    private y() {
    }

    private final ci a() {
    L25:
        th = move-exception;
        return (ci) ZeusTransformUtils.preCheckCast(z.a(th, null, 2, null), ci.class, "com.obric.memorydata.plugin");
    L4:
        if (c == false) goto L6;
        List<MainDispatcherFactory> r1 = o.f17589a.a();     // Catch: Throwable -> L25
    L7:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L25
        if (r2.hasNext() == true) goto L10;
        Object r3 = null;
    L19:
        MainDispatcherFactory r4 = (MainDispatcherFactory) ZeusTransformUtils.preCheckCast(r3, MainDispatcherFactory.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r4 == null) goto L23;
        ci r5 = z.a(r4, r1);     // Catch: Throwable -> L25
        if (r5 == null) goto L23;
        return r5;
    L23:
        return (ci) ZeusTransformUtils.preCheckCast(z.a(null, null, 3, null), ci.class, "com.obric.memorydata.plugin");
    L10:
        r3 = r2.next();     // Catch: Throwable -> L25
        if (r2.hasNext() == false) goto L19;
        int r6 = ((MainDispatcherFactory) ZeusTransformUtils.preCheckCast(r3, MainDispatcherFactory.class, "com.obric.memorydata.plugin")).getLoadPriority();     // Catch: Throwable -> L25
    L14:
        Object r7 = r2.next();     // Catch: Throwable -> L25
        int r8 = ((MainDispatcherFactory) ZeusTransformUtils.preCheckCast(r7, MainDispatcherFactory.class, "com.obric.memorydata.plugin")).getLoadPriority();     // Catch: Throwable -> L25
        if (r6 >= r8) goto L18;
        r3 = r7;
        r6 = r8;
    L18:
        if (r2.hasNext() == true) goto L14;
    L6:
        r1 = SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));     // Catch: Throwable -> L25
        goto L7
    }
}
