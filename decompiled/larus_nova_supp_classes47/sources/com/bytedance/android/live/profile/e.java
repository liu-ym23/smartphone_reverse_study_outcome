package com.bytedance.android.live.profile;

import com.bytedance.android.live.profile.model.EnterExitStateType;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Predicate {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final boolean test(Object r2) {
        com.bytedance.android.live.profile.model.a r3 = (com.bytedance.android.live.profile.model.a) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r3.a != EnterExitStateType.ENTER_END) goto L5;
        return true;
    L5:
        return false;
    }
}
