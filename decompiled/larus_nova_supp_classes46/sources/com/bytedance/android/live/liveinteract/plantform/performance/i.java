package com.bytedance.android.live.liveinteract.plantform.performance;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements LevelAbility {
    public static final Map<String, Object> a = null;
    public static final i b = null;

    public i() {
    }

    static {
        b = new i();
        a = new LinkedHashMap();
    }

    public final boolean onLevelChange(int r5) {
        if (r5 >= 0) goto L5;
        boolean r6 = j.a;
        Map<String, Object> r7 = a;
        Intrinsics.checkNotNullParameter(r7, "propertyMap");
        j.a = false;
        j.b.onNext(new d0(false, r7));
    L6:
        return true;
    L5:
        boolean r8 = j.a;
        Map<String, Object> r9 = a;
        Intrinsics.checkNotNullParameter(r9, "propertyMap");
        j.a = true;
        j.b.onNext(new d0(true, r9));
        goto L6
    }

    public final void onPropertyChange(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "property");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Map<String, Object> r1 = a;     // Catch: Throwable -> L5
        ((LinkedHashMap) r1).clear();     // Catch: Throwable -> L5
        r1.putAll(r3);     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L13;
        ALogger.e("MultiLinkAtomicAbility-DynamicBg", "setProperty error " + r5.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
