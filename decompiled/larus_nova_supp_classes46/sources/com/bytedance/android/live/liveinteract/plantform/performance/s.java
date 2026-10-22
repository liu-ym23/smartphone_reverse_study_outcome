package com.bytedance.android.live.liveinteract.plantform.performance;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import io.reactivex.subjects.BehaviorSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s implements LevelAbility {
    public static final Map<String, Object> a = null;
    public static final s b = null;

    public s() {
    }

    static {
        b = new s();
        a = new LinkedHashMap();
    }

    public final boolean onLevelChange(int r5) {
        if (r5 >= 0) goto L5;
        BehaviorSubject<d0> r6 = t.a;
        Map<String, Object> r7 = a;
        Intrinsics.checkNotNullParameter(r7, "propertyMap");
        t.a.onNext(new d0(false, r7));
    L6:
        return true;
    L5:
        BehaviorSubject<d0> r8 = t.a;
        Map<String, Object> r9 = a;
        Intrinsics.checkNotNullParameter(r9, "propertyMap");
        t.a.onNext(new d0(true, r9));
        goto L6
    }

    public final void onPropertyChange(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "property");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        Map<String, Object> r1 = a;     // Catch: Throwable -> L18
        ((LinkedHashMap) r1).clear();     // Catch: Throwable -> L18
        r1.putAll(r3);     // Catch: Throwable -> L18
        Object r4 = r3.get("extra");     // Catch: Throwable -> L18
        Unit r2 = null;
        if ((r4 instanceof Map) == true) goto L6;
        r4 = null;
    L6:
        Map r5 = (Map) r4;     // Catch: Throwable -> L18
        if (r5 == null) goto L9;
        Object r6 = r5.get("duration");     // Catch: Throwable -> L18
    L11:
        if ((r6 instanceof Integer) == true) goto L13;
        r6 = null;
    L13:
        Integer r7 = (Integer) r6;     // Catch: Throwable -> L18
        if (r7 == null) goto L16;
        r7.intValue();     // Catch: Throwable -> L18
        BehaviorSubject<d0> r8 = t.a;     // Catch: Throwable -> L18
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Object r9 = Result.constructor-impl(r2);     // Catch: Throwable -> L18
    L20:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L26;
        ALogger.e("MultiLinkAtomicAbility-SeiConsume", "setProperty error " + r10.getMessage());
        return;
    L26:
        return;
    L9:
        r6 = null;
    L18:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
