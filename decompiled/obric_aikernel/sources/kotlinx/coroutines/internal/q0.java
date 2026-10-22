package kotlinx.coroutines.internal;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/WeakMapCtorCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
final class q0 extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0 f10581a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ReentrantReadWriteLock f10582b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> f10583c = null;

    static {
        f10581a = new q0();
        f10582b = new ReentrantReadWriteLock();
        f10583c = new WeakHashMap();
    }

    private q0() {
    }

    @Override // kotlinx.coroutines.internal.k
    public Function1<Throwable, Throwable> a(Class<? extends Throwable> r10) {
        ReentrantReadWriteLock r11 = f10582b;
        ReentrantReadWriteLock.ReadLock r12 = r11.readLock();
        r12.lock();
        Function1<Throwable, Throwable> r13 = f10583c.get(r10);     // Catch: Throwable -> L31
        r12.unlock();
        if (r13 == null) goto L7;
        return r13;
    L7:
        ReentrantReadWriteLock.ReadLock r14 = r11.readLock();
        int r15 = 0;
        if (r11.getWriteHoldCount() != 0) goto L10;
        int r16 = r11.getReadHoldCount();
    L11:
        int r17 = 0;
    L12:
        if (r17 >= r16) goto L14;
        r14.unlock();
        r17 = r17 + 1;
        goto L12
    L14:
        ReentrantReadWriteLock.WriteLock r18 = r11.writeLock();
        r18.lock();
        WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> r19 = f10583c;     // Catch: Throwable -> L26
        Function1<Throwable, Throwable> r20 = r19.get(r10);     // Catch: Throwable -> L26
        if (r20 == null) goto L21;
    L17:
        if (r15 >= r16) goto L19;
        r14.lock();
        r15 = r15 + 1;
        goto L17
    L19:
        r18.unlock();
        return r20;
    L21:
        Function1<Throwable, Throwable> r21 = ExceptionsConstructorKt.a(r10);     // Catch: Throwable -> L26
        r19.put(r10, r21);     // Catch: Throwable -> L26
    L22:
        if (r15 >= r16) goto L24;
        r14.lock();
        r15 = r15 + 1;
        goto L22
    L24:
        r18.unlock();
        return r21;
    L26:
        th = move-exception;
    L27:
        if (r15 >= r16) goto L29;
        r14.lock();
        r15 = r15 + 1;
        goto L27
    L29:
        r18.unlock();
        throw th;
    L10:
        r16 = 0;
    L31:
        th = move-exception;
        r12.unlock();
        throw th;
    }
}
