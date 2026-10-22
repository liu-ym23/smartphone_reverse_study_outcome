package com.bytedance.android.live.liveinteract.hamlet;

import io.reactivex.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T1, T2, T3, R> implements Function3 {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    public final Object apply(Object r2, Object r3, Object r4) {
        Boolean r5 = (Boolean) r2;
        Boolean r6 = (Boolean) r3;
        Boolean r7 = (Boolean) r4;
        Intrinsics.checkNotNullParameter(r5, "isStreamRending");
        Intrinsics.checkNotNullParameter(r6, "isRtcClientInitialized");
        Intrinsics.checkNotNullParameter(r7, "isSelfCPosition");
        if (r5.booleanValue() == true) goto L5;
    L9:
        boolean r8 = false;
    L11:
        return Boolean.valueOf(r8);
    L5:
        if (r6.booleanValue() == false) goto L9;
        if (r7.booleanValue() == false) goto L9;
        r8 = true;
        goto L11
    }
}
