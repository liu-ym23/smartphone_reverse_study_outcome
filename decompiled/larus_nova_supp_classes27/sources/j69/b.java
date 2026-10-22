package j69;

import android.os.SystemClock;
import g49.d;
import java.util.ListIterator;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final ArrayDeque<Pair<String, Long>> a = null;
    public static final ReentrantLock b = null;

    static {
        a = new ArrayDeque();
        b = new ReentrantLock();
    }

    public static long a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "stage");
        ReentrantLock r0 = b;
        r0.lock();
        long r1 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L18
        ArrayDeque<Pair<String, Long>> r3 = a;     // Catch: Throwable -> L18
        ListIterator r4 = r3.listIterator(r3.size());     // Catch: Throwable -> L18
    L5:
        if (r4.hasPrevious() == false) goto L10;
        if (Intrinsics.areEqual(((Pair) r4.previous()).getFirst(), r9) == false) goto L5;
        int r5 = r4.nextIndex();     // Catch: Throwable -> L18
    L12:
        if (r5 == (-1)) goto L14;
        long r2 = r1 - ((Number) ((Pair) a.remove(r5)).component2()).longValue();     // Catch: Throwable -> L18
        d.d("DoraOTATrackerTimer", "popStage: stage=" + r9 + ", duration=" + r2);     // Catch: Throwable -> L18
    L16:
        r0.unlock();
        return r2;
    L14:
        d.b("DoraOTATrackerTimer", "popStage: stage=" + r9 + ", not found in stack");     // Catch: Throwable -> L18
        r2 = 0;
        goto L16
    L10:
        r5 = -1;
    L18:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public static void b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "stage");
        ReentrantLock r1 = b;
        r1.lock();
        long r2 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
        a.addLast(TuplesKt.to(r6, Long.valueOf(r2)));     // Catch: Throwable -> L6
        d.d("DoraOTATrackerTimer", "pushStage: stage=" + r6 + ", now=" + r2);     // Catch: Throwable -> L6
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r1.unlock();
        return;
    L6:
        th = move-exception;
        r1.unlock();
        throw th;
    }
}
