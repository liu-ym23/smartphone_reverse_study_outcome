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
public final class o implements LevelAbility {
    public static final Map<String, Object> a = null;
    public static final o b = null;

    public o() {
    }

    static {
        b = new o();
        a = new LinkedHashMap();
    }

    public final boolean onLevelChange(int r5) {
        if (r5 >= 0) goto L5;
        BehaviorSubject<d0> r6 = p.a;
        Map<String, Object> r7 = a;
        Intrinsics.checkNotNullParameter(r7, "propertyMap");
        p.a.onNext(new d0(false, r7));
    L6:
        return true;
    L5:
        BehaviorSubject<d0> r8 = p.a;
        Map<String, Object> r9 = a;
        Intrinsics.checkNotNullParameter(r9, "propertyMap");
        p.a.onNext(new d0(true, r9));
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
        ALogger.e("MultiLinkAtomicAbility-KtvPreviewSong", "setProperty error " + r5.getMessage());
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
