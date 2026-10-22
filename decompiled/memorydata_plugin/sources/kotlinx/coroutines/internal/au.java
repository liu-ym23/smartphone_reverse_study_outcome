package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\tj\u0002`\n2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0005\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\tj\u0002`\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/internal/WeakMapCtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "()V", "cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "get", "key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class au extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final au f17573a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ReentrantReadWriteLock f17574b = null;
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> c = null;

    static {
        f17573a = new au();
        f17574b = new ReentrantReadWriteLock();
        c = new WeakHashMap();
    }

    private au() {
    }

    @Override // kotlinx.coroutines.internal.k
    public Function1<Throwable, Throwable> a(Class<? extends Throwable> r8) {
        ReentrantReadWriteLock r0 = f17574b;
        ReentrantReadWriteLock.ReadLock r1 = r0.readLock();
        r1.lock();
        Function1<Throwable, Throwable> r2 = (Function1) ZeusTransformUtils.preCheckCast(c.get(r8), Function1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        r1.unlock();
        if (r2 == null) goto L7;
        return r2;
    L7:
        ReentrantReadWriteLock.ReadLock r3 = r0.readLock();
        int r4 = 0;
        if (r0.getWriteHoldCount() != 0) goto L10;
        int r5 = r0.getReadHoldCount();
    L11:
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L14;
        r3.unlock();
        r6 = r6 + 1;
        goto L12
    L14:
        ReentrantReadWriteLock.WriteLock r7 = r0.writeLock();
        r7.lock();
        WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> r9 = c;     // Catch: Throwable -> L26
        Function1<Throwable, Throwable> r10 = (Function1) ZeusTransformUtils.preCheckCast(r9.get(r8), Function1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r10 == null) goto L21;
    L17:
        if (r4 >= r5) goto L19;
        r3.lock();
        r4 = r4 + 1;
        goto L17
    L19:
        r7.unlock();
        return r10;
    L21:
        Function1<Throwable, Throwable> r11 = n.a(r8);     // Catch: Throwable -> L26
        ((Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin")).put(r8, r11);     // Catch: Throwable -> L26
    L22:
        if (r4 >= r5) goto L24;
        r3.lock();
        r4 = r4 + 1;
        goto L22
    L24:
        r7.unlock();
        return r11;
    L26:
        th = move-exception;
    L27:
        if (r4 >= r5) goto L29;
        r3.lock();
        r4 = r4 + 1;
        goto L27
    L29:
        r7.unlock();
        throw th;
    L10:
        r5 = 0;
    L31:
        th = move-exception;
        r1.unlock();
        throw th;
    }
}
