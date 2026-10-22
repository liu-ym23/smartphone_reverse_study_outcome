package okhttp3.internal.concurrent;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.time.DurationKt;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a5\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a*\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"formatDuration", "", "ns", "", "log", "", "task", "Lokhttp3/internal/concurrent/Task;", "queue", "Lokhttp3/internal/concurrent/TaskQueue;", "message", "logElapsed", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "taskLog", "messageBlock", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class TaskLoggerKt {
    public static final /* synthetic */ void access$log(Task r5, TaskQueue r10, String r11) {
        log(r5, r10, r11);
    }

    public static final String formatDuration(long r12) {
        if (r12 > (-999500000)) goto L6;
        String r13 = j0.o(new StringBuilder(), (r12 - ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS), " s ");
    L18:
        StringCompanionObject r14 = StringCompanionObject.INSTANCE;
        return String.format("%6s", Arrays.copyOf(new Object[]{r13}, 1));
    L6:
        if (r12 > (-999500)) goto L9;
        r13 = j0.o(new StringBuilder(), (r12 - ((long) 500000)) / ((long) DurationKt.NANOS_IN_MILLIS), " ms");
        goto L18
    L9:
        if (r12 > 0) goto L12;
        r13 = j0.o(new StringBuilder(), (r12 - ((long) 500)) / ((long) 1000), " µs");
        goto L18
    L12:
        if (r12 >= 999500) goto L15;
        r13 = j0.o(new StringBuilder(), (r12 + ((long) 500)) / ((long) 1000), " µs");
        goto L18
    L15:
        if (r12 >= 999500000) goto L17;
        r13 = j0.o(new StringBuilder(), (r12 + ((long) 500000)) / ((long) DurationKt.NANOS_IN_MILLIS), " ms");
        goto L18
    L17:
        r13 = j0.o(new StringBuilder(), (r12 + ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS), " s ");
        goto L18
    }

    private static final void log(Task r5, TaskQueue r10, String r11) {
        Logger r12 = TaskRunner.Companion.getLogger();
        StringBuilder r13 = new StringBuilder();
        r13.append(r10.getName$okhttp());
        r13.append(' ');
        StringCompanionObject r14 = StringCompanionObject.INSTANCE;
        r13.append(String.format("%-22s", Arrays.copyOf(new Object[]{r11}, 1)));
        r13.append(": ");
        r13.append(r5.getName());
        r12.fine(r13.toString());
    }

    public static final <T> T logElapsed(Task r10, TaskQueue r11, Function0<? extends T> r12) {
        Intrinsics.checkNotNullParameter(r10, "task");
        Intrinsics.checkNotNullParameter(r11, "queue");
        Intrinsics.checkNotNullParameter(r12, "block");
        boolean r5 = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (r5 == false) goto L5;
        long r13 = r11.getTaskRunner$okhttp().getBackend().nanoTime();
        access$log(r10, r11, "starting");
    L19:
        T r14 = r12.invoke();     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        if (r5 == false) goto L11;
        access$log(r10, r11, "finished run in " + formatDuration(r11.getTaskRunner$okhttp().getBackend().nanoTime() - r13));
    L11:
        InlineMarker.finallyEnd(1);
        return r14;
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (r5 == false) goto L17;
        access$log(r10, r11, "failed a run in " + formatDuration(r11.getTaskRunner$okhttp().getBackend().nanoTime() - r13));
    L17:
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r13 = -1;
        goto L19
    }

    public static final void taskLog(Task r5, TaskQueue r10, Function0<String> r11) {
        Intrinsics.checkNotNullParameter(r5, "task");
        Intrinsics.checkNotNullParameter(r10, "queue");
        Intrinsics.checkNotNullParameter(r11, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L6;
        access$log(r5, r10, r11.invoke());
        return;
    }
}
