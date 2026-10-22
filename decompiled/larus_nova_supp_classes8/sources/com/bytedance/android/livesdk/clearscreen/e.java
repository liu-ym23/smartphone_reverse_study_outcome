package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.livesdk.utils.condition.base.Condition;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements com.bytedance.android.livesdk.utils.condition.base.d {
    public e() {
    }

    public final boolean b(HashMap<ConditionConstant.ConditionType, Condition> r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "childConditions");
        if (r4 <= 5) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d() {
    }

    public final void reset() {
    }

    public final long a(com.bytedance.android.livesdk.utils.condition.base.b r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r1, "event");
        return 0;
    }

    public final long c(com.bytedance.android.livesdk.utils.condition.base.b r3, long r4, HashMap<ConditionConstant.ConditionType, Condition> r6) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r6, "childConditions");
        Iterator<Condition> r5 = r6.values().iterator();
        long r7 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r7 = r7 + r5.next().b;
        goto L4
    L6:
        return r7;
    }
}
