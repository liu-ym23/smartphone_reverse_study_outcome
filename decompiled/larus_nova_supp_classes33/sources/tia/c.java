package tia;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public final f a;
    public final Function0<Unit> b;
    public final AtomicBoolean c;
    public r58.c d;
    public PthreadThreadV2 e;
    public volatile long f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        this.c.set(false);
        PthreadThreadV2 r0 = this.e;
        if (r0 == null) goto L26;
        r0.interrupt();
    L26:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        r58.c r2 = this.d;     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        r2.stop();     // Catch: Throwable -> L12
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Result.constructor-impl(r3);     // Catch: Throwable -> L12
    L24:
        r58.c r4 = this.d;     // Catch: Throwable -> L20
        if (r4 == null) goto L17;
        r4.release();     // Catch: Throwable -> L20
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Result.constructor-impl(r5);     // Catch: Throwable -> L20
    L22:
        this.d = null;
        this.f = 0;
        return;
    L17:
        r5 = null;
    L20:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L9:
        r3 = null;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }

    public c(f r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "ringBuffer");
        Intrinsics.checkNotNullParameter(r3, "onFinish");
        this.a = r2;
        this.b = r3;
        this.c = new AtomicBoolean(false);
    }

    public static long b(long r11, int r13) {
        long r0 = System.currentTimeMillis();
        long r2 = ((Keva) r58.b.a.getValue()).getLong("last_backtrace_recorder_release_time_ms", 0);
        long r6 = 4800;
        if (r2 > 0) goto L5;
    L8:
        long r4 = r11 - r6;
        FLogger.a.i("WakeupCaptureProducer", "producer first read producerStartMs=" + r11 + " firstReadMs=" + r0 + " firstReadSize=" + r13 + " cacheMs=" + r6 + " lastReleaseMs=" + r2 + " audioStartMs=" + r4);
        return r4;
    L5:
        if (r2 >= r11) goto L8;
        r6 = RangesKt.coerceAtMost(r11 - r2, 4800);
        goto L8
    }
}
