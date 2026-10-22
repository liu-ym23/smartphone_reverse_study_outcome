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
public final class g implements LevelAbility {
    public static final Map<String, Object> a = null;
    public static final g b = null;

    public g() {
    }

    static {
        b = new g();
        a = new LinkedHashMap();
    }

    public final boolean onLevelChange(int r5) {
        ALogger.i("MultiLinkAtomicAbility-Base", "onLevelChange " + r5);
        if (r5 >= 0) goto L5;
        BehaviorSubject<d0> r6 = h.a;
        Map<String, Object> r7 = a;
        Intrinsics.checkNotNullParameter(r7, "propertyMap");
        h.a.onNext(new d0(false, r7));
    L6:
        return true;
    L5:
        BehaviorSubject<d0> r8 = h.a;
        Map<String, Object> r9 = a;
        Intrinsics.checkNotNullParameter(r9, "propertyMap");
        h.a.onNext(new d0(true, r9));
        goto L6
    }

    public final void onPropertyChange(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "property");
        ALogger.i("MultiLinkAtomicAbility-Base", "onPropertyChange " + r4);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Map<String, Object> r1 = a;     // Catch: Throwable -> L5
        ((LinkedHashMap) r1).clear();     // Catch: Throwable -> L5
        r1.putAll(r4);     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L13;
        ALogger.e("MultiLinkAtomicAbility-Base", "setProperty error " + r6.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
