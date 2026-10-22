package kotlin.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "LocksKt")
@SourceDebugExtension({"SMAP\nLocks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Locks.kt\nkotlin/concurrent/LocksKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n1#2:75\n*E\n"})
public final class LocksKt {
    @InlineOnly
    private static final <T> T read(ReentrantReadWriteLock r10, Function0<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        ReentrantReadWriteLock.ReadLock r12 = r10.readLock();
        r12.lock();
        T r13 = r11.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r12.unlock();
        InlineMarker.finallyEnd(1);
        return r13;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r12.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @InlineOnly
    private static final <T> T withLock(Lock r10, Function0<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        r10.lock();
        T r12 = r11.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.unlock();
        InlineMarker.finallyEnd(1);
        return r12;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @InlineOnly
    private static final <T> T write(ReentrantReadWriteLock r10, Function0<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        ReentrantReadWriteLock.ReadLock r12 = r10.readLock();
        int r13 = 0;
        if (r10.getWriteHoldCount() != 0) goto L5;
        int r14 = r10.getReadHoldCount();
    L6:
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L9;
        r12.unlock();
        r15 = r15 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r16 = r10.writeLock();
        r16.lock();
        T r17 = r11.invoke();     // Catch: Throwable -> L16
        InlineMarker.finallyStart(1);
    L12:
        if (r13 >= r14) goto L14;
        r12.lock();
        r13 = r13 + 1;
        goto L12
    L14:
        r16.unlock();
        InlineMarker.finallyEnd(1);
        return r17;
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
    L18:
        if (r13 >= r14) goto L20;
        r12.lock();
        r13 = r13 + 1;
        goto L18
    L20:
        r16.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r14 = 0;
        goto L6
    }
}
