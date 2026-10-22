package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.utils.condition.base.Condition;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ClearGuideManager {
    public static com.bytedance.android.livesdk.utils.condition.base.e a;
    public static final Lazy b = null;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;

    public static ArrayList c() {
        return (ArrayList) b.getValue();
    }

    static {
        b = LazyKt.lazy(ClearGuideManager$showClearEntranceGuideTriggers$2.INSTANCE);
        if (ClearScreenHelper.d(null) == false) goto L5;
        String r0 = "live.pref.PREF_CLEARSCREEN_ENTRANCE_GUIDE_V2";
    L6:
        c = r0;
        d = "live.pref.PREF_CLEARSCREEN_PERFORMANCE_POWER_GUIDE";
        e = "live.pref.PREF_CLEARSCREEN_PERFORMANCE_STALL_GUIDE";
        f = "live.pref.PREF_CLEARSCREEN_PERFORMANCE_TIMESTAMP";
        return;
    L5:
        r0 = "live.pref.PREF_CLEARSCREEN_ENTRANCE_GUIDE";
        goto L6
    }

    public static void a() {
        Iterator r0 = c().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        com.bytedance.android.livesdk.utils.condition.base.c r1 = (com.bytedance.android.livesdk.utils.condition.base.c) r0.next();
        if (r1 == null) goto L4;
        Iterator r2 = ((HashMap) r1.a.getValue()).values().iterator();
    L9:
        if (r2.hasNext() == false) goto L4;
        ((Condition) r2.next()).b();
        goto L9
    }

    public static Condition b(com.bytedance.android.livesdk.utils.condition.base.e r2, ConditionConstant.ConditionType r3, ConditionConstant.ConditionType r4) {
        return new Condition(r3, r2, new d(r4));
    }
}
