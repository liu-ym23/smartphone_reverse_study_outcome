package l8;

import com.bytedance.android.annie.monitor.common.timing.PerformanceTiming;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final ConcurrentHashMap<String, PerformanceTiming> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static PerformanceTiming a(String r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        PerformanceTiming r1 = a.get(r10);     // Catch: Throwable -> L7
        if (r1 == null) goto L5;
        return r1;
    L5:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        PerformanceTiming r11 = new PerformanceTiming();
        a.put(r10, r11);
        return r11;
    L7:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public static void b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "uuid");
        Intrinsics.checkNotNullParameter(r11, "stageName");
        long r12 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r10, "uuid");
        Intrinsics.checkNotNullParameter(r11, "stageName");
        Long r0 = Long.valueOf(r12);
        a(r10).put(r11, r0);
    }

    public static void c(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "uuid");
        Intrinsics.checkNotNullParameter(r11, "bizKey");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        PerformanceTiming r12 = a.get(r10);     // Catch: Throwable -> L8
        if (r12 != null) goto L6;
        return;
    L6:
        Schedulers.computation().scheduleDirect(new a(r12, r11));     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
