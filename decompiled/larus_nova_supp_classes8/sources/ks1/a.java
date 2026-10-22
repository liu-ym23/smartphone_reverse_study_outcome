package ks1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.y51;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements LevelAbility {
    public static boolean a;
    public static final a b = null;

    public a() {
    }

    static {
        b = new a();
        a = true;
    }

    public final boolean onLevelChange(int r2) {
        if (r2 >= 0) goto L6;
        boolean r3 = y51.a;
        y51.a = true;
    L8:
        return true;
    L6:
        if (a == false) goto L8;
        boolean r4 = y51.a;
        y51.a = false;
        goto L8
    }

    public final void onPropertyChange(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "property");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        Object r4 = r3.get("support_auto_recover");     // Catch: Throwable -> L16
        Object r1 = null;
        if ((r4 instanceof String) == true) goto L8;
        r4 = null;
    L8:
        if ((r4 instanceof String) == false) goto L11;
        r1 = r4;
    L11:
        String r2 = (String) r1;     // Catch: Throwable -> L16
        if (r2 == null) goto L14;
        a = Intrinsics.areEqual(r2, "1");     // Catch: Throwable -> L16
    L14:
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L24;
        ALogger.e("LiveMoveSamplingScheduleAtomicAbility", "setProperty error " + r6.getMessage());
        return;
    L24:
        return;
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
