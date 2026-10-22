package kotlin.concurrent;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a6\u0010\u0006\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\b\u001a6\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"read", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withLock", "Ljava/util/concurrent/locks/Lock;", "(Ljava/util/concurrent/locks/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "write", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "LocksKt")
@SourceDebugExtension({"SMAP\nLocks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Locks.kt\nkotlin/concurrent/LocksKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n1#2:75\n*E\n"})
public final class LocksKt {
    @InlineOnly
    private static final <T> T read(ReentrantReadWriteLock r5, Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "action");
        ReentrantReadWriteLock.ReadLock r11 = r5.readLock();
        r11.lock();
        T r12 = r10.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r11.unlock();
        InlineMarker.finallyEnd(1);
        return r12;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r11.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @InlineOnly
    private static final <T> T withLock(Lock r5, Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "action");
        r5.lock();
        T r11 = r10.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r5.unlock();
        InlineMarker.finallyEnd(1);
        return r11;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r5.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @InlineOnly
    private static final <T> T write(ReentrantReadWriteLock r5, Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "action");
        ReentrantReadWriteLock.ReadLock r11 = r5.readLock();
        int r12 = 0;
        if (r5.getWriteHoldCount() != 0) goto L5;
        int r13 = r5.getReadHoldCount();
    L6:
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r11.unlock();
        r14 = r14 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r15 = r5.writeLock();
        r15.lock();
        T r16 = r10.invoke();     // Catch: Throwable -> L16
        InlineMarker.finallyStart(1);
    L12:
        if (r12 >= r13) goto L14;
        r11.lock();
        r12 = r12 + 1;
        goto L12
    L14:
        r15.unlock();
        InlineMarker.finallyEnd(1);
        return r16;
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
    L18:
        if (r12 >= r13) goto L20;
        r11.lock();
        r12 = r12 + 1;
        goto L18
    L20:
        r15.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r13 = 0;
        goto L6
    }
}
