package com.ss.android.lark.passportc.impl.v2.action;

import com.ss.android.lark.passportc.entity.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final /* synthetic */ class b {
    public static void a(UserState r2, UserState r3, UserState r4) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "to");
        Intrinsics.checkNotNullParameter(r4, "expect");
        if (r2 == r3) goto L7;
        if (r3 != r4) goto L7;
        return;
    L7:
        throw new IllegalStateException("action state error, state: " + r2 + " -> " + r3);
    }
}
