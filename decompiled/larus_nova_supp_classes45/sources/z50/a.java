package z50;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements LevelAbility {
    public static boolean a;
    public static int b;
    public static final a c = null;

    public a() {
    }

    static {
        c = new a();
        b = 3;
    }

    public final boolean onLevelChange(int r2) {
        if (r2 >= 0) goto L5;
        a = true;
    L6:
        return true;
    L5:
        a = false;
        goto L6
    }

    public final void onPropertyChange(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "property");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        Object r4 = r3.get("trace_atomic_ability_cache_time");     // Catch: Throwable -> L21
        Object r1 = null;
        if (r4 != null) goto L6;
    L8:
        r4 = null;
    L10:
        if ((r4 instanceof String) == false) goto L13;
        r1 = r4;
    L13:
        String r2 = (String) r1;     // Catch: Throwable -> L21
        if (r2 == null) goto L18;
        Integer r5 = StringsKt.toIntOrNull(r2);     // Catch: Throwable -> L21
        if (r5 == null) goto L18;
        int r6 = r5.intValue();     // Catch: Throwable -> L21
    L19:
        b = r6;     // Catch: Throwable -> L21
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L29;
        ALogger.e("LiveTraceScheduleAtomicAbility", "setProperty error " + r8.getMessage());
        return;
    L29:
        return;
    L18:
        r6 = 3;
        goto L19
    L6:
        if ((r4 instanceof String) == false) goto L8;
    L21:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
