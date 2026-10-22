package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.livesdk.utils.condition.base.Condition;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements com.bytedance.android.livesdk.utils.condition.base.d {
    public final /* synthetic */ long a;
    public final /* synthetic */ ConditionConstant.ConditionType b;

    public final long a(com.bytedance.android.livesdk.utils.condition.base.b r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        return r4 + 1;
    }

    public final void reset() {
    }

    public final void d() {
        xs2.b.a().post(new com.bytedance.android.livesdk.utils.condition.base.b(this.b));
    }

    public d(ConditionConstant.ConditionType r3) {
        this.a = 5;
        this.b = r3;
    }

    public final boolean b(HashMap<ConditionConstant.ConditionType, Condition> r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "childConditions");
        if (r4 <= this.a) goto L5;
        return true;
    L5:
        return false;
    }

    public final long c(com.bytedance.android.livesdk.utils.condition.base.b r1, long r2, HashMap<ConditionConstant.ConditionType, Condition> r4) {
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r4, "childConditions");
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r4, "childConditions");
        return 0;
    }
}
