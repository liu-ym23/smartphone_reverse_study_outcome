package kotlin.concurrent;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a6\u0010\u0006\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\b\u001a6\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"read", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withLock", "Ljava/util/concurrent/locks/Lock;", "(Ljava/util/concurrent/locks/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "write", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class LocksKt {
    private static final <T> T read(ReentrantReadWriteLock r2, Function0<? extends T> r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "action");
        ReentrantReadWriteLock.ReadLock r5 = r2.readLock();
        r5.lock();
        T r6 = (T) r4.invoke();
        InlineMarker.finallyStart(1);
        r5.unlock();
        InlineMarker.finallyEnd(1);
        return r6;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r5.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private static final <T> T withLock(Lock r2, Function0<? extends T> r3) {
        Lock r4 = (Lock) ZeusTransformUtils.wrapperContextForParams(r2, Lock.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "action");
        r4.lock();
        T r6 = (T) r5.invoke();
        InlineMarker.finallyStart(1);
        r4.unlock();
        InlineMarker.finallyEnd(1);
        return r6;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r4.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private static final <T> T write(ReentrantReadWriteLock r4, Function0<? extends T> r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, "action");
        ReentrantReadWriteLock.ReadLock r0 = r4.readLock();
        int r2 = 0;
        if (r4.getWriteHoldCount() != 0) goto L5;
        int r1 = r4.getReadHoldCount();
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r0.unlock();
        r3 = r3 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r7 = r4.writeLock();
        r7.lock();
        T r8 = (T) r6.invoke();
        InlineMarker.finallyStart(1);
    L12:
        if (r2 >= r1) goto L14;
        r0.lock();
        r2 = r2 + 1;
        goto L12
    L14:
        r7.unlock();
        InlineMarker.finallyEnd(1);
        return r8;
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
    L18:
        if (r2 >= r1) goto L20;
        r0.lock();
        r2 = r2 + 1;
        goto L18
    L20:
        r7.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r1 = 0;
        goto L6
    }
}
